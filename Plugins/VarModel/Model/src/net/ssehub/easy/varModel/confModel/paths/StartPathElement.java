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
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * The start of a resolution path at a top-level variable.
 * 
 * @author Holger Eichelberger
 */
public class StartPathElement implements IResolutionPathElement {

    private AbstractVariable decl;
    
    /**
     * Creates a path start.
     * 
     * @param decl the top-level declaration 
     */
    public StartPathElement(AbstractVariable decl) {
        this.decl = decl;
    }
    
    @Override
    public IDecisionVariable resolve(IConfiguration config) {
        return config.getDecision(decl);
    }

}
