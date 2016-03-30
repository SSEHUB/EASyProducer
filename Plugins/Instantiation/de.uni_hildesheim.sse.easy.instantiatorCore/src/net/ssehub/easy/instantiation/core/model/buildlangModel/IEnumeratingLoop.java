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
package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Defines the internal interface of an enumerating loop.
 * 
 * @author Holger Eichelberger
 */
public interface IEnumeratingLoop extends IRuleBlock {

    /**
     * Returns the iterator expression.
     * 
     * @return the iterator expression
     */
    public Expression getExpression();
    
    /**
     * Returns the number of variables defined for this map statement.
     * 
     * @return the number of variables
     */
    public int getVariablesCount();

    /**
     * Returns the specified variable.
     * 
     * @param index the 0-based index denoting the variable to be returned
     * @return the specified variable
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getVariablesCount()}</code>
     */
    public VariableDeclaration getVariable(int index);

    /**
     * Returns the specified given type (further specifying to {@link #getVariable(int)}).
     * 
     * @param index the 0-based index denoting the type to be returned
     * @return the specified type, may be <b>null</b> if not given
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getVariablesCount()}</code>
     */    
    public TypeDescriptor<?> getGivenType(int index);

    /**
     * Returns the body element which determines the result.
     * 
     * @return the rule element determining the result (may be <b>null</b> if there is none)
     */
    public IRuleElement determinesResult();

    /**
     * Returns the name of the VIL language element.
     * 
     * @return the name
     */
    public String getElementName();

    /**
     * Returns whether the given separator was a colon.
     * 
     * @return <code>true</code> it it was a colon, <code>else</code> if it was an equals character
     */
    public boolean isColonSeparator();
    
}