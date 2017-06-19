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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;

/**
 * Defines the interface of a parameter declaration.
 * 
 * @author Holger Eichelberger
 */
public interface IMetaParameterDeclaration extends IResolvable, IVariable {

    /**
     * Returns the type of this variable.
     * 
     * @return the type of this variable
     */
    public TypeDescriptor<?> getType();
    
    /**
     * Get the (default) value of this variable.
     * 
     * @return The (default) value of this variable of <b>null</b> if this variable is unassigned.
     */
    public Expression getExpression();

}
