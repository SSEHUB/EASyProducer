/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * A specialized interface for reasoners, which, in principle, can be chained, i.e., composed to a chain
 * of reasoners, passing along results and configurations. The last reasoner in a chain shall create the
 * final reasoning result, potentially taking over results of the previous ones or complementing the
 * reasoning by resolving problems that the previous reasoners cannot solve.
 * 
 * @author Holger Eichelberger
 */
public interface IChainingReasoner extends IReasoner {
    
    /**
     * Sets the state determined by the last reasoner. If not <b>null</b>, project and configuration
     * passed in through the interface of {@link IReasoner} shall be ignored.
     * 
     * @param config the configuration (may be <b>null</b>, shall be ignored then). <code>config</code> may
     *   be an internal result
     * @param result the last reasoning result (may be <b>null</b>, shall be ignored then, identifies beginning of 
     *   chain). It is assumed that the constraints and variables mentioned in reasoning result fit to 
     *   <code>configuration</code>
     */
    public void setState(Configuration config, ReasoningResult result);

    /**
     * Sets the state determined by the last reasoner. If not <b>null</b>, project and configuration
     * passed in through the interface of {@link IReasoner} shall be ignored. Shall be used for {@link IReasoner
     * #evaluate(net.ssehub.easy.varModel.model.Project, Configuration, java.util.List, ReasonerConfiguration, 
     * net.ssehub.easy.basics.progress.ProgressObserver)} only.
     * 
     * @param config the configuration (may be <b>null</b>, shall be ignored then). <code>config</code> may
     *   be an internal result
     * @param result the last reasoning result (may be <b>null</b>, shall be ignored then, identifies beginning of 
     *   chain). It is assumed that the constraints and variables mentioned in reasoning result fit to 
     *   <code>configuration</code>
     */
    public void setState(Configuration config, EvaluationResult result);

    /**
     * Returns the last, potentially internal configuration. Shall be past into 
     * {@link #setState(Configuration, ReasoningResult)} of the next reasoner. Shall 
     * clear the attribute holding the last config.
     * 
     * @return the last, potentially internal configuration
     */
    public Configuration getLastConfiguration();
    
}
