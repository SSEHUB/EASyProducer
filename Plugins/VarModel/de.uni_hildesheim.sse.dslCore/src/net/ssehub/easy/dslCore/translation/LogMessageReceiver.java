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
package net.ssehub.easy.dslCore.translation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IMessage;

/**
 * A simple fallback receiver that does not store messages.
 * 
 * @author Holger Eichelberger
 */
public class LogMessageReceiver extends MessageReceiver {
    
    private EASyLogger logger;
    private URI locationHint;
    
    /**
     * Creates a log message receiver.
     * 
     * @param origin the origin where the messages shall be reported for
     * @param bundleName the bundle name (may be <b>null</b>)
     */
    public LogMessageReceiver(Class<?> origin, String bundleName) {
        logger = EASyLoggerFactory.INSTANCE.getLogger(origin, bundleName);
    }

    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        logger.error(message + " in " + getLocation(null));
    }

    @Override
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        logger.warn(message + " in " + getLocation(null));
    }

    @Override
    public void collect(IMessage message, EObject cause, EStructuralFeature causeFeature, int code) {
    }

    @Override
    public int getMessageCount() {
        return 0;
    }

    @Override
    public int getErrorCount() {
        return 0;
    }

    @Override
    public Message getMessage(int index) {
        return null;
    }

    @Override
    public void error(Diagnostic diagnostic) {
        logger.error(diagnostic.getMessage() + " in " + getLocation(diagnostic) + " line " 
            + diagnostic.getLine() + " col " + diagnostic.getColumn());
    }
    
    /**
     * Returns the location of diagnostic taking the location hint as fallback.
     * 
     * @param diagnostic the diagnostic (may be <b>null</b>)
     * @return the location
     */
    private String getLocation(Diagnostic diagnostic) {
        String location = null == diagnostic ? null : diagnostic.getLocation();
        if (null == location && null != locationHint) {
            location = locationHint.toString();
        }
        return location;
    }

    /**
     * Defines a location hint in case that diagnostics do not carry this information. Reset if not used.
     * 
     * @param locationHint the location hint, may be <b>null</b> for none
     */
    public void setLocationHint(URI locationHint) {
        this.locationHint = locationHint;
    }

    @Override
    public void addMessage(Message msg) {
    }
    
};
