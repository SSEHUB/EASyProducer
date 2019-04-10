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

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;

/**
 * Empty implementation of {@link IReasoningResultListener}.
 * 
 * @author Holger Eichelberger
 */
public class DefaultReasoningResultListener implements IReasoningResultListener {

    public static final IReasoningResultListener INSTANCE = new DefaultReasoningResultListener();
    
    @Override
    public void notifyReasoningResult(ReasoningResult result) {
    }

    @Override
    public void notifyMessage(Message msg, Status status) {
    }

    @Override
    public void notifyAssessmentResult(boolean result) {
    }

}
