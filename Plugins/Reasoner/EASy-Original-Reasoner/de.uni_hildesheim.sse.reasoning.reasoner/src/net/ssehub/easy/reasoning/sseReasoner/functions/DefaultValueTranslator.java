/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner.functions;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Turns partial compound default values into complete values as EASy allows only one default
 * assignment per variable.
 * 
 * @author Holger Eichelberger
 */
public class DefaultValueTranslator {
    
    /**
     * Calls {@link #translateDefaultValue(ConstraintSyntaxTree)} catching/logging exceptions.
     * 
     * @param cst the constraint to be translated
     * @return the translated constraint or {@code cst}
     */
    public static ConstraintSyntaxTree translateDefaultValueSafe(ConstraintSyntaxTree cst)  {
        try {
            return translateDefaultValue(cst);
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(DefaultValueTranslator.class, "Cannot translate default value for " 
                + StringProvider.toIvmlString(cst) + ": " + e.getMessage());
            return cst;
        }
    }

    /**
     * Translates a default value into its complete one-time default assignment value by including
     * nested default values of the defining compound/container types.
     * 
     * @param cst the constraint to be translated
     * @return the translated constraint or {@code cst}
     * @throws CSTSemanticException if constraint expressions cannot correctly be built
     */
    public static ConstraintSyntaxTree translateDefaultValue(ConstraintSyntaxTree cst) throws CSTSemanticException {
        ConstraintSyntaxTree result = cst;
        if (cst instanceof CompoundInitializer) {
            CompoundInitializer init = (CompoundInitializer) cst;
            Map<String, ConstraintSyntaxTree> values = new HashMap<String, ConstraintSyntaxTree>();
            Map<String, AbstractVariable> decls = new HashMap<String, AbstractVariable>();
            for (int s = 0; s < init.getSlotCount(); s++) {
                String slotName = init.getSlot(s);
                values.put(slotName, translateDefaultValue(init.getExpression(s)));
                decls.put(slotName, init.getSlotDeclaration(s));
            }
            translateDefaultValues(init.getType(), values, decls);
            result = createTranslatedCompoundInitializer(init.getType(), values, decls);
        } else if (cst instanceof ContainerInitializer) {
            ContainerInitializer init = (ContainerInitializer) cst;
            IDatatype containedType = init.getType().getContainedType();
            if (TypeQueries.isCompound(containedType) || TypeQueries.isContainer(containedType)) {
                ConstraintSyntaxTree[] inits = new ConstraintSyntaxTree[init.getExpressionCount()];
                for (int e = 0; e < inits.length; e++) {
                    inits[e] = translateDefaultValue(init.getExpression(e));
                }
                result = new ContainerInitializer(init.getType(), inits);
            }
        } else if (cst instanceof ConstantValue) {
            Value cValue = ((ConstantValue) cst).getConstantValue();
            if (cValue instanceof CompoundValue) {
                CompoundValue compValue = (CompoundValue) cValue;
                Compound compType = (Compound) compValue.getType();
                Map<String, ConstraintSyntaxTree> values = new HashMap<String, ConstraintSyntaxTree>();
                Map<String, AbstractVariable> decls = new HashMap<String, AbstractVariable>();
                for (String slotName : compValue.getSlotNames()) {
                    Value slotValue = compValue.getNestedValue(slotName);
                    ConstraintSyntaxTree slotValueEx = null;
                    if (null == slotValue) {
                        ConstraintSyntaxTree dflt = compType.getElement(slotName).getDefaultValue();
                        if (dflt instanceof ConstantValue) {
                            slotValueEx = dflt;
                        } else if (dflt != null) {
                            // do not evaluate directly, assign as value to be analyzed similar to constraint values
                            slotValueEx = new DeferInitExpression(dflt);
                        }
                    }
                    if (null != slotValue) {
                        slotValueEx = new ConstantValue(slotValue);
                    }
                    if (null != slotValueEx) { // else: undefined slots
                        values.put(slotName, translateDefaultValue(slotValueEx));
                        decls.put(slotName, compType.getElement(slotName));
                    }
                }
                translateDefaultValues(compType, values, decls);
                result = createTranslatedCompoundInitializer(compType, values, decls);
            } else if (cValue instanceof ContainerValue) {
                ContainerValue compValue = (ContainerValue) cValue;
                IDatatype containedType = compValue.getContainedType();
                if (TypeQueries.isCompound(containedType) || TypeQueries.isContainer(containedType)) {
                    ConstraintSyntaxTree[] inits = new ConstraintSyntaxTree[compValue.getElementSize()];
                    for (int e = 0; e < inits.length; e++) {
                        Value val = compValue.getElement(e);
                        inits[e] = translateDefaultValue(new ConstantValue(val));
                    }
                    result = new ContainerInitializer((Container) compValue.getType(), inits);
                }
            }
        }        
        return result;
    }

    /**
     * Recursively translates the default values of {@code} type into {@code values} and {@code decls},
     * but only if the slots are not already allocated.
     * 
     * @param type the type to be translated
     * @param values the values, i.e., slot name to value expression mappings
     * @param decls the declarations, i.e., slot name to declaration mappings
     * @throws CSTSemanticException if constraint expressions cannot correctly be built
     */
    private static void translateDefaultValues(Compound type, Map<String, ConstraintSyntaxTree> values, 
        Map<String, AbstractVariable> decls) throws CSTSemanticException {
        for (int d = 0; d < type.getDeclarationCount(); d++) {
            DecisionVariableDeclaration slotDecl = type.getDeclaration(d);
            String slotName = slotDecl.getName();
            ConstraintSyntaxTree dflt = slotDecl.getDefaultValue();
            if (!values.containsKey(slotName) && dflt != null) {
                values.put(slotName, translateDefaultValue(dflt)); 
                decls.put(slotName, slotDecl);
            }
        }
        for (int r = 0; r < type.getRefinesCount(); r++) {
            translateDefaultValues(type.getRefines(r), values, decls);
        }
    }

    /**
     * Creates a translated compound initializer.
     * 
     * @param type the type initializer represents
     * @param values the values, i.e., slot name to value expression mappings
     * @param decls the declarations, i.e., slot name to declaration mappings
     * @throws CSTSemanticException if constraint expressions cannot correctly be built
     * @return the created initializer
     */
    private static CompoundInitializer createTranslatedCompoundInitializer(Compound type, Map<String, 
        ConstraintSyntaxTree> values, Map<String, AbstractVariable> decls) throws CSTSemanticException {
        // init values of type hierarchy
        String[] slotNames = new String[values.size()];
        AbstractVariable[] slotDeclarations = new AbstractVariable[values.size()];
        ConstraintSyntaxTree[] slotExpressions = new ConstraintSyntaxTree[values.size()];
        int s = 0;
        for (Map.Entry<String, ConstraintSyntaxTree> v : values.entrySet()) {
            slotNames[s] = v.getKey();
            slotDeclarations[s] = decls.get(slotNames[s]);
            slotExpressions[s] = v.getValue();
            if (slotExpressions[s] instanceof OCLFeatureCall 
                && !ConstraintType.isConstraint(slotDeclarations[s].getType())) {
                // do not evaluate directly, assign as value to be analyzed similar to constraint values
                slotExpressions[s] = new DeferInitExpression(slotExpressions[s]);
            }
            s++;
        }
        return new CompoundInitializer(type, slotNames, slotDeclarations, slotExpressions);
    }

}
