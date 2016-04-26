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
package net.ssehub.easy.varModel.confModel;

import java.util.List;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * Alternative {@link QueryCache} if the same cache should be shared between two {@link Configuration}s.
 * @author El-Sharkawy
 *
 */
class SharedQueryCache extends QueryCache {

    private QueryCache delegate;
    
    /**
     * Sole constructor for this class.
     * @param original The shared cache instance, which should be wrapped by this cache.
     */
    SharedQueryCache(QueryCache original) {
        delegate = original;
    }
    
    @Override
    public void clear() {
        
    }

    @Override
    public List<ConstraintSyntaxTree> getPossibleValues(Reference refType) {
        return delegate.getPossibleValues(refType);
    }
}
