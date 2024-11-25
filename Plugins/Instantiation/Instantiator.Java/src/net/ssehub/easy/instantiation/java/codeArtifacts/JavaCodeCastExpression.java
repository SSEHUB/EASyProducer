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
 * Represents a Java cast expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeCastExpression extends JavaCodeExpression {

    private String typeName;
    private JavaCodeTypeSpecification type;
    private JavaCodeExpression valueEx;
    
    /**
     * Creates a method call.
     * 
     * @param parent the parent
     * @param type the (qualified) target type for the cast; may be empty to ignore the cast
     * @param valueEx the value to be casted
     */
    public JavaCodeCastExpression(IJavaCodeElement parent, String type, JavaCodeExpression valueEx) {
        super(parent);
        this.typeName = type;
        this.valueEx = valueEx;
        updateType();
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param type the cast target type; may be empty to ignore the cast
     * @param valueEx the value to be casted
     * @return the instance
     */
    public static JavaCodeCastExpression create(String type, JavaCodeExpression valueEx) {
        return new JavaCodeCastExpression(null, type, valueEx);
    }

    /**
     * Updates the type information including imports, e.g., when the parent is set later.
     */
    private void updateType() {
        if (null != getParent()) {
            this.type = new JavaCodeTypeSpecification(typeName, getParent());
        }
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        updateType();
        setParent(valueEx, this);
    }    
    
    @Override
    public void store(CodeWriter out) {
        if (typeName.length() > 0) { // may be empty
            out.print("(");
            if (null != type) {
                out.print(type.getOutputType()); // may be unqualified due to imports, but including generics
            } else {
                out.print(typeName); // fallback
            }
            out.print(") ");
        }
        valueEx.store(out);
    }
    
    @Override
    public boolean isEmpty() {
        return typeName.length() > 0 ? false : valueEx.isEmpty();
    }

}
