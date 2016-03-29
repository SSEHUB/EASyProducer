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
package net.ssehub.easy.varModel.model.search;


/**
 * Describes a search result. Note that each model element may be included multiple
 * times in a search result, e.g. via its simple and its qualified name.
 * 
 * @author Holger Eichelberger
 */
public class SearchResult {

    /**
     * The matched name.
     */
    private String matchedName;
    
    /**
     * The related element. This is of type object as {@link net.ssehub.easy.varModel.model.ModelElement}
     * is too restrictive, e.g. for project imports.
     */
    private Object element; // might also be just a Class<?>
    
    /**
     * Creates a search result.
     * 
     * @param matchedName the matched name
     * @param element the related element
     */
    SearchResult(String matchedName, Object element) {
        this.matchedName = matchedName;
        this.element = element;
    }
    
    /**
     * Returns the matched name.
     * 
     * @return the matched name
     */
    public String getMatchedName() {
        return matchedName;
    }
    
    /**
     * Returns the related (model) element.
     * 
     * @return the related element
     */
    public Object getElement() {
        return element;
    }
    
}

