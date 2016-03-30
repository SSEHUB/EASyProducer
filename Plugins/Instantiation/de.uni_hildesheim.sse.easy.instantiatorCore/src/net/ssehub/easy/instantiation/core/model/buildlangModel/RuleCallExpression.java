package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.ModelCallExpression;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;

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
     * @throws VilException in case of an erroneously qualified name
     */
    public RuleCallExpression(Script script, boolean isSuper, String name, CallArgument... arguments) 
        throws VilException {
        super(script, isSuper, name, arguments);
    }
    
    /**
     * Creates a new rule call expression for a known operation.
     * 
     * @param script the actual script to containing <code>rule</code>
     * @param rule the resolved rule to call
     * @param arguments the actual arguments
     * @throws VilException in case of an erroneously qualified name
     */
    RuleCallExpression(Script script, Rule rule, CallArgument... arguments) throws VilException {
        super(script, rule, arguments);
    }

    @Override
    protected Class<? extends Rule> getOperationClass() {
        return Rule.class;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitRuleCallExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
    
    @Override
    protected String getInvalidOperationMessage(IMetaOperation op) {
        return op.getJavaSignature() + " is not a valid rule";
    }

    @Override
    public boolean isVisible(Script fromModel) {
        boolean isVisible = true;
        Rule resolved = getResolved();
        if (resolved.isProtected()) {
            isVisible = resolved.getDeclaringType().equals(fromModel);
        }
        return isVisible;
    }
    
}
