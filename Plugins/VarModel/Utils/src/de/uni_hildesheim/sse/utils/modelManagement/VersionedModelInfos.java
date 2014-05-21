package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


/**
 * Stores model information objects of the same version.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class VersionedModelInfos <M extends IModel> {
    
    private Version version;
    private List<ModelInfo<M>> infos = new ArrayList<ModelInfo<M>>();

    /**
     * Creates a new versioned model information container.
     * 
     * @param version the version of this container (may be <b>null</b>)
     */
    public VersionedModelInfos(Version version) {
        this.version = version;
    }
    
    /**
     * Adds a model information object. 
     * 
     * @param info the object to be added
     * @throws IllegalArgumentException if the version of <code>info</code> does 
     *   not match {@link #version} or the name of <code>info</code> does not match
     *   the name of the first stored model information object (if there is any)
     */
    public void add(ModelInfo<M> info) {
        assert null != info;
        if (!Version.equals(info.getVersion(), version)) {
            throw new IllegalArgumentException("versions do not match");
        }
        if (!infos.isEmpty()) {
            ModelInfo<M> first = infos.get(0);
            if (!first.getName().equals(info.getName())) {
                throw new IllegalArgumentException("names do not match");
            }
        }
        for (int i = 0; i < infos.size(); i++) {
            ModelInfo<M> tmp = infos.get(i);
            if (isSame(tmp.getLocation(), info.getLocation()) && tmp.getLoader() == info.getLoader()) {
                throw new IllegalArgumentException("URI and loader match");
            }
        }
        // multiple equal URIs may exist due to different loaders -> any shall be fine
        infos.add(info);
    }
    
    /**
     * Checks two URIs for equality.
     * 
     * @param uri1 the first URI (may be <b>null</b>)
     * @param uri2 the second URI (may be <b>null</b>)
     * @return <code>true</code> if both are the same, <code>false</code> else
     */
    public static final boolean isSame(URI uri1, URI uri2) {
        return (null == uri1 && uri1 == uri2) || (null != uri1 && uri1.equals(uri2));
    }
    
    /**
     * Returns the specified model information object.
     * 
     * @param index the index of the object to be returned
     * @return the specified object
     * @throws IndexOutOfBoundsException if <code>index&lt;0 
     *   || index&gt;={@link #size()}</code>
     */
    public ModelInfo<M> get(int index) {
        return infos.get(index);
    }
    
    /**
     * Returns the model information objects with <code>model</code> as resolved model.
     * 
     * @param model the (resolved) model to search for
     * @return the model information object or <b>null</b> if there is none
     */
    public ModelInfo<M> get(M model) {
        ModelInfo<M> result = null;
        int size = infos.size();
        for (int i = 0; i < size; i++) {
            ModelInfo<M> tmp = infos.get(i);
            if (tmp.getResolved() == model) {
                result = tmp;
            }
        }
        return result;
    }
    
    /**
     * Returns the model information objects with <code>uri</code> as location.
     * 
     * @param uri the URI to search for
     * @return the model information object or <b>null</b> if there is none
     */
    public ModelInfo<M> get(URI uri) {
        ModelInfo<M> result = null;
        int size = infos.size();
        for (int i = 0; i < size; i++) {
            ModelInfo<M> tmp = infos.get(i);
            if ((null == uri && tmp.getLocation() == uri) || uri.equals(tmp.getLocation())) {
                result = tmp;
            }
        }
        return result;        
    }

    /**
     * Returns the number of contained version information objects.
     * 
     * @return the number of version information objects
     */
    public int size() {
        return infos.size();
    }
    
    /**
     * Removes the specified model information object.
     * @param index the index of the object to be returned
     * @return the removed object
     * @throws IndexOutOfBoundsException if <code>index&lt;0 
     *   || index&gt;={@link #size()}</code>
     */
    public ModelInfo<M> remove(int index) {
        return infos.remove(index);
    }
    
    /**
     * Removes all stored model information objects.
     */
    public void clear() {
        infos.clear();
    }

    /**
     * Removes the specified model information object.
     * @param info the information object to be removed
     * @return <code>true</code> if successful <code>false</code> else
     */
    public boolean remove(ModelInfo<M> info) {
        return infos.remove(info);
    }
    
    /**
     * Returns the version all information objects in this instance
     * are assigned to.
     * 
     * @return the version
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Returns the model information with the exact match to <code>uri</code>.
     * 
     * @param uri the URI to match with (may be <b>null</b> then the first 
     *   information object is returned)
     * @return the matching model information (or <b>null</b> if none matches)
     */
    public List<ModelInfo<M>> getByEqualUri(URI uri) {
        List<ModelInfo<M>> result = null;
        if (null != uri) {
            uri = uri.normalize();
            int size = infos.size();
            for (int i = 0; i < size; i++) {
                ModelInfo<M> info = infos.get(i);
                if (null != info.getLocation() && uri.equals(info.getLocation())) {
                    if (null == result) {
                        result = new ArrayList<ModelInfo<M>>();
                    }
                    result.add(info);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the model information with the closest match 
     * to <code>uri</code>, i.e. in closest in the same hierarchy path.
     * 
     * @param uri the URI to match with (may be <b>null</b> then the first 
     *   information object is returned)
     * @param modelPath additional URIs prefixes which shall be considered for importing,
     *   similar to the Java classpath 
     * @return the matching model information (or <b>null</b> if none matches)
     */
    public ModelInfo<M> getByClosestUri(URI uri, List<String> modelPath) {
        ModelInfo<M> result = null;
        int size = infos.size();
        if (size > 0) {
            if (null == uri/* || null == version*/) {
                result = infos.get(0);
            } else {
                // precedence to same file
                for (int i = 0; null == result && i < size; i++) {
                    ModelInfo<M> info = infos.get(i);
                    if (isSame(uri, info.getLocation())) {
                        result = info;
                    }
                }
                // precedence to own hierarchy
                String searchUriText = pathWithoutLastFragment(uri.normalize());
                if (null == result) {
                    // search according to hierarchical IVML convention
                    result = search(searchUriText, modelPath);
                    // this may fail, in particular for parent projects imported according to EASy convention
                    if (null == result) { 
                        result = searchOnParentLevel(uri, modelPath);
                    }
                }
                // containment in model path
                if (null != modelPath) {
                    for (int i = 0; null == result && i < size; i++) {
                        ModelInfo<M> info = infos.get(i);
                        for (int m = 0; null == result && m < modelPath.size(); m++) {
                            if (isMatching(info.getLocation().toString(), modelPath.get(m), false)) {
                                result = info;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Searches for the best match according to the IVML search conventions, first down along the given
     * URI, then up along the hierarchy.
     * 
     * @param searchUriText the search folder URI as text 
     * @param modelPath additional URIs prefixes which shall be considered for importing,
     *   similar to the Java classpath 
     * @return the matching model information (or <b>null</b> if none matches)
     */
    private ModelInfo<M> search(String searchUriText, List<String> modelPath) {
        ModelInfo<M> result = null;
        int matchLength = 0;
        // 0 == b: down, 1 == b up in URI hierarchy
        for (int b = 0; null == result && 0 == matchLength && b < 2; b++) {
            int size = infos.size();
            for (int i = 0; i < size; i++) {
                ModelInfo<M> info = infos.get(i);
                URI infoUri = info.getLocation();
                if (null == infoUri) {
                    continue;
                }
                String infoUriText = pathWithoutLastFragment(infoUri);
                if (isMatching(searchUriText, modelPath, infoUriText, 0 == b)) {
                 // the first match is a candidate
                    boolean isBestMatch = (0 == matchLength); 
                 // down, then minimize match length
                    isBestMatch |= (0 == b && infoUriText.length() < matchLength);
                 // up, then maximize match length
                    isBestMatch |= (1 == b && infoUriText.length() > matchLength);
                    if (isBestMatch) {
                        result = infos.get(i);
                        matchLength = infoUriText.length();
                    }
                }
            }
        }
        return result;
    }

    /**
     * Searches for the best match within the parent-parent folders of <code>uri</code> if that folder starts with 
     * ".". This enables cross-links among parent models according to the convention EASy places imported IVML files.
     * 
     * @param uri the URI to start searching 
     * @param modelPath additional URIs prefixes which shall be considered for importing,
     *   similar to the Java classpath 
     * @return the matching model information (or <b>null</b> if none matches)
     */
    private ModelInfo<M> searchOnParentLevel(URI uri, List<String> modelPath) {
        ModelInfo<M> result = null;
        File uriFile = new File(uri);
        File uriParent = uriFile.getParentFile();
        File parent = uriParent;
        // step two levels up... 
        // uri = EASy/.core/core.ivml; uri-parent = EASy/.core; uri-parent-parent = EASy
        if (null != parent) {
            if (parent.getName().startsWith(".")) { // do not consider other parents, EASy-folder not known here!
                parent = parent.getParentFile();
            } else {
                parent = null;
            }
        }
        if (null != parent) {
            File[] siblings = parent.listFiles();
            if (null != siblings) {
                for (int s = 0; null == result && s < siblings.length; s++) {
                    File sibling = siblings[s];
                    if (sibling.isDirectory() && !sibling.equals(uriParent)) {
                        URI siblingUri = sibling.toURI().normalize();
                        result = search(siblingUri.toString(), modelPath);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Checks whether the <code>searchUriText</code> (with precedence) ore one of the 
     * <code>modelPath</code> URI paths match <code>importUri</code>, i.e. whether
     * <code>importUri</code> is an appropriate URI for import.
     * 
     * @param searchUriText the textual URI of the model stating the import
     * @param modelPath additional URI paths, may be <b>null</b>
     * @param importUriText the URI path of the model being considered for import
     * @param contained prefer contained or containing URIs
     * @return <code>true</code> if the specified data match, <code>false</code> if not
     */
    private static boolean isMatching(String searchUriText, List<String> modelPath, String importUriText, 
        boolean contained) {
        boolean matches = isMatching(searchUriText, importUriText, contained);
        if (!matches && null != modelPath) {
            int size = modelPath.size();
            for (int p = 0; !matches && p < size; p++) {
                matches = isMatching(searchUriText, modelPath.get(p), contained);
            }
        }
        return matches;
    }

    /**
     * Checks whether the <code>searchUriText</code> and <code>importUri</code> match.
     * 
     * @param searchUriText the textual URI of the model stating the import
     * @param importUriText the URI path of the model being considered for import
     * @param contained prefer contained or containing URIs
     * @return <code>true</code> if the specified data match, <code>false</code> if not
     */
    private static boolean isMatching(String searchUriText, String importUriText, boolean contained) {
        return contained ? importUriText.startsWith(searchUriText) : searchUriText.startsWith(importUriText);
    }
    
    /**
     * Returns the prefix path of the given <code>uri</code> without the last fragment.
     * 
     * @param uri the URI to be considered
     * @return the prefix path if possible, the <code>uri</code> else
     */
    public static String pathWithoutLastFragment(URI uri) {
        String uriText = uri.toString();
        int pos = uriText.lastIndexOf('/');
        if (pos > 0) {
            uriText = uriText.substring(0, pos + 1);
        }
        return uriText;
    }
    
    /**
     * Adds all model information objects to the given <code>list</code>.
     * 
     * @param list the list to be modified as a side effect (may be <b>null</b>
     *   then a list is created)
     * @return <code>list</code> or the created list
     */
    public List<ModelInfo<M>> toList(List<ModelInfo<M>> list) {
        if (null == list) {
            list = new ArrayList<ModelInfo<M>>();
        }
        for (int i = 0; i < infos.size(); i++) {
            list.add(infos.get(i));
        }
        return list;
    }
    
    /**
     * Returns the textual representation of this instance.
     * 
     * @return the textual representation
     */
    public String toString() {
        return version + " "  + infos;
    }
    
    /**
     * Finds a model information object based on a give URI.
     * 
     * @param uri the URI to find the information object
     * @return the information object or <b>null</b> if not found
     */
    public ModelInfo<M> find(URI uri) {
        ModelInfo<M> result = null;
        if (null != uri) {
            int size = infos.size();
            for (int i = 0; null == result && i < size; i++) {
                ModelInfo<M> info = infos.get(i);
                if (uri.equals(info.getLocation())) {
                    result = info;
                }
            }
        }
        return result;
    }
    
    /**
     * Retrieves the version model information container with the specified version.
     * 
     * @param <M> the specific type of model
     * 
     * @param infos a list of model information containers (may be <b>null</b>)
     * @param version the version to retrieve
     * @return the first matching container
     */
    public static <M extends IModel> VersionedModelInfos<M> find(List<VersionedModelInfos<M>> infos, 
        Version version) {
        VersionedModelInfos<M> result = null;
        if (null != infos) {
            for (int i = 0; null == result && i < infos.size(); i++) {
                VersionedModelInfos<M> info = infos.get(i);
                if (Version.equals(info.getVersion(), version)) {
                    result = info;
                }
            }
        }
        return result;
    }

}
