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
import java.util.List;

/**
 * Represents an enactment command sequence.
 * 
 * @author Holger Eichelberger
 */
public class CommandSequence extends Command {

    private List<Command> commands = new ArrayList<Command>();
    
    /**
     * Creates a command sequence.
     */
    public CommandSequence() {
    }

    /**
     * Adds a command to the command sequence.
     * 
     * @param command the command to be added
     */
    public void add(Command command) {
        commands.add(command);
    }
    
    @Override
    public void exec() {
        CommandCollector.collectExecuted(this);
        System.out.println("EXECUTE SEQUENCE:");
        for (int i = 0; i < commands.size(); i++) {
            commands.get(i).exec();
        }
    }

}
