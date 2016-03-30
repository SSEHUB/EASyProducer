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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleCallExpression;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * Represents a model call as part of a strategy breakdown.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractBreakdownCall extends RuleCallExpression implements IRuleElement {

    private Expression guard;
    private Expression timeout;
    private List<TupleField> tuples = null; // we store them as a list in order to reconstruct the original sequence
     
    /**
     * Represents a tuple filed of name and associated value expression.
     * 
     * @author Holger Eichelberger
     */
    public static class TupleField {
        
        private String name;
        private Expression valueEx;
        
        /**
         * Creates a tuple field.
         * 
         * @param name the name of the tuple field
         * @param valueEx the value expression
         */
        protected TupleField(String name, Expression valueEx) {
            this.name = name;
            this.valueEx = valueEx;
        }
        
        /**
         * Returns the name of the field.
         * 
         * @return the name of the field
         */
        public String getName() {
            return name;
        }
        
        /**
         * Returns the value expression.
         * 
         * @return the value expression
         */
        public Expression getValueExpression() {
            return valueEx;
        }
        
    }
    
    /**
     * Creates a breakdown call.
     * 
     * @param script the actual script to resolve the rule on
     * @param name the name of the called element
     * @param arguments the actual arguments
     * @throws VilException in case of an erroneously qualified name
     */
    protected AbstractBreakdownCall(Script script, String name, CallArgument... arguments) throws VilException {
        super(script, false, name, arguments);
    }
    
    /**
     * Returns the guard for this call.
     * 
     * @return the guard expression (may be <b>null</b>)
     */
    public Expression getGuardExpression() {
        return guard;
    }

    /**
     * Defines the guard for this call.
     * 
     * @param guard the guard expression (may be <b>null</b>)
     */
    public void setGuardExpression(Expression guard) {
        this.guard = guard;
    }

    /**
     * Returns the timeout expression for this call.
     * 
     * @return the timeout expression expression (may be <b>null</b>)
     */
    public Expression getTimeoutExpression() {
        return timeout;
    }

    /**
     * Defines the timeout expression for this call.
     * 
     * @param timeout expression the timeout expression (may be <b>null</b>)
     */
    public void setTimeoutExpression(Expression timeout) {
        this.timeout = timeout;
    }
    
    /**
     * Adds a distinct tuple field of named expressions to be considered / evaluated in the context of the evaluation of
     * the weighting function. Please note that no consistency check happens here, i.e., tuple fileds must be consistent
     * in type for evaluation with the actual weighting function.
     * 
     * @param name the name of the tuple filed
     * @param valueEx the value expression
     */
    public void addTupleField(String name, Expression valueEx) {
        if (null == tuples) {
            tuples = new ArrayList<TupleField>();
        }
        tuples.add(new TupleField(name, valueEx));
    }
    
    /**
     * Returns the tuple field at the specified <code>index</code>.
     * 
     * @param index the 0-based index of the tuple to return
     * @return the specified tuple field
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getTupleFieldCount()}</code>
     */
    public TupleField getTupleField(int index) {
        if (null == tuples) {
            throw new IndexOutOfBoundsException();
        }
        return tuples.get(index);
    }
    
    /**
     * Returns the (first) tuple field with given <code>name</code>.
     * 
     * @param name the name to search for
     * @return the tuple field with given <code>name</code>, <b>null</b> if not found
     */
    public TupleField getTupleField(String name) {
        TupleField result = null;
        if (null != tuples) {
            for (int t = 0; null == result && t < tuples.size(); t++) {
                TupleField field = tuples.get(t);
                if (field.getName().equals(name)) {
                    result = field;
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the number of tuple fields.
     * 
     * @return the number of tuple fields
     */
    public int getTupleFieldCount() {
        return null == tuples ? 0 : tuples.size();
    }

}
