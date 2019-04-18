/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
 * A freeze selector which does not freeze any variable.
 * 
 * @author Holger Eichelberger
 */
public class NoFreezeSelector implements IFreezeSelector {

    public static final IFreezeSelector INSTANCE = new NoFreezeSelector();

    /**
     * Prevents external creation.
     */
    private NoFreezeSelector() {
    }
    
    @Override
    public boolean shallFreeze(IDecisionVariable variable) {
        return false;
    }

}
