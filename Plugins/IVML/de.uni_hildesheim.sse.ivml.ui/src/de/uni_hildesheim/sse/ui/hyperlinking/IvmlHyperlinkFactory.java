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

import de.uni_hildesheim.sse.ivml.Project;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericEditorOpener;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericHyperlink;
import net.ssehub.easy.dslCore.ui.hyperlinking.IHyperlinkFactory;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.filter.ModelElementTypeFinder.ModelElementDescription;

/**
 * A IVML hyperlink factory.
 * 
 * @author Holger Eichelberger
 */
public class IvmlHyperlinkFactory implements IHyperlinkFactory<Project> {

    public static final IvmlHyperlinkFactory INSTANCE = new IvmlHyperlinkFactory();
    public static GenericEditorOpener<VariabilityUnit, Project, net.ssehub.easy.varModel.model.Project, 
        ContainableModelElement, ModelElementDescription> OPENER = new GenericEditorOpener<VariabilityUnit, Project, 
        net.ssehub.easy.varModel.model.Project, ContainableModelElement, ModelElementDescription>(EcoreModelQuery.INSTANCE, IvmlModelQuery.INSTANCE);

    @Override
    public AbstractHyperlink createHyperlink(ILeafNode parseTreeElement, Project project) {
        return new GenericHyperlink<Project>(parseTreeElement, project, this);
    }

    @Override
    public GenericEditorOpener<?, Project, ?, ?, ?> getEditorOpener() {
        return OPENER;
    }

}
