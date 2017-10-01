/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction.IVariableMapper;
import net.ssehub.easy.instantiation.core.Bundle;
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
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CopyVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

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
    public Object visitVariableDeclaration(VariableDeclaration var) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }
    
    @Override
    public Object visitCompound(net.ssehub.easy.instantiation.core.model.common.Compound compound) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
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
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        return new PathMatchExpression((Expression) expression.getExpression().accept(this));
    }
    
    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        return new BooleanMatchExpression((Expression) expression.getExpression().accept(this));
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        return new StringMatchExpression(expression.getText());
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        return new ArtifactMatchExpression((Expression) expression.getExpression().accept(this));
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        return new CollectionMatchExpression((Expression) expression.getExpression().accept(this));
    }

    @Override
    public Object visitScript(Script script) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitLoadProperties(LoadProperties properties) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitStrategyCallExpression(StrategyCallExpression call) throws VilException {
        Expression result;
        CallArgument[] arguments = copyCallArguments(call);
        switch (call.getType()) {
        case EXECUTE:
            net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration decl = 
                (net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration) 
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
    public Object visitRuleCallExpression(RuleCallExpression ex) throws VilException {
        Expression result;
        CallArgument[] arguments = copyCallArguments(ex);
        result = new RuleCallExpression(ex.getModel(), ex.isSuper(), ex.getName(), arguments);
        result.inferType();
        return result;
    }

    @Override
    public Object visitJoinExpression(JoinExpression ex) throws VilException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("JoinExpression is currently not copied.");
        return ex; // TODO support full copy
    }

    @Override
    public Object visitJoinVariableDeclaration(JoinVariableDeclaration decl) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitRule(Rule rule) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitRule(VtlRule rule) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitMapExpression(MapExpression map) throws VilException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("MapExpression is currently not copied.");
        return map; // TODO support full copy
    }

    @Override
    public Object visitInstantiateExpression(InstantiateExpression inst) throws VilException {
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
    public Object visitAlternativeExpression(AlternativeExpression alt) throws VilException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info(
            "AlternativeExpression is currently not copied.");
        return alt; // TODO support full copy
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        return new CompoundMatchExpression((CompositeExpression) expression.getCompositeExpression().accept(this));
    }

    @Override
    public Object visitTypedef(Typedef typedef) throws VilException {
        throw new VilException("not an expression", VilException.ID_INTERNAL);
    }

    @Override
    public Object visitWhileStatement(WhileStatement stmt) throws VilException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("while is currently not copied.");
        return stmt; // TODO support full copy
    }

    @Override
    public Object visitForStatement(ForStatement stmt) throws VilException {
        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("for is currently not copied.");
        return stmt; // TODO support full copy
    }

}
