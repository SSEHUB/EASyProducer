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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.AttributeVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
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
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests covering different freezing situations.
 * 
 * @author Holger Eichelberger
 */
public class FreezeTest {
    
    private Project prj;
    private Compound param;
    private DecisionVariableDeclaration myParam;
    private DecisionVariableDeclaration myParamSeq;
    
    /**
     * Executed before a single test.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur 
     */
    @Before
    public void setUp() throws CSTSemanticException, ValueDoesNotMatchTypeException  {
        prj = new Project("test");

        Enum bindingTime = new OrderedEnum("BindingTime", prj);
        bindingTime.add(new EnumLiteral("compile", 1, bindingTime));
        bindingTime.add(new EnumLiteral("monitor", 2, bindingTime));
        bindingTime.add(new EnumLiteral("enact", 3, bindingTime));
        prj.add(bindingTime);
        
        Attribute attr = new Attribute("binding", bindingTime, prj, prj);
        prj.attribute(attr);
        prj.add(attr);
        
        param = new Compound("IntParameter", prj);
        param.add(new DecisionVariableDeclaration("defaultValue", IntegerType.TYPE, param));
        AttributeAssignment assng = new AttributeAssignment(param);
        assng.add(new Assignment("binding", "=", new ConstantValue(ValueFactory.createValue(bindingTime, "enact"))));
        assng.add(new DecisionVariableDeclaration("value", IntegerType.TYPE, assng));
        param.add(assng);
        prj.add(param);
        
        myParam = new DecisionVariableDeclaration("myParam", param, prj);
        prj.add(myParam);
        
        Sequence paramSeq = new Sequence("", param, prj);
        myParamSeq = new DecisionVariableDeclaration("myParamSeq", paramSeq, prj);
        prj.add(myParamSeq);
        
        IFreezable[] freezables = new IFreezable[2];
        freezables[0] = myParam;
        freezables[1] = myParamSeq;
        FreezeVariableType iterType = new FreezeVariableType(freezables, prj);
        DecisionVariableDeclaration freezeIter = new DecisionVariableDeclaration("b", iterType, prj);
        Variable iterEx = new AttributeVariable(new Variable(freezeIter), iterType.getAttribute("binding"));
        ConstraintSyntaxTree selector = new OCLFeatureCall(iterEx, ">=", 
            new ConstantValue(ValueFactory.createValue(bindingTime, "monitor")));
        selector.inferDatatype();
        FreezeBlock freeze = new FreezeBlock(freezables, freezeIter, selector, prj);
        prj.add(freeze);
    }
    
    /**
     * Executed after a single test.
     */
    @After
    public void tearDown() {
        prj = null;
        param = null;
        myParam = null;
        myParamSeq = null;
    }
    
    /**
     * Stores the relevant variables for the test.
     * 
     * @author Holger Eichelberger
     */
    private class Variables {

        private IDecisionVariable myParamVar;
        private IDecisionVariable myParamVarDeflt;
        private IDecisionVariable myParamVarValue;
        private IDecisionVariable myParamSeqVar;

        /**
         * Obtains the relevant variables.
         * 
         * @param cfg the configuration to obtain the variables from
         */
        private Variables(Configuration cfg) {
            myParamVar = cfg.getDecision(myParam);
            myParamVarDeflt = findNested(myParamVar, "defaultValue");
            myParamVarValue = findNested(myParamVar, "value");
            myParamSeqVar = cfg.getDecision(myParamSeq);
        }
        
        /**
         * Asserts default freezes according to the variability model.
         */
        private void assertDefaultFreeze() {
            Assert.assertEquals(AssignmentState.FROZEN, myParamVarDeflt.getState());
            Assert.assertNotEquals(AssignmentState.FROZEN, myParamVarValue.getState());
            Assert.assertEquals(AssignmentState.FROZEN, myParamVar.getState());
            Assert.assertEquals(AssignmentState.FROZEN, myParamSeqVar.getState());
        }
        
        /**
         * Asserts attribute structures and freeze states.
         */
        private void assertAttributes() {
            Assert.assertNotNull(myParamVar);
            Assert.assertEquals(1, myParamVar.getAttributesCount());
            Assert.assertNotNull(myParamVarDeflt);
            Assert.assertEquals(1, myParamVarDeflt.getAttributesCount());
            Assert.assertNotNull(myParamVarValue);
            Assert.assertEquals(1, myParamVarValue.getAttributesCount());
            Assert.assertNotNull(myParamSeqVar);
            Assert.assertEquals(1, myParamSeqVar.getAttributesCount());
        }

    }
    
    /**
     * Freezes a compound with excluded slot and no explicit value.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
//    @Ignore("-> Sascha")
    public void freezeUndefinedCompoundTest() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        
        // debugging
        ProjectTestUtilities.validateProject(prj, true);
        
        Configuration cfg = new Configuration(prj);

        Variables variables = new Variables(cfg);
        variables.assertAttributes();
        variables.assertDefaultFreeze();

        cfg.freezeValues(prj, FilterType.NO_IMPORTS); // no effect -> configuration
        
        changeValue(variables.myParamVarValue, ValueFactory.createValue(IntegerType.TYPE, 1));
        Assert.assertNotEquals(AssignmentState.FROZEN, variables.myParamVarValue.getState());
        assertIntValue(variables.myParamVarValue, 1);
    }
    
    /**
     * Freezes a compound with excluded slot and no value and changes the value of the unfrozen slot later ("runtime").
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
//    @Ignore("-> Sascha")
    public void freezeCompoundTest() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {

        OCLFeatureCall assignment = new OCLFeatureCall(new Variable(myParam), "=", 
             new ConstantValue(ValueFactory.createValue(myParam.getType(), new Object[]{"defaultValue", 1})));
        assignment.inferDatatype();
        Constraint constraint = new Constraint(assignment, prj);
        prj.addConstraint(constraint);
        
        Value tmp = ValueFactory.createValue(myParam.getType(), new Object[]{"defaultValue", 2});
        assignment = new OCLFeatureCall(new Variable(myParamSeq), "=", 
            new ConstantValue(ValueFactory.createValue(myParamSeq.getType(), new Object[]{tmp})));
        assignment.inferDatatype();
        constraint = new Constraint(assignment, prj);
        prj.addConstraint(constraint);
        
        // debugging
        ProjectTestUtilities.validateProject(prj, true);

        Configuration cfg = new Configuration(prj);
        Variables variables = new Variables(cfg);
        
        Assert.assertNotNull(variables.myParamVar.getValue());
        Assert.assertNotNull(variables.myParamVarDeflt.getValue());
        Assert.assertNull(variables.myParamVarValue.getValue());

        changeValue(variables.myParamVarValue, ValueFactory.createValue(IntegerType.TYPE, 1));
        assertIntValue(variables.myParamVarValue, 1);
        variables.assertDefaultFreeze();
        
        IDecisionVariable firstParam = variables.myParamSeqVar.getNestedElement(0);
        IDecisionVariable nestedValueDeflt = findNested(firstParam, "defaultValue"); 
        IDecisionVariable nestedValue = findNested(firstParam, "value"); 
        changeValue(nestedValue, ValueFactory.createValue(IntegerType.TYPE, 1));
        assertIntValue(nestedValue, 1);
        variables.assertDefaultFreeze();
        Assert.assertEquals(AssignmentState.FROZEN, nestedValueDeflt.getState());
        Assert.assertNotEquals(AssignmentState.FROZEN, nestedValue.getState());
    }

    /**
     * Asserts an int value on <code>actual</code>.
     * 
     * @param actual the variable
     * @param expected the expected value
     */
    private void assertIntValue(IDecisionVariable actual, int expected) {
        Value value = actual.getValue();
        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof IntValue);
        Assert.assertEquals(expected, ((IntValue) value).getValue().intValue());
    }
    
    /**
     * Changes a value as done in VIL.
     * 
     * @param toChange the variable to change
     * @param val the new value
     * @throws ConfigurationException in case of type conflicts
     */
    private void changeValue(IDecisionVariable toChange, Value val) throws ConfigurationException {
        IAssignmentState varState = toChange.getState();
        if (AssignmentState.UNDEFINED == varState) {
            varState = AssignmentState.ASSIGNED;
        }
        toChange.setValue(val, varState);
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
