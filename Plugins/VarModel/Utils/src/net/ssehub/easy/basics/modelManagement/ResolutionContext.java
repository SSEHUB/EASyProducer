/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.modelManagement.ModelLocations.Location;

/**
 * Defines an internal class representing the context of a model import resolution.
 *  
 * @param <M> the specific model type
 * @author Holger Eichelberger
 */
class ResolutionContext <M extends IModel> {
    
    private String modelName;
    private IModelRepository<M> repository;
    private M model;
    private ModelImport<M> toResolve;
    private URI modelUri;
    private List<ModelInfo<M>> inProgress;
    private IRestrictionEvaluationContext evaluationContext;
    private List<ModelImport<M>> conflicts;
    private boolean topLevel = true;
    private List<String> modelLocationPrefixes;
    
    /**
     * Creates a resolution context.
     * 
     * @param model the model for which the import resolution happens
     * @param modelUri the URI to <code>model</code> (may be <b>null</b>)
     * @param context the parent contexts
     */
    public ResolutionContext(M model, URI modelUri, ResolutionContext<M> context) {
        this(model, modelUri, context.inProgress, context.repository, context.evaluationContext);
        this.topLevel = false;
    }
    
    /**
     * Creates a resolution context.
     * 
     * @param model the model for which the import resolution happens
     * @param modelUri the URI to <code>model</code> (may be <b>null</b>)
     * @param inProgress the models being processed at once with <code>model</code> (may be <b>null</b>)
     * @param repository the model repository
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @see #collectLocationPrefixes()
     */
    public ResolutionContext(M model, URI modelUri, List<ModelInfo<M>> inProgress, 
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext) {
        this.model = model;
        this.modelUri = modelUri;
        this.inProgress = inProgress;
        this.repository = repository;
        this.evaluationContext = evaluationContext;
        collectLocationPrefixes();
    }
    
    /**
     * Creates a resolution context for resolving a model by name.
     * 
     * @param modelName the name of the model to resolve
     * @param baseUri the URI where to start the resolution from (may be a model URI)
     * @param repository the model repository
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @see #collectLocationPrefixes()
     */
    public ResolutionContext(String modelName, URI baseUri, IModelRepository<M> repository, 
        IRestrictionEvaluationContext evaluationContext) {
        this.modelName = modelName;
        this.modelUri = baseUri;
        this.inProgress = null;
        this.repository = repository;
        this.evaluationContext = evaluationContext;
        collectLocationPrefixes();
    }
    
    /**
     * Collects/caches the model location prefixes for filtering.
     */
    private void collectLocationPrefixes() {
        if (null != modelUri) {
            modelLocationPrefixes = new ArrayList<>();
            Location modelLocation = getModelRepository().getLocationFor(getModelURI());
            if (modelLocation != null) {
                while (modelLocation.getDepending() != null) {
                    modelLocation = modelLocation.getDepending();
                }
                collectLocationPrefixes(modelLocationPrefixes, modelLocation);
            }
        }
    }
    
    /**
     * Changes the actual import for resolution.
     * 
     * @param toResolve the actual import
     */
    public void setToResolve(ModelImport<M> toResolve) {
        this.toResolve = toResolve;
    }
    
    /**
     * Returns the actual import for resolution.
     * 
     * @return the actual import
     */
    public ModelImport<M> getToResolve() {
        return toResolve;
    }
    
    /**
     * Returns the URI to {@link #model}.
     * 
     * @return the URI (may be <b>null</b>)
     */
    public URI getModelURI() {
        return modelUri;
    }
    
    /**
     * Returns the model defining the context.
     * 
     * @return the model
     */
    public M getModel() {
        return model;
    }
    
    /**
     * Returns the name of the model to resolve.
     * 
     * @return the name of the model
     */
    public String getModelName() {
        return null != modelName ? modelName : model.getName();
    }
    
    /**
     * Returns the model repository.
     * 
     * @return the model repository
     */
    public IModelRepository<M> getModelRepository() {
        return repository;
    }
    
    /**
     * Returns the model paths.
     * 
     * @return the model paths
     */
    public List<String> getModelPaths() {
        List<String> result = null;
        URI uri = getModelURI();
        if (null != uri) {
            Location location = repository.getLocationFor(uri);
            if (null != location && location.getDependentLocationCount() > 0) {
                result = new ArrayList<String>();
                Set<Location> done = new HashSet<Location>();
                enumerateDependent(location, result, done);
            }
        }
        return result;
    }
    
    /**
     * Enumerate the dependent locations in terms of model paths.
     * 
     * @param location the location to enumerate
     * @param results the resulting model paths (modified as a side effect)
     * @param done the already processed locations in order to avoid cycles
     */
    private void enumerateDependent(Location location, List<String> results, Set<Location> done) {
        if (!done.contains(location)) {
            if (!done.isEmpty()) { // do not add top-level location
                results.add(location.getLocation().toURI().toString());
            }
            done.add(location);
            for (int d = 0; d < location.getDependentLocationCount(); d++) {
                enumerateDependent(location.getDependentLocation(d), results, done);
            }
        }
    }
    
    /**
     * Returns whether loading <code>info</code> would cause in infinite
     * loop in type resolution as it is currently being processed in the
     * same resolution context.
     * 
     * @param info the information object to be checked
     * @return <code>true</code> if it would cause a loop, <code>false</code> else
     */
    public boolean isLoop(ModelInfo<M> info) {
        boolean isLoop = false;
        if (null != inProgress) {
            int size = inProgress.size();
            for (int i = 0; !isLoop && i < size; i++) {
                isLoop = Utils.matches(info, inProgress.get(i));
            }
        }
        return isLoop;
    }
    
    /**
     * Returns the evaluation context for version restrictions.
     * 
     * @return the evaluation context
     */
    public IRestrictionEvaluationContext getEvaluationContext() {
        return evaluationContext;
    }

    /**
     * Initializes the conflicts set if required.
     */
    private void lazyInitConflicts() {
        if (null == conflicts) {
            conflicts = new ArrayList<ModelImport<M>>();
        }
    }

    /**
     * Adds all conflicts of the given <code>context</code>.
     * 
     * @param context the context to consider
     */
    public void addConflicts(ResolutionContext<M> context) {
        if (null != context.conflicts) {
            lazyInitConflicts();
            addConflicts(conflicts, context.conflicts);
        }
    }
    
    /**
     * Adds the given <code>toAdd</code> conflicts to <code>conflicts</code>. <code>conflicts</code> may be
     * <b>null</b> and is created then lazily.
     * 
     * @param <M> the type of models
     * @param conflicts the conflicts set to add the <code>toAdd</code> conflicts to
     * @param toAdd the conflicts to be added
     * @return <code>conflicts</code> if not <b>null</b>, a new list otherwise
     */
    public static <M extends IModel> List<ModelImport<M>> addConflicts(List<ModelImport<M>> conflicts, 
        List<ModelImport<M>> toAdd) {
        if (null != toAdd) {
            if (null == conflicts) {
                conflicts = new ArrayList<ModelImport<M>>();
            }
            if (conflicts.isEmpty()) {
                conflicts.addAll(toAdd);
            } else {
                Set<ModelImport<M>> present = new HashSet<ModelImport<M>>();
                for (int c = 0, n = conflicts.size(); c < n; c++) {
                    present.add(conflicts.get(c));
                }
                for (int c = 0, n = toAdd.size(); c < n; c++) {
                    ModelImport<M> imp = toAdd.get(c);
                    if (!present.contains(imp)) {
                        conflicts.add(imp);
                    }
                }
                
            }
        }
        return conflicts;
    }


    /**
     * Adds a single conflict to the conflict set of this resolution context.
     * 
     * @param conflict the conflict
     */
    public void addConflict(ModelImport<M> conflict) {
        if (conflict.isConflict()) {
            lazyInitConflicts();
            conflicts.add(conflict);
        }
    }

    /**
     * Returns the first conflict <code>model</code> and its (recursive) imports have with the conflict import 
     * statements collected in this context.
     * 
     * @param model the model information to search for
     * @return the first conflict or <b>null</b> if there is none
     * @throws RestrictionEvaluationException in case of evaluation problems
     */
    public ModelImport<M> getConflict(M model) throws RestrictionEvaluationException {
        return getConflict(model, new HashSet<M>());
    }

    /**
     * Returns the first conflict <code>model</code> and its (recursive) imports have with the conflict import 
     * statements collected in this context.
     * 
     * @param model the model information to search for (may be <b>null</b>
     * @param done the models visited so far (cycle check)
     * @return the first conflict or <b>null</b> if there is none
     * @throws RestrictionEvaluationException in case of evaluation problems
     */
    private ModelImport<M> getConflict(M model, Set<M> done) throws RestrictionEvaluationException {
        ModelImport<M> result = null;
        if (null != model) {
            if (!done.contains(model)) {
                done.add(model);
                result = getConflict(model.getName(), model.getVersion());
                for (int i = 0; null == result && i < model.getImportsCount(); i++) {
                    @SuppressWarnings("unchecked")
                    ModelImport<M> imp = (ModelImport<M>) model.getImport(i);
                    if (!imp.isConflict() && null != imp.getResolved()) {
                        result = getConflict(imp.getResolved(), done);
                    }
                }
            }
        }
        return result;
    }


    /**
     * Returns the first conflict the described model has with the conflict import statements collected in this context.
     * 
     * @param modelName the name of the model
     * @param version the version of the model (may be <b>null</b>)
     * @return the first conflict or <b>null</b> if there is none
     * @throws RestrictionEvaluationException in case of evaluation problems
     */
    private ModelImport<M> getConflict(String modelName, Version version) throws RestrictionEvaluationException {
        ModelImport<M> result = null;
        if (null != conflicts) {
            for (int c = 0, n = conflicts.size(); null == result && c < n; c++) {
                ModelImport<M> tmp = conflicts.get(c);
                if (modelName.equals(tmp.getName())) {
                    if (tmp.evaluateRestrictions(evaluationContext, version)) {
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }
   
    /**
     * Returns whether <code>info</code> has a conflict with the conflict import statements collected in this context.
     * 
     * @param info the model information to search for
     * @return if <code>context</code> implies conflicts on <code>model</code>
     * @throws RestrictionEvaluationException in case of evaluation problems
     */
    public boolean isConflict(ModelInfo<M> info) throws RestrictionEvaluationException {
        return null != getConflict(info.getName(), info.getVersion());
    }
    
    /**
     * Returns whether this is a top-level or a recursively used context.
     * 
     * @return <code>true</code> for top-level, <code>false</code> else
     */
    public boolean isTopLevel() {
        return topLevel;
    }
    
    /**
     * Returns whether model loading shall be considered.
     * 
     * @param isTransitiveEnabled whether transitive loading is enabled
     * @return <code>true</code> for loading, <code>false</code> else
     */
    public boolean considerLoading(boolean isTransitiveEnabled) {
        return topLevel || (!topLevel && isTransitiveEnabled);
    }

    /**
     * Collect location prefixes.
     * 
     * @param result the prefixes
     * @param location the location to turn into prefixes
     */
    private void collectLocationPrefixes(List<String> result, Location location) {
        File loc = location.getLocation().getAbsoluteFile();
        try {
            loc = loc.getCanonicalFile();
        } catch (IOException e) {
            String tmp = loc.toString();
            loc = new File(tmp.replace("/./", "/").replace("\\.\\", "\\")); // poor man's canonical file
        }
        result.add(loc.toURI().toString());
        for (int d = 0; d < location.getDependentLocationCount(); d++) {
            collectLocationPrefixes(result, location.getDependentLocation(d));
        }
    }
    
    /**
     * Filters {@code list} by the relevant locations for this resolution context. Removes infos/models that are not 
     * located within {@code location}.
     * 
     * @param list the list of versioned model infos, to be modified by filtering as side effect
     */
    public void filterByLocations(List<VersionedModelInfos<M>> list) {
        if (null != list && null != modelLocationPrefixes && modelLocationPrefixes.size() > 0) { // unlikely, tests
            for (int l = list.size() - 1; l >= 0; l--) {
                VersionedModelInfos<M> infos = list.get(l);
                int size = infos.size();
                for (int i = size - 1; i >= 0; i--) {
                    ModelInfo<M> info = infos.get(i);
                    boolean contained = false;
                    for (int p = 0; !contained && p < modelLocationPrefixes.size(); p++) {
                        contained = info.getLocation().toString().startsWith(modelLocationPrefixes.get(p));
                    }
                    if (!contained) {
                        infos.remove(i);
                    }
                }
                if (size > 0 && infos.size() == 0) {
                    list.remove(l);
                }
            }
        }
    }

    /**
     * Filters the contained models by by {@code location}, i.e., removes modes that are not located within 
     * {@code location}.
     * 
     * @param location the location that shall be used as base/required location
     */
    public void filterByLocation(Location location) {
    }

    
}
