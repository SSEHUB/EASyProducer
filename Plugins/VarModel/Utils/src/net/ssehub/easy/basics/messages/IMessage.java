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
package net.ssehub.easy.basics.messages;

/**
 * Defines a message.
 * 
 * @author Holger Eichelberger
 */
public interface IMessage {

    /**
     * Returns the message description.
     * 
     * @return the message description
     */
    public String getDescription();

    /**
     * Returns a detailed message description (if available) or {@link #getDescription()}. Details may
     * e.g., include file position or line number. As e.g. xText cares for location and position itself, 
     * this information would be superfluous there, but helpful in a command line context, where this
     * method shall be used instead.
     * 
     * @return the (detailed) message description
     */
    public String getDetailedDescription();

    /**
     * Returns the status of this message.
     * 
     * @return the status of this message
     */
    public Status getStatus();
    
}
