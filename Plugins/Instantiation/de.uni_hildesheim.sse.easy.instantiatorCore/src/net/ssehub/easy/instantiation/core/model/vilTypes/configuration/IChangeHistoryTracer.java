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

import net.ssehub.easy.varModel.model.values.Value;

/**
 * Allows tracing configuration history changes.
 * 
 * @author Holger Eichelberger
 */
public interface IChangeHistoryTracer {

    /**
     * Recording the original value for <code>variable</code>.
     * 
     * @param variable the variable the original value is recorded for
     * @param value the original value
     */
    public void recordedOriginalVariable(AbstractIvmlVariable variable, Value value);

    /**
     * Recorded a change.
     * 
     * @param variable the variable the change is recorded for
     * @param value the value before the change
     */
    public void recordedChangedVariable(AbstractIvmlVariable variable, Value value);

    /**
     * Start committing a change set.
     * 
     * @param config the underlying configuration
     */
    public void committing(Configuration config);

    /**
     * Committed a change set.
     * 
     * @param config the underlying configuration
     */
    public void committed(Configuration config);

    /**
     * Rolling back a change set.
     * 
     * @param config the underlying configuration
     */
    public void rollingBack(Configuration config);

    /**
     * Rolled back a change set.
     * 
     * @param config the underlying configuration
     */
    public void rolledBack(Configuration config);
    
    /**
     * Started a new change set.
     * 
     * @param config the underlying configuration
     */
    public void started(Configuration config);
    
}
