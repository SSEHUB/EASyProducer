package de.uni_hildesheim.sse.reasoning.core.model;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;

/**
 * A visitor to retrieve constraint that are used for value propagation.
 *
 */
public class ConstraintPatternFinder implements IConstraintTreeVisitor {

    private Boolean validAssignmentConstraint;
    private Boolean validImpliesConstraint;
    
    /**
     * Constructor of the visitor. Uses a single constraint.
     * @param constraint Constraint that is visited to retrieve variables.
     */
    public ConstraintPatternFinder(ConstraintSyntaxTree constraint) {
        this.validAssignmentConstraint = false;
        this.validImpliesConstraint = false;
        constraint.accept(this);
    }
    
    /**
     * Method to get if constraint is used for value propagation.
     * @return Boolean value true id constraint is used for value propagation.
     */
    public Boolean isValueAssignmentConstraint() {
        return validAssignmentConstraint;
    }
    
    /**
     * Method to get if constraint is an "implies" constraint.
     * @return Boolean value true id constraint is used for value propagation.
     */
    public Boolean isImpliesConstraint() {
        return validImpliesConstraint;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        // Not needed
    }

    @Override
    public void visitVariable(Variable variable) {
        // Not needed
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // Keep running/visiting
        parenthesis.getExpr().accept(this);        
    }

    @Override
    public void visitComment(Comment comment) {
        // Keep running/visiting
        comment.getExpr().accept(this);
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
            validAssignmentConstraint = true;
        }
        if (call.getOperation().equals(OclKeyWords.IMPLIES)) {
            validImpliesConstraint = true;
        }        
        call.getOperand().accept(this);
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
    }

    @Override
    public void visitDslFragment(DslFragment fragment) {
        // Not needed
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        ConstraintSyntaxTree nestedConstraint = expression.getActualExpression();
        if (null != nestedConstraint) {
            nestedConstraint.accept(this);
        }
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            initializer.getExpression(i).accept(this);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            initializer.getExpression(i).accept(this);
        }
    }

   
}
