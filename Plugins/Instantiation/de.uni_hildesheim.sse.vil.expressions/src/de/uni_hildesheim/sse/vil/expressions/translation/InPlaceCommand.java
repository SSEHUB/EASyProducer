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

import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Replaces an in-place command/expression within a string/content expression.
 * Implementing classes are intended to incrementally build up an expression or to return all collected sub-expressions
 * in case that the specification in the string/content expression was incomplete. An in-place command is a (temporary)
 * expression so that it can be later replaced in the parent in-place command when the real expression was created
 * through the {@link IStringResolverFactory}.
 * 
 * @param <I> the variable declaration type
 * @author Holger Eichelberger
 */
public abstract class InPlaceCommand <I extends VariableDeclaration> extends Expression {

    /**
     * Appends a sub-expression. An in-place command can have multiple sub-structures, that are sequentially switched
     * to active via {@link #advanceState()}.
     * 
     * @param ex the expression to append
     */
    protected abstract void append(Expression ex);

    /**
     * Changes among different states of sub-structures, e.g., then-part and else-part. Override if needed, else
     * the respective call is just ignored.
     */
    protected void advanceState() {
        // ignore, just always add to the active structure
    }
    
    /**
     * Closes this in-place command by creating the real expression.
     * 
     * @param factory the factory used to create the real expression
     * @return the real expression, may be <b>null</b> if optional / none shall be created
     * @throws VilException if the provided information is not sufficient for creating an expression
     */
    protected abstract Expression close(IStringResolverFactory<I> factory) throws VilException;
    
    /**
     * Appends the sub-expressions in parse sequence to <code>exprs</code> leaving out this command as fallback.
     * 
     * @param exprs the expressions to add the sub-expressions to
     */
    protected abstract void append(List<Expression> exprs);
    
    /**
     * Replaces <code>cmd</code> by <code>expr</code>.
     * 
     * @param cmd the command to be replaced
     * @param expr the replacing expression
     */
    protected abstract void replace(InPlaceCommand<I> cmd, Expression expr);
    
    /**
     * Replaces <code>cmd</code> by <code>expr</code> in <code>exprs</code>.
     * 
     * @param exprs the expressions list to be searched / modified
     * @param cmd the command to be replaced
     * @param expr the expression to replace <code>cmd</code>
     * @return <code>true</code> if replacement was done, <code>false</code> else
     */
    protected boolean replace(List<Expression> exprs, InPlaceCommand<I> cmd, Expression expr) {
        boolean done;
        int pos = exprs.indexOf(cmd);
        if (pos >= 0) {
            exprs.set(pos, expr);
            done = true;
        } else {
            done = false;
        }
        return done;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.voidType(); // just dummy
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return null; // just dummy
    }
    
    /**
     * Whether a cleanup of an erroneous parse stack requires cleaning up a resolver level.
     * 
     * @return <code>true</code> for cleanup, <code>false</code> else
     */
    protected boolean holdsResolverLevel() {
        return false;
    }

}
