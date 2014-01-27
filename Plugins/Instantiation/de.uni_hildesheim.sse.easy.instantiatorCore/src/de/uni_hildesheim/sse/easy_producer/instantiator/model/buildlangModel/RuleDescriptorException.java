package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * Defines a specific exception for failing rule conditions carrying the index of the 
 * failing expression.
 * 
 * @author Holger Eichelberger
 */
public class RuleDescriptorException extends AbstractException {

    public static final int ID_RULE_MISMATCH = 79990;

    /**
     * For serialization.
     */
    private static final long serialVersionUID = -6133161535416122432L;

    private int index;

    /**
     * Creates a new rule condition exception.
     * 
     * @param message the message
     * @param index the index of the failing expression
     */
    public RuleDescriptorException(String message, int index) {
        super(message, ID_RULE_MISMATCH);
        this.index = index;
    }

    /**
     * Creates a new rule condition exception.
     * 
     * @param exception the exception to take message and id from
     * @param index the index of the failing expression
     */
    public RuleDescriptorException(AbstractException exception, int index) {
        super(exception);
        this.index = index;
    }
    
    /**
     * Returns the index of the failing expression.
     * 
     * @return the index
     */
    public int getIndex() {
        return index;
    }
    
}
