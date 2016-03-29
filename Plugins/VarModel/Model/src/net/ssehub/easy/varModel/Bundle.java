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
package net.ssehub.easy.varModel;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;

/**
 * Stores data about the containing OSGi bundle (static bundle without activator).
 * 
 * @author Holger Eichelberger
 */
public class Bundle {
    
    /**
     * Stores the bundle ID.
     */
    public static final String ID = "de.uni_hildesheim.sse.varModel";
    
    /**
     * Helper method for getting an Logger for a Class of this bundle.
     * @param clazz The class of this bundle for which the logger should be returned for.
     * @return The logger instance.
     */
    public static EASyLogger getLogger(Class<?> clazz) {
        return EASyLoggerFactory.INSTANCE.getLogger(clazz, ID);
    }

}
