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
 * A text expression which represents a variable name (no new functionality, only for documentation).
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeVariableExpression extends JavaCodeTextExpression implements JavaCodeQualifiableElement {

    private IJavaCodeElement qualification;

    /**
     * Creates an instance.
     * 
     * @param parent the parent element
     * @param text the text
     */
    protected JavaCodeVariableExpression(IJavaCodeElement parent, String text) {
        super(parent, text);
    }

    /**
     * Creates an instance.
     * 
     * @param parent the parent element
     * @param var the variable to access
     */
    protected JavaCodeVariableExpression(IJavaCodeElement parent, JavaCodeVariableDeclaration var) {
        super(parent, var.getName());
    }
    
    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param text the text
     * @return the instance
     */
    public static JavaCodeVariableExpression create(String text) {
        return new JavaCodeVariableExpression(null, text);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param var the variable to represent/access
     * @return the instance
     */
    public static JavaCodeVariableExpression create(JavaCodeVariableDeclaration var) {
        return new JavaCodeVariableExpression(null, var);
    }

    @Override
    public void store(CodeWriter out) {
        if (null != qualification) {
            qualification.store(out);
            out.print(".");
        }
        super.store(out);
    }

    @Override
    public JavaCodeVariableExpression qualifiedBy(String qualification) {
        this.qualification = new JavaCodeTextExpression(this, qualification);
        return this;
    }

    @Override
    public JavaCodeVariableExpression qualifiedByType(String type) {
        this.qualification = new JavaCodeTypeSpecification(type, this);
        return this;
    }

    @Override
    public JavaCodeVariableExpression qualifiedBy(JavaCodeVariableDeclaration var) {
        this.qualification = new JavaCodeVariableExpression(this, var);
        return this;
    }

    @Override
    public JavaCodeVariableExpression replaceVariable(String oldName, String newName) {
        if (null != qualification) {
            qualification.replaceVariable(oldName, newName);
        }
        return this;
    }

}
