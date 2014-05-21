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

package de.uni_hildesheim.sse.easy.ui.project_management;

import de.uni_hildesheim.sse.easy.ui.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.EASyProjectCreatorFactory;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.InvalidProjectnameException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ProjectAlreadyExistsException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ProjectCreationException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ValidProjectNameType;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Creates a new Project with the given parameters.
 * 
 * @author El-Sharkawy
 * @author Kapeluch
 * @author Nowatzki
 * 
 */
public class ProjectCreator {
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ProjectCreator.class,
        Activator.PLUGIN_ID);
    
    private String projectname;
    private boolean lazy;

    /**
     * Default constructor for this class.
     * 
     * @param projectname The name of the new project
     * @throws ProjectAlreadyExistsException If the project which should be created already exists.
     * @throws InvalidProjectnameException If the projectname is not valid.
     */
    public ProjectCreator(String projectname) throws ProjectAlreadyExistsException, InvalidProjectnameException {
        this(projectname, false);
    }
    
    /**
     * Use this constructor in case, if you don't want to open a configuration window. This constructor is for automated
     * testing.
     * 
     * @param projectname The name of the new project
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before
     * 
     * @throws ProjectAlreadyExistsException If the project which should be created already exists.
     * @throws InvalidProjectnameException If the project which should be created has a non-valid name.
     */
    public ProjectCreator(String projectname, boolean lazy) 
        throws ProjectAlreadyExistsException, InvalidProjectnameException {
        ValidProjectNameType valid = EASyProjectCreatorFactory.isValidProjectName(projectname, lazy);
        switch (valid) {
        case VALID:
            this.projectname = projectname;
            this.lazy = lazy;
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
    }
    
    /**
     * Creates a new productline member with all necessarily files and folders. The new created project will be a
     * successor of an existing project. This method acts as a frontend for 
     * {@link #deriveNewPLP(String)}.
     * 
     * @see ProjectCreator#newPLP()
     * @param predecessor On predecessor of the new project
     * @return The newly created product line project
     */
    public ProductLineProject deriveNewMember(String predecessor) {

        ProductLineProject plpDerive = null;        
        try {
            plpDerive = EASyProjectCreatorFactory.createNewProject(projectname, predecessor, false,
                new EASyJavaConfigurator());
        } catch (ProjectCreationException e) {
            LOGGER.exception(e);
        }
        
        return plpDerive;
    }

    /**
     * Creates a new product line project with all necessarily files and folders.
     * 
     * @see #deriveNewPLP(String)
     * @return The newly created product line project
     */
    public ProductLineProject newPLP() {
        ProductLineProject plp = null;        
        try {
            plp = EASyProjectCreatorFactory.createNewProject(projectname, null, lazy, new EASyJavaConfigurator());
        } catch (ProjectCreationException e) {
            LOGGER.exception(e);
        }
        
        return plp;
    }


    /**
     * Tests whether a given projectname already exists inside the workspace.
     * 
     * @param projectname A new projectname to test
     * @return <b>true</b> if the project already exists, otherwise <b>false</b>
     */
    public static boolean projectExists(String projectname) {
        ValidProjectNameType validName = EASyProjectCreatorFactory.isValidProjectName(projectname);
        return ValidProjectNameType.VALID == validName;
    }
}