/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.lxc.instantiators;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to log out from one or multiple registries.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcLogout")
public class LxcLogout extends AbstractLxcInstantiator {

    /**
     * No real logout for LXC. Providing a stub operation for now.
     * 
     * @param baseDirectory
     *            the base directory
     * @throws VilException
     *             in case of artifact / parameter problems
     */
    public static void lxcLogout(String baseDirectory) throws VilException {
    }
    
}
