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
import java.util.HashSet;

import com.github.dockerjava.api.command.BuildImageCmd;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.model.AuthConfigurations;
import com.github.dockerjava.api.model.BuildResponseItem;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Builds Lxc images.
 * 
 * @author Monika Staciwa
 */
@Instantiator("lxcBuildImage")
public class LxcBuildImage extends AbstractLxcInstantiator {

    // checkstyle: stop exception type check
    
    /**
     * Executes a specific Dockerfile and builds an image.
     * 
     * @param baseDirectory the base directory for the build context
     * @param dockerFile the docker file for the container to create
     * @param name name of the image with following schema (repository:tag)
     * @return the container id, may be <b>null</b>/undefined
     * @throws VilException in case of artifact / parameter problems
     */
    public static String lxcBuildImage(Path baseDirectory, Path dockerFile, String name) throws VilException {
        HashSet<String> tags = new HashSet<String>();
        tags.add(name);
        
        try {
            File dockerfile = dockerFile.getAbsolutePath();
            BuildImageCmd cmd = createClient().buildImageCmd()
                .withDockerfile(dockerfile)
                .withPull(true)
                .withNoCache(true)      // false - building multiply images from one build context not possible
                .withBaseDirectory(baseDirectory.getAbsolutePath())
                .withTags(tags);
            AuthConfigurations aCfgs = LxcLogin.getAuthConfigs();
            if (null != aCfgs) {
                cmd.withBuildAuthConfigs(aCfgs);
            }
            String imageId = cmd
                .exec(new BuildImageResultCallback() {
                    
                    @Override
                    public void onNext(BuildResponseItem item) {
                        super.onNext(item);
                        TracerFactory.progressSubTask(1, 1, "Docker push: " + item.getId() + " " + item.getStatus());
                    }

                })
                .awaitImageId();
            return imageId;        
        } catch (Exception e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e.getMessage(), VilException.ID_RUNTIME);
            } else {
                return null;
            }
        }
    }
    
    // checkstyle: resume exception type check
  
}