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
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.internal.Bundle;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.IModelLoader.LoadResult;
import net.ssehub.easy.basics.modelManagement.IModelProcessingListener.Type;
import net.ssehub.easy.basics.modelManagement.ModelLocations.Location;
import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.basics.progress.ObservableTask;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.basics.progress.ProgressObserver.ITask;

import static net.ssehub.easy.basics.modelManagement.ModelUpdateUtils.*;

/**
 * A reusable class performing model imports, model linking etc. The central class holding all model 
 * instances and being
 * responsible for import resolution. Model loading is done by plugins of type 
 * {@link IModelLoader}. Public access shall be synchronized (in any way) as multiple
 * source parts and tools may access the information concurrently. Please note that specific
 * information and settings are available via {@link #availableModels()},  
 * {@link #events()}, {@link #loaders()}, {@link #locale()} and {@link #locations()}.
 * The model needs a loader and a location to operate. After providing this 
 * information, available models can be accessed via {@link #availableModels()}.
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public abstract class ModelManagement <M extends IModel> {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ModelManagement.class, Bundle.ID);

    private ModelPaths paths = new ModelPaths();
    private ModelLocale locale = new ModelLocale();

    // required for visiting!
    private List<M> models = new ArrayList<M>();
    
    // temporary information; bad hack as setResolved(null) destroys hints to listeners
    private Set<ModelInfo<M>> outdated = new HashSet<ModelInfo<M>>();

    private AvailableModels<M> availableModels;
    private ModelRepository<M> repository;
    private ModelEvents<M> events = new ModelEvents<M>();
    private ModelLocations<M> locations;
    private ModelLoaders<M> loaders;
    private transient Set<ModelInfo<M>> loading = new HashSet<ModelInfo<M>>();
    private transient boolean inUpdate = false;
    private Pool<ImportResolver<M>> resolverPool; // must not be static, as individual for each model type

    /**
     * Singleton.
     */
    protected ModelManagement() {
        resolverPool = new Pool<ImportResolver<M>>(new IPoolManager<ImportResolver<M>>() {

            @Override
            public ImportResolver<M> create() {
                return createResolver();
            }

            @Override
            public void clear(ImportResolver<M> instance) {
                instance.clear();
            }
            
        });
        repository = new ModelRepository<M>(this);
        availableModels = new AvailableModels<M>(repository);
        locations = new ModelLocations<M>(repository);
        loaders = new ModelLoaders<M>(repository);
    }

    /**
     * Creates a resolver instance.
     * 
     * @return the resolver instance
     */
    protected abstract ImportResolver<M> createResolver();

    /**
     * Provides access to the internationalization mechanisms. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the locale object
     */
    public ModelLocale locale() {
        return locale;
    }

    /**
     * Returns access to the model paths used while loading models. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the model paths object
     */
    public ModelPaths paths() {
        return paths;
    }
    
    /**
     * Provides access to the event mechanisms. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the events object
     */
    public ModelEvents<M> events() {
        return events;
    }

    /**
     * Provides access to the model loaders. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the events object
     */
    public ModelLoaders<M> loaders() {
        return loaders;
    }

    /**
     * Provides access to the model location. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the events object
     */
    public ModelLocations<M> locations() {
        return locations;
    }
    
    /**
     * Returns access to the available models. For future compatibility, 
     * please store the returned instance just for temporary purposes within a method and 
     * not for long-term use in an attribute etc.
     * 
     * @return the model paths object
     */
    public AvailableModels<M> availableModels() {
        return availableModels;
    }
    
    /**
     * Returns the repository instance.
     * 
     * @return the repository instance
     */
    protected ModelRepository<M> repository() {
        return repository;
    }
    
    /**
     * Returns the current top-level resolver.
     * 
     * @return the top-level resolver
     * @see #releaseResolver(ImportResolver)
     */
    public ImportResolver<M> getResolverFromPool() {
        return resolverPool.getInstance();
    }
    
    /**
     * Releases a given resolver instance.
     * 
     * @param resolver the resolver to be released
     * @see #getResolverFromPool()
     */
    public void releaseResolver(ImportResolver<M> resolver) {
        resolverPool.releaseInstance(resolver);
    }
    
    /**
     * Add a model to this management instance. Existing models are overwritten
     * in case of same name and version.
     * 
     * @param model the model to be added
     * @param uri the URI of the model (used for unique identification)
     * @param loader The parser able to load model
     */
    public synchronized void updateModel(M model, URI uri, IModelLoader<M> loader) {
        updateModel(model, uri, loader, true);
    }
    
    /**
     * Add a model to this management instance. Existing models are overwritten
     * in case of same name and version.
     * 
     * @param model the model to be added
     * @param uri the URI of the model (used for unique identification)
     * @param loader The parser able to load model
     * @param deepReload perform a deep reload of the dependent models
     */
    public synchronized void updateModel(M model, URI uri, IModelLoader<M> loader, boolean deepReload) {
        if (null != uri) {
            uri = uri.normalize();
        }
        M oldModel = null;
        List<VersionedModelInfos<M>> vList = availableModels.getAvailable(model.getName());
        VersionedModelInfos<M> vInfos = VersionedModelInfos.find(vList, model.getVersion());
        boolean done = false;
        if (null != vInfos) {
            ModelInfo<M> info = vInfos.find(uri);
            if (null != info) {
                oldModel = setResolved(info, model);
                if (null == info.getLocale()) {
                    info.setLocale(locale.getActualLocale());
                }
                try {
                    postLoadModel(info);
                } catch (IOException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(ModelManagement.class, Bundle.ID).exception(e);
                }
                done = true;
            }
        }
        if (!done) {
            // however, resolution and loading is disabled
            ModelInfo<M> info = new ModelInfo<M>(model, uri, loader);
            oldModel = setResolved(info, model);
            if (null == vList) {
                vList = new ArrayList<VersionedModelInfos<M>>();
                availableModels.putAvailable(model.getName(), vList);
            }
            if (null == vInfos) {
                vInfos = new VersionedModelInfos<M>(model.getVersion());
                vList.add(vInfos);
            }
            vInfos.add(info);
        }
        if (!inUpdate) {
            inUpdate = true;
            if (null != oldModel && deepReload) {
                // TODO turn this into an incremental updated structure -> performance
                reload(determineUpdateSeqence(model, collectImporting(models, addReplacing(oldModel, model))));
            }
            inUpdate = false;
        }
    }

    /**
     * Loads a set of models. Errors are logged.
     * 
     * @param models the models to be (re)loaded (entries may be <b>null</b>)
     */
    private void reload(List<M> models) {
        // strategy: outdate listed models, reload then (still) outdated starting with the top-most one
        for (int m = 0; m < models.size(); m++) {
            M tmp = models.get(m);
            if (null != tmp) {
                setOutdated(models.get(m));
            }
        }
        for (int m = models.size() - 1; m >= 0; m--) {
            M tmp = models.get(m);
            if (null != tmp) {
                if (isOutdated(tmp)) {
                    reload(tmp);
                }
            }
        }
    }

    /**
     * Update the given model by trying to reload it. Errors are logged.
     * 
     * @param model the model to be reloaded
     * @return the loaded model (may be <code>model</code> if no new model was loaded)
     */
    public M reload(M model) {
        return reload(model, false);
    }
    
    /**
     * Update the given model by trying to reload it. Errors are logged.
     * 
     * @param model the model to be reloaded
     * @param deepReload perform a deep reload of the dependent models
     * @return the loaded model (may be <code>model</code> if no new model was loaded)
     */
    public M reload(M model, boolean deepReload) {
        M result = model;
        ModelInfo<M> info = availableModels.getModelInfo(model);
        if (null != info) {
            try {
                result = load(info, true);
                setResolved(info, result);
            } catch (ModelManagementException e) {
                LOGGER.warn("updating model " + info.getName() + " " 
                    + Version.toString(info.getVersion()) + " failed: " + e.getMessage());
            }
        } else {
            LOGGER.warn("updating model: no information object found for " + model.getName() + " " 
                + Version.toString(model.getVersion()) + " (syntax/semantic error?)");
        }
        if (model == result) {
            events.notifyModelReloadFailed(model);
        } else {
            if (null != model && deepReload) {
                // TODO turn this into an incremental updated structure -> performance
                reload(determineUpdateSeqence(result, collectImporting(models, addReplacing(model, result))));
            }
        }
        return result;
    }
    
    /**
     * Unloads <code>model</code> as well as unloadable imported models, but not the related 
     * model information. No events will be sent but event listeners will be cleared.
     * Please note that references within <code>model</code> will not be modified and not managed
     * by this class after calling this method! Please release all references to <code>model</code>
     * after calling this method!
     * 
     * @param model the model to be unloaded
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @return the number of unloaded models
     * @throws ModelManagementException in case that unloading fails
     */
    public synchronized int unload(M model, ProgressObserver observer) 
        throws ModelManagementException {
        ITask task = observer.registerTask("unload model");
        observer.notifyStart(task, 2 + models.size());
        int step = 0;
        
        HashSet<M> toUnload = new HashSet<M>();

        // determine all imports (recursively, loop-free)
        HashSet<M> tmpImported = new HashSet<M>();
        HashSet<M> allUnloads = new HashSet<M>();
        Utils.enumerateImported(model, allUnloads, null);
        observer.notifyProgress(task, step++);
        // save allUnloads as marker, toUnload as copy will be reduced to actually unloadable models
        toUnload.addAll(allUnloads);
        // consider all models, determine imports, reduce duplicates as used
        int modelsCount = models.size();
        for (int p = 0; p < modelsCount; p++) {
            M tmp = models.get(p);
            if (!allUnloads.contains(tmp)) {
                Utils.enumerateImported(tmp, tmpImported, toUnload);
                tmpImported.clear();
                observer.notifyProgress(task, step++);
            }
        }
        allUnloads.clear(); // cleanup
        
        int count = 0;
        // unload models - from models list, from event mechanism, from resolved models
        for (M p : toUnload) {
            unloadImpl(p);
            count++;
        }
        observer.notifyProgress(task, step++);
        observer.notifyEnd(task);
        return count;
    }

    /**
     * Unloads a certain model.
     * 
     * @param model the model to unload
     */
    private void unloadImpl(M model) {
        models.remove(model);
        events.removeAllListeners(model);
        List<ModelInfo<M>> info = availableModels.getModelInfos(model);
        if (null != info) {
            int size = info.size();
            for (int i = 0; i < size; i++) {
                ModelInfo<M> pInfo = info.get(i);
                // no early termination just to be sure
                if (pInfo.getResolved() == model) {
                    pInfo.setResolved(null);
                }
            }
        }        
    }
    
    /**
     * Add a model to this management instance. Existing models are overwritten
     * in case of same name and version.
     * 
     * @param model the model to be added
     * @param uri the URI of the model (used for unique identification)
     */
    public synchronized void updateModel(M model, URI uri) {
        updateModel(model, uri, null);
    }
    
    /**
     * Defines the resolution for <code>info</code> and calls the listeners.
     * Calls {@link IModel#dispose()} if needed.
     * 
     * @param info the information object to be updated
     * @param model the resolving model
     * @return the old model, before replaced by <code>model</code> (may be <b>null</b> if inconsistent
     * or not yet loaded)
     */
    private M setResolved(ModelInfo<M> info, M model) {
        M current = info.getResolved();
        info.setResolved(model);
        outdated.remove(info);
        int pos = null == current ? -1 : models.indexOf(current);
        if (pos >= 0) {
            models.set(pos, model);
            if (model != current) { // might be used before but disturbs existing behavior
                current.dispose();
            }
        } else {
            models.add(model);    
        }
        events.notifyModelReplacement(current, model);
        return current;
    }
    
    /**
     * Returns the number of (known) models.
     * 
     * @return the number of models
     */
    public synchronized int getModelCount() {
        return models.size();
    }
    
    /**
     * Returns the specified model.
     * 
     * @param index the 0-based index of the model
     * @return the model
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;=0 || index&gt;={@link #getModelCount()}</code>
     */
    public synchronized M getModel(int index) {
        return models.get(index);
    }
    
    /**
     * Resolves the imports of the given <code>model</code> with transitive loading and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all. May modify <code>model</code>
     * as a side effect. This method uses a new default import resolver.
     * 
     * @param model the model to be resolved
     * @param uri the URI of the model to resolve (in order to find the closest 
     *   model, may be <b>null</b>)
     * @param inProgress the model information objects of the models currently being 
     *   processed at once (may be <b>null</b>)  
     * @return messages which occur during resolution, <code>null</code> or empty if none
     */
    public synchronized List<IMessage> resolveImports(M model, URI uri, List<ModelInfo<M>> inProgress) {
        return resolveImports(model, uri, inProgress, true);
    }

    /**
     * Resolves the imports of the given <code>model</code> and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all. May modify <code>model</code>
     * as a side effect. This method uses a new default import resolver.
     * 
     * @param model the model to be resolved
     * @param uri the URI of the model to resolve (in order to find the closest 
     *   model, may be <b>null</b>)
     * @param inProgress the model information objects of the models currently being 
     *   processed at once (may be <b>null</b>)  
     * @param transitiveLoading with or without transitive loading (see {@link ImportResolver})
     * @return messages which occur during resolution, <code>null</code> or empty if none
     */
    public synchronized List<IMessage> resolveImports(M model, URI uri, List<ModelInfo<M>> inProgress, 
        boolean transitiveLoading) {
        ImportResolver<M> resolver = getResolverFromPool();
        resolver.setTransitiveLoading(transitiveLoading); // set back by release 
        List<IMessage> result = resolver.resolveImports(model, uri, inProgress, repository, 
            model.getRestrictionEvaluationContext());
        releaseResolver(resolver);
        return result;
    }
    
    /**
     * Resolves the imports of the given <code>model</code> with transitive loading and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all. May modify <code>model</code>
     * as a side effect.
     * 
     * @param model the model to be resolved
     * @param uri the URI of the model to resolve (in order to find the closest 
     *   model, may be <b>null</b>)
     * @param inProgress the model information objects of the models currently being 
     *   processed at once (may be <b>null</b>)
     * @param resolver the import resolver (may be <b>null</b> to use a new default import resolver)  
     * @return messages which occur during resolution, <code>null</code> or empty if none
     */
    public synchronized List<IMessage> resolveImports(M model, URI uri, List<ModelInfo<M>> inProgress, 
        ImportResolver<M> resolver) {
        return resolveImports(model, uri, inProgress, resolver, true);
    }
    
    /**
     * Resolves the imports of the given <code>model</code> and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all. May modify <code>model</code>
     * as a side effect.
     * 
     * @param model the model to be resolved
     * @param uri the URI of the model to resolve (in order to find the closest 
     *   model, may be <b>null</b>)
     * @param inProgress the model information objects of the models currently being 
     *   processed at once (may be <b>null</b>)
     * @param resolver the import resolver (may be <b>null</b> to use a new default import resolver)
     * @param transitiveLoading with or without transitive loading (see {@link ImportResolver})  
     * @return messages which occur during resolution, <code>null</code> or empty if none
     */
    public synchronized List<IMessage> resolveImports(M model, URI uri, List<ModelInfo<M>> inProgress, 
        ImportResolver<M> resolver, boolean transitiveLoading) {
        List<IMessage> result;
        if (null == resolver) {
            result = resolveImports(model, uri, inProgress, transitiveLoading);
        } else {
            boolean old = resolver.setTransitiveLoading(transitiveLoading);
            result = resolver.resolveImports(model, uri, inProgress, repository, 
                model.getRestrictionEvaluationContext());
            resolver.setTransitiveLoading(old);
        }
        return result;
    }

    /**
     * Resolves the denoted model considering the given <code>restrictions</code>. This method uses a new default 
     * import resolver.
     * 
     * @param modelName the name of the model
     * @param restriction the restriction (may be <b>null</b> if there is none)
     * @param baseURI the URI where to start the resolution at (may be an existing model)
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @return the resolved model
     * @throws ModelManagementException in case of resolution failures
     */
    public synchronized M resolve(String modelName, IVersionRestriction restriction, URI baseURI, 
        IRestrictionEvaluationContext evaluationContext) throws ModelManagementException {
        ImportResolver<M> resolver = getResolverFromPool();
        M result = resolver.resolve(modelName, restriction, baseURI, repository, evaluationContext);
        releaseResolver(resolver);
        return result;
    }

    /**
     * Loads the model related to <code>info</code> with a new default import resolver.
     * 
     * @param info the model info to load the model for
     * @param messages the messages collected so far (modified as a side effect)
     * @return the loaded model or <b>null</b>
     */
    M load(ModelInfo<M> info, List<IMessage> messages) {
        return load(info, null, messages);
    }
    
    /**
     * Loads the model related to <code>info</code>.
     * 
     * @param info the model info to load the model for
     * @param resolver the resolver to use (<b>null</b> for a new default import resolver)
     * @param messages the messages collected so far (modified as a side effect)
     * @return the loaded model or <b>null</b>
     */
    M load(ModelInfo<M> info, ImportResolver<M> resolver, List<IMessage> messages) {
        M result = null;
        IModelLoader<M> loader = info.getLoader();
        if (null == loader) {
            loader = loaders.getDefaultLoader();
        }
        if (null != loader) { // do not use isActual here
            notifyLoading(info, true);
            LoadResult<M> loadResult = loader.load(info, resolver);
            notifyLoading(info, false);
            if (loadResult.getModelCount() > 0 && 0 == loadResult.getErrorCount()) {
                for (int i = 0; i < loadResult.getModelCount(); i++) {
                    M model = loadResult.getModel(i);
                    // load and assign descriptive texts
                    info.setLocale(locale.getActualLocale());
                    try {
                        postLoadModel(info);
                    } catch (IOException e) {
                        messages.add(new Message("while post loading model: " + e.getMessage(), Status.WARNING));
                    }
                    if (null == result && Utils.matches(model, info)) {
                        setResolved(info, model);
                        result = model;
                    }
                }
            } 
            for (int m = 0; m < loadResult.getMessageCount(); m++) {
                messages.add(loadResult.getMessage(m));
            }
        } else {
            messages.add(new Message("loader for model '" + info.getName() + "' is undefined", Status.ERROR));
        }
        return result;
    }
    
    /**
     * Handles the notification about model loading.
     * 
     * @param info the information object to notify about
     * @param started <code>true</code> if loading started, <code>false</code> else
     */
    private void notifyLoading(ModelInfo<M> info, boolean started) {
        if (started) {
            loading.add(info);
        } else {
            loading.remove(info);
        }
        events().notifyModelProcessing(info, started, Type.LOADING);
    }

    /**
     * Returns whether loading the model for <code>info</code>is currently happening.
     * 
     * @param info the information object to look for
     * @return <code>true</code> if loading is currently in progress, <code>false</code> else 
     * @see IModelProcessingListener
     */
    public boolean isLoading(ModelInfo<M> info) {
        return loading.contains(info);
    }
    
    /**
     * Returns whether loading a model from <code>location</code> is currently happening.
     * 
     * @param location the location to look for
     * @return <code>true</code> if loading is currently in progress, <code>false</code> else
     * @see IModelProcessingListener
     */
    public boolean isLoading(URI location) {
        boolean result = false;
        if (null != location) {
            ModelInfo<M> info = availableModels().getInfo(location);
            if (null != info) {
                result = isLoading(info);
            }
        }
        return result;
    }

    /**
     * Additional code to be executed after a model was loaded. 
     * 
     * @param info the information object describing the model
     * @throws IOException in case that loading fails - however, model loading will not fail
     */
    protected void postLoadModel(ModelInfo<M> info) throws IOException {
    }

    /**
     * Loads the specified model and resolves its imports. Be careful when calling
     * this method from inside this class as it automatically resolves
     * the imports. Loading an already loaded model does not cause physical 
     * reloading but returns the cached model contents.
     * 
     * @param info the information object of the model to load
     * @return the loaded model
     * @throws ModelManagementException in case of any error during loading <code>info</code>
     */
    public synchronized M load(ModelInfo<M> info) throws ModelManagementException {
        return load(info, false);
    }
    
    /**
     * Updates the model information in <code>file</code>.
     * 
     * @param file the location folder to search
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to this update
     */
    public synchronized void updateModelInformation(File file, ProgressObserver observer) 
        throws ModelManagementException {
        ModelInfoHolder<M> holder = new ModelInfoHolder<M>(availableModels);
        updateModelInformation(file, holder, observer, null);
    }
    
    
    /**
     * Updates the model information in all known locations.
     * 
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to this update
     */
    public synchronized void updateModelInformation(ProgressObserver observer) throws ModelManagementException {
        ModelInfoHolder<M> holder = new ModelInfoHolder<M>(availableModels);
        ITask task = observer.registerTask("update model model information");
        observer.notifyStart(task, locations.getLocationCount());
        Set<Location> done = new HashSet<Location>();
        for (int l = 0; l < locations.getLocationCount(); l++) {
            updateModelInformation(locations.getLocation(l), holder, observer, task, done);
            observer.notifyProgress(task, l);
        }
        observer.notifyEnd(task);
    }
    
    /**
     * Updates the model information in the given <code>location</code> and the dependent locations.
     * 
     * @param location the location to update the information for
     * @param holder the combined information and result collection instance
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @param task the task to run in (may be <b>null</b> in order to start a new task)
     * @param done already processed locations (in order to avoid cycles)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to this update
     */
    private void updateModelInformation(Location location, ModelInfoHolder<M> holder, ProgressObserver observer, 
        ITask task, Set<Location> done) throws ModelManagementException  {
        if (!done.contains(location)) {
            done.add(location);
            updateModelInformation(location.getLocation(), holder, observer, task);
            for (int d = 0; d < location.getDependentLocationCount(); d++) {
                updateModelInformation(location.getDependentLocation(d), holder, observer, task, done);
            }
        }
    }

    // ----------------------- package local functionality needed by ModelRepository ------------

    /**
     * Registers a model loader and updates the model information
     * provided by the loader.
     * 
     * @param loader the model loader (must not be <b>null</b>)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the <code>loader</code> aims at loading 
     *   inconsistent information
     */
    synchronized void updateForLoader(IModelLoader<M> loader, ProgressObserver observer) 
        throws ModelManagementException {
        StringBuilder errors = new StringBuilder();
        ModelInfoHolder<M> holder = new ModelInfoHolder<M>(availableModels);
        ObservableTask task = new ObservableTask("register model loader", 
            locations.countFilesInLocations(), observer);
        int locationsCount = locations.getLocationCount();
        if (locationsCount > 0) {
            Set<Location> done = new HashSet<Location>();
            for (int l = 0; l < locationsCount; l++) {
                updateForLoader(locations.getLocation(l), loader, holder, task, done);
            }
        }
        Utils.appendErrors(errors, updateAvailableModels(holder));
        task.notifyEnd();
        if (errors.length() > 0) {
            throw new ModelManagementException(
                "inconsistencies in model information (location, model loader) for: " 
                + errors, ModelManagementException.MODEL_INFO_INCONSISTENCY);
        }
    }
    
    /**
     * Updates <code>location</code> via <code>loader</code>.
     * 
     * @param location the location to be updated
     * @param holder the combined information and result collection instance
     * @param loader the specific loader to consider (may be <b>null</b>)
     * @param task the task to be informed
     * @param done already processed locations in order to prevent loops
     */
    private void updateForLoader(Location location, IModelLoader<M> loader, ModelInfoHolder<M> holder, 
        ObservableTask task, Set<Location> done) {
        if (!done.contains(location)) {
            done.add(location);
            Set<File> fileDone = new HashSet<File>();
            locations.scan(location.getLocation(), holder, loader, task, fileDone);
            for (int d = 0; d < location.getDependentLocationCount(); d++) {
                updateForLoader(location.getDependentLocation(d), loader, holder, task, done); 
            }
        }
    }

    /**
     * Removes a file location, i.e. a location from where models can be loaded.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     */
    synchronized void clearLocation(File file, ProgressObserver observer) {
        if (null != file) {
            URI uri = file.toURI().normalize();
            List<ModelInfo<M>> infos = new ArrayList<ModelInfo<M>>();
            Utils.collectModelInfo(availableModels.versionedModelInfos(), infos, null);
            for (int i = 0; i < infos.size(); i++) {
                ModelInfo<M> info = infos.get(i);
                if (info.isContainedIn(uri)) {
                    List<VersionedModelInfos<M>> vInfos = availableModels.getAvailable(info.getName());
                    VersionedModelInfos<M> vInfo = VersionedModelInfos.find(vInfos, info.getVersion());
                    if (null != vInfo) {
                        vInfo.remove(info);
                    }
                    M resolved = info.getResolved();
                    if (null != resolved) {
                        models.remove(resolved);
                        events.removeAllListeners(resolved);
                        resolved.dispose();
                    }
                    if (vInfos.isEmpty()) {
                        availableModels.removeAvailable(info.getName());
                    }
                }
            }
            try {
                locations.removeLocationFor(file);
            } catch (ModelManagementException e) {
                // ignore
            }
        }
    }
    
    /**
     * Returns models available for a given model <code>name</code>.
     * 
     * @param name the name to search for
     * 
     * @return the available modelss or <b>null</b>
     */
    public List<VersionedModelInfos<M>> getAvailable(String name) {
        return availableModels.getAvailable(name);
    }

    // --------------------------- internal funtionality -----------------------
    
    /**
     * Updates the list of available models.
     * 
     * @param holder the instance containing the results
     * @return an empty string if the update was available, information about inconsistencies else
     */
    private String updateAvailableModels(ModelInfoHolder<M> holder) {
        String result = "";
        if (null != holder) {
            StringBuilder errors = new StringBuilder();
            for (int i = 0; i < holder.getResultCount(); i++) {
                ModelInfo<M> info = holder.getResult(i);
                if (availableModels.updateAvailableModel(info)) {
                    if (errors.length() > 0) {
                        errors.append(", ");
                    }
                    errors.append(info.nameVersionToString());
                }
            }
            if (errors.length() > 0) {
                result = errors.toString();
            }
        }
        return result;
    }

    /**
     * Updates the model information in <code>file</code> considering <code>known</code>.
     * 
     * @param file the location to search
     * @param holder the combined information and result collection instance
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @param task the task to run in (may be <b>null</b> in order to start a new task)
     * @throws ModelManagementException in case of model information inconsistencies
     */
    private void updateModelInformation(File file, ModelInfoHolder<M> holder, ProgressObserver observer, 
        ITask task) throws ModelManagementException {
        StringBuilder errors = new StringBuilder();
        
        // update model information objects by adding unknown ones
        ObservableTask subtask = new ObservableTask("update model information", 
            locations.countFilesInLocations(), observer, task);
        Set<File> done = new HashSet<File>();
        locations.scan(file, holder, null, subtask, done);
        done = null; // release
        Utils.appendErrors(errors, updateAvailableModels(holder));
        subtask.notifyEnd();
        
        // clean and reload recently updated models, i.e. collect model information
        // for fast access, selected outdated, augment the outdated by their depending/importing
        // models, determine the topLevel models, invalidate all outdated,
        // load and resolve top-level again (including invalidated depending models)
        URI uri = file.toURI().normalize();
        List<ModelInfo<M>> allInfos = new ArrayList<ModelInfo<M>>();
        Map<M, ModelInfo<M>> modelInfoMap = new HashMap<M, ModelInfo<M>>();
        // allInfos and modelInfoMap could be determined in the calling method
        // to increase efficiency
        Utils.collectModelInfo(availableModels.versionedModelInfos(), allInfos, modelInfoMap);
        List<ModelInfo<M>> outdated = ModelInfo.selectOutdated(allInfos, true, uri);
        List<ModelInfo<M>> topLevel = Utils.augmentByDepending(outdated, allInfos, modelInfoMap);
        for (int o = 0; o < outdated.size(); o++) {
            ModelInfo<M> info = outdated.get(o);
            M resolved = info.getResolved();
            if (null != resolved) {
                models.remove(resolved);
                this.outdated.add(outdated.get(o));
                //outdated.get(o).setResolved(null);
                resolved.dispose();
            }
        }
        subtask = new ObservableTask("update outdated models", 
                topLevel.size(), observer, task);
        for (int o = 0; o < topLevel.size(); o++) {
            try {
                load(topLevel.get(o), true); // load and (!) resolve imports
            } catch (ModelManagementException e) {
                Utils.appendErrors(errors, e.getMessage());
            }
            subtask.notifyProgress();
        }
        // ensure clean up outdated
        for (int o = 0; o < outdated.size(); o++) {
            ModelInfo<M> info = outdated.get(o);
            this.outdated.remove(info);
        }
        subtask.notifyEnd();
        if (errors.length() > 0) {
            throw new ModelManagementException(
                "inconsistencies in model information (location, model loader) for: " 
                + errors, ModelManagementException.MODEL_INFO_INCONSISTENCY);
        }
    }

    /**
     * Loads the specified model and resolves its imports by calling 
     * {@link #resolveImports}. Be careful when calling
     * this method from inside this class as it automatically resolves
     * the imports. Loading an already loaded model does not cause physical 
     * reloading but returns the cached model contents.
     * 
     * @param info the information object of the model to load
     * @param force load anyway
     * @return the loaded model
     * @throws ModelManagementException in case of any error during loading <code>info</code>
     */
    private synchronized M load(ModelInfo<M> info, boolean force) throws ModelManagementException {
        if (null == info) {
            // shall be an IllegalArgumentException but this way may help EASy
            throw new ModelManagementException("model info must not be null", ModelManagementException.INTERNAL);
        }
        M result = info.getResolved();
        boolean reload = force || outdated.contains(info) || info.isOutdated();
        if (null == result || reload) {
            ArrayList<IMessage> messages = new ArrayList<IMessage>();
            if (!info.isResolved() || reload) {
                result = load(info, messages);
                if (null != result) {
                    List<IMessage> rmessages = resolveImports(result, info.getLocation(), null);
                    if (null != rmessages) {
                        messages.addAll(rmessages);
                    }
                }
                if (messages.size() > 0) {
                    int errorCount = 0;
                    StringBuilder builder = new StringBuilder();
                    for (int m = 0; m < messages.size(); m++) {
                        IMessage message = messages.get(m);
                        if (builder.length() > 0) {
                            builder.append("\n");
                        }
                        builder.append(message.getDescription());
                        if (Status.ERROR == message.getStatus() 
                            || Status.UNSUPPORTED == message.getStatus()) {
                            errorCount++;
                        }
                    }
                    if (errorCount > 0) {
                        throw new ModelManagementException(builder.toString(), 
                             ModelManagementException.MODEL_LOAD_FAILURE);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Clears <code>model</code> from the caches. Please handle with care.
     * 
     * @param model the model to be cleared
     */
    public void clearModel(M model) {
        if (null != model) {
            clearModel(availableModels.getModelInfo(model));
        }
    }
    

    /**
     * Clears <code>info</code> (and the related model) from the caches. Please handle with care.
     * 
     * @param info the info to be cleared
     */
    public void clearModel(ModelInfo<M> info) {
        if (null != info) {
            M model = info.getResolved();
            if (null != model) {
                models.remove(model);
            }
            availableModels.removeAvailable(info);
        }
    }

    /**
     * Unresolves all models / forces reload.
     */
    public void outdateAll() {
        for (M model : models) {
            ModelInfo<M> info = availableModels.getModelInfo(model);
            if (null != info) {
                outdated.add(info);
            }
        }
    }

    /**
     * Returns whether a model is outdated (will force a reload upon {@link #load(ModelInfo)}).
     * 
     * @param model the model to be tested (may be <b>null</b>)
     * @return <code>true</code> if it is outdated, <code>false</code> else
     */
    public boolean isOutdated(M model) {
        return isOutdated(availableModels.getModelInfo(model));
    }
    
    /**
     * Returns whether a model information is outdated (will force a reload upon {@link #load(ModelInfo)}).
     * 
     * @param info the object to be tested (may be <b>null</b>)
     * @return <code>true</code> if it is outdated, <code>false</code> (also for <code>info==<b>null</b></code>) else
     */
    public boolean isOutdated(ModelInfo<M> info) {
        return null == info ? false : outdated.contains(info);
    }

    /**
     * Declears a model as outdated (will force a reload upon {@link #load(ModelInfo)}).
     * 
     * @param model the model to be tested (may be <b>null</b>)
     */
    public void setOutdated(M model) {
        setOutdated(availableModels.getModelInfo(model));
    }
    
    /**
     * Returns whether a model information is outdated.
     * 
     * @param info the object to be tested (may be <b>null</b>)
     */
    public void setOutdated(ModelInfo<M> info) {
        if (null != info) {
            outdated.add(info);
        }
    }

}
