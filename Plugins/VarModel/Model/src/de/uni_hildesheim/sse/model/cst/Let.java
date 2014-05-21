package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a let expression, i.e. a local variable declaration which 
 * can be used in the attached expression.
 * 
 * @author Holger Eichelberger
 */
public class Let extends ConstraintSyntaxTree {

    private DecisionVariableDeclaration var;
    private ConstraintSyntaxTree inExpr;
    
    /**
     * Creates a new let expression.
     * @param var the local variable
     * @param inExpr the expression the local variable may be used in
     */
    public Let(DecisionVariableDeclaration var, ConstraintSyntaxTree inExpr) {
        this.var = var;
        this.inExpr = inExpr;
    }
    
    /**
     * Returns the local variable.
     * 
     * @return the local variable
     */
    public DecisionVariableDeclaration getVariable() {
        return var;
    }
    
    /**
     * Returns the expression the local variable may be used in.
     * 
     * @return the expression using the local variable
     */
    public ConstraintSyntaxTree getInExpression() {
        return inExpr;
    }
    
    /**
     * {@inheritDoc}
     */
    public IDatatype inferDatatype() throws CSTSemanticException {
        return inExpr.inferDatatype();
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitLet(this); // no further operations!
    }

}
