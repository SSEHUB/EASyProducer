/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator.TreeNode.InsertionPoint;
import net.ssehub.easy.instantiation.core.model.buildlangModel.AlternativeExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ForStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IEnumeratingLoop;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.InstantiateExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinVariableDeclaration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.LoadProperties;
import net.ssehub.easy.instantiation.core.model.buildlangModel.MapExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleCallExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.StrategyCallExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.WhileStatement;
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
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.ParenthesisExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ValueAssignmentExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VilTypeExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a visitor which builds a resolver for modifying a VIL model. If the requested node
 * is found, the visitor intentionally returns an open resolver context for that specific element.
 * 
 * @author Holger Eichelberger
 */
class BuildResolverVisitor implements IVisitor, IExpressionVisitor {

    private InsertionPoint point;
    private Resolver resolver;
    private Rule rule;
    private Object stop;
    private IRuleBlock currentBlock;
    private int currentBlockPosition;
    
    /**
     * Creates a build resolver visitor.
     * 
     * @param registry the type registry to create the resolver
     * @param node the tree node to search for
     * @param point the insertion point around tree node (just before/after)
     */
    BuildResolverVisitor(TypeRegistry registry, TreeNode node, InsertionPoint point) {
        this.point = point;
        this.resolver = new Resolver(registry);
        TreeNode iter = node;
        while (null != iter && !(iter instanceof RuleTreeNode)) {
            iter = iter.getParent();
        }
        if (iter instanceof RuleTreeNode) {
            rule = ((RuleTreeNode) iter).getRule();
        }
        if (node instanceof ElementTreeNode) {
            stop = ((ElementTreeNode<?>) node).getElement();
        } else if (node instanceof RuleTreeNode) {
            stop = ((RuleTreeNode) node).getRule();
        }
    }
    
    /**
     * Returns the created resolver.
     * 
     * @return the created resolver
     */
    Resolver getResolver() {
        return resolver;
    }

    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        return stop == var;
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        return stop == advice;
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        Object result;
        if (stop == statement) {
            result = Boolean.TRUE;
        } else {
            result = statement.getExpression().accept(this);
        }
        return result;
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return stop == typedef;
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        return stop == expression;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        return stop == expression;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        return stop == expression;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        return stop == expression;
    }

    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        return stop == expression;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        return stop == expression;
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        resolver.pushModel(script);
        resolver.pushLevel();
        for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
            resolver.add(script.getVariableDeclaration(v));
        }
        if (null != rule && null != stop) {
            for (int r = 0; r < script.getRuleCount(); r++) {
                if (script.getRule(r) == rule) {
                    rule.accept(this);
                }
            }
        }
        return null;
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        return stop == properties;
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        return stop == call;
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        Object result;
        if (ex == stop && InsertionPoint.BEFORE_THIS == point) {
            result = Boolean.TRUE;
        } else {
            resolver.pushLevel();
            for (int v = 0; v < ex.getVariablesCount(); v++) {
                resolver.add(ex.getVariable(v));
            }
            if (rule == stop) {
                result = Boolean.TRUE;
            } else {
                result = visitBlock(rule);
            }
            if (Boolean.TRUE != result) {
                resolver.popLevel();
            }
        }
        return result;
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        return stop == decl;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        Object result;
        if (alt == stop && InsertionPoint.BEFORE_THIS == point) {
            result = Boolean.TRUE; // found
        } else {
            result = visitBlock(alt.getIfPart());
            if (null == result && null != alt.getElsePart()) {
                result = visitBlock(alt.getElsePart());
            }
        }
        return result;
    }

    @Override
    public Object visitRule(Rule rule) throws VilException {
        Object result;
        resolver.pushLevel();
        int count = rule.getParameterCount();
        if (rule.acceptsNamedParameters()) {
            count--;
        }
        for (int p = 0; p < count; p++) {
            resolver.add(rule.getParameter(p));
        }
        if (rule == stop) {
            result = Boolean.TRUE;
            currentBlock = rule;
            currentBlockPosition = 0;
        } else {
            result = visitBlock(rule);
        }
        if (Boolean.TRUE != result) {
            resolver.popLevel();
        }
        return result;
    }
    
    /**
     * Visits a block.
     * 
     * @param block the block to be visited
     * @return whether {@link #stop} was found
     * @throws VilException in case of visiting problems
     */
    private Object visitBlock(IRuleBlock block) throws VilException {
        currentBlock = block;
        Object found = null;
        currentBlockPosition = 0;
        while (null == found && currentBlockPosition < rule.getBodyElementCount()) {
            found = rule.getBodyElement(currentBlockPosition).accept(this);
            if (null == found) {
                currentBlockPosition++;
            }
        }
        return found;
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        return visitLoop(map);
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
        return stop == inst; // just stop if found
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        Object result;
        if (stop == par) {
            result = Boolean.TRUE;
        } else {
            result = par.accept(this);
        }
        return result;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        return stop == call;
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return stop == cst;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) throws VilException {
        return stop == identifier;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return stop == typeExpression;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        return stop == cst;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return stop == ex;
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        return stop == ex;
    }
    
    /**
     * Inserts an element into the current block of the last found position. Requires visiting to build a resolver 
     * before.
     * 
     * @param element the element to be inserted
     * @throws VilException in case of type problems 
     */
    void insertElement(IRuleElement element) throws VilException {
        if (null != currentBlock) {
            int pos = currentBlockPosition;
            if (InsertionPoint.AFTER_THIS == point) {
                pos++;
            }
            currentBlock.addBodyElement(pos, element);
            if (rule.getDefaultReturnType() != rule.getReturnType()) { 
                boolean found = false;
                for (int b = rule.getBodyElementCount() - 1; !found && b >= 0; b--) {
                    IRuleElement elt = rule.getBodyElement(b);
                    if (elt instanceof ExpressionStatement) {
                        ExpressionStatement eStmt = (ExpressionStatement) elt;
                        TypeDescriptor<?> exType = eStmt.getExpression().inferType();
                        if (!rule.getReturnType().isAssignableFrom(exType)) {
                            throw new VilException("Expected return type '" + rule.getReturnType().getVilName()
                                + "' does not match last expression type '" + exType.getVilName() + "'", 
                                VilException.ID_TYPE_INCOMPATIBILITY);
                        }
                        found = true;
                    }
                }
            }
        } else {
            throw new VilException("No current block", VilException.ID_INTERNAL);
        }
    }

    @Override
    public Object visitWhileStatement(WhileStatement stmt) throws VilException {
        Object result;
        if (stmt == stop && InsertionPoint.BEFORE_THIS == point) {
            result = Boolean.TRUE; // found
        } else {
            resolver.pushLevel();
            if (stmt == stop) {
                result = Boolean.TRUE;
            } else {
                result = visitBlock(stmt);
            }
            if (Boolean.TRUE != result) {
                resolver.popLevel();
            }
        }
        return result;
    }

    @Override
    public Object visitForStatement(ForStatement stmt) throws VilException {
        return visitLoop(stmt);
    }

    /**
     * Visits a loop.
     * 
     * @param loop the loop
     * @return the visiting result (<code>true</code> for stop)
     * @throws VilException in case of visiting problems
     */
    private Object visitLoop(IEnumeratingLoop loop) throws VilException {
        Object result;
        if (loop == stop && InsertionPoint.BEFORE_THIS == point) {
            result = Boolean.TRUE; // found
        } else {
            resolver.pushLevel();
            for (int v = 0; v < loop.getVariablesCount(); v++) {
                resolver.add(loop.getVariable(v));
            }
            if (loop == stop) {
                result = Boolean.TRUE;
            } else {
                result = visitBlock(loop);
            }
            if (Boolean.TRUE != result) {
                resolver.popLevel();
            }
        }
        return result;        
    }
    
}
