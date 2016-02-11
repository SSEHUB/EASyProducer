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

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatypeVisitor;


/**
 * Represents the objects, a project can handle.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public abstract class ContainableModelElement extends ModelElement implements IDatatypeVisitable {

    private IModelElement parent;
    
    /**
     * Constructor for containable model element.
     * @param name Name of the containable model element
     * @param parent the object, in which this specific one is embedded
     */
    protected ContainableModelElement(String name, IModelElement parent) {
        super(name);
        this.parent = parent;
    }

    @Override
    public final IModelElement getParent() {
        return parent;
    }
    
    /**
     * Returns the topLevel parent.
     * @return should be the project
     */
    public final IModelElement getTopLevelParent() {
        IModelElement parent = getParent();
        if (null != parent && !(parent instanceof Project)) {
            ContainableModelElement immidiateParent = (ContainableModelElement) parent;
            parent = immidiateParent.getTopLevelParent();
        }
        return parent;
    }

    /**
     * Returns the containing project.
     * 
     * @return the contaning project (may be <b>null</b> if there is none)
     */
    public final Project getProject() {
        IModelElement parent = getParent();
        while (null != parent && !(parent instanceof Project)) {
            parent = parent.getParent();
        }
        return (parent instanceof Project) ? (Project) parent : null;
    }
    
    /**
     * Method to check whether the parent is a topLevel-element.
     * @return true, if the parent is the project, otherwise false
     */
    public final boolean isTopLevel() {
        boolean top = false;
        if (parent instanceof Project) {
            top = true;
        }
        return top;
    }
    
    @Override
    public String getNameSpace() {
        String namespace;
        if (null == parent) {
            namespace = "";
        } else {
            IModelElement p = parent;
            while (null != p && p.isTransparent()) {
                p = p.getParent();
            }
            if (null == p) {
                namespace = "";
            } else {
                if (p instanceof DecisionVariableDeclaration) {
                    // actually a special case for container
                    namespace = p.getNameSpace();
                } else {
                    namespace = p.getQualifiedName();
                }
            }
        }
        return namespace;
    }
    
    @Override
    public String getQualifiedName() {
        String result = getNameSpace();
        if (result.length() > 0) {
            result += "::" + getName();
        } else {
            result = getName();
        }
        return result;
    }

    
    /**
     * Changes the parent object. Note, that this operation
     * is necessary (although not intended) to resolve some
     * of the cycles in creating compounds or temporary variables.
     * 
     * @param parent the parent element
     */
    public final void setParent(IModelElement parent) {
        this.parent = parent;
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        //do nothing
    }
    
}
