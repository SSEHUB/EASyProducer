/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel.filter.mandatoryVars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;

/**
 * Stores the {@link VariableImportance} to each variable of a configuration.
 * @author El-Sharkawy
 */
public class VariableContainer {
    
    private Map<IDecisionVariable, VariableImportance> toplevelVariables;
    private Map<IDecisionVariable, VariableImportance> allVariables;
    private Map<AbstractVariable, Set<IDecisionVariable>> allVariablesByDeclaration;
    
    /**
     * Single constructor for this class, initializes all variables in state {@link Importance#UNCLAER}.
     * @param config The {@link Configuration}, for which the states are calculated.
     * @param settings Specification whether default values should be threaten as not mandatory.
     */
    VariableContainer(Configuration config, MandatoryClassifierSettings settings) {
        toplevelVariables = new HashMap<IDecisionVariable, VariableImportance>();
        allVariables = new HashMap<IDecisionVariable, VariableImportance>();
        allVariablesByDeclaration = new HashMap<AbstractVariable, Set<IDecisionVariable>>();
        Iterator<IDecisionVariable> varItr = config.iterator();
        while (varItr.hasNext()) {
            IDecisionVariable topVar = varItr.next();
            VariableImportance importance = new VariableImportance(topVar);
            if (null != topVar.getDeclaration().getDefaultValue() && settings.considerDefaultValues()) {
                importance.setImportance(Importance.OPTIONAL);
            }
            toplevelVariables.put(topVar, importance);
            initNestedVariables(topVar, importance);
        }
    }

    /**
     * Recursive method to find all nested {@link IDecisionVariable}s of the current configuration.
     * Part of the constructor.
     * @param variable The {@link IDecisionVariable} to add.
     * @param importance The newly created {@link VariableImportance} for the {@link IDecisionVariable}.
     */
    private void initNestedVariables(IDecisionVariable variable, VariableImportance importance) {
        // All variables for declaration
        AbstractVariable decl = variable.getDeclaration();
        Set<IDecisionVariable> instances = allVariablesByDeclaration.get(decl);
        if (null == instances) {
            instances = new HashSet<IDecisionVariable>();
            allVariablesByDeclaration.put(decl, instances);
        }
        instances.add(variable);
        
        // All top level
        allVariables.put(variable, importance);
        
        // Find nested elements in recursive method
        if (Compound.TYPE.isAssignableFrom(variable.getDeclaration().getType())) {
            for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                IDecisionVariable nestedVariable = variable.getNestedElement(i);
                VariableImportance nestedImportance = new VariableImportance(nestedVariable);
                if (null != nestedVariable.getDeclaration().getDefaultValue()) {
                    importance.setImportance(Importance.OPTIONAL);
                }
                initNestedVariables(nestedVariable, nestedImportance);
            }
        }
    }
    
    /**
     * Similar to {@link Configuration#getDecision(AbstractVariable)}, but not only restricted to toplevel variables.
     * @param declaration The declaration for which the configuration instances should be returned.
     * @return All instances ({@link IDecisionVariable}) for the given declaration.
     */
    Set<IDecisionVariable> getVariable(AbstractVariable declaration) {
        return allVariablesByDeclaration.get(declaration);
    }
    
    /**
     * Changes the importance of the {@link IDecisionVariable}.
     * @param variable The {@link IDecisionVariable} to add.
     * @param importance The current importance state for the {@link IDecisionVariable}.
     */
    void setImportance(IDecisionVariable variable, Importance importance) {
        VariableImportance varImportance = allVariables.get(variable);
        if (null != varImportance) {
            varImportance.setImportance(importance);
        }
    }
    
    /**
     * Should be called after the visitation process to free memory of data which is no longer needed.
     */
    void finish() {
        // Clear all data which is not longer needed after the complete data structure has been built.
        allVariablesByDeclaration = null;
        toplevelVariables = null;
    }
    
    /**
     * Checks whether the given {@link IDecisionVariable} is mandatory.
     * @param variable The {@link IDecisionVariable} to check.
     * @return <tt>true</tt> if the user should specify a value. This is only a heuristic value.
     */
    public boolean isMandatory(IDecisionVariable variable) {
        // Attributes are not considered here
        VariableImportance importance = allVariables.get(variable);
        return null != importance ? importance.isMandatory() : false;
    }
}
