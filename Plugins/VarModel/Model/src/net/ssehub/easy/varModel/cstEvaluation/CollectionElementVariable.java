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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.confModel.ICollectionElementVariable;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.confModel.paths.IResolutionPathElement;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * A temporary variable representing a value of a container. By design decision, container 
 * do not have contained decision variables. Anyway, references to container variables can
 * be defined and are resolved via this temporary variable. For resolving this variable
 * for a specific configuration, this class is equipped with a resolution path for deferred 
 * variable resolution.
 * 
 * @author Holger Eichelberger
 */
class CollectionElementVariable extends AbstractVariable implements ICollectionElementVariable {
    
    private AbstractVariable base;
    private int index;
    private IResolutionPathElement path;
    
    /**
     * Creates a collection element variable.
     * 
     * @param base the base the collection variable
     * @param type the contained type
     * @param path the path to resolve <code>base</code> in a configuration
     * @param index the index within <code>base</code>
     */
    CollectionElementVariable(AbstractVariable base, IDatatype type, IResolutionPathElement path, int index) {
        super(String.valueOf(index), type, base);
        this.base = base;
        this.index = index;
        this.path = path;
    }

    @Override
    public int getAttributesCount() {
        return base.getAttributesCount();
    }

    @Override
    public Attribute getAttribute(String name) {
        return base.getAttribute(name);
    }

    @Override
    public Attribute getAttribute(int index) {
        return base.getAttribute(index);
    }

    @Override
    public void accept(IModelVisitor visitor) {
        // nothing to visit
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public AbstractVariable getBaseVariable() {
        return base;
    }

    @Override
    public boolean isTemporaryVariable() {
        return false;
    }

    @Override
    public boolean isAttribute() {
        return false;
    }

    @Override
    public IDecisionVariable resolve(IConfiguration config) {
        IDecisionVariable result = path.resolve(config);
        if (null != result) {
            result = result.getNestedElement(getIndex());
        }
        return result;
    }
    
}