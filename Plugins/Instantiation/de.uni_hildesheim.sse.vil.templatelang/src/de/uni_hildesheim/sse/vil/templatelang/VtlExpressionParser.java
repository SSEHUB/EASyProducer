package de.uni_hildesheim.sse.vil.templatelang;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

public class VtlExpressionParser implements IExpressionParser {

    // no private constructor!!!
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        try {
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(VtlExpressionParser.class, VtlBundleId.ID);
        }
        TemplateLangExecution.setExpressionParser(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        TemplateModel.INSTANCE.loaders().unregisterLoader(TemplateLangModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        // this is not the official way of using DS but the official way is instable
        TemplateLangExecution.setExpressionParser(null);
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws ExpressionException {
        return TemplateLangModelUtility.INSTANCE.createExpression(text, environment);
    }

}
