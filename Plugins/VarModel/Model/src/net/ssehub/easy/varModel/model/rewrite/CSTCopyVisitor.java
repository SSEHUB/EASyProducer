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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.Map;

import net.ssehub.easy.varModel.cst.CopyVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Special {@link CopyVisitor} as needed by the {@link ProjectCopyVisitor}.
 * @author El-Sharkawy
 */
class CSTCopyVisitor extends CopyVisitor {
    
    private boolean complete;
    
    /**
     * Creates a copy visitor with explicit mapping.
     * 
     * @param mapping a mapping from old variable declarations to new variable declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     */
    CSTCopyVisitor(Map<AbstractVariable, AbstractVariable> mapping) {
        super(mapping);
        complete = true;
    }
    
    /**
     * Specifies whether the constraint could be translated completely.
     * @return <tt>true</tt> constraint was translated completely, <tt>false</tt> {@link UntranslatedDeclaration}s
     *     have been used and must be translated at a later point.
     */
    boolean translatedCompletely() {
        return complete;
    }
    
    @Override
    protected AbstractVariable mapVariable(AbstractVariable var) {
        AbstractVariable result = null;
        if (null != getMapping()) {
            result = getMapping().get(var);
            if (null == result) {
                result = var;
                complete = false;
            }
        } else {
            result = var;
        }
        return result;
    }

}
