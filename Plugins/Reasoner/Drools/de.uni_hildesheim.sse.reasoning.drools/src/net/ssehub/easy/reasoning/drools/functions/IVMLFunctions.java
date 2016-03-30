package net.ssehub.easy.reasoning.drools.functions; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;

/**
 * This class contains additional functions to support IVML operations.
 * @author Phani
 * @author Roman Sizonenko
 *
 */
public class IVMLFunctions {
    
    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(IVMLFunctions.class,
            "de.uni_hildesheim.sse.reasoning.drools");
    
    private static int pre = 0;
    private static int ins = 0;
    
    /**
     * Implementation for IVML operation min.
     * @param first Parameter one.
     * @param second Parameter two.
     * @return Minimum of two.
     */
    public static int min(int first, int second) {
 
        int result = 0;
        if (first < second) {
            result = first;
        } else {
            result = second;
        }
        
        return result;
    }
    
    
    /**
     * Implementation for IVML operation max.
     * @param first Parameter one.
     * @param second Parameter two.
     * @return Minimum of two.
     */
    public static int max(int first, int second) {
        int result = 0;
        if (first > second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for IVML operation min for real values.
     * @param first Parameter one.
     * @param second Parameter two.
     * @return Minimum of two.
     */
    public static double min(double first, double second) {
        double result = 0.0;
        if (first < second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for IVML operation max for real values.
     * @param first Parameter one.
     * @param second Parameter two.
     * @return Minimum of two.
     */
    public static double max(double first, double second) {
        double result = 0.0;
        if (first > second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
//    /**
//     * Implementation for IVML operation min for real values.
//     * @param first Parameter one.
//     * @param second Parameter two.
//     * @return Minimum of two.
//     */
//    public static double min(double first, int second) {
//        double result = 0.0;
//        if (first < (int) second) {
//            result = first;
//        } else {
//            result = second;
//        }
//        return result;
//    }
//    
//    /**
//     * Implementation for IVML operation max for real values.
//     * @param first Parameter one.
//     * @param second Parameter two.
//     * @return Minimum of two.
//     */
//    public static double max(double first, int second) {
//        double result = 0.0;
//        if (first > (int) second) {
//            result = first;
//        } else {
//            result = second;
//        }
//        return result;
//    }
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(Object first, Object second) {
        boolean result = true;
        boolean b1 = first == null; 
        boolean b2 = second == null;
        if (second instanceof Double) {
            double x = ((Double) second).doubleValue();
            double y = Math.round(x * 100.0) / 100.0;
            second = new Double(y);
            result = !first.equals(second);
        } else if (first instanceof Double) {
            double x = ((Double) first).doubleValue();
            double y = Math.round(x * 100.0) / 100.0;
            first = new Double(y);
            result = !first.equals(second);
        } else {
            if ((b1 || b2) && !(b1 && b2)) {
                result = true;
            } else if (b1 && b2) {
                result = false;
            } else {
                result = !first.toString().equals(second.toString());
            }
        }
        System.out.println("first " + first + "; second " + second + ";result " + result);
        return result;
    }
    
    
    
    
//    public static boolean uneq(List l1, List l2) {
//        logger.info(" ... " + l1.equals(l2));
//        logger.info("l1 and l2 " + l1 + " \n\t " + l2);
//        return true;
//    }
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(int first, int second) {
        return (first != second);
    }
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return result <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(double first, Number second) {
        
//        logger.info("first and second are " + first + " --- " + number);
        
        boolean result = false;
        result = first != second.doubleValue();
        return result;
        
    }
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return result <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(int first, Number second) {
        boolean result = false;
        result = first != second.intValue();
        return result;
        
    }
   
    /**
     * Implementation for IVML operation <> .
     * @param second Parameter two.
     * @param first Parameter one.
     * @return result <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(Number second, double first) {
        boolean result = false;
        result = first != second.doubleValue();
        return result;
        
    }
    
    /**
     * Implementation for IVML operation <> .
     * @param second Parameter two.
     * @param first Parameter one.
     * @return result <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(Number second, int first) {
        boolean result = false;
        result = first != second.intValue();
        return result;
        
    }
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(int first, double second) {
        return (first != (int) second);
    }
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(double first, double second) {
        return (first != second);
    }
    
    
    
    /**
     * Implementation for IVML operation <> .
     * @param first Parameter one.
     * @param second Parameter two.
     * @return <b>True</b> if the two parameters are not equal..
     */
    public static boolean uneq(double first, int second) {
        return (first != (double) second);
    }
    
    
    /**
     * Implementation for IVML operation notEquals.
     * @param first boolean parameter.
     * @param second boolean parameter.
     * @return <b>True</b> if the two parameters are not equal.
     */
    public static boolean uneq(boolean first, boolean second) {        
        return (first != second);
    }
    
//    /**
//     * Implementation for IVML operation div .
//     * @param first Parameter one.
//     * @param second Parameter two.
//     * @return division (a double value)
//     */
//    public static double div(double first, int second) {
//        if (second == 0) {
//            return 0;
//        }
//        return (double) (first / second);
//    }
//    
//    
//    /**
//     * Implementation for IVML operation div .
//     * @param first Parameter one.
//     * @param second Parameter two.
//     * @return division (a double value)
//     */
//    public static double div(int first, double second) { 
//        if (second == 0) {
//            return 0;
//        }
//        return (double) (first / second);
//    }
//    
//    /**
//     * Implementation for IVML operation div .
//     * @param first Parameter double.
//     * @param second Parameter double.
//     * @return division (a double value)
//     */
//    public static double div(double first, double second) { 
//        if (second == 0) {
//            return 0;
//        }        
//        return (double) (first / second);        
//    }
//    
//    /**
//     * Implementation for IVML operation div .
//     * @param first Parameter one.
//     * @param second Parameter two.
//     * @return division (a double value)
//     */
//    public static double div(int first, int second) {
//        if (second == 0) {
//            return 0;
//        }
//        return (double) (first / second);
//    }    
//   
//    
    
    /**
     * Implementation for IVML operations abs.
     * @param number parameter.
     * @return absolute value.
     */
    public static int abs(int number) {
        
        return Math.abs(number);
    }
    
    /**
     * Implementation for IVML operations abs.
     * @param number parameter (int).
     * @return absolute value.
     */
    public static double abs(double number) {
        
        return Math.abs(number);
    }
    
//    /**
//    * Implementation for the operation minus.
//    * @param first first number..
//    * @param second second number.
//    * @return minus, an integer.
//    */
//    public static int minus(int first, int second) {
//        return (first - second);
//    }
//    
//    /**
//     * Implementation for the operation minus.
//     * @param first first number..
//     * @param second second number.
//     * @return minus, a double value.
//     */
//    public static double minus(double first, double second) {
//        return (first - second);
//    }
//    
//    /**
//     * Implementation for the operation minus.
//     * @param first first number (int).
//     * @param second second number (real). 
//     * @return minus, a real value.
//     */
//    public static double minus(int first, double second) {
//        return (first - second);
//    }
//    
//    /**
//     * Implementation for the operation minus.
//     * @param first first number.
//     * @param second second number (int).
//     * @return minus, a real value.
//     */
//    public static double minus(double first, int second) {
//        return (first - second);
//    }
//    
    
    
    
    /**
     * Implementation for the operation inverse (-).
     * @param number parameter (int).
     * @return Inverse, an integer.
     */
    public static int minus(int number) {
        
        return (int) Math.pow(number, -1);
    }
    
    /**
     * Implementation for the operation inverse (-).
     * @param number parameter (double).
     * @return Inverse, an integer.
     */
    public static double minus(double number) {
        
        return Math.pow(number, -1);
    }
    
    /**
     * Implementation for IVML operation mod.
     * @param first first parameter.
     * @param second second parameter.
     * @return modulus, an integer value.
     */
    public static int mod(int first, int second) {
        int mod = first % second;
        return mod;
    }
    
    /**
     * Implementation for IVML operation mod.
     * @param first first parameter.
     * @param second second parameter (double).
     * @return modulus, a double value.
     */
    public static double mod(int first, double second) {
        //logger.info("firsta nd second " + first + "___" + second);
        double mod = first % second;
        //logger.info("mod is " + mod);
        return mod;
    }
    
    
    /**
     * Implementation for the operation floor.  
     * @param number parameter.
     * @return floor of the number (integer).
     */
    public static int floor(double number) {
        return (int) Math.floor(number);
    }
    
    /**
     * Implementation for IVML operation round.     
     * @param number parameter.
     * @return round (integer).
     */
    public static int round(double number) {
        return (int) Math.round(number);
    }
    
    /**
     * Implementation for the operation XOR.
     * @param param1 The first parameter.
     * @param param2 The second parameter.
     * @return returns the XOR of the two passed params.
     */
    public static boolean xor(boolean param1, boolean param2) {
        boolean result;
        if (param1 == param2) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
    
    /**
     * Implementation for the operation XNOR.
     * @param param1 The first parameter.
     * @param param2 The second parameter.
     * @return returns the XNOR of the two passed parameters.
     */
    public static boolean iff(boolean param1, boolean param2) {
        
        boolean result;
        if (param1 == param2) {
            result = true;
        } else {
            result = false;
        }
        return result;
        
    }
    
    /**
     * Implementation for the IVML operation size.
     * @param str String.
     * @return Size of the string.
     */
    public static int size(String str) {
        return str.length();
    }
    
    /**
     * Implementation for the IVML operation size.
     * This function is implemented to mitigate the problem with Mvel strict mode.
     * @param ob Object, which is a string
     * @return Size of the string.
     */
    public static int size(Object ob) {
        int result = -1;
        if (ob instanceof String) {
            result = ((String) ob).length();
        }
        return result;
    }
    
    /**
     * Implementation for the IVML operation size.
     * @param list List.
     * @return Size of the list.
     */
    @SuppressWarnings("rawtypes") 
    public static int size(List list) {
        int result = -1;
        if (list != null) {
            result = list.size();
        }
        return result;
    }
    
    /**
     * Implementation for the IVML operation size.
     * @param set Set..
     * @return Size of the list.
     */
    @SuppressWarnings("rawtypes") 
    public static int size(Set set) {
        int result = -1;
        if (set != null) {
            result = set.size();
        }
        return result;
    }
    
    
    /**
     * Implementation for the IVML operation toInteger.
     * @param str String.
     * @return Integer value of the string.
     */
    public static int toInteger(String str) {
        return Integer.valueOf(str);
    }
    
    /**
     * Implementation for the IVML operation toInteger.
     * @param str String.
     * @return Real value of the string.
     */
    public static double toReal(String str) {
        return Double.valueOf(str);
    }
    
    /**
     * Implementation for IVML operation concat.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return Concatenated string.
     */
    public static String concat(String str1, String str2) {
        return str1.concat(str2);
    }
    
    /**
     * Implementation for IVML operation substitutes.
     * @param str1 Operand, string one
     * @param str2 Parameter one.
     * @param str3 Parameter Two.
     * @return Substituted string.
     */
    public static String substitutes(String str1, String str2, String str3) {
        str1 = str1.replaceAll(str2, str3);
        return str1;
    }
    
    /**
     * Implementation for the IVML operation substring.
     * @param str1 String.
     * @param initialIndex The beginning index.
     * @param endIndex The ending index.
     * @return The substring.
     */
    public static String substring(String str1, int initialIndex, int endIndex) {
        return str1.substring(initialIndex, endIndex);
    }
    
    /**
     * Implementation for the IVML operation matches.
     * @param str1 String.
     * @param str2 regular expression (regex).
     * @return <b>True</b> if the regex. matches the string.
     */
    public static boolean matches(String str1, String str2) {
        return str1.matches(str2);
    }
    
    /**
     * Implementation for IVML operation sum.
     * @param list List (sequence).
     * @return The sum of elements of the list.
     */
    @SuppressWarnings("rawtypes")
    public static Number sum(List list) {
        Number n = null;
        if (list.get(0) instanceof Integer) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += (Integer) list.get(i);
            }
            n = sum;
        } else if (list.get(0) instanceof Double) {
            double sum = 0.0;
            for (int i = 0; i < list.size(); i++) {
                sum += (Double) list.get(i);
            }
            n = sum;
        }
//        return n.doubleValue();
        return n;
    }
    
    
    
    
    /**
     * Implementation for IVML operation product.
     * @param list List (sequence).
     * @return The product of elements of the list.
     */
    @SuppressWarnings("rawtypes")
    public static Number product(List list) {
        Number n = null;
        if (list.get(0) instanceof Integer) {
            int product = (Integer) list.get(0);
            for (int i = 1; i < list.size(); i++) {
                product *= (Integer) list.get(i);
            }
            n = product;
        } else if (list.get(0) instanceof Double) {
            double product = (Double) list.get(0);
            for (int i = 1; i < list.size(); i++) {
                product *= (Double) list.get(i);
            }
            n = product;
        }
        
        return n;
    }
    
    /**
     * Implementation for IVML operation product.
     * @param set set.
     * @return The product of elements of the list.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Number product(Set set) {
        List list = new ArrayList();
        list.addAll(set);
        
        Number n = null;
        if (list.get(0) instanceof Integer) {
            int product = (Integer) list.get(0);
            for (int i = 1; i < list.size(); i++) {
                product *= (Integer) list.get(i);
            }
            n = product;
        } else if (list.get(0) instanceof Double) {
            double product = (Double) list.get(0);
            for (int i = 1; i < list.size(); i++) {
                product *= (Double) list.get(i);
            }
            n = product;
        }
        
        return n;
    }
    
    
    
    /**
     * Implementation for IVML operation avg (average).
     * @param list list List (sequence)..
     * @return Returns the average of elements of the list.
     */
    @SuppressWarnings("rawtypes")
    public static Number avg(List list) {
        Number avg = null;
        
        if (list.get(0) instanceof Integer) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += (Integer) list.get(i);
            }
            avg = sum / list.size();
        } else if (list.get(0) instanceof Double) {
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += (Double) list.get(i);
            }
            avg = sum / list.size();
        }
        
        return avg;
    }
    
    
    /**
     * Implementation for IVML operation avg (average).
     * @param set set..
     * @return Returns the average of elements of the set.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Number avg(Set set) {
        List list = new ArrayList();
        list.addAll(set);
        Number avg = null;
        if (list.get(0) instanceof Integer) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += (Integer) list.get(i);
            }
            avg = sum / list.size();
        } else if (list.get(0) instanceof Double) {
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += (Double) list.get(i);
            }
            avg = sum / list.size();
        }
        
        return avg;
    }
    
    
    
    
    /**
     * Implementation for the IVML operation min, element with the minimum value.. 
     * @param list list List (sequence).
     * @return Returns the minimum value contained in the list.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Number min(List list) {
        Number min = null;
        
        min = (Number) Collections.min(list);
        
        return min;
    }
    
    /**
     * Implementation for the IVML operation min.
     * @param set Set (set).
     * @return Returns the minimum value of the set.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object min(Set set) {
        return Collections.min(set);
    }
    
    /**
     * Implementation for the IVML operation max, element with the maximum value.. 
     * @param list list List (sequence).
     * @return Returns the maximum value contained in the list.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Number max(List list) {
        Number min = null;
        
        min = (Number) Collections.max(list);
        
        return min;
    }
    
    /**
     * Implementation for the IVML operation max.
     * @param set Set (set).
     * @return Returns maximum value.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object max(Set set) {
        return Collections.max(set);
    }
    
    
    /**
     * Implementation for the IVML operation prepend.
     * @param list List (sequence).
     * @param num Number to prepend
     * @return Returns the list.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List prepend(List list, Number num) {
        List l =  new ArrayList();
        if (pre == 0) {
            l.add(num);
            l.addAll(list);
            list.removeAll(list);
            list.addAll(l);
            pre++;
        }
        
        return list;
           
    }
    
    /**
     * Implementation for the IVML operation first.
     * @param list List (sequence). 
     * @return Returns the firts element of the list.
     */
    @SuppressWarnings("rawtypes")
    public static Object first(List list) {
        return list.get(0);
    }
    
    /**
     * Implementation for the IVML operation last.
     * @param list List (sequence).
     * @return The last element contained in the list.
     */
    @SuppressWarnings("rawtypes")
    public static Object last(List list) {
        return list.get(list.size() - 1);
    }
    
    
    
    /**
     * Implementation for the IVML operation indexOf.
     * @param list List (sequence).
     * @param ob Object whose index is being searched for.
     * @return The index of the object passed in
     */
    @SuppressWarnings("rawtypes")
    public static int indexOf(List list, Object ob) {
        return list.indexOf(ob);
    }
    
    /**
     * Implementation for the IVML operation at.
     * @param list List (sequence).
     * @param index index.
     * @return Returns the object at the given index.
     */
    @SuppressWarnings("rawtypes")
    public static Object at(List list, int index) {
        Object result = null;
        if (list != null && list.size() > index) {
            result = list.get(index);
        }
        
        return result;
    }
    
    
    
    /**
     * Implementation for the IVML operation typeOf.
     * @param ob Object whose type is being retrieved.
     * @return returns the type of the given object.
     */
    @SuppressWarnings("rawtypes")
    public static Class typeOf(Object ob) {
//        logger.info("class " + ob.getClass().getSimpleName());
        Class cl = null;
        if (ob != null) {
            
            
            if (!ob.getClass().getSuperclass().getSimpleName().equals("Object")) {
                cl = ob.getClass().getSuperclass();
            }  else {
                cl = ob.getClass();
            }
            
        } else {
            cl = Class.class;
        }
        return cl;
    }
    
    /**
     * Implementation for the IVML operation inserAt. 
     * @param list List (Sequence).
     * @param index Index.
     * @param ob Object to insert.
     * @return List.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List insertAt(List list, int index, Object ob) {
        if (ins == 0) {
            list.set(index, ob);
            ins++;
        }
        return list;
    }
    
    /**
     * Implementation for the IVML operation asSet. 
     * @param list List (Sequence).
     * @return A set with duplicates removed.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Set asSet(List list) {
        Set set = new HashSet();
        set.addAll(list);
        return set;
    }
    
    /**
     * Implementation for the IVML operation asSequence.
     * @param list List (Sequence).
     * @return Returns the same sequence.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List asSequence(List list) {
        List list1 = new ArrayList();
        list1.addAll(list);
        return list1;
    }
    
    /**
     * Implementation for the IVML operation asSet. 
     * @param set Set.
     * @return Returns a new set with the same values.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Set asSet(Set set) {
        Set set1 = new HashSet();
        set1.addAll(set);
        return set1;
    }
    
    /**
     * Implementation for the IVML operation asSequence.
     * @param set Set.
     * @return Returns a new set with the same values as the passed set..
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List asSequence(Set set) {
        List list1 = new ArrayList();
        list1.addAll(set);
        return list1;
    }
    
    /**
     * Implementation for IVML operation includes.
     * @param list List (Sequence).
     * @param ob Object (Anytype).
     * @return returns <b>True</b> if the list contains/includes the given object.
     */
    @SuppressWarnings("rawtypes")
    public static boolean includes(List list, Object ob) {
        return list.contains(ob);
    }
    
    /**
     * Implementation for IVML operation excludes.
     * @param list List (Sequence).
     * @param ob Object (Anytype).
     * @return returns <b>True</b> if the list excludes the given object.
     */
    @SuppressWarnings("rawtypes")
    public static boolean excludes(List list, Object ob) {
        return !list.contains(ob);
    }
    
    
    /**
     * Implementation for IVML operation includes.
     * @param set Set.
     * @param ob Object (Anytype).
     * @return returns <b>True</b> if the Set contains/includes the given object.
     */
    @SuppressWarnings("rawtypes")
    public static boolean includes(Set set, Object ob) {
        return set.contains(ob);
    }
    
    /**
     * Implementation for IVML operation excludes.
     * @param set Set.
     * @param ob Object (Anytype).
     * @return returns <b>True</b> if the Set excludes the given object.
     */
    @SuppressWarnings("rawtypes")
    public static boolean excludes(Set set, Object ob) {
        return !set.contains(ob);
    }
    
    /**
     * Implementation for IVML operation count.
     * @param list List (Sequence).
     * @param ob Object whose count is being identified.
     * @return Returns the number of times the object is present in the list.
     */
    @SuppressWarnings("rawtypes")
    public static int count(List list, Object ob) {
        int count = 0;
        
        if (list.contains(ob)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(ob)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Implementation for IVML operation count.
     * @param set set.
     * @param ob Object whose count is being identified.
     * @return Returns the number of times the object is present in the set.
     */
    @SuppressWarnings("rawtypes")
    public static int count(Set set, Object ob) {
        int count = 0;
        
        if (set.contains(ob)) {
            count = 1;
        }
        
        return count;
    }
    
    /**
     * Implementation of the IVML operation including.
     * @param list List (sequence)
     * @param ob Object to include.
     * @return Returns a list including the given object.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List including(List list, Object ob) {
        List list1 = new ArrayList();
        list1.addAll(list);
        if (list1.contains(ob)) {
            list1.remove(ob);
        } else {
            list1.add(ob);
        }
        return list1;
        
    }
    
    /**
     * Implementation of the IVML operation including.
     * @param set Set.
     * @param ob Object to include.
     * @return Returns a set including the given object.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Set including(Set set, Object ob) {
        Set set1 = new HashSet();
        set1.addAll(set);
        set1.add(ob);
        return set1;
        
    }
    
    /**
     * Implementation of the IVML operation excluding.
     * @param list List (sequence)
     * @param ob Object to include.
     * @return Returns a list excluding the given object.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List excluding(List list, Object ob) {
        List list1 = new ArrayList();
        list1.addAll(list);
        if (list1.contains(ob)) {
            list1.remove(ob);
        }
        
        return list1;
    }
    
    
    /**
     * Implementation of the IVML operation excluding.
     * @param set Set.
     * @param ob Object to include.
     * @return Returns a set excluding the given object.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Set excluding(Set set, Object ob) {
        Set set1 = new HashSet();
        set1.addAll(set);
        if (set1.contains(ob)) {
            set1.remove(ob);
        }
        return set1;
        
    }
 
    /**
     * Implementation for the iVML operation isEmpty.
     * @param list List (Sequence).
     * @return returns <b>True</b> if the the list is empty.
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(List list) {
        int siz = -1;
        if (null != list) {
            siz = list.size();
        } else {
            siz = 0;
        }
        return siz == 0;
    }
    
    /**
     * Implementation for the iVML operation notEmpty.
     * @param list List (Sequence).
     * @return returns <b>True</b> if the the list is not empty.
     */
    @SuppressWarnings("rawtypes")
    public static boolean notEmpty(List list) {
        int siz = -1;
        if (null != list) {
            siz = list.size();
        } else {
            siz = 0;
        }
        return siz != 0;
        
    }
    
    
    /**
     * Implementation for the iVML operation isEmpty.
     * @param set Set.
     * @return returns <b>True</b> if the the set is empty.
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Set set) {
        int siz = -1;
        if (null != set) {
            siz = set.size();
        } else {
            siz = 0;
        }
        return siz == 0;
        
    }
    
    /**
     * Implementation for the iVML operation notEmpty.
     * @param set Set.
     * @return returns <b>True</b> if the the set is not empty.
     */
    @SuppressWarnings("rawtypes")
    public static boolean notEmpty(Set set) {
        int siz = -1;
        if (null != set) {
            siz = set.size();
        } else {
            siz = 0;
        }
        return siz != 0;
    }
    
    /**
     * Implementation for the IVML operation Union.
     * @param list1 a list (sequence).
     * @param list2 a list (sequence). 
     * @return Returns a list which is a union of the given lists.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List union(List list1, List list2) {
        List list = new ArrayList();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }
    
    /**
     * Implementation for the IVML operation Union.
     * @param set1 Set
     * @param set2 Set.
     * @return Returns a set which is the union of the given sets.
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public static Set union(Set set1, Set set2) {
        Set set = new HashSet();
        
        if (null != set1 && null != set2) {
            set.addAll(set1);
            set.addAll(set2);
        } 
        return set;
        
    }
    
    /**
     * Implementation for the IVML operation Intersection.
     * @param set1 Set
     * @param set2 Set.
     * @return Returns a set which is the intersection of the given sets.
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public static Set intersection(Set set1, Set set2) {
        Set set = new HashSet();
        
        if (null != set1 && null != set2) {
            set.addAll(set1);
            set.retainAll(set2);
        } 
        return set;
    }

    /**
     * Implementation for the IVML operation append.
     * @param list List (sequence).
     * @param num Number to append
     * @return Returns the list.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List append(List list, Number num) {
        List l = new ArrayList();
//        logger.info("list is " + list);
        if (null != list) {
            l.addAll(list);
            l.add(num);
        } 
        return l;
    }
    
    
    /**
     * Implementation for the IVML operation exists.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by all elements of the list.
     */
    @SuppressWarnings("rawtypes")
    public static boolean ivmlExists(List l1, List l2) {
        return l2.size() > 0;
    }
    
    /**
     * Implementation for the IVML operation exists.
     * @param s1 Set one, the actual set.
     * @param s2 Set two, the set containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by all elements of the set.
     */
    @SuppressWarnings("rawtypes")
    public static boolean ivmlExists(Set s1, Set s2) {
        return s2.size() > 0;
    }
    
    /**
     * Implementation for the IVML operation foreach.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by all elements of the list.
     */
    @SuppressWarnings("rawtypes")
    public static boolean ivmlForEach(List l1, List l2) {
        return l2.size() == l1.size();
    }
    
    
    /**
     * Implementation for the IVML operation foreach.
     * @param s1 Set one, the actual set.
     * @param s2 Set two, the set containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by all elements of the set.
     */
    @SuppressWarnings("rawtypes")
    public static boolean ivmlForEach(Set s1, Set s2) {
        return s2.size() == s1.size();
    }
    
    
    /**
     * Implementation for the IVML operation Select.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return list containing the elements satisfying a given expression.
     */
    @SuppressWarnings("rawtypes")
    public static List ivmlSelect(List l1, List l2) {
        return l2;
    }
    
    /**
     * Implementation for the IVML operation Select.
     * @param s1 Set one, the actual set.
     * @param s2 Set two, the set containing elements satisfying a given expression. 
     * @return set containing the elements satisfying a given expression.
     */
    @SuppressWarnings("rawtypes")
    public static Set ivmlSelect(Set s1, Set s2) {
        return s2;
    }
    
    /**
     * Implementation for the IVML operation Collect.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return list containing the elements satisfying a given expression.
     */
    @SuppressWarnings("rawtypes")
    public static List ivmlCollect(List l1, List l2) {
        return l2;
    }
    
    /**
     * Implementation for the IVML operation Collect.
     * @param s1 Set one, the actual set.
     * @param s2 Set two, the set containing elements satisfying a given expression. 
     * @return set containing the elements satisfying a given expression.
     */
    @SuppressWarnings("rawtypes")
    public static Set ivmlCollect(Set s1, Set s2) {
        return s2;
    }
    
    
    /**
     * Implementation for the IVML operation Reject.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return list containing the elements not satisfying a given expression.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List ivmlReject(List l1, List l2) {
        List list = new ArrayList();
        list.addAll(l1);
        for (int i = 0; i < l2.size(); i++) {
            if (list.contains(l2.get(i))) {
                list.remove(i);
            }
        }
        
        return list;
    }
    
    /**
     * Implementation for the IVML operation one.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by exactly one element of the list.
     */
    @SuppressWarnings("rawtypes")
    public static boolean ivmlOne(List l1, List l2) {
        return l2.size() == 1;
    }
    
    
    /**
     * Implementation for the IVML operation One.
     * @param s1 Set one, the actual set.
     * @param s2 Set two, the set containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by exactly one element of the set.
     */
    @SuppressWarnings("rawtypes")
    public static boolean ivmlOne(Set s1, Set s2) {
        return s2.size() == 1;
    }
    
    
    /**
     * Implementation for the IVML operation Any.
     * @param l1 List one, the actual list.
     * @param l2 List two, the list containing elements satisfying a given expression. 
     * @return Returns an element that is satisfied by the expression.
     */
    @SuppressWarnings("rawtypes")
    public static Object ivmlAny(List l1, List l2) {
        int size = l2.size();
        int index = (int) (Math.random() * size);
        return l2.get(index);
    }
    
    
    /**
     * Implementation for the IVML operation One.
     * @param s1 Set one, the actual set.
     * @param s2 Set two, the set containing elements satisfying a given expression. 
     * @return <b>True</b> if a given expression is satisfied by exactly one element of the set.
     */
    @SuppressWarnings("rawtypes")
    public static Object ivmlAny(Set s1, Set s2) {
        Object result = null;
        s2.iterator().next();
        if (s2.size() > 0) {
            result = s2.iterator().next(); 
        } 
        
        return result;
    }
    
    
    /**
     * Implementation for the IVML operation isDefined.
     * @param boo boolean.
     * @return Returns <b>True</b> if the object is defined, in the sense that it is not null.
     */
    public static boolean ivmlDefined(Boolean boo) {
        return boo;
    }
    
    
     
}



