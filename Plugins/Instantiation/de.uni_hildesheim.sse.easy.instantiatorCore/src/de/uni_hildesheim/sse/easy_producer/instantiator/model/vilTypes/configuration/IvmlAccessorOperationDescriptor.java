package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;

/**
 * Defines an operation descriptor which enables comfortable access to an individual decision variables
 * via its name.
 * 
 * @author Holger Eichelberger
 */
class IvmlAccessorOperationDescriptor extends IvmlOperationDescriptor {

    private String varName;
    
    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param name the name of the accessor to create the descriptor for
     * @param var the variable to create the descriptor for
     * @throws VilException in case that creating the descriptor fails
     */
    private IvmlAccessorOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, String name, 
        DecisionVariableDeclaration var) throws VilException {
        super(declaringType, name, false);
        varName = var.getName();
        setReturnType(determineReturnType(var.getType()));
        setParameters(createParameterList(declaringType), false, false);
    }
    
    /**
     * Creates the operation descriptor and a related getter according to the VIL conventions.
     * 
     * @param declaringType the declaring type
     * @param var the variable to create the descriptor for
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     * @throws VilException in case that creating the descriptors fails
     */
    static void createDescriptors(TypeDescriptor<? extends IVilType> declaringType, DecisionVariableDeclaration var, 
        Map<String, OperationDescriptor> operations) throws VilException {
        // var just in case that we need sometimes more information
        String name = var.getName();
        AbstractIvmlTypeDescriptor.addOperation(new IvmlAccessorOperationDescriptor(declaringType, name, var), 
            operations);
        AbstractIvmlTypeDescriptor.addOperation(new IvmlAccessorOperationDescriptor(declaringType, 
            Constants.GETTER_PREFIX + StringValueHelper.firstToUpperCase(name), var), operations);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return isCompatibleToDecisionVariable(params);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (null == args[0]) {
            result = null;
        } else {
            if (isCompatibleToDecisionVariable(args) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            DecisionVariable tmp = ((DecisionVariable) args[0]).getByName(varName);
            if (getReturnType().isCollection()) {
                IDatatype type = tmp.getDecisionVariable().getDeclaration().getType();
                type = DerivedDatatype.resolveToBasis(type);
                if (Set.TYPE.isAssignableFrom(type)) {
                    result = tmp.variablesSet();
                } else {
                    result = tmp.variables();
                }
            } else {
                result = tmp;
            }
        }
        return result;
    }
    
}
