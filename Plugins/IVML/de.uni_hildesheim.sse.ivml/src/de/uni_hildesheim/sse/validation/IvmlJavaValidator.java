package de.uni_hildesheim.sse.validation;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.eclipse.xtext.validation.Check;

import de.uni_hildesheim.sse.Config;
import de.uni_hildesheim.sse.IvmlBundleId;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * The on-the-fly validator calling the model transformation mechanism.
 */
public class IvmlJavaValidator extends AbstractIvmlJavaValidator {

    // checkstyle: stop exception throw type check

    /**
     * Checks the model on top-level element layer. This method
     * is called by dynamic dispatch.
     * 
     * @param unit the variability unit to start tests with
     */
    @Check
    public void checkModel(VariabilityUnit unit) {
        java.net.URI uri = null;
        if (null != unit.eResource() && null != unit.eResource().getURI()) {
            try {
                uri = ModelUtility.toNetUri(unit.eResource().getURI());
            } catch (URISyntaxException e) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), IvmlBundleId.ID);
                logger.error("error translating '" + unit.eResource().getURI() 
                    + "' during validation" + e.getMessage());
            }
        }
        try {
            TranslationResult<Project> result = ModelUtility.INSTANCE.createVarModel(
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
            if (Config.isDebuggingEnabled() && 0 == result.getMessageCount()) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), IvmlBundleId.ID);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintWriter pOut = new PrintWriter(out);
                pOut.println(">TRANSLATED MODEL");
                ModelUtility.INSTANCE.print(result, pOut, true, false);
                pOut.println("<TRANSLATED MODEL");
                logger.info(out.toString());
            }
        } catch (Exception e) {
            EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), IvmlBundleId.ID);
            logger.error("while validating IVML:" + e.getMessage());
        }
    }
    
    // checkstyle: resume throw exception type check

}
