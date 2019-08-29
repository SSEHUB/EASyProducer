package net.ssehub.easy.reasoning.core.frontend;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Delegate for starting a reasoning. This class can be run as a thread or be used inside a thread, e.g. as
 * an Eclipse WorkspaceJob.
 * @author El-Sharkawy
 *
 */
public class ReasoningProcess implements Runnable {

    private static final boolean LOG_RESULT = false;
    
    private ReasoningOperation desiredOperation;
    private ReasoningResult result;
    private Project project;
    private Configuration config;
    private ReasonerConfiguration reasonerConfig;
    private IReasonerListener listener;
    private ProgressObserver observer;
    
    /**
     * Sole constructor for this class.
     * @param desiredOperation Specifies which reasoning operation should be performed.
     * @param config The configuration, which should be used for reasoning.
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *     may be <b>null</b>)
     * @param listener A listener which will be called after the reasoning has been finished.
     *     Can be <tt>null</tt>, if no action shall be executed after the reasoning is finished.
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated
     */
    public ReasoningProcess(ReasoningOperation desiredOperation, Configuration config, 
        ReasonerConfiguration reasonerConfig, IReasonerListener listener, ProgressObserver observer) {
        
        this.desiredOperation = desiredOperation;
        this.project = config.getProject();
        this.config = config;
        this.reasonerConfig = reasonerConfig;
        this.listener = listener;
        this.observer = observer;
    }
    
    /**
     * Constructor for checking the consistency (satisfiability) of a project, without having a configuration.
     * @param project The origin project which should be used for reasoning
     * @param reasonerConfig the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *     may be <b>null</b>)
     * @param listener A listener which will be called after the reasoning has been finished.
     *     Can be <tt>null</tt>, if no action shall be executed after the reasoning is finished.
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated   
     */
    public ReasoningProcess(Project project, ReasonerConfiguration reasonerConfig, IReasonerListener listener,
        ProgressObserver observer) {
        
        this.desiredOperation = ReasoningOperation.CONSITENCY_CHECK;
        this.project = project;
        this.config = null;
        this.reasonerConfig = reasonerConfig;
        this.listener = listener;
        this.observer = observer;
    }
    
    /**
     * Executes the reasoning.
     */
    @Override
    public void run() {
        ReasonerFrontend reasoner = ReasonerFrontend.getInstance();
        if (null == reasoner) {
            setErrorResult("No reasoner found.");
        } else if (null == project) {
            setErrorResult("No project specified for reasoning");
        } else {
            try {
                switch(desiredOperation) {
                case CONSITENCY_CHECK:
                    result = reasoner.isConsistent(project, reasonerConfig, observer);
                    logResult();
                    break;
                case VALIDATION:
                    if (null == config) {
                        setErrorResult("No configuration specified for reasoning");
                    }
                    result = reasoner.check(config, reasonerConfig, observer);
                    logResult();
                    break;
                case PROPAGATION:
                    if (null == config) {
                        setErrorResult("No configuration specified for reasoning");
                    }
                    result = reasoner.propagate(project, config, reasonerConfig, observer);
                    logResult();
                    break;
                default:
                    result = new ReasoningResult();
                    Message msg = new Message("Nothing done.", null,
                        net.ssehub.easy.basics.messages.Status.WARNING);
                    result.addMessage(msg);
                    break;
                }
            // checkstyle: stop exception type check
            } catch (Exception e) {
            // checkstyle: resume exception type check
                StringBuffer errorMsg = new StringBuffer("Not expected exception caught:\n"); 
                errorMsg.append(e.getMessage());
                setErrorResult(errorMsg.toString());
                e.printStackTrace();
            }
        }
        
        if (null != listener) {
            listener.reasoningFinished(result);
        }
    }

    /**
     * Performs the result logging as it was previously integrated into the reasoner but removed for performance 
     * reasons.
     */
    private void logResult() {
        if (LOG_RESULT) {
            result.logInformation(project, reasonerConfig, true);
        }
    }

    /**
     * Returns the result of the reasoning, i.e. the result of the {@link #run()} method.
     * This method should be used, if no {@link ReasoningResult} was used.
     * @return The result of the reasoning.
     */
    public ReasoningResult getReasoningResult() {
        return result;
    }
    
    /**
     * Sets a {@link ReasoningResult} denoting that an error occurred during reasoning.
     * @param errorMsg A description what kind of error occurred.
     */
    private void setErrorResult(String errorMsg) {
        result = new ReasoningResult();
        Message msg = new Message(errorMsg, null, net.ssehub.easy.basics.messages.Status.ERROR);
        result.addMessage(msg);
    }
}
