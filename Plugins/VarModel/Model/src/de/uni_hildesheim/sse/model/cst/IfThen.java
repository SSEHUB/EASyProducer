package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a conditional expression.
 * 
 * @author Holger Eichelberger
 */
public class IfThen extends ConstraintSyntaxTree {

    private ConstraintSyntaxTree ifExpr;
    private ConstraintSyntaxTree thenExpr;
    private ConstraintSyntaxTree elseExpr;
    private IDatatype result;

    /**
     * Creates a new if-then-else node.
     * 
     * @param ifExpr the condition expression
     * @param thenExpr the then-path-expression
     * @param elseExpr the else-path-expression
     */
    public IfThen(ConstraintSyntaxTree ifExpr, ConstraintSyntaxTree thenExpr, 
        ConstraintSyntaxTree elseExpr) {
        this.ifExpr = ifExpr;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    /**
     * Returns the condition expression.
     * 
     * @return the condition expression
     */
    public ConstraintSyntaxTree getIfExpr() {
        return ifExpr;
    }

    /**
     * Returns the then-expression.
     * 
     * @return the then-expression
     */
    public ConstraintSyntaxTree getThenExpr() {
        return thenExpr;
    }

    /**
     * Returns the else-expression.
     * 
     * @return the else-expression
     */
    public ConstraintSyntaxTree getElseExpr() {
        return elseExpr;
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null == result) {
            IDatatype ifType = ifExpr.inferDatatype();
            if (!BooleanType.TYPE.isAssignableFrom(ifType)) {
                throw new CSTSemanticException("if expression type ('"
                    + ifType.getName() + "') is not Boolean", CSTSemanticException.TYPE_MISMATCH);
            }
            IDatatype thenType = thenExpr.inferDatatype();
            IDatatype elseType = elseExpr.inferDatatype();
            if (!thenType.isAssignableFrom(elseType)) {
                throw new CSTSemanticException("types of then ('"
                    + thenType.getName() + "') and else ('" 
                    + elseType.getName() + "') part do not match", CSTSemanticException.TYPE_MISMATCH);
            }
            result = thenType;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitIfThen(this); // no further operations!
    }
    
}
