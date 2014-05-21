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
package de.uni_hildesheim.sse.easy_producer.persistency.project_creation;

import org.eclipse.core.resources.ResourcesPlugin;

import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.model.validation.IvmlIdentifierCheck;

/**
 * Creates new EASy projects in Eclipse.
 * @author El-Sharkawy
 *
 */
public class EASyProjectCreatorFactory {
    
    
    /**
     * Checks whether a project with the given name could be created.
     * @param name The name of the new project.
     * @return A {@link ValidProjectNameType}
     */
    public static ValidProjectNameType isValidProjectName(String name) {
        ValidProjectNameType status = ValidProjectNameType.VALID;
        if (name == null || "".equals(name)) {
            // Invalid project name
            status = ValidProjectNameType.INVALID_IDENTIFIER;
        } else if (ResourcesPlugin.getWorkspace().getRoot().getProject(name).exists()) {
            //If the project which is intended to be created is already existing.
            status = ValidProjectNameType.ALREADY_EXISTS; 
        } else if (!IvmlIdentifierCheck.isValidIdentifier(name)) {
            // Invalid project name
            status = ValidProjectNameType.INVALID_IDENTIFIER;
        }
        
        return status;
    }

    /**
     * Checks whether a project with the given name could be created.
     * 
     * @param name The name of the new project.
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before.
     * @return A {@link ValidProjectNameType}
     */
    public static ValidProjectNameType isValidProjectName(String name, boolean lazy) {
        ValidProjectNameType status = isValidProjectName(name);
        // refactored version did not consider this
        if (lazy && ValidProjectNameType.ALREADY_EXISTS == status) {
            status = ValidProjectNameType.VALID;
        }
        return status;
    }
    
    /**
     * Creates a new EASy project.
     * @param name The name of the EASy project.
     * @param predecessorID Optional: The projectID of a predecessor for the new project.
     *     If <tt>null</tt> a new (not derived) project without a predecessor will be created.
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before.
     * @param configurators Optional list of configurators to configure the newly created project, maybe <tt>null</tt>.
     *     The configurators whill be applied in the ordering of the array.
     * @return The newly created {@link ProductLineProject} with the specified project name,
     *     created inside the workspace.
     * @throws ProjectCreationException If a name was used, which could not be used for creating a new EASy project.
     */
    public static ProductLineProject createNewProject(String name, String predecessorID, boolean lazy,
        IEASyProjectConfigurator... configurators) throws ProjectCreationException {
        
        ValidProjectNameType valid = isValidProjectName(name, lazy);
        switch (valid) {
        case VALID:
            //No action needed
            break;
        case ALREADY_EXISTS:
            throw new ProjectAlreadyExistsException();
        case INVALID_IDENTIFIER:
            throw new InvalidProjectnameException();
        default:
            // Could throw a nullpointer exception, but this code should also not be reached!
            new ProjectCreationException(null);
            break;
        }
        
        AbstractProjectCreator creator = null;
        if (null == predecessorID) {
            creator = new NewProjectCreator(name, lazy, configurators);
        } else {
            creator = new DerivedProjectCreator(name, predecessorID, lazy, configurators);
        }
        
        return creator.createEASyProject();
    }

}
