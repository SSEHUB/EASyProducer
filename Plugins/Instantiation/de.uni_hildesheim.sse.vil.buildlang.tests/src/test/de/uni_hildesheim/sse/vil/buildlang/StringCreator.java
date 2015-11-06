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
import java.util.Iterator;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;

/**
 * A string creator type.
 * 
 * @author Holger Eichelberger
 */
public class StringCreator implements IVilType, IStringValueProvider {
    
    /**
     * The VIL constructor.
     * 
     * @return a StringCreator instance
     */
    public static StringCreator create() {
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

}
