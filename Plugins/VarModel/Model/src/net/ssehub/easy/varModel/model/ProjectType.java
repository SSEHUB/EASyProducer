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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatypeVisitor;

/**
 * Implements a private datatype class which represents the (pseudo) type of a project.
 * The (pseudo) type is intended as operand in custom operations.
 * 
 * @author Holger Eichelberger
 */
public class ProjectType implements IDatatype {

    private final Project project;
    // this needs to be a list as it is truly dynamic
    private List<CustomOperation> operationList = new ArrayList<CustomOperation>();

    /**
     * Constructor for serialization.
     */
    ProjectType() {
        this.project = null;
    }
    
    /**
     * Creates the type instance of this.
     * @param project TODO
     */
    ProjectType(Project project) {
        this.project = project;
    }

    @Override
    public String getName() {
        return this.project.getName();
    }

    @Override
    public String getNameSpace() {
        return this.project.getNameSpace();
    }

    @Override
    public String getQualifiedName() {
        return this.project.getQualifiedName();
    }

    @Override
    public String getUniqueName() {
        return this.project.getUniqueName();
    }
    
    @Override
    public CustomOperation getOperation(int index) {
        return operationList.get(index);
    }

    @Override
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

    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return null != type && getClass().isAssignableFrom(type.getClass());
    }

    @Override
    public Class<? extends IDatatype> getTypeClass() {
        return ProjectType.class;
    }

    @Override
    public IDatatype getGenericType(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public int getGenericTypeCount() {
        return 0;
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitDatatype(this);
    }
    
    @Override
    public boolean isPseudoType() {
        return true;
    }

    @Override
    public IDatatype getType() {
        return this;
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }

}