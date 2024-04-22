/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.rewrite.modifier;

import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;

/**
 * Import filter based on a <a href="https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html">
 * Java regular expression</a>.
 * @author El-Sharkawy
 *
 */
public class ImportRegExNameFilter implements IProjectImportFilter {
    
    private String regexFilter;
    private boolean whitelist;
   
    /**
     * Default constructor for this class.
     * @param regexFilter The regular expression which shall be used for filtering.
     * @param whitelist {@code true} the given names will be kept and all others will be filtered out (whitelist
     * filtering), {@code false} the given names will be filtered out and all others will be kept
     * (blacklist filtering).
     */
    public ImportRegExNameFilter(String regexFilter, boolean whitelist) {
        this.regexFilter = regexFilter;
        this.whitelist = whitelist;
    }
    
    @Override
    public ProjectImport handleImport(ProjectImport pImport, RewriteContext context) {
        if (pImport.getName().matches(regexFilter) ^ whitelist) {
            pImport = null;
        }
        
        return pImport;
    }
}
