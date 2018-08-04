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
package net.ssehub.easy.reasoning.core.reasoner;

/**
 * General reasoner measures.
 * 
 * @author Holger Eichelberger
 */
public enum GeneralMeasures implements IMeasurementKey {
    
    /**
     * Time (in ms) spent for constraint translation.
     */
    EVALUATION_TIME("Evaluation time"),

    /**
     * Time (in ms) spent for translating the model - collected only if the approach performs translation.
     */
    TRANSLATION_TIME("Translation time"),

    /**
     * Total time (in ms) spent for reasoning.
     */
    REASONING_TIME("Total time"),
    
    /**
     * Total number of re-evaluations.
     */
    REEVALUATION_COUNT("Number of reevaluations"),
    
    /**
     * Total number of constraints.
     */
    CONSTRAINT_COUNT("Number of constraints"),
    
    /**
     * Total number of evaluation problems.
     */
    PROBLEMS("Number of problems");
    
    private String explanation;
    
    /**
     * Creates a measures constant.
     * 
     * @param explanation the headline/explanation
     */
    private GeneralMeasures(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String getExplanation() {
        return explanation;
    }

    @Override
    public int outputPos() {
        return ordinal();
    }

}
