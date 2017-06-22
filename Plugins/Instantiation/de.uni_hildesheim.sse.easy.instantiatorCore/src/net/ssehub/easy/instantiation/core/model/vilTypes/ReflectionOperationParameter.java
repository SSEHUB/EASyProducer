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

import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * Implements a simple operation parameter descriptor filled by reflection.
 * 
 * @author Holger Eichelberger
 */
class ReflectionOperationParameter implements IMetaParameterDeclaration {

    private String name;
    private TypeDescriptor<?> type;
    private Expression dflt;

    /**
     * Creates a reflection operation parameter.
     * 
     * @param name the name of the parameter
     * @param type the type of the parameter
     * @param dflt the default value expression, may be <b>null</b> for none, must comply with <code>type</code>
     */
    ReflectionOperationParameter(String name, TypeDescriptor<?> type, Expression dflt) {
        this.name = name;
        this.type = type;
        this.dflt = dflt;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public TypeDescriptor<?> getType() {
        return type;
    }

    @Override
    public Expression getExpression() {
        return dflt;
    }
    
    @Override
    public String toString() {
        return "named reflection operation parameter " + name + " " + type.getVilName() + " " + dflt;
    }

}
