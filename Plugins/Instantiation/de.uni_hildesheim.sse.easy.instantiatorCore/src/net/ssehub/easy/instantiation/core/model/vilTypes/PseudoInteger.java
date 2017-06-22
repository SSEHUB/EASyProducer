package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * A pseudo integer type for VIL.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = Constants.TYPE_INTEGER, equiv = Integer.class, nAssign = PseudoReal.class)
public class PseudoInteger extends PseudoReal {

    @DefaultValue
    public static final Integer DEFAULT = 0;
    
    /**
     * Prevents external instantiation.
     */
    protected PseudoInteger() {
    }
    
    /**
     * Represents the addition for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 + i2
     */
    @OperationMeta(name = Constants.ADDITION, opType = OperationType.INFIX)
    public static int add(int i1, int i2) {
        return i1 + i2;
    }

    /**
     * Represents the subtraction for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 - i2
     */
    @OperationMeta(name = Constants.SUBTRACTION, opType = OperationType.INFIX)
    public static int subtract(int i1, int i2) {
        return i1 - i2;
    }

    /**
     * Represents the multiplication for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 * i2
     */
    @OperationMeta(name = Constants.MULTIPLICATION, opType = OperationType.INFIX)
    public static int multiplication(int i1, int i2) {
        return i1 * i2;
    }

    /**
     * Represents the division for integers with remainder.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 / i2 as real
     */
    @OperationMeta(name = Constants.DIVISION, opType = OperationType.INFIX)
    public static double division(int i1, int i2) {
        return i1 / ((double) i2);
    }

    /**
     * Represents the division for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 / i2 as integer
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static int div(int i1, int i2) {
        return i1 / i2;
    }

    /**
     * Represents the less-then comparison for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 < i2
     */
    @OperationMeta(name = Constants.LESS_THEN, opType = OperationType.INFIX)
    public static boolean lessThan(int i1, int i2) {
        return i1 < i2;
    }

    /**
     * Represents the less-then-equals comparison for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 <= i2
     */
    @OperationMeta(name = Constants.LESS_THEN_EQUALS, opType = OperationType.INFIX)
    public static boolean lessEqualThan(int i1, int i2) {
        return i1 <= i2;
    }

    /**
     * Represents the greater-then-equals comparison for integer.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 >= i2
     */
    @OperationMeta(name = Constants.GREATER_THEN_EQUALS, opType = OperationType.INFIX)
    public static boolean greaterEqualThan(int i1, int i2) {
        return i1 >= i2;
    }

    /**
     * Represents the greater comparison for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 >= i2
     */
    @OperationMeta(name = Constants.GREATER_THEN, opType = OperationType.INFIX)
    public static boolean greaterThan(int i1, int i2) {
        return i1 > i2;
    }

    /**
     * Represents the equality operation for integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 == i2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(int i1, int i2) {
        return i1 == i2;
    }
    
    /**
     * Represents the unequality operation for Integers.
     * 
     * @param i1 the first integer to be considered
     * @param i2 the second integer to be considered
     * @return i1 != i2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(int i1, int i2) {
        return i1 != i2;
    }

    /**
     * Negates the given integer value.
     * 
     * @param i0 the integer to be negated
     * @return -i0
     */
    @OperationMeta(name = {Constants.SUBTRACTION }, opType = OperationType.PREFIX)
    public static int negates(int i0) {
        return -i0;
    }

    /**
     * Returns the absolute value of the given integer value.
     * 
     * @param i0 the integer the absolute value shall be returned for
     * @return |i0|
     */
    @OperationMeta(name = "abs", opType = OperationType.FUNCTION)
    public static int intAbs(int i0) {
        return Math.abs(i0);
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static double convert(int val) {
        return val;
    }

    /**
     * Returns the modulo value of <code>i1</code> and <code>i2</code>.
     * 
     * @param i1 the first value to be considered
     * @param i2 the first value to be considered
     * @return i1 % i2
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static int mod(int i1, int i2) {
        return i1 % i2;
    }

    /**
     * Returns the minimum value of <code>i1</code> and <code>i2</code>.
     * 
     * @param i1 the first value to be considered
     * @param i2 the first value to be considered
     * @return min(i1, i2)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static int min(int i1, int i2) {
        return Math.min(i1, i2);
    }

    /**
     * Returns the maximum value of <code>i1</code> and <code>i2</code>.
     * 
     * @param i1 the first value to be considered
     * @param i2 the first value to be considered
     * @return max(i1, i2)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static int max(int i1, int i2) {
        return Math.max(i1, i2);
    }

    /**
     * Returns the string value of <code>i0</code>.
     * 
     * @param i0 the int to be turned into a string
     * @return the string value
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static String toString(int i0) {
        return String.valueOf(i0);
    }

    /**
     * Returns the type of <code>value</code>. "Overrides" {@link PseudoAny#getType(Object)}.
     * 
     * @param value the Integer to return the type for
     * @return the type of object (<b>null</b> if <code>ob</code> is <b>null</b>)
     */
    public static TypeDescriptor<?> getType(Integer value) {
        return TypeRegistry.integerType();
    }

}
