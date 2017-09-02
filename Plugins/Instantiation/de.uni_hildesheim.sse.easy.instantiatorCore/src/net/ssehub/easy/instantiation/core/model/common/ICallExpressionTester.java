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
package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;

/**
 * The interface of a dynamic call expression tester.
 *
 * @param <M> the specific type of model
 * @param <O> the specific type of operation
 * @param <E> the specific call expression
 * @param <V> the specific class of variables
 *  
 * @author Holger Eichelberger
 */
public interface ICallExpressionTester <M extends IResolvableModel<V, M>, O extends IResolvableOperation<V>, 
    E extends ModelCallExpression<V, M, O>, V extends IMetaParameterDeclaration> {

    /**
     * Creates a call expression and tries to resolve the call.
     * 
     * @param model the model to resolve on
     * @param isSuper whether it is a super call
     * @param fromModel the model which issues the call
     * @return the created call expression in case of success, <b>null</b> else
     */
    public E createAndCheckCall(M model, boolean isSuper, M fromModel);
    
    /**
     * Returns the last exception produced by {@link #createAndCheckCall(IResolvableModel, boolean)}.
     * 
     * @return the last exception or <b>null</b>
     */
    public VilException getLastException();
    
}
