/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.vil.rt.tests.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collects "executed" commands for testing.
 * 
 * @author Holger Eichelberger
 */
public class CommandCollector {

    private static final List<Command> EXECUTED = new ArrayList<Command>();
    
    /**
     * Clears the collected executed commands.
     */
    public static void clear() {
        EXECUTED.clear();
    }
    
    /**
     * Returns the executed commands in execution sequence.
     * 
     * @return the executed commands
     */
    public static Iterator<Command> executed() {
        return EXECUTED.iterator();
    }
    
    /**
     * Collects an "executed" command.
     * 
     * @param command the "executed" command
     */
    static void collectExecuted(Command command) {
        EXECUTED.add(command);
    }
    
    /**
     * Returns the number of executed commands.
     * 
     * @return the number of executed commands
     */
    public static int getExecutedCount() {
        return EXECUTED.size();
    }
    
    /**
     * Returns the specified executed command.
     * 
     * @param index the 0-based index of the command
     * @return the command
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getExecutedCount()}</code>
     */
    public static Command getExecuted(int index) {
        return EXECUTED.get(index);
    }
    
}
