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
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IStringResolverFactory;
import net.ssehub.easy.instantiation.core.model.expressions.InPlaceForCommand;
import net.ssehub.easy.instantiation.core.model.expressions.InPlaceIfCommand;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * The template language string resolver factory.
 * 
 * @author Holger Eichelberger
 */
public class StringResolverFactory implements IStringResolverFactory<VariableDeclaration> {

    public static final StringResolverFactory INSTANCE = new StringResolverFactory();
    
    // no state
    
    /**
     * Prevents external creation.
     */
    private StringResolverFactory() {
    }
    
    @Override
    public Expression createIfExpression(InPlaceIfCommand<VariableDeclaration> cmd) 
        throws VilException {
        return new ContentAlternativeExpression(cmd.getCondition(), cmd.getThenExpressions(), cmd.getElseExpressions());
    }

    @Override
    public Expression createForExpression(InPlaceForCommand<VariableDeclaration> cmd) throws VilException {
        return new ContentLoopExpression(cmd.getIterator(), cmd.getInit(), cmd.getSeparator(), cmd.getEndSeparator(), 
            cmd.getBody());
    }

    @Override
    public VariableDeclaration createVariable(String name, Expression initExpression) throws VilException {
        TypeDescriptor<?> type = initExpression.inferType();
        if (!type.isCollection()) {
            throw new VilException("Iterator initialization expression must be of type collection", 
                VilException.ID_INVALID_ITERATOR);
        } else {
            if (type.getGenericParameterCount() > 0) {
                type = type.getGenericParameterType(0);
            } else {
                type = TypeRegistry.anyType();
            }
        }
        return new VariableDeclaration(name, type, false, initExpression);
    }

}
