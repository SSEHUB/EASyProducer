/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel;

import java.util.ArrayList;
import java.util.Map;

import net.ssehub.easy.varModel.cst.AttributeVariable;
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
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * This class handles setting values for compounds.
 * @author Marcel Lueder
 *
 */
public class CompoundValueSetter implements IConstraintTreeVisitor {

    private Map<AbstractVariable, IDecisionVariable> decisions;
    private ArrayList<Object> list = new ArrayList<Object>();
    
    /**
     * Sole constructor for this class.
     * @param ocl OCLFeatureCallS which should be used
     * @param decisions 
     */
    public CompoundValueSetter(OCLFeatureCall ocl, Map<AbstractVariable, IDecisionVariable> decisions) {
        this.decisions = decisions;
        list.add(((ConstantValue) ocl.getParameter(0)).getConstantValue().getValue());
        ocl.getOperand().accept(this);
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitVariable(Variable variable) {
        IDecisionVariable cp1 = decisions.get(variable.getVariable());
        CompoundValue value = (CompoundValue) cp1.getValue();
        Object[] result = new Object[2];
        
        while (!list.isEmpty()) {
            if (result[0] == null) {
                result[0] = list.get(1);
                result[1] = list.get(0);
                list.remove(0);                
            } else {
                result[1] = new Object[] {result[0], result[1]};
                result[0] = list.get(0);
            }
            list.remove(0);                
        }
        try {
            if (null != result[0] && null != result[1]) {
                value.configureValue(result[0].toString(), result[1]);
                cp1.setValue(value, AssignmentState.ASSIGNED);
            }
        } catch (ValueDoesNotMatchTypeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void visitComment(Comment parenthesis) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        list.add(access.getSlotName());
        access.getCompoundExpression().accept(this);
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // check this!!!
        ConstraintSyntaxTree actual = expression.getActualExpression();
        if (null != actual) {
            actual.accept(this);
        }
    }

    @Override
    public void visitSelf(Self self) {
        // only considered in reasoning
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

}
