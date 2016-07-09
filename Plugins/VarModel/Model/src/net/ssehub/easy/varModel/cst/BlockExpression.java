/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Represents a block of expressions. The type of the block as well as its value are determined by the last 
 * (non-comment) expression in the block.
 * 
 * @author Holger Eichelberger
 */
public class BlockExpression extends ConstraintSyntaxTree {

    private ConstraintSyntaxTree[] exprs;
    private IDatatype type;
    
    /**
     * Creates a block expression.
     * 
     * @param exprs the expressions in the block
     * @throws CSTSemanticException in case that no expressions are given
     */
    public BlockExpression(ConstraintSyntaxTree[] exprs) throws CSTSemanticException {
        this.exprs = exprs;
        if (null == exprs || exprs.length == 0) {
            throw new CSTSemanticException("no expressions", CSTSemanticException.ILLEGAL);
        }
    }

    /**
     * Returns the number of expressions.
     * 
     * @return the number of expressions
     */
    public int getExpressionCount() {
        return exprs.length;
    }
    
    /**
     * Returns the specified expression.
     * 
     * @param index the index of the expression
     * @return the specified index
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getExpressionCount()}</code>
     */
    public ConstraintSyntaxTree getExpression(int index) {
        return exprs[index];
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitBlockExpression(this);
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null == type) {
            // just infer all but return the last type
            for (int e = 0; e < exprs.length; e++) {
                type = exprs[e].inferDatatype();
            }
        }
        return type;
    }

}
