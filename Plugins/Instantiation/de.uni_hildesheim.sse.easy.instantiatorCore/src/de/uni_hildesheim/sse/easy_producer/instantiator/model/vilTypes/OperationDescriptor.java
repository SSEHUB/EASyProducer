package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;

/**
 * Represents an individual operation available to the VIL languages. Please
 * note that named arguments are passed in terms of a map as the last parameter
 * of the respective method. If the underlying Java method takes such a parameter, 
 * the descriptor will count one parameter less!
 * 
 * @author Holger Eichelberger
 */
public class OperationDescriptor implements IMetaOperation {

    /**
     * Declares different types of alias.
     * 
     * @author Holger Eichelberger
     */
    public enum AliasType {
        
        /**
         * No alias.
         */
        NONE,
        
        /**
         * Annotation-based alias.
         */
        EXPLICIT, 
        
        /**
         * Implicit name-based alias (duplication).
         */
        IMPLICIT
    }

    /**
     * The name of constructor methods (static, same return type as declaring class, this name).
     * We do not rely on constructors, as constructor methods simplify reflection analysis.
     */
    public static final String CONSTRUCTOR_NAME = "create";
    
    /**
     * Stores implicit type equalities handled by boxing/unboxing in Java reflection.
     */
    private static final Map<Class<?>, Class<?>> REFLECTION_EQUALITIES = new HashMap<Class<?>, Class<?>>();

    /**
     * Stores lazy default values (primitives are sufficient).
     */
    private static final Map<Class<?>, Object> LAZY_DEFAULTS = new HashMap<Class<?>, Object>();

    private String name; // only used if alias
    private Method method;
    private boolean isConstructor = false;
    private OperationType opType = OperationType.NORMAL;
    private TypeDescriptor<? extends IVilType> declaringType;
    private TypeDescriptor<? extends IVilType> returnType; // lazy
    private AliasType aliasType = AliasType.NONE;
    private List<TypeDescriptor<? extends IVilType>> parameter; // lazy
    private boolean acceptsNamedParameters = false; // lazy
    private boolean isConversion;
    
    /**
     * Creates a new operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param method the reflection method to be called
     */
    OperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, Method method) {
        this(declaringType, method, null);
    }

    /**
     * Creates a new operation descriptor as an alias.
     * 
     * @param declaringType the declaring type
     * @param method the reflection method to be called
     * @param name the alias name (may be <b>null</b> if the original name of <code>method</code> shall be used)
     */
    OperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, Method method, String name) {
        this.declaringType = declaringType;
        this.method = method;
        isConstructor = isConstructor(method);
        if (null != name && !name.equals(method.getName()) && name.length() > 0) {
            this.name = name; // ensure proper use
            aliasType = AliasType.IMPLICIT;
        }
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            opType = meta.opType();
            if (null != meta.name() && meta.name().length > 0) {
                aliasType = AliasType.EXPLICIT;
            }
        }
        isConversion = null != method.getAnnotation(Conversion.class);
    }
    
    /**
     * Initializes the parameter and the return type if necessary (lazy, due to 
     * linked descriptor structures which may not have been completely initialized
     * during the constructor execution).
     */
    private synchronized void initialize() {
        if (null == parameter) {
            parameter = new ArrayList<TypeDescriptor<? extends IVilType>>();
            if (!Modifier.isStatic(method.getModifiers()) && null != declaringType) {
                parameter.add(declaringType);
            }
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                if (i == params.length - 1 && Map.class.isAssignableFrom(params[i])) {
                    acceptsNamedParameters = true;
                } else {
                    parameter.add(resolveType(params[i]));
                }
            }
        }
        if (null == returnType) {
            returnType = resolveType(method.getReturnType());
        }
    }

    /**
     * Adds a new bi-directional reflection equality.
     * 
     * @param cls1 a class to be considered equivalent / assignment compatible to <code>cls2</code>
     * @param cls2 a class to be considered equivalent / assignment compatible to <code>cls1</code>
     */
    private static final void addReflectionEquality(Class<?> cls1, Class<?> cls2) {
        REFLECTION_EQUALITIES.put(cls1, cls2);
        REFLECTION_EQUALITIES.put(cls2, cls1);
    }
    
    static {
        addReflectionEquality(Integer.TYPE, Integer.class);
        addReflectionEquality(Long.TYPE, Long.class);
        addReflectionEquality(Float.TYPE, Float.class);
        addReflectionEquality(Double.TYPE, Double.class);
        addReflectionEquality(Boolean.TYPE, Boolean.class);
        addReflectionEquality(Character.TYPE, Character.class);
        addReflectionEquality(Byte.TYPE, Byte.class);
        addReflectionEquality(Short.TYPE, Short.class);

        LAZY_DEFAULTS.put(Integer.TYPE, 0);
        LAZY_DEFAULTS.put(Long.TYPE, 0L);
        LAZY_DEFAULTS.put(Float.TYPE, 0.0F);
        LAZY_DEFAULTS.put(Double.TYPE, 0.0D);
        LAZY_DEFAULTS.put(Boolean.TYPE, false);
        LAZY_DEFAULTS.put(Character.TYPE, 0);
        LAZY_DEFAULTS.put(Byte.TYPE, 0);
        LAZY_DEFAULTS.put(Short.TYPE, 0);
    }
    
    /**
     * Resolves the given type to a type descriptor.
     *  
     * @param cls the class to be resolved
     * @return the resolved type descriptor
     */
    private TypeDescriptor<? extends IVilType> resolveType(Class<?> cls) {
        TypeDescriptor<? extends IVilType> result = null;
        if (Void.TYPE == cls) {
            result = TypeDescriptor.VOID;
        } else {
            OperationMeta opMeta = method.getAnnotation(OperationMeta.class);
            TypeDescriptor<?>[] parameter;
            if (null != opMeta) {
                Class<?>[] param = opMeta.returnGenerics();
                parameter = TypeDescriptor.createArray(param.length);
                for (int i = 0; i < param.length; i++) {
                    parameter[i] = TypeRegistry.getType(TypeDescriptor.getRegName(param[i]));
                }
            } else {
                parameter = null;
            }
            try {
                if (TypeDescriptor.isSet(cls)) {
                    result = TypeRegistry.getSetType(parameter);
                } else if (TypeDescriptor.isSequence(cls)) {
                    result = TypeRegistry.getSequenceType(parameter);
                }
            } catch (VilException e) {
                // no type -> handled later
            }
            if (null == result) {
                result = TypeRegistry.getType(cls.getName());
                if (null == result) {
                    result = TypeRegistry.getType(cls.getSimpleName()); // artifacts
                }
            }
            if (null == result) {
                if (Object.class == cls) {
                    result = TypeDescriptor.ANY;
                } else {
                    result = TypeDescriptor.VOID;
                }
            }
        }
        return result;
    }
    
    /**
     * Returns whether the operation accepts named parameters.
     * 
     * @return <code>true</code> if it accepts named parameters, <code>false</code> else
     */
    public boolean acceptsNamedParameters() {
        return acceptsNamedParameters;
    }

    /**
     * Returns the name of the method.
     * 
     * @return the name of the method
     */
    public String getName() {
        return null != name ? name : method.getName();
    }
    
    /**
     * Returns the operation / operator type.
     * 
     * @return the operation / operator type
     */
    public OperationType getOperationType() {
        return opType;
    }

    /**
     * Returns the name of the declaring type. This method works even if 
     * {@link #getDeclaringType()} is null due to a mapped external Java operation.
     * 
     * @return the name of the declaring type
     */
    public String getDeclaringTypeName() {
        String result;
        if (null != declaringType) {
            result = declaringType.getName();
        } else {
            result = method.getDeclaringClass().getSimpleName();
        }
        return result;
    }
    
    /**
     * Returns the signature of the method.
     * 
     * @return the signature of the method
     */
    public String getSignature() {
        StringBuilder tmp = new StringBuilder();
        if (isConstructor) {
            tmp.append("new ");
            tmp.append(getDeclaringTypeName());
            tmp.append(" ");
        } else {
            tmp.append(getName());
        }
        tmp.append("(");
        Class<?>[] param = method.getParameterTypes();
        if (null != param) {
            for (int p = 0; p < param.length; p++) {
                tmp.append(param[p].getSimpleName());
                if (p < param.length - 1) {
                    tmp.append(",");
                }
            }
        }
        tmp.append(")");
        return tmp.toString();
    }
    
    /**
     * Returns whether this operation is static.
     * 
     * @return <code>true</code> if it is static, <code>false</code> else
     */
    public boolean isStatic() {
        return Modifier.isStatic(method.getModifiers());
    }

    /**
     * Returns the Java signature of the method (public for testing).
     * 
     * @return the Java signature of the method
     * @see #getJavaSignature(Method)
     */
    public String getJavaSignature() {
        return getJavaSignature(method, name, acceptsNamedParameters);
    }
    
    /**
     * Returns whether this operation represents a constructor. Basically, for VIL a 
     * constructor is a public static method named "create" which returns an instance
     * of the underlying type. Declared constructors are used for internal purposes.
     * 
     * @return <code>true</code> if this operation is a "constructor", <code>false</code> else
     */
    public boolean isConstructor() {
        return isConstructor;
    }
    
    /**
     * Returns the declaring type.
     * 
     * @return the declaring type (may be <b>null</b> in case of a wrapped external Java method)
     */
    public TypeDescriptor<? extends IVilType> getDeclaringType() {
        return declaringType;
    }
    
    /**
     * Returns the alias type.
     * 
     * @return the alias type
     */
    public AliasType isAlias() {
        return aliasType;
    }
    
    /**
     * Returns the result of a type compatibility comparison.
     * 
     * @author Holger Eichelberger
     */
    public enum CompatibilityResult {
        
        /**
         * Types are compatible.
         */
        COMPATIBLE,
        
        /**
         * Types are incompatible.
         */
        INCOMPATIBLE,

        /**
         * Types are incompatible but due to lazy arguments (<b>null</b>), lazy execution is possible.
         */
        LAZY_POSSIBLE
    }
    
    /**
     * Returns whether the operation represented by this instance is compatible to
     * the given return type and parameters. This method does not consider possible
     * unnamed parameter rather than the underlying Java parameter.
     * 
     * @param retType the return type (may be <b>null</b> in order to ignore this parameter)
     * @param params the parameters (may be <b>null</b> if there are none, may be classes)
     * @return an instance of {@link CompatibilityResult} denoting the actual compatibility level
     */
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        Class<?>[] par = method.getParameterTypes();
        boolean lazyPossible = true;
        boolean compatible = (null == params ? 0 : params.length) == par.length;
        if (null != retType) {
            compatible &= method.getReturnType().isAssignableFrom(retType);
        }
        for (int p = 0; p < par.length; p++) { // no early end!
            Class<?> cls;
            if (null != params[p]) {
                if (params[p] instanceof Class) {
                    cls = (Class<?>) params[p];
                } else {
                    cls = params[p].getClass();
                }
            } else {
                cls = Void.TYPE;
            }
            boolean parCompatible = par[p].isAssignableFrom(cls) // instances match?
                || REFLECTION_EQUALITIES.get(par[p]) == cls // basic types match?
                || (par[p] == Class.class && params[p] instanceof Class); // parameter is class
            if (!parCompatible) {
                lazyPossible &= params[p] == null;
            }
            compatible &= parCompatible;
        }
        CompatibilityResult result;
        if (compatible) {
            result = CompatibilityResult.COMPATIBLE;
        } else {
            if (lazyPossible) {
                result = CompatibilityResult.LAZY_POSSIBLE;
            } else {
                result = CompatibilityResult.INCOMPATIBLE;
            }
        }
        return result;
    }
    
    // disable assignment Integer
    // reflection translation table
    
    /**
     * Invokes the specified operation. This method does not consider possible
     * unnamed parameter rather than the underlying Java parameter. In case of {@link #acceptsNamedParameters()}
     * the caller must ensure that the last parameter is a <code>map&lt;String, Object&gt;</code> containing
     * the named parameters.
     * 
     * @param args the arguments, in case of non-static operations the first argument 
     *   must be the object to execute on
     * @return the result of the execution
     * @throws VilException if the invocation fails
     * 
     * @see #isCompatible
     */
    public Object invoke(Object... args) throws VilException {
        Object[] callArgs;
        Object object;
        boolean exec = true;
        if (isStatic()) {
            object = null;
            callArgs = args;
        } else {
            if (0 == args.length) {
                throw new VilException("object missing (first implicit parameter)", VilException.ID_EXECUTION_ERROR);
            }
            object = args[0];
            callArgs = new Object[args.length - 1];
            System.arraycopy(args, 1, callArgs, 0, callArgs.length);
            exec = null != object; // lazy execution
        }
        Object result = null;
        if (!exec) {
            result = null; // lazy execution
        } else {
            CompatibilityResult comp = isCompatible(null, callArgs);
            if (CompatibilityResult.INCOMPATIBLE == comp) {
                throwIncompatibleParameter(args);
            } else if (CompatibilityResult.LAZY_POSSIBLE == comp) {
                result = lazyExecutionResult();
            } else {
                try {
                    result = method.invoke(object, callArgs);
                } catch (IllegalArgumentException e) {
                    throw new VilException(e, VilException.ID_TYPE_INCOMPATIBILITY);
                } catch (IllegalAccessException e) {
                    throw new VilException(e, VilException.ID_SECURITY_ERROR);
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof NullPointerException) {
                        result = null; // fail-termination-semantics
                    } else {
                        throw new VilException(e.getCause(), VilException.ID_EXECUTION_ERROR);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Determines the (assumed) lazy execution result from the return type.
     * 
     * @return the lazy execution result
     */
    private Object lazyExecutionResult() {
        Class<?> returnType = method.getReturnType();
        Object result;
        if (!returnType.isPrimitive()) {
            // get rid of wrappers
            Class<?> eq = REFLECTION_EQUALITIES.get(returnType);
            if (null != eq) {
                returnType = eq;
            }
        }
        result = LAZY_DEFAULTS.get(returnType); // primitives are covered, all others are null
        return result;
    }
    
    /**
     * Throws an exception for the case that parameter are incompatible.
     * 
     * @param args the actual arguments
     * @throws VilException the created exception (happens in any case)
     */
    private void throwIncompatibleParameter(Object[] args) throws VilException {
        StringBuilder tmp = new StringBuilder("(");
        int start = 0;
        if (!isStatic()) {
            start = 1;
        }
        for (int i = start; i < args.length; i++) {
            if (i > start) {
                tmp.append(", ");
            }
            if (null == args[i]) {
                tmp.append("null");
            } else {
                tmp.append(args[i].getClass().getSimpleName());
            }
        }
        tmp.append(")");
        throw new VilException("incompatible parameter " + tmp + " cannot be applied to " 
            + getJavaSignature(), VilException.ID_TYPE_INCOMPATIBILITY);
    }

    /**
     * Returns a normalized Java signature for <code>method</code>. The signature
     * consists of name and parameters. This method may be simplified in future to 
     * optimize performance (public for testing). This method does not consider possible
     * unnamed parameter rather than the underlying Java parameter.
     * 
     * @param method the method to return the signature for
     * @return the signature
     */
    public static String getJavaSignature(Method method) {
        return getJavaSignature(method, null, false);
    }
    
    /**
     * Returns a normalized Java signature for <code>method</code>. The signature
     * consists of name and parameters. This method may be simplified in future to 
     * optimize performance (public for testing).
     * 
     * @param method the method to return the signature for
     * @param name an alias name
     * @param acceptsNamedParameter whether the method accepts named parameter
     * @return the signature
     */
    public static String getJavaSignature(Method method, String name, boolean acceptsNamedParameter) {
        StringBuilder tmp = new StringBuilder(null == name ? method.getName() : name);
        tmp.append("(");
        Class<?>[] param = method.getParameterTypes();
        if (null != param) {
            int count = param.length;
            if (acceptsNamedParameter) {
                count--;
            }
            for (int p = 0; p < count; p++) {
                tmp.append(param[p].getName());
                if (p < count - 1) {
                    tmp.append(",");
                }
            }
            if (acceptsNamedParameter) {
                if (count > 0) {
                    tmp.append(",");
                }
                tmp.append("...");
            }
        }
        tmp.append(")");
        return tmp.toString();
    }
    
    /**
     * Returns whether two Java methods have the same Java signature (public for testing). This method does not 
     * consider possible unnamed parameter rather than the underlying Java parameter.
     * 
     * @param method1 the first method to compare
     * @param method2 the second method to compare
     * @return <code>true</code> if both have the same signature, <code>false</code> else
     */
    public static boolean isSameSignature(Method method1, Method method2) {
        boolean same = false;
        if (method1.getName().equals(method2.getName())) {
            if (method1.getReturnType().equals(method2.getReturnType())) { // might need relaxation
                Class<?>[] param1 = method1.getParameterTypes();
                Class<?>[] param2 = method2.getParameterTypes();
                if (param1.length == param2.length) {
                    same = true;
                    for (int p = 0; same && p < param1.length; p++) {
                        same = param1[p].equals(param2[p]);
                    }
                }
            }
        }
        return same;
    }
    
    /**
     * Returns whether the given method is considered to be a VIL "constructor".
     * A VIL constructor must comply to the VIL rules, 
     * it must be static, the name must be equal to {@link #CONSTRUCTOR_NAME}
     * and the return type must be equal to the one of the declaring class (public for testing).
     * 
     * @param method the method to be analyzed
     * @return <code>true</code> if it is considered as a constructor, <code>false</code> else
     */
    public static boolean isConstructor(Method method) {
        int modifier = method.getModifiers();
        boolean modOk = Modifier.isPublic(modifier) && !Modifier.isAbstract(modifier) && Modifier.isStatic(modifier);
        return  modOk && method.getName().equals(CONSTRUCTOR_NAME) 
            && method.getReturnType().equals(method.getDeclaringClass());
    }

    /**
     * Returns whether the given method is considered to be a VIL operation. A VIL operation must comply to the 
     * VIL rules and not be static (public for testing).
     * 
     * @param method the method to be analyzed
     * @return <code>true</code> if it is considered as an operation, <code>false</code> else
     */
    public static boolean isOperation(Method method) {
        int modifier = method.getModifiers();
        return Modifier.isPublic(modifier) && !isConstructor(method);
    }
    
    /**
     * Returns whether the given method is a VIL operation or a VIL constructor.
     * 
     * @param method the method to be analyzed
     * @return <code>true</code> in case of a VIL operation or VIL constructor
     * 
     * @see #isConstructor(Method)
     * @see #isOperation(Method)
     */
    static boolean isOperationOrConstructor(Method method) {
        return isOperation(method) || isConstructor(method);
    }
    
    /**
     * Returns the return type of this operation.
     * 
     * @return the return type
     */
    public TypeDescriptor<? extends IVilType> getReturnType() {
        initialize();
        return returnType;
    }
    
    /**
     * Returns the number of parameters.
     * 
     * @return the number of parameter
     */
    public int getParameterCount() {
        initialize();
        return parameter.size();
    }
    
    /**
     * Returns the specified parameter type.
     * 
     * @param index the index of the parameter to return
     * @return the specified parameter type
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParameterCount()}</code>
     */
    public TypeDescriptor<? extends IVilType> getParameterType(int index) {
        initialize();
        return parameter.get(index);
    }
    
    /**
     * Returns a textual representation of this descriptor (the Java signature).
     * 
     * @return the textual representation
     */
    @Override
    public String toString() {
        return getJavaSignature();
    }
    
    /**
     * Returns whether this operation is a type select operation (non-static, collection
     * return, parameter is type).
     * 
     * @return <code>true</code> if it is a type select operation, <code>false</code> else
     */
    public boolean isTypeSelect() {
        boolean ok = false;
        if (!isStatic()) {
            initialize();
            ok = returnType.isCollection() && 2 == getParameterCount() && (TypeDescriptor.TYPE == getParameterType(1));
        }
        return ok;
    }

    /**
     * Returns whether this operation is a generic collection operation, i.e., whether the collection
     * itself determines the return type (non-static, collection return, implicit parameter is generic collection).
     * 
     * @return <code>true</code> if it is a generic collection operation, <code>false</code> else
     */
    public boolean isGenericCollectionOperation() {
        boolean ok = false;
        if (!isStatic()) {
            initialize();
            if (returnType.isCollection() && getParameterCount() > 0) {
                ok = getParameterType(0).isCollection();
            }
        }
        return ok;
    }
    
    /**
     * Return whether this operation returns the result of iterating over a collection. Such an 
     * operation may be a quantor, a collector or a selector. Therefore, the operation
     * must not be static, belong to a collection (first parameter type) and accept exactly one 
     * {@link ExpressionEvaluator} (typically the only additional parameter).
     * 
     * @return <code>true</code> of this operation is an iterating operation, <code>false</code> else
     */
    public boolean isIteratingCollectionOperation() {
        boolean ok = false;
        initialize();
        if (!isStatic()) {
            if (getParameterCount() > 1 && getParameterType(0).isCollection()) {
                int count = 0;
                for (int p = 1; p < getParameterCount(); p++) {
                    if (ExpressionEvaluator.class == getParameterType(0).getTypeClass()) {
                        count++;
                    }
                }
                ok = count == 1;
            }
        }
        return ok;
    }
    
    /**
     * Returns whether this operation descriptor is a conversion.
     * 
     * @return <code>true</code> if it is a conversion, <code>false</code> else
     */
    public boolean isConversion() {
        return isConversion;
    }

}
