/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
 * Represents a conditional expression.
 * 
 * @author Holger Eichelberger
 */
public class IfThen extends ConstraintSyntaxTree {

    private ConstraintSyntaxTree ifExpr;
    private ConstraintSyntaxTree thenExpr;
    private ConstraintSyntaxTree elseExpr;
    private IDatatype result;

    /**
     * Constructor for serialization.
     */ 
    IfThen() {
    }
    
    /**
     * Creates a new if-then-else node.
     * 
     * @param ifExpr the condition expression
     * @param thenExpr the then-path-expression
     * @param elseExpr the else-path-expression
     */
    public IfThen(ConstraintSyntaxTree ifExpr, ConstraintSyntaxTree thenExpr, 
        ConstraintSyntaxTree elseExpr) {
        this.ifExpr = ifExpr;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    /**
     * Returns the condition expression.
     * 
     * @return the condition expression
     */
    public ConstraintSyntaxTree getIfExpr() {
        return ifExpr;
    }

    /**
     * Returns the then-expression.
     * 
     * @return the then-expression
     */
    public ConstraintSyntaxTree getThenExpr() {
        return thenExpr;
    }

    /**
     * Returns the else-expression.
     * 
     * @return the else-expression
     */
    public ConstraintSyntaxTree getElseExpr() {
        return elseExpr;
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null == result) {
            IDatatype ifType = ifExpr.inferDatatype();
            if (!BooleanType.TYPE.isAssignableFrom(ifType)) {
                throw new CSTSemanticException("if expression type ('"
                    + ifType.getName() + "') is not Boolean", CSTSemanticException.TYPE_MISMATCH);
            }
            IDatatype thenType = thenExpr.inferDatatype();
            IDatatype elseType = elseExpr.inferDatatype();
            if (!thenType.isAssignableFrom(elseType)) {
                throw new CSTSemanticException("types of then ('"
                    + thenType.getName() + "') and else ('" 
                    + elseType.getName() + "') part do not match", CSTSemanticException.TYPE_MISMATCH);
            }
            result = thenType;
        }
        return result;
    }

    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitIfThen(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof IfThen) {
            IfThen other = (IfThen) obj;
            equals = ifExpr.equals(other.ifExpr);
            equals &= thenExpr.equals(other.thenExpr);
            if (null != elseExpr) {
                equals &= elseExpr.equals(other.elseExpr);
            }
        }
        return equals;
    }
    
    @Override
    public int hashCode() {
        int hashCode = ifExpr.hashCode();
        hashCode *= thenExpr.hashCode();
        if (null != elseExpr) {
            hashCode *= elseExpr.hashCode();    
        }
        // result hashcode/equals implicit
        return hashCode;
    }

}
