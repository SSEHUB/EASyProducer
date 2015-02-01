package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.CompatibilityResult;

/**
 * Represents an individual operation available to the VIL languages based on reflection 
 * analysis of the underlying class. This class works on the default type registry. Please
 * note that named arguments are passed in terms of a map as the last parameter
 * of the respective method. If the underlying Java method takes such a parameter, 
 * the descriptor will count one parameter less!
 * 
 * @author Holger Eichelberger
 */
class ReflectionOperationDescriptor extends OperationDescriptor {

    /**
     * Stores implicit type equalities handled by boxing/unboxing in Java reflection.
     */
    private static final Map<Class<?>, Class<?>> REFLECTION_EQUALITIES = new HashMap<Class<?>, Class<?>>();

    /**
     * Stores lazy default values (primitives are sufficient).
     */
    private static final Map<Class<?>, Object> LAZY_DEFAULTS = new HashMap<Class<?>, Object>();
    
    private Method method;
    private int returnParameterIndex = -1;
    private boolean storeArtifactsBeforeExecution = false;
    
    /**
     * Creates a new operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param method the reflection method to be called
     */
    ReflectionOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, Method method) {
        this(declaringType, method, null);
    }
    
    /**
     * Creates a new operation descriptor as an alias.
     * 
     * @param declaringType the declaring type
     * @param method the reflection method to be called
     * @param name the alias name (may be <b>null</b> if the original name of <code>method</code> shall be used)
     */
    ReflectionOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, Method method, String name) {
        super(declaringType, name, isConstructor(method));
        this.method = method;
        
        AliasType aliasType = getAliasType();
        OperationType opType = getOperationType();
        String opName = null;
        if (null != name && !name.equals(method.getName()) && name.length() > 0) {
            opName = name; // ensure proper use
            aliasType = AliasType.IMPLICIT;
        }
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            opType = meta.opType();
            if (null != meta.name() && meta.name().length > 0) {
                aliasType = AliasType.EXPLICIT;
            }
            returnParameterIndex = meta.useGenericParameter();
            storeArtifactsBeforeExecution = meta.storeArtifactsBefore();
        }
        boolean isConversion = null != method.getAnnotation(Conversion.class);
        setCharacteristics(opType, aliasType, isConversion, opName);
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
    
    @Override
    protected void initializeParameters() {
        boolean acceptsNamedParameters = false;
        boolean acceptsImplicitParameters = false;
        ArrayList<TypeDescriptor<? extends IVilType>> parameter = new ArrayList<TypeDescriptor<? extends IVilType>>();
        TypeDescriptor<? extends IVilType> declaringType = getDeclaringType();
        if (!Modifier.isStatic(method.getModifiers()) && null != declaringType) {
            parameter.add(declaringType);
        }
        Class<?>[] params = method.getParameterTypes();
        for (int i = 0; i < params.length; i++) {
            if (i == params.length - 1 && Map.class.isAssignableFrom(params[i])) {
                acceptsNamedParameters = true;
            } else {
                parameter.add(resolveType(params[i], false));
            }
        }
        if (acceptsNamedParameters) {
            Instantiator inst = method.getDeclaringClass().getAnnotation(Instantiator.class);
            /*
             *  Content assist triggers this indirectly.
             *  Thus, preventing null-pointer due to triggers before actually loading the classes.
             *  
             *  Idea: move initialization to constructor if further problems occur. 
             */
            if (inst != null) {            
                acceptsImplicitParameters = inst.acceptsImplicitParameters();
            }
        }
        setParameters(parameter, acceptsNamedParameters, acceptsImplicitParameters);
    }
    
    @Override
    protected void initializeReturnType() {
        setReturnType(resolveType(method.getReturnType(), true));
    }
    
    @Override
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
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < callArgs.length; i++) {
                Object arg = args[i + 1];
                // explicit conversion - convenience and legacy
                if (arg instanceof TypeDescriptor && paramTypes[i] == Class.class) {
                    callArgs[i] = ((TypeDescriptor<?>) arg).getTypeClass();
                } else {
                    callArgs[i] = args[i + 1];
                }
            }
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

    @Override
    public boolean isStatic() {
        return Modifier.isStatic(method.getModifiers());
    }
    
    @Override
    public boolean isFirstParameterOperand() {
        return !isStatic();
    }

    @Override
    public String getJavaSignature() {
        return SignatureUtils.getJavaSignature(method, getStoredName(), acceptsNamedParameters());
    }
    
    @Override
    public String getSignature() {
        StringBuilder tmp = new StringBuilder();
        if (isConstructor()) {
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
    
    @Override
    protected String getDeclaringTypeNameFallback() {
        return method.getDeclaringClass().getSimpleName();
    }
    
    @Override
    public String getName() {
        String tmp = getStoredName();
        return null != tmp ? tmp : method.getName();
    }
    
    /**
     * Resolves the given type to a type descriptor.
     *  
     * @param cls the class to be resolved
     * @param returnType whether a return type shall be resolved
     * @return the resolved type descriptor
     */
    private TypeDescriptor<? extends IVilType> resolveType(Class<?> cls, boolean returnType) {
        TypeDescriptor<? extends IVilType> result = null;
        if (Void.TYPE == cls) {
            result = ReflectionTypeDescriptor.VOID;
        } else {
            TypeDescriptor<?>[] parameter = null;
            if (returnType) {
                OperationMeta opMeta = method.getAnnotation(OperationMeta.class);
                if (null != opMeta) {
                    Class<?>[] param = opMeta.returnGenerics();
                    parameter = TypeDescriptor.createArray(param.length);
                    for (int i = 0; i < param.length; i++) {
                        parameter[i] = TypeRegistry.DEFAULT.getType(ReflectionTypeDescriptor.getRegName(param[i]));
                    }
                }
            }
            try {
                if (ReflectionTypeDescriptor.isSet(cls)) {
                    result = TypeRegistry.getSetType(parameter);
                } else if (ReflectionTypeDescriptor.isSequence(cls)) {
                    result = TypeRegistry.getSequenceType(parameter);
                }
            } catch (VilException e) {
                // no type -> handled later
            }
            if (null == result) {
                result = TypeRegistry.DEFAULT.getType(cls.getName());
                if (null == result) {
                    result = TypeRegistry.DEFAULT.getType(cls.getSimpleName()); // artifacts
                }
            }
            if (null == result) {
                if (Object.class == cls) {
                    result = ReflectionTypeDescriptor.ANY;
                } else {
                    result = ReflectionTypeDescriptor.VOID;
                }
            }
        }
        return result;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public int useParameterAsReturn() {
        return returnParameterIndex;
    }
    
    @Override
    public boolean storeArtifactsBeforeExecution() {
        return storeArtifactsBeforeExecution;
    }

}
