package net.ssehub.easy.varModel.cst;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Utility class for caching / pooling variables in order to save memory.
 * Please use this class local to a model / operation in order avoid that memory
 * remains allocated although not used. 
 * 
 * @author Sascha El-Sharkawy
 * @author Holger Eichelberger
 */
public class VariablePool {

    private static final boolean ENABLE = true; // for testing, debugging, measuring
    private Map<Integer, Variable> variablesCache = new HashMap<Integer, Variable>();

    /**
     * Returns a {@link Variable} for the given {@link AbstractVariable}.
     * This method will cache already created {@link Variable}s to reduce memory consumption.
     * 
     * @param decl A {@link AbstractVariable} for which a {@link Variable} shall be created.
     * @return A cached {@link Variable} for the given {@link AbstractVariable} or a new one
     *     if no cached variable exists, a new one is created and will be cached for future calls.
     */
    public final Variable obtainVariable(AbstractVariable decl) {
        Variable variable;
        if (ENABLE) {
            variable = variablesCache.get(keyObject(decl));
        } else {
            variable = null;
        }
        if (null == variable) {
            variable = new Variable(decl);
            variablesCache.put(keyObject(decl), variable);
        }
        return variable;
    }
    
    /**
     * Returns the key object for hashes, also for tests. This is needed, as the equals/hashcode
     * implementation of {@link AbstractVariable} is just based on the name and does not cope with
     * local variables. This method shall remind dependent implementations about the aforementionied problem.
     * 
     * @param decl the declaration
     * @return the key/hash object
     */
    public static final Integer keyObject(AbstractVariable decl) {
        return System.identityHashCode(decl);
    }
    
    /**
     * Returns whether this pool knows a certain variable.
     * 
     * @param decl the variable declaration
     * @return <code>true</code> if the pool knows the variable, <code>false</code> else
     */
    public final boolean knowsVariable(AbstractVariable decl) {
        return variablesCache.containsKey(keyObject(decl));
    }
    
    /**
     * Clears this pool for reuse or to force unallocation of memory.
     */
    public final void clear() {
        variablesCache.clear();
    }
    
    @Override
    public String toString() {
        return variablesCache.toString();
    }
    
}
