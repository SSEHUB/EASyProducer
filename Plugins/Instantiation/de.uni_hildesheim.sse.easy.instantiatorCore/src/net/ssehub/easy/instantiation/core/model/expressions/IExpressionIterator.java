/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.expressions;

/**
 * Defines a simple expression iterator.
 * 
 * @author Holger Eichelberger
 */
public interface IExpressionIterator {

    /**
     * Returns the number of expression.
     * 
     * @return the number of expressions
     */
    public int getExpressionsCount();
    
    /**
     * Returns the specified expression.
     * 
     * @param index the 0-based index of the expression
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getExpressionsCount()}</code>
     */
    public Expression getExpression(int index);
    
}
