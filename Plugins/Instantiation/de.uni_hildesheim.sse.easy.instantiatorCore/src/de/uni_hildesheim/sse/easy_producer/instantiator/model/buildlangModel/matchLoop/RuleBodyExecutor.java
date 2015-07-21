package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleBlock;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleExecutionContext;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

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
     * @return the execution status or the value of the block depending on the type of the rule
     * @throws VilException in case of serious execution problems
     */
    public Object executeRuleBody(IRuleBlock ruleBody, RuleExecutionContext context) throws VilException;

}
