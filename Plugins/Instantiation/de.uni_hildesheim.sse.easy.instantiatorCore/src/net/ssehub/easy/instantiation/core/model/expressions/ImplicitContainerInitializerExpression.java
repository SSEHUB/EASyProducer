/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * A container initializer expression that can be internally used to iterate over / declare
 * container operations over a single value rather than a container. This class was introduced
 * to enable OCL/IVML compliance.
 * 
 * @author Holger Eichelberger
 */
public class ImplicitContainerInitializerExpression extends ContainerInitializerExpression {

    /**
     * Creates a new implicit container initializer expression. Implicit initializers
     * have exactly on init expression, here taken from a call argument.
     * 
     * @param argument the call argument holding the initializer expression
     */
    public ImplicitContainerInitializerExpression(CallArgument argument) {
        this(argument.getExpression());
    }
    
    /**
     * Creates a new implicit container initializer expression. Implicit initializers
     * have exactly on init expression.
     * 
     * @param initExpression the initializer expression, either logical expressions
     *   or container initializer expression
     */
    public ImplicitContainerInitializerExpression(Expression initExpression) {
        super(toArray(initExpression));
    }
    
    /**
     * Internal constructor for set initialization.
     * 
     * @param initExpressions the initializer expressions, either logical expressions
     *   or container initializer expression
     * @param type the type of the expression
     */
    protected ImplicitContainerInitializerExpression(Expression[] initExpressions, TypeDescriptor<?> type) {
        super(initExpressions, type);
    }
    
    /**
     * Turns the given expression into an array with one element.
     * 
     * @param ex the expression
     * @return the array
     */
    private static Expression[] toArray(Expression ex) {
        Expression[] result = new Expression[1];
        result[0] = ex;
        return result;
    }
    
    @Override
    public boolean isImplicit() {
        return true;
    }
    
    @Override
    protected ContainerInitializerExpression createInitExpression(Expression[] initExpressions, 
        TypeDescriptor<?> type) {
        return new ImplicitContainerInitializerExpression(initExpressions, type);        
    }
    
}
