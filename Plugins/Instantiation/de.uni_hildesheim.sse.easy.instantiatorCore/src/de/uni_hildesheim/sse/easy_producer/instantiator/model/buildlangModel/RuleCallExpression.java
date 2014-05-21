package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ModelCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;

/**
 * Represents the explicit execution of a rule (precondition, rule body).
 * 
 * @author Holger Eichelberger
 */
public class RuleCallExpression extends ModelCallExpression<VariableDeclaration, Script, Rule> {

    /**
     * Creates a new rule call expression.
     * 
     * @param script the actual script to resolve the rule on
     * @param isSuper this is a super call
     * @param name the name of the rule
     * @param arguments the actual arguments
     * @throws ExpressionException in case of an erroneously qualified name
     */
    public RuleCallExpression(Script script, boolean isSuper, String name, CallArgument... arguments) 
        throws ExpressionException {
        super(script, isSuper, name, arguments);
    }
    
    /**
     * Creates a new rule call expression for a known operation.
     * 
     * @param script the actual script to containing <code>rule</code>
     * @param rule the resolved rule to call
     * @param arguments the actual arguments
     * @throws ExpressionException in case of an erroneously qualified name
     */
    RuleCallExpression(Script script, Rule rule, CallArgument... arguments) throws ExpressionException {
        super(script, rule, arguments);
    }

    @Override
    protected Class<Rule> getOperationClass() {
        return Rule.class;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitRuleCallExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
    
}
