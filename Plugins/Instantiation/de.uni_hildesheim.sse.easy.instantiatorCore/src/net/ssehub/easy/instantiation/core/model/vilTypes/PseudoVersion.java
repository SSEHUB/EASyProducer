package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.basics.modelManagement.Version;

/**
 * Represents the internal type "Version".
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(equiv = Version.class)
final class PseudoVersion implements IVilType {

    /**
     * Prevents external instantiation.
     */
    private PseudoVersion() {
    }
    
    /**
     * Represents the less-then comparison for versions.
     * 
     * @param v1 the first version to be considered
     * @param v2 the second version to be considered
     * @return v1 < v2
     */
    @OperationMeta(name = Constants.LESS_THEN, opType = OperationType.INFIX)
    public static boolean lessThan(Version v1, Version v2) {
        return Version.compare(v1, v2) < 0;
    }

    /**
     * Represents the less-then-equals comparison for versions.
     * 
     * @param v1 the first version to be considered
     * @param v2 the second version to be considered
     * @return v1 <= v2
     */
    @OperationMeta(name = Constants.LESS_THEN_EQUALS, opType = OperationType.INFIX)
    public static boolean lessEqualThan(Version v1, Version v2) {
        return Version.compare(v1, v2) <= 0;
    }

    /**
     * Represents the greater-then-equals comparison for versions.
     * 
     * @param v1 the first version to be considered
     * @param v2 the second version to be considered
     * @return v1 >= v2
     */
    @OperationMeta(name = Constants.GREATER_THEN_EQUALS, opType = OperationType.INFIX)
    public static boolean greaterEqualThan(Version v1, Version v2) {
        return Version.compare(v1, v2) >= 0;
    }

    /**
     * Represents the greater comparison for versions.
     * 
     * @param v1 the first version to be considered
     * @param v2 the second version to be considered
     * @return v1 >= v2
     */
    @OperationMeta(name = Constants.GREATER_THEN, opType = OperationType.INFIX)
    public static boolean greaterThan(Version v1, Version v2) {
        return Version.compare(v1, v2) > 0;
    }

    /**
     * Represents the equality operation for versions.
     * 
     * @param v1 the first version to be considered
     * @param v2 the second version to be considered
     * @return v1 == v2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(Version v1, Version v2) {
        return Version.compare(v1, v2) == 0;
    }
    
    /**
     * Represents the unequality operation for versions.
     * 
     * @param v1 the first version to be considered
     * @param v2 the second version to be considered
     * @return v1 != v2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(Version v1, Version v2) {
        return Version.compare(v1, v2) != 0;
    }

    /**
     * Returns the type of <code>value</code>. "Overrides" {@link PseudoAny#getType(Object)}.
     * 
     * @param value the version to return the type for
     * @return the type of object (<b>null</b> if <code>ob</code> is <b>null</b>)
     */
    public static TypeDescriptor<?> getType(Version value) {
        return TypeRegistry.versionType();
    }

}
