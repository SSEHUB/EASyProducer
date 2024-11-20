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
 * Basic interface for the code artifact (to reduce dependencies).
 * 
 * @author Holger Eichelberger
 */
public interface IJavaCodeArtifact {
    
    /**
     * Validates a given {@code type} and considers it for the imports. May modify the output type name of {@code type}
     * using {@link IJavaCodeTypeSpecification#setOutputTypeName(String)}.
     * 
     * @param type the type
     */
    public void validateType(IJavaCodeTypeSpecification type);
    
    /**
     * Validates a qualified static method call.
     * 
     * @param name the name
     * @param scope the scope to consider
     * @return the name, potentially without qualification if statically imported
     */
    public String validateStaticMethodCall(String name, JavaCodeImportScope scope);
    
    /**
     * Internal call to register an import.
     * 
     * @param imp the import
     */
    @Invisible
    public void registerImport(IJavaCodeImport imp);
    
    /**
     * Explicitly adds an import to this artifact.
     * 
     * @param imp the import (may be a wildcard), static can be set on the result
     * @return the existing or new code import
     */
    public JavaCodeImport addImport(String imp);

    /**
     * Explicitly adds static import to this artifact.
     * 
     * @param imp the import (may be a wildcard)
     * @return the existing or new code import
     */
    public JavaCodeImport addStaticImport(String imp);

}
