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

/**
 * Basic implementation for statements.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeStatement extends JavaCodeElement {

    /**
     * Creates an instance.
     *
     * @param parent the parent
     */
    protected JavaCodeStatement(IJavaCodeElement parent) {
        super(parent);
    }
    
    /**
     * Returns whether this statement is considered empty, e.g., with an empty expression.
     * 
     * @return {@code true} for empty, {@code false} else
     */
    public boolean isEmpty() {
        return false;
    }
    
}
