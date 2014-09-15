/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Basis value class.
 * @author Marcel Lueder
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public abstract class Value {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(Value.class, Bundle.ID);
    
    private IDatatype origin;
    
    /**
     * Constructor. 
     * @param origin the origin datatype.
     */
    protected Value(IDatatype origin) {
        this.origin = origin;
    }

    /**
     * Abstract getValue method. The result of this method <b>must</b> comply to 
     * the input conventions of {@link ValueFactory} and the constructor
     * of the respective implementing class.
     * 
     * @return the Value of the Datatype
     */
    public abstract Object getValue();
    
    /**
     * Abstract accept method.
     * @param visitor The visitor
     */
    public abstract void accept(IValueVisitor visitor);
    
    /**
     * Abstract setValue-method.
     * @param value the value to set.
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public abstract void setValue(Object value) throws ValueDoesNotMatchTypeException;
    
    /**
     * Returns the Datatype of this Value. The datatype should match to the type of this value.
     * @return Related datatype of this value.
     */
    public IDatatype getType() {
        return origin;        
    }
    
    /**
     * Abstract Method to check whether a value is configured.
     * @return true = it is configured / false = it is not
     */
    public abstract boolean isConfigured();

    /**
     * Converts a object value to a string. 
     * @param object the object to convert
     * @return the converted object
     */
    protected String stringValueOf(Object object) {
        return object == null ? null : object.toString();
    }
    
    /**
     * Clones the this value.
     * 
     * @return the clone of the value
     */
    public Value clone() {
        Value clone = null;
        try {
            clone = (Value) super.clone();
        } catch (CloneNotSupportedException e) {
            // Should not be possible to reach this point here
            LOGGER.exception(e);
        }
        return clone;            
    }
    
    
    /**
     * Returns the data type explicitly contained in this value. This is 
     * typically a meta value, i.e. a type expression.
     * 
     * @return the contained type or <b>null</b> if there is none
     */
    public IDatatype getContainedType() {
        return null;
    }

    @Override
    public String toString() {
        return getValue() + " : " + getType().toString();
    }

    // TODO check and remove!!!
    
    @Override
    public int hashCode() {
        return getValue().hashCode();
    }
    
    @Override 
    public boolean equals(Object other) {
        boolean equal = false;
        if (getClass().isInstance(other)) { // implicitly instanceof Value due to inheritance
            equal = getValue().equals(((Value) other).getValue());
        }
        return equal;
    }
    
}