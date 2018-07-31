/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the {@link EvaluationVisitor} with respect to compound self values.
 * 
 * @author Holger Eichelberger
 */
public class SelfTests {

    /**
     * Tests a self expression in a compound initializer.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCompoundInitSelf() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Compound cmpType = new Compound("Comp", project);
        DecisionVariableDeclaration cmpDeclV = new DecisionVariableDeclaration("v", IntegerType.TYPE, cmpType);
        cmpType.add(cmpDeclV);
        DecisionVariableDeclaration cmpDeclW = new DecisionVariableDeclaration("w", IntegerType.TYPE, cmpType);
        cmpDeclW.setValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        cmpType.add(cmpDeclW);
        project.add(cmpType);

        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("c", cmpType, project);
        project.add(decl1);
        
        ConstraintSyntaxTree initOp = new OCLFeatureCall(
            new CompoundAccess(new Self(cmpType), cmpDeclW.getName()), 
            IntegerType.MULT_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 3)));
        initOp.inferDatatype();
        ConstraintSyntaxTree assngOp = Utils.createCall(decl1, Compound.ASSIGNMENT, 
            new CompoundInitializer(cmpType, 
                new String[] {cmpDeclV.getName()}, 
                new AbstractVariable[] {cmpDeclV},
                new ConstraintSyntaxTree[] {initOp}));
        assngOp.inferDatatype();
        
        // Assign value
        Configuration config = new Configuration(project);

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        assngOp.accept(visitor);
        assertIntSlotValue(config, decl1, cmpDeclV.getName(), 6);
        
        visitor.clear();
    }
    
    /**
     * Asserts the value of an integer slot.
     * 
     * @param config the configuration to obtain the compound variable from
     * @param cmpDecl the compound declaration
     * @param slotName the slot name
     * @param expectedValue the expected value
     */
    private static void assertIntSlotValue(Configuration config, DecisionVariableDeclaration cmpDecl, String slotName, 
        int expectedValue) {
        assertIntSlotValue(config.getDecision(cmpDecl), slotName, expectedValue);
    }

    /**
     * Asserts the value of an integer slot.
     * 
     * @param var the compound variable
     * @param slotName the slot name
     * @param expectedValue the expected value
     */
    private static void assertIntSlotValue(IDecisionVariable var, String slotName, int expectedValue) {
        Assert.assertNotNull("no compound variable assigned", var);
        IDecisionVariable slot = var.getNestedElement(slotName);
        Assert.assertNotNull(slot);
        Value val = slot.getValue();
        Assert.assertNotNull(val);
        Assert.assertTrue(val instanceof IntValue);
        Assert.assertEquals(expectedValue, ((IntValue) val).getValue().intValue());
    }

    /**
     * Tests a self expression in a sequence container initializer.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSequenceInitSelf() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Compound cmpType = new Compound("Comp", project);
        DecisionVariableDeclaration cmpDeclV = new DecisionVariableDeclaration("v", IntegerType.TYPE, cmpType);
        cmpType.add(cmpDeclV);
        DecisionVariableDeclaration cmpDeclW = new DecisionVariableDeclaration("w", IntegerType.TYPE, cmpType);
        cmpDeclW.setValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        cmpType.add(cmpDeclW);
        project.add(cmpType);

        Sequence seqType = new Sequence("", cmpType, project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("seq", seqType, project);
        project.add(decl1);
        
        ConstraintSyntaxTree initOp1 = new OCLFeatureCall(
            new CompoundAccess(new Self(cmpType), cmpDeclW.getName()), 
            IntegerType.MULT_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 3)));
        initOp1.inferDatatype();
        ConstraintSyntaxTree initOp2 = new OCLFeatureCall(
            new CompoundAccess(new Self(cmpType), cmpDeclW.getName()), 
            IntegerType.MULT_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 4)));
        initOp2.inferDatatype();
        
        ContainerInitializer seqInit = new ContainerInitializer(seqType, 
            new ConstraintSyntaxTree[] {
                new CompoundInitializer(cmpType, 
                    new String[] {cmpDeclV.getName()}, 
                    new AbstractVariable[] {cmpDeclV},
                    new ConstraintSyntaxTree[] {initOp1}),
                new CompoundInitializer(cmpType, 
                    new String[] {cmpDeclV.getName()}, 
                    new AbstractVariable[] {cmpDeclV},
                    new ConstraintSyntaxTree[] {initOp2}),
            });
        
        ConstraintSyntaxTree assngOp = Utils.createCall(decl1, Compound.ASSIGNMENT, seqInit);
        assngOp.inferDatatype();
        
        // Assign value
        Configuration config = new Configuration(project);

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        assngOp.accept(visitor);

        IDecisionVariable var = config.getDecision(decl1);
        Assert.assertTrue("no sequence variable assigned", var instanceof ContainerVariable);
        ContainerVariable cVar = (ContainerVariable) var;
        Assert.assertEquals(2, cVar.getNestedElementsCount());
        assertIntSlotValue(cVar.getNestedElement(0), cmpDeclV.getName(), 6);
        assertIntSlotValue(cVar.getNestedElement(1), cmpDeclV.getName(), 8);

        visitor.clear();
    }

    /**
     * Tests a self expression in a set container initializer.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSetInitSelf() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Compound cmpType = new Compound("Comp", project);
        DecisionVariableDeclaration cmpDeclV = new DecisionVariableDeclaration("v", IntegerType.TYPE, cmpType);
        cmpType.add(cmpDeclV);
        DecisionVariableDeclaration cmpDeclW = new DecisionVariableDeclaration("w", IntegerType.TYPE, cmpType);
        cmpDeclW.setValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        cmpType.add(cmpDeclW);
        project.add(cmpType);

        Set seqType = new Set("", cmpType, project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("seq", seqType, project);
        project.add(decl1);
        
        ConstraintSyntaxTree initOp1 = new OCLFeatureCall(
            new CompoundAccess(new Self(cmpType), cmpDeclW.getName()), 
            IntegerType.MULT_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 3)));
        initOp1.inferDatatype();
        ConstraintSyntaxTree initOp2 = new OCLFeatureCall(
            new CompoundAccess(new Self(cmpType), cmpDeclW.getName()), 
            IntegerType.MULT_INTEGER_INTEGER.getName(), 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 4)));
        initOp2.inferDatatype();
        
        ContainerInitializer seqInit = new ContainerInitializer(seqType, 
            new ConstraintSyntaxTree[] {
                new CompoundInitializer(cmpType, 
                    new String[] {cmpDeclV.getName()}, 
                    new AbstractVariable[] {cmpDeclV},
                    new ConstraintSyntaxTree[] {initOp1}),
                new CompoundInitializer(cmpType, 
                    new String[] {cmpDeclV.getName()}, 
                    new AbstractVariable[] {cmpDeclV},
                    new ConstraintSyntaxTree[] {initOp2}),
            });
        
        ConstraintSyntaxTree assngOp = Utils.createCall(decl1, Compound.ASSIGNMENT, seqInit);
        assngOp.inferDatatype();
        
        // Assign value
        Configuration config = new Configuration(project);

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        assngOp.accept(visitor);
        IDecisionVariable var = config.getDecision(decl1);
        Assert.assertTrue("no set variable assigned", var instanceof ContainerVariable);
        ContainerVariable cVar = (ContainerVariable) var;
        Assert.assertEquals(2, cVar.getNestedElementsCount());
        assertIntSlotValue(cVar.getNestedElement(0), cmpDeclV.getName(), 6);
        assertIntSlotValue(cVar.getNestedElement(1), cmpDeclV.getName(), 8);

        visitor.clear();
    }

}
