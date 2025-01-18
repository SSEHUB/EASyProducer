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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a variable assignment. An explicit expression call takes precedence over a String expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAssignment extends JavaCodeStatement {

    private String variableName;
    private String operator;
    private JavaCodeExpression expression;
    
    /**
     * Creates a variable assignment with default assignment operator {@code =}.
     * 
     * @param parent the parent
     * @param variableName the variable name
     * @param expression the value expression
     */
    public JavaCodeAssignment(IJavaCodeElement parent, String variableName, JavaCodeExpression expression) {
        this(parent, variableName, "=", expression);
    }

    /**
     * Creates a variable assignment.
     * 
     * @param parent the parent
     * @param variableName the variable name
     * @param operator the assignment operator, e.g., {@code =} or {@code +=}
     * @param expression the value expression
     */
    public JavaCodeAssignment(IJavaCodeElement parent, String variableName, String operator, 
        JavaCodeExpression expression) {
        super(parent);
        this.variableName = variableName;
        this.operator = operator;
        this.expression = expression;
        this.expression.setParent(this);
    }

    /**
     * Adds a non-static method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Adds a method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        expression = new JavaCodeMethodCall(this, methodName, scope, false, "");
        return (JavaCodeMethodCall) expression;
    }
    
    @Override
    public void store(CodeWriter out) {
        out.printIndent();
        out.print(variableName);
        out.print(" ");
        out.print(operator);
        out.print(" ");
        if (expression != null) {
            expression.store(out);
        }
        out.println(";");
    }

}
