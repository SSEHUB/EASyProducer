/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
 * The EASy Loader interface.
 * 
 * @author Holger Eichelberger
 */
public interface ILoader {

    /**
     * Performs EASy startup activities.
     */
    public void startup();

    /**
     * Performs EASy shutdown activities.
     */
    public void shutdown();
    
    /**
     * Changes the verbosity mode.
     * 
     * @param verbose shall we be verbose?
     */
    public void setVerbose(boolean verbose);
    
    /**
     * Sets the class loader for loading EASy bundles. By default, the class loader of the implementing
     * class is used.
     * 
     * @param loader the loader, ignored if <b>null</b> 
     */
    public void setLoader(ClassLoader loader);

}
