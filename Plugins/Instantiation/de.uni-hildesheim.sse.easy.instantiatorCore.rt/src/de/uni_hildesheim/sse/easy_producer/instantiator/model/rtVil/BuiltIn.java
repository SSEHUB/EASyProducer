/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.serializer.SerializerPlugin;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IRegistration;
import de.uni_hildesheim.sse.persistency.xml.Extensions;

/**
 * Initializes built-in rt-VIL types.
 * 
 * @author Holger Eichelberger
 */
public class BuiltIn implements IRegistration {

    // public or implicit no-arg constructor

    /**
     * Default built-in types. Called directly by test initialization.
     */
    public static synchronized void initialize() {
        de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.types.BuiltIn.initialize();
        Extensions.register(new SerializerPlugin<Object>());
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        initialize();
    }
    
    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
    }
}
