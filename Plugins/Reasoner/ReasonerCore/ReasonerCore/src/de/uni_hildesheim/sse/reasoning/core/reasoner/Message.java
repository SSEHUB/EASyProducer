package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Part of the {@link ReasoningResult} class, expressing on error/warning of a complete {@link ReasoningResult}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class Message extends de.uni_hildesheim.sse.utils.messages.Message {

    private List<ModelElement> conflictingElements;
    private List<String> conflictingElementLabels;
    private List<Set<AbstractVariable>> variablesInConstraints;
    private List<Set<IDecisionVariable>> problemVariables;
    private List<ConstraintSyntaxTree> problemConstraintParts;
    private List<String> conflictingElementComments;
    private List<Project> conflictingElementProjects;
    private List<String> conflictingElementSuggestions;
    private List<IDecisionVariable> constraintVariables;
    

    /**
     * Sole constructor for multiple conflicting elements.
     * @param explanation A textual representation of this message
     * @param conflictingElements A list of model elements which lead to the current message, or <tt>null</tt>
     * @param status The status of this message, e. g. Error or Warning
     */
    public Message(String explanation, List<ModelElement> conflictingElements, Status status) {
        super(explanation, status);

        // Avoid NullpointerExceptions
        this.conflictingElements = new ArrayList<ModelElement>();
        if (null != conflictingElements) {
            this.conflictingElements.addAll(conflictingElements);
        }
    }  
    
    /**
     * Creates a list with on element. 
     * 
     * @param element the element to put into the list
     * @return the list with <code>element</code> as member if <code><b>null</b> != element</code>, <b>null</b> else
     */
    public static final List<ModelElement> createList(ModelElement element) {
        List<ModelElement> result;
        if (null != element) {
            result = new ArrayList<ModelElement>();
            result.add(element);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the list of conflicting items.
     * @return The list of conflicting items
     */
    public List<ModelElement> getConflicts() {
        return conflictingElements;
    }
    
    /**
     * Returns the number of conflicting elements.
     * @return Number of conflicting elements.
     */
    public int getConflictsCount() {
        return conflictingElements.size();
    }
    
    /**
     * Method for adding conflicting element labels.
     * @param conflictingElementLabels conflicting element labels.
     */
    public void addConflictingElementLabels(List<String> conflictingElementLabels) {
        this.conflictingElementLabels = new ArrayList<String>();
        if (null != conflictingElementLabels) {
            this.conflictingElementLabels.addAll(conflictingElementLabels);
        }
    }
    
    /**
     * Returns the list of conflicting item labels.
     * @return The list of conflicting item labels
     */
    public List<String> getConflictLabels() {
        return conflictingElementLabels;
    }
    
    /**
     * Method for adding conflicting element comments.
     * @param conflictingElementComments conflicting element comments.
     */
    public void addConflictingElementComments(List<String> conflictingElementComments) {
        this.conflictingElementComments = new ArrayList<String>();
        if (null != conflictingElementComments) {
            this.conflictingElementComments.addAll(conflictingElementComments);
        }
    }
    
    /**
     * Returns the list of conflicting item comments.
     * @return The list of conflicting item comments.
     */
    public List<String> getConflictComments() {
        return conflictingElementComments;
    }
    
    /**
     * Method for adding conflicting element Suggestions.
     * @param conflictingElementSuggestions conflicting element Suggestions.
     */
    public void addConflictingElementSuggestions(List<String> conflictingElementSuggestions) {
        this.conflictingElementSuggestions = new ArrayList<String>();
        if (null != conflictingElementSuggestions) {
            this.conflictingElementSuggestions.addAll(conflictingElementSuggestions);
        }
    }
    
    /**
     * Returns the list of conflicting item Suggestions.
     * @return The list of conflicting item Suggestions.
     */
    public List<String> getConflictSuggestions() {
        return conflictingElementSuggestions;
    }
    
    /**
     * Method for adding conflicting element Projects.
     * @param conflictingElementProjects conflicting element Projects.
     */
    public void addConflictingElementProjects(List<Project> conflictingElementProjects) {
        this.conflictingElementProjects = new ArrayList<Project>();
        if (null != conflictingElementProjects) {
            this.conflictingElementProjects.addAll(conflictingElementProjects);
        }
    }
    
    /**
     * Returns the list of conflicting item Projects.
     * @return The list of conflicting item Projects.
     */
    public List<Project> getConflictProjects() {
        return conflictingElementProjects;
    }

    
    /**
     * Method for adding a list of {@link AbstractVariable}s that are involved in each failed constraint.
     * @param variables List of variables.
     */
    public void addConstraintVariables(List<Set<AbstractVariable>> variables) {
        this.variablesInConstraints = new ArrayList<Set<AbstractVariable>>();
        if (null != variablesInConstraints) {
            this.variablesInConstraints.addAll(variables);
        }
    }
    
    /**
     * Method for returning a list of {@link AbstractVariable}s that are involved in each failed constraint.
     * @return List of variables.
     */
    public List<Set<AbstractVariable>> getConstraintVariables() {
        return variablesInConstraints;
    }
    
    /**
     * Method for adding a list of {@link IDecisionVariable}s that are involved in each failed constraint.
     * @param variables List of variables.
     */
    public void addProblemVariables(List<Set<IDecisionVariable>> variables) {
        this.problemVariables = new ArrayList<Set<IDecisionVariable>>();
        if (null != problemVariables) {
            this.problemVariables.addAll(variables);
        }
    }
    
    /**
     * Method for returning a list of {@link IDecisionVariable}s that are involved in each failed constraint.
     * @return List of variables.
     */
    public List<Set<IDecisionVariable>> getProblemVariables() {
        return problemVariables;
    }
    
    /**
     * Method for adding a list of partial {@link ConstraintSyntaxTree}s that are involved in each failed constraint.
     * @param variables List of variables.
     */
    public void addProblemConstraintParts(List<ConstraintSyntaxTree> variables) {
        this.problemConstraintParts = new ArrayList<ConstraintSyntaxTree>();
        if (null != problemConstraintParts) {
            this.problemConstraintParts.addAll(variables);
        }
    }
    
    /**
     * Method for returning a list of partial {@link ConstraintSyntaxTree}s that are involved in each failed constraint.
     * @return List of variables.
     */
    public List<ConstraintSyntaxTree> getProblemConstraintParts() {
        return problemConstraintParts;
    }
    
    /**
     * Method for adding a list of ConstraintVariables of a failed constraint. Null if non.
     * @param constraintVariables ConstraintVariable or null.
     */
    public void addNamedConstraintVariables(List<IDecisionVariable> constraintVariables) {
        this.constraintVariables = new ArrayList<IDecisionVariable>();
        if (null != constraintVariables) {
            this.constraintVariables.addAll(constraintVariables);
        }
    }
    
    /**
     * Method for returning a list of ConstraintVariables of a failed constraint. Null if none.
     * @return List of ConstraintVariable or null.
     */
    public List<IDecisionVariable> getNamedConstraintVariables() {
        return constraintVariables;
    }
}
