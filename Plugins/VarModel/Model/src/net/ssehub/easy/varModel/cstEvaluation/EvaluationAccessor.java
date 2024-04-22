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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Defines a unified accessor to variables, constants, slots etc. Please note that individual implementations
 * shall be accessible via pools. Also records nested variables as evaluation context, e.g., to carry variables
 * over a container aggregation function and to allow access to slots/attributes in following expressions. 
 * [public for testing]
 * 
 * @author Holger Eichelberger
 */
public abstract class EvaluationAccessor {
    
    private EvaluationContext context;
    private List<IDecisionVariable> nestedElements = new ArrayList<IDecisionVariable>();
    
    /**
     * Binds the accessor to the given context.
     * 
     * @param context the context to bind the accessor to
     * @see #clear()
     */
    protected void bind(EvaluationContext context) {
        this.context = context;
    }
    
    /**
     * Clears the accessor for reuse.
     */
    public void clear() {
        context = null;
        nestedElements.clear();
    }
    
    /**
     * Returns the evaluation context.
     * 
     * @return the evaluation context
     */
    public EvaluationContext getContext() {
        return context;
    }
    
    /**
     * Returns the value of the accessed element.
     * 
     * @return the value (may be <b>null</b> if undefined)
     */
    public abstract Value getValue();
    
    /**
     * Returns the value of the accessed element, referred values are dereferenced.<br/>
     * <b>Note:</b> This method is expensive as it may create a new {@link EvaluationVisitor}
     * to resolve reference expressions.
     * 
     * @return the dereferenced value (may be <b>null</b> if undefined)
     * @see #getValue()
     */
    public Value getDereferencedValue() {
        return getContext().getDereferencedValue(getValue());
    }

    /**
     * Returns the value of a reference to the accessed element.
     * 
     * @return the value (may be <b>null</b> if undefined)
     */
    public abstract Value getReferenceValue();

    /**
     * Defines a new value for the accessed element. In case of failures,
     * add appropriate messages to the context.
     * 
     * @param value the new value
     * @param asAssignment does this happen through an IVML assignment operation
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public abstract boolean setValue(Value value, boolean asAssignment);
    
    /**
     * Returns a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @return the nested value
     */
    public EvaluationAccessor getValue(EvaluationAccessor accessor) {
        getContext().addErrorMessage("left side of accessor must be a compound value", Message.CODE_RESOLUTION);
        return null;
    }

    /**
     * Changes a nested value based on the given accessor.
     * 
     * @param accessor the accessor to determine the nested value
     * @param value the new nested value
     */
    public void setValue(EvaluationAccessor accessor, Value value) {
        getContext().addErrorMessage("left side of accessor must be a compound value", Message.CODE_RESOLUTION);
    }
    
    /**
     * Returns whether the underlying value is assigned or still undefined.
     * 
     * @return <code>true</code> if a value is assigned, <code>false</code> else
     */
    public boolean isAssigned() {
        boolean assigned;
        IDecisionVariable var = getVariable();
        if (null != var) {
            assigned = AssignmentState.UNDEFINED != var.getState();
        } else {
            assigned = false;
        }
        return assigned;
    }
    
    /**
     * Releases this instance.
     */
    public abstract void release();
    
    /**
     * Returns the underlying variable.
     * 
     * @return the underlying variable (may be <b>null</b>)
     */
    public abstract IDecisionVariable getVariable();

    /**
     * Releases the given accessor.
     * 
     * @param <T> the type of the accessor
     * @param accessor the accessor to be released (may be <b>null</b>)
     * @return always <b>null</b> (to ease clearing local variables)
     */
    public static <T extends EvaluationAccessor> T release(T accessor) {
        if (null != accessor) {
            accessor.release();
        }
        return null;
    }
    
    /**
     * Returns whether values can be assigned to this evaluator.
     * 
     * @return <code>true</code> if values can be assigned, <code>false</code> else
     */
    public abstract boolean isAssignable();

    /**
     * Validates the context and sets the contained context to <code>context</code> if not given.
     * 
     * @param context the context to validate with
     */
    public void validateContext(EvaluationContext context) {
        if (null == this.context) {
            this.context = context;
        }
    }

    /**
     * Dereferences <code>variable</code> if of reference type and <code>value</code> is not of reference type.
     * 
     * @param variable the variable
     * @param value the value to consider
     * @return <code>variable</code> or the dereferenced variable
     */
    protected IDecisionVariable dereferenceIfNeeded(IDecisionVariable variable, Value value) {
        IDecisionVariable v = variable;
        if (TypeQueries.isReference(variable.getDeclaration().getType()) 
            && !TypeQueries.isReference(value.getType())) {
            v = Configuration.dereference(v);
            if (null == v) { // just a fallback, shall not happen
                v = variable;
            }
        }
        return v;
    }
    
    /**
     * Binds a <code>container</code> as provider for nested variables against this accessor in order
     * to carry information about the underlying variables as long as possible through the evaluation.
     * 
     * @param container the 
     */
    public void bindContainer(IDecisionVariable container) {
        if (null != container) {
            for (int e = 0, n = container.getNestedElementsCount(); e < n; e++) {
                nestedElements.add(container.getNestedElement(e));
            }
        }
    }
    
    /**
     * Adds the bound container element stored at <code>index</code> in <code>accessor</code> to
     * this accessor. If the bound container element does not exist, <b>null</b> will be added.
     * 
     * @param accessor the accessor to take the bound container element from
     * @param index the index
     */
    public void addBoundContainerElement(EvaluationAccessor accessor, int index) {
        IDecisionVariable element = accessor.getBoundContainerElement(index);
        if (null == element) {
            IDecisionVariable var = accessor.getVariable();
            if (null != var && 0 <= index && index <= var.getNestedElementsCount()) {
                element = var.getNestedElement(index);
            }
        }
        addBoundContainerElement(element);
    }
    
    /**
     * Clears the bound container elements.
     */
    public void clearContainerElements() {
        nestedElements.clear();
    }
    
    /**
     * Adds <code>element</code> to the bound container elements.
     * 
     * @param element the element to add (may be <b>null</b> for none
     */
    public void addBoundContainerElement(IDecisionVariable element) {
        nestedElements.add(element);
    }
    
    /**
     * Binds all bound container elements stored in <code>accessor</code> to this accessor. Clears already bound
     * elements in this accessor.
     * 
     * @param accessor the accessor to take the elements from
     */
    public void bindContainer(EvaluationAccessor accessor) {
        nestedElements.clear();
        nestedElements.addAll(accessor.nestedElements);
    }
    
    /**
     * Returns a container element. This method intentionally does not throw the
     * typical exceptions.
     * 
     * @param index the 0-based index
     * @return the element or <b>null</b> if it does not exist/is stored.
     */
    public IDecisionVariable getBoundContainerElement(int index) {
        return 0 <= index && index < nestedElements.size() ? nestedElements.get(index) : null;
    }
    
    /**
     * Returns the number of container elements.
     * 
     * @return the number of container elements
     */
    public int getBoundContainerElementCount() {
        return nestedElements.size();
    }
    
    /**
     * Returns whether this accessor represents a constant in the sense of the evaluation process, i.e., a value
     * that is already evaluated to its very end and not linked to any decision variable.
     * 
     * @return <code>true</code> for constant, <code>false</code> else
     */
    public boolean isConstant() {
        return false;
    }

}
