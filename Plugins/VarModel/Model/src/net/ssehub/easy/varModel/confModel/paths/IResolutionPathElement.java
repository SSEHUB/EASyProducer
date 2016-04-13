/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel.paths;

import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Represents a resolution path of a nested element through a configuration. Instances of this
 * interface enable deferred resolution along this path for a given configuration. This is in 
 * particular needed to resolve the value of a configured reference, which initially just leads
 * to an {@link net.ssehub.easy.varModel.model.AbstractVariable}, that cannot be uniquely followed
 * to its top-level variable as containers do not store container element variables.
 * 
 * @author Holger Eichelberger
 */
public interface IResolutionPathElement {
    
    /**
     * Resolves this path for <code>config</code>.
     * 
     * @param config the configuration to resolve on
     * @return the resolved decision variable (may be <b>null</b> if resolution fails)
     */
    public IDecisionVariable resolve(IConfiguration config);

}
