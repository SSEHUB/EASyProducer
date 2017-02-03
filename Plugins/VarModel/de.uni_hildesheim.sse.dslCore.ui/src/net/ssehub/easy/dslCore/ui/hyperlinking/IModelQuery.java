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
package net.ssehub.easy.dslCore.ui.hyperlinking;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelManagement;

/**
 * Performs queries on the respective semantic model.
 * 
 * @param <M> the model type
 * @param <E> the model element type
 * @param <R> the result type when querying for model elements (must fit to {@link IEcoreModelQuery})
 * @author Holger Eichelberger
 */
public interface IModelQuery <M extends IModel, E, R> {
    
    /**
     * Returns the model management instance.
     * 
     * @return the model management instance
     */
    public ModelManagement<M> getModelManagement();

    /**
     * Returns the element of the model identified by the selected
     * element (the name) and the scope which is the name of the project the
     * selected element is located in.
     * 
     * @param selectedElement
     *            the name of the selected element as a {@link String} for which
     *            the element in the model should be found.
     * @param selectedElementsProjectName
     *            the name of the project of the selected element as a
     *            {@link String} which is used as the starting point for finding
     *            the corresponding element in the model
     * @return the element in the model identified by the given name of the selected
     *         element. May return <code>null</code> if the element could not be
     *         found.
     */
    public E getModelElement(String selectedElement, String selectedElementsProjectName);
    
    /**
     * Returns the parent model/project the model element is declared in.
     * 
     * @param modelElement
     *            the model element for which the parent
     *            project should be found
     * @return the parent project the given model element is declared in. May return
     *         <code>null</code> if the given model element is <code>null</code>, 
     *         if the model element has no top-level parent (which typically
     *         is the project, or the top-level parent is not an instance of
     *         project.
     */
    public M getParentProject(E modelElement);

    /**
     * Finds a model element an returns a generic result.
     * 
     * @param project the project to search within
     * @param modelElement the model element
     * @return the result, <b>null</b> if not found
     */
    public R findDeclaration(M project, E modelElement);
    
}
