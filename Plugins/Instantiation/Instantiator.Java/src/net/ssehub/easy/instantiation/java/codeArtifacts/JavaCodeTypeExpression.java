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
 * Represents a type expression. To allow for constructor-based expression construction of parameters, 
 * resolution/registration of imports may have to be delayed until setParent.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeTypeExpression extends JavaCodeExpression { // unify with JavaCodeTypeSpecification?
    
    private JavaCodeTypeSpecification type;

    /**
     * Creates a type expression.
     * 
     * @param parent the parent
     * @param type the type specification
     */
    protected JavaCodeTypeExpression(IJavaCodeElement parent, JavaCodeTypeSpecification type) {
        super(parent);
        this.type = type;
    }

    @Override
    public void store(CodeWriter out) {
        out.print(type.getOutputTypeName());
        out.print(".class");
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        type.setParent(parent);
    }

}