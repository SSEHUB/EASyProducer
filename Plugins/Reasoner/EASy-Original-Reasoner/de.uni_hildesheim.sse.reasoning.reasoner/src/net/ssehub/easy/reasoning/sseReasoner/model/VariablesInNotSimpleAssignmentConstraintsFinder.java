package net.ssehub.easy.reasoning.sseReasoner.model;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
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
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * A visitor to retrieve variables from constraints.
 *
 */
public class VariablesInNotSimpleAssignmentConstraintsFinder implements IConstraintTreeVisitor {

    private VariablesMap constraintMap;
    private boolean isSimpleAssignment;
    private Constraint constraint;
    
    /**
     * Creates a visitor instance.
     * 
     * @param constraintMap the constraint map to use for storing results
     */
    public VariablesInNotSimpleAssignmentConstraintsFinder(VariablesMap constraintMap) {
        this.constraintMap = constraintMap;
        isSimpleAssignment = false;
    }

    /**
     * Accepts and visits a constraint.
     * 
     * @param constraint the constraint to accept
     */
    public void accept(Constraint constraint) {
        this.constraint = constraint;
        constraint.getConsSyntax().accept(this);
    }
    
    /**
     * Combines {@link #accept(Constraint)} and {@link #clear()}.
     * 
     * @param constraint the constraint to accept
     */
    public void acceptAndClear(Constraint constraint) {
        accept(constraint);
        clear();
    }
    
    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        constraint = null;
        isSimpleAssignment = false;
    }
    
    /**
     * Method for analyzing if constraint is valid for reevaluation (is not a simple asignment).
     * @return true if valid.
     */
    public boolean isSimpleAssignment() {
        return isSimpleAssignment;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        Value constValue = value.getConstantValue();
        if (null != constValue && constValue instanceof ReferenceValue) {
            ReferenceValue rValue = (ReferenceValue) constValue;
            AbstractVariable referencedDecl = rValue.getValue();
            if (null != referencedDecl) {
                constraintMap.add(referencedDecl, constraint);
            }
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        constraintMap.add(variable.getVariable(), constraint);
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
        if (null != call.getOperand()) {    
            // user def function returns operand null!
            if ((call.getOperand() instanceof Variable
                || call.getOperand() instanceof CompoundAccess)
                && call.getParameterCount() == 1
                && call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
                if (call.getParameter(0) instanceof ConstantValue
                    || call.getParameter(0) instanceof ContainerInitializer
                    || call.getParameter(0) instanceof CompoundInitializer) {
                    isSimpleAssignment = true; 
                }
            }
            if (!isSimpleAssignment) {
                call.getOperand().accept(this);
                for (int i = 0; i < call.getParameterCount(); i++) {
                    call.getParameter(i).accept(this);
                }
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
        try {
            access.inferDatatype();
            constraintMap.add(access.getResolvedSlot(), constraint);
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Descriptor.BUNDLE_NAME).exception(e);
        }
        
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
        // not needed
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
