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
package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;

/**
 * Implements a private datatype class which represents the (pseudo) type of a project.
 * The (pseudo) type is intended as operand in custom operations.
 * 
 * @author Holger Eichelberger
 */
class ProjectType implements IDatatype {

    private final Project project;
    // this needs to be a list as it is truly dynamic
    private List<CustomOperation> operationList = new ArrayList<CustomOperation>();
    
    /**
     * Creates the type instance of this.
     * @param project TODO
     */
    ProjectType(Project project) {
        this.project = project;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.project.getName();
    }

    /**
     * {@inheritDoc}
     */
    public String getNameSpace() {
        return this.project.getNameSpace();
    }

    /**
     * {@inheritDoc}
     */
    public String getQualifiedName() {
        return this.project.getQualifiedName();
    }

    /**
     * {@inheritDoc}
     */
    public String getUniqueName() {
        return this.project.getUniqueName();
    }
    
    /**
     * {@inheritDoc}
     */
    public CustomOperation getOperation(int index) {
        return operationList.get(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getOperationCount() {
        return operationList.size();
    }
    
    /**
     * Adds a custom operation.
     * 
     * @param operation the operation to be added
     */
    public void addOperation(CustomOperation operation) {
        operationList.add(operation);
    }
    
    /**
     * Removes a custom operation.
     * 
     * @param operation the operation to be removed
     * @return <code>true</code> if <code>operation</code> was removed, <code>false</code> else
     */        
    public boolean removeOperation(CustomOperation operation)  {
        return operationList.remove(operation);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isAssignableFrom(IDatatype type) {
        return null != type && getClass().isAssignableFrom(type.getClass());
    }

    /**
     * {@inheritDoc}
     */
    public Class<? extends IDatatype> getTypeClass() {
        return ProjectType.class;
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype getGenericType(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    /**
     * {@inheritDoc}
     */
    public int getGenericTypeCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitDatatype(this);
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype getType() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isPrimitive() {
        return false;
    }

}