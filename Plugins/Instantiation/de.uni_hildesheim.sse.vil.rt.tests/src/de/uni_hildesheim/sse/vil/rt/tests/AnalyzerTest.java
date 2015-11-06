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
import org.junit.Ignore;
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
        
        /**
         * Creates a violation object.
         * 
         * @param var the variable
         * @param operation the operation name (may be <b>null</b>)
         * @param deviation the deviation (may be <b>null</b>)
         */
        private Violation(IDecisionVariable var, String operation, Double deviation) {
            this.var = var;
            this.operation = operation;
            this.deviation = deviation;
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
        
    }
    
    /**
     * Implements a simple analyzer visitor.
     * 
     * @author Holger Eichelberger
     */
    private class AnalyzerVisitor extends AbstractAnalyzerVisitor<Violation> {

        @Override
        protected Violation createViolationInstance(IDecisionVariable var, String operation, Double deviation) {
            return new Violation(var, operation, deviation);
        }

        @Override
        protected boolean isRelevantVariable(IDecisionVariable var) {
            return var.getDeclaration().getName().startsWith("mon");
        }
        
    }
    
    /**
     * Tests a simple failing greater comparison.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Ignore("Jenkins")
    @Test
    public void testGreaterEqualsComparison() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        testSimpleComparison(">=", 0.5, 0.3, -1, 0.2);
    }

    /**
     * Tests a simple failing greater comparison.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Ignore("Jenkins")
    @Test
    public void testSmallerEqualsComparison() throws ValueDoesNotMatchTypeException, CSTSemanticException, 
        ConfigurationException {
        testSimpleComparison("<=", 0.5, 1.3, 1, -0.8);
    }

    /**
     * Tests a simple failing comparison.
     * 
     * @param operation the operation for the relevant variable
     * @param limit the limiting value to be applied with <code>operation</code>
     * @param value the actual value of the relevant variable
     * @param value2 the actual value of the irrelevant variable
     * @param deviation the expected deviation of the actual variable due to <code>operation</code> and limit
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws CSTSemanticException shall not occur
     * @throws ConfigurationException shall not occur
     */
    private void testSimpleComparison(String operation, double limit, double value, int value2, double deviation) 
        throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setRuntimeMode(true);

        Project prj = new Project("test");

        // relevantVariable with constraint: monVar >= 0.5
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("monVar", RealType.TYPE, prj);
        prj.add(decl1);
        ConstraintSyntaxTree cst1 = new OCLFeatureCall(new Variable(decl1), operation, new ConstantValue(
             ValueFactory.createValue(RealType.TYPE, limit)));
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
        cfg.getDecision(decl1).setValue(ValueFactory.createValue(RealType.TYPE, value), AssignmentState.ASSIGNED);
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
        Assert.assertEquals(operation, violation.getOperation());
        Assert.assertEquals(deviation, violation.getDeviation(), 0.05);
    }

}
