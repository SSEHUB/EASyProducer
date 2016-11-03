/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package test.de.uni_hildesheim.sse.vil.buildlang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Map;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.ParameterMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A string creator type.
 * 
 * @author Holger Eichelberger
 */
public class StringCreator implements IVilType, IStringValueProvider {
    
    /**
     * A VIL constructor.
     * 
     * @return a StringCreator instance
     */
    public static StringCreator create() {
        return new StringCreator();
    }

    /**
     * A VIL constructor.
     * 
     * @param string ignored (just for testing, no semantics)
     * @return a StringCreator instance
     */
    public static StringCreator create(String string) {
        return new StringCreator();
    }
    
    /**
     * Just return strings as iterator.
     * 
     * @return the iterator
     */
    @OperationMeta(returnGenerics = String.class)
    public Iterator<String> strings() {
        List<String> tmp = new ArrayList<String>();
        tmp.add("1");
        tmp.add("2");
        tmp.add("3");
        return tmp.iterator();
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<StringCreator>";
    }

    /**
     * Tests nested return generics and parameter meta.
     * 
     * @param string just a string
     * @param weights unused
     * @return combination of strings and weights
     */
    @OperationMeta(returnGenerics = {String.class, Map.class, String.class, Double.class})
    public Map<String, Map<String, Double>> mapStrings(String string, 
        @ParameterMeta(generics = {String.class, Double.class})
        Map<String, Double> weights) {
        java.util.Map<Object, Object> tmp = new HashMap<Object, Object>();
        TypeDescriptor<?>[] typesInner = TypeDescriptor.createArray(2);
        typesInner[0] = TypeRegistry.stringType();
        typesInner[1] = TypeRegistry.realType();
        TypeDescriptor<?>[] types = TypeDescriptor.createArray(2);
        types[0] = TypeRegistry.stringType();
        try {
            types[1] = TypeRegistry.getMapType(typesInner);
        } catch (VilException e) {
            types[1] = TypeRegistry.anyType();
        }
        
        java.util.Map<Object, Object> tmpInner = new HashMap<Object, Object>();
        tmpInner.put("here", 1.1);
        Map<String, Double> inner = new Map<String, Double>(tmpInner, typesInner);
        tmp.put("there", inner);
        Map<String, Map<String, Double>> result = new Map<String, Map<String, Double>>(tmp, types);
        return result;
    }

}
