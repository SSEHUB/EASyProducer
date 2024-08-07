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

package net.ssehub.easy.producer.ui.project_management;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.XtextProjectHelper;

import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.EASyNature;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.NatureUtils;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.InvalidProjectnameException;

/**
 * Utilities on Eclipse project level interferring with UI.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class ProjectUtils {
    
    /**
     * Toggles the EASy nature of <code>project</code>.
     * 
     * @param project the project to toggle the EASy nature for
     * @throws IOException in case of initialization problems
     * @throws InvalidProjectnameException if a projectname is not valid
     */
    public static final void toggleNature(IProject project) throws IOException, InvalidProjectnameException {
        try {
            boolean hasNature = NatureUtils.hasNature(project, EASyNature.NATURE_ID);
            if (!hasNature) {
                ResourcesMgmt.INSTANCE.addEASyNatures(project, XtextProjectHelper.NATURE_ID, EASyNature.NATURE_ID);
            } else {
                String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(project, project);
                ProductLineProject deletedPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(projectID);
                if (null != deletedPLP) {
                    deletedPLP.close();
                }
                NatureUtils.removeNature(project, EASyNature.NATURE_ID, null);
                project.refreshLocal(IProject.DEPTH_INFINITE, null);
            }
        } catch (CoreException e) {
            throw new IOException(e.getMessage());
        }
    }
}
