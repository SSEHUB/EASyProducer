package de.uni_hildesheim.sse.easy.ui.core.reasoning;

import org.eclipse.swt.widgets.Display;

import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;

/**
 * {@link IReasonerListener} which shall update the GUI.
 * The {@link IReasonerListener#reasoningFinished(ReasoningResult)} method is surrounded in an own GUI Thread to allow
 * modifications inside the GUI.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractReasonerListener implements IReasonerListener {

   /**
     * {@inheritDoc}
     */
    public void reasoningFinished(final ReasoningResult result) {
        Display.getDefault().asyncExec(new Runnable() {
            
           /**
             * {@inheritDoc}
             */
            public void run() {
                endReasoning(result);              
            }
        });
        
    }

    /**
     * This method will be called after the reasoner is finished.
     * This method is called in an own GUI thread to allow modifications on the GUI.
     * @param result The result of the reasoning, can also contain warnings and errors.
     */
    public abstract void endReasoning(ReasoningResult result);
}
