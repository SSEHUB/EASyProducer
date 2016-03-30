package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction.IVariableMapper;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CopyVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * The copy visitor for VTL expressions.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionCopyVisitor extends CopyVisitor implements IVisitor {

    /**
     * Creates a new copy visitor.
     * 
     * @param mapping the variable mapping to be considered while copying (may be <b>null</b> for no mapping)
     * @param reuse whether leaves shall be reused rather than created again
     */
    public ExpressionCopyVisitor(Map<VariableDeclaration, VariableDeclaration> mapping, boolean reuse) {
        super(mapping, reuse);
    }
    
    /**
     * Creates a new copy visitor.
     * 
     * @param mapping the variable mapping to be considered while copying (may be <b>null</b> for no mapping)
     * @param reuse whether leaves shall be reused rather than created again
     * @param mapper an optional variable mapper (may be <b>null</b> if absent)
     */
    public ExpressionCopyVisitor(Map<VariableDeclaration, VariableDeclaration> mapping, boolean reuse, 
        IVariableMapper mapper) {
        super(mapping, reuse, mapper);
    }

    @Override
    public Object visitTemplate(Template template) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitDef(Def def) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitTemplateBlock(TemplateBlock block) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitAlternative(AlternativeStatement alternative) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitLoop(LoopStatement loop) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitSwitch(SwitchStatement swtch) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitContentStatement(ContentStatement cnt) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitJavaExtension(JavaExtension ext) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitTemplateCallExpression(TemplateCallExpression call) throws VilException {
        Expression result = new TemplateCallExpression(call.getModel(), call.getResolved(), copyCallArguments(call));
        result.inferType();
        return result;
    }

    @Override
    public Object visitWhile(WhileStatement stmt) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

}
