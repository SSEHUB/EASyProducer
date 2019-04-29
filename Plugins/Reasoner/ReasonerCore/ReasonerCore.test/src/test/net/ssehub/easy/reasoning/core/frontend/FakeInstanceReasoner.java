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

import java.util.Map;

import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.DelegatingReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IChainingReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements a fake instance-based reasoner. The instances are based on {@link DelegatingReasonerInstance}.
 * 
 * @author Holger Eichelberger
 */
public class FakeInstanceReasoner extends FakeReasoner implements IChainingReasoner {

    private Configuration state;
    
    /**
     * Creates a fake reasoner.
     * 
     * @param descriptor the reasoner descriptor
     * @param results the results
     * @param eResult the evaluation result
     */
    public FakeInstanceReasoner(ReasonerDescriptor descriptor, Map<ResultType, ReasoningResult> results, 
        EvaluationResult eResult) {
        super(descriptor, results, eResult);
    }

    @Override
    public IReasonerInstance createInstance(Project project, Configuration cfg,
        ReasonerConfiguration reasonerConfiguration) {
        return new DelegatingReasonerInstance(project, cfg, reasonerConfiguration, this);
    }

    @Override
    public void setState(Configuration config, ReasoningResult result) {
        this.state = config;
    }

    @Override
    public void setState(Configuration config, EvaluationResult result) {
        this.state = config;
    }

    @Override
    public Configuration getLastConfiguration() {
        return state;
    }

    @Override
    boolean providesInstance() {
        return true;
    }


}
