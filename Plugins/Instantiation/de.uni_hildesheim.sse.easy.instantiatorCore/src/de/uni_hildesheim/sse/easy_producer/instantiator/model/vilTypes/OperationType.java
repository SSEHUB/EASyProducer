package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Defines the operation / operator types.
 * 
 * @author Holger Eichelberger
 */
public enum OperationType {

    /**
     * Only normal operation calls (first parameter prefix, first parameter as parameter).
     */
    NORMAL(true),
    
    /**
     * As infix operator.
     */
    INFIX(false),
    
    /**
     * As prefix operator.
     */
    PREFIX(false),
    
    /**
     * As postfix operator.
     */
    POSTFIX(false),
    
    /**
     * In function notation, i.e., name(args).
     */
    FUNCTION(true);
    
    private boolean trace;
    
    /**
     * Creates an enum constant with additional information whether the characterized operation shall be traced.
     * 
     * @param trace whether the operation type shall be traced
     */
    private OperationType(boolean trace) {
        this.trace = trace;
    }
    
    /**
     * Returns whether the operation type shall be traced.
     * 
     * @return <code>true</code> if the operation type shall be traced, <code>false</code> else
     */
    public boolean trace() {
        return trace;
    }
    
}
