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

import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.datatypes.Operation.ReturnTypeMode;

/**
 * Realizes a sequence container.
 * This represents an array.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Sequence extends Container {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check
    
    static final DelegatingType DTYPE = AnyType.SEQUENCE_TYPE;
    // actually we can define operations once and reuse them but I'm not sure whether this makes
    // sense with respect to the reasoner -> define in "supertype" and link to respective DTYPE
    
    /**
     * This constant represents the common type of all sets. Each specific sequence type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    // generic operations
    public static final Operation INDEX_ACCESS = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.INDEX_ACCESS, TYPE, IntegerType.TYPE);
    public static final Operation AT = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.AT, TYPE, IntegerType.TYPE);
    public static final Operation FIRST = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.FIRST, TYPE);
    public static final Operation LAST = new Operation(AnyType.TYPE, 
        ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.LAST, TYPE);

    public static final Operation AS_SET = new Operation(Set.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.AS_SET, TYPE);
    public static final Operation TO_SET = new Operation(Set.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.TO_SET, TYPE);
    public static final Operation AS_SEQUENCE = new Operation(Sequence.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.AS_SEQUENCE, TYPE);
    public static final Operation TO_SEQUENCE = new Operation(Sequence.TYPE, ReturnTypeMode.TYPED_OPERAND_1, 
        OclKeyWords.TO_SEQUENCE, TYPE);
    public static final Operation UNION = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.UNION, TYPE, TYPE);
    public static final Operation APPEND = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.APPEND, TYPE, AnyType.TYPE);
    public static final Operation PREPEND = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.PREPEND, TYPE, AnyType.TYPE);
    public static final Operation INSERT_AT = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.INSERT_AT, TYPE, IntegerType.TYPE, AnyType.TYPE);
    public static final Operation INDEX_OF = new Operation(IntegerType.TYPE, OclKeyWords.INDEX_OF, TYPE, AnyType.TYPE);
    public static final Operation HAS_DUPLICATES = new Operation(BooleanType.TYPE, OclKeyWords.HAS_DUPLICATES, TYPE);
    public static final Operation EXCLUDING = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.EXCLUDING, TYPE, AnyType.TYPE);
    public static final Operation INCLUDING = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.INCLUDING, TYPE, AnyType.TYPE);
    public static final Operation REVERSE = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND,
        OclKeyWords.REVERSE, TYPE);
    public static final Operation SUBSEQUENCE = new Operation(Sequence.TYPE, ReturnTypeMode.TYPED_OPERAND_1,
        OclKeyWords.SUBSEQUENCE, TYPE, IntegerType.TYPE, IntegerType.TYPE);
    public static final Operation ADD = new Operation(AnyType.TYPE, ReturnTypeMode.PARAM_1_CHECK, 
        OclKeyWords.ADD, TYPE, AnyType.TYPE);
    public static final Operation ISSUBSEQUENCE = new Operation(BooleanType.TYPE, 
        OclKeyWords.ISSUBSEQUENCE, TYPE, TYPE);
    public static final Operation OVERLAPS = new Operation(BooleanType.TYPE, OclKeyWords.OVERLAPS, TYPE, TYPE);
    public static final Operation FLATTEN = new Operation(TYPE, 
        ReturnTypeMode.IMMEDIATE_OPERAND_COLLECTION_NESTED_GENERIC_1, OclKeyWords.FLATTEN, TYPE);

    // type specific 
    public static final Operation EQUALS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE).markAsAssignableParameterOperation();
    public static final Operation ASSIGNMENT = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new Sequence());
        DTYPE.addOperation(INDEX_ACCESS);
        DTYPE.addOperation(AT);
        DTYPE.addOperation(FIRST);
        DTYPE.addOperation(LAST);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(AS_SET);
        DTYPE.addOperation(TO_SET);
        DTYPE.addOperation(AS_SEQUENCE);
        DTYPE.addOperation(TO_SEQUENCE);
        DTYPE.addOperation(UNION);
        DTYPE.addOperation(APPEND);
        DTYPE.addOperation(PREPEND);
        DTYPE.addOperation(INSERT_AT);
        DTYPE.addOperation(INDEX_OF);
        DTYPE.addOperation(HAS_DUPLICATES);
        DTYPE.addOperation(INCLUDING);
        DTYPE.addOperation(EXCLUDING);
        DTYPE.addOperation(REVERSE);
        DTYPE.addOperation(SUBSEQUENCE);
        DTYPE.addOperation(ADD);
        DTYPE.addOperation(ISSUBSEQUENCE);
        DTYPE.addOperation(OVERLAPS);
        DTYPE.addOperation(FLATTEN);
    }
    
    /**
     * Creates the singleton instance.
     */
    private Sequence() {
        this("<Sequence>",  null, null);
    }
    
    /**
     * Constructor for the container.
     * @param name Name of the container
     * @param type data type of the container elements
     * @param parent the object, in which this specific one is embedded
     */
    public Sequence(String name, IDatatype type, IModelElement parent) {
        super(name, DTYPE, type, parent);
    }

    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitSequence(this);
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitSequence(this);
    }

    /**
     * Returns whether <code>type</code> is a squence and the given <code>generics</code> match.
     * 
     * @param type the type to check for
     * @param generics the generics to be considered
     * @return <code>true</code> if <code>type</code> is <code>sequenceOf(<i>generics</i>)</code>, 
     *     <code>false</code> else
     */
    public static final boolean isSequence(IDatatype type, IDatatype... generics) {
        return isType(TYPE, type, generics);
    }

}
