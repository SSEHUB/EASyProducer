package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * An external type resolver for {@link TypeRegistry}. This may allow for deferred type
 * resolution in order to save memory.
 * 
 * @author Holger Eichelberger
 */
public interface ITypeResolver {

    /**
     * Resolves a type by its name.
     * 
     * @param name the name of the type to be resolved
     * @return the resolved type (or <b>null</b> if <code>name</code> cannot be resolved)
     */
    public TypeDescriptor<? extends IVilType> resolveType(String name);

    /**
     * Resolves an instantiator by its name.
     * 
     * @param name the name of the type to be resolved
     * @return the resolved instantiator type (or <b>null</b> if <code>name</code> cannot be resolved)
     */
    public TypeDescriptor<? extends IVilType> resolveInstantiator(String name);
    
}
