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
package net.ssehub.easy.varModel.confModel;

/**
 * Defines an interface to visit a configuration.
 * 
 * @author Holger Eichelberger
 */
public interface IConfigurationVisitor {

    /**
     * Visits a configuration.
     * 
     * @param configuration the configuration to visit
     */
    public void visitConfiguration(Configuration configuration);

    /**
     * Visits a decision variable.
     * 
     * @param variable the decision variable to visit
     */
    public void visitDecisionVariable(IDecisionVariable variable);

    // TODO is there a specific reason why compound and container variables do not have visit methods here?
    
}
