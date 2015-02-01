package de.uni_hildesheim.sse.vil.rt;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionParserRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVilExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVilModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Provides an expression parser for rtVIL.
 * 
 * @author Holger Eichelberger
 */
public class RtVilExpressionParser implements IExpressionParser {

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
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws ExpressionException {
        return RtVilModelUtility.INSTANCE.createExpression(text, environment);
    }

}
