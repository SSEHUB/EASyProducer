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
 * Allows VIL/VTL to notify the user about actual progress.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("notifyProgress")
public class ProgressNotifier implements IVilType {

    /**
     * Notifies the tracer about the actual process in order to inform the user.
     * 
     * @param actual the actual step (negative disables display)
     * @param max the maximum number of steps (may vary over time, negative disables display)
     */
    public static void notifyProgress(int actual, int max) {
        TracerFactory.progress(actual, max, null);
    }

    /**
     * Notifies the tracer about the actual process in order to inform the user.
     * 
     * @param actual the actual step (negative disables display)
     * @param max the maximum number of steps (may vary over time, negative disables display)
     * @param description an optional description of the step
     */
    public static void notifyProgress(int actual, int max, String description) {
        TracerFactory.progress(actual, max, description);
    }
    
}
