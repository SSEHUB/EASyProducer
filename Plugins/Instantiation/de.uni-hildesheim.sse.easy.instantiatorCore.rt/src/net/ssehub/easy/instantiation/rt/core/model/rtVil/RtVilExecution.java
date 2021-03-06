package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleCallExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleDescriptor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionContext;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.Status;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry.ILanguage;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IChangeHistoryTracer;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.AbstractBreakdownCall.TupleField;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.types.RtVilTypeRegistry;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.types.TupleType;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.types.TupleType.TupleInstance;
import net.ssehub.easy.reasoning.core.frontend.ReasonerAdapter;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Executes an rtVil adaptation script.
 * 
 * @author Holger Eichelberger
 */
public class RtVilExecution extends BuildlangExecution implements IRtVilVisitor {
    
    public static final ILanguage<Resolver> LANGUAGE = new ILanguage<Resolver>() {

        @Override
        public String getName() {
            return "rt-VIL";
        }
        
    };
    
    public static final ReasonerConfiguration REASONER_CONFIGURATION = new ReasonerConfiguration();
    
    static {
        REASONER_CONFIGURATION.setRuntimeMode(true);
    }
    
    /**
     * Defines a fallback in case that a dynamic call cannot be resolved.
     * 
     * @author Holger Eichelberger
     */
    private interface IDynamicCallFallback {

        /**
         * Implements the specific fallback call.
         * 
         * @param evaluator the current evaluator instance
         * @param args the call arguments
         * @return the call result
         * @throws VilException in case that the call fails
         */
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException;
    }

    /**
     * A fallback to IVML reasoning. The second argument is the current configuration 
     * in terms of a VIL instance.
     */
    private static final IDynamicCallFallback VALIDATE_FALLBACK = new IDynamicCallFallback() {
        
        // checkstyle: stop exception type check
        
        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            IRtVilConcept concept = obtainConcept(evaluator, 0, args);
            Configuration cfg = obtainConfiguration(evaluator, 1, args);
            return evaluator.reason(cfg, concept, null);
        }
        
        // checkstyle: resume exception type check

    };
    
    /**
     * A fallback to no reasoning.
     */
    private static final IDynamicCallFallback VALIDATE_NO_REASONER_FALLBACK = new IDynamicCallFallback() {

        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            evaluator.getTracer().trace("Reasoner execution: " + true); // keep testing stable although disabled
            return true;
        }
    };

    /**
     * A fallback for the start VIL rule.
     */
    private static final IDynamicCallFallback START_FALLBACK = new IDynamicCallFallback() {
        
        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            Configuration cfg = obtainConfiguration(evaluator, 1, args);
            if (null != cfg) {
                cfg.getChangeHistory().start();
            }
            return null;
        }
    };

    /**
     * A fallback for the succeeded VIL rule.
     */
    private static final IDynamicCallFallback SUCCEEDED_FALLBACK = new IDynamicCallFallback() {
        
        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            Configuration cfg = obtainConfiguration(evaluator, 1, args);
            if (null != cfg) {
                cfg.getChangeHistory().commit();
            }
            return null;
        }
    };
    
    /**
     * A fallback for the update VIL rule.
     */
    private static final IDynamicCallFallback UPDATE_FALLBACK = new IDynamicCallFallback() {
        
        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            return null;
        }
    };
    
    /**
     * A fallback for the failed VIL rule.
     */
    private static final IDynamicCallFallback FAILED_FALLBACK = new IDynamicCallFallback() {
        
        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            Configuration cfg = obtainConfiguration(evaluator, 1, args);
            if (null != cfg) {
                cfg.getChangeHistory().rollback();
            }
            return null;
        }
    };

    /**
     * A fallback for the bind values VIL rule.
     */
    private static final IDynamicCallFallback BIND_VALUES_FALLBACK = new IDynamicCallFallback() {

        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            return null;
        }
        
    };

    /**
     * A fallback for the initialize VIL rule.
     */
    private static final IDynamicCallFallback INITIALIZE_FALLBACK = new IDynamicCallFallback() {

        @Override
        public Object call(RtVilExecution evaluator, CallArgument... args) throws VilException {
            return null;
        }
        
    };

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(RtVilExecution.class, Bundle.ID);

    private List<IRtVilConcept> successful = new LinkedList<IRtVilConcept>();
    private boolean stopAfterBindValues = false;
    private boolean useReasoner = true;
    private boolean enableEnactment = true;
    private Script currentScript;
    private IRtValueAccess valueAccess;
    private IReasoningHook reasoningHook = DefaultReasoningHook.INSTANCE;
    private String lastFailReason;
    private Integer lastFailCode;
    private ITracer rtTracer;
    private IChangeHistoryTracer chgTracer;
    private int nestedStrategyCount;
    private ReasonerAdapter reasonerCache = new ReasonerAdapter();
    
    /**
     * Creates a new execution environment for evaluating local expressions.
     */
    public RtVilExecution() {
        super(new RuntimeEnvironment(RtVilTypeRegistry.INSTANCE));
    }

    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param parameter the top-level parameter for the script to be executed
     */
    public RtVilExecution(net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer tracer, File base, 
        Map<String, Object> parameter) {
        super(tracer, base, parameter);
        this.valueAccess = new IRtValueAccess() {
            
            @Override
            public Object getValue(net.ssehub.easy.instantiation.core.model.common.
                VariableDeclaration var) throws VilException {
                return getRuntimeEnvironment().getValue(var);
            }
        };
        if (tracer instanceof ITracer) {
            rtTracer = (ITracer) tracer;
        }
    }

    /**
     * Defines whether execution shall stop after binding monitoring values (default: false).
     * 
     * @param stopAfterBindValues whether the full script shall be executed or only values shall be bound to initialize
     *   the runtime configuration
     */
    public void setStopAfterBindValues(boolean stopAfterBindValues) {
        this.stopAfterBindValues = stopAfterBindValues;
    }

    /**
     * Defines whether the reasoner shall be used (default: true).
     * 
     * @param useReasoner make use of the reasoner or default to consistent model
     */
    public void setUseReasoner(boolean useReasoner) {
        this.useReasoner = useReasoner;        
    }
    
    /**
     * Enables or disables the enactment phase (default: enabled).
     * 
     * @param enableEnactment enables the enactment
     */
    public void setEnableEnactment(boolean enableEnactment) {
        this.enableEnactment = enableEnactment;
    }
    
    /**
     * Defines the actual reasoning hook.
     * 
     * @param reasoningHook the reasoning hook (ignored if <b>null</b>)
     */
    public void setReasoningHook(IReasoningHook reasoningHook) {
        if (null != reasoningHook) {
            this.reasoningHook = reasoningHook;
        }
    }
    
    /**
     * Sets the reasoner cache. No change happens if {@code reasonerCache} is <b>null</b>.
     * 
     * @param reasonerCache the reasoner cache
     */
    public void setReasonerCache(ReasonerAdapter reasonerCache) {
        if (null != reasonerCache) {
            this.reasonerCache = reasonerCache;
        }
    }
    
    /**
     * Compose the plain text of reasoner failures.
     * 
     * @param msg the message to be turned into text
     * @return the description text
     */
    public static String toText(Message msg) {
        String result = msg.getDescription();
        List<Set<IDecisionVariable>> info = msg.getProblemVariables();
        if (null != info) {
            result += " problem vars: ";
            Iterator<Set<IDecisionVariable>> iter = info.iterator();
            while (iter.hasNext()) {
                Set<IDecisionVariable> set = iter.next();
                result += "{";
                Iterator<IDecisionVariable> iter2 = set.iterator();
                while (iter2.hasNext()) {
                    IDecisionVariable var = iter2.next();
                    result += net.ssehub.easy.varModel.confModel.Configuration.getInstanceName(var);
                    if (iter2.hasNext()) {
                        result += ", ";
                    }
                }
                result += "}";
                if (iter.hasNext()) {
                    result += ", ";
                }
            }
        }

        List<Constraint> cstr = msg.getProblemConstraints();
        if (null != cstr && cstr.size() > 0) {
            result += "problem constraints: ";
            for (int i = 0; i < cstr.size(); i++) {
                if (i > 0) {
                    result += ", ";
                }
                result += StringProvider.toIvmlString(cstr.get(i).getConsSyntax());
            }
        }
        return result;
    }

    // checkstyle: stop exception type check

    /**
     * Performs reasoning for rt-VIL based on the knowledge in this instance.
     * 
     * @param cfg the configuration to reason on (may be a projected one, shall be compliant with the 
     *     configuration the executor was called or one of its projections)
     * @param concept the language concept the reasoning was called for (as required by the reasoning hook, may 
     *     be <b>null</b>)
     * @param listener an optional listener to be informed about the filtered reasoning results (may be <b>null</b>)
     * @return the execution result for rt-VIL
     */
    protected Object reason(Configuration cfg, IRtVilConcept concept, IReasoningResultListener listener) {
        Object result = null;
        if (null != cfg) {
            if (null == listener) {
                listener = DefaultReasoningResultListener.INSTANCE;
            }
            net.ssehub.easy.varModel.confModel.Configuration easyConfig = cfg.getConfiguration();
            EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(RtVilExecution.class, Bundle.ID);
            reasoningHook.preReasoning(currentScript, concept, valueAccess, cfg);
            ReasoningResult rResult = null;
            try {
                rResult = reasonerCache.propagate(easyConfig, REASONER_CONFIGURATION, ProgressObserver.NO_OBSERVER);
                //rResult = ReasonerFrontend.getInstance().propagate(easyConfig.getProject(), 
                //    easyConfig, REASONER_CONFIGURATION, ProgressObserver.NO_OBSERVER);
            } catch (Throwable t) {
                // pretend it is ok
                logger.error("Reasoning exception: " + t.getMessage() + " - going on");
            }
            reasoningHook.postReasoning(currentScript, concept, valueAccess, cfg, rResult);
            listener.notifyReasoningResult(rResult);
            int errorCount = 0;
            for (int m = 0; m < rResult.getMessageCount(); m++) {
                Message msg = rResult.getMessage(m);
                net.ssehub.easy.basics.messages.Status status = reasoningHook.analyze(
                    currentScript, concept, valueAccess, msg);
                if (null != status) {
                    switch (status) {
                    case UNSUPPORTED:
                    case ERROR:
                        errorCount++;
                        logger.error(toText(msg));
                        break;
                    case INFO:
                        logger.info(toText(msg));
                        break;
                    case WARNING:
                        logger.warn(toText(msg));
                        break;
                    default:
                        logger.info(toText(msg));
                        break;
                    }
                    listener.notifyMessage(msg, status);
                }
            }
            boolean ok = (0 == errorCount);
            getTracer().trace("Reasoner execution ok: " + ok);
            logger.warn("Reasoner execution ok: " + ok);
            if (!ok) {
                reasoningHook.reasoningFailed(cfg);
            }
            listener.notifyAssessmentResult(ok);
            result = ok;
        }
        return result;
    }
    
    // checkstyle: resume exception type check

    /**
     * Obtains a typed argument instance from the given dynamic call fallback argument. [helper]
     * 
     * @param <T> the argument type
     * @param evaluator the evaluator
     * @param argument the 0-based argument index pointing to the argument in <code>args</code> to be returned
     * @param type the argument type class
     * @param args the actual arguments
     * @return the typed argument instance (may be <b>null</b> if it does not exist or it is of a different type)
     * @throws VilException in case that evaluating the specified argument in <code>evaluator</code> fails
     */
    private static <T> T obtainArgument(RtVilExecution evaluator, int argument, Class<T> type, CallArgument... args) 
        throws VilException {
        T result;
        if (0 <= argument && argument < args.length) {
            Object tmp = args[argument].accept(evaluator);
            if (type.isInstance(tmp)) {
                result = type.cast(tmp);
            } else {
                result = null;
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Obtains a concept argument instance from the given dynamic call fallback argument. [helper]
     * 
     * @param evaluator the evaluator
     * @param argument the 0-based argument index pointing to the concept argument in <code>args</code> to be returned
     * @param args the actual arguments
     * @return the concept instance (may be <b>null</b> if it does not exist or it is of a different type)
     * @throws VilException in case that evaluating the specified argument in <code>evaluator</code> fails
     */
    private static IRtVilConcept obtainConcept(RtVilExecution evaluator, int argument, CallArgument... args) 
        throws VilException {
        return obtainArgument(evaluator, argument, IRtVilConcept.class, args);
    }

    /**
     * Obtains a configuration argument instance from the given dynamic call fallback argument. [helper]
     * 
     * @param evaluator the evaluator
     * @param argument the 0-based argument index pointing to the configuration argument in <code>args</code> to 
     *     be returned
     * @param args the actual arguments
     * @return the configuration instance (may be <b>null</b> if it does not exist or it is of a different type)
     * @throws VilException in case that evaluating the specified argument in <code>evaluator</code> fails
     */
    private static Configuration obtainConfiguration(RtVilExecution evaluator, int argument, CallArgument... args) 
        throws VilException {
        return obtainArgument(evaluator, argument, Configuration.class, args);
    }

    @Override
    protected Object executeDefault(net.ssehub.easy.instantiation.core.model.buildlangModel.Script script)
        throws VilException {
        RuleExecutionResult result = null;
        if (!stopAfterBindValues) {
            if (null != rtTracer) {
                rtTracer.startStrategies();
                attachChangeHistoryTracer();
            }
            VilException exc = null;
            try {
                List<Strategy> strategies = determineStrategiesRanking((Script) script);
                for (int s = 0; (null == result || Status.SUCCESS != result.getStatus()) 
                    && s < strategies.size(); s++) {
                    Object tmp = strategies.get(s).accept(this);
                    if (tmp instanceof RuleExecutionResult) {
                        result = (RuleExecutionResult) tmp;
                    }
                }
                persistVariables(script);
            } catch (VilException e) {
                exc = e;
            }
            if (doSimulationRollback()) {
                // allow reuse of configuration - get rid of all changes
                for (int i = 0; i < script.getParameterCount(); i++) {
                    if (clearCfg(script.getParameter(i))) {
                        break;
                    }
                }
            }
            if (null != rtTracer) {
                detachChangeHistoryTracer();
            }
            if (null != exc) {
                throw exc;
            }
            if (null != rtTracer) {
                rtTracer.endStrategies();
            }
        } else {
            RuleDescriptor desc = new RuleDescriptor();
            Rule dummy = new Rule("dummy", true, null, desc, script);
            result = new RuleExecutionResult(Status.SUCCESS, new RuleExecutionContext(dummy, getRuntimeEnvironment()));
        }
        return result;
    }

    /**
     * Attaches the change history tracer to the change history.
     */
    private void attachChangeHistoryTracer() {
        try {
            if (rtTracer instanceof IChangeHistoryTracer) {
                Configuration cfg = getCurrentConfigurationIvml();
                if (null != cfg) {
                    chgTracer = cfg.getChangeHistory().setTracer((IChangeHistoryTracer) rtTracer);
                }
            }
        } catch (VilException e) {
            LOGGER.info(e.getMessage());
        }
    }

    /**
     * Detaches a previously attached change history tracer to the change history.
     * Call in pair with {@link #attachChangeHistoryTracer()} only.
     */
    private void detachChangeHistoryTracer() {
        try {
            Configuration cfg = getCurrentConfigurationIvml();
            if (null != cfg) {
                cfg.getChangeHistory().setTracer(chgTracer);
                chgTracer = null;
            }    
        } catch (VilException e) {
            LOGGER.info(e.getMessage());
        }
    }
    
    /**
     * Returns whether we are in a simulation and shall roll back the configuration changes.
     * 
     * @return <code>true</code> for roll back, <code>false</code> else
     */
    private boolean doSimulationRollback() {
        ISimulationNotifier notifier = RtVilStorage.getSimulationNotifier();
        return null != notifier ? notifier.doRollbackSimulation() : false; 
    }
    
    /**
     * Clears the configuration of <code>param</code> is a configuration parameter.
     * 
     * @param param the parameter
     * @return <code>true</code> if <code>param</code> is a configuration parameter, <code>false</code> else
     * @throws VilException in case of an evaluation problem
     */
    private boolean clearCfg(VariableDeclaration param) throws VilException {
        boolean found = false;
        if (IvmlTypes.configurationType().isAssignableFrom(param.getType())) {
            if (getRuntimeEnvironment().isDefined(param)) {
                Configuration cfg = (Configuration) getRuntimeEnvironment().getValue(param);
                if (null != cfg) {
                    cfg.getChangeHistory().rollbackSimulation(); // calls clear(true)
                }
            }
            found = true;
        }
        return found;
    }
    
    /**
     * Determines the active strategies an their ranking.
     * 
     * @param script the script to rank the strategies for
     * @return the applicable and ranked strategies (may be empty)
     * @throws VilException in case of execution / evaluation problems
     */
    private List<Strategy> determineStrategiesRanking(Script script) throws VilException {
        List<Strategy> strategies = script.getTopLevelStrategies(true, false); // can be called on script level
        List<Strategy> result = new ArrayList<Strategy>();
        for (int s = 0; s < strategies.size(); s++) {
            Strategy strategy = strategies.get(s);
            if (doArgumentsMatch(strategy) && isApplicable(strategy)) {
                result.add(strategy);
            }
        }
        if (result.size() > 1) {
            Map<Object, Number> ranking = new HashMap<Object, Number>();
            for (int s = 0; s < result.size(); s++) { 
                Strategy strategy = result.get(s);
                ranking.put(strategy, getRanking(script, strategy));
            }
            Collections.sort(result, new RankingComparator(ranking, false)); // stable sort required!
        }
        return result;
    }
    
    /**
     * Returns whether the arguments for a given strategy do match.
     * 
     * @param strategy the strategy to check for
     * @return <code>true</code> if the arguments match, <code>false</code> else
     */
    private boolean doArgumentsMatch(Strategy strategy) {
        int maxParam = Math.min(strategy.getParameterCount(), getParameterCount());
        boolean matches = true;
        if (getParameterCount() >= 3 && strategy.getParameterCount() < 3) {
            // due to tests, in case of 3 default parameters require them
            matches = false;
        }
        TypeRegistry registry = getRuntimeEnvironment().getTypeRegistry();
        for (int p = 0; matches && p < maxParam; p++) {
            VariableDeclaration decl = strategy.getParameter(p);
            Object param = getParameter(decl.getName());
            if (null != param) {
                TypeDescriptor<?> type = registry.getType(param.getClass());
                matches &= (null != type && decl.getType().isAssignableFrom(type));
            } else {
                matches = true;
            }
        }
        return matches;
    }
    
    /**
     * Returns the ranking of the given top level <code>strategy</code> in terms of its parameter 
     * type compliance within <code>script</code>, i.e., with respect to the actual script parameters.
     * 
     * @param script the script to be considered
     * @param strategy the top-level strategy within <code>script</code> to be considered
     * @return the ranking of the <code>strategy</code>
     */
    private int getRanking(Script script, Strategy strategy) {
        int maxCommonCount = Math.min(script.getParameterCount(), strategy.getParameterCount());
        int result = 0;
        for (int p = 0; p < maxCommonCount; p++) {
            IMetaType scriptType = script.getParameter(p).getType();
            IMetaType strategyType = strategy.getParameterType(p);
            if (scriptType.equals(strategyType)) {
                result += maxCommonCount;
            } else { // must be assignable
                result += 1; // 0 shall also be ok
            }
        }
        return result;
    }
    
    /**
     * Determines the ranking of the active breakdown calls in <code>context</code> using the weighting function of a 
     * strategy if defined.
     * 
     * @param context the context to take the active breakdown calls from
     * @return the ranking of the active breakdown calls (may be empty)
     * @throws VilException in case that ranking the strategies fails
     */
    private List<AbstractBreakdownCall> determineBreakdownRanking(StrategyExecutionContext context) 
        throws VilException {
        
        List<AbstractBreakdownCall> result = new ArrayList<AbstractBreakdownCall>();
        for (int c = 0; c < context.getBreakdownCallCount(); c++) {
            result.add(context.getBreakdownCall(c)); // already active
        }
        WeightingFunction wf = context.getRule().getWeightingFunction();
        if (result.size() > 1 && wf != null) {
            Map<Object, Number> ranking = new HashMap<Object, Number>();
            RuntimeEnvironment env = getRuntimeEnvironment();
            env.pushLevel();
            VariableDeclaration wfVar = wf.getVariable();
            IMetaType wfVarType = wfVar.getType();
            TupleInstance wfVarInst = null;
            Object varVal;
            if (wfVarType instanceof TupleType) {
                wfVarInst = new TupleInstance((TupleType) wfVarType);
                varVal = wfVarInst;
            } else {
                varVal = null;
            }
            env.addValue(wfVar, varVal);
            for (int s = 0; s < result.size(); s++) {
                AbstractBreakdownCall call = result.get(s);
                if (wfVarInst != null) {
                    wfVarInst.clear();
                    for (int f = 0; f < wfVarType.getFieldCount(); f++) {
                        String fName = wfVarType.getField(f).getName();
                        TupleField field = call.getTupleField(fName);
                        if (null != field) {
                            wfVarInst.put(fName, field.getValueExpression().accept(this));
                        }
                    }
                    // already set in env
                } else {
                    env.setValue(wfVar, call.getResolved());
                }
                Object wValue = wf.getExpression().accept(this);
                if (wValue instanceof Number) {
                    ranking.put(call, (Number) wValue);
                }
            }
            env.popLevel();
            Collections.sort(result, new RankingComparator(ranking, true)); // maximize
        }
        return result;
    }

    /**
     * Implements a ranking comparator. The ranking is given as a map.
     * 
     * @author Holger Eichelberger
     */
    private static class RankingComparator implements Comparator<Object> {
        
        private Map<Object, Number> ranking;
        private int factor;

        /**
         * Creates the ranking comparator.
         * 
         * @param ranking the ranking - all objects in the collection to be sorted must be given
         * @param reverse reverse the ranking (<code>false</code> lowest first)
         */
        RankingComparator(Map<Object, Number> ranking, boolean reverse) {
            this.ranking = ranking;
            this.factor = reverse ? -1 : 1;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Number r1 = ranking.get(o1);
            Number r2 = ranking.get(o2);
            return factor * Double.compare(r1.doubleValue(), r2.doubleValue()); // max first
        }
        
    }

    /**
     * Process the leading variables of a strategy.
     *  
     * @param strategy the strategy to process the variables for
     * @throws VilException in case of problems during variable processing
     */
    private void processVariables(Strategy strategy) throws VilException {
        for (int v = 0; v < strategy.getVariableDeclarationCount(); v++) {
            strategy.getVariableDeclaration(v).accept(this);
        }
    }
    
    /**
     * Returns whether a <code>strategy</code> is applicable.
     * 
     * @param strategy the strategy to be checked
     * @return <code>true</code> if <code>strategy</code> is applicable
     * @throws VilException in case of evaluation problems
     * 
     * @see #isApplicable(Strategy, RuleExecutionContext)
     */
    private boolean isApplicable(Strategy strategy) throws VilException {
        RuleExecutionContext context = new RuleExecutionContext(strategy, getRuntimeEnvironment());
        boolean result = isApplicable(strategy, context);
        cleanupRuleExecution(context);
        return result;
    }
    
    /**
     * Returns whether a strategy is applicable, considering the applicability of the preconditions and the objective.
     * 
     * @param strategy the strategy to consider
     * @param context the execution context of <code>strategy</code>
     * @return <code>true</code> if the <code>strategy</code> is applicable, <code>false</code> else
     * @throws VilException in case of execution / evaluation problems
     */
    private boolean isApplicable(Strategy strategy, RuleExecutionContext context) throws VilException {
        boolean applicable = prepareExecution(context);
        if (applicable && Status.SUCCESS == context.getStatus()) {
            Expression objective = strategy.getObjective();
            if (null != objective) {
                processVariables(strategy);
                Object objectiveResult = objective.accept(this);
                if (!Boolean.TRUE.equals(objectiveResult)) {
                    context.setStatus(Status.NOT_APPLICABLE);
                    applicable = false;
                }
            }
        }
        return applicable;
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        Script tmp = currentScript;
        currentScript = script;
        ReasonerAdapter.registerInstance(reasonerCache);
        Object result = super.visitScript(script); // just pass through, handled in executeDefault
        script.markAsExecuted();
        ReasonerAdapter.unregisterInstance();
        currentScript = tmp;
        return result;
    }

    @Override
    protected void processProperties(
        net.ssehub.easy.instantiation.core.model.buildlangModel.Script script, File base) 
        throws VilException {
        callInitialize();
        callBindValues();
        if (!stopAfterBindValues) {
            super.processProperties(script, base);
            RtVilStorage storage = RtVilStorage.getInstance();
            if (null != storage) { // check whether this position is correct
                String scriptName = script.getName();
                for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
                    VariableDeclaration varDecl = script.getVariableDeclaration(v);
                    if (varDecl.hasModifier(VariableDeclarationModifier.PERSISTENT)) {
                        Object value = storage.getValue(scriptName, varDecl.getName());
                        if (null != value) {
                            getRuntimeEnvironment().setValue(varDecl, value);
                            getTracer().valueDefined(varDecl, null, value);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Persists persistable variables.
     * 
     * @param script the script to store the variables for
     * @throws VilException in case that accessing a variable value fails
     */
    private void persistVariables(net.ssehub.easy.instantiation.core.model.buildlangModel.Script script) 
        throws VilException {
        RtVilStorage storage = RtVilStorage.getInstance();
        if (null != storage) { // check whether this position is correct
            String scriptName = script.getName();
            for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
                VariableDeclaration varDecl = script.getVariableDeclaration(v);
                if (varDecl.hasModifier(VariableDeclarationModifier.PERSISTENT)) {
                    Object value = getRuntimeEnvironment().getValue(varDecl);
                    storage.setValue(scriptName, varDecl.getName(), value);
                }
            }
        }
    }
    
    @Override
    public Object visitStrategy(Strategy strategy) throws VilException {
        nestedStrategyCount++;
        boolean visited = false;
        StrategyExecutionContext context = new StrategyExecutionContext(strategy, getRuntimeEnvironment());
        if (prepareExecution(context)) {
            getTracer().visitRule(strategy, getRuntimeEnvironment());
            visited = true;
            if (Status.SUCCESS == context.getStatus()) {
                callStart(strategy);
                processVariables(strategy);
                // builds up breakdown
                context.setStatus(applyRuleBody(strategy, context.getRhsValues(), context));
                List<AbstractBreakdownCall> calls = determineBreakdownRanking(context);
                RuleExecutionResult callResult = null;
                Status lastStatus = null;
                for (int c = 0; continueBreakdown(callResult) && c < calls.size(); c++) {
                    AbstractBreakdownCall call = calls.get(c);
                    Expression timeoutEx = call.getTimeoutExpression();
                    Object timeout = null;
                    if (null != timeoutEx) {
                        timeout = timeoutEx.accept(this);
                    }
                    long startTimeStamp = System.currentTimeMillis();
                    callResult = (RuleExecutionResult) visitModelCallExpression(call);
                    long endTimeStamp = System.currentTimeMillis();
                    lastStatus = null == callResult ? Status.NOT_APPLICABLE : callResult.getStatus();
                    if (Status.SUCCESS == lastStatus) {
                        setFailInfo(context, null);
                        if (!validateTimeout(timeout, startTimeStamp, endTimeStamp, callResult)) {
                            LOGGER.info("strategy '" + call.getResolved().getSignature() + "' failed in breakdown "
                                + "of '" + strategy.getSignature() + "' due to a timeout of " + timeout);
                        }
                    } else if (Status.FAIL == lastStatus) {
                        setFailInfo(context, callResult);
                    }
                }
                if (null == callResult) {
                    context.setStatus(Status.NOT_APPLICABLE);
                } else {
                    context.setStatus(callResult.getStatus());
                    if (Status.SUCCESS == callResult.getStatus()) {
                        context.setStatus(executeRuleBody(strategy.getPostprocessing(), context));
                    }
                    checkPostconditions(context);
                }
            }
        }
        cleanupRuleExecution(context);
        RuleExecutionResult result = new RuleExecutionResult(context.getStatus(), context);
        boolean failed = true;
        if (Status.SUCCESS == context.getStatus()) {
            if (Boolean.TRUE == callValidate(strategy)) {
                callSucceeded(strategy, result);
                successful.add(strategy);
                callUpdate();
                callEnact();
                failed = false;
            }
        }
        if (failed) {
            callFailed(strategy);
        }
        nestedStrategyCount--;
        return visitedRule(visited, strategy, result);
    }

    /**
     * Determines whether the breakdown execution shall continue.
     * 
     * @param callResult the call result
     * @return <code>true</code> for continue, <code>false</code> for stop
     * @throws VilException in case that the actual configuration cannot be found
     */
    private boolean continueBreakdown(RuleExecutionResult callResult) throws VilException {
        boolean cont;
        if (null == callResult) {
            cont = true;
        } else {
            if (Status.SUCCESS == callResult.getStatus()) {
                Configuration cfg = getCurrentConfigurationIvml();
                cont = (null == cfg || !callResult.hasChanges());
            } else {
                cont = true;
            }
        }
        return cont;
    }

    /**
     * Notifies the tracer if <code>visited</code>.
     * 
     * @param visited whether <code>strategy</code> was visited
     * @param strategy the strategy
     * @param result the strategy execution result
     * @return <code>result</code>
     */
    private RuleExecutionResult visitedRule(boolean visited, Strategy strategy, RuleExecutionResult result) {
        if (visited) {
            getTracer().visitedRule(strategy, getRuntimeEnvironment(), result);
        }
        return result;
    }

    /**
     * Sets the fail code from <code>callResult</code> to <code>context</code>.
     * 
     * @param context the context to modify as a side effect
     * @param callResult the call result to take the fail information from (may be <b>null</b> for <b>null</b> as 
     *   fail code/reason)
     */
    private void setFailInfo(StrategyExecutionContext context, RuleExecutionResult callResult) {
        if (null == callResult) {
            context.setFailCode(null);
            context.setFailReason(null);
        } else {
            context.setFailCode(callResult.getFailCode());
            context.setFailReason(callResult.getFailReason());
        }
    }

    /**
     * Validates the timeout.
     * 
     * @param timeout the timeout
     * @param startTimeStamp the start time stamp
     * @param endTimeStamp the end time stamp
     * @param callResult the call result
     * @return <code>true</code> if valid or not relevant, <code>false</code> if invalid (exceeded)
     */
    private boolean validateTimeout(Object timeout, long startTimeStamp, long endTimeStamp, 
        RuleExecutionResult callResult) {
        boolean result = true;
        if (timeout instanceof Number) {
            long timeoutValue = ((Number) timeout).longValue();
            long expectedEndTimeStamp = startTimeStamp + ((Number) timeout).longValue();
            if (timeoutValue > 0 && endTimeStamp > expectedEndTimeStamp) {
                callResult.fail();
                result = false;
            }
        }
        return result;
    }

    @Override
    public Object visitTactic(Tactic tactic) throws VilException {
        boolean visited = false;
        RuleExecutionContext context = new RuleExecutionContext(tactic, getRuntimeEnvironment());
        if (prepareExecution(context)) {
            getTracer().visitRule(tactic, getRuntimeEnvironment());
            visited = true;
            if (Status.SUCCESS == context.getStatus()) {
                callStart(tactic);
                context.setStatus(applyRuleBody(tactic, context.getRhsValues(), context));
                checkPostconditions(context);
            }
        }
        cleanupRuleExecution(context);
        RuleExecutionResult result = new RuleExecutionResult(context.getStatus(), context);
        boolean failed = true;
        if (Status.SUCCESS == context.getStatus()) {
            if (Boolean.TRUE == callValidate(tactic)) {
                callSucceeded(tactic, result);
                // no callEnact();
                failed = false;
                successful.add(tactic);
            }
        }
        if (failed) {
            callFailed(tactic);
        }
        if (visited) {
            getTracer().visitedRule(tactic, getRuntimeEnvironment(), result);
        }
        return result;
    }

    /**
     * Evaluates the guard of a breakdown call.
     * 
     * @param call the call
     * @return whether the call is active (due to the guard) or not
     * @throws VilException in case of evaluation problems
     */
    private boolean evaluateGuard(AbstractBreakdownCall call) throws VilException {
        boolean active = true;
        Expression guard = call.getGuardExpression();
        if (null != guard) {
            Object o = guard.accept(this);
            if (o instanceof DecisionVariable) {
                o = ((DecisionVariable) o).getValue();
            }
            if (o instanceof BooleanValue) {
                o = ((BooleanValue) o).getValue();
            }
            if (!Boolean.TRUE.equals(o)) {
                active = false;
            }
        }
        return active;
    }
    
    @Override
    public Object visitStrategyCall(StrategyCall call) throws VilException {
        // called in first execution of strategy breakdown part - collect 
        RuleExecutionContext context = peekRuleStack();
        boolean isActive = evaluateGuard(call);
        if (isActive) {
            Strategy strategy = call.getResolved();
            if (isApplicable(strategy)) {
                ((StrategyExecutionContext) context).addBreakdownCall(call); // happens only in strategy execution
            }
        }
        return new RuleExecutionResult(Status.SUCCESS, context); // don't stop here
    }

    @Override
    public Object visitTacticCall(TacticCall call) throws VilException {
        // called in first execution of strategy breakdown part - collect
        RuleExecutionContext context = peekRuleStack();
        boolean isActive = evaluateGuard(call);
        if (isActive) {
            RuleExecutionContext tmpContext = new RuleExecutionContext(call.getResolved(), getRuntimeEnvironment());
            if (prepareExecution(context)) {
                ((StrategyExecutionContext) context).addBreakdownCall(call); // happens only in strategy execution
            }
            cleanupRuleExecution(tmpContext);
        }
        return new RuleExecutionResult(Status.SUCCESS, context); // don't stop here
    }

    /**
     * Returns the current script being executed.
     * 
     * @return the current script
     */
    private Script getCurrentScript() {
        return (Script) getRuntimeEnvironment().getContextModel();
    }

    /**
     * Returns the current configuration as IVML instance.
     * 
     * @return the current configuration
     * @throws VilException in case that accessing the configuration fails
     */
    private Configuration getCurrentConfigurationIvml() throws VilException {
        return (Configuration) getCurrentConfiguration().accept(this);
    }
    
    /**
     * Returns the configuration object used in <code>script</code>, i.e., the top-level configuration object.
     * 
     * @return the configuration object
     * @throws VilException in case that accessing the configuration object fails
     */
    private CallArgument getCurrentConfiguration() throws VilException {
        Script script = getCurrentScript();
        TypeDescriptor<?> cfgType = IvmlTypes.configurationType();
        CallArgument result = new CallArgument(cfgType);
        for (int i = 0; i < script.getParameterCount(); i++) {
            VariableDeclaration decl = script.getParameter(i);
            if (cfgType.isAssignableFrom(decl.getType())) {
                result.fixValue(getRuntimeEnvironment().getValue(decl));
            }
        }
        return result;
    }
    
    /**
     * Calls the VTL failed rule if it exists or the IVML reasoner instead. Performs validation only if there are
     * direct changes.
     * 
     * @param concept the concept to call on
     * @return the result of validation
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private Object callValidate(IRtVilConcept concept) throws VilException {
        Configuration cfg = getCurrentConfigurationIvml();
        Object result = Boolean.TRUE;
        if (cfg.getChangeHistory().hasChanges()) {
            result = dfltRtVilConceptCall(concept, "validate", 
                useReasoner ? VALIDATE_FALLBACK : VALIDATE_NO_REASONER_FALLBACK);
        }
        return result;
    }

    /**
     * Calls the VTL start rule if it exists.
     * 
     * @param concept the concept to call on
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callStart(IRtVilConcept concept) throws VilException {
        dfltRtVilConceptCall(concept, "start", START_FALLBACK);
    }

    /**
     * Calls the VTL succeeded rule if it exists.
     * 
     * @param concept the concept to call on
     * @param result the execution result, to be modified as a side effect
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callSucceeded(IRtVilConcept concept, RuleExecutionResult result) throws VilException {
        Configuration cfg = getCurrentConfigurationIvml();
        if (null != cfg) {
            result.setChanges(cfg.getChangeHistory().hasChanges());
        }
        dfltRtVilConceptCall(concept, "succeeded", SUCCEEDED_FALLBACK);
    }
    
    /**
     * Calls the VTL update rule if it exists.
     * 
     * @param concept the concept to call on
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callUpdate(IRtVilConcept concept) throws VilException {
        dfltRtVilConceptCall(concept, "update", UPDATE_FALLBACK);
    }
    
    /**
     * Calls the VTL failed rule if it exists.
     * 
     * @param concept the concept to call on
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callFailed(IRtVilConcept concept) throws VilException {
        dfltRtVilConceptCall(concept, "failed", FAILED_FALLBACK);
    }
    
    /**
     * Calls all successful strategies and tactics.
     * 
     * @throws VilException in case that one of the calls fails
     */
    private void callUpdate() throws VilException {
        Set<IRtVilConcept> done = new HashSet<IRtVilConcept>();
        for (int s = 0; s < successful.size(); s++) {
            IRtVilConcept concept = successful.get(s);
            if (!done.contains(concept)) {
                callUpdate(concept);
                done.add(concept);
            }
        }
        successful.clear();
    }
    
    /**
     * Returns whether the given <code>type</code> is a map with the given two generics.
     * 
     * @param type the type to check
     * @param gen1 the first generic type
     * @param gen2 the second generic type
     * @return <code>true</code> if <code>type</code> is the requested map type, <code>false</code> else
     */
    private boolean isMap(TypeDescriptor<?> type, TypeDescriptor<?> gen1, TypeDescriptor<?> gen2) {
        return type.isMap() && 2 == type.getGenericParameterCount() 
            && gen1.isAssignableFrom(type.getGenericParameterType(0)) 
            && gen2.isAssignableFrom(type.getGenericParameterType(1));
    }
    
    /**
     * Calls the bind values rule if present or does nothing.
     * 
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callBindValues() throws VilException {
        Script script = getCurrentScript();
        CallArgument[] args = new CallArgument[2];
        int pos = 0;
        for (int i = 0; i < script.getParameterCount(); i++) {
            VariableDeclaration decl = script.getParameter(i);
            TypeDescriptor<?> type = decl.getType();
            if (IvmlTypes.configurationType().isAssignableFrom(type) 
                || isMap(type, TypeRegistry.stringType(), TypeRegistry.realType())) {
                Object value = getRuntimeEnvironment().getValue(decl);
                args[pos++] = new CallArgument(decl.getType()).fixValue(value);
            }
        }
        if (2 == pos) { // only if both parameters are present
            if (null != rtTracer) {
                rtTracer.startBind();
            }
            boolean enabled = setEnableRuleElementFailed(false);
            dynamicCall("bindValues", BIND_VALUES_FALLBACK, args);
            // clear the change history 
            ((Configuration) args[0].accept(this)).getChangeHistory().clear(true);
            setEnableRuleElementFailed(enabled);
            if (null != rtTracer) {
                rtTracer.endBind();
            }
        } else {
            LOGGER.info("bindValues not found - map declaration missing?");
        }
    }

    /**
     * Calls the initialization of the actual script.
     * 
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callInitialize() throws VilException {
        Script script = getCurrentScript();
        if (!script.wasExecuted()) {
            if (null != rtTracer) {
                rtTracer.startInitialize();
            }
            CallArgument[] args = new CallArgument[1];
            args[0] = getCurrentConfiguration();
            dynamicCall("initialize", INITIALIZE_FALLBACK, args);
            if (null != rtTracer) {
                rtTracer.endInitialize();
            }
        }
    }
    
    /**
     * Calls the enactment and complains if no top-level enactment function can be found.
     * 
     * @throws VilException in case that constructing, resolving or executing the corresponding VIL rule fails
     */
    private void callEnact() throws VilException {
        if (enableEnactment && 1 == nestedStrategyCount) { // do not repeate enact calls
            if (null != rtTracer) {
                rtTracer.startEnact();
            }
            Script script = getCurrentScript();
            CallArgument[] args = new CallArgument[3];
            for (int i = 0; i < Math.min(3,  script.getParameterCount()); i++) {
                VariableDeclaration decl = script.getParameter(i);
                Object value = getRuntimeEnvironment().getValue(decl);
                args[i] = new CallArgument(decl.getType()).fixValue(value);
            }
            dynamicCall("enact", null, args);
            if (null != rtTracer) {
                rtTracer.endEnact();
            }
        }
    }

    /**
     * A default rt-VIL concept call.
     * 
     * @param concept the concept to call on
     * @param name the name of the call
     * @param fallback the optional fallback instance in case that the corresponding VIL rule cannot be found 
     * @return the execution result
     * @throws VilException in case that constructing, resolving or executing the VIL rule fails
     */
    private Object dfltRtVilConceptCall(IRtVilConcept concept, String name, IDynamicCallFallback fallback) 
        throws VilException {
        CallArgument conceptArg = new CallArgument(RtVilTypeRegistry.INSTANCE.findType(concept.getClass()))
            .fixValue(concept);
        return dynamicCall(name, fallback, conceptArg, getCurrentConfiguration());
    }

    /**
     * Executes a dynamic rule call, i.e., a call that is composed and resolved at runtime.
     * 
     * @param name the name of the rule to be called
     * @param fallback an optional fallback instance in case that the call cannot be resolved
     * @param args the rule arguments
     * @return the rule execution result
     * @throws VilException in case that constructing, resolving or executing the VIL rule fails
     */
    private Object dynamicCall(String name, IDynamicCallFallback fallback, CallArgument... args) throws VilException {
        Object result;
        try {
            result = dynamicCall(getCurrentScript(), name, args);
        } catch (VilException e) {
            if (null != fallback && VilException.ID_CANNOT_RESOLVE == e.getId()) {
                result = fallback.call(this, args);
            } else {
                throw e;
            }
        }
        return result;
    }

    /**
     * Executes a dynamic rule call on <code>script</code> or its (transitively) imported scripts, i.e., 
     * a call that is composed and resolved at runtime.
     * 
     * @param script the script to resolve the call on
     * @param name the name of the rule to be called
     * @param args the rule arguments
     * @return the rule execution result
     * @throws VilException in case that constructing, resolving or executing the VIL rule fails
     */
    private Object dynamicCall(net.ssehub.easy.instantiation.core.model.buildlangModel.Script script, 
        String name, CallArgument... args) throws VilException {
        Object result = null;
        VilException failure = null;
        try {
            RuleCallExpression expr = new RuleCallExpression(script, false, name, args);
            expr.inferType();
            result = expr.accept(this);
        } catch (VilException e) {
            if (VilException.ID_CANNOT_RESOLVE == e.getId()) {
                failure = e; // go on trying
            } else {
                throw e;
            }
        }
        if (failure != null) {
            boolean succeeded = false;
            for (int i = 0; !succeeded && i < script.getImportsCount(); i++) {
                net.ssehub.easy.instantiation.core.model.buildlangModel.Script tmp 
                    = script.getImport(i).getResolved();
                if (null != tmp) {
                    try {
                        result = dynamicCall(tmp, name, args);
                        succeeded = true;
                    } catch (VilException e) {
                        if (VilException.ID_CANNOT_RESOLVE != e.getId()) {
                            throw e;
                        } // else: ignore, we have already and information in failure
                    }
                }
            }
            if (!succeeded) {
                throw failure;
            }
        }
        return result;
    }

    @Override
    public Object visitFailStatement(FailStatement statement) throws VilException {
        return null; // go on in ruleElementFailed
    }

    @Override
    protected boolean ruleElementFailed(IRuleElement elt, RuleExecutionContext context) throws VilException {
        boolean fail = true;
        if (elt instanceof FailStatement) {
            FailStatement fStmt = (FailStatement) elt;
            String msg;
            if (fStmt.isRefail()) {
                if (null != lastFailCode || null != lastFailReason) {
                    context.setFailCode(lastFailCode);
                    context.setFailReason(lastFailReason);
                    msg = "refail";
                } else {
                    msg = null;
                    fail = false;
                }
            } else {
                msg = "explicit fail";
                if (null != fStmt.getReasonEx()) {
                    Object value = fStmt.getReasonEx().accept(this);
                    if (value instanceof String) {
                        context.setFailReason((String) value);
                    }
                }
                if (null != fStmt.getCodeEx()) {
                    Object value = fStmt.getCodeEx().accept(this);
                    if (value instanceof Integer) {
                        context.setFailCode((Integer) value);
                    }
                }
                if (null == context.getFailCode() && null == context.getFailReason()) {
                    context.setFailCode(-1);
                }
                lastFailReason = context.getFailReason();
                lastFailCode = context.getFailCode();
            }

            if (null != msg) {
                if (null != context.getFailReason()) {
                    msg += " message \"" + context.getFailReason() + "\"";
                }
                if (null != context.getFailCode()) {
                    msg += " with code " + context.getFailCode();
                }
                context.setStatus(Status.FAIL);
                getTracer().trace(msg);
            }
        }
        return fail;
    }
    
    @Override
    protected boolean mayFail(Object elt) {
        boolean result;
        if (elt instanceof FailStatement) {
            result = true;
        } else {
            result = super.mayFail(elt);
        }
        return result;
    }

    /*
public Object visitRule(Rule rule) throws VilException {
    System.out.println(">> " + rule.getName());
    Object result = super.visitRule(rule);
    System.out.println("<< " + rule.getName());
    return result;
}
*/

}
