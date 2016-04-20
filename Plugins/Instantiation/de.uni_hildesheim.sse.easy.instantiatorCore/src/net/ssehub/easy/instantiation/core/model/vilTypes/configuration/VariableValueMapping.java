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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

/**
 * Stores overriding values for IVML elements. This approach is currently rather basic and needs further
 * refinement.
 * 
 * @author Holger Eichelberger
 */
public class VariableValueMapping {

    private static final IVariableValueMapper DEFAULT = new IVariableValueMapper() {

        @Override
        public boolean isValid(IvmlElement element) {
            return true;
        }

        @Override
        public boolean isEnacting(IvmlElement element) {
            return false;
        }

        @Override
        public Object getValue(IvmlElement element) {
            return null;
        }
        
    };

    private static IVariableValueMapper instance = DEFAULT;
    
    /**
     * Returns the actual mapper instance.
     * 
     * @return the actual instance
     */
    public static IVariableValueMapper getInstance() {
        return instance;
    }

    /**
     * Defines the actual mapper instance.
     * 
     * @param mapper the mapper, switch to default if <b>null</b>
     */
    public static void setInstance(IVariableValueMapper mapper) {
        if (null == mapper) {
            instance = DEFAULT;
        } else {
            instance = mapper;
        }
    }
    

}