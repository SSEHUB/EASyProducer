package de.uni_hildesheim.sse.utils.modelManagement;

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

}
