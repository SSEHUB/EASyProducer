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
 * Represents a throw statement/command.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeThrow extends JavaCodeStatement {

    private String expression;
    
    /**
     * Creates an if-then-else alternative.
     * 
     * @param parent the parent instance
     * @param expression the expression representing the exception
     */
    public JavaCodeThrow(IJavaCodeElement parent, String expression) {
        super(parent);
        this.expression = expression;
    }
    
    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("throw ");
        out.print(expression);
        out.println(";");
    }

}
