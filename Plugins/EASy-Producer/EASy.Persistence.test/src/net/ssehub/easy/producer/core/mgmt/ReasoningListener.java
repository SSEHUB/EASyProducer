package net.ssehub.easy.producer.core.mgmt;

import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;

/**
 * Helper class for testing  the
 * {@link PLPInfo#reason(de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation, IReasonerListener)}
 * method.
 * This method {@link #didReasoning()} returns thether the reasoning was finished successfully or not.
 * @author El-Sharkawy
 *
 */
abstract class ReasoningListener implements IReasonerListener {
    
    private boolean reasoningFinished = false;

    @Override
    public void reasoningFinished(ReasoningResult result) {
        reasoningFinished = true;
        afterReasoning(result);
    }
    
    /**
     * Should be used during the tests to access the {@link ReasoningResult}.
     * @param result The result of the reasoning, can also contain warnings and errors.
     */
    abstract void afterReasoning(ReasoningResult result);
    
    /**
     * Returns whether the reasoning was performed successfully.
     * @return <code>true</code> if the reasoning was applied successfully, otherwise <code>false</code>.
     */
    boolean didReasoning() {
        return reasoningFinished;
    }
}
