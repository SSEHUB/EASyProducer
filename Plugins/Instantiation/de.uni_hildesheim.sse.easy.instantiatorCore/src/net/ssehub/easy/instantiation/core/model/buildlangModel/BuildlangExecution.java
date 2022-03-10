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

package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.io.output.NullWriter;
import org.apache.commons.lang.SystemUtils;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.AvailableModels;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.Status;
import net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand.ExecutableOperand;
import net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand.IExecutableOperandType;
import net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop.BuildCollectionApplicator;
import net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop.BuildEnablingApplicator;
import net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop.BuildExecutionApplicator;
import net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop.LhsRhsMatchLoop;
import net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop.RuleBodyExecutor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.BooleanMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.CompoundMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.MatchResolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.PathMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.StringMatchExpression;
import net.ssehub.easy.instantiation.core.model.common.Compound;
import net.ssehub.easy.instantiation.core.model.common.ExecutionVisitor;
import net.ssehub.easy.instantiation.core.model.common.IResolvableModel;
import net.ssehub.easy.instantiation.core.model.common.ITerminatable;
import net.ssehub.easy.instantiation.core.model.common.ITerminator;
import net.ssehub.easy.instantiation.core.model.common.ModelCallExpression;
import net.ssehub.easy.instantiation.core.model.common.StreamGobbler;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.expressions.IArgumentProvider;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionParser;
import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.StringReplacer;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry.ILanguage;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.FixedListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.Project;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;

/**
 * Executes a build language project. Please note that for full
 * functionality, {@link #setExpressionParser(IExpressionParser)}
 * must be called appropriately.
 * 
 * @author Holger Eichelberger
 */
public class BuildlangExecution extends ExecutionVisitor<Script, AbstractRule, VariableDeclaration, Resolver> 
    implements IBuildlangVisitor, RuleBodyExecutor, ITerminator {

    public static final ILanguage<Resolver> LANGUAGE = new ILanguage<Resolver>() {

        @Override
        public String getName() {
            return "VIL";
        }
        
    };
    
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

    /**
     * The name of the default main rule (called {@value}).
     */
    public static final String DEFAULT_MAIN_RULE = "main";
    
    private RuntimeEnvironment environment;
    private ITracer tracer;
    private File base;
    private String startRuleName;
    private List<Rule> failed = new ArrayList<Rule>();
    private MatchResolver matchResolver;
    private VariableFinder variableFinder;
    private ExecutableRules executableRules;
    private Stack<RuleExecutionContext> ruleStack = new Stack<RuleExecutionContext>();
    private Resolver resolver;
    private boolean enableRuleElementFailed = true;
    private boolean stop = false;
    private Set<ITerminatable> terminatables = new HashSet<ITerminatable>();
        
    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param parameter the top-level parameter for the script to be executed
     */
    public BuildlangExecution(ITracer tracer, File base, Map<String, Object> parameter) {
        this(tracer, base, DEFAULT_MAIN_RULE, parameter);
    }
    
    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param startRuleName the name of the start rule; if multiple source projects are given,
     *   as a convention the first one shall the top-level project that needs to be executed.
     * @param parameter the top-level parameter for the script to be executed
     */
    public BuildlangExecution(ITracer tracer, File base, String startRuleName, Map<String, Object> parameter) {
        super(new RuntimeEnvironment(), tracer, parameter);
        this.tracer = tracer;
        this.environment = getRuntimeEnvironment();
        this.base = base;
        this.startRuleName = startRuleName;
        initialize();
    }

    /**
     * Creates a new execution visitor for import expression evaluation.
     * 
     * @param environment the runtime environment to be used for expression evaluation
     */
    protected BuildlangExecution(RuntimeEnvironment environment) {
        super(environment, NoTracer.INSTANCE, new HashMap<String, Object>());
        this.tracer = NoTracer.INSTANCE;
        this.environment = environment;
        this.base = new File("");
        this.startRuleName = DEFAULT_MAIN_RULE;
        initialize();
    }
    
    /**
     * Stops the execution, e.g., within endless loops constructed by the user.
     */
    public void stop() {
        this.stop = true;
        for (ITerminatable t : terminatables) {
            t.stop();
        }
    }
    
    /**
     * Enables / disables failed rule elements in some situations.
     * 
     * @param enableRuleElementFailed whether rule elements shall be enabled
     * @return the old state
     */
    protected boolean setEnableRuleElementFailed(boolean enableRuleElementFailed) {
        boolean old = this.enableRuleElementFailed;
        this.enableRuleElementFailed = enableRuleElementFailed;
        return old;
    }
    
    /**
     * Creates the initial runtime environment.
     * 
     * @return the initial runtime environment
     */
    protected RuntimeEnvironment createRuntimeEnvironment() {
        return new RuntimeEnvironment(); // go with default VIL type registry as basis - switch context asks the model
    }
    
    @Override
    public RuntimeEnvironment getRuntimeEnvironment() {
        return (RuntimeEnvironment) super.getRuntimeEnvironment();
    }
    
    @Override
    protected ITracer getTracer() {
        return tracer;
    }
    
    @Override
    protected IExpressionParser<Resolver> getExpressionParser() {
        return ExpressionParserRegistry.getExpressionParser(LANGUAGE);
    }
    
    /**
     * Returns the top element on the rule stack.
     * 
     * @return the top element
     */
    protected RuleExecutionContext peekRuleStack() {
        return ruleStack.peek();
    }
    
    /**
     * Returns the size of the rule stack.
     * 
     * @return the size of the rule stack
     */
    protected int getRuleStackSize() {
        return ruleStack.size();
    }
    
    /**
     * Does common initializations based on already set values (requires {@link #environment) to be set properly).
     */
    private void initialize() {
        this.matchResolver = new MatchResolver(environment, getExpressionParser(), this);
        this.variableFinder = new VariableFinder();
        this.executableRules = createExecutableRulesInstance();
        this.resolver = new Resolver(environment.getTypeRegistry());
    }
    
    /**
     * Creates an executable rules instance.
     * 
     * @return the created instance
     */
    protected ExecutableRules createExecutableRulesInstance() {
        return new ExecutableRules();
    }
    
    /**
     * Makes <code>path</code> absolute with respect to <code>base</code> if necessary.
     * 
     * @param path the file to be made absolute
     * @param base the base path
     * @return the absolute file
     */
    private static File absolute(String path, File base) {
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
    public Object visitScript(Script script) throws VilException {
        environment.switchContext(script); // the initial context, method is called only from outside
        return executeScript(script, null);
    }
    
    /**
     * Executes the given script starting at <code>start</code>.
     * 
     * @param script the script to be executed
     * @param start the start rule (may be <b>null</b> to determine main)
     * @return the result of the execution
     * @throws VilException if the execution fails
     */
    private Object executeScript(Script script, RuleCallExpression start) throws VilException {
        Map<String, Object> scriptParam = determineScriptParam(start);
        resolver.pushModel(script);
        tracer.visitScript(script, environment);
        if (null != scriptParam) {
            scriptParam = replaceParameter(scriptParam);
        }
        visitModelHeader(script);
        List<File> vtlPaths = new ArrayList<File>();
        for (int p = 0; p < script.getParameterCount(); p++) {
            Object value;
            try {
                value = environment.getValue(script.getParameter(p));
            } catch (VilException e) {
                value = null; // don't care for undefined variables
            }
            if (value instanceof Configuration) {
                Configuration config = (Configuration) value;
                if (null == config.getRootScript()) {
                    config.setRootScript(script);
                }
            }
            String pName = script.getParameter(p).getName();
            if (pName.equals(PARAM_SOURCE) || pName.equals(PARAM_TARGET)) {
                if (value instanceof Project) {
                    vtlPaths.add(((Project) value).getVtlFolder().getAbsolutePath());
                }
                if (value instanceof Project[]) {
                    for (Project prj : (Project[]) value) {
                        vtlPaths.add(prj.getVtlFolder().getAbsolutePath());
                    }
                }
                
            }
        }
        executableRules.collect(script);
        IResolvableModel<VariableDeclaration, Script> oldContext = environment.switchContext(script);
        environment.setContextPaths(vtlPaths);
        processProperties(script, getTargetPath(script, scriptParam));
        checkConstants(script);
        tracer.visitScriptBody(script, environment);
        Object result;
        if (null == start) {
            result = executeDefault(script);
        } else {
            result = start.accept(this);
        }
        resolver.popModel();
        if (null != scriptParam) {
            scriptParam = replaceParameter(scriptParam);
        }
        environment.switchContext(oldContext);
        tracer.visitedScript(script);
        return result;
    }

    @Override
    public void release(boolean releaseDefault) {
        Object target = getParameter(PARAM_TARGET);
        if (target instanceof Project) {
            ((Project) target).release();
        }
        Object source = getParameter(PARAM_SOURCE);
        if (source != target && source instanceof Project) {
            ((Project) source).release();
        }
        if (releaseDefault) {
            ArtifactFactory.clearDefaultModel(); // may affect other executions
        }
    }
    
    /**
     * Executes the given <code>script</code> via its default entry point.
     * 
     * @param script the script to be executed
     * @return the execution result
     * @throws VilException if execution fails
     */
    protected Object executeDefault(Script script) throws VilException {
        return executeMain(script, script.determineStartRule(startRuleName));
    }
    
    /**
     * Returns the target path or {@link #base}.
     * 
     * @param script the script to obtain the target path from
     * @param scriptParam the script parameters to consider (additional, may be <b>null</b>)
     * @return the path to the target project or {@link #base} if not found
     */
    private File getTargetPath(Script script, Map<String, Object> scriptParam) {
        File result = base;
        Object target = null;
        if (null != scriptParam) {
            target = scriptParam.get(PARAM_TARGET);
        }
        if (null == target && script.getParameterCount() >= 3) {
            try {
                target = environment.getValue(script.getParameter(2));
            } catch (VilException e) {
            }
            if (!(target instanceof Project)) {
                target = null;
            }
        }
        if (null == target) {
            for (int p = 0; null == target && p < script.getParameterCount(); p++) {
                VariableDeclaration decl = script.getParameter(p);
                if (decl.getName().equals(PARAM_TARGET)) {
                    try {
                        target = environment.getValue(decl);
                    } catch (VilException e) {
                    }
                }
            }
        }
        
        if (target instanceof Project) {
            result = ((Project) target).getPath().getAbsolutePath();
        }
        return result;
    }
    
    @Override
    protected void initializeImplicitVariables(IResolvableModel<VariableDeclaration, Script> model) 
        throws VilException {
        if (model instanceof Script) {
            Script script = (Script) model;
            VariableDeclaration var = script.getVariableDeclaration(Script.NAME_OTHERPROJECTS);
            if (null != var) {
                environment.addValue(var, environment.getOtherProjects());
            }
            var = script.getVariableDeclaration(Script.NAME_SCRIPTDIR);
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
        }
    }
    
    @Override
    protected ModelCallExpression<VariableDeclaration, Script, AbstractRule> createModelCall(Script model, 
        AbstractRule operation, CallArgument... arguments) throws VilException {
        return new RuleCallExpression(model, operation, arguments);
    }
    
    @Override
    protected void setModelArgument(VariableDeclaration param, Object value) throws VilException {
        // input may be Project or Project[] instance, expected may be collection or project
        // perform explicit conversion if possible - otherways fail and execution will fail anyway
        // this is needed for multi-project instantiation
        Object newVal = value;
        if (null != value) {
            TypeDescriptor<?> projectType = IvmlTypes.projectType();
            TypeDescriptor<?> type = param.getType();
            if (type.isCollection() && 1 == type.getGenericParameterCount() 
                && projectType.isAssignableFrom(type.getGenericParameterType(0))) {
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
                    if (pArray.length > 0) { // use also in array case the first project ... assumption on call
                        newVal = pArray[0];
                    }
                }
            }
        }
        super.setModelArgument(param, newVal);
    }

    /**
     * Processes the {@link LoadProperties}.
     * 
     * @param script the script to process the properties for
     * @param base the base path to make relative paths absolute
     * @throws VilException in case that something goes wrong
     */
    protected void processProperties(Script script, File base) throws VilException {
        Properties loaded = new Properties();
        for (int p = 0; p < script.getPropertiesCount(); p++) {
            LoadProperties prop = script.getProperties(p);
            String path = prop.getPath();
            path = StringReplacer.substitute(path, new Resolver(environment), getExpressionParser(), this, null);
            File file = absolute(path, base);
            loadProperties(file, loaded, null);
            if (SystemUtils.IS_OS_MAC) {
                loadProperties(file, loaded, "macos");
            } else if (SystemUtils.IS_OS_UNIX) {
                loadProperties(file, loaded, "unix");
            } else if (SystemUtils.IS_OS_WINDOWS) {
                loadProperties(file, loaded, "win");
            }
        }
        for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
            VariableDeclaration var = script.getVariableDeclaration(v);
            String value = loaded.getProperty(var.getName(), null);
            if (null != value) {
                if (var.isConstant() && null != var.getExpression()) {
                    throw new VilException("constant '" + var.getName() + "' is already assigned a value", 
                        VilException.ID_IS_CONSTANT);
                }
                Object actValue = evaluateExternalValue(var, value);
                environment.setValue(var, actValue);
                tracer.valueDefined(var, null, actValue);
            }
        }
    }
    
    /**
     * Loads properties from <code>file</code> into <code>prop</code> possibly overriding existing
     * properties. 
     * 
     * @param file the file name
     * @param prop the loaded properties (to be modified as a side effect)
     * @param os if not <b>null</b> to be inserted after the last "." with a following ".". If file
     *   not exists, no exception will be thrown.
     * @throws VilException in case of loading problems
     */
    private void loadProperties(File file, Properties prop, String os) throws VilException {
        boolean loadFile = true;
        if (null != os) {
            String f = file.toString();
            int pos = f.lastIndexOf('.');
            if (pos > 0 && pos < f.length()) {
                f = f.substring(0, pos + 1) + os + "." + f.substring(pos + 1);
                file = new File(f);
                loadFile = file.exists();
            } else {
                loadFile = false;
            }
        }
        if (loadFile) {
            try {
                FileInputStream fis = new FileInputStream(file);
                Properties p = new Properties();
                p.load(fis);
                prop.putAll(p);
                fis.close();
                
                for (String key : prop.stringPropertyNames()) {
                    String value = prop.getProperty(key);
                    // Replace value
                    try {
                        value = StringReplacer.substitute(value, new Resolver(environment), 
                            getExpressionParser(), this, null);
                    } catch (VilException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
                    }
                    prop.setProperty(key, value);
                }
            } catch (IOException e) {
                throw new VilException(e.getMessage(), e, VilException.ID_IO);
            }
        }
    }

    /**
     * Evaluates an external value for a given <code>var</code>.
     * 
     * @param var the variable to evaluate the value for
     * @param value the external value
     * @return the actual value for <code>var</code>
     * @throws VilException in case that conversion does not work
     */
    private Object evaluateExternalValue(VariableDeclaration var, String value) throws VilException {
        Object actValue;
        try {
            ConstantExpression ex = new ConstantExpression(var.getType(), value, environment.getTypeRegistry());
            actValue = ex.accept(this);
        } catch (VilException e) {
            // cannot be turned into a primitive value
            actValue = value;
            TypeDescriptor<?> varType = var.getType();
            TypeDescriptor<?> exType = TypeRegistry.stringType();
            if (!varType.isAssignableFrom(exType)) {
                OperationDescriptor desc = TypeDescriptor.findConversionOnBoth(exType, varType);
                if (null != desc) {
                    Expression ex = new ConstantExpression(exType, value, environment.getTypeRegistry());
                    ex = new CallExpression(desc, new CallArgument(ex));
                    actValue = ex.accept(this);
                }
            }
        }       
        return actValue;
    }

    /**
     * Checks the constant values for proper initialization.
     * 
     * @param script the project to process the properties for
     * @throws VilException in case that something goes wrong
     */
    private void checkConstants(Script script) throws VilException {
        for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
            VariableDeclaration var = script.getVariableDeclaration(v);
            if (var.isConstant()) {
                if (!environment.isDefined(var)) {
                    throw new VilException("constant '" + var.getName() + "' must be assigned a value " 
                        + "(either in script or via loaded properties)", VilException.ID_SEMANTIC);
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
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        Object result;
        if (stop || call.isPlaceholder()) {
            result = null;
        } else {
            result = visitStrategyCallExpressionImpl(call);
        }
        return result;
    }
    
    /**
     * Implements the strategy call execution of an executable call.
     * 
     * @param call the call to execute
     * @return the execution result
     * @throws VilException in case of execution problems
     */
    public Object visitStrategyCallExpressionImpl(StrategyCallExpression call) throws VilException {
        Object result;
        switch (call.getType()) {
        case EXECUTE:
            String exec;
            Object nameVarVal = environment.getValue(call.getNameVariable());
            if (nameVarVal instanceof Path) {
                exec = ((Path) nameVarVal).getAbsolutePath().getAbsolutePath();
            } else {
                exec = StringValueHelper.getStringValue(nameVarVal, null);
//              exec = StringReplacer.substitute(exec, environment, getExpressionParser(), this);
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
                    args[a] = type.convert(o);
                }
                args[a] = postprocessSystemCallArgument(args[a]);
//                    StringReplacer.substitute(args[a], environment, getExpressionParser(), this));
            }
            
            EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(StrategyCallExpression.class, Bundle.ID);
            logger.info("system call: " + Arrays.toString(args));
            tracer.visitSystemCall(args);
            ProcessBuilder builder = new ProcessBuilder(args);
            try {
                Process process = builder.start();
                StreamGobbler.gobble(process);
                int res = process.waitFor();
                logger.info("execution result: " + res);
            } catch (InterruptedException e) {
                throw new VilException(e, VilException.ID_SYSTEM_EXEC);
            } catch (IOException e) {
                throw new VilException(e, VilException.ID_SYSTEM_EXEC);
            }
            result = Boolean.TRUE;
            break;
        case INSTANTIATOR:
            tracer.visitingInstantiator(call.getName());
            result = visitCallExpression(call);
            tracer.visitedInstantiator(call.getName(), result);
            break;
        default:
            throw new VilException("illegal strategy type " + call.getType(), VilException.ID_INTERNAL);
        }
        return result;
    }
    
    /**
     * Adds additional implicit named parameters.
     * 
     * @param named the named parameters
     */
    protected void addImplicitParamters(java.util.Map<String, Object> named) {
        super.addImplicitParamters(named);
        named.put(Constants.IMPLICIT_TERMINATOR_NAME, this);
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        // done in processProperties
        return null;
    }
    
    /**
     * Registers the parameter of <code>rule</code>.
     * 
     * @param rule the rule to register the parameter for
     * @throws VilException in case of any execution error
     */
    private void registerParameter(AbstractRule rule) throws VilException {
        for (int p = 0; p < rule.getParameterCount(); p++) {
            VariableDeclaration var = rule.getParameter(p);
            IResolvable res = environment.get(var.getName());
            if (null == res) {
                throw new VilException("parameter " + var.getName() + " is not defined in rule " + rule.getSignature(), 
                    VilException.ID_RUNTIME_PARAMETER);
            } else {
                environment.addValue(var, environment.getValue(res));
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
     * @return depending on {@link Rule#returnActualValue()}, the actual body evaluation result or the execution status 
     * @throws VilException in case of serious execution problems
     */
    protected Object applyRuleBody(Rule rule, Object[] rhsValues, RuleExecutionContext context) 
        throws VilException {
        Object bodyRes = null;
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
                bodyRes = executeRuleBody(rule, context);
                status = Status.toStatus(bodyRes);
            }
        } else {
            // check for enabling
            BuildEnablingApplicator applicator = new BuildEnablingApplicator();
            LhsRhsMatchLoop.matchLoop(rule, rhsValues, applicator, tracer);
            status = applicator.allConditionsEnabled() ? Status.SUCCESS : Status.NOT_APPLICABLE;
        }
        Object result;
        if (null != context && rule.returnActualValue()) { // only if body shall be evaluated and has actual return val
            result = bodyRes;
        } else {
            result = status;
        }
        return result;
    }

    @Override
    public Object executeRuleBody(IRuleBlock ruleBody, RuleExecutionContext context) throws VilException {
        Status status = Status.SUCCESS;
        Object resVal = null;
        if (null != ruleBody) {
            int bodyEltCount = ruleBody.getBodyElementCount();
            int lastBodyEltIndex = bodyEltCount - 1;
            boolean returnActual = ruleBody.returnActualValue();
            for (int e = 0; Status.SUCCESS == status && e < bodyEltCount; e++) {
                IRuleElement elt = ruleBody.getBodyElement(e);
                Object eltVal = elt.accept(this);
                resVal = eltVal;
                if (mayFail(elt) // guard expression
                    && !checkConditionResult(eltVal, elt, ConditionTest.DONT_CARE)) {
                    if (enableRuleElementFailed && !(returnActual && e == lastBodyEltIndex)) {
                        if (ruleElementFailed(elt, context)) {
                            tracer.failedAt(ruleBody.getBodyElement(e));
                            status = Status.FAIL;
                        }
                    }
                } else {
                    context.add(eltVal);
                    if (Status.FAIL == context.getStatus()) {
                        status = Status.FAIL;
                    }
                }
            }
        }
        
        Object result;
        if (context.getRule().returnActualValue()) {
            if (Status.FAIL == status) {
                resVal = null;
            }
            result = resVal;
        } else {
            result = status;
        }
        return result;
    }

    /**
     * Is called when <code>elt</code> failed in execution, e.g., to put further information about
     * failing into the rule execution <code>context</code>.
     *  
     * @param elt the failing element 
     * @param context the rule execution context
     * @return <code>true</code> if the failure shall be recorded, <code>false</code> if the failure shall be ignored
     * @throws VilException in case that the evaluation of the failed element fails
     */
    protected boolean ruleElementFailed(IRuleElement elt, RuleExecutionContext context) throws VilException {
        return true;
    }
    
    /**
     * Resolves rule condition matches.
     * 
     * @param rule the rule to consider
     * @param side the side of the rule
     * @throws VilException in case of resolution problems
     */
    void resolveMatches(AbstractRule rule, Side side) throws VilException {
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
    boolean isOnStack(AbstractRule rule) {
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
     * @throws VilException in case of evaluating an LHS/RHS expression fails
     */
    private Status determineRhsLhsMatching(Rule rule, Object[] rhsValues) throws VilException {
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
            status = Status.toStatus(applyRuleBody(rule, rhsValues, null));
        }
        return status;
    }
    
    @Override
    public Object visitRule(Rule rule) throws VilException {
        boolean visited = false;
        Object bodyRes = null;
        boolean ruleExecResult = true;
        RuleExecutionContext context = new RuleExecutionContext(rule, environment);
        if (prepareExecution(context)) {
            tracer.visitRule(rule, environment);
            visited = true;
            if (Status.SUCCESS == context.getStatus()) {
                bodyRes = applyRuleBody(rule, context.getRhsValues(), context);
                ruleExecResult = bodyRes instanceof Status;
                context.setStatus(bodyRes);
                checkPostconditions(context);
            }
        }
        cleanupRuleExecution(context);
        Object result;
        if (ruleExecResult) {
            result = new RuleExecutionResult(context.getStatus(), context);
        } else {
            result = bodyRes;
        }
        if (visited) {
            tracer.visitedRule(rule, environment, result);
        }
        return result;
    } 
    
    @Override
    public Object visitRule(VtlRule rule) throws VilException {
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer tracer 
            = TracerFactory.createTemplateLanguageTracer();
        TracerFactory.registerTemplateLanguageTracer(tracer);
        Writer writer = new NullWriter(); // not for reuse
        Map<String, Object> localParam = new HashMap<String, Object>(); // by default
        localParam.put(PARAM_CONFIG, environment.getTopLevelConfiguration());
        localParam.put(PARAM_TARGET, null); // for now
        net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment<?, ?> oldEnv 
            = tracer.getRuntimeEnvironment(); // keep to reset, changed in TemplateLangExecution
        TemplateLangExecution exec = new TemplateLangExecution(tracer, writer, localParam);
        Def def = rule.getDef();
        Template template = (Template) def.getParent();
        net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment<
            net.ssehub.easy.instantiation.core.model.templateModel.VariableDeclaration, Template> tEnv 
            = exec.getRuntimeEnvironment();
        tEnv.switchContext(template);
        exec.visitModelHeader(template);
        // transfer and set argment values to template def parameter
        for (int p = 0; p < rule.getParameterCount(); p++) {
            VariableDeclaration var = rule.getParameter(p);
            net.ssehub.easy.instantiation.core.model.templateModel.VariableDeclaration defP = def.getParameter(p);
            IResolvable res = environment.get(var.getName());
            if (null == res) {
                throw new VilException("parameter " + var.getName() + " is not defined in rule " + rule.getSignature(), 
                    VilException.ID_RUNTIME_PARAMETER);
            } else {
                tEnv.addValue(defP, environment.getValue(res));
            }
        }
        Object result = def.accept(exec);
        TracerFactory.unregisterTemplateLanguageTracer(tracer);
        tracer.setRuntimeEnvironment(oldEnv); // reset, changed in TemplateLangExecution
        return result;
    }

    /**
     * Evaluates the rule header and returns whether the rule is applicable. Call 
     * {@link #checkPostconditions(RuleExecutionContext)} afterwards if required and 
     * {@link #cleanupRuleExecution(RuleExecutionContext)} at the end of the evaluation.
     * 
     * @param context the rule execution context, to be modified as a side effect (at least the 
     *   {@link RuleExecutionContext#getStatus() status}, possibly also the 
     *   {@link RuleExecutionContext#getRhsValues()} RHS values).
     * @return <code>true</code> if the {@link RuleExecutionContext#getRule() rule} is applicable, <code>false</code>
     *   else
     * @throws VilException in case of execution / evaluation problems
     */
    protected boolean prepareExecution(RuleExecutionContext context) throws VilException {
        boolean goOn;
        Rule rule = context.getRule();
        if (rule.isPlaceholder()) {
            context.setStatus(Status.NOT_APPLICABLE);
            goOn = false;
        } else {
            ruleStack.push(context);
            context.setStatus(Status.SUCCESS);
            environment.pushLevel(); 
            // evaluate parameter and replace generic matches
            registerParameter(rule);
            resolveMatches(rule, Side.RHS);
            resolveMatches(rule, Side.LHS);
            int rhsCondCount = rule.getRuleConditionCount(Side.RHS);
            if (rhsCondCount > 0) {
                Object[] rhsValues = new Object[rhsCondCount];
                context.setStatus(determineRhsLhsMatching(rule, rhsValues));
                context.setRhsValues(rhsValues);
            }
            for (int c = 0; Status.SUCCESS == context.getStatus() && c < rule.getRuleCallCount(Side.RHS); c++) {
                RuleCallExpression ex = rule.getRuleCall(Side.RHS, c);
                RuleExecutionResult res = (RuleExecutionResult) ex.accept(this);
                if (Status.FAIL == res.getStatus()) {
                    context.setStatus(Status.FAIL); // don't care fore not_applicable or success
                }
                environment.addValue(rule.getVariable(Side.RHS, rhsCondCount + c), res);
                context.add(res);
            }
            goOn = true;
        }
        return goOn;
    }
    
    /**
     * Checks the postconditions of the {@link RuleExecutionContext#getRule() rule}. Call 
     * {@link #prepareExecution(RuleExecutionContext)} before and 
     * {@link #cleanupRuleExecution(RuleExecutionContext)} after.
     * 
     * @param context the execution context, to be modified as a side effect with respect to the
     *   {@link RuleExecutionContext#getStatus() status}
     * @throws VilException in case of execution / evaluation problems
     */
    protected void checkPostconditions(RuleExecutionContext context) throws VilException {
        Rule rule = context.getRule();
        for (int c = 0; Status.SUCCESS == context.getStatus() && c < rule.getRuleConditionCount(Side.LHS); c++) {
            AbstractRuleMatchExpression ex = rule.getRuleCondition(Side.LHS, c);
            if (!checkConditionResult(ex.accept(this), ex, ConditionTest.EXISTS)) {
                context.setStatus(Status.FAIL);
                tracer.failedAt(ex);
            }
        }
    }

    /**
     * Cleans up the rule execution. 
     * 
     * @param context the execution context
     * @throws VilException in case of execution problems
     */
    protected void cleanupRuleExecution(RuleExecutionContext context) throws VilException {
        if (Status.NOT_APPLICABLE != context.getStatus()) {
            Rule rule = context.getRule();
            ruleStack.pop();
            environment.popLevel();
            if (Status.FAIL == context.getStatus()) {
                this.failed.add(rule);
            } else if (Status.SUCCESS == context.getStatus()) {
                context.addAllResults();
            }
        }
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
        return visitModelCallExpression(ex);
    }

    @Override
    protected Object executeModelCall(AbstractRule rule) throws VilException {
        Object result;
        if (stop) {
            result = null;
        } else {
            result = rule.accept(this);
        }
        return result;
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        return expression.evaluate(this);
    }
    
    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        return expression.getExpression().accept(this);
    }
    
    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        return expression.evaluate(this);
    }
    
    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        return expression.evaluate(this);
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        return expression.evaluate(this);
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        environment.pushLevel();
        Object result = join(ex);
        environment.popLevel();
        return result;
    }
    
    /**
     * Evaluates the condition for a variable.
     * 
     * @param var the variable to be evaluated
     * @return the evaluation result
     * @throws VilException in case of expression evaluation errors
     */
    @SuppressWarnings("unchecked")
    private Collection<Object> evaluate(JoinVariableDeclaration var) 
        throws VilException {
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
     * @throws VilException in case of execution problems
     */
    private Object join(JoinExpression join) throws VilException {
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
            result = new FixedListSequence<IVilType>(simpleResult, environment.getTypeRegistry(), types(join));
        } else {
            result = new FixedListSequence<IVilType[]>(complexResult, environment.getTypeRegistry(), types(join));
        }
        return result;
    }
    
    /**
     * Sets the specified join variable.
     * 
     * @param join the join expression
     * @param index the index of the variable
     * @param value the value
     * @throws VilException in case that setting the variable fails
     */
    private void setJoinVariableValue(JoinExpression join, int index, Object value) throws VilException {
        environment.addValue(join.getVariable(index), value);
    }

    /**
     * Evaluates a join combination.
     * 
     * @param join the join to be evaluated
     * @param simpleResult modified in case of 1-sided joins
     * @param complexResult modified in case of multi-sided joins
     * @throws VilException in case that the evaluation fails
     */
    private void evaluateJoinCombination(JoinExpression join, List<IVilType> simpleResult, 
        List<IVilType[]> complexResult) throws VilException {
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
    private static Class<?>[] types(JoinExpression join) {
        int count = join.getVisibleVariablesCount();
        Class<?>[] result = new Class[count];
        for (int i = 0; i < count; i++) {
            result[i] = join.getVisibleVariable(i).getType().getTypeClass();
        }
        return result;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        return decl.getExpression().accept(this);
    }
    
    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        Object result = null;
        Object condition = alt.getCondition().accept(this);
        if (condition instanceof Boolean) {
            boolean execThenPart = ((Boolean) condition).booleanValue();
            tracer.visitAlternative(execThenPart);
            IRuleBlock execute;
            if (execThenPart) {
                execute = alt.getIfPart();
            } else {
                execute = alt.getElsePart();
            }
            if (null != execute) {
                RuleExecutionContext context = ruleStack.peek();
                boolean failed = false;
                IRuleElement determinesResult = Utils.findLastExpressionStatement(execute);
                environment.pushLevel();
                for (int e = 0; !failed && e < execute.getBodyElementCount(); e++) {
                    IRuleElement elt = execute.getBodyElement(e);
                    Object eltRes = elt.accept(this);
                    context.add(eltRes);
                    if (elt == determinesResult) {
                        result = eltRes; // collect the last one
                    } else if (mayFail(elt)) {
                        failed = !checkConditionResult(eltRes, elt, ConditionTest.DONT_CARE);
                        if (enableRuleElementFailed) {
                            ruleElementFailed(elt, context);
                        }
                    }
                }
                environment.popLevel();
            }
        }
        return result;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        boolean failed = false;
        List<Object> result;
        TypeDescriptor<?> mapType = map.inferType();
        result = TypeRegistry.voidType() == mapType ? null : new ArrayList<Object>(); 
        try {
            environment.pushLevel();
            tracer.visitLoop(map, environment);
            failed = (null == executeLoop(map, true, result));
            tracer.visitedLoop(map, environment);
        } catch (ClassCastException e) { // for handcrafted models
            throw new VilException(e.getMessage(), VilException.ID_INTERNAL); 
        } catch (IndexOutOfBoundsException e) { // for handcrafted models
            throw new VilException("index out of bounds " + e.getMessage(), VilException.ID_INTERNAL);
        } 
        environment.popLevel();
        return mapResult(mapType, result, failed);
    }

    /**
     * Executes a loop.
     * 
     * @param loop the loop to be executed
     * @param parallelize whether execution may happen in parallel
     * @param result the result collector (may be <b>null</b> for no collection)
     * @return the last statement execution result
     * @throws VilException in case that expression evaluation fails
     */
    private Object executeLoop(IEnumeratingLoop loop, boolean parallelize, List<Object> result) 
        throws VilException {
        Object bodyResult = null;
        boolean failed = false;
        RuleExecutionContext context = ruleStack.peek();
        Expression expr = loop.getExpression();
        Object set = convertToContainer(expr, expr.accept(this), loop.getElementName());
        if (set instanceof Collection) {
            Collection<?> coll = (Collection<?>) set;
            if (coll.allowSequenceAdjustment()) {
                coll = tracer.adjustSequenceForMap(coll);
            }
            Iterator<?> iter = coll.iterator();
            while (iter.hasNext() && !stop) {
                Object entry = iter.next();
                if (loop.getVariablesCount() > 1) {
                    Object[] data = (Object[]) entry;
                    for (int v = 0; v < loop.getVariablesCount(); v++) {
                        VariableDeclaration var = loop.getVariable(v);
                        environment.addValue(var, data[v]);
                        tracer.visitIteratorAssignment(loop, var, data[v]);
                    }
                } else {
                    VariableDeclaration var = loop.getVariable(0);
                    environment.addValue(var, entry);
                    tracer.visitIteratorAssignment(loop, var, entry);
                }
                Object iterResult = null;
                IRuleElement determinesResult = loop.determinesResult();
                for (int e = 0; !failed && e < loop.getBodyElementCount(); e++) {
                    IRuleElement elt = loop.getBodyElement(e);
                    Object eltRes = elt.accept(this);
                    context.add(eltRes);
                    if (elt == determinesResult) {
                        iterResult = eltRes; // collect the last one
                    } else if (mayFail(elt)) {
                        failed = !checkConditionResult(eltRes, elt, ConditionTest.DONT_CARE);
                        if (enableRuleElementFailed) {
                            ruleElementFailed(elt, context);
                        }
                    }
                }
                if (null != result) {
                    result.add(iterResult);
                }
                bodyResult = iterResult;
            }
        }
        return bodyResult;
    }
    
    /**
     * Creates the actual result of executing a {@link MapExpression}.
     * 
     * @param mapType the type of the map expression 
     * @param result the collected results (may be <b>null</b> if <code>type</code> is {@link TypeDescriptor#VOID})
     * @param failed whether the actual execution failed
     * @return the return object for the map
     */
    private static Object mapResult(TypeDescriptor<?> mapType, List<Object> result, boolean failed) {
        Object mapResult;
        if (null == result) {
            mapResult = !failed; // no problem as not processed further and allows further execution
        } else {
            TypeDescriptor<?>[] param;
            if (1 == mapType.getGenericParameterCount()) {
                param = TypeDescriptor.createArray(1);
                param[0] = mapType.getGenericParameterType(0);
            } else {
                param = null;
            }
            // may actually be empty - considered by checkConditionResult
            mapResult = new ListSequence<Object>(result, param); 
        }
        return mapResult;        
    }
    
    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return cst.getValue();
    }

    @Override
    protected AbstractRule dynamicDispatch(AbstractRule operation, Object[] args, IArgumentProvider argumentProvider, 
        boolean enableParentScope) {
        return AbstractCallExpression.dynamicDispatch(operation, args, AbstractRule.class, 
            environment.getTypeRegistry(), argumentProvider, 
            enableParentScope ? environment.getMostSpecificContextModel() : null);
    }
    
    @Override
    protected void handleParameterInSequence(IResolvableModel<VariableDeclaration, Script> model, 
        Map<String, VariableDeclaration> varMap) throws VilException {
        if (model.getParameterCount() >= 3) {
            // check default sequence instead, source, config, target, optional
            boolean ok = IvmlTypes.projectType().isAssignableFrom(model.getParameter(0).getType());
            ok &= IvmlTypes.configurationType().isAssignableFrom(model.getParameter(1).getType());
            ok &= IvmlTypes.projectType().isAssignableFrom(model.getParameter(2).getType());
            if (ok) {
                assignModelParameter(model, model);
                for (int p = 0; p < 3; p++) {
                    varMap.remove(model.getParameter(p).getName());
                }
            }
        }
    }

    @Override
    protected void assignModelParameter(IResolvableModel<VariableDeclaration, Script> targetModel,
        IResolvableModel<VariableDeclaration, Script> srcModel) throws VilException {
        setModelArgument(srcModel, 0, PARAM_SOURCE);
        setModelArgument(srcModel, 1, PARAM_CONFIG);
        setModelArgument(srcModel, 2, PARAM_TARGET);
        evaluateModelParameter(targetModel, srcModel, 3);
    }

    /**
     * Sets a model argument.
     * 
     * @param srcModel the model to take the parameter from
     * @param index the index of the parameter to modify (for sequence-based assignment)
     * @param name the name of the parameter to modify (to retrieve the value, but also for name-based assignment)
     * @throws VilException in case that assigning the parameter fails
     */
    private void setModelArgument(IResolvableModel<VariableDeclaration, Script> srcModel, int index, String name) 
        throws VilException {
        if (srcModel.getParameterCount() >= index + 1) {
            try {
                setModelArgument(srcModel.getParameter(index), getParameter(name));
            } catch (VilException e) {
                VariableDeclaration decl = srcModel.getParameter(name);
                if (null != decl) {
                    setModelArgument(decl, getParameter(name));    
                } else {
                    throw e;
                }
            }
        }
    }
    
    /**
     * Resolves the script for an instantiation expression.
     * 
     * @param project the project to resolve the script on
     * @param restrictions the version restrictions (may be <b>null</b>)
     * @return the resolved script
     * @throws VilException in case that the version is not valid or that the script cannot be found
     */
    private Script resolveScript(Project project, IVersionRestriction restrictions) throws VilException {
        Script script = null;
        AvailableModels<Script> available = BuildModel.INSTANCE.availableModels();
        Script current = resolver.getCurrentModel();
        ModelInfo<Script> currentInfo = available.getModelInfo(current);
        try {
            script = BuildModel.INSTANCE.resolve(project.getName(), restrictions, 
                currentInfo.getLocation(), environment);
        } catch (ModelManagementException e) {
            throw new VilException(e.getMessage(), e.getId());
        }
        return script;
    }
    
    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
        // no tracer needed, will happen in ex.accept
        Script script = null;
        String name = null;
        if (null != inst.getProject()) {
            name = inst.getName();
            if (null == name) {
                name = DEFAULT_MAIN_RULE;
            }
            Object pr = environment.getValue(inst.getProject());
            if (pr instanceof Project) {
                Project project = (Project) pr;
                script = resolveScript(project, inst.getVersionRestriction()); // resolve it in the local context
                if (null == script) { // fallback - ask the project
                    script = project.getMainVilScript();  
                }
                if (null == script) {
                    // this may only happen if the projects are initially passed in as files
                    throw new VilException("cannot resolve script " + name + " in project " 
                        + project.getName() , VilException.ID_RUNTIME);
                }
            }
            if (null == script) {
                // this may only happen if the projects are initially passed in as files
                throw new VilException("cannot resolve script " + name, VilException.ID_RUNTIME);
            }
            resolver.pushModel(script);
        } else {
            name = inst.getQualifiedName();
        }
        
        CallArgument[] args = new CallArgument[inst.getArgumentsCount()];
        for (int a = 0; a < args.length; a++) {
            args[a] = inst.getArgument(a);
        }
        RuleCallExpression ex = resolver.createCallExpression(false, name, args);
        if (null != inst.getProject()) {
            resolver.popModel();
        }
        if (null == ex) {
            throw new VilException("cannot resolve rule " + name, VilException.ID_RUNTIME);
        }
        Object result;
        if (null == script) {
            result = ex.accept(this);
        } else {
            result = executeScript(script, ex);
        }
        return result;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        return expression.evaluate(this);
    }
    
    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        Object result;
        Object val = environment.getValue(ex.getVariable());
        if (val instanceof Rule) {
            Rule rule = (Rule) val;
            result = proceedModelCall(rule, rule.getParent(), ex, false, false);
            //result = ((IBuildlangElement) val).accept(this);
        } else {
            result = super.visitResolvableOperationCallExpression(ex);
        }
        return result;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return null; // typedefs are processed during parsing
    }

    @Override
    public Object visitWhileStatement(WhileStatement stmt) throws VilException {
        Expression condition = stmt.getCondition();
        boolean executeLoop = false;
        RuleExecutionContext context = ruleStack.peek();
        Object bodyResult = null;
        do {
            Object conditionResult = condition.accept(this);
            executeLoop = (conditionResult instanceof Boolean && (Boolean) conditionResult);
            if (executeLoop) {
                tracer.visitWhileBody();
                bodyResult = executeRuleBody(stmt, context);
                if (null == bodyResult) {
                    executeLoop = false;
                }
                tracer.visitedWhileBody();
            }
        } while (executeLoop && !stop);
        return bodyResult;
    }

    @Override
    public Object visitForStatement(ForStatement stmt) throws VilException {
        Object result = null;
        try {
            environment.pushLevel();
            tracer.visitLoop(stmt, environment);
            result = executeLoop(stmt, false, null);
            tracer.visitedLoop(stmt, environment);
        } catch (ClassCastException e) { // for handcrafted models
            throw new VilException(e.getMessage(), VilException.ID_INTERNAL); 
        } catch (IndexOutOfBoundsException e) { // for handcrafted models
            throw new VilException("index out of bounds " + e.getMessage(), VilException.ID_INTERNAL);
        } 
        environment.popLevel();
        return result;
    }

    @Override
    public void register(ITerminatable terminatable) {
        if (null != terminatable) {
            terminatables.add(terminatable);
        }
    }
    
    // TODO -> stop() terminate all, pass to VIL

    @Override
    public void unregister(ITerminatable terminatable) {
        if (null != terminatable) {
            terminatables.remove(terminatable);
        }
    }

    @Override
    public Object visitCompound(Compound compound) throws VilException {
        return null; // declaration is not executed
    }

}
