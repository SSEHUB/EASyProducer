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

import de.uni_hildesheim.sse.ui.hyperlinking.VilModelQuery;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.dslCore.ui.hyperlinking.IModelQuery;
import net.ssehub.easy.dslCore.ui.hyperlinking.ModelUtils;
import net.ssehub.easy.dslCore.ui.hyperlinking.ModelUtils.IModelFinder;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangElement;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.Utils;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Strategy;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Tactic;

/**
 * VIL Model Query implementation.
 * 
 * @author Holger Eichelberger
 */
public class RtVilModelQuery implements IModelQuery<Script, IBuildlangElement, ILanguageElement>, 
    IModelFinder<Script, IBuildlangElement> {
    
    public static final RtVilModelQuery INSTANCE = new RtVilModelQuery();

    @Override
    public ModelManagement<Script> getModelManagement() {
        return RtVilModel.INSTANCE;
    }

    @Override
    public IBuildlangElement getModelElement(String selectedElement, String selectedElementsProjectName) {
        return ModelUtils.getModelElement(selectedElement, selectedElementsProjectName, getModelManagement(), this);
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
        IBuildlangElement result = null;
        for (int s = 0; null == result && s < model.getStrategiesCount(); s++) {
            Strategy strategy = model.getStrategy(s);
            if (strategy.getName().equals(name)) {
                result = strategy;
            }
        }
        for (int t = 0; null == result && t < model.getTacticsCount(); t++) {
            Tactic tactic = model.getTactic(t);
            if (tactic.getName().equals(name)) {
                result = tactic;
            }
        }
        if (null == result) {
            result = VilModelQuery.findScriptElement(model, name);
        }
        return result;
    }

}
