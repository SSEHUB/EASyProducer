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
package de.uni_hildesheim.sse.utils;

import java.io.File;
import java.net.URL;

/**
 * Static utility functions regarding the environment of EASy.
 * @author El-Sharkawy
 *
 */
public class Environment {
    
    /**
     * Should avoid instances of this class.
     */
    private Environment() {}
    
    /**
     * Checks whether EASy runs inside of Eclipse.
     * @return <tt>true</tt> if EASy runs inside of Eclipse, <tt>false</tt> otherwise.
     */
    public static boolean runsInEclipse() {
        // this is just a heuristic, pde.launch is required to state that RCP apps are no eclipse
        return (null != System.getProperty("eclipse.product", null)
            || null != System.getProperty("eclipse.home.location", null)) 
            && null != System.getProperty("eclipse.pde.launch");
    }
    
    /**
     * Checks whether this program is currently running on a Windows machine.
     * @return <tt>true</tt> if The current OS is a windows machine, <tt>false</tt> otherwise.
     */
    public static boolean isWinOS() {
        return System.getProperty("os.name").contains("win") || System.getProperty("os.name").contains("Win");
    }
    
    /**
     * Converts the given {@link URL} to an {@link File}. The {@link URL} must point to an element inside the local
     * file system. This method should be used to resolve URL given be Eclipse for resolving locally installed
     * resources. This method should be aware of the <b>white space problem</b>, which may occur if working with
     * URIs.
     * @param localURL An url pointing to a local resource, must not be <tt>null</tt>.
     * @return An file object pointing to the same address, which is able to handle white spaces inside the path.
     */
    public static File toFile(URL localURL) {     
        String path = localURL.getPath();
        return new File(path);
    }

}
