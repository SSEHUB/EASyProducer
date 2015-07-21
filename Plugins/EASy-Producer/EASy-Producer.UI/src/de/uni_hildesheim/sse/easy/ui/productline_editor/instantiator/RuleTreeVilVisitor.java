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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.AlternativeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleBlock;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.InstantiateExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.JoinExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.JoinVariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.LoadProperties;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.MapExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StrategyCallExpression;
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
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CompositeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ContainerInitializerExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.FieldAccessExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ParenthesisExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolvableOperationCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolvableOperationExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VarModelIdentifierExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VilTypeExpression;

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
        MapExpressionTreeNode result = new MapExpressionTreeNode(getCurrentParent(), map);
        visitRuleBlock(result, map);
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
