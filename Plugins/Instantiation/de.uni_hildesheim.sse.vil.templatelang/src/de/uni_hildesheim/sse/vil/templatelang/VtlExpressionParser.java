package de.uni_hildesheim.sse.vil.templatelang;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.AbstractModelInitializer;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelInitializer;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionParser;
import net.ssehub.easy.instantiation.core.model.expressions.IRuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.templateModel.Resolver;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;

/**
 * Provides an expression parser for VTL.
 * 
 * @author Holger Eichelberger
 */
public class VtlExpressionParser extends AbstractModelInitializer<Template> implements IExpressionParser<Resolver> {

    // no private constructor!!!
    
    /**
     * Registers the expression parser in case that VTL shall be used without Eclipse-DS initialization. Do not call 
     * this method within Eclipse.
     * 
     * @return the registered instance (for {@link #unregister(VtlExpressionParser)})
     */
    public static VtlExpressionParser register() {
        VtlExpressionParser parser = new VtlExpressionParser();
        parser.activate(null);
        return parser;
    }
    
    /**
     * Unregisters the parser obtained from {@link #register()}.
     * 
     * @param parser the parser to unregister
     */
    public static void unregister(VtlExpressionParser parser) {
        if (null != parser) {
            parser.deactivate(null);
        }
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        try {
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, 
                ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(VtlExpressionParser.class, VtlBundleId.ID).exception(e);
        }
        ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, this);
        ModelInitializer.register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        TemplateModel.INSTANCE.loaders().unregisterLoader(TemplateLangModelUtility.INSTANCE, 
            ProgressObserver.NO_OBSERVER);
        // this is not the official way of using DS but the official way is instable
        ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, null);
        ModelInitializer.unregister(this);
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws VilException {
        return TemplateLangModelUtility.INSTANCE.createExpression(text, environment);
    }
    
    @Override
    public Expression parse(String text, Resolver resolver) throws VilException {
        return TemplateLangModelUtility.INSTANCE.createExpression(text, resolver, null);
    }

    @Override
    protected ModelManagement<Template> getModelManagement() {
        return TemplateModel.INSTANCE;
    }

    @Override
    protected IModelLoader<Template> getModelLoader() {
        return TemplateLangModelUtility.INSTANCE;
    }

}
