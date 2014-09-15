/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.utils.logger;

/**
 * ENUM for ILogger Logging Level. Is used to declare what type off messages should be logged.
 * Clients should normally use the predefined Level constants such as DEBUG. 
 * <p>The levels in descending order are:</p>
 * <li>ERROR (highest value)</li>
 * <li>WARNING</li>
 * <li>INFO</li> 
 * <li>DEBUG (lowest value)</li><br><br>
 * <p>In addition there is a level OFF that can be used to turn off logging.</p>
 * 
 * @author Sass
 *
 */
public enum LoggingLevel {
    DEBUG,
    INFO, 
    WARN, 
    ERROR, 
    OFF
}
