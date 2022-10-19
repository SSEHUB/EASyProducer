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

import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.AuthResponse;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to log into a registry.
 * 
 * @author Monika Staciwa
 */
@Instantiator("lxcLoginByToken")
public class LxcLoginByToken extends AbstractLxcInstantiator {

    private static AuthConfig authConfig;
    
    // checkstyle: stop exception type check
    
    static AuthConfig getAuthConfig() {
        return authConfig;
    }
    
    /**
     * Clears an existing authentication token.
     */
    static void clear() {
        authConfig = null;
    }
    
    /**
     * Logs into the given LXC registry. Stores the authentication configuration if successful and
     * applies it automatically.
     * 
     * @param registry the registry address
     * @param user the user name
     * @param token the identity token
     * @return {@code true} if successful
     * @throws VilException in case of artifact / parameter problems
     */
    public static boolean lxcLoginByToken(String registry, String user, String token) throws VilException {
        try {
            AuthConfig tmp = new AuthConfig()
                .withRegistryAddress(registry)
                .withUsername(user)
                .withIdentityToken(token);
            
            AuthResponse response = createClient().authCmd().withAuthConfig(tmp).exec();
            boolean ok = response.getStatus().equalsIgnoreCase("Login Succeeded");
            if (ok) {
                authConfig = tmp;
            }
            return ok;
        } catch (Exception e) {
            if (FAIL_ON_ERROR) {
                throw new VilException(e, VilException.ID_RUNTIME);
            } else {
                return false;
            }
        }
    }
    
    // checkstyle: resume exception type check
    
}
