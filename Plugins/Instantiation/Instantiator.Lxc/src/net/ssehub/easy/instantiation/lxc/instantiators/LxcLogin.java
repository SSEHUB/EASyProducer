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

import java.util.HashMap;
import java.util.Map;

import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.AuthConfigurations;
import com.github.dockerjava.api.model.AuthResponse;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Instantiator to log into a LXC registry.
 * 
 * @author Monika Staciwa
 */
@Instantiator("lxcLogin")
public class LxcLogin extends AbstractLxcInstantiator {

    private static Map<String, AuthConfig> authConfig = new HashMap<String, AuthConfig>();
 
    /**
     * Returns the known/validated auth configs.
     * 
     * @return the known/validated auth configs, <b>null</b> for none
     */
    static AuthConfigurations getAuthConfigs() {
        AuthConfigurations result;
        if (authConfig.size() > 0) {
            result = new AuthConfigurations();
            for (AuthConfig c: authConfig.values()) {
                result.addConfig(c);
            }
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the auth configuration for the given registry address.
     * 
     * @param registryAddress the address
     * @return the auth configuration or <b>null</b> for none
     */
    static AuthConfig getAuthConfig(String registryAddress) {
        return authConfig.get(registryAddress);
    }
    
    /**
     * Adds an auth config.
     * 
     * @param config the config to add
     */
    static void addConfig(AuthConfig config) {
        authConfig.put(config.getRegistryAddress(), config);
    }

    /**
     * Clears an existing authentication configuration.
     * 
     * @param registryAddress the registry to clear the authentication for
     * @return {@code true} if successful
     */
    static boolean clear(String registryAddress) {
        return authConfig.remove(registryAddress) != null;
    }
    
    /**
     * Clears an existing authentication configuration.
     */
    static void clear() {
        authConfig.clear();
    }
    
    // checkstyle: stop exception type check

    /**
     * Logs into the given LXC registry. Stores the authentication configuration if successful and
     * applies it automatically.
     * 
     * @param registry the registry address
     * @param user the user name
     * @param password the password
     * @return {@code true} if successful
     * @throws VilException in case of artifact / parameter problems
     */
    public static boolean lxcLogin(String registry, String user, String password) throws VilException {
        try {
            AuthConfig tmp = new AuthConfig()
                .withRegistryAddress(registry)
                .withUsername(user)
                .withPassword(password);
            
            AuthResponse response = createClient().authCmd().withAuthConfig(tmp).exec();
            boolean ok = response.getStatus().equalsIgnoreCase("Login Succeeded");
            if (ok) {
                addConfig(tmp);
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
