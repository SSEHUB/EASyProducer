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
package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * Replaces an in-place if-command/expression within a string/content expression.
 * 
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public class InPlaceIfCommand<I extends VariableDeclaration> extends InPlaceCommand<I> {

    private Expression condition;
    private List<Expression> thenEx;
    private List<Expression> elseEx;
    private transient List<Expression> curEx;

    /**
     * Creates an in-place alternative.
     * 
     * @param condition the condition of the alternative
     */
    InPlaceIfCommand(Expression condition) {
        this.condition = condition;
        this.thenEx = new ArrayList<Expression>();
        this.curEx = thenEx;
    }
    
    /**
     * Returns the condition expression.
     * 
     * @return the condition
     */
    public Expression getCondition() {
        return condition;
    }

    /**
     * Returns the then expressions.
     * 
     * @return the then expressions
     */
    public List<Expression> getThenExpressions() {
        return thenEx;
    }
    
    /**
     * Returns the else expressions.
     * 
     * @return the else expressions, may be <b>null</b>
     */
    public List<Expression> getElseExpressions() {
        return elseEx;
    }

    @Override
    protected void advanceState() {
        this.elseEx = new ArrayList<Expression>();
        this.curEx = elseEx;
        // ignore further state changes
    }

    @Override
    protected void append(Expression ex) {
        this.curEx.add(ex);
    }

    @Override
    protected Expression close(IStringResolverFactory<I> factory) throws VilException {
        return factory.createIfExpression(this);
    }

    @Override
    protected void append(List<Expression> exprs) {
        exprs.addAll(thenEx);
        if (null != elseEx) {
            exprs.addAll(elseEx);
        }
    }

    @Override
    protected void replace(InPlaceCommand<I> cmd, Expression expr) {
        if(!replace(thenEx, cmd, expr) && null != elseEx) {
            replace(elseEx, cmd, expr);
        }
    }

}
