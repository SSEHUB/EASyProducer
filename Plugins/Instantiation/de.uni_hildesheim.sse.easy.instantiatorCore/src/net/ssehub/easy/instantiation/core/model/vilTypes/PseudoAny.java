package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.basics.DefaultLocale;

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
     * Represents the equality operation for Objects.
     * 
     * @param o1 the object boolean to be considered
     * @param o2 the object boolean to be considered
     * @return o1 == o2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(Object o1, Object o2) {
        return (o1 == null && o2 == null) || (o1 != null && o1.equals(o2));
    }
    
    /**
     * Represents the unequality operation for Objects.
     * 
     * @param o1 the first object to be considered
     * @param o2 the second object to be considered
     * @return o1 != o2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(Object o1, Object o2) {
        return (o1 == null && o2 == null) || (o1 != null && !o1.equals(o2));
    }

    /**
     * Converts object to real if possible.
     * 
     * @param ob the object
     * @return the real value or <b>null</b>
     */
    @Conversion
    public static Double convertToReal(Object ob) {
        Double result;
        if (ob instanceof Double) {
            result = (Double) ob;
        } else if (ob instanceof Integer) {
            result = ((Integer) ob).doubleValue();
        } else if (ob instanceof String) {
            result = PseudoString.toReal(ob.toString());
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts object to int if possible.
     * 
     * @param ob the object
     * @return the int value or <b>null</b>
     */
    @Conversion
    public static Integer convertToInt(Object ob) {
        Integer result;
        if (ob instanceof Double) {
            result = ((Double) ob).intValue();
        } else if (ob instanceof Integer) {
            result = (Integer) ob;
        } else if (ob instanceof String) {
            result = PseudoString.toInteger(ob.toString());
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts object to boolean if possible.
     * 
     * @param ob the object
     * @return the boolean value or <b>null</b>
     */
    @Conversion
    public static Boolean convertToBool(Object ob) {
        Boolean result;
        if (ob instanceof Boolean) {
            result = (Boolean) ob;
        } else if (ob instanceof String) {
            result = PseudoString.toBoolean(ob.toString());
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the current (global) locale.
     * 
     * @param ob the object to return the current locale for (ignored, needed to assign this to Any)
     * @return the current locale
     */
    public static String getLocale(Object ob) {
        return DefaultLocale.toString(PseudoString.getCurrentLocale());
    }

    /**
     * Changes the current (global) locale.
     * 
     * @param ob the object to return the current locale for (ignored, needed to assign this to Any)
     * @param locale the new (global) locale
     * @return the (new) current locale
     */
    @OperationMeta(name = "locale")
    public static String setLocale(Object ob, String locale) {
        return DefaultLocale.toString(PseudoString.setCurrentLocale(DefaultLocale.toLocale(locale)));
    }

}
