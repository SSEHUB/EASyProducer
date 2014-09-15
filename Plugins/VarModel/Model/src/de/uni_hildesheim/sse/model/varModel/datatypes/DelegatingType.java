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

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.InternalConstraint;

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

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return delegate.getName();
    }

    /** 
     * {@inheritDoc}
     */
    public String getNameSpace() {
        return delegate.getNameSpace();
    }
    
    /**
     * {@inheritDoc}
     */
    public String getQualifiedName() {
        return delegate.getQualifiedName();
    }
    
    /**
     * {@inheritDoc}
     */
    public String getUniqueName() {
        return delegate.getUniqueName();
    }

    /**
     * {@inheritDoc}
     */
    public Operation getOperation(int index) {
        return getAllOperation(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getOperationCount() {
        return getAllOperationCount();
    }

    /**
     * {@inheritDoc}
     */
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
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public IDatatype getGenericType(int index) {
        return delegate.getGenericType(index);
    }
    
    /**
     * {@inheritDoc}
     */
    public int getGenericTypeCount() {
        return delegate.getGenericTypeCount();
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        delegate.accept(visitor);
    }
    
    /**
     * {@inheritDoc}
     */
    public final InternalConstraint[] createConstraints(AbstractVariable declaration) {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
    public boolean isPrimitive() {
        return delegate.isPrimitive();
    }

}
