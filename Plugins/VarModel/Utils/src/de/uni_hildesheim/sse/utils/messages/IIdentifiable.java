package de.uni_hildesheim.sse.utils.messages;

/**
 * An identifiable (to be implemented by exceptions).
 * 
 * @author Holger Eichelberger
 */
public interface IIdentifiable  {
    
    /**
     * Returns a numerical identifier representing the
     * actual {@link #getMessage() message}. This identifier is used 
     * for asserting exceptions in tests.
     * 
     * @return the identifier
     */
    public int getId();

    /**
     * Returns the actual message.
     * 
     * @return the message
     */
    public String getMessage();
    
}
