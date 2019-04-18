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

import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.datatypes.Operation.ReturnTypeMode;


/** 
 * A reference allows the definition of individual configurations of an (external) element for the referencing element.
 * Currently, operations such as assignments are represented as the respective operations of the base type. Actually, 
 * this may be confusing / wrong. See {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree#inferDatatype()}.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Reference extends CustomDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    
    /**
     * This constant represents the common type of all references. Each specific reference type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    public static final Operation EQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.EQUALS, TYPE, TYPE);
    public static final Operation UNEQUALS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS, TYPE, TYPE);
    public static final Operation UNEQUALS_ALIAS 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);
    public static final Operation ASSIGNMENT 
        = Operation.createInfixOperator(BooleanType.TYPE, OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
        .markAsAcceptsNull();
    public static final Operation COPY = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND, 
        OclKeyWords.COPY, TYPE, AnyType.STRING_TYPE);
    public static final Operation REF_BY = new Operation(TYPE, ReturnTypeMode.IMMEDIATE_OPERAND_DEREF, 
        IvmlKeyWords.REFBY, TYPE); // internal, not resolvable through IVML as keyword there!
 
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new Reference());
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(IS_DEFINED);
        DTYPE.addOperation(COPY);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(UNEQUALS);
        DTYPE.addOperation(UNEQUALS_ALIAS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(REF_BY);
    }
    
    private IDatatype type;

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private Reference() {
        this("<Reference>", null, null);
    }
    
    /**
     * Constructor for the reference.
     * @param name Name of reference
     * @param type the type to refer to
     * @param parent the object, in which this specific one is embedded
     */
    public Reference(String name, IDatatype type, ModelElement parent) {
        super(name, DTYPE, parent);
        this.type = type;
    }
    
    /**
     * Returns the type this reference is referring to.
     * 
     * @return the type
     */
    public IDatatype getType() {
        return type;
    }

    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitReference(this);
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitReference(this);
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
        boolean isAssignable = AnyType.TYPE == type;
        if (super.isAssignableFrom(type) && type instanceof Reference) {
            Reference r = (Reference) type;
            if (null == this.type) {
                isAssignable = true; // this is akin to Reference.INSTANCE so everything reference can be assinged
            } else {
                if (null != r.type) {
                    isAssignable = this.type.isAssignableFrom(DerivedDatatype.resolveToBasis(r.type));
                }
            }
        }
        return isAssignable;
    }
    
    /**
     * Aims at dereference <code>type</code> in case that it is a reference.
     * 
     * @param type the type to dereference
     * @return the dereferenced type (or <code>type</code> if <code>type</code> was not a reference)
     */
    public static IDatatype dereference(IDatatype type) {
        // TODO actually I'm not happy about this explicit dereferencing
        IDatatype result;
        if (type instanceof Reference) {
            result = ((Reference) type).getType();
        } else {
            result = type;
        }
        return result;
    }

    /**
     * Dereferences all datatypes in <code>type</code>.
     * 
     * @param types the types to be dereferenced
     */
    public static void dereference(IDatatype[] types) {
        if (null != types) {
            for (int p = 0; p < types.length; p++) {
                types[p] = Reference.dereference(types[p]);
            }            
        }
    }
    
    /**
     * Returns whether the given <code>type</code> is a reference with given <code>generic</code>.
     *  
     * @param type the type to check
     * @param parameter the parameter type of the expected reference (may also be a more generic type)
     * @return <code>true</code> if <code>type</code> is <code>refTo(<i>generic</i>)</code>, <code>false</code> else
     */
    public static boolean isReferenceTo(IDatatype type, IDatatype parameter) {
        return TYPE.isAssignableFrom(type) && parameter.isAssignableFrom(type.getType());
    }

}
