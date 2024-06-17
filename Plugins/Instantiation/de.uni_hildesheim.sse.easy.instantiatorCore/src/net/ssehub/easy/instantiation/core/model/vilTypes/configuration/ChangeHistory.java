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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.varModel.confModel.IConfigurationChangeListener;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements a checkpointing change history of variable changes. Changes are traced in
 * a kind of transaction marked by {@link #start()}, and ending with {@link #commit()}, {@link #rollback()} or 
 * {@link #commitAll()} on a change set stack. On committed, they are either committed in the next
 * change set on the stack or into the global set of committed variables.
 * 
 * @author Holger Eichelberger
 */
public class ChangeHistory implements IVilType, IStringValueProvider {

    private Configuration configuration;
    private IChangeHistoryTracer tracer;
    private Map<IDecisionVariable, Value> originalValues = new HashMap<IDecisionVariable, Value>();
    private CSet committed = new CSet();
    private Stack<CSet> changeSetStack = new Stack<CSet>();
    private IConfigurationChangeListener changeListener = new ChangeListener();
    
    /**
     * Creates a change history.
     * 
     * @param configuration the configuration to track changes for
     */
    ChangeHistory(Configuration configuration) {
        this.configuration = configuration;
        this.configuration.getConfiguration().register(changeListener);
    }
    
    // finalize is deprecated; change history is bound against creating configuration and GCed with configuration
    
    /**
     * Defines the type of a change set.
     * 
     * @author Holger Eichelberger
     */
    @SuppressWarnings("serial")
    private static class CSet extends HashMap<AbstractIvmlVariable, Value> {
        
        private int directChanges = 0;
        
        /**
         * Adds all {@link IvmlElement elements} to <code>result</code>.
         * 
         * @param result the set to be changed as a side effect
         */
        private void addAllIvmlElements(Set<AbstractIvmlVariable> result) {
            for (AbstractIvmlVariable var : keySet()) {
                result.add(var);
            }
        }

        /**
         * Adds all original decision variables of all {@link IvmlElement elements} to <code>result</code>.
         * 
         * @param result the set to be changed as a side effect
         */
        private void addAllDecisionVariables(Set<IDecisionVariable> result) {
            for (AbstractIvmlVariable var : keySet()) {
                IConfigurationElement iter = var.getVariable();
                while (iter instanceof IDecisionVariable) { // give also access to the parents
                    result.add((IDecisionVariable) iter);
                    iter = iter.getParent();
                }
            }
        }
        
        /**
         * Notifies this change set about a direct change within the scope of this change set.
         * 
         * @param variable the changed variable
         * @param value the actual value
         */
        private void notifyChanged(AbstractIvmlVariable variable, Value value) {
            put(variable, value);
            directChanges++;
        }
        
        /**
         * Returns the number of direct changes in this change set (excluding indirectly commited ones).
         * 
         * @return the number of changes
         */
        private boolean hasChanges() {
            return directChanges > 0;
        }

    }

    /**
     * Implements a change listener to track reasoning changes to the configuration.
     * 
     * @author Holger Eichelberger
     */
    private class ChangeListener implements IConfigurationChangeListener {

        @Override
        public void itemChanged(net.ssehub.easy.varModel.confModel.Configuration config,
            IDecisionVariable changedVariable, Value oldValue) {
            // check config?
            IvmlElement elt = configuration.get(changedVariable.getDeclaration().getQualifiedName());
            if (elt instanceof AbstractIvmlVariable) {
                notifyChanged((AbstractIvmlVariable) elt, oldValue);
            }
        }

        @Override
        public void stateChanged(net.ssehub.easy.varModel.confModel.Configuration config,
            IDecisionVariable changedVariable) {
        }

        @Override
        public void configurationRefreshed(net.ssehub.easy.varModel.confModel.Configuration config) {
        }
        
    }

    /**
     * Returns whether the current change set has direct changes (i.e., no indirect commits from other change sets).
     * 
     * @return whether there were direct changes
     */
    public boolean hasChanges() {
        boolean result = false;
        if (!changeSetStack.isEmpty()) {
            result = changeSetStack.peek().hasChanges();
        }
        return result;
    }

    /**
     * Starts a new change set.
     */
    public void start() {
        changeSetStack.push(new CSet());
        if (null != tracer) {
            tracer.started(configuration);
        }
    }
    
    /**
     * Rolls back the most recent change set. Nothing happens if the stack is empty.
     */
    public void rollback() {
        if (!changeSetStack.isEmpty()) {
            if (null != tracer) {
                tracer.rollingBack(configuration);
            }
            CSet top = changeSetStack.pop();
            for (Map.Entry<AbstractIvmlVariable, Value> entry : top.entrySet()) {
                entry.getKey().setValue(entry.getValue());
            }
            if (null != tracer) {
                tracer.rolledBack(configuration);
            }
        }
    }

    /**
     * Visits the most recent changes into the top-most change set. Does not modify the change set.
     * 
     * @param visitor the visitor to be called for each change
     */
    public void changes(IChangeHistoryVisitor visitor) {
        if (!changeSetStack.isEmpty()) {
            CSet top = changeSetStack.peek();
            for (Map.Entry<AbstractIvmlVariable, Value> e: top.entrySet()) {
                visitor.changed(e.getKey(), e.getValue());
            }
        }
    }
    
    /**
     * Visits all changes. Does not modify the change set.
     * 
     * @param visitor the visitor to be called for each change
     */
    public void allChanges(IChangeHistoryVisitor visitor) {
        for (CSet changes: changeSetStack) {
            for (Map.Entry<AbstractIvmlVariable, Value> e: changes.entrySet()) {
                visitor.changed(e.getKey(), e.getValue());
            }
        }
    }
    
    /**
     * Commits the most recent change set into the one before or if there is none into the committed set.
     * Clears the most recent change set. Nothing happens if the stack is empty.
     */
    public void commit() {
        if (!changeSetStack.isEmpty()) {
            if (null != tracer) {
                tracer.committing(configuration);
            }
            CSet top = changeSetStack.pop();
            CSet target;
            if (changeSetStack.isEmpty()) {
                target = committed;
            } else {
                target = changeSetStack.peek();
            }
            for (Map.Entry<AbstractIvmlVariable, Value> entry : top.entrySet()) {
                if (!target.containsKey(entry.getKey())) {
                    target.put(entry.getKey(), entry.getValue());
                }
            }
            if (null != tracer) {
                tracer.committed(configuration);
            }
        }
    }
    
    /**
     * Commits the changes of all stacked change sets into the committed change set.
     */
    @Invisible
    public void commitAll() {
        while (!changeSetStack.isEmpty()) {
            commit();
        }
    }
    
    /**
     * Rolls back all the changes in the uncommitted stack.
     */
    @Invisible
    public void rollbackAll() {
        while (!changeSetStack.isEmpty()) {
            rollback();
        }
    }
    
    /**
     * Returns the original value of a variable before any explicit change. This method
     * is made accessible through <code>variable</code> itself. Following the idea of VIL, reference
     * values are transparently dereferenced.
     * 
     * @param variable the 
     * @return the original value
     */
    @Invisible
    public Value getOriginalValue(AbstractIvmlVariable variable) {
        Value value = originalValues.get(variable.origVariable);
        if (null == value) {
            value = variable.getVariable().getValue();
        }
        Value result = net.ssehub.easy.varModel.confModel.Configuration.dereference(
            configuration.getConfiguration(), value);
        return result;
    }

    /**
     * Rolls back all all changes.
     */
    @Invisible
    public void rollbackSimulation()  {
        rollbackAll();
        for (Map.Entry<AbstractIvmlVariable, Value> entry : committed.entrySet()) {
            entry.getKey().setValue(entry.getValue());
        }
        clear(true);
    }
    
    /**
     * Returns whether <code>value1</code> and <code>value2</code> are the same.
     * 
     * @param value1 the first value (may be <b>null</b>)
     * @param value2 the second value (may be <b>null</b>)
     * @return <code>true</code> if <code>value1</code> is considered to be the same as <code>value2</code>, 
     *     <code>false</code> else
     */
    private static boolean isSameValue(Value value1, Value value2) {
        boolean isSame;
        if (null == value1) {
            isSame = (null == value2);
        } else {
            isSame = value1.equals(value2);
        }
        return isSame;
    }

    /**
     * Notifies the change set about a changed variable.
     * 
     * @param variable the variable
     * @param value the old value (clone assumed)
     */
    @Invisible
    void notifyChanged(AbstractIvmlVariable variable, Value value) {
        if (!isSameValue(variable.getVariable().getValue(), value)) {
            CSet changeSet;
            if (!originalValues.containsKey(variable.origVariable)) {
                Value oValue = value == null ? NullValue.INSTANCE : value;
                originalValues.put(variable.origVariable, oValue);
                if (null != tracer) {
                    tracer.recordedOriginalVariable(variable, oValue);
                }
            }
            if (!changeSetStack.isEmpty()) {
                changeSet = changeSetStack.peek();
            } else {
                changeSet = committed;
            }
            if (!changeSet.containsKey(variable)) { // keep the oldest value, not the intermediate updates
                if (null == value) { // cannot play back Java null, needs IVML null to unconfigure
                    value = NullValue.INSTANCE;
                }
                changeSet.notifyChanged(variable, value);
                if (null != tracer) {
                    tracer.recordedChangedVariable(variable, value);
                }
            }
        }
    }
    
    /**
     * Returns all changed variables.
     * 
     * @return all changed variables
     */
    @Invisible
    Set<AbstractIvmlVariable> changed() {
        Set<AbstractIvmlVariable> enabled = new HashSet<AbstractIvmlVariable>();
        committed.addAllIvmlElements(enabled);
        for (int i = 0; i < changeSetStack.size(); i++) {
            changeSetStack.get(i).addAllIvmlElements(enabled);
        }
        return enabled;
    }

    /**
     * Returns a filter for all changed variables.
     * 
     * @return a filter for all changed variables
     */
    @Invisible
    IVariableFilter changedFilter() {
        Set<IDecisionVariable> enabled = new HashSet<IDecisionVariable>();
        committed.addAllDecisionVariables(enabled);
        for (int i = 0; i < changeSetStack.size(); i++) {
            changeSetStack.get(i).addAllDecisionVariables(enabled);
        }
        return new SetVariablesFilter(enabled);
    }

    @Override
    @Invisible
    public String getStringValue(StringComparator comparator) {
        return "<change set>";
    }

    /**
     * Clears the history.
     * 
     * @param resetOriginalValues also reset original values
     */
    @Invisible
    public void clear(boolean resetOriginalValues) {
        changeSetStack.clear();
        committed.clear();
        if (resetOriginalValues) {
            originalValues.clear();
        }
    }
    
    /**
     * Defines or unsets the configuration tracer.
     * 
     * @param tracer the tracer (may be <b>null</b> for unsetting)
     * @return the tracer before setting
     */
    public IChangeHistoryTracer setTracer(IChangeHistoryTracer tracer) {
        IChangeHistoryTracer old = this.tracer;
        this.tracer = tracer;
        return old;
    }
    
    /**
     * Returns the current tracer.
     * 
     * @return the tracer
     */
    public IChangeHistoryTracer getTracer() {
        return tracer;
    }
    
}
