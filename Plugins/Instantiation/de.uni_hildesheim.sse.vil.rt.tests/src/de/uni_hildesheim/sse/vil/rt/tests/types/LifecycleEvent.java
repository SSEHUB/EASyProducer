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
package de.uni_hildesheim.sse.vil.rt.tests.types;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassMeta;

/**
 * Defines a lifecycle event.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = "LifecycleEvent")
public class LifecycleEvent implements IAdaptationEvent {

    private Status status;
    private String pipeline;
    
    /**
     * Defines the lifecycle phase / status.
     * 
     * @author Holger Eichelberger
     */
    @ClassMeta(name = "LifecycleEventStatus")
    public enum Status {
        START,
        END
    }
    
    /**
     * Creates a lifecycle event.
     * 
     * @param pipeline the pipeline id
     * @param status the status
     */
    public LifecycleEvent(String pipeline, Status status) {
        this.status = status;
        this.pipeline = pipeline;
    }
    
    /**
     * Returns the status.
     * 
     * @return the satus
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Returns the pipeline name.
     * 
     * @return the pipeline name
     */
    public String getPipeline() {
        return pipeline;
    }
}
