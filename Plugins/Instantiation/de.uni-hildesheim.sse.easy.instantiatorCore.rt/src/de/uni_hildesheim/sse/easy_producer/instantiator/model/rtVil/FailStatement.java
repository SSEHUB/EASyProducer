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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;

/**
 * Implements a fail statement, i.e., when a tactic or a strategy explicitly wants to signal that it cannot do it's job
 * and another tactic or strategy shall go on.
 * 
 * @author Holger Eichelberger
 */
public class FailStatement implements IRuleElement {

    private String reason;
    private Expression codeEx;
    private boolean reFail = false;

    /**
     * Creates a fail statement instance.
     */
    public FailStatement() {
        reFail = true;
    }
    
    /**
     * Creates a fail statement instance.
     * 
     * @param reason an optional reason for failing
     * @param codeEx an optional code expression
     */
    public FailStatement(String reason, Expression codeEx) {
        this.reason = reason;
        this.codeEx = codeEx;
    }
    
    /**
     * Returns the optional reason for failing.
     * 
     * @return the reason for failing (may be <b>null</b>)
     */
    public String getReason() {
        return reason;
    }

    /**
     * Returns the optional error code expression.
     * 
     * @return the expression (may be <b>null</b>)
     */
    public Expression getCodeEx() {
        return codeEx;
    }
    
    /**
     * Return whether it is an re-fail statement.
     * 
     * @return <code>true</code> for re-fail, <code>false</code> else
     */
    public boolean isRefail() {
        return reFail;
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IRtVilVisitor) {
            result = ((IRtVilVisitor) visitor).visitFailStatement(this);
        } else {
            result = null;
        }
        return result;
    }

}
