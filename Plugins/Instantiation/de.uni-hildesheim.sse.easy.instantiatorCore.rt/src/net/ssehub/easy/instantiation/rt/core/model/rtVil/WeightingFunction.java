/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * Represents a breakdown weighting function.
 * 
 * @author Holger Eichelberger
 */
public class WeightingFunction {

    private Expression expression;
    private VariableDeclaration variable;
    
    /**
     * Creates a weighting function.
     * 
     * @param variable a local variable that may be used in <code>expression</code>
     * @param expression the weighting function expression
     */
    public WeightingFunction(VariableDeclaration variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }
    
    /**
     * Returns the local variable declaration.
     * 
     * @return the local variable declaration
     */
    public VariableDeclaration getVariable() {
        return variable;
    }
    
    /**
     * Returns the expression representing the weighting function.
     * 
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }
    
}
