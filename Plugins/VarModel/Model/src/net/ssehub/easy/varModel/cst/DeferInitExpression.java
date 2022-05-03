/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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
 * An expression to indicate that the contained expression shall not be evaluated
 * rather than used as value. The need may occur when translating compound and constraint
 * initializer values into expression to obtain full values for default assignment, which is
 * permitted in EASy per variable only once.
 * 
 * This is an internal, temporary constraint node and thus does not support visiting.
 * 
 * @author Holger Eichelberger
 */
public class DeferInitExpression extends ConstraintSyntaxTree {

    private ConstraintSyntaxTree cst;
    
    /**
     * Creates the expression.
     * 
     * @param cst the deferred expression
     */
    public DeferInitExpression(ConstraintSyntaxTree cst) {
        this.cst = cst;
    }
    
    /**
     * Returns the deferred expression.
     * 
     * @return the expression
     */
    public ConstraintSyntaxTree getExpression() {
        return cst;
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitDeferInitExpression(this);
    }

    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return cst.inferDatatype();
    }

}
