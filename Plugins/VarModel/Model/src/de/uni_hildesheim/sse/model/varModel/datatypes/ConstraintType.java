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
 * Defines the basis datatype for holding constraints. This datatype
 * allows to define varying constraints (required by HIS).
 * 
 * @author Holger Eichelberger
 */
public class ConstraintType extends BasisDatatype {

    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    public static final IDatatype TYPE = AnyType.CONSTRAINT_TYPE;

    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    
    // constraints appear to be booleans
    public static final Operation EQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, BooleanType.TYPE);
    public static final Operation UNEQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, BooleanType.TYPE);
    public static final Operation ASSIGNMENT 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, BooleanType.TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();

    // checkstyle: resume declaration order check

    static {
        AnyType.CONSTRAINT_TYPE.setDelegate(new ConstraintType());
        AnyType.CONSTRAINT_TYPE.addOperation(EQUALS);
        AnyType.CONSTRAINT_TYPE.addOperation(UNEQUALS);
        AnyType.CONSTRAINT_TYPE.addOperation(ASSIGNMENT);
        AnyType.CONSTRAINT_TYPE.addOperation(IS_DEFINED);
    }
    
    /**
     * Constructor for a new ConstraintType.
     */
    private ConstraintType() {
        super("Constraint", AnyType.CONSTRAINT_TYPE);
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitConstraintType(this); 
    }
    
    /**
    * {@inheritDoc}
    */
    public boolean isAssignableFrom(IDatatype type) {
        // enable boolean assignments as constraints are handled as Boolean expressions
        return super.isAssignableFrom(type) || BooleanType.TYPE.equals(type);
    }
    
}
