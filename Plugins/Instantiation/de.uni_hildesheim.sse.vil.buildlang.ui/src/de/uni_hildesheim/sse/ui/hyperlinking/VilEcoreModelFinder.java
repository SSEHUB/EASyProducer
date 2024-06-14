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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.RuleElementBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.Compound;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;

/**
 * A Ecore model element finder for VIL.
 * 
 * @author Holger Eichelberger
 */
public class VilEcoreModelFinder {

    /**
     * Returns the ECore object for <code>declaration</code> defined in <code>contentElement</code>.
     * 
     * @param contentElement the content element to search within
     * @param declaration the declaration to search
     * @return the ECore object representing <code>declaration</code>, may be <b>null</b> if not found
     */
    public EObject getEcoreElement(EObject contentElement, ILanguageElement declaration) {
        EObject result = null;
        // TODO consider parameters!
        if (contentElement instanceof de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration 
            && declaration instanceof VariableDeclaration && declaration.getParent() instanceof Script) {
            if (((VariableDeclaration) declaration).getName().equals(
                ((de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration) contentElement).getName())) {
                result = contentElement;
            }
        }
        if (null == result && contentElement instanceof de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef 
            && declaration instanceof Typedef && declaration.getParent() instanceof Script) {
            if (((Typedef) declaration).getName().equals(
                ((de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef) contentElement).getName())) {
                result = contentElement;
            }
        }
        if (null == result && contentElement instanceof Compound
            && declaration.getParent() instanceof Script) {
            if (((Compound) declaration).getName().equals(
                ((de.uni_hildesheim.sse.vil.expressions.expressionDsl.Compound) contentElement).getName())) {
                result = contentElement;
            }
        }
        if (null == result && contentElement instanceof RuleDeclaration) {
            RuleDeclaration ruleDecl = (RuleDeclaration) contentElement;
            if (declaration instanceof Rule && declaration.getParent() instanceof Script) {
                if (((Rule) declaration).getName().equals(ruleDecl.getName())) {
                    result = contentElement;
                }
            }
            if (declaration instanceof VariableDeclaration && !(declaration.getParent() instanceof Script)) {
                int level = calcLevel(declaration, Rule.class);
                result = findInRuleElts(ruleDecl.getBlock().getElements(), declaration, level);
            }
        }
        return result;
    }

    /**
     * Determines the nesting level of <code>element</code> until <code>stopCls</code>.
     * 
     * @param elt the element to determine the nesting for
     * @param stopCls the stop class or run until the topmost parent
     * @return the nesting level
     */
    protected int calcLevel(ILanguageElement elt, Class<?> stopCls) {
        int level = 0;
        ILanguageElement iter = elt.getParent();
        while (null != iter && !(stopCls.isInstance(iter))) {
            iter = iter.getParent();
            level++;
        }
        return level;
    }

    /**
     * Tries finding <code>declaration</code> in the defs of <code>block</code>.
     * 
     * @param block the block to search
     * @param declaration the declaration to search for
     * @param level the actual nesting level starting with the one of <code>element</code>, if greater 0 recurse to the 
     *   next levels
     * @return the found EObject or <b>null</b> if not found
     */
    protected EObject findInRuleElts(RuleElementBlock block, ILanguageElement declaration, int level) {
        EObject result = null;
        if (null != block) {
            result = findInRuleElts(block.getElements(), declaration, level);
        }
        return result;
    }

    /**
     * Tries finding <code>declaration</code> in the defs of <code>elts</code>.
     * 
     * @param elts the elements to search
     * @param declaration the declaration to search for
     * @param level the actual nesting level starting with the one of <code>element</code>, if greater 0 recurse to the 
     *   next levels
     * @return the found EObject or <b>null</b> if not found
     */
    protected EObject findInRuleElts(List<? extends RuleElement> elts, ILanguageElement declaration, int level) {
        EObject result = null;
        if (null != elts) {
            for (int s = 0; null == result && s < elts.size(); s++) {
                result = findInRuleElt(elts.get(s), declaration, level); // same level!
            }
        }
        return result;
    }

    /**
     * Tries finding <code>declaration</code> in <code>elt</code>.
     * 
     * @param elt the element to search
     * @param declaration the declaration to search for
     * @param level the actual nesting level starting with the one of <code>element</code>, if greater 0 recurse to the 
     *   next levels
     * @return the found EObject or <b>null</b> if not found
     */
    protected EObject findInRuleElt(RuleElement elt, ILanguageElement declaration, int level) {
        EObject result = null;
        if (null != elt) {
            if (0 == level) {
                if (null != elt.getVarDecl() && declaration instanceof VariableDeclaration) {
                    if (((VariableDeclaration) declaration).getName().equals(elt.getVarDecl().getName())) {
                        result = elt.getVarDecl();
                    }
                }
            } else {
                if (null != elt.getFor()) {
                    result = findInRuleElts(elt.getFor().getBlock(), declaration, level);
                } else if (null != elt.getWhile()) {
                    result = findInRuleElts(elt.getWhile().getBlock(), declaration, level);
                }
                // TODO handle (complex) expressions
            }
        }
        return result;
    }

}
