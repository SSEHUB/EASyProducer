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
package net.ssehub.easy.reasoning.sseReasoner;

import net.ssehub.easy.reasoning.core.reasoner.IMeasurementKey;

/**
 * The measures provided/supported by the SSE reasoner.
 * 
 * @author Holger Eichelberger
 */
public enum Measures implements IMeasurementKey {
    
    /**
     * Number of variables in constraints.
     */
    VARIABLES_IN_CONSTRAINTS("Number of variables involved in constraints"),

    /**
     * Number of constraints with evaluation problems.
     */
    PROBLEM_CONSTRAINTS("Number of problem constraints"),

    /**
     * Number of constraints with assignment problems.
     */
    PROBLEM_ASSIGNMENTS("Number of problem assignments");
    
    private String explanation;
    
    /**
     * Creates a measures constant.
     * 
     * @param explanation the headline/explanation
     */
    private Measures(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String getExplanation() {
        return explanation;
    }

    @Override
    public int outputPos() {
        return 100 + ordinal();
    }

}
