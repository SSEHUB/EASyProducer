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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to obtain the name of a docker image.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerLoadImage")
public class DockerLoadImage extends AbstractDockerInstantiator {

    // checkstyle: stop exception type check
    
    /**
     * Returns the name of a Docker image.
     * 
     * @param archive the image archive to load
     * @return {@code true} if successful, {@code false} 
     * @throws VilException in case of artifact / parameter problems
     */
    public static boolean dockerLoadImage(Path archive) throws VilException {
        boolean ok = false;
        File tarFile = archive.getAbsolutePath();
        try {
            InputStream imageStream = new FileInputStream(tarFile);
            createClient().loadImageCmd(imageStream).exec();
            imageStream.close();
            ok = true;
        } catch (IOException e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        }            
        return ok;
    }
    
    // checkstyle: resume exception type check
    
}
