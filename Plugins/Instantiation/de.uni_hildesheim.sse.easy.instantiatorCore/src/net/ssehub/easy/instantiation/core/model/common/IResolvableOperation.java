package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Defines the interface of a resolvable operation.
 * 
 * @param <V> the actual type of variable
 * 
 * @author Holger Eichelberger
 */
public interface IResolvableOperation<V extends IMetaParameterDeclaration> extends IParameterizable<V>, IMetaOperation {

    /**
     * Returns the return type of this operation.
     * 
     * @return the return type
     */
    @Override
    public TypeDescriptor<?> getReturnType(); // specializes the type

}
