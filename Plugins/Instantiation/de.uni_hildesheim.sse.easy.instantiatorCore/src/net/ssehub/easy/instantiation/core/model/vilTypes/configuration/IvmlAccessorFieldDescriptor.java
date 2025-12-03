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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation.CompatibilityResult;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Defines a pseudo field descriptor which enables comfortable access to an individual decision variables
 * via its name.
 * 
 * @author Holger Eichelberger
 */
public class IvmlAccessorFieldDescriptor extends AbstractIvmlFieldDescriptor {
    
    /**
     * Constructor for serialization.
     */
    public IvmlAccessorFieldDescriptor() {
    }
    
    /**
     * Creates the field descriptor.
     * 
     * @param declaringType the declaring type
     * @param var the variable to create the descriptor for
     * @param registry the actual type registry 
     * @throws VilException in case that creating the descriptor fails
     */
    IvmlAccessorFieldDescriptor(TypeDescriptor<?> declaringType, 
        DecisionVariableDeclaration var, TypeRegistry registry) throws VilException {
        super(declaringType, var, registry);
    }
    
    @Override
    public Object getValue(Object owner) throws VilException {
        Object result;
        if (null == owner) {
            result = null;
        } else if (owner instanceof CompoundValue) {
            result = from((CompoundValue) owner);
        } else {
            if (Utils.isCompatibleToDecisionVariable(owner) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            DecisionVariable ownerVar = (DecisionVariable) owner;
            DecisionVariable tmp = ownerVar.getByName(getName());
            if (null == tmp) {
                result = null;
                IDecisionVariable dv = ownerVar.getDecisionVariable();
                if (dv.getValue() instanceof CompoundValue) { // nested compound, not full variable somehow
                    result = from((CompoundValue) dv.getValue());
                }
                if (result == null) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Configuration field " + getName() 
                        + " not accessible by name (omitted frozen?)");
                }
            } else {
                if (getType().isCollection()) {
                    IDatatype type = tmp.getDecisionVariable().getDeclaration().getType();
                    type = DerivedDatatype.resolveToBasis(type);
                    if (Set.TYPE.isAssignableFrom(type)) {
                        result = tmp.variablesSet();
                    } else {
                        result = tmp.variables();
                    }
                } else {
                    result = getSpecificBaseValue(tmp);
                    if (null == result && tmp.isConfigured()) {
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Extracts the field from the given compound value.
     * 
     * @param cValue the compound value
     * @return the field value or <b>null</b> for none
     */
    private Object from(CompoundValue cValue) {
        Object result;
        Value val = cValue.getNestedValue(getName());
        if (null != val) {
            result = val.getValue();
        } else {
            result = null;
        }
        return result;
    }
    
    @Override
    public void setValue(Object owner, Object value) throws VilException {
        if (null != owner) {
            if (Utils.isCompatibleToDecisionVariable(owner) != CompatibilityResult.COMPATIBLE) {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            DecisionVariable tmp = ((DecisionVariable) owner).getByName(getName());
            if (null == tmp) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Configuration field " + getName() 
                    + " not accessible by name (omitted frozen?)");
            } else {
                tmp.setValue(value);
            }
        }
    }
    
    @Override
    public Object getMetaValue(Object owner) throws VilException {
        if (null != owner && Utils.isCompatibleToDecisionVariable(owner) != CompatibilityResult.COMPATIBLE) {
            throw new VilException("incompatible arguments accessing meta value of IVML variable " 
                + getVariable().getName(), VilException.ID_TYPE_INCOMPATIBILITY);
        }
        return null == owner ? null : ((DecisionVariable) owner).getByName(getName());
    }
    
}
