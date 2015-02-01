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

import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;

/**
 * A list of containable model elements which acts as {@link IResolutionScope}.
 * Note that such a list does neither provides imports nor a name and is more 
 * or less intended to be considered for searching specific elements 
 * in {@link ModelQuery}.
 * 
 * @author Holger Eichelberger
 */
public class ContainableModelElementList extends ArrayList<ContainableModelElement> 
    implements IResolutionScope {
    
    // This would be a candidate for a utils package

    /**
     * Identification for serialization.
     */
    private static final long serialVersionUID = 6379434188902270970L;

    private IModelElement parent;
    
    /**
     * Creates a new model element list.
     * 
     * @param parent the parent (scope, may be <b>null</b>)
     */
    public ContainableModelElementList(IModelElement parent) {
        super();
        this.parent = parent;
    }

    /**
     * Creates a new model element list.
     * 
     * @param initialCapacity the initial capacity of the list
     * @param parent the parent (scope, may be <b>null</b>)
     */
    public ContainableModelElementList(int initialCapacity, IModelElement parent) {
        super(initialCapacity);
    }
    
    @Override
    public ContainableModelElement getElement(int index) {
        return get(index);
    }

    @Override
    public int getElementCount() {
        return size();
    }

    @Override
    public int getImportsCount() {
        return 0;
    }

    @Override
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public IModelElement getParent() {
        return parent;
    }
    
    /** 
     * Returns the (unqualified) name of the scope.
     * @return the unqualified name of the scope
     */
    public String getName() {
        return "";
    }

    /**
     * Returns whether this project has interfaces.
     * 
     * @return <code>true</code> if it has interfaces, <code>false</code> else
     */
    public boolean hasInterfaces() {
        return false; // this is just a list used internally
    }
    
    @Override
    public boolean isInterface() {
        return false; // this is just a list used internally
    }

    @Override
    public ContainableModelElement getElement(String name) {
        ContainableModelElement result = null;
        for (int i = 0; null == result && i < size(); i++) {
            ContainableModelElement elt = get(i);
            if (elt.getName().equals(name) || elt.getQualifiedName().equals(name)) {
                result = elt;
            }
        }
        return result;
    }
    
}

