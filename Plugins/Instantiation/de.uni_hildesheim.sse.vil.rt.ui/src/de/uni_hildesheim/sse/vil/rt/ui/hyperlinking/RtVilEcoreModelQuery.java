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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;

import de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit;
import de.uni_hildesheim.sse.vil.rt.rtVil.LanguageUnit;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;
import net.ssehub.easy.dslCore.ui.hyperlinking.AbstractEcoreModelQuery;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;

/**
 * VIL Ecore model queries.
 * 
 * @author Holger Eichelberger
 */
public class RtVilEcoreModelQuery extends AbstractEcoreModelQuery<LanguageUnit, ILanguageElement> {

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
                de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit tmp = topUnit.getScripts().get(0);
                if (tmp instanceof LanguageUnit) {
                    result = (LanguageUnit) tmp;
                }
            }
        }
        return result;
    }

    @Override
    public EObject getEcoreElement(CommonXtextEditor<?, LanguageUnit> editor,
            ILanguageElement elementDescription) {
        // TODO Auto-generated method stub
        return null;
    }

}
