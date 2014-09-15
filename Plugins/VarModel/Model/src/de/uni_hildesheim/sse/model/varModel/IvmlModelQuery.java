/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel;

import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.QualifiedNameMode;
import de.uni_hildesheim.sse.model.varModel.search.SearchContext;
import de.uni_hildesheim.sse.model.varModel.search.SearchResult;

/**
 * Provides IVML specific model query operations.
 * 
 * @author Holger Eichelberger
 */
public class IvmlModelQuery extends ModelQuery {
    
    /**
     * Searches a given set of elements by a name prefix starting at <code>element</code>.
     * 
     * @param element the element to start searching at
     * @param namePrefix the name prefix
     * @param mode the type name resolution mode to be applied
     * @param context additional information to include or exclude locally defined model elements
     * @param restrictions type restrictions on the elements to include into the search
     * @return the search results
     */
    public static List<SearchResult> getElementsByNamePrefix(ModelElement element, 
        String namePrefix, QualifiedNameMode mode, SearchContext context, Class<?>... restrictions) {
        IvmlDatatypeVisitor visitor = IvmlDatatypeVisitor.getInstance(mode);
        List<SearchResult> results = getElementsByNamePrefix(element, namePrefix, visitor, context, restrictions);
        IvmlDatatypeVisitor.release(visitor);
        return results;
    }

    /**
     * Searches a given set of elements by a name prefix starting at <code>element</code>. Types
     * are resolved to qualified names.
     * 
     * @param element the element to start searching at
     * @param namePrefix the name prefix
     * @param context additional information to include or exclude locally defined model elements
     * @param restrictions type restrictions on the elements to include into the search
     * @return the search results
     */
    public static List<SearchResult> getElementsByNamePrefix(ModelElement element, 
        String namePrefix, SearchContext context, Class<?>... restrictions) {
        return getElementsByNamePrefix(element, namePrefix, QualifiedNameMode.QUALIFIED, context, restrictions);
    }

}
