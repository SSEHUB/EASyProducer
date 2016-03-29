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
package net.ssehub.easy.basics.modelManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;

/**
 * Supports the transparent registration of models, locations, model loaders etc.
 * This mechanism is intended to simplify the initialization of the runtime library, 
 * which potentially does not contain the language parsers. However, currently, this 
 * mechanism is limited to one location for all models.
 * 
 * @author Holger Eichelberger
 */
public class ModelInitializer {

    private static final List<IModelInitializer> INITIALIZERS = new ArrayList<IModelInitializer>();

    /**
     * Defines the interface of an initializer.
     * 
     * @author Holger Eichelberger
     */
    public interface IModelInitializer {

        /**
         * Adds a model location.
         * 
         * @param location the model location. Basically, this is a folder but for serializers, 
         *     this may be a file.
         * @param observer the progress observer
         * @throws ModelManagementException in case of problems registering the location
         */
        public void addLocation(File location, ProgressObserver observer) throws ModelManagementException;

        /**
         * Adds a model location.
         * 
         * @param location the model location. Basically, this is a folder but for serializers, 
         *     this may be a file.
         * @param observer the progress observer
         * @throws ModelManagementException in case of problems registering the location
         */
        public void removeLocation(File location, ProgressObserver observer) throws ModelManagementException;
        
        /**
         * Registers the default model loader instance.
         *
         * @param observer the progress observer
         * @throws ModelManagementException in case of problems registering the location
         */
        public void registerLoader(ProgressObserver observer) throws ModelManagementException;
        
        /**
         * Unregisters the default model loader.
         * 
         * @param observer the progress observer
         * @throws ModelManagementException in case of problems registering the location
         */
        public void unregisterLoader(ProgressObserver observer) throws ModelManagementException;

    }

    /**
     * Registers a model initializer.
     * 
     * @param initializer the initializer
     */
    public static void register(IModelInitializer initializer) {
        if (null != initializer && !INITIALIZERS.contains(initializer)) {
            INITIALIZERS.add(initializer);
        }
    }

    /**
     * Unregisters a model initializer.
     * 
     * @param initializer the initializer
     */
    public static void unregister(IModelInitializer initializer) {
        if (null != initializer) {
            INITIALIZERS.remove(initializer);
        }
    }

    /**
     * Registers a location via the present model loaders.
     * 
     * @param location the location
     * @param observer the progress observer
     * @throws ModelManagementException in case of problems registering the location
     */
    public static void addLocation(File location, ProgressObserver observer) throws ModelManagementException {
        if (null != location) {
            for (IModelInitializer initializer : INITIALIZERS) {
                initializer.addLocation(location, observer);
            }
        }
    }

    /**
     * Registers a location via the present model loaders.
     * 
     * @param location the location
     * @param observer the progress observer
     * @throws ModelManagementException in case of problems registering the location
     */
    public static void removeLocation(File location, ProgressObserver observer) throws ModelManagementException {
        if (null != location) {
            for (IModelInitializer initializer : INITIALIZERS) {
                initializer.removeLocation(location, observer);
            }
        }
    }
    
    /**
     * Registers a default model loader.
     * 
     * @param observer the progress observer
     * @throws ModelManagementException in case of problems registering the location
     */
    public static void registerLoader(ProgressObserver observer) throws ModelManagementException {
        for (IModelInitializer initializer : INITIALIZERS) {
            initializer.registerLoader(observer);
        }
    }

    /**
     * Registers a default model loader.
     * 
     * @param observer the progress observer
     * @throws ModelManagementException in case of problems registering the location
     */
    public static void unregisterLoader(ProgressObserver observer) throws ModelManagementException {
        for (IModelInitializer initializer : INITIALIZERS) {
            initializer.unregisterLoader(observer);
        }
    }

}