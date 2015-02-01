package de.uni_hildesheim.sse.reasoning.reasoner.functions;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;

/**
 * Class contains all failed rules.
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class FailedRules {
    
    /**
     * A List of failed rules separated by individual reasoning tasks.
     * This map is in the form of: (name/id of individual reasoning task, list of failed rules for task).
     */
    private static final Map<String, FailedElements> FAILED_RULES = new HashMap<String, FailedElements>();
    
    /**
     * Creates a new ID for an individual reasoning task.
     * @param projectName Name of the project that is reasoned on.
     * @return unique reasoning ID composed from the name of the project and a time when reasoning was started.
     */
    public static synchronized String createReasoningID(String projectName) {        
//        String reasoningID = projectName;
        String reasoningID = projectName + "_" + System.currentTimeMillis();
        FailedElements timeStamps = FAILED_RULES.get(reasoningID);
        if (null != timeStamps) {
            int randomdigit = (int) (System.nanoTime() % 10);
            // Recursive call
            reasoningID = createReasoningID(projectName + randomdigit);
        } 
        return reasoningID;
    }   
    
    /**
     * Creates a new empty list of failed rules for an individual reasoning task.
     * Should be called before reasoning.
     * @param reasoningID unique reasoning ID.
     */
    public static void createNewList(String reasoningID) {
        FailedElements failedElements = new FailedElements();        
        FAILED_RULES.put(reasoningID, failedElements);        
    }
    
    /**
     * Method to add values (failed {@link Constraint}) to the list of Failed constraints.
     * @param reasoningID The ID of the current reasoning process (cf. {@link #createNewList(String)}).
     * @param constraint Failed {@link Constraint}.
     */
    public static void addFailedConstraint(String reasoningID, Constraint constraint) {
        FAILED_RULES.get(reasoningID).addConstraint(constraint);
    } 
    
    /**
     * Method to remove values (valid {@link Constraint}) from the list of Failed constraints.
     * @param reasoningID The ID of the current reasoning process (cf. {@link #createNewList(String)}).
     * @param constraint Valid {@link Constraint}.
     */
    public static void removeValidConstraint(String reasoningID, Constraint constraint) {
        FAILED_RULES.get(reasoningID).removeConstraint(constraint);
    } 
    
    /**
     * Method to add values (failed {@link AbstractVariable} ) to the list of Failed variables.
     * @param reasoningID The ID of the current reasoning process (cf. {@link #createNewList(String)}).
     * @param variable Failed {@link AbstractVariable}.
     */
    public static void addFailedVariable(String reasoningID, AbstractVariable variable) {
        FAILED_RULES.get(reasoningID).addVariable(variable);
    } 
    
    /**
     * Method for retrieving {@link FailedElements} with failed {@link Constraint} and {@link AbstractVariable}.
     * This method removes the {@link FailedElements} also from this container. Therefore the <tt>reasoningID</tt> 
     * must not longer be used, after calling this method. This method should be called, after Drools is finished.
     * @param reasoningID A {@link FailedElements} instance, containing all violated elements,
     *     found during reasoning (cf. {@link #createNewList(String)}).
     * @return {@link FailedElements} of failed {@link Constraint} and {@link AbstractVariable}.
     */
    public static FailedElements getFailedElements(String reasoningID) {
        return FAILED_RULES.get(reasoningID);
    }
    
    /**
     * Method for clearing all failed rule entries.
     * @param reasoningID ID to be cleared.
     */
    public static void clearResults(String reasoningID) {
        FAILED_RULES.remove(reasoningID);
    }
}
