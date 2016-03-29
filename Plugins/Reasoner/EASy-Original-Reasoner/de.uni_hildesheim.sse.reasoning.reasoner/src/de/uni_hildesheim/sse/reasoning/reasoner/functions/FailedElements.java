package de.uni_hildesheim.sse.reasoning.reasoner.functions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;

/**
 * Part of the {@link FailedRules}. This class stores violated elements detected during a reasoning process.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class FailedElements {    
    
    /**
     * Map of failed {@link Constraint}s and {@link FailedElementDetails}s that might cause the problem.
     */
    private Map<Constraint, FailedElementDetails> problemConstraints;
    
    /**
     * Map of failed {@link AbstractVariable}s and {@link FailedElementDetails}s behind it.
     */
    private Map<AbstractVariable, FailedElementDetails> problemVariables;
    
    
    /**
     * Creates a new {@link FailedElements} instance, which can be used for exact one reasoning process.
     * This constructor is only package visible, as it should only be used inside of the {@link FailedElements} class.
     */
    public FailedElements() {
        problemConstraints = new HashMap<Constraint, FailedElementDetails>();
        problemVariables = new HashMap<AbstractVariable, FailedElementDetails>();
    }
    
    /**
     * Method for adding failed constraints and associated details.
     * @param constraint Failed constraint.
     * @param details Failed constraint details.
     */
    public void addProblemConstraint(Constraint constraint, FailedElementDetails details) {
        problemConstraints.put(constraint, details);       
    }
    
    /**
     * Method for removing a problem point.
     * @param constraint Constraint that is valid.
     */
    public void removeProblemConstraint(Constraint constraint) {
        problemConstraints.remove(constraint);
    }
    
    /**
     * Method for adding failed variable and associated {@link IDecisionVariable}.
     * @param variable Failed variable.
     * @param details Associated details.
     */
    public void addProblemVariable(AbstractVariable variable, FailedElementDetails details) {
        problemVariables.put(variable, details);
    } 
    
    /**
     * Returns whether constraint violations or variable assignment were detected during the related reasoning process.
     * @return <tt>true</tt> if at least one errors was reported to this instance, <tt>false</tt> otherwise.
     */
    public boolean hasProblems() {
        return !(problemConstraints.isEmpty() && problemVariables.isEmpty());
    }
    
    /**
     * Returns the total number of failed elements ( {@link Constraint} and {@link AbstractVariable} ).
     * @return The number of failed elements, 0 if {@link #hasProblems()} was <tt>false</tt>.
     */
    public int problemCount() {
        return problemConstraintCount() + problemVariabletCount();
    }
    
    /**
     * Returns the number of problem constraints.
     * @return the number of problem constraints.
     */
    public int problemConstraintCount() {
        return problemConstraints.size();
    }
    
    /**
     * Returns the number of problem variables.
     * @return the number of problem variables.
     */
    public int problemVariabletCount() {
        return problemVariables.size();
    } 
    
    /**
     * Returns a {@link Iterator} - problem {@link Constraint}s.
     * @return The failed constraints.
     */
    public Iterator<Constraint> getProblemConstraints() {
        return problemConstraints.keySet().iterator();
    }
    
    /**
     * Returns a map of failed {@link Constraint}s and associated {@link FailedElementDetails}s.
     * @return Map of problem constraints.
     */
    public Map<Constraint, FailedElementDetails> getProblemConstraintMap() {
        return problemConstraints;
    }
    
    /**
     * Returns a {@link Iterator} - problem {@link AbstractVariable}s.
     * @return Problem variables.
     */
    public Iterator<AbstractVariable> getProblemVariables() {
        return problemVariables.keySet().iterator();
    }
    
    /**
     * Returns a map of problem {@link AbstractVariable}s and associated {@link FailedElementDetails}s.
     * @return Map of problem variables.
     */
    public Map<AbstractVariable, FailedElementDetails> getProblemVariableMap() {
        return problemVariables;
    }
   
}
