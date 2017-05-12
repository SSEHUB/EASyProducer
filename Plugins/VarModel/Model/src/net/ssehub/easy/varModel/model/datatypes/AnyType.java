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
 * The AnyType is the "Object" of OCL, a type to which all types are compatible.
 * We need this type to specify generic operations (return values)
 * 
 * @author Holger Eichelberger
 */
public class AnyType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    public static final IDatatype TYPE = DTYPE;
    
    // forward type declaration to avoid class loading cycles / null
    static final DelegatingType META_TYPE = new DelegatingType();
    static final DelegatingType BOOLEAN_TYPE = new DelegatingType(DTYPE);
    static final DelegatingType STRING_TYPE = new DelegatingType(AnyType.DTYPE);
    static final DelegatingType CONSTRAINT_TYPE = new DelegatingType(AnyType.DTYPE);
    static final DelegatingType CONTAINER_TYPE = new DelegatingType(AnyType.DTYPE);
    static final DelegatingType SEQUENCE_TYPE = new DelegatingType(CONTAINER_TYPE);
    static final DelegatingType SET_TYPE = new DelegatingType(CONTAINER_TYPE);
            
    // operations go here
    public static final Operation IS_TYPE_OF = new Operation(
        BOOLEAN_TYPE, OclKeyWords.IS_TYPE_OF, TYPE, META_TYPE);
    public static final Operation IS_KIND_OF = new Operation(
        BOOLEAN_TYPE, OclKeyWords.IS_KIND_OF, TYPE, META_TYPE);
    public static final Operation SET_LOCALE = new Operation(
        STRING_TYPE, OclKeyWords.LOCALE, TYPE, STRING_TYPE);
    public static final Operation GET_LOCALE = new Operation(
        STRING_TYPE, OclKeyWords.LOCALE, TYPE);

    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new AnyType());
        DTYPE.addOperation(IS_TYPE_OF);
        DTYPE.addOperation(IS_KIND_OF);
        DTYPE.addOperation(SET_LOCALE);
        DTYPE.addOperation(GET_LOCALE);
    }
    
    /**
     * Constructor for a new BooleanType.
     */
    private AnyType() {
        super("AnyType", DTYPE);
    }
    
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return true; // any type is compliant to this
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitAnyType(this);
    }

}
