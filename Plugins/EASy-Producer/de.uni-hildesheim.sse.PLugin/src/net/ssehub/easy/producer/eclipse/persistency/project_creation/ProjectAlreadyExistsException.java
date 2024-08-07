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
 * Exception which will be thrown, if a projectname of project, which should be created, already exists.
 * 
 * @author EL-Sharkawy
 * 
 */
@SuppressWarnings("serial")
public class ProjectAlreadyExistsException extends ProjectCreationException {

    /**
     * Sole constructor for this class.<br>
     * This exception should only be thrown inside this package.
     */
    public ProjectAlreadyExistsException() {
        super(ValidProjectNameType.ALREADY_EXISTS);
    }
}