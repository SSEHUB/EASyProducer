package net.ssehub.easy.reasoning.sseReasoner;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerInterceptor;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerMessage;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult.ConstraintEvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult.EvaluationPair;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * This class is the EASy Producer Reasoner implementation for reasoning over IVML projects and configurations. 
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class Reasoner implements IReasoner {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(Reasoner.class,
        Descriptor.BUNDLE_NAME);

    private static final Descriptor DESCRIPTOR = new Descriptor();
    private IReasonerInterceptor interceptor;

    /**
     * A reusable reasoner instance.
     * 
     * @author Holger Eichelberger
     */
    private class ReasonerInstance implements IReasonerInstance {

        private Engine engine;
        private Project project;
        private Configuration cfg;
        private ReasonerConfiguration reasonerConfiguration;
        private IReasonerInterceptor interceptor;

        /**
         * Creates a reusable reasoner instance.
         * 
         * @param project the project which serves as basis for the related configuration.
         * @param cfg the configuration as a basis for the evaluation
         * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
         *        may be <b>null</b>)
         * @param interceptor the optional reasoner interceptor (may be <b>null</b>)
         */
        private ReasonerInstance(Project project, Configuration cfg,
            ReasonerConfiguration reasonerConfiguration, IReasonerInterceptor interceptor) {
            this.project = project;
            this.cfg = cfg;
            this.interceptor = interceptor;
            this.reasonerConfiguration = null == reasonerConfiguration 
                ? new ReasonerConfiguration() : reasonerConfiguration;
        }
        
        @Override
        public ReasonerDescriptor getDescriptor() {
            return DESCRIPTOR;
        }

        @Override
        public ReasoningResult isConsistent(ProgressObserver observer) {
            return Reasoner.this.isConsistent(project, reasonerConfiguration, observer);
        }

        @Override
        public ReasoningResult check(ProgressObserver observer) {
            return Reasoner.this.check(project, cfg, reasonerConfiguration, observer);
        }

        @Override
        public ReasoningResult propagate(ProgressObserver observer) {
            if (null == engine) {
                engine = new Engine(project, createConfiguration(project, cfg, reasonerConfiguration, false), 
                    reasonerConfiguration, observer, interceptor);
                engine.markForReuse();
            } else {
                engine.reInit();
            }
            ReasoningResult res = engine.reason();
            engine.clear();
            return res;
        }

        @Override
        public EvaluationResult evaluate(List<Constraint> constraints, ProgressObserver observer) {
            return Reasoner.this.evaluate(project, cfg, constraints, reasonerConfiguration, observer);
        }

        @Override
        public void notify(IReasonerMessage message) {
            Reasoner.this.notify(message);
        }

        @Override
        public boolean isRunning() {
            return engine.isRunning();
        }

        @Override
        public boolean stop() {
            return engine.stop();
        }

        @Override
        public Project getProject() {
            return project;
        }

        @Override
        public ReasonerConfiguration getReasonerConfiguration() {
            return reasonerConfiguration;
        }
        
    }
    
    @Override
    public ReasonerDescriptor getDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public ReasoningResult upgrade(URI url, ProgressObserver observer) {
        return null;
    }

    @Override
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfig, 
        ProgressObserver observer) {
        reasonerConfig =  null == reasonerConfig ? new ReasonerConfiguration() : reasonerConfig;
        Engine engine = new Engine(project, createConfiguration(project, null, reasonerConfig, true), 
            reasonerConfig, observer, interceptor);           
        return engine.reason();
    }

    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) {
        reasonerConfig =  null == reasonerConfig ? new ReasonerConfiguration() : reasonerConfig;
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig, true), 
            reasonerConfig, observer, interceptor);
        return engine.reason();
    }

    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) { // implemented also (for instance reuse) in reasoner instance
        reasonerConfig =  null == reasonerConfig ? new ReasonerConfiguration() : reasonerConfig;
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig, false), 
            reasonerConfig, observer, interceptor);
        return engine.reason();
    }

    @Override
    public ReasoningResult initialize(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) {
        reasonerConfig =  null == reasonerConfig ? new ReasonerConfiguration() : reasonerConfig;
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig, false), 
            reasonerConfig, observer, interceptor);
        //engine.setAssignmentState(cfg.getResolutionState()); // too specific, remove resolution state at all??
        ReasoningResult res =  engine.reason();
        return res;
    }

    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfig, ProgressObserver observer) {        
        final EvaluationResult result = new EvaluationResult(DESCRIPTOR.getName());
        EvalVisitor evaluator = new EvalVisitor(cfg, null, false, new IValueChangeListener() {
            
            @Override
            public void notifyUnresolved(IDecisionVariable variable) {
            }
            
            @Override
            public void notifyChanged(IDecisionVariable variable, Value oldValue) {
                result.addAffected(variable);
            }
        });
        evaluator.setDispatchScope(project);
        for (int c = 0; c < constraints.size(); c++) {
            Constraint constraint = constraints.get(c);
            evaluator.visit(constraint.getConsSyntax());
            ConstraintEvaluationResult eRes;
            Value eVal = null;
            if (evaluator.constraintFailed()) {
                eRes = ConstraintEvaluationResult.FALSE;
            } else if (evaluator.constraintFulfilled()) {
                eRes = ConstraintEvaluationResult.TRUE;
                eVal = evaluator.getResult();
            } else {
                eRes = ConstraintEvaluationResult.UNKNOWN;
            }
            result.addEvaluationPair(new EvaluationPair(constraint, eRes, eVal));
            // initial, may be better to join messages
            for (int m = 0; m < evaluator.getMessageCount(); m++) {
                EvalVisitor.Message eMsg = evaluator.getMessage(m);
                List<ModelElement> conflicts = new ArrayList<ModelElement>();
                conflicts.add(eMsg.getVariable());
                Message msg = new Message(eMsg.getDescription(), conflicts, eMsg.getStatus());
                List<Project> conflictProjects = new ArrayList<Project>();
                conflictProjects.add(project);
                msg.addConflictingElementProjects(conflictProjects);
                List<Set<IDecisionVariable>> problemVariables = new ArrayList<Set<IDecisionVariable>>();
                Set<IDecisionVariable> tmp = new HashSet<IDecisionVariable>();
                tmp.add(eMsg.getDecision());
                problemVariables.add(tmp);
                msg.addProblemVariables(problemVariables);
                List<Constraint> problemConstraints = new ArrayList<Constraint>();
                problemConstraints.add(constraint);
                result.addMessage(msg);
            }
            evaluator.clearIntermediary();
        }
        evaluator.clear();
        return result;        
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ReasonerFrontend.getInstance().getRegistry().register(this);
        LOGGER.info("EASy-Producer IVML Reasoner started ");
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ReasonerFrontend.getInstance().getRegistry().unregister(this);
    }

    @Override
    public void notify(IReasonerMessage message) {
    }
    
    /**
     * Method for creating a clean {@link Configuration} if required.
     * @param project Project for {@link Configuration}
     * @param cfg the initial configuration
     * @param rConfig the reasoner configuration
     * @param freshConfig use a fresh (new) configuration (<code>true</code>) instance or operate on 
     *      <code>cfg</code> (<code>false</code>)
     * @return Created {@link Configuration}
     */
    private Configuration createConfiguration(Project project, Configuration cfg, ReasonerConfiguration rConfig, 
        boolean freshConfig) {
        Configuration result;
        if (rConfig.isRuntimeMode() || !freshConfig) {
            result = cfg;
        } else {
            result = null;
        }
        if (null == result) {
            result = new Configuration(project, false);
        }
        return result;
    }   

    @Override
    public IReasonerInstance createInstance(Project project, Configuration cfg,
            ReasonerConfiguration reasonerConfiguration) {
        return new ReasonerInstance(project, cfg, reasonerConfiguration, interceptor);
    }

    @Override
    public void setInterceptor(IReasonerInterceptor interceptor) {
        this.interceptor = interceptor;
    }

}
