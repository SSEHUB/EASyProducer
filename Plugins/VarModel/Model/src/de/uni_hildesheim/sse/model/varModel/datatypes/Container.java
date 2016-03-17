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
 * Realizes an abstract container.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Container extends StructuredDatatype {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);
    
    /**
     * This constant represents the common type of all sets. Each specific sequence type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    public static final Operation SIZE = new Operation(IntegerType.TYPE, OclKeyWords.SIZE, TYPE);
    public static final Operation UNEQUALS = Operation.createInfixOperator(BooleanType.TYPE, 
        OclKeyWords.UNEQUALS, TYPE, TYPE);
    
    public static final Operation INCLUDES = new Operation(BooleanType.TYPE, OclKeyWords.INCLUDES, TYPE, AnyType.TYPE);
    public static final Operation EXCLUDES = new Operation(BooleanType.TYPE, OclKeyWords.EXCLUDES, TYPE, AnyType.TYPE);
    public static final Operation COUNT = new Operation(BooleanType.TYPE, OclKeyWords.COUNT, TYPE, AnyType.TYPE);
    public static final Operation IS_EMPTY = new Operation(BooleanType.TYPE, OclKeyWords.IS_EMPTY, TYPE);
    public static final Operation NOT_EMPTY = new Operation(BooleanType.TYPE, OclKeyWords.NOT_EMPTY, TYPE);
    public static final Operation SUM = new Operation(AnyType.TYPE, ReturnTypeMode.GENERIC_PARAM_1, 
        OclKeyWords.SUM, TYPE);
    public static final Operation PRODUCT = new Operation(AnyType.TYPE, ReturnTypeMode.GENERIC_PARAM_1, 
            OclKeyWords.PRODUCT, TYPE);
    public static final Operation MIN = new Operation(AnyType.TYPE, ReturnTypeMode.GENERIC_PARAM_1, 
            OclKeyWords.MIN, TYPE);
    public static final Operation MAX = new Operation(AnyType.TYPE, ReturnTypeMode.GENERIC_PARAM_1, 
            OclKeyWords.MAX, TYPE);
    public static final Operation AVG = new Operation(AnyType.TYPE, ReturnTypeMode.GENERIC_PARAM_1, 
            OclKeyWords.AVG, TYPE);
    
    // do *not* add equals here!
    
    // this operation is defined on the (abstract) container and reused by the concrete
    // implementations... let's see whether this makes sense from the perspective of the reasoner
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    // strange thing... the apply operation is type generic on the first parameter (result of lambda expression)
    public static final Operation APPLY = new Operation(BooleanType.TYPE, ReturnTypeMode.PARAM_1, 
        OclKeyWords.APPLY, TYPE, AnyType.TYPE).markAsContainerOperation();

    // quantors
    public static final Operation FORALL = new Operation(BooleanType.TYPE, OclKeyWords.FOR_ALL, 
        TYPE, BooleanType.TYPE).markAsContainerOperation();
    public static final Operation EXISTS = new Operation(BooleanType.TYPE, OclKeyWords.EXISTS, 
        TYPE, BooleanType.TYPE).markAsContainerOperation();
    public static final Operation ANY = new Operation(TYPE, ReturnTypeMode.GENERIC_PARAM_1, OclKeyWords.ANY, 
        TYPE, BooleanType.TYPE).markAsContainerOperation();
    public static final Operation ONE = new Operation(BooleanType.TYPE, OclKeyWords.ONE, 
        TYPE, BooleanType.TYPE).markAsContainerOperation();
    public static final Operation IS_UNIQUE = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.IS_UNIQUE, TYPE, AnyType.TYPE).markAsContainerOperation();
    public static final Operation COLLECT = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND_COLLECTION_PARAM_1, 
        OclKeyWords.COLLECT, TYPE, AnyType.TYPE).markAsContainerOperation();
    public static final Operation SELECT = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, OclKeyWords.SELECT, 
        TYPE, BooleanType.TYPE).markAsContainerOperation();
    public static final Operation REJECT = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, OclKeyWords.REJECT, 
        TYPE, BooleanType.TYPE).markAsContainerOperation();

    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();
    public static final Operation TYPE_SELECT = new Operation(TYPE, ReturnTypeMode.TYPED_PARAM_1, 
        OclKeyWords.TYPE_SELECT, TYPE, AnyType.TYPE);    
    public static final Operation TYPE_REJECT = new Operation(TYPE, ReturnTypeMode.TYPED_PARAM_1, 
        OclKeyWords.TYPE_REJECT, TYPE, AnyType.TYPE);
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new Container("Container", DTYPE, AnyType.TYPE, null));
        DTYPE.addOperation(SIZE);
        DTYPE.addOperation(UNEQUALS);
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(APPLY);
        DTYPE.addOperation(INCLUDES);
        DTYPE.addOperation(EXCLUDES);
        DTYPE.addOperation(COUNT);
        DTYPE.addOperation(IS_EMPTY);
        DTYPE.addOperation(NOT_EMPTY);
        DTYPE.addOperation(SUM);
        DTYPE.addOperation(PRODUCT);
        DTYPE.addOperation(MIN);
        DTYPE.addOperation(MAX);
        DTYPE.addOperation(AVG);
        DTYPE.addOperation(FORALL);
        DTYPE.addOperation(EXISTS);
        DTYPE.addOperation(ANY);
        DTYPE.addOperation(ONE);
        DTYPE.addOperation(IS_UNIQUE);
        DTYPE.addOperation(COLLECT);
        DTYPE.addOperation(SELECT);
        DTYPE.addOperation(REJECT);
        DTYPE.addOperation(IS_DEFINED);
        DTYPE.addOperation(TYPE_SELECT);
        DTYPE.addOperation(TYPE_REJECT);
    }
    
    private IDatatype type;
    
    //private List<DecisionVariableDeclaration> elements = new ArrayList<DecisionVariableDeclaration>();
    
    /**
     * Constructor for the container.
     * @param name Name of the container
     * @param singleton the instance which knows the operations
     * @param type data type of the container elements
     * @param parent the object, in which this specific one is embedded
     */
    protected Container(String name, DelegatingType singleton, IDatatype type, IModelElement parent) {
        super(name, singleton, parent);
        this.type = type;
    }
    
//    /**
//     * Method to add an object to the elements list of the container.
//     * @param elem element to add to the list
//     */
//    public void add(DecisionVariableDeclaration elem) {
//        elements.add(elem);            
//    }
//    
//    /**
//     * Returns the number of elements.
//     * 
//     * @return the number of elements
//     */
//    public int getElementCount() {
//        return elements.size();
//    }
//    
//    /**
//     * Returns the specified element.
//     * 
//     * @param index the index of the element
//     * @return the element at the given index
//     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
//     */
//    public DecisionVariableDeclaration getElement(int index) {
//        return elements.get(index);
//    }
//    
//    /**
//     * Method to delete an element at a specific position.
//     * @param pos the element at the position pos will be deleted
//     */
//    public void deleteElement(int pos) {
//        //elements.remove(pos)?
//        for (int i = pos; i < elements.size() - 1; i++) {
//            elements.set(i, elements.get(i + 1));
//        }
//    }
    
    /**
     * Returns the type of the contained elements.
     * 
     * @return the type of the contained elements
     */
    public IDatatype getContainedType() {
        return type;
    }

    @Override
    public IDatatype getGenericType(int index) {
        if (0 == index) {
            return getContainedType();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public int getGenericTypeCount() {
        return 1;
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        // this class is considered to be abstract but must not
        // be abstract due to the initialization of type delegates
        // thus this method is not implemented and must be implemented
        // by subclasses
    }

    @Override
    public void accept(IModelVisitor visitor) {
        // this class is considered to be abstract but must not
        // be abstract due to the initialization of type delegates
        // thus this method is not implemented and must be implemented
        // by subclasses
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
        boolean result;
        if (super.isAssignableFrom(type)) {
            if (type.getType() instanceof Container) {
                // if the basic is fulfilled also the contained types must match
                Container cType = (Container) type.getType();
                IDatatype thisContained = getContainedType();
                IDatatype typeContained = cType.getContainedType();
                if (null == thisContained) {
                    // this is "container" and supertype of all containers
                    result = true;
                } else if (null == typeContained) {
                    // this is a specific container and never a supertype of "container"
                    result = false;
                } else {
                    result = thisContained.isAssignableFrom(typeContained);
                }
            } else {
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Returns whether <code>type</code> is a container with one generic of type Constraint.
     * 
     * @param type the type to check for
     * @return <code>true</code> if <code>type</code> is a container of Constraints, <code>false</code> else
     */
    public static final boolean isConstraintContainer(IDatatype type) {
        boolean result = false;
        if (isContainer(type, ConstraintType.TYPE)) {
            result = ConstraintType.isConstraint(type.getGenericType(0)); // avoid booleans
        }
        return result;
    }
        
    /**
     * Returns whether <code>type</code> is a container and the given <code>generics</code> match.
     * 
     * @param type the type to check for
     * @param generics the generics to be considered
     * @return <code>true</code> if <code>type</code> is a container with the given generics, <code>false</code> else
     * @see #isReferencesContainer(IDatatype)
     * @see #isReferencesContainer(IDatatype, IDatatype)
     */
    public static final boolean isContainer(IDatatype type, IDatatype... generics) {
        return isType(TYPE, type, generics);
    }

    /**
     * Returns if <code>type</code> is a container of references.
     * 
     * @param type the type to check
     * @return <code>true</code> if <code>type</code> is a container of references, <code>false</code> else
     */
    public static final boolean isReferencesContainer(IDatatype type) {
        return Container.TYPE.isAssignableFrom(type) 
            && 1 == type.getGenericTypeCount() 
            && Reference.TYPE.isAssignableFrom(type.getGenericType(0));
    }

    /**
     * Returns if <code>type</code> is a container of references of the given <code>elementType</code>.
     * 
     * @param type the type to check
     * @param elementType the element type within the references
     * @return <code>true</code> if <code>type</code> is a container of references, <code>false</code> else
     * @see #isContainer(IDatatype, IDatatype...)
     */
    public static boolean isReferencesContainer(IDatatype type, IDatatype elementType) {
        return isReferencesContainer(type) 
            && ((Reference) type.getGenericType(0)).getType().isAssignableFrom(elementType);
    }

}
