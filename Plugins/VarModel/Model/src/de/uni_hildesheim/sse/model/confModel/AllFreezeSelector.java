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
package de.uni_hildesheim.sse.model.confModel;

/**
 * A freeze selector which just freezes all variables.
 * 
 * @author Holger Eichelberger
 */
public class AllFreezeSelector implements IFreezeSelector {

    public static final IFreezeSelector INSTANCE = new AllFreezeSelector();

    /**
     * Prevents external creation.
     */
    private AllFreezeSelector() {
    }
    
    @Override
    public boolean shallFreeze(IDecisionVariable variable) {
        return true;
    }

}
