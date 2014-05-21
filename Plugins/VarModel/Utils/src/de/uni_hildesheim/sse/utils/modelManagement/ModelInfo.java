package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Stores high-level information about an available (possibly unresolved) model.
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public class ModelInfo <M extends IModel> implements IModelData {
    
    private String name;
    private Version version;
    private IModelLoader<M> loader;
    private URI location;
    private M resolved;
    private long timestamp;
    private List<ModelImport<M>> imports;
    private Locale locale;

    /**
     * Creates a model information object.
     * 
     * @param model the model to create this object for
     * @param location the physical location where the model is stored
     */
    public ModelInfo(M model, URI location) {
        this(model.getName(), model.getVersion(), null, location, null);
        // do not setResolved here! -> notification mechanism
    }
    
    /**
     * Creates a model information object.
     * 
     * @param model the model to create this object for
     * @param location the physical location where the model is stored
     * @param loader the loader being responsible for resolving the related model
     */
    public ModelInfo(M model, URI location, IModelLoader<M> loader) {
        this(model.getName(), model.getVersion(), loader, location, null);
        // do not setResolved here! -> notification mechanism
    }
    
    /**
     * Creates a model information object.
     * 
     * @param name the name of the model
     * @param version the version of the model, <b>null</b> signals that no version
     *   was given in the model
     * @param loader the loader being responsible for resolving the related model
     * @param location the physical location where the model is stored
     * @param imp imports and conflicts (may be <b>null</b>)
     */
    public ModelInfo(String name, Version version, IModelLoader<M> loader, URI location, List<ModelImport<M>> imp) {
        this.name = name;
        this.version = version;
        this.loader = loader;
        if (null != location) {
            this.location = location.normalize();
        } else {
            this.location = null;
        }
        imports = new ArrayList<ModelImport<M>>();
        if (null != imp) {
            imports.addAll(imp);
        }
        adjustTimestamp();
    }
    
    /**
     * Returns the name of the model.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the version of the model.
     * 
     * @return the version, may be <b>null</b> if no version is specified in the model
     */
    public Version getVersion() {
        return version;
    }
    
    /**
     * Returns the physical location of the model.
     * 
     * @return the physical location
     */
    public URI getLocation() {
        return location;
    }
    
    /**
     * Stores the responsible loader.
     * 
     * @return the loader
     */
    public IModelLoader<M> getLoader() {
        return loader;
    }
    
    /**
     * Returns name and version as a string for output.
     * 
     * @return name and version
     */
    public String nameVersionToString() {
        return "'" + name + "'" + Version.toString(version);
    }
    
    /**
     * Returns a textual representation of this instance.
     * 
     * @return a textual representation
     */
    public String toString() {
        return name + " v" + version + " " + location + " " + loader + " " + isResolved() + " " + locale;
    }

    /**
     * Changes the resolved model.
     * 
     * @param resolved the model, may be <b>null</b> if inconsistent or not yet loaded
     */
    void setResolved(M resolved) {
        this.resolved = resolved;
        // imports switch automatically
        adjustTimestamp();
    }

    /**
     * Adjusts the timestamp according to the currently resolved instance.
     */
    private void adjustTimestamp() {
        if (null == resolved) {
            timestamp = -1;
        } else {
            timestamp = System.currentTimeMillis();
        }
    }
    
    /**
     * Returns the resolved model.
     * 
     * @return the resolved model, may be <b>null</b> if inconsistent or not yet loaded
     */
    public M getResolved() {
        return resolved;
    }
    
    /**
     * Returns whether the related model was already resolved.
     * 
     * @return <code>true</code> if it was resolved, <code>false</code> else
     */
    public boolean isResolved() {
        return null != resolved;
    }
    
    /**
     * Returns the timestamp of the resolution.
     * 
     * @return the timestamp, may be negative if there is currently no resolution
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Returns whether the represented model is outdated.
     * 
     * @return <code>true</code> if it is outdated and
     *   loading the model is recommended, , <code>false</code> else
     */
    public boolean isOutdated() {
        boolean actual = false;
        if (null != location) {
            if ("file".equalsIgnoreCase(location.getScheme())) {
                try {
                    File file = new File(location);
                    actual = file.lastModified() > timestamp;
                } catch (IllegalArgumentException e) {
                    // should not happen -> force reload
                }
            }
        } else {
            actual = true;
        }
        return actual;
    }
    
    /**
     * Returns the number of imports. Please
     * note that this method is primarily intended to support versioned import
     * resolution. The returned information is in sync with the resolved
     * model if there is a resolved model, otherwise information is
     * stored locally (and resolved information there may be incorrect or
     * <b>null</b>).
     * 
     * @return the number of imports
     */
    public int getImportsCount() {
        int result;
        if (null != resolved) {
            result = resolved.getImportsCount();
        } else {
            result = imports.size();
        }
        return result;
    }
    
    /**
     * Returns the model import specified by <code>index</code>. Please
     * note that this method is primarily intended to support versioned import
     * resolution. The returned information is in sync with the resolved
     * model if there is a resolved model, otherwise information is
     * stored locally (and resolved information there may be incorrect or
     * <b>null</b>).
     * 
     * @param index a 0-based index specifying the import to be returned
     * @return the model import
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    @SuppressWarnings("unchecked")
    public ModelImport<M> getImport(int index) {
        ModelImport<M> result;
        if (null != resolved) {
            result = (ModelImport<M>) resolved.getImport(index);
        } else {
            result = imports.get(index); 
        }
        return result;
    }
    
    /**
     * Returns whether the given <code>uri</code> is contained in
     * the location of this information object.
     * 
     * @param uri the URI to be considered as containing URI
     * @return <code>true</code> if the location of this information
     *   object is contained, <code>false</code> if not (or any of both 
     *   is <b>null</b>)
     */
    public boolean isContainedIn(URI uri) {
        boolean result = false;
        if (null != uri && null != location) {
            result = uri.compareTo(location) < 0;
        }
        return result;
    }

    /**
     * Returns the outdated model information objects (due to file change).
     * May modify and return <code>info</code> if <code>modify</code> is
     * enabled.
     * 
     * @param <M> the specific type of model
     * 
     * @param info the model information objects to be considered
     * @param requireResolved <code>true</code> if the information objects
     *   to be returned need to be resolved ({@link ModelInfo#isResolved()}), 
     *   <code>false</code> if just all outdated objects shall be returned
     * @param uri an optional URI the results must be contained in (may be <b>null</b>)
     * @return the outdated (and, depending on the parameter resolved) information
     *   objects
     */
    public static <M extends IModel> List<ModelInfo<M>> selectOutdated(List<ModelInfo<M>> info, 
        boolean requireResolved, URI uri) {
        List<ModelInfo<M>> result = new ArrayList<ModelInfo<M>>();
        for (int i = 0; i < info.size(); i++) {
            ModelInfo<M> pi = info.get(i);
            if (pi.isOutdated()) {
                if (!requireResolved || requireResolved && pi.isResolved()) {
                    if (null == uri || pi.isContainedIn(uri)) {
                        result.add(pi);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Selects those information objects out of <code>info</code> which are contained 
     * in <code>uri</code>.
     * 
     * @param <M> the specific type of model
     * 
     * @param info the information objects to filter
     * @param uri the URI to filter for (may be <b>null</b>)
     * @return the contained models
     */
    public static <M extends IModel> List<ModelInfo<M>> selectContained(List<ModelInfo<M>> info, URI uri) {
        List<ModelInfo<M>> result = new ArrayList<ModelInfo<M>>();
        for (int i = 0; i < info.size(); i++) {
            ModelInfo<M> pi = info.get(i);
            if (null == uri || pi.isContainedIn(uri)) { 
                result.add(pi);
            }
        }
        return result;
    }
    
    /**
     * Stores the locale used while resolving the related model.
     * 
     * @param locale the locale used for resolving
     */
    void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    /**
     * Returns the locale used for resolving the related model.
     * 
     * @return the locale used for resolving
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * Returns the URI to the actual comments text resource. The URI is derived
     * using the {@linkplain #getLocation() location} of the model by adding the
     * country of the {@linkplain #getLocale() locale} used while loading and 
     * changing the extension to ".text".
     *   
     * @return the URI of the associated comments text resource (the existence of
     *   the related resource is not ensured), <b>null</b> if the resource cannot
     *   be composed, e.g., as the location is not known or the location
     *   does not point to a file
     */
    public URI getCommentsResource() {
        return getCommentsResource(getLocale());
    }
    
    /**
     * Returns the URI to the default comments text resource. The URI is derived
     * using the {@linkplain #getLocation() location} of the model by changing 
     * the extension to ".text".
     *   
     * @return the URI of the associated comments text resource (the existence of
     *   the related resource is not ensured), <b>null</b> if the resource cannot
     *   be composed, e.g., as the location is not known or the location
     *   does not point to a file
     */
    public URI getDefaultCommentsResource() {
        return getCommentsResource(null);
    }
    
    /**
     * Returns the URI to the actual comments text resource. The URI is derived
     * using the {@linkplain #getLocation() location} of the model by adding the
     * country of the {@linkplain #getLocale() locale} used while loading and 
     * changing the extension to ".text".
     * 
     * @param locale the locale to use, may be <b>null</b> for the default locale
     * @return the URI of the associated comments text resource (the existence of
     *   the related resource is not ensured), <b>null</b> if the resource cannot
     *   be composed, e.g., as the location is not known or the location
     *   does not point to a file
     */
    private URI getCommentsResource(Locale locale) {
        URI result = null;
        if (null != location) {
            String path = location.getPath();
            int pos = path.lastIndexOf('/');
            if (pos >= 0 && pos < path.length()) {
                pos++; // first character of "file"
                String name = path.substring(pos);
                path = path.substring(0, pos);
                pos = name.lastIndexOf('.'); // find separator
                if (pos >= 0 && pos < path.length()) {
                    String fName = name.substring(0, pos);
                    if (null != locale) {
                        fName += "_" + locale.getLanguage();
                    }
                    path += fName + ".text"; 
                } else {
                    path = null;
                }
            } else {
                path = null;
            }
            if (null != path) {
                try {
                    result = new URI(location.getScheme(), location.getUserInfo(), location.getHost(), 
                        location.getPort(), path, location.getQuery(), location.getFragment());
                } catch (URISyntaxException e) {
                }
            }
        }
        return result;
    }
    
    /**
     * Updates the model loader (only if unset).
     * 
     * @param loader the new loader
     */
    void updateModelLoader(IModelLoader<M> loader) {
        if (null == this.loader) {
            this.loader = loader;
        }
    }

}

