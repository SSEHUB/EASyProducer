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
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a return statement.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeReturn extends JavaCodeStatement {

    private JavaCodeExpression valueEx;

    /**
     * Creates a return statement.
     * 
     * @param parent the parent element
     * @param valueEx the value expression
     */
    protected JavaCodeReturn(IJavaCodeElement parent, JavaCodeExpression valueEx) {
        super(parent);
        setValue(valueEx);
    }

    /**
     * Changes the value expression of the return statement (transitively adjusting the parents of {@code expr} as 
     * side effect) .
     * 
     * @param expr the value expression
     */
    @OperationMeta(name = {"setValue", "val"})
    public void setValue(JavaCodeExpression expr) {
        expr.setParent(this);
        this.valueEx = expr;
    }
    
    /**
     * Adds an annotation argument representing an array initializer.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param lineBreaks add line breaks/indents between subsequent values, except for the last
     * @return the array initializer for adding values
     */
    @OperationMeta(name = {"addArrayValue", "arrayVal"})
    public JavaCodeArrayInitializerExpression addArrayValue(String name, boolean lineBreaks) {
        valueEx = new JavaCodeArrayInitializerExpression(this, lineBreaks);
        return (JavaCodeArrayInitializerExpression) valueEx;
    }

    /**
     * Adds an annotation argument representing an array initializer as default argument.
     * 
     * @param lineBreaks add line breaks/indents between subsequent values, except for the last
     * @return the array initializer for adding values
     */  
    @OperationMeta(name = {"addArrayValue", "arrayVal"})
    public JavaCodeArrayInitializerExpression addArrayValue(boolean lineBreaks) {
        return addArrayValue(null, lineBreaks);
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi("return ");
        valueEx.store(out);
        out.println(";");
    }

}
