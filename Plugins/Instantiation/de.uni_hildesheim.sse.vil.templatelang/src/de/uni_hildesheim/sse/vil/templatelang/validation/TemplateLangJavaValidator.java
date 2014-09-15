package de.uni_hildesheim.sse.vil.templatelang.validation;

import java.io.Writer;
import java.net.URI;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils.IModelValidationCallback;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils.MessageType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangConfig;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
 
public class TemplateLangJavaValidator extends AbstractTemplateLangJavaValidator {

    private IModelValidationCallback<LanguageUnit, Template> callback = new IModelValidationCallback<LanguageUnit, 
        Template>() {

        @Override
        public TranslationResult<Template> createModel(LanguageUnit unit, URI uri) {
            return TemplateLangModelUtility.INSTANCE.createModel(unit, uri, false); // false = checkOnly!
        }

        @Override
        public void message(MessageType type, String message, EObject source, EStructuralFeature feature, 
            int identifier) {
            switch (type) {
            case ERROR:
                error(message, source, feature, identifier);
                break;
            case INFO:
                info(message, source, feature, identifier);
                break;
            case WARNING:
                warning(message, source, feature, identifier);
                break;
            default:
                break;
            }
        }

        @Override
        public void print(TranslationResult<Template> result, Writer out) {
            TemplateLangModelUtility.INSTANCE.print(result, out, true, false);
        }
        
    };

    /**
     * Checks the model on top-level element layer. This method
     * is called by dynamic dispatch.
     * 
     * @param unit the variability unit to start tests with
     */
    @Check
    public void checkModel(LanguageUnit unit) {
        ValidationUtils.checkModel(unit, callback, TemplateLangConfig.isDebuggingEnabled());
        /*java.net.URI uri = null;
        if (null != unit.eResource() && null != unit.eResource().getURI()) {
            try {
                uri = TemplateLangModelUtility.toNetUri(unit.eResource().getURI());
            } catch (URISyntaxException e) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VtlBundleId.ID);
                logger.error("error translating '" + unit.eResource().getURI() 
                    + "' during validation" + e.getMessage());
            }
        }
        try {
            TranslationResult<Template> result = TemplateLangModelUtility.INSTANCE.createModel(
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
            if (TemplateLangConfig.isDebuggingEnabled() && 0 == result.getMessageCount()) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VtlBundleId.ID);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintWriter pOut = new PrintWriter(out);
                pOut.println(">TRANSLATED MODEL");
                TemplateLangModelUtility.INSTANCE.print(result, pOut, true, false);
                pOut.println("<TRANSLATED MODEL");
                logger.info(out.toString());
            }
        } catch (Exception e) {
            if (null != e.getMessage()) {
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VtlBundleId.ID);
                logger.error("while validating IVML:" + e.getMessage());
            } // pare error
        }*/
    }

}
