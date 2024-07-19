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

/**
 * Represents a variable assignment. An explicit expression call takes precedence over a String expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAssignment implements IJavaCodeElement {

    private IJavaCodeElement parent;
    private String variableName;
    private String expression;
    private JavaCodeMethodCall expressionCall;
    
    /**
     * Creates a variable assignment.
     * 
     * @param parent the parent
     * @param variableName the variable name
     * @param expression the value expression
     */
    public JavaCodeAssignment(IJavaCodeElement parent, String variableName, String expression) {
        this.parent = parent;
        this.variableName = variableName;
        this.expression = expression;
    }

    /**
     * Adds a non-static method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, false);
    }

    /**
     * Adds a method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param considerStatic whether the call is static
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName, boolean considerStatic) {
        expressionCall = new JavaCodeMethodCall(this, methodName, considerStatic);
        return expressionCall;
    }
    
    @Override
    public void store(CodeWriter out) {
        out.printIndent();
        out.print(variableName);
        out.print(" = ");
        if (expressionCall != null) {
            expressionCall.store(out);
        } else {
            out.print(expression);
        }
        out.println(";");
    }

    @Override
    public IJavaCodeArtifact getArtifact() {
        return parent.getArtifact();
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaCodeAssignment";
    }

    @Override
    public IJavaCodeElement getParent() {
        return parent;
    }

}
