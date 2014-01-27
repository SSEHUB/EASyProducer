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

package de.uni_hildesheim.sse.easy_producer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

import de.uni_hildesheim.sse.easy_producer.contributions.Contributions;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistency.EASyPersistencer;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.PersistenceUtils;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction.Operator;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

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
     * Loads a project and registers it if necessary.
     * 
     * @param project the project to load
     * @throws PersistenceException in case of errors loading the project
     */
    public static void loadProject(IProject project) throws PersistenceException {
        String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(project);
        if (null != projectID) {
            PLPInfo openedPLP = SPLsManager.INSTANCE.getPLP(projectID);
            if (null == openedPLP) {
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
    public static void determineConfigurationPath(IProject project) {
        String easyPath = Contributions.determineEasyConfigPath(project);
        if (null != easyPath) {
            try {
                PersistenceUtils.storeConfigLocation(project, easyPath);
            } catch (IOException ioe) {
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
            addImport(plp, predecessor.getProjectName(), predecessor.getVersion(), hasBuildScript);
        }
        Script script = plp.getBuildScript();
        if (null != script) {
            Rule main = script.getMainRule(true);
            try {
                BuildModel.INSTANCE.locations().updateLocation(plp.getConfigLocation(), ProgressObserver.NO_OBSERVER);
                // we just need an URI to a file in the config location - this avoids writing the buildScript now
                File fakeLocation = new File(plp.getConfigLocation(), "x_0.vil");
                BuildModel.INSTANCE.resolveImports(script, fakeLocation.toURI(), new ArrayList<ModelInfo<Script>>());
                for (int i = 0; i < script.getImportsCount(); i++) {
                    ModelImport<Script> imp = script.getImport(i);
                    if (null != imp.getResolved()) {
                        try {
                            Rule target = imp.getResolved().getMainRule(false);
                            main.appendCallTo(target, true);
                        } catch (ExpressionException e) {
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
     * Adds an import to the project <code>projectName</code> with version <code>version</code>.
     * 
     * @param plp the product line project to add the import to
     * @param projectName the name of the project
     * @param version the version of the import (may be <b>null</b>)
     * @param considerVIL <tt>true</tt> if the parent project has also a build script which should be considered,
     *     <tt>false</tt> otherwise
     */
    public static final void addImport(PLPInfo plp, String projectName, String version,
        boolean considerVIL) {
        
        Version ver;
        if (null == version) {
            ver = null;
        } else {
            try {
                ver = new Version(version);
            } catch (VersionFormatException e) {
                ver = null;
            }
        }
        addImport(plp, projectName, ver, considerVIL);
    }

    /**
     * Adds an import to the project <code>projectName</code> with version <code>version</code>.
     * 
     * @param plp the product line project to add the import to
     * @param projectName the name of the project
     * @param version the version of the import (may be <b>null</b>)
     * @param considerVIL <tt>true</tt> if the parent project has also a build script which should be considered,
     *     <tt>false</tt> otherwise
     */
    public static final void addImport(PLPInfo plp, String projectName, Version version,
        boolean considerVIL) {
        
        // Variability Model
        ProjectImport parentImport = new ProjectImport(projectName, null);
        VersionRestriction[] vr = {new VersionRestriction(projectName, Operator.EQUALS, version)};
        parentImport.setRestrictions(vr);
        plp.getProject().addImport(parentImport);
        
        // Build Script
        if (considerVIL) {
            ModelImport<Script> scriptImport = new ModelImport<Script>(projectName);
            //Currently not working
            Version scriptVersion = null;
            if (null != version) {
                try {
                    scriptVersion = new Version(version.getVersion());
                } catch (VersionFormatException e) {
                    // Can not happen, since a valid version was used
                    LOGGER.exception(e);
                }
            }
            VersionRestriction[] vrScript = {new VersionRestriction(projectName, Operator.EQUALS, scriptVersion)};
            scriptImport.setRestrictions(vrScript);
            plp.getBuildScript().addImport(scriptImport);
        }
    }
    
}
