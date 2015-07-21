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
package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;

import de.uni_hildesheim.sse.utils.modelManagement.ModelInitializer.IModelInitializer;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Implements an abstract model initializer for the language parsers.
 * 
 * @param <M> the model type
 * @author Holger Eichelberger
 */
public abstract class AbstractModelInitializer<M extends IModel> implements IModelInitializer {

    /**
     * Returns the actual model management instance.
     * 
     * @return the model management instance
     */
    protected abstract ModelManagement<M> getModelManagement();
    
    /**
     * Returns the actual model loader.
     * 
     * @return the model loader (may be <b>null</b> if registration of the loader is done differently)
     */
    protected abstract IModelLoader<M> getModelLoader();
    
    /**
     * Strips the file and turns it to the containing folder.
     * 
     * @param file the file to be stripped
     * @return the containing folder in case of a file, <code>file</code> else
     */
    public static File stripFile(File file) {
        if (file.isFile()) {
            file = file.getParentFile();
        }
        return file;
    }
    
    @Override
    public void addLocation(File location, ProgressObserver observer) throws ModelManagementException {
        getModelManagement().locations().addLocation(stripFile(location), observer);
    }

    @Override
    public void removeLocation(File location, ProgressObserver observer) throws ModelManagementException {
        getModelManagement().locations().removeLocation(stripFile(location), observer);
    }

    @Override
    public void registerLoader(ProgressObserver observer) throws ModelManagementException {
        IModelLoader<M> loader = getModelLoader();
        if (null != loader) {
            getModelManagement().loaders().registerLoader(loader, observer);
        }
    }

    @Override
    public void unregisterLoader(ProgressObserver observer) throws ModelManagementException {
        IModelLoader<M> loader = getModelLoader();
        if (null != loader) {
            getModelManagement().loaders().unregisterLoader(loader, observer);
        }
    }

}
