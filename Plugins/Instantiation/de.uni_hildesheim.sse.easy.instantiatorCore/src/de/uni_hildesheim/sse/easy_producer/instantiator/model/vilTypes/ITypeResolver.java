package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * An external type resolver for {@link TypeRegistry}. This may allow for deferred type
 * resolution in order to save memory.
 * 
 * @author Holger Eichelberger
 */
public interface ITypeResolver {

    /**
     * Returns the type registry this resolver is registered with.
     * 
     * @return the type registry
     */
    public TypeRegistry getTypeRegistry();
    
    /**
     * Resolves a type by its name.
     * 
     * @param name the name of the type to be resolved
     * @param addIfMissing whether dynamically adding (a fake) type for a missing type is 
     *     allowed through this call
     * @return the resolved type (or <b>null</b> if <code>name</code> cannot be resolved)
     */
    public TypeDescriptor<?> resolveType(String name, boolean addIfMissing);

    /**
     * Resolves a type by its IVML type.
     * 
     * @param type the type to be resolved
     * @return the resolved type (or <b>null</b> if <code>name</code> cannot be resolved)
     */
    public TypeDescriptor<?> resolveType(IDatatype type);
    
    /**
     * Resolves an instantiator by its name.
     * 
     * @param name the name of the type to be resolved
     * @return the resolved instantiator type (or <b>null</b> if <code>name</code> cannot be resolved)
     */
    public TypeDescriptor<? extends IVilType> resolveInstantiator(String name);
    
    /**
     * Set the direct access to the registry.
     * 
     * @param access the access instance
     */
    public void setRegistryAccess(IDirectTypeRegistryAccess access);
    
}
