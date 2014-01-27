package de.uni_hildesheim.sse.reasoning.drools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;

/**
 * This class contains methods to identify if the IVML operations are implicitly supported by Jess.
 * @author Phani
 * @author Roman Sizonenko
 *
 */
public class DroolsOperations {
    
    private static Map<String, String> opMap = new HashMap<String, String>();
    private static Map<String, String> operators = new HashMap<String, String>();
    private static List<String> notSupportedOperators = new ArrayList<String>(); 
    
    /**
     * Constructor for the class.
     */
    public DroolsOperations() {
//        loadOperators();
//        createDroolsOperators();
//        System.out.println("called");
    }
    
    /**
     * Method to identify if the given operation is supported by Drools.
     * @param op Operation
     * @return <b>True</b> if supported by drools.
     */
    public static boolean isImplicitOperation(String op) {
        boolean result = true;
        if (op.equals(OclKeyWords.IMPLIES)) {
            result = false;
        } else if (op.equals(OclKeyWords.NOT)) {
            result = false;
        } else if (opMap.containsKey(op)) {
            result = false;
        } else if (operators.containsKey(op) && !op.equals(OclKeyWords.NOT)) {
            result = true;
        } else {
            result = true;
        }
        return result;
    }
    
    /**
     * This method returns equivalent operation in Drools.
     * @param op Operation.
     * @return Operation in Drools.
     */
    public static String getDroolsOperation(String op) {
        String operation = op;
        if (opMap.containsKey(op)) {
            operation = opMap.get(op);
        } else if (operators.containsKey(op)) {
            operation = operators.get(op);
        } else {
            operation = op;
        }
        return operation;
    }
    
    
    /**
     * Method to identify if an operation is supported by Drools current implementation.
     * @param op Operation.
     * @return Returns <b>True</b> if the operation is supported by Drools current implementation.
     */
    public static boolean isOperationSupported(String op) {
        return !notSupportedOperators.contains(op);
    }
    
    /**
     * A private method to load all the operators.
     */
    public static void loadOperators() {
        
        opMap.put(OclKeyWords.UNEQUALS, "uneq"); 
        opMap.put(OclKeyWords.UNEQUALS_ALIAS, "uneq");
        opMap.put(OclKeyWords.FLOOR, "floor");
        opMap.put(OclKeyWords.MOD, "mod");
        opMap.put(OclKeyWords.ABS, "abs");
        opMap.put(OclKeyWords.ROUND, "round");
//        opMap.put(OclKeyWords.MINUS, "minus");
        opMap.put(OclKeyWords.INVERSE, "minus");
        opMap.put(OclKeyWords.DIV_INT, "div");        
        opMap.put(OclKeyWords.DIV, "/");
        opMap.put(OclKeyWords.MULT, "*");
        opMap.put(OclKeyWords.PLUS, "+");
        opMap.put(OclKeyWords.MINUS, "-");
        opMap.put(OclKeyWords.INDEX_OF, "indexOf");
        opMap.put(OclKeyWords.IFF, "iff");
        opMap.put(OclKeyWords.XOR, "xor");
        opMap.put(OclKeyWords.SIZE, "size");
        opMap.put(OclKeyWords.TO_INTEGER, "toInteger");
        opMap.put(OclKeyWords.TO_REAL, "toReal");
        opMap.put(OclKeyWords.CONCAT, "concat");
        opMap.put(OclKeyWords.SUBSTITUTES, "substitutes");
        opMap.put(OclKeyWords.SUBSTRING, "substring");
        opMap.put(OclKeyWords.MATCHES, "matches");
        opMap.put(OclKeyWords.SUM, "sum");
        opMap.put(OclKeyWords.PRODUCT, "product");
        opMap.put(OclKeyWords.AVG, "avg");
        opMap.put(OclKeyWords.MIN, "min");
        opMap.put(OclKeyWords.MAX, "max");
        opMap.put(OclKeyWords.FIRST, "first");
        opMap.put(OclKeyWords.LAST, "last");
        opMap.put(OclKeyWords.APPEND, "append");
        opMap.put(OclKeyWords.PREPEND, "prepend");
        opMap.put(OclKeyWords.AT, "at");
        opMap.put(OclKeyWords.INDEX_ACCESS, "at");
        opMap.put(OclKeyWords.INSERT_AT, "insertAt");
        opMap.put(OclKeyWords.AS_SET, "asSet");
        opMap.put(OclKeyWords.AS_SEQUENCE, "asSequence"); 
        opMap.put(OclKeyWords.INCLUDES, "includes");
        opMap.put(OclKeyWords.EXCLUDES, "excludes");
        opMap.put(OclKeyWords.INCLUDING, "including");
        opMap.put(OclKeyWords.EXCLUDING, "excluding");
        opMap.put(OclKeyWords.COUNT, "count");
        opMap.put(OclKeyWords.IS_EMPTY, "isEmpty");
        opMap.put(OclKeyWords.NOT_EMPTY, "notEmpty");
        opMap.put(OclKeyWords.UNION, "union");
        opMap.put(OclKeyWords.INTERSECTION, "intersection");
        opMap.put(OclKeyWords.EXISTS, "exists");
        opMap.put(OclKeyWords.IS_DEFINED, "ivmlDef");
        opMap.put(OclKeyWords.EXISTS, "ivmlExists");
        opMap.put(OclKeyWords.FOR_ALL, "ivmlForEach");
        opMap.put(OclKeyWords.SELECT, "ivmlSelect");
        opMap.put(OclKeyWords.REJECT, "ivmlReject");
        opMap.put(OclKeyWords.ANY, "ivmlAny");
        opMap.put(OclKeyWords.ONE, "ivmlOne");
        opMap.put(OclKeyWords.TYPE_OF, "typeOf");
        opMap.put(OclKeyWords.COLLECT, "ivmlCollect");
//        opMap.put(OclKeyWords.EQUALS, "equalsFun");
//        opMap.put(OclKeyWords.EQUALS_ALIAS, "equalsFun");
//        opMap.put(OclKeyWords.ASSIGNMENT, "equalsFun");
        
        
    }
    
    /**
     * Public method to create Drools equivalent operations.
     */
    public static void createDroolsOperators() {
        operators.put(OclKeyWords.GREATER, ">");
        operators.put(OclKeyWords.LESS_EQUALS, "<=");
        operators.put(OclKeyWords.LESS, "<");
        operators.put(OclKeyWords.GREATER_EQUALS, ">=");
        operators.put(OclKeyWords.AND, "&&"); // && does not work 
        operators.put(OclKeyWords.OR, "||");
        operators.put(OclKeyWords.NOT, "!");
        operators.put(OclKeyWords.EQUALS, "==");
        operators.put(OclKeyWords.ASSIGNMENT, "==");
//        operators.put(OclKeyWords.DIV, "/");
//        operators.put(OclKeyWords.MULT, "*");
//        operators.put(OclKeyWords.PLUS, "+");
//        operators.put(OclKeyWords.MINUS, "-");
    }
    
    /**
     * Public method to create a map of operators currently not supported.
     */
    public static void createNonSupportedOperatorsList() {
//        notSupportedOperators.add(OclKeyWords.COLLECT);
//        notSupportedOperators.add(OclKeyWords.ASSIGNMENT);
//        notSupportedOperators.add(OclKeyWords.SELECT);
//        notSupportedOperators.add(OclKeyWords.ONE);
//        notSupportedOperators.add(OclKeyWords.REJECT);
        
    }
 
}
