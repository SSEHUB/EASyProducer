package net.ssehub.easy.reasoning.drools2;

import java.net.URI;
import java.util.List;

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
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.reasoning.drools2.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * This class is the Drools implementation for reasoning over IVML projects and configurations. 
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class DroolsReasoner implements IReasoner {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(DroolsReasoner.class,
        DroolsReasonerDescriptor.BUNDLE_NAME);

    private static final ReasonerDescriptor DESCRIPTOR = new DroolsReasonerDescriptor();
    
    @Override
    public ReasonerDescriptor getDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public ReasoningResult upgrade(URI url, ProgressObserver observer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfig, 
                ProgressObserver observer) {
        ReasoningResult notSupportedResult = new ReasoningResult("Drools");
        return notSupportedResult;
    }

    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) { 
        ReasonerModel model = new ReasonerModel(cfg, reasonerConfig);
        DroolsEngine engine = new DroolsEngine(model, ReasoningOperation.PROPAGATION, observer);           
        return engine.reason();
    }

    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) {        
        ReasonerModel model = new ReasonerModel(cfg, reasonerConfig);
        DroolsEngine engine = new DroolsEngine(model, ReasoningOperation.PROPAGATION, observer);
        return engine.reason();
    }

    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfig, ProgressObserver observer) {
        
        EvaluationResult notSupportedResult = new EvaluationResult("Drools");
        return notSupportedResult;
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ReasonerFrontend.getInstance().getRegistry().register(this);
        LOGGER.info("Drools started ");
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
    
    @Override
    public IReasonerInstance createInstance(Project project, Configuration cfg,
            ReasonerConfiguration reasonerConfiguration) {
        return null;
    }

    /**
     * Initializes the configuration according to the given model and propagates values, if possible.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project (may be modified as a side effect
     *            of value propagation)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    @Override
    public ReasoningResult initialize(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
            ProgressObserver observer) {
        return propagate(project, cfg, reasonerConfiguration, observer);
    }

    @Override
    public void setInterceptor(IReasonerInterceptor interceptor) {
    }

    /**
     * Creates the value for a certain IVML type/variable.
     * 
     * @param cfg the configuration to operate on (will not be modified)
     * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
     *     additional constraints, takes precedence over {@code type})
     * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return the value creation result
     */
    //@Override
    public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type,
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        return null;
    }

}
