package de.uni_hildesheim.sse.vil.templatelang;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionParserRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Provides an expression parser for VTL.
 * 
 * @author Holger Eichelberger
 */
public class VtlExpressionParser implements IExpressionParser {

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
            EASyLoggerFactory.INSTANCE.getLogger(VtlExpressionParser.class, VtlBundleId.ID);
        }
        ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, this);
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
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws ExpressionException {
        return TemplateLangModelUtility.INSTANCE.createExpression(text, environment);
    }

}
