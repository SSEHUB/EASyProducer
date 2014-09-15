package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;

/**
 * Defines an operation descriptor which enables comfortable access to a top-level decision variable
 * by its name.
 * 
 * @author Holger Eichelberger
 */
class IvmlConfigurationOperationDescriptor extends IvmlOperationDescriptor {

    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param var the variable to create the descriptor for
     */
    IvmlConfigurationOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, 
        DecisionVariableDeclaration var) {
        super(declaringType, var.getName(), false);
        setReturnType(IvmlTypes.decisionVariableType());
        setParameters(createParameterList(declaringType), false, false);
    }
    
    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return isCompatible(params, Configuration.class);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (null == args[0]) {
            result = null;
        } else {
            if (isCompatible(args, Configuration.class) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            result = ((Configuration) args[0]).getByName(getName());
        } 
        return result;
    }
    
}
