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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.ModelElement;

/** 
 * Enumerations allow the definition of sets of named values.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/

public class Enum extends CustomDatatype {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);
    
    /**
     * This constant represents the common type of all enums. Each specific enum type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    // we assume normalized operations to OCL -> simplifies reasoner translation
    public static final Operation EQUALS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE).markAsAssignableParameterOperation();
    public static final Operation NOTEQUALS = Operation.createInfixOperator(
        BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation NOTEQUALS_ALIAS = Operation.createInfixOperator(
            BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);
    public static final Operation ASSIGNMENT = Operation.createInfixOperator(BooleanType.TYPE, 
        OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();
    public static final Operation FORCE_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.FORCE_DEFINED, TYPE)
        .markAsAcceptsNull();
//    public static final Operation COPY = OperationsHelper.createCopyOperation(TYPE);
    public static final Operation ORDINAL = new Operation(IntegerType.TYPE, OclKeyWords.ORDINAL, TYPE);
    
    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new Enum());
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(NOTEQUALS);
        DTYPE.addOperation(NOTEQUALS_ALIAS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(IS_DEFINED);
        DTYPE.addOperation(FORCE_DEFINED);
//        DTYPE.addOperation(COPY);
        DTYPE.addOperation(ORDINAL);
    }
    
    private List<EnumLiteral> literals;

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private Enum() {
        this("<Enum>", null);
    }
    
    /**
     * Constructor for an empty enum.
     * @param name Name of the enum
     * @param parent the object, in which this specific one is embedded
     */
    protected Enum(String name, ModelElement parent) {
        this(name, DTYPE, parent);
    }

    /**
     * Constructor for an empty enum.
     * @param name Name of the enum
     * @param singleton the instance which knows the operations
     * @param parent the object, in which this specific one is embedded
     */
    protected Enum(String name, DelegatingType singleton, ModelElement parent) {
        super(name, singleton, parent);
        this.literals = new ArrayList<EnumLiteral>();
    }
    
    /**
     * Constructor for the enum.
     * @param name Name of the enum
     * @param parent the object, in which this specific one is embedded
     * @param literals literals to put into this Enum
     */
    public Enum(String name, ModelElement parent, String... literals) {
        this(name, DTYPE, parent);
        
        for (int i = 0; i < literals.length; i++) {
            this.add(literals[i]);
        }
    }
    
    /**
     * Method to add an literal to the enumeration.
     * 
     * @param literal the literal to add
     */
    private void add(String literal) {
        int pos = literals.size();
        EnumLiteral enumLiteral = new EnumLiteral(literal, pos, this);
        literals.add(enumLiteral);
    }

    /**
     * Method to add an literal to the enumeration.
     * 
     * @param literal the literal to add
     * @return <code>true</code> if the operation was successful, 
     *   <code>false</code>
     */
    public boolean add(EnumLiteral literal) {
        boolean ok = true;
        int size = getLiteralCount();
        for (int i = 0; ok && i < size; i++) {
            EnumLiteral tmp = getLiteral(i);
            ok &= tmp.getOrdinal() != literal.getOrdinal();
            ok &= !tmp.getName().equals(literal.getName());
        }
        ok &= this == literal.getParent();
        if (ok) {
            literals.add(literal);
        }
        return ok;
    }
    
    /**
     * Returns whether this enum defines the specified <code>literal</code>.
     * 
     * @param literal the literal to test for
     * @return <code>true</code> if it is defined, <code>false</code> else
     */
    public boolean has(EnumLiteral literal) {
        return literals.contains(literal);
    }
    
    /**
     * Returns the enum literal with name <code>name</code>.
     * 
     * @param name the name to search for
     * @return the literal or <b>null</b>
     */
    public EnumLiteral get(String name) {
        EnumLiteral found = null;
        int size = getLiteralCount();
        for (int i = 0; null == found && i < size; i++) {
            EnumLiteral lit = getLiteral(i); 
            if (lit.getName().equals(name)) {
                found = lit;
            }
        }
        return found;
    }

    /** 
     * Accept method for the visitor. <br/>
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitEnum(this);
    }
    
    /**
     * Returns the number of literals.
     * 
     * @return the number of literals
     */
    public int getLiteralCount() {
        return literals.size();
    }
    
    /**
     * Returns the specified literal.
     * 
     * @param index the index of the literal to be returned
     * @return the specified literal
     * @throws IndexOutOfBoundsException if <code>index&lt;0 
     *     || index&gt;={@link #getLiteralCount()}</code>
     */
    public EnumLiteral getLiteral(int index) {
        return literals.get(index);
    }
    
    /**
     * Returns a literal by its <code>ordinal</code>.
     * 
     * @param ordinal the ordinal of the enumeration literal
     * @return the literal or <b>null</b> if not found
     */
    public EnumLiteral getLiteralByOrdinal(int ordinal) {
        EnumLiteral result = null;
        for (int i = 0; null == result && i < literals.size(); i++) {
            EnumLiteral tmp = literals.get(i);
            if (ordinal == tmp.getOrdinal()) {
                result = tmp;
            }
        }
        return result;
    }
    
    /**
     * Returns the index of the given literal.
     * 
     * @param literal the literal to search for
     * @return the index of the literal, <code>-1</code> if not found
     */
    public int getLiteralIndex(EnumLiteral literal) {
        return literals.indexOf(literal);
    }
    
    /**
     * Returns whether this enum is ordered.
     * 
     * @return <code>true</code> if it is ordered, <code>false</code> else (default <code>false</code>)
     */
    public boolean isOrdered() {
        return false;
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitEnumType(this);
    }
}
