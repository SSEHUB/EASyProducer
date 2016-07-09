package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * A visitor to retrieve constraints from collections.
 *
 */
public class AssignmentConstraintFinder implements IConstraintTreeVisitor {

    private boolean isAssignment;
    private List<Constraint> validationconstraints;
//    private Constraint currentConstraint;
    
    
    /**
     * Constructor of the visitor. Uses a single constraint.
     * @param cst Constraint that is visited to retrieve variables.
     */
    public AssignmentConstraintFinder(ConstraintSyntaxTree cst) {
        isAssignment = false;
        if (cst != null) {
            cst.accept(this);           
        }
    }
    
    /**
     * Constructor of the visitor. Uses a single constraint.
     * @param constraints Constraints that is visited to filter out vlidation constraints..
     */
    public AssignmentConstraintFinder(List<Constraint> constraints) {
        isAssignment = false;
        validationconstraints = new ArrayList<Constraint>();
        for (Constraint constraint : constraints) {
            constraint.getConsSyntax().accept(this);
            if (!isAssignment) {
                validationconstraints.add(constraint);
            }
            isAssignment = false;
        }
        
    }

    /**
     * Method for determine if constraint is an assignment.
     * @return true if holds collection of constraints.
     */
    public boolean isAssignment() {
        return isAssignment;
    }
    
    /**
     * Method for returning validation constraints.
     * @return List of validation constraints.
     */
    public List<Constraint> getValidationConstraints() {
        return validationconstraints;
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
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
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
        isAssignment = OclKeyWords.ASSIGNMENT.equals(call.getOperation());        
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

    @Override
    public void visitSelf(Self self) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }
   
}
