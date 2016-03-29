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
package net.ssehub.easy.varModel.capabilities;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Provides descriptive access to the default reasoner.
 * 
 * @author Holger Eichelberger
 */
public class DefaultReasonerAccess {

    private static IDefaultReasonerProvider provider;
    
    /**
     * Defines the interface for a reasoner provider.
     * 
     * @author Holger Eichelberger
     */
    public interface IDefaultReasonerProvider {

        /**
         * Returns whether the default reasoner (if known) has a certain capability.
         * 
         * @param capability the capability
         * @return <code>true</code> if the capability is provided, <code>false</code> else
         */
        public boolean hasCapability(IReasonerCapability capability);
        
        /**
         * Initializes the derived values in the given <code>configuration</code> and freezes.
         * 
         * @param config the configuration to reason on
         * @param progress the progress observer
         */
        public void initialize(Configuration config, ProgressObserver progress);
        
    }

    /**
     * Sets the reasoner provider.
     * 
     * @param defaultProvider the provider
     */
    public static void setProvider(IDefaultReasonerProvider defaultProvider) {
        provider = defaultProvider;
    }
    
    /**
     * Returns whether the default reasoner (if known) has a certain capability.
     * 
     * @param capability the capability
     * @return <code>true</code> if the capability is provided, <code>false</code> else
     */
    public static boolean hasCapability(IReasonerCapability capability) {
        boolean result = false;
        if (null != provider) {
            result = provider.hasCapability(capability);
        }
        return result;
    }
    
}
