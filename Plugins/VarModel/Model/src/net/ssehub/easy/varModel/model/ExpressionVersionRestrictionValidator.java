package net.ssehub.easy.varModel.model;

import net.ssehub.easy.basics.messages.IMessageHandler;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;

/**
 * A simple validator for version restrictions, disallowing if-then-else, let-in and 
 * compound initializers.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionVersionRestrictionValidator implements IConstraintTreeVisitor {
    
    private IMessageHandler handler;

    /**
     * Creates an expression version validator.
     * 
     * @param handler the message handler (may be <b>null</b> for no handler)
     */
    public ExpressionVersionRestrictionValidator(IMessageHandler handler) {
        this.handler = handler;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        // ok
    }

    @Override
    public void visitVariable(Variable variable) {
        // ok
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
        // ok
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        // simple comparisons are already of this kind
        call.getOperand().accept(this);
        for (int a = 0; a < call.getParameterCount(); a++) {
            call.getParameter(a).accept(this);
        }
    }
    
    @Override
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this);
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        // at the moment I do not see way we need them here
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // at the moment I do not see way we need them here
        emit("if-then-else expressions are not allowed here", true, CSTSemanticException.ILLEGAL);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // simple comparisons are already of this kind
        call.getContainer().accept(this);
        call.getExpression().accept(this);
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // this is ok, required for project.version
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        emit("unresolved expressions are not allowed here", true, CSTSemanticException.ILLEGAL);
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // at the moment I do not see way we need them here
        emit("compound initializers are not allowed here", true, CSTSemanticException.ILLEGAL);
    }
    
    /**
     * Emits the given message to the handler.
     * 
     * @param message the message
     * @param error error or warning
     * @param code the message code
     */
    private void emit(String message, boolean error, int code) {
        if (null != handler) {
            handler.handle(message, error, code);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // ok for now
    }

    @Override
    public void visitSelf(Self self) {
        // ok as not allowed
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }
    
    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
