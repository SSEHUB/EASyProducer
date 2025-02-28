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

/**
 * Defines the interface for a model element.
 * 
 * @author Holger Eichelberger
 */
public interface IModelElement {

    /** 
     * Returns the name of the model element.
     * @return Name of this model element.
     */
    public String getName();
    
    /** 
     * Returns the comment of the model element.
     * 
     * @return Comment of this model element.
     * 
     * @see #setComment(String)
     */
    public String getComment();
    
    /**
     * Changes the (possibly internationalized) comment of this model element.
     * Please note that comments are not stored in the model rather than in additional
     * resource files associated to the model. Use 
     * {@link net.ssehub.easy.varModel.management.ModelCommentsPersistencer
     * #storeComments(de.uni_hildesheim.sse.model.management.ProjectInfo)}
     * for storing comments. Loading of comments is done as part of loading models.
     * 
     * @param comment the new comment, turned into an empty string if <code>null</code>
     */
    public void setComment(String comment);
    
    /** 
     * Returns the namespace introduced by this model element.
     * @return the namespace introduced by this model element.
     */
    public String getNameSpace();
    
    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor);
    
    /**
     * Returns the qualified name of this element.
     * 
     * @return the qualified name
     */
    public String getQualifiedName();
    
    /**
     * Returns the UniqueName of this model element.
     * @return the unique name of this model element
     */
    public String getUniqueName(); 

    /**
     * Propagates an attribute application from the parent to this element or contained elements. This may imply the 
     * creation of clones of the given <code>attribute</code>.
     * 
     * @param attribute the attribute to be propagated
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    public boolean propagateAttribute(Attribute attribute);
    
    /**
     * Returns whether this element is transparent regarding the naming hierarchy.
     * 
     * @return <code>true</code> if it is transparent, <code>false</code> else
     */
    public boolean isTransparent();
 
    /**
     * Returns the parent model element.
     * 
     * @return the parent model element (may be <b>null</b>)
     */
    public IModelElement getParent();
    
}
