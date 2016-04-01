package de.uni_hildesheim.sse;

/**
 * Exception thrown in case that a constraint is given as string
 * and parsed by {@link ModelUtility#createConstraint(String, 
 * de.uni_hildesheim.sse.model.varModel.Project, boolean)}. Semantic
 * problems are handled by IVML model exceptions.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ConstraintSyntaxException extends Exception {

    /**
     * Creates a constraint syntax exception instance.
     * 
     * @param message a message denoting the syntax problem
     */
    public ConstraintSyntaxException(String message) {
        super(message);
    }

}
