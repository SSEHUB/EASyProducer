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

package net.ssehub.easy.instantiation.docker;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.docker.instantiators.DockerBuildImage;
import net.ssehub.easy.instantiation.docker.instantiators.DockerImageName;
import net.ssehub.easy.instantiation.docker.instantiators.DockerLoadImage;
import net.ssehub.easy.instantiation.docker.instantiators.DockerLogin;
import net.ssehub.easy.instantiation.docker.instantiators.DockerLoginByToken;
import net.ssehub.easy.instantiation.docker.instantiators.DockerLogout;
import net.ssehub.easy.instantiation.docker.instantiators.DockerPushImage;
import net.ssehub.easy.instantiation.docker.instantiators.DockerRemoveImage;
import net.ssehub.easy.instantiation.docker.instantiators.DockerSaveImage;

/**
 * Registers the Docker additions to VIL.
 * 
 * @author Monika Staciwa
 */
public class Registration implements IRegistration {

    private static boolean registered = false;
    
    /**
     * Registers the ANT artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(DockerBuildImage.class);
            TypeRegistry.DEFAULT.register(DockerImageName.class);
            TypeRegistry.DEFAULT.register(DockerRemoveImage.class);
            TypeRegistry.DEFAULT.register(DockerSaveImage.class);
            TypeRegistry.DEFAULT.register(DockerLoadImage.class);
            TypeRegistry.DEFAULT.register(DockerLogin.class);
            TypeRegistry.DEFAULT.register(DockerLoginByToken.class);
            TypeRegistry.DEFAULT.register(DockerLogout.class);
            TypeRegistry.DEFAULT.register(DockerPushImage.class);
        }
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        register();
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
    }

}
