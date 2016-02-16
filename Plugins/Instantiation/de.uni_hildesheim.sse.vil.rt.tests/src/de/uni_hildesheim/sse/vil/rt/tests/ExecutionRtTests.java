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

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVILMemoryStorage;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVilStorage;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.NoVariableFilter;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.utils.messages.AbstractException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.vil.rt.tests.types.AlgorithmChangeCommand;
import de.uni_hildesheim.sse.vil.rt.tests.types.CommandCollector;
import de.uni_hildesheim.sse.vil.rt.tests.types.CommandSequence;
import de.uni_hildesheim.sse.vil.rt.tests.types.LifecycleEvent;
import de.uni_hildesheim.sse.vil.rt.tests.types.ParameterAdaptationEvent;
import de.uni_hildesheim.sse.vil.rt.tests.types.RegularAdaptationEvent;
import de.uni_hildesheim.sse.vil.rt.tests.types.StartupAdaptationEvent;

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
    protected void testExecutor(de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script script, 
        EqualitySetup data) throws VilException {
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
        EqualitySetup setup = new EqualitySetup(createFile(testName), testName, null, 
            createTraceFile(testName + ".snd"), param);
        assertEqual(setup);
        
        assertStorageEqual(2, storage, scriptName, varName);

        RtVilStorage.setInstance(null);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name + ".start"), param);
        assertEqual(setup);

        param.put("event", new LifecycleEvent("pipeline", LifecycleEvent.Status.END));
        setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name + ".end"), param);
        assertEqual(setup);

        param.put("event", new RegularAdaptationEvent());
        setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name + ".regular"), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        final String name = "startup4";
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
        EqualitySetup setup = new EqualitySetup(modelFile, name, null, createTraceFile(name), param);
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
        ReasonerFrontend.getInstance().check(cfg.getConfiguration().getProject(), cfg.getConfiguration(), rCfg, 
             ProgressObserver.NO_OBSERVER);
        
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
        EqualitySetup setup = new EqualitySetup(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
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
        ReasonerFrontend.getInstance().check(cfg.getConfiguration().getProject(), cfg.getConfiguration(), rCfg, 
             ProgressObserver.NO_OBSERVER);
        
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
        EqualitySetup setup = new EqualitySetup(modelFile, name, null, createTraceFile(name), param);
        setup.setEnableEquals(false);
        assertEqual(setup);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
        setup.setExpectedFailCode(127);
        setup.setExpectedFailReason("unknown");
        assertEqual(setup);
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

        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
        assertEqual(setup);

        Assert.assertEquals(2, CommandCollector.getExecutedCount());
        Assert.assertTrue(CommandCollector.getExecuted(0) instanceof CommandSequence);
        Assert.assertTrue(CommandCollector.getExecuted(1) instanceof AlgorithmChangeCommand);
        CommandCollector.clear();
        
        setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name + ".snd"), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
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
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
        assertEqual(setup);
    }

}
