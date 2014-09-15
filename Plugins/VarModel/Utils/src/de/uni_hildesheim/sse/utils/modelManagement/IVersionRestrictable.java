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
package de.uni_hildesheim.sse.utils.modelManagement;


/**
 * Denotes an element which can be restricted in terms of versions.
 * 
 * @author Holger Eichelberger
 */
public interface IVersionRestrictable {

    /**
     * Returns the restriction specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the restriction to be returned
     * @return the restriction
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getRestrictionsCount}</code>
     */
    public VersionRestriction getRestriction(int index);

    /**
     * Returns the number of restrictions.
     * 
     * @return the number of restrictions
     */
    public int getRestrictionsCount();

}
