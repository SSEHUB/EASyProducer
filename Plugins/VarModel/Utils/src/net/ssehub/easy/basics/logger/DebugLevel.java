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
package net.ssehub.easy.basics.logger;

import java.util.logging.Level;

/**
 * Extension for java.util.logging.Level since it does not have a DEBUG level.
 * 
 * @author Sass
 *
 */
public class DebugLevel extends Level {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 2568194940376788365L;

    /**
     * Constructor for DEBUG level which calls super constructor of Level.
     * Level value is placed between CONFIG and INFO.
     * 
     */
    protected DebugLevel() {
        super("DEBUG", 750);
    }

}
