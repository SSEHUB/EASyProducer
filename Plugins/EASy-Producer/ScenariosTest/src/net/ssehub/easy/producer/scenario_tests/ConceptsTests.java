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
import java.util.HashSet;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Tests variability modeling concepts and reasoning.
 * 
 * @author Holger Eichelberger
 */
public class ConceptsTests extends AbstractEasyScenarioTest {

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
     * Tests a simple version of a multi selection over integers with a constraint.
     */
    @Test
    public void testMultiSelect1() {
        HashMap<String, Object> expected = new HashMap<String, Object>();
        HashSet<Integer> value = new HashSet<Integer>();
        value.add(1);
        value.add(2);
        value.add(3);
        expected.put("var", value);
        doConceptTest("MultiSelect1", expected);
    }

    /**
     * Tests a simple version of a failing multi selection over integers with a constraint.
     */
    @Test
    public void testMultiSelect1fail() {
        doConceptTest("MultiSelect1fail", false, null);
    }

    /**
     * Tests a simple version of relevancies (disconnecting a tree).
     * 
     * @throws ModelQueryException in case of a model query problem
     */
    @Test
    public void testRelevancy1() throws ModelQueryException {
        HashMap<String, Object> expected = new HashMap<String, Object>();
        expected.put("c.gears.number", 4);
        expected.put("c.engine", NullValue.INSTANCE);
        Configuration config = doConceptTest("Relevancy1", expected);
        IDatatype engineType = ModelQuery.findType(config.getProject(), "Engine", null);
        Assert.assertNotNull("Engine type does not exist", engineType);
        Value inst = config.getAllInstances(engineType);
        if (inst instanceof ContainerValue) {
            Assert.assertEquals("There shall be no Engine instances", 0, ((ContainerValue) inst).getElementSize());
        }
    }

    /**
     * Tests a simple version of relevancies (disconnecting a tree) via references.
     */
    @Test
    public void testRelevancy2() {
        HashMap<String, Object> expected = new HashMap<String, Object>();
        expected.put("c.gears.number", 7);
        expected.put("c.engine", null); // does not even have a value in the model
        doConceptTest("Relevancy2", expected);
    }

    /**
     * Performs a concept test with reasoning (must be valid and not conflicting).
     * 
     * @param modelName the name of the model to test
     * @param expected the expected values
     * @return the created configuration for further tests
     */
    protected Configuration doConceptTest(String modelName, Map<String, Object> expected) {
        return doConceptTest(modelName, true, expected);
    }
    
    /**
     * Performs a concept test with reasoning.
     * 
     * @param modelName the name of the model to test
     * @param success whether a success or a reasoning failure is expected (in the latter case the <code>expected</code>
     *   values are not tested)
     * @param expected the expected values (use nested variable names, {@link NullValue#INSTANCE} and null for not
     *   configured)
     * @return the created configuration for further tests
     */
    protected Configuration doConceptTest(String modelName, boolean success, Map<String, Object> expected) {
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        net.ssehub.easy.varModel.model.Project ivmlModel = obtainIvmlModel(modelName, null, getIvmlFolder());
        Configuration config = new Configuration(ivmlModel);
        ReasonerFrontend rf = ReasonerFrontend.getInstance();
        if (0 == rf.getReasonersCount()) {
            rf.getRegistry().register(new net.ssehub.easy.reasoning.sseReasoner.Reasoner());
        }
        ReasoningResult res = rf.propagate(ivmlModel, config, rCfg, ProgressObserver.NO_OBSERVER);
        if (success) { 
            Assert.assertFalse("The configuration for " + modelName + " shall be free of conflicts", res.hasConflict());
        } else {
            Assert.assertTrue("The configuration for " + modelName + " shall have conflicts", res.hasConflict());
        }
        if (success && null != expected) {
            try {
                for (Map.Entry<String, Object> ex : expected.entrySet()) {
                    String varName = ex.getKey();
                    IDecisionVariable var = config.getDecision(varName, true);
                    Assert.assertNotNull("Expected variable " + varName + " is does not exist in configuaration", var);
                    Value value = var.getValue();
                    if (null == ex.getValue()) {
                        Assert.assertEquals("Variable " + varName + " is configured rather than unconfigured", 
                            AssignmentState.UNDEFINED, var.getState());
                    } else {
                        Assert.assertNotNull("Expected variable " + varName + " is not configured", value);
                        Object valueExpected = ex.getValue();
                        Object valueActual = value.getValue();
                        if (Set.TYPE.isAssignableFrom(value.getType())) {
                            java.util.Set<Object> tmpActual = new java.util.HashSet<Object>();
                            addAll(tmpActual, value, true);
                            java.util.Set<Object> tmpExpected = new java.util.HashSet<Object>();
                            addAll(tmpExpected, ex.getValue(), true);
                            valueExpected = tmpExpected;
                            valueActual = tmpActual;
                        } else if (Sequence.TYPE.isAssignableFrom(value.getType())) {
                            java.util.List<Object> tmpActual = new java.util.ArrayList<Object>();
                            addAll(tmpActual, value, true);
                            java.util.List<Object> tmpExpected = new java.util.ArrayList<Object>();
                            addAll(tmpExpected, ex.getValue(), true);
                            valueExpected = tmpExpected;
                            valueActual = tmpActual;
                        }
                        Assert.assertEquals("Expected value for variable " + varName + " does not match", 
                            valueExpected, valueActual);
                    }
                }
            } catch (ModelQueryException e) {
                Assert.fail("unexpected exception " + e.getMessage());
            }
        }
        return config;
    }
    
    /**
     * Adds all values in <code>value</code> depending on its type into <code>result</code> (may include nested
     * structures if not <code>top</code>).
     * 
     * @param result the result to be modified as a side effect
     * @param value the value to add
     * @param top whether this is a top-level call to this method (or a recursive call)
     */
    private static void addAll(java.util.Collection<Object> result, Object value, boolean top) {
        java.util.Collection<Object> r = result;
        if (value instanceof ContainerValue) {
            ContainerValue cValue = (ContainerValue) value;
            if (!top) {
                if (Set.TYPE.isAssignableFrom(cValue.getType())) {
                    r = new java.util.HashSet<Object>();
                } else {
                    r = new java.util.ArrayList<Object>();
                }
                result.add(r);
            }
            for (int e = 0; e < cValue.getElementSize(); e++) {
                addAll(r, cValue.getElement(e), false);
            }
        } else if (value instanceof java.util.Collection<?>)  {
            if (!top) {
                if (value instanceof java.util.Set) {
                    r = new java.util.HashSet<Object>();
                } else {
                    r = new java.util.ArrayList<Object>();
                }
                result.add(r);
            }
            for (Object v : (java.util.Collection<?>) value) {
                addAll(r, v, false);
            }
        } else if (null != value && value.getClass().isArray()) {
            Object[] aValue = (Object[]) value;
            if (!top) {
                r = new java.util.ArrayList<Object>();
                result.add(r);
            }
            for (Object v : aValue) {
                addAll(r, v, false);
            }
        } else if (value instanceof Value) {
            r.add(((Value) value).getValue());
        } else {
            r.add(value);
        }
    }

}
