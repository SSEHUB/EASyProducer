/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.model.filter;

import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Superclass for searching for variables/declarations inside
 * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}s.
 * @author El-Sharkawy
 *
 */
abstract class AbstractVariableInConstraintFinder implements IConstraintTreeVisitor {

    private boolean considerReferences;
    
    /**
     * Single constructor for this class.
     * @param considerReferences <tt>true</tt> declarations of
     *   {@link net.ssehub.easy.varModel.model.datatypes.Reference} values will also be found,
     *   <tt>false</tt> these declarations will be omitted. 
     */
    protected AbstractVariableInConstraintFinder(boolean considerReferences) {
        this.considerReferences = considerReferences;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        if (considerReferences) {
            visitValue(value.getConstantValue());
        }
    }
    
    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null != call.getOperand()) { // user defined function!
            call.getOperand().accept(this);
        }
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }
    
    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);        
    }
    
    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitSelf(Self self) {
        // no variable declaration
    }
    
    @Override
    public void visitVariable(Variable variable) {
        addVariable(variable.getVariable());
    }
    
    /**
     * Recursive method to find reference values pointing to a {@link AbstractVariable}.
     * @param value the content of a {@link ConstantValue}.
     * @see #visitConstantValue(ConstantValue)
     */
    protected void visitValue(Value value) {
        if (null != value) {
            if (value instanceof ContainerValue) {
                ContainerValue containerValue = (ContainerValue) value;
                for (int i = 0; i < containerValue.getElementSize(); i++) {
                    visitValue(containerValue.getElement(i));
                }
            } else if (value instanceof CompoundValue) {
                CompoundValue compoundValue = (CompoundValue) value;
                Compound cType = (Compound) compoundValue.getType();
                for (int i = 0; i < cType.getInheritedElementCount(); i++) {
                    visitValue(compoundValue.getNestedValue(cType.getInheritedElement(i).getName()));
                }
            } else if (value instanceof ReferenceValue) {
                ReferenceValue refValue = (ReferenceValue) value;
                addVariable(refValue.getValue());
            }
        }
    }
    
    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }
    
    /**
     * Handle a discovered declaration.
     * @param declaration The declaration which was found and should be added to the list of found elements.
     */
    protected abstract void addVariable(AbstractVariable declaration);
}
