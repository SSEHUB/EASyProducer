/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * This class tests the correct behavior of the OCLFeatureCall class.
 * 
 * @author tebbje
 * @author El-Sharkawy
 * @author Holger Eichelberger
 * @see OCLFeatureCall
 *
 */
public class OCLFeatureCallTest {

    private Project project;
    
    /**
     * Creates a project, which is needed as toplevel element.
     */
    @Before
    public void setUp() {
        project = new Project("project");
    }
    
    /**
     * Tests whether an OCLFeatureCall without an operation throws a CSTSemanticException during inferDatatype method.
     * @see OCLFeatureCall#inferDatatype()
     */
    @Test
    public void testNoOperator() {
        //Create OCLFeatureCall constraint without an operator
        DecisionVariableDeclaration str = new DecisionVariableDeclaration("str", StringType.TYPE, project);
        Variable strVarCst = new Variable(str);
        OCLFeatureCall featureCall = new OCLFeatureCall(strVarCst, null, (ConstraintSyntaxTree[]) null);
        
        //Test: The return value of str.size() should be an integer 
        try {
            featureCall.inferDatatype();
            //Exception should occur
            Assert.fail();
        } catch (CSTSemanticException e) {
            // Exception should occur, no action is needed.
        }
    }
    
    /**
     * Simple test for inferDatatype.
     * 
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testSimpleInferDatatype() throws IvmlException {
        //Create constraint: i = 5
        DecisionVariableDeclaration iVar = new DecisionVariableDeclaration("i", IntegerType.TYPE, project);
        Variable iVarCst = new Variable(iVar);
        ConstantValue constCst = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5"));
        OCLFeatureCall featureCall = new OCLFeatureCall(iVarCst, "=", constCst);
        //Test: i = 5 should be a boolean
        Assert.assertTrue(null != featureCall);
        Assert.assertEquals(BooleanType.TYPE, featureCall.inferDatatype());
    }
    
    /**
     * Simple test for inferDatatype.
     * 
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testBooleanUnary() throws IvmlException {
        DecisionVariableDeclaration bVar = new DecisionVariableDeclaration("b", BooleanType.TYPE, project);
        Variable bVarCst = new Variable(bVar);
        OCLFeatureCall featureCall = new OCLFeatureCall(bVarCst, "not");
        Assert.assertTrue(null != featureCall);
        Assert.assertEquals(BooleanType.TYPE, featureCall.inferDatatype());
    }

    /**
     * Simple test for inferDatatype.
     * 
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testBooleanBinary() throws IvmlException {
        DecisionVariableDeclaration bVar = new DecisionVariableDeclaration("b", BooleanType.TYPE, project);
        Variable bVarCst = new Variable(bVar);
        DecisionVariableDeclaration cVar = new DecisionVariableDeclaration("c", BooleanType.TYPE, project);
        Variable cVarCst = new Variable(cVar);

        String[] binOpNames = {OclKeyWords.AND, OclKeyWords.OR, OclKeyWords.XOR, OclKeyWords.IMPLIES};
        for (String name : binOpNames) {
            OCLFeatureCall featureCall = new OCLFeatureCall(bVarCst, name, cVarCst);
            Assert.assertTrue(null != featureCall);
            Assert.assertEquals(BooleanType.TYPE, featureCall.inferDatatype());
        }
    }
    
    /**
     * Simple test for inferDatatype.
     * 
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testTwoStagedInferDatatype() throws IvmlException {
        //Create constraint: i = j + 5
        DecisionVariableDeclaration iVar = new DecisionVariableDeclaration("i", IntegerType.TYPE, project);
        DecisionVariableDeclaration jVar = new DecisionVariableDeclaration("j", IntegerType.TYPE, project);
        Variable iVarCst = new Variable(iVar);
        Variable jVarCst = new Variable(jVar);
        ConstantValue constCst = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5"));
        OCLFeatureCall addCall = new OCLFeatureCall(jVarCst, "+", constCst);
        OCLFeatureCall featureCall = new OCLFeatureCall(iVarCst, "=", addCall);
        //Test: i = (j + 5) should be a boolean 
        Assert.assertEquals(BooleanType.TYPE, featureCall.inferDatatype());
    }
    
    /**
     * Simple test for (failing) inferDatatype.
     * 
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testSimpleInferDatatypeFail() throws IvmlException {
        //Create constraint: i = 5 6 (operation unknown!)
        DecisionVariableDeclaration iVar = new DecisionVariableDeclaration("i", IntegerType.TYPE, project);
        Variable iVarCst = new Variable(iVar);
        ConstantValue constCst5 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "5"));
        ConstantValue constCst6 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "6"));
        OCLFeatureCall featureCall = new OCLFeatureCall(iVarCst, "=", constCst5, constCst6);
        try {
            featureCall.inferDatatype();
            //Exception should occur
            Assert.fail();
        } catch (CSTSemanticException e) {
            // Exception should occur, no action is needed.
        }
    }
    
    /**
     * Tests an index-based container access. In IVML:
     * <code>
     *   setOf(Integer) set;
     *   set[5] should be Integer
     * </code>
     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
     */
    @Test
    public void testIndexBasedContainer() throws IvmlException {
        IDatatype setType = new Sequence("sequence(Integer)", IntegerType.TYPE, null);
        DecisionVariableDeclaration sVar = new DecisionVariableDeclaration("set", setType, project);
        Variable sVarCst = new Variable(sVar);
        ConstantValue constCst0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "0"));
        OCLFeatureCall featureCall = new OCLFeatureCall(sVarCst, "[]", constCst0);
        IDatatype resultType = featureCall.inferDatatype();
        Assert.assertTrue(resultType.isAssignableFrom(IntegerType.TYPE));
    }
    
    /**
     * Tests {@link ConstraintSyntaxTree#isSemanticallyEqual(ConstraintSyntaxTree)} of Boolean operations.
     */
    @Test
    public void testEqualsOfBooleanCommutativeOperations() {
        DecisionVariableDeclaration boolA = new DecisionVariableDeclaration("boolA", BooleanType.TYPE, project);
        project.add(boolA);
        DecisionVariableDeclaration boolB = new DecisionVariableDeclaration("boolB", BooleanType.TYPE, project);
        project.add(boolB);
        
        ConstraintSyntaxTree or1 = new OCLFeatureCall(new Variable(boolA), OclKeyWords.OR, new Variable(boolB));
        ConstraintSyntaxTree or2 = new OCLFeatureCall(new Variable(boolB), OclKeyWords.OR, new Variable(boolA));
        Assert.assertNotEquals(or1, or2);
        Assert.assertTrue(or1.isSemanticallyEqual(or2));
    }
    
//    /**
//     * Tests initialization of enum compound slot.
//     * 
//     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
//     */
//    @Test
//    public void testEnumValuedCompound() throws IvmlException {
//        final String slotName = "e";
//        final String firstEnumValue = "one"; 
//        de.uni_hildesheim.sse.model.varModel.datatypes.Enum myEnum 
//            = new de.uni_hildesheim.sse.model.varModel.datatypes.Enum("myEnum", project, firstEnumValue, "two");
//        Compound compound = new Compound("test", project);
//        DecisionVariableDeclaration enumSlot = new DecisionVariableDeclaration(slotName, myEnum, compound);
//        compound.add(enumSlot);
//        Assert.assertEquals(1, compound.getElementCount());
//        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(compound, slotName, null);
//        cValue.configureValue(slotName, firstEnumValue);
//        Assert.assertTrue(null != cValue);
//        ConstraintSyntaxTree cst = cValue.getNestedValue(slotName);
//        Assert.assertTrue(null != cst);
//        Assert.assertTrue(cst instanceof ConstantValue);
//        Value val = ((ConstantValue) cst).getConstantValue();
//        Assert.assertTrue(val instanceof EnumValue);
//        EnumValue assigned = (EnumValue) val;
//        Assert.assertTrue(null != assigned.getValue());
//        Assert.assertEquals(myEnum.getLiteral(0).getName(), assigned.getValue().getName());
//        Assert.assertEquals(myEnum.getLiteral(0).getOrdinal(), assigned.getValue().getOrdinal());
//        
//        cValue = (CompoundValue) ValueFactory.createValue(compound, slotName, firstEnumValue);
//        Assert.assertTrue(null != cValue);
//        cst = cValue.getNestedValue(slotName);
//        Assert.assertTrue(null != cst);
//        Assert.assertTrue(cst instanceof ConstantValue);
//        val = ((ConstantValue) cst).getConstantValue();
//        Assert.assertTrue(null != val);
//        Assert.assertTrue(val instanceof EnumValue);
//        assigned = (EnumValue) val;
//        Assert.assertTrue(null != assigned.getValue());
//        Assert.assertEquals(myEnum.getLiteral(0).getName(), assigned.getValue().getName());
//        Assert.assertEquals(myEnum.getLiteral(0).getOrdinal(), assigned.getValue().getOrdinal());
//    }
//
//    /**
//     * Tests initialization of enum compound slot.
//     * 
//     * @throws IvmlException Should not occur, as the nested constraint is semantically correct.
//     */
//    @Test
//    public void testCompoundValuedCompound() throws IvmlException {
//        final String slotName = "s";
//        final String innerSlotName = "test";
//        Compound slotCompound = new Compound("slot", project);
//        DecisionVariableDeclaration testSlot 
//            = new DecisionVariableDeclaration(innerSlotName, IntegerType.TYPE, slotCompound);
//        testSlot.setValue("1");
//        slotCompound.add(testSlot);
//        
//        Compound compound = new Compound("test", project);
//        DecisionVariableDeclaration enumSlot = new DecisionVariableDeclaration(slotName, slotCompound, compound);
//        compound.add(enumSlot);
//        Assert.assertEquals(1, compound.getElementCount());
//        CompoundValue sValue = (CompoundValue) ValueFactory.createValue(slotCompound);
//        CompoundValue cValue = (CompoundValue) ValueFactory.createValue(compound, slotName, null);
//        cValue.configureValue(slotName, sValue);
//        Assert.assertTrue(null != cValue);
//        ConstraintSyntaxTree cst = cValue.getNestedValue(slotName);
//        Assert.assertTrue(null != cst);
//        Assert.assertTrue(cst instanceof ConstantValue);
//        Value val = ((ConstantValue) cst).getConstantValue();
//        Assert.assertTrue(null != val);
//        Assert.assertTrue(val instanceof CompoundValue);
//        CompoundValue assigned = (CompoundValue) val;
//        Assert.assertEquals(assigned.getType().getName(), sValue.getType().getName());
//        Assert.assertTrue(null != sValue.getNestedValue(innerSlotName));
//        Assert.assertTrue(null != assigned.getNestedValue(innerSlotName));
//        cValue = (CompoundValue) ValueFactory.createValue(compound, slotName, sValue);
//        Assert.assertTrue(null != cValue);
//        cst = cValue.getNestedValue(slotName);
//        Assert.assertTrue(null != cst);
//        Assert.assertTrue(cst instanceof ConstantValue);
//        val = ((ConstantValue) cst).getConstantValue();
//        Assert.assertTrue(null != val);
//        Assert.assertTrue(val instanceof CompoundValue);
//        assigned = (CompoundValue) val;
//        Assert.assertEquals(assigned.getType().getName(), sValue.getType().getName());
//        Assert.assertTrue(null != sValue.getNestedValue(innerSlotName));
//        Assert.assertTrue(null != assigned.getNestedValue(innerSlotName));
//    }

}
