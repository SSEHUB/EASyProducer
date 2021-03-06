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

import java.util.HashMap;
import java.util.Map;

/**
 * Maps singleton type instances to unique names and back again. Basically, all instances
 * of delegating types shall be mapped.
 * 
 * @author Holger Eichelberger
 */
public class TypeMapper {
    
    /**
     * Exports the meta-class of the package-local class {@link DelegatingType}.
     */
    public static final Class<?> DELEGATING_CLASS = DelegatingType.class;
    
    /**
     * Stores the type-to-name-mappings.
     */
    private static final Map<IDatatype, String> TYPE_STRING = new HashMap<IDatatype, String>();

    /**
     * Stores the name-to-type-mappings.
     */
    private static final Map<String, IDatatype> STRING_TYPE = new HashMap<String, IDatatype>();
    
    /**
     * Adds a name-type-mapping.
     * 
     * @param name the (unique) textual name of <code>type</code> 
     * @param type the mapped type
     */
    private static final void put(String name, IDatatype type) {
        STRING_TYPE.put(name, type);
        TYPE_STRING.put(type, name);
    }
    
    /**
     * Initializes known types. This might be done dynamically, but then it is not
     * guaranteed that all required types are known.
     */
    static {
        put("Integer", IntegerType.TYPE);
        put("Real", RealType.TYPE);
        put("Boolean", BooleanType.TYPE);
        put("String", StringType.TYPE);
        put("Meta", MetaType.TYPE);
        put("Any", AnyType.TYPE);
        put("Container", Container.TYPE);
        put("Set", Set.TYPE);
        put("Sequence", Sequence.TYPE);
        put("Compound", Compound.TYPE);
        put("Derived", DerivedDatatype.TYPE);
        put("Enum", Enum.TYPE);
        put("OrderedEnum", OrderedEnum.TYPE);
        put("Reference", Reference.TYPE);
        put("Constraint", ConstraintType.TYPE);
        put("FreezeVariable", FreezeVariableType.TYPE);
    }
    
    /**
     * Returns the mapping name for a <code>type</code>.
     * 
     * @param type the type to return the mapping name for
     * @return the mapping name (<b>null</b> in case that there is no mapping)
     */
    public static final String getName(IDatatype type) {
        return TYPE_STRING.get(type);
    }

    /**
     * Returns the mapped type for a <code>name</code>.
     * 
     * @param name the name to return the mapped type for
     * @return the mapped type (<b>null</b> in case that there is no mapping)
     */
    public static final IDatatype getType(String name) {
        return STRING_TYPE.get(name);
    }

}
