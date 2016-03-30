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

import net.ssehub.easy.instantiation.core.model.buildlangModel.StrategyCallExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.StrategyCallExpression.Type;

/**
 * Implements an element node for strategy call expressions.
 * 
 * @author Holger Eichelberger
 */
class StrategyCallExpressionTreeNode extends CallExpressionTreeNode {
    
    /**
     * Implements an element tree node.
     * 
     * @param parent the parent node
     * @param elt the VIL strategy call expression
     */
    StrategyCallExpressionTreeNode(TreeNode parent, StrategyCallExpression elt) {
        super(parent, elt);
        // TODO set image
    }
    
    @Override
    StrategyCallExpression getElement() {
        return (StrategyCallExpression) super.getElement();
    }
    
    @Override
    public String getText() {
        StrategyCallExpression ex = getElement();
        String result;
        if (Type.EXECUTE == ex.getType()) {
            result = "execute";
        } else {
            result = "";
        }
        return result + super.getText();
    }
    
}