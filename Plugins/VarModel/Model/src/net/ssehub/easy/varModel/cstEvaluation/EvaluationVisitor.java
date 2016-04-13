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
package net.ssehub.easy.varModel.cstEvaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.CopyVisitor;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cst.CopyVisitor.IVariableReplacer;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Evaluation visitor for IVML expressions. Usage:
 * <ol>
 *   <li>Single use: Call {@link #EvaluationVisitor(IConfiguration, IAssignmentState, boolean, EvaluationContext)}, 
 *     {@link #visit(ConstraintSyntaxTree)}, call {@link #getResult()} and finally {@link #clear()}.</li>
 *   <li>Reuse: Call {@link #EvaluationVisitor()}. Before visiting, call 
 *     {@link #init(IConfiguration, IAssignmentState, boolean, boolean, EvaluationContext)}, 
 *     {@link #visit(ConstraintSyntaxTree)}, call {@link #getResult()} and then {@link #clear()}. Now you can go
 *     on with {@link #init(IConfiguration, boolean)} etc.</li>
 *   <li>Do not forget to {@link #setDispatchScope(Project) set the dispatch scope} to the project which is currently
 *     being evaluated.
 * </ol>
 * Please note that you may also let the constraint accept the visitor directly, but then the evaluation will fail 
 * if static compound accesses occur. Please use {@link #visit(ConstraintSyntaxTree)} instead.<br/>
 * Please do not forget to call {@link #clear()}! {@link #clearResult()} allows to reuse a visitor including the
 * settings made in {@link #init(IConfiguration, IAssignmentState, boolean, IValueChangeListener)}. <br/>
 * Personally, I would handle evaluation problems with exceptions, but the visitor interface and the classes to be 
 * visited are not defined to support this adequately.
 * 
 * @author Holger Eichelberger
 */
public class EvaluationVisitor implements IConstraintTreeVisitor {
    
    protected IAssignmentState assignmentState;
    private EvaluationAccessor result;
    private int opNesting = 0;
    private boolean assignmentsOnly;
    private IValueChangeListener listener;
    private IResolutionListener resolutionListener;
    private List<Message> messages = new ArrayList<Message>();
    private EvaluationContextImpl context;
    private Project dispatchScope;
    private StaticAccessFinder finder = new StaticAccessFinder();
    private Set<DecisionVariableDeclaration> selfVars = new HashSet<DecisionVariableDeclaration>();
    private Value selfValue;
    private boolean issueWarning;
    private ConstraintSyntaxTree innermostFailed;
    private Map<AbstractVariable, IDecisionVariable> varMapping = new HashMap<AbstractVariable, IDecisionVariable>();
    private ConstantValueResolver constantResolver = new ConstantValueResolver(this);

    /**
     * Implements the evaluation context. The context may contain nested local 
     * configurations in order to represent the nested (recursive) execution of 
     * operations defining parameters or local variables (let). Decision variables
     * are searched along this stack starting at the top.
     * 
     * @author Holger Eichelberger
     */
    private class EvaluationContextImpl extends EvaluationContext implements IConfiguration {

        private Stack<IConfiguration> configStack = new Stack<IConfiguration>();
        private boolean allowPropagation = true;

        /**
         * Creates the context.
         * 
         * @param config the variability model configuration (outermost stack level)
         */
        EvaluationContextImpl(IConfiguration config) {
            pushLevel(config);
        }
        
        /**
         * Pushes a level.
         * 
         * @param config the configuration to be pushed
         */
        void pushLevel(IConfiguration config) {
            configStack.push(config);
        }
        
        /**
         * Pops the top-most configuration level.
         */
        void popLevel() {
            configStack.pop();
        }
        
        @Override
        public boolean allowAssignValues() {
            return assignmentState != null;
        }

        @Override
        public void notifyChangeListener(IDecisionVariable variable) {
            if (null != listener && null != variable) {
                listener.notifyChanged(variable);
            }
        }

        @Override
        public void addMessage(Message message) {
            if (null != message) {
                EvaluationVisitor.this.addMessage(message);
            }
        }

        @Override
        public IAssignmentState getTargetState(IDecisionVariable var) {
            return EvaluationVisitor.this.getTargetState(var);
        }

        @Override
        public IDecisionVariable getDecision(AbstractVariable variable) {
            IDecisionVariable result = varMapping.get(variable); // may be null
            for (int l = configStack.size() - 1; null == result && l >= 0; l--) {
                result = configStack.get(l).getDecision(variable);
            }
            if (null != resolutionListener && null != result) {
                resolutionListener.notifyResolved(variable, result);
            }
            return result;
        }

        @Override
        public Value getAllInstances(IDatatype type) {
            return configStack.get(0).getAllInstances(type);
        }
        
        /**
         * Binds the type to the first/closest definition of type.
         * 
         * @param type the type to search for
         * @return the value (may be <b>null</b> if there is none)
         */
        Value bind(IDatatype type) {
            Value result = null;
            for (int l = configStack.size() - 1; null == result && l >= 0; l--) {
                IConfiguration cfg = configStack.get(l);
                if (cfg instanceof LocalConfiguration) {
                    LocalConfiguration localCfg = (LocalConfiguration) cfg;
                    result = localCfg.bind(type, context);
                }
            }
            return result;
        }
        
        @Override
        public void issueWarning() {
            issueWarning = true;
        }

        @Override
        public boolean allowPropagation() {
            return allowPropagation;
        }
        
        /**
         * Changes the propagation state of this context.
         * 
         * @param inPropagation whether we are currently in a propagation
         * @param op a filter for allowing propagation, basically implies
         *   is allow to change or <b>null</b> (no operation as filter)
         * @return the propagation state before
         */
        boolean setAllowPropagation(Operation op, boolean inPropagation) {
            boolean oldState = this.allowPropagation;
            if (op == BooleanType.IMPLIES || null == op) {
                this.allowPropagation = inPropagation;
            }
            return oldState;
        }

    }
    
    /**
     * Extended Message class for saving variables that fail in assignments.
     * 
     * @author Sizonenko
     */
    public static class Message extends net.ssehub.easy.basics.messages.Message {

        private IDecisionVariable  var;
        
        /**
         * Main contractor.
         * @param description Description of why variable is saved.
         * @param status {@link Status} of the message.
         * @param var causing {@link IDecisionVariable} to be saved.
         */
        public Message(String description, Status status, IDecisionVariable var) {
            super(description, status);
            this.var = var;
        }
        
        /**
         * Getter for the variable declaration.
         * 
         * @return the variable declaration or <tt>null</tt> if no {@link IDecisionVariable}
         * was passed to the constructor.
         */
        public AbstractVariable getVariable() {
            return null != var ? var.getDeclaration() : null;
        }
        
        /**
         * Returns the causing decision variable.
         * 
         * @return the causing decision variable or <tt>null</tt> if no {@link IDecisionVariable}
         * was passed to the constructor.
         */
        public IDecisionVariable getDecision() {
            return var;
        }
        
    }
    
    // ----------------------------------- construction and reuse -----------------------------
    
    /**
     * Creates an evaluation visitor.
     */
    public EvaluationVisitor() {
    }
    
    /**
     * Creates an evaluation visitor.
     * 
     * @param config the configuration to take already evaluated values from
     * @param assignmentState the state for the assignments (may be <b>null</b> if no assignment shall take place)
     * @param assignmentsOnly if <code>true</code> process only assignments, else process all constraints
     * @param listener a listener to notify some external mechanism about a changed variable (may be <b>null</b>)
     */
    public EvaluationVisitor(IConfiguration config, IAssignmentState assignmentState, boolean assignmentsOnly, 
        IValueChangeListener listener) {
        this();
        init(config, assignmentState, assignmentsOnly, listener);
    }

    /**
     * Clears the visitor for reuse.
     * 
     * @param config the configuration to take already evaluated values from
     * @param assignmentState the state for the assignments (may be <b>null</b> if no assignment shall take place)
     * @param assignmentsOnly if <code>true</code> process only assignments, else process all constraints
     * @param listener a listener to notify some external mechanism about a changed variable (may be <b>null</b>)
     */
    public void init(IConfiguration config, IAssignmentState assignmentState, boolean assignmentsOnly, 
        IValueChangeListener listener) {
        this.context = new EvaluationContextImpl(config);
        this.assignmentState = assignmentState;
        this.assignmentsOnly = assignmentsOnly;
        this.listener = listener;
    }
    
    /**
     * Defines the current (optional) resolution listener.
     *  
     * @param listener the listener (may be <b>null</b> to indicate that no listener is required)
     */
    public void setResolutionListener(IResolutionListener listener) {
        this.resolutionListener = listener;
    }
    
    /**
     * Adds an explicit mapping of a declaration to a decision variable taking precedence over the configuration.
     * This is in particular required for evaluating freeze-but. 
     * 
     * @param decl the declaration
     * @param var the variable
     */
    void addMapping(AbstractVariable decl, IDecisionVariable var) {
        varMapping.put(decl, var);
    }

    /**
     * Removes an explicit mapping of a declaration to a decision variable as counterpart for 
     * {@link #addMessage(Message)}. This is in particular required for evaluating freeze-but. 
     * 
     * @param decl the declaration
     */
    void removeMapping(AbstractVariable decl) {
        varMapping.remove(decl);
    }
    
    /**
     * Defines the top-level search scope for dynamic dispatch of custom operations.
     * 
     * @param scope the scope (may be <b>null</b> to disable dynamic dispatch)
     * @return the scope before calling this operation
     */
    public Project setDispatchScope(Project scope) {
        Project oldScope = this.dispatchScope;
        this.dispatchScope = scope;
        return oldScope;
    }
    
    /**
     * Changes the value of "self" for the current compound in case that constraint evaluation does
     * not happen via {@link #visit(ConstraintSyntaxTree)}. May be overwritten by {@link #visit(ConstraintSyntaxTree)}.
     * 
     * @param selfValue the self value, may be <b>null</b> if evaluation happens not in a compound
     */
    public void setSelfValue(CompoundValue selfValue) {
        this.selfValue = selfValue;
    }
        
    /**
     * Clears the visitor for reuse (including the dispatch scope).
     */
    public void clear() {
        clearResult();
        context = null;
        assignmentState = null;
        dispatchScope = null;
        messages.clear();
        selfVars.clear();
        selfValue = null;
        issueWarning = false;
        innermostFailed = null;
    }
    
    /**
     * Clears the result.
     */
    public void clearResult() {
        if (null != result) {
            result.release();
            result = null;
        }
    }
    
    // ------------------------------- result handling -------------------------------

    /**
     * Returns the evaluation result.
     * 
     * @return may be <b>null</b> in case of an expression that cannot be evaluated (shall lead to an exception)
     */
    public Value getResult() {
        Value result = null;
        if (null != this.result) {
            result = this.result.getValue(); 
        }
        return result;
    }
    
    /**
     * Just for internal purposes of derived classes - get the result accessor.
     * If you use this method, you are anyway responsible for cleaning up the result properly. 
     * 
     * @param nullify set {@link #result} to <b>null</b> and caller takes over full responsibility for releasing, 
     *    <code>false</code> leave responsibility in this part
     * 
     * @return the result accessor
     */
    protected EvaluationAccessor getResultAccessor(boolean nullify) {
        EvaluationAccessor res = result;
        if (nullify) {
            result = null;
        }
        return res;
    }

    /**
     * Returns whether the {@link #getResult() result of a constraint evaluation}
     * indicates that the evaluated constraint was fulfilled.
     * 
     * @param result the evaluation result
     * @return <code>true</code> if the constraint is fulfilled, <code>false</code> else
     */
    public static boolean constraintFulfilled(Object result) {
        return (BooleanValue.TRUE == result || Boolean.TRUE == result);
    }

    /**
     * Returns whether the {@link #getResult() result of a constraint evaluation}
     * indicates that the evaluated constraint failed.
     * 
     * @param result the evaluation result
     * @return <code>true</code> if the constraint failed, <code>false</code> else
     */
    public static boolean constraintFailed(Object result) {
        return (BooleanValue.FALSE == result || Boolean.FALSE == result);
    }

    /**
     * Returns whether the {@link #getResult() result of a constraint evaluation}
     * indicates that (at least one part of) the constraint was undefined.
     * 
     * @param result the evaluation result
     * @return <code>true</code> if (at least one part of) the constraint was undefined, <code>false</code> else
     */
    public static boolean constraintUndefined(Object result) {
        return result == null;
    }

    /**
     * Returns whether the constraint evaluation
     * indicates that the evaluated constraint was fulfilled.
     * 
     * @return <code>true</code> if the constraint is fulfilled, <code>false</code> else
     */
    public boolean constraintFulfilled() {
        return constraintFulfilled(result != null ? result.getValue() : null);
    }

    /**
     * Returns whether the constraint evaluation
     * indicates that the evaluated constraint failed.
     * For instance, the following should fail:
     * <pre><code>
     * a = true;
     * b = false;
     * 
     * !a or b
     * </code></pre>
     * 
     * @return <code>true</code> if the constraint failed, <code>false</code> else
     */
    public boolean constraintFailed() {
        return constraintFailed(result != null ? result.getValue() : null);
    }

    /**
     * Returns whether the constraint evaluation
     * indicates that (at least one part of) the constraint was undefined.
     * 
     * @return <code>true</code> if (at least one part of) the constraint was undefined, <code>false</code> else
     */
    public boolean constraintUndefined() {
        return constraintUndefined(result != null ? result.getValue() : null);
    }
    
    /**
     * Returns whether the constraint was internally evaluated to false but finally
     * leads to a successful execution and shall lead to a warning to the user.
     * 
     * @return <code>true</code> if the constraint shall be issued as a warning, <code>false</code> else.
     */
    public boolean constraintIsAWarning() {
        return issueWarning;
    }
    
    /**
     * Returns the innermost failed expression(s).
     *  
     * @return <b>null</b> if there were no failed expressions, the (innermost) failed expressions else 
     *   (currently at maximum one)
     */
    public ConstraintSyntaxTree[] getFailedExpression() {
        ConstraintSyntaxTree[] result;
        if (null != innermostFailed) {
            result = new ConstraintSyntaxTree[1];
            result[0] = innermostFailed;
        } else {
            result = null;
        }
        return result;
    }

    // --------------------------- error handling ---------------------------

    /**
     * Adds a message.
     * 
     * @param message the message to be added
     */
    private void addMessage(Message message) {
        messages.add(message);
    }
    
    /**
     * Adds an error message.
     * 
     * @param text the text of the error message
     */
    private void error(String text) {
        addMessage(new Message(text, Status.ERROR, null));
    }
    
    /**
     * Adds a not implemented error message.
     * 
     * @param subject the subject that is not implemented
     */
    private void notImplementedError(String subject) {
        addMessage(new Message("cannot evaluate " + subject + " as it is currently not implemented", 
            Status.UNSUPPORTED, null));
    }
    
    /**
     * Adds a throwable as error message.
     * 
     * @param th the throwable
     */
    private void exception(Throwable th) {
        error(th.getMessage());
    }
    
    /**
     * Returns the number of messages.
     * 
     * @return the number of messages
     */
    public int getMessageCount() {
        return messages.size();
    }
    
    /**
     * Returns the specified evaluation message.
     * 
     * @param index the message to return
     * @return the specified message
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link getMessageCount()}</code>
     */
    public Message getMessage(int index) {
        return messages.get(index);
    }
    
    // --------------------------- visitor ----------------------------

    /**
     * Returns the declaring compound type.
     * 
     * @param decl the variable declaration to return the compound parent for
     * @return the compound parent or <b>null</b> if there is none
     */
    private static Compound getDeclaringCompound(AbstractVariable decl) {
        IModelElement parent = decl.getParent();
        while (!(parent instanceof Project || parent instanceof Compound)) {
            parent = parent.getParent();
        }
        return parent instanceof Compound ? (Compound) parent : null;
    }
    
    /**
     * Visits a constraint syntax tree. This method considers partial expressions with static 
     * access and wraps the entire expression into an all-quantified constraint. "Free" variables are bound by 
     * all-quantors constructed for individual compound types. Multiple slots for one compound
     * are then bound by variable let expressions. As a result, the entire constraint is 
     * bound against the all-instance sets of the individual types and can be handled as all other
     * constraints by the {@link EvaluationVisitor}.
     *  
     * @param cst the constraint to be evaluated
     * @return the rewritten constraint if needed, <code>cst</code> else
     */
    public ConstraintSyntaxTree visit(ConstraintSyntaxTree cst) {
        ConstraintSyntaxTree tmp = cst;
        tmp.accept(finder);

        Iterator<AbstractVariable> staticIter = finder.getResults();
        if (staticIter.hasNext()) {
            // group the iterators in order to avoid unnecessary quantors
            // bind the free variables by quantors, consider self
            tmp = bindFreeVarsByQuantors(tmp, groupQuantors(staticIter));
        } else if (null != finder.getSelf()) {
            // the case if there is only self in the expression
            IDatatype type = finder.getSelf().getType();
            Value allInstances = context.getAllInstances(type);
            if (allInstances instanceof ContainerValue) {
                Container cont = (Container) allInstances.getType();
                DecisionVariableDeclaration iter = new DecisionVariableDeclaration("iter", cont.getContainedType(), 
                    null);
                selfVars.add(iter);
                tmp = new ContainerOperationCall(new ConstantValue(allInstances), Container.FORALL.getName(), 
                    tmp, iter);
                try {
                    tmp.inferDatatype();
                } catch (CSTSemanticException e) {
                    tmp = null;
                }
            } else {
                error("Cannot determine all instances for " + IvmlDatatypeVisitor.getQualifiedType(type));
            }
        }
        finder.clear();
        if (null != tmp) {
            cst = tmp;
            cst.accept(this);
        }
        return cst;
    }

    /**
     * Turns the statically accessed variables into groups of variables belonging to the same compound.
     * These groups will then be bound by the same quantor (iterator).
     * 
     * @param staticIter the iterator providing access to the statically accessed variables
     * @return a mapping of compound types to used variables forming the quantor groups
     */
    private static Map<IDatatype, List<AbstractVariable>> groupQuantors(Iterator<AbstractVariable> staticIter) {
        Map<IDatatype, List<AbstractVariable>> iterGroups 
            = new HashMap <IDatatype, List<AbstractVariable>>();
        while (staticIter.hasNext()) {
            AbstractVariable var = staticIter.next();
            Compound declaring = getDeclaringCompound(var);
            if (null != declaring) {
                List<AbstractVariable> group = iterGroups.get(declaring);
                if (null == group) {
                    group = new ArrayList<AbstractVariable>();
                    iterGroups.put(declaring, group);
                }
                group.add(var);
            }
        }
        return iterGroups;
    }

    /**
     * Implements a variable replacer.
     * 
     * @author Holger Eichelberger
     */
    private static class VariableReplacer implements IVariableReplacer {

        private Variable iter;
        private List<AbstractVariable> decls;

        /**
         * Creates a variable replacer.
         * 
         * @param iter the iter declaration to be replaced
         * @param decls the replacing declarations
         */
        private VariableReplacer(DecisionVariableDeclaration iter, List<AbstractVariable> decls) {
            this.iter = new Variable(iter);
            this.iter.inferDatatype();
            this.decls = decls;
        }
        
        @Override
        public IVariable map(IVariable variable) {
            return null;
        }

        @Override
        public ConstraintSyntaxTree mapLeaf(Variable variable) {
            ConstraintSyntaxTree result = null;
            AbstractVariable var = variable.getVariable();
            for (int i = 0; null == result && i < decls.size(); i++) { // put into map???
                if (decls.get(i) == var) {
                    result = new CompoundAccess(iter, var.getName());
                }
            }
            return result;
        }
        
    }
    
    /**
     * Binds the free variables by one quantor per quantor group.
     * 
     * @param cst the constraint to be quantorized/bound
     * @param quantorGroups the quantor groups as determined by {@link #groupQuantors(Iterator)}
     * @return the resulting rewritten constraint (may be <b>null</b> if errors occcurred)
     */
    private ConstraintSyntaxTree bindFreeVarsByQuantors(ConstraintSyntaxTree cst, 
        Map<IDatatype, List<AbstractVariable>> quantorGroups) {
        Iterator<Map.Entry<IDatatype, List<AbstractVariable>>> groupIter 
            = quantorGroups.entrySet().iterator();
        while (null != cst && groupIter.hasNext()) {
            Map.Entry<IDatatype, List<AbstractVariable>> entry = groupIter.next();
            IDatatype eType = entry.getKey();
            Value allInstances = context.getAllInstances(eType);
            IDatatype type;
            if (allInstances instanceof ContainerValue) {
                type = ((Container) allInstances.getType()).getContainedType();
            } else {
                type = new Reference("", eType, null);
            }
            List<AbstractVariable> group = entry.getValue();
            DecisionVariableDeclaration iter = null;
            iter = new DecisionVariableDeclaration("iter", type, null);
            selfVars.add(iter);
            CopyVisitor cVis = new CopyVisitor(new VariableReplacer(iter, group));
            cst.accept(cVis);
            cst = cVis.getResult();
            if (null != cst && null != allInstances) {
                try {
                    cst = new ContainerOperationCall(new ConstantValue(allInstances), Container.FORALL.getName(), 
                        cst, iter);
                    cst.inferDatatype();
                } catch (CSTSemanticException e) {
                    cst = null;
                }
            } else {
                error("Cannot determine all instances for " + IvmlDatatypeVisitor.getQualifiedType(type));
            }
        }
        return cst;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        Value constValue = value.getConstantValue();
        /*if (constValue instanceof ReferenceValue) { // dereference if valueExpression
            ReferenceValue ref = (ReferenceValue) constValue;
            if (null != ref.getValueEx()) {
                ref.getValueEx().accept(this); // -> leads to result
                if (null != result) {
                    constValue = result.getReferenceValue();
                    clearResult();
                }
            }
        } 
        // constants must not be changed, at least original constants :o
        Value cVal = constValue.clone();
        result = ConstantAccessor.POOL.getInstance().bind(cVal, context);
        */
        constValue.accept(constantResolver);
        Value resolvedValue = constantResolver.getValue();
        if (null != resolvedValue) {
            // constants must not be changed, at least original constants :o
            if (resolvedValue == constValue) {
                resolvedValue = resolvedValue.clone();
            }
            result = ConstantAccessor.POOL.getInstance().bind(resolvedValue, context);
        } else {
            result = null; // failure
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        ConstraintSyntaxTree qualifier = variable.getQualifier();
        if (null != qualifier) {
            // special case: attributes -> find attribute decision variable
            IDecisionVariable attribute = null;
            qualifier.accept(this);
            if (null != result) {
                IDecisionVariable var = result.getVariable();
                if (null != var) {
                    boolean byName = isFreezeVariable(qualifier);
                    attribute = findAttribute(var, variable.getVariable(), byName);
                    if (null == attribute && !byName) { // give rise to direct match, but try for project/nested attribs
                        attribute = findAttribute(var, variable.getVariable(), true);
                    }
                } // the project does only define the name rather than the attributes
            }
            clearResult();
            // shall not be null if model is valid
            result = VariableAccessor.POOL.getInstance().bind(attribute, context);
        } else {
            result = VariableAccessor.POOL.getInstance().bind(variable.getVariable(), context);
        }
    }
    
    /**
     * Finds an attribute decision variable for the given decision variable and attribute declaration.
     * 
     * @param var the variable to search the decision variable for
     * @param decl the attribute declaration
     * @param byName compare by name or by declaration
     * @return the attribute decision variable or <b>null</b> if not found
     */
    private static IDecisionVariable findAttribute(IDecisionVariable var, AbstractVariable decl, boolean byName) {
        IDecisionVariable result = null;
        if (null != var) {
            for (int a = 0, n = var.getAttributesCount(); null == result && a < n; a++) {
                IDecisionVariable attribute = var.getAttribute(a);
                if (byName && attribute.getDeclaration().getName().equals(decl.getName())) {
                    result = attribute;
                } else if (!byName && attribute.getDeclaration().equals(decl)) {
                    result = attribute;
                }
            }
        }
        return result;
    }
    
    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
        // nothing to do
    }

    /**
     * Evaluates the given custom operation.
     * 
     * @param operation the operation to be evaluated
     * @param operand the call operand (may be <b>null</b>; if not, added to parameters)
     * @param args the call arguments
     */
    private void evaluateCustomOperation(CustomOperation operation, EvaluationAccessor operand, 
        EvaluationAccessor[] args) {
        if (null != operand) {
            EvaluationAccessor[] tmp = new EvaluationAccessor[args.length + 1];
            tmp[0] = operand;
            System.arraycopy(args, 0, tmp, 1, args.length);
            args = tmp;
        } 
        if (args.length == operation.getParameterCount()) {
            LocalConfiguration cfg = new LocalConfiguration();
            context.pushLevel(cfg);
            for (int a = 0; a < args.length; a++) {
                LocalDecisionVariable argument = new LocalDecisionVariable(operation.getParameterDeclaration(a), 
                    context, args[a].getVariable());
                try {
                    argument.setValue(args[a].getValue(), AssignmentState.ASSIGNED);
                } catch (ConfigurationException e) {
                    exception(e);
                }
                cfg.addDecision(argument);
            }
            if (!operation.isStatic()) {
                CustomOperation dyn = dynamicDispatch(operation, args);
                if (dyn != operation) { // no equals defined
                    cfg.rebind(operation, dyn);
                    operation = dyn;
                }
            }
            operation.getFunction().accept(this);
            context.popLevel();
        } else {
            error("argument and operation count do not match");
        }
    }
    
    /**
     * Handles an {@link BooleanType#AND} operation. Should evaluate special situations like
     * <code>undef AND false</code> to <code>false</code>.
     * @param operand The operand of the AND operation. The operand should already been visited.
     * @param parameter The first parameter of the AND operation.
     * @return <tt>true</tt> the operation was evaluated successfully, <tt>false</tt> otherwise.
     */
    private boolean handleAND(EvaluationAccessor operand, ConstraintSyntaxTree parameter) {
        boolean hasBeenEvaluated = false;
        if (null != operand && operand.getValue() == BooleanValue.FALSE) {
            result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.FALSE, operand.getContext());
            hasBeenEvaluated = true;
        } else if (null != operand && null != parameter) {
            parameter.accept(this);
            if (null != result && result.getValue() == BooleanValue.FALSE) {
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.FALSE, operand.getContext());
                hasBeenEvaluated = true;
            }
        }
        return hasBeenEvaluated;
    }
    
    /**
     * Handles an {@link BooleanType#OR} operation. Should evaluate special situations like
     * <code>undef OR true</code> to <code>true</code>.
     * @param operand The operand of the OR operation. The operand should already been visited.
     * @param parameter The first parameter of the OR operation.
     * @return <tt>true</tt> the operation was evaluated successfully, <tt>false</tt> otherwise.
     */
    private boolean handleOR(EvaluationAccessor operand, ConstraintSyntaxTree parameter) {
        boolean hasBeenEvaluated = false;
        if (null != operand && operand.getValue() == BooleanValue.TRUE) {
            result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, operand.getContext());
            hasBeenEvaluated = true;
        } else if (null != operand && null != parameter) {
            parameter.accept(this);
            if (null != result && result.getValue() == BooleanValue.TRUE) {
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, operand.getContext());
                hasBeenEvaluated = true;
            }
        }
        return hasBeenEvaluated;
    }

    /**
     * Creates a string of <code>count</code> spaces. (debugging)
     * 
     * @param count the number of spaces
     * @return the string
     */
    protected String createSpaces(int count) {
        String res = "";
        for (int i = 1; i <= count; i++) {
            res += " ";
        }
        return res;
    }
    
    /**
     * Returns whether an OCL feature call shall be evaluated.
     * 
     * @param call the specific call to consider
     * @return <code>true</code> if the call shall be evaluated, <code>false</code> else
     */
    private boolean evaluateOclFeatureCall(OCLFeatureCall call) {
        return !assignmentsOnly 
            || assignmentsOnly && (opNesting > 0 || OclKeyWords.ASSIGNMENT.equals(call.getOperation()));
    }
    
    /**
     * Encapsulates a null context (some of the model test cases.
     * 
     * @param op the operation to consider
     * @param allow the new state of the allow flag
     * @return the old state of the allow flag
     */
    private boolean setAllowPropagation(Operation op, boolean allow) {
        boolean result = true; // recent default
        if (null != context) {
            result = context.setAllowPropagation(op, allow);
        }
        return result;
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (evaluateOclFeatureCall(call)) {
            opNesting++;
            EvaluationAccessor operand;
            Operation op = call.getResolvedOperation();
            if (null != call.getOperand()) {               
                boolean oldState = setAllowPropagation(op, false);
                call.getOperand().accept(this);
                operand = result;
                result = null; // clear result - kept in operand and released below
                setAllowPropagation(op, oldState); 
            } else {
                operand = null; // custom operation
            }
            EvaluationAccessor[] args = new EvaluationAccessor[call.getParameterCount()];
            boolean allOk = true;
            if (op == BooleanType.AND) { // Handle "short cuts", e.g., undef or true -> true
                allOk = !handleAND(operand, call.getParameter(0));
            } else if (op == BooleanType.OR) {
                allOk = !handleOR(operand, call.getParameter(0));
            } else if (op == ConstraintType.ASSIGNMENT) {
                result = ConstraintOperations.handleConstraintAssignment(operand, call.getParameter(0));
                allOk = false; // constraints need the constraint assigned rather than its evaluation
            } else if (op == ConstraintType.EQUALS || op == ConstraintType.UNEQUALS) {
                result = ConstraintOperations.handleConstraintEquals(operand, call.getParameter(0), op);
                allOk = false; // constraints need the constraint assigned rather than its evaluation (propagate)
            }         
            for (int a = 0; allOk && a < args.length; a++) {
                if (op == BooleanType.IMPLIES && (null == operand || BooleanValue.FALSE.equals(operand.getValue())) ) {
                    result = null == operand ? null 
                        : ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, context);
                    allOk = false; // Everything is ok, but no further processing shall be taken place ;-)
                } else {
                    call.getParameter(a).accept(this);
                    if (null == result && op.acceptsNull()) { // evaluators must assure to work with that -> isDefined
                        result = ConstantAccessor.POOL.getInstance().bind(null, context); 
                    }
                    args[a] = result;
                    if (null == result) {
                        allOk = false; // no message as arguments may be undefined
                    } 
                    result = null; // clear result - kept in args and released below
                }
            }
            if (allOk) {
                if (op instanceof CustomOperation) {
                    evaluateCustomOperation((CustomOperation) op, operand, args);
                } else {
                    IOperationEvaluator evaluator = getOperationEvaluator(op);
                    if (null == evaluator) {
                        String name = null != op ? op.getName() : call.getOperation();
                        notImplementedError(name);
                    } else {
                        if (null != operand) {
                            result = evaluator.evaluate(operand, args);
                        }
                    }
                }
                if (null == operand && null != result) { // special isDefined situation
                    result.validateContext(context);
                }
            }
            if (null != operand) {
                operand.release();
            }
            release(args);
            opNesting--;
            recordIfFailed(call);
        }
    }
    
    /**
     * Records a constraint syntax tree if it failed.
     * 
     * @param cst the syntax tree to record
     */
    private void recordIfFailed(ConstraintSyntaxTree cst) {
        if (null != result) {
            Value value = result.getValue();
            if (value instanceof BooleanValue) {
                if (Boolean.FALSE == ((BooleanValue) value).getValue()) {
                    if (null == innermostFailed) {
                        innermostFailed = cst;
                    }
                }
            }
        }
    }

    /**
     * Releases a bunch of accessors.
     * 
     * @param accessors the accessors to be released
     */
    private static void release(EvaluationAccessor[] accessors) {
        for (int a = 0; a < accessors.length; a++) {
            if (null != accessors[a]) {
                accessors[a].release();
            }
        }
    }
    
    /**
     * Stores dispatch information for dynamically dispatching a custom operation.
     * 
     * @author Holger Eichelberger
     */
    private static class DispatchInformation {
        private CustomOperation operation;
        private IDatatype[] argTypes;
        private int bestDiff;
        private CustomOperation bestMatch;
        private Set<String> candidates;
        private Set<Project> doneProjects;
        private String opName;
        private int opParamCount;
        private IDatatype returnType;
        
        /**
         * Creates a dispatch information object.
         * 
         * @param operation the operation to dispatch
         * @param args the operation arguments
         */
        private DispatchInformation(CustomOperation operation, EvaluationAccessor[] args) {
            this.operation = operation;
            opName = operation.getName();
            opParamCount = operation.getParameterCount();
            returnType = operation.getReturns();
            argTypes = new IDatatype[args.length];
            for (int a = 0, n = args.length; a < n; a++) {
                Value val = args[a].getValue();
                if (null != val) {
                    // use actual type with precedence
                    argTypes[a] = val.getType();
                } else if (args[a].getVariable() != null) {
                    // Use declaration to get type if it's a variable
                    argTypes[a] = args[a].getVariable().getDeclaration().getType();
                }
            }

            bestMatch = operation;
            bestDiff = calculateDiff(operation, returnType, argTypes);
            candidates = new HashSet<String>();
            candidates.add(operation.getSignature());
            doneProjects = new HashSet<Project>();
        }

        /**
         * Returns the best matching operation.
         * 
         * @return the best matching operation
         */
        private CustomOperation getBestMatch() {
            return bestMatch;
        }

        /**
         * Checks the given scope for dispatch candidates.
         * 
         * @param scope the scope to check for
         */
        private void checkForDispatch(Project scope) {
            if (!doneProjects.contains(scope)) {
                doneProjects.add(scope);
                for (int o = 0, n = scope.getOperationCount(); bestDiff > 0 && o < n; o++) {
                    CustomOperation tmp = scope.getOperation(o);
                    if (tmp != operation && opName.equals(tmp.getName()) && opParamCount == tmp.getParameterCount()) {
                        String tmpSignature = tmp.getSignature();
                        if (!candidates.contains(tmpSignature)) {
                            int diff = calculateDiff(tmp, returnType, argTypes);
                            if (diff < 0) {
                                continue;
                            }
                            candidates.add(tmpSignature);
                            if (diff < bestDiff) {
                                bestMatch = tmp;
                                bestDiff = diff;
                            }
                        }
                    }
                }
                for (int i = 0, n = scope.getImportsCount(); bestDiff > 0 && i < n; i++) {
                    Project imp = scope.getImport(i).getResolved();
                    if (null != imp) {
                        checkForDispatch(imp);
                    }
                }
            }
        }
        
    }
    
    /**
     * Performs a dynamic dispatch of <code>operation</code> according to the given actual arguments in 
     * <code>args</code>, i.e., this method searches and returns a method that fits better to the actual
     * arguments then the statically bound operation.
     * 
     * @param operation the operation to be dispatched
     * @param args the actual arguments
     * @return the best fitting operation
     */
    private CustomOperation dynamicDispatch(CustomOperation operation, EvaluationAccessor[] args) {
        CustomOperation result;
        if (null != dispatchScope) {
            DispatchInformation info = new DispatchInformation(operation, args);
            info.checkForDispatch(dispatchScope);
            result = info.getBestMatch();
        } else {
            result = operation;
        }
        return result;
    }
    
    /**
     * Returns the difference of the operations in terms of different (assignable) types.
     * 
     * @param operation the candidate operation for dispatch
     * @param returns the return type of the operation to be dispatched (for checking)
     * @param argTypes the actual argument types
     * @return the difference, <code>0</code> in case of signature equality, <code>-1</code> if the signature
     *   does not match the required types, a the number of assignable (not equal) types else
     */
    private static int calculateDiff(CustomOperation operation, IDatatype returns, IDatatype[] argTypes) {
        int diff = diff(returns, operation.getReturns()); // if no match -1
        if (diff >= 0) {
            for (int a = 0, n = argTypes.length; diff >= 0 && a < n; a++) {
                int tmp = diff(operation.getParameter(a).getType(), argTypes[a]);
                if (tmp < 0) {
                    diff = -1;
                } else {
                    diff += tmp;
                }
            }
        }
        return diff;        
    }
    
    /**
     * Returns the difference indicator between two types.
     * 
     * @param opType the operation type
     * @param paramType the parameter type
     * @return <code>0</code> in case of type equality, <code>-1</code> if the signature
     *   does not match the required types, <code>1</code> in case of assignable (not equal) types else
     */
    private static int diff(IDatatype opType, IDatatype paramType) {
        int result = -1;
        if (opType.isAssignableFrom(paramType)) {
            if (paramType.isAssignableFrom(opType)) {
                result = 0; // both are equal
            } else {
                result = 1; // actually, there is a distance
                if (Compound.TYPE.isAssignableFrom(paramType)) {
                    // in case of compounds, also consider the distance to the refined types so that not only
                    // direct matches but also intermediary refined types can be specified
                    Compound iter = (Compound) paramType;
                    while (null != iter && !TypeQueries.sameTypes(iter, opType)) {
                        result++;
                        iter = iter.getRefines();
                    }
                }
                if (Container.TYPE.isAssignableFrom(opType) && Container.TYPE.isAssignableFrom(paramType)) {
                    // in case of container, also take the generic types into account 
                    result = diffContainer((Container) opType, (Container) paramType);
                }
            }
        }
        if (result != 0 && paramType instanceof Reference) {
            result = diff(opType, Reference.dereference(paramType));
        }
        return result;
    }
    
    /**
     * Returns the difference of container types in terms of assignable types.
     * 
     * @param opCont the container from the operation signature
     * @param paramCont the parameter / argument container type allowed to iterate to compare refined types
     * @return the difference, <code>-1</code> in case of a type mismatch
     */
    private static int diffContainer(Container opCont, Container paramCont) {
        int result = 0;
        // the container difference is not relevant as container is not a visible type in IVML 
        int opContGen = opCont.getGenericTypeCount();
        int paramContGen = paramCont.getGenericTypeCount();
        if (opContGen != paramContGen) {
            result = -1;
        } else {
            for (int i = 0; i < opContGen; i++) {
                int tmp = diff(opCont.getGenericType(i), paramCont.getGenericType(i));
                if (tmp < 0) {
                    result = -1;
                    break;
                } else {
                    result += tmp;
                }
            }
        }
        return result;
    }

    @Override
    public void visitLet(Let let) {
        clearResult();
        LocalConfiguration cfg = new LocalConfiguration();
        context.pushLevel(cfg);
        addLocalVariable(cfg, let.getVariable(), let.getInitExpression()); // shall not be reassignable
        let.getInExpression().accept(this);
        context.popLevel();
    }

    /**
     * Adds a new local decision variable based on <code>decl</code> to <code>cfg</code>.
     * 
     * @param cfg the local configuration to add the new variable
     * @param decl the variable declaration
     * @param initEx the explicitly given initialization expression, may be <b>null</b> then
     *     this method considers the default value of <code>decl</code>
     * @return the created local variable
     */
    private LocalDecisionVariable addLocalVariable(LocalConfiguration cfg, DecisionVariableDeclaration decl, 
        ConstraintSyntaxTree initEx) {
        Value value = null;
        IDecisionVariable parent = null;
        if (null == initEx) {
            initEx = decl.getDefaultValue();
        }
        if (null != initEx) {
            initEx.accept(this);
            if (null != result) {
                value = result.getValue();
                parent = result.getVariable();
                clearResult();
            }
        }
        
        LocalDecisionVariable var = new LocalDecisionVariable(decl, context, parent);
        cfg.addDecision(var);
        if (null != value) {
            try {
                var.setValue(value, AssignmentState.DEFAULT);
            } catch (ConfigurationException e) {
                exception(e);
            }
        }
        return var;
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        EvaluationAccessor resultBefore = result;
        boolean oldState = setAllowPropagation(null, false);
        ifThen.getIfExpr().accept(this);
        setAllowPropagation(null, oldState);
        if (null != result) {
            boolean isFulfilled = constraintFulfilled();
            clearResult();
            if (isFulfilled) {
                EvaluationAccessor.release(resultBefore);
                ifThen.getThenExpr().accept(this);
            } else if (null != ifThen.getElseExpr()) {
                EvaluationAccessor.release(resultBefore);
                ifThen.getElseExpr().accept(this);
            } else {
                result = resultBefore;
            }
        }
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        if (!assignmentsOnly) {
            opNesting++;
            clearResult(); // throw away old result as in body the result of this operation will supersede
            Operation operation = call.getResolvedOperation();
            IIteratorEvaluator evaluator = getIteratorEvaluator(operation);
            if (null != evaluator) {
                boolean ok = true;
                LocalConfiguration cfg = new LocalConfiguration();
                context.pushLevel(cfg);
                
                // prepare the variables; apply has an explicit result declarator, others have an implicit result 
                // variable the other declarators are the iterators - we may have multi-dimensional cross-products
                int lastIteratorIndex = call.getDeclaratorsCount();
                DecisionVariableDeclaration resultDecl;
                if (Container.APPLY == operation) {
                    // the last declarator is the result
                    lastIteratorIndex--;
                    resultDecl = call.getDeclarator(lastIteratorIndex);
                } else {
                    // result is implicit
                    IDatatype type;
                    try {
                        type = call.inferDatatype();
                    } catch (CSTSemanticException e) {
                        type = AnyType.TYPE; // shall not happen as model is type-valid
                        exception(e);
                        ok = false;
                    }
                    resultDecl = new DecisionVariableDeclaration(LocalDecisionVariable.ITERATOR_RESULT_VARNAME, type, 
                        call.getParent());
                    try {
                        resultDecl.setValue(evaluator.getStartResult(type));
                    } catch (ValueDoesNotMatchTypeException e) {
                        exception(e);
                        ok = false;
                    }
                }
                // prepare the declarators representing the iterators
                VariableAccessor resultVar = VariableAccessor.POOL.getInstance()
                    .bind(addLocalVariable(cfg, resultDecl, null), context, true);
                LocalDecisionVariable[] declarators = new LocalDecisionVariable[lastIteratorIndex];
                for (int d = 0; ok && d < declarators.length; d++) {
                    declarators[d] = addLocalVariable(cfg, call.getDeclarator(d), null);
                }

                if (ok) {
                    ok = executeContainerIteration(call, declarators, resultVar, evaluator);
                }
    
                context.popLevel();
                // resultVar would be a variable, result of iteration is a constant!
                if (ok) {
                    result = ConstantAccessor.POOL.getInstance().bind(resultVar.getValue(), context);
                } else {
                    result = null;
                }
                resultVar.release();
            } else {
                result = null;
            }
            opNesting--;
            recordIfFailed(call);
        }
    }
    
    /**
     * Initialize the container iterators for a container iteration.
     * 
     * @param container the actual container to iterate over
     * @param containers the containers to be assigned to the declarators
     * @param declarators the declarators
     * @return <code>true</code> if initialization was successful, <code>false</code> else
     */
    private boolean initialize(ContainerValue container, ContainerValue[] containers, 
        LocalDecisionVariable[] declarators) {
        boolean ok = true;
        // initialize the actual container values
        for (int c = 0; c < containers.length; c++) {
            Value val = declarators[c].getValue();
            if (val instanceof ContainerValue) {
                containers[c] = (ContainerValue) val;
                ok = containers[c] != null;
            } else if (null == val || val == NullValue.INSTANCE) {
                containers[c] = container;
                ok = containers[c] != null;
            } else {
                error("declarator " + declarators[c].getDeclaration().getName() 
                    + " does not provide a container value");
                ok = false;
            }
        }
        return ok;
    }
    
    /**
     * Executes the container iteration.
     * 
     * @param call the container operation call to be executed
     * @param declarators the declarators of the call in terms of decision variables
     * @param resultVar the result variable to be modified as a side effect during the iteration (result aggregation)
     * @param evaluator the evaluator corresponding to <code>call</code> (may be <b>null</b> in case of an apply 
     *     operation)
     * @return <code>true</code> if successful, <code>false</code> if unevaluated
     */
    private boolean executeContainerIteration(ContainerOperationCall call, LocalDecisionVariable[] declarators, 
        VariableAccessor resultVar, IIteratorEvaluator evaluator) {
        boolean ok = true;
        call.getContainer().accept(this);
        if (null != result) {
            ContainerValue container = (ContainerValue) result.getValue();
            clearResult();
            ContainerValue[] containers = new ContainerValue[declarators.length];
            ok = initialize(container, containers, declarators);
            // iterate over inner iterator again and again until all outer iterators are done
            int[] pos = new int[declarators.length];
            Map<Object, Object> data = new HashMap<Object, Object>();
            while (ok && null != containers[0] && pos[0] < containers[0].getElementSize()) {
                int iter = pos.length - 1;
                ContainerValue iterator = containers[iter];
                boolean setSelf = selfVars.contains(declarators[iter].getDeclaration());
                int maxIter = iterator.getElementSize();
                for (pos[iter] = 0; ok && pos[iter] < maxIter; pos[iter]++) {
                    Value iterVal = iterator.getElement(pos[iter]);
                    if (setSelf) { // for now only inner...
                        selfValue = iterVal;
                    }
                    try {
                        declarators[iter].setValue(iterVal, AssignmentState.ASSIGNED);
                    } catch (ConfigurationException e) {
                        ok = containerException(e);
                    }
                    call.getExpression().accept(this);      
                    if (null != result && null != result.getValue()) {
                        try {
                            boolean stop = evaluator.aggregate(resultVar, iterVal, result, data);
                            clearResult();
                            if (stop) {
                                pos[iter] = maxIter; // break -> endless loop
                            }
                        } catch (ValueDoesNotMatchTypeException e) {
                            ok = containerException(e);
                        }
                    } else {
                        ok = false;
                    }
                }
                selfValue = null;
                data.clear();
                iter--;
                boolean propagate = true; // propagate loop end through other iterators
                while (iter > 0 && propagate) {
                    pos[iter]++;
                    if (pos[iter] >= containers[iter].getElementSize()) {
                        pos[iter] = 0;
                    } else {
                        propagate = false;
                    }
                    try {
                        declarators[iter].setValue(iterator.getElement(pos[iter]), AssignmentState.ASSIGNED);
                    } catch (ConfigurationException e) {
                        ok = containerException(e);
                    }
                    if (propagate) {
                        iter--;
                    } else {
                        break;
                    }
                }
            }
        } else {
            ok = false;
        }
        return ok;
    }
    
    /**
     * Just a wrapper for container exceptions constantly returning <b>false</b>.
     * Calls {@link #exception(Throwable)}.
     * 
     * @param throwable the exception
     * @return <code>false</code>
     */
    private boolean containerException(Throwable throwable) {
        exception(throwable);
        return false;
    }
    
    /**
     * Returns whether <code>cst</code> is a freeze variable.
     * 
     * @param cst the cst to check
     * @return <code>true</code> if <code>cst</code> contains a freeze variable, <code>false</code> else
     */
    private boolean isFreezeVariable(ConstraintSyntaxTree cst) {
        boolean result = false;
        if (null != cst) {
            try {
                result = FreezeVariableType.TYPE.isAssignableFrom(cst.inferDatatype());
            } catch (CSTSemanticException e) {
            }
        }
        return result;
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        if (null != result) {
            String slotName = access.getSlotName();
            IDecisionVariable variable = result.getVariable();
            Value value = result.getValue();
            clearResult();
            if (value instanceof ReferenceValue) {
                // dereference first
                ReferenceValue refVal = (ReferenceValue) value;
                AbstractVariable decl = refVal.getValue(); 
                if (null == decl) {
                    ConstraintSyntaxTree ex = refVal.getValueEx();
                    if (null != ex) {
                        // determines result
                        ex.accept(this);
                    }
                    variable = null;
                } else {
                    variable = context.getDecision(decl);
                }
            }
            if (variable instanceof CompoundVariable) {
                result = CompoundSlotAccessor.POOL.getInstance().bind(variable, slotName, context);
            } else if (variable instanceof LocalDecisionVariable) {
                result = CompoundSlotAccessor.POOL.getInstance().bind((LocalDecisionVariable) variable, 
                    slotName, context);
            } else if (value instanceof CompoundValue) {
                // static qualified in compound
                CompoundValue cValue = (CompoundValue) value;
                Value nValue = cValue.getNestedValue(slotName);
                if (null != nValue) {
                    result = ConstantAccessor.POOL.getInstance().bind(nValue, context);
                }
            } else if (value instanceof MetaTypeValue) {
                // static qualified top
                IDatatype type = ((MetaTypeValue) value).getValue();
                value = context.bind(type);
                if (value instanceof CompoundValue) {
                    value = ((CompoundValue) value).getNestedValue(slotName);
                    if (null != value) {
                        result = ConstantAccessor.POOL.getInstance().bind(value, context);
                    }
                }
            } else {
                if (null == result) {
                    error("cannot evaluate compound");
                }
            }
            if (null != resolutionListener && null != result) {
                IDecisionVariable resVar = result.getVariable();
                if (null != resVar) {
                    resolutionListener.notifyResolved(variable, slotName, resVar);
                }
            }
            recordIfFailed(access);
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        clearResult();
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        Compound type = initializer.getType();
        Object[] values = new Object[2 + 2 * initializer.getSlotCount()];
        int pos = 0;
        values[pos++] = CompoundValue.SPECIAL_SLOT_NAME_TYPE;
        values[pos++] = type;
        boolean ok = true;
        for (int s = 0; ok && s < initializer.getSlotCount(); s++) {
            String slotName = initializer.getSlot(s);
            values[pos++] = slotName;
            DecisionVariableDeclaration decl = type.getElement(slotName);
            if (ConstraintType.TYPE.isAssignableFrom(decl.getType())) {
                try {
                    // do not evaluate a constraint value here - this is just a value as it is / deferred
                    // see StaticAccessFinder
                    values[pos++] = ValueFactory.createValue(ConstraintType.TYPE, initializer.getExpression(s));
                } catch (ValueDoesNotMatchTypeException e) {
                    error(e.getMessage());
                }
            } else {
                initializer.getExpression(s).accept(this);
                if (null == result) {
                    error("cannot evaluate compound slot '" + slotName + "' in type '" + type.getName() + "'");
                    ok = false;
                } else {
                    if (Reference.TYPE.isAssignableFrom(decl.getType())) {
                        values[pos++] = result.getReferenceValue();
                    } else {
                        values[pos++] = result.getValue();
                    }
                }
                clearResult();
            }
        }
        if (ok) {
            try {
                Value value = ValueFactory.createValue(initializer.getType(), values);
                result = ConstantAccessor.POOL.getInstance().bind(value, context);
            } catch (ValueDoesNotMatchTypeException e) {
                exception(e);
            }
        }
        recordIfFailed(initializer);
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        Object[] values = new Object[initializer.getExpressionCount()];
        boolean isConstraintCollection = Container.isContainer(initializer.getType(), ConstraintType.TYPE);
        boolean ok = true;
        boolean references = Reference.TYPE.isAssignableFrom(initializer.getType().getContainedType());
        for (int s = 0; ok && s < values.length; s++) {
            if (isConstraintCollection) {
                try {
                    // do not evaluate a constraint value here - this is just a value as it is / deferred
                    // See static access finder
                    values[s] = ValueFactory.createValue(ConstraintType.TYPE, initializer.getExpression(s));
                } catch (ValueDoesNotMatchTypeException e) {
                    error(e.getMessage());
                }
            } else {
                initializer.getExpression(s).accept(this);
                if (null == result) {
                    error("cannot evaluate container initializer expression '" + s + "'");
                    ok = false;
                } else {
                    if (references) {
                        values[s] = result.getReferenceValue();
                    } else {
                        values[s] = result.getValue();
                    }
                }
                clearResult();
            }
        }
        if (ok) {
            try {
                Value value = ValueFactory.createValue(initializer.getType(), values); 
                result = ConstantAccessor.POOL.getInstance().bind(value, context);
            } catch (ValueDoesNotMatchTypeException e) {
                exception(e);
            }
        }
        recordIfFailed(initializer);
    }
    
    @Override
    public void visitSelf(Self self) {
        if (null != selfValue) {
            result = ConstantAccessor.POOL.getInstance().bind(selfValue, context);
        } else {
            result = null;
        }
    }

    /**
     * Returns the operation evaluator for the given <code>operation</code>. This
     * method is intended to be overridden in case that other operations than the
     * default ones from the {@link EvaluatorRegistry} shall be used.
     * 
     * @param operation the operation to return the evaluator for
     * @return the operation evaluator (or <b>null</b> if none is known)
     */
    protected IOperationEvaluator getOperationEvaluator(Operation operation) {
        return EvaluatorRegistry.getOperationEvaluator(operation);
    }

    /**
     * Returns the iterator evaluator for the given <code>operation</code>. This
     * method is intended to be overridden in case that other operations than the
     * default ones from the {@link EvaluatorRegistry} shall be used.
     * 
     * @param operation the operation to return the evaluator for
     * @return the iterator evaluator (or <b>null</b> if none is known)
     */
    protected IIteratorEvaluator getIteratorEvaluator(Operation operation) {
        return EvaluatorRegistry.getIteratorEvaluator(operation);
    }
    
    /**
     * Returns the target state for a variable which is actually being
     * assigned. This method is intended to be overriden if state conflicts shall
     * be checked before assignment.
     * 
     * @param var variable
     * @return the target state for the variable, may be <b>null</b> if assignment is not permitted
     */
    protected IAssignmentState getTargetState(IDecisionVariable var) {
        IAssignmentState returnState = assignmentState;        
        return returnState;
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }
    
}
