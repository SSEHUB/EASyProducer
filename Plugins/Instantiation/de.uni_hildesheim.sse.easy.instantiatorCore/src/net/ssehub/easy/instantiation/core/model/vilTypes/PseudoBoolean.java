package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * A class representing the Boolean type.
 * 
 * @author Holger Eichelberger
 *
 */
@ClassEquivalentTo(Boolean.class)
@ClassMeta(name = Constants.TYPE_BOOLEAN)
public class PseudoBoolean implements IVilType {

    @DefaultValue
    public static final Boolean DEFAULT = false;
    
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
     * @return b1 &amp; b2
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

    /**
     * Represents the unequality operation for Booleans.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 != b2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(boolean b1, boolean b2) {
        return b1 != b2;
    }

    /**
     * Represents the Boolean "implies" operation.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 ^ b2
     */
    @OperationMeta(opType = OperationType.INFIX)
    public static boolean implies(boolean b1, boolean b2) {
        return !b1 || b2;
    }

    /**
     * Represents the Boolean "iff" operation.
     * 
     * @param b1 the first boolean to be considered
     * @param b2 the second boolean to be considered
     * @return b1 ^ b2
     */
    @OperationMeta(opType = OperationType.INFIX)
    public static boolean iff(boolean b1, boolean b2) {
        return (!b1 || b2) && (!b2 || b1);
    }

    /**
     * Returns the string value of <code>b0</code>.
     * 
     * @param b0 the boolean to be turned into a string
     * @return the string value
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static String toString(boolean b0) {
        return String.valueOf(b0);
    }

    /**
     * Returns the type of <code>value</code>. "Overrides" {@link PseudoAny#getType(Object)}.
     * 
     * @param value the Boolean to return the type for
     * @return the type of object (<b>null</b> if <code>ob</code> is <b>null</b>)
     */
    public static TypeDescriptor<?> getType(Boolean value) {
        return TypeRegistry.booleanType();
    }

}
