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
package net.ssehub.easy.dslCore.ui.listeners;

/**
 * Defines the interface of a control to be used with the simple model processing listener.
 * 
 * @author Holger Eichelberger
 */
public interface IControl {

    /**
     * Notifies Sets the display status to disabled or enabled.
     * 
     * @param key optional information that uniquely identifies the caller in order to aggregate the overall status 
     *     (may be <b>null</b>)
     * @param enabled the next display status
     */
    public void setEnabled(IAggregatableListener key, boolean enabled);
    
}
