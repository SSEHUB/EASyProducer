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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IConfiguration;
import de.uni_hildesheim.sse.model.confModel.IConfigurationElement;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Resolves the context around changed variables, including their parent variables, their
 * references and the variables referencing them. Create an instance, call {@link #resolve()} and obtain
 * the result from {@link #variables()}, {@link #attributes()} and {@link #filter()}.
 * 
 * @author Holger Eichelberger
 */
class ConfigurationContextResolver {

    private Configuration configuration;
    private Set<AbstractIvmlVariable> changed;
    private List<DecisionVariable> variables = new ArrayList<DecisionVariable>();
    private List<Attribute> attributes = new ArrayList<Attribute>();
    private HashFilter filter = new HashFilter();
    private ResolutionList resolve = new ResolutionList();

    /**
     * Implements a hash-based filter.
     * 
     * @author Holger Eichelberger
     */
    private class HashFilter implements IVariableFilter {

        private Set<IDecisionVariable> filterMap = new HashSet<IDecisionVariable>();

        @Override
        public boolean isEnabled(IDecisionVariable variable) {
            return filterMap.contains(variable);
        }
        
    }

    /**
     * Creates a context resolver.
     * 
     * @param configuration the configuration to resolve within
     * @param changed the changed variables to resolve the context for
     */
    public ConfigurationContextResolver(Configuration configuration, Set<AbstractIvmlVariable> changed) {
        this.configuration = configuration;
        this.changed = changed;
    }

    /**
     * Resolve the context.
     */
    public void resolve() {
        // augment with all parents and a filter which focuses just on those variables (for further projections)
        // take over the appropriate variables from configuration and augment missing
        for (AbstractIvmlVariable var : changed) {
            augment(var.getVariable(), false);
        }
        Map<AbstractVariable, List<IDecisionVariable>> referenced = collectReferences();
        for (int r = 0; r < resolve.size(); r++) {
            IDecisionVariable var = resolve.get(r);
            List<IDecisionVariable> dependent = referenced.get(var.getDeclaration());
            if (null != dependent) {
                for (IDecisionVariable dVar : dependent) {
                    augment(dVar, false);
                }
            }
        }
    }

    /**
     * Stores the variables already processed and to be resolved.
     * 
     * @author Holger Eichelberger
     */
    private static class ResolutionList {
        private List<IDecisionVariable> list = new LinkedList<IDecisionVariable>();
        private Set<IDecisionVariable> set = new HashSet<IDecisionVariable>();

        /**
         * Adds a variable.
         * 
         * @param var the variable
         */
        public void add(IDecisionVariable var) {
            if (!set.contains(var)) {
                list.add(var);
                set.add(var);
            }
        }
        
        /**
         * Returns whether the list already contains <code>var</code>.
         * 
         * @param var the variable
         * @return <code>true</code> if <code>var</code> is already contained, <code>false</code> else
         */
        public boolean contains(IDecisionVariable var) {
            return set.contains(var);
        }
        
        /**
         * Returns the number of variables.
         * 
         * @return the number of variables
         */
        public int size() {
            return list.size();
        }
        
        /**
         * Returns the variable at the specified position.
         * 
         * @param index the 0-based position
         * @return the variable
         */
        public IDecisionVariable get(int index) {
            return list.get(index);
        }
    }

    /**
     * Map the variable and its nested variables to the configuration and follows references.
     * 
     * @param var the variable to map
     * @param viaParent was this called via a parent recursion?
     */
    private void map(IDecisionVariable var, boolean viaParent) {
        if (!resolve.contains(var)) {
            if (!viaParent || (viaParent && !Container.TYPE.isAssignableFrom(var.getDeclaration().getType()))) {
                // follow collections only downstream, else through filter
                for (int n = 0; n < var.getNestedElementsCount(); n++) {
                    IDecisionVariable nested = var.getNestedElement(n);
                    mapVar(nested, false, viaParent);
                }
            }
            mapVar(var, true, viaParent); // containing last!!
        }
    }

    /**
     * Map the variable (without nested) to the configuration and follows references, but only if 
     * frozen.
     * 
     * @param var the variable to map
     * @param resolve consider <code>decVar</code> for reverse reference resolution
     * @param viaParent was called via parent recursion
     */
    private void mapVar(IDecisionVariable var, boolean resolve, boolean viaParent) {
        boolean follow = false;
        if (!filter.filterMap.contains(var)) {        
            if (AssignmentState.FROZEN == var.getState()) { // changed come from outside
                createVilInstance(var, configuration);
                if (resolve) {
                    this.resolve.add(var);
                }
                follow = true;
            } else { // the changed one...
                createVilInstance(var, configuration);
                follow = true;
            }
            if (follow && Reference.TYPE.isAssignableFrom(var.getDeclaration().getType())) {
                Value value = var.getValue();
                if (value instanceof ReferenceValue) { // NULLVALUE
                    ReferenceValue val = (ReferenceValue) value;
                    if (null != val && null != val.getValue()) {
                        IDecisionVariable refVar = configuration.getConfiguration().getDecision(val.getValue());
                        augment(refVar, viaParent);
                    }
                }
            }
            for (int a = 0; a < var.getAttributesCount(); a++) {
                mapVar(var.getAttribute(a), resolve, viaParent);
            }
        }        
    }
    
    /**
     * Obtains a mapping instance from <code>configuration</code> or creates a new one.
     * 
     * @param decVar the decision variable to obtain or create
     * @param configuration the configuration for lookup
     * @return the mapper instance
     */
    private AbstractIvmlVariable createVilInstance(IDecisionVariable decVar, Configuration configuration) {
        AbstractIvmlVariable result;
        IvmlElement elt = configuration.get(decVar.getDeclaration().getQualifiedName());
        if (elt instanceof AbstractIvmlVariable) {
            result = (AbstractIvmlVariable) elt;
        } else {
            result = new DecisionVariable(configuration, decVar, filter);
        }
        // mark as done and store all created in filter to enable them in configuration
        filter.filterMap.add(decVar);
        // store only top-level variables in configuration variables / attributes
        if (decVar.getParent() instanceof IConfiguration) {
            if (result instanceof DecisionVariable) {
                variables.add((DecisionVariable) result);
            } else if (result instanceof Attribute) {
                attributes.add((Attribute) result);
            }        
        }
        return result;
    }
    
    /**
     * Augments <code>dVar</code> and its transitive parents.
     * 
     * @param dVar the decision variable to augment
     * @param viaParent was called via parent recursion
     */
    private void augment(IDecisionVariable dVar, boolean viaParent) {
        if (null != dVar && !resolve.contains(dVar)) {
            map(dVar, viaParent);
            IConfigurationElement par = dVar.getParent();
            while (par instanceof IDecisionVariable) {
                IDecisionVariable pVar = (IDecisionVariable) par;
                map(pVar, true);
                par = par.getParent();
            }
        }
    }
    
    /**
     * Collects all references in the configuration.
     * 
     * @return all references in terms of a reference target - referring elements maps
     */
    private Map<AbstractVariable, List<IDecisionVariable>> collectReferences() {
        Map<AbstractVariable, List<IDecisionVariable>> result 
            = new HashMap<AbstractVariable, List<IDecisionVariable>>();
        Iterator<IDecisionVariable> iter = configuration.getConfiguration().iterator();
        while (iter.hasNext()) {
            IDecisionVariable var = iter.next();
            for (int n = 0; n < var.getNestedElementsCount(); n++) {
                collectReferences(var.getNestedElement(n), result);
            }
            collectReferences(var, result);
        }
        return result;
    }

    /**
     * Collects the references for a single variable.
     * 
     * @param var the variable to collect the references for
     * @param references the references in terms of a reference target - referring elements maps (modified as a side 
     *     effect)
     */
    private void collectReferences(IDecisionVariable var, Map<AbstractVariable, List<IDecisionVariable>> references) {
        IDatatype type = var.getDeclaration().getType();
        if (Reference.TYPE.isAssignableFrom(type)) {
            collectReference(var, var.getValue(), references);
        } else if (Container.TYPE.isAssignableFrom(type)) {
            Value value = var.getValue();
            if (value instanceof ContainerValue) { // NULLVALUE
                ContainerValue val = (ContainerValue) value;
                if (null != val) {
                    for (int e = 0; e < val.getElementSize(); e++) {
                        collectReference(var, val.getElement(e), references);
                    }
                }
            }
        }
    }

    /**
     * Collects the references for a variable and a single value (entry in case of a collection).
     * 
     * @param var the variable to collect the references for
     * @param val the value (entry)
     * @param references the references in terms of a reference target - referring elements maps (modified as a side 
     *     effect)
     */
    private void collectReference(IDecisionVariable var, Value val, Map<AbstractVariable, 
        List<IDecisionVariable>> references) {
        if (val instanceof ReferenceValue) {
            AbstractVariable refVar = ((ReferenceValue) val).getValue();
            if (null != refVar) {
                List<IDecisionVariable> values = references.get(refVar);
                if (null == values) {
                    values = new ArrayList<IDecisionVariable>();
                    references.put(refVar, values);
                }
                values.add(var);
            }
        }
    }

    /**
     * Returns the variables to be used in the configuration.
     * 
     * @return the variables
     */
    public DecisionVariable[] variables() {
        return variables.toArray(new DecisionVariable[variables.size()]);
    }

    /**
     * Returns the attributes to be used in the configuration.
     * 
     * @return the attributes
     */
    public Attribute[] attributes() {
        return attributes.toArray(new Attribute[attributes.size()]);
    }
    
    /**
     * Returns the filter to be used in the configuration.
     * 
     * @return the filter
     */
    public IVariableFilter filter() {
        return filter;
    }

}
