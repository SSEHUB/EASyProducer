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

import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;

/**
 * Implements a rule node.
 * 
 * @author Holger Eichelberger
 */
class RuleTreeNode extends TreeNode {
    
    private Rule rule;

    /**
     * Creates a rule node.
     * 
     * @param rule the rule node
     */
    RuleTreeNode(Rule rule) {
        super(null, null);
        this.rule = rule;
    }
    
    @Override
    public String getText() {
        String result = rule.getName() + "(";
        for (int p = 0; p < rule.getParameterCount(); p++) {
            if (p > 0) {
                result += ", ";
            }
            VariableDeclaration decl = rule.getParameter(p);
            result += decl.getType().getVilName();
            result += " ";
            result += decl.getName();
        }
        result += ")";
        return result;
    }

    /**
     * Returns the represented rule.
     * 
     * @return the rule
     */
    Rule getRule() {
        return rule;
    }
    
    @Override
    InsertionPoint supportedInsertionPoint(Insertable insertable) {
        InsertionPoint result;
        switch (insertable) {
        case INSTANTIATOR:
            result = InsertionPoint.AFTER_THIS; // only within
            break;
        case RULE:
            result = InsertionPoint.AROUND_SIBLINGS;
            break;
        default:
            result = InsertionPoint.NONE;
            break;
        }
        return result;
    }
    
}