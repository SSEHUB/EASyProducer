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

import net.ssehub.easy.instantiation.core.model.buildlangModel.IBuildlangVisitor;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Defines the visitor rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public interface IRtVilVisitor extends IBuildlangVisitor {

    /**
     * Is called to visit a rt-VIL script.
     * 
     * @param script the script to be visited
     * @return the result of visiting
     * @throws VilException in case that visiting fails
     */
    public Object visitScript(Script script) throws VilException;

    /**
     * Is called to visit a rt-VIL strategy.
     * 
     * @param strategy the strategy to be visited
     * @return the result of visiting
     * @throws VilException in case that visiting fails
     */
    public Object visitStrategy(Strategy strategy) throws VilException;

    /**
     * Is called to visit a rt-VIL tactic.
     * 
     * @param tactic the tactic to be visited
     * @return the result of visiting
     * @throws VilException in case that visiting fails
     */
    public Object visitTactic(Tactic tactic) throws VilException;
    
    /**
     * Is called to visit a rt-VIL strategy call.
     * 
     * @param call the strategy call to be visited
     * @return the result of visiting
     * @throws VilException in case that visiting fails
     */
    public Object visitStrategyCall(StrategyCall call) throws VilException;

    /**
     * Is called to visit a rt-VIL tactic call.
     * 
     * @param call the tactic call to be visited
     * @return the result of visiting
     * @throws VilException in case that visiting fails
     */
    public Object visitTacticCall(TacticCall call) throws VilException;

    /**
     * Is called to visit a fail statement.
     * 
     * @param statement the fail statement
     * @return the result of visiting
     * @throws VilException in case that visiting fails
     */
    public Object visitFailStatement(FailStatement statement) throws VilException;
}
