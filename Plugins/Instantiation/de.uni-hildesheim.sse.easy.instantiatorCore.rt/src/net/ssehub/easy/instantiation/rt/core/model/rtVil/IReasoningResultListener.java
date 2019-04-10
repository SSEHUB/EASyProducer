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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.basics.messages.Status;

/**
 * A listener allowing to observe the filtered/processed reasoning messages from the perspective of rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public interface IReasoningResultListener {
    
    /**
     * Informs the listener about the direct result after reasoning without filtering the result.
     * 
     * @param result the result (must not be modified)
     */
    public void notifyReasoningResult(ReasoningResult result);

    /**
     * Informs the listener about a relevant (not filtered out) reasoning message.
     * 
     * @param msg the message
     * @param status the considered message status (may differ from the status in the message)
     */
    public void notifyMessage(Message msg, Status status);
    
    /**
     * Informs the listener about the final assessment result from the perspective of rt-VIL, i.e., 
     * whether the filtered reasoning result was considered to be ok or not.
     * 
     * @param result whether the filtered reasoning result was considered to be ok or not
     */
    public void notifyAssessmentResult(boolean result);
}
