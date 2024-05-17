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
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.tools.ant.BuildException;

import de.uni_hildesheim.sse.easy.ant.AbstractModelTask;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.rewrite.ProjectRewriteVisitor;
import net.ssehub.easy.varModel.model.rewrite.modifier.DeclarationNameFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.ImportNameFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.ModelElementFilter;

/**
 * ANT task for copying the an EASy-Producer model (IVML, VIL, VTL, .EASyConfig, ...) to a specified location, while
 * omitting configurations (as specified in QualiMaster).
 * @author El-Sharkawy
 *
 */
public class ModelCopy extends AbstractModelTask {
    
    private static final String CONFIG_FILE_EXTENSION = "cfg.ivml";
    private static final String BASICS_CONFIG = "BasicsCfg";
    private static final String PIPELINES_CONFIG = "PipelinesCfg";
    private static final String ALGORITHMS_CONFIG = "AlgorithmsCfg";
    private static final String DATAMGT_CONFIG = "DataManagementCfg";
    private static final String FAMILIES_CONFIG = "FamiliesCfg";
    private static final String HARDWARE_CONFIG = "HardwareCfg";
    @SuppressWarnings("unused")
    private static final String INFRASTRUCTURE_CONFIG = "InfrastructureCfg";
    private static final String RECONFIGURABLE_HW_CONFIG = "ReconfigurableHardwareCfg";
    private static final String REMOVEABLE_CONFIG_EXTENSION = "^.*(_\\p{Digit}*|prioritypip)" + CONFIG_FILE_EXTENSION + "$";
    
    private ProjectRewriteVisitor rewriter;
    
    /**
     * Constructor for the ant task.
     */
    public ModelCopy() {
        super();
        setAllowDestDeletion(false); // Only allowed during tests.
        rewriter = null;
    }
    
    /**
     * Constructor for testing
     * @param orgFolder A folder containing the source artifacts for copying.
     * @param cpyfolder The folder must exist and empty or not exist (must not be <code>null</code>).
     * @param mainProject the main project
     */
    public ModelCopy(String orgFolder, String cpyfolder, String mainProject) {
        super();
        setSourceFolder(orgFolder);
        setDestinationFolder(cpyfolder);
        setMainProject(mainProject);
        setAllowDestDeletion(true);
        rewriter = null;
    }
    
    /**
     * Starts the copy process.
     * @throws ModelManagementException If IVML files could not be parsed
     * @throws IOException If files could not be copied.
     */
    private void copy() throws ModelManagementException, IOException {
        // Initialize
        loadProject(getSourceFolder(), getMainProject());
        List<File> originalFiles = new ArrayList<>(FileUtils.listFiles(getSourceFolder(), new EASyModelFilter(),
            TrueFileFilter.INSTANCE));
        // cave: works here (close to Windows sequence) because "infrastructure/" goes before "meta/" and
        // PipelinesCfg*.ivml with deepest model dependencies comes after all others
        Collections.sort(originalFiles, (f1, f2) -> f1.getAbsolutePath().compareTo(f2.getAbsolutePath()));
        // Copy all files
        for (File file : originalFiles) {
            String relativeFileName = getSourceFolder().toURI().relativize(file.toURI()).getPath();
            debugMessage("Processing: " + relativeFileName);
            File copyDestination = new File(getDestinationFolder(), relativeFileName);
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
            debugMessage("Filter: " + projectName);
            
            if (BASICS_CONFIG.equals(p.getName())) {
                // Clear Basics Config
                clearRewriter(p, FilterType.NO_IMPORTS);
                rewriter.addModelCopyModifier(new DeclarationNameFilter(new String[] {"IntegerType", "LongType",
                    "StringType", "BooleanType", "FloatType", "DoubleType", "RealType", "ObjectType"}));
                p.accept(rewriter);
            } else if (PIPELINES_CONFIG.equals(p.getName())) {
                // Clear Pipelines Config
                clearRewriter(p, FilterType.NO_IMPORTS);
                rewriter.addImportModifier(new ImportNameFilter(new String[] {"Basics", "Pipelines", "FamiliesCfg",
                    "DataManagementCfg"}));
                p.accept(rewriter);
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
            debugMessage("Omitting: " + relativeFileName);
        }
    }

    private Project processDefaultConfig(Project p) {
        clearRewriter(p, FilterType.NO_IMPORTS);
        rewriter.addModelCopyModifier(new ModelElementFilter(DecisionVariableDeclaration.class));
        p.accept(rewriter);
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
    public void doModelOperation() throws BuildException {
        // Copy and filter
        try {
            debugMessage("Start creation of copy");
            copy();
            debugMessage("Finished creation of copy");
        } catch (Exception e) {
            try {
                FileUtils.deleteDirectory(getDestinationFolder());
            } catch (IOException exc) {
               
            }
            
            if (e instanceof IOException) {
                throw new BuildException("IOError during copying models from \"" + getSourceFolder().getAbsolutePath()
                    + "\" to \"" + getDestinationFolder().getAbsolutePath() + "\". Cause: " + e.getMessage());
            } else if (e instanceof ModelManagementException) {
                throw new BuildException("Modelloadingerror during copying models from \""
                    + getSourceFolder().getAbsolutePath() + "\" to \"" + getDestinationFolder().getAbsolutePath()
                    + "\". Cause: " + e.getMessage());
            } else {
                throw new BuildException("Unspecified error during copying models from \""
                    + getSourceFolder().getAbsolutePath() + "\" to \"" + getDestinationFolder().getAbsolutePath()
                    + "\". Cause: " + e.getMessage());
            }
        }
    }
}
