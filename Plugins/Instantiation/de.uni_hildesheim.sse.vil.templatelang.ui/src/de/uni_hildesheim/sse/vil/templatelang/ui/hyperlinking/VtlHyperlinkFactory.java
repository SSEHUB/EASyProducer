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
package de.uni_hildesheim.sse.vil.templatelang.ui.hyperlinking;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericEditorOpener;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericHyperlink;
import net.ssehub.easy.dslCore.ui.hyperlinking.IHyperlinkFactory;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.templateModel.ITemplateLangElement;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;

/**
 * VIL hyperlink factory.
 * 
 * @author Holger Eichelberger
 */
public class VtlHyperlinkFactory implements IHyperlinkFactory<LanguageUnit> {

    public static final VtlEcoreModelQuery MODEL_QUERY_INSTANCE = new VtlEcoreModelQuery();
    public static final VtlHyperlinkFactory INSTANCE = new VtlHyperlinkFactory();
    public static GenericEditorOpener<LanguageUnit, LanguageUnit, Template, 
        ITemplateLangElement, ILanguageElement> OPENER = new GenericEditorOpener<LanguageUnit, LanguageUnit, 
        Template, ITemplateLangElement, ILanguageElement>(MODEL_QUERY_INSTANCE, VtlModelQuery.INSTANCE);

    @Override
    public AbstractHyperlink createHyperlink(ILeafNode parseTreeElement, LanguageUnit project) {
System.err.println("CREATING HYPERLINK FOR " + parseTreeElement);        
        return new GenericHyperlink<LanguageUnit>(parseTreeElement, project, this);
    }

    @Override
    public GenericEditorOpener<?, LanguageUnit, ?, ?, ?> getEditorOpener() {
        return OPENER;
    }

}
