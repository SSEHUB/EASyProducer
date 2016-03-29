/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;

/**
 * Defines the generic access to the top-level model. This class is needed as some
 * models and their editors shall be optional.
 * 
 * @author Holger Eichelberger
 */
public class TopLevelModelAccessor {

    private static final Map<String, IModelAccessor<?>> ACCESSORS = new HashMap<String, IModelAccessor<?>>();
    
    /**
     * Defines the interface for the model accessor.
     * 
     * @param <M> the model type
     * @author Holger Eichelberger
     */
    public interface IModelAccessor <M extends IModel > {
        
        /**
         * Accesses the model info. The implementation shall ensure that the returned info contains a resolved model, 
         * if possible.
         * 
         * @param projectName the name of the containing project (EASy convention)
         * @param project an optional instance to access the top level model from some EASy instance
         * @return the model info (may be <b>null</b> if the model does not exist)
         */
        public ModelInfo<M> getModelInfo(String projectName, Object project);
        
        /**
         * Returns the model management instance.
         * 
         * @return the model management instance
         */
        public ModelManagement<M> getModelManagement();
        
        /**
         * Called to register the model loader (optional).
         * 
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void registerLoader(ProgressObserver observer) throws ModelManagementException;

        /**
         * Called to unregister the model loader (optional).
         * 
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void unregisterLoader(ProgressObserver observer) throws ModelManagementException;
        
        /**
         * Called to add a model location (optional).
         * 
         * @param location the location
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void addLocation(File location, ProgressObserver observer) throws ModelManagementException;

        /**
         * Called to remove a model location (optional).
         * 
         * @param location the location
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void removeLocation(File location, ProgressObserver observer) throws ModelManagementException;
        
        /**
         * Returns the name of the path kind to be used. 
         * 
         * @return the name of the path kind
         */
        public String getPathKindHint();
        
    }

    /**
     * Implements the register methods empty.
     * 
     * @param <M> the actual model type
     * @author Holger Eichelberger
     */
    public abstract static class AbstractDefaultModelAccessor<M extends IModel> implements IModelAccessor<M> {

        /**
         * Called to register the model loader (optional).
         * 
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void registerLoader(ProgressObserver observer) throws ModelManagementException {
        }

        /**
         * Called to unregister the model loader (optional).
         * 
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void unregisterLoader(ProgressObserver observer) throws ModelManagementException {
        }
        
        /**
         * Called to add a model location (optional).
         * 
         * @param location the location
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void addLocation(File location, ProgressObserver observer) throws ModelManagementException {
        }

        /**
         * Called to remove a model location (optional).
         * 
         * @param location the location
         * @param observer the progress observer
         * @throws ModelManagementException in case of failures
         */
        public void removeLocation(File location, ProgressObserver observer) throws ModelManagementException {
        }
        
    }
    
    /**
     * Basic implementation of {@link IModelAccessor} performing model loader registration and location registration. 
     * 
     * @param <M> the actual model type
     * @author Holger Eichelberger
     */
    public abstract static class AbstractModelAccessor<M extends IModel> extends AbstractDefaultModelAccessor<M> {

        private IModelLoader<M> loader;
        
        /**
         * Creates a model accessor based on the given model <code>loader</code>.
         * 
         * @param loader the model loader
         */
        protected AbstractModelAccessor(IModelLoader<M> loader) {
            this.loader = loader;
        }
        
        @Override
        public void registerLoader(ProgressObserver observer) throws ModelManagementException {
            getModelManagement().loaders().registerLoader(loader, observer);
        }

        @Override
        public void unregisterLoader(ProgressObserver observer) throws ModelManagementException {
            getModelManagement().loaders().unregisterLoader(loader, observer);
        }

        @Override
        public void addLocation(File location, ProgressObserver observer) throws ModelManagementException {
            getModelManagement().locations().addLocation(location, observer);
        }

        @Override
        public void removeLocation(File location, ProgressObserver observer) throws ModelManagementException {
            getModelManagement().locations().removeLocation(location, observer);
        }
        
    }


    /**
     * Prevents external instantiation.
     */
    private TopLevelModelAccessor() {
    }
    
    /**
     * Registers an accessor via the model file extension / id.
     * 
     * @param extension the model extension
     * @param accessor the model accessor
     */
    public static void register(String extension, IModelAccessor<?> accessor) {
        if (null != extension && null != accessor) {
            ACCESSORS.put(extension, accessor);
        }
    }
    
    /**
     * Removes a registered accessor.
     * 
     * @param extension the model extension / id
     */
    public static void unregister(String extension) {
        if (null != extension) {
            ACCESSORS.remove(extension);
        }
    }
    
    /**
     * Returns the registered accessors.
     * 
     * @return the registered accessors
     */
    public static Iterable<IModelAccessor<?>> registered() {
        return ACCESSORS.values();
    }

    /**
     * Returns the registered accessor for <code>extension</code>.
     * 
     * @param extension the model extension / id
     * @return the registered accessor (may be <b>null</b> if none was registered)
     */
    public static IModelAccessor<?> getAccessor(String extension) {
        return null == extension ? null : ACCESSORS.get(extension);
    }
    
    /**
     * Returns the top-level model info through a registered accessor for <code>extension</code>.
     * 
     * @param extension the model extension / id
     * @param project an optional instance to access the top level model from some EASy instance
     * @param projectName the name of the containing project (EASy convention)
     * @return the registered accessor (may be <b>null</b> if none was registered)
     */
    public static ModelInfo<?> getTopLevelModel(String extension, String projectName, Object project) {
        IModelAccessor<?> accessor = getAccessor(extension);
        return null == accessor ? null : accessor.getModelInfo(projectName, project);
    }

}