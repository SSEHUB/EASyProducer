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

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.InternalConstraint;

/**
 * Abstract class, implements the setName method for the custom data types.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/

public abstract class CustomDatatype extends ContainableModelElement implements IDatatype {

    private DelegatingType singleton;
    
    /**
     * Constructor for custom data type.
     * @param name Name of the custom data type
     * @param singleton the instance which knows the operations
     * @param parent the object, in which this specific one is embedded
     */
    protected CustomDatatype(String name, DelegatingType singleton, IModelElement parent) {
        super(name, parent);
        this.singleton = singleton;
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
        return singleton.equals(type) // allow exactly the same 
            || AnyType.TYPE == type   // allow null
            || (null != type && getClass().isAssignableFrom(type.getClass())); // allow subclasses
    }
    
    /**
     * Returns the java class realizing the type.
     * 
     * @return the java class realizing the type
     */
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
    public InternalConstraint[] createConstraints(AbstractVariable declaration) throws CSTSemanticException {
        return null;
    }
    
    @Override
    public boolean isPseudoType() {
        return false;
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }

    /**
     * Returns whether <code>type</code> of <code>requestedType</code>and the given <code>generics</code> match.
     * 
     * @param requestedType the requested basic type
     * @param type the type to check for
     * @param generics the generics to be considered
     * @return <code>true</code> if <code>type</code> is a <code>requestedType</code> with the matching generics, 
     *   <code>false</code> else
     */
    protected static final boolean isType(IDatatype requestedType, IDatatype type, IDatatype... generics) {
        boolean match = false;
        if (requestedType.isAssignableFrom(type) && null != generics && generics.length == type.getGenericTypeCount()) {
            match = true;
            for (int g = 0; match && g < type.getGenericTypeCount(); g++) {
                IDatatype generic = type.getGenericType(g);
                match = generic.isAssignableFrom(generics[g]) || generics[g].isAssignableFrom(generic);
            }
        }
        return match;
    }

}
