package de.uni_hildesheim.sse.translation;

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
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;

/**
 * Implements a visitor which searches for assignments. Instances of this class
 * may be reused by calling {@link #clear()} after use.
 */
public class AssignmentDetector implements IConstraintTreeVisitor {

    /**
     * The level specification to be used if traversal shall not be limited.
     */
    public static final int LEVEL_UNLIMITED = -1;

    /**
     * The level specification to be used if no deep traversal shall happen (just the top level).
     */
    public static final int NO_DEEP_TRAVERSAL = 0;

    private boolean isAssignment;
    private int maxLevel;
    private int level;
    
    /**
     * Defines the maximum search level.
     * 
     * @param level the maximum search level, may be {@link #LEVEL_UNLIMITED} in order
     * to avoid any level limitation or {@link #NO_DEEP_TRAVERSAL} in order to avoid
     */
    public void setMaxLevel(int level) {
        this.maxLevel = Math.max(-1, level);
    }
    
    /**
     * Returns whether the expression is an assignment at maximum at the given
     * level.
     * 
     * @return <code>true</code> if it is an assignment, <code>false</code> else
     */
    public boolean isAssignment() {
        return isAssignment;
    }

    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        isAssignment = false;
        maxLevel = -1;
        level = 0;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        // nothing to do
    }

    @Override
    public void visitVariable(Variable variable) {
        // nothing to do
    }

    /**
     * Returns whether the traversal of the given constraint shall be continued
     * in case of nested trees. Continuation is not needed if already an assignment
     * has been found or the maximum level is exceeded.
     * 
     * @return <code>true</code> if the traversal shall be continued, <code>false</code> else
     */
    private boolean continueTraversal() {
        return !isAssignment && (maxLevel < 0 || level <= maxLevel);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        if (continueTraversal()) {
            level++;
            parenthesis.getExpr().accept(this);
            level--;
        }
    }

    @Override
    public void visitComment(Comment comment) {
        // nothing to do
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (OclKeyWords.ASSIGNMENT.equals(call.getOperation())) {
            isAssignment = true;
        }
        if (continueTraversal()) {
            level++;
            if (null != call.getOperand()) { // incomplete xText
                call.getOperand().accept(this);
                for (int p = 0; !isAssignment && p < call.getParameterCount(); p++) {
                    call.getParameter(p).accept(this);
                }
            }
            level--;
        }
    }

    @Override
    public void visitLet(Let let) {
        if (continueTraversal()) {
            level++;
            let.getInExpression().accept(this);
            level--;
        }
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        if (continueTraversal()) {
            level++;
            ifThen.getIfExpr().accept(this);
            if (!isAssignment) {
                ifThen.getThenExpr().accept(this);
            }
            if (!isAssignment && null != ifThen.getElseExpr()) {
                ifThen.getElseExpr().accept(this);
            }
            level--;
        }
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        if (continueTraversal()) {
            level++;
            call.getContainer().accept(this);
            // don't check the expressions at all -> apply
            /*if (!isAssignment) {
                call.getExpression().accept(this);
            }*/
            level--;
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        if (continueTraversal()) {
            level++;
            access.getCompoundExpression().accept(this);
            level--;
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // nothing to do
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        if (continueTraversal()) {
            level++;
            for (int e = 0; !isAssignment && e < initializer.getExpressionCount(); e++) {
                initializer.getExpression(e).accept(this);
            }
            level--;
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        if (continueTraversal()) {
            level++;
            for (int e = 0; !isAssignment && e < initializer.getExpressionCount(); e++) {
                initializer.getExpression(e).accept(this);
            }
            level--;
        }
    }

    @Override
    public void visitSelf(Self self) {
        // not an assignment
    }

}
