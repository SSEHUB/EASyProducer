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
 * Represents an array constructor.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeNewArrayExpression extends JavaCodeExpression {

    private List<JavaCodeExpression> dimensions = new ArrayList<>();
    private JavaCodeTypeSpecification type;

    /**
     * Creates a new instance.
     * 
     * @param parent the parent
     * @param type the type
     */
    protected JavaCodeNewArrayExpression(IJavaCodeElement parent, String type) {
        super(parent);
        this.type = new JavaCodeTypeSpecification(type, this);
    }

    /**
     * Creates an instance. {@link #setParent(IJavaCodeElement)} must be called later.
     * 
     * @param type the type
     * @return the instance
     */
    public static JavaCodeNewArrayExpression create(String type) {
        return new JavaCodeNewArrayExpression(null, type);
    }
    
    /**
     * Adds an array dimension expression.
     * 
     * @param dimension the dimension expression
     * @return <b>this</b> for chaining
     */
    public JavaCodeNewArrayExpression addDimension(JavaCodeExpression dimension) {
        dimensions.add(dimension);
        return this;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        type.setParent(this);
    }
    
    @Override
    public void store(CodeWriter out) {
        out.print("new ");
        type.store(out);
        for (JavaCodeExpression d: dimensions) {
            out.print("[");
            d.store(out);
            out.print("]");
        }
    }

}
