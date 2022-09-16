/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.varModel.model.values.Value;

/**
 * Visits a change history, i.e., methods are called upon the respective information in no specific sequence. Please do 
 * not modify the passed-in information.
 * 
 * @author Holger Eichelberger
 */
public interface IChangeHistoryVisitor {

    /**
     * Called when a variable is about to be changed.
     * 
     * @param var the variable
     * @param value the new value
     */
    public void changed(AbstractIvmlVariable var, Value value);
    
    // created
    // removed
    
}
