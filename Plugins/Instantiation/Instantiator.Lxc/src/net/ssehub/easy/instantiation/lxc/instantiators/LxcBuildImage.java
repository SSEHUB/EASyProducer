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

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Builds Lxc images.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcBuildImage")
public class LxcBuildImage extends AbstractLxcInstantiator {

    // checkstyle: stop exception type check

    /**
     * Executes a specific LXC Template, builds an image and imports it to LXD.
     * 
     * @param baseDirectory the base directory for the build context(.tar.xz) will be stored
     * @param lxcTemplate the LXC template to create the image from
     * @param imageName name of the image
     * @return the image fingerprint, may be <b>null</b>/undefined
     * @throws VilException in case of artifact / parameter problems
     */
    public static String lxcBuildImage(Path baseDirectory, Path lxcTemplate, String imageName) throws VilException {
        String distrobuilderCmd = "distrobuilder build-lxd ";
        String flags = " --type=unified --import-into-lxd=";
        String templatePath = lxcTemplate.getAbsolutePath().toString();

        IInstantiatorTracer tracer = TracerFactory.getInstance().createInstantiatorTracerImpl();
        try {
            tracer.traceMessage("Building LXC image " + imageName+ ". Please wait...");
            createCmdClient().executeLinuxCmd("cd " + baseDirectory + " && sudo " + distrobuilderCmd + templatePath 
                + flags + imageName);

            // Should wait until the command is actually finished now
            // VilException will be thrown
            // but Image will still be built
            String imageFingerprint = createClient().loadImageMap().get(imageName).getFingerprint();
            tracer.traceMessage("Building LXC image " + imageName + " completed: " + imageFingerprint);

            return imageFingerprint;
        } catch (Throwable e) {
            if (FAIL_ON_ERROR) {
                tracer.traceMessage("Building LXC image " + imageName + "failed: " + e.getMessage());
                throw new VilException(e.getMessage(), VilException.ID_RUNTIME);
            } else {
                return null;
            }
        }
    }

    // checkstyle: resume exception type check

}