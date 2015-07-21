/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.vil.rt.tests.types;

import java.util.Map;

/**
 * Emulates the frozen system state from QM.
 * 
 * @author Holger Eichelberger
 */
public class FrozenSystemState {

    /**
     * Creates a frozen systems state instance from a map of values. This allows rt-VIL
     * to use this class as a wrapper.
     * 
     * @param values the values to be wrapped
     */
    public FrozenSystemState(
        @Generics(types = {String.class, Double.class }) Map<String, Double> values) {
        // ignore for now
    }
    
    /**
     * Returns an algorithm observation.
     * 
     * @param name the name of the algorithm
     * @param observable the observable 
     * @return the observation, may be <b>null</b> if not known
     */
    public Double getAlgorithmObservation(String name, IObservable observable) {
        return 2.0;
    }

    /**
     * Returns a pipeline observation.
     * 
     * @param name the name of the algorithm
     * @param observable the observable 
     * @return the observation, may be <b>null</b> if not known
     */
    public Double getPipelineObservation(String name, IObservable observable) {
        return 5.0;
    }

    /**
     * Returns a pipeline element observation.
     * 
     * @param name the name of the algorithm
     * @param element the pipeline element name
     * @param observable the observable 
     * @return the observation, may be <b>null</b> if not known
     */
    public Double getPipelineElementObservation(String name, String element, IObservable observable) {
        return 1.0;
    }

}
