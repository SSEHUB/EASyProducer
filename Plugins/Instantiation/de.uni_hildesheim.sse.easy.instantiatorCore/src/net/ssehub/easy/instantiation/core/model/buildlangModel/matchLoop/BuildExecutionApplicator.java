package net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop;

import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionContext;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult.Status;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * An applicator which actually executes a rule body if build is required for a LHS/RHS match.
 * Execution will fail upon the first {@link Status#FAIL}.
 * 
 * @author Holger Eichelberger
 */
public class BuildExecutionApplicator extends Applicator {

    private Status status = Status.SUCCESS;
    private RuntimeEnvironment environment;
    private RuleExecutionContext context;
    private RuleBodyExecutor executor;

    /**
     * Creates the applicator.
     * 
     * @param environment the actual runtime environment
     * @param context the actual rule execution context
     * @param executor the actual rule executor
     */
    public BuildExecutionApplicator(RuntimeEnvironment environment, RuleExecutionContext context, 
        RuleBodyExecutor executor) {
        this.environment = environment;
        this.context = context;
        this.executor = executor;
    }
    
    @Override
    public void apply(Object expectedLhsValue, Object rhsValue, int index) throws VilException {
        environment.addValue(rule.getVariable(Side.RHS, index), rhsValue);
        environment.addValue(rule.getVariable(Side.LHS, index), expectedLhsValue);
        status = Status.toStatus(executor.executeRuleBody(rule, context));
    }
    
    /**
     * Returns the status of the execution.
     * 
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    @Override
    public boolean stopMatchLoop() {
        return Status.FAIL == status;
    }

    @Override
    public boolean stopConditionLoop() {
        return Status.FAIL == status;
    }

}
