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

import org.junit.Test;

import org.junit.Assert;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Tests the copy operation.
 * 
 * @author Holger Eichelberger
 */
public class CopyOperationTest {

    private static final String NO_PREFIX = "*noPrefix*";

    private TestSpec[] specs = new TestSpec[] {
        new BooleanVarSpec(), 
        new IntegerVarSpec(), 
        new RealVarSpec(), 
        new StringVarSpec(), 
        new ContainerVarSpec(), 
        new CompoundVarSpec(),
        new ReferenceVarSpec(), 
        new ReferenceCollectionVarSpec()};
    
    /**
     * Generic test specification for a variable. Lazy initialization!
     * 
     * @author Holger Eichelberger
     */
    private abstract static class TestSpec {
        
        protected DecisionVariableDeclaration decl1;
        protected DecisionVariableDeclaration decl2;
        protected ConstraintSyntaxTree cst;
        
        /**
         * Creates a decision variable and hooks it into {@code project} [helper].
         * 
         * @param name the name of the variable
         * @param type the type of the variable
         * @param project the project to hook into
         * @return the created variable
         */
        protected DecisionVariableDeclaration createVar(String name, IDatatype type, Project project) {
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, type, project);
            project.add(decl);
            return decl;
        }
        
        /**
         * Creates the variables required for this test and stores them within this instance.
         * 
         * @param project the project to create the variables for
         */
        abstract void createVariables(Project project);
        
        /**
         * Creates the copy assignment constraint depending on the given prefix name. 
         * {@link CopyOperationTest#NO_PREFIX} indicates that the specific operation without prefix shall be used.
         * The constraint shall be stored within this instance.
         * 
         * @param project the project to create the constraint for
         * @param prefix the variable name prefix
         * @throws CSTSemanticException in case that constraint syntax is wrong
         * @throws ValueDoesNotMatchTypeException in case that values do not match
         */
        void createConstraint(Project project, String prefix) throws CSTSemanticException, 
            ValueDoesNotMatchTypeException {
            ConstraintSyntaxTree copy;
            if (NO_PREFIX.equals(prefix)) {
                copy = new OCLFeatureCall(new Variable(decl1), OclKeyWords.COPY);
            } else {
                copy = new OCLFeatureCall(new Variable(decl1), OclKeyWords.COPY, 
                    new ConstantValue(ValueFactory.createValue(StringType.TYPE, prefix)));
                
            }
            cst = new OCLFeatureCall(new Variable(decl2), OclKeyWords.ASSIGNMENT, copy);
            cst.inferDatatype();
            Constraint cstr = new Constraint(cst, project);
            project.add(cstr);
        }
        
        /**
         * Initializes the variables created in {@link #createVariables(Project)} within the given{@code config}.
         * 
         * @param config the configuration
         * @throws ConfigurationException in case that configuration operations fail
         * @throws ValueDoesNotMatchTypeException in case that values do not match
         */
        abstract void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException;

        /**
         * Returns the expression created by {@link #createConstraint(Project, String)}.
         * 
         * @return the expression
         */
        ConstraintSyntaxTree getExpression() {
            return cst;
        }

        /**
         * Asserts the values of {@link #decl1} and {@link #decl2} by calling 
         * {@link #doAssert(IDecisionVariable, String, boolean)} for both.
         * 
         * @param config the configuration to take the configured values from
         * @param prefix the variable name prefix
         */
        void doAssert(Configuration config, String prefix) {
            Assert.assertNotNull(config.getDecision(decl1));
            doAssert(config.getDecision(decl1), prefix, true);
            Assert.assertNotNull(config.getDecision(decl2));
            doAssert(config.getDecision(decl2), prefix, false);
        }

        /**
         * Asserts the value of a single variable taken from this instance.
         * 
         * @param dec the decision variable
         * @param prefix the variable name prefix
         * @param original is this the original or the copied variable
         */
        abstract void doAssert(IDecisionVariable dec, String prefix, boolean original);

    }
    
    /**
     * Test specification for a single Boolean variable.
     * 
     * @author Holger Eichelberger
     */
    private static class BooleanVarSpec extends TestSpec {

        @Override
        void createVariables(Project project) {
            decl1 = createVar("boolDecl", BooleanType.TYPE, project);
            decl2 = createVar("boolDecl2", BooleanType.TYPE, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(decl1);
            dec.setValue(ValueFactory.createValue(BooleanType.TYPE, true), AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof BooleanValue);
            Assert.assertEquals(true, ((BooleanValue) dec.getValue()).getValue());
        }

    }

    /**
     * Test specification for a single Integer variable.
     * 
     * @author Holger Eichelberger
     */
    private static class IntegerVarSpec extends TestSpec {

        @Override
        void createVariables(Project project) {
            decl1 = createVar("intDecl", IntegerType.TYPE, project);
            decl2 = createVar("intDecl2", IntegerType.TYPE, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(decl1);
            dec.setValue(ValueFactory.createValue(IntegerType.TYPE, 42), AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof IntValue);
            Assert.assertEquals(42, ((IntValue) dec.getValue()).getValue().intValue());
        }

    }

    /**
     * Test specification for a single Real variable.
     * 
     * @author Holger Eichelberger
     */
    private static class RealVarSpec extends TestSpec {

        @Override
        void createVariables(Project project) {
            decl1 = createVar("realDecl", RealType.TYPE, project);
            decl2 = createVar("realDecl2", RealType.TYPE, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(decl1);
            dec.setValue(ValueFactory.createValue(RealType.TYPE, 3.421), AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof RealValue);
            Assert.assertEquals(3.421, ((RealValue) dec.getValue()).getValue().doubleValue(), 0.1);
        }

    }

    /**
     * Test specification for a single String variable.
     * 
     * @author Holger Eichelberger
     */
    private static class StringVarSpec extends TestSpec {

        @Override
        void createVariables(Project project) {
            decl1 = createVar("stringDecl", StringType.TYPE, project);
            decl2 = createVar("stringDecl2", StringType.TYPE, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(decl1);
            dec.setValue(ValueFactory.createValue(StringType.TYPE, "hello"), AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof StringValue);
            Assert.assertEquals("hello", ((StringValue) dec.getValue()).getValue());
        }

    }

    /**
     * Test specification for a simple container variable.
     * 
     * @author Holger Eichelberger
     */
    private static class ContainerVarSpec extends TestSpec {

        private Set type;
        private Value value;
        
        @Override
        void createVariables(Project project) {
            type = new Set("", IntegerType.TYPE, project);
            decl1 = createVar("cntDecl", type, project);
            decl2 = createVar("cntDecl2", type, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(decl1);
            value = ValueFactory.createValue(type, 1, 2, 3, 4, 5);
            dec.setValue(value, AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof ContainerValue);
            Assert.assertEquals(value, dec.getValue());
        }

    }

    /**
     * Test specification for a simple compound variable.
     * 
     * @author Holger Eichelberger
     */
    private static class CompoundVarSpec extends TestSpec {

        private Compound type;
        private Value value;
        
        @Override
        void createVariables(Project project) {
            type = new Compound("TestCompound", project);
            DecisionVariableDeclaration slot1 = new DecisionVariableDeclaration("slot1", IntegerType.TYPE, type);
            type.add(slot1);
            DecisionVariableDeclaration slot2 = new DecisionVariableDeclaration("slot2", StringType.TYPE, type);
            type.add(slot2);
            
            decl1 = createVar("cmpDecl", type, project);
            decl2 = createVar("cmpDecl2", type, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(decl1);
            value = ValueFactory.createValue(type, new Object[] {"slot1", 1, "slot2", "abba"});
            dec.setValue(value, AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof CompoundValue);
            Assert.assertEquals(value, dec.getValue());
        }

    }

    /**
     * Tests a single reference variable.
     * 
     * @author Holger Eichelberger
     */
    private static class ReferenceVarSpec extends TestSpec {

        private Compound cType;
        private DecisionVariableDeclaration cDecl;
        private Reference type;
        
        @Override
        void createVariables(Project project) {
            cType = new Compound("RTestCompound", project);
            DecisionVariableDeclaration slot1 = new DecisionVariableDeclaration("slot1", StringType.TYPE, type);
            cType.add(slot1);
            cDecl = createVar("cmpDeclR", cType, project);
            type = new Reference("ref", cType, project);
            decl1 = createVar("cRef1", type, project);
            decl2 = createVar("cRef2", type, project);
        }
        
        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            IDecisionVariable dec = config.getDecision(cDecl);
            dec.setValue(ValueFactory.createValue(cDecl.getType(), 
                new Object[]{"slot1", "abba"}), AssignmentState.ASSIGNED);
            dec = config.getDecision(decl1);
            dec.setValue(ValueFactory.createValue(type, cDecl), AssignmentState.ASSIGNED);
        }
        
        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof ReferenceValue);
            ReferenceValue val = (ReferenceValue) dec.getValue();
            // dereference
            AbstractVariable valVar = val.getValue();
            if (original) {
                Assert.assertEquals(cDecl, valVar);
            } else { // the copy
                if (VariableValueCopier.doCreateNewVars(prefix)) {
                    // a different variable was created
                    Assert.assertNotEquals(cDecl, valVar);
                    Assert.assertFalse(cDecl.getName().startsWith(prefix));
                    // and has a prefix
                    Assert.assertTrue(valVar.getName().startsWith(prefix));
                    // and a value
                    IDecisionVariable valVarDec = dec.getConfiguration().getDecision(valVar);
                    Assert.assertNotNull(valVarDec);
                    Assert.assertNotNull(valVarDec.getValue());
                    // and the values are also equal
                    Assert.assertEquals(dec.getConfiguration().getDecision(cDecl).getValue(), valVarDec.getValue());
                } else {
                    Assert.assertEquals(cDecl, valVar);
                }
            }
        }
        
    }

    /**
     * Tests a collection of reference variables.
     * 
     * @author Holger Eichelberger
     */
    private static class ReferenceCollectionVarSpec extends TestSpec {

        private Compound aType;
        private IDatatype aSetType;
        private DecisionVariableDeclaration alg1;
        private DecisionVariableDeclaration alg2;
        private ContainerValue value;

        @Override
        void createVariables(Project project) {
            aType = new Compound("Algorithm", project);
            project.add(aType);
            aSetType = new Set("", new Reference("", aType, project), project);
            
            alg1 = createVar("alg1", aType, project);
            alg2 = createVar("alg2", aType, project);
            decl1 = createVar("avail1", aSetType, project);
            decl2 = createVar("avail2", aSetType, project);
        }

        @Override
        void initialize(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException {
            config.getDecision(alg1).setValue(
                ValueFactory.createValue(aType, ValueFactory.EMPTY), AssignmentState.ASSIGNED);
            config.getDecision(alg2).setValue(
                ValueFactory.createValue(aType, ValueFactory.EMPTY), AssignmentState.ASSIGNED);
            value = (ContainerValue) ValueFactory.createValue(aSetType, new Object[] {alg1, alg2});
            config.getDecision(decl1).setValue(value, AssignmentState.ASSIGNED);
        }

        @Override
        void doAssert(IDecisionVariable dec, String prefix, boolean original) {
            Assert.assertTrue(dec.getValue() instanceof ContainerValue);
            if (!original && VariableValueCopier.doCreateNewVars(prefix)) {
                ContainerValue cVal = (ContainerValue) dec.getValue();
                Assert.assertEquals(value.getElementSize(), cVal.getElementSize());
                for (int s = 0; s < value.getElementSize(); s++) {
                    Value v1 = value.getElement(s);
                    Value v2 = cVal.getElement(s);
                    Assert.assertTrue(v1 instanceof ReferenceValue);
                    Assert.assertTrue(v2 instanceof ReferenceValue);
                    AbstractVariable var1 = ((ReferenceValue) v1).getValue();
                    AbstractVariable var2 = ((ReferenceValue) v2).getValue();
                    // a different variable was created
                    Assert.assertNotEquals(var1, var2);
                    Assert.assertFalse(var1.getName().startsWith(prefix));
                    // and has a prefix
                    Assert.assertTrue(var2.getName().startsWith(prefix));
                    // and a value
                    IDecisionVariable var1Dec = dec.getConfiguration().getDecision(var1);
                    Assert.assertNotNull(var1Dec);
                    Assert.assertNotNull(var1Dec.getValue());
                    IDecisionVariable var2Dec = dec.getConfiguration().getDecision(var2);
                    Assert.assertNotNull(var2Dec);
                    Assert.assertNotNull(var2Dec.getValue());
                    // and the values are also equal
                    Assert.assertEquals(var1Dec.getValue(), var2Dec.getValue());
                }
            } else {
                Assert.assertEquals(value, dec.getValue());
            }
        }
    }
    
    // move runtime variable binding here as variable binding
    // reference collection
    
    /**
     * Tests the copy operation.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ConfigurationException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public void testCopyOperation() throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        //testCopyOperation(NO_PREFIX); // TODO implement, operation not available
        testCopyOperation("");
        testCopyOperation("TMP_");
    }

    /**
     * Tests the copy operation.
     * 
     * @param prefix the prefix to use, {@link #NO_PREFIX} for operation without second argument
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ConfigurationException shall not occur
     * @throws CSTSemanticException shall not occur
     */
    private void testCopyOperation(String prefix) throws ValueDoesNotMatchTypeException, ConfigurationException, 
        CSTSemanticException {
        System.out.println("Testing with prefix '" + prefix + "'");
        Project project = new Project("Test");
        
        // set up all declarations
        
        for (TestSpec spec : specs) {
            spec.createVariables(project);
            spec.createConstraint(project, prefix);
        }
        // set up the configuration - no reasoner running, perform explicit initialization

        Configuration config = new Configuration(project);
        for (TestSpec spec : specs) {
            spec.initialize(config);
        }
        // set up evaluation visitor and evaluate all expressions

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        for (TestSpec spec : specs) {
            System.out.println("Evaluating " + StringProvider.toIvmlString(spec.getExpression()));
            visitor.setAssignmentState(AssignmentState.DEFAULT);
            spec.getExpression().accept(visitor);
            for (int m = 0; m < visitor.getMessageCount(); m++) {
                EvaluationVisitor.Message msg = visitor.getMessage(m);
                System.out.println(" MSG: " + msg.getDescription() + " " + msg.getVariable() + " " 
                     + msg.getDecision());
            }
            Assert.assertTrue("Constraint " + StringProvider.toIvmlString(spec.getExpression()) + " not fulfilled!" , 
                visitor.constraintFulfilled());
            visitor.clearIntermediary();
        }
        visitor.clear();

        // assert all results

        for (TestSpec spec : specs) {
            spec.doAssert(config, prefix);
        }
    }
    
}
