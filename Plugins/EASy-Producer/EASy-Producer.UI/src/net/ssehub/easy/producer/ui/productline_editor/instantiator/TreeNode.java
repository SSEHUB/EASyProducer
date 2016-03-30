/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import org.eclipse.swt.graphics.Image;

/**
 * A display tree node.
 * 
 * @author Holger Eichelberger
 */
abstract class TreeNode {
    
    private Image image;
    private TreeNode parent;
    private TreeNode[] children;
    
    /**
     * Denotes insertion points around this node.
     * 
     * @author Holger Eichelberger
     */
    enum InsertionPoint {
        
        /**
         * Directly before.
         */
        BEFORE_THIS,
        
        /**
         * Directly after.
         */
        AFTER_THIS,
        
        /**
         * Directly before/after.
         */
        AROUND_THIS,
        
        /**
         * Directly before or after the last child, before next sibling.
         */
        AROUND_SIBLINGS,
        
        /**
         * Not at all.
         */
        NONE;
    }
    
    /**
     * Language elements to be inserted.
     * 
     * @author Holger Eichelberger
     */
    enum Insertable {
        
        INSTANTIATOR,
        RULE
    }
    
    /**
     * Creates a tree node.
     * 
     * @param parent the parent node
     * @param image the image of the node (may be <b>null</b>)
     */
    TreeNode(TreeNode parent, Image image) {
        this.parent = parent;
        if (image == null) {
            this.image = ImageProvider.INSTANCE.getImage(this);
        } else {            
            this.image = image;
        }
    }
    
    /**
     * Returns the parent node.
     * 
     * @return the parent node (may be <b>null</b>)
     */
    TreeNode getParent() {
        return parent;
    }
    
    /**
     * Defines the children.
     * 
     * @param children the children
     */
    void setChildren(TreeNode[] children) {
        this.children = children;
    }
    
    /**
     * Returns whether this node has children.
     * 
     * @return <code>true</code> if this node has children, <code>false</code> else
     */
    boolean hasChildren() {
        return null != children && children.length > 0;
    }
    
    /**
     * Returns the children.
     * 
     * @return the children (may be <b>null</b>)
     */
    TreeNode[] getChildren() {
        return children;
    }
    
    /**
     * Returns the display image.
     * 
     * @return the display image (may be <b>null</b>)
     */
    Image getImage() {
        return image;
    }
    
    /**
     * Returns the display text.
     * 
     * @return the display text
     */
    abstract String getText();
    
    /**
     * Returns the supported insertion point within the tree for <code>insertable</code>.
     * 
     * @param insertable the element to be inserted
     * @return the supported rule insertion point
     */
    abstract InsertionPoint supportedInsertionPoint(Insertable insertable);

}