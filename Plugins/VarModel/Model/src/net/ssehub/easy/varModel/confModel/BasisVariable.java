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

import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Class for variables which do not bear nested variables.
 * Supported data types are:
 * <ul>
 * <li><tt>BasisDatatype</tt></li>
 * <li><tt>ConstraintType</tt></li>
 * <li><tt>Enum</tt></li>
 * <li><tt>OrderedEnum</tt></li>
 * <li><tt>Reference</tt></li>
 * </ul>
 * @author El-Sharkawy
 *
 */
class BasisVariable extends DecisionVariable {

    /**
     * Sole constructor for creating {@link IDecisionVariable}'s which do not contain nested Elements.
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds also the containing {@link DecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     * @param isAttribute whether this variable represents (a part of) an attribute or a variable
     */
    protected BasisVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible, 
        boolean isAttribute) {
        super(parent, varDeclaration, isVisible, isAttribute);
    }

    @Override
    public int getNestedElementsCount() {
        return 0;
    }

    @Override
    public IDecisionVariable getNestedElement(int index) {
        return null;
    }

    @Override
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {
        // Not supported by this class.
    }

    @Override
    public void freeze(String nestedElement) {
        // Not supported by this class.
    }

    @Override
    public boolean removeDerivedValues() {
        boolean changed = false;
        if (AssignmentState.ASSIGNED != getState()) {
            try {
                setValue(null, AssignmentState.UNDEFINED);
                changed = true;
            } catch (ConfigurationException e) {
                // Should not be possible to get an exception here.
                Bundle.getLogger(BasisVariable.class).exception(e);
            }
        }
        for (int i = 0; i < this.getAttributesCount(); i++) {
            try {
                this.getAttribute(i).setValue(null, AssignmentState.UNDEFINED);
            } catch (ConfigurationException e) {
                Bundle.getLogger(BasisVariable.class).exception(e);
            }
        }
        return changed;
    }
    
}
