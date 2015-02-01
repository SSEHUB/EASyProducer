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
package de.uni_hildesheim.sse.model.confModel;

import java.util.ArrayList;
import java.util.Map;

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
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

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

}
