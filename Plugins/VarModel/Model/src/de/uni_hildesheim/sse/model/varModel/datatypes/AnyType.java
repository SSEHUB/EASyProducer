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
    
    static final DelegatingType META_TYPE = new DelegatingType();
    static final DelegatingType BOOLEAN_TYPE = new DelegatingType(DTYPE);
    static final DelegatingType CONSTRAINT_TYPE = new DelegatingType(AnyType.DTYPE);
    
    // operations go here
    public static final Operation IS_TYPE_OF = new Operation(
        BOOLEAN_TYPE, OclKeyWords.IS_TYPE_OF, TYPE, META_TYPE);
    public static final Operation IS_KIND_OF = new Operation(
        BOOLEAN_TYPE, OclKeyWords.IS_KIND_OF, TYPE, META_TYPE);

    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new AnyType());
        DTYPE.addOperation(IS_TYPE_OF);
        DTYPE.addOperation(IS_KIND_OF);
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
