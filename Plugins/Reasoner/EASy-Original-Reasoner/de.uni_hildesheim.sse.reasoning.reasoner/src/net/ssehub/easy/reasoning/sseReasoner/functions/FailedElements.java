package net.ssehub.easy.reasoning.sseReasoner.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;

/**
 * Stores violated elements detected during a reasoning process.
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
     * Other, unresolved messages.
     */
    private List<EvaluationVisitor.Message> messages;
    
    /**
     * Creates a new {@link FailedElements} instance, which can be used for exact one reasoning process.
     * This constructor is only package visible, as it should only be used inside of the {@link FailedElements} class.
     */
    public FailedElements() {
        problemConstraints = new HashMap<Constraint, FailedElementDetails>();
        problemVariables = new HashMap<AbstractVariable, FailedElementDetails>();
        messages = new ArrayList<EvaluationVisitor.Message>();
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
     * Removes a problem point through its constraint.
     * 
     * @param constraint Constraint to be declared valid/irrelevant for problems.
     */
    public void removeProblemConstraint(Constraint constraint) {
        problemConstraints.remove(constraint);
    }
    
    public void addMessage(EvaluationVisitor.Message message) {
        messages.add(message);
    }

    /**
     * Removes problem points through several constraint.
     * 
     * @param constraints the constraints to be declared valid/irrelevant for problems.
     */
    public void removeProblemConstraints(List<Constraint> constraints) {
        for (int c = 0, n = constraints.size(); c < n; c++) {
            problemConstraints.remove(constraints.get(c));
        }
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
     * @return <code>true</code> if at least one errors was reported to this instance, <code>false</code> otherwise.
     */
    public boolean hasProblems() {
        boolean messageProblem = false;
        for (int m = 0; !messageProblem && m < messages.size(); m++) {
            messageProblem = messages.get(m).getStatus() == Status.ERROR;
        }
        return messageProblem || !(problemConstraints.isEmpty() && problemVariables.isEmpty());
    }
    
    /**
     * Returns the total number of failed elements ( {@link Constraint} and {@link AbstractVariable} ).
     * @return The number of failed elements, 0 if {@link #hasProblems()} was <code>false</code>.
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
     * Returns the messages.
     * 
     * @return the messages
     */
    public Iterator<EvaluationVisitor.Message> getMessages() {
        return messages.iterator();
    }
    
    /**
     * Returns a map of problem {@link AbstractVariable}s and associated {@link FailedElementDetails}s.
     * @return Map of problem variables.
     */
    public Map<AbstractVariable, FailedElementDetails> getProblemVariableMap() {
        return problemVariables;
    }
    
    /**
     * Clears this instance.
     */
    public void clear() {
        problemConstraints.clear();
        problemVariables.clear();
        messages.clear();
    }
   
}
