package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Operation descriptor for decision variable to sequence conversion using 
 * {@link AbstractIvmlVariable#variables()}.
 *  
 * @author Holger Eichelberger
 */
class IvmlSequenceConversionOperationDescriptor extends IvmlOperationDescriptor {
    
    public static final String NAME = "convertToSequence";
    private static final TypeDescriptor<? extends IVilType> RETURN;
    
    static {
        TypeDescriptor<? extends IVilType> returnType;
        try {
            TypeDescriptor<? extends IVilType>[] types = TypeDescriptor.createArray(1);
            types[0] = IvmlTypes.decisionVariableType();
            returnType = TypeRegistry.getSequenceType(types);
        } catch (VilException e) {
            returnType = TypeRegistry.anyType();
        }
        RETURN = returnType;
    }

    /**
     * Creates a conversion descriptor.
     * 
     * @param declaringType the declaring class
     */
    IvmlSequenceConversionOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType) {
        this(declaringType, null);
    }
    
    /**
     * Creates a conversion descriptor.
     * 
     * @param declaringType the declaring class
     * @param generic the generic type for the set to convert to, may be <b>null</b> for DecisionVariable
     */
    IvmlSequenceConversionOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType, 
        TypeDescriptor<? extends IVilType> generic) {
        super(declaringType, NAME, false);
        if (null != generic) {
            TypeDescriptor<? extends IVilType>[] types = TypeDescriptor.createArray(1);
            types[0] = generic;
            try {
                setReturnType(TypeRegistry.getSequenceType(types));
            } catch (VilException e) {
                setReturnType(TypeRegistry.anyType());
            }
        } else {
            setReturnType(RETURN);
        }
        setParameters(createParameterList(declaringType), false, false);
        setCharacteristics(OperationType.NORMAL, AliasType.NONE, true, NAME);
    }
    
    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return isCompatible(params, DecisionVariable.class);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result;
        if (args[0] instanceof Sequence) {
            result = args[0];
        } else {
            result = ((DecisionVariable) args[0]).variables();
        }
        return result;
    }
}
