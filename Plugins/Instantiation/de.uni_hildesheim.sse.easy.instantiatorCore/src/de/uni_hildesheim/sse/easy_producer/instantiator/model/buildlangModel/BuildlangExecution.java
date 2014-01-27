/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionResult.Status;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand.ExecutableOperand;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand.IExecutableOperandType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop.BuildCollectionApplicator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop.BuildEnablingApplicator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop.BuildExecutionApplicator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop.LhsRhsMatchLoop;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop.RuleBodyExecutor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.MatchResolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExecutionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IResolvableModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ModelCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StringReplacer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.FixedListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Executes a build language project. Please note that for full
 * functionality, {@link #setExpressionParser(IExpressionParser)}
 * must be called appropriately.
 * 
 * @author Holger Eichelberger
 */
public class BuildlangExecution extends ExecutionVisitor<Script, Rule, VariableDeclaration> 
    implements IBuildlangVisitor, RuleBodyExecutor {

    /**
     * The default source project parameter (called {@value}).
     */
    public static final String PARAM_SOURCE = "source";

    /**
     * The default target project parameter (called {@value}).
     */
    public static final String PARAM_TARGET = "target";
    
    /**
     * The default configuration parameter (called {@value}).
     */
    public static final String PARAM_CONFIG = "config";

    
    private static IExpressionParser expressionParser;

    private RuntimeEnvironment environment;
    private ITracer tracer;
    private File base;
    private String startRuleName;
    private List<Rule> failed = new ArrayList<Rule>();
    private MatchResolver matchResolver;
    private VariableFinder variableFinder;
    private ExecutableRules executableRules;
    private Stack<RuleExecutionContext> ruleStack = new Stack<RuleExecutionContext>();
        
    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param parameter the top-level parameter for the script to be executed
     */
    public BuildlangExecution(ITracer tracer, File base, Map<String, Object> parameter) {
        this(tracer, base, "main", parameter);
    }
    
    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param startRuleName the name of the start rule
     * @param parameter the top-level parameter for the script to be executed
     */
    public BuildlangExecution(ITracer tracer, File base, String startRuleName, Map<String, Object> parameter) {
        super(new RuntimeEnvironment(), tracer, parameter);
        this.tracer = tracer;
        this.environment = (RuntimeEnvironment) getRuntimeEnvironment();
        this.base = base;
        this.startRuleName = startRuleName;
        this.matchResolver = new MatchResolver(environment, expressionParser, this);
        this.variableFinder = new VariableFinder();
        this.executableRules = new ExecutableRules();
    }

    /**
     * Defines the expression parser.
     * 
     * @param parser the parser
     */
    public static void setExpressionParser(IExpressionParser parser) {
        String info;
        if (null != parser) {
            info = "registered expression parser " + parser.getClass().getName();
        } else {
            info = "expression parser unregistered";
        }
        EASyLoggerFactory.INSTANCE.getLogger(BuildlangExecution.class, Bundle.ID).info(info);
        expressionParser = parser;
    }
    
    /**
     * Makes <code>path</code> absolute with respect to <code>base</code> if necessary.
     * 
     * @param path the file to be made absolute
     * @return the absolute file
     */
    private File absolute(String path) {
        File result = new File(path);
        if (!result.isAbsolute()) {
            result = new File(base, path);
        }
        return result;
    }
        
    /**
     * Returns the number of failed rules.
     * 
     * @return the number of failed rules
     */
    public int getFailedCount() {
        return failed.size();
    }
    
    /**
     * Returns the specified failed rule.
     * 
     * @param index the index of the failed rule
     * @return the failed rule
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getFailedCount()}</code>
     */
    public Rule getFailed(int index) {
        return failed.get(index);
    }
    
    /**
     * Checks the results of an evaluation of a condition.
     * 
     * @param value the evaluation result
     * @param element the element to check on
     * @param test how to test individual artifacts
     * @return <code>true</code> if the condition is fulfilled, <code>false</code> else
     */
    protected boolean checkConditionResult(Object value, Object element, ConditionTest test) {
        boolean ok = true;
        if (element instanceof MapExpression) {
            ok = true; // maps never fail
        } else if (value instanceof RuleExecutionResult) {
            ok = ((RuleExecutionResult) value).getStatus() != Status.FAIL;
        } else {
            ok = super.checkConditionResult(value, element, test);
        }
        return ok;
    }

    @Override
    public Object visitScript(Script script) throws VilLanguageException {
        tracer.visitScript(script);
        visitModelHeader(script);
        for (int p = 0; p < script.getParameterCount(); p++) {
            Object value;
            try {
                value = environment.getValue(script.getParameter(p));
            } catch (VilLanguageException e) {
                value = null; // don't care for undefined variables
            }
            if (value instanceof Configuration) {
                Configuration config = (Configuration) value;
                if (null == config.getRootScript()) {
                    config.setRootScript(script);
                }
            }
        }
        environment.register(script);
        executableRules.collect(script);
        environment.switchContext(script);
        VariableDeclaration var = script.getVariableDeclaration(Script.NAME_SCRIPTDIR);
        if (null != var) {
            String scriptDir;
            File file = script.getContainingFolder();
            if (null == file) {
                scriptDir = "";
            } else {
                scriptDir = file.getAbsolutePath();
            }
            environment.addValue(var, scriptDir);
        }
        processProperties(script);
        checkConstants(script);
        tracer.visitedScript(script);
        return executeMain(script, script.determineStartRule(startRuleName));
    }
    
    @Override
    protected ModelCallExpression<VariableDeclaration, Script, Rule> createModelCall(Script model, Rule operation,
        CallArgument... arguments) throws ExpressionException {
        return new RuleCallExpression(model, operation, arguments);
    }
    
    @Override
    protected void setModelArgument(VariableDeclaration param, Object value) throws VilLanguageException {
        // input may be Project or Project[] instance, expected may be collection or project
        // perform explicit conversion if possible - otherways fail and execution will fail anyway
        // this is needed for multi-project instantiation
        Object newVal = value;
        if (null != value) {
            TypeDescriptor<? extends IVilType> projectType = TypeRegistry.projectType();
            TypeDescriptor<? extends IVilType> type = param.getType();
            if (type.isCollection() && 1 == type.getParameterCount() 
                && projectType.isAssignableFrom(type.getParameterType(0))) {
                // expected type is a collection of Projects
                Project[] pArray = null;
                if (value instanceof Project[]) {
                    // just convert the array into collection type later
                    pArray = (Project[]) value;
                } else if (value instanceof Project) {
                    // turn project into 1-array and requried collection type later
                    pArray = new Project[1];
                    pArray[0] = (Project) value;
                }
                if (null != pArray) {
                    // turn array into collection type
                    if (type.isSequence()) {
                        newVal = new ArraySequence<Project>(pArray, Project.class);
                    } else {
                        newVal = new ArraySet<Project>(pArray, Project.class);
                    }
                }
            } else if (type.isAssignableFrom(projectType)) {
                // expected type is a Project
                if (value instanceof Project[]) {
                    Project[] pArray = (Project[]) value;
                    if (1 == pArray.length) {
                        newVal = pArray[0];
                    } // else either no element or multiple elements - will fail anyway
                }
            }
        }
        super.setModelArgument(param, newVal);
    }

    /**
     * Processes the {@link LoadProperties}.
     * 
     * @param script the script to process the properties for
     * @throws VilLanguageException in case that something goes wrong
     */
    private void processProperties(Script script) throws VilLanguageException {
        Properties loaded = new Properties();
        for (int p = 0; p < script.getPropertiesCount(); p++) {
            LoadProperties prop = script.getProperties(p);
            String path = prop.getPath();
            try {
                path = StringReplacer.substitute(path, environment, expressionParser, this);
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
            }
            File file = absolute(path);
            try {
                FileInputStream fis = new FileInputStream(file);
                loaded.load(fis);
                fis.close();
            } catch (IOException e) {
                throw new VilLanguageException(e.getMessage(), e, VilLanguageException.ID_IO);
            }
        }
        for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
            VariableDeclaration var = script.getVariableDeclaration(v);
            String value = loaded.getProperty(var.getName(), null);
            if (null != value) {
                if (var.isConstant() && null != var.getExpression()) {
                    throw new VilLanguageException("constant '" + var.getName() + "' is already assigned a value", 
                        VilLanguageException.ID_IS_CONSTANT);
                }
                Object actValue = evaluateExternalValue(var, value);
                environment.setValue(var, actValue);
                tracer.valueDefined(var, actValue);
            }
        }
    }

    /**
     * Evaluates an external value for a given <code>var</code>.
     * 
     * @param var the variable to evaluate the value for
     * @param value the external value
     * @return the actual value for <code>var</code>
     * @throws VilLanguageException in case that conversion does not work
     */
    private Object evaluateExternalValue(VariableDeclaration var, String value) throws VilLanguageException {
        Object actValue;
        try {
            ConstantExpression ex = new ConstantExpression(var.getType(), value);
            actValue = ex.accept(this);
        } catch (ExpressionException e) {
            // cannot be turned into a primitive value
            try {
                actValue = value;
                TypeDescriptor<? extends IVilType> varType = var.getType();
                TypeDescriptor<? extends IVilType> exType = TypeRegistry.stringType();
                if (!varType.isAssignableFrom(exType)) {
                    OperationDescriptor desc = TypeDescriptor.findConversionOnBoth(exType, varType);
                    if (null != desc) {
                        Expression ex = new ConstantExpression(exType, value);
                        ex = new CallExpression(desc, new CallArgument(ex));
                        actValue = ex.accept(this);
                    }
                }
            } catch (ExpressionException e1) {
                throw new VilLanguageException(e1);
            }
        }       
        return actValue;
    }

    /**
     * Checks the constant values for proper initialization.
     * 
     * @param script the project to process the properties for
     * @throws VilLanguageException in case that something goes wrong
     */
    private void checkConstants(Script script) throws VilLanguageException {
        for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
            VariableDeclaration var = script.getVariableDeclaration(v);
            if (var.isConstant()) {
                if (!environment.isDefined(var)) {
                    throw new VilLanguageException("constant '" + var.getName() + "' must be assigned a value " 
                        + "(either in script or via loaded properties)", VilLanguageException.ID_SEMANTIC);
                }
            }
        }        
    }

    /**
     * Post processes system call arguments, e.g., by removing line separators.
     * 
     * @param argument the argument to be processed
     * @return the processed argument
     */
    private String postprocessSystemCallArgument(String argument) {
        return null == argument ? "" : argument.replaceAll("(\\r|\\n)", "");
    }
    
    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws ExpressionException {
        Object result;
        switch (call.getType()) {
        case EXECUTE:
            String exec;
            try {
                Object nameVarVal = environment.getValue(call.getNameVariable());
                if (nameVarVal instanceof Path) {
                    exec = ((Path) nameVarVal).getAbsolutePath().getAbsolutePath();
                } else {
                    exec = StringValueHelper.getStringValue(nameVarVal, null);
                    exec = StringReplacer.substitute(exec, environment, expressionParser, this);
                }
            } catch (VilLanguageException e) {
                throw new ExpressionException(e);
            } 
            String[] args = new String[call.getArgumentsCount() + 1];
            args[0] = postprocessSystemCallArgument(exec);
            for (int a = 1; a < args.length; a++) {
                Object o = call.getArgument(a - 1).accept(this);
                IExecutableOperandType type = ExecutableOperand.getExecutableType(o);
                if (null == type) {
                    if (null == o) {
                        args[a] = null;
                    } else {
                        args[a] = o.toString();
                    }
                } else {
                    try {
                        args[a] = type.convert(o);
                    } catch (ArtifactException e) {
                        throw new ExpressionException(e, ExpressionException.ID_RUNTIME);
                    }
                }
                args[a] = postprocessSystemCallArgument(
                    StringReplacer.substitute(args[a], environment, expressionParser, this));
            }
            
            EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(StrategyCallExpression.class, Bundle.ID);
            logger.info("system call: " + Arrays.toString(args));
            tracer.visitSystemCall(args);
            ProcessBuilder builder = new ProcessBuilder(args);
            try {
                Process process = builder.start();
                InputStream is = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    logger.info(line);
                }
                int res = process.waitFor();
                logger.info("execution result: " + res);
            } catch (InterruptedException e) {
                throw new ExpressionException(e, ExpressionException.ID_SYSTEM_EXEC);
            } catch (IOException e) {
                throw new ExpressionException(e, ExpressionException.ID_SYSTEM_EXEC);
            }
            result = Boolean.TRUE;
            break;
        case INSTANTIATOR:
            tracer.visitingInstantiator(call.getName());
            result = visitCallExpression(call);
            tracer.visitedInstantiator(call.getName(), result);
            break;
        default:
            throw new ExpressionException("illegal strategy type " + call.getType(), ExpressionException.ID_INTERNAL);
        }
        return result;
    }

/*  @Override
    public void visitDefer(Defer defer) throws BuildlangException {
    }*/

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilLanguageException {
        // done in processProperties
        return null;
    }
    
    /**
     * Registers the parameter of <code>rule</code>.
     * 
     * @param rule the rule to register the parameter for
     * @throws VilLanguageException in case of any execution error
     */
    private void registerParameter(Rule rule) throws VilLanguageException {
        for (int p = 0; p < rule.getParameterCount(); p++) {
            VariableDeclaration var = rule.getParameter(p);
            IResolvable res = environment.get(var.getName());
            if (null == res) {
                throw new VilLanguageException("parameter " + var.getName() + " is not defined", 
                    VilLanguageException.ID_RUNTIME_PARAMETER);
            } else {
                try {
                    environment.addValue(var, environment.getValue(res));
                } catch (ExpressionException e) {
                    throw new VilLanguageException(e);
                }
            }
        }
    }
    
    /**
     * Adds the variables of <code>rule</code> at the given <code>side</code> to the {@link #variableFinder}.
     * 
     * @param rule the rule to take the variables from
     * @param side the side to consider
     * @param matchVariables shall match variables (entire expression) or related loop variables be added
     */
    private void addVariablesToFinder(Rule rule, Side side, boolean matchVariables) {
        for (int i = 0; i < rule.getVariablesCount(side); i++) {
            VariableDeclaration decl;
            if (matchVariables) {
                decl = rule.getMatchVariable(side, i);
            } else {
                decl = rule.getVariable(side, i);
            }
            if (null != decl) {
                variableFinder.addToSearch(decl);
            }
        }
    }

    /**
     * Determines pre- and postcondition matches and, if enabled, assigns RHS/LHS variables and executes the rule body.
     * Actually, this method has two purposes, namely, testing for enabling pre- and post-condition matches as well
     * as executing the rule body, in case of RHS/LHS matches in iterative fashion. We combined both functionalities
     * as they are closely related and modifications to the matching would otherwise need modifications to multple
     * algorithms. This also prevents storing the matching (outdated/non-existing) pairs in memory.
     * 
     * @param rule the rule to be executed (contains the rule body)
     * @param rhsValues the evaluated RHS conditions (values, determined by visiting the RHS matching expressions 
     *   and therefore are Objects)
     * @param context the rule execution context, may be <b>null</b> if actually no execution of the rule 
     *   body shall be performed and just pre-postcondition matches shall be tested
     * @return the execution status if <code>execute</code> is true, the matching status else (in particular 
     *   {@link Status#SUCCESS} and {@link Status#NOT_APPLICABLE}).
     * @throws VilLanguageException in case of serious execution problems
     */
    private Status applyRuleBody(Rule rule, Object[] rhsValues, RuleExecutionContext context) 
        throws VilLanguageException {
        
        Status status = Status.SUCCESS;
        if (null != context) {
            // determine whether rule match variables are actually used and determine body execution strategy
            variableFinder.reset();
            addVariablesToFinder(rule, Side.LHS, false);
            addVariablesToFinder(rule, Side.RHS, false);
            rule.accept(variableFinder);
            boolean iteratedExecution = variableFinder.wasFound();
            
            variableFinder.reset();
            //addVariablesToFinder(rule, Side.LHS, true);
            addVariablesToFinder(rule, Side.RHS, true);
            rule.accept(variableFinder);
            boolean matchExecution = variableFinder.wasFound();

            if (matchExecution) {
                LhsRhsMatchLoop.matchLoop(rule, rhsValues, new BuildCollectionApplicator(environment), tracer);
            }
            if (iteratedExecution) {
                BuildExecutionApplicator applicator = new BuildExecutionApplicator(environment, context, this);
                LhsRhsMatchLoop.matchLoop(rule, rhsValues, applicator, tracer);
                status = applicator.getStatus();
            } else {
                status = executeRuleBody(rule, context);
            }
        } else {
            // check for enabling
            BuildEnablingApplicator applicator = new BuildEnablingApplicator();
            LhsRhsMatchLoop.matchLoop(rule, rhsValues, applicator, tracer);
            status = applicator.allConditionsEnabled() ? Status.SUCCESS : Status.NOT_APPLICABLE;
        }
        return status;
    }

    @Override
    public Status executeRuleBody(RuleBlock ruleBody, RuleExecutionContext context) throws VilLanguageException {
        Status status = Status.SUCCESS;
        for (int e = 0; Status.SUCCESS == status && e < ruleBody.getBodyElementCount(); e++) {
            IRuleElement elt = ruleBody.getBodyElement(e);
            Object eltVal = elt.accept(this);
            if (mayFail(elt) // guard expression
                && !checkConditionResult(eltVal, elt, ConditionTest.DONT_CARE)) {
                tracer.failedAt(ruleBody.getBodyElement(e));
                status = Status.FAIL;
            } else {
                context.add(eltVal);
            }
        }
        return status;
    }
    
    /**
     * Resolves rule condition matches.
     * 
     * @param rule the rule to consider
     * @param side the side of the rule
     * @throws ExpressionException in case of resolution problems
     */
    void resolveMatches(Rule rule, Side side) throws ExpressionException {
        int count = rule.getRuleConditionCount(side);
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                rule.getRuleCondition(side, i).accept(matchResolver);
            }
        }
    }
    
    /**
     * Returns whether the given <code>rule</code> is on the execution stack.
     * 
     * @param rule the rule to be tested
     * @return <code>true</code> if it is on the actual execution stack, <code>false</code> else
     */
    boolean isOnStack(Rule rule) {
        boolean found = false;
        for (int i = ruleStack.size() - 1; !found && i >= 0; i--) {
            found = ruleStack.get(i).getRule() == rule; // handled internally so reference equality is ok
        }
        return found;
    }
    
    /**
     * Checks the RHS/LHS matching.
     * 
     * @param rule the rule the matching shall be done for
     * @param rhsValues an already initialized array for carrying the primary evaluation/matching results of the RHS
     *   matching expression(s)
     * @return the status of the matching, i.e., {@link Status#SUCCESS} if execution can go on, 
     *   {@link Status#NOT_APPLICABLE} if the rule shall not be applied, {@link Status#FAIL} if already the (execution 
     *   of the preconditions) fails and, thus, the entire rule shall fail
     * @throws ExpressionException in case of evaluating an LHS/RHS expression fails
     * @throws VilLanguageException in case that execution seriously fails
     */
    private Status determineRhsLhsMatching(Rule rule, Object[] rhsValues) throws ExpressionException, 
        VilLanguageException {
        Status status = Status.SUCCESS;
        // determine the RHS matching results -> collections; stop if no result
        int rhsCondCount = rule.getRuleConditionCount(Side.RHS);
        for (int c = 0; Status.SUCCESS == status && c < rhsCondCount; c++) {
            AbstractRuleMatchExpression cond = rule.getRuleCondition(Side.RHS, c);
            rhsValues[c] = cond.accept(this);
            // has elements; actual - if not, check further
            assert cond.inferType().isCollection();
            assert rhsValues[c] instanceof Collection;
            if (!checkConditionResult(rhsValues[c], rule, ConditionTest.DONT_CARE)) {
                rhsValues[c] = executableRules.buildContributing(cond, this);
                if (!checkConditionResult(rhsValues[c], cond, ConditionTest.DONT_CARE)) {
                    status = Status.NOT_APPLICABLE;
                }
            }
        }
        // look into the RHS-LHS matching based on timestamp/existence; stop if no matches
        if (Status.SUCCESS == status) {
            status = applyRuleBody(rule, rhsValues, null); // 
        }
        return status;
    }
    
    @Override
    public Object visitRule(Rule rule) throws VilLanguageException {
        RuleExecutionContext context = new RuleExecutionContext(rule, environment); 
        ruleStack.push(context);
        Status status = Status.SUCCESS;
        boolean visited = false;
        try {
            environment.pushLevel(); 
            // evaluate parameter and replace generic matches
            registerParameter(rule); 
            resolveMatches(rule, Side.RHS);
            resolveMatches(rule, Side.LHS);
            Object[] rhsValues = null; // store for iteration
            int rhsCondCount = rule.getRuleConditionCount(Side.RHS);
            if (rhsCondCount > 0) {
                rhsValues = new Object[rhsCondCount];
                status = determineRhsLhsMatching(rule, rhsValues);
            }
            for (int c = 0; Status.SUCCESS == status && c < rule.getRuleCallCount(Side.RHS); c++) {
                RuleCallExpression ex = rule.getRuleCall(Side.RHS, c);
                RuleExecutionResult res = (RuleExecutionResult) ex.accept(this);
                if (Status.FAIL == res.getStatus()) {
                    status = Status.FAIL; // don't care fore not_applicable or success
                }
                environment.addValue(rule.getVariable(Side.RHS, rhsCondCount + c), res);
                context.add(res);
            }
            // process the body
            tracer.visitRule(rule, environment);
            visited = true;
            if (Status.SUCCESS == status) {
                status = applyRuleBody(rule, rhsValues, context);
                for (int c = 0; Status.SUCCESS == status && c < rule.getRuleConditionCount(Side.LHS); c++) {
                    AbstractRuleMatchExpression ex = rule.getRuleCondition(Side.LHS, c);
                    if (!checkConditionResult(ex.accept(this), ex, ConditionTest.EXISTS)) {
                        status = Status.FAIL;
                        tracer.failedAt(ex);
                    }
                }
            }
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        } catch (VilLanguageException e) {
            throw new VilLanguageException(e);
        } finally {
            try {
                ruleStack.pop();
                environment.popLevel();
            } catch (ArtifactException e) {
                throw new VilLanguageException(e);
            }
        }
        if (Status.FAIL == status) {
            this.failed.add(rule);
        }
        RuleExecutionResult result = new RuleExecutionResult(status, context);
        if (visited) {
            tracer.visitedRule(rule, environment, result);
        }
        return result;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws ExpressionException {
        return visitModelCallExpression(ex);
    }

    @Override
    protected Object executeModelCall(Rule rule) throws VilLanguageException {
        return rule.accept(this);
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException {
        return expression.evaluate(this);
    }
    
    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException {
        return expression.evaluate(this);
    }
    
    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException {
        return expression.evaluate(this);
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException {
        return expression.evaluate(this);
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws ExpressionException {
        environment.pushLevel();
        Object result;
        try {
            result = join(ex);
        } catch (VilLanguageException e) {
            throw new ExpressionException(e);
        } finally {
            try {
                environment.popLevel();
            } catch (ArtifactException e) {
                throw new ExpressionException(e);
            }
        }
        return result;
    }
    
    /**
     * Evaluates the condition for a variable.
     * 
     * @param var the variable to be evaluated
     * @return the evaluation result
     * @throws ExpressionException in case of expression evaluation errors
     */
    @SuppressWarnings("unchecked")
    private Collection<Object> evaluate(JoinVariableDeclaration var) 
        throws ExpressionException {
        return (Collection<Object>) var.getExpression().accept(this);
    }
    
    /**
     * Creates an empty array of collections.
     * 
     * @param length the length of the array to be created
     * @return the array instance
     */
    @SuppressWarnings("unchecked")
    private static Collection<Object>[] createCollectionArray(int length) {
        return new Collection[length];
    }

    /**
     * Creates an empty array of iterators.
     * 
     * @param length the length of the array to be created
     * @return the array instance
     */
    @SuppressWarnings("unchecked")
    private static Iterator<Object>[] createIteratorArray(int length) {
        return new Iterator[length];
    }
    
    /**
     * Performs the join operation.
     * 
     * @param join the join expression to be evaluated
     * @return the join result
     * @throws ExpressionException in case of expression problems
     * @throws VilLanguageException in case of execution problems
     */
    private Object join(JoinExpression join) throws ExpressionException, VilLanguageException {
        List<IVilType> simpleResult = new ArrayList<IVilType>();
        List<IVilType[]> complexResult = new ArrayList<IVilType[]>();
        // simple (inefficient) join for the initial implementation...
        Collection<Object>[] collection = createCollectionArray(join.getVariablesCount());
        Iterator<Object>[] iter = createIteratorArray(join.getVariablesCount());
        for (int i = 0; i < join.getVariablesCount(); i++) {
            collection[i] = tracer.adjustSequenceForJoin(evaluate(join.getVariable(i)));
            iter[i] = collection[i].iterator();
        }

        // initialize
        boolean stop = false;
        int lastIndex = join.getVariablesCount() - 1;
        for (int i = 0; !stop && i <= lastIndex; i++) {
            if (iter[i].hasNext()) {
                setJoinVariableValue(join, i, iter[i].next());
            } else {
                stop = true;
            }
        }
        if (!stop && iter[lastIndex].hasNext()) {
            boolean propagate = false;
            while (iter[0].hasNext()) {
                if (propagate) {
                    // reset last iterator
                    iter[lastIndex] = collection[lastIndex].iterator();
                    setJoinVariableValue(join, lastIndex, iter[lastIndex].next());
                    // propagate
                    int pos = lastIndex - 1;
                    while (pos >= 0 && !iter[pos].hasNext()) {
                        pos--;
                    }
                    if (pos >= 0) {
                        setJoinVariableValue(join, pos, iter[pos].next());
                        for (int i = lastIndex - 1; i > pos; i--) {
                            iter[i] = collection[i].iterator();
                            if (iter[i].hasNext()) {
                                iter[i] = collection[i].iterator();
                                setJoinVariableValue(join, i, iter[i].next());
                            }
                        }
                    } // else end outer loop
                }
                evaluateJoinCombination(join, simpleResult, complexResult);
                // loop last
                while (iter[lastIndex].hasNext()) {
                    setJoinVariableValue(join, lastIndex, iter[lastIndex].next());
                    evaluateJoinCombination(join, simpleResult, complexResult);
                }
                propagate = true;
            }
        }
        Object result;
        if (1 == join.getVisibleVariablesCount()) {
            result = new FixedListSequence<IVilType>(simpleResult, types(join));
        } else {
            result = new FixedListSequence<IVilType[]>(complexResult, types(join));
        }
        return result;
    }
    
    /**
     * Sets the specified join variable.
     * 
     * @param join the join expression
     * @param index the index of the variable
     * @param value the value
     * @throws VilLanguageException in case that setting the variable fails
     */
    private void setJoinVariableValue(JoinExpression join, int index, Object value) throws VilLanguageException {
        environment.addValue(join.getVariable(index), value);
    }

    /**
     * Evaluates a join combination.
     * 
     * @param join the join to be evaluated
     * @param simpleResult modified in case of 1-sided joins
     * @param complexResult modified in case of multi-sided joins
     * @throws ExpressionException in case that the evaluation fails
     * @throws VilLanguageException in case that the evaluation fails
     */
    private void evaluateJoinCombination(JoinExpression join, List<IVilType> simpleResult, 
        List<IVilType[]> complexResult) throws ExpressionException, VilLanguageException {
        Boolean bool;
        if (null != join.getCondition()) {
            bool = (Boolean) join.getCondition().accept(this);
        } else {
            bool = Boolean.TRUE;
        }
        if (null != bool && bool.booleanValue()) {
            if (1 == join.getVisibleVariablesCount()) {
                simpleResult.add((IVilType) environment.getValue(join.getVisibleVariable(0)));
            } else {
                IVilType[] tmp = new IVilType[join.getVisibleVariablesCount()];
                for (int i = 0; i < join.getVisibleVariablesCount(); i++) {
                    tmp[i] = (IVilType) environment.getValue(join.getVisibleVariable(i));
                }
                complexResult.add(tmp);
            }
        }
        
    }

    /**
     * Returns the types to be used to parameterize the return type.
     * 
     * @param join the join expression
     * 
     * @return the types
     */
    @SuppressWarnings("unchecked")
    private static Class<? extends IVilType>[] types(JoinExpression join) {
        int count = join.getVisibleVariablesCount();
        Class<? extends IVilType>[] result = new Class[count];
        for (int i = 0; i < count; i++) {
            result[i] = join.getVisibleVariable(i).getType().getTypeClass();
        }
        return result;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilLanguageException {
        try {
            return decl.getExpression().accept(this);
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws ExpressionException {
        boolean failed = false;
        List<Object> result;
        RuleExecutionContext context = ruleStack.peek();
        TypeDescriptor<? extends IVilType> mapType = map.inferType();
        result = TypeDescriptor.VOID == mapType ? null : new ArrayList<Object>(); 
        try {
            environment.pushLevel();
            tracer.visitMap(map, environment);
            Object set = map.getExpression().accept(this);
            if (set instanceof Collection) {
                Collection<?> coll = (Collection<?>) set;
                if (coll.allowSequenceAdjustment()) {
                    coll = tracer.adjustSequenceForMap(coll);
                }
                for (Object entry : coll) {
                    if (map.getVariablesCount() > 1) {
                        Object[] data = (Object[]) entry;
                        for (int v = 0; v < map.getVariablesCount(); v++) {
                            VariableDeclaration var = map.getVariable(v);
                            environment.addValue(var, data[v]);
                            tracer.visitMapIteratorAssignment(var, data[v]);
                        }
                    } else {
                        VariableDeclaration var = map.getVariable(0);
                        environment.addValue(var, entry);
                        tracer.visitMapIteratorAssignment(var, entry);
                    }
                    Object iterResult = null;
                    IRuleElement determinesResult = map.determinesResult();
                    for (int e = 0; !failed && e < map.getBodyElementCount(); e++) {
                        IRuleElement elt = map.getBodyElement(e);
                        Object eltRes = elt.accept(this);
                        context.add(eltRes);
                        if (elt == determinesResult) {
                            iterResult = eltRes; // collect the last one
                        } else if (mayFail(elt)) {
                            failed = !checkConditionResult(eltRes, elt, ConditionTest.DONT_CARE);
                        }
                    }
                    if (null != result) {
                        result.add(iterResult);
                    }
                }
            }
            tracer.visitedMap(map, environment);
        } catch (VilLanguageException e) {
            throw new ExpressionException(e);
        } catch (ClassCastException e) { // for handcrafted models
            throw new ExpressionException(e.getMessage(), VilLanguageException.ID_INTERNAL); 
        } catch (IndexOutOfBoundsException e) { // for handcrafted models
            throw new ExpressionException("index out of bounds " + e.getMessage(), VilLanguageException.ID_INTERNAL);
        } finally {
            try {
                environment.popLevel();
            } catch (ArtifactException e) {
                throw new ExpressionException(e);
            }
        }
        return mapResult(mapType, result, failed);
    }
    
    /**
     * Creates the actual result of executing a {@link MapExpression}.
     * 
     * @param mapType the type of the map expression 
     * @param result the collected results (may be <b>null</b> if <code>type</code> is {@link TypeDescriptor#VOID})
     * @param failed whether the actual execution failed
     * @return the return object for the map
     */
    private static Object mapResult(TypeDescriptor<? extends IVilType> mapType, List<Object> result, boolean failed) {
        Object mapResult;
        if (null == result) {
            mapResult = !failed; // no problem as not processed further and allows further execution
        } else {
            TypeDescriptor<? extends IVilType>[] param;
            if (1 == mapType.getParameterCount()) {
                param = TypeDescriptor.createArray(1);
                param[0] = mapType.getParameterType(0);
            } else {
                param = null;
            }
            // may actually be empty - considered by checkConditionResult
            mapResult = new ListSequence<Object>(result, param); 
        }
        return mapResult;        
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        Object result = cst.getValue();
        // we have to care for $name and ${} but only in strings
        if (result instanceof String) {
            result = StringReplacer.substitute(result.toString(), environment, expressionParser, this);
        }
        return result;
    }

    @Override
    protected Rule dynamicDispatch(Rule operation, Object[] args) {
        return AbstractCallExpression.dynamicDispatch(operation, args, Rule.class);
    }
    
    @Override
    protected void handleParameterInSequence(IResolvableModel<VariableDeclaration> model, 
        Map<String, VariableDeclaration> varMap) throws VilLanguageException {
        if (model.getParameterCount() >= 3) {
            // check default sequence instead, source, config, target, optional
            boolean ok = TypeRegistry.projectType().isAssignableFrom(model.getParameter(0).getType());
            ok &= TypeRegistry.configurationType().isAssignableFrom(model.getParameter(1).getType());
            ok &= TypeRegistry.projectType().isAssignableFrom(model.getParameter(2).getType());
            if (ok) {
                setModelArgument(model.getParameter(0), getParameter(PARAM_SOURCE));
                setModelArgument(model.getParameter(1), getParameter(PARAM_CONFIG));
                setModelArgument(model.getParameter(2), getParameter(PARAM_TARGET));
                for (int p = 0; p < 3; p++) {
                    varMap.remove(model.getParameter(p).getName());
                }
            }
        }
    }

}
