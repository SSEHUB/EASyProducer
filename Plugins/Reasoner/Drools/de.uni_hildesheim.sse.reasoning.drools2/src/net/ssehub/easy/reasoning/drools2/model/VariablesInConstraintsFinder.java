package net.ssehub.easy.reasoning.drools2.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
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
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * A visitor to retrieve variables from constraints.
 *
 */
class VariablesInConstraintsFinder implements IConstraintTreeVisitor {

    private Set<AbstractVariable> variables;
    
    
    /**
     * Constructor of the visitor. Uses collection of constraints.
     * @param constraints Constraints that is visited to retrieve variables.
     */
    VariablesInConstraintsFinder(Collection<ConstraintSyntaxTree> constraints) {
        variables = new HashSet<AbstractVariable>();
        for (ConstraintSyntaxTree constraintSyntaxTree : constraints) {
            constraintSyntaxTree.accept(this);            
        }
    }
    
    /**
     * Constructor of the visitor. Uses a single constraint.
     * @param constraint Constraint that is visited to retrieve variables.
     */
    VariablesInConstraintsFinder(ConstraintSyntaxTree constraint) {
        variables = new HashSet<AbstractVariable>();        
        constraint.accept(this);            
        
    }
    
    /**
     * Method to get all variables that are used in constraints.
     * @return List of {@link AbstractVariable}s (maybe empty, but not <tt>null</tt>).
     */
    Set<AbstractVariable> getVariables() {
        return variables;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        // Not needed
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable wrappedDeclaration = variable.getVariable();
        variables.add(wrappedDeclaration);
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        variable.getQualifier().accept(this);
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
        call.getOperand().accept(this);
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }
    
    @Override
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this); // transparent
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
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
