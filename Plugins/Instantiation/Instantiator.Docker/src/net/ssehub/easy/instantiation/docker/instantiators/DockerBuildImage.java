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

import java.io.File;
import java.util.HashSet;

import com.github.dockerjava.api.command.BuildImageResultCallback;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Builds Docker images.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerBuildImage")
public class DockerBuildImage extends AbstractDockerInstantiator {

    // checkstyle: stop exception type check
    
    /**
     * Executes a specific Dockerfile and builds an image.
     * 
     * @param baseDirectory the base directory for the build context
     * @param dockerFile the docker file for the container to create
     * @param name name of the image with following schema (repository:tag)
     * @return the container id
     * @throws VilException in case of artifact / parameter problems
     */
    public static String dockerBuildImage(Path baseDirectory, Path dockerFile, String name) throws VilException {
        String[] tmp = name.split(":");
        if (tmp.length != 2) {
            throw new VilException("Name not given in format <repository:tag>", VilException.ID_RUNTIME);
        }
        HashSet<String> tags = new HashSet<String>();
        tags.add(tmp[0]);
        tags.add(tmp[1]);
        
        try {
            File dockerfile = dockerFile.getAbsolutePath();
            String imageId = createClient().buildImageCmd()
                .withDockerfile(dockerfile)
                .withPull(true)
                .withNoCache(true)      // false - building multiply images from one build context not possible
                .withBaseDirectory(baseDirectory.getAbsolutePath())
                .withTags(tags)
                .exec(new BuildImageResultCallback())
                .awaitImageId();
            return imageId;        
        } catch (Exception e) {
            throw new VilException(e.getMessage(), VilException.ID_RUNTIME);
        }
    }
    
    // checkstyle: resume exception type check
  
}