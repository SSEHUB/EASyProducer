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
 * Represents a name-based access path element, e.g., for compounds.
 * 
 * @author Holger Eichelberger
 */
public class NameAccessPathElement implements IResolutionPathElement {

    private IResolutionPathElement parent;
    private String name;
    
    /**
     * Creates a name access path element.
     * 
     * @param parent the parent path
     * @param name the name representing the access
     */
    public NameAccessPathElement(IResolutionPathElement parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    @Override
    public IDecisionVariable resolve(IConfiguration config) {
        IDecisionVariable result = parent.resolve(config);
        if (null != result) {
            result = result.getNestedElement(name);
        }
        return result;
    }
}
