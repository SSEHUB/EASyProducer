/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Provides access to custom operations.
 * 
 * @author Holger Eichelberger
 *
 */
public interface ICustomOperationAccessor {

    /**
     * Returns the (pseudo) datatype of this accessor, the operand type for
     * all accessible custom operations.
     * 
     * @return the datatype
     */
    public IDatatype getType();

    /**
     * Returns the operation specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the operation
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getOperationCount}</code>
     */
    public CustomOperation getOperation(int index);

    /**
     * Returns the number of operations.
     * 
     * @return the number of operations
     */
    public int getOperationCount();

}
