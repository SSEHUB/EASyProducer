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

/** 
 * All elements a VarModel could contain.
 * @author Marcel Lueder
 */
public abstract class ModelElement implements IModelElement {
    private String name;
    private String comment = "";
    private boolean isUnique;
    
    /**
     * Constructor for the model element.
     * @param name Name of the model element
     */
    protected ModelElement(String name) {
        this.name = name;
        comment = null;
        isUnique = true;
    }
    
    @Override
    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    @Override
    public final String getComment() {
        return comment;
    }
    
    @Override
    public void setComment(String comment) {
        if (null == comment) {
            this.comment = "";
        } else {
            this.comment = comment;
        }
    }
    
    @Override
    public String getNameSpace() {
        return "";
    }
    
    @Override
    public String getQualifiedName() {
        return getName(); // we do not have a parent here
    }
    
    @Override
    public final String getUniqueName() {
        String uniqueName = getName();
        if (!isUnique) {
            uniqueName = getQualifiedName();
        }
        if (null == uniqueName) {
            uniqueName = "";
        }
        return uniqueName;
    }
    
    /**
     * Changes the name of this model element.
     * @param name the new name
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Searches for a specified attribute.
     * 
     * @param access the instance providing access to attributes
     * @param name the name of the attribute to search for
     * @return the attribute or <b>null</b> if not found
     */
    public static final Attribute findAttribute(IAttributeAccess access, String name) {
        Attribute result = null;
        for (int a = 0; null == result && a < access.getAttributesCount(); a++) {
            Attribute attr = access.getAttribute(a);
            if (attr.getName().equals(name)) {
                result = attr;
            }
        }
        return result;
    }
    
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        return true;
    }
    
    @Override
    public boolean isTransparent() {
        return false;
    }
    
    @Override
    public IModelElement getParent() {
        return null;
    }

}
