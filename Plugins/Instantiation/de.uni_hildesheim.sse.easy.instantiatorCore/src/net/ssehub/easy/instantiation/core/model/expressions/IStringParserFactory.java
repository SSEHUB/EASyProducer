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
package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * An optional factory turning in-place commands into language-specific expressions. If none is given, 
 * in-place commands shall not be resolved but shall remain as string expressions.
 *
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public interface IStringParserFactory<I extends VariableDeclaration> {

    /**
     * Creates an alternative expression.
     * 
     * @param cmd the command to create an if-expression for
     * @return an alternative expression (may be <b>null</b> if not supported)
     * @throws VilException if the expression cannot be created
     */
    public Expression createIfExpression(InPlaceIfCommand<I> cmd) throws VilException;

    /**
     * Creates a for-loop expression.
     * 
     * @param cmd the command to create a for-loop expression for
     * @return a for-loop expression (may be <b>null</b> if not supported)
     * @throws VilException if the expression cannot be created
     */
    public Expression createForExpression(InPlaceForCommand<I> cmd) throws VilException;

    /**
     * Creates a variable declaration expression.
     * 
     * @param cmd the command to create a variable declaration expression for
     * @return a for-loop expression (may be <b>null</b> if not supported)
     * @throws VilException if the expression cannot be created
     */
    public Expression createVarDeclExpression(InPlaceVarDeclCommand<I> cmd) throws VilException;

    /**
     * Creates an import expression.
     * 
     * @param cmd the command to create an import expression for
     * @return a for-loop expression (may be <b>null</b> if not supported)
     * @throws VilException if the expression cannot be created
     */
    public Expression createImportExpression(InPlaceImportCommand<I> cmd) throws VilException;

    /**
     * Creates a variable.
     * 
     * @param name the name of the variable
     * @param initExpression the initialization expression determining the type of the iterator variable
     * @param asIterator whether the variable shall act as iterator
     * @return the variable
     * @throws VilException if the variable cannot be created
     */
    public I createVariable(String name, Expression initExpression, boolean asIterator) throws VilException;
    
    /**
     * Creates a non-constant variable declaration.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     * @return the variable declaration
     */
    public I createVariableDeclaration(String name, TypeDescriptor<?> type);
    
    /**
     * Creates a version restriction from the given <code>expression</code>.
     * 
     * @param expression the expression
     * @param variable the version variable
     * @return the version restriction or <b>null</b> if not supported
     * @throws VilException if the restriction cannot be created
     */
    public IVersionRestriction createVersionRestriction(Expression expression, I variable) throws VilException;
    
}
