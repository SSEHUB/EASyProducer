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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Basic implementation for elements with parent.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeElement implements IJavaCodeElement {

    private IJavaCodeElement parent;
    
    /**
     * Creates an instance.
     *
     * @param parent the parent
     */
    protected JavaCodeElement(IJavaCodeElement parent) {
        this.parent = parent;
    }
    
    @Override
    public IJavaCodeArtifact getArtifact() {
        return null == parent ? null : parent.getArtifact();
    }

    @Override
    public IJavaCodeElement getParent() {
        return parent;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        this.parent = parent;
    }

}
