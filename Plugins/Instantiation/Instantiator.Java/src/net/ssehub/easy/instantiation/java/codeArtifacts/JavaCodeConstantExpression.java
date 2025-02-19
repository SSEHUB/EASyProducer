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
 * Represents a static class access, i.e., accessing a declared constant.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeConstantExpression extends JavaCodeExpression {

    private String value;
    private JavaCodeTypeSpecification type;
    
    /**
     * Creates an instance.
     * 
     * @param value the value, potentially qualified
     * @param parent the parent, may be <b>null</b> ({@see #setParent(IJavaCodeElement)})
     */
    public JavaCodeConstantExpression(String value, IJavaCodeElement parent) {
        super(parent);
        this.value = value;
        int pos = value.lastIndexOf('.');
        if (pos > 0) {
            int classPos = value.lastIndexOf('.', pos - 1);
            if (classPos > 0) {
                type = new JavaCodeTypeSpecification(value.substring(0, pos), this);
                this.value = this.value.substring(classPos + 1);
            }
        }
    }
    
    /**
     * Creates a constant expression. Requires calling {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param value the value, potentially qualified
     * @return the constant expression
     */
    public static JavaCodeConstantExpression create(String value) {
        return new JavaCodeConstantExpression(value, null);
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        setParent(type, this);
    }
    
    @Invisible
    public void store(CodeWriter out) {
        out.print(value);
    }

}
