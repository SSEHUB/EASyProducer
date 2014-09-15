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


/**
 * Creates the BasisDatatype String.
 * 
 * @author beck
 *
 */
public class StringType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);
    
    public static final IDatatype TYPE = DTYPE;
    
    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);

    public static final Operation EQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation UNEQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation ASSIGNMENT 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();    
    
    // specific operations
    public static final Operation SIZE = new Operation(IntegerType.TYPE, OclKeyWords.SIZE, TYPE);
    public static final Operation TO_INTEGER = new Operation(IntegerType.TYPE, OclKeyWords.TO_INTEGER, TYPE);
    public static final Operation TO_REAL = new Operation(RealType.TYPE, OclKeyWords.TO_REAL, TYPE);
    public static final Operation CONCAT = new Operation(TYPE, OclKeyWords.CONCAT, TYPE, TYPE);
    public static final Operation SUBSTRING = new Operation(TYPE, OclKeyWords.SUBSTRING, TYPE, 
        IntegerType.TYPE, IntegerType.TYPE);

    public static final Operation MATCHES = new Operation(BooleanType.TYPE, OclKeyWords.MATCHES, TYPE, TYPE);
    public static final Operation SUBSTITUTES = new Operation(TYPE, OclKeyWords.SUBSTITUTES, TYPE, TYPE, TYPE);

    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new StringType());
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(UNEQUALS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(IS_DEFINED);
        DTYPE.addOperation(SIZE);
        DTYPE.addOperation(TO_INTEGER);
        DTYPE.addOperation(TO_REAL);
        DTYPE.addOperation(CONCAT);
        DTYPE.addOperation(SUBSTRING);
        DTYPE.addOperation(MATCHES);
        DTYPE.addOperation(SUBSTITUTES);
    }
    
    /**
     * Constructor for a new BasisDatatype String.
     */
    private StringType() {
        super("String", DTYPE);
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitStringType(this);
    }
}
