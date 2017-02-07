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
package de.uni_hildesheim.sse.vil.expressions.ui.hyperlinking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import net.ssehub.easy.dslCore.ui.hyperlinking.IModelQuery;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;

/**
 * Some common functionality for the common VIL expressions language.
 * 
 * @param <P> the type of the "project", the top-most semantic language unit
 * @param <R> {@link IModelQuery} search result type
 * @author Holger Eichelberger
 */
public abstract class AbstractEcoreModelQuery<P extends EObject, R> 
    extends net.ssehub.easy.dslCore.ui.hyperlinking.AbstractEcoreModelQuery<P, R> {
    
    /**
     * Tries finding <code>element</code> in <code>defs</code>.
     * 
     * @param defs the variable declarations to search within
     * @param element the element to search for
     * @return the found variable declaration or <b>null</b>
     */
    public static EObject findVariableDeclaration(
        List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> defs, 
        VariableDeclaration element) {
        EObject result = null;
        String name = element.getName();
        for (int t = 0; null == result && t < defs.size(); t++) {
            if (name.equals(defs.get(t).getName())) {
                result = defs.get(t);
            }
        }
        return result;
    }

    /**
     * Tries finding <code>element</code> in <code>defs</code>.
     * 
     * @param defs the type defs to search within
     * @param element the element to search for
     * @return the found type def or <b>null</b>
     */
    public static EObject findTypedef(List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.TypeDef> defs, 
        Typedef element) {
        EObject result = null;
        String alias = ((Typedef) element).getName();
        for (int t = 0; null == result && t < defs.size(); t++) {
            if (alias.equals(defs.get(t).getName())) {
                result = defs.get(t);
            }
        }
        return result;
    }

}
