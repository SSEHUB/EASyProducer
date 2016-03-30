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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Provides access to rt-VIL values during the execution of a rt-VIL script. Do not modify the values!
 * 
 * @author Holger Eichelberger
 */
public interface IRtValueAccess {

    /**
     * Returns the value of <code>var</code>.
     * 
     * @param var the variable to return the value for
     * @return the value of <code>var</code>
     * @throws VilException in case that <code>var</code> was not defined
     */
    public Object getValue(VariableDeclaration var) throws VilException;

}
