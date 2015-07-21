package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CopyVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction.IVariableMapper;

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

}
