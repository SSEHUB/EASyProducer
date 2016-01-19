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
package de.uni_hildesheim.sse.model.confModel;

import java.io.PrintStream;

/**
 * Preliminary class for tracing illegal variable operations. Will be removed soon.
 * 
 * @author Holger Eichelberger
 */
public class Debug {

    private static PrintStream out = null;

    /**
     * Enables or disables tracing.
     * 
     * @param stream the stream to use (may be <b>null</b>)
     */
    public static void setStream(PrintStream stream) {
        out = stream;
    }

    /**
     * Traces a call.
     * 
     * @param var the variable to trace
     */
    public static void trace(IDecisionVariable var) {
        trace(var, null);
    }
    
    /**
     * Traces a call.
     * 
     * @param var the variable to trace
     * @param text the text to be logged
     */
    public static void trace(IDecisionVariable var, String text) {
        if (null != out) {
            Throwable t = new Throwable(Configuration.getInstanceName(var) + (null != text ? text : ""));
            t.printStackTrace(out);
        }
    }

    /**
     * Traces a call.
     * 
     * @param text the text to be logged
     */
    public static void trace(String text) {
        if (null != out) {
            Throwable t = new Throwable(text);
            t.printStackTrace(out);
        }
    }

    /**
     * Logs a given text.
     * 
     * @param text the text
     */
    public static void log(String text) {
        if (null != out) {
            out.println(text);
        }
    }

}
