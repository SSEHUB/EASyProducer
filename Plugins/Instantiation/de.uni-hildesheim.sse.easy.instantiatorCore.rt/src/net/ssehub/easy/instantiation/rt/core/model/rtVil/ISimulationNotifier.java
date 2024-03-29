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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;

/**
 * Notified if operations are not executed due to the rt-VIL simulation mode.
 * 
 * @author Holger Eichelberger
 */
public interface ISimulationNotifier {

    /**
     * Notifies this instance that <code>operation</code> is not being executed
     * due to the simulation mode.
     * 
     * @param operation the operation
     * @param args the operation call arguments
     */
    public void notifyOperationCall(OperationDescriptor operation, Object[] args);
    
    /**
     * Returns whether the ongoing simulation shall be rolled back or whether changes
     * to the model shall be kept.
     * 
     * @return <code>true</code> for roll back, <code>false</code> else
     */
    public boolean doRollbackSimulation();

}
