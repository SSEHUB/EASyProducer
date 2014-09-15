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
package de.uni_hildesheim.sse.model.confModel;

/**
 * 
 * {@link VariableConfigProvider} for nested variables of a {@link StructuredVariable}.
 * 
 * @author El-Sharkawy
 *
 */
abstract class NestedVarConfigProvider extends VariableConfigProvider {

    private StructuredVariable parent;
    
    /**
     * Sole constructor for this class.
     * @param parent A {@link StructuredVariable} which will hold the
     * nested {@link IDecisionVariable} where this provider belongs to.
     */
    protected NestedVarConfigProvider(StructuredVariable parent) {
        super();
        this.parent = parent;
    }
    
    /**
     * Returns the {@link StructuredVariable} which hold the related {@link IDecisionVariable}
     * where this provider belongs to.
     * @return The {@link StructuredVariable} which hold the related {@link IDecisionVariable}.
     */
    protected StructuredVariable getParent() {
        return parent;
    }

    @Override
    protected final Configuration getConfiguration() {
        return parent.getConfiguration();
    }
    
    @Override
    protected final boolean isStateChangeAllowed() {
        return parent.allowsNestedStates();
    }

}
