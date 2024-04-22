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
package net.ssehub.easy.varModel.confModel;

import java.util.List;

import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.progress.ProgressObserver;

/**
 * Externalizes the initialization of a configuration, so that a specific reasoner can do this job.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationInitializerRegistry {

    private static IConfigurationInitializer initializer = Configuration.DEFAULT_INITIALIZER;
    
    /**
     * Defines the interface for the configuration initializer.
     * 
     * @author Holger Eichelberger
     */
    public interface IConfigurationInitializer {
        
        /**
         * Initializes the configuration.
         * 
         * @param config the configuration to be initialized
         * @param observer a progress observer on the initialization progress
         * @return any messages occurring during the initialization, <b>null</b> or empty denote no problems. The
         *   result may also consist of warnings only.
         */
        public List<Message> initializeConfiguration(Configuration config, ProgressObserver observer);
        
        /**
         * Whether the initializer/configuration supports enforced model copy.
         * 
         * @return <code>true</code> for support, <code>false</code> else
         */
        public boolean supportsElementCopy();
        
        /**
         * Resolves default values of a particular variable. 
         * 
         * @param variable the instance to resolve the default values for.
         * @return {@code true} of a default value could be resolved and assigned to {@code variable}, {@code false}
         *     otherwise.
         */
        public boolean resolveDefaultValue(IDecisionVariable variable);
        
    }
    
    /**
     * Defines the global initializer.
     * 
     * @param init the initializer instance
     * @throws IllegalArgumentException if <code>init == <b>null</b></code>
     */
    public static void setInitializer(IConfigurationInitializer init) {
        if (null != init) {
            initializer = init;
        }
    }
    
    /**
     * Returns the global initializer.
     * 
     * @return the initializer instance to use
     */
    public static IConfigurationInitializer getInitializer() {
        return initializer;
    }

}