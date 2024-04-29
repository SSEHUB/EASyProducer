package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * Just a type for types. {@link TypeDescriptor} is also considered equivalent
 * to {@link PseudoType} and <i>Class</i> for convenience of writing artifacts
 * and types. This is handled by explicit type conversion before a call.
 * 
 * @author Holger Eichelberger
 */
@ClassEquivalentTo({Class.class, TypeDescriptor.class})
@ClassMeta(name = "Type")
public final class PseudoType implements IVilType {

    /**
     * Prevents external instantiation.
     */
    private PseudoType() {
    }
    
    /**
     * Returns the type of <code>value</code>. "Overrides" {@link PseudoAny#getType(Object)}.
     * 
     * @param value the type to return the type for
     * @return the type of object (<b>null</b> if <code>ob</code> is <b>null</b>)
     */
    public static TypeDescriptor<?> getType(TypeDescriptor<?> value) {
        return TypeRegistry.typeType();
    }

    /**
     * Represents the equality operation for types vs. Strings (legacy). Use simple or
     * qualified name of type for comparison.
     * 
     * @param type the type to compare
     * @param string the string to compare
     * @return string == type.getName() || string == type.getQualifiedName()
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(TypeDescriptor<?> type, String string) {
        return PseudoString.equals(string, type);
    }

    /**
     * Represents the un-equality operation for types vs. Strings (legacy). Use simple or
     * qualified name of type for comparison.
     * 
     * @param type the type to compare
     * @param string the string to compare
     * @return <code>string != type.getName() &amp;&amp; string != type.getQualifiedName()</code>
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS}, opType = OperationType.INFIX)
    public static boolean notEquals(TypeDescriptor<?> type, String string) {
        return !PseudoString.equals(string, type);
    }

    /**
     * Represents the equality operation for types.
     * 
     * @param type1 the first type to compare
     * @param type2 the second type to compare
     * @return type1 != type2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(TypeDescriptor<?> type1, TypeDescriptor<?> type2) {
        return type1.isSame(type2);
    }

    /**
     * Represents the un-equality operation for types.
     * 
     * @param type1 the first type to compare
     * @param type2 the second type to compare
     * @return type1 != type2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS}, opType = OperationType.INFIX)
    public static boolean notEquals(TypeDescriptor<?> type1, TypeDescriptor<?> type2) {
        return !type1.isSame(type2);
    }

    /**
     * Turns a descriptor into its name (legacy).
     * 
     * @param type the type
     * @return the name
     */
    @Conversion
    public static String toString(TypeDescriptor<?> type) {
        return type.getName();
    }

    /**
     * Returns the name of <code>type</code>.
     * 
     * @param type the type
     * @return the name of <code>type</code>
     */
    public static String getName(TypeDescriptor<?> type) {
        return type.getName();
    }

    /**
     * Returns the qualified name of <code>type</code>.
     * 
     * @param type the type
     * @return the qualified name of <code>type</code>
     */
    public static String getQualifiedName(TypeDescriptor<?> type) {
        return type.getQualifiedName();
    }

    /**
     * Returns whether <code>type</code> is of the same type as <code>ob</code>. This 
     * method may be "override" by more specific types that cannot be obtained from the default type factory.
     * 
     * @param ob the object to determine the type for
     * @param type the type to compare with
     * @return <code>true</code> if <code>type</code> is of the same type as <code>ob</code>, 
     *   <code>false</code> else
     */
    public static boolean isTypeOf(Object ob, TypeDescriptor<?> type) {
        return type.isSame(PseudoAny.getType(ob));
    }

    /**
     * Returns whether <code>type</code> is of the same or a super type as <code>ob</code>. This 
     * method may be "override" by more specific types that cannot be obtained from the default type factory.
     * 
     * @param ob the object to determine the type for
     * @param type the type to compare with
     * @return <code>true</code> if <code>type</code> is of the same or a super type as <code>ob</code>, 
     *   <code>false</code> else
     */
    public static boolean isKindOf(Object ob, TypeDescriptor<?> type) {
        boolean result;
        TypeDescriptor<?> realType = TypeRegistry.realType();
        TypeDescriptor<?> obType = PseudoAny.getType(ob);
        if (type == realType) {
            TypeDescriptor<?> intType = TypeRegistry.integerType();
            result = (obType == realType || obType == intType);
        } else {
            result = type.isAssignableFrom(obType);
        }
        return result;
    }
    
    /**
     * Provides access to all instances of this type in the configuration.
     * 
     * @param type the type to return all instances for
     * @return all instances
     */
    @ReturnGenerics(IVilType.class)
    @OperationMeta(useOperandTypeAsParameter = true, opType = OperationType.FUNCTION)
    public static Set<?> allInstances(TypeDescriptor<?> type) {
        Set<?> result = type.allInstances();
        if (null == result) {
            result = new ArraySet<Object>(new Object[0], type);
        }
        return result;
    }

}
