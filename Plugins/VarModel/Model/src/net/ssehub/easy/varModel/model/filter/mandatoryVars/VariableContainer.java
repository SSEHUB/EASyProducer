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
package net.ssehub.easy.varModel.model.filter.mandatoryVars;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;

/**
 * Stores the {@link VariableImportance} to each variable of a configuration.
 * @author El-Sharkawy
 */
public class VariableContainer {
    
    private Map<String, Importance> importances;
    
    /**
     * Single constructor for this class, initializes all variables in state {@link Importance#UNCLAER}.
     * @param config The {@link Configuration}, for which the states are calculated.
     * @param settings Specification whether default values should be threaten as not mandatory.
     */
    VariableContainer(Configuration config, MandatoryClassifierSettings settings) {
        importances = new HashMap<String, Importance>();
    }

    
    /**
     * Changes the importance of the {@link IDecisionVariable}.
     * @param variable The {@link IDecisionVariable} to add.
     * @param importance The current importance state for the {@link IDecisionVariable}.
     */
    void setImportance(IDecisionVariable variable, Importance importance) {
        String qName = variable.getQualifiedName();
        setImportance(qName, importance);
    }
    
    /**
     * Changes the importance of the {@link IDecisionVariable}.
     * @param qName The qualified name of a decision variable or a datatype
     * @param importance The current importance state for the {@link IDecisionVariable}.
     */
    void setImportance(String qName, Importance importance) {
        Importance oldImportance = importances.get(qName);
        if (Importance.OPTIONAL != oldImportance) {
            importances.put(qName, importance);
        }
    }
    
    /**
     * Checks whether the given {@link IDecisionVariable} is mandatory.
     * @param variable The {@link IDecisionVariable} to check.
     * @return <tt>true</tt> if the user should specify a value. This is only a heuristic value.
     */
    public boolean isMandatory(IDecisionVariable variable) {
        // Attributes are not considered here
        boolean isMandatory = false;
        
        // Test self, e.g., cmp.slotName
        String qName = variable.getQualifiedName();
        Importance importance = importances.get(qName);
        isMandatory = Importance.MANDATORY == importance;
        
        if (!isMandatory) {
            isMandatory = hasMandatoryTypeOrParent(variable.getDeclaration());
        }

        return isMandatory;
    }
    
    /**
     * Checks whether the given {@link AbstractVariable} is mandatory.
     * This will also consider if a declaration is multiple times instantiates,
     * e.g., a nested declaration of a compound.
     * @param declaration The {@link AbstractVariable} to check.
     * @return <tt>true</tt> if the user should specify a value. This is only a heuristic value.
     */
    public boolean isMandatory(AbstractVariable declaration) {
        // Attributes are not considered here
        boolean isMandatory = false;
        
        // Test self, e.g., cmp.slotName
        String qName = declaration.getQualifiedName();
        Importance importance = importances.get(qName);
        isMandatory = Importance.MANDATORY == importance;
        
        if (!isMandatory) {
            isMandatory = hasMandatoryTypeOrParent(declaration);
        }

        return isMandatory;
    }


    /**
     * Checks whether the given declaration is mandatory because of its type, or while the parent specifies that all
     * nested elements shall be mandatory. Part of {@link #isMandatory(IDecisionVariable)}
     * and {@link #isMandatory(AbstractVariable)}.
     * @param declaration The declaration to check.
     * @return <tt>true</tt> if the user should specify a value. This is only a heuristic value.
     */
    private boolean hasMandatoryTypeOrParent(AbstractVariable declaration) {
        boolean isMandatory = false;
        // Test mandatory by datatype, e.g., CP.slotName
        IModelElement parent = declaration.getParent();
        if (!(parent instanceof Project)) {
            String qName = parent.getQualifiedName() + "::" + declaration.getName();
            Importance importance = importances.get(qName);
            isMandatory = Importance.MANDATORY == importance;
        }
        return isMandatory;
    }
    
    @Override
    public String toString() {
        return importances.toString();
    }
}
