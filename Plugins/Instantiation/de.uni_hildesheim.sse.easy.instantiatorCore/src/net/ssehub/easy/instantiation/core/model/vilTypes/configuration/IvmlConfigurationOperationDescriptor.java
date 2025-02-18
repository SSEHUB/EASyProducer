package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Defines an operation descriptor which enables comfortable access to a top-level decision variable
 * by its name.
 * 
 * @author Holger Eichelberger
 */
class IvmlConfigurationOperationDescriptor extends IvmlOperationDescriptor {

    /**
     * For serialization.
     */
    IvmlConfigurationOperationDescriptor() {
        super(null, null, false);
    }
    
    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param var the variable to create the descriptor for
     */
    IvmlConfigurationOperationDescriptor(TypeDescriptor<?> declaringType, 
        DecisionVariableDeclaration var) {
        super(declaringType, var.getName(), false);
        setReturnType(IvmlTypes.decisionVariableType());
        setParameters(createParameterList(declaringType), false, false);
    }
    
    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return Utils.isCompatible(params, Configuration.class);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (null == args[0]) {
            result = null;
        } else {
            if (Utils.isCompatible(args, Configuration.class) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            result = ((Configuration) args[0]).getByName(getName());
        } 
        return result;
    }
    
}
