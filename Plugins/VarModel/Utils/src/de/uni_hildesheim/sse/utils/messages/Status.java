package de.uni_hildesheim.sse.utils.messages;


/**
 * Defines basic message types for messages.
 * 
 * @author Holger Eichelberger
 */
public enum Status implements IStatus {

    /**
     * Status for informations that something (not bad) happened.
     */
    INFO,
    
    /**
     * Error message type.
     */
    ERROR,
    
    /**
     * Warning message type.
     */
    WARNING,
    
    /**
     * Some element or semantics is not supported.
     */
    UNSUPPORTED

}
