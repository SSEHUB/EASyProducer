/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.IModelElement;

/**
 * Class to specify the container and compound.
 * @author beck
 */
public abstract class StructuredDatatype extends CustomDatatype {
    
    /**
     * Constructor.
     * @param name the name of the object.
     * @param singleton the instance which knows the operations
     * @param parent the object, in which this specific one is embedded
     */
    protected StructuredDatatype(String name, DelegatingType singleton, IModelElement parent) {
        super(name, singleton, parent);
    }

}
