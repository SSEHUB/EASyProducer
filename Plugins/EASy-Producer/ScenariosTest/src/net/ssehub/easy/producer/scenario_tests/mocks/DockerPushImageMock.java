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
package net.ssehub.easy.producer.scenario_tests.mocks;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Mocks the instantiator to push a Docker image to a repository.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerPushImage")
public class DockerPushImageMock extends AbstractFileInstantiator {

    private static boolean result = true;

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
        return result;
    }

    /**
     * Changes the mocked result for the following calls.
     * 
     * @param res the result values
     * @return the original value before calling this method
     */
    public static boolean setResult(boolean res) {
        boolean orig = result;
        result = res;
        return orig;
    }

}
