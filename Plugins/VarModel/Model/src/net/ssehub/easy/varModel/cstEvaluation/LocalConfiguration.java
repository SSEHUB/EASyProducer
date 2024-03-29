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
package net.ssehub.easy.varModel.cstEvaluation;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Creates a local configuration instance.
 * 
 * @author Holger Eichelberger
 */
public class LocalConfiguration implements IConfiguration, IRestrictionEvaluationContext {

    private Map<AbstractVariable, IDecisionVariable> map = new HashMap<AbstractVariable, IDecisionVariable>();
    
    /**
     * Creates a local configuration instance.
     */
    public LocalConfiguration() {
    }
    
    @Override
    public IDecisionVariable getDecision(AbstractVariable declaration) {
        return map.get(declaration);
    }
    
    /**
     * Adds a (local) decision to this configuration.
     * 
     * @param decision the related decision
     * @return <code>decision</code> (builder pattern style)
     */
    public IDecisionVariable addDecision(IDecisionVariable decision) {
        map.put(decision.getDeclaration(), decision);
        return decision;
    }
    
    @Override
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
     * @param context the evaluation context
     * @return the bound value (may be <b>null</b> if there is none)
     */
    Value bind(IDatatype type, EvaluationContext context) {
        Value result = null;
        // is this unique??
        for (IDecisionVariable var : map.values()) {
            AbstractVariable decl = var.getDeclaration();
            if (!LocalDecisionVariable.ITERATOR_RESULT_VARNAME.equals(decl.getName())) {
                IDatatype varType = decl.getType();
                if (TypeQueries.sameTypes(type, varType)) {
                    result = var.getValue();
                    break;
                } else {
                    if (varType instanceof Reference) { // explicitly only 1 step dereference due to allInstances
                        varType = ((Reference) varType).getType();
                        if (TypeQueries.sameTypes(type, varType)) {
                            ReferenceValue ref = (ReferenceValue) var.getValue();
                            if (null != ref) {
                                IDecisionVariable refVar = context.getDecision(ref.getValue());
                                // refVar may be null if compound value is stated in container initializer
                                result = null == refVar ? null : refVar.getValue();
                                break;
                            }
                        } 
                    }
                }
            }
        }
        return result;
    }

    // restriction evaluation
    
    @Override
    public void setValue(IVariable variable, Version version) throws RestrictionEvaluationException {
        if (variable instanceof DecisionVariableDeclaration) {
            DecisionVariableDeclaration decl = (DecisionVariableDeclaration) variable;
            IDecisionVariable var = getDecision(decl);
            if (null == var) {
                var = addDecision(new LocalDecisionVariable(decl, this, null));
            }
            try {
                Value val;
                if (Compound.TYPE.isAssignableFrom(decl.getType())) {
                    // special case for legacy IVML notation project.variable
                    if (null == version) { // otherwise version itself is set to null in compound
                        version = Version.NULL_VALUE;
                    }
                    val = ValueFactory.createValue(decl.getType(), new Object[]{"version", version});
                } else {
                    val = ValueFactory.createValue(decl.getType(), version);                    
                }
                var.setValue(val, AssignmentState.ASSIGNED);
            } catch (ValueDoesNotMatchTypeException e) {
                throw new RestrictionEvaluationException(e.getMessage(), e.getId());
            } catch (ConfigurationException e) {
                throw new RestrictionEvaluationException(e.getMessage(), e.getId());
            }
        } else {
            throw new RestrictionEvaluationException("unsupported type", RestrictionEvaluationException.ID_INTERNAL);
        }
    }

    @Override
    public void unsetValue(IVariable variable) throws RestrictionEvaluationException {
        if (variable instanceof DecisionVariableDeclaration) {
            map.remove((DecisionVariableDeclaration) variable);
        } else {
            throw new RestrictionEvaluationException("unsupported type", RestrictionEvaluationException.ID_INTERNAL);
        }
    }

    @Override
    public Object startEvaluation() throws RestrictionEvaluationException {
        // not relevant here as no contexts are considered and in the evaluation context this class
        // is supposed to be used as a single instance rather than a stack
        return null; // unused
    }

    @Override
    public void endEvaluation(Object processor) throws RestrictionEvaluationException {
        // not relevant here as no contexts are considered and in the evaluation context this class
        // is supposed to be used as a single instance rather than a stack
    }

    /**
     * Rebinds the parameters from <code>actual</code> to <code>replacement</code>, e.g., for dynamic
     * dispatch. As a prerequisite, <code>actual</code> and <code>replacement</code> must have the same
     * number of parameters and compatible parameter types, i.e., <code>replacement</code> must have the 
     * same or more specific parameter types then <code>actual</code>.
     * 
     * @param actual the operation for which the parameters shall be replace
     * @param replacement the operation replacing <code>actual</code>
     */
    void rebind(CustomOperation actual, CustomOperation replacement) {
        if (actual.getParameterCount() == replacement.getParameterCount()) {
            for (int p = 0, n = actual.getParameterCount(); p < n; p++) {
                map.put(replacement.getParameterDeclaration(p), map.remove(actual.getParameterDeclaration(p)));
            }
        }
    }
    
    @Override
    public String toString() {
        return map.toString();
    }

}
