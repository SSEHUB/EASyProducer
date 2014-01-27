package de.uni_hildesheim.sse.model.varModel.datatypes;

import java.util.List;

/**
 * Provides some utility operations, also due to the split in the inheritance
 * hierarchy.
 * 
 * @author Holger Eichelberger
 */
public class TypeQueries {

    /**
     * Returns an operation defined on <code>operand</code> with
     * given <code>name</code> and <code>parameters</code>.
     * Please note that the first parameter of an operation
     * is implicitly <code>operand</code>.
     * 
     * @param operand the type the operation shall be defined for
     * @param name the name of the operation
     * @param parameter the list of parameters (excluding
     *   this data type)
     * @return the operation or <b>null</b> if none was found
     */
    public static Operation getOperation(IDatatype operand, String name, IDatatype... parameter) {
        // rather preliminary, shall be part of an abstract superclass!
        Operation result = null;
        for (int o = 0; null == result && o < operand.getOperationCount(); o++) {
            Operation tmp = operand.getOperation(o);
            if (tmp.getName().equals(name)) {
                int tmpParamCount = tmp.getParameterCount();
                if (null == parameter && 0 == tmpParamCount) {
                    result = tmp;
                } else if (parameter.length == tmpParamCount) {
                    boolean eq = true;
                    for (int p = 0; eq && p < tmpParamCount; p++) {
                        eq = (tmp.getParameter(p).isAssignableFrom(parameter[p]));
                    }
                    if (eq) {
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the operations defined on <code>operant</code> which
     * comply to the given name <code>prefix</code> (may also be 
     * the entire name) and the prefixed parameter set (at least
     * the given parameter types must match in the specified 
     * order, an empty list may match all operations).
     * Please note that the first parameter of an operation
     * is <code>operant</code>.
     * 
     * @param operant the type the operation shall be defined for
     * @param prefix the name prefix of the operations to be returned
     * @param parameter the list of parameters (excluding
     *   this data type)
     * @return the matching operations or <b>null</b> if none was found
     */
    public static List<Operation> getOperationByPrefix(IDatatype operant, String prefix, IDatatype... parameter) {
        // TODO HE: realize this
        return null;
    }

    
}
