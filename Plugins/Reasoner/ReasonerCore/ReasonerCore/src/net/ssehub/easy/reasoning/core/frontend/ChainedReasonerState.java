/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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

import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Helper class implementing a chained reasoner state. Can be used for a hybrid reasoner to signal
 * that we are in chained reasoning. This state has both, reasoning and evaluation result. The one to 
 * use is determined by the reasoning calls to the reasoner chain.
 * 
 * @author Holger Eichelberger
 */
public class ChainedReasonerState {

    private Configuration config;
    private ReasoningResult reasoningResult;
    private EvaluationResult evaluationResult;

    /**
     * Creates a reasoner state.
     * 
     * @param config the configuration to reason on (instead of the one passed in through the usual methods)
     * @param reasoningResult the reasoning result of the last reasoner step (may be <b>null</b> for the 
     * first reasoner in a chain)
     */
    public ChainedReasonerState(Configuration config, ReasoningResult reasoningResult) {
        this.config = config;
        this.reasoningResult = reasoningResult;
    }

    /**
     * Creates a reasoner state.
     * 
     * @param config the configuration to reason on (instead of the one passed in through the usual methods)
     * @param evaluationResult the evaluation result of the last reasoner step (may be <b>null</b> for the 
     * first reasoner in a chain)
     */
    public ChainedReasonerState(Configuration config, EvaluationResult evaluationResult) {
        this.config = config;
        this.evaluationResult = evaluationResult;
    }
    
    /**
     * Returns the last configuration to be passed on.
     * 
     * @return the last configuration
     */
    public Configuration getLastConfiguration() {
        return config;
    }

    /**
     * Returns the last reasoning result to be passed on and considered.
     * 
     * @return the last reasoning result (may be <b>null</b> for the first reasoner in a chain)
     */
    public ReasoningResult getLastReasoningResult() {
        return reasoningResult;
    }

    /**
     * Returns the last evaluation result to be passed on and considered.
     * 
     * @return the last evaluation result (may be <b>null</b> for the first reasoner in a chain)
     */
    public EvaluationResult getLastEvaluationResult() {
        return evaluationResult;
    }

}
