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

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a let expression, i.e. a local variable declaration which 
 * can be used in the attached expression.
 * 
 * @author Holger Eichelberger
 */
public class Let extends ConstraintSyntaxTree {

    private DecisionVariableDeclaration var;
    private ConstraintSyntaxTree inExpr;
    
    /**
     * Creates a new let expression.
     * @param var the local variable
     * @param inExpr the expression the local variable may be used in
     */
    public Let(DecisionVariableDeclaration var, ConstraintSyntaxTree inExpr) {
        this.var = var;
        this.inExpr = inExpr;
    }
    
    /**
     * Returns the local variable.
     * 
     * @return the local variable
     */
    public DecisionVariableDeclaration getVariable() {
        return var;
    }
    
    /**
     * Returns the initialization expression.
     * 
     * @return the initialization expression
     */
    public ConstraintSyntaxTree getInitExpression() {
        return var.getDefaultValue();
    }
    
    /**
     * Returns the expression the local variable may be used in.
     * 
     * @return the expression using the local variable
     */
    public ConstraintSyntaxTree getInExpression() {
        return inExpr;
    }
    
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return inExpr.inferDatatype();
    }

    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitLet(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof Let) {
            Let other = (Let) obj;
            equals = inExpr.equals(other.inExpr);
            equals &= var.equals(other.var);
        }
        return equals;
    }
    
    @Override
    public int hashCode() {
        int hashCode = inExpr.hashCode();
        hashCode *= var.hashCode();
        return hashCode;
    }

}
