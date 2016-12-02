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
package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Allows enabling or disabling tracing from VIL/VTL.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("enableTracing")
public class Tracing implements IVilType {

    /**
     * Enables or disables tracing on registered tracers for this thread.
     * 
     * @param enable enable or disable
     */
    public static void enableTracing(boolean enable) {
        net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer bTracer 
            = TracerFactory.getRegisteredBuildLanguageTracer();
        if (null != bTracer) {
            bTracer.enable(enable);
        }
        
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer tTracer 
            = TracerFactory.getRegisteredTemplateLanguageTracer();
        if (null != tTracer) {
            tTracer.enable(enable);
        }
    }
    
}
