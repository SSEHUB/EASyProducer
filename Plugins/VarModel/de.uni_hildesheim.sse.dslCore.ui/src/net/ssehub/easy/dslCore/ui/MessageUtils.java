/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore.ui;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;
import org.eclipse.xtext.validation.Issue;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.dslCore.BundleId;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.dslCore.translation.MessageReceiver;
import net.ssehub.easy.dslCore.validation.ValidationUtils;

/**
 * Generic message utilities.
 * 
 * @author Holger Eichelberger
 */
public class MessageUtils {
    
    public static final Logger LOG = Logger.getLogger(MessageUtils.class);

    /**
     * Processes the messages in {@code result} to be attached to the given resource {@code res}.
     *
     * @param <R> the result type
     * @param res the resource
     * @param result the translation result
     * @throws CoreException in case of marker processing problems
     */
    public static <R> void processMessages(IResource res, TranslationResult<R> result) throws CoreException {
        processMessages(res, result.getReceiver());
    }

    /**
     * Processes the messages to be attached to the given resource {@code res}.
     * 
     * @param res the resource
     * @param messages the messages
     * @throws CoreException in case of marker processing problems
     */
    public static void processMessagesQuiet(IResource res, MessageReceiver messages) {
        try {
            processMessages(res, messages);
        } catch (CoreException e) {
            EASyLoggerFactory.INSTANCE.getLogger(MessageUtils.class, BundleId.ID).error(e.getMessage());
        }
    }
    
    /**
     * Processes the messages to be attached to the given resource {@code res}.
     * 
     * @param res the resource
     * @param messages the messages
     * @throws CoreException in case of marker processing problems
     */
    public static void processMessages(IResource res, MessageReceiver messages) throws CoreException {
        res.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ZERO);
        DiagnosticConverterImpl conv = new DiagnosticConverterImpl();
        final MarkerCreator markerCreator = new MarkerCreator();
        for (int m = 0; m < messages.getMessageCount(); m++) {
            Message message = messages.getMessage(m);
            LOG.info("MSG: " + message.getStatus() + " " + message.getDescription());
            conv.convertValidatorDiagnostic(ValidationUtils.processMessage(message), new IAcceptor<Issue>() {
                
                @Override
                public void accept(Issue issue) {
                    try {
                        markerCreator.createMarker(issue, res, IMarker.PROBLEM);
                    } catch (CoreException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), BundleId.ID).exception(e);
                    }
                }
            });
        }
    }

}
