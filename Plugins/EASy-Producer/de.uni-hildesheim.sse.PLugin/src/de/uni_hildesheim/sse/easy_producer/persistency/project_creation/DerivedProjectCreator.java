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

import org.eclipse.core.resources.IProject;

import de.uni_hildesheim.sse.easy_producer.EASyUtils;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;

/**
 * Creates a derived EASy project, which will have one predecessor.
 * @author El-Sharkawy
 *
 */
class DerivedProjectCreator extends AbstractProjectCreator {
    
    private String predecessorID;
    private ProductLineProject parentPLP;
    private IProject predecessorPoject;
    
    /**
     * Creates a new derived {@link ProductLineProject}.
     * @param projectName The name of the new project (should already be checked, whether the name is valid).
     * @param predecessorID The projectID of a predecessor for the new project, must not be <tt>null</tt>.
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before.
     * @param configurators Optional list of configurators to configure the newly created project, maybe <tt>null</tt>.
     *     The configurators whill be applied in the ordering of the array.
     */
    DerivedProjectCreator(String projectName, String predecessorID, boolean lazy,
        IEASyProjectConfigurator[] configurators) {
        
        super(projectName, lazy, configurators);
        this.predecessorID = predecessorID;
        parentPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(predecessorID);
        predecessorPoject = (null != parentPLP) ? ResourcesMgmt.INSTANCE.getProject(parentPLP.getProjectName()) : null;
    }

    /**
     * Creates the derived {@link ProductLineProject}.
     * @return The newly created {@link ProductLineProject}.
     */
    @Override
    ProductLineProject createEASyProject() {
        super.createProject();

        // Set Predecessors
        getCreatedProject().getMemberController().addPredecessor(predecessorID);
        
        // Support old EASy project, which do not contain any build scripts
        boolean hasBuildScript = null != parentPLP.getBuildScript();
        EASyUtils.addImport(getCreatedProject(), parentPLP, hasBuildScript);

        // Save parent plp
        parentPLP.save();

        // Set Successor
        parentPLP.getMemberController().addSuccessor(getCreatedProject().getProjectID());

        // Configure the newly created PTN
        getCreatedProject().pullConfigFromPredecessors();
        createScriptImports();
        getCreatedProject().save();

        // Sets persistence properties for the newly created project and refreshes the workspace/models
        super.setPersistenceProperties();
   
        return getCreatedProject();
    }

    /**
     * Adds call to build script of predecessor to own build script.
     */
    protected void createScriptImports() {
        PLPInfo plp = getCreatedProject();
        PLPInfo parentPLP = SPLsManager.INSTANCE.getPLP(predecessorID);

        PersistenceUtils.createInstantiatePredecessorScript(plp, parentPLP);
    }

    @Override
    protected void configureProject(IProject project, IEASyProjectConfigurator configurator) {
        if (null != predecessorPoject) {
            // Try to take over settings from parent project.
            configurator.configure(project, predecessorPoject);
        } else {
            // Use default settings if parent could not be found
            configurator.configure(project);
        }
    }
}
