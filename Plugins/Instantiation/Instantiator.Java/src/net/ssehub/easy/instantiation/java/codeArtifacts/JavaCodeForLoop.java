/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a for-loop.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeForLoop extends JavaCodeBlock {

    private JavaCodeTypeSpecification type;
    private LoopVariable variable;
    private List<LoopVariable> furtherVariables = null;
    private String condition;
    private List<String> updates;
    
    private static class LoopVariable {
        private String name;
        private String initializer;
        
        private LoopVariable(String name, String initializer) {
            this.name = name;
            this.initializer = initializer;
        }
        
        private boolean hasVariable() {
            return name != null && !name.isEmpty();
        }
        
        private boolean hasInitializer() {
            return null != initializer && !initializer.isEmpty();
        }
        
    }
    
    /**
     * Creates an interable-based for-loop.
     * 
     * @param parent the parent instance
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     */
    public JavaCodeForLoop(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName, 
        String expression) {
        super(parent, true, true);
        this.type = type;
        this.variable = new LoopVariable(variableName, null == expression ? "" : expression);
    }

    /**
     * Creates a traditional for-loop.
     * 
     * @param parent the parent instance
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable (optional, may be <b>null</b> or empty)
     * @param initializer the iterator variable initializer
     * @param condition the loop condition (optional, may be <b>null</b> or empty)
     * @param update the iterator variable update, e.g., increment, decrement (may be <b>null</b> or empty)
     */
    public JavaCodeForLoop(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName, 
        String initializer, String condition, String update) {
        super(parent, true, true);
        this.type = type;
        this.variable = new LoopVariable(variableName, initializer);
        this.condition = condition;
        addUpdate(update);
    }

    /**
     * Adds an update statement.
     * 
     * @param update the statement (may be <b>null</b> or empty to ignore this call)
     * @return <b>this</b> for chaining
     */
    public JavaCodeForLoop addUpdate(String update) {
        if (null != update && update.length() > 0) {
            if (null == this.updates) {
                this.updates = new ArrayList<>();
            }
            this.updates.add(update);
        }
        return this;
    }

    /**
     * Adds a loop variable.
     * 
     * @param name the variable (may be <b>null</b> or empty to ignore this call)
     * @param initializer the initializer
     * @return <b>this</b> for chaining
     */
    public JavaCodeForLoop addLoopVariable(String name, String initializer) {
        if (null != name && name.length() > 0) {
            if (null == furtherVariables) {
                furtherVariables = new ArrayList<>();
            }
            furtherVariables.add(new LoopVariable(name, initializer));
        }
        return this;
    }
    
    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("for (");
        boolean hasVariable = variable.hasVariable();
        if (hasVariable) {
            type.store(out);
            out.print(" ");
            out.print(variable.name);
        }
        if (null == updates) {
            out.print(" : ");
            out.print(variable.initializer);
        } else {
            if (hasVariable && variable.hasInitializer()) {
                out.print(" = ");
                out.print(variable.initializer);
            }
            if (null != furtherVariables) {
                for (LoopVariable v : furtherVariables) {
                    out.print(", ");
                    out.print(v.name);
                    if (v.hasInitializer()) {
                        out.print(" = ");
                        out.print(v.initializer);
                    }
                }
            }
            out.print(";");
            if (null != condition) {
                out.print(" ");
                out.print(condition);
            }
            out.print(";");
            if (null != updates) {
                out.print(" ");
                boolean first = true;
                for (String u : updates) {
                    if (!first) {
                        out.print(", ");
                    }
                    out.print(u);
                    first = false;
                }
            }
        }
        out.print(")");
        super.store(out);
    }

}
