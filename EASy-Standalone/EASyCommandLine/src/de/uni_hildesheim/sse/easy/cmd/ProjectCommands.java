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

package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.io.IOException;

import de.uni_hildesheim.sse.easy_producer.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.persistence.contributions.Contributions;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.NatureHelper;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.EASyNature;

/**
 * Command line commands on project level.<br/>
 * <b>Before calling any of the methods in this class, EASy must be loaded via calling 
 * {@link LowlevelCommands#startEASy()}.</b>
 * 
 * @author Holger Eichelberger
 */
public class ProjectCommands {

    // replicates the XTEXT nature - this is defined in XTEXT.ui
    private static final String XTEXT_NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature";
    
    /**
     * Toggles the EASy nature on a folder representing a project. This method may initially
     * update product line dependencies via {@link Contributions#updateDependencies(File, String...)}.
     * 
     * @param project the folder representing a project
     * @param classpath the classpath of the project (needed in case of importing product line models, 
     *   may be <b>null</b> or empty)
     * 
     * @throws IOException in case of writing the configuration file causes an I/O problem
     * @throws IllegalArgumentException in case that the given folders are invalid
     */
    public static void toggleEasyNature(File project, String... classpath) throws IOException, 
        IllegalArgumentException {
        checkFolder(project, "project");
        if (!NatureHelper.hasNature(project, EASyNature.NATURE_ID)) {
            if (!NatureHelper.hasNature(project, XTEXT_NATURE_ID)) {
                NatureHelper.addNature(project, XTEXT_NATURE_ID);
            }
            NatureHelper.addNature(project, EASyNature.NATURE_ID);
            Contributions.updateDependencies(project, classpath);
        } else {
            NatureHelper.removeNature(project, EASyNature.NATURE_ID);
        }
    }

    /**
     * Update product line dependencies via {@link Contributions#updateDependencies(File, String...)}.
     * 
     * @param project the folder representing a project
     * @param classpath the classpath of the project (needed in case of importing product line models, 
     *   may be <b>null</b> or empty)
     * @throws IOException in case of writing the configuration file causes an I/O problem
     * @throws IllegalArgumentException in case that the given folders are invalid
     */
    public static void updateDependencies(File project, String... classpath) throws IOException {
        checkFolder(project, "project");
        Contributions.updateDependencies(project, classpath);
    }
    
    /**
     * Checks a folder for existence and folder nature.
     * 
     * @param file the file to be checked
     * @param name the parameter name (for formatting the exception)
     * @throws IllegalArgumentException in case that the given <code>file</code> is not a folder
     */
    private static final void checkFolder(File file, String name) throws IllegalArgumentException {
        if (null == file) {
            throw new IllegalArgumentException(name + " must be given (not null)");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException(name + " must exist (" + file + ")");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(name + " must be a folder/directory (" + file + ")");
        }
    }

    /**
     * Defines the configuration locations. Uses the given VIL folder also for VTL.
     * 
     * @param project the folder representing a project
     * @param ivmlFolder the IVML models 
     * @param vilFolder the VIL models
     * 
     * @throws IOException in case of writing the configuration file causes an I/O problem
     * @throws IllegalArgumentException in case that at least one of the given folders is invalid
     * 
     * @see #setConfigLocation(File, File, File, File)
     */
    public static void setConfigLocation(File project, File ivmlFolder, File vilFolder) throws IOException, 
        IllegalArgumentException {
        setConfigLocation(project, ivmlFolder, vilFolder, vilFolder);
    }
    
    /**
     * Defines the configuration locations.
     * 
     * @param project the folder representing a project
     * @param ivmlFolder the IVML models
     * @param vilFolder the VIL models
     * @param vtlFolder the VTL models
     * 
     * @throws IOException in case of writing the configuration file causes an I/O problem
     * @throws IllegalArgumentException in case that at least one of the given folders is invalid
     */
    public static void setConfigLocation(File project, File ivmlFolder, File vilFolder, File vtlFolder) 
        throws IOException, IllegalArgumentException {
        checkFolder(project, "project");
        checkFolder(ivmlFolder, "ivmlFolder");
        checkFolder(vilFolder, "vilFolder");
        checkFolder(vilFolder, "vtlFolder");
        
        Configuration config = PersistenceUtils.getConfiguration(project);
        config.setPath(PathKind.IVML, ivmlFolder);
        config.setPath(PathKind.VIL, vilFolder);
        config.setPath(PathKind.VTL, vtlFolder);
        config.store();
    }
    
}
