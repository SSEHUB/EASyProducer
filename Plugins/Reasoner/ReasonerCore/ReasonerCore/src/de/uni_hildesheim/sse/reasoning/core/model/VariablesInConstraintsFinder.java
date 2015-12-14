package de.uni_hildesheim.sse.reasoning.core.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

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
