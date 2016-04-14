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
 * An index access path element, e.g., for collections or as fallback.
 * 
 * @author Holger Eichelberger
 */
public class IndexAccessPathElement implements IResolutionPathElement {

    private IResolutionPathElement parent;
    private int index;
    
    /**
     * Creates an index access path element.
     * 
     * @param parent the parent path
     * @param index the index representing the access
     */
    public IndexAccessPathElement(IResolutionPathElement parent, int index) {
        this.parent = parent;
        this.index = index;
    }

    @Override
    public IDecisionVariable resolve(IConfiguration config) {
        IDecisionVariable result = parent.resolve(config);
        if (null != result) {
            result = result.getNestedElement(index);
        }
        return result;
    }
    
}
