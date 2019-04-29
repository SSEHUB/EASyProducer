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

import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.DelegatingReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements a fake instance-based reasoner with explicit propagation result for the instance-based reasoning. 
 * The instances are based on an extended {@link DelegatingReasonerInstance}.
 * 
 * @author Holger Eichelberger
 */
public class FakeExplicitInstanceReasoner extends FakeInstanceReasoner {

    private Map<ResultType, ReasoningResult> iResults;
    private EvaluationResult ieResult;
    
    /**
     * An extended delegation instance faking the propagation result.
     * 
     * @author Holger Eichelberger
     */
    private class FakeDelegatingReasonerInstance extends DelegatingReasonerInstance {

        /**
         * Creates a delegating reasoner instance.
         * 
         * @param project the project to reason bound to this instance
         * @param config the configuration to reason bound to this instance
         * @param rConfig the reasoner configuration
         * @param delegate the delegate
         */
        public FakeDelegatingReasonerInstance(Project project, Configuration config, ReasonerConfiguration rConfig,
            IReasoner delegate) {
            super(project, config, rConfig, delegate);
        }
        
        @Override
        public ReasoningResult propagate(ProgressObserver observer) {
            return getExpectedPropagationInstanceResult(ResultType.PROPAGATE);
        }
        
        @Override
        public ReasoningResult isConsistent(ProgressObserver observer) {
            return getExpectedPropagationInstanceResult(ResultType.IS_CONSISTENT);
        }

        @Override
        public EvaluationResult evaluate(List<Constraint> constraints, ProgressObserver observer) {
            return getExpectedEvaluationInstanceResult();
        }
        
        @Override
        public ReasoningResult check(ProgressObserver observer) {
            return getExpectedPropagationInstanceResult(ResultType.CHECK);
        }
        
    }
    
    /**
     * Creates a fake reasoner.
     * 
     * @param descriptor the reasoner descriptor
     * @param results the results
     * @param eResult the evaluation result
     * @see FakeExplicitInstanceReasoner#setInstanceResults(Map, EvaluationResult)
     */
    public FakeExplicitInstanceReasoner(ReasonerDescriptor descriptor, Map<ResultType, ReasoningResult> results,
        EvaluationResult eResult) {
        super(descriptor, results, eResult);
    }
    
    /**
     * Sets the instance reasoning results overriding the results given in the constructor.
     * 
     * @param iResults the results
     * @param ieResult the evaluation result
     */
    public void setInstanceResults(Map<ResultType, ReasoningResult> iResults, EvaluationResult ieResult) {
        this.iResults = iResults;
        this.ieResult = ieResult;
    }
    
    @Override
    public IReasonerInstance createInstance(Project project, Configuration cfg,
        ReasonerConfiguration reasonerConfiguration) {
        return new FakeDelegatingReasonerInstance(project, cfg, reasonerConfiguration, this);
    }
    
    /**
     * Returns the explicit result for propagation in instance-based reasoning. Takes the general one from 
     * {@link #getExpectedPropagationInstanceResult(ResultType)} if none was defined in this instance.
     * 
     * @param resultType the result type
     * @return the result
     */
    ReasoningResult getExpectedPropagationInstanceResult(ResultType resultType) {
        ReasoningResult result = null;
        if (null != iResults) {
            result = iResults.get(resultType);
        }
        if (null == result) {
            result = getExpectedReasoningResult(resultType);
        }
        return result;
    }
    
    /**
     * Returns the expected evaluation instance result. Takes the general one from 
     * {@link #getExpectedEvaluationResult()} if none was defined in this instance.
     * 
     * @return the result
     */
    EvaluationResult getExpectedEvaluationInstanceResult() {
        EvaluationResult result = ieResult;
        if (null == result) {
            result = getExpectedEvaluationResult();
        }
        return result;
    }

}
