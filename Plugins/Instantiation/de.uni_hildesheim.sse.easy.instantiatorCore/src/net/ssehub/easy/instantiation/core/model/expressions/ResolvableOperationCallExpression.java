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
package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a call to a resolvable operation, i.e., a "function pointer".
 * 
 * @author Holger Eichelberger
 */
public class ResolvableOperationCallExpression extends AbstractCallExpression {
    
    private VariableDeclaration var;
    private CallArgument[] arguments;

    /**
     * Creates a resolvable operation call expression, i.e., a call expression pointing to a certain operation but which
     * is called through a (parameter) variable. This is used for resolved "function pointers".
     * 
     * @param var the variable holding an expression to the resolved operation {@link ResolvableOperationExpression} 
     * @param arguments the arguments for the call
     * @throws VilException in case that no arguments are given, or the arguments do not match the parameters provided
     *     by the type of <code>var</code>
     */
    public ResolvableOperationCallExpression(VariableDeclaration var, CallArgument[] arguments) throws VilException {
        super(var.getName(), false);
        this.var = var;
        this.arguments = arguments;
        if (null == arguments) {
            throw new VilException("no arguments provided (null)", VilException.ID_INTERNAL);
        }
        TypeDescriptor<?> varType = var.getType();
        if (!TypeRegistry.resolvableOperationType().isAssignableFrom(varType)) {
            throw new VilException("var is not of type resolvable operation", VilException.ID_INTERNAL);
        }
        int genParamCount = varType.getGenericParameterCount();
        if (genParamCount < 1) {
            throw new VilException("no generic parameter of var", VilException.ID_INTERNAL);
        }
        if (arguments.length != genParamCount - 1) {
            throw new VilException("number of provided operation and call does not match", VilException.ID_INTERNAL);
        }
        for (int a = 0; a < arguments.length; a++) {
            if (!varType.getGenericParameterType(a).isAssignableFrom(arguments[a].getExpression().inferType())) {
                throw new VilException("argument number " + a + " does not match declared parameter type", 
                    VilException.ID_INTERNAL);
            }
        }
    }
    
    /**
     * Returns the variable holding the expression to the function pointer.
     * 
     * @return the variable
     */
    public VariableDeclaration getVariable() {
        return var;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public String getVilSignature() {
        return getSignature(getName(), arguments);
    }

    @Override
    public int getArgumentsCount() {
        return arguments.length;
    }

    @Override
    public CallArgument getArgument(int index) {
        return arguments[index];
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> type = var.getType(); // by convention
        return type.getGenericParameterType(type.getGenericParameterCount() - 1);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitResolvableOperationCallExpression(this);
    }

}
