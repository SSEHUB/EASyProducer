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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;

/**
 * An absract implementation of the Ecore model query interface with common helpful functionality.
 * 
 * @param <P> the type of the "project", the top-most semantic language unit
 * @param <R> {@link IModelQuery} search result type
 * 
 * @author kroeher
 * @author Holger Eichelberger
 */
public abstract class AbstractEcoreModelQuery<P extends EObject, R> implements IEcoreModelQuery<P, R> {

    /**
     * Stores the current {@link XtextResource} that is the basis for parsing the Ecore-model
     * which in turn is used for retrieving elements from.
     * 
     * This attribute is used to avoid parsing the same {@link XtextResource} multiple times.
     */
    private XtextResource currentResource;
    
    /**
     * Stores the current {@link XtextEditor} from which the {@link XtextResource} is used as a basis
     * for parsing the Ecore-model which in turn is used for retrieving elements from.
     * 
     * This attribute is used to avoid parsing the same {@link XtextResource} multiple times.
     */
    private CommonXtextEditor<?, P> currentEditor;

    /**
     * Checks whether the given {@link String} is not <code>null</code> or empty.
     * 
     * @param stringToCheck the {@link String} to check
     * @return <code>true</code> if the given {@link String} is not <code>null</code> or empty. 
     *     <code>False</code> otherwise.
     */
    protected static boolean notEmpty(String stringToCheck) {
        return stringToCheck != null && !stringToCheck.isEmpty();
    }
    
    /**
     * Checks whether the given {@link EList} is not <code>null</code> or empty.
     * 
     * @param eListToCheck the {@link EList} to check
     * @return <code>true</code> if the given {@link EList} is not <code>null</code> or empty. 
     *     <code>False</code> otherwise.
     */
    protected static boolean notEmpty(EList<?> eListToCheck) {
        return eListToCheck != null && !eListToCheck.isEmpty();
    }
    
    /**
     * Checks whether the given {@link List} is not <code>null</code> or empty.
     * 
     * @param listToCheck the {@link List} to check
     * @return <code>true</code> if the given {@link List} is not <code>null</code> or empty. 
     *     <code>False</code> otherwise.
     */
    protected static boolean notEmpty(List<?> listToCheck) {
        return listToCheck != null && !listToCheck.isEmpty();
    }

    /**
     * Returns the {@link XtextResource} currently displayed by the given editor.
     * 
     * This code for reading the resource is copied from: http://code.google.com/a/eclipselabs.org/p/vclipse/source
     * /browse/trunk/plugins/org.vclipse.base.ui/src/org/vclipse/base/ui/util/EditorUtilsExtensions.java?r=1498
     * 
     * @param ivmlEditor the {@link XtextEditor} from which the resource should be retrieved
     * @return the {@link XtextResource} currently displayed by the given editor. May return <code>null</code> if the
     * given editor is <code>null</code> or the resource of that editor cannot be read.
     */
    protected XtextResource getXtextResource(CommonXtextEditor<?, P> ivmlEditor) {
        XtextResource editorResource = null;
        if (ivmlEditor != null && ivmlEditor.getDocument() != null) {
            if (ivmlEditor.equals(currentEditor)) {
                editorResource = currentResource;
            } else {
                currentEditor = ivmlEditor;
                currentResource = (XtextResource) ivmlEditor.getDocument()
                                .readOnly(new IUnitOfWork<EObject, XtextResource>() {
                                    @Override
                                    public EObject exec(XtextResource resource) throws Exception {
                                        return resource.getParseResult().getRootASTElement();
                                    }
                                }).eResource();
                editorResource = currentResource;
            }
        }

        return editorResource;
    }
    
    /**
     * Returns the {@link ICompositeNode} of the Ecore-model that represent the root node.
     * 
     * @param resource the {@link XtextResource} from which the root node should be retrieved
     * @return the {@link ICompositeNode} of the Ecore-model that represent the root node. May return
     * <code>null</code> if the given resource is <code>null</code> or cannot be parsed
     */
    public ICompositeNode getRootNode(XtextResource resource) {
        ICompositeNode rootNode = null;
        if (resource != null) {
            IParseResult resourceParseResult = resource.getParseResult();
            if (resourceParseResult != null && resourceParseResult.getRootNode() != null) {
                rootNode = resourceParseResult.getRootNode();
            }
        }
        return rootNode;
    }

}
