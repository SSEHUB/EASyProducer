package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Defines the type of a runtime environment to evaluate expressions in.
 * 
 * @author Holger Eichelberger
 */
public interface IRuntimeEnvironment {

    /**
     * Returns the (local) type registry of this runtime environment.
     * 
     * @return the type registry
     */
    public TypeRegistry getTypeRegistry();
    
    /**
     * Returns the value of <code>resolvable</code>.
     * 
     * @param resolvable the resolvable 
     * @return the value of <code>resolvable</code>
     * @throws VilException in case that <code>resolvable</code> was not defined
     */
    public Object getValue(IResolvable resolvable) throws VilException;
    
    /**
     * Returns the value of the IVML element denoted by <code>name</code> in the closest scope defining
     * an IVML configuration.
     * 
     * @param name the name
     * @return the value
     * @throws VilException in case that <code>name</code> was not defined
     */
    public Object getIvmlValue(String name) throws VilException;

    /**
     * Returns the resolvable of name <code>name</code> if defined.
     * 
     * @param name the name of the variable
     * @return the variable or <b>null</b> if not found
     */
    public IResolvable get(String name);
    
    /**
     * Changes the value of <code>var</code> where it is defined.
     * 
     * @param var the variable to be modified
     * @param object the value of <code>var</code>
     * @throws VilException in case of an attempt of modifying a constant
     */
    public void setValue(IResolvable var, Object object) throws VilException;

    /**
     * Returns the search paths of the current context.
     * 
     * @return the (qualified) search paths (may be <b>null</b>)
     */
    public String[] getContextPaths();

    /**
     * Stores the artifacts in the current context.
     * 
     * @throws VilException in case that storing artifacts fails
     */
    public void storeArtifacts() throws VilException;

}
