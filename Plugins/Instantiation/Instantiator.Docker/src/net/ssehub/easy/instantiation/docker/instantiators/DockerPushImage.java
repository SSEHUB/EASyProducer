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

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.PushImageCmd;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.PushResponseItem;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to push a Docker image to a repository.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerPushImage")
public class DockerPushImage extends AbstractDockerInstantiator {

    // checkstyle: stop exception type check

    /**
     * Returns the name of a Docker image.
     * 
     * @param imageName name of the image, "repository:tag"
     * @param registry the target registry
     * @param repository the repository within registry to use
     * @param tag optional tag, may be empty
     * @return {@code true} if removed
     * @throws VilException in case of artifact / parameter problems
     */
    public static boolean dockerPushImage(String imageName, String registry, String repository, String tag) 
        throws VilException {
        try {
            if (!imageName.equals(registry + "/" + repository)) {
                createClient().tagImageCmd(imageName, registry + "/" + repository, tag).exec();
            }
            
            PushImageCmd cmd = createClient().pushImageCmd(registry + "/" + repository + ":" + tag);

            AuthConfig cfg = DockerLogin.getAuthConfig(registry);
            if (null != cfg) {
                cmd.withAuthConfig(cfg);
            }
            
            final String fallbackTaskDescription = "Docker activity";
            TracerFactory.ensureTasks(fallbackTaskDescription);
            cmd.exec(new ResultCallback.Adapter<PushResponseItem>() {
                
                @Override
                public void onNext(PushResponseItem item) {
                    super.onNext(item);
                    TracerFactory.progressSubTask(1, 1, "Docker push: " + item.getId() + " " + item.getStatus());
                }
                
            }).awaitCompletion();
            TracerFactory.closeTasks(fallbackTaskDescription);
            
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