package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Operation descriptor for decision variable to sequence conversion using 
 * {@link AbstractIvmlVariable#variables()}.
 *  
 * @author Holger Eichelberger
 */
class IvmlSequenceConversionOperationDescriptor extends IvmlOperationDescriptor {
    
    public static final String NAME = "convertToSequence";
    private static final TypeDescriptor<?> RETURN;
    
    static {
        TypeDescriptor<?> returnType;
        try {
            TypeDescriptor<?>[] types = TypeDescriptor.createArray(1);
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
    IvmlSequenceConversionOperationDescriptor(TypeDescriptor<?> declaringType) {
        this(declaringType, null);
    }
    
    /**
     * Creates a conversion descriptor.
     * 
     * @param declaringType the declaring class
     * @param generic the generic type for the set to convert to, may be <b>null</b> for DecisionVariable
     */
    IvmlSequenceConversionOperationDescriptor(TypeDescriptor<?> declaringType, 
        TypeDescriptor<?> generic) {
        super(declaringType, NAME, false);
        if (null != generic) {
            TypeDescriptor<?>[] types = TypeDescriptor.createArray(1);
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
        return Utils.isCompatible(params, DecisionVariable.class);
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
