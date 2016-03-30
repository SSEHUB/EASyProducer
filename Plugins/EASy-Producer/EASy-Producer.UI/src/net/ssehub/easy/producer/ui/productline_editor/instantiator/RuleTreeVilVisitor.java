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
package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.ssehub.easy.instantiation.core.model.buildlangModel.AlternativeExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ForStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.InstantiateExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.JoinVariableDeclaration;
import net.ssehub.easy.instantiation.core.model.buildlangModel.LoadProperties;
import net.ssehub.easy.instantiation.core.model.buildlangModel.MapExpression;
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
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;

/**
 * A visitor turning a VIL script into a tree suitable for SWT display.
 *  
 * @author Holger Eichelberger
 */
public class RuleTreeVilVisitor implements IVisitor, IExpressionVisitor {

    private List<RuleTreeNode> rootNodes = new ArrayList<RuleTreeNode>();
    private Stack<TreeNode> parents = new Stack<TreeNode>();
    
    /**
     * Returns the root nodes.
     * 
     * @return the created root nodes
     */
    RuleTreeNode[] getRootNodes() {
        RuleTreeNode[] tmp = new RuleTreeNode[rootNodes.size()];
        return rootNodes.toArray(tmp);
    }
    
    /**
     * Returns the current parent.
     * 
     * @return the current parent
     */
    private TreeNode getCurrentParent() {
        return parents.isEmpty() ? null : parents.peek();
    }
    
    @Override
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        return new VariableDeclarationTreeNode(getCurrentParent(), var);
    }

    @Override
    public Object visitAdvice(Advice advice) throws VilException {
        return null; // ignore
    }

    @Override
    public Object visitExpressionStatement(ExpressionStatement statement) throws VilException {
        return statement.getExpression().accept(this);
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        return null; // ignore
    }

    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
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
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        return null;
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        for (int v = 0; v < script.getVariableDeclarationCount(); v++) {
            script.getVariableDeclaration(v).accept(this);
        }
        for (int r = 0; r < script.getRuleCount(); r++) {
            script.getRule(r).accept(this);
        }
        return null;
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        return null; // ignore for now
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        Object result;
        if (CallType.TRANSPARENT != call.getCallType()) {
            result = new StrategyCallExpressionTreeNode(getCurrentParent(), call);
        } else {
            result = null; // don't show conversions
        }
        return result; 
    }

    @Override
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
        return new RuleCallExpressionTreeNode(getCurrentParent(), ex);
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        return new JoinExpressionTreeNode(getCurrentParent(), ex); // preliminary
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        return null;
    }

    @Override
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        AlternativeExpressionTreeNode node = new AlternativeExpressionTreeNode(getCurrentParent(), alt);
        TextTreeNode ifNode = new AlternativeBranchTreeNode(node, true);
        visitRuleBlock(ifNode, alt.getIfPart());
        if (null != alt.getElsePart()) {
            TextTreeNode elseNode = new AlternativeBranchTreeNode(node, false);
            visitRuleBlock(elseNode, alt.getElsePart());
        }
        return node;
    }

    @Override
    public Object visitRule(Rule rule) throws VilException {
        RuleTreeNode node = new RuleTreeNode(rule);
        rootNodes.add(node);
        parents.push(node);
        visitRuleBlock(node, rule);
        parents.pop();
        return node;
    }
    
    /**
     * Visits a rule block and add the created nodes as children of <code>node</code>.
     * 
     * @param node the node to be modified
     * @param block the block to be visited
     */
    private void visitRuleBlock(TreeNode node, IRuleBlock block) {
        List<TreeNode> children = new ArrayList<TreeNode>();
        for (int e = 0; e < block.getBodyElementCount(); e++) {
            try {
                Object o = block.getBodyElement(e).accept(this);
                if (o instanceof TreeNode) {
                    children.add((TreeNode) o);
                }
            } catch (VilException ex) {
                // ignore
            }
        }
        TreeNode[] tmp = new TreeNode[children.size()];
        node.setChildren(children.toArray(tmp));
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        LoopExpressionTreeNode result = new LoopExpressionTreeNode(getCurrentParent(), map);
        visitRuleBlock(result, map);
        return result;
    }
    
    @Override
    public Object visitWhileStatement(WhileStatement stmt) throws VilException {
        WhileTreeNode result = new WhileTreeNode(getCurrentParent(), stmt);
        visitRuleBlock(result, stmt);
        return result;        
    }

    @Override
    public Object visitForStatement(ForStatement stmt) throws VilException {
        LoopExpressionTreeNode result = new LoopExpressionTreeNode(getCurrentParent(), stmt);
        visitRuleBlock(result, stmt);
        return result;
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
        return new InstantiateExpressionTreeNode(getCurrentParent(), inst);
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        return new CallExpressionTreeNode(getCurrentParent(), call);
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws VilException {
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) throws VilException {
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws VilException {
        return null;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws VilException {
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitResolvableOperationExpression(ResolvableOperationExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitResolvableOperationCallExpression(ResolvableOperationCallExpression ex) throws VilException {
        return null;
    }

}
