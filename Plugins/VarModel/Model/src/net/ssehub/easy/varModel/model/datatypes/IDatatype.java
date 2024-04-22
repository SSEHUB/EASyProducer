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
 * Abstract class, implements some methods for all existing data types.
 * Note that a datatype may be generic, i.e. parameterized (see {@link #getGenericType(int)}.
 * 
 * <b>Important:</b> Please do not use reference equality or the equals method for testing 
 * equality of datatypes. Use {@link #isAssignableFrom(IDatatype)} instead. 
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public interface IDatatype extends IDatatypeVisitable {
 
    /**
     * Method to get the name of the Datatype.
     * @return name of the Datatype
     */
    public String getName();

    /** 
     * Returns the namespace of this datatype.
     * @return Namespace of this datatype.
     */
    public String getNameSpace();
    
    /**
     * Returns the qualified name of this element.
     * 
     * @return the qualified name
     */
    public String getQualifiedName();

    /**
     * Returns the unique name of this element.
     * 
     * @return the unique name
     */
    public String getUniqueName();

    /**
     * Returns the operation specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the operation to be returned
     * @return the operation
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getOperationCount}</code>
     */
    public Operation getOperation(int index);

    /**
     * Returns the number of operations.
     * 
     * @return the number of operations
     */
    public int getOperationCount();

    /**
    * Determines if the data type represented by this
    * object is either the same as, or is a supertype of 
    * <code>type</code>.
    * 
    * @param type the type being checked
    * @return <code>true</code> if this type is either the same or a 
    *   supertype of <code>type</code>, <code>false</code> else
    */
    public boolean isAssignableFrom(IDatatype type);

    /**
     * Returns the java class realizing the type.
     * 
     * @return the java class realizing the type
     */
    public Class<? extends IDatatype> getTypeClass();

    /**
     * Returns the object realizing the type.
     * 
     * @return the object realizing the type
     */
    public IDatatype getType();

    /**
     * Returns the specified generic type.
     * 
     * @param index the index of the type
     * @return the specified generic type
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getGenericTypeCount()}</code>
     */
    public IDatatype getGenericType(int index);
    
    /**
     * Returns the number of generic types.
     * @return the number of generic types
     */
    public int getGenericTypeCount();
    
    /**
     * Returns whether this type is a pseudo type. This operation shall be used
     * to prevent the output of internal types to the user.
     * 
     * @return <code>true</code> if it is a pseudo type, <code>false</code> else
     */
    public boolean isPseudoType();
    
    /**
     * Returns whether this type is a primitive type.
     * 
     * @return <code>true</code> if it is a primitive type, <code>false</code> else
     */
    public boolean isPrimitive();
}
