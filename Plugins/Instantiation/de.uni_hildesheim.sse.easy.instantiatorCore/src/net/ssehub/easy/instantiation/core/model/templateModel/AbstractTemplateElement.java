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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;

/**
 * An abstract template element.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractTemplateElement implements ITemplateElement {

    private ILanguageElement parent;
    
    @Override
    public ILanguageElement getParent() {
        return parent;
    }
    
    /**
     * Changes the parent. Please override if children must be adjusted according.
     * Shall be called only once per instance, but there is no limitation.
     * 
     * @param parent the parent
     */
    protected void setParent(ILanguageElement parent) {
        this.parent = parent;
    }
    
}
