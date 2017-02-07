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

import de.uni_hildesheim.sse.ui.hyperlinking.VilEcoreModelFinder;
import de.uni_hildesheim.sse.vil.expressions.ui.hyperlinking.AbstractEcoreModelQuery;
import de.uni_hildesheim.sse.vil.rt.rtVil.StrategyDeclaration;
import de.uni_hildesheim.sse.vil.rt.rtVil.TacticDeclaration;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Strategy;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Tactic;

/**
 * A Ecore model element finder for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilEcoreModelFinder extends VilEcoreModelFinder {

    @Override
    public EObject getEcoreElement(EObject contentElement, ILanguageElement declaration) {
        EObject result = super.getEcoreElement(contentElement, declaration);

        if (null == result && contentElement instanceof StrategyDeclaration) {
            StrategyDeclaration strategyDecl = (StrategyDeclaration) contentElement;
            if (declaration instanceof Strategy && declaration.getParent() instanceof Script) {
                if (((Strategy) declaration).getName().equals(strategyDecl.getName())) {
                    result = contentElement;
                }
            }
            if (declaration instanceof VariableDeclaration && !(declaration.getParent() instanceof Script)) {
                result = AbstractEcoreModelQuery.findVariableDeclaration(strategyDecl.getVarDecls(), 
                    (VariableDeclaration) declaration);
                if (null == result) {
                    int level = calcLevel(declaration, Strategy.class);
                    result = findInRuleElts(strategyDecl.getPost(), declaration, level);
                }
            }
        }

        if (null == result && contentElement instanceof TacticDeclaration) {
            TacticDeclaration tacticDecl = (TacticDeclaration) contentElement;
            if (declaration instanceof Tactic && declaration.getParent() instanceof Script) {
                if (((Tactic) declaration).getName().equals(tacticDecl.getName())) {
                    result = contentElement;
                }
            }
            if (declaration instanceof VariableDeclaration && !(declaration.getParent() instanceof Script)) {
                int level = calcLevel(declaration, Tactic.class);
                result = findInRuleElts(tacticDecl.getBlock(), declaration, level);
            }
        }

        return result;
    }
    
}
