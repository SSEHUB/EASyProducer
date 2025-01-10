/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.yaml;

import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Basic representant for Yaml structures.
 * 
 * @author Holger Eichelberger
 */
public abstract class YamlStructure implements IVilType, IStringValueProvider, INodeParent {

    private INodeParent parent;

    /**
     * Creates an empty instance.
     * 
     * @param parent the parent to notify about changes
     */
    YamlStructure(INodeParent parent) {
        setParent(parent);
    }
    
    /**
     * Changes the parent, e.g., if by artifact without binding to parent.
     * 
     * @param parent the new parent
     */
    void setParent(INodeParent parent) {
        this.parent = parent;
    }
    
    /**
     * Returns the parent.
     * 
     * @return the parent
     */
    INodeParent getParent() {
        return parent;
    }

    @Override
    public void notifyChanged() {
        if (null != parent) {
            parent.notifyChanged();
        }
    }
    
    /**
     * Defines the sorting mode of maps/objects.
     * 
     * @author Holger Eichelberger
     */
    enum Sorting {
        
        /**
         * No sorting, implementation dependent.
         */
        NONE,

        /**
         * Insert/adding/reading sequence.
         */
        INSERT,

        /**
         * Alphanumerical according to field/key names.
         */
        ALPHA,

        /**
         * Locale/language based according to field/key names.
         */
        COLLATOR
        
    }
    
    /**
     * Returns the data in this node, formatted to be useful for snakeyaml.
     * 
     * @param sorting the sorting sequence for the data
     * @return the data
     */
    @Invisible
    abstract Object getData(Sorting sorting);

    @Invisible
    abstract boolean hasData();
    
}
