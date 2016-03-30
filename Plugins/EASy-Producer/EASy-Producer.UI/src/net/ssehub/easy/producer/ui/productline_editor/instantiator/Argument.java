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
package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Represents a user-specified call argument.
 *
 * @author Holger Eichelberger
 */
class Argument {

    private IMetaType type;
    private String parameterType;
    private String argument = "";

    /**
     * Creates a call argument.
     * 
     * @param type the type of the argument
     */
    Argument(IMetaType type) {
        this.type = type;
        if (type instanceof TypeDescriptor<?>) {
            this.parameterType = ((TypeDescriptor<?>) type).getVilName();
        } else {
            this.parameterType = type.getName();    
        }
    }
    
    /**
     * Returns the parameter type as String.
     * 
     * @return the parameter type as string
     */
    public String getParameterType() {
        return parameterType;
    }
    
    /**
     * Returns the current argument (expression).
     * 
     * @return the current argument
     */
    public String getArgument() {
        return argument;
    }
    
    /**
     * Changes the argument (expression).
     * 
     * @param argument the new argument expression
     */
    public void setArgument(String argument) {
        this.argument = null == argument ? "" : argument;
    }
 
    /**
     * Returns the actual type of the argument.
     * 
     * @return the type
     */
    public IMetaType getType() {
        return type;
    }
    
}
