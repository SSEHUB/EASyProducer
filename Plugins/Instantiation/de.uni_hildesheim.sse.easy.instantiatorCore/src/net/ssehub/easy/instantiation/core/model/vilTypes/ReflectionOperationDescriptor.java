package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation.CompatibilityResult;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.NullValue.NullValueType;

/**
 * Represents an individual operation available to the VIL languages based on reflection 
 * analysis of the underlying class. This class works on the default type registry. Please
 * note that named arguments are passed in terms of a map as the last parameter
 * of the respective method. If the underlying Java method takes such a parameter, 
 * the descriptor will count one parameter less!
 * 
 * @author Holger Eichelberger
 */
public class ReflectionOperationDescriptor extends OperationDescriptor implements ILazyDescriptor {

    /**
     * Stores implicit type equalities handled by boxing/unboxing in Java reflection.
     */
    private static final Map<Class<?>, Class<?>> REFLECTION_EQUALITIES = new HashMap<Class<?>, Class<?>>();

    private Method method;
    private int returnGenericParameterIndex = -1;
    private int returnParameterIndex = -1;
    private boolean storeArtifactsBeforeExecution = false;
    private boolean trace = true;
    
    /**
     * Creates a new operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param method the reflection method to be called
     * @param isConstructor whether this descriptor shall act as constructor
     */
    public ReflectionOperationDescriptor(TypeDescriptor<?> declaringType, Method method, boolean isConstructor) {
        this(declaringType, method, null, isConstructor);
    }
    
    /**
     * Creates a new operation descriptor as an alias.
     * 
     * @param declaringType the declaring type
     * @param method the reflection method to be called
     * @param name the alias name (may be <b>null</b> if the original name of <code>method</code> shall be used)
     * @param isConstructor whether this descriptor shall act as a constructor
     */
    public ReflectionOperationDescriptor(TypeDescriptor<?> declaringType, Method method, String name, 
        boolean isConstructor) {
        super(declaringType, name, isConstructor);
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
            trace = meta.trace();
            if (null != meta.name() && meta.name().length > 0) {
                aliasType = AliasType.EXPLICIT;
            }
            returnGenericParameterIndex = meta.useGenericParameter();
            returnParameterIndex = meta.useParameter();
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
    }
    
    @Override
    public void forceInitialization() {
        initializeParameters();
        initializeReturnType();
    }
    
    /**
     * Returns whether named parameters shall be considered for this descriptor.
     * 
     * @return <code>true</code> if named parameters shall be considered, <code>false</code> else
     */
    protected boolean considerNamedParameters() {
        return true;
    }
    
    @Override
    protected void initializeParameters() {
        boolean acceptsNamedParameters = false;
        boolean acceptsImplicitParameters = false;
        ArrayList<TypeDescriptor<?>> parameter = new ArrayList<TypeDescriptor<?>>();
        TypeDescriptor<?> declaringType = getDeclaringType();
        if (!Modifier.isStatic(method.getModifiers()) && null != declaringType) {
            parameter.add(declaringType);
        }
        boolean considerNamed = considerNamedParameters();
        Class<?>[] params = method.getParameterTypes();
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        int[] argGenericIndex = null == meta ? null : meta.genericArgument();
        TypeDescriptor<?> declaring = getDeclaringType();
        
        for (int i = 0; i < params.length; i++) {
            if (considerNamed && i == params.length - 1 && Map.class.isAssignableFrom(params[i])) {
                acceptsNamedParameters = true;
            } else {
                TypeDescriptor<?> type = ReflectionResolver.resolveType(params[i], getParameterGenerics(i));
                if (null != argGenericIndex && i < argGenericIndex.length) {
                    int genIndex = argGenericIndex[i];
                    if (genIndex >= 0 && genIndex < declaring.getGenericParameterCount()) {
                        type = declaring.getGenericParameterType(genIndex);
                    }
                }
                parameter.add(type);
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
    public OperationDescriptor specializeFor(TypeDescriptor<?> declaringType) {
        OperationDescriptor result = this;
        if (declaringType.getGenericParameterCount() > 0) {
            OperationMeta meta = method.getAnnotation(OperationMeta.class);
            if (null != meta && null != meta.genericArgument() && meta.genericArgument().length > 0) {
                result = new ReflectionOperationDescriptor(declaringType, method, isConstructor());
            }
        }
        return result;
    }
    
    @Override
    protected void initializeReturnType() {
        setReturnType(ReflectionResolver.resolveType(method.getReturnType(), getReturnGenerics()));
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
                throw new VilException("object missing (first implicit parameter)", 
                    VilException.ID_EXECUTION_ERROR);
            }
            object = args[0];
            callArgs = new Object[args.length - 1];
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < callArgs.length; i++) {
                Object arg = args[i + 1];
                // explicit conversion - convenience and legacy
                if (arg instanceof TypeDescriptor && paramTypes[i] == Class.class) {
                    callArgs[i] = ((TypeDescriptor<?>) arg).getTypeClass();
                } else if (arg instanceof IActualTypeProvider && paramTypes[i] == TypeDescriptor.class) {
                    callArgs[i] = ((IActualTypeProvider) arg).getType();
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
                result = tryEvaluateEquality(args, callArgs);
            } else if (CompatibilityResult.ARG_EVALUATION_FAILED == comp) {
                result = null; // cannot evaluate
            } else {
                try {
                    // convertVariables(callArgs); // ???
                    result = method.invoke(object, callArgs);
                    if (null == result && Void.TYPE == method.getReturnType()) {
                        result = NullValue.VALUE; // void methods otherwise cause failing of the calling rule / template
                    }
                } catch (IllegalArgumentException e) {
                    throw new VilException(composeExceptionMessage(e, args), VilException.ID_TYPE_INCOMPATIBILITY);
                } catch (IllegalAccessException e) {
                    throw new VilException(composeExceptionMessage(e, args), VilException.ID_SECURITY_ERROR);
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof NullPointerException) {
                        result = null; // fail-termination-semantics
                    } else {
                        throw new VilException(composeExceptionMessage(e.getCause(), args), e.getCause(), 
                            VilException.ID_EXECUTION_ERROR);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Nullifies <code>value</code>, i.e., checks whether it is an IVML null value and turns it into <b>null</b>.
     * 
     * @param value the value to check
     * @return <code>value</code> or <b>null</b>
     */
    private static Object nullify(Object value) {
        Object result;
        if (value instanceof NullValueType) {
            result = null;
        } else {
            result = value;
        }
        return result;
    }
    
    /**
     * Tries to evaluate equality/unequality if the actual parameters are incompatible for a regular call. This
     * allows evaluating null comparisons against primitive types (decision variables declare a specific operation
     * for that).
     * 
     * @param args the original call arguments
     * @param callArgs the actual call arguments prepared for a reflective call
     * @return the evaluation result
     * @throws VilException in case that the arguments are still considered incompatible
     */
    private Object tryEvaluateEquality(Object[] args, Object[] callArgs) throws VilException {
        Object result = null;
        if (callArgs.length == 2 && OperationType.INFIX == getOperationType()) {
            Object arg0 = nullify(callArgs[0]);
            Object arg1 = nullify(callArgs[1]);
            String name = getName();
            if (Constants.UNEQUALITY.equals(name) || Constants.UNEQUALITY_ALIAS.equals(name)) {
                if (null == arg0) {
                    result = arg1 != null;
                } else {
                    result = !arg0.equals(arg1);
                }
                //result = arg0 != arg1;
            } else if (Constants.EQUALITY.equals(name)) {
                if (null == arg0) {
                    result = arg1 == null;
                } else {
                    result = arg0.equals(arg1);
                }
                //result = arg0 == arg1;
            } else {
                throwIncompatibleParameter(args);
            }
        }
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
        boolean cannotEvaluate = true;
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
                cannotEvaluate &= params[p] == null;
            }
            compatible &= parCompatible;
        }
        CompatibilityResult result;
        if (compatible) {
            result = CompatibilityResult.COMPATIBLE;
        } else {
            if (cannotEvaluate) {
                result = CompatibilityResult.ARG_EVALUATION_FAILED;
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
        int pCount = getParameterCount();
        for (int p = 0; p < pCount; p++) {
            TypeDescriptor<?> pType = getParameterType(p);
            tmp.append(pType.getVilName());
            if (p < pCount - 1) {
                tmp.append(",");
            }
        }
        /* old:
        Class<?>[] param = method.getParameterTypes();
        if (null != param) {
            for (int p = 0; p < param.length; p++) {
                tmp.append(param[p].getSimpleName());
                if (p < param.length - 1) {
                    tmp.append(",");
                }
            }
        }*/
        tmp.append(")");
        return tmp.toString();
    }
    
    @Override
    protected String getDeclaringTypeNameFallback() {
        return method.getDeclaringClass().getSimpleName();
    }
    
    /**
     * Returns the wrapped method.
     * 
     * @return the method
     */
    protected Method getMethod() {
        return method;
    }
    
    @Override
    public String getName() {
        String tmp = getStoredName();
        return null != tmp ? tmp : method.getName();
    }
    
    /**
     * Determines the type of a parameter.
     * 
     * @param index the index of the parameter
     * @return the parameter generics (<b>null</b> if none are specified)
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParameterCount()}</code>
     */
    protected Class<?>[] getParameterGenerics(int index) {
        Class<?>[] result = null;
        ParameterMeta pMeta = TypeHelper.getParameterAnnotation(method.getParameterAnnotations(), 
            index, ParameterMeta.class);
        if (null != pMeta) {
            result = pMeta.generics();
        }
        return result;
    }

    /**
     * Determines the return type generics.
     * 
     * @return the return type generics (<b>null</b> if none are specified)
     */
    protected Class<?>[] getReturnGenerics() {
        Class<?>[] result = null;
        OperationMeta opMeta = method.getAnnotation(OperationMeta.class);
        if (null != opMeta) {
            result = opMeta.returnGenerics();
        }
        return result;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public int useGenericParameterAsReturn() {
        return returnGenericParameterIndex;
    }
    
    @Override
    public int useParameterAsReturn() {
        return returnParameterIndex;
    }
    
    @Override
    public boolean storeArtifactsBeforeExecution() {
        return storeArtifactsBeforeExecution;
    }

    @Override
    public boolean requiresDynamicExpressionProcessing() {
        boolean result;
        OperationMeta annotation = method.getAnnotation(OperationMeta.class);
        if (null != annotation) {
            result = annotation.requiresDynamicExpressionProcessing();
        } else {
            result = false;
        }
        return result;
    }
    
    @Override
    public boolean trace() {
        return trace && super.trace();
    }

    @Override
    public boolean allowsAggregation() {
        boolean result = false;
        OperationMeta opMeta = method.getAnnotation(OperationMeta.class);
        if (null != opMeta) {
            result = opMeta.allowsAggregation();
        }
        return result;
    }

    @Override
    public boolean isOclCompliant() {
        boolean compliant = true;
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            String name = getName();
            String[] not = meta.notOclCompliant();
            for (int i = 0; compliant && i < not.length; i++) {
                compliant = !name.equals(not[i]);
            }
        }
        return compliant;
    }

    @Override
    public boolean useAny() {
        boolean result = false;
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            result = meta.useAny();
        }
        return result;
    }
    
    @Override
    public boolean flatten() {
        boolean result = false;
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            result = meta.flatten();
        }
        return result;        
    }
    
    @Override
    public boolean useOperandTypeAsParameter() {
        boolean result = false;
        OperationMeta meta = method.getAnnotation(OperationMeta.class);
        if (null != meta) {
            result = meta.useOperandTypeAsParameter();
        }
        return result;        
    }

}
