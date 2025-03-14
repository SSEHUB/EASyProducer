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

import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Simplified registration for the Docker mocks.
 * 
 * @author Monika Staciwa
 */
public class DockerMock {

    private static boolean registered = false;

    /**
     * Registers the Java artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(DockerBuildImageMock.class);
            TypeRegistry.DEFAULT.register(DockerLoginMock.class);
            TypeRegistry.DEFAULT.register(DockerPushImageMock.class);
            TypeRegistry.DEFAULT.register(DockerLogoutMock.class);
        }
    }

}
