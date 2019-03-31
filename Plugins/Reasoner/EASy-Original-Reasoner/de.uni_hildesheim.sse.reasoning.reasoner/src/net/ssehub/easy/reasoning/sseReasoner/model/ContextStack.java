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
package net.ssehub.easy.reasoning.sseReasoner.model;

import static net.ssehub.easy.reasoning.sseReasoner.model.ReasoningUtils.createContainerCall;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.reasoning.core.reasoner.ConstraintList;
import net.ssehub.easy.reasoning.sseReasoner.model.TypeCache.IConstraintTarget;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Constraint.Type;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Implements a context stack for nested translations. The top-most context corresponds to the 
 * project, further nested contexts to visited compounds or containers. Each context contains
 * the recent part of the variable mapping, whereby {@link #getMapping(AbstractVariable) variable
 * mapping lookup} starts with the current context and takes also previous contexts into account. 
 * Each context may parts of a complex constraint accessing the path to contained compound variables (the complete 
 * constraint over all stack contexts can be obtained from {@link #composeExpression(ConstraintSyntaxTree)}.<p>
 * 
 * However, due to IVML assignment blocks, a translation context stack is not really straightforward.
 * In assignment blocks, additional implicit constraints to initialize annotations are introduced and
 * translated after the actual variable has been translated, i.e., outside the context of a compound
 * or container variable. Therefore, we allow {@link #setRegisterContexts(boolean) registering contexts} 
 * with their variable in the parent context for later {@link #activate(AbstractVariable) activation} and 
 * {@link #deactivate(AbstractVariable) deactivation} as long as the parent context exists. If re-activated,
 * an already popped context (which must not be cleaned up then) is pushed back onto the stack. If de-activated,
 * the re-activated context is popped again but not cleaned up. Registered contexts are cleaned up when the
 * parent context is popped. 
 * 
 * @author Holger Eichelberger
 */
public final class ContextStack {
    
    /**
     * (Compound) Translation mode for active type caches. [type cache]
     * 
     * @author Holger Eichelberger
     */
    public enum TranslateMode {
        
        /**
         * Do nothing, i.e., create a context and go on.
         */
        NOTHING,
        
        /**
         * Register mappings as without type cache.
         */
        REGISTER,
        
        /**
         * Transfer existing mappings instead of creating new ones.
         */
        TRANSFER
    }
    
    /**
     * A linked stack entry. Stack is formed through {@link #predecessor}.
     * 
     * @author Holger Eichelberger
     */
    static class Context {
        
        /**
         * Variable-accessor mapping.
         */
        private Map<AbstractVariable, ConstraintSyntaxTree> varMap 
            = new HashMap<AbstractVariable, ConstraintSyntaxTree>(30);
        
        /**
         * Secundary name-accessor mapping, consistent with {@link #varMap}.
         */
        private Map<String, ConstraintSyntaxTree> nameMap = new HashMap<String, ConstraintSyntaxTree>();
        
        /**
         * Iterator variable for incremental container quantification.
         */
        private DecisionVariableDeclaration iterator;

        /**
         * Container accessor for incremental container quantification.
         */
        private ConstraintSyntaxTree container;
        
        /**
         * Predecessor context for stacked lookups.
         */
        private Context predecessor;
        
        /**
         * Shall processed types be recorded.
         */
        private boolean recordProcessedTypes;
        
        /**
         * The processed types.
         */
        private Set<IDatatype> processedTypes = new HashSet<IDatatype>();
        
        /**
         * Stores type-excludes for constraint re-scheduling.
         */
        private Set<? extends IDatatype> typeExcludes;
        
        /**
         * Stores the associated type.
         */
        private IDatatype type;
        
        /**
         * A type cache entry in construction during translation.
         */
        private TypeCache.Entry inConstruction;
        
        /**
         * Indicates whether the mapping shall be (type) cached in this context.
         */
        private boolean cashMapping;
        
        /**
         * Indicates that only constraint variable constraints shall be translated/instantiated.
         */
        private boolean constraintVarOnly;
        
        /**
         * A completed type cache entry to be used as fallback lookup for on-demand accessor instantiation.
         */
        private TypeCache.Entry fallback;
        
        /**
         * The underlying variable being translated, used for fallback lookups in on-demand accessor instantiation 
         * through {@link #fallback}.
         */
        private AbstractVariable self;
        
        /**
         * Clears this context.
         */
        private void clear() {
            varMap.clear();
            nameMap.clear();
            iterator = null;
            container = null;
            predecessor = null;
            recordProcessedTypes = false;
            processedTypes.clear();
            typeExcludes = null;
            type = null;
            inConstruction = null;
            cashMapping = false;
            fallback = null;
        }
        
    }

    private static final Pool<Context> POOL = new Pool<Context>(new IPoolManager<Context>() {

        @Override
        public Context create() {
            return new Context();
        }

        @Override
        public void clear(Context instance) {
            instance.clear();
        }
        
    });
    
    private Context currentContext;
    private Set<? extends IDatatype> globalExcludes;
    private transient TypeCache typeCache = TypeCache.ENABLED ? new TypeCache() : null;

    /**
     * Creates a context stack with implicit top-most (project) context.
     */
    public ContextStack() {
        currentContext = new Context();
    }

    /**
     * Clears the stack, i.e., pops all contexts and clears the top-most (project) context for re-use.
     */
    public void clear() {
        do {
            popContext(); // changes currentContext
        } while (null != currentContext.predecessor);
        currentContext.clear();
    }

    /**
     * Pushes a new (compound) context to the stack. No processed types are recorded.
     * 
     * @param decl the variable to register the new context with if {@link #setRegisterContexts(boolean) enabled}, 
     *     may be <b>null</b> to explicitly prevent registration
     * @param recordProcessedTypes whether processed types indicated by {@link #recordType(IDatatype)} shall be recorded
     *     or not (<code>false</code>)
     */
    public void pushContext(AbstractVariable decl, boolean recordProcessedTypes) {
        pushContext(decl, null, null, false);
    }

    /**
     * Pushes a new container context to the stack. All parameters may be <b>null</b>.
     * 
     * @param decl the variable to register the new context with if {@link #setRegisterContexts(boolean) enabled}, 
     *     may be <b>null</b> to explicitly prevent registration
     * @param container the container expression (may be <b>null</b>)
     * @param iterator a container iterator variable for <code>container</code>, may be <b>null</b> but only if 
     *     <code>container</code> is null
     * @param recordProcessedTypes whether processed types indicated by {@link #recordType(IDatatype)} shall be recorded
     *     or not (<code>false</code>)
     */
    public void pushContext(AbstractVariable decl, ConstraintSyntaxTree container, 
        DecisionVariableDeclaration iterator, boolean recordProcessedTypes) {
        Context context = POOL.getInstance();
        
        // fill values
        context.container = container;
        context.iterator = iterator;
        context.recordProcessedTypes = recordProcessedTypes;
        
        pushContextImpl(context);
    }
    
    /**
     * Just pushes the given <code>context</code> without changing it.
     * 
     * @param context the context to be pushed
     */
    private void pushContextImpl(Context context) {
        // make to current context, link into
        context.predecessor = currentContext;
        context.inConstruction = currentContext.inConstruction;
        context.constraintVarOnly = currentContext.constraintVarOnly;
        context.self = currentContext.self;
        currentContext = context;
    }

    /**
     * Pops a context and transfers the cache information. [type cache]
     * 
     * @param type the type to transfer the data to if the actual context is in {@link Context#inConstruction} and
     * cashing is needed {@link Context#cashMapping}.
     */
    public void popContext(IDatatype type) {
        if (TypeCache.ENABLED) {
            if (currentContext.inConstruction != null && currentContext.cashMapping) {
                typeCache.transferContext(type, 
                    ReasoningUtils.copyMapNull(currentContext.varMap), 
                    ReasoningUtils.copyMapNull(currentContext.nameMap));
            }
        }
        popContextImpl();
    }
    
    /**
     * Removes (and clears) the current context from the stack (except for the initial project context
     * which remains). Contexts are only cleaned up and released to the pool if they are not registered with
     * a parent context.
     */
    public void popContext() {
        popContextImpl();
    }
    
    /**
     * Pops the actual context if not the initial (project) context but does not clean up the popped context.
     * 
     * @return the popped context, <b>null</b> in case of the initial (project) context
     */
    private Context popContextImpl() {
        Context context = null;
        if (null != currentContext.predecessor) {
            context = currentContext;
            currentContext = context.predecessor;
            currentContext.cashMapping |= context.cashMapping;
        }
        return context;
    }
    
    /**
     * Registers a mapping between the variable <code>var</code> and its actual access expression <code>acc</code> into
     * the current top-most context. Overrides any existing mapping in the top-most context. Preceeds any 
     * existing mapping in a previous still active context.
     * 
     * @param var the variable
     * @param acc the access expression
     */
    public void registerMapping(AbstractVariable var, ConstraintSyntaxTree acc) {
        currentContext.varMap.put(var, acc);
        String name = var.getName();
        if (!currentContext.nameMap.containsKey(name)) {
            currentContext.nameMap.put(name, acc);
        }
    }
    
    /**
     * Unregisters a mapping for the variable <code>var</code> from the current context.
     * 
     * @param var the variable to be unregistered
     */
    public void unregisterMapping(AbstractVariable var) {
        currentContext.varMap.remove(var);
    }
    
    /**
     * Returns whether the current context contains a mapping for <code>var</code>.
     * 
     * @param var the variable to look for
     * @return <code>true</code> if there is a mapping, <code>false</code> else
     */
    public boolean containsMapping(AbstractVariable var) {
        boolean found = currentContext.varMap.containsKey(var); // not != null, may be null
        if (TypeCache.ENABLED) { // method is needed, just disable additional functionality
            if (!found && currentContext.fallback != null) {
                found = currentContext.fallback.containsMapping(var);
            }
        }
        return found;
    }

    /**
     * Returns the mapped access expression for <code>var</code> taking into account all current
     * contexts of the stack starting with the current top-most one.
     * 
     * @param var the variable to return the mapping for
     * @return the mapped access expression or <b>null</b> if there is no registered mapping
     */
    public ConstraintSyntaxTree getMapping(AbstractVariable var) {
        ConstraintSyntaxTree result;
        Context iter = currentContext;
        do {
            result = iter.varMap.get(var);
            if (TypeCache.ENABLED) { // method is needed, just disable additional functionality
                if (null == result && null != iter.fallback) {
                    result = iter.fallback.getMapping(var, currentContext.self);
                }
            }
            iter = iter.predecessor;
        } while (null == result && null != iter);
        return result;
    }
    
    /**
     * Returns the local mapping for the given variable {@code name} just from the current context. Names are 
     * registered once, to the most local (non-shadowed) variable.
     * 
     * @param name the name of the variable
     * @return the mapped access expression or <b>null</b> if there is no registered mapping
     */
    public ConstraintSyntaxTree getLocalMapping(String name) {
        ConstraintSyntaxTree result = currentContext.nameMap.get(name);
        if (TypeCache.ENABLED) { // method is needed, just disable additional functionality
            if (null == result && null != currentContext.fallback) {
                result = currentContext.fallback.getLocalMapping(name, currentContext.self);
            }
        }
        return result;
    }
    
    /**
     * Adds a constraint to the type cache that is currently in construction for the actual context frame. [type cache]
     * 
     * @param target the target constraint list
     * @param first add to the front or to the end of {@code target}
     * @param constraint the (template) constraint to be stored
     * @param register shall the constraint later be registered with {@link VariablesMap}
     */
    public void addConstraint(ConstraintList target, boolean first, Constraint constraint, boolean register) {
        if (TypeCache.ENABLED) {
            if (null != currentContext.inConstruction && constraint.getType() != Type.CONSTRAINT) {
                currentContext.inConstruction.addConstraint(target, first, constraint, register);
            }
        }
    }
    
    /**
     * Transfers all constraints from the associated type cache entry into their respective target constraint
     * sets. Substitute the original template variable by {@code var}. [type cache]
     * 
     * @param type the type to transfer the constraints for
     * @param target the constraint target
     * @param register the variable to register the new constraints with {@link VariablesMap}
     * @param var the actual variable for substitution
     * @return {@code true} if the transfer was done even if no constraint was transferred as no one was registered and 
     *   no further translation shall happen, {@code false} if translation can go on, e.g. the type cache for {@code} 
     *   type is currently in construction
     */
    public boolean transferConstraints(IDatatype type, IConstraintTarget target, IDecisionVariable register, 
        AbstractVariable var) {
        boolean result = false;
        if (TypeCache.ENABLED) {
            if (null == currentContext.inConstruction) {
                if (typeCache.transferConstraints(type, target, register, var)) {
                    if (TranslateMode.TRANSFER == getMappingMode(type)) {
                        // for transfer keep translate
                        currentContext.constraintVarOnly = true;
                    } else {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the flag of the current context whether only constraint variables shall be translated. [type cache]
     * 
     * @param clear clears the original value to {@code false} (e.g., for temporary use)
     * @return the original value
     */
    public boolean constraintVarOnly(boolean clear) {
        boolean result;
        //TypeCache.ENABLED as switching off on caller side will lead to warnings
        if (TypeCache.ENABLED) {
            result = currentContext.constraintVarOnly;
            if (clear) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Changes the flag of the current context whether only constraint variables shall be translated. [type cache]
     * 
     * @param constraintVarOnly the new value of the flag
     */
    public void setConstraintVarOnly(boolean constraintVarOnly) {
        //TypeCache.ENABLED as switching off on caller side will lead to warnings
        if (TypeCache.ENABLED) {
            currentContext.constraintVarOnly = constraintVarOnly;
        }
    }
    
    /**
     * Registers the given type and the prototypical template variable {@code var} as type in the type cache.
     * As long as the containing context is active, all constraints added through 
     * {@link #addConstraint(ConstraintList, boolean, Constraint, boolean))} will be related to the created type 
     * cache entry. Upon 
     * {@link #transferConstraints(IDatatype, IConstraintTarget, IDecisionVariable, AbstractVariable))} 
     * all occurrences of {@code var} will be substituted by a given variable. [type cache]
     * 
     * @param type the type to relate to
     * @param var the template variable
     */
    public void registerForTypeCache(IDatatype type, AbstractVariable var) {
        //TypeCache.ENABLED on caller side
        if (TypeCache.ENABLED) {
            setInConstruction(typeCache.createEntryFor(type, var)); 
        }
    }

    /**
     * Returns whether the current context is currently constructing a type cache. [type cache]
     * 
     * @param clear clears the original value to {@code null} (e.g., for temporary use)
     * @return the type cache entry
     */
    public TypeCache.Entry getInConstruction(boolean clear) {
        //TypeCache.ENABLED as switching off on caller side will lead to warnings
        TypeCache.Entry result;
        if (TypeCache.ENABLED) {
            result = currentContext.inConstruction;
            if (clear) {
                currentContext.inConstruction = null;
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Changes the type cache the current context is currently constructing. [type cache]
     * 
     * @param inConstruction the type cache being in construction, may be {@code null} for none
     */
    public void setInConstruction(TypeCache.Entry inConstruction) {
        //TypeCache.ENABLED as switching off on caller side will lead to warnings
        if (TypeCache.ENABLED) {
            currentContext.inConstruction = inConstruction;
        }
    }

    /**
     * Notifies the current context that mappings shall be cached upon {@link #popContext(IDatatype)}. [type cache]
     */
    public void notifyCashMapping() {
        if (TypeCache.ENABLED) {
            currentContext.cashMapping = true;
        }
    }

    /**
     * Returns the type cache mapping mode when trying to register a new type. [type cache]
     * 
     * @param type the type the mode shall be returned for
     * @return the mode
     */
    public TranslateMode getMappingMode(IDatatype type) {
        TranslateMode result = TranslateMode.REGISTER;
        if (TypeCache.ENABLED) {
            TypeCache.Entry entry = typeCache.get(type);
            if (null != entry) {
                result = entry.hasMapping() ? TranslateMode.TRANSFER : TranslateMode.NOTHING;
            }
        }
        return result;
    }

    /**
     * Indicates that mapping information from the type cache shall be transferred into the current context.
     * This may be done on-demand or in one step depending on {@link TypeCache#ON_DEMAND_ACCESSORS}. [type cache]
     * 
     * @param type the type to do the transfer for
     * @param var the variable replacing the template variable
     */
    public void transferToContext(IDatatype type, AbstractVariable var) {
        if (TypeCache.ENABLED) {
            if (TypeCache.ON_DEMAND_ACCESSORS) {
                // on-demand accessor instantiation
                TypeCache.Entry entry = typeCache.get(type);
                if (null != entry && null != var) {
                    currentContext.fallback = entry;
                    currentContext.self = var;
                }
            } else {
                // one-step accessor instantiation
                typeCache.transferToContext(type, this, var);
                currentContext.fallback = null;
                currentContext.self = null;
            }
        }
    }
    
    /**
     * Adds the type cache of {@code type} as parent to the type cache that is currently in construction. [type cache]
     * 
     * @param type the type to add
     * @param target the target container for immediately transferring constraints
     * @param register whether constraints shall be registered
     * @param var the replacing variable
     */
    public void addAsParentCache(IDatatype type, IConstraintTarget target, IDecisionVariable register, 
        AbstractVariable var) {
        if (TypeCache.ENABLED) {
            if (currentContext.inConstruction != null) {
                TypeCache.Entry entry = typeCache.get(type);
                if (null != entry) {
                    currentContext.inConstruction.addParent(entry, target, register, var);
                }
            } else {
                transferConstraints(type, target, register, var);
            }
        }
    }

    /**
     * Returns the current container expression from the top-most context.
     * 
     * @return the container expression (may be <b>null</b> for the initial project context or a compound context)
     */
    public ConstraintSyntaxTree getCurrentContainer() {
        return currentContext.container;
    }

    /**
     * Returns the current iterator variable from the top-most context.
     * 
     * @return the iterator variable (may be <b>null</b> for the initial project context or a compound context)
     */
    public DecisionVariableDeclaration getCurrentIterator() {
        return currentContext.iterator;
    }
    
    /**
     * Composes an all-quantified expression over the contexts of the stack. If
     * no stack contains container/iterator, <code>cst</code> will be returned.
     * 
     * @param cst the constraint expression to be composed, shall contain the access
     *   expression of the top-most context to be effective
     * @return the composed expression or <code>cst</code> if there is nothing to compose
     * @throws CSTSemanticException if the composed expression is not valid
     */
    public ConstraintSyntaxTree composeExpression(ConstraintSyntaxTree cst) throws CSTSemanticException {
        Context iter = currentContext;
        do {
            if (null != iter.container) {
                cst = createContainerCall(iter.container, Container.FORALL, cst, iter.iterator);
                cst.inferDatatype();
            }
            iter = iter.predecessor;
        } while (null != iter);
        return cst;
    }

    /**
     * Records a processed type (in case of compounds also all refined types) in the closest actual context that allows 
     * recording (see {@link Context#recordProcessedTypes} and {@link #pushContext(AbstractVariable, 
     * ConstraintSyntaxTree, DecisionVariableDeclaration, boolean)}). Stores {@code type} in the current
     * context for retrieval via {@link #getCurrentType()}.
     * 
     * @param type the type to record
     */
    public void recordProcessed(IDatatype type) {
        boolean found = false;
        Context iter = currentContext;
        do {
            if (iter.recordProcessedTypes) {
                if (type instanceof Compound) {
                    recordProcessed(iter.processedTypes, (Compound) type);
                } else {
                    iter.processedTypes.add(type);
                }
                found = true;
            }
            iter = iter.predecessor;
        } while (!found && null != iter);
    }

    /**
     * Records a processed compound.
     * 
     * @param processed the set of already processed types (may be modified as a side effect)
     * @param type the type to be recorded
     */
    private void recordProcessed(Set<IDatatype> processed, Compound type) {
        if (!processed.contains(type)) {
            processed.add(type);
            for (int r = 0; r < type.getRefinesCount(); r++) {
                recordProcessed(processed, type.getRefines(r));
            }
        }
    }
    
    /**
     * Returns whether <code>type</code> was already processed. All current contexts with enabled
     * recording are considered.
     * 
     * @param type the type to look for
     * @return <code>true</code> if the type was already processed, <code>false</code> if not
     */
    public boolean alreadyProcessed(IDatatype type) {
        boolean found = false;
        Context iter = currentContext;
        do {
            if (iter.recordProcessedTypes) {
                found = iter.processedTypes.contains(type);
            }
            iter = iter.predecessor;
        } while (!found && null != iter);
        return found;
    }
    
    /**
     * Returns the size of the context stack.
     * 
     * @return the size
     */
    public int size() {
        int result = 0;
        Context iter = currentContext;
        do {
            result++;
            iter = iter.predecessor;
        } while (null != iter);
        return result;
    }
    
    /**
     * Sets type excludes on the current context. Type excludes are only valid on the given
     * context, but defined type excludes on the next enclosing context may be 
     * {@link #transferTypeExcludes(IDatatype) transferred}.  
     * 
     * @param excludes the type excludes, <b>null</b> for none
     * @see #isTypeExcluded(IDatatype)
     * @see #isElementTypeExcluded(IModelElement)
     */
    public void setTypeExcludes(Set<? extends IDatatype> excludes) {
        globalExcludes = excludes;
    }
    
    /**
     * Transfers the type excludes from the next enclosing context defining type excludes to the current
     * context. Clears the type excludes in the originating context.
     *  
     * @param type the type causing the transfer, to be stored in the current context (@link #getCurrentType()}
     * @see #setTypeExcludes(Set)
     * @see #isTypeExcluded(IDatatype)
     * @see #isElementTypeExcluded(IModelElement)
     */
    public void transferTypeExcludes(IDatatype type) {
        if (null != globalExcludes && null == currentContext.typeExcludes) {
            currentContext.typeExcludes = globalExcludes;
            globalExcludes = null;
        }
        currentContext.type = type;
    }
    
    /**
     * Returns whether the given <code>element</code> if it is a type is excluded in the current
     * context.
     * 
     * @param element the element to check for
     * @return {@code true} if excluded, {@code false} else
     */
    public boolean isElementTypeExcluded(IModelElement element) {
        return element instanceof IDatatype ? isTypeExcluded((IDatatype) element) : false;
    }

    /**
     * Returns whether the given {@code type} is excluded in the current context. 
     * 
     * @param type the type to check for
     * @return {@code true} if excluded, {@code false} else
     */
    public boolean isTypeExcluded(IDatatype type) {
        return null == currentContext.typeExcludes ? false : currentContext.typeExcludes.contains(type);
    }

    /**
     * Returns the type stored in the current context.
     * 
     * @return the type, may be <b>null</b> if there is none
     */
    public IDatatype getCurrentType() {
        return currentContext.type;
    }

}
