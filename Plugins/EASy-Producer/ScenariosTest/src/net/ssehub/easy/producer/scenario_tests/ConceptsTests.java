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
package net.ssehub.easy.producer.scenario_tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Tests variability modeling concepts and reasoning.
 * 
 * @author Holger Eichelberger
 */
public class ConceptsTests extends AbstractScenarioTest {

    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "concepts");
    }
    
    /**
     * Sets the IVML location on startup.
     * 
     * @throws ModelManagementException shall not occur, leads to failure
     */
    @Before
    public void startup() throws ModelManagementException {
        VarModel.INSTANCE.locations().addLocation(getIvmlFolder(), ProgressObserver.NO_OBSERVER);        
    }

    /**
     * Unsets the IVML location on startup.
     * 
     * @throws ModelManagementException shall not occur, leads to failure
     */
    @After
    public void end() throws ModelManagementException {
        VarModel.INSTANCE.locations().removeLocation(getIvmlFolder(), ProgressObserver.NO_OBSERVER);
    }
    
    /**
     * Returns the IVML folder within {@link #getTestFolder()}.
     * 
     * @return the IVML folder
     */
    private File getIvmlFolder() {
        return getIvmlFolderIn(getTestFolder());
    }

    /**
     * Tests a simple version of a mandatory variability with a single default variable.
     */
    @Test
    public void testMandatory1() {
        doConceptTest("Mandatory1", createDefaultMandatoryExpected());
    }

    /**
     * Tests a simple version of a mandatory variability with a single default variable and constraint.
     */
    @Test
    public void testMandatory2() {
        doConceptTest("Mandatory2", createDefaultMandatoryExpected());
    }
    
    /**
     * Tests a simple version of a mandatory variability with a single default variable and constraint in a typedef.
     */
    @Test
    public void testMandatory2t() {
        doConceptTest("Mandatory2t", createDefaultMandatoryExpected());
    }

    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and constraint.
     */
    @Test
    public void testMandatory3() {
        doConceptTest("Mandatory3", createDefaultMandatoryExpected());
    }
    
    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and constraint in a typedef.
     */
    @Test
    public void testMandatory3t() {
        doConceptTest("Mandatory3t", createDefaultMandatoryExpected());
    }

    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and constraint with 
     * staged assignment.
     */
    @Test
    public void testMandatory3s() {
        doConceptTest("Mandatory3s", createDefaultMandatoryExpected());
    }

    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and constraint in typedef 
     * with staged assignment.
     */
    @Test
    public void testMandatory3st() {
        doConceptTest("Mandatory3st", createDefaultMandatoryExpected());
    }
    
    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and (reversed) constraint.
     */
    @Test
    public void testMandatory4() {
        doConceptTest("Mandatory4", createDefaultMandatoryExpected());
    }

    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and (reversed) constraint 
     * with staged assignment.
     */
    @Test
    public void testMandatory4s() {
        doConceptTest("Mandatory4s", createDefaultMandatoryExpected());
    }
    
    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and two constraints.
     */
    @Test
    public void testMandatory5() {
        doConceptTest("Mandatory5", createDefaultMandatoryExpected());
    }

    /**
     * Tests a simple version of a mandatory variability with a single non-default variable and two constraints in 
     * reverted order (compared to Mandatory5).
     */
    @Test
    public void testMandatory6() {
        doConceptTest("Mandatory6", createDefaultMandatoryExpected());
    }

    /**
     * Creates the default result for mandatory tests (var = true).
     * 
     * @return the default result
     */
    private Map<String, Object> createDefaultMandatoryExpected() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("var", Boolean.TRUE);
        return result;
    }

    /**
     * Performs a concept test with reasoning (must be valid and not conflicting).
     * 
     * @param modelName the name of the model to test
     * @param expected the expected values
     */
    private void doConceptTest(String modelName, Map<String, Object> expected) {
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setFreshConfiguration(false); // let pass through changes of reasoner
        net.ssehub.easy.varModel.model.Project ivmlModel = obtainIvmlModel(modelName, null, getIvmlFolder());
        Configuration config = new Configuration(ivmlModel);
        ReasonerFrontend rf = ReasonerFrontend.getInstance();
        if (0 == rf.getReasonersCount()) {
            rf.getRegistry().register(new net.ssehub.easy.reasoning.sseReasoner.Reasoner());
        }
        ReasoningResult res = rf.propagate(ivmlModel, config, rCfg, ProgressObserver.NO_OBSERVER);
        Assert.assertFalse("The configuration for " + modelName + " shall be free of conflicts", res.hasConflict());
        if (null != expected) {
            try {
                for (Map.Entry<String, Object> ex : expected.entrySet()) {
                    String varName = ex.getKey();
                    AbstractVariable varDecl = ModelQuery.findVariable(ivmlModel, varName, null);
                    Assert.assertNotNull("Expected variable " + varName + " is not declared", varDecl);
                    IDecisionVariable var = config.getDecision(varDecl);
                    Assert.assertNotNull("Expected variable " + varName + " is does not exist in configuaration", var);
                    Value value = var.getValue();
                    Assert.assertNotNull("Expected variable " + varName + " is not configured", value);
                    Assert.assertEquals("Expected value for variable " + varName + " does not match", 
                        ex.getValue(), value.getValue());
                }
            } catch (ModelQueryException e) {
                Assert.fail("Unexpected query exception: " + e.getMessage());
            }
        }
    }

}
