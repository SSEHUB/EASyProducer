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

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;

import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericEditorOpener;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericHyperlink;
import net.ssehub.easy.dslCore.ui.hyperlinking.IHyperlinkFactory;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;

/**
 * VIL hyperlink factory.
 * 
 * @author Holger Eichelberger
 */
public class VilHyperlinkFactory implements IHyperlinkFactory<LanguageUnit> {

    public static final VilEcoreModelQuery MODEL_QUERY_INSTANCE = new VilEcoreModelQuery();
    public static final VilHyperlinkFactory INSTANCE = new VilHyperlinkFactory();
    public static GenericEditorOpener<ImplementationUnit, LanguageUnit, Script, 
        IBuildlangElement, ILanguageElement> OPENER = new GenericEditorOpener<ImplementationUnit, LanguageUnit, Script, 
        IBuildlangElement, ILanguageElement>(MODEL_QUERY_INSTANCE, VilModelQuery.INSTANCE);

    @Override
    public AbstractHyperlink createHyperlink(ILeafNode parseTreeElement, LanguageUnit project) {
        return new GenericHyperlink<LanguageUnit>(parseTreeElement, project, this);
    }

    @Override
    public GenericEditorOpener<?, LanguageUnit, ?, ?, ?> getEditorOpener() {
        return OPENER;
    }

}
