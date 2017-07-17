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
package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * An optional factory turning in-place commands into language-specific expressions. If none is given, 
 * in-place commands shall not be resolved but shall remain as string expressions.
 *
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public interface IStringResolverFactory<I extends VariableDeclaration> {

    /**
     * Creates an alternative expression.
     * 
     * @param condition the condition deciding between the alternatives
     * @param thenEx the then expressions
     * @param elseEx the optional else expressions (may be <b>null</b>)
     * @return an alternative expression (may be <b>null</b> if not supported)
     * @throws VilException if the expression cannot be created
     */
    public Expression createIfExpression(Expression condition, List<Expression> thenEx, List<Expression> elseEx) 
        throws VilException;

    /**
     * Creates a for-loop expression.
     * 
     * @param iterator the iterator variable declaration including initialization
     * @param init the initialization for the iterator (a container expression)
     * @param separator optional separator expression (may be <b>null</b>)
     * @param body the for body expressions
     * @return a for-loop expression (may be <b>null</b> if not supported)
     * @throws VilException if the expression cannot be created
     */
    public Expression createForExpression(I iterator, Expression init, Expression separator, List<Expression> body) 
        throws VilException;
 
    /**
     * Creates a variable.
     * 
     * @param name the name of the variable
     * @param initExpression the initialization expression determining the type of the iterator variable
     * @return the variable
     * @throws VilException if the variable cannot be created
     */
    public I createVariable(String name, Expression initExpression) throws VilException;
    
}
