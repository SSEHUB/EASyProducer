package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Defines a variable declaration for VIL joins.
 * 
 * @author Holger Eichelberger
 */
public class JoinVariableDeclaration extends VariableDeclaration {

    private boolean exclude;
    
    /**
     * Creates a new variable declaration.
     * 
     * @param name the name of the variable
     * @param expr the initializing expression (must be given)
     * @param exclude if this join variable shall be excluded from the join result
     * @throws VilException in case of structural or semantic errors
     */
    public JoinVariableDeclaration(String name, Expression expr, boolean exclude) throws VilException {
        super(name, getJoinVariableType(expr), false, expr);
        this.exclude = exclude;
    }
    
    /**
     * Determine the type of the join variable from the initializing expression.
     * 
     * @param expr the expression used for the initialization
     * @return the actual type of the join variable
     * @throws VilException in case that <code>expr</code> is not a collection or does not have exactly 
     *   one parameter
     */
    private static TypeDescriptor<?> getJoinVariableType(Expression expr) throws VilException {
        TypeDescriptor<?> exprType = expr.inferType();
        if (exprType.isCollection() && 1 != exprType.getGenericParameterCount()) {
            throw new VilException("parameter must be set or sequence with one generic type", 
                VilException.ID_SEMANTIC);
        }
        return exprType.getGenericParameterType(0);
    }
    
    /**
     * Returns whether this variable shall be excluded from the join result.
     * 
     * @return <code>true</code> if it shall be excluded, <code>false</code> else
     */
    public boolean isExcluded() {
        return exclude;
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitJoinVariableDeclaration(this);
    }

}
