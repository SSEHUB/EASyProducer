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
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a variable declaration. An explicit method call takes precedence over a String initializer.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeVariableDeclaration extends JavaCodeStatement {

    private JavaCodeTypeSpecification type;
    private String variableName;
    private boolean isFinal;
    private JavaCodeExpression initEx;
    private boolean asResource;

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
        boolean isFinal, JavaCodeExpression initializer) {
        this(parent, type, variableName, isFinal, initializer, false);
    }
    
    /**
     * Creates a variable declaration.
     * 
     * @param parent the parent
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @param asResource {@code true} if this declaration is used in a try resource declaration, {@code false} for 
     *     "normal" variable declarations
     */
    public JavaCodeVariableDeclaration(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer, boolean asResource) {
        super(parent);
        this.type = type;
        this.variableName = variableName;
        this.isFinal = isFinal;
        if (null != initializer && !initializer.isEmpty()) {
            this.initEx = initializer;
            this.initEx.setParent(this);
        }
        this.asResource = asResource;
    }

    /**
     * Sets the initializer.
     * 
     * @param initializer the initializer
     * @return <b>this</b> for chaining
     */
    public JavaCodeVariableDeclaration addInitializer(String initializer) {
        return setInitializer(initializer); // TODO transition to expression
    }

    /**
     * Sets the initializer.
     * 
     * @param initializer the initializer, may be <b>null</b> or empty for none
     * @return <b>this</b> for chaining
     */
    public JavaCodeVariableDeclaration setInitializer(String initializer) {
        if (null != initializer && initializer.length() > 0) {
            this.initEx = new JavaCodeTextExpression(this, initializer);
        }
        return this;
    }
    
    /**
     * Sets this variable declaration to final.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeVariableDeclaration setFinal() {
        return setFinal(true);
    }

    /**
     * Sets this variable declaration conditionally to final.
     * 
     * @param isFinal whether this variable shall be final
     * @return <b>this</b> for chaining
     */
    public JavaCodeVariableDeclaration setFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }

    /**
     * Returns the initializer expression.
     * 
     * @return the initializer expression, may be <b>null</b> for none
     */
    public JavaCodeExpression getInitializer() {
        return initEx;
    }
    
    /**
     * Adds a non-static method call as initializer.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Adds a method call as initializer.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        initEx = new JavaCodeMethodCall(this, methodName, scope, false, "");
        return (JavaCodeMethodCall) initEx;
    }

    /**
     * Adds a constructor call.
     * 
     * @param cls the name of the class, may be qualified
     * @return the method call (for chaining)
     */
    public JavaCodeConstructorCall addNew(String cls) {
        initEx = new JavaCodeConstructorCall(this, cls, false, "");
        return (JavaCodeConstructorCall) initEx;
    }

    @Override
    public void store(CodeWriter out) {
        if (!asResource) {
            out.printIndent();
        }
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
        if (initEx != null) {
            out.print(" = ");
            initEx.store(out);
        }
        if (!asResource) {
            out.println(";");
        }
    }
    
    @Invisible
    public void storeAsQualifier(CodeWriter out) {
        out.print(variableName);
    }
    
    /**
     * Returns the name of the variable.
     * 
     * @return the name
     */
    public String getName() {
        return variableName;
    }

}
