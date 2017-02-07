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

import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.ui.hyperlinking.IModelQuery;
import net.ssehub.easy.dslCore.ui.hyperlinking.ModelUtils;
import net.ssehub.easy.dslCore.ui.hyperlinking.ModelUtils.IModelFinder;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.Utils;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.ITemplateLangElement;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TypeDef;
import net.ssehub.easy.instantiation.core.model.templateModel.VariableDeclaration;

/**
 * VTL Model Query implementation.
 * 
 * @author Holger Eichelberger
 */
public class VtlModelQuery implements IModelQuery<Template, ITemplateLangElement, ILanguageElement>, 
    IModelFinder<Template, ITemplateLangElement> {
    
    public static final VtlModelQuery INSTANCE = new VtlModelQuery();

    @Override
    public ModelManagement<Template> getModelManagement() {
        return TemplateModel.INSTANCE;
    }

    @Override
    public ITemplateLangElement getModelElement(String selectedElement, String selectedElementsProjectName) {
        return ModelUtils.getModelElement(selectedElement, selectedElementsProjectName, 
            getModelManagement(), this);
    }

    @Override
    public Template getParentProject(ITemplateLangElement modelElement) {
        return Utils.getParentProject(modelElement, Template.class);
    }

    @Override
    public ILanguageElement findDeclaration(Template template, ITemplateLangElement modelElement) {
        return modelElement;
    }

    @Override
    public ITemplateLangElement findElement(Template model, String name) {
        ITemplateLangElement result = null;
        for (int v = 0; null == result && v < model.getVariableDeclarationCount(); v++) {
            VariableDeclaration decl = model.getVariableDeclaration(v);
            if (decl.getName().equals(name)) {
                result = decl;
            }
        }
        for (int d = 0; null == result && d < model.getDefCount(); d++) {
            Def def = model.getDef(d);
            if (def.getName().equals(name)) {
                result = def;
            }
        }
        for (int t = 0; null == result && t < model.getTypedefCount(); t++) {
            Typedef td = model.getTypedef(t);
            if (td.getName().equals(name) && td instanceof TypeDef) {
                result = (TypeDef) td;
            }
        }
        return result;
    }

}
