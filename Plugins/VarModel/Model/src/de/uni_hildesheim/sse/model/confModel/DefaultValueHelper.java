/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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

import java.util.Stack;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Assigns the defined default value(s). This class is intended to support
 * interactive configuration. Otherwise, please rely on the reasoning capabilities.
 * 
 * Instances of this class are intended for reuse, so call {@link #initialize(IDecisionVariable)} 
 * before use (alternatively {@link #DefaultValueHelper(IDecisionVariable)} for creation) and
 * {@link #clear()} after use.
 * 
 * @author Holger Eichelberger
 */
public class DefaultValueHelper {

    private EvaluationVisitor evaluator;
    private Stack<IDecisionVariable> variables;

    /**
     * Creates a new default value helper. Call {@link #initialize(IDecisionVariable)}.
     */
    public DefaultValueHelper() {
        evaluator = new EvaluationVisitor();
    }
    
    /**
     * Creates an initialized default value helper by calling {@link #initialize(IDecisionVariable)}.
     * 
     * @param variable the variable to fill with default values
     */
    public DefaultValueHelper(IDecisionVariable variable) {
        this();
        initialize(variable);
    }
    
    /**
     * Fills the value of the given <code>variable</code> with defined default values.
     * Currently, evaluation errors are ignored.
     * 
     * @param variable the variable to fill
     */
    public static void fillDefaults(IDecisionVariable variable) {
        if (null != variable && variable.getState() != AssignmentState.FROZEN) {
            DefaultValueHelper helper = new DefaultValueHelper(variable);
            helper.assignDefaultValue(variable);
            helper.clear();
        }
    }
    
    /**
     * Initializes this instance.
     * 
     * @param variable the variable to fill with default values
     */
    public void initialize(IDecisionVariable variable) {
        variables.clear();
        variables.push(variable);
        evaluator.init(variable.getConfiguration(), null, false, null); // don't assign!
    }

    /**
     * Clears this instance for reuse.
     */
    public void clear() {
        variables.clear();
        evaluator.clear();
    }

    /**
     * Assigns default value(s) to the given variable <code>var</code>.
     * 
     * @param var the variable to assign the default value(s)
     */
    private void assignDefaultValue(IDecisionVariable var) {
        IDatatype type = var.getDeclaration().getType();
        // there is no real visitor for decision variables :(
        if (type instanceof ConstraintType) {
            assignConstraintValue();
        } else if (type instanceof Compound) {
            assignCompoundValue((Compound) type);
        } else {
            assignSingleExpressionDefault();
        }
    }
    
    /**
     * Assigns the default value to a constraint variable.
     */
    private void assignConstraintValue() {
        IDecisionVariable var = variables.peek();
        ConstraintSyntaxTree defaultEx = var.getDeclaration().getDefaultValue();
        if (null != defaultEx) {
            try {
                var.setValue(ValueFactory.createValue(var.getDeclaration().getType(), defaultEx), 
                     AssignmentState.DEFAULT);
            } catch (ConfigurationException e) {
                getLogger().exception(e);
            } catch (ValueDoesNotMatchTypeException e) {
                getLogger().exception(e);
            }
        }
    }

    /**
     * Assigns the default value to a compound.
     * 
     * @param compound the compound type
     */
    private void assignCompoundValue(Compound compound) {
        // assign declared defaults first
        IDecisionVariable variable = variables.peek();
        if (variable instanceof CompoundVariable) {
            CompoundVariable cVariable = (CompoundVariable) variable;
            for (int e = 0; e < compound.getElementCount(); e++) {
                AbstractVariable var = compound.getElement(e);
                String slotName = var.getName();
                variables.push(cVariable.getNestedVariable(slotName));
                assignDefaultValue(cVariable.getNestedVariable(slotName));
                variables.pop();
            }
        }
        // assign explicit default value of variable if present
        assignSingleExpressionDefault();
        
    }
    
    /**
     * Assigns a basic default value based on a single expression.
     */
    private void assignSingleExpressionDefault() {
        IDecisionVariable var = variables.peek();
        if (AssignmentState.UNDEFINED == var.getState()) { 
            ConstraintSyntaxTree defaultEx = var.getDeclaration().getDefaultValue();
            if (null != defaultEx) {
                defaultEx.accept(evaluator);
                Value defaultValue = evaluator.getResult();
                if (null != defaultValue) {
                    try {
                        var.setValue(defaultValue, AssignmentState.DEFAULT);
                    } catch (ConfigurationException e) {
                        getLogger().exception(e);
                    }
                } else {
                    getLogger().error("Cannot evaluate default value for " + var);
                }
            }
        }
    }

    /**
     * Returns the actual logger.
     * 
     * @return the logger
     */
    private static EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(DefaultValueHelper.class, Bundle.ID);
    }

}
