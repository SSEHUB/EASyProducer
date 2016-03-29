package net.ssehub.easy.sseReasoner.functions;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Constraint;

/**
 * Class for storing Failed elements details.
 * @author Sizonenko
 *
 */
public class FailedElementDetails {

    private Set<IDecisionVariable> problemPoints;
    private ConstraintSyntaxTree problemConstraintPart;
    private Constraint problemConstraint;
    
    /**
     * Main constructor.
     */
    public FailedElementDetails() {
        problemPoints = new HashSet<IDecisionVariable>();
        problemConstraintPart = null;
        problemConstraint = null;
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
     * Method for adding the failed Constraints {@link Constraint}.
     * @param problemConstraint The failed constraint.
     */
    public void setProblemConstraint(Constraint problemConstraint) {
        this.problemConstraint = problemConstraint;
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
    /**
     * Method for returning the failed Constraint {@link Constraint}.
     * @return The failed constraint.
     */
    public Constraint getProblemConstraint() {
        return problemConstraint;
    }
}
