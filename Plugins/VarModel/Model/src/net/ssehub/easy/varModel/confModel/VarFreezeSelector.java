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
package net.ssehub.easy.varModel.confModel;

/**
 * A freeze selector which just freezes the given variable but not it's contained or its annotations.
 * 
 * @author Holger Eichelberger
 */
public class VarFreezeSelector implements IFreezeSelector {

    private IDecisionVariable variable;
    
    /**
     * Creates an instance.
     * 
     * @param variable
     */
    public VarFreezeSelector(IDecisionVariable variable) {
        this.variable = variable;
    }
    
    @Override
    public boolean shallFreeze(IDecisionVariable variable) {
        return variable == this.variable; // for compound constants, may be true (?)
    }
    
    @Override
    public boolean shallFreezeAnnotations() {
        return false;
    }


}
