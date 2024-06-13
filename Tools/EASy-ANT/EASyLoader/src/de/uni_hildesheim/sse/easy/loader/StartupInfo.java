/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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

import de.uni_hildesheim.sse.easy.loader.framework.Log;
import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * Stores startup information about a certain class.
 * 
 * @author Holger Eichelberger
 */
public class StartupInfo {

    private InitType type;
    private String className;
    
    /**
     * Creates a startup information object.
     * 
     * @param type the startup / shutdown type
     * @param className the class to be started / stopped
     */
    StartupInfo(InitType type, String className) {
        this.type = type;
        this.className = className;
    }
    
    /**
     * Returns the type of the startup unit.
     * 
     * @return the type
     */
    public InitType getType() {
        return type;
    }
    
    /**
     * Returns the qualified class name of the startup unit.
     * 
     * @return the class name
     */
    public String getClassName() {
        return className;
    }
    
    
    /**
     * Starts up the associated class according to the startup type.
     * 
     * @param verbose {@code true} for verbose output, {@code false} else
     * @return <code>true</code> in case of success, <code>false</code> else
     */
    public boolean start(boolean verbose) {
        boolean result;
        if (InitType.ACTIVATOR == type) {
            if (verbose) {
                Log.info("START activator " + className);
            }
            result = Utils.startBundle(getClass().getClassLoader(), className);
        } else if (InitType.DS == type) {
            if (verbose) {
                Log.info("START DS " + className);
            }
            result = Utils.activateDsInstance(getClass().getClassLoader(), className);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Stops the associated class according to the shutdown type.
     * 
     * @param verbose {@code true} for verbose output, {@code false} else
     * @return <code>true</code> in case of success, <code>false</code> else
     */
    public boolean stop(boolean verbose) {
        boolean result;
        if (InitType.ACTIVATOR == type) {
            if (verbose) {
                Log.info("STOP activator " + className);
            }
            result = Utils.stopBundle(getClass().getClassLoader(), className);
        } else if (InitType.DS == type) {
            if (verbose) {
                Log.info("STOP DS " + className);
            }
            result = Utils.deactivateDsInstance(getClass().getClassLoader(), className);
        } else {
            result = false;
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "StartupInfo(" + type + ": " + className + ")";
    }
    
}