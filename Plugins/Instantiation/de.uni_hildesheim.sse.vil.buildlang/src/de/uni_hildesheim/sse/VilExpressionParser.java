package de.uni_hildesheim.sse;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.AbstractModelInitializer;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelInitializer;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionParser;
import net.ssehub.easy.instantiation.core.model.expressions.IRuntimeEnvironment;

/**
 * Provides an expression parser for VIL.
 * 
 * @author Holger Eichelberger
 */
public class VilExpressionParser extends AbstractModelInitializer<Script> implements IExpressionParser<Resolver> {

    // no private constructor!!!
    
    /**
     * Registers the expression parser in case that VIL shall be used without Eclipse-DS initialization. Do not call 
     * this method within Eclipse.
     * 
     * @return the registered instance (for {@link #unregister(VilExpressionParser)})
     */
    public static VilExpressionParser register() {
        VilExpressionParser parser = new VilExpressionParser();
        parser.activate(null);
        return parser;
    }
    
    /**
     * Unregisters the parser obtained from {@link #register()}.
     * 
     * @param parser the parser to unregister
     */
    public static void unregister(VilExpressionParser parser) {
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
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, 
                ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(VilExpressionParser.class, VilBundleId.ID).exception(e);
        }
        ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, this);
        ModelInitializer.register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        BuildModel.INSTANCE.loaders().unregisterLoader(BuildLangModelUtility.INSTANCE, 
            ProgressObserver.NO_OBSERVER);
        // this is not the official way of using DS but the official way is instable
        ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, null);
        ModelInitializer.unregister(this);
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws VilException {
        return BuildLangModelUtility.INSTANCE.createExpression(text, environment);
    }

    @Override
    public Expression parse(String text, Resolver resolver) throws VilException {
        return BuildLangModelUtility.INSTANCE.createExpression(text, resolver, null);
    }

    @Override
    public ModelManagement<Script> getModelManagement() {
        return BuildModel.INSTANCE;
    }

    @Override
    protected IModelLoader<Script> getModelLoader() {
        return BuildLangModelUtility.INSTANCE;
    }

}
