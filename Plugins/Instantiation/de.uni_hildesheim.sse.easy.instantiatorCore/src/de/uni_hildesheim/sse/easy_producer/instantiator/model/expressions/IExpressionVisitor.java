package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

/**
 * A visitor interface.
 * 
 * @author Holger Eichelberger
 */
public interface IExpressionVisitor {

    /**
     * Visits a parenthesis node.
     * 
     * @param par the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException;

    /**
     * Visits a call node.
     * 
     * @param call the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitCallExpression(CallExpression call) throws ExpressionException;

    /**
     * Visits a constant node.
     * 
     * @param cst the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException;

    /**
     * Visits a variability model identifier.
     * 
     * @param identifier the identifier
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) throws ExpressionException;

    /**
     * Visits a VIL type expression.
     * 
     * @param typeExpression the expression
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException;
    
    /**
     * Visits a constant node.
     * 
     * @param cst the node
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException;

    /**
     * Visits an expression evaluator.
     * 
     * @param ex the evaluator
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException;
    
    /**
     * Visits an unspecified expression (in case of specialized nodes).
     * 
     * @param ex the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitExpression(Expression ex) throws ExpressionException;

    /**
     * Visits a value assignment expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException;

    /**
     * Visits a container initializer expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws ExpressionException in case that visiting fails (e.g., execution)
     */
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException;
    
}
