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
package net.ssehub.easy.reasoning.core.reasoner;

import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Provides a default implementation for reasoner instances by delegating the
 * respective calls to a given delegate reasoner. Use this class to simplify
 * calls for {@link IReasoner#createInstance(Configuration, ReasonerConfiguration)},
 * i.e., to avoid null pointer returns.
 * 
 * @author Holger Eichelberger
 */
public class DelegatingReasonerInstance implements IReasonerInstance {

    private IReasoner delegate;
    private Configuration config;
    private ReasonerConfiguration rConfig;
    private boolean isRunning;

    /**
     * Creates a delegating reasoner instance.
     * 
     * @param config the configuration to reason bound to this instance
     * @param rConfig the reasoner configuration
     * @param delegate the delegate
     */
    public DelegatingReasonerInstance(Configuration config, ReasonerConfiguration rConfig, 
        IReasoner delegate) {
        this.config = config;
        this.rConfig = rConfig;
        this.delegate = delegate;
    }
    
    @Override
    public ReasonerDescriptor getDescriptor() {
        return delegate.getDescriptor();
    }

    @Override
    public ReasoningResult isConsistent(ProgressObserver observer) {
        ReasoningResult result;
        isRunning = true;
        result = delegate.isConsistent(config.getProject(), rConfig, observer);
        isRunning = false;
        return result;
    }

    @Override
    public ReasoningResult check(ProgressObserver observer) {
        ReasoningResult result;
        isRunning = true;
        result = delegate.check(config, rConfig, observer);
        isRunning = false;
        return result;
    }

    @Override
    public ReasoningResult propagate(ProgressObserver observer) {
        ReasoningResult result;
        isRunning = true;
        result = delegate.propagate(config, rConfig, observer);
        isRunning = false;
        return result;
    }

    @Override
    public EvaluationResult evaluate(List<Constraint> constraints, ProgressObserver observer) {
        EvaluationResult result;
        isRunning = true;
        result = delegate.evaluate(config, constraints, rConfig, observer);
        isRunning = false;
        return result;
    }

    @Override
    public ValueCreationResult createValue(AbstractVariable var, IDatatype type, ProgressObserver observer) {
        ValueCreationResult result;
        isRunning = true;
        result = delegate.createValue(config, var, type, rConfig, observer);
        isRunning = false;
        return result;
    }

    @Override
    public void notify(IReasonerMessage message) {
        delegate.notify(message);
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public boolean stop() {
        return false; // indicate that we cannot react on this
    }

    @Override
    public Project getProject() {
        return config.getProject();
    }

    @Override
    public ReasonerConfiguration getReasonerConfiguration() {
        return rConfig;
    }

}
