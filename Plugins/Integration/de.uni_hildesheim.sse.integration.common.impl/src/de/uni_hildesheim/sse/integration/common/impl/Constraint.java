package de.uni_hildesheim.sse.integration.common.impl;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.integration.common.IConstraint;
import de.uni_hildesheim.sse.integration.common.ModelException;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * Implements the constraint (delegate).
 *  
 * @author Holger Eichelberger
 */
public class Constraint implements IConstraint {

    private de.uni_hildesheim.sse.model.varModel.Constraint constraint;
    
    /**
     * Creates a new constraint instances, i.e. parses the input.
     * 
     * @param constraint the constraint in textual IVML form
     * @param project the context for the semantic analysis
     * @throws ModelException in case of any syntactial or semantical problems
     */
    public Constraint(String constraint, Project project) throws ModelException {
        try {
            this.constraint = ModelUtility.INSTANCE.createConstraint(constraint, project, false);
        } catch (CSTSemanticException e) {
            throw new ModelException(e);
        } catch (ConstraintSyntaxException e) {
            throw new ModelException(e);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName() {
        return constraint.getName();
    }
        
    /**
     * {@inheritDoc}
     */
    public String toString() {
        return StringProvider.toIvmlString(constraint.getConsSyntax());
    }
    
    /**
     * Returns the related IVML instance.
     * 
     * @return the related IVML instance
     */
    public de.uni_hildesheim.sse.model.varModel.Constraint getInstance() {
        return constraint;
    }

}
