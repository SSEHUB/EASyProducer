package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.IRuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements the resolver for VIL templates.
 * 
 * @author Holger Eichelberger
 */
public class Resolver extends net.ssehub.easy.instantiation.core.model.common.Resolver
    <Template, Def, TemplateCallExpression, VariableDeclaration> {

    /**
     * Defines the context types for the VIL template language.
     * 
     * @author Holger Eichelberger
     */
    public enum ContextType implements IContextType {
        
        /**
         * Within the template.
         */
        TEMPLATE,
        
        /**
         * Within an individual definition.
         */
        DEF;
    }

    /**
     * Creates a new resolver instance.
     * 
     * @param registry the (local) type registry
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
        return ContextType.TEMPLATE;
    }

    @Override
    protected TemplateCallExpression createCallExpression(Template model, boolean isSuper, String name,
        CallArgument... arguments) throws VilException {
        return new TemplateCallExpression(model, isSuper, name, arguments);
    }
    
    /**
     * Adds a model instance for resolution.
     * 
     * @param model the model instance
     */
    public void pushModel(Template model) {
        super.pushModel(model);
    }

}
