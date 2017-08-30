/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Creates a content expression/statement that declares and initializes a variable.
 * 
 * @author Holger Eichelberger
 */
public class ContentVarDeclExpression extends InContentExpression {

    private VariableDeclaration var;

    /**
     * Creates an instance.
     * 
     * @param var the variable
     */
    public ContentVarDeclExpression(VariableDeclaration var) {
        this.var = var;
    }
    
    /**
     * Returns the declared variable.
     * 
     * @return the variable
     */
    public VariableDeclaration getVariable() {
        return var;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitContentVarDeclExpression(this);
        } else {
            result = null;
        }
        return result;
    }

}
