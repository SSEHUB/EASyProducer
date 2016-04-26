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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * A cache for {@link ConfigQuery}s based on a {@link Configuration}. As long the configuration is not recreated,
 * the cache will store already retrieved values.
 * @author El-Sharkawy
 *
 */
public class QueryCache {
    
    private Configuration config;

    /**
     * Tuple of ({@link Reference#getType()}, possible values for the reference).
     */
    private Map<IDatatype, List<ConstraintSyntaxTree>> refValues;
    
    /**
     * Should only be used for inheritance.
     */
    protected QueryCache() {
        // Used for inheritance
    }
    
    /**
     * Default constructor for this class, creates an empty cache.
     * @param config The configuration for which this cache is used.
     */
    QueryCache(Configuration config) {
        this.config = config; 
        refValues = new HashMap<IDatatype, List<ConstraintSyntaxTree>>();
    }
    
    /**
     * Clears the cache, must be called from the configuration after the configuration was refreshed.
     */
    void clear() {
        refValues.clear();
    }
    
    /**
     * Calculates possible values ({@link ConstraintSyntaxTree}-based) for a
     * given {@link Reference} variable.
     * @param refType  The reference for which possible values should be calculated for.
     * @return  A maybe empty list of possible values for the given {@link Reference}. This list is unmodifiable and
     *     should not be stored outside of this cache.
     */
    public List<ConstraintSyntaxTree> getPossibleValues(Reference refType) {
        List<ConstraintSyntaxTree> possibleValues = refValues.get(refType.getType());
        if (null == possibleValues) {
            List<ConstraintSyntaxTree> values = ConfigQuery.possibleValuesForReferences(config, refType);
            possibleValues = Collections.unmodifiableList(values);
            refValues.put(refType.getType(), possibleValues);
        }
        
        return possibleValues;
    }

}
