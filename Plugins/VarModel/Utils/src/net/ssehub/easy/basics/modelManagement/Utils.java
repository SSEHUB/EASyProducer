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
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Some model utilities.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class Utils {

    /**
     * Prevents this class from being instantiated.
     */
    private Utils() {
    }
    
    /**
     * Returns whether two model data object match. This method is preliminary
     * and shall be unified with the <code>matchesFull</code> methods as soon as
     * full model import and conflicts resolution is available.
     * 
     * @param data1 the first data object to test
     * @param data2 the second data object to test
     * @return <code>true</code> if both match, <code>false</code> else
     */
    public static boolean matches(IModelData data1, IModelData data2) {
        boolean result = data1.getName().equals(data2.getName())
                && sameVersion(data1.getVersion(), data2.getVersion());
        
        if (data1 instanceof ModelInfo && data2 instanceof ModelInfo) {
            ModelInfo<?> info1 = (ModelInfo<?>) data1;
            ModelInfo<?> info2 = (ModelInfo<?>) data2;
            result = result && (info1.getLocation().compareTo(info2.getLocation()) == 0);
        }
        return result;
    }
    
    /**
     * Returns whether the given versions are equal.
     * 
     * @param version1 the first version to compare
     * @param version2 the second version to compare
     * @return <code>true</code> if both versions are equal, <code>false</code> else
     */
    static boolean sameVersion(Version version1, Version version2) {
        boolean result;
        if (null == version1) {
            result = (null == version2);
        } else {
            result = (0 == version1.compareTo(version2));
        }
        return result;
    }
    
    /**
     * Appends a string of error messages to a given builder. Commas are 
     * inserted between already stored information in <code>builder</code>
     * and <code>errors</code> (if <code>errors</code> contains information) 
     * 
     * @param builder the builder to append to (modified as a side effect)
     * @param errors the error string (may be <b>null</b>)
     * @return <code>builder</code>
     */
    static StringBuilder appendErrors(StringBuilder builder, String errors) {
        if (null != errors && errors.length() > 0) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(errors);
        }
        return builder;
    }
    
    /**
     * Fills the given list/map as temporary data structures for improved
     * handling of model information objects and related model.
     * 
     * @param <M> the specific model type
     * 
     * @param availableModels all available model infos to be considered 
     * @param info a list of all available model information objects (modified
     *   as a side effect if not <b>null</b>)
     * @param modelInfoMap a reverse mapping between models and their related
     *   models (modified as a side effect if not <b>null</b>)
     */
    static <M extends IModel> void collectModelInfo(Collection<List<VersionedModelInfos<M>>> availableModels, 
        List<ModelInfo<M>> info, Map<M, ModelInfo<M>> modelInfoMap) {
        for (List<VersionedModelInfos<M>> vInfos : availableModels) {
            int vInfosSize = vInfos.size();
            for (int i = 0; i < vInfosSize; i++) {
                VersionedModelInfos<M> vInfo = vInfos.get(i);
                for (int j = 0; j < vInfo.size(); j++) {
                    ModelInfo<M> pi = vInfo.get(j);
                    if (null != info) {
                        info.add(pi);
                    }
                    if (null != modelInfoMap && pi.isResolved()) {
                        modelInfoMap.put(pi.getResolved(), pi);
                    }
                }
            }
        }
    }
    
    /**
     * Augments the given model <code>infos</code> by their depending models,
     * i.e. the models which import the models in <code>info</code>. Please 
     * note that this method contains only already resolved models!
     * 
     * @param <M> the specific model type
     * 
     * @param infos the model informations to be augmented by their depending 
     *   models (modified as a side effect)
     * @param allInfos all information objects that are currently available
     * @param modelInfoMap reverse mapping of models to their information objects
     * @return the top-level models which are not imported by any model
     */
    static <M extends IModel> List<ModelInfo<M>> augmentByDepending(List<ModelInfo<M>> infos, 
        List<ModelInfo<M>> allInfos, Map<M, ModelInfo<M>> modelInfoMap) {
        List<ModelInfo<M>> topLevel = new ArrayList<ModelInfo<M>>();
        topLevel.addAll(infos); // just assume that they could be top level

        Set<ModelInfo<M>> known = new HashSet<ModelInfo<M>>();
        known.addAll(infos);
        int lastSize = infos.size();
        
        // idea: determine for each (unprocessed) information object whether 
        // a resolved import points to an interesting object (in infos/infoMap).
        // In this case, the importing models is also interesting, i.e. the imported
        // model is not a top-level model, the importing may be a top-level model,
        // it shall be subject to further processing (added to infos) and it shall 
        // not be processed in this method again (add to processed)
        do {
            for (int j = 0; j < allInfos.size(); j++) {
                ModelInfo<M> info = allInfos.get(j);
                if (!info.isResolved() || known.contains(info)) {
                    // do not consider unresolved or already known objects
                    continue;
                }
                boolean isInteresting = false;
                for (int p = 0; p < info.getImportsCount(); p++) {
                    ModelImport<M> imp = info.getImport(p);
                    if (!imp.isConflict() && imp.isResolved()) {
                        // consider only resolved imports
                        ModelInfo<M> resolved = modelInfoMap.get(imp.getResolved());
                        if (known.contains(resolved)) {
                            isInteresting = true;
                            topLevel.remove(resolved);
                        }
                    }
                }
                if (isInteresting) {
                    known.add(info);
                    infos.add(info);
                    topLevel.add(info);
                }
            }
            
            int curSize = infos.size();
            if (curSize == lastSize) { // stop at fixpoint, imports are not cyclic!
                break;
            }
            lastSize = curSize;
        } while (true);

        return topLevel;
    }
    
    /**
     * Returns a file object for <code>uri</code> which points to an existing file.
     * 
     * @param uri the URI to turn into a file
     * @return the related file or <b>null</b> if either uri is <b>null</b> or the 
     *   related file does not exist
     */
    public static File toExistingFile(URI uri) {
        File result = null;
        if (null != uri) {
            result = new File(uri);
            if (!result.exists()) {
                result = null;
            }
        }
        return result;
    }
    
    /**
     * Enumerate all imported (and resolved) models of <code>model</code> (including <code>model</code>).
     * 
     * @param <M> the actual model type
     * 
     * @param model the model to enumerate for
     * @param result the imported models (modified as a side effect)
     * @param deleteFrom delete models to be added to <code>result</code> if not <b>null</b>
     */
    @SuppressWarnings("unchecked")
    static <M extends IModel> void enumerateImported(M model, Set<M> result, Set<M> deleteFrom) {
        if (null != model && !result.contains(model)) {
            result.add(model);
            if (null != deleteFrom) {
                deleteFrom.remove(model);
            }
            int iCount = model.getImportsCount();
            for (int i = 0; i < iCount; i++) {
                enumerateImported((M) model.getImport(i).getResolved(), result, deleteFrom);
            }
        }
    }
    
    /**
     * List all imported {@link IModel}s for the given model including the model itself. The most inner model
     * will be the first element of the list, the main model the last (helpful for a correct initialization). <br>
     * <b>Note:</b> This function should not run into an endless loop in case of cycling imports.
     * @param mainModel The model to start with. May contain any imports and is the starting point.
     * @return The list of all associated projects (first most inner imported model, last is the main model itself).
     * @param <M> the actual model type 
     */
    public static synchronized <M extends IModel> List<M> discoverImports(M mainModel) {
        // Unsorted list of all models (imports and main model)
        List<M> allModels = new ArrayList<M>();
        findImportedModels(mainModel, allModels, new HashSet<M>());
        
        // Arrange them (most inner import first, main model last).
        return arrangeImportedModels(allModels); 
    }
    
    /**
     * Fills the stack of imported {@link IModel}s recursively.
     * @param model the model to be considered (should be the main model for starting the recursion).
     * @param allModels the list of all included models (modified as a side effect)
     * @param done already considered models
     * @param <M> the actual model type 
     */
    @SuppressWarnings("unchecked")
    private static <M extends IModel> void findImportedModels(M model, List<M> allModels, Set<M> done) {
        if (!done.contains(model)) {
            done.add(model);
            
            // do this in sequence of import specification
            allModels.add(model); 
            for (int i = 0, n = model.getImportsCount(); i < n; i++) {
                M importedModel = (M) model.getImport(i).getResolved();
                if (null != importedModel) {
                    findImportedModels(importedModel, allModels, done);
                }
            }
        }
    }
    
    /**
     * Rearranges all {@link IModel}s used in imports.
     * @param models {@link IModel}s retrieved from {@link #findImportedModels(IModel, List, Set)}.
     * @return Rearranged list of {@link IModel}s.
     * @param <M> the actual model type 
     */
    private static <M extends IModel> List<M> arrangeImportedModels(List<M> models) {
        List<M> sequence = new ArrayList<M>();    
        Set<M> done = new HashSet<M>();        
        for (int y = models.size() - 1; y >= 0; y--) {
            M project = models.get(y);
            if (!done.contains(project)) {
                arrangeImportedModels(project, done, sequence);
            }
        }
        return sequence;
    }
    
    /**
     * Recursive part of {@link #arrangeImportedModels(List)} to arrange first the imports before the importing
     * project without running into an endless loop in case of cycling projects.
     * @param model The current {@link IModel} to add/check
     * @param alreadyVisited Already visited {@link IModel}s, will not be revisited in case of a cycle.
     * Should be empty when the recursive function is called from outside to start.
     * @param sequence The resulting sequence (deepest import should be first, main {@link IModel} should be last).
     * Should be empty when the recursive function is called from outside to start.
     * @param <M> the actual model type 
     */
    @SuppressWarnings("unchecked")
    private static <M extends IModel> void arrangeImportedModels(M model, Set<M> alreadyVisited, List<M> sequence) {
        alreadyVisited.add(model);
        for (int i = 0, n = model.getImportsCount(); i < n; i++) {
            M importedProject = (M) model.getImport(i).getResolved();
            if (null != importedProject) {
                if (!alreadyVisited.contains(importedProject)) {
                    arrangeImportedModels(importedProject, alreadyVisited, sequence);
                }
            }
        }
        sequence.add(model);
    }
    
    /**
     * Prints the import resolution of the given {@code model} to {@code System.out}.
     * 
     * @param <M> the model type
     * @param model the model
     * @param mgt the optional model management if also model locations shall be emitted, may be <b>null</b>
     */
    public static <M extends IModel> void printResolution(M model, ModelManagement<M> mgt) {
        if (null != model) {
            System.out.print("Import resolution:");
            printResolution(model, mgt, new HashSet<M>(), "");
        }
    }
    
    /**
     * Prints the resolution information of the given {@code model} to {@code System.out}.
     * 
     * @param <M> the model type
     * @param model the model
     * @param mgt the optional model management if also model locations shall be emitted, may be <b>null</b>
     */
    private static <M extends IModel> void printModelInfo(M model, ModelManagement<M> mgt) {
        System.out.print(model.getName());
        if (model.getVersion() != null) {
            System.out.print(" " + model.getVersion());
        }
        if (null != mgt) {
            ModelInfo<M> info = mgt.availableModels().getModelInfo(model);
            if (null != info) {
                System.out.print(" -> " + info.getLocation());
            }
        }
        System.out.println();
    }

    /**
     * Prints the import resolution of the given {@code model} to {@code System.out}.
     * 
     * @param <M> the model type
     * @param model the model
     * @param mgt the optional model management if also model locations shall be emitted, may be <b>null</b>
     * @param done already done/visited models
     * @param indent characters to be emitted before model information
     */
    @SuppressWarnings("unchecked")
    private static <M extends IModel> void printResolution(M model, ModelManagement<M> mgt, Set<M> done, 
        String indent) {
        boolean isDone = done.contains(model);
        String marker = isDone ? "~" : "-";
        System.out.print(indent + marker + " ");
        printModelInfo(model, mgt);
        if (!isDone) {
            done.add(model);
            if (null != model.getSuper()) {
                System.out.println(indent + "- super:");
                printResolution((M) model.getSuper().getResolved(), mgt, done, indent + "  ");
            }
            for (int m = 0; m < model.getImportsCount(); m++) {
                ModelImport<M> imp = (ModelImport<M>) model.getImport(m);
                System.out.println(indent + "- import:" + imp.getName());
                printResolution(imp.getResolved(), mgt, done, indent + "  ");
            }
        }
    }

}
