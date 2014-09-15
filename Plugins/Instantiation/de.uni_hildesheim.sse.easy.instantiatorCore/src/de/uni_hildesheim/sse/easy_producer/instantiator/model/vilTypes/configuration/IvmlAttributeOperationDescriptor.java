package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Defines an operation descriptor which enables comfortable access to an individual IVML attribute 
 * via its name.
 * 
 * @author Holger Eichelberger
 */
class IvmlAttributeOperationDescriptor extends IvmlOperationDescriptor {

    private String attName;
    
    /**
     * Creates the operation descriptor for an attribute access.
     * 
     * @param declaringType the declaring type
     * @param name the name of the operation
     * @param attribute the attribute to create the descriptor for
     * @throws VilException in case that creating the descriptor fails
     */
    private IvmlAttributeOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, String name, 
        de.uni_hildesheim.sse.model.varModel.Attribute attribute) throws VilException {
        super(declaringType, name, false);
        attName = attribute.getName();
        IDatatype type = attribute.getType();
        if (type.isPrimitive()) {
            setReturnType(IvmlTypes.attributeType()); // due to conversions
        } else {
            setReturnType(determineReturnType(type));
        }
        setParameters(createParameterList(declaringType), false, false);
    }

    /**
     * Creates the operation descriptor and a related getter according to the VIL conventions.
     * 
     * @param declaringType the declaring type
     * @param attribute the attribute to create the descriptor for
     * @param operations the operations (signature-descriptor) (to be modified as a side effect)
     * @throws VilException in case that creating the descriptors fails
     */
    static void createDescriptors(TypeDescriptor<? extends IVilType> declaringType, 
        de.uni_hildesheim.sse.model.varModel.Attribute attribute, Map<String, OperationDescriptor> operations) 
        throws VilException {
        // attribute just in case that we need sometimes more information
        String name = attribute.getName();
        AbstractIvmlTypeDescriptor.addOperation(new IvmlAttributeOperationDescriptor(declaringType, name, attribute), 
            operations);
        AbstractIvmlTypeDescriptor.addOperation(new IvmlAttributeOperationDescriptor(declaringType, 
            Constants.GETTER_PREFIX + StringValueHelper.firstToUpperCase(name), attribute), operations);
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
            if (CompatibilityResult.COMPATIBLE == isCompatible(args, DecisionVariable.class)) {
                result = ((DecisionVariable) args[0]).getAttribute(attName);
            } else if (CompatibilityResult.COMPATIBLE == isCompatible(args, Configuration.class)) {
                result = ((Configuration) args[0]).getAttribute(attName);
            } else {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            if (result instanceof AbstractIvmlVariable) {
                if (getReturnType().isCollection()) {
                    result = ((AbstractIvmlVariable) result).variables();
                } 
            }
        }
        return result;
    }
    
}
