package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.utils.messages.IMessageHandler;

/**
 * Implements a basic expression version restriction validator.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionVersionRestrictionValidator implements IExpressionVisitor {

    private IMessageHandler handler;
    
    /**
     * Creates the validator with a message handler.
     * 
     * @param handler the message handler (may be <b>null</b> for absent)
     */
    public ExpressionVersionRestrictionValidator(IMessageHandler handler) {
        this.handler = handler;
    }
    
    /**
     * Emits a message to the message handler.
     * 
     * @param description the message description
     * @param error whether it is an error
     * @param code an internal message code (debugging)
     */
    protected void emit(String description, boolean error, int code) {
        if (null != handler) {
            handler.handle(description, error, code);
        }
    }
    
    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException {
        return par.getExpr().accept(this);
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws ExpressionException {
        for (int a = 0; a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null; // is ok
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        return null; // is ok
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws ExpressionException {
        return null; // probably ok for future
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException {
        return null; // probably ok for future
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException {
        return null; // ok
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException {
        return null; // probably ok for future
    }

    @Override
    public Object visitExpression(Expression ex) throws ExpressionException {
        return null; // generic fallback
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException {
        emit("no value assignments supported here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException {
        return null; // probably ok
    }

}
