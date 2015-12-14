package de.uni_hildesheim.sse.reasoning.reasoner.model;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
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
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;

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

   
}
