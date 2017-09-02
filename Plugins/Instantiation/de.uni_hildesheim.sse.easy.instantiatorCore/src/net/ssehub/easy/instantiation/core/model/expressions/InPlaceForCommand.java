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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Replaces an in-place for-command/expression within a string/content expression.
 * 
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public class InPlaceForCommand<I extends VariableDeclaration> extends InPlaceCommand<I> {

    private I iterator;
    private Expression init;
    private Expression separator;
    private Expression endSeparator;
    private List<Expression> body;
    
    /**
     * Creates an in-place loop command.
     * 
     * @param iterator the iterator variable
     * @param init the initialization expression (collection over iterator)
     * @param separator the optional element separator
     * @param endSeparator the optional end separator
     */
    public InPlaceForCommand(I iterator, Expression init, Expression separator, Expression endSeparator) {
        this.iterator = iterator;
        this.init = init;
        this.separator = separator;
        this.endSeparator = endSeparator;
        body = new ArrayList<Expression>();
    }
    
    /**
     * Returns the iterator variable.
     * 
     * @return the iterator variable
     */
    public I getIterator() {
        return iterator;
    }
    
    /**
     * Returns the initialization expression.
     * 
     * @return the initialization expression
     */
    public Expression getInit() {
        return init;
    }
    
    /**
     * Returns the element separator.
     * 
     * @return the element separator
     */
    public Expression getSeparator() {
        return separator;
    }
    
    /**
     * Returns the optional end separator.
     * 
     * @return the end separator expression (may be <b>null</b>)
     */
    public Expression getEndSeparator() {
        return endSeparator;
    }
    
    /**
     * Returns the body expressions.
     * 
     * @return the body expressions
     */
    public List<Expression> getBody() {
        return body;
    }
    
    @Override
    protected void append(Expression ex) {
        body.add(ex);
    }

    @Override
    protected Expression close(IStringParserFactory<I> factory) throws VilException {
        return factory.createForExpression(this);
    }

    @Override
    protected void append(List<Expression> exprs) {
        //exprs.addAll(body); // may contain iterator vars, cannot be evaluated without for
    }

    @Override
    protected void replace(InPlaceCommand<I> cmd, Expression expr) {
        replace(body, cmd, expr); 
    }
    
    @Override
    protected boolean holdsResolverLevel() {
        return true;
    }

}
