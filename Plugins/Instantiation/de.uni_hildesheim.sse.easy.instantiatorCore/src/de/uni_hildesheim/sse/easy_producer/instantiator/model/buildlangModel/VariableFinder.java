package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.PathMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.StringMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ContainerInitializerExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ParenthesisExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VarModelIdentifierExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VilTypeExpression;

/**
 * Searches whether given variables are used.
 * 
 * @author Holger Eichelberger
 */
class VariableFinder implements IBuildlangVisitor {

    private Set<VariableDeclaration> searchFor = new HashSet<VariableDeclaration>();
    private boolean found = false; 

    /**
     * Creates a new variable finder.
     */
    public VariableFinder() {
    }

    /**
     * Adds a variable to search for.
     * 
     * @param searchFor the variable to search for
     */
    public void addToSearch(VariableDeclaration searchFor) {
        if (null != searchFor) {
            this.searchFor.add(searchFor);
        }
    }
    
    /**
     * Adds variables to search for.
     * 
     * @param searchFor the variables to add
     */
    public void addToSearch(VariableDeclaration[] searchFor) {
        if (null != searchFor) {
            for (int v = 0; v < searchFor.length; v++) {
                this.searchFor.add(searchFor[v]);
            }
        }
    }
    
    /**
     * Resets this visitor.
     */
    public void reset() {
        this.searchFor.clear();
        found = false;
    }
    
    /**
     * Returns whether at least one variable was found.
     * 
     * @return <code>true</code> if at least one was found, <code>false</code> else
     */
    public boolean wasFound() {
        return found;
    }
    
    @Override
    public Object visitScript(Script script) throws VilLanguageException {
        for (int p = 0; !found && p < script.getParameterCount(); p++) {
            found = searchFor.contains(script.getParameter(p));
        }
        for (int r = 0; !found && r < script.getRuleCount(); r++) {
            script.getRule(r).accept(this);
        }
        return null;
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilLanguageException {
        return null;
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws ExpressionException {
        for (int a = 0; !found && a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws ExpressionException {
        for (int a = 0; !found && a < ex.getArgumentsCount(); a++) {
            ex.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws ExpressionException {
        for (int v = 0; !found && v < ex.getVariablesCount(); v++) {
            try {
                ex.getVariable(v).accept(this);
            } catch (VilLanguageException e) {
                throw new ExpressionException(e);
            }
        }
        return null;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilLanguageException {
        if (!found && null != decl.getExpression()) {
            try {
                decl.getExpression().accept(this);
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
            }
        }
        return null;
    }

    /**
     * Visits and searches in a given rule block.
     * 
     * @param block the block to search in
     * @throws VilLanguageException if visiting fails
     */
    private void visitRuleBlock(IRuleBlock block) throws VilLanguageException {
        for (int b = 0; !found && b < block.getBodyElementCount(); b++) {
            block.getBodyElement(b).accept(this);
        }
    }

    @Override
    public Object visitRule(Rule rule) throws VilLanguageException {
        for (int p = 0; !found && p < rule.getParameterCount(); p++) {
            found = searchFor.contains(rule.getParameter(p));
        }
        visitRuleBlock(rule);
        return null;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws ExpressionException {
        map.getExpression().accept(this);
        try {
            visitRuleBlock(map);
        } catch (VilLanguageException e) {
            throw new ExpressionException(e);
        }
        return null;
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilLanguageException {
        if (!found && null != var.getExpression()) {
            try {
                var.getExpression().accept(this);
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
            }
        }
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilLanguageException {
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilLanguageException {
        if (!found && null != statement.getExpression()) {
            try {
                statement.getExpression().accept(this);
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
            }
        }
        return null;
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException {
        par.getExpr().accept(this);
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws ExpressionException {
        for (int a = 0; !found && a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws ExpressionException {
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException {
        found = searchFor.contains(cst.getDeclaration());
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws ExpressionException {
        return null; // general visit statement
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException {
        if (!found && null != ex.getValueExpression()) {
            ex.getValueExpression().accept(this);
        }
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws ExpressionException {
        alt.getCondition().accept(this);
        try {
            visitRuleBlock(alt.getIfPart());
            if (null != alt.getElsePart()) {
                visitRuleBlock(alt.getElsePart());
            }
        } catch (VilLanguageException e) {
            throw new ExpressionException(e);
        }
        return null;
    }

}
