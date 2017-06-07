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
package net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ConstantExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ContainerInitializerExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;
import net.ssehub.easy.instantiation.core.model.expressions.FieldAccessExpression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionParser;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.expressions.IRuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.expressions.MultiAndExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ParenthesisExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationCallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.ResolvableOperationExpression;
import net.ssehub.easy.instantiation.core.model.expressions.StringReplacer;
import net.ssehub.easy.instantiation.core.model.expressions.ValueAssignmentExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.expressions.VilTypeExpression;

/**
 * This class resolves match expressions if necessary.
 * 
 * @author Holger Eichelberger
 */
public class MatchResolver implements IExpressionVisitor, IMatchVisitor {

    private IRuntimeEnvironment environment;
    private IExpressionParser expressionParser; 
    private IExpressionVisitor evaluator;

    /**
     * Creates a match resolver.
     * 
     * @param environment the actual runtime environment
     * @param expressionParser the actual expression parser
     * @param evaluator the actual evaluator
     */
    public MatchResolver(IRuntimeEnvironment environment, IExpressionParser expressionParser, 
        IExpressionVisitor evaluator) {
        this.environment = environment;
        this.expressionParser = expressionParser;
        this.evaluator = evaluator;
    }
    
    /**
     * Resolves the given string.
     * 
     * @param string the string to be resolved
     * @return the resolved string
     * @throws VilException in case that resolution fails
     */
    private String resolve(String string) throws VilException {
        return StringReplacer.substitute(string, environment, expressionParser, evaluator);
    }
    
    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException {
        Object value = expression.getExpression().accept(this);
        if (value instanceof Path) {
            Path path = (Path) value;
            String text = resolve(path.getPath());
            Path resolved = Path.create(text);
            expression.resolve(resolved);
        } else {
            if (null != value) {
                throw new VilException("does not evaluate to a path", VilException.ID_RUNTIME);
            }
        }
        return null;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException {
        String text = resolve(expression.getText());
        Path path = Path.create(text);
        expression.resolve(path);
        return null;
    }
    
    @Override
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException {
        expression.resolve(expression.getExpression().accept(evaluator));
        return null;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException {
        expression.resolve(expression.getExpression().accept(evaluator));
        return null;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException {
        expression.resolve(expression.getExpression().accept(evaluator));
        return null;
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws VilException {
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws VilException {
        return null;
    }
    

    @Override
    public Object visitMultiAndExpression(MultiAndExpression ex) throws VilException {
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
        return null;
    }
    

    @Override
    public Object visitFieldAccessExpression(FieldAccessExpression ex) throws VilException {
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
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws VilException {
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws VilException {
        return null;
    }

    @Override
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException {
        String text = (String) expression.getCompositeExpression().accept(evaluator);
        if (null != text) {
            Path path = Path.create(text);
            expression.resolve(path);
        }
        return null;
    }

    @Override
    public Object visitCompositeExpression(CompositeExpression ex) throws VilException {
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
