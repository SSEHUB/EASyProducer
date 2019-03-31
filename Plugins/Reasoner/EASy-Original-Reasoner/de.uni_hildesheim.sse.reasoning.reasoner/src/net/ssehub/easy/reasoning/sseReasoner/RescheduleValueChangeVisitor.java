/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ResolvedVariable;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener;
import net.ssehub.easy.varModel.cstEvaluation.LocalDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueVisitorAdapter;

import static net.ssehub.easy.reasoning.sseReasoner.model.ReasoningUtils.*;

/**
 * Reschedules value changes. Uses the provided resolver instance to perform further transformations and to
 * register new constraints with the constraint base.
 * 
 * @author Holger Eichelberger
 */
class RescheduleValueChangeVisitor extends ValueVisitorAdapter implements IValueChangeListener {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(RescheduleValueChangeVisitor.class, Descriptor.BUNDLE_NAME);
    private Resolver resolver;
    private boolean clear;
    private Value oldValue;
    private IDecisionVariable variable;
    private IDecisionVariable varParent;

    /**
     * Creates a rescheduling value change visitor for a certain resolver instance.
     * 
     * @param resolver the resolver instance
     */
    public RescheduleValueChangeVisitor(Resolver resolver) {
        this.resolver = resolver;
    }
    
    @Override
    public void visitConstraintValue(ConstraintValue value) {
        List<Constraint> constraints = resolver.cleanupConstraints(varParent, clear, null);
        Value newValue = variable.getValue();
        ConstraintSyntaxTree cst = getConstraintValueExpression(newValue);
        if (null != cst) {
            IModelElement parent = null == constraints || constraints.isEmpty() 
                ? variable.getDeclaration().getParent() 
                : constraints.get(0).getParent();
            Constraint c = resolver.createConstraintVariableConstraint(cst, createParentExpression(variable), 
                null, parent, varParent);
            setValue(variable, c); // fixes value after substitution, does not cause change event
            resolver.moveOtherConstraintsToConstraintBase(variable);
        }
    }

    @Override
    public void visitCompoundValue(CompoundValue newValue) {
        for (String name : newValue.getSlotNames()) {
            Value nValue = newValue.getNestedValue(name);
            if (null != nValue) {
                IDecisionVariable nVar = variable.getNestedElement(name);
                rescheduleValueChange(variable, nVar, nValue, true);
            }
        }
    }

    @Override
    public void visitContainerValue(ContainerValue newValue) {
        if (oldValue instanceof ContainerValue) {
            ContainerValue oldCValue = (ContainerValue) oldValue;
            for (int c = 0; c < newValue.getElementSize(); c++) {
                rescheduleValueChange(variable, variable.getNestedElement(c), 
                    null != oldCValue && c < oldCValue.getElementSize() ? oldCValue.getElement(c) : null, c == 0);
            }
        }
    }
    
    /**
     * Re-schedules a changed constraint value but only if rescheduling is needed.
     * 
     * @param varParent the parent variable holding <code>variable</code>, if not nested use <code>variable</code>
     * @param variable the variable for which the value changed
     * @param oldValue the old value
     * @param clear whether constraints for {@code holder} shall be cleared
     */
    void rescheduleValueChange(IDecisionVariable varParent, IDecisionVariable variable, Value oldValue, 
        boolean clear) {
        // save current state locally
        IDecisionVariable sVarParent = this.varParent;
        IDecisionVariable sVariable = this.variable;
        Value sOldValue = this.oldValue;
        boolean sClear = this.clear;
        
        // overwrite current state with parameters
        this.varParent = varParent;
        this.variable = variable;
        this.oldValue = oldValue;
        this.clear = clear;

        // visit for rescheduling
        variable.getValue().accept(this);
        
        // re-set current state from locally saved values
        this.varParent = sVarParent;
        this.variable = sVariable;
        this.oldValue = sOldValue;
        this.clear = sClear;
    }

    @Override
    public void notifyChanged(IDecisionVariable variable, Value oldValue) {
        AbstractVariable decl = variable.getDeclaration();
        if (!variable.isLocal()) {
            resolver.notifyRescheduling(true);
            if (Descriptor.LOGGING) {
                LOGGER.debug("Value changed: " + variable.getDeclaration().getName() + " " + variable.getValue()
                    + " Parent: " + (null == variable.getParent() ? null : variable.getParent()));                 
            }
            resolver.addAssignedVariableToScope(variable);
            Value newValue = variable.getValue();
            if (!Value.equals(newValue, oldValue)) {
                rescheduleValueChange(variable, variable, oldValue, true);
                if (isValueTypeChange(variable, newValue, oldValue)) {
                    resolver.translateValueTypeChange(variable, newValue, oldValue);
                }
            }
            rescheduleConstraintsForChilds(variable);
            // All constraints for the parent (as this was also changed)
            rescheduleConstraintsForParent(variable);
            resolver.notifyRescheduling(false);
        } else if (resolver.contextContainsMapping(decl)) {
            IDecisionVariable var = ((LocalDecisionVariable) variable).getVariable();
            resolver.contextRegisterMapping(decl, null == var ? null : new ResolvedVariable(var));
        }
    }

    @Override
    public void notifyUnresolved(IDecisionVariable variable) {
    }
    
    /**
     * Returns whether a value change from {@code oldValue} to {@code newValue} on {@code variable}
     * is a value type change.
     * 
     * @param variable the variable
     * @param newValue the new value (in {@code variable}
     * @param oldValue the old value
     * @return {@code true} for type change, {@code false} else
     */
    private boolean isValueTypeChange(IDecisionVariable variable, Value newValue, Value oldValue) {
        boolean result = false;
        if (TypeQueries.isCompound(variable.getDeclaration().getType())) {
            // for null -> initial value, constraints shall already be set by translation
            if (null != oldValue && null != newValue 
                && !TypeQueries.sameTypes(oldValue.getType(), newValue.getType())) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Determines the constraints needed for the parents of <code>variable</code>.
     * 
     * @param variable the variable to analyze
     */
    private void rescheduleConstraintsForParent(IDecisionVariable variable) {
        IConfigurationElement parent = variable.getParent();
        if (parent instanceof IDecisionVariable) {
            IDecisionVariable pVar = (IDecisionVariable) parent;
            AbstractVariable declaration = pVar.getDeclaration();
            resolver.reschedule(declaration);
            rescheduleConstraintsForParent(pVar);
        }
    }

    /**
     * Determines the constraints needed for <code>variable</code> and its (transitive) child slots.
     * 
     * @param variable the variable to analyze
     */
    private void rescheduleConstraintsForChilds(IDecisionVariable variable) {
        AbstractVariable declaration = variable.getDeclaration();
        resolver.reschedule(declaration);
        // All constraints for childs (as they may also changed)
        for (int j = 0, nChilds = variable.getNestedElementsCount(); j < nChilds; j++) {
            rescheduleConstraintsForChilds(variable.getNestedElement(j));
        }
    }

}
