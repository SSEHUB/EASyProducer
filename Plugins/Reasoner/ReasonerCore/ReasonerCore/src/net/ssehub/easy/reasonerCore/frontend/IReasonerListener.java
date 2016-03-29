package net.ssehub.easy.reasonerCore.frontend;

import net.ssehub.easy.reasonerCore.reasoner.ReasoningResult;

/**
 * Listener for the {@link IReasoner}, to inform the caller of the reasoner, that the reasoning has been finished.
 * @author El-Sharkawy
 *
 */
public interface IReasonerListener {
    
    /**
     * This method will be called after the reasoner is finished.
     * @param result The result of the reasoning, can also contain warnings and errors.
     */
    public void reasoningFinished(ReasoningResult result);

}
