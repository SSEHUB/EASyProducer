package de.uni_hildesheim.sse.vil.rt;

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
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilExecution;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;

/**
 * Provides an expression parser for rtVIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilExpressionParser extends AbstractModelInitializer<Script> implements IExpressionParser {

    // no private constructor!!!
    
    /**
     * Registers the expression parser in case that VIL shall be used without Eclipse-DS initialization. Do not call 
     * this method within Eclipse.
     * 
     * @return the registered instance (for {@link #unregister(RtVilExpressionParser)})
     */
    public static RtVilExpressionParser register() {
        RtVilExpressionParser parser = new RtVilExpressionParser();
        parser.activate(null);
        return parser;
    }
    
    /**
     * Unregisters the parser obtained from {@link #register()}.
     * 
     * @param parser the parser to unregister
     */
    public static void unregister(RtVilExpressionParser parser) {
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
            RtVilModel.INSTANCE.loaders().registerLoader(RtVilModelUtility.INSTANCE, 
                ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(RtVilExpressionParser.class, RtVilBundleId.ID);
        }
        ExpressionParserRegistry.setExpressionParser(RtVilExecution.LANGUAGE, this);
        ModelInitializer.register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        RtVilModel.INSTANCE.loaders().unregisterLoader(RtVilModelUtility.INSTANCE, 
            ProgressObserver.NO_OBSERVER);
        // this is not the official way of using DS but the official way is instable
        ExpressionParserRegistry.setExpressionParser(RtVilExecution.LANGUAGE, null);
        ModelInitializer.unregister(this);
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws VilException {
        return RtVilModelUtility.INSTANCE.createExpression(text, environment);
    }

    @Override
    protected ModelManagement<Script> getModelManagement() {
        return RtVilModel.INSTANCE;
    }

    @Override
    protected IModelLoader<Script> getModelLoader() {
        return RtVilModelUtility.INSTANCE;
    }

}
