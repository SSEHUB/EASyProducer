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

import net.ssehub.easy.instantiation.core.model.buildlangModel.AlternativeExpression;

/**
 * Implements an element node for alternative expressions.
 * 
 * @author Holger Eichelberger
 */
class AlternativeExpressionTreeNode extends ElementTreeNode<AlternativeExpression> {
    
    /**
     * Implements an element tree node.
     * 
     * @param parent the parent node
     * @param elt the VIL map expression
     */
    AlternativeExpressionTreeNode(TreeNode parent, AlternativeExpression elt) {
        super(parent, elt);
    }
    
    @Override
    public String getText() {
        AlternativeExpression ex = getElement();
        String result = "if (";
        result += expressionToString(ex.getCondition());
        result += ")";
        return result;
    }
    
}