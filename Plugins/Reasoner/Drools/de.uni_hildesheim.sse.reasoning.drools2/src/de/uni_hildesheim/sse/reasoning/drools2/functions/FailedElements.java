package de.uni_hildesheim.sse.reasoning.drools2.functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Part of the {@link FailedRules}. This class stores violated elements detected during a reasoning process.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class FailedElements {

    /**
     * List of violated constraints.
     * The numbers must match to the ordering of
     * {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel#getTotalValueValidationConstraintCount()}.
     */
    private Set<Integer> failedRules;
    
    /**
     * Failed constraints of compounds.
     */    
    private Map<String, Set<Integer>> failedRulesInCompounds;
    
    /**
     * Creates a new {@link FailedElements} instance, which can be used for exact one reasoning process.
     * This constructor is only package visible, as it should only be used inside of the {@link FailedElements} class.
     */
    FailedElements() {
        failedRules = new HashSet<Integer>();
        failedRulesInCompounds = new HashMap<String, Set<Integer>>();
    }
    
    /**
     * Adds the number of a failed rule to this instance.
     * @param failedRule The number of the failed rule (must match to
     *     {@link de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel#getTotalValueValidationConstraintCount()}).
     */
    void addRule(int failedRule) {
        failedRules.add(failedRule);
    }
    
    /**
     * Adds an failed constraint to the compound key.
     * @param cmpName The violated compound.
     * @param constraint Violated constraints index.
     */
    void addFailedRuleInCompound(String cmpName, int constraint) {
        Set<Integer> tmpSet = new HashSet<Integer>();
        if (failedRulesInCompounds.get(cmpName) != null) {
            tmpSet = failedRulesInCompounds.get(cmpName);
            tmpSet.add(constraint);
            failedRulesInCompounds.put(cmpName, tmpSet);            
        } else {
            tmpSet.add(constraint);
            failedRulesInCompounds.put(cmpName, tmpSet); 
        }
    }
    
    /**
     * Returns whether any constraint violations were detected during the related reasoning process.
     * @return <tt>true</tt> if at least one errors was reported to this instance, <tt>false</tt> otherwise.
     */
    public boolean hasErrors() {
        return !(failedRules.isEmpty() && failedRulesInCompounds.isEmpty());
    }
    
    /**
     * Returns the total number of failed elements (rules numbers and declarations).
     * @return The number of failed elements, 0 if {@link #hasErrors()} was <tt>false</tt>.
     */
    public int failedElementsCount() {
        return failedRules.size() + failedRulesInCompoundsCount();
    }
    
    /**
     * Returns the number of failed constraints (rules numbers).
     * @return The number of failed constraints.
     */
    public int failedConstraintCount() {
        return failedRules.size();
    }    
    
    /**
     * Returns the number of failed rules in compounds.
     * @return The number of failed rules in compounds.
     */
    public int failedRulesInCompoundsCount() {
        return failedRulesInCompounds.size();
    }
    
    /**
     * Returns a {@link Iterator} for traversing all failed rule numbers.
     * @return The failed rule numbers.
     */
    public Iterator<Integer> getFailedRules() {
        return failedRules.iterator();
    }    
    
    /**
     * Returns a Set of keys - names of compounds that have failed constraints.
     * @return The failed compounds names.
     */
    public Set<String> getFailedCompoundsNames() {
        return failedRulesInCompounds.keySet();
    }
    
    /**
     * Returns a map of compounds that have failed constraints.
     * @return All compounds with failed constraints.
     */
    public Map<String, Set<Integer>> getFailedRulesInCompounds() {
        return failedRulesInCompounds;
    }
}
