package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Implements the resolver for VIL templates.
 * 
 * @author Holger Eichelberger
 */
public class Resolver extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Resolver
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
        CallArgument... arguments) throws ExpressionException {
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
