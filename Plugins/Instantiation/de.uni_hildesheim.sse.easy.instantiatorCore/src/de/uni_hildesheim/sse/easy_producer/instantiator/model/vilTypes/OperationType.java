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
    NORMAL,
    
    /**
     * As infix operator.
     */
    INFIX,
    
    /**
     * As prefix operator.
     */
    PREFIX,
    
    /**
     * As postfix operator.
     */
    POSTFIX,
    
    /**
     * In function notation, i.e., name(args).
     */
    FUNCTION;
    
}
