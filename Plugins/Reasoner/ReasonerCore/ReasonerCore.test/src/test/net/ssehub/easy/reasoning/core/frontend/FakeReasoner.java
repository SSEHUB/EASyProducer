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
package test.net.ssehub.easy.reasoning.core.frontend;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerInterceptor;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerMessage;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.capabilities.IReasonerCapability;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements a fake reasoner not creating reasoner instances.
 * 
 * @author Holger Eichelberger
 */
public class FakeReasoner implements IReasoner {

    public static final String FAKE_VERSION = "1.0";
    
    private ReasonerDescriptor descriptor;
    private Map<ResultType, ReasoningResult> results;
    private EvaluationResult eResult;
    private IReasonerMessage message;
    private IReasonerInterceptor interceptor;
    
    /**
     * Various result types.
     * 
     * @author Holger Eichelberger
     */
    public enum ResultType {
        UPGRADE,
        IS_CONSISTENT,
        CHECK,
        INITIALIZE,
        PROPAGATE
    }
    
    /**
     * Creates a fake reasoner.
     * 
     * @param descriptor the reasoner descriptor
     * @param results the results (no result shall be <b>null</b>)
     * @param eResult the evaluation result (shall not be <b>null</b>)
     */
    public FakeReasoner(ReasonerDescriptor descriptor, Map<ResultType, ReasoningResult> results, 
        EvaluationResult eResult) {
        this.descriptor = descriptor;
        this.results = results;
        this.eResult = eResult;
    }
    
    /**
     * A fake descriptor.
     * 
     * @author Holger Eichelberger
     */
    protected static class FakeReasonerDescriptor extends ReasonerDescriptor {

        /**
         * Creates a new reasoner descriptor.
         * 
         * @param name
         *            the name of the reasoner
         * @param version
         *            a version description of the integrated reasoner (may be <b>null</b>)
         * @param license
         *            the license (may be <b>null</b>)
         * @param licenseRestriction
         *            a restriction of the license to be displayed, e.g. "valid until March 2020" (may be <b>null</b>)
         * @param downloadSource
         *            the source for downloading a licensed version (may be <b>null</b> if the implementation 
         *            is complete)
         */
        public FakeReasonerDescriptor(String name, String version, String license, String licenseRestriction,
            URL downloadSource) {
            super(name, version, license, licenseRestriction, downloadSource);
        }
        
        /**
         * Adds a capability.
         * 
         * @param cap the capability to add (<b>null</b> is ignored)
         */
        void addCap(IReasonerCapability cap) {
            addCapability(cap);
        }

        /**
         * Adds a capabilities.
         * 
         * @param cap the capabilities to add (<b>null</b> is ignored)
         */
        void addCaps(Collection<IReasonerCapability> cap) {
            addCapabilities(cap);
        }
        
    }
    
    /**
     * Creates a default descriptor.
     * 
     * @param name the reasoner name
     * @param capabilities the specific reasoner capabilities
     * @return the descriptor
     */
    public static ReasonerDescriptor createDefaultDescriptor(String name, IReasonerCapability... capabilities) {
        FakeReasonerDescriptor result = new FakeReasonerDescriptor(name, FAKE_VERSION, "NO LICENSE", null, null);
        List<IReasonerCapability> caps = new ArrayList<IReasonerCapability>();
        for (IReasonerCapability c : capabilities) {
            result.addCap(c);
            caps.add(c);
        }
        result.addCaps(caps); // no effect, just for testing
        return result;
    }

    /**
     * Creates a set of default reasoning results. Per default, reasoning results are just created using the
     * default constructor.
     * 
     * @param override overrides the default result, given in the ordinal sequence of {@link ResultType}; may have more 
     *     or less entries - irrelevant or null entries are ignored
     * @return the reasoning results
     */
    public static Map<ResultType, ReasoningResult> createDefaultResults(ReasoningResult... override) {
        Map<ResultType, ReasoningResult> results = new HashMap<ResultType, ReasoningResult>();
        determineResult(results, ResultType.UPGRADE, override);
        determineResult(results, ResultType.IS_CONSISTENT, override);
        determineResult(results, ResultType.CHECK, override);
        determineResult(results, ResultType.INITIALIZE, override);
        determineResult(results, ResultType.PROPAGATE, override);
        return results;
    }
    
    /**
     * Determines an individual reasoning result.
     * 
     * @param results the results map to modify as a side effect
     * @param type the result type to modify
     * @param override overrides the default result, given in the ordinal sequence of {@link ResultType}; may have more 
     *     or less entries - irrelevant or null entries are ignored
     */
    private static void determineResult(Map<ResultType, ReasoningResult> results, ResultType type, 
        ReasoningResult[] override) {
        ReasoningResult res = null;
        if (override.length > type.ordinal()) {
            res = override[type.ordinal()];
        }
        if (null == res) {
            res = new ReasoningResult();
        }
        results.put(type, res);
    }

    /**
     * Creates a set of default evaluation result.
     * 
     * @return the default evaluation result
     */
    public static EvaluationResult createDefaultEvaluationResult() {
        return new EvaluationResult();
    }

    @Override
    public ReasonerDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public ReasoningResult upgrade(URI url, ProgressObserver observer) {
        return results.get(ResultType.UPGRADE);
    }

    @Override
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        return results.get(ResultType.IS_CONSISTENT);
    }

    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        return results.get(ResultType.CHECK);
    }

    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        return results.get(ResultType.PROPAGATE);
    }

    @Override
    public ReasoningResult initialize(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer) {
        return results.get(ResultType.INITIALIZE);
    }

    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        return eResult;
    }

    @Override
    public void notify(IReasonerMessage message) {
        this.message = message;
    }

    /**
     * Returns the last message and clears the last message.
     * 
     * @return may be <b>null</b>
     */
    public IReasonerMessage getLastMessage() {
        IReasonerMessage result = message;
        message = null;
        return result;
    }

    @Override
    public IReasonerInstance createInstance(Project project, Configuration cfg,
        ReasonerConfiguration reasonerConfiguration) {
        return null;
    }

    @Override
    public void setInterceptor(IReasonerInterceptor interceptor) {
        this.interceptor = interceptor;
    }
    
    /**
     * Returns the reasoning interceptor.
     * 
     * @return the interceptor
     */
    public IReasonerInterceptor getInterceptor() {
        return interceptor;
    }

    /**
     * Returns the expected reasoning result (for the immediate preceding reasoning operation).
     * 
     * @param resultType the result type
     * @return the reasoning result (shall not be <b>null</b>)
     */
    ReasoningResult getExpectedReasoningResult(ResultType resultType) {
        return results.get(resultType);
    }

    /**
     * Returns the expected evaluation result (for the immediate preceding evaluation operation).
     * 
     * @return the evaluation result (shall not be <b>null</b>)
     */
    EvaluationResult getExpectedEvaluationResult() {
        return eResult;
    }
    
    /**
     * Returns whether this reasoner provides an instance.
     * 
     * @return {@code true} for instance, {@code false} else
     */
    boolean providesInstance() {
        return false;
    }

}
