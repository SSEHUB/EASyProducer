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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;

/**
 * Debug / printing support.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("println")
public class Println implements IVilType {

    /**
     * Just prints to the instantiator tracer.
     *  
     * @param object the object to be printed
     */
    @OperationMeta(trace = false)
    public static void println(Object object) {
        TracerFactory.createInstantiatorTracer().traceMessage(StringValueHelper.getStringValue(object, null));
    }
    
}
