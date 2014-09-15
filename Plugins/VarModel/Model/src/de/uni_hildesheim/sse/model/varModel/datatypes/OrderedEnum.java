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
package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;

/** 
 * Enumerations allow the definition of sets of named values.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/

public class OrderedEnum extends Enum {

    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(Enum.DTYPE);
    
    /**
     * This constant represents the common type of all enums. Each specific enum type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    public static final Operation GREATER = new Operation(BooleanType.TYPE, OclKeyWords.GREATER, TYPE, TYPE);
    public static final Operation LESS = new Operation(BooleanType.TYPE, OclKeyWords.LESS, TYPE, TYPE);
    public static final Operation GREATER_EQUALS = new Operation(BooleanType.TYPE,
            OclKeyWords.GREATER_EQUALS, TYPE, TYPE);
    public static final Operation LESS_EQUALS = new Operation(BooleanType.TYPE,
            OclKeyWords.LESS_EQUALS, TYPE, TYPE);
    
    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new OrderedEnum());
        DTYPE.addOperation(GREATER);
        DTYPE.addOperation(GREATER_EQUALS);
        DTYPE.addOperation(LESS);        
        DTYPE.addOperation(LESS_EQUALS);
    }
    
    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private OrderedEnum() {
        this("<OrderedEnum>", null);
    }
    
    /**
     * Constructor for an empty enum.
     * @param name Name of the enum
     * @param parent the object, in which this specific one is embedded
     */
    public OrderedEnum(String name, ModelElement parent) {
        super(name, DTYPE, parent);
    }
    
    /**
     * Returns whether this enum is ordered.
     * 
     * @return <code>true</code> if it is ordered, <code>false</code> else (default <code>true</code>)
     */
    @Override
    public boolean isOrdered() {
        return true;
    }

    /** 
     * Accept method for the visitor. <br/>
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitOrderedEnum(this);
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitOrderedEnumType(this);
    }
    
}
