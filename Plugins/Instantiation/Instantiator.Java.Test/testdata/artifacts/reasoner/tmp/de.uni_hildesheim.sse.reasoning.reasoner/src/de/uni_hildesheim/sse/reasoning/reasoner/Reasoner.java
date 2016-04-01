package de.uni_hildesheim.sse.reasoning.reasoner;
import java.net.URI;
import java.util.List;
import org.osgi.service.component.ComponentContext;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerMessage;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
/** 
 * This class is the EASy Producer Reasoner implementation for reasoning over IVML projects and configurations. 
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class Reasoner implements IReasoner {
    private static final Descriptor DESCRIPTOR = new Descriptor();
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
        Engine engine = new Engine(project, createConfiguration(project, null, reasonerConfig), reasonerConfig,
                observer);
        return engine.reason();
    }
    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
            ProgressObserver observer) {
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig), reasonerConfig,
                observer);
        return engine.reason();
    }
    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
            ProgressObserver observer) {
        Engine engine = new Engine(project, createConfiguration(project, cfg, reasonerConfig), reasonerConfig,
                observer);
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
        ReasonerFrontend.getInstance().getRegistry().register(this);
    }
    /** 
    * Private method to to de-activate plugin.
    * @param context Context.
    */
    protected void deactivate(ComponentContext context) {
        ReasonerFrontend.getInstance().getRegistry().unregister(this);
    }
    @Override
    public void notify(IReasonerMessage message) {
    }
    /** 
    * Method for creating a clean   {@link Configuration} if required.
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
        return result;
    }
}
