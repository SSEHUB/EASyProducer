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
package net.ssehub.easy.varModel.model.datatypes;

/**
 * Creates the BasisDatatype Real.
 * 
 * @author beck
 * @author Holger Eichelberger
 */
public class RealType extends BasisDatatype {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);
    public static final IDatatype TYPE = DTYPE;

    static final DelegatingType INTEGER_TYPE = new DelegatingType(AnyType.DTYPE);

    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    
    // we assume normalized operations to OCL -> simplifies reasoner translation
    public static final Operation EQUALS_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation EQUALS_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, INTEGER_TYPE);
    public static final Operation ASSIGNMENT_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    public static final Operation ASSIGNMENT_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, INTEGER_TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();    
    public static final Operation FORCE_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.FORCE_DEFINED, TYPE)
        .markAsAcceptsNull();    
    public static final Operation COPY = new Operation(TYPE, OclKeyWords.COPY, TYPE, AnyType.STRING_TYPE);

    public static final Operation NOTEQUALS_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation NOTEQUALS_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, INTEGER_TYPE);
    public static final Operation NOTEQUALS_REAL_REAL_ALIAS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);
    public static final Operation NOTEQUALS_REAL_INTEGER_ALIAS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, INTEGER_TYPE);
    
    public static final Operation PLUS_REAL_REAL = Operation.createInfixOperator(
        TYPE, OclKeyWords.PLUS, TYPE, TYPE);
    public static final Operation PLUS_REAL_INTEGER = Operation.createInfixOperator(
        TYPE, OclKeyWords.PLUS, TYPE, INTEGER_TYPE);
    
    public static final Operation MINUS_REAL_REAL = Operation.createInfixOperator(
        TYPE, OclKeyWords.MINUS, TYPE, TYPE);
    public static final Operation MINUS_REAL_INTEGER = Operation.createInfixOperator(
        TYPE, OclKeyWords.MINUS, TYPE, INTEGER_TYPE);
    
    public static final Operation MULT_REAL_REAL = Operation.createInfixOperator(
        TYPE, OclKeyWords.MULT, TYPE, TYPE);
    public static final Operation MULT_REAL_INTEGER = Operation.createInfixOperator(
        TYPE, OclKeyWords.MULT, TYPE, INTEGER_TYPE);
    
    public static final Operation DIV_REAL_REAL = Operation.createInfixOperator(
            TYPE, OclKeyWords.DIV, TYPE, TYPE);
    public static final Operation DIV_REAL_INTEGER = Operation.createInfixOperator(
            TYPE, OclKeyWords.DIV, TYPE, INTEGER_TYPE);
    
    public static final Operation GREATER_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER, TYPE, TYPE);
    public static final Operation GREATER_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER, TYPE, INTEGER_TYPE);    
    
    public static final Operation LESS_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS, TYPE, TYPE);
    public static final Operation LESS_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER, TYPE, INTEGER_TYPE);    

    public static final Operation GREATER_EQUALS_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER_EQUALS, TYPE, TYPE);
    public static final Operation GREATER_EQUALS_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER_EQUALS, TYPE, INTEGER_TYPE);    
        
    public static final Operation LESS_EQUALS_REAL_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS_EQUALS, TYPE, TYPE);
    public static final Operation LESS_EQUALS_REAL_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER_EQUALS, TYPE, INTEGER_TYPE);

    public static final Operation MIN_REAL_REAL = new Operation(
        TYPE, OclKeyWords.MIN, TYPE, TYPE);
    public static final Operation MAX_REAL_REAL = new Operation(
        TYPE, OclKeyWords.MAX, TYPE, TYPE);
    public static final Operation MIN_REAL_INTEGER = new Operation(
        TYPE, OclKeyWords.MIN, TYPE, INTEGER_TYPE);
        
    public static final Operation MAX_REAL_INTEGER = new Operation(
        TYPE, OclKeyWords.MAX, TYPE, INTEGER_TYPE);
    
    public static final Operation MOD_REAL_REAL = Operation.createInfixOperator(
            TYPE, OclKeyWords.MOD, TYPE, TYPE);
    public static final Operation MOD_REAL_INTEGER = Operation.createInfixOperator(
            TYPE, OclKeyWords.MOD, TYPE, INTEGER_TYPE);

    public static final Operation ABS_REAL_REAL = new Operation(
        TYPE, OclKeyWords.ABS, TYPE);
    
    public static final Operation INVERSE_REAL = Operation.createPrefixOperator(
        TYPE, OclKeyWords.INVERSE, TYPE);
    
    public static final Operation FLOOR = new Operation(
        INTEGER_TYPE, OclKeyWords.FLOOR, TYPE);
    public static final Operation ROUND = new Operation(
        INTEGER_TYPE, OclKeyWords.ROUND, TYPE);

    public static final Operation TO_STRING = new Operation(
        AnyType.STRING_TYPE, OclKeyWords.TO_STRING, TYPE);

    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new RealType());

        // not nice
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(PLUS_REAL_REAL);
        DTYPE.addOperation(PLUS_REAL_INTEGER);
        DTYPE.addOperation(MINUS_REAL_REAL);
        DTYPE.addOperation(MINUS_REAL_INTEGER);
        DTYPE.addOperation(MULT_REAL_REAL);
        DTYPE.addOperation(MULT_REAL_INTEGER);
        DTYPE.addOperation(DIV_REAL_REAL);
        DTYPE.addOperation(DIV_REAL_INTEGER);
        DTYPE.addOperation(EQUALS_REAL_REAL);
        DTYPE.addOperation(EQUALS_REAL_INTEGER);
        DTYPE.addOperation(NOTEQUALS_REAL_REAL);
        DTYPE.addOperation(NOTEQUALS_REAL_INTEGER);
        DTYPE.addOperation(NOTEQUALS_REAL_REAL_ALIAS);
        DTYPE.addOperation(NOTEQUALS_REAL_INTEGER_ALIAS);
        DTYPE.addOperation(ASSIGNMENT_REAL_REAL);
        DTYPE.addOperation(ASSIGNMENT_REAL_INTEGER);
        DTYPE.addOperation(IS_DEFINED);
        DTYPE.addOperation(FORCE_DEFINED);
        DTYPE.addOperation(COPY);
        DTYPE.addOperation(GREATER_REAL_REAL);
        DTYPE.addOperation(GREATER_REAL_INTEGER);
        DTYPE.addOperation(LESS_REAL_REAL);
        DTYPE.addOperation(LESS_REAL_INTEGER);
        DTYPE.addOperation(GREATER_EQUALS_REAL_REAL);
        DTYPE.addOperation(GREATER_EQUALS_REAL_INTEGER);
        DTYPE.addOperation(LESS_EQUALS_REAL_REAL);
        DTYPE.addOperation(LESS_EQUALS_REAL_INTEGER);
        DTYPE.addOperation(MIN_REAL_REAL);
        DTYPE.addOperation(MAX_REAL_REAL);
        DTYPE.addOperation(MIN_REAL_INTEGER);
        DTYPE.addOperation(MAX_REAL_INTEGER);
        DTYPE.addOperation(ABS_REAL_REAL);
        DTYPE.addOperation(MOD_REAL_REAL);
        DTYPE.addOperation(MOD_REAL_INTEGER);
        DTYPE.addOperation(INVERSE_REAL);
        DTYPE.addOperation(FLOOR);
        DTYPE.addOperation(ROUND);
        DTYPE.addOperation(TO_STRING);
        // ensure initialization, avoid cyclic class dependency
        // otherwise IntegerType is not properly initialized when
        // RealType is used without using IntegerType before
        try {
            Class.forName("de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType");
        } catch (ClassNotFoundException e) {
        }
    }
    
    /**
     * Constructor for a new RealType.
     */
    private RealType() {
        super("Real", DTYPE);
    } 
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitRealType(this);
    }
    
    /**
    * Determines if the data type represented by this
    * object is either the same as, or is a supertype of 
    * <code>type</code>.
    * 
    * @param type the type being checked
    * @return <code>true</code> if this type is either the same or a 
    *   supertype of <code>type</code>, <code>true</code> else
    */
    public boolean isAssignableFrom(IDatatype type) {
        // basically the same due to singletons
        return super.isAssignableFrom(type) || INTEGER_TYPE.equals(type) || INTEGER_TYPE.getType().equals(type);
    }
}
