package net.ssehub.easy.reasoning.drools2.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class contains all failed rules. Methods are static for used in Drools as functions.
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
     * Method to add values (failed rule names) to the list of Failed rules.
     * Will be used in Drools file as a imported function.
     * @param reasoningID The ID of the current reasoning process (cf. {@link #createNewList(String)}).
     * @param ruleNr number of the rule that failed.
     */
    public static void addFailedRule(String reasoningID, int ruleNr) {
        FAILED_RULES.get(reasoningID).addRule(ruleNr);
    }    
    
    /**
     * Method to add {@link FailedRuleInCompound} to the list of failed declarations.
     * Will be used in Drools file as a imported function.
     * @param reasoningID The ID of the current reasoning process (cf. {@link #createNewList(String)}).
     * @param cmpName The name of compound instance, containing violated constraints.
     * @param constraint The index of violated constraints.
     */
    public static void addFailedRuleInCompound(String reasoningID, String cmpName, int constraint) {
        FAILED_RULES.get(reasoningID).addFailedRuleInCompound(cmpName, constraint);
    }
    
    /**
     * Method for retrieving list with failed rules indexes from Drools.
     * This method removes the list also from this container. Therefore the <tt>reasoningID</tt> must not longer be
     * used, after calling this method. This method should be called, after Drools is finished.
     * @param reasoningID A {@link FailedElements} instance, containing all violated elements,
     *     found during reasoning (cf. {@link #createNewList(String)}).
     * @return {@link FailedElements} of failed rules indexes and failed
     *     {@link de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;} names.
     */
    public static FailedElements getFailedRuleList(String reasoningID) {
        return FAILED_RULES.remove(reasoningID);
    }
}
