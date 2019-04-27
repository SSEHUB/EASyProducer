/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.frontend;

import org.junit.Test;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.FakeReasoner.ResultType;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

import static net.ssehub.easy.reasoning.core.frontend.ReasoningFrontendTests.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests the {@link ReasonerAdapter}.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerAdapterTests {

    private static final String INSTANCE_MSG_PREFIX = "fri-i";
    private FakeReasoner fr;
    private FakeExplicitInstanceReasoner fri;
    
    /**
     * Tests the adapter.
     */
    @Test
    public void testAdapter() {
        ReasonerFrontend frontend = ReasonerFrontend.getInstance();
        fr = new FakeReasoner(
            FakeReasoner.createDefaultDescriptor(NAME_NORMAL_REASONER), 
            FakeReasoner.createDefaultResults(
                createFailingReasoningResult(false, false), createFailingReasoningResult(false, false), 
                createFailingReasoningResult(false, false), createFailingReasoningResult(false, false), 
                createFailingReasoningResult(false, false)),
            FakeReasoner.createDefaultEvaluationResult());
        frontend.getRegistry().register(fr);
        fri = new FakeExplicitInstanceReasoner(
            FakeReasoner.createDefaultDescriptor(NAME_INSTANCE_REASONER), 
            FakeReasoner.createDefaultResults(),
            FakeReasoner.createDefaultEvaluationResult());

        // specific instance message overrides to separate instance-based from normal reasoning
        Map<ResultType, ReasoningResult> results = new HashMap<ResultType, ReasoningResult>();
        createWarningResult(results, INSTANCE_MSG_PREFIX, ResultType.UPGRADE);
        createWarningResult(results, INSTANCE_MSG_PREFIX, ResultType.IS_CONSISTENT);
        createWarningResult(results, INSTANCE_MSG_PREFIX, ResultType.CHECK);
        createWarningResult(results, INSTANCE_MSG_PREFIX, ResultType.INITIALIZE);
        createWarningResult(results, INSTANCE_MSG_PREFIX, ResultType.PROPAGATE);
        fri.setInstanceResults(results, createWarningEvaluationResult(INSTANCE_MSG_PREFIX));

        frontend.getRegistry().register(fri); 
        frontend.setReasonerHint(null); // just to be sure, must not be set here

        ReasonerAdapter ra = new ReasonerAdapter();
        testAdaptor(frontend, ra, fr, false);
        testAdaptor(frontend, ra, fri, true);
        ra = new ReasonerAdapter(true);
        testAdaptor(frontend, ra, fr, false);
        testAdaptor(frontend, ra, fri, true);
        ra.setEnableInstanceBasedReasoning(false);
        testAdaptor(frontend, ra, fr, false);
        testAdaptor(frontend, ra, fri, false);
    
        frontend.getRegistry().unregister(fr);
        frontend.getRegistry().unregister(fri);
        fr = null;
        fri = null;
    }
    
    /**
     * Creates a warning result set.
     * 
     * @param results the result set to modify as a side effect
     * @param prefix a prefix for identifying the messages
     * @param resultType the result type to create the result for
     */
    private static void createWarningResult(Map<ResultType, ReasoningResult> results, String prefix, 
        ResultType resultType) {
        ReasoningResult result = new ReasoningResult();
        result.addMessage(new Message(prefix + " " + resultType.ordinal(), null, Status.WARNING));
        results.put(resultType, result);
    }
    
    /**
     * Creates a warning evaluation result.
     * 
     * @param prefix a prefix for identifying the messages
     * @return the warning evaluation result
     */
    private static EvaluationResult createWarningEvaluationResult(String prefix) {
        EvaluationResult result = new EvaluationResult();
        result.addMessage(new Message(prefix + " i-eval", null, Status.WARNING));
        return result;
    }

    /**
     * Tests the reasoner adaptor.
     * 
     * @param frontend the underlying frontend
     * @param adaptor the adaptor to use
     * @param hint the hinting reasoner
     * @param useInstance whether instance reasoning is expected
     */
    private void testAdaptor(ReasonerFrontend frontend, ReasonerAdapter adaptor, 
        FakeReasoner hint, boolean useInstance) {
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        rConfig.setDefaultReasoner(hint.getDescriptor());
        ProgressObserver observer = ProgressObserver.NO_OBSERVER;
        Project prj = new Project("prj");
        Configuration cfg = new Configuration(prj);
        assertNormal(adaptor, cfg, rConfig, observer, hint, useInstance); 
        Project prjI = new Project("prjI");
        Configuration cfgI = new Configuration(prjI);
        assertNormal(adaptor, cfg, rConfig, observer, hint, useInstance); 
        assertNormal(adaptor, cfgI, rConfig, observer, hint, useInstance);
        adaptor.register(cfgI);
        assertNormal(adaptor, cfg, rConfig, observer, hint, useInstance);
        assertInstance(adaptor, cfgI, rConfig, observer, hint, useInstance);
        adaptor.clear(cfgI);
        assertNormal(adaptor, cfg, rConfig, observer, hint, useInstance);
        assertNormal(adaptor, cfgI, rConfig, observer, hint, useInstance);
        adaptor.register(cfgI);
        assertNormal(adaptor, cfg, rConfig, observer, hint, useInstance);
        assertInstance(adaptor, cfgI, rConfig, observer, hint, useInstance);
        adaptor.clear();
        assertNormal(adaptor, cfg, rConfig, observer, hint, useInstance);
        assertNormal(adaptor, cfgI, rConfig, observer, hint, useInstance);
    }
    
    // checkstyle: stop parameter number check

    /**
     * Asserts a normal reasoning result for all reasoning operations.
     * 
     * @param adapter the adapter instance
     * @param cfg the configuration to use
     * @param rConfig the reasoner configuration to user
     * @param observer the progress observer to use
     * @param hint the hinting reasoner
     * @param useInstance whether instance reasoning is expected
     */
    private void assertNormal(ReasonerAdapter adapter, Configuration cfg, ReasonerConfiguration rConfig, 
        ProgressObserver observer, FakeReasoner hint, boolean useInstance) {
        assertNormal(adapter.propagate(cfg, rConfig, observer), hint, ResultType.PROPAGATE, useInstance); 
        assertNormal(adapter.check(cfg, rConfig, observer), hint, ResultType.CHECK, useInstance); 
        assertNormal(adapter.isConsistent(cfg, rConfig, observer), hint, ResultType.IS_CONSISTENT, useInstance); 
        List<Constraint> constraints = new ArrayList<Constraint>();
        assertNormal(adapter.evaluate(cfg, constraints, rConfig, observer), hint, useInstance);
    }

    /**
     * Asserts an instance reasoning result for all reasoning operations.
     * 
     * @param adapter the adapter instance
     * @param cfg the configuration to use
     * @param rConfig the reasoner configuration to user
     * @param observer the progress observer to use
     * @param hint the hinting reasoner
     * @param useInstance whether instance reasoning is expected
     */
    private void assertInstance(ReasonerAdapter adapter, Configuration cfg, ReasonerConfiguration rConfig, 
        ProgressObserver observer, FakeReasoner hint, boolean useInstance) {
        assertInstance(adapter.propagate(cfg, rConfig, observer), hint, ResultType.PROPAGATE, useInstance);
        assertInstance(adapter.check(cfg, rConfig, observer), hint, ResultType.CHECK, useInstance);
        assertInstance(adapter.isConsistent(cfg, rConfig, observer), hint, ResultType.IS_CONSISTENT, useInstance);
        List<Constraint> constraints = new ArrayList<Constraint>();
        assertInstance(adapter.evaluate(cfg, constraints, rConfig, observer), hint, useInstance);
    }

    // checkstyle: resume parameter number check

    /**
     * Asserts a normal reasoning result.
     * 
     * @param result the actual result
     * @param hint the hinting reasoner
     * @param resultType the type of result/operation we are asserting for
     * @param useInstance whether instance reasoning is expected
     */
    private void assertNormal(ReasoningResult result, FakeReasoner hint, ResultType resultType, boolean useInstance) {
        assertReasoningResult(hint, resultType, result);
    }

    /**
     * Asserts a normal evaluation result.
     * 
     * @param result the actual result
     * @param hint the hinting reasoner
     * @param useInstance whether instance reasoning is expected
     */
    private void assertNormal(EvaluationResult result, FakeReasoner hint, boolean useInstance) {
        assertEvaluationResult(hint, result);
    }

    /**
     * Asserts an instance reasoning result.
     * 
     * @param result the actual result
     * @param hint the hinting reasoner
     * @param resultType the type of result/operation we are asserting for
     * @param useInstance whether instance reasoning is expected
     */
    private void assertInstance(ReasoningResult result, FakeReasoner hint, ResultType resultType, boolean useInstance) {
        if (useInstance && hint == fri) {
            assertReasoningResult(fri.getExpectedPropagationInstanceResult(resultType), result);
        } else {
            assertReasoningResult(hint, resultType, result);
        }
    }

    /**
     * Asserts an instance evaluation result.
     * 
     * @param result the actual result
     * @param hint the hinting reasoner
     * @param useInstance whether instance reasoning is expected
     */
    private void assertInstance(EvaluationResult result, FakeReasoner hint, boolean useInstance) {
        if (useInstance && hint == fri) {
            assertEvaluationResult(fri.getExpectedEvaluationInstanceResult(), result);
        } else {
            assertEvaluationResult(hint, result);
        }
    }

}
