/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.reasoning.core.reasoner.ConstraintList;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.Constraint.Type;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Implements a type cache to avoid repeatedly identifying, iterating over and collecting constraints for complex 
 * types.
 * 
 * @author Holger Eichelberger
 */
public final class TypeCache {

    /**
     * Globally enables or disables type-caching.
     */
    public static final boolean ENABLED = false;
    
    /**
     * Variable-accessor and name-accessor mappings may be transferred back to the current context in
     * one copy step {@code false} or step-wise and on-demand only {@code true}. Only active if {@code #ENABLED}.
     */
    static final boolean ON_DEMAND_ACCESSORS = true;

    private Map<IDatatype, Entry> cache = new HashMap<IDatatype, Entry>();
    private transient SubstitutionVisitor substVisitor = new SubstitutionVisitor();

    /**
     * Implements a type cache entry. Variables in an entry are relative to {@link #var}, which must be substituted
     * finally with the actual top-level variable.
     * 
     * @author Holger Eichelberger
     */
    public class Entry {
        private AbstractVariable origvar;
        private List<ConstraintTemplate> constraints;
        private List<Entry> parents;
        private Map<AbstractVariable, ConstraintSyntaxTree> varMap;
        private Map<String, ConstraintSyntaxTree> nameMap;
 
        /**
         * Creates a type cache entry.
         * 
         * @param var the variable the constraint are bound to
         */
        private Entry(AbstractVariable var) {
            this.origvar = var;
        }
        
        /**
         * Adds a constraint to this type cache entry.
         * 
         * @param target the target list
         * @param first whether the constraint shall be added to front or back
         * @param constraint the constraint
         * @param register shall the constraint be registered in {@link VariablesMap}
         */
        public void addConstraint(ConstraintList target, boolean first, Constraint constraint, boolean register) {
            if (null == constraints) {
                constraints = new LinkedList<ConstraintTemplate>();
            }
            constraints.add(new ConstraintTemplate(target, first, constraint, register));
        }
        
        /**
         * Returns whether this cache entry has a variable-accessor mapping. Such mappings are only present if
         * additional constraint translations for this type are needed, e.g., to cope with changing constraint 
         * variables.
         * 
         * @return {@code true} for mapping, {@code false} else
         */
        public boolean hasMapping() {
            return varMap != null;
        }
        
        /**
         * Returns whether the current context contains a mapping for <code>var</code>.
         * 
         * @param var the variable to look for
         * @return <code>true</code> if there is a mapping, <code>false</code> else
         */
        public boolean containsMapping(AbstractVariable var) {
            return null != varMap && varMap.containsKey(var);
        }
        
        /**
         * Instantiates a the given constraint.
         * 
         * @param cst the constraint
         * @param var the replacing variable
         * @return the instantiated constraint
         */
        private ConstraintSyntaxTree instantiate(ConstraintSyntaxTree cst, AbstractVariable var) {
            ConstraintSyntaxTree result = cst;
            if (null != result) {
                substVisitor.addVariableMapping(origvar, var, 0);
                result = substVisitor.acceptAndClear(result);
            }
            return result;
        }
        
        /**
         * Returns the mapped access expression for <code>var</code> taking into account all current
         * contexts of the stack starting with the current top-most one. If {@link #varMap} is present,
         * performs an on-the-fly instantiation of the mapped accessor. Intended for dynamically building up 
         * the mapping in the context stack.
         * 
         * @param var the variable to return the mapping for
         * @param self the variable to instantiate the stored mapping for
         * @return the mapped access expression or <b>null</b> if there is no registered mapping
         */
        public ConstraintSyntaxTree getMapping(AbstractVariable var, AbstractVariable self) {
            ConstraintSyntaxTree result = null;
            if (null != varMap) {
                result = instantiate(varMap.get(var), self);
            }
            return result;
        }
        
        /**
         * Returns the local mapping for the given variable {@code name} just from the current context. Names are 
         * registered once, to the most local (non-shadowed) variable. If {@link #varMap} is present,
         * performs an on-the-fly instantiation of the mapped accessor. Intended for dynamically building up 
         * the mapping in the context stack.
         * 
         * @param name the name of the variable
         * @param self the variable to instantiate the stored mapping for
         * @return the mapped access expression or <b>null</b> if there is no registered mapping
         */
        public ConstraintSyntaxTree getLocalMapping(String name, AbstractVariable self) {
            ConstraintSyntaxTree result = null;
            if (null != nameMap) {
                result = instantiate(nameMap.get(name), self);
            }
            return result;
        }

        /**
         * Adds a parent to this entry and causes constraint transfer. Shall be applied only to type-compatible types
         * such as refined compounds or derived types.
         * 
         * @param entry the entry
         * @param target the constraint target
         * @param register the variable to register against
         * @param var the replacing variable
         */
        public void addParent(Entry entry, IConstraintTarget target, IDecisionVariable register, 
            AbstractVariable var) {
            if (null == parents) {
                parents = new ArrayList<Entry>();
            }
            parents.add(entry);
            entry.transferConstraints(target, register, var);
        }

        /**
         * Transfers constraints.
         * 
         * @param target the constraint target
         * @param register the variable to register against
         * @param var the replacing variable
         * @return whether the transfer was done
         */
        private boolean transferConstraints(IConstraintTarget target, IDecisionVariable register, 
            AbstractVariable var) {
            boolean done;
            if (null != constraints) {
                boolean defaults = !target.inRescheduling();
                for (int e = 0, n = constraints.size(); e < n; e++) {
                    ConstraintTemplate template = constraints.get(e);
                    if (defaults || (!defaults && template.constraint.getType() != Type.DEFAULT)) {
                        template.transfer(target, register, origvar, var);
                    }
                }
                if (null != parents) {
                    for (int p = 0, n = parents.size(); p < n; p++) {
                        parents.get(p).transferConstraints(target, register, var);
                    }
                }
                done = true;
            } else {
                done = false;
            }
            return done;
        }
        
        @Override
        public String toString() {
            return IvmlDatatypeVisitor.getQualifiedType(origvar.getType()) 
                + " constr " + (null != constraints ? constraints.size() : 0) 
                + " map " + (null != varMap ? varMap.size() : 0); 
        }

    }
    
    /**
     * Specifies the interface that an object receiving constraints from this class must provide.
     * 
     * @author Holger Eichelberger
     */
    public interface IConstraintTarget {
        
        /**
         * Adds a constraint to the (preliminary) constraint base.
         * 
         * @param target the target constraint set
         * @param first at to front/end
         * @param constraint the constraint to be added
         * @param register register the constraint with {@link VariablesMap} for the given variable (ignored 
         *     if <b>null</b>)
         */
        public void addConstraint(ConstraintList target, boolean first, Constraint constraint, 
            IDecisionVariable register);
        
        /**
         * Returns whether the constraint target is currently in re-scheduling and, thus, e.g., default constraints
         * shall not be added.
         * 
         * @return {@code true} for re-scheduling, {@code false} else
         */
        public boolean inRescheduling();

    }
    
    /**
     * Represents a constraint template with related constraint set to add the constraint to.
     * 
     * @author Holger Eichelberger
     */
    private class ConstraintTemplate {
        private ConstraintList target;
        private boolean first;
        private Constraint constraint;
        private boolean register;

        /**
         * Creates the constraint template.
         * 
         * @param target the target constraint set
         * @param first add to front or to end
         * @param constraint the constraint
         * @param register the constraint with the {@link VariablesMap}
         */
        private ConstraintTemplate(ConstraintList target, boolean first, Constraint constraint, boolean register) {
            this.target = target;
            this.first = first;
            this.constraint = constraint;
            this.register = register;
        }
        
        /**
         * Transfers the stored constraint into the context of {@code self}.
         * 
         * @param target the target constraint set
         * @param register the decision variable to register with (may be <b>null</b> for none)
         * @param var the original (template) variable
         * @param self the new variable
         */
        private void transfer(IConstraintTarget target, IDecisionVariable register, AbstractVariable var, 
            AbstractVariable self) {
            Constraint c = constraint;
            if (null != var && null != self) {
                substVisitor.addVariableMapping(var, self, 0);
                try {
                    c = constraint.createConstraint(substVisitor.acceptAndClear(constraint.getConsSyntax()));
                } catch (CSTSemanticException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(TypeCache.class, Descriptor.BUNDLE_NAME).exception(e);
                }
            }
            target.addConstraint(this.target, first, c, this.register ? register : null);
        }
        
    }
    
    /**
     * Returns a type cache entry for the given {@code type}.
     * 
     * @param type the type to return the cache entry for
     * @return the cache entry, may be <b>null</b> for none
     */
    public Entry get(IDatatype type) {
        return cache.get(type);
    }
    
    /**
     * Returns whether this type cache contains an entry for {@code type}.
     * 
     * @param type the type to look for
     * @return {@code true} if {@code type} is in the cache, {@code false} else
     */
    public boolean contains(IDatatype type) {
        return cache.containsKey(type);
    }
    
    /**
     * Creates a type cache entry.
     * 
     * @param type the type to create the entry for
     * @param var the template varible
     * @return the created entry
     */
    public Entry createEntryFor(IDatatype type, AbstractVariable var) {
        Entry entry = new Entry(var);
        cache.put(type, entry);
        return entry;
    }
    
    /**
     * Transfers collected constraints for <code>type</code>.
     * 
     * @param type the type to transfer the constraints to
     * @param target the constraint target receiving instantiated constraints
     * @param register the variable to register new constraints with
     * @param var the variable to replace the template variable
     * @return {@code true} for transferred, {@code false} else
     */
    public boolean transferConstraints(IDatatype type, IConstraintTarget target, IDecisionVariable register, 
        AbstractVariable var) {
        boolean done;
        Entry entry = cache.get(type);
        if (null != entry) {
            done = entry.transferConstraints(target, register, var);
        } else {
            done = false;
        }
        return done;
    }

    /**
     * Transfers the mappings of the given {@code context} into the cache entry of {@code type}.
     * 
     * @param type the type
     * @param varMap the variable-accessor mapping (optional, may be <b>null</b>)
     * @param nameMap the name-accessor mapping (optional, may be <b>null</b>)
     */
    public void transferContext(IDatatype type, Map<AbstractVariable, ConstraintSyntaxTree> varMap, 
        Map<String, ConstraintSyntaxTree> nameMap) {
        Entry entry = cache.get(type);
        if (null != entry) {
            entry.varMap = varMap;
            entry.nameMap = nameMap;
        }
    }

    /**
     * Transfers all accessors stored in {@link Entry#varMap} into the actual context in {@code contexts} by
     * instantiating them.
     * 
     * @param type the type to transfer
     * @param contexts the target contexts (using the actual one)
     * @param var the variable to instantiate for
     */
    public void transferToContext(IDatatype type, ContextStack contexts, AbstractVariable var) {
        Entry entry = cache.get(type);
        if (null != entry && null != entry.varMap) {
            for (Map.Entry<AbstractVariable, ConstraintSyntaxTree> e : entry.varMap.entrySet()) {
                contexts.registerMapping(e.getKey(), entry.instantiate(e.getValue(), var));
            }
        }
    }

}
