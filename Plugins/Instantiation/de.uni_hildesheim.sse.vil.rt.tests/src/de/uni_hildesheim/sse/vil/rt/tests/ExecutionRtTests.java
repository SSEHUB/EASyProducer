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
package de.uni_hildesheim.sse.vil.rt.tests;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.vil.rt.tests.types.AlgorithmChangeCommand;
import de.uni_hildesheim.sse.vil.rt.tests.types.CommandCollector;
import de.uni_hildesheim.sse.vil.rt.tests.types.CommandSequence;
import de.uni_hildesheim.sse.vil.rt.tests.types.LifecycleEvent;
import de.uni_hildesheim.sse.vil.rt.tests.types.ParameterAdaptationEvent;
import de.uni_hildesheim.sse.vil.rt.tests.types.RegularAdaptationEvent;
import de.uni_hildesheim.sse.vil.rt.tests.types.StartupAdaptationEvent;
import net.ssehub.easy.basics.messages.AbstractException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.NoVariableFilter;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Executor;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVILMemoryStorage;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilStorage;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cstEvaluation.VariableValueCopier;
import net.ssehub.easy.varModel.cstEvaluation.VariableValueCopier.CopySpec;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the execution of rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionRtTests extends AbstractRtTest {

    private static final boolean DEBUG = false;
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "execution-rt");
    }

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        test.de.uni_hildesheim.sse.vil.buildlang.ExecutionTests.startUp();
        registerReasoner();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        test.de.uni_hildesheim.sse.vil.buildlang.ExecutionTests.shutDown();
    }
    
    @Override
    protected void testExecutor(net.ssehub.easy.instantiation.core.model.buildlangModel.Script script, 
        EqualitySetup<Script> data) throws VilException {
        // disable the executor testing for now - leads to the execution of a rtVILscript with VIL searching for
        // the default main model
    }

    /**
     * Tests the load properties element.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEmpty() throws IOException {
        assertEqual("empty");
    }
    
    /**
     * Asserts the equality of a value in a rt-VIL storage.
     * 
     * @param expected the expected value
     * @param storage the storage to check for
     * @param script the script to take the value from
     * @param variable the variable to take the value from
     */
    private static void assertStorageEqual(Object expected, RtVilStorage storage, String script, String variable) {
        Object value = storage.getValue(script, variable);
        if (null == expected) {
            Assert.assertNull(value);
        } else {
            Assert.assertEquals(expected, value);
        }
    }

    /**
     * Tests the basic functions of persistent variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testPersistentVar() throws IOException {
        final String scriptName = "persistentVar";
        final String varName = "global";
        
        RtVilStorage storage = new RtVILMemoryStorage();
        RtVilStorage.setInstance(storage);
        assertStorageEqual(null, storage, scriptName, varName);
        
        final String testName = "persistentVar";
        assertEqual(testName);
        assertStorageEqual(1, storage, scriptName, varName);
        
        // do the same game with different trace result that shall lead to different variable assignment
        Map<String, Object> param = createParameterMap(null, null, null);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(testName), testName, null, 
            createTraceFile(testName + ".snd"), param);
        assertEqual(setup);
        
        assertStorageEqual(2, storage, scriptName, varName);

        RtVilStorage.setInstance(null);
    }
    
    /**
     * Tests the re-use of strategies.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSubstrategy() throws IOException {
        final String name = "substrategy";
        
        Configuration cfg = getIvmlConfiguration("Add", NoVariableFilter.INSTANCE);
        // if referenced strategies are not top-level (reusable) strategies, the trace is empty
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new RegularAdaptationEvent());
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);

        // "normal" execution with specific event
        param.put("event", new LifecycleEvent("pip", LifecycleEvent.Status.START));
        setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name + ".snd"), param);
        assertEqual(setup);
    }

    /**
     * Tests return rule with precondition (true).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReturn() throws IOException {
        final String name = "return";
        
        Configuration cfg = getIvmlConfiguration("Add", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new LifecycleEvent("pip", LifecycleEvent.Status.START));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests return rule with precondition (false).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReturn2() throws IOException {
        final String name = "return2";
        
        Configuration cfg = getIvmlConfiguration("Add", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new LifecycleEvent("pip", LifecycleEvent.Status.START));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests the basic functions of startup, events and implicit calls failing at a missing enactment.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStartup() throws IOException {
        final String name = "startup";
        Map<String, Object> param = createParameterMap(null, null, null);
        param.put("event", new LifecycleEvent("pipeline", LifecycleEvent.Status.START));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup, AbstractException.ID_CANNOT_RESOLVE);
    }

    /**
     * Tests the basic functions of startup, events and implicit calls.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStartup1() throws IOException {
        final String name = "startup1";
        Map<String, Object> param = createParameterMap(null, null, null);
        param.put("event", new LifecycleEvent("pipeline", LifecycleEvent.Status.START));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests the basic functions of startup, shutdown and default strategy.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStartup2() throws IOException {
        final String name = "startup2";
        Map<String, Object> param = createParameterMap(null, null, null);
        
        // test startup
        param.put("event", new LifecycleEvent("pipeline", LifecycleEvent.Status.START));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name + ".start"), param);
        assertEqual(setup);

        param.put("event", new LifecycleEvent("pipeline", LifecycleEvent.Status.END));
        setup = new EqualitySetup<Script>(createFile(name), name, null, createTraceFile(name + ".end"), param);
        assertEqual(setup);

        param.put("event", new RegularAdaptationEvent());
        setup = new EqualitySetup<Script>(createFile(name), name, null, createTraceFile(name + ".regular"), param);
        assertEqual(setup);
    }
    
    /**
     * Tests a QM-like pipeline startup.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStartup3() throws IOException {
        final String name = "startup3";

        CommandCollector.clear();
        Configuration cfg = getIvmlConfiguration("QM1", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new LifecycleEvent("pip", LifecycleEvent.Status.START));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
        Assert.assertEquals(2, CommandCollector.getExecutedCount());
        Assert.assertTrue(CommandCollector.getExecuted(0) instanceof CommandSequence);
        Assert.assertTrue(CommandCollector.getExecuted(1) instanceof AlgorithmChangeCommand);
        AlgorithmChangeCommand algC = (AlgorithmChangeCommand) CommandCollector.getExecuted(1);
        Assert.assertEquals("pip", algC.getPipeline());
        Assert.assertEquals("famelt1", algC.getElement());
        Assert.assertEquals("alg1", algC.getAlgorithm()); // see rtvil + ivml
    }

    /**
     * Tests a QM-like pipeline startup with value mapping.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStartup4() throws IOException {
        testStartup4o5("startup4");
    }
    
    /**
     * Tests a QM-like pipeline startup with value mapping (as startup5, tactics separated in own file).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStartup5() throws IOException {
        testStartup4o5("startup5");
    }
    
    /**
     * Tests a QM-like pipeline startup with value mapping.
     * 
     * @param name the name of the rt-VIL file
     * @throws IOException should not occur
     */
    private void testStartup4o5(final String name) throws IOException {
        File modelFile = createFile(name);
        CommandCollector.clear();
        Configuration cfg = getIvmlConfiguration("QM1", NoVariableFilter.INSTANCE);
        
        URI uri = URI.createFileURI(modelFile.getAbsolutePath());
        TranslationResult<Script> result = getTestConfigurer().parse(uri);
        if (DEBUG) {
            if (result.getErrorCount() > 0) {
                for (int r = 0; r < result.getMessageCount(); r++) {
                    System.out.println(result.getMessage(r).getDescription());        
                }
            }
        }
        Assert.assertEquals(0, result.getErrorCount());
        Assert.assertEquals(1, result.getResultCount());
        
        // do initialization here
        Executor exec = new Executor(result.getResult(0));
        File tmp = File.createTempFile("rtviltest", "temp");
        tmp.delete();
        tmp.mkdirs();
        tmp.deleteOnExit();
        exec.addBase(tmp);
        exec.addSource(tmp);
        exec.addTarget(tmp);
        exec.addConfiguration(cfg.getConfiguration());
        exec.addCustomArgument("event", null);
        exec.addCustomArgument("values", null);
        exec.stopAfterBindValues();
        
        try {
            exec.execute();
        } catch (VilException e) {
            Assert.fail("unexpected exception " + e.getMessage());
        }
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new LifecycleEvent("pip", LifecycleEvent.Status.START));
        param.put("values", null);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        setup.setModel(result.getResult(0)); // ensure same for initialize - no initialization here
        assertEqual(setup);
        Assert.assertEquals(2, CommandCollector.getExecutedCount());
        Assert.assertTrue(CommandCollector.getExecuted(0) instanceof CommandSequence);
        Assert.assertTrue(CommandCollector.getExecuted(1) instanceof AlgorithmChangeCommand);
        AlgorithmChangeCommand algC = (AlgorithmChangeCommand) CommandCollector.getExecuted(1);
        Assert.assertEquals("pip", algC.getPipeline());
        Assert.assertEquals("famelt1", algC.getElement());
        Assert.assertEquals("alg1", algC.getAlgorithm()); // see rtvil + ivml
    }

    /**
     * Tests a QM-like pipeline startup with value mapping.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testParameter() throws IOException {
        final String name = "parameter";
        File modelFile = createFile(name);
        CommandCollector.clear();
        Configuration cfg = getIvmlConfiguration("QM2", NoVariableFilter.INSTANCE);
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setRuntimeMode(true);
        ReasonerFrontend.getInstance().check(cfg.getConfiguration(), rCfg, ProgressObserver.NO_OBSERVER);
        
        URI uri = URI.createFileURI(modelFile.getAbsolutePath());
        TranslationResult<Script> result = getTestConfigurer().parse(uri);
        if (true) {
            if (result.getErrorCount() > 0) {
                for (int r = 0; r < result.getMessageCount(); r++) {
                    System.out.println(result.getMessage(r).getDescription());        
                }
            }
        }
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new ParameterAdaptationEvent<Integer>("pipeline", "element", "delay", 50));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
        assertEqual(setup);
    }
    
    /**
     * Tests addition on fields.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testParameter2() throws IOException {
        final String name = "parameter2";
        Configuration cfg = getIvmlConfiguration("QM2", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        setup.setExpectedFailReason("not done");
        assertEqual(setup);
    }

    /**
     * Tests a QM-like pipeline startup with value mapping.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testMapping() throws IOException {
        final String name = "mapping";
        File modelFile = createFile(name);
        CommandCollector.clear();
        Configuration cfg = getIvmlConfiguration("QM3", NoVariableFilter.INSTANCE);
        ReasonerConfiguration rCfg = new ReasonerConfiguration();
        rCfg.setRuntimeMode(true);
        ReasonerFrontend.getInstance().check(cfg.getConfiguration(), rCfg, ProgressObserver.NO_OBSERVER);
        
        URI uri = URI.createFileURI(modelFile.getAbsolutePath());
        TranslationResult<Script> result = getTestConfigurer().parse(uri);
        if (true) {
            if (result.getErrorCount() > 0) {
                for (int r = 0; r < result.getMessageCount(); r++) {
                    System.out.println(result.getMessage(r).getDescription());        
                }
            }
        }
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new ParameterAdaptationEvent<Integer>("pipeline", "element", "delay", 50));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
        assertEqual(setup);
    }
    
    /**
     * Tests a single reference assignment (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences() throws IOException {
        final String name = "references";
        File modelFile = createFile(name);
        Configuration cfg = getIvmlConfiguration("QM4", NoVariableFilter.INSTANCE);
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
        assertEqual(setup);
    }

    /**
     * Tests value instantiation capabilities of rt-VIL (via VIL, contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInstances() throws IOException {
        testInstances("instances", "QM6");
    }

    /**
     * Tests value instantiation capabilities of rt-VIL (via VIL, contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInstances2() throws IOException {
        testInstances("instances2", "QM6");
    }

    /**
     * Tests value instantiation capabilities of rt-VIL (via VIL, contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInstances3() throws IOException {
        testInstances("instances3", "QM7");
    }

    /**
     * Tests value instantiation capabilities of rt-VIL for some rather similar models.
     * 
     * @param name instances?
     * @param ivmlName QM6/QM7
     * 
     * @throws IOException should not occur
     */
    private void testInstances(String name, String ivmlName) throws IOException {
        File modelFile = createFile(name);
        Configuration cfg = getIvmlConfiguration(ivmlName, NoVariableFilter.INSTANCE);
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        //setup.setEnableEquals(false);
        assertEqual(setup);
        
        DecisionVariable var = cfg.getByName("node");
        Assert.assertNotNull(var);
        DecisionVariable sVar = var.getByName("shedder");
        Assert.assertNotNull(sVar);
        DecisionVariable nVar = sVar.getByName("name");
        Assert.assertNotNull(nVar);
        Assert.assertEquals("NTH_ITEM", nVar.getStringValue());
        DecisionVariable pVar = sVar.getByName("parameters");
        Assert.assertNotNull(pVar);
        Sequence<DecisionVariable> pVars = pVar.variables();
        Assert.assertNotNull(pVars);
        Assert.assertTrue(1 == pVars.size());
        DecisionVariable ppVar = pVars.get(0);
        Assert.assertNotNull(ppVar);
        DecisionVariable ppNameVar = ppVar.getByName("name");
        Assert.assertNotNull(ppNameVar);
        Assert.assertEquals("NTH_TUPLE", ppNameVar.getStringValue());
        DecisionVariable ppValueVar = ppVar.getByName("value");
        Assert.assertNotNull(ppValueVar);
        Assert.assertEquals(500, ppValueVar.getIntegerValue().intValue());
    }

    /**
     * Tests value instantiation capabilities of rt-VIL for constraints during value creation.
     * 
     * @param name instances?
     * @param ivmlName RTInstances1
     * 
     * @throws IOException should not occur
     */
    private void testRtInstances(String name, String ivmlName) throws IOException {
        File modelFile = createFile(name);
        Configuration cfg = getIvmlConfiguration(ivmlName, NoVariableFilter.INSTANCE);
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        //setup.setEnableEquals(false);
        assertEqual(setup);
        
        DecisionVariable var = cfg.getByName("node");
        Assert.assertNotNull(var);
        DecisionVariable sVar = var.getByName("shedder");
        Assert.assertNotNull(sVar);
        DecisionVariable nVar = sVar.getByName("name");
        Assert.assertNotNull(nVar);
        Assert.assertEquals("NTH_ITEM", nVar.getStringValue());
    }
    
    /**
     * Tests a single reference assignment (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences2() throws IOException {
        final String name = "references2";
        File modelFile = createFile(name);
        Configuration cfg = getIvmlConfiguration("QM5", NoVariableFilter.INSTANCE);
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
        assertEqual(setup);
    }

    /**
     * Tests a single reference assignment (contributed by QualiMaster).
     * 
     * @throws IOException should not occur
     * @throws ModelQueryException should not occur
     */
    @Test
    public void testReferences3() throws IOException, ModelQueryException {
        final String name = "references3";
        File modelFile = createFile(name);
        Configuration cfg = getIvmlConfiguration("QM8", NoVariableFilter.INSTANCE);
        
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
        assertEqual(setup);
        
        net.ssehub.easy.varModel.confModel.Configuration c = cfg.getConfiguration();
        AbstractVariable var = ModelQuery.findVariable(c.getProject(), "hAlg", null);
        Assert.assertNotNull(var);
        IDecisionVariable d = c.getDecision(var);
        IDecisionVariable a = d.getNestedElement("actualHwNode");
        Assert.assertNotEquals(NullValue.INSTANCE, a.getValue());
    }
    
    /**
     * Tests a simple weighting function.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWeighting() throws IOException {
        assertEqual("weighting");
    }

    /**
     * Tests a simple weighting function with imported enactment.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWeighting2() throws IOException {
        assertEqual("weighting2");
    }
    
    /**
     * Tests a failing tactic. The first tactic shall fail, the second shall succeed.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail1() throws IOException {
        assertEqual("fail1");
    }

    /**
     * Tests a failing strategy. The first strategy shall fail, the second shall succeed.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail2() throws IOException {
        assertEqual("fail2");
    }
    
    /**
     * Tests a finally failing strategy.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail3() throws IOException {
        final String name = "fail3";
        Map<String, Object> param = createParameterMap(null, null, null);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        setup.setExpectedFailCode(127);
        setup.setExpectedFailReason("unknown");
        assertEqual(setup);
    }

    /**
     * Tests a finally failing strategy.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail4() throws IOException {
        final String name = "fail4";
        Map<String, Object> param = createParameterMap(null, null, null);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        setup.setExpectedFailCode(127);
        setup.setExpectedFailReason("unknown");
        assertEqual(setup);
    }
    
    /**
     * Tests fail over multiple strategies.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail5() throws IOException {
        final String name = "fail5";
        Map<String, Object> param = createParameterMap(null, null, null);
        param.put("event", new ParameterAdaptationEvent<Integer>("pipeline", "element", "param", 5));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        setup.setExpectedFailReason("unknown");
        setup.setExpectedFailCode(127);
        assertEqual(setup);
    }

    /**
     * Tests a refail without previous fail. Nothing shall happen.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail6() throws IOException {
        assertEqual("fail6");
    }

    /**
     * Tests simple timeout expressions (negative, possible).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTimeout() throws IOException {
        assertEqual("timeout");
    }

    /**
     * Tests simple timeout expressions, one causing a timeout due to calculations that take more
     * than one 1ms leading to an alternative execution.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTimeout1() throws IOException {
        assertEqual("timeout1");
    }

    /**
     * Tests fallthrough tactics, i.e., no modification try next.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTactics1() throws IOException {
        assertEqual("tactics1");
    }
    
    /**
     * Tests a non-fallthrough tactic based on re-configuration.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTactics2() throws IOException {
        final String name = "tactics2";
        Configuration cfg = getIvmlConfiguration("tactics2", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests mapped map types.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypes() throws IOException {
        assertEqual("types");
    }
    
    /**
     * Tests the QM AdaptationLayer test model.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testALTest() throws IOException {
        final String name = "ALtest";

        CommandCollector.clear();
        Configuration cfg = getIvmlConfiguration("ALtest", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        param.put("event", new StartupAdaptationEvent("pipeline"));
        param.put("bindings", null);

        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);

        Assert.assertEquals(2, CommandCollector.getExecutedCount());
        Assert.assertTrue(CommandCollector.getExecuted(0) instanceof CommandSequence);
        Assert.assertTrue(CommandCollector.getExecuted(1) instanceof AlgorithmChangeCommand);
        CommandCollector.clear();
        
        setup = new EqualitySetup<Script>(createFile(name), name, null, createTraceFile(name + ".snd"), param);
        assertEqual(setup);
        
        Assert.assertEquals(0, CommandCollector.getExecutedCount());
    }
    
    /**
     * Shortcut function to {@link #assertEqual(EqualitySetup, int...)} providing default script
     * parameters.
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files fails
     */
    protected void assertEqual(String name, int... expectedExceptions) throws IOException {
        Map<String, Object> param = createParameterMap(null, null, null);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup, expectedExceptions);
    }

    /**
     * Tests calls to imported scripts.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCall() throws IOException {
        final String name = "call";
        Configuration cfg = getIvmlConfiguration("QM1", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
             createTraceFile(name), param);
        assertEqual(setup);
    }
    
    /**
     * Tests addition on fields.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testAdd() throws IOException {
        final String name = "add";
        Configuration cfg = getIvmlConfiguration("Add", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests addition on fields.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testClear() throws IOException {
        final String name = "clear";
        Configuration cfg = getIvmlConfiguration("Clear", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests dynamic dispatch.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDispatch() throws IOException {
        final String name = "dispatch1";
        Configuration cfg = getIvmlConfiguration("dispatch1", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    /**
     * Tests dynamic dispatch over references. Testing also {@link VariableValueCopier}.
     * 
     * @throws IOException should not occur
     * @throws ModelQueryException should not occur
     * @throws CSTSemanticException should not occur
     * @throws ValueDoesNotMatchTypeException should not occur
     * @throws ConfigurationException should not occur
     */
    @Test
    public void testDispatch2() throws IOException, ModelQueryException, CSTSemanticException, 
        ValueDoesNotMatchTypeException, ConfigurationException {
        final String name = "dispatch2";
        net.ssehub.easy.varModel.confModel.Configuration cfg 
            = getIvmlConfiguration("dispatch2", NoVariableFilter.INSTANCE).getConfiguration();
        Compound algType = (Compound) ModelQuery.findType(cfg.getProject(), "Algorithm", null);
        CopySpec spec = new CopySpec(algType, "ref", "avail");
        VariableValueCopier copier = new VariableValueCopier("TEST", spec);
        copier.process(cfg);
        Map<String, Object> param = createParameterMap(null, null, new Configuration(cfg, NoVariableFilter.INSTANCE));
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }
    
    /**
     * Tests default output on fields.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testDefault() throws IOException {
        final String name = "default";
        Configuration cfg = getIvmlConfiguration("Add", NoVariableFilter.INSTANCE);
        Map<String, Object> param = createParameterMap(null, null, cfg);
        EqualitySetup<Script> setup = new EqualitySetup<Script>(createFile(name), name, null, 
            createTraceFile(name), param);
        assertEqual(setup);
    }

    @Override
    protected void assertExecutor(EqualitySetup<Script> data, 
        net.ssehub.easy.instantiation.core.model.execution.Executor executor) {
        if (executor instanceof Executor) {
            Executor e = (Executor) executor;
            assertFailure(data, e.getFailReason(), e.getFailCode(), null);
        }
    }

    @Override
    protected void assertFailure(EqualitySetup<Script> data, Object result) {
        String actualFailReason;
        Integer actualFailCode;
        net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.Status status;
        if (null != data.getExpectedFailCode() || null != data.getExpectedFailReason()) {
            Assert.assertNotNull("explicit failure expected but no execution result", result);
            Assert.assertTrue("expected instanceof of RuleExecutionResult", result instanceof RuleExecutionResult);
            RuleExecutionResult rResult = (RuleExecutionResult) result;
            actualFailReason = rResult.getFailReason();
            actualFailCode = rResult.getFailCode();
            status = rResult.getStatus();
        } else {
            if (result instanceof RuleExecutionResult) {
                RuleExecutionResult rResult = (RuleExecutionResult) result;
                status = rResult.getStatus();
                actualFailReason = rResult.getFailReason();
                actualFailCode = rResult.getFailCode();
            } else {
                status = net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.
                    Status.SUCCESS; 
                actualFailReason = null;
                actualFailCode = null;
            }
        }
        assertFailure(data, actualFailReason, actualFailCode, status);
    }

    @Override
    protected void assertFailure(EqualitySetup<Script> data, String actualFailReason, Integer actualFailCode, 
        net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.Status status) {
        if (null != data.getExpectedFailCode() || null != data.getExpectedFailReason()) {
            if (null != data.getExpectedFailCode()) {
                Assert.assertEquals(data.getExpectedFailCode(), actualFailCode);
            }
            if (null != data.getExpectedFailReason()) {
                Assert.assertEquals(data.getExpectedFailReason(), actualFailReason);
            }
            if (null != status) {
                Assert.assertEquals(net.ssehub.easy.instantiation.core.model.buildlangModel.
                    RuleExecutionResult.Status.FAIL, status);
            }
        } else {
            Assert.assertNull(actualFailCode);
            Assert.assertNull(actualFailReason);
            if (null != status) {
                Assert.assertEquals(net.ssehub.easy.instantiation.core.model.buildlangModel.
                    RuleExecutionResult.Status.SUCCESS, status);
            }
        }
    }

    /**
     * Tests value instantiation capabilities of rt-VIL with constraints.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRtInstance1() throws IOException {
        testRtInstances("rtInstance1", "RTInstance1");
    }

}
