package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Defines an operation descriptor which enables comfortable access to an individual decision variables
 * via its name.
 * 
 * @author Holger Eichelberger
 */
public class IvmlConversionOperationDescriptor extends IvmlOperationDescriptor {

    public static final String NAME = "convertToGeneric";

    /**
     * Constructor for serialization.
     */ 
    IvmlConversionOperationDescriptor() {
        this(null);
    }
    
    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     */
    IvmlConversionOperationDescriptor(TypeDescriptor<?> declaringType) {
        this(declaringType, IvmlTypes.decisionVariableType());
    }
    
    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param returnType the return type
     */
    IvmlConversionOperationDescriptor(TypeDescriptor<?> declaringType, 
        TypeDescriptor<?> returnType) {
        super(declaringType, NAME, false);
        setReturnType(returnType);
        setParameters(createParameterList(declaringType), false, false);
        setCharacteristics(OperationType.NORMAL, AliasType.NONE, true, NAME);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return Utils.isCompatible(params, DecisionVariable.class);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return args[0];
    }
    
}
