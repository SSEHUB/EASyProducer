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

import java.util.List;

import com.github.dockerjava.api.model.Image;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to obtain the name of a docker image.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerRemoveImage")
public class DockerImageName extends AbstractDockerInstantiator {

    // checkstyle: stop exception type check
    
    /**
     * Returns the name of a Docker image.
     * 
     * @param id the id of the image to return the name for
     * @return the name, if not found <b>null</b> (undefined)
     * @throws VilException in case of artifact / parameter problems
     */
    public static String dockerImageName(String id) throws VilException {
        String name = null;
        try {
            List<Image> imgs = (List<Image>) createClient().listImagesCmd().withShowAll(true).exec();
    
            for (Image img: imgs) {
                // Extracting 12-digits version of the image id. 
                String imgId = img.getId();
                imgId = imgId.substring(7, 19);
                // Comparing with input id
                if (imgId.equals(id)) {
                    name = img.getRepoTags()[0];
                }
            }
        } catch (Exception e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        }
        return name;
    }
    
    // checkstyle: resume exception type check
    
}
