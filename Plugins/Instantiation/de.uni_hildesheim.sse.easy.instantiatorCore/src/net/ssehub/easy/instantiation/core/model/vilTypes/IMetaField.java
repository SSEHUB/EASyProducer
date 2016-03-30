/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * Represents a data field.
 * 
 * @author Holger Eichelberger
 */
public interface IMetaField {

    /**
     * Returns the name of the method.
     * 
     * @return the name of the method
     */
    public String getName();

    /**
     * Returns the java-like signature of this operation.
     * 
     * @return the java-like Java signature of this operation
     */
    public String getJavaSignature();

    /**
     * Returns the signature of the method (in terms of VIL types where possible).
     * 
     * @return the signature of the method
     */
    public String getSignature();

    /**
     * Returns the type of this attribute.
     * 
     * @return the type
     */
    public IMetaType getType();

    /**
     * Returns whether the field is read-only. Please note that this method provides a "static" information, i.e.,
     * it cannot change during script execution. If a field can be modified at all, this method shall return 
     * <code>true</code> and determine when the value is changed, whether the actual access is permitted. In contrast, 
     * if it is known that the field cannot be changed at all, this method shall return <code>false</code>.
     * 
     * @return <code>true</code> if the field is read-only, <code>false</code> else
     */
    public boolean isReadOnly();
    
    /**
     * Returns whether the field is static.
     * 
     * @return <code>true</code> if the field is static, <code>false</code> else
     */    
    public boolean isStatic();
}
