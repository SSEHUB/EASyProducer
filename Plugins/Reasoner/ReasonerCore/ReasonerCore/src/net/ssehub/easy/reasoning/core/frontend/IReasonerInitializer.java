package net.ssehub.easy.reasoning.core.frontend;

import net.ssehub.easy.reasoning.core.reasoner.IReasoner;

/**
 * Used to specify the actual reasoner for test and to create a reasoner instance
 * if required. A reasoner implementation is supposed to implement this class for 
 * testing.
 * 
 * @author Holger Eichelberger
 */
public interface IReasonerInitializer {
    
    /**
     * Returns the name of the reasoner.
     * 
     * @return the name of the reasoner
     */
    public String getName();
    
    /**
     * Returns the version of the reasoner.
     * 
     * @return the version of the reasoner
     */
    public String getVersion();
    
    /**
     * Creates a new instance of the reasoner.
     * 
     * @return the new version
     */
    public IReasoner create();
}