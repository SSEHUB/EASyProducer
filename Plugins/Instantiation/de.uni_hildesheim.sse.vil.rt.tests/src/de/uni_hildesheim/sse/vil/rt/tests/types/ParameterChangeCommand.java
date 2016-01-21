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

/**
 * Represents an algorithm change command.
 * 
 * @author Holger Eichelberger
 */
public class ParameterChangeCommand extends Command {

    private String pipeline;
    private String element;
    private String parameter;
    private Object value;
    
    /**
     * Creates an algorithm change command.
     * 
     * @param pipeline the pipeline name
     * @param element the pipeline element name
     * @param parameter the parameter name
     * @param value the new value
     */
    public ParameterChangeCommand(String pipeline, String element, String parameter, Object value) {
        this.pipeline = pipeline;
        this.element = element;
        this.parameter = parameter;
        this.value = value;
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
     * Returns the parameter name.
     * 
     * @return the parameter name
     */
    public String getParameter() {
        return parameter;
    }
    
    /**
     * Returns the value.
     * 
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    @Override
    public void exec() {
        System.out.println("EXECUTE PARAMCHANGE " + pipeline + " " + element + " " + parameter + " " + value);
        CommandCollector.collectExecuted(this);
    }
   
}
