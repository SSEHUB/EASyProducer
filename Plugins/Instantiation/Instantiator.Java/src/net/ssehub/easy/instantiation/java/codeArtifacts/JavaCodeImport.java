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
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

public class JavaCodeImport implements IJavaCodeElement {

    private boolean isStatic;
    private String name;
    private IJavaCodeArtifact artifact;
    
    JavaCodeImport(String name, IJavaCodeArtifact artifact) {
        this.name = name;
        this.artifact = artifact;
    }
    
    public String getName() {
        return name;
    }

    /**
     * Sets this element's static state.
     * 
     * @param isStatic if the element is static
     */
    @OperationMeta(name = {"static"})
    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    /**
     * Sets this element to static.
     */
    @OperationMeta(name = {"static"})
    public void setStatic() {
        setStatic(true);
    }

    /**
     * Returns whether the element is static.
     * 
     * @return {@code true} for static, {@code false} for instance
     */
    public boolean isStatic() {
        return isStatic;
    }

    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        return artifact;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("import ");
        if (isStatic) {
            out.print("static ");
        }
        out.println(name + ";");
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaImport: " + getName();
    }

}
