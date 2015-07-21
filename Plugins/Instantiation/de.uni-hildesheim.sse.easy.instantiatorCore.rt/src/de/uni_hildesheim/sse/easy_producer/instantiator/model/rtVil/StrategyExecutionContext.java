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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionContext;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuntimeEnvironment;

/**
 * Defines specific information to be considered during the execution
 * of a strategy.
 * 
 * @author Holger Eichelberger
 */
public class StrategyExecutionContext extends RuleExecutionContext {

    private List<AbstractBreakdownCall> activeCalls = new ArrayList<AbstractBreakdownCall>();
    
    /**
     * Creates a rule execution context.
     * 
     * @param rule the rule being executed
     * @param environment the runtime environment holding the OTHERPROJECTS variable
     */
    public StrategyExecutionContext(Strategy rule, RuntimeEnvironment environment) {
        super(rule, environment);
    }
    
    @Override
    public Strategy getRule() {
        return (Strategy) super.getRule();
    }
    
    /**
     * Adds an active breakdown call.
     * 
     * @param call the call to be added
     */
    public void addBreakdownCall(AbstractBreakdownCall call) {
        activeCalls.add(call);
    }
    
    /**
     * Returns the number of active breakdown calls.
     * 
     * @return the number of active breakdown calls
     */
    public int getBreakdownCallCount() {
        return activeCalls.size();
    }
    
    /**
     * Returns the specified active breakdown call.
     * 
     * @param index the 0-based index of the call to return
     * @return the specified breakdown call
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt;0 || index &gt;={@link #getBreakdownCallCount()}</code>
     */
    public AbstractBreakdownCall getBreakdownCall(int index) {
        return activeCalls.get(index);
    }

}
