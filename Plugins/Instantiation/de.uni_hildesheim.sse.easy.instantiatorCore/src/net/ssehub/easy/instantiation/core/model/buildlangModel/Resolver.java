package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.IRuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A specific resolver for the rule-based build language.
 * 
 * @author Holger Eichelberger
 */
public class Resolver extends net.ssehub.easy.instantiation.core.model.common.Resolver
    <Script, AbstractRule, RuleCallExpression, VariableDeclaration> {

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
     * 
     * @param registry a specific (local) registry
     */
    public Resolver(TypeRegistry registry) {
        super(registry);
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
        CallArgument... arguments) throws VilException {
        return new RuleCallExpression(model, isSuper, name, arguments);
    }
    
}
