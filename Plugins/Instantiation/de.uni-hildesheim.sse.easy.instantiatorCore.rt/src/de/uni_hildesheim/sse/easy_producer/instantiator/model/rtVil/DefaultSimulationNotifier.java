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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;

/**
 * Provides a default implementation of an empty (no action) simulation notifier and 
 * a configuration rollback at the end of execution.
 * 
 * @author Holger Eichelberger
 */
public class DefaultSimulationNotifier implements ISimulationNotifier {

    public static final ISimulationNotifier INSTANCE = new DefaultSimulationNotifier();

    /**
     * Prevents external creation.
     */
    private DefaultSimulationNotifier() {
    }
    
    @Override
    public void notifyOperationCall(OperationDescriptor operation, Object[] args) {
    }

    @Override
    public boolean doRollbackSimulation() {
        return true;
    }

}
