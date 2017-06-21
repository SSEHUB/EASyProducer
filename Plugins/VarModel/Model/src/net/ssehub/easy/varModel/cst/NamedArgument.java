/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Implements a named argument as a transparent constraint syntax tree.
 * 
 * @author Holger Eichelberger
 */
public class NamedArgument extends ConstraintSyntaxTree {

    private ConstraintSyntaxTree expression;
    private String name;
    
    /**
     * Creates a named argument.
     * 
     * @param name the name
     * @param expression the expression
     */
    public NamedArgument(String name, ConstraintSyntaxTree expression) {
        this.name = name;
        this.expression = expression;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        expression.accept(visitor); // just pass through
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return expression.inferDatatype(); // just pass through
    }

}
