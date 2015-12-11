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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;

/**
 * Filters {@link DecisionVariableDeclaration}s based on their names.
 * @author El-Sharkawy
 *
 */
public class DeclarationNameFilter implements IModelCopyModifier<DecisionVariableDeclaration> {
    
    private Set<String> whitelist;
    
    /**
     * Default constructor of this class.
     * @param allowedNames A whitelist of allowed names, others will be deleted.
     */
    public DeclarationNameFilter(String[] allowedNames) {
        whitelist = new HashSet<String>();
        for (int i = 0; i < allowedNames.length; i++) {
            whitelist.add(allowedNames[i]);
        }
    }

    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return DecisionVariableDeclaration.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        if (!whitelist.contains(element.getName())) {
            element = null;
        }
        
        return element;
    }

}
