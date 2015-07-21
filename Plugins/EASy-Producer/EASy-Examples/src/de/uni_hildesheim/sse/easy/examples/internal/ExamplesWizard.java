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
package de.uni_hildesheim.sse.easy.examples.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.uni_hildesheim.sse.easy.examples.AvailableExamples.ExampleDescriptor;
import de.uni_hildesheim.sse.easy.ui.productline_editor.EasyProducerDialog;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Wizard for unpacking examples shipped with this bundle into the worksapce.
 * @author El-Sharkawy
 *
 */
public class ExamplesWizard extends Wizard implements INewWizard {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ExamplesWizard.class,
        Bundle.PLUGIN_ID);
    
    private ExamplesWizardPage page;
    private Set<String> importedProjects;
    
    /**
     * Created files, for a rollback.
     */
    private Map<String, List<File>> installedFiles;
    
    /**
     * Sole constructor for this Wizard.
     * Should be without parameters, as it will be called by Eclipse.
     */
    public ExamplesWizard() {
        super();
        importedProjects = new HashSet<String>();
        installedFiles = new HashMap<String, List<File>>();
        page = new ExamplesWizardPage();
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        importedProjects.clear();
        installedFiles.clear();
        
        ExampleDescriptor[] selectedExamples = page.getSelectedExamples();
        if (null != selectedExamples) {
            for (int i = 0; i < selectedExamples.length; i++) {
                unzip(selectedExamples[i].getSource());
            }
        }
        
        StringBuffer errorMsg = new StringBuffer("Could not import the following projects:");
        boolean showAlert = false;
        for (String projectName : importedProjects) {
            IProject project = ResourcesMgmt.INSTANCE.getProject(projectName);
            if (null != project && !project.exists()) {
                try {
                    project.create(null);
                    project.open(null);
                    ResourcesMgmt.INSTANCE.refreshProject(projectName);
                } catch (CoreException e) {
                    LOGGER.exception(e);
                }
            } else {
                showAlert = true;
                errorMsg.append("\n * ");
                errorMsg.append(projectName);
                List<File> createdFiles = installedFiles.get(projectName);
                if (null != createdFiles && !createdFiles.isEmpty()) {
                    for (File createdFile : createdFiles) {
                        if (createdFile.exists()) {
                            if (createdFile.isDirectory()) {
                                try {
                                    FileUtils.deleteDirectory(createdFile);
                                } catch (IOException e) {
                                    LOGGER.exception(e);
                                }
                            } else {
                                FileUtils.deleteQuietly(createdFile);
                            }
                        }
                    }
                }
            }
        }
        
        if (showAlert) {
            EasyProducerDialog.showErrorDialog(errorMsg.toString());
        }
        
        return !importedProjects.isEmpty() && !showAlert;
    }
    
    /**
     * Saves newly created files, for a rollback.
     * @param projectName The name of the newly imported project.
     * @param createdFile The file created for the project.
     */
    private void addCreatedFile(String projectName, File createdFile) {
        List<File> createdFiles = installedFiles.get(projectName);
        if (null == createdFiles) {
            createdFiles = new ArrayList<File>();
            installedFiles.put(projectName, createdFiles);
        }
        createdFiles.add(createdFile);
    }
    
    /**
     * Unzipps the contents of the given zip archive.
     * @see <a href="http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/">
     * http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/</a>
     * @param zipLocation The location of the zip archive to unpack. Should be located inside this bundle.
     */
    private void unzip(File zipLocation) {
        ResourcesMgmt.INSTANCE.getWorspaceFolder();
        System.out.println(zipLocation.getAbsolutePath());
        
        byte[] buffer = new byte[1024];
        
        try {
            // Get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipLocation));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();
     
            while (ze != null) {
     
                String fileName = ze.getName();
                String projectName = null;
                if (null != fileName) {
                    String[] pathElement = fileName.split("/");
                    if (null != pathElement && pathElement.length > 0) {
                        projectName = pathElement[0];
                        importedProjects.add(projectName);
                    }
                }
                File newFile = new File(ResourcesMgmt.INSTANCE.getWorspaceFolder() + File.separator + fileName);
     
                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();
                if (!newFile.exists()) {
                    addCreatedFile(projectName, newFile);
                    
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
            LOGGER.exception(ex);
        }
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // Method from INewWizard, but not needed.
    }

}
