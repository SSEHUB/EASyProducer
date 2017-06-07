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

import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Represents a multi-and expression.
 * 
 * @author Holger Eichelberger
 */
public class MultiAndExpression extends ConstraintSyntaxTree {

    private OCLFeatureCall[] expressions;
    
    /**
     * Creates a multi-and expression.
     * 
     * @param expressions the individual expressions
     * @throws CSTSemanticException if <code>expressions</code> or an expression within is <b>null</b>
     */
    public MultiAndExpression(OCLFeatureCall... expressions) throws CSTSemanticException {
        if (null == expressions) {
            throw new CSTSemanticException("No expressions given", CSTSemanticException.ILLEGAL);
        }
        for (int e = 0; e < expressions.length; e++) {
            if (null == expressions[e]) {
                throw new CSTSemanticException("Expression at index " + e + " is not given", 
                    CSTSemanticException.ILLEGAL);
            }
        }
        this.expressions = expressions;
    }

    /**
     * Returns the number of expressions represented by this expression.
     * 
     * @return the number of expressions
     */
    public int getExpressionCount() {
        return expressions.length;
    }
    
    /**
     * Returns the specified expression.
     * 
     * @param index the 0-based index 
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index &gt;={@link #getExpressionCount()}</code>
     */
    public OCLFeatureCall getExpression(int index) {
        return expressions[index];
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitMultiAndExpression(this);
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        for (int e = 0; e < expressions.length; e++) {
            if (!BooleanType.TYPE.isAssignableFrom(expressions[e].inferDatatype())) {
                throw new CSTSemanticException("Expression at index " + e + " does not evaluate to Boolean", 
                    CSTSemanticException.TYPE_MISMATCH);
            }
        }
        return BooleanType.TYPE;
    }

}
