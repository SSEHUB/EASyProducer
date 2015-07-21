package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Provides direct access to the type registration for {@link ITypeResolver}. This
 * interface helps protecting the inner registry while providing write access to 
 * related type resolvers.
 * 
 * @author Holger Eichelberger
 */
public interface IDirectTypeRegistryAccess {

    /**
     * Adds a type.
     * 
     * @param name the name of the type
     * @param type the type to be added
     */
    public void add(String name, TypeDescriptor<?> type);
    
    /**
     * Returns whether the type given by <code>name</code> is already registered.
     * 
     * @param name the name of the type
     * @return <code>true</code> if it was registered, <code>false</code> else
     */
    public boolean contains(String name);
    
    /**
     * Returns the type descriptor registered for <code>name</code>.
     * 
     * @param name the name of the type
     * @return the registered descriptor (may be <b>null</b> if none was registered)
     */
    public TypeDescriptor<?> get(String name);

    /**
     * Adds an instantiator.
     * 
     * @param name the name of the instantiator
     * @param type the type to be added
     */
    public void addInstantiator(String name, TypeDescriptor<? extends IVilType> type);
    
    /**
     * Returns whether the instantiator given by <code>name</code> is already registered.
     * 
     * @param name the name of the instantiator
     * @return <code>true</code> if it was registered, <code>false</code> else
     */
    public boolean containsInstantiator(String name);

}
