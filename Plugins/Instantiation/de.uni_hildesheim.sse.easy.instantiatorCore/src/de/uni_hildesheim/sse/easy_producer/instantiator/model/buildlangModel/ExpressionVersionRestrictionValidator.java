package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.BooleanMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CompoundMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Typedef;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import net.ssehub.easy.basics.messages.IMessageHandler;

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
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        emit("variable declaration is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        emit("advice is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        return null; // fallback
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        emit("match expression is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        emit("match expression is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        emit("match expression is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        emit("match expression is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        emit("match expression is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        emit("script is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        emit("load properties is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        emit("strategy call is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
        emit("rule call is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        emit("join is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        emit("join is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitRule(Rule rule) throws VilException {
        emit("rule is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        emit("map is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
        emit("instantiation is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        emit("alternative is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        emit("match expression is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        emit("typedef is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitWhileStatement(WhileStatement stmt) throws VilException {
        emit("while is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

    @Override
    public Object visitForStatement(ForStatement stmt) throws VilException {
        emit("for is not allowed here", true, VilException.ID_SEMANTIC);
        return null;
    }

}
