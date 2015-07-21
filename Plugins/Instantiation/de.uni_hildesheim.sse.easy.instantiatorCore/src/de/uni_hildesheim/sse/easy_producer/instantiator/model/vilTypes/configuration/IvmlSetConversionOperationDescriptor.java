package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Operation descriptor for decision variable to sequence conversion using 
 * {@link AbstractIvmlVariable#variables()}.
 *  
 * @author Holger Eichelberger
 */
class IvmlSetConversionOperationDescriptor extends IvmlOperationDescriptor {
    
    public static final String NAME = "convertToSet";
    private static final TypeDescriptor<?> RETURN;
    
    static {
        TypeDescriptor<?> returnType;
        try {
            TypeDescriptor<?>[] types = TypeDescriptor.createArray(1);
            types[0] = IvmlTypes.decisionVariableType();
            returnType = TypeRegistry.getSetType(types);
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
    IvmlSetConversionOperationDescriptor(TypeDescriptor<?> declaringType) {
        this(declaringType, null);
    }
    
    /**
     * Creates a conversion descriptor.
     * 
     * @param declaringType the declaring class
     * @param generic the generic type for the set to convert to, may be <b>null</b> for DecisionVariable
     */
    IvmlSetConversionOperationDescriptor(TypeDescriptor<?> declaringType, 
        TypeDescriptor<?> generic) {
        super(declaringType, NAME, false);
        if (null != generic) {
            TypeDescriptor<?>[] types = TypeDescriptor.createArray(1);
            types[0] = generic;
            try {
                setReturnType(TypeRegistry.getSetType(types));
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
        if (args[0] instanceof Set) {
            result = args[0];
        } else {
            result = ((DecisionVariable) args[0]).variablesSet();
        }
        return result;
    }
}
