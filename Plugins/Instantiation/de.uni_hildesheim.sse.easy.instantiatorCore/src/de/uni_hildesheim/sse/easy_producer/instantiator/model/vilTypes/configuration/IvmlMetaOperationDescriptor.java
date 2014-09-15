package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Implements an abstract class for zero (only implicit) parameter operations providing
 * meta information on a {@link DecisionVariable}. This kind of operations is never a constructor.
 * 
 * @author Holger Eichelberger
 */
abstract class IvmlMetaOperationDescriptor extends IvmlOperationDescriptor {
    
    public static final String META_PREFIX = "$";
    
    /**
     * Creates the descriptor.
     * 
     * @param declaringType the declaring type
     * @param returnType the return type of the operation
     * @param name the name of the operation
     */
    IvmlMetaOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, 
        TypeDescriptor<? extends IVilType> returnType, String name) {
        super(declaringType, name, false);
        setParameters(createParameterList(declaringType), false, false);
        setReturnType(returnType);
    }
    
    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return isCompatibleToDecisionVariable(params);
    }

    /**
     * Provides the actual implementation of the invocation call. Is called from {@link #invoke(Object...)}.
     * 
     * @param args the actual arguments 
     * @return the return value
     * @throws VilException in case that the invocation fails
     */
    protected abstract Object invokeImpl(Object[] args) throws VilException;

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (null == args[0]) {
            result = null;
        } else {
            if (isCompatibleToDecisionVariable(args) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            result = invokeImpl(args);
        }
        return result;
    }
    
}
