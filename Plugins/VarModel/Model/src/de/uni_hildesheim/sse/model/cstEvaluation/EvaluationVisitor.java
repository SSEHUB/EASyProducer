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
package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.CompoundVariable;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IConfiguration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomOperation;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation;
import de.uni_hildesheim.sse.model.varModel.datatypes.TypeQueries;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Rudimentary evaluation visitor for constant expressions. Usage:
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

    private EvaluationAccessor result;
    private int opNesting = 0;
    private boolean assignmentsOnly;
    private IAssignmentState assignmentState;
    private IValueChangeListener listener;
    private List<Message> messages = new ArrayList<Message>();
    private EvaluationContextImpl context;
    private Project dispatchScope;
    private StaticAccessFinder finder = new StaticAccessFinder();

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
                messages.add(message);
            }
        }

        @Override
        public IAssignmentState getTargetState(IAssignmentState state) {
            return EvaluationVisitor.this.getTargetState(state);
        }

        @Override
        public IDecisionVariable getDecision(AbstractVariable variable) {
            IDecisionVariable result = null;
            for (int l = configStack.size() - 1; null == result && l >= 0; l--) {
                result = configStack.get(l).getDecision(variable);
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
                    result = localCfg.bind(type);
                }
            }
            return result;
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
     * Clears the visitor for reuse (including the dispatch scope).
     */
    public void clear() {
        clearResult();
        context = null;
        assignmentState = null;
        dispatchScope = null;
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

    // --------------------------- error handling ---------------------------

    /**
     * Adds an error message.
     * 
     * @param text the text of the error message
     */
    private void error(String text) {
        messages.add(new Message(text, Status.ERROR));
    }
    
    /**
     * Adds a not implemented error message.
     * 
     * @param subject the subject that is not implemented
     */
    private void notImplementedError(String subject) {
        messages.add(new Message("cannot evaluate " + subject + " as it is currently not implemented", 
            Status.UNSUPPORTED));
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
    private static Compound getDeclaringCompound(DecisionVariableDeclaration decl) {
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

        Iterator<DecisionVariableDeclaration> staticIter = finder.getResults();
        if (staticIter.hasNext()) {
            // group the iterators in order to avoid unnecessary quantors
            // bind the free variables by quantors
            tmp = bindFreeVarsByQuantors(tmp, groupQuantors(staticIter));
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
    private static Map<IDatatype, List<DecisionVariableDeclaration>> groupQuantors(
        Iterator<DecisionVariableDeclaration> staticIter) {
        Map<IDatatype, List<DecisionVariableDeclaration>> iterGroups 
            = new HashMap <IDatatype, List<DecisionVariableDeclaration>>();
        while (staticIter.hasNext()) {
            DecisionVariableDeclaration var = staticIter.next();
            Compound declaring = getDeclaringCompound(var);
            if (null != declaring) {
                List<DecisionVariableDeclaration> group = iterGroups.get(declaring);
                if (null == group) {
                    group = new ArrayList<DecisionVariableDeclaration>();
                    iterGroups.put(declaring, group);
                }
                group.add(var);
            }
        }
        return iterGroups;
    }
    
    /**
     * Binds the free variables by one quantor per quantor group.
     * 
     * @param cst the constraint to be quantorized/bound
     * @param quantorGroups the quantor groups as determined by {@link #groupQuantors(Iterator)}
     * @return the resulting rewritten constraint (may be <b>null</b> if errors occcurred)
     */
    private ConstraintSyntaxTree bindFreeVarsByQuantors(ConstraintSyntaxTree cst, 
        Map<IDatatype, List<DecisionVariableDeclaration>> quantorGroups) {
        Iterator<Map.Entry<IDatatype, List<DecisionVariableDeclaration>>> groupIter 
            = quantorGroups.entrySet().iterator();
        while (null != cst && groupIter.hasNext()) {
            Map.Entry<IDatatype, List<DecisionVariableDeclaration>> entry = groupIter.next();
            IDatatype type = entry.getKey();
            List<DecisionVariableDeclaration> group = entry.getValue();
            DecisionVariableDeclaration iter = null;
            // determine iterator variable
            for (int d = 0, n = group.size(); null == iter && d < n; d++) {
                DecisionVariableDeclaration var = group.get(d);
                if (TypeQueries.sameTypes(var.getType(), type)) {
                    iter = var;
                }
            }
            if (null == iter) {
                iter = new DecisionVariableDeclaration("iter", type, null);
            }
            if (group.size() > 1) {
                for (int d = 0, n = group.size(); d < n; d++) {
                    DecisionVariableDeclaration var = group.get(d);
                    if (!TypeQueries.sameTypes(var.getType(), type)) {
                        ConstraintSyntaxTree init = new CompoundAccess(new Variable(iter), var.getName());
                        cst = new IterLet(var, init, cst); // INIT expression->! v
                        try {
                            init.inferDatatype();
                            cst.inferDatatype();
                        } catch (CSTSemanticException e) {
                            cst = null;
                        }
                    }
                }
            } 
            Value allInstances = context.getAllInstances(type);
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
    
    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        result = ConstantAccessor.POOL.getInstance().bind(value.getConstantValue(), context);
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {        
        ConstraintSyntaxTree qualifier = variable.getQualifier();
        if (null != qualifier) {
            // special case: attributes -> find attribute decision variable
            IDecisionVariable attribute = null;
            qualifier.accept(this);
            if (null != result) {
                IDecisionVariable var = result.getVariable();
                if (null != var) {
                    attribute = findAttribute(var, variable.getVariable());
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
     * @return the attribute decision variable or <b>null</b> if not found
     */
    private static IDecisionVariable findAttribute(IDecisionVariable var, AbstractVariable decl) {
        IDecisionVariable result = null;
        if (null != var) {
            for (int a = 0, n = var.getAttributesCount(); null == result && a < n; a++) {
                IDecisionVariable attribute = var.getAttribute(a);
                if (attribute.getDeclaration().equals(decl)) {
                    result = attribute;
                }
            }
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // nothing to do
    }

    /**
     * Evaluates the given custom operation.
     * 
     * @param operation the operation to be evaluated
     * @param args the call arguments
     */
    private void evaluateCustomOperation(CustomOperation operation, EvaluationAccessor[] args) {
        if (args.length == operation.getParameterCount()) {
            LocalConfiguration cfg = new LocalConfiguration();
            context.pushLevel(cfg);
            for (int a = 0; a < args.length; a++) {
                LocalDecisionVariable argument = new LocalDecisionVariable(operation.getParameterDeclaration(a));
                try {
                    argument.setValue(args[a].getValue(), AssignmentState.ASSIGNED);
                } catch (ConfigurationException e) {
                    exception(e);
                }
                cfg.addDecision(argument);
            }
            operation.getFunction().accept(this);
            context.popLevel();
        } else {
            messages.add(new Message("argument and operation count do not match", Status.ERROR));
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
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (!assignmentsOnly 
            || assignmentsOnly && (opNesting > 0 || OclKeyWords.ASSIGNMENT.equals(call.getOperation()))) {
            opNesting++;
            EvaluationAccessor operand;
            if (null != call.getOperand()) {
                call.getOperand().accept(this);
                operand = result;
            } else {
                // custom operation
                operand = null;
            }
            EvaluationAccessor[] args = new EvaluationAccessor[call.getParameterCount()];
            Operation op = call.getResolvedOperation();
            
            boolean allOk = true;
            
            // Handle "short cuts". For instance undef or true should be evaluated to true.
            if (op == BooleanType.AND) {
                allOk = !handleAND(operand, call.getParameter(0));
            } else if (op == BooleanType.OR) {
                allOk = !handleOR(operand, call.getParameter(0));
            }
            
            for (int a = 0; allOk && a < args.length; a++) {
                // Overwrite "implies" operation
                if (op == BooleanType.IMPLIES && BooleanValue.FALSE.equals(operand.getValue())) {
                    result = ConstantAccessor.POOL.getInstance().bind(BooleanValue.TRUE, context);
                    allOk = false; // Everything is ok, but no further processing shall be taken place ;-)
                } else {
                    call.getParameter(a).accept(this);
                    if (null == result && op.acceptsNull()) {
                        // evaluators must assure to work with that -> isDefined
                        result = ConstantAccessor.POOL.getInstance().bind(null, context); 
                    }
                    args[a] = result;
                    if (null == result) {
                        messages.add(new Message("cannot evaluate the argument " + a + " of " + call.getOperation(), 
                            Status.ERROR));
                        allOk = false;
                    } 
                }
            }
            
            if (allOk) {
                if (op instanceof CustomOperation) {
                    CustomOperation cOp = dynamicDispatch((CustomOperation) op, args);
                    evaluateCustomOperation(cOp, args);
                } else {
                    IOperationEvaluator evaluator = getOperationEvaluator(op);
                    if (null == evaluator) {
                        notImplementedError(op.getName());
                    } else {
                        result = evaluator.evaluate(operand, args);
                    }
                }
            }
            if (null != operand) {
                operand.release();
            }
            for (int a = 0; a < args.length; a++) {
                if (null != args[a]) {
                    args[a].release();
                }
            }
            
            opNesting--;
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
                argTypes[a] = args[a].getVariable().getDeclaration().getType();
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
                    checkForDispatch(scope);
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
                result = 0;
            } else {
                result = 1;
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        clearResult();
        LocalConfiguration cfg = new LocalConfiguration();
        context.pushLevel(cfg);
        addLocalVariable(cfg, let.getVariable(), let.getInitExpression());
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
        LocalDecisionVariable var = new LocalDecisionVariable(decl);
        cfg.addDecision(var);
        if (null == initEx) {
            initEx = decl.getDefaultValue();
        }
        if (null != initEx) {
            initEx.accept(this);
            if (null != result) {
                try {
                    var.setValue(result.getValue(), AssignmentState.DEFAULT);
                } catch (ConfigurationException e) {
                    exception(e);
                }
                clearResult();
            }
        }
        return var;
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        EvaluationAccessor resultBefore = result;
        ifThen.getIfExpr().accept(this);
        if (null != result) {
            boolean isFulfilled = constraintFulfilled();
            clearResult();
            if (isFulfilled) {
                EvaluationAccessor.release(resultBefore);
                ifThen.getIfExpr().accept(this);
            } else if (null != ifThen.getElseExpr()) {
                EvaluationAccessor.release(resultBefore);
                ifThen.getElseExpr().accept(this);
            } else {
                result = resultBefore;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
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
                    resultDecl = new DecisionVariableDeclaration("*r*", type, call.getParent());
                    try {
                        resultDecl.setValue(evaluator.getStartResult(type));
                    } catch (ValueDoesNotMatchTypeException e) {
                        exception(e);
                        ok = false;
                    }
                }
                
                // prepare the declarators representing the iterators
                VariableAccessor resultVar = VariableAccessor.POOL.getInstance()
                    .bind(addLocalVariable(cfg, resultDecl, null), context);
                LocalDecisionVariable[] declarators = new LocalDecisionVariable[lastIteratorIndex];
                for (int d = 0; ok && d < declarators.length; d++) {
                    declarators[d] = addLocalVariable(cfg, call.getDeclarator(d), null);
                }
                
                if (ok) {
                    executeContainerIteration(call, declarators, resultVar, evaluator);
                }
    
                context.popLevel();
                // resultVar would be a variable, result of iteration is a constant!
                result = ConstantAccessor.POOL.getInstance().bind(resultVar.getValue(), context);
                resultVar.release();
            } else {
                result = null;
            }
            opNesting--;
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
            } else if (null == val || val == NullValue.INSTANCE) {
                containers[c] = container;
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
     */
    private void executeContainerIteration(ContainerOperationCall call, LocalDecisionVariable[] declarators, 
        VariableAccessor resultVar, IIteratorEvaluator evaluator) {
        boolean ok = true;
        call.getContainer().accept(this);
        if (null != result) {
            ContainerValue container = (ContainerValue) result.getValue();
            ContainerValue[] containers = new ContainerValue[declarators.length];
            initialize(container, containers, declarators);
            // iterate over inner iterator again and again until all outer iterators are done
            int[] pos = new int[declarators.length];
            Map<Object, Object> data = new HashMap<Object, Object>();
            while (ok && null != containers[0] && pos[0] < containers[0].getElementSize()) {
                int iter = pos.length - 1;
                ContainerValue iterator = containers[iter];
                int maxIter = iterator.getElementSize();
                for (pos[iter] = 0; ok && pos[iter] < maxIter; pos[iter]++) {
                    Value iterVal = iterator.getElement(pos[iter]);
                    try {
                        declarators[iter].setValue(iterVal, AssignmentState.ASSIGNED);
                    } catch (ConfigurationException e) {
                        ok = false;
                        exception(e);
                    }
                    call.getExpression().accept(this);
                    if (null != result && null != result.getValue()) {
                        try {
                            boolean stop = evaluator.aggregate(resultVar, iterVal, result, data);
                            result.release();
                            if (stop) {
                                pos[iter] = maxIter; // break -> endless loop
                            }
                        } catch (ValueDoesNotMatchTypeException e) {
                            exception(e);
                            ok = false;
                        }
                    }
                }
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
                        ok = false;
                        exception(e);
                    }
                    if (propagate) {
                        iter--;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
        if (null != result) {
            IDecisionVariable variable = result.getVariable();
            Value value = result.getValue();
            clearResult();
            if (value instanceof ReferenceValue) {
                // dereference first
                DecisionVariableDeclaration decl = ((ReferenceValue) value).getValue(); 
                variable = context.getDecision(decl);
            }
            if (variable instanceof CompoundVariable) {
                result = CompoundSlotAccessor.POOL.getInstance().bind(variable, access.getSlotName(), context);
            } else if (value instanceof CompoundValue) {
                // static qualified in compound
                value = ((CompoundValue) value).getNestedValue(access.getSlotName());
                if (null != value) {
                    result = ConstantAccessor.POOL.getInstance().bind(value, context);
                }
            } else if (value instanceof MetaTypeValue) {
                // static qualified top
                IDatatype type = ((MetaTypeValue) value).getValue();
                value = context.bind(type);
                if (value instanceof CompoundValue) {
                    value = ((CompoundValue) value).getNestedValue(access.getSlotName());
                    if (null != value) {
                        result = ConstantAccessor.POOL.getInstance().bind(value, context);
                    }
                }
            } else {
                messages.add(new Message("cannot evaluate compound", Status.ERROR));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
        // nothing to do
        clearResult();
    }

    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        clearResult();
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        Object[] values = new Object[2 + 2 * initializer.getSlotCount()];
        int pos = 0;
        values[pos++] = CompoundValue.SPECIAL_SLOT_NAME_TYPE;
        values[pos++] = initializer.getType();
        boolean ok = true;
        for (int s = 0; ok && s < initializer.getSlotCount(); s++) {
            String slotName = initializer.getSlot(s);
            values[pos++] = slotName;
            initializer.getExpression(s).accept(this);
            values[pos++] = result;
            if (null == result) {
                messages.add(new Message("cannot evaluate compound slot '" + slotName + "'", Status.ERROR));
                ok = false;
            }
        }
        clearResult();
        if (ok) {
            try {
                Value value = ValueFactory.createValue(initializer.getType(), values);
                result = ConstantAccessor.POOL.getInstance().bind(value, context);
            } catch (ValueDoesNotMatchTypeException e) {
                exception(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        Object[] values = new Object[initializer.getExpressionCount()];
        boolean ok = true;
        for (int s = 0; ok && s < values.length; s++) {
            initializer.getExpression(s).accept(this);
            values[s] = result;
            if (null == result) {
                messages.add(new Message("cannot evaluate container initializer expression '" + s + "'", Status.ERROR));
                ok = false;
            }
        }
        clearResult();
        if (ok) {
            try {
                Value value = ValueFactory.createValue(initializer.getType(), values); 
                result = ConstantAccessor.POOL.getInstance().bind(value, context);
            } catch (ValueDoesNotMatchTypeException e) {
                exception(e);
            }
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
     * @param state the state of the variable being assigned
     * @return the target state for the variable, may be <b>null</b> if assignment is not permitted
     */
    protected IAssignmentState getTargetState(IAssignmentState state) {
        return assignmentState;
    }
    
}
