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
package de.uni_hildesheim.sse.model.cstEvaluation;

import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Some basic functionality required by the evaluators without exposing the {@link EvaluationVisitor}.
 *   
 * @author Holger Eichelberger
 */
public abstract class EvaluationContext {
    
    /**
     * Returns whether values shall be assigned, i.e., the configuration may be changed.
     * 
     * @return <code>true</code> if values shall be assigned, <code>false</code> else
     */
    public abstract boolean allowAssignValues();
    
    /**
     * Notifies the change listener, i.e., the value of <code>variable</code> has changed.
     * 
     * @param variable the changed variable
     */
    public abstract void notifyChangeListener(IDecisionVariable variable);

    /**
     * Returns the decision for the given <code>variable</code>.
     * 
     * @param variable the variable to return the decision for
     * @return the configured decision or <b>null</b> if the decision does not exist
     */
    public abstract IDecisionVariable getDecision(AbstractVariable variable);
    
    /**
     * Adds an evaluation message.
     * 
     * @param message the message to be added
     */
    public abstract void addMessage(Message message);

    /**
     * Returns the target state of the evaluation.
     * 
     * @param state the state of the variable before assignment
     * @return the target state (may be <b>null</b> if the actual value cannot be 
     *   assigned do to a state conflict)
     */
    public abstract IAssignmentState getTargetState(IAssignmentState state);
    
    /**
     * Adds an evaluation error message.
     * 
     * @param message the message to be added
     */
    public void addErrorMessage(String message) {
        addMessage(new Message(message, Status.ERROR));
    }

    /**
     * Adds an evaluation error message based on a throwable.
     * 
     * @param throwable the throwable carrying the message
     */
    public void addErrorMessage(Throwable throwable) {
        addErrorMessage(throwable.getMessage());
    }
    
    /**
     * Returns all instances of <code>type</code>.
     *  
     * @param type the type to return the instances for
     * @return all instances of type (may be <b>null</b> if this is not possible, e.g., in case of Integer)
     */
    public abstract Value getAllInstances(IDatatype type);

}
