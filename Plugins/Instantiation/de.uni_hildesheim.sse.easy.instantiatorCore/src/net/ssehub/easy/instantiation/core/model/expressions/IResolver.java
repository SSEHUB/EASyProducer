package net.ssehub.easy.instantiation.core.model.expressions;

/**
 * Defines the interface of a simple variable resolver. 
 * 
 * @param <V> the type of variable declarations
 * 
 * @author Holger Eichelberger
 */
public interface IResolver<V extends IResolvable> {

    /**
     * Resolves a variable.
     * 
     * @param name the name of the variable
     * @param local consider only the local scope or also outside nested scopes
     * @return the variable declaration or <b>null</b>
     */
    public V resolve(String name, boolean local);
    
    /**
     * Resolves an IVML element.
     * 
     * @param name the name to be resolved
     * @return the IVML element (value, containable model element), <b>null</b> else
     */
    public Object getIvmlElement(String name);
    
}
