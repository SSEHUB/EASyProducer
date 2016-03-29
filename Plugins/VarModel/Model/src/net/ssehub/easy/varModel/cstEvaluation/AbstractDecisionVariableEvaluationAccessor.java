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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * An accessor based on a decision variable.
 * 
 * @author Holger Eichelberger
 */
abstract class AbstractDecisionVariableEvaluationAccessor extends EvaluationAccessor {
    
    private IDecisionVariable variable;
    
    /**
     * Binds this accessor.
     * 
     * @param variable the underlying variable
     * @param context the evaluation context
     * @return <b>this</b> (builder pattern)
     */
    protected AbstractDecisionVariableEvaluationAccessor bind(IDecisionVariable variable, EvaluationContext context) {
        super.bind(context);
        this.variable = variable;
        return this;
    }
    
    @Override
    public void clear() {
        variable = null;
    }
    
    @Override
    public IDecisionVariable getVariable() {
        return variable;
    }
    
    /**
     * Notifies the underlying variable about a change.
     */
    protected void notifyVariableChange() {
        getContext().notifyChangeListener(getVariable());
    }

    @Override
    public Value getReferenceValue() {
        Value result;
        try {
            result = ValueFactory.createValue(Reference.TYPE, variable);
        } catch (ValueDoesNotMatchTypeException e) {
            result = null;
        }
        return result;
    }

    @Override
    public String toString() {
        return null == variable ? "null" : variable.getDeclaration().getName();
    }
    
    /**
     * Returns whether this accessor denotes a local variable.
     * 
     * @return <code>true</code> if it is a local variable, <code>false</code> else
     */
    public boolean isLocal() {
        // storing this as a separate attribute would require state takeover among accessors
        // sub-variables of LocalDecisionVariables are also LocalDecisionVariables
        return variable instanceof LocalDecisionVariable; 
    }

}
