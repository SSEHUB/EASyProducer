package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;

/**
 * A specific resolver for the rule-based build language.
 * 
 * @author Holger Eichelberger
 */
public class Resolver extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Resolver
    <Script, Rule, RuleCallExpression, VariableDeclaration> {

    /**
     * Defines the contexts for the VIL build language.
     * 
     * @author Holger Eichelberger
     */
    public enum ContextType implements IContextType {
        RULE_HEADER,
        RULE_BODY;
    }
    
    /**
     * Creates a new resolver instance.
     */
    public Resolver() {
        super();
    }
    
    /**
     * Creates a new resolver considering the runtime environment. (for expression
     * resolution only).
     * 
     * @param environment the runtime environment
     */
    public Resolver(IRuntimeEnvironment environment) {
        super(environment);
    }    

    @Override
    protected IContextType getDefaultType() {
        return ContextType.RULE_HEADER;
    }

    @Override
    protected RuleCallExpression createCallExpression(Script model, boolean isSuper, String name,
        CallArgument... arguments) throws ExpressionException {
        return new RuleCallExpression(model, isSuper, name, arguments);
    }
    
}
