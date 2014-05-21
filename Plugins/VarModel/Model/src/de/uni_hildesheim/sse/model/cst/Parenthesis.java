package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a parenthesis. The value of a parenthesis is just the 
 * value of the contained expression. This class is used to represent
 * explicit sub expressions.
 * 
 * @author Holger Eichelberger
 */
public class Parenthesis extends ConstraintSyntaxTree {

    /**
     * Stores the expression in the parenthesis.
     */
    private ConstraintSyntaxTree expr;
    
    /**
     * Creates a new parenthesis node.
     * 
     * @param expr the nested expression
     */
    public Parenthesis(ConstraintSyntaxTree expr) {
        this.expr = expr;
    }

    /**
     * Returns the nested expression.
     * 
     * @return the nested expression
     */
    public ConstraintSyntaxTree getExpr() {
        return expr;
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype inferDatatype() throws CSTSemanticException {
        return expr.inferDatatype();
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitParenthesis(this); // no further operations!
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = expr.equals(obj);
        return equals;        
    }
    
    @Override
    public int hashCode() {
        int hashCode = expr.hashCode();
        //TODO ML create a unique hashCode-method for Parenthesis
        //To decide between parenthesis and OCLFeatureCall we engineer the hashCode
        hashCode = hashCode * 13;
        return hashCode;        
    }

}
