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

import java.io.StringWriter;

import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangWriter;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IArgumentProvider;

/**
 * Implements an element node. 
 * 
 * @param <E> the element type
 * @author Holger Eichelberger
 */
abstract class ElementTreeNode<E> extends TreeNode {
    
    private E elt;
    
    /**
     * Implements an element tree node.
     * 
     * @param parent the parent node
     * @param elt the VIL rule element
     */
    ElementTreeNode(TreeNode parent, E elt) {
        super(parent, null);
        this.elt = elt;
    }
    
    /**
     * Returns the element.
     * 
     * @return the element
     */
    E getElement() {
        return elt;
    }
    
    /**
     * Turns the arguments to a string.
     * 
     * @param provider the argument provider
     * @param start the start argument index (typically 0)
     * @return the printed arguments
     */
    String argumentsToString(IArgumentProvider provider, int start) {
        String result = "(";
        StringWriter tmp = new StringWriter();
        BuildlangWriter writer = new BuildlangWriter(tmp);
        for (int a = start; a < provider.getArgumentsCount(); a++) {
            if (a > start) {
                tmp.append(", ");
            }
            try {
                provider.getArgument(a).accept(writer);
            } catch (VilException e) {
                // ignore
            }
        }
        result += tmp.toString();
        result += ")";
        return result;
    }
    
    /**
     * Turns an expression into a string.
     * 
     * @param expression the expression
     * @return the related VIL string representation
     */
    String expressionToString(Expression expression) {
        StringWriter tmp = new StringWriter();
        BuildlangWriter writer = new BuildlangWriter(tmp);
        try {
            expression.accept(writer);
        } catch (VilException e) {
        }
        return writer.toString();
    }
    
    @Override
    InsertionPoint supportedInsertionPoint(Insertable insertable) {
        InsertionPoint result;
        switch (insertable) {
        case INSTANTIATOR:
            result = InsertionPoint.AROUND_THIS;
            break;
        case RULE:
            result = InsertionPoint.NONE;
            break;
        default:
            result = InsertionPoint.NONE;
            break;
        }
        return result;
    }
    
}