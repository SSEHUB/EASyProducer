package net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop;

import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionContext;
import net.ssehub.easy.instantiation.core.model.common.VilException;

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
