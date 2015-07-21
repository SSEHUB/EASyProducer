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
package de.uni_hildesheim.sse.vil.rt.ui.embed;

import java.io.StringWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVilWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents an (open, to be defined) script argument.
 * 
 * @author Holger Eichelberger
 */
public class Argument {
    
    private String name;
    private TypeDescriptor<?> type;
    private Expression valueExpression;
    private Object value;

    /**
     * Creates a script call argument.
     * 
     * @param name the name of the argument
     * @param type the type of the argument
     */
    public Argument(String name, TypeDescriptor<?> type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the name of the argument.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the type of the argument.
     * 
     * @return the type of the argument
     */
    public TypeDescriptor<?> getType() {
        return type;
    }
    
    /**
     * Returns the name of the argument type as text.
     * 
     * @return the type name
     */
    public String getTypeName() {
        return type.getVilName();
    }
    
    /**
     * Returns the value expression.
     * 
     * @return the value expression (may be <b>null</b> if undefined)
     */
    public Expression getValueExpression() {
        return valueExpression;
    }
    
    /**
     * Defines the value expression and the value of the argument.
     * 
     * @param valueExpression the value expression (may be <b>null</b> if undefined)
     * @param value the value obtained by evaluating the expression (may be <b>null</b> if undefined)
     */
    public void setValue(Expression valueExpression, Object value) {
        this.valueExpression = valueExpression;
        this.value = value;
    }
    
    /**
     * Returns the value of the argument.
     * 
     * @return the value (may be <b>null</b> if undefined)
     */
    public Object getValue() {
        return value;
    }
    
    /**
     * Returns whether the argument is valid.
     * 
     * @return <code>true</code> if the argument is valid, <code>false</code> else
     */
    public boolean isValid() {
        return null != value && null != valueExpression;
    }
    
    /**
     * Turns the value expression into VIL text representation.
     * 
     * @return the text representation (may be <b>empty</b>)
     */
    public String getValueExpressionText() {
        String result = "";
        if (null != valueExpression) {
            StringWriter writer = new StringWriter();
            RtVilWriter wr = new RtVilWriter(writer);
            try {
                valueExpression.accept(wr);
                result = writer.toString();
            } catch (VilException e) {
                // result -> ""
            }
        }
        return result;
    }
    
}
