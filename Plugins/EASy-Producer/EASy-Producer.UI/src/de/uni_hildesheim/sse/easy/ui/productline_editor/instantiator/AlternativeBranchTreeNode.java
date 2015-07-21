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
package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

/**
 * Represents an alternative branch tree node.
 * 
 * @author Holger Eichelberger
 */
public class AlternativeBranchTreeNode extends TextTreeNode {

    /**
     * Creates a branch tree node.
     * 
     * @param parent the parent node
     * @param thenPart whether this node represents the then or the else part
     */
    AlternativeBranchTreeNode(TreeNode parent, boolean thenPart) {
        super(parent, thenPart ? null : null, thenPart ? "then" : "else"); // TODO insert image
    }

    @Override
    InsertionPoint supportedInsertionPoint(Insertable insertable) {
        InsertionPoint result;
        if (Insertable.INSTANTIATOR == insertable) {
            result = InsertionPoint.AFTER_THIS; // only between if and branch
        } else {
            result = super.supportedInsertionPoint(insertable);
        }
        return result;
    }
    
}
