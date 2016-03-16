/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Implements a VIL for statement.
 * 
 * @author Holger Eichelberger
 */
public class ForStatement extends RuleBlock implements IRuleElement, IEnumeratingLoop  {

    private VariableDeclaration[] variables;
    private Expression expr;
    private TypeDescriptor<?>[] givenTypes;
    private boolean colon;
    
    /**
     * Creates a for statement.
     * 
     * @param variables the variables to iterate over
     * @param expr the expression denoting on what to iterate
     * @param body the body of the for statement
     * @param givenTypes the given types in addition to the inferred types
     *   of the <code>variable</code> (may be <b>null</b>; if given must have
     *   same length as <code>variables</code>, may contain <b>null</b> if no type
     *   is given, types must at least be supertypes of those in <code>variables</code>)
     * @param colon <code>true</code> it it was a colon, <code>else</code> if it was an equals character
     * @throws VilException in case of initialization problems
     */
    public ForStatement(VariableDeclaration[] variables, Expression expr, IRuleElement[] body, 
        TypeDescriptor<?>[] givenTypes, boolean colon) throws VilException {
        super("", body);
        if (null == variables || variables.length < 1) {
            throw new VilException("no iterator variables given", VilException.ID_SEMANTIC);
        }
        if (null != givenTypes && variables.length != givenTypes.length) {
            throw new VilException("given types length does not match to variables length", 
                VilException.ID_SEMANTIC);
        }
        this.givenTypes = givenTypes;
        this.variables = variables;
        this.expr = expr;
        if (null == expr) {
            throw new VilException("no expression given", VilException.ID_SEMANTIC);
        }
    }

    @Override
    public int getVariablesCount() {
        return variables.length;
    }

    @Override
    public VariableDeclaration getVariable(int index) {
        return variables[index];
    }

    @Override
    public TypeDescriptor<?> getGivenType(int index) {
        return null == givenTypes ? null : givenTypes[index]; 
    }
    
    @Override
    public Expression getExpression() {
        return expr;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result = null;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitForStatement(this);
        }
        return result;
    }

    /**
     * Returns whether the given separator was a colon.
     * 
     * @return <code>true</code> it it was a colon, <code>else</code> if it was an equals character
     */
    public boolean isColonSeparator() {
        return colon;
    }

    @Override
    public boolean isVirtual() {
        return false;
    }

    @Override
    public IRuleElement determinesResult() {
        return Utils.findLastExpressionStatement(this);
    }

    @Override
    public String getElementName() {
        return "for";
    }

}
