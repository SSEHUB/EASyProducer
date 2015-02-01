package de.uni_hildesheim.sse.reasoning.reasoner.functions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;

/**
 * Part of the {@link FailedRules}. This class stores violated elements detected during a reasoning process.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class FailedElements {

    /**
     * List of violated constraints.
     */
    private Set<Constraint> failedConstraints;
    
    /**
     * List of all variables that had an error in assignments.
     */
    private Set<AbstractVariable> failedVariables; 
    
    /**
     * Creates a new {@link FailedElements} instance, which can be used for exact one reasoning process.
     * This constructor is only package visible, as it should only be used inside of the {@link FailedElements} class.
     */
    FailedElements() {
        failedConstraints = new HashSet<Constraint>();
        failedVariables = new HashSet<AbstractVariable>();
    }
    
    /**
     * Adds the {@link Constraint} to this instance.
     * @param constraint The failed constraint.    
     */
    void addConstraint(Constraint constraint) {
        failedConstraints.add(constraint);
    }
    
    /**
     * Removes the {@link Constraint} from this instance.
     * @param constraint The valid constraint.    
     */
    void removeConstraint(Constraint constraint) {
        failedConstraints.remove(constraint);
    }    
    
    /**
     * Adds the {@link AbstractVariable} with a failed assignment.
     * @param variable Failed variable.
     */
    void addVariable(AbstractVariable variable) {
        failedVariables.add(variable);
    }    
    
    /**
     * Returns whether constraint violations or variable assignment were detected during the related reasoning process.
     * @return <tt>true</tt> if at least one errors was reported to this instance, <tt>false</tt> otherwise.
     */
    public boolean hasErrors() {
        return !(failedConstraints.isEmpty() && failedVariables.isEmpty());
    }
    
    /**
     * Returns the total number of failed elements ( {@link Constraint} and {@link AbstractVariable} ).
     * @return The number of failed elements, 0 if {@link #hasErrors()} was <tt>false</tt>.
     */
    public int failedElementsCount() {
        return failedConstraints.size() + failedVariables.size();
    }
    
    /**
     * Returns the number of failed constraints.
     * @return The number of failed constraints.
     */
    public int failedConstraintCount() {
        return failedConstraints.size();
    }    
    
    /**
     * Return the number of failed variables.
     * @return the number of failed variables.
     */
    public int failedVariablesCount() {
        return failedVariables.size();
    }
    
    /**
     * Returns a {@link Iterator} for traversing all failed constraints.
     * @return The failed {@link Constraint}.
     */
    public Iterator<Constraint> getFailedConstraints() {
        return failedConstraints.iterator();
    } 
    
    /**
     * Returns a {@link Iterator} for traversing all failed variables.
     * @return Failed {@link AbstractVariable}.
     */
    public Iterator<AbstractVariable> getFailedVariables() {
        return failedVariables.iterator();
    }     
   
}
