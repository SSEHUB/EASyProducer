/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.impl;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Some helpful methods for reasoners.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerHelper {

    /**
     * Creates the value for a certain IVML type/variable. This method is intended as a generic fallback. It just uses 
     * the {@link ValueFactory value factory} and does not do any reasoning. 
     * 
     * @param cfg the configuration to operate on (will not be modified)
     * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
     *     additional constraints, takes precedence over {@code type})
     * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return the value creation result
     */
    public static ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type,
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        IDatatype t = null != var ? var.getType() : type;
        List<String> messages = null;
        Value val = null;
        if (null == t) {
            messages = appendMessage(messages, "No variable or type given (null).");
        } else {
            try {
                val = ValueFactory.createValue(t);
            } catch (ValueDoesNotMatchTypeException e) {
                messages = appendMessage(messages, e.getMessage());
            }
        }
        Project p = new Project("*");
        DecisionVariableDeclaration pVar = new DecisionVariableDeclaration("*", type, p);
        IDecisionVariable res = null;
        try {
            pVar.setValue(new ConstantValue(val));
            p.add(pVar);
            Configuration c = new Configuration(p);
            res = c.getDecision(pVar);
        } catch (CSTSemanticException e) {
            appendMessage(messages, e);
        } catch (ValueDoesNotMatchTypeException e) {
            appendMessage(messages, e);
        }
        ValueCreationResult result = new ValueCreationResult(res);
        if (null != messages) {
            for (int m = 0; m < messages.size(); m++) {
                result.addMessage(new Message(messages.get(m), null, Status.ERROR));
            }
        }
        return result;
    }

    /**
     * Appends the message of {@code th} to the list of messages.
     * 
     * @param messages the messages (may be <b>null</b>)
     * @param th the throwable to take the message from
     * @return {@code messages} or a new list
     */
    private static List<String> appendMessage(List<String> messages, Throwable th) {
        return appendMessage(messages, th.getMessage());
    }

    /**
     * Appends a message {@code text} to the list of messages.
     * 
     * @param messages the messages (may be <b>null</b>)
     * @param message the message to append
     * @return {@code messages} or a new list
     */
    private static List<String> appendMessage(List<String> messages, String message) {
        if (null == messages) {
            messages = new ArrayList<String>();
        }
        messages.add(message);
        return messages;
    }
    
}
