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
package net.ssehub.easy.instantiation.core.model.common;

/**
 * Something that can terminate a {@link ITerminatable} indirectly on demand.
 * 
 * @author Holger Eichelberger
 */
public interface ITerminator {
    
    /**
     * Registers a terminatable.
     * 
     * @param terminatable the terminatable
     */
    public void register(ITerminatable terminatable);

    /**
     * Unregisters a terminatable.
     * 
     * @param terminatable the terminatable
     */
    public void unregister(ITerminatable terminatable);

}
