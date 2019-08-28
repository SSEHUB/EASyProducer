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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Abstracts over instance-based and full reasoning. Configuration instances registered
 * with this adaptor/cache lead to instance-based reasoning, others are subject to full reasoning.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerAdapter {

    private static Map<Thread, ReasonerAdapter> instances = new HashMap<Thread, ReasonerAdapter>();
    private Map<Configuration, IReasonerAdapter> cache = new HashMap<Configuration, IReasonerAdapter>();
    private IReasonerAdapter deflt;
    private boolean enableInstanceBasedReasoning;
    
    /**
     * Defines the interface of an abstracting reasoner adapter.
     * 
     * @author Holger Eichelberger
     */
    private interface IReasonerAdapter {
        
        /**
         * Checks whether a given variability model (project) is satisfiable.
         * 
         * @param cfg The configuration to reason on.
         * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
         * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
         *        may be <b>null</b>)
         * @return The result of this reasoning step. Can have the status
         *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
         *     this operation.
         */
        public ReasoningResult isConsistent(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
                ProgressObserver observer);

        /**
         * Checks the configuration according to the given project structure and does not affect the configuration.
         * 
         * @param cfg The configuration to reason on.
         * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
         *        may be <b>null</b>)                   
         * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
         * @return The result of this reasoning step. Can have the status
         *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
         *     this operation.
         */
        public ReasoningResult check(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
             ProgressObserver observer);
        
        /**
         * Checks the configuration according to the given model and propagates values, if possible.
         * 
         * @param cfg The configuration to reason on (may be modified as a side effect
         *            of value propagation)
         * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
         *        may be <b>null</b>)                   
         * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
         * @return The result of this reasoning step. Can have the status
         *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
         *     this operation.
         */
        public ReasoningResult propagate(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
            ProgressObserver observer);
        
        /**
         * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid 
         * in the context of the given project and configuration.
         * 
         * @param cfg The configuration to reason on.
         * @param constraints
         *            the constraints (expressions which evaluate to a boolean value)
         * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
         *        may be <b>null</b>)
         * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
         * @return The result of this reasoning step. Can have the status
         *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
         *     this operation.
         */
        public EvaluationResult evaluate(Configuration cfg, List<Constraint> constraints, 
            ReasonerConfiguration reasonerConfiguration, ProgressObserver observer);

        /**
         * Creates the value for a certain IVML type/variable.
         * 
         * @param cfg the configuration to operate on (will not be modified)
         * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
         *     additional constraints)
         * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
         * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
         *        may be <b>null</b>)
         * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
         * @return the value creation result
         */
        public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type, 
            ReasonerConfiguration reasonerConfiguration, ProgressObserver observer);
        
    }

    /**
     * Implements a full/fallback reasoner adapter.
     * 
     * @author Holger Eichelberger
     */
    private class FrontendReasonerAdapter implements IReasonerAdapter {
        
        @Override
        public ReasoningResult propagate(Configuration cfg, ReasonerConfiguration rConfig, 
            ProgressObserver observer) {
            return ReasonerFrontend.getInstance().propagate(cfg.getProject(), cfg, rConfig, observer);
        }

        @Override
        public ReasoningResult isConsistent(Configuration cfg, ReasonerConfiguration reasonerConfiguration,
            ProgressObserver observer) {
            return ReasonerFrontend.getInstance().isConsistent(cfg.getProject(), reasonerConfiguration, observer);
        }

        @Override
        public ReasoningResult check(Configuration cfg, ReasonerConfiguration reasonerConfiguration,
            ProgressObserver observer) {
            return ReasonerFrontend.getInstance().check(cfg.getProject(), cfg, reasonerConfiguration, observer);
        }

        @Override
        public EvaluationResult evaluate(Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
            return ReasonerFrontend.getInstance().evaluate(cfg, constraints, reasonerConfiguration, observer);
        }

        @Override
        public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type,
                ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
            return ReasonerFrontend.getInstance().createValue(cfg, var, type, reasonerConfiguration, observer);
        }
        
    }
    
    /**
     * Implements an instance-based reasoner adapter.
     * 
     * @author Holger Eichelberger
     */
    private class InstanceReasonerAdapter implements IReasonerAdapter {
        
        private IReasonerInstance instance;
        
        /**
         * Creates a new instance reasoner adapter .
         * 
         * @param instance the reasoner instance
         */
        private InstanceReasonerAdapter(IReasonerInstance instance) {
            this.instance = instance;
        }
        
        @Override
        public ReasoningResult propagate(Configuration config, ReasonerConfiguration rConfig, 
            ProgressObserver observer) {
            return instance.propagate(observer);
        }

        @Override
        public ReasoningResult isConsistent(Configuration cfg, ReasonerConfiguration reasonerConfiguration,
            ProgressObserver observer) {
            return instance.isConsistent(observer);
        }

        @Override
        public ReasoningResult check(Configuration cfg, ReasonerConfiguration reasonerConfiguration,
            ProgressObserver observer) {
            return instance.check(observer);
        }

        @Override
        public EvaluationResult evaluate(Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
            return instance.evaluate(constraints, observer);
        }

        @Override
        public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type,
                ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
            return instance.createValue(var, type, observer);
        }
        
    }
    
    /**
     * Creates a reasoning adapter cache with instance-based reasoning allowed as default.
     */
    public ReasonerAdapter() {
        this(true);
    }

    /**
     * Creates a reasoning adapter cache.
     * 
     * @param enableInstanceBasedReasoning whether instance-based reasoning shall be allowed
     */
    public ReasonerAdapter(boolean enableInstanceBasedReasoning) {
        // deflt lazy
        setEnableInstanceBasedReasoning(enableInstanceBasedReasoning);
    }

    /**
     * Returns the adapter for the given configuration.
     * 
     * @param cfg The configuration to reason on.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return the adapter instance
     */
    private IReasonerAdapter getAdapter(Configuration cfg, ReasonerConfiguration reasonerConfiguration) {
        IReasonerAdapter adapter = cache.get(cfg);
        if (null == adapter) {
            if (enableInstanceBasedReasoning && cache.containsKey(cfg)) { // is marked for creating an instance
                IReasonerInstance instance = ReasonerFrontend.getInstance().createInstance(cfg, reasonerConfiguration);
                if (null != instance) {
                    adapter = new InstanceReasonerAdapter(instance);
                    cache.put(cfg, adapter);
                }
            }
            if (null == adapter) {
                if (null == deflt) {
                    deflt = new FrontendReasonerAdapter();
                }
                adapter = deflt;
            }
        }
        return adapter;
    }

    /**
     * Checks whether a given variability model (project) is satisfiable.
     * 
     * @param cfg The configuration to reason on.
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult isConsistent(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        return getAdapter(cfg, reasonerConfiguration).isConsistent(cfg, reasonerConfiguration, observer);
    }

    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * 
     * @param cfg The configuration to reason on.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult check(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        return getAdapter(cfg, reasonerConfiguration).check(cfg, reasonerConfiguration, observer);
    }
    
    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param cfg The configuration to reason on (may be modified as a side effect
     *        of value propagation)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult propagate(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        return getAdapter(cfg, reasonerConfiguration).propagate(cfg, reasonerConfiguration, observer);
    }
    
    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid 
     * in the context of the given project and configuration.
     * 
     * @param cfg The configuration to reason on.
     * @param constraints the constraints (expressions which evaluate to a boolean value)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public EvaluationResult evaluate(Configuration cfg, List<Constraint> constraints, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer)  {
        return getAdapter(cfg, reasonerConfiguration).evaluate(cfg, constraints, reasonerConfiguration, observer);
    }

    /**
     * Creates the value for a certain IVML type/variable.
     * 
     * @param cfg the configuration to operate on (will not be modified)
     * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
     *     additional constraints)
     * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return the value creation result
     */
    public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        return getAdapter(cfg, reasonerConfiguration).createValue(cfg, var, type, reasonerConfiguration, observer);
    }

    /**
     * Defines whether instance-based reasoning shall be allowed/supported. Please reset already registered
     * configurations if needed.
     * 
     * @param enableInstanceBasedReasoning whether instance-based reasoning shall be allowed
     */
    public void setEnableInstanceBasedReasoning(boolean enableInstanceBasedReasoning) {
        this.enableInstanceBasedReasoning = enableInstanceBasedReasoning;
    }
    
    /**
     * Clears all cache entries.
     */
    public void clear() {
        cache.clear();
    }
    
    /**
     * Clears the cache entry for {@code config} if one was registered.
     * 
     * @param config the configuration to prepare for (ignored if <b>null</b>)
     */
    public void clear(Configuration config) {
        if (null != config) {
            cache.remove(config);
        }
    }

    /**
     * Registers for a reasoning adapter (cache entry) for {@code config} for instance-based reasoning.
     * Already registered configurations are not re-registered.
     * 
     * @param config the configuration to prepare for (ignored if <b>null</b>)
     */
    public void register(Configuration config) {
        if (null != config && !cache.containsKey(config)) {
            cache.put(config, null); // yes, just mark that we want to have an instance-based reasoner later
        }
    }

    /**
     * Registers an instance for the current thread.
     * 
     * @param adapter the adapter instance to register
     */
    public static void registerInstance(ReasonerAdapter adapter) {
        instances.put(Thread.currentThread(), adapter);
    }
    
    /**
     * Unregisters an instance for the current thread.
     */
    public static void unregisterInstance() {
        instances.remove(Thread.currentThread());
    }
    
    /**
     * Returns the registered instance for the current thread.
     * 
     * @return the registered instance, <b>null</b> for none
     */
    public static ReasonerAdapter getInstance() {
        return instances.get(Thread.currentThread());
    }

    /**
     * Returns the registered instance for the current thread.
     * 
     * @return the registered instance, <b>null</b> for none
     */
    public static ReasonerAdapter getInstanceSafe() {
        ReasonerAdapter result = instances.get(Thread.currentThread());
        if (null == result) {
            result = new ReasonerAdapter(false);
        }
        return result;
    }

}
