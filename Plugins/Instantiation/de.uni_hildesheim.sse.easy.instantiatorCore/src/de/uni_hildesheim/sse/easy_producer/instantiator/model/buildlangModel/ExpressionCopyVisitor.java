package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CopyVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.IVariable;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction.IVariableMapper;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;

/**
 * The copy visitor for VIL expressions.
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
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException {
        return new PathMatchExpression((Expression) expression.getExpression().accept(this));
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException {
        return new StringMatchExpression(expression.getText());
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException {
        return new ArtifactMatchExpression((Expression) expression.getExpression().accept(this));
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException {
        return new CollectionMatchExpression((Expression) expression.getExpression().accept(this));
    }

    @Override
    public Object visitScript(Script script) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws ExpressionException {
        Expression result;
        CallArgument[] arguments = copyCallArguments(call);
        switch (call.getType()) {
        case EXECUTE:
            de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration decl = 
                (de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration) 
                map(call.getNameVariable(), false);
            result = new StrategyCallExpression(decl, arguments);
            break;
        case INSTANTIATOR:
            result = new StrategyCallExpression(call.getParent(), call.getName(), arguments);
            break;
        default:
            result = call; // this shall not happen
            break;
        }
        result.inferType();
        return result;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws ExpressionException {
        Expression result;
        CallArgument[] arguments = copyCallArguments(ex);
        result = new RuleCallExpression(ex.getModel(), ex.isSuper(), ex.getName(), arguments);
        result.inferType();
        return result;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws ExpressionException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("JoinExpression is currently not copied.");
        return ex; // TODO support full copy
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitRule(Rule rule) throws VilLanguageException {
        throw new VilLanguageException("not an expression", VilLanguageException.ID_INTERNAL);
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws ExpressionException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("MapExpression is currently not copied.");
        return map; // TODO support full copy
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws ExpressionException {
        Expression result;
        CallArgument[] arguments = copyCallArguments(inst);
        if (null == inst.getProject()) {
            result = new InstantiateExpression(inst.getName(), arguments);
        } else {
            IVersionRestriction restriction = inst.getVersionRestriction();
            if (null != restriction) {
                try {
                    restriction = restriction.copy(new IVariableMapper() {
                        
                        @Override
                        public IVariable map(IVariable variable) {
                            IVariable result = null;
                            if (variable instanceof VariableDeclaration) {
                                result = ExpressionCopyVisitor.this.map((VariableDeclaration) variable, true);
                            }
                            return result;
                        }
                    }); // as is
                } catch (RestrictionEvaluationException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
                }
            }
            result = new InstantiateExpression(inst.getProject(), restriction, inst.getName(), arguments);
        }
        result.inferType();
        return result;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws ExpressionException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info(
            "AlternativeExpression is currently not copied.");
        return alt; // TODO support full copy
    }

}
