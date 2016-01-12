/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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

import org.junit.Test;
import org.junit.Assert;

import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.FreezeVariableType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * Tests covering different freezing situations.
 * 
 * @author Holger Eichelberger
 */
public class FreezeTest {
    
    /**
     * Freezes a compound with unfreezeable.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public void freezeCompoundTest() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project prj = new Project("test");

        Enum bindingTime = new OrderedEnum("BindingTime", prj);
        bindingTime.add(new EnumLiteral("compile", 1, bindingTime));
        bindingTime.add(new EnumLiteral("monitor", 2, bindingTime));
        bindingTime.add(new EnumLiteral("enact", 3, bindingTime));
        prj.add(bindingTime);
        
        Attribute attr = new Attribute("binding", bindingTime, prj, prj);
        prj.attribute(attr);
        prj.add(attr);
        
        Compound param = new Compound("IntParameter", prj);
        param.add(new DecisionVariableDeclaration("defaultValue", IntegerType.TYPE, param));
        AttributeAssignment assng = new AttributeAssignment(param);
        assng.add(new Assignment("binding", "=", new ConstantValue(ValueFactory.createValue(bindingTime, "enact"))));
        assng.add(new DecisionVariableDeclaration("value", IntegerType.TYPE, param));
        param.add(assng);
        prj.add(param);
        
        DecisionVariableDeclaration myParam = new DecisionVariableDeclaration("myParam", param, prj);
        prj.add(myParam);
        
        IFreezable[] freezables = new IFreezable[1];
        freezables[0] = myParam;
        FreezeVariableType iterType = new FreezeVariableType(freezables, prj);
        DecisionVariableDeclaration freezeIter = new DecisionVariableDeclaration("b", iterType, prj);
        Variable iterEx = new AttributeVariable(new Variable(freezeIter), iterType.getAttribute("binding"));
        ConstraintSyntaxTree selector = new OCLFeatureCall(iterEx, ">=", 
            new ConstantValue(ValueFactory.createValue(bindingTime, "monitor")));
        selector.inferDatatype();
        FreezeBlock freeze = new FreezeBlock(freezables, freezeIter, selector, prj);
        prj.add(freeze);
        
        // debugging
        System.out.println(StringProvider.toIvmlString(prj));
        
        Configuration cfg = new Configuration(prj);
        IDecisionVariable myParamVar = cfg.getDecision(myParam);
        Assert.assertNotNull(myParamVar);
        IDecisionVariable myParamVarDeflt = findNested(myParamVar, "defaultValue");
        Assert.assertNotNull(myParamVarDeflt);
        Assert.assertEquals(1, myParamVarDeflt.getAttributesCount());
        IDecisionVariable myParamVarValue = findNested(myParamVar, "value");
        Assert.assertNotNull(myParamVarValue);
        Assert.assertEquals(1, myParamVarValue.getAttributesCount());

        cfg.freezeValues(prj, FilterType.NO_IMPORTS); // no effect
        
        Assert.assertEquals(AssignmentState.FROZEN, myParamVarDeflt.getState());
        Assert.assertNotEquals(AssignmentState.FROZEN, myParamVarValue.getState());
        //Assert.assertNotEquals(AssignmentState.FROZEN, myParamVar.getState());
    }
    
    /**
     * Finds a nested variable.
     * 
     * @param var the parent variable
     * @param name the name of the variable
     * @return the nested variable (may be <b>null</b>)
     */
    private IDecisionVariable findNested(IDecisionVariable var, String name) {
        IDecisionVariable result = null;
        for (int n = 0; null == result && n < var.getNestedElementsCount(); n++) {
            IDecisionVariable decVar = var.getNestedElement(n);
            if (decVar.getDeclaration().getName().equals(name)) {
                result = decVar;
            }
        }
        return result;
    }

}
