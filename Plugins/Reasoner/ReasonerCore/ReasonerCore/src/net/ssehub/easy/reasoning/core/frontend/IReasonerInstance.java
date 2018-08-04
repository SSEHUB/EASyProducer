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

import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerMessage;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

/**
 * A reuseable reasoner instance. Project, configuration and reasoner configuration are
 * fixed for this instance. The reasoner may operate sequentially or in parallel. A specific
 * reasoner must not offer/create reasoner instances. The underlying model is assumed to
 * have no structural changes between two subsequent reasonings.
 * 
 * @author Holger Eichelberger
 */
public interface IReasonerInstance {

    /**
     * Returns a descriptor stating common information about this reasoner.
     * 
     * @return the descriptor
     */
    public ReasonerDescriptor getDescriptor();

    /**
     * Checks whether a given variability model (project) is satisfiable.
     * 
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult isConsistent(ProgressObserver observer);

    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * 
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult check(ProgressObserver observer);

    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult propagate(ProgressObserver observer);

    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid in the
     * context of the given project and configuration.
     * 
     * @param constraints
     *            the constraints (expressions which evaluate to a boolean value)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public EvaluationResult evaluate(List<Constraint> constraints, ProgressObserver observer);

    /**
     * Is called when a reasoner message is issued.
     * 
     * @param message
     *            the message sent
     */
    public void notify(IReasonerMessage message);

    /**
     * Returns whether the reasoner is (still) operating.
     * 
     * @return <code>true</code> for operating, <code>false</code> else
     */
    public boolean isRunning();

    /**
     * Stops/terminates reasoning. If possible, a reasoner shall stop the reasoning
     * operations as quick as possible. A reasoner must not implement this operation.
     * 
     * @return <code>true</code> if the reasoner tries to stop, <code>false</code> else 
     *     (operation not implemented)
     *     
     * @see ReasoningResult#setStopped(boolean)
     */
    public boolean stop();
    
    /**
     * Returns the project this instance is attached to.
     * 
     * @return the project
     */
    public Project getProject();
    
    /**
     * Returns the reasoner configuration this project is running with.
     * 
     * @return the reasoner configuration
     */
    public ReasonerConfiguration getReasonerConfiguration();
    
}
