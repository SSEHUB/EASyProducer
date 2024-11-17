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
 * Represents a qualifiable element, e.g., a method call or a variable.
 * 
 * @author Holger Eichelberger
 */
public interface JavaCodeQualifiableElement extends IJavaCodeElement {
    
    /**
     * Qualifies the element by a given name.
     * 
     * @param qualification the qualifying name
     * @return <b>this</b> for chaining
     */
    public JavaCodeQualifiableElement qualifiedBy(String qualification);

    /**
     * Qualifies the element by a given type.
     * 
     * @param type the qualifying type
     * @return <b>this</b> for chaining
     */
    public JavaCodeQualifiableElement qualifiedByType(String type);

    /**
     * Qualifies the element by a given variable.
     * 
     * @param var the qualifying variable
     * @return <b>this</b> for chaining
     */
    public JavaCodeQualifiableElement qualifiedBy(JavaCodeVariableDeclaration var);
    
}
