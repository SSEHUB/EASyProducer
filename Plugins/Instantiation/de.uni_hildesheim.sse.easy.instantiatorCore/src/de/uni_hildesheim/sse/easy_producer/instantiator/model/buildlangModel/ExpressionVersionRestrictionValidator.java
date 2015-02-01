package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.utils.messages.IMessageHandler;

/**
 * Implements a VIL expression version restriction validator.
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
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilLanguageException {
        emit("variable declaration is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilLanguageException {
        emit("advice is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilLanguageException {
        return null; // fallback
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException {
        emit("match expression is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException {
        emit("match expression is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException {
        emit("match expression is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException {
        emit("match expression is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitScript(Script script) throws VilLanguageException {
        emit("script is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilLanguageException {
        emit("load properties is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws ExpressionException {
        emit("strategy call is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws ExpressionException {
        emit("rule call is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws ExpressionException {
        emit("join is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilLanguageException {
        emit("join is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitRule(Rule rule) throws VilLanguageException {
        emit("rule is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws ExpressionException {
        emit("map is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws ExpressionException {
        emit("instantiation is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws ExpressionException {
        emit("alternative is not allowed here", true, ExpressionException.ID_SEMANTIC);
        return null;
    }

}
