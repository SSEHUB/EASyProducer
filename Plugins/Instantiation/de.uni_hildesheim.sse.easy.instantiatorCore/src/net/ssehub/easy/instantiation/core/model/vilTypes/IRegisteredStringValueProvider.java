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

import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider.StringComparator;

/**
 * Defines the interface of an externally registered string value provider.
 * This is the "static" version of {@link IStringValueProvider} for external type
 * classes that do not implement EASy interfaces, e.g., for rt-VIL.
 * 
 * @author Holger Eichelberger
 */
public interface IRegisteredStringValueProvider {

    /**
     * Returns the string value of this object.
     * 
     * @param object the object to be printed
     * @param comparator if the sequence of elements, e.g., in case of collections, shall
     *   be ordered according to the comparator, <b>null</b> if the original sequence shall
     *   be returned
     * @return the string value
     */
    @Invisible
    public String getStringValue(Object object, StringComparator comparator);

}
