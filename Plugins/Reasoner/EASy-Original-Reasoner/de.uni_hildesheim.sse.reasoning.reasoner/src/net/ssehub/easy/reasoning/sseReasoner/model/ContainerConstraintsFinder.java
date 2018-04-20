package net.ssehub.easy.reasoning.sseReasoner.model;

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
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * A visitor to retrieve constraints from containers.
 */
public class ContainerConstraintsFinder implements IConstraintTreeVisitor {

    private boolean isConstraintContainer;
    private boolean isCompoundInitializer;
    private ConstraintSyntaxTree cst;
    private CompoundValue compoundValue;
    private ContainerValue containerValue;
    
    /**
     * Constructor of the visitor. Visits the given constraint using {@link #accept(ConstraintSyntaxTree)}.
     * Use {@link #clear()} to clear the visitor for reuse.
     * 
     * @param constraint Constraint that is visited to retrieve variables.
     */
    public ContainerConstraintsFinder(ConstraintSyntaxTree constraint) {
        clear();
        accept(constraint);
    }

    /**
     * Creates a (reusable) visitor.
     */
    public ContainerConstraintsFinder() {
    }

    /**
     * Accepts and analyzes the given <code>constraint</code>.
     * 
     * @param constraint the constraint to be visited (ignored if <b>null</b>)
     */
    public void accept(ConstraintSyntaxTree constraint) {
        if (constraint != null) {
            constraint.accept(this);           
        }
    }
    
    /**
     * Clears the visitor for reuse.
     */
    public void clear() {
        isConstraintContainer = false;
        isCompoundInitializer = false;
        cst = null;
        containerValue = null;
        compoundValue = null;
    }

    /**
     * Method for determine if expression holds a container of constraints.
     * @return true if holds container of constraints.
     */
    public boolean isConstraintContainer() {
        return isConstraintContainer;
    }
    
    /**
     * Method for determine if expression holds a compound initializer.
     * @return true if holds compound initializer.
     */
    public boolean isCompoundInitializer() {
        return isCompoundInitializer;
    }

    /**
     * Returns the container value if a constant value was identified as right side.
     * 
     * @return the container value (may be <b>null</b> if there is none)
     */
    public ContainerValue getContainerValue() {
        return containerValue;
    }

    /**
     * Returns the compound value if a constant value was identified as right side.
     * 
     * @return the compound value (may be <b>null</b> if there is none)
     */
    public CompoundValue getCompoundValue() {
        return compoundValue;
    }
    
    /**
     * Method to get expression.
     * @return returns {@link ConstraintSyntaxTree} expression..
     */
    public ConstraintSyntaxTree getExpression() {
        return cst;
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
        if (null != call.getOperand()) { 
            if ((call.getOperand() instanceof Variable
                || call.getOperand() instanceof CompoundAccess)
                && call.getParameterCount() == 1
                && call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
                ConstraintSyntaxTree param0 = call.getParameter(0);
                if (param0 instanceof ContainerInitializer) {
                    isConstraintContainer = true;
                    cst = call.getParameter(0);                    
                } else if (param0 instanceof CompoundInitializer) {
                    isCompoundInitializer = true;
                    cst = call.getParameter(0);                     
                } else if (param0 instanceof ConstantValue) {
                    Value value = ((ConstantValue) param0).getConstantValue();
                    if (value instanceof ContainerValue) {
                        containerValue = (ContainerValue) value;
                    } else if (value instanceof CompoundValue) {
                        compoundValue = (CompoundValue) value;
                    }
                }
            }
            call.getOperand().accept(this);
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
            }
        }
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
