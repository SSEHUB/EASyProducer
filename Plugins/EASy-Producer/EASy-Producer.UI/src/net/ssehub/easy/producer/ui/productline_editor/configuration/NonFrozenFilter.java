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
package net.ssehub.easy.producer.ui.productline_editor.configuration;

import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.varModel.confModel.AssignmentState;

/**
 * Implements a simple attribute filter.
 * 
 * @author Holger Eichelberger
 */
public class NonFrozenFilter extends AbstractConfigurationFilter {

    /**
     * Creates a filter for non-frozen variables.
     * 
     * @param showAllNestedElements whether nested elements of a shown variable will also be filtered
     */
    public NonFrozenFilter(boolean showAllNestedElements) {
        super(showAllNestedElements);
    }

    @Override
    protected boolean checkVariable(GUIVariable variable) {
        return AssignmentState.FROZEN != variable.getVariable().getState()
            || checkVariableRecursivley(variable);
    }
    
}