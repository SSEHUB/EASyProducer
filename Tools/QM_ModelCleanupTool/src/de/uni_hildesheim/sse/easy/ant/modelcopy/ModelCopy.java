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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor;
import de.uni_hildesheim.sse.model.validation.ValidationMessage;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.rewrite.ProjectRewriteVisitor;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.DeclarationNameFilter;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.ImportNameFilter;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.ModelElementFilter;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * ANT task for copying the an EASy-Producer model (IVML, VIL, VTL, .EASyConfig, ...) to a specified location, while
 * omitting configurations (as specified in QualiMaster).
 * @author El-Sharkawy
 *
 */
public class ModelCopy extends Task {
    
    private static final String CONFIG_FILE_EXTENSION = "cfg.ivml";
    private static final String BASICS_CONFIG = "BasicsCfg";
    private static final String PIPELINES_CONFIG = "PipelinesCfg";
    private static final String ALGORITHMS_CONFIG = "AlgorithmsCfg";
    private static final String DATAMGT_CONFIG = "DataManagementCfg";
    private static final String FAMILIES_CONFIG = "FamiliesCfg";
    private static final String HARDWARE_CONFIG = "HardwareCfg";
    private static final String INFRASTRUCTURE_CONFIG = "InfrastructureCfg";
    private static final String RECONFIGURABLE_HW_CONFIG = "ReconfigurableHardwareCfg";
    private static final String REMOVEABLE_CONFIG_EXTENSION = "^.*(_\\p{Digit}*|prioritypip)" + CONFIG_FILE_EXTENSION + "$";
    
    private File sourceFolder;
    private File destinationFolder;
    private String mainProject;
    private boolean allowDestDeletion;
    
    private ProjectRewriteVisitor rewriter;
    
    /**
     * Constructor for the ant task.
     */
    public ModelCopy() {
        allowDestDeletion = false; // Only allowed during tests.
        rewriter = null;
    }
    
    /**
     * Constructor for testing
     * @param orgFolder A folder containing the source artifacts for copying.
     * @param cpyfolder The folder must exist and empty or not exist (must not be <tt>null</tt>).
     * @param mainProject
     * @throws Exception
     */
    public ModelCopy(String orgFolder, String cpyfolder, String mainProject) {
        sourceFolder = new File(orgFolder);
        destinationFolder = new File(cpyfolder);
        this.mainProject = mainProject;
        allowDestDeletion = true;
        rewriter = null;
    }
    
    /**
     * A folder containing artifacts to copy. Will consider sub folders.
     * @param sourceFolder A folder containing the source artifacts for copying.
     */
    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = new File(sourceFolder);
    }
    
    /**
     * The target folder where the copied models hall be stored.
     * @param destinationFolder The folder must exist and empty or not exist (must not be <tt>null</tt>).
     */
    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = new File(destinationFolder);
    }
    /**
     * Main Project, is needed for loading the projects in a correct order.
     * @param mainProject The starting point of the model to be copied, only its name.
     */
    public void setMainProject(String mainProject) {
        this.mainProject = mainProject;
    }
    
    /**
     * Starts the copy process.
     * @throws ModelManagementException If IVML files could not be parsed
     * @throws IOException If files could not be copied.
     */
    private void copy() throws ModelManagementException, IOException {
        // Initialize
        VarModel.INSTANCE.locations().addLocation(sourceFolder, ProgressObserver.NO_OBSERVER);
        Project p = ProjectUtilities.loadProject(mainProject);
        System.out.println(p.getName() + " sucessfully loaded.");
        Collection<File> originalFiles = FileUtils.listFiles(sourceFolder, new EASyModelFilter(),
            TrueFileFilter.INSTANCE);
        
        // Copy all files
        for (File file : originalFiles) {
            String relativeFileName = sourceFolder.toURI().relativize(file.toURI()).getPath();
            System.out.println("Processing: " + relativeFileName);
            File copyDestination = new File(destinationFolder, relativeFileName);
            if (!copyDestination.exists()) {
                File destFolder = copyDestination.getParentFile();
                destFolder.mkdirs();
                if (!relativeFileName.toLowerCase().endsWith(CONFIG_FILE_EXTENSION)) {
                    FileUtils.copyFile(file, copyDestination, false);
                } else {
                    handleConfigFile(relativeFileName, destFolder);
                }
            }
        }
    }

    /**
     * Copies the IVML model. Configs will be cleaned.
     * @param relativeFileName The path inside {@link #sourceFolder}.
     * @param destFolder The destination folder where to save the copy.
     * @throws ModelManagementException If IVML files could not be parsed
     * @throws IOException If files could not be copied.
     */
    private void handleConfigFile(String relativeFileName, File destFolder) throws ModelManagementException,
        IOException {
        
        if (!relativeFileName.toLowerCase().matches(REMOVEABLE_CONFIG_EXTENSION)) {
            int lastDot = relativeFileName.lastIndexOf('.');
            int lastSeparator = relativeFileName.lastIndexOf('/');
            if (-1 == lastSeparator) {
                lastSeparator = relativeFileName.lastIndexOf('\\');
            }
            
            String projectName = relativeFileName.substring(lastSeparator + 1, lastDot);
            Project p = ProjectUtilities.loadProject(projectName);
            System.out.println("Filter: " + projectName);
            
            if (BASICS_CONFIG.equals(p.getName())) {
                // Clear Basics Config
                clearRewriter(p, FilterType.NO_IMPORTS);
                rewriter.addModelCopyModifier(new DeclarationNameFilter(new String[] {"IntegerType", "LongType",
                    "StringType", "BooleanType", "FloatType", "DoubleType", "RealType", "ObjectType"}));
                p.accept(rewriter);
                p = rewriter.getCopyiedProject();
            } else if (PIPELINES_CONFIG.equals(p.getName())) {
                // Clear Pipelines Config
                clearRewriter(p, FilterType.NO_IMPORTS);
                rewriter.addImportModifier(new ImportNameFilter(new String[] {"Basics", "Pipelines", "FamiliesCfg",
                    "DataManagementCfg"}));
                p.accept(rewriter);
                p = rewriter.getCopyiedProject();
            } else if (ALGORITHMS_CONFIG.equals(p.getName())) {
                p = processDefaultConfig(p);
            } else if (DATAMGT_CONFIG.equals(p.getName())) {
                p = processDefaultConfig(p);
            } else if (FAMILIES_CONFIG.equals(p.getName())) {
                p = processDefaultConfig(p);
            } else if (HARDWARE_CONFIG.equals(p.getName())) {
                p = processDefaultConfig(p);
            } else if (RECONFIGURABLE_HW_CONFIG.equals(p.getName())) {
                p = processDefaultConfig(p);
//            } else if (INFRASTRUCTURE_CONFIG.equals(p.getName())) {
//                p = processDefaultConfig(p);
//                
                // FIXME SE: Do not remove to much inside InfrastructureCfg
            } else {
                // Clear all other configs
                List<ProjectImport> imports = new ArrayList<ProjectImport>();
                for (int i = 0; i < p.getImportsCount(); i++) {
                    ProjectImport projectImport = p.getImport(i);
                    String importName = projectImport.getName().toLowerCase();
                    if (!(importName + ".ivml").matches(REMOVEABLE_CONFIG_EXTENSION)) {
                        imports.add(projectImport);
                    }
                }
                p.clear();
                for (int i = 0; i < imports.size(); i++) {
                    p.addImport(imports.get(i));
                }
            }
            ProjectUtilities.saveProject(destFolder, p);
        } else {
            System.out.println("Ommiting: " + relativeFileName);
        }
    }

    private Project processDefaultConfig(Project p) {
        clearRewriter(p, FilterType.NO_IMPORTS);
        rewriter.addModelCopyModifier(new ModelElementFilter(DecisionVariableDeclaration.class));
        p.accept(rewriter);
        p = rewriter.getCopyiedProject();
        return p;
    }
    
    private void clearRewriter(Project project, FilterType filterType) {
        if (null == rewriter) {
            rewriter = new ProjectRewriteVisitor(project, filterType);
        } else {
            rewriter.reset(project, filterType);
        }
    }
    
    @Override
    public void execute() throws BuildException {
        // Print debug data
        System.out.println("Source folder: " + sourceFolder.getAbsolutePath());
        System.out.println("Destination folder: " + destinationFolder.getAbsolutePath());
        System.out.println("Main model: " + mainProject);
        
        // Setup
        boolean createFolder = false;
        if (destinationFolder.exists() && allowDestDeletion) {
            try {
                FileUtils.deleteDirectory(destinationFolder);
                createFolder = true;
            } catch (IOException e) {
                throw new BuildException("Destination folder \"" + destinationFolder.getAbsolutePath()
                    + "\" exists and could not be deleted. Cause: " + e.getMessage());
            }
        } else if (destinationFolder.exists() && !allowDestDeletion && destinationFolder.listFiles().length > 0) {
            throw new BuildException("Destination folder \"" + destinationFolder.getAbsolutePath() + "\" exists and "
                + "is not empty.");
        }
        if (createFolder && !destinationFolder.mkdirs()) {
            throw new BuildException("Destination folder \"" + destinationFolder.getAbsolutePath()
                + "\" could not be created.");
        }
        
        // Copy and filter
        try {
            copy();
        } catch (Exception e) {
            try {
                FileUtils.deleteDirectory(destinationFolder);
            } catch (IOException exc) {
               
            }
            
            if (e instanceof IOException) {
                throw new BuildException("IOError during copying models from \"" + sourceFolder.getAbsolutePath()
                    + "\" to \"" + destinationFolder.getAbsolutePath() + "\". Cause: " + e.getMessage());
            } else if (e instanceof ModelManagementException) {
                throw new BuildException("Modelloadingerror during copying models from \""
                    + sourceFolder.getAbsolutePath() + "\" to \"" + destinationFolder.getAbsolutePath()
                    + "\". Cause: " + e.getMessage());
            } else {
                throw new BuildException("Unspecified error during copying models from \""
                    + sourceFolder.getAbsolutePath() + "\" to \"" + destinationFolder.getAbsolutePath() + "\". Cause: " + e.getMessage());
            }
        }
        
        // Validate result
        try {
            VarModel.INSTANCE.locations().removeLocation(sourceFolder, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.locations().addLocation(destinationFolder, ProgressObserver.NO_OBSERVER);
            Project copiedProject = ProjectUtilities.loadProject(mainProject);
            
            IvmlValidationVisitor validator = new IvmlValidationVisitor();
            copiedProject.accept(validator);
            if (validator.getErrorCount() > 0) {
                StringBuffer errMsg = new StringBuffer("Project \"");
                errMsg.append(mainProject);
                errMsg.append("\" was copied, but the result contains inconsitencies:");
                for (int i = 0; i < validator.getMessageCount(); i++) {
                    ValidationMessage msg = validator.getMessage(i);
                    errMsg.append("\n - ");
                    errMsg.append(msg.getStatus().name());
                    errMsg.append(": ");
                    errMsg.append(msg.getDescription());
                }
                throw new BuildException(errMsg.toString());
            }
        } catch (ModelManagementException e) {
            throw new BuildException("Copied Project contains errors: " + e.getMessage());
        } catch (IOException e) {
            throw new BuildException("Copied Project contains IO errors: " + e.getMessage());
        }
    }
}
