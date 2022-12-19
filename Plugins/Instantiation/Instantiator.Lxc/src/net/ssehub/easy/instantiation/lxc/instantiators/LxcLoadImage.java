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

import java.io.IOException;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to load a LXC image.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcLoadImage")
public class LxcLoadImage extends AbstractLxcInstantiator {

    // checkstyle: stop exception type check

    /**
     * Loads/Imports a LXC image from archive into LXD .
     * 
     * @param archive
     *            the image archive to load (only unified tarball allowed)
     * @param name
     *            the name that the image is going to get
     * @return {@code true} if successful, {@code false}
     * @throws VilException
     *             in case of artifact / parameter problems
     */
    public static boolean lxcLoadImage(Path archive, String name) throws VilException {
        boolean ok = false;
        try {
            createCmdClient().executeLinuxCmd("lxc image import " + archive + " --alias " + name);
            ok = true;
        } catch (IOException e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        } catch (InterruptedException e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        }
        return ok;
    }

    // checkstyle: resume exception type check

}
