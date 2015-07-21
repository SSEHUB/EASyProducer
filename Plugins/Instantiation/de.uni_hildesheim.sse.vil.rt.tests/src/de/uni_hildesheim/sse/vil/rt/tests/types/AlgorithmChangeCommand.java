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
package de.uni_hildesheim.sse.vil.rt.tests.types;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;

/**
 * Represents an algorithm change command.
 * 
 * @author Holger Eichelberger
 */
public class AlgorithmChangeCommand extends Command {

    private String pipeline;
    private String element;
    private String algorithm;
    private Map<Integer, String> map;
    
    /**
     * Creates an algorithm change command.
     * 
     * @param pipeline the pipeline name
     * @param element the pipeline element name
     * @param algorithm the algorithm name
     */
    public AlgorithmChangeCommand(String pipeline, String element, String algorithm) {
        this.pipeline = pipeline;
        this.element = element;
        this.algorithm = algorithm;
    }

    /**
     * Returns the pipeline name.
     * 
     * @return the pipeline name
     */
    public String getPipeline() {
        return pipeline;
    }

    /**
     * Returns the pipeline element name.
     * 
     * @return the pipeline element name
     */
    public String getElement() {
        return element;
    }

    /**
     * Returns the algorithm name.
     * 
     * @return the algorithm name
     */
    public String getAlgorithm() {
        return algorithm;
    }

    @Override
    public void exec() {
        System.out.println("EXECUTE ALGCHANGE " + pipeline + " " + element + " " + algorithm);
        CommandCollector.collectExecuted(this);
    }
   
    /**
     * Sets a map (testing).
     * 
     * @param map the map
     */
    public void setMap(@Generics(types = {Integer.class, String.class })Map<Integer, String> map) {
        this.map = map;
    }
    
    /**
     * Returns a map.
     * 
     * @return the map
     */
    @OperationMeta(returnGenerics = {Integer.class, String.class })
    public Map<Integer, String> getMap() {
        return map;
    }
}
