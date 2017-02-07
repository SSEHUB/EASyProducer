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

import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.ui.hyperlinking.IModelQuery;
import net.ssehub.easy.dslCore.ui.hyperlinking.ModelUtils;
import net.ssehub.easy.dslCore.ui.hyperlinking.ModelUtils.IModelFinder;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.TypeDef;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.Utils;

/**
 * VIL Model Query implementation.
 * 
 * @author Holger Eichelberger
 */
public class VilModelQuery implements IModelQuery<Script, IBuildlangElement, ILanguageElement>, 
    IModelFinder<Script, IBuildlangElement> {
    
    public static final VilModelQuery INSTANCE = new VilModelQuery();

    @Override
    public ModelManagement<Script> getModelManagement() {
        return BuildModel.INSTANCE;
    }

    @Override
    public IBuildlangElement getModelElement(String selectedElement, String selectedElementsProjectName) {
        return ModelUtils.getModelElement(selectedElement, selectedElementsProjectName, 
            getModelManagement(), this);
    }

    @Override
    public Script getParentProject(IBuildlangElement modelElement) {
        return Utils.getParentProject(modelElement, Script.class);
    }

    @Override
    public ILanguageElement findDeclaration(Script project, IBuildlangElement modelElement) {
        return modelElement;
    }

    @Override
    public IBuildlangElement findElement(Script model, String name) {
        return findScriptElement(model, name);
    }

    /**
     * Tries to find an element declaration for <code>name</code>.
     * 
     * @param model the model
     * @param name the name to search for
     * @return the declaration or <b>null</b>
     */
    public static IBuildlangElement findScriptElement(Script model, String name) {
        IBuildlangElement result = null;
        for (int v = 0; null == result && v < model.getVariableDeclarationCount(); v++) {
            VariableDeclaration decl = model.getVariableDeclaration(v);
            if (decl.getName().equals(name)) {
                result = decl;
            }
        }
        for (int r = 0; null == result && r < model.getRuleCount(); r++) {
            Rule rule = model.getRule(r);
            if (rule.getName().equals(name)) {
                result = rule;
            }
        }
        for (int t = 0; null == result && t < model.getTypedefCount(); t++) {
            Typedef td = model.getTypedef(t);
            if (td.getName().equals(name) && td instanceof TypeDef) {
                result = (TypeDef) td;
            }
        }
System.err.println(model.getName()+" "+name+" -> "+result);        
        return result;
    }

}
