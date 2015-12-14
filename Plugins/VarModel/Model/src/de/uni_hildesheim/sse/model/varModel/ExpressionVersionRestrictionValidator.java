package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.utils.messages.IMessageHandler;

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
}
