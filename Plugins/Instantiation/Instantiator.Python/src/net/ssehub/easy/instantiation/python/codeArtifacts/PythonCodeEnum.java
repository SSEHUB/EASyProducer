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
package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python enum.
 * 
 * @author Holger Eichelberger
 */
public class PythonCodeEnum extends PythonCodeClass {
    
    /**
     * Represents an enum literal with comment.
     * 
     * @author Holger Eichelberger
     */
    private class PythonCodeEnumLiteral extends PythonCodeAssign {

        private PythonCodeDocComment comment;
        
        /**
         * Creates a literal.
         * 
         * @param parent the parent
         * @param varName the variable name
         * @param expr the value expression
         * @param comment optional comment, may be <b>null</b> or empty for none
         */
        private PythonCodeEnumLiteral(IPythonCodeElement parent, String varName, String expr, 
            String comment) {
            super(parent, varName, expr);
            if (null != expr && expr.length() > 0) {
                this.comment = new PythonCodeDocComment(comment, this);
            }
        }
        
        @Override
        public void store(CodeWriter out) {
            super.store(out);
            if (null != comment) {
                comment.store(out);
            }
        }
        
        @Invisible
        @Override
        public boolean isAttribute() {
            return true; // shall look like an attribute
        }

    }

    /**
     * Creates an enum.
     * 
     * @param parent the parent code element
     * @param name the enum name
     */
    PythonCodeEnum(IPythonCodeElement parent, String name) {
        super(parent, name);
        init();
    }

    /**
     * Creates an enum with comment.
     * 
     * @param parent the parent code element
     * @param name the enum name
     * @param comment the comment
     */
    PythonCodeEnum(IPythonCodeElement parent, String name, String comment) {
        super(parent, name, comment);
        init();
    }
    
    /**
     * Initializes an instance.
     */
    private void init() {
        getArtifact().addImport("enum", "Enum");
        addBase("Enum");
    }

    /**
     * Adds a literal.
     * 
     * @param name the name of the literal
     * @param value the (ordinal) value
     * @return the literal declaration (for chaining)
     */
    public PythonCodeAssign addLiteral(String name, String value) {
        return addLiteral(name, value, null);
    }

    /**
     * Adds a commented literal.
     * 
     * @param name the name of the literal
     * @param value the (ordinal) value
     * @param comment the comment (may be empty or <b>null</b> for none)
     * @return the literal declaration (for chaining)
     */
    public PythonCodeAssign addLiteral(String name, String value, String comment) {
        return add(new PythonCodeEnumLiteral(this, name, value, comment));
    }

    /**
     * Adds a function/method that returns an enumeration literal by its ordinal.
     * 
     * @param name the name of the function
     * @return the function for chaining
     */
    public PythonCodeFunction addLiteralByOrdinalFunction(String name) {
        return addLiteralByOrdinalFunction(name, "ordinal");
    }

    /**
     * Adds a function/method that returns an enumeration literal by its ordinal.
     * 
     * @param name the name of the function
     * @param argumentName the argument name for the function
     * @return the function for chaining
     */
    public PythonCodeFunction addLiteralByOrdinalFunction(String name, String argumentName) {
        PythonCodeFunction f = getArtifact().addFunc(name, "Returns an enum literal via its model ordinal.");
        f.addRetType(getName(), "the enum literal or Null");
        f.addParameter("ordinal", "int", "the desired ordinal value");
        PythonCodeForLoop l = f.addFor("l", getName());
        PythonCodeAlternative i = l.addIf("l.value == ordinal");
        i.addReturn("l");
        f.addReturn("None");
        return f;
    }

}
