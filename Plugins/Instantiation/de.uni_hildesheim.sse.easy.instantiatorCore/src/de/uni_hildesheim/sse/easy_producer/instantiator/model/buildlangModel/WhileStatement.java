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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;

/**
 * Implements a VIL while statement.
 * 
 * @author Holger Eichelberger
 */
public class WhileStatement extends RuleBlock implements IRuleElement {

    private Expression condition;
    
    /**
     * Creates a while statement.
     * 
     * @param condition the condition of the while (Boolean expression)
     * @param body the body of the while
     * @throws VilException in case of initialization problems
     */
    public WhileStatement(Expression condition, IRuleElement[] body) throws VilException {
        super("", body);
        this.condition = condition;
        if (null == condition) {
            throw new VilException("no condition given", VilException.ID_SEMANTIC);
        }
    }
    
    /**
     * Returns the condition of the while statement.
     * 
     * @return the condition
     */
    public Expression getCondition() {
        return condition;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result = null;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitWhileStatement(this);
        }
        return result;
    }

    @Override
    public boolean isVirtual() {
        return false;
    }

}
