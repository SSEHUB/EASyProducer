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
public class VoidType extends BasisDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!
    
    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    public static final IDatatype TYPE = DTYPE;
    
    // checkstyle: resume declaration order check
    
    static {
        DTYPE.setDelegate(new VoidType());
    }
    
    /**
     * Constructor for a new VoidType.
     */
    private VoidType() {
        super("VoidType", DTYPE);
    }
    
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return false; // no type is compliant to this
    }

    @Override
    public void accept(IDatatypeVisitor visitor) {
        //visitor.visitAnyType(this);
    }

}
