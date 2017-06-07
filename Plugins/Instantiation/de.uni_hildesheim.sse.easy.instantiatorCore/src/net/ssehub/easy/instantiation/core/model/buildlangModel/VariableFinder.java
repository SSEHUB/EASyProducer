package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.ArtifactMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.BooleanMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.CollectionMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.CompoundMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.PathMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.StringMatchExpression;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ContainerInitializerExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;
import net.ssehub.easy.instantiation.core.model.expressions.FieldAccessExpression;
import net.ssehub.easy.instantiation.core.model.expressions.MultiAndExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ParenthesisExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ValueAssignmentExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VilTypeExpression;

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
    public Object visitScript(Script script) throws VilException {
        for (int p = 0; !found && p < script.getParameterCount(); p++) {
            found = searchFor.contains(script.getParameter(p));
        }
        for (int r = 0; !found && r < script.getRuleCount(); r++) {
            script.getRule(r).accept(this);
        }
        return null;
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        return null;
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        for (int a = 0; !found && a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
        for (int a = 0; !found && a < ex.getArgumentsCount(); a++) {
            ex.getArgument(a).accept(this);
        }
        return null;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        for (int v = 0; !found && v < ex.getVariablesCount(); v++) {
            ex.getVariable(v).accept(this);
        }
        return null;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        if (!found && null != decl.getExpression()) {
            decl.getExpression().accept(this);
        }
        return null;
    }

    /**
     * Visits and searches in a given rule block.
     * 
     * @param block the block to search in
     * @throws VilException if visiting fails
     */
    private void visitRuleBlock(IRuleBlock block) throws VilException {
        for (int b = 0; !found && b < block.getBodyElementCount(); b++) {
            block.getBodyElement(b).accept(this);
        }
    }
    
    @Override
    public Object visitRule(VtlRule rule) throws VilException {
        for (int p = 0; !found && p < rule.getParameterCount(); p++) {
            found = searchFor.contains(rule.getParameter(p));
        }
        // rule block not needed
        return null;
    }

    @Override
    public Object visitRule(Rule rule) throws VilException {
        for (int p = 0; !found && p < rule.getParameterCount(); p++) {
            found = searchFor.contains(rule.getParameter(p));
        }
        visitRuleBlock(rule);
        return null;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        map.getExpression().accept(this);
        visitRuleBlock(map);
        return null;
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        if (!found && null != var.getExpression()) {
            var.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        return null;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        if (!found && null != statement.getExpression()) {
            statement.getExpression().accept(this);
        }
        return null;
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        par.getExpr().accept(this);
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        for (int a = 0; !found && a < call.getArgumentsCount(); a++) {
            call.getArgument(a).accept(this);
        }
        return null;
    }
    

    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
        for (int e = 0; !found && e < ex.getExpressionCount(); e++) {
            ex.getExpression(e).accept(this);
        }
        return null;
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws VilException {
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return null;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        found = searchFor.contains(cst.getDeclaration());
        return null;
    }
    
    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        if (null != ex.getNested()) {
            ex.getNested().accept(this);
        } else {
            found = searchFor.contains(ex.getVariable());
        }
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return null; // general visit statement
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        if (!found && null != ex.getValueExpression()) {
            ex.getValueExpression().accept(this);
        }
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
        return null;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        alt.getCondition().accept(this);
        visitRuleBlock(alt.getIfPart());
        if (null != alt.getElsePart()) {
            visitRuleBlock(alt.getElsePart());
        }
        return null;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        ex.getVariable().accept(this);
        return null;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return null; // no variables involved
    }

    @Override
    public Object visitWhileStatement(WhileStatement stmt) throws VilException {
        stmt.getCondition().accept(this);
        visitRuleBlock(stmt);
        return null;
    }

    @Override
    public Object visitForStatement(ForStatement stmt) throws VilException {
        stmt.getExpression().accept(this);
        visitRuleBlock(stmt);
        return null;
    }

}
