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

import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Operation.ReturnTypeMode;

/**
 * Realizes a set container.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Set extends Container {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(Container.DTYPE);
    // actually we can define operations once and reuse them but I'm not sure whether this makes
    // sense with respect to the reasoner -> define in "supertype" and link to respective DTYPE
    
    /**
     * This constant represents the common type of all sets. Each specific set type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    public static final Operation AS_SET = new Operation(Set.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.AS_SET, TYPE);
    public static final Operation AS_SEQUENCE = new Operation(Sequence.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.AS_SEQUENCE, TYPE);
    public static final Operation UNION = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.UNION, TYPE, TYPE);
    public static final Operation INTERSECTION = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.INTERSECTION, TYPE, TYPE);
    public static final Operation EXCLUDING = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.EXCLUDING, TYPE, AnyType.TYPE);
    public static final Operation INCLUDING = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.INCLUDING, TYPE, AnyType.TYPE);
    public static final Operation ADD = new Operation(AnyType.TYPE, ReturnTypeMode.GENERIC_PARAM_1, 
        OclKeyWords.ADD, TYPE, AnyType.TYPE);
    
    // type specific 
    public static final Operation EQUALS = Operation.createInfixOperator(BooleanType.TYPE, 
        OclKeyWords.EQUALS, TYPE, TYPE).markAsAssignableParameterOperation();
    public static final Operation ASSIGNMENT = Operation.createInfixOperator(BooleanType.TYPE, 
         OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    
    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new Set());
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(AS_SET);
        DTYPE.addOperation(AS_SEQUENCE);
        DTYPE.addOperation(UNION);
        DTYPE.addOperation(INTERSECTION);
        DTYPE.addOperation(EXCLUDING);
        DTYPE.addOperation(INCLUDING);
        DTYPE.addOperation(ADD);
    }
    
    /**
     * Creates the singleton instance.
     */
    private Set() {
        this("<Set>", null, null);
    }
    
    /**
     * Constructor for the container.
     * @param name Name of the container
     * @param type data type of the container elements
     * @param parent the object, in which this specific one is embedded
     */
    public Set(String name, IDatatype type, IModelElement parent) {
        super(name, DTYPE, type, parent);
    }
    
//    /**
//     * Method to add an object to the elements list of the container.
//     * @param elem element to add to the list
//     */
//    @Override
//    public void add(DecisionVariableDeclaration elem) {
//        boolean add = true;
//        int size = getElementCount();
//        for (int i = 0; i < size; i++) {
//            if (getElement(i) == elem) {
//                add = false;
//            }
//        }
//        if (add) {
//            super.add(elem);
//        }
//    }

    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitSet(this);
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitSet(this);
    }

    /**
     * Returns whether <code>type</code> is a squence and the given <code>generics</code> match.
     * 
     * @param type the type to check for
     * @param generics the generics to be considered
     * @return <code>true</code> if <code>type</code> is <code>sequenceOf(<i>generics</i>)</code>, 
     *     <code>false</code> else
     */
    public static final boolean isSet(IDatatype type, IDatatype... generics) {
        return isType(TYPE, type, generics);
    }

}
