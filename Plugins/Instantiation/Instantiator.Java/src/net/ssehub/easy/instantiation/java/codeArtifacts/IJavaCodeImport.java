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

public interface IJavaCodeImport extends IJavaCodeElement {

    /**
     * Returns the imported name.
     * 
     * @return the name
     */
    public String getName();

    /**
     * Returns the imported non-qualified name.
     * 
     * @return the non-qualified name
     */
    public String getSimpleName();
    
    /**
     * Returns whether the import is static.
     * 
     * @return {@code true} for static, {@code false} for instance
     */
    public boolean isStatic();
    
    /**
     * Returns whether the wildcard is static.
     * 
     * @return {@code true} for static, {@code false} for instance
     */
    public boolean isWildcard();
    
}
