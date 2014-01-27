package de.uni_hildesheim.sse.reasoning.drools;

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
import de.uni_hildesheim.sse.reasoning.drools.drl.IRules;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * This class is the Drools implementation for reasoning over IVML projects and configurations. 
 * @author Phani
 *
 */
public class DroolsReasoner implements IReasoner, IRules {

    private static final ReasonerDescriptor DESCRIPTOR = new DroolsReasonerDescriptor();
    private DroolsVisitor droolsVisitor = null;
//    private StatefulKnowledgeSession ksession = null;
    
    /**
     * Getter for the visitor, for testing.
     * @return droolsVisitor the visitor in action.
     */
    public DroolsVisitor getDroolsVisitor() {
        return droolsVisitor;
    }
    
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
        droolsVisitor = new DroolsVisitor();
        DroolsEngine engine = new DroolsEngine(droolsVisitor);
        engine.setPropagate(false);
        ReasoningResult result = engine.check(project, cfg, reasonerConfig, observer); 

        return result;
    }

    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfig,
            ProgressObserver observer) {
        droolsVisitor = new DroolsVisitor();
        DroolsEngine engine = new DroolsEngine(droolsVisitor);
        engine.setPropagate(true);
        ReasoningResult result = engine.check(project, cfg, reasonerConfig, observer); 
        
        return result;
    }

    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfig, ProgressObserver observer) {
        DroolsEvaluation eval = new DroolsEvaluation();
        
        return eval.evaluate(project, cfg, constraints, reasonerConfig, observer);
    }

    @Override
    public void notify(IReasonerMessage message) {
        // TODO Auto-generated method stub

    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        ReasonerFrontend.getInstance().getRegistry().register(this);
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
    public String getConstraintValidationDRL(Project project, Configuration cfg) {
        droolsVisitor = new DroolsVisitor();
        DroolsEngine engine = new DroolsEngine(droolsVisitor);
        engine.setPropagate(false);
        ReasoningResult result = engine.check(project, cfg, null, null); 
        String drl = "";
        if (!result.hasConflict()) {
            List<String> rules = droolsVisitor.getHardConstraints();
            for (String rule : rules) {
                drl += rule;
            }
        }
        return drl;
    }

}
