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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests the {@link EvaluationVisitor} with respect to container iterator operations.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class EvaluationVisitorIteratorTest {

    /**
     * Tests the "forAll" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testForAllContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 2, 3, 4, 5}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            localDecl, IntegerType.GREATER_EQUALS_INTEGER_INTEGER, const0);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.FORALL, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, -2, 3, 4, 5}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.FALSE, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Tests the "min", "max" container operation on ints and container of compounds.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testMinMaxIntContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Compound cmpType = new Compound("Comp", project);
        DecisionVariableDeclaration cmpDecl = new DecisionVariableDeclaration("v", IntegerType.TYPE, cmpType);
        cmpType.add(cmpDecl);
        Sequence seqType = new Sequence("mySeq", cmpType, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("cmps", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        Value v1 = ValueFactory.createValue(cmpType, new Object[]{"v", 1});
        Value v2 = ValueFactory.createValue(cmpType, new Object[]{"v", 2});
        var.setValue(ValueFactory.createValue(seqType, new Object[]{v1, v2}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", cmpType, null);
        ConstantValue const2 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            new CompoundAccess(new Variable(localDecl), "v"), IntegerType.MULT_INTEGER_INTEGER, const2);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.MIN2, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(v1, visitor.getResult());
        visitor.clear();
        
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp = Utils.createContainerCall(decl1, Sequence.MAX2, itExpression, localDecl);
        containerOp.inferDatatype();
        containerOp.accept(visitor);
        Assert.assertEquals(v2, visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Tests the "min", "max" container operation on reals and container of compounds.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testMinMaxRealContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Compound cmpType = new Compound("Comp", project);
        DecisionVariableDeclaration cmpDecl = new DecisionVariableDeclaration("v", RealType.TYPE, cmpType);
        cmpType.add(cmpDecl);
        Set setType = new Set("mySet", cmpType, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("cmps", setType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        Value v1 = ValueFactory.createValue(cmpType, new Object[]{"v", 1});
        Value v2 = ValueFactory.createValue(cmpType, new Object[]{"v", 2});
        var.setValue(ValueFactory.createValue(setType, new Object[]{v1, v2}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", cmpType, null);
        ConstantValue const2 = new ConstantValue(ValueFactory.createValue(RealType.TYPE, 2));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            new CompoundAccess(new Variable(localDecl), "v"), RealType.MULT_REAL_REAL, const2);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.MIN2, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(v1, visitor.getResult());
        visitor.clear();
        
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp = Utils.createContainerCall(decl1, Sequence.MAX2, itExpression, localDecl);
        containerOp.inferDatatype();
        containerOp.accept(visitor);
        Assert.assertEquals(v2, visitor.getResult());
        visitor.clear();
    }

    /**
     * Tests the "exists" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testExistContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 2, 3, 4, 5}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            localDecl, IntegerType.LESS_EQUALS_INTEGER_INTEGER, const0);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.EXISTS, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.FALSE, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, -2, 3, 4, 5}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.FALSE, visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Tests the "isUnique" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testIsUniqueContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 2, 3, 4, 5}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const2 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.MULT_INTEGER_INTEGER, const2);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(
            decl1, Sequence.IS_UNIQUE, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 1, 1, 1, 1}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.FALSE, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clear();
    }

    /**
     * Tests the "any" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testAnyContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{10, 20, 30, 40, 50}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const21 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 21));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            localDecl, IntegerType.GREATER_EQUALS_INTEGER_INTEGER, const21);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.ANY, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Value result = visitor.getResult();
        Assert.assertTrue(result instanceof IntValue);
        Assert.assertEquals(Integer.valueOf(30), ((IntValue) visitor.getResult()).getValue());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, -2, 3, 4, 5}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(NullValue.INSTANCE == visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(NullValue.INSTANCE == visitor.getResult());
        visitor.clear();
    }

    /**
     * Tests the "one" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testOneContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{10, 20, 30, 40, 50}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const20 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 20));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.EQUALS_INTEGER_INTEGER, const20);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.ANY, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Value result = visitor.getResult();
        Assert.assertTrue(result instanceof IntValue);
        Assert.assertEquals(Integer.valueOf(20), ((IntValue) visitor.getResult()).getValue());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, -2, 3, 4, 5}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(NullValue.INSTANCE == visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(NullValue.INSTANCE == visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Tests the "select" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSelectContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{10, 20, 30, 40, 50}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const20 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 20));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            localDecl, IntegerType.GREATER_EQUALS_INTEGER_INTEGER, const20);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.SELECT, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Utils.assertContainer(new Object[]{20, 30, 40, 50}, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, -2, 3, 4, 5}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Utils.assertContainer(new Object[]{}, visitor.getResult());
        visitor.clear();
        
        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Utils.assertContainer(new Object[]{}, visitor.getResult());
        visitor.clear();
    }

    /**
     * Tests the "reject" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testRejectContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{10, 20, 30, 40, 50}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const20 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 20));
        ConstraintSyntaxTree itExpression = Utils.createCall(
            localDecl, IntegerType.GREATER_EQUALS_INTEGER_INTEGER, const20);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.REJECT, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Utils.assertContainer(new Object[]{10}, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, -2, 3, 4, 5}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Utils.assertContainer(new Object[]{1, -2, 3, 4, 5}, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Utils.assertContainer(new Object[]{}, visitor.getResult());
        visitor.clear();
    }

    /**
     * Tests a collect container operation on a non-nested collection.
     * 
     * @param op the sequence collect operation to be applied
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    private void testCollectNonNestedSequenceOperation(Operation op) throws ValueDoesNotMatchTypeException, 
        ConfigurationException, CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 2, 3, 4, 5}), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 10));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.MULT_INTEGER_INTEGER, const10);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, op, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Value result = visitor.getResult();
        Assert.assertTrue(result instanceof ContainerValue);
        Utils.assertContainer(new Object[]{10, 20, 30, 40, 50}, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        result = visitor.getResult();
        Assert.assertTrue(result instanceof ContainerValue);
        Utils.assertContainer(new Object[]{}, result);
        visitor.clear();
    }

    
    /**
     * Tests the "collect" container operation on a non-nested collection.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCollectNonNestedSequenceOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        testCollectNonNestedSequenceOperation(Sequence.COLLECT); // set has same implementation
    }

    /**
     * Tests the "collectNested" container operation on a non-nested collection.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCollectNestedNonNestedSequenceOperation() throws ValueDoesNotMatchTypeException, 
        ConfigurationException, CSTSemanticException {
        // collect nested on non-nested sequence shall have the same result
        testCollectNonNestedSequenceOperation(Sequence.COLLECT_NESTED); // set has same implementation
    }
    
    /**
     * Tests a collect container operation on a nested collection.
     * 
     * @param op the operation to test
     * @param values the values to execute <code>op</code> on
     * @param expected the expected result for <code>values</code>
     * @param empty the empty set
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    private void testCollectNestedSequenceOperation(Operation op, Object[] values, Object[] expected, 
        Object[] empty) throws ValueDoesNotMatchTypeException, ConfigurationException, CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence sType = new Sequence("mySeq", IntegerType.TYPE, project);
        Sequence seqType = new Sequence("mySeqSeq", sType, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, values), AssignmentState.ASSIGNED);

        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 10));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.MULT_INTEGER_INTEGER, const10);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, op, itExpression, localDecl);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Value result = visitor.getResult();
        Assert.assertTrue(result instanceof ContainerValue);
        Utils.assertContainer(expected, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, empty), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        result = visitor.getResult();
        Assert.assertTrue(result instanceof ContainerValue);
        Utils.assertContainer(empty, result);
        visitor.clear();
    }

    /**
     * Tests the "collect" container operation on a nested collection.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCollectNestedSequenceOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        testCollectNestedSequenceOperation(Sequence.COLLECT, 
            new Object[][]{{1, 2}, {3, 4}, {5}}, 
            new Object[]{10, 20, 30, 40, 50},
            new Object[]{});
    }

    /**
     * Tests the "collectNested" container operation on a nested collection.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCollectNestedNestedSequenceOperation() throws ValueDoesNotMatchTypeException, 
        ConfigurationException, CSTSemanticException {
        testCollectNestedSequenceOperation(Sequence.COLLECT_NESTED, 
            new Object[][]{{1, 2}, {3, 4}, {5}}, 
            new Object[][]{{10, 20}, {30, 40}, {50}}, 
            new Object[][]{});
    }
    
    // checkstyle: stop parameter number check
    
    /**
     * Tests the sequence sortedBy operation on given values and iterator expression.
     * 
     * @param elementType the element type to test on
     * @param values the values to execute the sortedBy operation on
     * @param expected the expected result for <code>values</code>
     * @param itVar the iterator variable declaration
     * @param itExpression the iterator expression using <code>itVar</code>
     * @param pr optional top-level project (may be <b>null</b> for default top-level project)
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    private void testSortedBySequenceOperation(IDatatype elementType, Object[] values, Object[] expected, 
        DecisionVariableDeclaration itVar, ConstraintSyntaxTree itExpression, Project pr) 
        throws ValueDoesNotMatchTypeException, ConfigurationException, CSTSemanticException {
        Project project = pr;
        if (null == project) {
            project = new Project("Test");
        }
        // Types
        Sequence seqType = new Sequence("mySeq", elementType, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("seq", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, values), AssignmentState.ASSIGNED);

        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.SORTED_BY, itExpression, itVar);
        containerOp.inferDatatype();
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Value result = visitor.getResult();
        Assert.assertTrue(result instanceof ContainerValue);
        Utils.assertContainer(expected, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        result = visitor.getResult();
        Assert.assertTrue(result instanceof ContainerValue);
        Utils.assertContainer(new Object[]{}, result);
        visitor.clear();
    }

    // checkstyle: resume parameter number check

    /**
     * Tests the sortedBy operation on integer sequences.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSortedByIntSequenceOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        // some expression, also just a would do the job
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 10));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.MULT_INTEGER_INTEGER, const10);
        testSortedBySequenceOperation(IntegerType.TYPE, new Object[]{7, 1, -4, 20}, new Object[]{-4, 1, 7, 20}, 
            localDecl, itExpression, null);
    }

    /**
     * Tests the sortedBy operation on real sequences.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSortedByRealSequenceOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        // some expression, also just a would do the job
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", RealType.TYPE, null);
        ConstantValue const10 = new ConstantValue(ValueFactory.createValue(RealType.TYPE, 10.0));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, RealType.MULT_REAL_REAL, const10);
        testSortedBySequenceOperation(RealType.TYPE, new Object[]{7.1, -1.2, -8.1, 20.2}, 
            new Object[]{-8.1, -1.2, 7.1, 20.2}, localDecl, itExpression, null);
    }
    
    /**
     * Tests the sortedBy operation on String sequences.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSortedByStringSequenceOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", StringType.TYPE, null);
        ConstraintSyntaxTree itExpression = new Variable(localDecl);
        testSortedBySequenceOperation(StringType.TYPE, new Object[]{"aa", "zz", "cc", "bb"}, 
            new Object[]{"aa", "bb", "cc", "zz"}, localDecl, itExpression, null);
    }

    /**
     * Tests the sortedBy operation on integer sequences.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testSortedByCompoundSequenceOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        Compound cmp = new Compound("Cmp", project);
        DecisionVariableDeclaration cmpA = new DecisionVariableDeclaration("a", StringType.TYPE, project);
        cmp.add(cmpA);
        project.add(cmp);
        // some expression, also just a would do the job
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("c", cmp, null);
        ConstraintSyntaxTree itExpression = new CompoundAccess(new Variable(localDecl), "a");
        Object[] actual = new Object[3];
        actual[0] = ValueFactory.createValue(cmp, new Object[]{"a", "zz"});
        actual[1] = ValueFactory.createValue(cmp, new Object[]{"a", "aa"});
        actual[2] = ValueFactory.createValue(cmp, new Object[]{"a", "bb"});
        Object[] expected = new Object[3];
        expected[0] = actual[1];
        expected[1] = actual[2];
        expected[2] = actual[0];
        testSortedBySequenceOperation(cmp, actual, expected, localDecl, itExpression, project);
    }
    
    /**
     * Tests the "apply" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testApplyContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        testApplyIterateContainerOperation(Sequence.APPLY);
    }

    /**
     * Tests the "iterate" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testIterateContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        testApplyIterateContainerOperation(Sequence.ITERATE);
    }

    /**
     * Tests the apply/iterate container operation.
     * 
     * @param op the operation to test
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    private void testApplyIterateContainerOperation(Operation op) throws ValueDoesNotMatchTypeException, 
        ConfigurationException, CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Sequence seqType = new Sequence("mySeq", IntegerType.TYPE, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 2, 3, 4, 5}), AssignmentState.ASSIGNED);

        // unusual start value
        ConstantValue const100 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 100));
        DecisionVariableDeclaration resultDecl = new DecisionVariableDeclaration("r", IntegerType.TYPE, null);
        resultDecl.setValue(const100);
        
        DecisionVariableDeclaration localDecl = new DecisionVariableDeclaration("a", IntegerType.TYPE, null);
        ConstantValue const2 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        // r = r + a * 2
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.MULT_INTEGER_INTEGER, const2);
        itExpression = Utils.createCall(resultDecl, IntegerType.PLUS_INTEGER_INTEGER, itExpression);
        itExpression = Utils.createCall(resultDecl, IntegerType.ASSIGNMENT_INTEGER_INTEGER, itExpression);
        itExpression.inferDatatype();
        
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, op, itExpression, localDecl, resultDecl);
        containerOp.inferDatatype();
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Utils.assertEquals(130, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 1, 1, 1, 1}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Utils.assertEquals(110, visitor.getResult());
        visitor.clear();

        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Utils.assertEquals(100, visitor.getResult());
        visitor.clear();

        // with tmp variable - shall be ignored
        DecisionVariableDeclaration tempLocal = new DecisionVariableDeclaration("tmp", BooleanType.TYPE, null);
        tempLocal.setValue(BooleanValue.TRUE);
        itExpression = new BlockExpression(new ConstraintSyntaxTree[] {itExpression});
        containerOp = Utils.createContainerCall(decl1, op, 
            itExpression, localDecl, tempLocal, resultDecl);
        containerOp.inferDatatype();
        var.setValue(ValueFactory.createValue(seqType, new Object[]{1, 1, 1, 1, 1}), AssignmentState.ASSIGNED);
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        containerOp.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Utils.assertEquals(110, visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Tests the "typeSelect" and "typeReject" container operations.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testTypeSelectContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project project = new Project("Test");
        // Types
        Compound baseC = new Compound("base", project);
        baseC.add(new DecisionVariableDeclaration("name", StringType.TYPE, baseC));
        project.add(baseC);
        Compound refC = new Compound("refined", project, baseC);
        project.add(refC);
        Sequence seqType = new Sequence("mySeq", baseC, project);
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("s", seqType, project);
        project.add(decl1);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable var = config.getDecision(decl1);
        Object[] seqData = new Object[6];
        seqData[0] = ValueFactory.createValue(baseC, createCompoundData("b.1"));
        seqData[1] = ValueFactory.createValue(refC, createCompoundData("r.1"));
        seqData[2] = ValueFactory.createValue(baseC, createCompoundData("b.2"));
        seqData[3] = ValueFactory.createValue(refC, createCompoundData("r.2"));
        seqData[4] = ValueFactory.createValue(refC, createCompoundData("r.3"));
        seqData[5] = ValueFactory.createValue(baseC, createCompoundData("b.3"));
        Object[] seqDataBaseC = new Object[3];
        seqDataBaseC[0] = seqData[0];
        seqDataBaseC[1] = seqData[2];
        seqDataBaseC[2] = seqData[5];
        var.setValue(ValueFactory.createValue(seqType, seqData), AssignmentState.ASSIGNED);
        // type expressions
        ConstraintSyntaxTree baseCTypeEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, baseC));
        ConstraintSyntaxTree refCTypeEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, refC));
        ConstraintSyntaxTree anyTypeEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, AnyType.TYPE));

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);

        // select the base type - all must be in
        assertTypeSelect(visitor, decl1, Sequence.TYPE_SELECT, baseCTypeEx, seqData);
        assertTypeSelect(visitor, decl1, Sequence.SELECT_BY_TYPE, baseCTypeEx, seqDataBaseC); // only 3 baseC
        assertTypeSelect(visitor, decl1, Sequence.SELECT_BY_KIND, baseCTypeEx, seqData);

        // reject the base type - all must be out
        assertTypeSelect(visitor, decl1, Sequence.TYPE_REJECT, baseCTypeEx, new Object[]{});

        // select any type - all must be in
        assertTypeSelect(visitor, decl1, Sequence.TYPE_SELECT, anyTypeEx, seqData);
        assertTypeSelect(visitor, decl1, Sequence.SELECT_BY_TYPE, anyTypeEx, new Object[]{}); // no any instance
        assertTypeSelect(visitor, decl1, Sequence.SELECT_BY_KIND, anyTypeEx, seqData);

        // reject any type - all must be out
        assertTypeSelect(visitor, decl1, Sequence.TYPE_REJECT, anyTypeEx, new Object[]{});

        // select the refined type - only refined instances shall be in
        assertTypeSelect(visitor, decl1, Sequence.TYPE_SELECT, refCTypeEx, 
            new Object[]{seqData[1], seqData[3], seqData[4]});

        // select the refined type - only base instances shall be in
        assertTypeSelect(visitor, decl1, Sequence.TYPE_REJECT, refCTypeEx, 
            new Object[]{seqData[0], seqData[2], seqData[5]});

        // go on with empty sequence
        var.setValue(ValueFactory.createValue(seqType, new Object[]{}), AssignmentState.ASSIGNED);
        
        // select base type from empty sequence -> empty
        assertTypeSelect(visitor, decl1, Sequence.TYPE_SELECT, baseCTypeEx, new Object[]{});

        // reject base type from empty sequence -> empty
        assertTypeSelect(visitor, decl1, Sequence.TYPE_REJECT, baseCTypeEx, new Object[]{});
        
        visitor.clear();
    }

    /**
     * Creates the object-data representing a compound value in {@link #testTypeSelectContainerOperation()}.
     * @param name the name of the compound
     * @return the object array for the value factory
     */
    private static final Object[] createCompoundData(String name) {
        return new Object[]{"name", name};
    }

    /**
     * Asserts the results of a type select/reject operation.
     * 
     * @param visitor the (reusable) visitor to evaluate with
     * @param decl the variable declaration carrying the collection
     * @param op the operation to be tested
     * @param typeEx the type expression to select/reject for
     * @param expected the expected result
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    private static final void assertTypeSelect(EvaluationVisitor visitor, DecisionVariableDeclaration decl, 
        Operation op, ConstraintSyntaxTree typeEx, Object[] expected) throws CSTSemanticException {
        ConstraintSyntaxTree containerOp = Utils.createCall(decl, op, typeEx);
        containerOp.inferDatatype();
        containerOp.accept(visitor);
        Utils.assertContainer(expected, visitor.getResult());
        visitor.clearResult();
    }

    /**
     * Tests closure operations on sequences.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testClosureOnSequence() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        testClosure(false, false);
    }

    /**
     * Tests closure operations on sets.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testClosureOnSet() throws CSTSemanticException, ValueDoesNotMatchTypeException, ConfigurationException {
        testClosure(true, false);
    }
    
    /**
     * Tests isAcyclic operations on sequences.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testIsAcyclicOnSequence() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        testClosure(false, true);
    }

    /**
     * Tests isAcyclic operations on sets.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testIsAcyclicOnSet() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        testClosure(true, true);
    }

    /**
     * Tests closure operations.
     * 
     * @param set test on set or on sequence
     * @param testIsAcyclic whether the closure or the isAcyclic operation shall be tested
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    private void testClosure(boolean set, boolean testIsAcyclic) throws CSTSemanticException, 
        ValueDoesNotMatchTypeException, ConfigurationException {
        Project project = new Project("Test");
        Compound cmp = new Compound("Cmp", project);
        Reference refType = new Reference("ref(Cmp)", cmp, project);
        IDatatype setRefType = set ? new Set("setOf(ref(Cmp))", refType, project) 
            : new Sequence("sequenceOf(ref(Cmp))", refType, project);
        DecisionVariableDeclaration cmpName = new DecisionVariableDeclaration("name", StringType.TYPE, cmp);
        cmp.add(cmpName);
        DecisionVariableDeclaration cmpNext = new DecisionVariableDeclaration("next", refType, cmp);
        cmp.add(cmpNext);
        DecisionVariableDeclaration cmpFollow = new DecisionVariableDeclaration("follow", setRefType, cmp);
        cmp.add(cmpFollow);
        project.add(cmp);
        
        DecisionVariableDeclaration cVar1 = new DecisionVariableDeclaration("c1", cmp, project);
        project.add(cVar1);
        DecisionVariableDeclaration cVar2 = new DecisionVariableDeclaration("c2", cmp, project);
        project.add(cVar2);
        DecisionVariableDeclaration cVar3 = new DecisionVariableDeclaration("c3", cmp, project);
        project.add(cVar3);
        DecisionVariableDeclaration allVar = new DecisionVariableDeclaration("all", setRefType, project);
        project.add(allVar);
        // Assign value
        Configuration config = new Configuration(project);
        IDecisionVariable vcVar1 = config.getDecision(cVar1);
        IDecisionVariable vcVar2 = config.getDecision(cVar2);
        IDecisionVariable vcVar3 = config.getDecision(cVar3);
        IDecisionVariable vallVar = config.getDecision(allVar);
        setValue(vcVar1, ValueFactory.createValue(cmp, createCompoundData("c1", cVar2, cVar2)));
        setValue(vcVar2, ValueFactory.createValue(cmp, createCompoundData("c2", cVar3, cVar3)));
        setValue(vcVar3, ValueFactory.createValue(cmp, createCompoundData("c3", cVar1, cVar1, cVar2)));
        setValue(vallVar, ValueFactory.createValue(setRefType, cVar1, cVar2, cVar3));

        ConstraintSyntaxTree allNextClosure = createClosureContainerOp(refType, "next", allVar, testIsAcyclic);
        ConstraintSyntaxTree allFollowClosure = createClosureContainerOp(refType, "follow", allVar, testIsAcyclic);
        ConstraintSyntaxTree var1NextClosure = createClosureContainerOp(refType, "next", cVar1, testIsAcyclic);
        ConstraintSyntaxTree var1FollowClosure = createClosureContainerOp(refType, "follow", cVar1, testIsAcyclic);

        EvaluationVisitor visitor = new EvaluationVisitor();
        // sequence is determined through pre-order (OCL)
        assertClosure(visitor, config, allNextClosure, new Object[]{cVar1, cVar2, cVar3}, 
            acyclic(false, testIsAcyclic));
        assertClosure(visitor, config, allFollowClosure, new Object[]{cVar1, cVar2, cVar3}, 
            acyclic(false, testIsAcyclic));
        assertClosure(visitor, config, var1NextClosure, new Object[]{cVar1, cVar2, cVar3}, 
            acyclic(false, testIsAcyclic));
        assertClosure(visitor, config, var1FollowClosure, new Object[]{cVar1, cVar2, cVar3}, 
            acyclic(false, testIsAcyclic));

        // Test empty
        setValue(vallVar, ValueFactory.createValue(setRefType, (Object[]) null));
        assertClosure(visitor, config, allNextClosure, new Object[]{}, acyclic(true, testIsAcyclic));
        assertClosure(visitor, config, allFollowClosure, new Object[]{}, acyclic(true, testIsAcyclic));
    }
    
    /**
     * Returns the expected result for the IsAcyclic-test, i.e., passes on the <code>expected</code> if 
     * <code>testIsAcyclic</code> is enabled, <b>null</b> else.
     * 
     * @param expected the expected value
     * @param testIsAcyclic shall the expected value be passed on
     * @return the expected value or <b>null</b>
     */
    private Boolean acyclic(boolean expected, boolean testIsAcyclic) {
        Boolean result;
        if (testIsAcyclic) {
            result = expected;
        } else {
            result = null; // closure operation
        }
        return result;
    }

    /**
     * Creates the object-data representing a compound value in {@link #testClosure()}.
     * 
     * @param name the name of the compound
     * @param next the reference target for the next slot
     * @param follow the reference target(s) for the follow slot
     * @return the object array for the value factory
     */
    private static final Object[] createCompoundData(String name, AbstractVariable next, AbstractVariable... follow) {
        return new Object[]{"name", name, "next", next, "follow", follow};
    }

    /**
     * Sets an assigned value for <code>var</code>.
     * 
     * @param var the variable to set the value on
     * @param value the value
     * @throws ConfigurationException in case of configuration/value setting problems
     */
    private static void setValue(IDecisionVariable var, Value value) throws ConfigurationException {
        var.setValue(value, AssignmentState.ASSIGNED);
    }

    /**
     * Creates a closure container operation expression.
     * 
     * @param itType the iterator type
     * @param slot the slot to access on the iterator
     * @param var the variable to bind the operation to
     * @param testIsAcyclic test the isAcyclic operation
     * @return the closure operation expression
     * @throws CSTSemanticException in case of syntactic problems with the constraint expression
     */
    private static ConstraintSyntaxTree createClosureContainerOp(IDatatype itType, String slot, 
        DecisionVariableDeclaration var, boolean testIsAcyclic) throws CSTSemanticException {
        DecisionVariableDeclaration itDecl = new DecisionVariableDeclaration("a", itType, null);
        ConstraintSyntaxTree itEx = new CompoundAccess(new Variable(itDecl), slot);
        itEx.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(var, 
            testIsAcyclic ? Container.IS_ACYCLIC : Container.CLOSURE, itEx, itDecl);
        containerOp.inferDatatype();
        return containerOp;
    }

    /**
     * Asserts the closure result and clears the visitor.
     * 
     * @param visitor the reusable visitor to evaluate on
     * @param config the configuration (for initializing <code>visitor</code>)
     * @param ex the expression to evaluate
     * @param expected the expected values
     * @param acyclic whether the outcome of the isAcyclic operation shall be tested against that value
     */
    private static void assertClosure(EvaluationVisitor visitor, Configuration config, ConstraintSyntaxTree ex, 
        Object[] expected, Boolean acyclic) {
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        ex.accept(visitor);
        Value result = visitor.getResult();
        if (null != acyclic) {
            Utils.assertEquals(acyclic, result);
        } else {
            Assert.assertTrue(result instanceof ContainerValue);
            Assert.assertTrue(Set.TYPE.isAssignableFrom(result.getType()));
            Utils.assertContainer(expected, visitor.getResult());
        }
        visitor.clear();
    }

}
