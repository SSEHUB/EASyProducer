package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * A visitor interface for expressions.
 * 
 * @author Holger Eichelberger
 */
public interface IExpressionVisitor {

    /**
     * Visits a parenthesis node.
     * 
     * @param par the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException;

    /**
     * Visits a call node.
     * 
     * @param call the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitCallExpression(CallExpression call) throws VilException;

    /**
     * Visits a constant node.
     * 
     * @param cst the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitConstantExpression(ConstantExpression cst) throws VilException;

    /**
     * Visits a variability model identifier.
     * 
     * @param identifier the identifier
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws VilException;

    /**
     * Visits a VIL type expression.
     * 
     * @param typeExpression the expression
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException;
    
    /**
     * Visits a constant node.
     * 
     * @param cst the node
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitVariableExpression(VariableExpression cst) throws VilException;

    /**
     * Visits an expression evaluator.
     * 
     * @param ex the evaluator
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException;
    
    /**
     * Visits an unspecified expression (in case of specialized nodes).
     * 
     * @param ex the node
     * @return the result of visiting this expression (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitExpression(Expression ex) throws VilException;

    /**
     * Visits a value assignment expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException;

    /**
     * Visits a container initializer expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException;
    
    /**
     * Visits a composite expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException;

    /**
     * Visits a field access expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException;

    /**
     * Visits resolvable operation expression (function pointer resolution).
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException;

    /**
     * Visits resolvable operation call expression (function pointer call).
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */    
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException;
    
}
