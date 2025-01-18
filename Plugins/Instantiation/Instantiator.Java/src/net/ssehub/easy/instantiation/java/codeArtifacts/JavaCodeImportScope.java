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

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;

/**
 * Denotes the auto-import scope for types.
 * 
 * @author Holger Eichelberger
 */
public enum JavaCodeImportScope implements IVilType {

    /**
     * No scope, no import.
     */
    NONE,
    
    /**
     * Class scope.
     */
    CLASS,

    /**
     * Class scope. The name is a class not followed by a method name.
     */
    CLASS_NO_METHOD,

    /**
     * (Static) class and method scope. May lead to a static method import.
     */
    METHOD, 
    
    /**
     * (Static) class and method scope. Import class only, no static method import.
     */
    METHOD_CLASS_IMPORT

}
