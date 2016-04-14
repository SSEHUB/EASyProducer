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
package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;

/**
 * Debugging support.
 * 
 * @author Holger Eichelberger
 */
public class Debug {

    /**
     * Emit debugging text into the tracer messages and also to the calling Eclipse console. [debug]
     * Logging is not feasible here as it is more helpful to have the debugging information directly
     * within the tracer output stream.
     * 
     * @param text the text to be emitted.
     */
    public static void debug(String text) {
        System.out.println(text);
        TracerFactory.createInstantiatorTracer().traceMessage(text);
    }  
    
}
