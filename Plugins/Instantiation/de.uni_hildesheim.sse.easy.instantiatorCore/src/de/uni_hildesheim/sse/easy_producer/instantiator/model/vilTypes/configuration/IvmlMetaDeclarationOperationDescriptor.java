package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Implements the operation descriptor which provides access to the variable declaration (just the operand as 
 * implicit parameter).
 *  
 * @author Holger Eichelberger
 */
class IvmlMetaDeclarationOperationDescriptor extends IvmlMetaOperationDescriptor {

    /**
     * The name of the operation.
     */
    public static final String NAME = META_PREFIX + "declaration";

    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     */
    IvmlMetaDeclarationOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType) {
        super(declaringType, IvmlTypes.declarationType(), NAME);
    }

    @Override
    protected Object invokeImpl(Object[] args) throws VilException {
        return ((DecisionVariable) args[0]).getDeclaration();
    }
    
}
