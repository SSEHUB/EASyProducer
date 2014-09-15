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
package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Implements a simple DSL fragment.
 * 
 * @author Holger Eichelberger
 */
public class DslFragment extends Leaf {

    private String command;
    private String escape;
    private String stop;
    private String dsl;
    
    /**
     * Creates a new DSL fragment.
     * 
     * @param command the command to execute the fragment
     * @param escape a string for marking IVML decision variables in <code>dsl</code>  
     * @param stop the stop string for marking the end of the DSL (legacy)
     * @param dsl the DSL program
     */
    public DslFragment(String command, String escape, String stop, String dsl) {
        this.command = command;
        this.escape = escape;
        this.stop = stop;
        this.dsl = dsl;
    }
    
    /**
     * Returns the command for executing the DSL fragment.
     * 
     * @return the command
     */
    public String getCommand() {
        return command;
    }
    
    /**
     * Returns the variable declaration escape sequence (prefix).
     * 
     * @return the variable declaration escape sequence
     */
    public String getEscape() {
        return escape;
    }
    
    /**
     * Returns the stop marker. (legacy)
     * 
     * @return the stop marker
     */
    public String getStop() {
        return stop;
    }
    
    /**
     * Returns the DSL program.
     * 
     * @return the DSL program
     */
    public String getDsl() {
        return dsl;
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitDslFragment(this);
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return AnyType.TYPE; // unclear, we might need "VOID" here
    }

    // as this is legacy, it is ok to stay with built-in hashcode and equals

}
