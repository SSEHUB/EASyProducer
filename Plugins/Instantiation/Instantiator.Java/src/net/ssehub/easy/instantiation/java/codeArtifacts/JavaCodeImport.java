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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Java import.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeImport implements IJavaCodeImport {

    public static final JavaCodeImport DEFAULT = new JavaCodeImport();
    
    private boolean isStatic;
    private String name;
    private IJavaCodeArtifact artifact;
    private boolean isWildcard;
    
    /**
     * Creates an instance for the default import.
     */
    private JavaCodeImport() {
        this.name = "java.lang";
    }

    /**
     * Creates a non-static import.
     * 
     * @param name the name/wildcard to import
     * @param artifact the containing artifact
     */
    JavaCodeImport(String name, IJavaCodeArtifact artifact) {
        this(name, artifact, false);
    }
    
    /**
     * Creates an import.
     * 
     * @param name the name/wildcard to import
     * @param artifact the containing artifact
     * @param isStatic is the import static or non-static
     */
    JavaCodeImport(String name, IJavaCodeArtifact artifact, boolean isStatic) {
        this.name = name;
        this.artifact = artifact;
        this.isWildcard = name.endsWith("*");
        this.isStatic = isStatic;
        artifact.registerImport(this);
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getSimpleName() {
        String result = name;
        int pos = result.lastIndexOf('.');
        if (pos > 0) {
            result = result.substring(pos + 1);
        }
        return result;
    }

    /**
     * Sets this element's static state.
     * 
     * @param isStatic if the element is static
     */
    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    /**
     * Sets this element to static.
     */
    public void setStatic() {
        setStatic(true);
    }

    @Override
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
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + ": " + getName();
    }

    @Override
    public boolean isWildcard() {
        return isWildcard;
    }

    @Override
    public IJavaCodeElement getParent() {
        return null;
    }

    @Override
    public void setParent(IJavaCodeElement parent) {
    }

}
