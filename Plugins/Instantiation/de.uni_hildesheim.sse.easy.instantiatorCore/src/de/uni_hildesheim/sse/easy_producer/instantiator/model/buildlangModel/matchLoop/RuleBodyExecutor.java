package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleBlock;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionContext;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionResult.Status;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;

/**
 * An instance being able to execute a rule body.
 * 
 * @author Holger Eichelberger
 */
public interface RuleBodyExecutor {
    
    /**
     * Executes a rule body. 
     * 
     * @param ruleBody the rule body
     * @param context the rule execution context 
     * @return the execution status
     * @throws VilLanguageException in case of serious execution problems
     */
    public Status executeRuleBody(RuleBlock ruleBody, RuleExecutionContext context) throws VilLanguageException;

}
