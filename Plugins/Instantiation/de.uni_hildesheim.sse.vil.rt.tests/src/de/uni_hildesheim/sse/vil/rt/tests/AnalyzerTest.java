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
package de.uni_hildesheim.sse.vil.rt.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.AbstractAnalyzerVisitor;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Tests the {@link AbstractAnalyzerVisitor}.
 * 
 * @author Holger Eichelberger
 */
public class AnalyzerTest extends AbstractRtTest {
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        registerReasoner();
    }
    
    /**
     * Characterizes a violation.
     * 
     * @author Holger Eichelberger
     */
    private static class Violation {
        private IDecisionVariable var;
        private String operation;
        private Double deviation;
        private Double deviationPercentage;
        
        /**
         * Creates a violation object.
         * 
         * @param var the variable
         * @param operation the operation name (may be <b>null</b>)
         * @param deviation the deviation (may be <b>null</b>)
         * @param deviationPercentage the deviation as percentage (may be <b>null</b>, may be NaN)
         */
        private Violation(IDecisionVariable var, String operation, Double deviation, Double deviationPercentage) {
            this.var = var;
            this.operation = operation;
            this.deviation = deviation;
            this.deviationPercentage = deviationPercentage;
        }
        
        /**
         * Returns the failing variable.
         * 
         * @return the failing variable
         */
        public IDecisionVariable getVariable() {
            return var;
        }
        
        /**
         * Returns the failing operation name.
         * 
         * @return the operation name (may be <b>null</b>)
         */
        public String getOperation() {
            return operation;
        }
        
        /**
         * Returns the deviation.
         * 
         * @return the deviation (may be <b>null</b>)
         */
        public Double getDeviation() {
            return deviation;
        }
        
        /**
         * Returns the deviation percentage.
         * 
         * @return the deviation percentage (may be <b>null</b>, may be NaN)
         */
        public Double getDeviationPercentage() {
            return deviationPercentage;
        }
        
    }
    
    /**
     * Implements a simple analyzer visitor.
     * 
     * @author Holger Eichelberger
     */
    private class AnalyzerVisitor extends AbstractAnalyzerVisitor<Violation> {

        @Override
        protected boolean isRelevantVariable(IDecisionVariable var) {
            return var.getDeclaration().getName().startsWith("mon");
        }

        @Override
        protected Violation createViolationInstance(IDecisionVariable var, String operation, Double deviation,
            Double deviationPercentage) {
            return new Violation(var, operation, deviation, deviationPercentage);
        }
        
    }
    
    /**
     * Tests a simple failing greater comparison.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void testGreaterEqualsComparison() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        testSimpleComparison(new ClauseData(">=", 0.5, 0.3), -1, 0.2);
    }

    /**
     * Tests a simple failing greater comparison.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void testSmallerEqualsComparison() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        testSimpleComparison(new ClauseData("<=", 0.5, 1.3), 1, -0.8);
    }

    /**
     * Tests a simple failing comparison. We distinguish here between a relevant variable that shall be reported
     * by the analysis and an irrelevant variable (with fixed clause, just varying value) that shall be ignored. 
     * 
     * @param clause the clause data  for the relevant variable
     * @param value2 the actual value of the irrelevant variable
     * @param deviation the expected deviation of the actual variable due to 
     *     <code>clause.operation</code> and <code>clause.limit</code>
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    private void testSimpleComparison(ClauseData clause, int value2, double deviation) 
        throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setRuntimeMode(true);

        Project prj = new Project("test");

        // relevantVariable with constraint: monVar >= 0.5
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("monVar", RealType.TYPE, prj);
        prj.add(decl1);
        ConstraintSyntaxTree cst1 = new OCLFeatureCall(new Variable(decl1), clause.operation, new ConstantValue(
             ValueFactory.createValue(RealType.TYPE, clause.limit)));
        cst1.inferDatatype();
        prj.add(new Constraint(cst1, prj));

        // irrelevantVariable with constraint: counter >= 0
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("counter", IntegerType.TYPE, prj);
        prj.add(decl2);
        ConstraintSyntaxTree cst2 = new OCLFeatureCall(new Variable(decl2), ">=", new ConstantValue(
             ValueFactory.createValue(IntegerType.TYPE, 0)));
        cst2.inferDatatype();
        prj.add(new Constraint(cst2, prj));

        Configuration cfg = new Configuration(prj);
        cfg.getDecision(decl1).setValue(ValueFactory.createValue(RealType.TYPE, clause.value), 
             AssignmentState.ASSIGNED);
        cfg.getDecision(decl2).setValue(ValueFactory.createValue(IntegerType.TYPE, value2), AssignmentState.ASSIGNED);

        ReasoningResult rResult = ReasonerFrontend.getInstance().check(prj, cfg, rCfg, ProgressObserver.NO_OBSERVER);
        Assert.assertNotNull(rResult);
        Assert.assertTrue(rResult.hasConflict());
        
        AnalyzerVisitor analyzer = new AnalyzerVisitor();
        List<Violation> violations = analyzer.analyze(cfg, rResult);
        analyzer.clear();
        
        Assert.assertNotNull(violations);
        Assert.assertEquals(1, violations.size()); // we expect one violation, for the relevant variable
        Violation violation = violations.get(0);
        
        Assert.assertEquals(cfg.getDecision(decl1), violation.getVariable());
        Assert.assertEquals(clause.operation, violation.getOperation());
        Assert.assertEquals(deviation, violation.getDeviation(), 0.05);
        Assert.assertNotNull(violation.getDeviationPercentage());
        Assert.assertNotNull(Math.abs(violation.getDeviationPercentage()) >= 0.00005);
    }
    
    /**
     * Represents information about a clause, currently basic operations / comparisons only.
     * 
     * @author Holger Eichelberger
     */
    private class ClauseData {
        private String operation;
        private double limit;
        private double value;
        
        /**
         * Creates a clause information instance.
         * 
         * @param operation the operation to use
         * @param limit the limiting value in the clause
         * @param value the actual value of the variable
         */
        private ClauseData(String operation, double limit, double value) {
            this.operation = operation;
            this.limit = limit;
            this.value = value;
        }
        
    }
    
    /**
     * Tests a implication with a comparison on both sides (no deviation as the left side does not hold).
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void testImplicationNoDeviation1() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        // monVarLeft >= 2 => monVarRight >= 0.3, monVarLeft = 1 -> no deviation
        testSimpleImplication(new ClauseData(">=", 2, 1), new ClauseData(">=", 0.3, 0.1), null);
    }
    
    /**
     * Tests a implication with a comparison on both sides (no deviation as the right side holds).
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void testImplicationNoDeviation2() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        // monVarLeft >= 2 => monVarRight >= 0.3, monVarLeft = 2, monVarRight = 0.4 -> no deviation
        testSimpleImplication(new ClauseData(">=", 2, 1), new ClauseData(">=", 0.3, 0.4), null);
    }

    /**
     * Tests a implication with a comparison on both sides (with deviation).
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void testImplicationWithDeviation() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        // monVarLeft >= 2 => monVarRight >= 0.3, monVarLeft = 2, monVarRight = 0.2 -> 0.1
        testSimpleImplication(new ClauseData(">=", 2, 2), new ClauseData(">=", 0.3, 0.2), 0.1);
    }

    /**
     * Tests a simple failing implication, left => right.
     * 
     * @param left the left clause data
     * @param right the right clause data
     * @param deviation the expected deviation of the actual variable due to <code>right.operation</code> and 
     *    <code>right.limit</code>, may be <b>null</b> if no deviation is expected 
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    private void testSimpleImplication(ClauseData left, ClauseData right, Double deviation) 
        throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setRuntimeMode(true);

        Project prj = new Project("test");

        // relevantVariables
        DecisionVariableDeclaration declLeft = new DecisionVariableDeclaration("monVarLeft", RealType.TYPE, prj);
        prj.add(declLeft);
        DecisionVariableDeclaration declRight = new DecisionVariableDeclaration("monVarRight", RealType.TYPE, prj);
        prj.add(declRight);
        
        OCLFeatureCall cstLeft = new OCLFeatureCall(new Variable(declLeft), left.operation, new ConstantValue(
             ValueFactory.createValue(RealType.TYPE, left.limit)));
        cstLeft.inferDatatype();
        OCLFeatureCall cstRight = new OCLFeatureCall(new Variable(declRight), right.operation, new ConstantValue(
            ValueFactory.createValue(RealType.TYPE, right.limit)));
        cstRight.inferDatatype();
        ConstraintSyntaxTree cst = new OCLFeatureCall(cstLeft, "implies", cstRight);
        cst.inferDatatype();
        
        prj.add(new Constraint(cst, prj));

        Configuration cfg = new Configuration(prj);
        cfg.getDecision(declLeft).setValue(ValueFactory.createValue(RealType.TYPE, left.value), 
            AssignmentState.ASSIGNED);
        cfg.getDecision(declRight).setValue(ValueFactory.createValue(RealType.TYPE, right.value), 
            AssignmentState.ASSIGNED);

        ReasoningResult rResult = ReasonerFrontend.getInstance().check(prj, cfg, rCfg, ProgressObserver.NO_OBSERVER);
        Assert.assertNotNull(rResult);
        Assert.assertEquals(deviation != null, rResult.hasConflict());
        
        AnalyzerVisitor analyzer = new AnalyzerVisitor();
        List<Violation> violations = analyzer.analyze(cfg, rResult);
        analyzer.clear();
        
        if (null != deviation) { // we expect one violation, for the relevant variable
            Assert.assertNotNull(violations);
            Assert.assertEquals(1, violations.size()); 
            Violation violation = violations.get(0);
            
            Assert.assertEquals(cfg.getDecision(declRight), violation.getVariable());
            Assert.assertEquals(right.operation, violation.getOperation());
            Assert.assertEquals(deviation, violation.getDeviation(), 0.05);
            Assert.assertNotNull(violation.getDeviationPercentage());
            Assert.assertNotNull(Math.abs(violation.getDeviationPercentage()) >= 0.00005);            
        } else { // no violation expected
            Assert.assertTrue(null == violations || 1 == violations.size());    
        }
    }
    
}
