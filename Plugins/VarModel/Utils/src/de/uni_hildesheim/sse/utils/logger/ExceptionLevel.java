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
package de.uni_hildesheim.sse.utils.logger;

import java.util.logging.Level;

/**
 * Extension for java.util.logging.Level since it does not have a EXCEPTION level.
 * 
 * @author Sass
 *
 */
public class ExceptionLevel extends Level {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 6875381264871245337L;

    /**
     * Constructor for EXCEPTION level which calls super constructor of Level.
     * Level value is placed between CONFIG and INFO.
     * 
     */
    protected ExceptionLevel() {
        super("EXCEPTION", 760);
    }

}
