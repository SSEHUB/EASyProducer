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
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ConfigurationInitializerRegistry;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
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
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.Operation.NestingMode;
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
import net.ssehub.easy.varModel.persistency.StringProvider;

import static net.ssehub.easy.varModel.cstEvaluation.EvaluationUtils.*;

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
public class EvaluationVisitor implements IConstraintTreeVisitor, IConstraintEvaluator {
    
    protected IAssignmentState assignmentState;
    // TRANSITION hack
    private final boolean modelCopy = ConfigurationInitializerRegistry.getInitializer().supportsElementCopy();
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
    private ContextStack contextStack = new ContextStack();

    /**
     * Implements the evaluation context. The context may contain nested local 
     * configurations in order to represent the nested (recursive) execution of 
     * operations defining parameters or local variables (let). Decision variables
     * are searched along this stack starting at the top.
     * 
     * @author Holger Eichelberger
     */
    private class EvaluationContextImpl extends EvaluationContext {

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
         * Resets this instance for reuse.
         * 
         * @param config the variability model configuration (outermost stack level)
         * @return <b>this</b>
         */
        EvaluationContextImpl reset(IConfiguration config) {
            pushLevel(config);
            return this;
        }

        /**
         * Clears this instance for reuse.
         */
        void clear() {
            configStack.clear();
            allowPropagation = true;
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
        public void notifyChangeListener(IDecisionVariable variable, Value value) {
            if (null != listener && null != variable) {
                listener.notifyChanged(variable, value);
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
        
        @Override
        public IAssignmentState getAssignmentState() {
            return assignmentState;
        }

    }
    
    /**
     * Extended Message class for saving variables that fail in assignments.
     * 
     * @author Sizonenko
     */
    public static class Message extends net.ssehub.easy.basics.messages.Message {

        public static final int CODE_UNSUPPORTED = 100;
        public static final int CODE_ASSIGNMENT_STATE = 101;
        public static final int CODE_RESOLUTION = 102;
        public static final int CODE_INDEX = 103;
        public static final int CODE_THROWABLE = 110;

        private IDecisionVariable var;
        private int code;
        
        /**
         * Main constructor.
         * 
         * @param description Description of why variable is saved.
         * @param status {@link Status} of the message.
         * @param var causing {@link IDecisionVariable} to be saved.
         * @param code the message code for detailing the problem
         */
        public Message(String description, Status status, IDecisionVariable var, int code) {
            super(description, status);
            this.var = var;
            this.code = code;
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
        
        /**
         * Returns the error/message code.
         * 
         * @return the code
         */
        public int getCode() {
            return code;
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
        this.context = null == this.context ? new EvaluationContextImpl(config) : this.context.reset(config);
        this.assignmentState = assignmentState;
        this.assignmentsOnly = assignmentsOnly;
        this.listener = listener;
    }
    
    /**
     * Allow changing the assignment state to do an 
     * {@link #init(IConfiguration, IAssignmentState, boolean, IValueChangeListener)}, a repeated evaluation with 
     * changing assignment state and finally a {@link #clear()} or {@link #clearResult()}.
     * 
     * @param assignmentState the state for the assignments (may be <b>null</b> if no assignment shall take place)
     */
    public void setAssignmentState(IAssignmentState assignmentState) {
        this.assignmentState = assignmentState;
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
     * Defines the current (optional) value change listener listener.
     *  
     * @param listener the listener (may be <b>null</b> to indicate that no listener is required)
     */
    public void setValueChangeListener(IValueChangeListener listener) {
        this.listener = listener;
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
     * Clears the visitor for reuse (including the dispatch scope and the context).
     * 
     * @see #clearIntermediary()
     */
    public void clear() {
        clearIntermediary();
        if (null != context) { // some test cases do not cause a context creation :|
            context.clear();
        }
        dispatchScope = null;
    }
    
    /**
     * Clears intermediary state information including {@link #clearResult() result}, 
     * assignment state, messages, warnings, failed and selfVars. Call at least
     * {@link #setAssignmentState(IAssignmentState)} to reuse this instance.
     */
    public void clearIntermediary() {
        clearResult();
        assignmentState = null;
        messages.clear();
        selfVars.clear();
        selfValue = null;
        issueWarning = false;
        innermostFailed = null;
        contextStack.clear();
    }
    
    /**
     * Clears the result. Does not clear the context stack, which may contain frames in case of evaluation problems.
     */
    public void clearResult() {
        if (null != result) {
            result.release();
            result = null;
        }
    }
    
    // ------------------------------- result handling -------------------------------

    @Override
    public Value getResult() {
        Value result = null;
        if (null != this.result) {
            result = this.result.getValue(); 
        }
        return result;
    }
    
    /**
     * Returns the result variable.
     * 
     * @return may be <b>null</b> in case of an expression that cannot be evaluated (shall lead to an exception)
     */
    public IDecisionVariable getResultVariable() {
        IDecisionVariable result = null;
        if (null != this.result) {
            result = this.result.getVariable();
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
     * Defines the result accessor and overrides an existing accessor. Please use with care. This part takes over the 
     * responsibility for releasing the accessor.
     * 
     * @param result the new result accessor (may be <b>null</b> for none)
     */
    protected void setResultAcessor(EvaluationAccessor result) {
        this.result = result;
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

    @Override
    public boolean constraintFulfilled() {
        return constraintFulfilled(result != null ? result.getValue() : null);
    }

    @Override
    public boolean constraintFailed() {
        return constraintFailed(result != null ? result.getValue() : null);
    }

    @Override
    public boolean constraintUndefined() {
        return constraintUndefined(result != null ? result.getValue() : null);
    }
    
    @Override
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
     * @param code the message code
     */
    private void error(String text, int code) {
        addMessage(new Message(text, Status.ERROR, null, code));
    }
    
    /**
     * Adds a not implemented error message.
     * 
     * @param subject the subject that is not implemented
     */
    private void notImplementedError(String subject) {
        addMessage(new Message("cannot evaluate " + subject + " as it is currently not implemented", 
            Status.UNSUPPORTED, null, Message.CODE_UNSUPPORTED));
    }
    
    /**
     * Adds a throwable as error message.
     * 
     * @param th the throwable
     */
    private void exception(Throwable th) {
        error(th.getMessage(), Message.CODE_THROWABLE);
    }

    @Override
    public int getMessageCount() {
        return messages.size();
    }
    
    @Override
    public Message getMessage(int index) {
        return messages.get(index);
    }
    
    // --------------------------- visitor ----------------------------
    
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
                tmp = null;
                error("Cannot determine all instances for " + IvmlDatatypeVisitor.getQualifiedType(type), 
                    Message.CODE_RESOLUTION);
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
                cst = null;
                error("Cannot determine all instances for " + IvmlDatatypeVisitor.getQualifiedType(type), 
                    Message.CODE_RESOLUTION);
            }
        }
        return cst;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        Value constValue = value.getConstantValue();
        constValue.accept(constantResolver);
        Value resolvedValue = constantResolver.getValue();
        if (null != resolvedValue) {
            // constants must not be changed, at least original constants :o
            if (resolvedValue == constValue) {
                resolvedValue = resolvedValue.clone();
            }
            result = ConstantAccessor.POOL.getInstance().bind(resolvedValue, true, context);
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
            if (null != attribute) { // fallback -> local vars
                clearResult();
                // shall not be null if model is valid
                result = VariableAccessor.POOL.getInstance().bind(attribute, context);
            }
        } else {
            IDecisionVariable resolved = variable.getResolved();
            if (null != resolved) { // temporary resolution, variable is known
                result = VariableAccessor.POOL.getInstance().bind(resolved, context);
            } else {
                result = VariableAccessor.POOL.getInstance().bind(variable.getVariable(), context);
            }
        }
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
            int dec = 0;
            // due to potential named parameters, args may be longer and contain nulls at the end -> skip them
            while (args.length - 1 - dec >= 0 && null == args[args.length - 1 - dec]) {
                dec++;
            }
            EvaluationAccessor[] tmp = new EvaluationAccessor[args.length + 1 - dec];
            tmp[0] = operand;
            System.arraycopy(args, 0, tmp, 1, args.length - dec);
            args = tmp;
        } 
        if (args.length == operation.getParameterCount()) {
            LocalConfiguration cfg = new LocalConfiguration();
            context.pushLevel(cfg);
            boolean allOk = true;
            for (int a = 0; allOk && a < args.length; a++) {
                if (args[a] != null) { // may occur in temporary compound accessor evaluations, not detected before
                    LocalDecisionVariable argument = new LocalDecisionVariable(operation.getParameterDeclaration(a), 
                        context, args[a].getVariable());
                    try {
                        argument.setValue(args[a].getValue(), AssignmentState.ASSIGNED);
                    } catch (ConfigurationException e) {
                        exception(e);
                    }
                    cfg.addDecision(argument);
                } else {
                    allOk = false;
                }
            }
            if (allOk) {
                if (!operation.isStatic()) {
                    CustomOperation dyn = dynamicDispatch(operation, args);
                    if (dyn != operation) { // no equals defined
                        cfg.rebind(operation, dyn);
                        operation = dyn;
                    }
                }
                operation.getFunction().accept(this);
            }
            context.popLevel();
        } else {
            error("argument and operation count do not match", Message.CODE_RESOLUTION);
        }
    }
    
    /**
     * Handles an {@link BooleanType#AND}, {@link BooleanType#OR} or {@link BooleanType#XOR} operation. Should evaluate 
     * special situations like <code>undef OR true</code> to <code>true</code>. Dynamically changes evaluation sequence 
     * depending on {@link #containsIsDefined(ConstraintSyntaxTree)}.
     * 
     * @param operand The operand of the OR operation. The operand should already been visited.
     * @param call the call representing the OR operation
     * @return <tt>true</tt> the operation was evaluated successfully, <tt>false</tt> otherwise.
     */
    private boolean handleBinaryBoolean(EvaluationAccessor operand, OCLFeatureCall call) {
        boolean hasBeenEvaluated = false;
        Operation op = call.getResolvedOperation();
        EvaluationAccessor operandAccessor = operand;
        EvaluationAccessor parameterAccessor = null;
        ConstraintSyntaxTree parameter = call.getParameter(0);
        if (containsIsDefined(call.getOperand())) {
            if (null != parameter) { // if there is no parameter then no change in result
                // change evaluation sequence - may not help if both contains an isDefined
                parameterAccessor = getAccessor(parameterAccessor, parameter);
                // re-evaluate operand!
                operandAccessor = getAccessor(operandAccessor, call.getOperand());
            }
        }
        if (op == BooleanType.AND) {
            if (null != operandAccessor && operandAccessor.getValue() == BooleanValue.FALSE) {
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.FALSE, true, operand.getContext());
                hasBeenEvaluated = true;
            } else if (null != operand && null != parameter) {
                parameterAccessor = getAccessor(parameterAccessor, parameter);
                if (null != parameterAccessor && parameterAccessor.getValue() == BooleanValue.FALSE) {
                    result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.FALSE, true, operand.getContext());
                    hasBeenEvaluated = true;
                }
            }
        } else if (op == BooleanType.OR) {
            if (null != operandAccessor && operandAccessor.getValue() == BooleanValue.TRUE) {
                result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, true, operand.getContext());
                hasBeenEvaluated = true;
            } else if (null != operandAccessor && null != parameter) {
                parameterAccessor = getAccessor(parameterAccessor, parameter);
                if (null != parameterAccessor && parameterAccessor.getValue() == BooleanValue.TRUE) {
                    result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, true, operand.getContext());
                    hasBeenEvaluated = true;
                }
            }
        } else { // xor
            if (null != operandAccessor && null != parameter) {
                parameterAccessor = getAccessor(parameterAccessor, parameter);
                if (null != parameterAccessor) {
                    boolean xorRes = operand.getValue() == BooleanValue.TRUE ^ result.getValue() == BooleanValue.TRUE;
                    result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(xorRes), 
                        true, operand.getContext());
                    hasBeenEvaluated = true;
                }
            }
        }
        if (null != parameterAccessor) {
            parameterAccessor.release();
        }
        if (operandAccessor != operand) { // we have a temporary operand
            operandAccessor.release();
        }
        return hasBeenEvaluated;
    }
    
    /**
     * Returns an evaluation accessor for <code>expression</code> if <code>accessor</code> is not already determined.
     * 
     * @param accessor the accessor
     * @param expression the expression
     * @return the accessor, may be <b>accessor</b>, may be a new accessor, may be <b>null</b>. Must be released if not
     *   <b>null</b>
     */
    private EvaluationAccessor getAccessor(EvaluationAccessor accessor, ConstraintSyntaxTree expression) {
        EvaluationAccessor result = accessor;
        if (null == result) {
            expression.accept(this);
            result = this.result;
        }
        return result;
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
     * Encapsulates a null context (some of the model test cases).
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
    
    /**
     * Returns whether <code>constraint</code> somewhere contains/calls an isDefined operation.
     * Alternative would be constraint rewriting during parsing.
     * 
     * @param constraint the constraint
     * @return <code>true</code> if isDefined is somewhere used, <code>false</code> else
     */
    private boolean containsIsDefined(ConstraintSyntaxTree constraint) {
        boolean found;
        if (constraint instanceof OCLFeatureCall) {
            OCLFeatureCall call = (OCLFeatureCall) constraint;
            found = OclKeyWords.IS_DEFINED.equals(call.getOperation()); // we have several specific signatures
            if (!found) {
                found = containsIsDefined(call.getOperand());
                for (int p = 0; !found && p < call.getParameterCount(); p++) {
                    found = containsIsDefined(call.getParameter(p));
                }
            }
        } else {
            found = false;
        }
        return found;
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (evaluateOclFeatureCall(call)) {
            opNesting++;
            EvaluationAccessor operand;
            boolean pop = false;
            Operation op = call.getResolvedOperation();
            if (null != call.getOperand()) {               
                boolean oldState = setAllowPropagation(op, false);
                call.getOperand().accept(this);
                operand = result;
                result = null; // clear result - kept in operand and released below
                setAllowPropagation(op, oldState);
                if (IvmlKeyWords.ASSIGNMENT.equals(op.getName())) {
                    contextStack.push(operand);
                    pop = true;
                }
            } else {
                operand = null; // custom operation
            }
            EvaluationAccessor[] args = new EvaluationAccessor[op.getParameterCount()];
            boolean allOk = evaluateArguments(call, op, operand, args);
            if (allOk) {
                if (op instanceof CustomOperation) {
                    evaluateCustomOperation((CustomOperation) op, operand, args);
                } else {
                    IOperationEvaluator evaluator = getOperationEvaluator(op);
                    if (null == evaluator) {
                        notImplementedError(null != op ? op.getName() : call.getOperation());
                    } else if (null != operand) {
                        result = evaluator.evaluate(operand, args);
                    }
                }
                if (null == operand && null != result) { // special isDefined situation
                    result.validateContext(context);
                }
            }
            if (pop) {
                contextStack.pop();
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
     * Evaluates the arguments.
     * 
     * @param call the call
     * @param op the resolved operation
     * @param operand the operand
     * @param args the arguments (empty, size of number of parameters, modified as side effect)
     * @return <code>true</code> for successful, <code>false</code> else
     */
    private boolean evaluateArguments(OCLFeatureCall call, Operation op, EvaluationAccessor operand, 
        EvaluationAccessor[] args) {
        boolean allOk = true;
        if (op == BooleanType.AND || op == BooleanType.OR || op == BooleanType.XOR) { // Handle "short cuts"
            allOk = !handleBinaryBoolean(operand, call);
        } else if (op == ConstraintType.ASSIGNMENT) {
            result = ConstraintOperations.handleConstraintAssignment(operand, call.getParameter(0));
            allOk = false; // constraints need the constraint assigned rather than its evaluation
        } else if (op == ConstraintType.EQUALS || op == ConstraintType.UNEQUALS 
            || op == ConstraintType.UNEQUALS_ALIAS) {
            result = ConstraintOperations.handleConstraintEquals(operand, call.getParameter(0), 
                op != ConstraintType.EQUALS);
            allOk = false; // constraints need the constraint assigned rather than its evaluation (propagate)
        }
        Map<String, EvaluationAccessor> namedArgs = null;
        contextStack.push();
        for (int a = 0; allOk && a < op.getParameterCount(); a++) {
            contextStack.setVariable(op.getParameterDeclaration(a));
            if (op == BooleanType.IMPLIES && (null == operand || BooleanValue.FALSE.equals(operand.getValue())) ) {
                result = null == operand ? null 
                    : ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, true, context);
                allOk = false; // Everything is ok, but no further processing shall be taken place ;-)
            } else {
                String argName = null;
                if (a < call.getParameterCount()) {
                    call.getParameter(a).accept(this);
                    argName = call.getParameter(a).getName();
                } else if (null != op.getParameterDefaultValue(a)) {
                    op.getParameterDefaultValue(a).accept(this);
                } else {
                    result = null;
                    break;
                }
                if (null == result && op.acceptsNull()) {
                    if (op.acceptsNull()) { // evaluators must assure to work with that -> isDefined
                        result = ConstantAccessor.POOL.getInstance().bind(null, true, context);
                    }
                }
                if (argName != null) {
                    if (null == namedArgs) {
                        namedArgs = new HashMap<String, EvaluationAccessor>(); 
                    }
                    namedArgs.put(argName, result);
                } else {
                    args[a] = result;
                }
                if (null == result) {
                    allOk = false; // no message as arguments may be undefined
                } 
                result = null; // clear result - kept in args and released below
            }
        }
        contextStack.pop();
        if (allOk && null != namedArgs) {
            for (int a = 0; a < args.length; a++) {
                DecisionVariableDeclaration param = op.getParameterDeclaration(a);
                if (null != param) {
                    String paramName = param.getName();
                    EvaluationAccessor arg = namedArgs.get(paramName);
                    if (null != arg) {
                        args[a] = arg;
                    }
                }
            }
        }
        return allOk;
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

    @Override
    public void visitLet(Let let) {
        clearResult();
        LocalConfiguration cfg = new LocalConfiguration();
        context.pushLevel(cfg);
        // var shall not be reassignable
        LocalDecisionVariable lVar = addLocalVariable(cfg, let.getVariable(), let.getInitExpression(), true); 
        let.getInExpression().accept(this);
        disposeLocalVariable(lVar);
        context.popLevel();
    }
    
    /**
     * Notifies the resolution listener about disposing a local variable.
     * 
     * @param var the variable
     */
    void disposeLocalVariable(LocalDecisionVariable var) {
        if (null != resolutionListener) {
            resolutionListener.localVariableDisposed(var);
        }
    }

    /**
     * Notifies the resolution listener about disposing several local variables.
     * 
     * @param vars the variables
     */
    void disposeLocalVariables(LocalDecisionVariable[] vars) {
        for (int v = 0; null != resolutionListener && v < vars.length; v++) {
            resolutionListener.localVariableDisposed(vars[v]);
        }
    }


    /**
     * Adds a new local decision variable based on <code>decl</code> to <code>cfg</code>.
     * 
     * @param cfg the local configuration to add the new variable
     * @param decl the variable declaration
     * @param initEx the explicitly given initialization expression, may be <b>null</b> then
     *     this method considers the default value of <code>decl</code>
     * @param notify notify the resolution listener about the creation of the new variable, unregistering must follow
     * @return the created local variable
     */
    private LocalDecisionVariable addLocalVariable(LocalConfiguration cfg, DecisionVariableDeclaration decl, 
        ConstraintSyntaxTree initEx, boolean notify) {
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
        if (notify && null != resolutionListener) {
            resolutionListener.localVariableCreated(var);
            var.setValueChangeListener(listener); // currently coupled
        }
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
                if (Container.APPLY == operation || Container.ITERATE == operation) { // last declarator is the result
                    lastIteratorIndex--;
                    resultDecl = call.getDeclarator(lastIteratorIndex);
                } else { // result is implicit
                    IDatatype type;
                    IDatatype exType;
                    try {
                        type = call.inferDatatype();
                        exType = call.getExpression().inferDatatype();                        
                    } catch (CSTSemanticException e) {
                        type = AnyType.TYPE; // shall not happen as model is type-valid
                        exType = AnyType.TYPE;
                        exception(e);
                        ok = false;
                    }
                    resultDecl = new DecisionVariableDeclaration(LocalDecisionVariable.ITERATOR_RESULT_VARNAME, type, 
                        call.getParent());
                    try {
                        resultDecl.setValue(evaluator.getStartResult(type, exType));
                    } catch (ValueDoesNotMatchTypeException e) {
                        exception(e);
                        ok = false;
                    }
                }
                LocalDecisionVariable lResultVar = addLocalVariable(cfg, resultDecl, null, true); 
                VariableAccessor resultVar = VariableAccessor.POOL.getInstance()
                    .bind(lResultVar, context, true);
                LocalDecisionVariable[] declarators = new LocalDecisionVariable[lastIteratorIndex];
                int iterCount = 0;
                IDatatype contd = call.getIteratorBaseType();
                boolean isContained = true; 
                for (int d = 0; ok && d < declarators.length; d++) { // create local vars, initialize here only temp var
                    DecisionVariableDeclaration decl = call.getDeclarator(d);
                    boolean isIterator = isContained && (null == contd || contd.isAssignableFrom(decl.getType()));
                    declarators[d] = addLocalVariable(cfg, decl, isIterator ? null : decl.getDefaultValue(), true);
                    iterCount += isIterator ? 1 : 0;
                }
                if (ok) {
                    ok = executeContainerIteration(call, declarators, iterCount, resultVar, evaluator);
                }
                context.popLevel();
                if (ok) { // resultVar would be a variable, result of iteration is a constant!
                    result = ConstantAccessor.POOL.getInstance().bind(resultVar.getValue(), false, context);
                } else {
                    result = null;
                }
                resultVar.release();
                disposeLocalVariable(lResultVar);
                disposeLocalVariables(declarators);
            } else {
                result = null;
            }
            opNesting--;
            recordIfFailed(call);
        }
    }
    
    /**
     * Implements flattening/non-flattening container evaluation.
     * 
     * @author Holger Eichelberger
     */
    private class ContainerIterationExecutor {
        
        private ContainerOperationCall call;
        private LocalDecisionVariable[] declarators;
        private VariableAccessor resultVar;
        private IIteratorEvaluator evaluator;
        private Map<Object, Object> data = new HashMap<Object, Object>();
        private int[] pos;
        private ContainerValue containerValue;
        private IDecisionVariable containerVariable;
        
        /**
         * Creates a container iteration executor with own context.
         * 
         * @param call the call to evaluate
         * @param declarators the declarators
         * @param resultVar the result variable / declarator
         * @param evaluator the evaluator for <code>call</code>
         */
        private ContainerIterationExecutor(ContainerOperationCall call, LocalDecisionVariable[] declarators, 
            VariableAccessor resultVar, IIteratorEvaluator evaluator) {
            this.call = call;
            this.declarators = declarators;
            this.resultVar = resultVar;
            this.evaluator = evaluator;
        }
        
        /**
         * Determines the container value to iterate over from the container expression. If needed, create an 
         * implicit temporary container (if operation is applied to a non-container variable).
         */
        private void determineContainer() {
            call.getContainer().accept(EvaluationVisitor.this);
            containerValue = null;
            if (null != result) {
                Value rValue = result.getValue();
                if (rValue instanceof ContainerValue) {
                    containerValue = (ContainerValue) rValue;
                    containerVariable = result.getVariable();
                    if (null != containerVariable && containerVariable.isLocal()) {
                        containerVariable = null; // prevent deep access to local variables
                    }
                    if (null != containerVariable) {
                        resultVar.bindContainer(containerVariable);
                    } else {
                        resultVar.bindContainer(result);
                    }
                } else if (null != rValue) {
                    try {
                        IDatatype containerType = call.getContainerType();
                        containerValue = (ContainerValue) ValueFactory.createValue(containerType, (Object[]) null);
                        if (containerType.getGenericTypeCount() > 0) {
                            IDatatype elementType = containerType.getGenericType(0);
                            if (Reference.TYPE.isAssignableFrom(elementType)) {
                                rValue = ValueFactory.createValue(elementType, result.getVariable().getDeclaration());
                            }
                        }
                        containerValue.addElement(rValue);
                    } catch (ValueDoesNotMatchTypeException e) {
                        exception(e);
                    } catch (CSTSemanticException e) {
                        exception(e);
                    }
                }
            }
        }

        /**
         * Initialize the container iterators for a container iteration.
         * 
         * @param containers the containers to be assigned to the declarators
         * @param declarators the declarators
         * @return <code>true</code> if initialization was successful, <code>false</code> else
         */
        private boolean initialize(ContainerValue[] containers, LocalDecisionVariable[] declarators) {
            boolean ok = true;
            // initialize the actual container values, not declarators.length!
            for (int c = 0; c < containers.length; c++) {
                Value val = declarators[c].getValue();
                if (val instanceof ContainerValue) {
                    containers[c] = (ContainerValue) val;
                    ok = containers[c] != null;
                } else if (null == val || val == NullValue.INSTANCE) {
                    containers[c] = containerValue;
                    ok = containers[c] != null;
                } else {
                    error("declarator " + declarators[c].getDeclaration().getName() 
                        + " does not provide a container value", Message.CODE_RESOLUTION);
                    ok = false;
                }
            }
            return ok;
        }
        
        /**
         * Evaluate for the given number of iterators.
         * 
         * @param iterCount the number of iterators
         * @return <code>true</code> for success, <code>false</code> else
         */
        private boolean execute(int iterCount) {
            boolean ok = true;
            determineContainer();
            if (null != containerValue) {
                clearResult();
                ContainerValue[] containers = new ContainerValue[iterCount];
                ok = initialize(containers, declarators);
                // iterate over inner iterator again and again until all outer iterators are done
                pos = new int[iterCount];
                while (ok && containers.length > 0 && null != containers[0] 
                    && pos[0] < containers[0].getElementSize()) {
                    int iter = pos.length - 1;
                    ContainerValue iterator = containers[iter];
                    boolean setSelf = selfVars.contains(declarators[iter].getDeclaration());
                    int maxIter = iterator.getElementSize();
                    for (pos[iter] = 0; ok && pos[iter] < maxIter; pos[iter]++) {
                        IDecisionVariable iVar = resultVar.getBoundContainerElement(pos[iter]);
                        Value iVal = iterator.getElement(pos[iter]);
                        ok = evaluateIterator(iter, iVal, iVar, maxIter, setSelf, resultVar);
                    }
                    try {
                        evaluator.postProcessResult(resultVar, data);
                    } catch (ValueDoesNotMatchTypeException ex) {
                        ok = containerException(ex);
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
                            LocalDecisionVariable lVar = declarators[iter];
                            lVar.setVariable(resultVar.getBoundContainerElement(pos[iter]));
                            lVar.setValue(iterator.getElement(pos[iter]), AssignmentState.ASSIGNED);
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
        
        // checkstyle: stop parameter number check

        /**
         * Evaluates an iterator. Considers the nesting mode and flattens/builds up sub-collections if needed.
         * 
         * @param iter the declarator iteration index
         * @param iterVal the actual value of the iterator
         * @param iterVar the alternative iterator variable (may be <b>null</b>)
         * @param maxIter the maximum iteration index
         * @param setSelf whether {@link EvaluationVisitor#selfValue} shall be modified
         * @param rVar the result value accessor
         * @return whether the execution was ok (<code>true</code>) or not <code>false</code>)
         */
        private boolean evaluateIterator(int iter, Value iterVal, IDecisionVariable iterVar, int maxIter, 
            boolean setSelf, EvaluationAccessor rVar) {
            boolean ok = true;
            NestingMode nestingMode = call.getResolvedOperation().getNestingMode();
            if (NestingMode.NONE != nestingMode && iterVal instanceof ContainerValue) {
                if (NestingMode.LEGACY == nestingMode 
                    && declarators[iter].getDeclaration().getType().isAssignableFrom(iterVal.getType())) {
                    // in legacy mode, flattening the iterValue is not always desired, in particular if iterValue is 
                    // already a collection and the iterator is a collection, flattening would lead to wrong results / 
                    // undefined parameters although static type safety is given. in this case, go for second / legacy
                    // alternative
                    nestingMode = NestingMode.NONE;
                }
            } else {
                // prerequisites not given, go for NONE and second alternative below
                nestingMode = NestingMode.NONE;
            }
            if (NestingMode.NONE != nestingMode) {
                EvaluationAccessor res = rVar; 
                if (NestingMode.NESTING == nestingMode) {
                    try {
                        Value val = ValueFactory.createValue(rVar.getValue().getContainedType(), (Object[]) null);
                        res = ConstantAccessor.POOL.getInstance().bind(val, false, rVar.getContext());
                        ((ContainerValue) rVar.getValue()).addElement(res.getValue());
                    } catch (ValueDoesNotMatchTypeException ex) {
                        ok = containerException(ex);
                    }
                }
                ContainerValue cValue = (ContainerValue) iterVal;
                for (int e = 0; ok && e < cValue.getElementSize(); e++) {
                    ok &= evaluateIterator(iter, cValue.getElement(e), 
                        null == iterVar ? null : iterVar.getNestedElement(e), maxIter, setSelf, res);
                }
            } else {
                if (setSelf) { // for now only inner...
                    selfValue = iterVal;
                }
                try {
                    declarators[iter].setVariable(iterVar);
                    declarators[iter].setValue(iterVal, AssignmentState.ASSIGNED);
                } catch (ConfigurationException e) {
                    ok = containerException(e);
                }
                call.getExpression().accept(EvaluationVisitor.this);
                if (null != result && null != result.getValue()) {
                    try {
                        Value aggRes = evaluator.aggregate(rVar, iterVal, result, data); 
                        clearResult();
                        if (BooleanValue.TRUE == aggRes) {
                            pos[iter] = maxIter; // break -> endless loop
                        } else if (aggRes instanceof ListWrapperValue) {
                            ListWrapperValue lwv = (ListWrapperValue) aggRes;
                            for (int e = 0; e < lwv.getElementCount(); e++) {
                                ok &= evaluateIterator(iter, lwv.getElement(e), null, maxIter, setSelf, rVar);
                            }
                        }
                    } catch (ValueDoesNotMatchTypeException ex) {
                        ok = containerException(ex);
                    }
                } else {
                    ok = false;
                }
            }
            return ok;
        }
    }

    // checkstyle: resume parameter number check
    
    /**
     * Executes the container iteration.
     * 
     * @param call the container operation call to be executed
     * @param declarators all declarators of the call in terms of decision variables
     * @param iterCount the number of iterators within the declarators
     * @param resultVar the result variable to be modified as a side effect during the iteration (result aggregation)
     * @param evaluator the evaluator corresponding to <code>call</code> (may be <b>null</b> in case of an apply 
     *     operation)
     * @return <code>true</code> if successful, <code>false</code> if unevaluated
     */
    private boolean executeContainerIteration(ContainerOperationCall call, LocalDecisionVariable[] declarators, 
        int iterCount, VariableAccessor resultVar, IIteratorEvaluator evaluator) {
        ContainerIterationExecutor exec = new ContainerIterationExecutor(call, declarators, resultVar, evaluator);
        return exec.execute(iterCount);
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
                result = TypeQueries.isFreezeVariableType(cst.inferDatatype());
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
                    IDecisionVariable res = context.getDecision(decl);
                    if (null == res) { // no top-top-level variable
                        res = Configuration.findInParents(variable, decl.getName());
                    }
                    variable = res;
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
                    result = ConstantAccessor.POOL.getInstance().bind(nValue, false, context);
                }
            } else if (value instanceof MetaTypeValue) {
                // static qualified top
                IDatatype type = ((MetaTypeValue) value).getValue();
                value = context.bind(type);
                if (value instanceof CompoundValue) {
                    value = ((CompoundValue) value).getNestedValue(slotName);
                    if (null != value) {
                        result = ConstantAccessor.POOL.getInstance().bind(value, false, context);
                    }
                }
            } else {
                if (null == result) {
                    if (null == variable) {
                        error("cannot evaluate compound/slot in " + StringProvider.toIvmlString(access), 
                            Message.CODE_RESOLUTION);
                    } // else variable not defined, stop lazy evaluation
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
        contextStack.push();
        for (int s = 0; ok && s < initializer.getSlotCount(); s++) {
            String slotName = initializer.getSlot(s);
            contextStack.setCompoundSlot(slotName);
            values[pos++] = slotName;
            DecisionVariableDeclaration decl = type.getElement(slotName);
            if (ConstraintType.isConstraint(decl.getType())) {
                try {
                    // do not evaluate a constraint value here - this is just a value as it is / deferred
                    // see StaticAccessFinder
                    values[pos++] = ValueFactory.createValue(ConstraintType.TYPE, initializer.getExpression(s));
                } catch (ValueDoesNotMatchTypeException e) {
                    exception(e);
                }
            } else {
                initializer.getExpression(s).accept(this);
                if (null == result) {
                    error("cannot evaluate expression for compound slot '" + slotName + "' in type '" 
                        + type.getName() + "': " + StringProvider.toIvmlString(initializer.getExpression(s)), 
                        Message.CODE_RESOLUTION);
                    ok = false;
                } else {
                    if (TypeQueries.isReference(decl.getType())) {
                        values[pos++] = result.getReferenceValue();
                    } else {
                        Value val = result.getValue();
                        // avoid implicit reference semantics of assigning complex variables
                        if (null != val && modelCopy && !result.isConstant()) {
                            val = val.clone();
                        }
                        values[pos++] = val;
                        
                    }
                }
                clearResult();
            }
        }
        contextStack.pop();
        if (ok) {
            try {
                Value value = ValueFactory.createValue(initializer.getType(), values);
                result = ConstantAccessor.POOL.getInstance().bind(value, false, context);
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
        boolean references = TypeQueries.isReference(initializer.getType().getContainedType());
        contextStack.push(initializer);
        for (int s = 0; ok && s < values.length; s++) {
            contextStack.setContainerIndex(s);
            if (isConstraintCollection) {
                try {
                    // do not evaluate a constraint value here - this is just a value as it is / deferred
                    // See static access finder
                    values[s] = ValueFactory.createValue(ConstraintType.TYPE, initializer.getExpression(s));
                } catch (ValueDoesNotMatchTypeException e) {
                    exception(e);
                }
            } else {
                initializer.getExpression(s).accept(this);
                if (null == result) {
                    error("cannot evaluate container initializer expression '" + s + "'", Message.CODE_RESOLUTION);
                    ok = false;
                } else {
                    if (references) {
                        Value val = result.getValue();
                        if (null == val) {
                            error("cannot evaluate container initializer expression, leads to null/no reference", 
                                Message.CODE_RESOLUTION);        
                            ok = false;
                        } else {
                            if (TypeQueries.isReference(val.getType())) { // the parser accepts both
                                values[s] = result.getValue();
                            } else {
                                values[s] = result.getReferenceValue();
                            }
                        }
                    } else {
                        Value val = result.getValue();
                        // Fails for one test case with AssignmentResolver-Init
                        // avoid implicit reference semantics of assigning complex variables
                        if (null != val && modelCopy && !result.isConstant()) {
                            val = val.clone();
                        }
                        values[s] = val;
                    }
                }
                clearResult();
            }
        }
        contextStack.pop();
        if (ok) {
            try {
                Value value = ValueFactory.createValue(initializer.getType(), values); 
                result = ConstantAccessor.POOL.getInstance().bind(value, false, context);
            } catch (ValueDoesNotMatchTypeException e) {
                exception(e);
            }
        }
        recordIfFailed(initializer);
    }
    
    @Override
    public void visitSelf(Self self) {
        Value val = selfValue;
        if (null == val) {
            val = contextStack.getSelfValue();
        }
        if (null != val) {
            result = ConstantAccessor.POOL.getInstance().bind(val, false, context);
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
        return assignmentState;
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        visitVariable(variable);
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            if (e > 0 && null == result) {
                break; // break if undefined
            }
            clearResult(); // leave only last one
            block.getExpression(e).accept(this);
        }
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        Boolean res = Boolean.TRUE;
        for (int e = 0; Boolean.TRUE == res && e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
            if (null != result) {
                Value val = result.getValue();
                clearResult();
                if (val instanceof BooleanValue) {
                    res = ((BooleanValue) val).getValue();
                } else {
                    res = null;
                }
            } else {
                res = null;
            }
        }
        if (null != res) {
            result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.toBooleanValue(res), true, context);
        }
    }

}
