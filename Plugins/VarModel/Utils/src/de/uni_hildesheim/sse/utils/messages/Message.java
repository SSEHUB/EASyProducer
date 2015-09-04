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
    
}

