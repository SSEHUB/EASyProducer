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
import de.uni_hildesheim.sse.model.varModel.values.Value;

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
    public Value getValue(EvaluationAccessor accessor) {
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

}
