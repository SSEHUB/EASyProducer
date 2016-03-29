/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.filter;

/**
 * This enumeration if for the constructors of this package to denote
 * whether imports should be considered during filtering the current project.
 * @author El-Sharkawy
 *
 */
public enum FilterType {
    /**
     * Current project and all imported projects will be filtered.
     */
    ALL,
    /**
     * Only the current project without imports will be filtered.
     */
    NO_IMPORTS,
    
    /**
     * Only the imported projects without the current project will be considered.
     */
    ONLY_IMPORTS;

}
