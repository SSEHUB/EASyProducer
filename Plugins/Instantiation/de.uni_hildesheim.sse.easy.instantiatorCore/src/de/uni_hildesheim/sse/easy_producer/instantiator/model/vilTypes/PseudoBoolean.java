package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * A class representing the Boolean type.
 * 
 * @author Holger Eichelberger
 *
 */
@ClassMeta(name = Constants.TYPE_BOOLEAN, equiv = Boolean.class)
public class PseudoBoolean implements IVilType {

    /**
     * Prevents external instantiation.
     */
    protected PseudoBoolean() {
    }
    
    /**
     * Represents the Boolean "and" operation.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 & b2
     */
    @OperationMeta(opType = OperationType.INFIX)
    public static boolean and(boolean b1, boolean b2) {
        return b1 & b2;
    }

    /**
     * Represents the Boolean "or" operation.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 | b2
     */
    @OperationMeta(opType = OperationType.INFIX)
    public static boolean or(boolean b1, boolean b2) {
        return b1 | b2;
    }

    /**
     * Represents the Boolean "xor" operation.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 ^ b2
     */
    @OperationMeta(opType = OperationType.INFIX)
    public static boolean xor(boolean b1, boolean b2) {
        return b1 ^ b2;
    }

    /**
     * Represents the Boolean "or" operation.
     * 
     * @param val the boolean to be negated
     * @return !val
     */
    @OperationMeta(name = {Constants.NEGATION, Constants.NEGATION_ALIAS }, opType = OperationType.PREFIX)
    public static boolean not(boolean val) {
        return !val;
    }
    
    /**
     * Represents the equality operation for Booleans.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 == b2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(boolean b1, boolean b2) {
        return b1 == b2;
    }

    // TODO complete operations

}
