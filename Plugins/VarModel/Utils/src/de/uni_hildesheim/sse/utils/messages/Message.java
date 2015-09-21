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
package de.uni_hildesheim.sse.utils.messages;

import java.util.List;


/**
 * Defines a message to be emitted during runtime. 
 * 
 * @author Holger Eichelberger
 */
public class Message implements IMessage {
    private String description;
    private Status status;
    
    /**
     * Creates a message.
     * 
     * @param description the message description
     * @param status the status of the message
     */
    public Message(String description, Status status) {
        this.description = description;
        this.status = status;
    }
    
    /**
     * Returns the message description.
     * 
     * @return the message description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the status of this message.
     * 
     * @return the status of this message
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Utility method returning whether there is an error message in the given <code>messages</code>.
     * 
     * @param messages the messages (may be <b>null</b>)
     * @return <code>true</code> if there is an error, <code>false</code> else
     */
    public static boolean containsError(List<Message> messages) {
        boolean hasError = false;
        if (null != messages) {
            for (int m = 0; !hasError && m < messages.size(); m++) {
                hasError = Status.ERROR == messages.get(m).getStatus();
            }
        }
        return hasError;
    }

    /**
     * Utility method returning a string representation of a given set of <code>messages</code>.
     * 
     * @param messages the messages (may be <b>null</b>)
     * @param filter just messages of the given status shall be returned (<b>null</b> for all)
     * @return the string representation
     */
    public static String toString(List<Message> messages, Status filter) {
        StringBuilder result = new StringBuilder();
        if (null != messages) {
            int count = 0;
            for (int m = 0; m < messages.size(); m++) {
                Message msg = messages.get(m);
                if (null == filter || filter == msg.getStatus()) {
                    if (count > 0) {
                        result.append(", ");
                    }
                    result.append(msg.getStatus());
                    result.append(":");
                    result.append(msg.getDescription());
                }
            }
        }
        return result.toString();
    }
    
}

