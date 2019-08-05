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
 * Represents a comment in the source of an IVML file. Instances
 * of this model element are required to properly restore the input
 * IVML file (after modifications) by using output iterators. Each
 * comment consists of its text (may be multiple successive comments
 * and whitespaces without outer model element in between) and a position
 * which indicates where in the following model element to attach this
 * comment to (supported constant definitions are given in this class).<br/>
 * <b>Please note:</b> Currently we realize a simplified model for the 
 * comments, i.e. only comments which describe language constructs but 
 * not inlined comments within individual language constructs are implemented 
 * by this class and by specialized subclasses.
 * 
 * @author Holger Eichelberger
 */
public class Comment extends ContainableModelElement {

    /**
     * Constructor for serialization.
     */
    Comment() {
        super(null, null);
    }
    
    /**
     * Creates a new comment element.
     * 
     * @param comment the comment (to be stored as the "name" of this model element)
     * @param parent the model element, in which this specific one is embedded
     */
    public Comment(String comment, IModelElement parent) {
        super(comment, parent);
    }
    
    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitComment(this);
    }
    
    /**
     * Returns the comment assigned to the given model <code>element</code>.
     * 
     * @param element the element to return the comment for
     * @return the assigned comment (or <b>null</b> if none is assigned), 
     *     <b>null</b> by default
     */
    public Comment getComment(Object element) {
        return null;
    }

    /**
     * Assigns a <code>comment</code> to the given model <code>element</code>.
     * This method is not implemented.
     * 
     * @param element the element to assign the comment to
     * @param comment the comment to assign the element to
     */
    public void assignComment(Object element, Comment comment) {
    }
    
    @Override
    public String getNameSpace() {
        return "";
    }

    @Override
    public String getQualifiedName() {
        return "";
    }

}
