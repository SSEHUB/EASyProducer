package de.uni_hildesheim.sse;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

public class VilExpressionParser implements IExpressionParser {

    // no private constructor!!!
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        try {
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            EASyLoggerFactory.INSTANCE.getLogger(VilExpressionParser.class, VilBundleId.ID);
        }
        BuildlangExecution.setExpressionParser(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        BuildModel.INSTANCE.loaders().unregisterLoader(BuildLangModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        // this is not the official way of using DS but the official way is instable
        BuildlangExecution.setExpressionParser(null);
    }

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws ExpressionException {
        return BuildLangModelUtility.INSTANCE.createExpression(text, environment);
    }

}
