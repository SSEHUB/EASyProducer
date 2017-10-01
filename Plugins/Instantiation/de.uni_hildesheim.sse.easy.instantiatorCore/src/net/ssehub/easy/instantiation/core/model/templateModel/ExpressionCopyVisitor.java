package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction.IVariableMapper;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
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
    public Object visitAdvice(Advice advice) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
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
    public Object visitFlush(FlushStatement stmt) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }
    
    @Override
    public Object visitWhile(WhileStatement stmt) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }
    
    @Override
    public Object visitCompound(net.ssehub.easy.instantiation.core.model.common.Compound compound) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitContentAlternativeExpression(ContentAlternativeExpression ex) throws VilException {
        List<Expression> thenEx = copyExpressions(ex.thenEx());
        List<Expression> elseEx;
        if (ex.getElseExpressionsCount() > 0) {
            elseEx = copyExpressions(ex.elseEx());
        } else {
            elseEx = null;
        }
        return new ContentAlternativeExpression(copyExpression(ex.getCondition()), thenEx, elseEx);
    }

    @Override
    public Object visitContentLoopExpression(ContentLoopExpression ex) throws VilException {
        List<Expression> bodyEx = copyExpressions(ex);
        return new ContentLoopExpression(ex.getIterator(), copyExpression(ex.getInit()), 
            copyExpression(ex.getSeparator()), copyExpression(ex.getEndSeparator()), bodyEx);
    }

    @Override
    public Object visitContentVarDeclExpression(ContentVarDeclExpression ex) throws VilException {
        return new ContentVarDeclExpression(ex.getVariable());
    }

    @Override
    public Object visitContentImportExpression(ContentImportExpression ex) throws VilException {
        IVersionRestriction res = null;
        if (null != ex.getVersionRestriction()) {
            try {
                res = ex.getVersionRestriction().copy(getMapper());
            } catch (RestrictionEvaluationException e) {
            }
        }
        return new ContentImportExpression(ex.getTemplate(), res);
    }

}
