package net.ssehub.easy.reasoning.core.reasoner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.confModel.DisplayNameProvider;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.management.CommentResource;
import net.ssehub.easy.varModel.management.ModelCommentsPersistencer;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Part of the {@link ReasoningResult} class, expressing on error/warning of a complete {@link ReasoningResult}. Takes
 * a series of lists, which shall be consistent in size. Complex textual representations are calculated on demand
 * when requesting the respective information (rather than calculating this without need beforehand in a reasoner).
 * 
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class Message extends net.ssehub.easy.basics.messages.Message {

    // TODO refactor to a single, consistent list of entries. Left it for compatibility 
    private List<ModelElement> conflictingElements;
    private List<Set<AbstractVariable>> variablesInConstraints;
    private List<Set<IDecisionVariable>> problemVariables;
    private List<ConstraintSyntaxTree> problemConstraintParts = new ArrayList<ConstraintSyntaxTree>();
    private List<Constraint> problemConstraints;
    private List<Project> conflictingElementProjects;
    private List<SuggestionType> conflictingElementSuggestions;
    private List<IDecisionVariable> constraintVariables;
    private List<Integer> errorClassification;

    /**
     * Defines supported suggestion types. Please check {@link Message#getConflictSuggestions()} for turning them
     * into text.
     * 
     * @author Holger Eichelberger
     */
    public enum SuggestionType {
        PROBLEM_POINTS,
        REASSIGNMENT
    }
    
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
     * Returns the minimum of the three given integer values.
     * 
     * @param v1 the first value
     * @param v2 the second value
     * @param v3 the third value
     * @return the minimum of the three given integer values
     */
    private static int min(int v1, int v2, int v3) {
        return Math.min(Math.min(v1, v2), v3);
    }

    /**
     * Returns the minimum of the four given integer values.
     * 
     * @param v1 the first value
     * @param v2 the second value
     * @param v3 the third value
     * @param v4 the fourth value
     * @return the minimum of the four given integer values
     */
    private static int min(int v1, int v2, int v3, int v4) {
        return Math.min(Math.min(v1, v2), Math.min(v3, v4));
    }

    /**
     * Returns the list of conflicting item labels.
     * 
     * @return The list of conflicting item labels. The number of entries depends on the minimum number of 
     * conflicting element suggestions, conflicting elements, constraint variables and variables in constraints.
     */
    public List<String> getConflictLabels() {
        List<String> result;
        if (null == conflictingElementSuggestions) {
            result = null;
        } else {
            result = new ArrayList<String>();
            for (int i = 0, n = min(conflictingElementSuggestions.size(), conflictingElements.size(), 
                    constraintVariables.size(), variablesInConstraints.size()); i < n; i++) {
                String text;
                switch (conflictingElementSuggestions.get(i)) {
                case PROBLEM_POINTS:
                    text = toString(conflictingElements.get(i), constraintVariables.get(i)) + " Please check: " 
                        + problemPointsToString(variablesInConstraints.get(i));
                    break;
                case REASSIGNMENT:
                    text = toString(conflictingElements.get(i), null); 
                    break;
                default:
                    text = "none";
                    break;
                }
                result.add(text);
            }
        }
        return result;
    }
    
    /**
     * Returns the list of conflicting item comments.
     * 
     * @return The list of conflicting item comments. The number of entries depends on the minimum number of 
     * conflicting element suggestions, conflicting elements, and constraint variables.
     */
    public List<String> getConflictComments() {
        List<String> result;
        if (null == conflictingElementSuggestions) {
            result = null;
        } else {
            result = new ArrayList<String>();
            for (int i = 0, n = min(conflictingElementSuggestions.size(), conflictingElements.size(), 
                    constraintVariables.size()); i < n; i++) {
                String text;
                switch (conflictingElementSuggestions.get(i)) {
                case PROBLEM_POINTS:
                    text = toString(conflictingElements.get(i), constraintVariables.get(i));
                    break;
                case REASSIGNMENT:
                    text = toString(conflictingElements.get(i), null); 
                    break;
                default:
                    text = "none";
                    break;
                }
                result.add(text);
            }
        }
        return result;
    }
    
    /**
     * Turns a constraint into a string representation. If a named variable is given, use comment or name instead.
     * 
     * @param constraint the constraint
     * @param namedVariable the related named variable (may be <b>null</b>)
     * @return the string representation
     */
    private String toString(Constraint constraint, IDecisionVariable namedVariable) {
        String result = "";
        if (namedVariable != null) {
            AbstractVariable decl = namedVariable.getDeclaration();
            String comment = decl.getComment();
            if (null == comment) {
                result = decl.getName();  
            } else {
                result = decl.getComment();
            } 
        } 
        if (noResult(result)) {
            result = constraint.getComment();
            if (noResult(result)) {
                try {
                    CommentResource cr = ModelCommentsPersistencer.getComments(constraint.getProject());
                    if (null != cr) {
                        result = cr.get(ModelCommentsPersistencer.getKey(constraint));
                    }
                } catch (IOException e) {
                }
                if ((noResult(result))) {
                    result = StringProvider.toIvmlString(constraint.getConsSyntax());
                }
            }
        }
        return result;
    }
    
    private static boolean noResult(String result) {
        return null == result || result.length() == 0;
    }

    /**
     * Turns a model element into a string representation. Considers {@link DisplayNameProvider} and 
     * {@link #toString(Constraint, IDecisionVariable)}.
     * 
     * @param elt the element to be turned into a string representation
     * @param namedVariable the related named variable (may be <b>null</b>)
     * @return the string representation
     */
    private String toString(ModelElement elt, IDecisionVariable namedVariable) {
        String result;
        if (elt instanceof AbstractVariable) {
            result = DisplayNameProvider.getInstance().getDisplayName((AbstractVariable) elt);
        } else if (elt instanceof IDecisionVariable) {
            result = DisplayNameProvider.getInstance().getDisplayName((IDecisionVariable) elt);
        } else if (elt instanceof Constraint) {
            result = toString((Constraint) elt, namedVariable);
        } else {
            result = elt.getName();
        }
        return result + " (" + traceToTop(elt) + " )";
    }
    
    /**
     * Method for creating a msg of trace to the top element 
     * of constraint or variable that fail in the reasoning.
     * @param element Constraint of Variable.
     * @return text text of the trace.
     */
    private String traceToTop(ModelElement element) {
        String text = "";
        if (element.getParent() != null) {
            text = " -> " + element.getParent().getName();
            ModelElement mElement = (ModelElement) element.getParent();
            text = text + traceToTop(mElement);
        }
        return text;
    }
    
    /**
     * Method for adding conflicting element Suggestions.
     * @param conflictingElementSuggestions conflicting element Suggestions.
     */
    public void addConflictingElementSuggestions(List<SuggestionType> conflictingElementSuggestions) {
        this.conflictingElementSuggestions = new ArrayList<SuggestionType>();
        if (null != conflictingElementSuggestions) {
            this.conflictingElementSuggestions.addAll(conflictingElementSuggestions);
        }
    }

    /**
     * Returns the list of conflicting item suggestion types.
     * @return The list of conflicting item suggestion types.
     */
    public List<SuggestionType> getConflictSuggestionTypes() {
        return conflictingElementSuggestions;
    }

    /**
     * Returns the list of conflicting item Suggestions.
     * 
     * @return The list of conflicting item Suggestions. The number of entries depends on the minimum number of 
     * conflicting element suggestions and variables in constraints.
     */
    public List<String> getConflictSuggestions() {
        List<String> result;
        if (null == conflictingElementSuggestions) {
            result = null;
        } else {
            result = new ArrayList<String>();
            for (int i = 0, 
                n = Math.min(conflictingElementSuggestions.size(), variablesInConstraints.size()); i < n; i++) {
                String text;
                switch (conflictingElementSuggestions.get(i)) {
                case PROBLEM_POINTS:
                    text = "Please check: " + problemPointsToString(variablesInConstraints.get(i));
                    break;
                case REASSIGNMENT:
                    text = "Check for variable reassignments in the same Project scope";
                    break;
                default:
                    text = "none";
                    break;
                }
                result.add(text);
            }
        }
        return result;
    }

    /**
     * Turns given variables into a problem points description.
     * 
     * @param vars the variables
     * @return the description
     */
    private String problemPointsToString(java.util.Set<AbstractVariable> vars) {
        String problemPoints = "";
        int count = 0;
        for (AbstractVariable variable : vars) {
            if (count > 0) {
                if (count == vars.size() - 1) {
                    problemPoints += " or ";
                } else {
                    problemPoints += ", ";
                }
            }
            String displayVarName = DisplayNameProvider.getInstance().getDisplayName(variable);
            String displayParentName = DisplayNameProvider.getInstance().getParentNames(variable);
            if (displayParentName != null) {
                problemPoints = problemPoints + "\"" + displayVarName + "\" in " + displayParentName;
            } else {
                problemPoints = problemPoints + "\"" + displayVarName + "\"";
            }
            count++;
        }
        return problemPoints;
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
     * @param constraints List of constraint trees (elements may be <tt>null</tt>). The entries in this 
     * list must correspond to {@link #addProblemConstraints(List)}.
     */
    public void addProblemConstraintParts(List<ConstraintSyntaxTree> constraints) {
        if (null != constraints) {
            this.problemConstraintParts.addAll(constraints);
        }
    }
    
    /**
     * Method for adding a list of {@link Constraint}s that are involved in each failed constraint. The entries in this 
     * list must correspond to {@link #addProblemConstraintParts(List)}.
     * @param constraints List of constraints.
     */
    public void addProblemConstraints(List<Constraint> constraints) {
        this.problemConstraints = new ArrayList<Constraint>();
        if (null != problemConstraints) {
            this.problemConstraints.addAll(constraints);
        }
    }
    
    /**
     * Method for returning a list of partial {@link ConstraintSyntaxTree}s that are involved in each failed constraint.
     * The result must correspond to {@link #getProblemConstraints()}.
     * @return List of constraint syntax trees.
     */
    public List<ConstraintSyntaxTree> getProblemConstraintParts() {
        return problemConstraintParts;
    }

    /**
     * Method for returning a list of full {@link Constraint}s that are involved in each failed constraint.
     * The result must correspond to {@link #getProblemConstraintParts()}.
     * @return List of constraints.
     */
    public List<Constraint> getProblemConstraints() {
        return problemConstraints;
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
    
    /**
     * Method for adding a list of reasoning error classifiers Null if non.
     * @param errorClassification defined error codes or null.
     */
    public void addErrorClassification(List<Integer> errorClassification) {
        this.errorClassification = new ArrayList<Integer>();
        if (null != errorClassification) {
            this.errorClassification.addAll(errorClassification);
        }
    }
    
    /**
     * Method for returning a list of reasoning error classifiers. Null if none.
     * @return List of error codes or null.
     */
    public List<Integer> getErrorClassification() {
        return errorClassification;
    }
    
    @Override
    public String toString() {
        String res = "";
        List<String> labels = getConflictLabels();
        List<String> comments = getConflictComments();
        List<Project> projects = getConflictProjects();
        List<String> suggestions = getConflictSuggestions();
        List<Set<IDecisionVariable>> vars = getProblemVariables();
        List<ConstraintSyntaxTree> parts = getProblemConstraintParts();
        List<IDecisionVariable> namedVars = getNamedConstraintVariables();
        List<Integer> codes = getErrorClassification();
        for (int i = 0; i < getConflictsCount(); i++) {
            ModelElement conflict = getConflicts().get(i);
            if (i > 0) {
                res += "\n";
            }
            if (conflict instanceof Constraint) {
                Constraint constraint = (Constraint) conflict;
                res = append(res, "Failed element (EP): " + StringProvider.toIvmlString(constraint.getConsSyntax())); 
            } else {
                res = append(res, "Failed element (EP): " + StringProvider.toIvmlString(conflict));
            }
            res = append(res, "Failed elements label (CT): " + labels.get(i));
            res = append(res, "Failed elements comment: " + comments.get(i));
            res = append(res, "Failed elements project: " + projects.get(i).getName());
            res = append(res, "Failed elements suggestion: " + suggestions.get(i));
            res = append(res, "Failed elements variables: " + vars.get(i));
            if (parts.get(i) != null) {
                res = append(res, "Failed elements problem constraint parts: " 
                    + StringProvider.toIvmlString(parts.get(i)));                
            }
            res = append(res, "Failed elements constraint variable: " + namedVars.get(i)); 
            res = append(res, "Reasoning error code: " + codes.get(i));
        }
        return res;
    }
    
    /**
     * Appends <code>text</code> and a line end to <code>res</code>.
     * 
     * @param res the text to append to
     * @param text the text to append
     * @return the combined text
     */
    private String append(String res, String text) {
        return res + text + "\n";
    }
    
}
