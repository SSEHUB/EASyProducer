/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.ui.hyperlinking;

import de.uni_hildesheim.sse.ui.Activator;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.ui.hyperlinking.IModelQuery;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.ModelElementTypeFinder;
import net.ssehub.easy.varModel.model.filter.ModelElementTypeFinder.ModelElementDescription;

public class IvmlModelQuery implements IModelQuery<Project, ContainableModelElement, ModelElementDescription> {

    public static final IvmlModelQuery INSTANCE = new IvmlModelQuery();
    
    @Override
    public ModelManagement<Project> getModelManagement() {
        return VarModel.INSTANCE;
    }

    @Override
    public ContainableModelElement getModelElement(String selectedElement, String selectedElementsProjectName) {
        // Find the corresponding VarModel element for the selected element
        ContainableModelElement modelElement = null;
        if (selectedElement != null && !selectedElement.isEmpty() && selectedElementsProjectName != null
                        && !selectedElementsProjectName.isEmpty()) {
            int modelCount = VarModel.INSTANCE.getModelCount();
            int modelCounter = 0;
            while (modelElement == null && modelCounter < modelCount) {
                if (VarModel.INSTANCE.getModel(modelCounter).getName().equals(selectedElementsProjectName)) {
                    try {
                        modelElement = ModelQuery.findElementByName(VarModel.INSTANCE.getModel(modelCounter),
                            selectedElement, null);
                    } catch (ModelQueryException e) {
                        getLogger().error("Obtaining model element: " + e.getMessage());
                    }
                }
                modelCounter++;
            }
        }
        return modelElement;
    }
    
    /**
     * Returns the parent {@link net.ssehub.easy.varModel.model.Project} the
     * given {@link ContainableModelElement} is declared in.
     * 
     * @param modelElement
     *            the {@link ContainableModelElement} for which the parent
     *            project should be found
     * @return the parent {@link net.ssehub.easy.varModel.model.Project} the
     *         given {@link ContainableModelElement} is declared in. May return
     *         <code>null</code> if the given model element is <code>null</code>
     *         , if the model element has no top-level parent (which typically
     *         is the {@link net.ssehub.easy.varModel.model.Project}), or the
     *         top-level parent is not an instance of
     *         {@link net.ssehub.easy.varModel.model.Project}.
     */
    public Project getParentProject(ContainableModelElement modelElement) {
        Project parentProject = null;
        if (modelElement != null && modelElement.getTopLevelParent() != null
                        && modelElement.getTopLevelParent() instanceof Project) {
            parentProject = (Project) modelElement.getTopLevelParent();
        }
        return parentProject;
    }
    
    /**
     * Returns the logger.
     * 
     * @return the logger
     */
    private EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(IvmlModelQuery.class, Activator.PLUGIN_ID);
    }

    @Override
    public ModelElementDescription findDeclaration(Project project, ContainableModelElement modelElement) {
        ModelElementTypeFinder typeFinder = new ModelElementTypeFinder(project, FilterType.ALL);
        ModelElementDescription varModelElementTypeDescription = typeFinder
            .getDatatypeByElementName(modelElement.getName());
        return varModelElementTypeDescription;
    }

}
