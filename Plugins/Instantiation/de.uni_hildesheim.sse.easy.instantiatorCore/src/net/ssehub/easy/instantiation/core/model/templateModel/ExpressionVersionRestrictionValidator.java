package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.basics.messages.IMessageHandler;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Implements a VTL expression version restriction validator.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionVersionRestrictionValidator 
    extends net.ssehub.easy.instantiation.core.model.expressions.ExpressionVersionRestrictionValidator 
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
    public Object visitTemplate(Template template) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitDef(Def def) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException {
        emit("template call is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitFlush(FlushStatement stmt) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitWhile(WhileStatement stmt) throws VilException {
        emit("not supported here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        emit("advice is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        emit("typedef is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        return null; // fallback
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        emit("variable declaration is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

}
