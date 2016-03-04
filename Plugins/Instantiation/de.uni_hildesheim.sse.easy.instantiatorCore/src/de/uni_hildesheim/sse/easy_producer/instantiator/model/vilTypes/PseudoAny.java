package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * A type which can be assigned to any type.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = "Any")
final class PseudoAny implements IVilType {
    
    /**
     * Prevents external instantiation.
     */
    private PseudoAny() {
    }
    
    /**
     * Represents the equality operation for Strings.
     * 
     * @param s1 the first boolean to be considered
     * @param s2 the second boolean to be considered
     * @return s1 == s2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(Object s1, Object s2) {
        return (s1 == null && s2 == null) || (s1 != null && s1.equals(s2));
    }
    
    /**
     * Represents the unequality operation for Strings.
     * 
     * @param s1 the first boolean to be considered
     * @param s2 the second boolean to be considered
     * @return s1 != s2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(Object s1, Object s2) {
        return (s1 == null && s2 == null) || (s1 != null && !s1.equals(s2));
    }
    
}
