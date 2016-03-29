package de.uni_hildesheim.sse.reasoning.drools2;

import java.net.URI;
import java.util.List;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.reasoning.core.model.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerMessage;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

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
        // TODO Auto-generated method stub
        
    }
}
