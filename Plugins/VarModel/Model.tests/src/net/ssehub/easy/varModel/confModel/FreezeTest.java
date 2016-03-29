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
package net.ssehub.easy.varModel.confModel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests covering different freezing situations.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class FreezeTest {
    
    private Project prj;
    private Compound param;
    private Compound refinedCType;
    private DecisionVariableDeclaration myParam;
    private DecisionVariableDeclaration myParamSeq;
    private DecisionVariableDeclaration refCmpDecl;
    
    /**
     * Executed before a single test.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur 
     */
    @Before
    public void setUp() throws CSTSemanticException, ValueDoesNotMatchTypeException  {
        prj = new Project("FreezeTest");

        // Annotation
        Enum bindingTime = new OrderedEnum("BindingTime", prj);
        bindingTime.add(new EnumLiteral("compile", 1, bindingTime));
        bindingTime.add(new EnumLiteral("link", 2, bindingTime));
        bindingTime.add(new EnumLiteral("monitor", 3, bindingTime));
        bindingTime.add(new EnumLiteral("enact", 4, bindingTime));
        prj.add(bindingTime);    
        Attribute attr = new Attribute("binding", bindingTime, prj, prj);
        prj.attribute(attr);
        prj.add(attr);
        
        // Basis compound
        param = new Compound("IntParameter", prj);
        param.add(new DecisionVariableDeclaration("defaultValue", IntegerType.TYPE, param));
        AttributeAssignment assng = new AttributeAssignment(param);
        assng.add(new Assignment(attr.getName(), OclKeyWords.ASSIGNMENT,
            new ConstantValue(ValueFactory.createValue(bindingTime, bindingTime.getLiteral(3)))));
        assng.add(new DecisionVariableDeclaration("value", IntegerType.TYPE, assng));
        param.add(assng);
        prj.add(param);
        myParam = new DecisionVariableDeclaration("myParam", param, prj);
        prj.add(myParam);

        // Sequence of basis compound
        Sequence paramSeq = new Sequence("", param, prj);
        myParamSeq = new DecisionVariableDeclaration("myParamSeq", paramSeq, prj);
        prj.add(myParamSeq);
        
        // Refined Compound
        refinedCType = new Compound("refinedCP", prj, param);
        AttributeAssignment assng2 = new AttributeAssignment(refinedCType);
        assng2.add(new Assignment(attr.getName(), OclKeyWords.ASSIGNMENT,
                new ConstantValue(ValueFactory.createValue(bindingTime, bindingTime.getLiteral(2)))));
        DecisionVariableDeclaration refinedValue1 = new DecisionVariableDeclaration("rVal1", IntegerType.TYPE, assng2);
        assng2.add(refinedValue1);
        AttributeAssignment assng3 = new AttributeAssignment(assng2);
        assng3.add(new Assignment(attr.getName(), OclKeyWords.ASSIGNMENT,
                new ConstantValue(ValueFactory.createValue(bindingTime, bindingTime.getLiteral(1)))));
        DecisionVariableDeclaration refinedValue2 = new DecisionVariableDeclaration("rVal2", IntegerType.TYPE, assng3);
        assng3.add(refinedValue2);
        assng2.add(assng3);
        refinedCType.add(assng2);
        prj.add(refinedCType);
        refCmpDecl = new DecisionVariableDeclaration("refinedCmp", refinedCType, prj);
        prj.add(refCmpDecl);
        
        // Freeze
        IFreezable[] freezables = new IFreezable[3];
        freezables[0] = myParam;
        freezables[1] = myParamSeq;
        freezables[2] = refCmpDecl;
        FreezeVariableType iterType = new FreezeVariableType(freezables, prj);
        DecisionVariableDeclaration freezeIter = new DecisionVariableDeclaration("b", iterType, prj);
        Variable iterEx = new AttributeVariable(new Variable(freezeIter), iterType.getAttribute(attr.getName()));
        ConstraintSyntaxTree selector = new OCLFeatureCall(iterEx, OclKeyWords.GREATER_EQUALS, 
            new ConstantValue(ValueFactory.createValue(bindingTime, bindingTime.getLiteral(2))));
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
     * @author El-Sharkawy
     */
    private class Variables {

        private IDecisionVariable myParamVar;
        private IDecisionVariable myParamVarDeflt;
        private IDecisionVariable myParamVarValue;
        private IDecisionVariable myParamSeqVar;
        private IDecisionVariable refCmpVar;
        private IDecisionVariable refCmpVarValue;
        private IDecisionVariable refCmpVarDeflValue;
        private IDecisionVariable refCmpVarRef1Value;
        private IDecisionVariable refCmpVarRef2Value;

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

            // Refined compound
            refCmpVar = cfg.getDecision(refCmpDecl);
            refCmpVarValue = findNested(refCmpVar, "value");
            refCmpVarDeflValue = findNested(refCmpVar, "defaultValue");
            refCmpVarRef1Value = findNested(refCmpVar, "rVal1");
            refCmpVarRef2Value = findNested(refCmpVar, "rVal2");
        }
        
        /**
         * Asserts default freezes according to the variability model.
         * To be atomic, this tests <b>not</b> the refined compound.
         */
        private void assertDefaultFreeze() {
            Assert.assertEquals(AssignmentState.FROZEN, myParamVarDeflt.getState());
            Assert.assertNotEquals(AssignmentState.FROZEN, myParamVarValue.getState());
            Assert.assertEquals(AssignmentState.FROZEN, myParamVar.getState());
            Assert.assertEquals(AssignmentState.FROZEN, myParamSeqVar.getState());
        }
        
        /**
         * Asserts annotation structures.
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
            
            // Refined compound
            Assert.assertNotNull(refCmpVar);
            Assert.assertEquals(1, refCmpVar.getAttributesCount());
            Assert.assertNotNull(refCmpVarValue);
            Assert.assertEquals(1, refCmpVarValue.getAttributesCount());
            Assert.assertNotNull(refCmpVarDeflValue);
            Assert.assertEquals(1, refCmpVarDeflValue.getAttributesCount());
            Assert.assertNotNull(refCmpVarRef1Value);
            Assert.assertEquals(1, refCmpVarRef1Value.getAttributesCount());
            Assert.assertNotNull(refCmpVarRef2Value);
            Assert.assertEquals(1, refCmpVarRef2Value.getAttributesCount());
        }

    }
    

    /**
     * Tests whether attribute assignments of parent compounds are considered in refined compounds.
     * Tests also whether nested assign blocks inside other assign blocks are considered correctly.
     */
    @Test
    public void freezeRefinedCompoundTest() {
        // validate project for testing
        ProjectTestUtilities.validateProject(prj, true);
        Configuration config = new Configuration(prj);
        
        Variables variables = new Variables(config);
        variables.assertAttributes();
        variables.assertDefaultFreeze();
        
        // Test refined compound
        Assert.assertEquals(AssignmentState.FROZEN, variables.refCmpVar.getState());
        Assert.assertEquals(AssignmentState.FROZEN, variables.refCmpVarDeflValue.getState());
        Assert.assertNotEquals(AssignmentState.FROZEN, variables.refCmpVarValue.getState());
        Assert.assertNotEquals(AssignmentState.FROZEN, variables.refCmpVarRef1Value.getState());
        Assert.assertEquals(AssignmentState.FROZEN, variables.refCmpVarRef2Value.getState());
        // Since the inner assert block switches the frozen state back to default, we must test the annotation itself
        IDecisionVariable annotation = variables.refCmpVarRef2Value.getAttribute(0);
        Assert.assertNotNull(annotation);
        Assert.assertEquals("binding", annotation.getDeclaration().getName());
        Value annotationValue = annotation.getValue();
        Assert.assertNotNull(annotationValue);
        Assert.assertEquals("link", annotationValue.getValue().toString());
    }
    
    /**
     * Freezes a compound with excluded slot and no explicit value.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void freezeUndefinedCompoundTest() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        
        // debugging
        ProjectTestUtilities.validateProject(prj);
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
        ProjectTestUtilities.validateProject(prj);

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
