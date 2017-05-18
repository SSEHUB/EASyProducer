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
package net.ssehub.easy.varModel.model.datatypes;

import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Operation.ReturnTypeMode;

/**
 * Describes an operation that returns a set as collection, i.e., that does not dynamically
 * choose, e.g., based on the operand type.
 * 
 * @author Holger Eichelberger
 */
public class SetReturningOperation extends Operation {

    /**
     * Creates a non-container operation (descriptor).
     * The return type mode is {@link ReturnTypeMode#UNCHANGED} by default. Use 
     * {@link #markAsContainerOperation()} to flag this operation as a container operation.
     * 
     * @param returns result type of the operation
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     */
    SetReturningOperation(IDatatype returns, String name, IDatatype operand, IDatatype... parameters) {
        super(returns, name, operand, parameters);
    }

    /**
     * Creates an operation (descriptor). Use {@link #markAsContainerOperation()} to
     * flag this operation as a container operation.
     * 
     * @param returns result type of the operation
     * @param returnTypeMode the return type mode
     * @param name name of the operation
     * @param operand the data type the operation is defined for
     * @param parameters list of parameters for operation
     */
    SetReturningOperation(IDatatype returns, ReturnTypeMode returnTypeMode, String name, IDatatype operand,
        IDatatype... parameters) {
        super(returns, returnTypeMode, name, operand, parameters);
    }

    @Override
    protected IDatatype createCollectionReturnType(IDatatype aim, IDatatype elementType, IModelElement parent) {
        return super.createCollectionReturnType(Set.TYPE, elementType, parent);
    }

}
