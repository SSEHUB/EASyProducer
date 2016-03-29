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

import java.util.Arrays;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;

/**
 * ProjectInterface class.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 *
 */
public class ProjectInterface extends ContainableModelElement implements IResolutionScope {

    private DecisionVariableDeclaration[] exports;
    
    /**
     * Constructor for the project interface.
     * @param name Name of the project interface
     * @param exports the exports of this interface
     * @param parent the object, in which this specific one is embedded
     */
    public ProjectInterface(String name, DecisionVariableDeclaration[] exports, ModelElement parent) {
        super(name, parent);
        this.exports = exports;
    }
    
    /**
     * Method checks the configurable status of an object.
     * 
     * @return the configurable status.
     */
    public boolean isFullConfigurable() {
        return false;
    }
    
    /**
     * Returns the number of exports.
     * 
     * @return the number of exports
     */
    public int getExportsCount() {
        return null == exports ? 0 : exports.length; 
    }
    
    /**
     * Returns the exported decision variable specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the exported decision variable
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getExportsCount()}</code>
     */
    public DecisionVariableDeclaration getExport(int index) {
        if (null == exports) {
            throw new IndexOutOfBoundsException();
        }
        return exports[index];
    }

    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitProjectInterface(this);
    }

    /**
     * Returns a contained model element specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the contained element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     * @see #getExport(int)
     */
    public ContainableModelElement getElement(int index) {
        if (null == exports) {
            throw new IndexOutOfBoundsException();
        }
        return exports[index];
    }

    /**
     * Returns the number of contained elements.
     * 
     * @return the number of contained elements
     * @see #getExportsCount()
     */
    public int getElementCount() {
        return null == exports ? 0 : exports.length; 
    }
    
    @Override
    public int getImportsCount() {
        return 0;
    }

    @Override
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns whether this project has interfaces.
     * 
     * @return <code>true</code> if it has interfaces, <code>false</code> else
     */
    public boolean hasInterfaces() {
        return false; // so far no nested interfaces
    }
    
    @Override
    public boolean isInterface() {
        return true;
    }

    @Override
    public ContainableModelElement getElement(String name) {
        return null;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(exports);
        result += prime * result + getTopLevelParent().hashCode();
        result += prime * result + getName().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = this == obj;
        if (!equal && obj instanceof ProjectInterface) {
            ProjectInterface other = (ProjectInterface) obj;
            // ProjectInterfaces belong to the same project
            IModelElement thisParent = getTopLevelParent();
            IModelElement otherParent = other.getTopLevelParent();
            if (null == thisParent) {
                equal = null == otherParent;
            } else {
                equal = thisParent.getName().equals(otherParent.getName());
                if (thisParent instanceof Project && otherParent instanceof Project && equal) {
                    Version thisVersion = ((Project) thisParent).getVersion();
                    Version otherVersion = ((Project) otherParent).getVersion();
                    equal = (null == thisVersion) ? null == otherVersion : thisVersion.equals(otherVersion);
                }
            }
            // ProjectInterfaces have the same name
            equal &= this.getName().equals(other.getName());
            // ProjectInterfaces exports the same declarations
            if (equal) {
                equal = Arrays.equals(exports, other.exports);
            }
        }
        return equal;
    }

}
