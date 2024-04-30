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
package net.ssehub.easy.producer.eclipse.persistency.project_creation;

/**
 * Returns types for {@link EASyProjectCreatorFactory#isValidProjectName(String)}.
 * @author El-Sharkawy
 *
 */
public enum ValidProjectNameType {

    /**
     * Project name can be used for new projects.
     */
    VALID,
    
    /**
     * Project name already exists.
     */
    ALREADY_EXISTS,
    
    /**
     * Project name does not exists, but is not a valid IVML name.
     */
    INVALID_IDENTIFIER,
}
