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
package de.uni_hildesheim.sse.vil.rt.ui.hyperlinking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;

import de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.rtContents;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;
import net.ssehub.easy.dslCore.ui.hyperlinking.AbstractEcoreModelQuery;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;

/**
 * VIL Ecore model queries.
 * 
 * @author Holger Eichelberger
 */
public class RtVilEcoreModelQuery extends AbstractEcoreModelQuery<LanguageUnit, ILanguageElement> {

    private RtVilEcoreModelFinder finder = new RtVilEcoreModelFinder();
    
    @Override
    public String getName(LanguageUnit project) {
        return project.getName();
    }

    @Override
    public LanguageUnit getProject(ICompositeNode rootNode) {
        LanguageUnit result = null;
        if (rootNode != null && rootNode.getSemanticElement() != null 
            && rootNode.getSemanticElement() instanceof ImplementationUnit) {
            ImplementationUnit topUnit = (ImplementationUnit) rootNode.getSemanticElement();
            // Only one project per resource (file) allowed, thus, take the first element of the list
            if (topUnit.getScripts() != null && !topUnit.getScripts().isEmpty()) {
                de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.LanguageUnit tmp = topUnit.getScripts().get(0);
                if (tmp instanceof LanguageUnit) {
                    result = (LanguageUnit) tmp;
                }
            }
        }
        return result;
    }

    @Override
    public EObject getEcoreElement(CommonXtextEditor<?, LanguageUnit> editor, ILanguageElement declaration) {
        EObject desiredElement = null;
        if (editor != null && null != declaration) {
            XtextResource editorResource = getXtextResource(editor);
            LanguageUnit unit = getLanguageUnit(editorResource);
            if (unit != null) {
                rtContents sc = unit.getRtContents();
                if (sc != null) {
                    List<EObject> elts = sc.getElements();
                    for (int e = 0; null == desiredElement && e < elts.size(); e++) {
                        desiredElement = finder.getEcoreElement(elts.get(e), declaration);
                    }
                    
                }
            }
        }
        return desiredElement;
    }

    /**
     * Returns the {@link LanguageUnit} in the given resource (VTL-file).
     * 
     * @param resource the {@link XtextResource} from which the {@link LanguageUnit} should be retrieved
     * @return the {@link LanguageUnit} in the given resource. May return <code>null</code> if the
     * given resource is <code>null</code>, cannot be parsed, or there is no {@link LanguageUnit} in that file
     */
    protected LanguageUnit getLanguageUnit(XtextResource resource) {
        LanguageUnit unit = null;
        ICompositeNode rootNode = getRootNode(resource);
        if (rootNode != null) {
            EObject rootObject = rootNode.getSemanticElement();
            if (rootObject != null && rootObject instanceof ImplementationUnit) {              
                ImplementationUnit iUnit = (ImplementationUnit) rootObject;
                if (iUnit.getScripts() != null && !iUnit.getScripts().isEmpty()) {
                    Object tmp = iUnit.getScripts().get(0);
                    if (tmp instanceof LanguageUnit) {
                        unit = (LanguageUnit) tmp;
                    }
                }
            }
        }
        return unit;
    }

}
