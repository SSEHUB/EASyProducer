package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Defines an operation descriptor which enables comfortable access to an individual decision variables
 * via its name.
 * 
 * @author Holger Eichelberger
 */
class IvmlConversionOperationDescriptor extends IvmlOperationDescriptor {

    public static final String NAME = "convertToGeneric";

    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     */
    IvmlConversionOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType) {
        this(declaringType, IvmlTypes.decisionVariableType());
    }
    
    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param returnType the return type
     */
    IvmlConversionOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, 
        TypeDescriptor<? extends IVilType> returnType) {
        super(declaringType, NAME, false);
        setReturnType(returnType);
        setParameters(createParameterList(declaringType), false, false);
        setCharacteristics(OperationType.NORMAL, AliasType.NONE, true, NAME);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return isCompatible(params, DecisionVariable.class);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return args[0];
    }
    
}
