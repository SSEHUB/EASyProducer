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
package net.ssehub.easy.instantiation.docker.instantiators;

import com.github.dockerjava.api.command.PushImageCmd;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.core.command.PushImageResultCallback;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to push a Docker image to a repository.
 * 
 * @author Monika Staciwa
 */
@SuppressWarnings("deprecation")
@Instantiator("dockerPushImage")
public class DockerPushImage extends AbstractDockerInstantiator {

    // checkstyle: stop exception type check

    public static boolean dockerPushImage(String imageName, String registry) throws VilException {
        return dockerPushImage(imageName, registry, "");
    }
    
    /**
     * Returns the name of a Docker image.
     * 
     * @param imageName name of the image, "repository:tag"
     * @param registry the target registry
     * @param tag optional tag, may be empty
     * @return {@code true} if removed
     * @throws VilException in case of artifact / parameter problems
     */
    public static boolean dockerPushImage(String imageName, String registry, String tag) throws VilException {
        try {
            PushImageCmd cmd = createClient().pushImageCmd(imageName);
            AuthConfig cfg = DockerLogin.getAuthConfig(registry);
            if (null != cfg) {
                cmd.withAuthConfig(cfg);
            }
            if (null != tag && tag.length() > 0) {
                cmd.withTag(tag);
            }
            cmd.exec(new PushImageResultCallback())
                .awaitCompletion();
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
