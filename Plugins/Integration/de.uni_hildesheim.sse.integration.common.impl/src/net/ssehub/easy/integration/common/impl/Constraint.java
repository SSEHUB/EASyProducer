package net.ssehub.easy.integration.common.impl;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.integration.common.IConstraint;
import net.ssehub.easy.integration.common.ModelException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Implements the constraint (delegate).
 *  
 * @author Holger Eichelberger
 */
public class Constraint implements IConstraint {

    private net.ssehub.easy.varModel.model.Constraint constraint;
    
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
    
    @Override
    public String getName() {
        return constraint.getName();
    }
        
    @Override
    public String toString() {
        return StringProvider.toIvmlString(constraint.getConsSyntax());
    }
    
    /**
     * Returns the related IVML instance.
     * 
     * @return the related IVML instance
     */
    public net.ssehub.easy.varModel.model.Constraint getInstance() {
        return constraint;
    }

}
