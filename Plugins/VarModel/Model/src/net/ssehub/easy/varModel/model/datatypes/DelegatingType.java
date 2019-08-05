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
package net.ssehub.easy.varModel.model.datatypes;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.InternalConstraint;

/**
 * An internal delegating type to resolve cyclic class dependencies. A delegating type
 * represents (common) singleton type instances.
 * 
 * @author Holger Eichelberger
 */
class DelegatingType implements IDatatype {

    private List<Operation> operationList = new ArrayList<Operation>();
    
    /**
     * Stores the type to delegate to.
     */
    private IDatatype delegate;
    
    private DelegatingType parent;
    
    private int parentOperationCount;
    
    /**
     * Creates a delegating type.
     */
    DelegatingType() {
    }

    /**
     * Creates a delegating type.
     * 
     * @param delegate the delegate
     */
    DelegatingType(IDatatype delegate) {
        this(delegate, null);
    }

    /**
     * Creates a delegating type.
     * 
     * @param parent the parent delegate (considers operations)
     */
    DelegatingType(DelegatingType parent) {
        this(null, parent);
    }

    /**
     * Creates a delegating type.
     * 
     * @param delegate the delegate
     * @param parent the parent delegate (considers operations)
     */
    DelegatingType(IDatatype delegate, DelegatingType parent) {
        this.delegate = delegate;
        this.parent = parent;
        updateParentInformation();
    }
    
    /**
     * Updates the information collected about the parent.
     */
    public void updateParentInformation() {
        if (null != parent) {
            parentOperationCount = parent.getAllOperationCount();
        } else {
            parentOperationCount = 0;
        }
    }
    
    /**
     * Returns the number of operations of the parent an all parents above.
     * 
     * @return the number of operation
     */
    private int getAllOperationCount() {
        updateParentInformation();
        int result = operationList.size();
        if (null != parent) {
            result += parent.getAllOperationCount();
        }
        return result;
    }
    
    /**
     * Returns the operation at position <code>index</code> and considers
     * also parent operations.
     * 
     * @param index the index number of the operation
     * @return the specified operation
     * @throws IndexOutOfBoundsException if <code>index&lt;0 
     *     || index&gt;={@link #getAllOperationCount()}</code>
     */
    private Operation getAllOperation(int index) {
        Operation result;
        if (index >= parentOperationCount) {
            result = operationList.get(index - parentOperationCount);
        } else {
            result = parent.getAllOperation(index);
        }
        return result;
    }

    /**
     * Changes the delegate.
     * 
     * @param delegate the new delegate
     */
    public void setDelegate(IDatatype delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public String getNameSpace() {
        return delegate.getNameSpace();
    }
    
    @Override
    public String getQualifiedName() {
        return delegate.getQualifiedName();
    }
    
    @Override
    public String getUniqueName() {
        return delegate.getUniqueName();
    }

    @Override
    public Operation getOperation(int index) {
        return getAllOperation(index);
    }

    @Override
    public int getOperationCount() {
        return getAllOperationCount();
    }

    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return delegate.isAssignableFrom(type);
    }

    /**
     * Allows child classes to add Operations to itself.
     * @param operator One operation, which should be added.
     */
    void addOperation(Operation operator) {
        assert operator.getOperand() == this;
        operationList.add(operator);
    }

    /**
     * Allows child classes to add Operations to itself.
     * @param operator One operation, which should be added.
     */
    void prependOperation(Operation operator) {
        assert operator.getOperand() == this;
        operationList.add(0, operator);
    }
    
    @Override
    public Class<? extends IDatatype> getTypeClass() {
        return delegate.getClass();
    }
    
    /**
     * Returns the object realizing the type.
     * 
     * @return the object realizing the type
     */
    public IDatatype getType() {
        return delegate.getType();
    }

    @Override
    public IDatatype getGenericType(int index) {
        return delegate.getGenericType(index);
    }
    
    @Override
    public int getGenericTypeCount() {
        return delegate.getGenericTypeCount();
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        delegate.accept(visitor);
    }
    
    @Override
    public final InternalConstraint[] createConstraints(AbstractVariable declaration) {
        return null;
    }
    
    @Override
    public boolean isPseudoType() {
        return false; // represents a real type
    }
    
    /**
     * Returns the delegate type.
     * 
     * @return the delegate type
     */
    public IDatatype getDelegate() {
        return delegate;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    @Override
    public boolean isPrimitive() {
        return delegate.isPrimitive();
    }

}
