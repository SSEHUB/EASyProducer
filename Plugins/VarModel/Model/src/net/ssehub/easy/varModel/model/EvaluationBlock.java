/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model;

/** 
 * An evaluation block consisting of constraints to be evaluated.
 * 
 * @author Marcel Lueder
 */
public abstract class EvaluationBlock extends ContainableModelElement {

    /**
     * Constructor for serialization.
     */
    public EvaluationBlock() {
        super(null, null);
    }
    
    /**
     * Constructor for the evaluation block.
     * 
     * @param name Name of the evaluation block
     * @param parent the object, in which this specific one is embedded
     */
    public EvaluationBlock(String name, IModelElement parent) {
        super(name, parent);
    }

    /**
     * Checks whether the evaluation block is empty.
     * @return true if empty
     */
    public boolean isEmpty() {
        return true;
    }
    
}
