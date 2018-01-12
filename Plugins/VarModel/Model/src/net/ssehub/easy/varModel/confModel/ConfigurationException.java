/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.IvmlException;

/**
 * Implements a specific exception for errors in the configuration.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ConfigurationException extends IvmlException {

    public static final int ALREADY_FROZEN = 19001;
    public static final int TYPE_MISMATCH = 19002;
    public static final int INTERNAL = 19003;
    public static final int DUPLICATES_IN_SET = 19004;
    
    private IConfiguration configuration;
    
    /**
     * Creates a configuration exception.
     *
     * @param configuration the causing configuration (may be <b>null</b> during incremental buildup)
     * @param message a message explaining the reason for this exception
     * @param code a code representing the reason
     */
    public ConfigurationException(IConfiguration configuration, String message, int code) {
        super(message, code);
        this.configuration = configuration;
    }
    
    /**
     * Returns the configuration this exception occurs on.
     * 
     * @return the configuration (may be <b>null</b> during incremental buildup)
     */
    public IConfiguration getConfiguration() {
        return configuration;
    }
    
}
