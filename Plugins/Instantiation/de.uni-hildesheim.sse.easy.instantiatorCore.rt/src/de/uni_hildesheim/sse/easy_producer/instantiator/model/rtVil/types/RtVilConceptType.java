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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.types;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.IRtVilConcept;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;

/**
 * Defines the type of a rt-VIL concept and its operations.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = Constants.TYPE_RT_VIL_CONCEPT, equiv = IRtVilConcept.class)
public class RtVilConceptType implements IVilType {

    /**
     * Returns the name of the given concept.
     * 
     * @param concept the concept to return the name for
     * @return the name of the concept
     */
    public static String getName(IRtVilConcept concept) {
        return null == concept ? null : concept.getName();
    }

}
