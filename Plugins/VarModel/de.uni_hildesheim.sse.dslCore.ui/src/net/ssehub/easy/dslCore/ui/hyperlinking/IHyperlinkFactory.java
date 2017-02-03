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
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;

/**
 * Creates language-dependent hyperlinks.
 * 
 * @param <P> the type of the "project", the top-most semantic language unit
 * 
 * @author Holger Eichelberger
 */
public interface IHyperlinkFactory <P extends EObject> {

    /**
     * Creates an hyperlink instance for the given {@link ILeafNode}
     * which enables the jump to the element's declaration the node represents.
     * 
     * This is a user visible feature as this hyperlink is shown when the user holds CTRL and points
     * to an element in an editor.
     * 
     * @param parseTreeElement the {@link ILeafNode} of the parsed resource for which this hyperlink
     * should be created
     * @param project the "project" the given node is located in
     * @return the hyperlink
     */
    public AbstractHyperlink createHyperlink(ILeafNode parseTreeElement, P project);

    /**
     * Returns the editor opener.
     * 
     * @return the editor opener
     */
    public GenericEditorOpener<?, P, ?, ?, ?> getEditorOpener();
    
}
