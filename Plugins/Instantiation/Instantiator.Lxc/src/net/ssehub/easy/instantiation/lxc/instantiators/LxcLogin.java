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

import java.io.File;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to log into a LXC registry.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcLogin")
public class LxcLogin extends AbstractLxcInstantiator {

    /**
     * Logging into a registry/remote is not possible with the LXD-API Remotes
     * have to be added manually on the client-system Once trusted remotes can
     * be used and images can be copied or removed
     * 
     * Has to be called before any operation can be made, otherwise it will
     * fail. For now this Method sets the system properties to the needed
     * certificates.
     * 
     * @param baseDirectory
     *            the base directory
     * @throws VilException
     *             in case of artifact / parameter problems
     */
    public static void lxcLogin(String baseDirectory) throws VilException {
        System.setProperty("snap_cert", baseDirectory + File.separator + "snap/lxd/common/config/client.crt");
        System.setProperty("snap_key", baseDirectory + File.separator + "snap/lxd/common/config/client.key");
    }

}
