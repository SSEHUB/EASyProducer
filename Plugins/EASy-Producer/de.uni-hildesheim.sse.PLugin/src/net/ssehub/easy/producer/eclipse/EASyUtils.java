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

package net.ssehub.easy.producer.eclipse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.AbstractRule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;
import net.ssehub.easy.producer.eclipse.contributions.Contributions;
import net.ssehub.easy.producer.eclipse.persistency.EASyPersistencer;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.PersistenceUtils;

/**
 * Some utility methods.
 * 
 * @author Holger Eichelberger
 */
public class EASyUtils {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(EASyUtils.class, Activator.PLUGIN_ID);

    /**
     * Prevents this class from being instantiated.
     */
    private EASyUtils() {
    }

    /**
     * Tries to find the EASy-Producer configuration from the IVML/VIL path configurations.
     * 
     * @param project the project to look into
     * @return the EASy config file
     */
    public static IFile findEasyConfig(IProject project) {
        IFile result = null;
        Configuration cfg = PersistenceUtils.getConfiguration(project);
        int count = cfg.getPathCount(PathKind.IVML);
        for (int i = 0; null == result && i < count; i++) {
            String folder = cfg.getPath(PathKind.IVML, count);
            IFile file = project.getFile(folder + ResourcesMgmt.INSTANCE.getSeperator() 
                + PersistenceConstants.CONFIG_FILE);
            if (file.exists()) {
                result = file;
            }
        }
        if (null == result) { // original/classic setup
            IFile file = project.getFile(ProjectConstants.EASY_FILES + ResourcesMgmt.INSTANCE.getSeperator() 
                + PersistenceConstants.CONFIG_FILE);
            if (file.exists()) {
                result = file;
            }
        }
        return result;
    }
    
    /**
     * Loads a project and registers it if necessary.
     * 
     * @param project the project to load
     * @throws PersistenceException in case of errors loading the project
     */
    public static void loadProject(IProject project) throws PersistenceException {
        String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(project);
        if (null == projectID) { // consider paths as fallback
            IFile cfg = findEasyConfig(project);
            if (null != cfg) {
                projectID = ResourcesMgmt.INSTANCE.getIDfromResource(cfg);
            }
        }
        if (null != projectID) {
            PLPInfo openedPLP = SPLsManager.INSTANCE.getPLP(projectID);
            if (null == openedPLP || openedPLP.isPreliminary()) {
                EASyPersistencer persistencer = new EASyPersistencer(project.getLocation().toFile());
                // load method adds automatically the loaded PLP to the SPLsManager
                persistencer.load();
            }
        } else {
            throw new PersistenceException("EASy configuration not found");
        }
    }
    
    /**
     * Determines the configuration path of the project (considers {@link Contributions}).
     * 
     * @param project the project to determine the configuration path for
     */
    public static void determineConfigurationPaths(IProject project) {
        Configuration config = PersistenceUtils.getConfiguration(project);
        if (Contributions.determineConfigurationPaths(project, config)) {
            config.store();
            try {
                project.refreshLocal(IProject.DEPTH_ONE, null);
            } catch (CoreException e) {
            }
        }
    }
    
    /**
     * Initializes the given project (considers {@link Contributions}).
     * 
     * @param project the parent Eclipse project
     * @param plp the product line project
     * @throws IOException in case of any I/O exception during initialization
     */
    public static void initialize(IProject project, PLPInfo plp) throws IOException {
        List<PLPInfo> predecessors = new ArrayList<PLPInfo>();
        Contributions.initializePLP(project, plp, predecessors);
        for (PLPInfo predecessor : predecessors) {
            plp.getMemberController().addPredecessor(predecessor);
            // Support old EASy project, which do not contain any build scripts
            PLPInfo predecessorPLP = SPLsManager.INSTANCE.getPLP(predecessor.getProjectID());
            boolean hasBuildScript = false;
            if (null != predecessorPLP) {
                hasBuildScript = null != predecessorPLP.getBuildScript();
            }
            // support case where project is not fully loaded (add-easy-nature)
            hasBuildScript |= predecessor.hasDefaultMainBuildScript();
            addImport(plp, predecessor, hasBuildScript);
        }
        Script script = plp.getBuildScript();
        if (null != script) {
            AbstractRule main = script.getMainRule(true);
            try {
                BuildModel.INSTANCE.locations().updateLocation(plp.getConfigLocation(), ProgressObserver.NO_OBSERVER);
                // we just need an URI to a file in the config location - this avoids writing the buildScript now
                File fakeLocation = new File(plp.getConfigLocation(), "x_0.vil");
                BuildModel.INSTANCE.resolveImports(script, fakeLocation.toURI(), new ArrayList<ModelInfo<Script>>());
                for (int i = 0; i < script.getImportsCount(); i++) {
                    ModelImport<Script> imp = script.getImport(i);
                    if (null != imp.getResolved()) {
                        try {
                            AbstractRule target = imp.getResolved().getMainRule(false);
                            main.appendCallTo(target, true);
                        } catch (VilException e) {
                            LOGGER.exception(e);
                        }
                    }
                } 
            } catch (ModelManagementException e) {
                LOGGER.exception(e);
            }
        }
    }
    
    /**
     * Adds an import to the {@link net.ssehub.easy.varModel.model.Project} and to the {@link Script} of a given
     * {@link PLPInfo} to the {@link net.ssehub.easy.varModel.model.Project} and {@link Script} of a predecessor
     * project.
     * 
     * @param plp the product line project to add the import to
     * @param predecessor A predecessor project of plp, where the {@link net.ssehub.easy.varModel.model.Project}
     *     <b>and</b> the {@link Script} should be included.
     * @param considerVIL <code>true</code> if the parent project has also a build script which should be considered,
     *     <code>false</code> otherwise
     */
    public static final void addImport(PLPInfo plp, PLPInfo predecessor, boolean considerVIL) {
        net.ssehub.easy.producer.core.persistence.PersistenceUtils.addImport(plp, predecessor, considerVIL);
    }
}
