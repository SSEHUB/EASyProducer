package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Defines the interface of a resolvable operation.
 * 
 * @param <V> the actual type of variable
 * 
 * @author Holger Eichelberger
 */
public interface IResolvableOperation<V extends IResolvable> extends IParameterizable<V>, IMetaOperation {

    /**
     * Returns the return type of this operation.
     * 
     * @return the return type
     */
    @Override
    public TypeDescriptor<?> getReturnType(); // specializes the type

}
