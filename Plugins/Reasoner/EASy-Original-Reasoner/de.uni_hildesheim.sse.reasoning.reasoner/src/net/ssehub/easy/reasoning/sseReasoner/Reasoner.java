package net.ssehub.easy.reasoning.sseReasoner;

import java.net.URI;
import java.util.List;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
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
 * This class is the EASy Producer Reasoner implementation for reasoning over IVML projects and configurations. 
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class Reasoner implements IReasoner {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(Reasoner.class,
        Descriptor.BUNDLE_NAME);

    private static final Descriptor DESCRIPTOR = new Descriptor();
    
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
        Engine engine = new Engine(project, createConfiguration(project, null, reasonerConfig), 
            reasonerConfig, observer);           
        return engine.reason();
    }

    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) {
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig), 
            reasonerConfig, observer);           
        return engine.reason();
    }

    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
        ProgressObserver observer) {
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig), 
            reasonerConfig, observer);
        return engine.reason();
    }

    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfig, ProgressObserver observer) {        
        EvaluationResult notSupportedResult = new EvaluationResult("EASy-Producer IVML Reasoner");
        return notSupportedResult;        

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
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Method for creating a clean {@link Configuration} if required.
     * @param project Project for {@link Configuration}
     * @param cfg the initial configuration
     * @param rConfig the reasoner configuration
     * @return Created {@link Configuration}
     */
    private Configuration createConfiguration(Project project, Configuration cfg, ReasonerConfiguration rConfig) {
        Configuration result;
        if (rConfig.isRuntimeMode() || !rConfig.isFreshConfiguration()) {
            result = cfg;
        } else {
            result = null;
        }
        if (null == result) {
            result = new Configuration(project, false);
        }        
//        if (rConfig.isFreshConfiguration()) {
//            result = new Configuration(project, false);
//        } else {
//            result = cfg;
//        }        
        return result;
    }   
    
}
