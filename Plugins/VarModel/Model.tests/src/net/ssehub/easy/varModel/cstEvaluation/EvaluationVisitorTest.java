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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

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
     *     See {@link ValueFactory#createValue(net.ssehub.easy.varModel.model.datatypes.IDatatype, Object...)}
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
            void valueChanged(IDecisionVariable variable, Value oldValue) {
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
        assertEvaluationVisitor(equalsOperation, config, "At", Result.UNDEFINED);
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
        assertEvaluationVisitor(equalsOperation, config, "Size", Result.UNDEFINED);
    }

    /**
     * Result status.
     * 
     * @author Holger Eichelberger
     */
    private enum Result {
        SUCCESS,
        UNDEFINED,
        FAIL,
        ERROR
    }

    /**
     * Tests the correct behavior of the {@link EvaluationVisitor}, while working with sequences, which are set to
     * {@link NullValue}.
     * @param cst A sequence operation which shall be visited by the {@link EvaluationVisitor}.
     * @param config The configuration of a project containing the <tt>cst</tt> constraint.
     * @param operation The name of the operation for creating sufficient error messages if the assertion fails.
     * @param expected the expected status
     */
    private void assertEvaluationVisitor(ConstraintSyntaxTree cst, Configuration config, String operation, 
        Result expected) {
        EvaluationVisitor visitor = new EvaluationVisitor();
        
        visitor.init(config, AssignmentState.ASSIGNED, false, null);
        try {
            cst.accept(visitor);
        } catch (NullPointerException npe) {
            Assert.fail(operation + "-operation causes a NullPointerException on NullValues for a sequence variable.");
            npe.printStackTrace();
        }
        if (Result.SUCCESS == expected) {
            Assert.assertTrue(visitor.constraintFulfilled());
            Assert.assertFalse(visitor.constraintFailed());
            Assert.assertFalse(visitor.constraintUndefined());
        } else if (Result.UNDEFINED == expected) {
            Assert.assertFalse(visitor.constraintFulfilled());
            Assert.assertFalse(visitor.constraintFailed());
            Assert.assertTrue(visitor.constraintUndefined());
        } else if (Result.FAIL == expected) {
            Assert.assertFalse(visitor.constraintFulfilled());
            Assert.assertTrue(visitor.constraintFailed());
            Assert.assertFalse(visitor.constraintUndefined());
        } else if (Result.ERROR == expected) {
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
            void valueChanged(IDecisionVariable variable, Value oldValue) {
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

    /**
     * Tests the multi-and expression.
     * 
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     * @throws ValueDoesNotMatchTypeException if a value does not match the expected type (shall not occur)
     * @throws ConfigurationException if a value cannot be configured (shall not occur)
     */
    @Test
    public void testMultiAnd() throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {
        Project prj = new Project("test");
        DecisionVariableDeclaration var1 = new DecisionVariableDeclaration("var1", IntegerType.TYPE, prj);
        var1.setValue(ValueFactory.createValue(IntegerType.TYPE, 1));
        prj.add(var1);
        DecisionVariableDeclaration var2 = new DecisionVariableDeclaration("var2", IntegerType.TYPE, prj);
        var2.setValue(ValueFactory.createValue(IntegerType.TYPE, 2));
        prj.add(var2);
        DecisionVariableDeclaration var3 = new DecisionVariableDeclaration("var3", IntegerType.TYPE, prj);
        var3.setValue(ValueFactory.createValue(IntegerType.TYPE, 3));
        prj.add(var3);

        OCLFeatureCall call1 = new OCLFeatureCall(new Variable(var1), OclKeyWords.LESS, new Variable(var2));
        call1.inferDatatype();
        OCLFeatureCall call2 = new OCLFeatureCall(new Variable(var2), OclKeyWords.LESS, new Variable(var3));
        call1.inferDatatype();
        MultiAndExpression maEx = new MultiAndExpression(call1, call2);
        maEx.inferDatatype();

        Configuration config = new Configuration(prj);
        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        visitor.visit(maEx);

        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(true, ((BooleanValue) visitor.getResult()).getValue().booleanValue());
        
        config.getDecision(var2).setValue(ValueFactory.createValue(IntegerType.TYPE, 5), AssignmentState.ASSIGNED);
        visitor.visit(maEx);

        Assert.assertTrue(visitor.getResult() instanceof BooleanValue);
        Assert.assertEquals(false, ((BooleanValue) visitor.getResult()).getValue().booleanValue());

        visitor.clearResult();
    }

}