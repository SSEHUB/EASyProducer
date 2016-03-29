/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.reasonerCore.reasoner.Message;

/**
 * Provides a neutral reasoning hook implementation, i.e., a hook that does not influencing the 
 * reasoning result.
 * 
 * @author Holger Eichelberger
 */
public class ReasoningHookAdapter implements IReasoningHook {
    
    @Override
    public void preReasoning(Script script, IRtVilConcept concept, IRtValueAccess values, Configuration config) {
        // do nothing
    }

    @Override
    public Status analyze(Script script, IRtVilConcept concept, IRtValueAccess values, Message message) {
        return message.getStatus();
    }

    @Override
    public void postReasoning(Script script, IRtVilConcept concept, IRtValueAccess values, Configuration config) {
        // do nothing
    }

    /**
     * Turns a message into readable text. [convenience]
     * 
     * @param msg the message to be turned into text
     * @return the description text
     * @see RtVilExecution#toText(Message)
     */
    protected String toText(Message msg) {
        return RtVilExecution.toText(msg);
    }
    
}
