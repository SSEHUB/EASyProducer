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

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a structured comment which stores relations between nested model
 * elements of the following model element and the comments stored in this
 * comment. The comments assigned to the following model element shall therefore
 * be stored in a structured comment.
 * 
 * @author Holger Eichelberger
 */
public class StructuredComment extends Comment {

    /**
     * Stores the sub comments.
     */
    private Map<Object, Comment> comments = null;
    
    /**
     * Creates a new structured comment element.
     * 
     * @param comment the comment (to be stored as the "name" of this model element)
     * @param parent the model element, in which this specific one is embedded
     */
    public StructuredComment(String comment, IModelElement parent) {
        super(comment, parent);
    }
    
    /**
     * Returns the comment assigned to the given model <code>element</code>.
     * 
     * @param element the element to return the comment for
     * @return the assigned comment (or <b>null</b> if none is assigned)
     */
    @Override
    public Comment getComment(Object element) {
        Comment result;
        if (null == comments) {
            result = null;
        } else {
            result = comments.get(element);
        }
        return result;
    }

    /**
     * Assigns a <code>comment</code> to the given model <code>element</code>.
     * 
     * @param element the element to assign the comment to
     * @param comment the comment to assign the element to
     */
    @Override
    public void assignComment(Object element, Comment comment) {
        if (null == comments) {
            comments = new HashMap<Object, Comment>();
        }
        comments.put(element, comment);
    }
    
}
