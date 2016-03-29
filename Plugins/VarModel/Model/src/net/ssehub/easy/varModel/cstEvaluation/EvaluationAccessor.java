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

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Defines a unified accessor to variables, constants, slots etc. Please note that individual implementations
 * shall be accessible via pools. [public for testing]
 * 
 * @author Holger Eichelberger
 */
public abstract class EvaluationAccessor {
    
    private EvaluationContext context;
    
    /**
     * Binds the accessor to the given context.
     * 
     * @param context the context to bind the accessor to
     * @see #clear()
     */
    protected void bind(EvaluationContext context) {
        this.context = context;
    }
    
    /**
     * Clears the accessor for reuse.
     */
    public void clear() {
        context = null;
    }
    
    /**
     * Returns the evaluation context.
     * 
     * @return the evaluation context
     */
    public EvaluationContext getContext() {
        return context;
    }
    
    /**
     * Returns the value of the accessed element.
     * 
     * @return the value (may be <b>null</b> if undefined)
     */
    public abstract Value getValue();

    /**
     * Returns the value of a reference to the accessed element.
     * 
     * @return the value (may be <b>null</b> if undefined)
     */
    public abstract Value getReferenceValue();

    /**
     * Defines a new value for the accessed element. In case of failures,
     * add appropriate messages to the context.
     * 
     * @param value the new value
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public abstract boolean setValue(Value value);
    
    /**
     * Returns a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @return the nested value
     */
    public EvaluationAccessor getValue(EvaluationAccessor accessor) {
        getContext().addErrorMessage("left side of accessor must be a compound value");
        return null;
    }

    /**
     * Changes a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @param value the new nested value
     */
    public void setValue(EvaluationAccessor accessor, Value value) {
        getContext().addErrorMessage("left side of accessor must be a compound value");
    }
    
    /**
     * Returns whether the underlying value is assigned or still undefined.
     * 
     * @return <code>true</code> if a value is assigned, <code>false</code> else
     */
    public boolean isAssigned() {
        boolean assigned;
        IDecisionVariable var = getVariable();
        if (null != var) {
            assigned = AssignmentState.UNDEFINED != var.getState();
        } else {
            assigned = false;
        }
        return assigned;
    }
    
    /**
     * Releases this instance.
     */
    public abstract void release();
    
    /**
     * Returns the underlying variable.
     * 
     * @return the underlying variable (may be <b>null</b>)
     */
    public abstract IDecisionVariable getVariable();

    /**
     * Releases the given accessor.
     * 
     * @param accessor the accessor to be released (may be <b>null</b>)
     */
    public static void release(EvaluationAccessor accessor) {
        if (null != accessor) {
            accessor.release();
        }
    }
    
    /**
     * Returns whether values can be assigned to this evaluator.
     * 
     * @return <code>true</code> if values can be assigned, <code>false</code> else
     */
    public abstract boolean isAssignable();

    /**
     * Validates the context and sets the contained context to <code>context</code> if not given.
     * 
     * @param context the context to validate with
     */
    public void validateContext(EvaluationContext context) {
        if (null == this.context) {
            this.context = context;
        }
    }

}
