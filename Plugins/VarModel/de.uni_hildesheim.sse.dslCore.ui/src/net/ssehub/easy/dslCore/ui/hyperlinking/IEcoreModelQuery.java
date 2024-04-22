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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;

import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;
import net.ssehub.easy.varModel.model.filter.ModelElementTypeFinder.ModelElementDescription;

/**
 * Performs queries on underlying models.
 * 
 * @param <P> the type of the "project", the top-most semantic language unit
 * @param <R> {@link IModelQuery} search result type
 * @author Holger Eichelberger
 */
public interface IEcoreModelQuery <P extends EObject, R> {

    /**
     * Returns the name of the project.
     * 
     * @param project the project
     * @return the name of <code>project</code>
     */
    public String getName(P project);
    
    /**
     * Returns the {@link ICompositeNode} of the Ecore-model that represent the root node.
     * 
     * @param resource the {@link XtextResource} from which the root node should be retrieved
     * @return the {@link ICompositeNode} of the Ecore-model that represent the root node. May return
     * <code>null</code> if the given resource is <code>null</code> or cannot be parsed
     */
    public ICompositeNode getRootNode(XtextResource resource);

    /**
     * Returns the "project" of the Ecore-model represented by the given root node.
     * 
     * @param rootNode the {@link ICompositeNode} which is the root of the Ecore-model from which the
     * "project" should be retrieved
     * @return the "project" in the given resource. May return <code>null</code> if the
     * given root node is <code>null</code>, or there is no "project" in that file
     */
    public P getProject(ICompositeNode rootNode);
    
    /**
     * Returns the {@link EObject} of the parse tree of the given editor's resource that matches the element
     * described by the given {@link ModelElementDescription}.
     * 
     * The search for this object will be performed in the Ecore-model of the given editor's resource only. This
     * requires that it is ensured that the given editor displays a file which includes the desired element.
     * 
     * @param editor the {@link XtextEditor} which displays the file in which the desired element should
     * be found
     * @param elementDescription the {@link ModelElementDescription} that describes the model element that should
     * be found in the parse tree of the given editor's resource
     * @return the {@link EObject} that matches the element described by the given {@link ModelElementDescription}. May
     * return <code>null</code> if the element could not be found
     */
    public EObject getEcoreElement(CommonXtextEditor<?, P> editor, R elementDescription);

}
