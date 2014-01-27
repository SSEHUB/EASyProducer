package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;

/**
 * Defines the type of a runtime environment to evaluate expressions in.
 * 
 * @author Holger Eichelberger
 */
public interface IRuntimeEnvironment {

    /**
     * Returns the value of <code>resolvable</code>.
     * 
     * @param resolvable the resolvable 
     * @return the value of <code>resolvable</code>
     * @throws ExpressionException in case that <code>resolvable</code> was not defined
     */
    public Object getValue(IResolvable resolvable) throws ExpressionException;
    
    /**
     * Returns the value of the IVML element denoted by <code>name</code> in the closest scope defining
     * an IVML configuration.
     * 
     * @param name the name
     * @return the value
     * @throws ExpressionException in case that <code>name</code> was not defined
     */
    public Object getIvmlValue(String name) throws ExpressionException;

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
     * @throws VilLanguageException in case of an attempt of modifying a constant
     */
    public void setValue(IResolvable var, Object object) throws VilLanguageException;

}
