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
package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a parenthesis. The value of a parenthesis is just the 
 * value of the contained expression. This class is used to represent
 * explicit sub expressions.
 * 
 * @author Holger Eichelberger
 */
public class Parenthesis extends ConstraintSyntaxTree {

    /**
     * Stores the expression in the parenthesis.
     */
    private ConstraintSyntaxTree expr;
    
    /**
     * Creates a new parenthesis node.
     * 
     * @param expr the nested expression
     */
    public Parenthesis(ConstraintSyntaxTree expr) {
        this.expr = expr;
    }

    /**
     * Returns the nested expression.
     * 
     * @return the nested expression
     */
    public ConstraintSyntaxTree getExpr() {
        return expr;
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return expr.inferDatatype();
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitParenthesis(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof Parenthesis) {
            equals = expr.equals(((Parenthesis) obj).expr);
        }
        return equals;        
    }
    
    @Override
    public int hashCode() {
        return expr.hashCode() * 13;
    }

    @Override
    public String toString() {
        return "(" + expr.toString() + ")";
    }
}
