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

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;

/**
 * Implements an element node for rule call expressions.
 * 
 * @author Holger Eichelberger
 */
class CallExpressionTreeNode extends ElementTreeNode<CallExpression> {
    
    /**
     * Implements an element tree node.
     * 
     * @param parent the parent node
     * @param elt the VIL rule call expression
     */
    CallExpressionTreeNode(TreeNode parent, CallExpression elt) {
        super(parent, elt);
    }
    
    @Override
    public String getText() {
        CallExpression ex = getElement();
        String result;
        switch (ex.getCallType()) {
        case EXTERNAL:
            result = "Java: ";
            // fallthrough
        case NORMAL:            
            result = ex.getQualifiedName();
            result += argumentsToString(ex, 0);
            break;
        case TRANSPARENT:
            result = ""; // shall not be created at all
            break;
        default:
            result = "";
            break;
        }
        return result;
    }
    
}