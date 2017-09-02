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

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.InPlaceImportCommand;
import net.ssehub.easy.instantiation.core.model.expressions.InPlaceVarDeclCommand;

/**
 * An extended template language string resolver factory. This factory 
 * creates expressions for in-place variable declarations and imports.
 * 
 * @author Holger Eichelberger
 */
public class StringReplacerFactory extends StringResolverFactory {

    public static final StringReplacerFactory INSTANCE = new StringReplacerFactory();
    
    // no state
    
    /**
     * Prevents external creation.
     */
    protected StringReplacerFactory() {
    }

    @Override
    public Expression createVarDeclExpression(InPlaceVarDeclCommand<VariableDeclaration> cmd) throws VilException {
        return new ContentVarDeclExpression(cmd.getDeclaration());
    }

    @Override
    public Expression createImportExpression(InPlaceImportCommand<VariableDeclaration> cmd) throws VilException {
        return new ContentImportExpression(cmd.getTemplate(), cmd.getVersionRestriction());
    }

    @Override
    public IVersionRestriction createVersionRestriction(Expression expression, VariableDeclaration variable) 
        throws VilException {
        try {
            return new ExpressionVersionRestriction(expression, variable);
        } catch (RestrictionEvaluationException e) {
            throw new VilException(e.getMessage(), e.getId());
        } 
    }

}
