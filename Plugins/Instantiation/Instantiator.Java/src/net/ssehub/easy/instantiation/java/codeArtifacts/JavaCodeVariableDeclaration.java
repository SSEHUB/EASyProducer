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
 * Represents a variable declaration. An explicit method call takes precedence over a String initializer.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeVariableDeclaration implements IJavaCodeElement {

    private IJavaCodeElement parent;
    private JavaCodeTypeSpecification type;
    private String variableName;
    private boolean isFinal;
    private String initializer;
    private JavaCodeMethodCall initCall;
    
    /**
     * Creates a variable declaration.
     * 
     * @param parent the parent
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> for none
     */
    public JavaCodeVariableDeclaration(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName, 
        boolean isFinal, String initializer) {
        this.parent = parent;
        this.type = type;
        this.variableName = variableName;
        this.isFinal = isFinal;
        this.initializer = initializer;
    }

    /**
     * Sets the initializer.
     * 
     * @param initializer the initializer
     */
    public void setInitializer(String initializer) {
        this.initializer = initializer;
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
        initCall = new JavaCodeMethodCall(this, methodName, considerStatic);
        return initCall;
    }

    @Override
    public void store(CodeWriter out) {
        out.printIndent();
        if (isFinal) {
            out.print("final ");
        }
        if (null == type) {
            out.print("var ");
        } else {
            type.store(out);
            out.print(" ");
        }
        out.print(variableName);
        if (initCall != null) {
            out.print(" = ");
            initCall.store(out);
        } else if (null != initializer && !initializer.isEmpty()) {
            out.print(" = ");
            out.print(initializer);
        }
        out.println(";");
    }

    @Override
    public IJavaCodeArtifact getArtifact() {
        return parent.getArtifact();
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "MethodCall";
    }

    @Override
    public IJavaCodeElement getParent() {
        return parent;
    }

}
