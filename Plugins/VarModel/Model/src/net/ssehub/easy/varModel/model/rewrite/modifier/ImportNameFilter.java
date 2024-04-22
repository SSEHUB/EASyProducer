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

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;

/**
 * Filters {@link ProjectImport}s based on their names.
 * @author El-Sharkawy
 *
 */
public class ImportNameFilter implements IProjectImportFilter {
    
    private Set<String> projectNames;
    private boolean blacklist;
    
    /**
     * Default constructor for a whitelist based filtering.
     * @param allowedNames A whitelist of allowed names, others will be deleted.
     */
    public ImportNameFilter(String[] allowedNames) {
        this(allowedNames, false);
    }
    
    /**
     * Constructor which can be used for white or black list based filtering.
     * @param declarationNames Names which shall be filtered.
     * @param blacklist {@code true} the given names will be filtered out and all others will be kept
     * (blacklist filtering), {@code false} the given names will be kept and all others will be filtered out (whitelist
     * filtering).
     */
    public ImportNameFilter(String[] declarationNames, boolean blacklist) {
        this.blacklist = blacklist;
        this.projectNames = new HashSet<String>();
        for (int i = 0; i < declarationNames.length; i++) {
            this.projectNames.add(declarationNames[i]);
        }
    }

    @Override
    public ProjectImport handleImport(ProjectImport element, RewriteContext context) {
        if (!projectNames.contains(element.getName()) ^ blacklist) {
            element = null;
        }
        
        return element;
    }

}
