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
package test.net.ssehub.easy.reasoning.core.frontend;

import org.junit.Test;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.AttributeValues;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerInterceptor;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration.IAdditionalInformationLogger;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.capabilities.IReasonerCapability;
import net.ssehub.easy.varModel.capabilities.IvmlReasonerCapabilities;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cstEvaluation.IConstraintEvaluator;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import test.net.ssehub.easy.reasoning.core.frontend.FakeReasoner.ResultType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * Tests {@link ReasonerFrontend}.
 * 
 * @author Holger Eichelberger
 */
public class ReasoningFrontendTests {

    public static final String NAME_NORMAL_REASONER = "fake";
    public static final String NAME_INSTANCE_REASONER = "fake-instance";
    
    /**
     * Tests the reasoner frontend.
     */
    @Test
    public void testFrontend() {
        ReasonerFrontend frontend = ReasonerFrontend.getInstance();
        // there shall be nothing, otherwise there are other registrations left over that were not cleaned up!
        Assert.assertNotNull(frontend.getRegistry());
        Assert.assertEquals(0, frontend.getReasonersCount());
        Assert.assertEquals(0, frontend.getReadyForUseCount());
        Assert.assertFalse(frontend.reasoningSupported());
        FakeReasoner fr = new FakeReasoner(
            FakeReasoner.createDefaultDescriptor(NAME_NORMAL_REASONER), 
            FakeReasoner.createDefaultResults(
                new ReasoningResult(NAME_NORMAL_REASONER), 
                createFailingReasoningResult(false, true)), // a fail
            FakeReasoner.createDefaultEvaluationResult());
        frontend.getRegistry().register(fr);
        FakeInstanceReasoner fri = new FakeInstanceReasoner(
            FakeReasoner.createDefaultDescriptor(NAME_INSTANCE_REASONER, IvmlReasonerCapabilities.EVAL), // one more!
            FakeReasoner.createDefaultResults(
                null, 
                createFailingReasoningResult(true, false),
                createFailingReasoningResult(false, false)), 
            FakeReasoner.createDefaultEvaluationResult());
        frontend.getRegistry().register(fri);
        Assert.assertEquals(2, frontend.getReasonersCount());
        Assert.assertEquals(2, frontend.getReadyForUseCount());
        Assert.assertTrue(frontend.reasoningSupported());
        assertInterceptor(fr);
        assertInterceptor(fri);

        Assert.assertEquals(frontend.getPreferredReasoner(), fri.getDescriptor());
        frontend.setReasonerHint(fr.getDescriptor());
        Assert.assertEquals(frontend.getReasonerHint(), fr.getDescriptor());
        Assert.assertEquals(frontend.getPreferredReasoner(), fri.getDescriptor());
        Assert.assertFalse(frontend.hasReasonerCapability(IvmlReasonerCapabilities.EVAL));
        frontend.setPreferredReasoner();
        Assert.assertEquals(frontend.getReasonerHint(), fri.getDescriptor());
        Assert.assertTrue(frontend.hasReasonerCapability(IvmlReasonerCapabilities.EVAL));
        
        List<ReasonerDescriptor> descriptors = new ArrayList<ReasonerDescriptor>();
        for (int i = 0; i < frontend.getReasonersCount(); i++) {
            descriptors.add(frontend.getReasonerDescriptor(i));
        }
        Assert.assertEquals(frontend.getReasonersCount(), descriptors.size());
        Assert.assertTrue(descriptors.contains(fr.getDescriptor()));
        Assert.assertTrue(descriptors.contains(fri.getDescriptor()));
        Assert.assertEquals(fr, frontend.findReasoner(NAME_NORMAL_REASONER, FakeReasoner.FAKE_VERSION));
        Assert.assertEquals(fr, frontend.findReasoner(NAME_NORMAL_REASONER, null));
        Assert.assertEquals(fri, frontend.findReasoner(NAME_INSTANCE_REASONER, FakeReasoner.FAKE_VERSION));
        Assert.assertEquals(fri, frontend.findReasoner(NAME_INSTANCE_REASONER, null));
        assertFailFindReasoner(frontend, NAME_INSTANCE_REASONER, "0.0");
        assertFailFindReasoner(frontend, "bla", FakeReasoner.FAKE_VERSION);
        
        frontend.setTimeout(10000);
        Assert.assertEquals(10000, frontend.getTimeout());

        Assert.assertFalse(frontend.isChainingReasoner(fr.getDescriptor()));
        Assert.assertTrue(frontend.isChainingReasoner(fri.getDescriptor()));

        assertReasoningOperations(frontend, fri); // the currently hinted one
        frontend.setReasonerHint(fr.getDescriptor());
        assertReasoningOperations(frontend, fr); // the currently hinted one
        
        frontend.getRegistry().unregister(fr);
        frontend.getRegistry().unregister(fri);
        Assert.assertEquals(0, frontend.getReasonersCount());
        Assert.assertEquals(0, frontend.getReadyForUseCount());
        Assert.assertFalse(frontend.reasoningSupported());
        frontend.setReasonerHint(null);
        Assert.assertNull(frontend.getReasonerHint());
    }
    
    /**
     * Creates a failing reasoning result.
     * 
     * @param stopped shall the result signal a stopped reasoning
     * @param timeout shall the result signal a timeout reasoning
     * @return the reasoning result instance
     */
    static ReasoningResult createFailingReasoningResult(boolean stopped, boolean timeout) {
        ReasoningResult result = new ReasoningResult();
        if (stopped) {
            result.setStopped(true);
        } else if (timeout) {
            result.setTimeout(true);
        } else {
            result.addMessage(new Message("fail", null, Status.ERROR));
        }
        return result;
    }
    
    /**
     * Asserts that finding a non-existing reasoner fails.
     * 
     * @param frontend the reasoner frontend to use
     * @param name the name of the reasoner
     * @param version the version (ignored if <b>null</b>)
     */
    private void assertFailFindReasoner(ReasonerFrontend frontend, String name, String version) {
        try {
            frontend.findReasoner(name, version);
            Assert.fail("Found reasoner '" + name + "' that shall not exist");
        } catch (IllegalArgumentException e) {
            // ok, not found
        }
    }
    
    /**
     * Applies the expected reasoner with different reasoner configurations. As the reasoning operations are 
     * not implemented, there shall not be any differences in the results. Just apply some combinations to
     * see whether they cause unexpected failures in the generic (frontend) classes.
     * 
     * @param frontend the reasoning frontend to use
     * @param expected the expected reasoner to apply (may differentiate via the reasoning results, 
     *     shall be hinted/default reasoner)
     */
    private void assertReasoningOperations(ReasonerFrontend frontend, FakeReasoner expected) {
        assertReasoningOperations(frontend, null, ProgressObserver.NO_OBSERVER, expected);
        ReasonerConfiguration reasonerConfiguration = new ReasonerConfiguration();
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
        reasonerConfiguration.enableCustomMessages();
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
        reasonerConfiguration.disableCustomMessages();
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
        reasonerConfiguration.setRuntimeMode(true);
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
        reasonerConfiguration.setTimeout(1000);
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
        reasonerConfiguration.setAdditionalInformationLogger(new IAdditionalInformationLogger() {
            
            @Override
            public void info(Message msg) {
                System.out.println("ADDITIONAL MESSAGE: " + msg);
            }
            
            @Override
            public void info(String text) {
                System.out.println("ADDITIONAL INFO: " + text);
            }
        });
        AttributeValues val = new AttributeValues();
        reasonerConfiguration.setAttributeValues(val);
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
        reasonerConfiguration.setDefaultReasoner(expected.getDescriptor());
        for (IReasonerCapability c : IvmlReasonerCapabilities.values()) {
            Assert.assertEquals(expected.getDescriptor().hasCapability(c), 
                frontend.hasReasonerCapability(c, reasonerConfiguration));
        }
        assertReasoningOperations(frontend, reasonerConfiguration, ProgressObserver.NO_OBSERVER, expected);
    }
    
    /**
     * Does a series of basic "reasoning" operations. Just apply some combinations to
     * see whether they cause unexpected failures in the generic (frontend) classes.
     * 
     * @param frontend the reasoning frontend to use
     * @param reasonerConfiguration the reasoner configuration to use
     * @param observer the progress observer to use
     * @param expected the expected reasoner to apply (may differentiate via the reasoning results)
     */
    private void assertReasoningOperations(ReasonerFrontend frontend, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer, FakeReasoner expected) {
        
        Project prj = new Project("test");
        Configuration cfg = new Configuration(prj);

        assertReasoningResult(expected, ResultType.CHECK, 
            frontend.check(cfg, reasonerConfiguration, observer));
        assertReasoningResult(expected, ResultType.CHECK, 
            frontend.check(prj, cfg, reasonerConfiguration, observer));
        List<Constraint> constraints = new ArrayList<Constraint>();
        assertEvaluationResult(expected, frontend.evaluate(cfg, constraints, reasonerConfiguration, observer));
        assertReasoningResult(expected, ResultType.IS_CONSISTENT, 
            frontend.isConsistent(prj, reasonerConfiguration, observer));
        assertReasoningResult(expected, ResultType.PROPAGATE, 
            frontend.propagate(cfg, reasonerConfiguration, observer));
        assertReasoningResult(expected, ResultType.PROPAGATE,
            frontend.propagate(prj, cfg, reasonerConfiguration, observer));
        ReasoningResult expRes = new ReasoningResult();
        expRes.addMessage(new Message("invalid URL", null, Status.ERROR));
        assertReasoningResult(expRes, frontend.upgradeReasoner(expected.getDescriptor(), null, observer));
        assertReasoningResult(expected, ResultType.UPGRADE, 
            frontend.upgradeReasoner(expected.getDescriptor(), new File(".").toURI(), observer));

        assertInstanceOperations(frontend.createInstance(cfg, reasonerConfiguration), cfg, reasonerConfiguration, 
            observer, expected);
        assertInstanceOperations(frontend.createInstance(prj, cfg, reasonerConfiguration), cfg, reasonerConfiguration, 
            observer, expected);
    }
    
    /**
     * Asserts instance operations. Instances shall have the same descriptor etc.
     * 
     * @param instance the reasoner instance
     * @param cfg the configuration
     * @param reasonerConfiguration the reasoner configuration to use
     * @param observer the progress observer to use
     * @param expected the expected reasoner to apply (may differentiate via the reasoning results)
     */
    private void assertInstanceOperations(IReasonerInstance instance, Configuration cfg, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer, FakeReasoner expected) {
        if (expected.providesInstance()) {
            Assert.assertNotNull(instance);
            Assert.assertEquals(expected.getDescriptor(), instance.getDescriptor());
            Assert.assertEquals(cfg.getProject(), instance.getProject());
            Assert.assertEquals(reasonerConfiguration, instance.getReasonerConfiguration());
            assertReasoningResult(expected, ResultType.CHECK, instance.check(observer));
            assertReasoningResult(expected, ResultType.IS_CONSISTENT, instance.isConsistent(observer));
            assertReasoningResult(expected, ResultType.PROPAGATE, instance.propagate(observer));
            List<Constraint> constraints = new ArrayList<Constraint>();
            assertEvaluationResult(expected, instance.evaluate(constraints, observer));
            Assert.assertFalse(instance.isRunning());
            instance.stop(); // shall not cause anything
        } else {
            Assert.assertNull(instance);
        }
    }
 
    /**
     * Asserts the interceptor - by applying one.
     * 
     * @param reasoner the reasoner to apply the interceptor to
     */
    private void assertInterceptor(FakeReasoner reasoner) {
        reasoner.setInterceptor(new IReasonerInterceptor() {
            
            @Override
            public void notifyEvaluation(Constraint constraint, IConstraintEvaluator evaluator) {
                System.out.println("INTERCEPTOR: " + constraint + " " + evaluator);
            }
        });
    }
    
     /**
     * Asserts a reasoning result.
     * 
     * @param expected the expected reasoner to use
     * @param resultType the result type to look into
     * @param actual the expected reasoning result
     */
    static void assertReasoningResult(FakeReasoner expected, FakeReasoner.ResultType resultType, 
        ReasoningResult actual) {
        ReasoningResult expRes = expected.getExpectedReasoningResult(resultType);
        assertReasoningResult(expRes, actual);
    }

    /**
     * Asserts a reasoning result.
     * 
     * @param expected the expected reasoning result
     * @param actual the expected reasoning result
     */
    static void assertReasoningResult(ReasoningResult expected, ReasoningResult actual) {
        Assert.assertEquals(expected.hasConflict(), actual.hasConflict());
        Assert.assertEquals(expected.hasTimeout(), actual.hasTimeout());
        Assert.assertEquals(expected.hasInfo(), actual.hasInfo());
        Assert.assertEquals(expected.getMessageCount(), actual.getMessageCount());

        for (int m = 0; m < expected.getMessageCount(); m++) {
            Message me = expected.getMessage(m);
            Message ma = actual.getMessage(m);
            // sufficient comparison for here
            Assert.assertEquals(me.getDescription(), ma.getDescription());
            Assert.assertEquals(me.getStatus(), ma.getStatus());
        }
    }

    /**
     * Asserts an evaluation result.
     * 
     * @param expected the expected reasoner to use
     * @param actual the expected evaluation result
     */
    static void assertEvaluationResult(FakeReasoner expected, EvaluationResult actual) {
        EvaluationResult expRes = expected.getExpectedEvaluationResult();
        assertEvaluationResult(expRes, actual);
    }

    /**
     * Asserts an evaluation result.
     * 
     * @param expected the expected evaluation result
     * @param actual the expected evaluation result
     */
    static void assertEvaluationResult(EvaluationResult expected, EvaluationResult actual) {
        assertReasoningResult(expected, actual);
        Assert.assertEquals(expected.getEvaluationPairCount(), actual.getEvaluationPairCount());
    }

}
