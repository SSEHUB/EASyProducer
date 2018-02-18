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
package net.ssehub.easy.varModel.model.datatypes;

/**
 * Defines the basis (internal) datatype "Version".
 * 
 * @author Holger Eichelberger
 */
public class VersionType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);
    
    public static final IDatatype TYPE = DTYPE;
    
    // basic from any
    // no typeof so far
    public static final Operation EQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation UNEQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation UNEQUALS_ALIAS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);

    // comparisons
    public static final Operation GREATER = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER, TYPE, TYPE);
    public static final Operation LESS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS, TYPE, TYPE);
    public static final Operation GREATER_EQUALS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.GREATER_EQUALS, TYPE, TYPE);
    public static final Operation LESS_EQUALS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.LESS_EQUALS, TYPE, TYPE);

    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new VersionType());
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(UNEQUALS);
        DTYPE.addOperation(UNEQUALS_ALIAS);
        DTYPE.addOperation(GREATER);
        DTYPE.addOperation(LESS);
        DTYPE.addOperation(GREATER_EQUALS);
        DTYPE.addOperation(LESS_EQUALS);
    }
    
    /**
     * Constructor for a new type instance.
     */
    private VersionType() {
        super("Version", DTYPE);
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitVersionType(this);
    }
}
