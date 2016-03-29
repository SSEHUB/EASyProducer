package net.ssehub.easy.reasonerCore.reasoner;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.model.Constraint;

/**
 * A specific reasoning result for evaluations of presence conditions.
 * 
 * @author Holger Eichelberger
 */
public class EvaluationResult extends ReasoningResult {

    /**
     * Denotes the possible results of a constraint evaluation.
     * 
     * @author Holger Eichelberger
     */
    public enum ConstraintEvaluationResult {

        /**
         * Signals that the constraint was evaluated to <code>true</code>.
         */
        TRUE,

        /**
         * Signals that the constraint was evaluated to <code>false</code>.
         */
        FALSE,

        /**
         * Signals that the constraint cannot be evaluated at all.
         */
        UNKNOWN;
    }

    /**
     * Defines a pair of a constraint and its evaluation result.
     * 
     * @author Holger Eichelberger
     */
    public static class EvaluationPair {
        private Constraint constraint;
        private ConstraintEvaluationResult result;

        /**
         * Creates a pair with an unknown evaluation result.
         * 
         * @param constraint the constraint
         */
        public EvaluationPair(Constraint constraint) {
            this(constraint, ConstraintEvaluationResult.UNKNOWN);
        }

        /**
         * Creates a pair with a given evaluation result.
         * 
         * @param constraint the constraint
         * @param result the evaluation result
         */
        public EvaluationPair(Constraint constraint, ConstraintEvaluationResult result) {
            this.constraint = constraint;
            this.result = result;
        }

        /**
         * Changes the evaluation result.
         * 
         * @param result the new evaluation result
         */
        public void setResult(ConstraintEvaluationResult result) {
            assert null != result;
            this.result = result;
        }

        /**
         * Returns the constraint.
         * 
         * @return the constraint
         */
        public Constraint getConstraint() {
            return constraint;
        }

        /**
         * Returns the evaluation result.
         * 
         * @return the evaluation result
         */
        public ConstraintEvaluationResult getResult() {
            return result;
        }
    }

    private List<EvaluationPair> evaluatedConstraints = new ArrayList<EvaluationPair>();

    /**
     * Creates an instance.
     */
    public EvaluationResult() {
        super();
    }

    /**
     * Creates an instance of a result signalling an unsupported operation.
     * 
     * @param reasonerName the name of the reasoner which does not support the operation
     */
    public EvaluationResult(String reasonerName) {
        super(reasonerName);
    }

    /**
     * Adds an evaluation pair.
     * 
     * @param pair the pair to be added
     */
    public void addEvaluationPair(EvaluationPair pair) {
        evaluatedConstraints.add(pair);
    }

    /**
     * Returns the number of stored evaluation pairs.
     * 
     * @return the number of evaluation pairs
     */
    public int getEvaluationPairCount() {
        return evaluatedConstraints.size();
    }

    /**
     * Returns an evaluation pair.
     * 
     * @param index the index of the pair
     * @return the pair
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getEvaluationPairCount()}</code>
     */
    public EvaluationPair getEvaluationPair(int index) {
        return evaluatedConstraints.get(index);
    }
}
