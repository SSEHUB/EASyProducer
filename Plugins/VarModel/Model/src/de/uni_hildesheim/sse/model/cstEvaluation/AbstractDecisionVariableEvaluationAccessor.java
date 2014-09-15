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
package de.uni_hildesheim.sse.model.cstEvaluation;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

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
    
    /**
     * {@inheritDoc}
     */
    public void clear() {
        variable = null;
    }
    
    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getVariable() {
        return variable;
    }
    
    /**
     * Notifies the underlying variable about a change.
     */
    protected void notifyVariableChange() {
        getContext().notifyChangeListener(getVariable());
    }

}
