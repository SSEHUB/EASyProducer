package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;

/**
 * Visitor methods for the match expressions.
 * 
 * @author Holger Eichelberger
 */
public interface IMatchVisitor {

    /**
     * Visits a path match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException;

    /**
     * Visits a string match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException;

    /**
     * Visits an artifact match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException;

    /**
     * Visits a collection match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException;
    
}
