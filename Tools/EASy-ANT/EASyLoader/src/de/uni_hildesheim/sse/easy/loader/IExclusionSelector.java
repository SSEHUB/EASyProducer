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
package de.uni_hildesheim.sse.easy.loader;

/**
 * A generic exclusion selector for controlling the packaging.
 * 
 * @author Holger Eichelberger
 */
public interface IExclusionSelector {

    /**
     * Returns whether the given <code>name</code> is considered to be excluded.
     * 
     * @param name the name
     * @return <code>true</code> if excluded, <code>false</code> else
     */
    public boolean isExcluded(String name);
    
}
