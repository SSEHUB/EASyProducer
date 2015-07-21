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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CompositeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ContainerInitializerExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.FieldAccessExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ParenthesisExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolvableOperationCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ResolvableOperationExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StringReplacer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VarModelIdentifierExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VilTypeExpression;

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
