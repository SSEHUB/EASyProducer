/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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

package net.ssehub.easy.producer.scenario_tests.mocks;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Mocks the instantiator to build LXC images.
 * 
 * @author Luca Schulz
 */
@Instantiator("lxcBuildImage")
public class LxcBuildImageMock extends AbstractFileInstantiator {

    private static String result = "abc";

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
        return result;
    }

    /**
     * Changes the mocked result for the following calls.
     * 
     * @param res the result values
     * @return the original value before calling this method
     */
    public static String setResult(String res) {
        String orig = result;
        result = res;
        return orig;
    }

}