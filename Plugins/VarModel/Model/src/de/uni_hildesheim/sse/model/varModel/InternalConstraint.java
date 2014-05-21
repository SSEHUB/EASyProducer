package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;


/**
 * Constraints for instances of an {@link DerivedDatatype}.
 * @author El-Sharkawy
 *
 */
public class InternalConstraint extends Constraint {
    
    private DerivedDatatype originType;

    /**
     * Creates a new internal constraint from an already parsed syntax tree.
     * 
     * @param originType The source of this constraint.
     * @param consSyntax the constraint syntax tree
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public InternalConstraint(DerivedDatatype originType, ConstraintSyntaxTree consSyntax, IModelElement parent)
        throws CSTSemanticException {
        
        super(originType.getName(), consSyntax, parent);
        this.originType = originType;
    }
    
    /**
     * Returns the {@link DerivedDatatype} where this constraints belongs to.
     * @return The source of this constraint.
     */
    public DerivedDatatype getDerivedDatatype() {
        return originType;
    }
}
