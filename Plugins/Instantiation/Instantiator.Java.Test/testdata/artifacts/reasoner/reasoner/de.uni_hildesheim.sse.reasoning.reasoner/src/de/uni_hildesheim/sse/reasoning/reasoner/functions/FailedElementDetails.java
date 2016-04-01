package de.uni_hildesheim.sse.reasoning.reasoner.functions;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;

/**
 * Class for storing Failed elements details.
 * @author Sizonenko
 *
 */
public class FailedElementDetails {

    private Set<IDecisionVariable> problemPoints;
    private ConstraintSyntaxTree problemConstraintPart;
    
    /**
     * Main constructor.
     */
    public FailedElementDetails() {
        problemPoints = new HashSet<IDecisionVariable>();
        problemConstraintPart = null;
    }
    
    /**
     * Method for adding a set of {@link IDecisionVariable}s that may caused a constraint to fail.
     * @param problemPoints Set of {@link IDecisionVariable}s.
     */
    public void setProblemPoints(Set<IDecisionVariable> problemPoints) {
        this.problemPoints = problemPoints;
    }
    
    /**
     * Method for adding a part of failed Constraints {@link ConstraintSyntaxTree}.
     * @param problemConstraintPart Part of failed constraint.
     */
    public void setProblemConstraintPart(ConstraintSyntaxTree problemConstraintPart) {
        this.problemConstraintPart = problemConstraintPart;
    }
    
    /**
     * Method for returning a set of {@link IDecisionVariable}s that may caused a constraint to fail.
     * @return problemPoints Set of {@link IDecisionVariable}s.
     */
    public Set<IDecisionVariable> getProblemPoints() {
        return problemPoints;
    }
    
    /**
     * Method for returning a part of failed Constraints {@link ConstraintSyntaxTree}.
     * @return Part of failed constraint.
     */
    public ConstraintSyntaxTree getProblemConstraintPart() {
        return problemConstraintPart;
    }
}
