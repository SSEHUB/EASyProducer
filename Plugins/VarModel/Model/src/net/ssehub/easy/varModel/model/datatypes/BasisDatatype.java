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
 * Represents the basic data types of the IVML.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public abstract class BasisDatatype implements IDatatype {
    
    private String name;
    
    private DelegatingType singleton;
        
    /**
     * Constructor for the basis data type.
     * @param name Name of the basis data type
     * @param singleton the instance which knows the operations
     */
    protected BasisDatatype(String name, DelegatingType singleton) {
        this.name = name;
        this.singleton = singleton;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getNameSpace() {
        return "";
    }
    
    @Override
    public String getQualifiedName() {
        return name;
    }
    
    @Override
    public String getUniqueName() {
        return name;
    }

    @Override
    public final Operation getOperation(int index) {
        return singleton.getOperation(index);
    }

    @Override
    public final int getOperationCount() {
        return singleton.getOperationCount();
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
        // basically the same due to singletons and null is assignable too
        boolean isAssignable = singleton.equals(type) || AnyType.TYPE == type;
        // but also derived types of basis datatypes are assignable - constraints are checked at reasoning time 
        if (!isAssignable && type instanceof DerivedDatatype) {
            
            DerivedDatatype derived = (DerivedDatatype) type;
            isAssignable = isAssignableFrom(derived.getBasisType());
        }
        return isAssignable;
    }
    
    @Override
    public Class<? extends IDatatype> getTypeClass() {
        return singleton.getTypeClass();
    }
    
    /**
     * Returns the object realizing the type.
     * 
     * @return the object realizing the type
     */
    public IDatatype getType() {
        return this;
    }

    @Override
    public IDatatype getGenericType(int index) {
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public int getGenericTypeCount() {
        return 0;
    }
    
    @Override
    public abstract void accept(IDatatypeVisitor visitor);
    
    @Override
    public boolean isPseudoType() {
        return false;
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }

}
