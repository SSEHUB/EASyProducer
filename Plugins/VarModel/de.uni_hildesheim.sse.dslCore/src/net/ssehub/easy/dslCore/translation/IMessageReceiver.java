/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.messages.IMessage;

/**
 * The fundamental interface of a message receiver based on EObjects and EStructuralFeatures
 * for xText grammars.
 * 
 * @author Holger Eichelberger
 */
public interface IMessageReceiver {

    /**
     * Receives an error message.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     * @param code
     *            a numerical identification of the error
     */
    public void error(String message, EObject cause,  EStructuralFeature causeFeature, int code);

    /**
     * Receives a warning message.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     * @param code
     *            a numerical identification of the warning
     */
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code);
    
    /**
     * Receives an EASy message. This allows re-directing the message while keeping the relation to the original
     * one, e.g., for cleaning up messages.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     * @param code
     *            a numerical identification of the error
     */
    public void collect(IMessage message, EObject cause,  EStructuralFeature causeFeature, int code);

}
