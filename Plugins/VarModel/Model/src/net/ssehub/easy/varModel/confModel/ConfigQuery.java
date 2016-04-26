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
package net.ssehub.easy.varModel.confModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Provides an interface to query {@link Configuration}s.
 * @author El-Sharkawy
 */
public class ConfigQuery {
    
    /**
     * Calculates possible values ({@link ConstraintSyntaxTree}-based) for a
     * given {@link Reference} variable.
     * @param config The {@link Configuration} which contains the queried values.
     * @param refType The reference for which possible values should be calculated for.
     * @return A maybe empty list of possible values for the given {@link Reference}.
     */
    static List<ConstraintSyntaxTree> possibleValuesForReferences(Configuration config, Reference refType) {
        List<ConstraintSyntaxTree> cstValues = new ArrayList<ConstraintSyntaxTree>();
        List<IDecisionVariable> allowedVars = collectVariablesByType(config, refType.getType(), false);
        for (IDecisionVariable possibleVar : allowedVars) {
            try {
                cstValues.add(toCST(possibleVar));
            } catch (ModelQueryException e) {
                // Omit variables which cannot be converted to CSTs (e.g. Sets).
                Bundle.getLogger(ConfigQuery.class).warn(e.getMessage());
            }
        }
        
        return cstValues;
    }
    
    /**
     * Gathers all {@link IDecisionVariable}s of the given {@link Configuration}, which match the specified type.
     * @param config The {@link Configuration} which contains the queried variables.
     * @param type The type of which the variables shall be returned, or <tt>null</tt> if all variables should
     *     be returned.
     * @param onlyToplevel <tt>true</tt> only top level variables will be returned, <tt>false</tt> also nested
     *     variables will be returned, e.g. nested inside a compound.
     * @return variables The set of variables, which match the given parameters.
     */
    public static List<IDecisionVariable> collectVariablesByType(Configuration config, IDatatype type,
        boolean onlyToplevel) {
        
        List<IDecisionVariable> variables = new ArrayList<IDecisionVariable>();
        Iterator<IDecisionVariable> varItr = config.iterator();
        while (varItr.hasNext()) {
            IDecisionVariable variable = varItr.next();
            addVariableByType(variable, type, onlyToplevel, variables);
        }
        
        return variables;
    }
    
    /**
     * Recursive part of {@link #collectVariablesByType(Configuration, IDatatype, boolean)}, which searches for (nested)
     * variables.
     * @param variable The currently tested variable, which should maybe added.
     * @param type The type of which the variables shall be returned, or <tt>null</tt> if all variables should
     *     be returned.
     * @param onlyToplevel <tt>true</tt> only top level variables will be returned, <tt>false</tt> also nested
     *     variables will be returned, e.g. nested inside a compound.
     * @param variables The set of variables to be returned (will be changed as a side-effect).
     */
    private static void addVariableByType(IDecisionVariable variable, IDatatype type, boolean onlyToplevel,
        List<IDecisionVariable> variables) {
        
        if (null == type || type.isAssignableFrom(variable.getDeclaration().getType())) {
            variables.add(variable);
        }

        if (!onlyToplevel) {
            for (int i = 0, end = variable.getNestedElementsCount(); i < end; i++) {
                addVariableByType(variable.getNestedElement(i), type, onlyToplevel, variables);
            }
        }
    }
    
    /**
     * Converts an {@link IDecisionVariable} of the configuration to a {@link Variable} expression, so that it can be
     * used for a value assignment, e.g. for creating a value assignment of a
     * {@link net.ssehub.easy.varModel.model.datatypes.Reference}.
     * @param variable The variable to be converted, must not be <tt>null</tt>.
     * @return An absolute expression pointing to the given variable, considering nested variables, e.g., of compounds.
     * @throws ModelQueryException If the given variable could not be resolved to an unambiguous expression, e.g., if
     *     the variable is nested inside a {@link net.ssehub.easy.varModel.model.datatypes.Set}.
     */
    public static ConstraintSyntaxTree toCST(IDecisionVariable variable) throws ModelQueryException {
        ConstraintSyntaxTree result = null;
        
        // Convert variable and its parent to cst
        if (variable.isNested()) {
            IDecisionVariable parent = (IDecisionVariable) variable.getParent();
            IDatatype parentType = DerivedDatatype.resolveToBasis(parent.getDeclaration().getType());
            if (Compound.TYPE.isAssignableFrom(parentType)) {
                result = new CompoundAccess(toCST(parent), variable.getDeclaration().getName());
            } else if (Sequence.TYPE.isAssignableFrom(parentType)) {
                int index = -1;
                for (int i = 0, end = parent.getNestedElementsCount(); i < end && index == -1; i++) {
                    if (parent.getNestedElement(i) == variable) {
                        index = i;
                    }
                }
                if (index != -1) {
                    try {
                        ConstantValue indexValue = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, index));
                        result = new OCLFeatureCall(toCST(parent), OclKeyWords.INDEX_ACCESS, indexValue);
                    } catch (ValueDoesNotMatchTypeException e) {
                        throw new ModelQueryException("cannot resolve nested element '"
                            + variable.getDeclaration().getName() + "' in parent '" + parent.getDeclaration().getName()
                            + "'", ModelQueryException.ACCESS_ERROR);
                    }
                }
            } else if (net.ssehub.easy.varModel.model.datatypes.Set.TYPE.isAssignableFrom(parentType)) {
                throw new ModelQueryException("cannot create access statement for nested elements of a set.",
                    ModelQueryException.ACCESS_ERROR);
            }
        } else {
            result = new Variable(variable.getDeclaration());
        }
        
        // TODO: Consider annotations
        
        return result;
    }

}
