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
package net.ssehub.easy.instantiation.core.model.common;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;

/**
 * Implements a simple list variable declaration receiver.
 * 
 * @param <I> the variable type
 * @author Holger Eichelberger
 */
public class ListVariableDeclarationReceiver<I extends IResolvable> implements IVariableDeclarationReceiver<I> {

    private List<I> variables;
    
    /**
     * Creates a receiver.
     */
    public ListVariableDeclarationReceiver() {
        variables = new ArrayList<I>();
    }

    /**
     * Creates a receiver of given initial size.
     * 
     * @param size the initial size
     */
    public ListVariableDeclarationReceiver(int size) {
        variables = new ArrayList<I>(size);
    }

    @Override
    public void addVariableDeclaration(I var) {
        variables.add(var);
    }
    
    /**
     * Returns the number of variables.
     * 
     * @return the number of variables
     */
    public int getVariableCount() {
        return variables.size();
    }
    
    /**
     * Returns the specified variable.
     * 
     * @param index the 0-based index of the variable
     * @return the specified variable
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getVariableCount()}</code>
     */
    public I getVariable(int index) {
        return variables.get(index);
    }
    
    /**
     * Turns the collected variables into an array.
     * 
     * @return the array
     */
    @SuppressWarnings("unchecked")
    public I[] toArray() {
        Object[] res = new Object[variables.size()];
        variables.toArray(res);
        return (I[]) res;
    }
    
}
