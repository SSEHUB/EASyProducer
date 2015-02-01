package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.utils.messages.IMessageHandler;

/**
 * Implements a VTL expression version restriction validator.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionVersionRestrictionValidator 
    extends de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionVersionRestrictionValidator 
    implements IVisitor {

    /**
    * Creates the validator with a message handler.
    * 
    * @param handler the message handler (may be <b>null</b> for absent)
    */
    public ExpressionVersionRestrictionValidator(IMessageHandler handler) {
        super(handler);
    }

    @Override
    public Object visitTemplate(Template template) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitDef(Def def) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilLanguageException {
        emit("not supported here", true, VilLanguageException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws ExpressionException {
        emit("template call is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

}
