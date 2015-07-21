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
package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.uni_hildesheim.sse.utils.internal.Bundle;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * A model imports resolver. Don't store information in attributes!
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public abstract class DefaultImportResolver<M extends IModel> extends ImportResolver<M> {

    /** 
     * Allows to switch easily to the primitive (non-version checking) variant.
     */
    public static final boolean IMPORT_WITH_VERSION = true;
    
    private final ModelInfo<M> conflictMarker = new ModelInfo<M>();

    /**
     * Creates an resolver instance.
     */
    protected DefaultImportResolver() {
        super();
    }

    /**
     * Creates an resolver instance with a parent resolver to delegate to in failure cases.
     * 
     * @param parent the parent resolver
     */
    protected DefaultImportResolver(ImportResolver<M> parent) {
        super(parent);
    }
    
    @Override
    protected List<IMessage> resolveImportsImpl(M model, URI uri, List<ModelInfo<M>> inProgress, 
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext) {
        List<IMessage> messages = new ArrayList<IMessage>();
        ResolutionContext<M> context = new ResolutionContext<M>(model, uri, inProgress, repository, evaluationContext);
        HashSet<M> done = new HashSet<M>();
        List<ModelImport<M>> conflicts = resolveImports(context, done, messages);
        done.clear();
        //checkImportCycles(model, messages, done); // conflicts with QM-Model... 
        try {
            if ((null != conflicts) || null != context.getConflict(model)) {
                messages.add(new Message("import conflict on model '" + model.getName() 
                    + "', cannot resolve the import", Status.ERROR));
            }
        } catch (RestrictionEvaluationException e) {
            messages.add(new Message(e.getMessage(), Status.ERROR));
        }

        return messages;
    }

    /**
     * Checks the import structure of <code>model</code> for cycles.
     * 
     * @param model the (root) model to be checked
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @param done for detecting cyclic imports (modified as a side effect)
     */
    @SuppressWarnings("unused")
    private void checkImportCycles(M model, List<IMessage> messages, Set<M> done) {
        if (done.contains(model)) {
            messages.add(new Message("cyclic import of '" + model.getName() + "'", Status.ERROR));
        } else {
            done.add(model);
            for (int i = 0; i < model.getImportsCount(); i++) {
                @SuppressWarnings("unchecked")
                ModelImport<M> imp = (ModelImport<M>) model.getImport(i);
                if (null != imp.getResolved()) {
                    checkImportCycles(imp.getResolved(), messages, done);
                }
            }
        }
    }
    
    /**
     * Resolves the imports of the model in the given <code>context</code> and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all.
     * 
     * @param context the context of the models to be resolved
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @return the conflicting model imports, <b>null</b> if there are none
     */
    private List<ModelImport<M>> resolveImports(ResolutionContext<M> context, HashSet<M> done, 
        List<IMessage> messages) {
        List<ModelImport<M>> conflicts = null;
        M model = context.getModel();
        if (done.contains(model)) {
            String ver;
            if (null == model.getVersion()) {
                ver = "";
            } else {
                ver = " version '" + model.getVersion().getVersion() + "'";
            }
            messages.add(new Message("Cyclic import with '" + model.getName() + ver + ". Importing stopped here.", 
                Status.ERROR));
        } else {
            List<ModelImport<M>> todo = new ArrayList<ModelImport<M>>();
            handleImports(context, model, todo);
            
            int lastBacktrack = -1;
            int i = 0; 
            while ((null == conflicts && lastBacktrack < 0) || lastBacktrack >= 0) {
                while (null == conflicts && i < todo.size()) {
                    ModelImport<M> imp = todo.get(i); // here are no conflicts in
                    if (null == imp.getResolved()) {
                        context.setToResolve(imp);
                        // currently unresolved
                        conflicts = resolve(context, done, messages);
                    }
                    if (null == conflicts) {
                        i++;
                    }
                }
                if (null != conflicts) {
                    // we have a conflict at i and can revert a previous one
                    if (lastBacktrack < 0) {
                        lastBacktrack = i - 1;
                    } else {
                        lastBacktrack--;
                    }
                    if (lastBacktrack < 0) {
                        break; // no backtracking alternatives - stop
                    }
                    for (int j = i - 1; j >= lastBacktrack; j--) {
                        // keep the actual conflicts and try to find another solution
                        setUnresolved(context.getModel(), todo.get(j), j == i - 1 ? null : conflicts);
                    }
                    i = lastBacktrack;
                    conflicts = null;
                } else {
                    break; // successful - stop
                }
            }
            // conflicts may change during resolution
            for (i = 0; null == conflicts && i < todo.size(); i++) {
                ModelImport<M> imp = todo.get(i);
                try {
                    ModelImport<M> conflict = context.getConflict(imp.getResolved());
                    if (null != conflict) {
                        String conflictMsg = "";
                        if (null != conflict.getVersionRestriction()) {
                            conflictMsg = " with " + conflict.getVersionRestriction().toSpecification();
                        }
                        messages.add(new Message("Import of '" + imp.getName() + "' conflicts '" + conflictMsg + "'", 
                            Status.ERROR));
                    }
                } catch (RestrictionEvaluationException e) {
                    messages.add(new Message(e.getMessage(), Status.ERROR));
                }
            }
        }
        return conflicts;
    }
    
    /**
     * Sets the given <code>model</code> and its import recursively to unresolved.
     * 
     * @param model the model to be set to unresolved
     * @param conflicts the conflicts to unresolve exclusively, i.e., if not <b>null</b> other 
     *   imports are not modified, otherwise all imports are set to unresolved
     */
    @SuppressWarnings("unchecked")
    private void setUnresolved(M model, List<ModelImport<M>> conflicts) {
        for (int i = 0; i < model.getImportsCount(); i++) {
            setUnresolved(model, (ModelImport<M>) model.getImport(i), conflicts);
        }
        setUnresolved(model, (ModelImport<M>) model.getSuper(), conflicts);
    }

    /**
     * Sets the given import in <code>model</code> and its imports recursively to unresolved.
     * 
     * @param model the model containing <code>imp</code>
     * @param imp the import to be set to unresolved
     * @param conflicts the conflicts to unresolve exclusively, i.e., if not <b>null</b> other 
     *   imports are not modified, otherwise all imports are set to unresolved
     */
    private void setUnresolved(M model, ModelImport<M> imp, List<ModelImport<M>> conflicts) {
        if (null != imp) {
            try {
                M resolved = imp.getResolved();
                if (null != resolved) {
                    boolean unresolve = false;
                    if (null != conflicts) {
                        for (int i = 0; unresolve && i < conflicts.size(); i++) {
                            unresolve = (conflicts.get(i).getResolved() == resolved);
                        }
                    } else {
                        unresolve = true;
                    }
                    if (unresolve) {
                        setUnresolved(resolved, conflicts);
                        imp.setResolved(null);
                    }
                }
            } catch (ModelManagementException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
            }
        }
    }
    
    /**
     * Handles all imports for the given model.
     * 
     * @param context the resolution context
     * @param model the model to handle the imports
     * @param todo the imports to be handled in the calling step (may be <b>null</b>, then no todo list is built up)
     */
    private void handleImports(ResolutionContext<M> context, M model, List<ModelImport<M>> todo) {
        for (int i = 0; i < model.getImportsCount(); i++) {
            handleImport(context, model.getImport(i), todo);
        }
        handleImport(context, model.getSuper(), todo);
    }

    /**
     * Handles an import. If it denotes a conflict, it is added to the context, other to <code>todo</code>.
     * 
     * @param context the context of the models to be resolved (may be modified as a side effect)
     * @param imp the import to be handled
     * @param todo the imports to be handled in the calling step (may be <b>null</b>, then no todo list is built up)
     */
    private void handleImport(ResolutionContext<M> context, ModelImport<?> imp, List<ModelImport<M>> todo) {
        if (null != imp) {
            @SuppressWarnings("unchecked")
            ModelImport<M> i = (ModelImport<M>) imp;
            if (i.isConflict()) {
                context.addConflict(i);
            } else if (null != todo) {
                todo.add(i);
            }
        }
    }
    
    /**
     * Determine the model matching the import restrictions. If multiple matching models exist, return the model with
     * the highest version number.
     * 
     * @param context the import context
     * @param versions the already known and matching model information objects
     * @param restriction the version restriction (may be <b>null</b>)
     * @return the matching model (<b>null</b> if there no model was found or {@link #conflictMarker} if no matching 
     *   model was determined due to conflicts on all possible candidates)
     * @throws ModelManagementException in case of restriction evaluation problems
     */
    private ModelInfo<M> determineMatching(ResolutionContext<M> context, List<VersionedModelInfos<M>> versions, 
        IVersionRestriction restriction) throws ModelManagementException {
        ModelInfo<M> result;
        if (IMPORT_WITH_VERSION) {
            List<ModelInfo<M>> candidates = new ArrayList<ModelInfo<M>>();
            boolean hasConflicts = false;
            for (int v = 0, n = versions.size(); v < n; v++) {
                VersionedModelInfos<M> vInfos = versions.get(v);
                for (int i = 0, vn = vInfos.size();  i < vn; i++) {
                    ModelInfo<M> info = vInfos.get(i);
                    try {
                        boolean isOk = null == restriction 
                            || restriction.evaluate(context.getEvaluationContext(), info.getVersion());
                        if (isOk) {
                            if (context.isConflict(info)) {
                                hasConflicts = true;
                            } else {
                                candidates.add(info);
                            }
                        }
                    } catch (RestrictionEvaluationException e) {
                        throw new ModelManagementException(e.getMessage(), e.getId());
                    }
                }
            }
            int candidatesSize = candidates.size();
            if (0 == candidatesSize) {
                if (hasConflicts) {
                    result = conflictMarker;
                } else {
                    result = null;
                }
            } else if (1 == candidatesSize) {
                result = candidates.get(0);
            } else {
                // two model infos with same name and version shall not exist
                ModelInfo<M> highest = candidates.get(0);
                for (int i = 1; i < candidatesSize; i++) {
                    ModelInfo<M> info = candidates.get(i);
                    Version iVersion = info.getVersion();
                    if (null == highest.getVersion() && null != iVersion) {
                        highest = info;
                    } else if (null != iVersion && iVersion.compareTo(highest.getVersion()) > 0) {
                        highest = info;
                    }
                }
                result = highest;
                List<ModelInfo<M>> tmp = new ArrayList<ModelInfo<M>>();
                for (int i = 0; i < candidatesSize; i++) {
                    ModelInfo<M> info = candidates.get(i);
                    if (Version.equals(highest.getVersion(), info.getVersion())) {
                        tmp.add(info);
                    }
                }
                result = VersionedModelInfos.getByClosestUri(tmp, context.getModelURI(), context.getModelPaths());
            }
        } else {
            if (!versions.isEmpty()) {
                result = versions.get(0).getByClosestUri(context.getModelURI(), context.getModelPaths());
            }
        }
        return result; 
    }

    /**
     * Adds the given <code>conflict</code> conflicts to <code>conflicts</code>. <code>conflicts</code> may be
     * <b>null</b> and is created then lazily.
     * 
     * @param conflicts the conflicts set to add the <code>toAdd</code> conflicts to
     * @param conflict the conflicts to be added
     * @return <code>conflicts</code> if not <b>null</b>, a new list otherwise
     */
    private List<ModelImport<M>> addConflict(List<ModelImport<M>> conflicts, ModelImport<M> conflict) {
        if (null != conflict) {
            if (null == conflicts) {
                conflicts = new ArrayList<ModelImport<M>>();
            }
            conflicts.add(conflict);
        }
        return conflicts;
    }
    
    /**
     * Resolves the import / conflict represented by <code>imp</code>.
     * 
     * @param context the import context
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @param versions the already known and matching model information objects
     * @param imp the import to be resolved
     * @return the conflicting model imports, <b>null</b> if there are none
     */
    private List<ModelImport<M>> resolve(ResolutionContext<M> context, HashSet<M> done, List<IMessage> messages, 
        List<VersionedModelInfos<M>> versions, ModelImport<M> imp) {
        // determine the matching model
        List<ModelImport<M>> conflicts = null;
        ModelInfo<M> toLoad;
        try {
            toLoad = determineMatching(context, versions, imp.getVersionRestriction());
            if (conflictMarker == toLoad) {
                addConflict(conflicts, imp);
            }
        } catch (ModelManagementException e) {
            toLoad = null;
            messages.add(new Message(e.getMessage(), Status.ERROR));
        }
        if (null != toLoad && toLoad != conflictMarker) {
            conflicts = load(context, done, toLoad, messages, imp, conflicts);
        } else {
            if (null == toLoad) {
                messages.add(new Message("model '" + imp.getName() + "' cannot be resolved as no model matches the "
                    + "import specification", Status.ERROR));
            }
        }
        return conflicts;
    }
    
    // checkstyle: stop parameter number check
    
    /**
     * Loads the given model information, checks it for conflicts.
     * 
     * @param context the import context
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param toLoad the model to load
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @param imp the import to be resolved
     * @param conflicts the actual import conflicts (may be <b>null</b> if none were detected so far)
     * @return the actual import conflicts
     */
    private List<ModelImport<M>> load(ResolutionContext<M> context, HashSet<M> done, ModelInfo<M> toLoad, 
        List<IMessage> messages, ModelImport<M> imp, List<ModelImport<M>> conflicts) {
        M model = context.getModel();
        if (null != model && ModelInfo.equals(toLoad, model.getName(), model.getVersion(), context.getModelURI())) {
            messages.add(new Message("model '" + imp.getName() + "' cannot import itself", Status.ERROR));
        } else {
            IModelRepository<M> repository = context.getModelRepository();
            // is it already loaded?
            M found = toLoad.getResolved();
            if (null == found || repository.isOutdated(toLoad)) { // do not use is actual here!
                if (!context.isLoop(toLoad)) {
                    found = repository.load(toLoad, messages);
                } else {
                    messages.add(new Message("model '" + imp.getName() 
                        + "' cannot be resolved here due to errors in the imported model", 
                        Status.ERROR));                    
                }
            }
            if (null != found) {
                try {
                    if (checkImported(imp, found, messages)) {
                        handleImports(context, found, null); // collect conflicts
                        // check for new conflicts
                        try {
                            conflicts = addConflict(conflicts, context.getConflict(context.getModel()));
                        } catch (RestrictionEvaluationException e) {
                            messages.add(new Message(e.getMessage(), Status.ERROR));
                        }
                        if (null == conflicts) {
                            imp.setResolved(found);
                        }
                    }
                    if (null == conflicts) {
                        ResolutionContext<M> ctx = new ResolutionContext<M>(found, toLoad.getLocation(), context);
                        ctx.addConflicts(context);
                        conflicts = ResolutionContext.addConflicts(conflicts, resolveImports(ctx, done, messages));
                        if (null == conflicts) {
                            context.addConflicts(ctx);
                        } else {
                            imp.setResolved(null);
                        }
                    }
                } catch (ModelManagementException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
                }
            }
        }
        return conflicts;
    }
    
    // checkstyle: resume parameter number check

    /**
     * Checks the imported interfaces for obvious import problems, such as importing models
     * with interfaces as a whole.
     * 
     * @param imp the import to be resolved
     * @param model the model which may resolve the import
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @return <code>true</code> if the import is fine, <code>true</code> if problems were detected
     */
    protected boolean checkImported(ModelImport<M> imp, M model, List<IMessage> messages) {
        return true;
    }

    @Override
    protected M resolveImpl(String modelName, IVersionRestriction restrictions, URI baseUri,
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext) 
        throws ModelManagementException {
        M result = null;
        ResolutionContext<M> context = new ResolutionContext<M>(modelName, baseUri, repository, evaluationContext);
        List<VersionedModelInfos<M>> versions = context.getModelRepository().getAvailable(modelName);
        ModelInfo<M> toLoad = determineMatching(context, versions, restrictions);
        if (null != toLoad && toLoad != conflictMarker) { // no backtracking on individual model resolution
            result = toLoad.getResolved();
            if (null == result || repository.isOutdated(toLoad)) { 
                List<IMessage> messages = new ArrayList<IMessage>();
                result = repository.load(toLoad, messages);
                if (!messages.isEmpty()) {
                    boolean isError = false;
                    StringBuilder tmp = new StringBuilder();
                    for (int m = 0, n = messages.size(); m < n; m++) {
                        IMessage msg = messages.get(m);
                        isError |= Status.ERROR == msg.getStatus();
                        if (tmp.length() > 0) {
                            tmp.append(", ");
                        }
                        tmp.append(msg.getDescription());
                    }
                    if (isError) {
                        throw new ModelManagementException(tmp.toString(), ModelManagementException.MODEL_LOAD_FAILURE);
                    } else {
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info(tmp.toString());
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Resolves the import represented by <code>context</code>.
     * 
     * @param context the context to resolve (including the import to resolve)
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @return the conflicting model imports, <b>null</b> if there are none
     */
    private List<ModelImport<M>> resolve(ResolutionContext<M> context, HashSet<M> done, List<IMessage> messages) {
        List<ModelImport<M>> conflicts = null;
        ModelImport<M> imp = context.getToResolve();
        if (!imp.isConflict()) {
            if (null == imp.getResolved()) {
                List<VersionedModelInfos<M>> versions = context.getModelRepository().getAvailable(imp.getName());
                if (null != versions && versions.size() > 0) {
                    conflicts = resolve(context, done, messages, versions, imp);
                } else {
                    messages.add(new Message("model '" + imp.getName() + "' cannot be found", Status.ERROR));
                }
            }
        } 
        return conflicts;
    }

}
