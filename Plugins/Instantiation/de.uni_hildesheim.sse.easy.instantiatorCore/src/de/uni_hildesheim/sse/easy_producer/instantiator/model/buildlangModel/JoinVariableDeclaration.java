package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

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
     * @throws ExpressionException in case of structural or semantic errors
     */
    public JoinVariableDeclaration(String name, Expression expr, boolean exclude) throws ExpressionException {
        super(name, getJoinVariableType(expr), false, expr);
        this.exclude = exclude;
    }
    
    /**
     * Determine the type of the join variable from the initializing expression.
     * 
     * @param expr the expression used for the initialization
     * @return the actual type of the join variable
     * @throws ExpressionException in case that <code>expr</code> is not a collection or does not have exactly 
     *   one parameter
     */
    private static TypeDescriptor<? extends IVilType> getJoinVariableType(Expression expr) throws ExpressionException {
        TypeDescriptor<? extends IVilType> exprType = expr.inferType();
        if (exprType.isCollection() && 1 != exprType.getParameterCount()) {
            throw new ExpressionException("parameter must be set or sequence with one generic type", 
                ExpressionException.ID_SEMANTIC);
        }
        return exprType.getParameterType(0);
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
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitJoinVariableDeclaration(this);
    }

}
