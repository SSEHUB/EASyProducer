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

import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinExpression;

/**
 * Implements an element node for join expressions.
 * 
 * @author Holger Eichelberger
 */
class JoinExpressionTreeNode extends ElementTreeNode<JoinExpression> {
    
    /**
     * Implements an element tree node.
     * 
     * @param parent the parent node
     * @param elt the VIL join expression
     */
    JoinExpressionTreeNode(TreeNode parent, JoinExpression elt) {
        super(parent, elt);
    }
    
    @Override
    public String getText() {
        JoinExpression ex = getElement();
        String result = "join(";
        for (int v = 0; v < ex.getVariablesCount(); v++) {
            if (v > 0) {
                result += ", ";
            }
            result += ex.getVariable(v).getName();
        }
        result += ") with (";
        result += expressionToString(ex.getCondition());
        result += ")";
        return result;
    }
    
}