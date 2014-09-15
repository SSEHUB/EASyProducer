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
package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.IConfiguration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeQueries;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Creates a local configuration instance.
 * 
 * @author Holger Eichelberger
 */
class LocalConfiguration implements IConfiguration {

    private Map<AbstractVariable, IDecisionVariable> map = new HashMap<AbstractVariable, IDecisionVariable>();
    
    /**
     * Creates a local configuration instance.
     */
    LocalConfiguration() {
    }
    
    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getDecision(AbstractVariable declaration) {
        return map.get(declaration);
    }
    
    /**
     * Adds a (local) decision to this configuration.
     * 
     * @param decision the related decision
     */
    void addDecision(LocalDecisionVariable decision) {
        map.put(decision.getDeclaration(), decision);
    }
    
    /**
     * {@inheritDoc}
     */
    public Value getAllInstances(IDatatype type) {
        Value result;
        try {
            Set set = new Set("", type, null);
            result = ValueFactory.createValue(set, new Object[]{});
        } catch (ValueDoesNotMatchTypeException e) {
            result = null; // shall not happen
        }
        return result;
    }
    
    /**
     * Binds the given <code>type</code> to the first matching decision variable. Rationale: Static (all-quantized)
     * variable access needs to be bound automatically. In that case, there is an implicitly created enclosing quantor
     * (rewritten expression), and only one, i.e., the first one can be bound.
     * 
     * @param type the type to bind to
     * @return the bound value (may be <b>null</b> if there is none)
     */
    Value bind(IDatatype type) {
        Value result = null;
        for (IDecisionVariable var : map.values()) {
            if (TypeQueries.sameTypes(type, var.getDeclaration().getType())) {
                result = var.getValue();
                break;
            }
        }
        return result;
    }
    
}
