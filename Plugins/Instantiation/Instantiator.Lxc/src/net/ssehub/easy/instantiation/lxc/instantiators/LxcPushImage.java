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
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to push a LXC image to a repository.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcPushImage")
public class LxcPushImage extends AbstractLxcInstantiator {

    // checkstyle: stop exception type check

    /**
     * Copies a image from local to trusted remote repository or the other way
     * if imageName consists of remote:image-name.
     * 
     * @param imageName name of the image to be copied, for local images the name is
     *     enough for remote images use this syntax: "repository:image-name"
     * @param repository (destination), the target trusted repository, "repository:"
     * @param newImageName the image a name for new repository otherwise if empty it will
     *     be nameless
     * @return {@code true} if removed
     * @throws VilException in case of artifact / parameter problems
     */
    public static boolean lxcPushImage(String imageName, String repository, String newImageName) throws VilException {
        try {

            String copyImage = "lxc image copy ";

            if (!"".equals(newImageName)) {
                createCmdClient().executeLinuxCmd(
                                copyImage + " " + imageName + " " + repository + " --alias " + newImageName);
            } else {
                createCmdClient().executeLinuxCmd(copyImage + " " + imageName + " " + repository);
            }

            final String fallbackTaskDescription = "LXC activity";
            TracerFactory.ensureTasks(fallbackTaskDescription);

            return true;
        } catch (Exception e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            } else {
                return false;
            }
        }
    }

    // checkstyle: resume exception type check

}
