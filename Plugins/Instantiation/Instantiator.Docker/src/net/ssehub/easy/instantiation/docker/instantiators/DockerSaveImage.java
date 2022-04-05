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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.PathUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils.ScanResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Instantiator to remove a Docker image.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerSaveImage")
public class DockerSaveImage extends AbstractDockerInstantiator {

    // checkstyle: stop exception type check
    
    /**
     * Returns the name of a Docker image.
     * 
     * @param imageName name of the image, "repository:tag"
     * @param target the image file to be created 
     * @return {@code true} if removed
     * @throws VilException in case of artifact / parameter problems
     */
    public static Set<FileArtifact> dockerSaveImage(String imageName, Path target) throws VilException {
        long timestamp = PathUtils.normalizedTime();
        File targetPath = determineTargetPath(target);
        
        try {
            String[] cmd = new String[] {"docker", "save", "-o", target.getAbsolutePath().toString(), imageName};
            Process proc = new ProcessBuilder(cmd).start();
            int consoleResult = proc.waitFor();
            // status so far unclear, e.g. just for ps: 
            // https://betterprogramming.pub/understanding-docker-container-exit-codes-5ee79a1d58f6
            if (consoleResult > 0) {
                throw new VilException("Stopped with status " + consoleResult, VilException.ID_RUNTIME);
            }
        } catch (IOException e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        } catch (InterruptedException e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            }
        }
        
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), target.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        return new ListSet<FileArtifact>(result, FileArtifact.class);        
    }
    
    // checkstyle: resume exception type check
    
}
