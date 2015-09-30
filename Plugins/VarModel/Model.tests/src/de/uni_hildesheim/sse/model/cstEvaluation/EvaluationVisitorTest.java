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
package de.uni_hildesheim.sse.model.cstEvaluation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.CompoundVariable;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the {@link EvaluationVisitor}.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class EvaluationVisitorTest {

    // TODO Check whether reusing a project in tests really makes sense as for independent execution cleanup among 
    // tests is required!
    private Project project;
    
    /**
     * Creates common parts, which are used in all tests.
     * This will create a new (empty) project;
     */
    @Before
    public void setUp() {
        project = new Project(EvaluationVisitorTest.class.getSimpleName());
    }
    
    /**
     * Creates a new assignment constraint for the given variable.
     * This will only assign a <b>constant value</b> to the variable.
     * @param decl The declaration for which a assignment should be done.
     * @param oValue A value for setting the value.
     *     See {@link ValueFactory#createValue(de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype, Object...)}
     *     for more information.
     *     If oValue is already one {@link Value}, this value will be used for creating the constraint.
     * @return The assignment constraint, expressing <code>decl = oValue</code>. This constraint is not added to the
     *     project to avoid side effects during initialization of the configuration.
     */
    private ConstraintSyntaxTree createAssignmentConstraint(DecisionVariableDeclaration decl,
        Object... oValue) {
        
        ConstraintSyntaxTree assignment = null;
        if (null != oValue && 1 == oValue.length && oValue[0] instanceof Value) {
            ConstantValue constValue = new ConstantValue((Value) oValue[0]);
            assignment = createAssignmentConstraint(decl, constValue);
        } else {
            try {
                Value value = ValueFactory.createValue(decl.getType(), oValue);
                ConstantValue constValue = new ConstantValue(value);
                
                assignment = createAssignmentConstraint(decl, constValue);
            } catch (ValueDoesNotMatchTypeException e) {
                Assert.fail(e.getMessage());
            }
        }
        
        return assignment;
    }
    
    /**
     * Creates a new assignment constraint for the given variable.
     * Contrary to {@link #createAssignmentConstraint(DecisionVariableDeclaration, Object...)},
     * the value can be an arbitrary constraint, e.g. another variable.
     * @param decl The declaration for which a assignment should be done.
     * @param dynValue another constraint, which can be used to infer a value for <tt>decl</tt>.
     * @return The assignment constraint, expressing <code>decl = dynValue</code>. This constraint is not added to the
     *     project to avoid side effects during initialization of the configuration.
     */
    private ConstraintSyntaxTree createAssignmentConstraint(DecisionVariableDeclaration decl,
        ConstraintSyntaxTree dynValue) {
        
        ConstraintSyntaxTree assignment = null;
        try {
            Variable var = new Variable(decl);
            assignment = new OCLFeatureCall(var, OclKeyWords.ASSIGNMENT, dynValue);
            assignment.inferDatatype();
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        return assignment;
    }
    
    /**
     * Tests whether the {@link EvaluationVisitor} is able to evaluate simple integer assignments in the form of
     * <code>intA = 5</code>.
     */
    @Test
    public void testAssignIntegerValue() {
        final Object oValue = 5;
        
        // Create project with one decision variable and an assignment.
        // Declaration
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(decl);
        // Assignment
        ConstraintSyntaxTree assignment = createAssignmentConstraint(decl, oValue);
        
        // Create Configuration
        Configuration config = new Configuration(project);
        final IDecisionVariable var = config.getDecision(decl);
        Assert.assertNull(var.getValue());
        
        // Create visitor
        EvaluationVisitor visitor = new EvaluationVisitor();
        ValueChangeListener listener = new ValueChangeListener() {
            
            @Override
            void valueChanged(IDecisionVariable variable) {
                Assert.assertNotNull(var.getValue());
                Assert.assertEquals(oValue, var.getValue().getValue());
                Assert.assertSame(var, variable);
            }

            @Override
            void valueUnresolved(IDecisionVariable variable) {
                // TODO Auto-generated method stub
            }
        };
        
        visitor.init(config, AssignmentState.DEFAULT, true, listener);
        assignment.accept(visitor);
        
        // Test whether listener was executed, rest of the test is inside listening method.
        Assert.assertTrue(listener.wasCalled());
        visitor.clear();
    }

    
    /**
     * Tests whether the <tt>at</tt> operation works on a sequence variable with was set to <tt>null</tt>.
     * Adam Krafczyk detected an uncaught NullPointerException.
     * @throws CSTSemanticException Must not occur otherwise is this test broken.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise is this test broken.
     * @see <a href="https://projects.sse.uni-hildesheim.de/agilo/QualiMaster/ticket/121">
     * https://projects.sse.uni-hildesheim.de/agilo/QualiMaster/ticket/121</a>
     */
    @Test
    public void testAtOperationOnNullValue() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        /*
         * Create project with following constraints and evaluate it:
         * sequenceOf(Integer) seq;
         * seq = null;
         * at(seq, 5) == 6;
         */
        Sequence seqType = new Sequence("IntegerSequence", IntegerType.TYPE, project);
        project.add(seqType);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("seq", seqType, project);
        project.add(decl);
        // Null assignment
        ConstraintSyntaxTree assignment = createAssignmentConstraint(decl, NullValue.INSTANCE);
        Constraint constraint1 = new Constraint(project);
        constraint1.setConsSyntax(assignment);
        project.add(constraint1);
        // Equals operation
        ConstantValue val5 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 5));
        ConstantValue val6 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 6));
        ConstraintSyntaxTree atOperation = new OCLFeatureCall(new Variable(decl), OclKeyWords.AT, val5);
        ConstraintSyntaxTree equalsOperation = new OCLFeatureCall(atOperation, OclKeyWords.EQUALS, val6);
        Constraint constraint2 = new Constraint(project);
        constraint2.setConsSyntax(equalsOperation);
        project.add(constraint2);
        // Validate Projects
        ProjectTestUtilities.validateProject(project);
        
        // Create Configuration
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(project, true);
        final IDecisionVariable var = config.getDecision(decl);
        Assert.assertSame(NullValue.INSTANCE, var.getValue());
        
     // Test correct behavior of visitor
        assertEvaluationVisitor(equalsOperation, config, "At");
    }
    
    /**
     * Tests whether the <tt>size</tt> operation works on a sequence variable with was set to <tt>null</tt>.
     * Adam Krafczyk detected an uncaught NullPointerException.
     * @throws CSTSemanticException Must not occur otherwise is this test broken.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise is this test broken.
     * @see <a href="https://projects.sse.uni-hildesheim.de/agilo/QualiMaster/ticket/122">
     * https://projects.sse.uni-hildesheim.de/agilo/QualiMaster/ticket/122</a>
     */
    @Test
    public void testSizeOperationOnNullValue() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        /*
         * Create project with following constraints and evaluate it:
         * sequenceOf(Integer) seq;
         * seq = null;
         * size(seq) == 6;
         */
        Sequence seqType = new Sequence("IntegerSequence", IntegerType.TYPE, project);
        project.add(seqType);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("seq", seqType, project);
        project.add(decl);
        // Null assignment
        ConstraintSyntaxTree assignment = createAssignmentConstraint(decl, NullValue.INSTANCE);
        Constraint constraint1 = new Constraint(project);
        constraint1.setConsSyntax(assignment);
        project.add(constraint1);
        // Equals operation
        ConstantValue val6 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 6));
        ConstraintSyntaxTree seziOperation = new OCLFeatureCall(new Variable(decl), OclKeyWords.SIZE);
        ConstraintSyntaxTree equalsOperation = new OCLFeatureCall(seziOperation, OclKeyWords.EQUALS, val6);
        Constraint constraint2 = new Constraint(project);
        constraint2.setConsSyntax(equalsOperation);
        project.add(constraint2);
        // Validate Projects
        ProjectTestUtilities.validateProject(project, true);
        
        // Create Configuration
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(project, true);
        final IDecisionVariable var = config.getDecision(decl);
        Assert.assertSame(NullValue.INSTANCE, var.getValue());
        
        // Test correct behavior of visitor
        assertEvaluationVisitor(equalsOperation, config, "Size");
    }

    /**
     * Tests the correct behavior of the {@link EvaluationVisitor}, while working with sequences, which are set to
     * {@link NullValue}.
     * @param cst A sequence operation which shall be visited by the {@link EvaluationVisitor}.
     * @param config The configuration of a project containing the <tt>cst</tt> constraint.
     * @param operation The name of the operation for creating sufficient error messages if the assertion fails.
     */
    private void assertEvaluationVisitor(ConstraintSyntaxTree cst, Configuration config, String operation) {
        EvaluationVisitor visitor = new EvaluationVisitor();
        
        visitor.init(config, AssignmentState.ASSIGNED, false, null);
        try {
            cst.accept(visitor);
        } catch (NullPointerException npe) {
            Assert.fail(operation + "-operation causes a NullPointerException on NullValues for a sequence variable.");
            npe.printStackTrace();
        }
        
        EvaluationVisitor.Message errorMsg = visitor.getMessage(0);
        Assert.assertNotNull(errorMsg);
        Assert.assertSame(Status.ERROR, errorMsg.getStatus());
        Assert.assertNotNull("Error message does not have a description what failed!", errorMsg.getDescription());
        try {
            errorMsg.getVariable();
        } catch (NullPointerException npe) {
            Assert.fail("Error: EvaluationVisitor.Message.getVariable() is producing NullPointerExceptions!");
            npe.printStackTrace();
        }
    }
    
    /**
     * Tests whether the {@link EvaluationVisitor} is able to evaluate an integer assignments in the form of
     * <code>intB = intA</code>, whereby intA has already a value.
     */
    @Test
    public void testAssignValueOfOtherVariable() {
        final IAssignmentState usedState = AssignmentState.DEFAULT;
        final Object oValue = 5;
        
        // Create project with two decision variables and two assignments.
        // Declarations
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(decl1);
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(decl2);
        
        // Assignments
        ConstraintSyntaxTree assignment1 = createAssignmentConstraint(decl1, oValue);
        Variable varValue = new Variable(decl1);
        ConstraintSyntaxTree assignment2 = createAssignmentConstraint(decl2, varValue);
        
        // Create configuration
        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, usedState, true, null);
        assignment1.accept(visitor);
        Assert.assertEquals(oValue, config.getDecision(decl1).getValue().getValue());
        
        // Test whether assignment2 does not lead to an error
        final IDecisionVariable var = config.getDecision(decl2);
        ValueChangeListener listener = new ValueChangeListener() {
            
            @Override
            void valueChanged(IDecisionVariable variable) {
                IAssignmentState state = variable.getState();
                Value val = variable.getValue();
                
                Assert.assertSame(var, variable);
                Assert.assertNotNull(val);
                Assert.assertEquals(oValue, val.getValue());
                Assert.assertSame(usedState, state);
            }

            @Override
            void valueUnresolved(IDecisionVariable variable) {
                // TODO Auto-generated method stub
            }
        };
        
        visitor.init(config, usedState, true, listener);
        assignment2.accept(visitor);
        
        // Test whether listener was executed, rest of the test is inside listening method.
        Assert.assertTrue(listener.wasCalled());
        visitor.clear();
    }
    
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
     * Tests the "collect" container operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCollectContainerOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
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
        ConstantValue const10 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 10));
        ConstraintSyntaxTree itExpression = Utils.createCall(localDecl, IntegerType.MULT_INTEGER_INTEGER, const10);
        itExpression.inferDatatype();
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.COLLECT, itExpression, localDecl);
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
        
        ConstraintSyntaxTree containerOp = Utils.createContainerCall(decl1, Sequence.APPLY, 
            itExpression, localDecl, resultDecl);
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
        var.setValue(ValueFactory.createValue(seqType, seqData), AssignmentState.ASSIGNED);
        // type expressions
        ConstraintSyntaxTree baseCTypeEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, baseC));
        ConstraintSyntaxTree refCTypeEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, refC));
        ConstraintSyntaxTree anyTypeEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, AnyType.TYPE));

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);

        // select the base type - all must be in
        assertTypeSelect(visitor, decl1, Sequence.TYPE_SELECT, baseCTypeEx, seqData);

        // reject the base type - all must be out
        assertTypeSelect(visitor, decl1, Sequence.TYPE_REJECT, baseCTypeEx, new Object[]{});

        // select any type - all must be in
        assertTypeSelect(visitor, decl1, Sequence.TYPE_SELECT, anyTypeEx, seqData);

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
     * Tests the if-then-else expression.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testIfThenElse() throws ValueDoesNotMatchTypeException, ConfigurationException, CSTSemanticException {
        Project project = new Project("Test");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("test", IntegerType.TYPE, project);
        project.add(decl);

        Configuration config = new Configuration(project);
        config.getDecision(decl).setValue(ValueFactory.createValue(IntegerType.TYPE, 1), AssignmentState.ASSIGNED);
        
        // if test>0 then true else false
        ConstraintSyntaxTree const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree condition = Utils.createCall(decl, IntegerType.GREATER_EQUALS_INTEGER_INTEGER, const0);
        condition.inferDatatype();
        ConstraintSyntaxTree expr = new IfThen(condition, 
            new ConstantValue(BooleanValue.TRUE), 
            new ConstantValue(BooleanValue.FALSE));

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);

        expr.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clearResult();

        config.getDecision(decl).setValue(ValueFactory.createValue(IntegerType.TYPE, -1), AssignmentState.ASSIGNED);
        expr.accept(visitor);
        Assert.assertEquals(BooleanValue.FALSE, visitor.getResult());
        visitor.clearResult();
        
        expr = new IfThen(condition, new ConstantValue(BooleanValue.TRUE), null);
        expr.accept(visitor);
        Assert.assertNull(visitor.getResult());
        visitor.clearResult();

        visitor.clear();
    }
    
    /**
     * Tests the let construct.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testLet() throws ValueDoesNotMatchTypeException, ConfigurationException, CSTSemanticException {
        Project project = new Project("Test");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("a", IntegerType.TYPE, project);
        project.add(decl);

        Configuration config = new Configuration(project);
        config.getDecision(decl).setValue(ValueFactory.createValue(IntegerType.TYPE, 7), AssignmentState.ASSIGNED);

        // int a = 7; let t = a * 7 in t > 0;
        DecisionVariableDeclaration letVar = new DecisionVariableDeclaration("t", IntegerType.TYPE, null);
        ConstraintSyntaxTree const7 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 7));
        ConstraintSyntaxTree const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree defltVal = Utils.createCall(decl, IntegerType.MULT_INTEGER_INTEGER, const7);
        defltVal.inferDatatype();
        letVar.setValue(defltVal);
        ConstraintSyntaxTree inExpr = Utils.createCall(letVar, IntegerType.GREATER_INTEGER_INTEGER, const0);
        inExpr.inferDatatype();
        ConstraintSyntaxTree letExpr = new Let(letVar, inExpr);
        letExpr.inferDatatype();

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        letExpr.accept(visitor);
        Assert.assertEquals(BooleanValue.TRUE, visitor.getResult());
        visitor.clear();
    }
    
    /**
     * Tests a custom operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        
        // int myFunc(int x) = {x * 7}
        Project project = new Project("Test");
        DecisionVariableDeclaration param = new DecisionVariableDeclaration("x", IntegerType.TYPE, null);
        ConstraintSyntaxTree const7 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 7));
        ConstraintSyntaxTree func = Utils.createCall(param, IntegerType.MULT_INTEGER_INTEGER, const7);
        func.inferDatatype();
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[1];
        params[0] = param;
        CustomOperation custOp = new CustomOperation(IntegerType.TYPE, "myFunc", project.getType(), func, params);
        OperationDefinition opDef = new OperationDefinition(project);
        opDef.setOperation(custOp);
        project.add(opDef);
        
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("a", IntegerType.TYPE, project);
        project.add(decl);
        
        Configuration config = new Configuration(project);
        config.getDecision(decl).setValue(ValueFactory.createValue(IntegerType.TYPE, 3), AssignmentState.ASSIGNED);
        ConstraintSyntaxTree call = new OCLFeatureCall(null, "myFunc", project, new Variable(decl));
        call.inferDatatype();
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        call.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        Assert.assertEquals(21, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
    }

    /**
     * Tests reference parameters at custom operations.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperationReferenceParameter() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
            
        Project project = new Project("Test");

        // compound Base {};
        Compound cBase = new Compound("Base", project);
        project.add(cBase);

        DecisionVariableDeclaration cBaseVar = new DecisionVariableDeclaration("b", cBase, project);
        project.add(cBaseVar);

        Reference cBaseRef = new Reference("BaseRef", cBase, project);
        DecisionVariableDeclaration cBaseRefVar = new DecisionVariableDeclaration("bRef", cBaseRef, project);
        project.add(cBaseRefVar);
        
        // def Boolean test(Base b) = isDefined(b);
        DecisionVariableDeclaration param1 = new DecisionVariableDeclaration("b", cBase, null);
        DecisionVariableDeclaration[] params1 = new DecisionVariableDeclaration[1];
        params1[0] = param1;
        ConstraintSyntaxTree func = Utils.createCall(param1, Compound.IS_DEFINED);
        func.inferDatatype();
        CustomOperation custOp1 = new CustomOperation(BooleanType.TYPE, "test", project.getType(), func, params1);
        OperationDefinition opDef1 = new OperationDefinition(project);
        opDef1.setOperation(custOp1);
        project.add(opDef1);

        // test(b); // b is undefined -> false
        ConstraintSyntaxTree cst = new OCLFeatureCall(null, "test", project, new Variable(cBaseRefVar));
        cst.inferDatatype();
        
        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(false, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clearResult();
        
        // define b
        config.getDecision(cBaseVar).setValue(ValueFactory.createValue(cBase, (Object[]) null), 
            AssignmentState.ASSIGNED);
        config.getDecision(cBaseRefVar).setValue(ValueFactory.createValue(cBaseRef, cBaseVar), 
            AssignmentState.ASSIGNED);
        
        // test(b); // b is defined -> true
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clear();
    }
    
    /**
     * Tests dynamic dispatch for custom operation.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testCustomOperationDispatch() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        
        Project project = new Project("Test");

        // compound Base {};
        Compound cBase = new Compound("Base", project);
        project.add(cBase);

        // compound Refined refines Base {};
        Compound cRefined = new Compound("Refined", project, cBase);
        project.add(cRefined);

        // def Integer test(Base b) = 0;
        ConstraintSyntaxTree const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        DecisionVariableDeclaration param1 = new DecisionVariableDeclaration("b", cBase, null);
        DecisionVariableDeclaration[] params1 = new DecisionVariableDeclaration[1];
        params1[0] = param1;
        CustomOperation custOp1 = new CustomOperation(IntegerType.TYPE, "test", project.getType(), const0, params1);
        OperationDefinition opDef1 = new OperationDefinition(project);
        opDef1.setOperation(custOp1);
        project.add(opDef1);

        // def Integer test(Refined r) = 1;
        ConstraintSyntaxTree const1 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 1));
        DecisionVariableDeclaration param2 = new DecisionVariableDeclaration("r", cRefined, null);
        DecisionVariableDeclaration[] params2 = new DecisionVariableDeclaration[1];
        params2[0] = param2;
        CustomOperation custOp2 = new CustomOperation(IntegerType.TYPE, "test", project.getType(), const1, params2);
        OperationDefinition opDef2 = new OperationDefinition(project);
        opDef2.setOperation(custOp2);
        project.add(opDef2);

        DecisionVariableDeclaration var = new DecisionVariableDeclaration("r", cRefined, project);
        project.add(var);
        
        ConstraintSyntaxTree cst = new OCLFeatureCall(null, "test", project, new Variable(var));
        cst.inferDatatype();
        
        Configuration config = new Configuration(project);
        config.getDecision(var).setValue(ValueFactory.createValue(cRefined, (Object[]) null), AssignmentState.ASSIGNED);
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.setDispatchScope(project); // this is important!
        cst.accept(visitor);
        Assert.assertTrue(visitor.getResult() instanceof IntValue);
        // use the more specific one due to dynamic dispatch
        Assert.assertEquals(1, ((IntValue) visitor.getResult()).getValue().intValue());
        visitor.clear();
    }
    
    /**
     * Tests an expression with "self".
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testSelf()  throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        Project project = new Project("Test");
        Compound compC = new Compound("C", project);
        ConstraintSyntaxTree cst = Utils.createCall(new Self(compC), Compound.NOTEQUALS, 
            new ConstantValue(NullValue.INSTANCE));
        cst.inferDatatype();
        Constraint constr = new Constraint(cst, compC);
        compC.addConstraint(constr, false);
        project.add(compC);

        DecisionVariableDeclaration testVar = new DecisionVariableDeclaration("test", compC, project);
        project.add(testVar);

        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        
        visitor.visit(cst);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clearResult();
        
        visitor.clear();
    }

    /**
     * Tests a statically qualified constraint within a compound.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testStaticallyQualified() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        Project project = new Project("Test");
        Compound algC = new Compound("Algorithm", project);
        DecisionVariableDeclaration algInput = new DecisionVariableDeclaration("input", StringType.TYPE, algC);
        algC.add(algInput);
        project.add(algC);
        
        Compound familyC = new Compound("Family", project);
        DecisionVariableDeclaration famInput = new DecisionVariableDeclaration("input", StringType.TYPE, familyC);
        familyC.add(famInput);
        Set algSet = new Set("AlgSet", algC, null);
        DecisionVariableDeclaration famAlgs = new DecisionVariableDeclaration("algorithms", algSet, familyC);
        familyC.add(famAlgs);
        project.add(familyC);
        
        // implicit static access
        DecisionVariableDeclaration iter = new DecisionVariableDeclaration("algorithm", algC, null);
        ConstraintSyntaxTree iterEx = Utils.createCall(new CompoundAccess(new Variable(iter), "input"), 
            StringType.EQUALS, new Variable(famInput));
        iterEx.inferDatatype();
        ConstraintSyntaxTree cst = Utils.createContainerCall(new Variable(famAlgs), Set.FORALL, iterEx, iter);
        cst.inferDatatype();
        
        DecisionVariableDeclaration fam = new DecisionVariableDeclaration("testFam", familyC, project);
        project.add(fam);

        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);

        // implicit all quantor evaluates for empty set (undefined) to true
        visitor.visit(cst);
        Assert.assertNull(visitor.getResult());
        visitor.clearResult();
        
        // implicit all quantor evaluates for given set with unmatching slots to false
        Value algVal = ValueFactory.createValue(algC, new Object[]{"input", "alg"});
        Value algs = ValueFactory.createValue(algSet, new Object[]{algVal});
        Value famVal = ValueFactory.createValue(familyC, new Object[]{"input", "fam", "algorithms", algs});
        config.getDecision(fam).setValue(famVal, AssignmentState.ASSIGNED); // this shall cause a signal -> allInstance
        visitor.visit(cst);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(false, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        visitor.clear();
    }

    /**
     * Tests a statically qualified constraint on top-level.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testStaticallyQualifiedTop() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        Project project = new Project("Test");
        Compound algC = new Compound("Algorithm", project);
        DecisionVariableDeclaration algInput = new DecisionVariableDeclaration("input", StringType.TYPE, algC);
        algC.add(algInput);
        project.add(algC);

        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("algorithm", algC, project);
        project.add(decl);
        // explicit static access
        ConstraintSyntaxTree algCEx = new ConstantValue(ValueFactory.createValue(MetaType.TYPE, algC));
        algCEx.inferDatatype();
        ConstraintSyntaxTree consEx = Utils.createCall(new CompoundAccess(algCEx, "input"), 
            StringType.EQUALS, new ConstantValue(ValueFactory.createValue(StringType.TYPE, "abba")));
        consEx.inferDatatype();

        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);

        // implicit all quantor evaluates for empty set (undefined) to true
        visitor.visit(consEx);
        Assert.assertNull(visitor.getResult());
        visitor.clearResult();

        // implicit all quantor evaluates for given value with unmatching slot to false
        Value algVal = ValueFactory.createValue(algC, new Object[]{"input", "alg"});
        config.getDecision(decl).setValue(algVal, AssignmentState.ASSIGNED); // this shall cause a signal -> allInstance
        visitor.visit(consEx);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(false, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        visitor.clear();
    }
    
    /**
     * Tests nested compound accesses. This test uses the following IVML model:
     * <pre>
     * compound further {
     *     Integer f = 0;
     * }
     * 
     * compound position {
     *     refTo(further) rf;
     *     further f;
     * }
     * 
     * further f;
     * position p;
     * p.f.f > 0;
     * p.rf.f > 0;
     * </pre>
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testNestedCompoundAccess() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        
        Project project = new Project("Test");
        Compound furtherC = new Compound("further", project);
        DecisionVariableDeclaration furtherF = new DecisionVariableDeclaration("f", IntegerType.TYPE, furtherC);
        furtherC.add(furtherF);
        project.add(furtherC);
        
        Compound positionC = new Compound("position", project);
        Reference positionRFType = new Reference("rf", furtherC, null);
        DecisionVariableDeclaration positionRF = new DecisionVariableDeclaration("rf", positionRFType, positionC);
        positionC.add(positionRF);
        DecisionVariableDeclaration positionF = new DecisionVariableDeclaration("f", furtherC, positionC);
        positionC.add(positionF);
        project.add(positionC);

        DecisionVariableDeclaration projectF = new DecisionVariableDeclaration("f", furtherC, project);
        project.add(projectF);
        DecisionVariableDeclaration projectP = new DecisionVariableDeclaration("p", positionC, project);
        project.add(projectP);
        
        ConstantValue const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        ConstraintSyntaxTree c = new CompoundAccess(new Variable(projectP), "f");
        c.inferDatatype();
        c = new CompoundAccess(c, "f");
        c.inferDatatype();
        c = Utils.createCall(c, IntegerType.GREATER_INTEGER_INTEGER, const0);
        c.inferDatatype();
        
        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);

        visitor.visit(c);
        Assert.assertNull(visitor.getResult()); // undefined value
        visitor.clearResult();

        // define the values in the configuration
        IDecisionVariable fDec = config.getDecision(projectF);
        fDec.setValue(ValueFactory.createValue(furtherC, new Object[]{"f", 1}), 
            AssignmentState.DEFAULT);
        IDecisionVariable pDec = config.getDecision(projectP);
        Value pDecF = ValueFactory.createValue(furtherC, new Object[]{"f", 2});
        Value pDecRFValue = ValueFactory.createValue(positionRFType, projectF);
        pDec.setValue(ValueFactory.createValue(positionC, new Object[]{"f", pDecF, "rf", pDecRFValue}), 
            AssignmentState.DEFAULT);
        
        visitor.visit(c);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clearResult();

        c = new CompoundAccess(new Variable(projectP), "rf");
        c.inferDatatype();
        c = new CompoundAccess(c, "f");
        c.inferDatatype();
        c = Utils.createCall(c, IntegerType.GREATER_INTEGER_INTEGER, const0);
        c.inferDatatype();
        
        visitor.visit(c);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clearResult();

        visitor.clear();
    }
    
    /**
     * Tests {@link BooleanType#OR} and {@link BooleanType#AND}, which are treated as special cases inside of the
     * {@link EvaluationVisitor}. This should facilitate the evaluation of special cases like
     * <code>undef OR true</code> or <code>undef AND false</code>.
     */
    @Test
    public void testSpecialBooleanOperartions() {
        Boolean[] expectedANDResults = new Boolean[] {false, null, null, false, false, false, false, true, null};
        assertSpecialBooleanOperations(OclKeyWords.AND, expectedANDResults);
        
        Boolean[] expectedORResults = new Boolean[] {null, true, null, false, true, null, true, true, true};
        assertSpecialBooleanOperations(OclKeyWords.OR, expectedORResults);
    }
    
    /**
     * Tests all nine possible situations of an binary boolean operation.
     * It will test:
     * <ol>
     * <li><tt>undef OPERATION false</tt></li>
     * <li><tt>undef OPERATION true</tt></li>
     * <li><tt>undef OPERATION undef</tt></li>
     * <li><tt>false OPERATION false</tt></li>
     * <li><tt>false OPERATION true</tt></li>
     * <li><tt>false OPERATION undef</tt></li>
     * <li><tt>true OPERATION false</tt></li>
     * <li><tt>true OPERATION true</tt></li>
     * <li><tt>true OPERATION undef</tt></li>
     * </ol>
     * @param operation One of {@link OclKeyWords#AND} or {@link OclKeyWords#OR}.
     * @param expectedValues The expected values for the given list above, should bean arrays with length = 9.
     *     If expected that the {@link EvaluationVisitor} is not able to resolve the operation, add <tt>null</tt> to
     *     the specific position of the array.
     * @see #testSpecialBooleanOperartions()
     */
    private void assertSpecialBooleanOperations(String operation, Boolean[] expectedValues) {
        DecisionVariableDeclaration unDefVar = new DecisionVariableDeclaration("unDefVar", BooleanType.TYPE, project);
        project.add(unDefVar);
        Configuration config = new Configuration(project);
        EvaluationVisitor evaluator = new EvaluationVisitor(config, null, false, null);
        
        Variable nullVar = new Variable(unDefVar);
        ConstantValue constFalseVal = new ConstantValue(BooleanValue.FALSE);
        ConstantValue constTrueVal = new ConstantValue(BooleanValue.TRUE);
        
        // All nine possible constraints
        assertSpecialOperation(nullVar, operation, constFalseVal, expectedValues[0], evaluator);
        assertSpecialOperation(nullVar, operation, constTrueVal, expectedValues[1], evaluator);
        assertSpecialOperation(nullVar, operation, nullVar, expectedValues[2], evaluator);
        assertSpecialOperation(constFalseVal, operation, constFalseVal, expectedValues[3], evaluator);
        assertSpecialOperation(constFalseVal, operation, constTrueVal, expectedValues[4], evaluator);
        assertSpecialOperation(constFalseVal, operation, nullVar, expectedValues[5], evaluator);
        assertSpecialOperation(constTrueVal, operation, constFalseVal, expectedValues[6], evaluator);
        assertSpecialOperation(constTrueVal, operation, constTrueVal, expectedValues[7], evaluator);
        assertSpecialOperation(constTrueVal, operation, nullVar, expectedValues[8], evaluator);
    }
    
    /**
     * Tests one binary boolean operation.
     * @param operand A variable with no value or a {@link BooleanValue}.
     * @param operation One of {@link OclKeyWords#AND} or {@link OclKeyWords#OR}.
     * @param parameter A variable with no value or a {@link BooleanValue}.
     * @param expectedResult <tt>null</tt> if expected that the {@link EvaluationVisitor} is not able to resolve the
     *     specific operations.
     * @param evaluator The {@link EvaluationVisitor} instance which is already prepared for testing.
     * @see #testSpecialBooleanOperartions()
     * @see #assertSpecialOperation(ConstraintSyntaxTree, String, ConstraintSyntaxTree, Boolean, EvaluationVisitor)
     */
    private void assertSpecialOperation(ConstraintSyntaxTree operand, String operation,
        ConstraintSyntaxTree parameter, Boolean expectedResult, EvaluationVisitor evaluator) {
        
        try {
            OCLFeatureCall op = new OCLFeatureCall(operand, operation, parameter);
            op.inferDatatype();
            op.accept(evaluator);
            if (null != expectedResult) {
                Assert.assertEquals(expectedResult, evaluator.constraintFulfilled());
                Assert.assertEquals(!expectedResult, evaluator.constraintFailed());
                Assert.assertFalse(evaluator.constraintUndefined());
                Value result = evaluator.getResult();
                Assert.assertNotNull(result);
                Assert.assertEquals(BooleanValue.toBooleanValue(expectedResult), result);
            } else {
                Assert.assertFalse(evaluator.constraintFulfilled());
                Assert.assertTrue(evaluator.constraintUndefined());
                Value result = evaluator.getResult();
                Assert.assertNull(result);
            }
            evaluator.clearResult();
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
    }
    
    /**
     * Tests assignment and equality of constaints.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testSpecialConstraintOperations() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        Project project = new Project("Test");

        DecisionVariableDeclaration cDecl = new DecisionVariableDeclaration("c", ConstraintType.TYPE, project);
        project.add(cDecl);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("x", IntegerType.TYPE, project);
        project.add(decl);

        ConstantValue c0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));

        ConstraintSyntaxTree cst1 = new OCLFeatureCall(
            new Variable(decl), IntegerType.LESS_EQUALS_INTEGER_INTEGER.getName(), c0);
        cst1.inferDatatype();
        ConstraintSyntaxTree cst2 = new OCLFeatureCall(
            new Variable(decl), IntegerType.GREATER_EQUALS_INTEGER_INTEGER.getName(), c0);
        cst2.inferDatatype();
        
        Configuration config = new Configuration(project);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        
        ConstraintSyntaxTree equals = new OCLFeatureCall(new Variable(cDecl), 
            ConstraintType.EQUALS.getName(), cst1);
        equals.inferDatatype();
        
        visitor.visit(equals);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        IDecisionVariable var = config.getDecision(cDecl);
        Assert.assertNotNull(var);
        Value val = var.getValue();
        Assert.assertTrue(val instanceof ConstraintValue);
        Assert.assertEquals(cst1, ((ConstraintValue) val).getValue());
        visitor.clearResult();

        ConstraintSyntaxTree nEquals = new OCLFeatureCall(new Variable(cDecl), 
            ConstraintType.UNEQUALS.getName(), cst2);
        nEquals.inferDatatype();
        visitor.visit(nEquals);
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        visitor.clearResult();

        ConstraintSyntaxTree assign = new OCLFeatureCall(new Variable(cDecl), 
            ConstraintType.ASSIGNMENT.getName(), cst2);
        assign.inferDatatype();
        visitor.visit(assign);
        val = var.getValue();
        Assert.assertTrue(val instanceof ConstraintValue);
        Assert.assertEquals(cst2, ((ConstraintValue) val).getValue());
        visitor.clearResult();
    }

    /**
     * Tests references among collections (from QualiMaster).
     * <pre>
     *   Compound Pipeline {};
     *   Pipeline pipeline = {];
     *   sequenceOf(refTo(Pipeline)) pipelines = {refBy(pipeline)};
     *   sequenceOf(refTo(Pipeline)) activePipelines;
     *   activePipelines = {pipelines[0]};
     * </pre>
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testReferencesAmongCollections() throws CSTSemanticException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        Project project = new Project("Test");

        Compound cPipeline = new Compound("Pipeline", project);
        project.add(cPipeline);
        Reference rPipeline = new Reference("cPipeline", cPipeline, project);
        project.add(rPipeline);
        Sequence srPipeline = new Sequence("srPipeline", rPipeline, project);
        project.add(srPipeline);
        DecisionVariableDeclaration pipeline = new DecisionVariableDeclaration("pipeline", cPipeline, project);
        project.add(pipeline);
        DecisionVariableDeclaration pipelines = new DecisionVariableDeclaration("pipelines", srPipeline, project);
        project.add(pipelines);
        DecisionVariableDeclaration activePipelines = new DecisionVariableDeclaration("activePipelines", srPipeline, 
            project);
        project.add(activePipelines);
        
        Configuration config = new Configuration(project);
        Value pipelineValue = ValueFactory.createValue(cPipeline);
        config.getDecision(pipeline).setValue(pipelineValue, AssignmentState.ASSIGNED);
        Value pipelineRefValue = ValueFactory.createValue(rPipeline, pipeline);
        Value pipelinesValue = ValueFactory.createValue(srPipeline, pipelineRefValue);
        config.getDecision(pipelines).setValue(pipelinesValue, AssignmentState.ASSIGNED);

        ConstantValue const0 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        
        ConstraintSyntaxTree ex = new OCLFeatureCall(new Variable(pipelines), Sequence.INDEX_ACCESS.getName(), const0);
        ex.inferDatatype();
        ex = new ContainerInitializer(srPipeline, new ConstraintSyntaxTree[] {ex});
        ex.inferDatatype();
        ex = new OCLFeatureCall(new Variable(activePipelines), Sequence.ASSIGNMENT.getName(), ex);
        ex.inferDatatype();

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.visit(ex);

        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        IDecisionVariable var = config.getDecision(activePipelines);
        Assert.assertNotNull(var);
        Assert.assertEquals(AssignmentState.DEFAULT, var.getState());
        Assert.assertEquals(pipelinesValue, var.getValue());
    }
    
    /**
     * Tests modification access to local variables in an user defined operation.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testCompoundAccessLocalVar() throws CSTSemanticException, ConfigurationException, 
        ValueDoesNotMatchTypeException {
        Project project = new Project("Test");
        Compound cmpType = new Compound("cmp", project);
        project.add(cmpType);
        DecisionVariableDeclaration cmpTypeDecl = new DecisionVariableDeclaration("var", IntegerType.TYPE, cmpType);
        cmpType.add(cmpTypeDecl);
        
        DecisionVariableDeclaration[] params = new DecisionVariableDeclaration[2];
        params[0] = new DecisionVariableDeclaration("p1", cmpType, null);
        params[1] = new DecisionVariableDeclaration("p2", IntegerType.TYPE, null);
        ConstraintSyntaxTree custOpEx = new OCLFeatureCall(new CompoundAccess(new Variable(params[0]), "var"), 
            IntegerType.ASSIGNMENT_INTEGER_INTEGER.getName(), new Variable(params[1]));
        custOpEx.inferDatatype();
        CustomOperation cOp = new CustomOperation(BooleanType.TYPE, "test", project.getType(), custOpEx, params);
        OperationDefinition opDef = new OperationDefinition(project);
        opDef.setOperation(cOp);
        project.add(opDef);

        DecisionVariableDeclaration cmpVar = new DecisionVariableDeclaration("c", cmpType, project);
        project.add(cmpVar);

        ConstraintSyntaxTree cEx = new OCLFeatureCall(new Variable(cmpVar), "test", project, 
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 10)));
        cEx.inferDatatype();
        
        Configuration config = new Configuration(project);
        config.getDecision(cmpVar).setValue(ValueFactory.createValue(cmpType, (Object[]) null), 
            AssignmentState.ASSIGNED);
        
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.visit(cEx);
        
        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        IDecisionVariable var = config.getDecision(cmpVar);
        Assert.assertNotNull(var);
        Assert.assertTrue(var instanceof CompoundVariable);
        Assert.assertEquals(AssignmentState.ASSIGNED, var.getState());
        IDecisionVariable nVar = ((CompoundVariable) var).getNestedVariable("var");
        Value val = nVar.getValue();
        Assert.assertTrue(val instanceof IntValue);
        Assert.assertEquals(10, ((IntValue) val).getValue().intValue());
    }
 
    /**
     * Tests reference equality of sequences.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testReferenceEquality() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        Project prj = new Project("test");
        Compound fType = new Compound("FieldType", prj);
        DecisionVariableDeclaration fName = new DecisionVariableDeclaration("name", StringType.TYPE, fType);
        fType.add(fName);
        prj.add(fType);
        
        DecisionVariableDeclaration stringType = new DecisionVariableDeclaration("StringType", fType, prj);
        prj.add(stringType);
        DecisionVariableDeclaration integerType = new DecisionVariableDeclaration("IntegerType", fType, prj);
        prj.add(integerType);
        
        Reference refType = new Reference("", fType, null);
        Sequence seqType = new Sequence("refSeq", refType, null);
        
        DecisionVariableDeclaration seq1 = new DecisionVariableDeclaration("seq1", seqType, prj);
        prj.add(seq1);
        DecisionVariableDeclaration seq2 = new DecisionVariableDeclaration("seq2", seqType, prj);
        prj.add(seq2);
        
        ConstraintSyntaxTree cst = new OCLFeatureCall(new Variable(seq1), "==", new Variable(seq2));
        cst.inferDatatype();

        ConstraintSyntaxTree cst2 = new OCLFeatureCall(new Variable(seq1), "==", new Variable(seq1));
        cst2.inferDatatype();

        Configuration config = new Configuration(prj);
        config.getDecision(stringType).setValue(ValueFactory.createValue(fType, 
            new Object[] {"name", "String"}), AssignmentState.ASSIGNED);
        config.getDecision(integerType).setValue(ValueFactory.createValue(fType, 
            new Object[] {"name", "Integer"}), AssignmentState.ASSIGNED);
        config.getDecision(seq1).setValue(ValueFactory.createValue(seqType, 
            new Object[] {stringType, integerType}), AssignmentState.ASSIGNED);
        config.getDecision(seq2).setValue(ValueFactory.createValue(seqType, 
            new Object[] {integerType, stringType}), AssignmentState.ASSIGNED);

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.visit(cst);

        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(false, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        visitor.clearResult();
        visitor.visit(cst2);

        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        visitor.clear();
    }

}