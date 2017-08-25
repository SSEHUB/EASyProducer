/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.StringResolver.IExpressionTranslator;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentAlternativeExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Simplified expression parser for testing.
 * 
 * @author Holger Eichelberger
 */
class ExpressionParser implements IExpressionParser, IExpressionTranslator<VarDecl, VarResolver>, 
    IStringResolverFactory<VarDecl> {

    @Override
    public Expression parse(String text, IRuntimeEnvironment environment) throws VilException {
        Expression result = null;
        int startPos = text.indexOf('(');
        int endPos = text.lastIndexOf(')');
        if (startPos > 0 && endPos > 0) {
            String name = text.substring(0, startPos);
            String tmp = text.substring(startPos + 1, endPos);
            StringTokenizer tokens = new StringTokenizer(tmp, ",");
            List<Expression> params = new ArrayList<Expression>();
            while (tokens.hasMoreTokens()) {
                params.add(parse(tokens.nextToken().trim(), environment));
            }
            Expression[] p = new Expression[params.size()];
            params.toArray(p);
            result = new CallExpression(null, name, p);
        } else if (text.startsWith("\"") && text.endsWith("\"")) {
            result = new ConstantExpression(TypeRegistry.stringType(), text, TypeRegistry.DEFAULT);
        } else {
            IResolvable res = environment.get(text);
            if (res instanceof VariableDeclaration) {
                result = new VariableExpression((VariableDeclaration) res);
            }
        }
        if (null == result) { // fallback to some constant
            result = new ConstantExpression(TypeRegistry.stringType(), text, TypeRegistry.DEFAULT);
        }
        return result;
    }

    @Override
    public Expression parseExpression(String expression, VarResolver resolver, StringBuilder warnings)
        throws VilException {
        return parse(expression, resolver.getRuntimeEnvironment());
    }

    @Override
    public Expression createIfExpression(InPlaceIfCommand<VarDecl> cmd) 
        throws VilException {
        return new ContentAlternativeExpression(cmd.getCondition(), cmd.getThenExpressions(), cmd.getElseExpressions());
    }

    @Override
    public Expression createForExpression(InPlaceForCommand<VarDecl> cmd) throws VilException {
        return null;
    }

    @Override
    public VarDecl createVariable(String name, Expression initExpression) throws VilException {
        TypeDescriptor<?> type = initExpression.inferType();
        return new VarDecl(name, type);
    }

}
