/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents a resolved operation in terms of a function pointer. The resolved
 * operation just needs to be the basic operation as dynamic dispatch will follow at runtime.
 * 
 * @author Holger Eichelberger
 */
public class ResolvableOperationExpression extends Expression {

    private TypeDescriptor<?> type;
    private IMetaOperation operation;
    
    /**
     * Creates a resolvable operation expression, i.e., the expression which (basically)
     * resolves a function pointer.
     * 
     * @param type the resolvable operation type (declaring the function pointer)
     * @param operation the resolved operation (resolving the function pointer, allow also rules, defs)
     */
    public ResolvableOperationExpression(TypeDescriptor<?> type, IMetaOperation operation) {
        this.type = type;
        this.operation = operation;
    }
    
    /**
     * Returns the resolvable type descriptor framing the operation.
     * 
     * @return the resolvable type descriptor
     */
    public TypeDescriptor<?> getType() {
        return type;
    }

    /**
     * Returns the resolved operation.
     * 
     * @return the resolved operation
     */
    public IMetaOperation getOperation() {
        return operation;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return type;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitResolvableOperationExpression(this);
    }

}
