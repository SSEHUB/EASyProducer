package de.uni_hildesheim.sse.validation;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.eclipse.xtext.validation.Check;

import de.uni_hildesheim.sse.BuildLangConfig;
import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.VilBundleId;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
 

public class VilBuildLanguageJavaValidator extends AbstractVilBuildLanguageJavaValidator {

    // checkstyle: stop exception throw type check

    /**
     * Checks the model on top-level element layer. This method
     * is called by dynamic dispatch.
     * 
     * @param unit the variability unit to start tests with
     */
    @Check
    public void checkModel(ImplementationUnit unit) {
        java.net.URI uri = null;
        if (null != unit.eResource() && null != unit.eResource().getURI()) {
            try {
                uri = BuildLangModelUtility.toNetUri(unit.eResource().getURI());
            } catch (URISyntaxException e) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VilBundleId.ID);
                logger.error("error translating '" + unit.eResource().getURI() 
                    + "' during validation" + e.getMessage());
            }
        }
        try {
            TranslationResult<Script> result = BuildLangModelUtility.INSTANCE.createBuildModel(
                    unit, uri, false); // false = checkOnly!
            for (int m = 0; m < result.getMessageCount(); m++) {
                Message message = result.getMessage(m);
                switch (message.getStatus()) {
                case ERROR:
                case UNSUPPORTED:
                    error(message.getDescription(), message.getCause(),
                            message.getCausingFeature(), message.getCode());
                    break;
                case WARNING:
                    warning(message.getDescription(), message.getCause(),
                            message.getCausingFeature(), message.getCode());
                    break;
                default:
                    info(message.getDescription(), message.getCause(),
                            message.getCausingFeature(), message.getCode());
                    break;
                }
            }
            if (BuildLangConfig.isDebuggingEnabled() && 0 == result.getMessageCount()) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VilBundleId.ID);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintWriter pOut = new PrintWriter(out);
                pOut.println(">TRANSLATED MODEL");
                BuildLangModelUtility.INSTANCE.print(result, pOut, true, false);
                pOut.println("<TRANSLATED MODEL");
                logger.info(out.toString());
            }
        } catch (Exception e) {
            if (null != e.getMessage()) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VilBundleId.ID);
                logger.error("while validating IVML:" + e.getMessage());
            } // pare error
        }
    }
    
    // checkstyle: resume throw exception type check


}
