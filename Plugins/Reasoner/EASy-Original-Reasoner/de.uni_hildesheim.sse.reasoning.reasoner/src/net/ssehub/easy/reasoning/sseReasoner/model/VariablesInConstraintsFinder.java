package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.cst.AttributeVariable;
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
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * A visitor to retrieve variables from constraints.
 *
 */
public class VariablesInConstraintsFinder implements IConstraintTreeVisitor {

    private Set<AbstractVariable> variables;
    private AbstractVariable checkedVariable;
    private boolean containsVariable;
    private boolean isSimpleAssignment;
    
    
    /**
     * Constructor of the visitor. Uses collection of constraints.
     * @param constraints Constraints that is visited to retrieve variables.
     */
    public VariablesInConstraintsFinder(Collection<ConstraintSyntaxTree> constraints) {
        variables = new HashSet<AbstractVariable>();
        containsVariable = false;
        for (ConstraintSyntaxTree constraintSyntaxTree : constraints) {
            isSimpleAssignment = false;
            constraintSyntaxTree.accept(this);            
        }
    }
    
    /**
     * Constructor of the visitor. Uses a single constraint.
     * @param constraint Constraint that is visited to retrieve variables.
     */
    public VariablesInConstraintsFinder(ConstraintSyntaxTree constraint) {
        variables = new HashSet<AbstractVariable>(); 
        isSimpleAssignment = false;
        containsVariable = false;
        if (constraint != null) {
            constraint.accept(this);           
        }
    }
    
    /**
     * Constructor of the visitor. Uses a single constraint.
     * @param variable {@link AbstractVariable} to check.
     * @param constraint Constraint that is visited to retrieve variables.
     */
    public VariablesInConstraintsFinder(AbstractVariable variable, ConstraintSyntaxTree constraint) {
        variables = new HashSet<AbstractVariable>();
        isSimpleAssignment = false;
        containsVariable = false;
        checkedVariable = variable;
        if (constraint != null) {
            constraint.accept(this);           
        }        
    }
    
    /**
     * Method to get all variables that are used in constraints.
     * @return List of {@link AbstractVariable}s (maybe empty, but not <tt>null</tt>).
     */
    public Set<AbstractVariable> getVariables() {
        return variables;
    } 
    
    /**
     * Method for analyzing if constraint contains specific variable.
     * @return true if does.
     */
    public boolean containsVariable() {
        return containsVariable;
    }
    
    /**
     * Method for analyzing if constraint is valid for reevaluation (is not a simple aasignment).
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
                variables.add(referencedDecl);
            }
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable wrappedDeclaration = variable.getVariable();        
        variables.add(wrappedDeclaration);
        
        if (checkedVariable != null) {
            if (variable.getVariable().getName().equals(checkedVariable.getName())) {
                containsVariable = true;
            }            
        }
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
            call.getOperand().accept(this);
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
            }
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
            variables.add(access.getResolvedSlot());
            if (access.getResolvedSlot().equals(checkedVariable)) {
                containsVariable = true;
            }
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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

   
}
