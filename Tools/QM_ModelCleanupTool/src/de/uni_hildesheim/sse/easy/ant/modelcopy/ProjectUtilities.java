/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.ant.modelcopy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.IVMLWriter;

/**
 * Utility functions needed by this tool while handling {@link Project}s.
 * @author El-Sharkawy
 *
 */
public class ProjectUtilities {
    
    /**
     * Stores an exception which may occur during initialization of this class.
     */
    private static ModelManagementException intialException;
    
    static {
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            intialException = e;
        }
    }
    
    /**
     * Load an IVML File as project.
     * 
     * @param projectName of the project file to load
     * @return the loaded ivml file as project.
     * @throws IOException
     *             if an error occurred due reading the ivml file
     */
    public static Project loadProject(String projectName) throws ModelManagementException, IOException {
        if (null != intialException) {
            throw intialException;
        }

        // Parse IVML File
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo(projectName);
        
        // Parse IVML File
        Project project = null;
        try {
            project = VarModel.INSTANCE.load(infos.get(0));
        } catch (ModelManagementException mme) {
            System.out.println("Exception while loading : " + projectName);
            throw mme;
        }
        
        return project;
    }
    
    /**
     * Saves the given project to the specified folder.
     * @param destFolder The folder where the project shall be saved to.
     * @param project The project to be saved.
     * @throws IOException  if the file exists but is a directory rather than
     *      a regular file, does not exist but cannot be created,
     *      or cannot be opened for any other reason
     */
    public static void saveProject(File destFolder, Project project) throws IOException {
        try (FileWriter fWriter = new FileWriter(new File(destFolder, project.getName() + ".ivml"))) {
            IVMLWriter iWriter = new IVMLWriter(fWriter);
            project.accept(iWriter);
        } catch (IOException ioe) {
            throw ioe;
        }
    }

}
