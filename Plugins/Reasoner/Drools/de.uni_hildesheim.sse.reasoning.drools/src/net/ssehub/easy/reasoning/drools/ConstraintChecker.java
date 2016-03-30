package net.ssehub.easy.reasoning.drools;


import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
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
import net.ssehub.easy.varModel.model.values.IntValue;

/**
 * Class for the value narrowing down mechanism.
 * @author Phani
 *
 */
public class ConstraintChecker implements IConstraintTreeVisitor {

    private String currentVariablesBeingVisited = "";
    private int totalVariables = 0;
    private int boundaries = 0;
    private String currentVariable = "";
    private String currentOperation = "";
    private List<String> boundaryValues = new ArrayList<String>();
    private List<String> operators = new ArrayList<String>();
    
    
    
    /**
     * Getter for the list containing the boundary values.
     * @return List containing the boundary values of a variable.
     */
    public List<String> getBoundaryValues() {
        return boundaryValues;
    }

    /**
     * Getter for the list containing operators for a variable.
     * @return List containing the operators on a variable.
     */
    public List<String> getOperations() {
        return operators;
    }

    /**
     * k.
     * @return cNr.
     */
    public int getcNr() {
        return totalVariables;
    }
    
    /**
     * Getter for the number of boundaries for a given variable.
     * @return boundaries Nr. of boundaries.
     */
    public int getBoundaries() {
        return boundaries;
    }

    
    /**
     * Set the name of the variable currently being searched.
     * @param name Name of the variable.
     */
    public void setCurrentVariable(String name) {
        this.currentVariablesBeingVisited = name;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        if (currentVariable.equals(currentVariablesBeingVisited)) {
            
            if (value.getConstantValue() instanceof IntValue) {
                IntValue val = (IntValue) value.getConstantValue();
                boundaries++;
                boundaryValues.add(val.getValue().toString());
            }
            // Currently only for Integer values.
//            else if (value.getConstantValue() instanceof RealValue) {
//                RealValue val = (RealValue) value.getConstantValue();
//                boundaries++;
//                boundaryValues.add(val.getValue().toString());
//            }
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        String name = variable.getVariable().getName();
        currentVariable = name;
        if (name.equals(currentVariablesBeingVisited)) {
            operators.add(currentOperation);
            totalVariables++;
        }
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO check
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO check
        for (int e = 0; e < init.getExpressionCount(); e++) {
            init.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        currentOperation = call.getOperation();
        call.getOperand().accept(this);
        
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        let.getVariable().getDefaultValue().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub
        call.getContainer().accept(this);
        
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSelf(Self self) {
        // TODO Auto-generated method stub
    }

}
