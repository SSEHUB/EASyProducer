package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Implements a specific expression for defining local variables with variable initialization
 * expressions in iterator expressions. Therefore, this expression may override the 
 * initialization expression of the "in" variable.
 * 
 * @author Holger Eichelberger
 */
class IterLet extends Let {

    private ConstraintSyntaxTree init;
    
    /**
     * Creates an iterator let-expression.
     * 
     * @param var the variable to be defined
     * @param init the initialization expression (may be <b>null</b>, then the default expression of 
     *     <code>var</code> takes precedence)
     * @param inExpr the expression <code>var</code> is used in
     */
    public IterLet(DecisionVariableDeclaration var, ConstraintSyntaxTree init, ConstraintSyntaxTree inExpr) {
        super(var, inExpr);
        this.init = init;
    }
    
    @Override
    public ConstraintSyntaxTree getInitExpression() {
        return null != init ? init : getVariable().getDefaultValue();
    }

}
