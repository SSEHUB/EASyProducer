/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Defines a deferrable resolvable operation expression, i.e., a currently unresolved "function pointer".
 * This is needed, as all functions and operations are only known at the end of the translation process, while
 * the initialization expressions of global variables are (currently) resolved before.
 * 
 * @author Holger Eichelberger
 */
class DeferredResolvableOperationExpression extends Expression {

    private transient de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration decl;
    private transient TypeDescriptor<?> varType;
    private transient Expression init;
    
    /**
     * Creates a resolvable operation expression.
     * 
     * @param decl the Ecore variable declaration object
     * @param varType the actual variable type
     * @param init the initialization expression
     */
    DeferredResolvableOperationExpression(
        de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration decl, TypeDescriptor<?> varType, 
        Expression init) {
        this.decl = decl;
        this.varType = varType;
        this.init = init;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.anyType(); // so that it basically matches
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return null; // shall not be visited, rather than replaced
    }
    
    /**
     * Returns the ECore variable declaration.
     * 
     * @return the variable declaration
     */
    de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration getDecl() {
        return decl;
    }
    
    /**
     * Returns the variable type.
     * 
     * @return the variable type
     */
    TypeDescriptor<?> getVarType() {
        return varType;
    }
    
    /**
     * Returns the initialization expression.
     * 
     * @return the initialization expression
     */
    Expression getInit() {
        return init;
    }

}
