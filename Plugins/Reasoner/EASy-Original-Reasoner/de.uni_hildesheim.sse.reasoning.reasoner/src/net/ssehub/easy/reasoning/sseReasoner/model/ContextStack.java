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
import java.util.Map;

import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Container;

/**
 * Implements a context stack for nested translations. The top-most context corresponds to the 
 * project, further nested contexts to visited compounds or containers. Each context contains
 * the recent part of the variable mapping, whereby {@link #getMapping(AbstractVariable) variable
 * mapping lookup} starts with the current context and takes also previous contexts into account. 
 * Each context may store a compound access expression and, container contexts, parts of a complex
 * constraint accessing the path to contained compound variables (the complete constraint over all
 * stack contexts can be obtained from {@link #composeExpression(ConstraintSyntaxTree)}.<p>
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
public class ContextStack {
    
    /**
     * A linked stack entry. Stack is formed through {@link #predecessor}.
     * 
     * @author Holger Eichelberger
     */
    private static class Context {
        private Map<AbstractVariable, ConstraintSyntaxTree> varMap 
            = new HashMap<AbstractVariable, ConstraintSyntaxTree>(30);
        private ConstraintSyntaxTree access;
        private DecisionVariableDeclaration iterator;
        private ConstraintSyntaxTree container;
        private Context predecessor;
        private Map<AbstractVariable, Context> registeredContexts = new HashMap<AbstractVariable, Context>();
        private boolean isRegistered;
        
        /**
         * Clears this context.
         */
        private void clear() {
            varMap.clear();
            for (Map.Entry<AbstractVariable, Context> ent : registeredContexts.entrySet()) {
                POOL.releaseInstance(ent.getValue());
            }
            registeredContexts.clear();
            access = null;
            iterator = null;
            container = null;
            predecessor = null;
            isRegistered = false;
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
    private boolean registerContexts = false;

    /**
     * Creates a context stack with implicit top-most (project) context.
     */
    public ContextStack() {
        currentContext = new Context();
    }

    /**
     * Enables or disables registering contexts.
     * 
     * @param registerContexts whether newly pushed contexts shall be registered from now on 
     * @return the old state, to be used in a local variable to call this method with the previous state correctly
     */
    public boolean setRegisterContexts(boolean registerContexts) {
        boolean res = this.registerContexts;
        this.registerContexts = registerContexts;
        return res;
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
     * Pushes a new (compound) context to the stack.
     * 
     * @param decl the variable to register the new context with if {@link #setRegisterContexts(boolean) enabled}, 
     *     may be <b>null</b> to explicitly prevent registration
     * @param access the access expression to the compound (may be <b>null</b> for top-most compounds)
     */
    public void pushContext(AbstractVariable decl, ConstraintSyntaxTree access) {
        pushContext(decl, null, null, access);
    }

    /**
     * Pushes a new container context to the stack. All parameters may be <b>null</b>.
     * 
     * @param decl the variable to register the new context with if {@link #setRegisterContexts(boolean) enabled}, 
     *     may be <b>null</b> to explicitly prevent registration
     * @param container the container expression (may be <b>null</b>)
     * @param iterator a container iterator variable for <code>container</code>, may be <b>null</b> but only if 
     *     <code>container</code> is null
     * @param access compound access expression (may be <b>null</b> for top-most container)
     */
    public void pushContext(AbstractVariable decl, ConstraintSyntaxTree container, DecisionVariableDeclaration iterator,
        ConstraintSyntaxTree access) {
        Context context = POOL.getInstance();
        
        // fill values
        context.container = container;
        context.iterator = iterator;
        context.access = access;
        
        if (registerContexts && null != decl) {
            currentContext.registeredContexts.put(decl, context);
            context.isRegistered = true;
        }
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
        currentContext = context;
    }

    /**
     * Removes (and clears) the current context from the stack (except for the initial project context
     * which remains). Contexts are only cleaned up and released to the pool if they are not registered with
     * a parent context.
     */
    public void popContext() {
        Context context = popContextImpl();
        if (null != context && !context.isRegistered) {
            POOL.releaseInstance(context);
        }
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
            iter = iter.predecessor;
        } while (null == result && null != iter);
        return result;
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
     * Returns the current access expression from the top-most context.
     * 
     * @return the current access expression (may be <b>null</b>, e.g., for the initial project contect)
     */
    public ConstraintSyntaxTree getCurrentAccess() {
        return currentContext.access;
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
     * Looks up the actual contexts whether <code>decl</code> was registered previously with a context.
     * 
     * @param decl the declaration to search for
     * @return the registered context or <b>null</b> if none was registered
     */
    private Context findRegisteredContext(AbstractVariable decl) {
        Context result = null;
        Context iter = currentContext;
        do {
            result = iter.registeredContexts.get(decl);
            iter = iter.predecessor;
        } while (null == result && null != iter);
        return result;
    }

    /**
     * Re-activates the context registered for <code>decl</code> and re-pushes it onto the stack. Nothing happens if 
     * no context was registered.
     * 
     * @param decl the declaration
     */
    public void activate(AbstractVariable decl) {
        Context registered = findRegisteredContext(decl);
        if (null != registered) {
            pushContextImpl(registered);
        }
    }
    
    /**
     * Deactivates the context registered for <code>decl</code>. Nothing happens if no context was registered.
     * 
     * @param decl the declaration
     */
    public void deactivate(AbstractVariable decl) {
        if (null != findRegisteredContext(decl)) {
            popContextImpl(); // don't clear, keep it
        }
    }

}
