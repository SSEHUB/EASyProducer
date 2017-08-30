package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * An expression used in the instantiation languages.
 * 
 * @author Holger Eichelberger
 */
public abstract class Expression {

    /**
     * Infers the type of this expression including the type of the contained sub-expressions.
     * 
     * @return the type of this expression
     * @throws VilException in case that inferring the type fails
     */
    public abstract TypeDescriptor<?> inferType() throws VilException;
    
    /**
     * Visits the expression.
     * 
     * @param visitor the visitor
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public abstract Object accept(IExpressionVisitor visitor) throws VilException;

    /**
     * In content replacement, replace an entire line if this expression is
     * evaluated to an empty string.
     * 
     * @return <code>true</code> for replace entire line, <code>false</code> (default) else
     */
    public boolean replaceEmptyLine() {
        return false;
    }
    
}
