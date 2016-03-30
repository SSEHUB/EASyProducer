/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import net.ssehub.easy.instantiation.core.model.buildlangModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;

/**
 * Represents a tactic call as part of a strategy breakdown.
 * 
 * @author Holger Eichelberger
 */
public class TacticCall extends AbstractBreakdownCall {

    /**
     * Creates a tactic call.
     * 
     * @param script the actual script to resolve the rule on
     * @param name the name of the called element
     * @param arguments the actual arguments
     * @throws VilException in case of an erroneously qualified name
     */
    public TacticCall(Script script, String name, CallArgument... arguments) throws VilException {
        super(script, name, arguments);
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IRtVilVisitor) {
            result = ((IRtVilVisitor) visitor).visitTacticCall(this);
        } else {
            result = null;
        }
        return result;
    }

    @Override
    protected Class<? extends Rule> getOperationClass() {
        return Tactic.class;
    }

    @Override
    public Tactic getResolved() {
        return (Tactic) super.getResolved(); // due to getOperationClass
    }
    
    @Override
    protected String getInvalidOperationMessage(IMetaOperation op) {
        return op.getJavaSignature() + " is not a valid tactic";
    }

}
