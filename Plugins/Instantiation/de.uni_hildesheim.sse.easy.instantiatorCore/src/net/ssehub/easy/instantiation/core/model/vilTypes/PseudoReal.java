package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * Implements a pseudo class for reals.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = Constants.TYPE_REAL, equiv = Double.class)
public class PseudoReal implements IVilType {

    /**
     * Prevents external instantiation.
     */
    protected PseudoReal() {
    }
    
    /**
     * Represents the addition for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 + r2
     */
    @OperationMeta(name = Constants.ADDITION, opType = OperationType.INFIX)
    public static double add(double r1, double r2) {
        return r1 + r2;
    }

    /**
     * Represents the subtraction for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 - r2
     */
    @OperationMeta(name = Constants.SUBTRACTION, opType = OperationType.INFIX)
    public static double subtract(double r1, double r2) {
        return r1 - r2;
    }

    /**
     * Represents the multiplication for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 * r2
     */
    @OperationMeta(name = Constants.MULTIPLICATION, opType = OperationType.INFIX)
    public static double multiplication(double r1, double r2) {
        return r1 * r2;
    }

    /**
     * Represents the division for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 / r2
     */
    @OperationMeta(name = Constants.DIVISION, opType = OperationType.INFIX)
    public static double division(double r1, double r2) {
        return r1 / r2;
    }

    /**
     * Represents the less-than comparison for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 < r2
     */
    @OperationMeta(name = Constants.LESS_THEN, opType = OperationType.INFIX)
    public static boolean lessThan(double r1, double r2) {
        return r1 < r2;
    }

    /**
     * Represents the less-then-equals comparison for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 <= r2
     */
    @OperationMeta(name = Constants.LESS_THEN_EQUALS, opType = OperationType.INFIX)
    public static boolean lessEqualThen(double r1, double r2) {
        return r1 <= r2;
    }

    /**
     * Represents the greater-then-equals comparison for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 >= r2
     */
    @OperationMeta(name = Constants.GREATER_THEN_EQUALS, opType = OperationType.INFIX)
    public static boolean greaterEqualThen(double r1, double r2) {
        return r1 >= r2;
    }

    /**
     * Represents the greater comparison for reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 >= r2
     */
    @OperationMeta(name = Constants.GREATER_THEN, opType = OperationType.INFIX)
    public static boolean greaterThan(double r1, double r2) {
        return r1 > r2;
    }
    
    /**
     * Represents the equality operation for Reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 == r2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(double r1, double r2) {
        return r1 == r2;
    }
    
    /**
     * Represents the unequality operation for Reals.
     * 
     * @param r1 the first real to be considered
     * @param r2 the second real to be considered
     * @return r1 != r2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(double r1, double r2) {
        return r1 != r2;
    }

    /**
     * Negates the given real value.
     * 
     * @param r0 the real to be negated
     * @return -r0
     */
    @OperationMeta(name = {Constants.SUBTRACTION }, opType = OperationType.PREFIX)
    public static double negates(double r0) {
        return -r0;
    }

    /**
     * Returns the absolute value of the given real value.
     * 
     * @param r0 the real the absolute value shall be returned for
     * @return |r0|
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static double abs(double r0) {
        return Math.abs(r0);
    }

    /**
     * Returns whether the given real value is not a number.
     * 
     * @param r0 the real the absolute value to be considered
     * @return <code>true</code> if <code>r0</code> is not a number, <code>false</code> else
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static boolean isNaN(double r0) {
        return Double.isNaN(r0);
    }
    
    /**
     * Returns whether the given real value is finite.
     * 
     * @param r0 the real the absolute value to be considered
     * @return <code>true</code> if <code>r0</code> is finite, <code>false</code> else
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static boolean isFinite(double r0) {
        // SE: following function exists only since Java 1.8
        // Double.isFinite(r0);
        return Math.abs(r0) <= Double.MAX_VALUE;
    }
    
    /**
     * Returns whether the given real value is infinite.
     * 
     * @param r0 the real the absolute value to be considered
     * @return <code>true</code> if <code>r0</code> is infinite, <code>false</code> else
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static boolean isInfinite(double r0) {
        return Double.isInfinite(r0);
    }

    /**
     * Returns the largest integer that is less than or equal to r0.
     * 
     * @param r0 the real value to be considered
     * @return floor(r0)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static int floor(double r0) {
        return (int) Math.floor(r0);
    }

    /**
     * Returns the integer that is closest to r0.
     * 
     * @param r0 the real value to be considered
     * @return ceil(r0)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static int ceil(double r0) {
        return (int) Math.ceil(r0);
    }
    
    // TODO complete operations

}
