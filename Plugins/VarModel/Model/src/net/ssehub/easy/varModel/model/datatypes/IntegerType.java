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
 * Creates the BasisDatatype Integer.
 * 
 * @author Tebbje
 * @author Holger Eichelberger
 */
public class IntegerType extends BasisDatatype {
    // DO NOT RENAME THIS CLASS - REFERENCED AS TEXT FROM RealType

    public static final IDatatype TYPE = RealType.INTEGER_TYPE;
   
    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    
    // we assume normalized operations to OCL -> simplifies reasoner translation
    public static final Operation EQUALS_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation EQUALS_INTEGER_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, RealType.TYPE);
    public static final Operation ASSIGNMENT_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();
    public static final Operation FORCE_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.FORCE_DEFINED, TYPE)
        .markAsAcceptsNull();
    public static final Operation COPY = new Operation(TYPE, OclKeyWords.COPY, TYPE, AnyType.STRING_TYPE);
    
    public static final Operation NOTEQUALS_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation NOTEQUALS_INTEGER_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, RealType.TYPE);
    public static final Operation NOTEQUALS_INTEGER_INTEGER_ALIAS = Operation.createInfixOperator(
            BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);
    public static final Operation NOTEQUALS_INTEGER_REAL_ALIAS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, RealType.TYPE);
    
    public static final Operation PLUS_INTEGER_INTEGER = Operation.createInfixOperator(
        TYPE, OclKeyWords.PLUS, TYPE, TYPE);
    public static final Operation PLUS_INTEGER_REAL = Operation.createInfixOperator(
        RealType.TYPE, OclKeyWords.PLUS, TYPE, RealType.TYPE);
    
    public static final Operation MINUS_INTEGER_INTEGER = Operation.createInfixOperator(
        TYPE, OclKeyWords.MINUS, TYPE, TYPE);
    public static final Operation MINUS_INTEGER_REAL = Operation.createInfixOperator(
        RealType.TYPE, OclKeyWords.MINUS, TYPE, RealType.TYPE);
    
    public static final Operation MULT_INTEGER_INTEGER = Operation.createInfixOperator(
        TYPE, OclKeyWords.MULT, TYPE, TYPE);
    public static final Operation MULT_INTEGER_REAL = Operation.createInfixOperator(
        RealType.TYPE, OclKeyWords.MULT, TYPE, RealType.TYPE);    
    
    public static final Operation DIV_INTEGER_REAL = Operation.createInfixOperator(RealType.TYPE, 
        OclKeyWords.DIV, TYPE, RealType.TYPE);
    public static final Operation DIVREAL_INTEGER_INTEGER = Operation.createInfixOperator(RealType.TYPE, 
        OclKeyWords.DIV, TYPE, TYPE);
    
    public static final Operation GREATER_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER, TYPE, TYPE);
    public static final Operation GREATER_INTEGER_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER, TYPE, RealType.TYPE);  
    
    public static final Operation LESS_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS, TYPE, TYPE);
    public static final Operation LESS_INTEGER_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS, TYPE, RealType.TYPE);
    
    public static final Operation GREATER_EQUALS_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER_EQUALS, TYPE, TYPE);
    public static final Operation GREATER_EQUALS_INTEGER_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER_EQUALS, TYPE, RealType.TYPE);  
    
    public static final Operation LESS_EQUALS_INTEGER_INTEGER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS_EQUALS, TYPE, TYPE);
    public static final Operation LESS_EQUALS_INTEGER_REAL = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS_EQUALS, TYPE, RealType.TYPE);  
    
    public static final Operation MIN_INTEGER_INTEGER = new Operation(
        TYPE, OclKeyWords.MIN, TYPE, TYPE);    
    public static final Operation MIN_INTEGER_REAL = new Operation(
        RealType.TYPE, OclKeyWords.MIN, TYPE, RealType.TYPE);
    
    public static final Operation MAX_INTEGER_INTEGER = new Operation(
        TYPE, OclKeyWords.MAX, TYPE, TYPE);    
    public static final Operation MAX_INTEGER_REAL = new Operation(
        RealType.TYPE, OclKeyWords.MAX, TYPE, RealType.TYPE);
    
    public static final Operation ABS_INTEGER_INTEGER = new Operation(
        TYPE, OclKeyWords.ABS, TYPE);
    
    public static final Operation INVERSE_INTEGER = Operation.createPrefixOperator(
        TYPE, OclKeyWords.INVERSE, TYPE);
        
    public static final Operation MOD_INTEGER_INTEGER = new Operation(
        TYPE, OclKeyWords.MOD, TYPE, TYPE);
    public static final Operation MOD_INTEGER_REAL = new Operation(
        RealType.TYPE, OclKeyWords.MOD, TYPE, RealType.TYPE);
    
    public static final Operation DIV_INTEGER_INTEGER = new Operation(TYPE, 
        OclKeyWords.DIV_INT, TYPE, TYPE);
    
    public static final Operation TO_STRING = new Operation(
        AnyType.STRING_TYPE, OclKeyWords.TO_STRING, TYPE);
    
    static {
        RealType.INTEGER_TYPE.setDelegate(new IntegerType());
        RealType.INTEGER_TYPE.addOperation(TYPE_OF);
        RealType.INTEGER_TYPE.addOperation(PLUS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(PLUS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(MINUS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(MINUS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(MULT_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(MULT_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(DIV_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(DIV_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(DIVREAL_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(EQUALS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(EQUALS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(NOTEQUALS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(NOTEQUALS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(NOTEQUALS_INTEGER_INTEGER_ALIAS);
        RealType.INTEGER_TYPE.addOperation(NOTEQUALS_INTEGER_REAL_ALIAS);
        RealType.INTEGER_TYPE.addOperation(ASSIGNMENT_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(IS_DEFINED);
        RealType.INTEGER_TYPE.addOperation(FORCE_DEFINED);
        RealType.INTEGER_TYPE.addOperation(COPY);
        RealType.INTEGER_TYPE.addOperation(GREATER_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(GREATER_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(LESS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(LESS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(GREATER_EQUALS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(GREATER_EQUALS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(LESS_EQUALS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(LESS_EQUALS_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(MIN_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(MIN_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(MAX_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(MAX_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(ABS_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(INVERSE_INTEGER);
        RealType.INTEGER_TYPE.addOperation(MOD_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(MOD_INTEGER_REAL);
        RealType.INTEGER_TYPE.addOperation(DIV_INTEGER_INTEGER);
        RealType.INTEGER_TYPE.addOperation(TO_STRING);
    }
    
    /**
     * Constructor for a new IntgerType.
     */
    private IntegerType() {
        super("Integer", RealType.INTEGER_TYPE);
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitIntegerType(this);
    }

}
