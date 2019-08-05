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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.model.datatypes.CustomOperation;

/**
 * A containable element which represents user defined operations.
 * 
 * @author Holger Eichelberger
 */
public class OperationDefinition extends ContainableModelElement {

    private CustomOperation operation;
    
    /**
     * Constructor for serialization.
     */ 
    OperationDefinition() {
        super(null, null);
    }
    
    /**
     * Constructor for containable model element.
     * @param parent the object, in which this specific one is embedded
     */
    public OperationDefinition(ModelElement parent) {
        super(null, parent);
    }

    /**
     * Changes the defined operation.
     * 
     * @param operation the defined operation
     */
    public void setOperation(CustomOperation operation) {
        this.operation = operation;
        setName(operation.getName());
    }
    
    /**
     * Returns the defined operation.
     * 
     * @return the operation
     */
    public CustomOperation getOperation() {
        return operation;
    }

    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitOperationDefinition(this);
    }

}
