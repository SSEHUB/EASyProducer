package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

/**
 * Implements the operation descriptor which provides access to the IVML type of the decision variable itself (just 
 * the operand as implicit parameter).
 *  
 * @author Holger Eichelberger
 */
class IvmlMetaTypeOperationDescriptor extends IvmlMetaOperationDescriptor {
    
    /**
     * The name of the operation.
     */
    public static final String NAME = META_PREFIX + "type";

    /**
     * Creates the operation descriptor.
     * 
     * @param declaringType the declaring type
     */
    IvmlMetaTypeOperationDescriptor(TypeDescriptor<? extends IVilType> declaringType) {
        super(declaringType, TypeRegistry.stringType(), NAME);
    }

    @Override
    protected Object invokeImpl(Object[] args) throws VilException {
        return ((DecisionVariable) args[0]).getType();
    }

}
