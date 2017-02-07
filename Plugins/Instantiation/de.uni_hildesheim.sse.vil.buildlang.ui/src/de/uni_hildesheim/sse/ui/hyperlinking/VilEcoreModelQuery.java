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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;

import de.uni_hildesheim.sse.vil.expressions.ui.hyperlinking.AbstractEcoreModelQuery;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElement;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleElementBlock;
import de.uni_hildesheim.sse.vilBuildLanguage.ScriptContents;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;

/**
 * VIL Ecore model queries.
 * 
 * @author Holger Eichelberger
 */
public class VilEcoreModelQuery extends AbstractEcoreModelQuery<LanguageUnit, ILanguageElement> {

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
                result = topUnit.getScripts().get(0);
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
                ScriptContents sc = unit.getContents();
                if (sc != null) {
                    List<EObject> elts = sc.getElements();
                    for (int e = 0; null == desiredElement && e < elts.size(); e++) {
                        desiredElement = getEcoreElement(elts.get(e), declaration);
                    }
                    
                }
            }
        }
        return desiredElement;
    }

    /**
     * Returns the ECore object for <code>declaration</code> defined in <code>contentElement</code>.
     * 
     * @param contentElement the content element to search within
     * @param declaration the declaration to search
     * @return the ECore object representing <code>declaration</code>, may be <b>null</b> if not found
     */
    protected EObject getEcoreElement(EObject contentElement, ILanguageElement declaration) {
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
        if (null == result && contentElement instanceof RuleDeclaration) {
            RuleDeclaration ruleDecl = (RuleDeclaration) contentElement;
            if (declaration instanceof Rule && declaration.getParent() instanceof Script) {
                if (((Rule) declaration).getName().equals(ruleDecl.getName())) {
                    result = contentElement;
                }
            }
            if (declaration instanceof VariableDeclaration && !(declaration.getParent() instanceof Script)) {
                int level = 0;
                ILanguageElement iter = declaration.getParent();
                while (null != iter && !(iter instanceof Rule)) {
                    iter = iter.getParent();
                    level++;
                }
                result = findInRuleElts(ruleDecl.getBlock().getElements(), declaration, level);
            }
        }
        return result;
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
    private EObject findInRuleElts(RuleElementBlock block, ILanguageElement declaration, int level) {
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
    private EObject findInRuleElts(List<RuleElement> elts, ILanguageElement declaration, int level) {
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
    private EObject findInRuleElt(RuleElement elt, ILanguageElement declaration, int level) {
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
                    unit = iUnit.getScripts().get(0);
                }
            }
        }
        return unit;
    }


}
