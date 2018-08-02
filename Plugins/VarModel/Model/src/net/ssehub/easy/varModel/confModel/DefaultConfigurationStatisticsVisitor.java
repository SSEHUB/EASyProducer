/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.Project;

/**
 * A default implementation of the {@link AbstractConfigurationStatisticsVisitor} with empty implementation
 * of special treatments.
 * 
 * @author Holger Eichelberger
 */
public class DefaultConfigurationStatisticsVisitor extends AbstractConfigurationStatisticsVisitor {

    /**
     * Creates an instance with a statistics object of type {@link ConfigStatistics}.
     */
    public DefaultConfigurationStatisticsVisitor() {
        super(new ConfigStatistics());
    }
    
    /**
     * Creates a statistics visitor with given statistics object (for extension, overriding).
     * 
     * @param statistics A data object to store the statistical information.
     */
    protected DefaultConfigurationStatisticsVisitor(ConfigStatistics statistics) {
        super(statistics);
    }

    @Override
    protected void specialTreatment(IDecisionVariable variable) {
    }

    @Override
    protected void specialTreatment(Project mainProject) {
    }

}
