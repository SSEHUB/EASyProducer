package de.uni_hildesheim.sse.reasoner.jess;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;


/**
 * Class contains the most common aspects of Jess writing, for e.g. like open brackets, indentations etc.
 * @author saripalli
 *
 */
public class JessCommons { 

    public static final String NEWLINE = "\n"; 
    public static final String BRACKETOPEN = "(";
    public static final String BRACKETCLOSE = " )";
    public static final String TAB = "\t";
    public static final String QOUTE = "\""; 
    public static final String IMPLIES = "=>";
    
    public static final String RUN = "(run)";
    public static final String RUNUNRILHALT = "(run-until-halt)";
    public static final String FACTS = "(facts)";
    public static final String DEFRULE = "(defrule ";
    private static Map<String, String> opMap = new HashMap<String, String>();
    
    /**
     * Method that loads all the operators in a map.
     * @return 
     * 
     */
    public static final void loadOperators() {
        opMap.put(OclKeyWords.GREATER, ">");
        opMap.put(OclKeyWords.EQUALS, "Equals");
        opMap.put(OclKeyWords.LESS_EQUALS, "<=");
//        opMap.put(OclKeyWords.UNEQUALS_ALIAS, "<>");
//        opMap.put(OclKeyWords.UNEQUALS, "<>");
        
        opMap.put(OclKeyWords.UNEQUALS_ALIAS, "NotEquals");
        opMap.put(OclKeyWords.UNEQUALS, "NotEquals");
        
        opMap.put(OclKeyWords.IMPLIES, "IVMLBooleanImplication");
        opMap.put(OclKeyWords.XOR, "IVMLXOR");
        opMap.put(OclKeyWords.IS_EMPTY, "IVMLisEmpty");
        opMap.put(OclKeyWords.NOT_EMPTY, "IVMLnotEmpty");
//        opMap.put(OclKeyWords.SIZE, "length$");
        opMap.put(OclKeyWords.FIRST, "IVMLfirst");
        opMap.put(OclKeyWords.LAST, "IVMLlast");
        opMap.put(OclKeyWords.MIN, "IVMLmin");
        opMap.put(OclKeyWords.MAX, "IVMLmax");
        opMap.put(OclKeyWords.IFF, "IVMLXNOR");
        opMap.put(OclKeyWords.SUM, "IVMLsum");
        opMap.put(OclKeyWords.PRODUCT, "IVMLproduct");
        opMap.put(OclKeyWords.AVG, "IVMLavg");
        opMap.put(OclKeyWords.AS_SET, "IVMLasSet");
        opMap.put(OclKeyWords.AS_SEQUENCE, "IVMLasSequence");
        opMap.put(OclKeyWords.INTERSECTION, "intersection$");
        opMap.put(OclKeyWords.COLLECT, "IVMLsel");
        opMap.put(OclKeyWords.FOR_ALL, "IVMLsel");
        opMap.put(OclKeyWords.REJECT, "IVMLsel");
        opMap.put(OclKeyWords.EXISTS, "IVMLexists");
        opMap.put(OclKeyWords.SELECT, "IVMLsel");
        opMap.put(OclKeyWords.CONCAT, "str-cat");
        opMap.put(OclKeyWords.MATCHES, "IVMLmatches");
        opMap.put(OclKeyWords.SUBSTITUTES, "IVMLsubstitutes");
        opMap.put(OclKeyWords.SUBSTRING, "IVMLsubstring");
        opMap.put(OclKeyWords.TO_INTEGER, "IVMLtoInteger");
        opMap.put(OclKeyWords.TO_REAL, "IVMLtoReal");
        opMap.put(OclKeyWords.LAST, "IVMLlast");
        opMap.put(OclKeyWords.TYPE_OF, "IVMLtypeOf");
        opMap.put(OclKeyWords.APPEND, "IVMLappend");
        opMap.put(OclKeyWords.UNION, "IVMLUnion");
        opMap.put(OclKeyWords.INDEX_OF, "IVMLindexOf");
//        opMap.put(OclKeyWords.INSERT_AT, "IVMLinsertAt");
        opMap.put(OclKeyWords.ONE, "IVMLsel");
        opMap.put(OclKeyWords.AT, "IVMLindexAccess");
        opMap.put(OclKeyWords.INDEX_ACCESS, "IVMLindexAccess");
        opMap.put(OclKeyWords.DIV_INT, "IVMLdiv");
        opMap.put(OclKeyWords.DIV, "IVMLdiv");
        opMap.put(OclKeyWords.FLOOR, "IVMLfloor");
        opMap.put(OclKeyWords.UNEQUALS_ALIAS, "IVMLneq");
        opMap.put(OclKeyWords.FLOOR, "IVMLfloor");
        opMap.put(OclKeyWords.MOD, "IVMLmod");
        opMap.put(OclKeyWords.ABS, "abs");
        opMap.put(OclKeyWords.MINUS, "IVMLminus");
        opMap.put(OclKeyWords.INVERSE, "IVMLminus");
        opMap.put(OclKeyWords.ANY, "IVMLsel");
        opMap.put(OclKeyWords.INCLUDES, "IVMLincludes");
        opMap.put(OclKeyWords.EXCLUDES, "IVMLexcludes");
        opMap.put(OclKeyWords.IS_DEFINED, "IVMLisDefined");
        opMap.put(OclKeyWords.SIZE, "IVMLsize");
        opMap.put(OclKeyWords.ROUND, "IVMLround");
        opMap.put(OclKeyWords.PREPEND, "IVMLprepend");
    }
   
    /**
     * Method to retrieve Jess equivalent operator.
     * @param op Operator.
     * @return Returns Jess equivalent operator.
     */
    public static String getJessOperator(String op) {
        String returnOp = opMap.get(op);
        if (opMap.get(op) != null) {
            returnOp = opMap.get(op);
        } else {
            returnOp = op;
        }
                
        return returnOp;
    }
    
}
