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
package de.uni_hildesheim.sse.utils.internal;


/**
 * Stores data about the containing OSGi bundle (static bundle without activator).
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class Bundle {
    
    /**
     * Stores the bundle ID.
     * Must be the same ID as specified inside the Manifest file.
     */
    public static final String ID = "de.uni_hildesheim.sse.utils";

}
