package net.ssehub.easy.producer.eclipse.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import net.ssehub.easy.producer.eclipse.observer.ObservableWorkspaceJob;
import net.ssehub.easy.reasoning.core.frontend.ReasoningProcess;

/**
 * (Graphical) observer for reasoning steps.
 * Reasoning runs also in an own thread.
 * @author El-Sharkawy
 *
 */
public class ReasoningProgressObserver extends ObservableWorkspaceJob {
    
    private ReasoningProcess process;
    
    /**
     * Sole constructor for this Observer.
     * @param process A configured {@link ReasoningProcess} (cf.
     * {@link net.ssehub.easy.producer.eclipse.model.ProductLineProject
     * #reason(net.ssehub.easy.reasoning.core.model.ReasoningOperation,
     * net.ssehub.easy.reasoning.core.frontend.IReasonerListener)}).
     */
    public ReasoningProgressObserver(ReasoningProcess process) {
        
        super("Reasoning");
        this.process = process;
        setUser(true);
        /*
         * Schedule will run the doJob method in an own thread.
         * Afterwards the reasoningFinished method will be executed.
         */
        schedule();
    }

    @Override
    protected IStatus doJob() {
        process.run();    
        return Status.OK_STATUS;
    }
}
