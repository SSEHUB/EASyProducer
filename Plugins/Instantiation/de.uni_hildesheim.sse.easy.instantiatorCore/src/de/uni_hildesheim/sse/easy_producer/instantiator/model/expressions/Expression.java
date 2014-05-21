package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

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
     * @throws ExpressionException in case that inferring the type fails
     */
    public abstract TypeDescriptor<? extends IVilType> inferType() throws ExpressionException;
    
    /**
     * Visits the expression.
     * 
     * @param visitor the visitor
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public abstract Object accept(IExpressionVisitor visitor) throws ExpressionException;
    
}
