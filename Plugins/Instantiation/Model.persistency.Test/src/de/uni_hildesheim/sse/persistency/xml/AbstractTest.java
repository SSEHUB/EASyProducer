package de.uni_hildesheim.sse.persistency.xml;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.easy.java.Registration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionParserRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;

/**
 * The refined version of abstract tests for the build language.
 * 
 * @author Sass
 *
 */
public abstract class AbstractTest extends AbstractUtil {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(AbstractTest.class, 
            "Model.persistency.Test");
    
    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
    
    /**
     * Creates and initializes an abstract test.
     */
    protected AbstractTest() {
        Registration.register();
        BuiltIn.initialize();
        ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, new VilExpressionParser());
        ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, new VtlExpressionParser());
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
            VarModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
        } catch (ModelManagementException e) {
            logger.exception(e);
        }
    }
    
}
