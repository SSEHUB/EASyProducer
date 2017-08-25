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
        return parseToExpression(text, environment, null, null);
    }
    
    /**
     * Parses text to an expression. Does recursive parsing using the {@link StringResolver} if <code>resolver</code>
     * and <code>warnings</code> are given.
     * 
     * @param text the text to parse
     * @param environment the runtime environment
     * @param resolver the resolver instance (may be <b>null</b>)
     * @param warnings the warnings collector (may be <b>null</b>)
     * @return the parsed expression
     * @throws VilException in case that parsing/expression evaluation fails
     */
    private Expression parseToExpression(String text, IRuntimeEnvironment environment, 
        VarResolver resolver, StringBuilder warnings) throws VilException {
        Expression result = null;
        int startPos = text.indexOf('(');
        int endPos = text.lastIndexOf(')');
        int startBrPos = text.indexOf('{');
        int endBrPos = text.lastIndexOf('}');
        final int textEndPos = text.length() - 1;
        if (startPos > 0 && textEndPos == endPos) {
            String name = text.substring(0, startPos);
            String tmp = text.substring(startPos + 1, endPos);
            StringTokenizer tokens = new StringTokenizer(tmp, ",");
            List<Expression> params = new ArrayList<Expression>();
            while (tokens.hasMoreTokens()) {
                String tok = tokens.nextToken().trim();
                params.add(parseToExpression(tok, environment, resolver, warnings));
            }
            Expression[] p = new Expression[params.size()];
            params.toArray(p);
            result = new CallExpression(null, name, p);
        } else if (0 == startBrPos && textEndPos == endBrPos) {
            String tmp = text.substring(startBrPos + 1, endBrPos);
            StringTokenizer tokens = new StringTokenizer(tmp, ",");
            List<Expression> params = new ArrayList<Expression>();
            while (tokens.hasMoreTokens()) {
                params.add(parseToExpression(tokens.nextToken().trim(), environment, resolver, warnings));
            }
            Expression[] p = new Expression[params.size()];
            params.toArray(p);
            result = new ContainerInitializerExpression(p);
        } else if (text.startsWith("\"") && text.endsWith("\"")) {
            result = parseString(text, resolver, warnings);
        } else {
            IResolvable res = environment.get(text);
            if (res instanceof VariableDeclaration) {
                result = new VariableExpression((VariableDeclaration) res);
            }
        }
        if (null == result) { // fallback to some constant
            result = parseString(text, resolver, warnings);
        }
        return result;
    }

    /**
     * Parses a string (intended to be a constant, may contain a substitutable expression) into an expression.
     * 
     * @param text the text to parse
     * @param resolver the resolver instance (may be <b>null</b>)
     * @param warnings the warnings collector (may be <b>null</b>)
     * @return the parsed expression
     * @throws VilException in case that parsing/expression evaluation fails
     */
    private Expression parseString(String text, VarResolver resolver, StringBuilder warnings) throws VilException {
        Expression result;
        if (null != resolver && null != warnings) {
            result = StringResolver.substitute(text, resolver, this, warnings, this);
        } else {
            result = new ConstantExpression(TypeRegistry.stringType(), text, TypeRegistry.DEFAULT);
        }
        return result;
    }

    @Override
    public Expression parseExpression(String expression, VarResolver resolver, StringBuilder warnings)
        throws VilException {
        return parseToExpression(expression, resolver.getRuntimeEnvironment(), resolver, warnings);
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
