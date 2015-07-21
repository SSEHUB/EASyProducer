/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.xvcl;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import edu.xvcl.core.api.XVCLException;
import edu.xvcl.core.util.XVCLProcessor;

/**
 * The XVCL instantiator implementation.
 * 
 * @author El-Sharkawy
 */
public class XvclTransformatorEngine {
    
    /**
     * Instantiates the given XVCL specification file via VIL.
     * @param specification The stating point for instantiation with XVCL.
     * @throws VilException If XVCL detects any errors.
     */
    void instantiate(FileArtifact specification) throws VilException {
        XVCLProcessor xvcl = new XVCLProcessor();
        String[] args = null;
        if (null != specification && null != specification.getPath()) {
            File specFile = specification.getPath().getAbsolutePath();
            if (null != specFile && null != specFile.getAbsolutePath()) {
                args = new String[]{specFile.getAbsolutePath()};
            }
        }
        
        // Critical: If xvcl detects any errors, it will call System.exit(1) and close the whole jVM.
        if (null != args && args.length > 0) {
            try {
                xvcl.process(args, true, true, false);
                xvcl.clearCache();
                System.out.println(xvcl.getVersion());
    
            } catch (XVCLException e) {
                throw new VilException(e, VilException.ID_IO);
            }
        }
        
        xvcl = null;
    }
}