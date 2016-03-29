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
package net.ssehub.easy.reasonerCore.reasoner;

import net.ssehub.easy.varModel.capabilities.IReasonerCapability;

/**
 * Defines general reasoner capabilities.
 * 
 * @author Holger Eichelberger
 */
public enum GeneralReasonerCapabilities implements IReasonerCapability {
    
    /**
     * Support for incremental reasoning while configuring a product.
     */
    INCREMENTAL_REASONING,
    
    /**
     * Support for runtime reasoning, i.e., can be applied for runtime reconfiguration, e.g., 
     * in combination with rt-VIL.
     */
    RUNTIME_REASONING,
    
    /**
     * Is suitable to perform the initialization of an IVML configuration instance as it provides
     * comprehensive IVML reasoning capabilities. Currently, the reasoner developer declares this
     * capability. However, it might also be derived from the presence of 
     * {@link de.uni_hildesheim.sse.capabilities.IvmlReasonerCapabilities}.
     */
    CONFIGURATION_INITIALIZATION;

}
