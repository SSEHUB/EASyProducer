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
package net.ssehub.easy.producer.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;
import net.ssehub.easy.producer.examples.AvailableExamples.ExampleDescriptor;
import net.ssehub.easy.producer.examples.internal.Bundle;

/**
 * Methods for installing selected examples into the workspace.
 * @author El-Sharkawy
 *
 */
public class ExamplesInstaller {
    
    /**
     * Stores whether a given project may be imported into workspace (<tt>true</tt>) or
     * already exist in workspace.
     */
    private Map<String, Boolean> projects;
    private ExampleDescriptor[] selectedExamples;
    private Set<String> importedProjects;
    private Set<String> skippedProjects;
    
    /**
     * Sole constructor for this class.
     * @param selectedExamples The list of examples, which shall be installed into workspace.
     * Must not be <tt>null</tt>.
     */
    public ExamplesInstaller(ExampleDescriptor[] selectedExamples) {
        projects = new HashMap<String, Boolean>();
        this.selectedExamples = selectedExamples;
        importedProjects = new HashSet<String>();
        skippedProjects = new HashSet<String>();
    }
    
    /**
     * Imports the examples into workspace.
     * @return the List of successfully imported projects.
     * @throws ExampleInstallationException If at least one of the examples could not be installed into
     * the workspace.
     */
    public Set<String> installExamples() throws ExampleInstallationException {
        if (null != selectedExamples) {
            for (int i = 0; i < selectedExamples.length; i++) {
                unzip(selectedExamples[i].getSource());
            }
        }
        
        for (String projectName : importedProjects) {
            IProject project = ResourcesMgmt.INSTANCE.getProject(projectName);
            if (null != project && !project.exists()) {
                try {
                    project.create(null);
                    // Takes a lot of time
                    project.open(null);
                } catch (CoreException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(ExamplesInstaller.class,
                            Bundle.PLUGIN_ID).exception(e);
                }
            }
        }
//        Job job = new Job("Open imported examples.") {
//            @Override
//            protected IStatus run(IProgressMonitor monitor) {
//                for (String projectName : importedProjects) {
//                    IProject project = ResourcesMgmt.INSTANCE.getProject(projectName);
//                    if (null != project && !project.exists()) {
//                        try {
//                            project.create(null);
//                            // Takes a lot of time
//                            project.open(null);
//                        } catch (CoreException e) {
//                            EASyLoggerFactory.INSTANCE.getLogger(ExamplesInstaller.class,
//                                    Bundle.PLUGIN_ID).exception(e);
//                        }
//                    }
//                }
//                return Status.OK_STATUS;
//            }
//        };
//
//        // Start the Job
//        job.schedule(); 
        
        
        if (!skippedProjects.isEmpty()) {
            throw new ExampleInstallationException(skippedProjects);
        }
        
        return importedProjects;
    }
    
    /**
     * Unzipps the contents of the given zip archive.
     * @see <a href="http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/">
     * http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/</a>
     * @param zipLocation The location of the zip archive to unpack. Should be located inside this bundle.
     */
    private void unzip(File zipLocation) {
        byte[] buffer = new byte[1024];
        
        try {
            // Get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipLocation));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();
     
            while (ze != null) {
     
                String fileName = ze.getName();
                String projectName = determineProjectName(fileName);
                boolean considerFile = (null != projectName) ? addProject(projectName) : false;
                File newFile = new File(ResourcesMgmt.INSTANCE.getWorspaceFolder() + File.separator + fileName);
     
                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();
                if (considerFile) {
                    
                    // Write
                    if (!ze.isDirectory()) {
                        FileOutputStream fos = new FileOutputStream(newFile);             
                        
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                        
                        fos.close();
                    } else if (!newFile.exists()) {
                        // Create folders (necessary if they do not contain files)
                        newFile.mkdirs();
                    }
                }
                
                ze = zis.getNextEntry();
            }
     
            zis.closeEntry();
            zis.close();
 
        } catch (IOException ex) {
            EASyLoggerFactory.INSTANCE.getLogger(ExamplesInstaller.class, Bundle.PLUGIN_ID).exception(ex);
        }
    }
    
    /**
     * Returns whether a given project name may be used for creating a new project inside the workspace.
     * @param projectName The name of the project to be created in workspace.
     * @return <tt>true</tt> if the project and the destination location do not exist, <tt>false</tt> otherwise. 
     */
    private boolean addProject(String projectName) {
        Boolean validDestination = projects.get(projectName);
        if (null == validDestination) {
            IProject project = ResourcesMgmt.INSTANCE.getProject(projectName);
            File projectDestination = new File(ResourcesMgmt.INSTANCE.getWorspaceFolder(), projectName);
            if (null != project && !project.exists() && !projectDestination.exists()) {
                validDestination = true;
                importedProjects.add(projectName);
            } else {
                validDestination = false;
                skippedProjects.add(projectName);
            }
            projects.put(projectName, validDestination);
        }
        
        return validDestination;
    }
    
    /**
     * Calculates the project name for a given entry of a Zip archive.
     * @param entryName The current entry for which the destination project should be calculated.
     * Should not be <tt>null</tt>.
     * @return The name of the project, may be <tt>null</tt> if destination project could not be calculated.
     */
    public static synchronized String determineProjectName(String entryName) {
        String projectName = null;
        if (null != entryName) {
            String[] pathElement = entryName.split("/");
            if (null != pathElement && pathElement.length > 0) {
                projectName = pathElement[0];
            }
        }
        
        return projectName;
    }

}
