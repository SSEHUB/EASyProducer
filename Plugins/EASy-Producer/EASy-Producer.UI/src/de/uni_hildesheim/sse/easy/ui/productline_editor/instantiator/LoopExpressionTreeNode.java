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

import net.ssehub.easy.instantiation.core.model.buildlangModel.IEnumeratingLoop;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;

/**
 * Implements an element node for loop expressions.
 * 
 * @author Holger Eichelberger
 */
class LoopExpressionTreeNode extends ElementTreeNode<IEnumeratingLoop> {
    
    /**
     * Implements an element tree node.
     * 
     * @param parent the parent node
     * @param elt the VIL map expression
     */
    LoopExpressionTreeNode(TreeNode parent, IEnumeratingLoop elt) {
        super(parent, elt);
    }
    
    @Override
    public String getText() {
        IEnumeratingLoop ex = getElement();
        String result = ex.getElementName();
        result += "(";
        for (int v = 0; v < ex.getVariablesCount(); v++) {
            if (v > 0) {
                result += ", ";
            }
            VariableDeclaration decl = ex.getVariable(v);
            result += decl.getType().getVilName() + " " + decl.getName();
        }
        result += ":";
        result += expressionToString(ex.getExpression());
        result += ")";
        return result;
    }
    
}