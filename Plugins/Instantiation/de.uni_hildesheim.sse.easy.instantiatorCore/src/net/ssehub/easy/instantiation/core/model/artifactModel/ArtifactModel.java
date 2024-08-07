package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.tools.ant.types.selectors.SelectorUtils;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.basics.progress.ProgressObserver.ITask;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.SettingsInitializerRegistry;

/**
 * Implements the artifact model starting at a certain file root. However, the artifact 
 * model may also contain related artifacts outside the base directory subtree which 
 * must then be absolute. Typically, an artifact model will be created up incrementally
 * but may be created in one step using {@link #scanAll(ProgressObserver)}.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactModel {

    private File base;
    private String basePath;
    private TreeMap<String, IFileSystemArtifact> fileArtifacts = new TreeMap<String, IFileSystemArtifact>();
    private TreeMap<Object, IArtifact> otherArtifacts = new TreeMap<Object, IArtifact>();
    private Map<ProjectSettings, Object> settings;
    private Map<String, Path> pathCache = new HashMap<String, Path>();
    
    /**
     * Creates an artifact model instance as instantiation environment.
     * 
     * @param base the base directory of this artifact model (may be <b>null</b>
     *   but only as default model for the factory)
     */
    ArtifactModel(File base) {
        this.base = base;
        basePath = PathUtils.normalize(base.getAbsolutePath());
        if (!basePath.endsWith(Path.SEPARATOR)) {
            basePath += Path.SEPARATOR;
        }
        settings = SettingsInitializerRegistry.initializeSettings(base);
    }
    
    /**
     * Returns the base directory.
     * 
     * @return the base directory
     */
    public File getBase() {
        return base;
    }
    
    /**
     * Returns the (absolute) base path of {@link #getBase()}.
     * 
     * @return the absolute base path
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * Scans the entire environment starting at <code>root</code>.
     * 
     * @param observer the observer to be notified in case of progress, use 
     *   {@link ProgressObserver#NO_OBSERVER} if progress shall not be monitored
     * @throws VilException in case that creating / obtaining artifacts fails
     */
    public void scanAll(ProgressObserver observer) throws VilException {
        if (null != base) {
            ITask task = observer.registerTask("creating complete artifact model for " + base.getAbsolutePath());
            int count = 0;
            if (ProgressObserver.NO_OBSERVER != observer) {
                count = scanAll(base, 0, null, null, null);
            }
            observer.notifyProgress(task, 0, count);
            List<VilException> errors = new ArrayList<VilException>();
            scanAll(base, 0, observer, task, errors);
            observer.notifyEnd(task);
            if (errors.size() > 0) {
                throw new VilException(errors);
            }
        }
    }

    /**
     * Processes all files in <code>location</code> in a recursive manner. May be used
     * to count the number of files to be processed.
     * 
     * @param location the location to be scanned
     * @param count the number of files counted so far (call initially with <code>0</code>)
     * @param observer the progress observer (do not create artifacts if this is <b>null</b>)
     * @param task the progress task (ignored if <b>null</b>)
     * @param errors exceptions caught during scanning (do not create artifacts if this is <b>null</b>)
     * @return the number of files processed
     * 
     * @see ArtifactFactory#createFileSystemArtifact(File)
     */
    private int scanAll(File location, int count, ProgressObserver observer, ITask task, 
        List<VilException> errors) {
        if (null != location) {
            if (location.isDirectory()) {
                File[] files = location.listFiles();
                if (null != files) {
                    for (int f = 0; f < files.length; f++) {
                        count = scanAll(files[f], count, observer, task, errors);
                    }
                }
            } else {
                if (null != observer && null != errors) {
                    try {
                        ArtifactFactory.createFileSystemArtifact(location, this);
                    } catch (VilException e) {
                        errors.add(e);
                    }
                    if (null != task) {
                        observer.notifyProgress(task, count);
                    }
                }
                count++;
            }
        }
        return count;
    }

    /**
     * Returns all artifacts.
     * 
     * @return the selected artifacts
     */
    public Set<FolderArtifact> selectAllFolders() {
        List<FolderArtifact> result = new ArrayList<FolderArtifact>();
        for (IFileSystemArtifact artifact : fileArtifacts.values()) {
            if (FolderArtifact.class.isInstance(artifact)) {
                result.add((FolderArtifact) artifact);
            }
        }
        return new ListSet<FolderArtifact>(result, FolderArtifact.class);
    }
    
    /**
     * Does type selection of artifacts by type equality.
     * 
     * @param type the target type
     * @param negate negate the selection
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    public Set<FileArtifact> selectByType(Class<?> type, boolean negate) {
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        selectByType(null, type, result, false, negate);
        return new ListSet<FileArtifact>(result, type);
    }

    /**
     * Does type selection of artifacts by subtyping.
     * 
     * @param type the target type
     * @param negate negate the selection
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    public Set<FileArtifact> selectByKind(Class<?> type, boolean negate) {
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        selectByType(null, type, result, true, negate);
        return new ListSet<FileArtifact>(result, type);
    }
    
    /**
     * Does name selection of artifacts.
     * 
     * @param name the regular name pattern for artifact selection
     * @return the selected artifacts
     */
    public Set<FileArtifact> selectByName(String name) {
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        Pattern pattern;
        try {
            pattern = Pattern.compile(name);
        } catch (PatternSyntaxException e) {
            pattern = null;
        }
        selectByName(pattern, name, result);
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }
    
    /**
     * Does type selection of artifacts based on <code>path</code> and <code>type</code>.
     * 
     * @param pattern an optional regular expression to be matched (may be <b>null</b>)
     * @param name the name used to build the pattern used as fallback if <code>pattern</code> is <b>null</b>
     * @param result to be modified as a side effect
     */
    void selectByName(Pattern pattern, String name, List<FileArtifact> result) {
        for (IFileSystemArtifact artifact: fileArtifacts.values()) {
            if (artifact instanceof FileArtifact) {
                try {
                    String aName = artifact.getPath().getPath();
                    boolean ok;
                    if (null == pattern) {
                        ok = aName.equals(name);
                    } else {
                        ok = pattern.matcher(aName).matches();
                    }
                    if (ok) {
                        result.add((FileArtifact) artifact);
                    }
                } catch (VilException e) {
                    // no path, no match
                }
            }
        }
    }
    
    /**
     * Does type selection of artifacts based on <code>path</code> and <code>type</code>.
     * 
     * @param path the path to be considered for selection (may be <b>null</b>)
     * @param type the type to be considered (may be <b>null</b>, than this parameter is ignored)
     * @param result to be modified as a side effect
     * @param byKind do the selection by subtyping (<code>true</code>) or by equality (<code>false</code>)
     * @param negate negate the selection
     */
    void selectByType(Path path, Class<?> type, List<FileArtifact> result, boolean byKind, boolean negate) {
        if (null == type) {
            type = FileArtifact.class; // TODO -> remove in case of IFileSystemArtifact as return type
        }
        if (null == type || FileArtifact.class.isAssignableFrom(type)) {
            // TODO improve efficiency!!! -> start at path!
            for (IFileSystemArtifact artifact: fileArtifacts.values()) {
                if ((null == type || isOfType(type, artifact, byKind, negate)) && matchesPath(path, artifact)) {
                    result.add((FileArtifact) artifact);
                }
            }
        }
    }
    
    /**
     * Returns whether type selection matches.
     * 
     * @param type the type to be considered (may be <b>null</b>, than this parameter is ignored)
     * @param artifact the artifact to test
     * @param byKind do the selection by subtyping (<code>true</code>) or by equality (<code>false</code>)
     * @param negate negate the result
     * @return <code>true</code> if types match, <code>false</code> else
     */
    private static boolean isOfType(Class<?> type, IFileSystemArtifact artifact, boolean byKind, boolean negate) {
        boolean result;
        if (byKind) {
            result = type.isInstance(artifact);
        } else {
            result = null != artifact && type == artifact.getClass();
        }
        if (negate) {
            result = !result;
        }
        return result;
    }
    
    /**
     * Returns whether the given <code>path</code> (may be a pattern) matches the path of <code>artifact</code>.
     * 
     * @param path the path to be considered (as pattern)
     * @param artifact the artifact to be matched against the pattern
     * @return <code>true</code> if it matches, <code>false</code> else
     */
    private static boolean matchesPath(Path path, IFileSystemArtifact artifact) {
        boolean match;
        if (null == path) {
            match = true;
        } else {
            try {
                match = path.matches(artifact.getPath());
            } catch (VilException e) {
                // don't care
                match = false;
            }
        }
        return match;
    }
    
    /**
     * Registers a given artifact created by the artifact factory.
     * 
     * @param real the real underlying artifact
     * @param artifact the artifact to be registered
     * @return <code>true</code> if the artifact was registered, <code>false</code> else
     */
    boolean register(Object real, IArtifact artifact) {
        boolean result = false;
        if (null == base) {
            // this is the default/other model
            result = true;
        } else {
            if (true) {
                // TODO check model
                if (artifact instanceof IFileSystemArtifact && real instanceof File) {
                    fileArtifacts.put(makeRelativeFile((File) real), (IFileSystemArtifact) artifact);
                } else {
                    otherArtifacts.put(real, artifact);
                }
                result = true;
            }
        }
        return result;
    }

    /**
     * Makes the given <code>file</code> relative to this model.
     * 
     * @param file the file to make relative
     * @return the normalized and relative file if this model matches as prefix, 
     *    the normalized absolute file path else
     */
    String makeRelativeFile(File file) {
        return makeRelative(file.getAbsolutePath());
    }
    
    /**
     * Makes the given <code>file</code> relative to this model.
     * 
     * @param file the file to make relative
     * @return the normalized and relative path if this model matches as prefix, 
     *    the normalized absolute file else
     */
    String makeRelative(File file) {
        return makeRelative(file.getAbsolutePath());
    }

    /**
     * Makes the given <code>path</code> relative to this model.
     * 
     * @param path the path to make relative
     * @return the normalized and relative path if this model matches as prefix, 
     *    the normalized absolute file else
     */
    String makeRelative(String path) {
        String tmp = PathUtils.normalize(path);
        String parentPath = getBasePath();
        if (tmp.startsWith(parentPath)) {
            tmp = tmp.substring(parentPath.length());
        }
        return tmp;
    }

    /**
     * Makes the given <code>path</code> relative to the given <code>model</code>.
     * 
     * @param path the path to make relative
     * @param model the model to consider (may be <b>null</b>)
     * @return the normalized and relative path if <code>model</code> is given and matches as prefix, 
     *   the normalized absolute file else
     */
    static String makeRelative(String path, ArtifactModel model) {
        String tmp;
        if (null == model) {
            tmp = PathUtils.normalize(path);
        } else {
            tmp = model.makeRelative(path);
        }
        return tmp;
    }

    /**
     * Makes the given <code>file</code> relative to the given <code>model</code>.
     * 
     * @param file the file to make relative
     * @param model the model to consider (may be <b>null</b>)
     * @return the normalized and relative path if <code>model</code> is given and matches as prefix, 
     *   the normalized absolute file else
     */
    static String makeRelative(File file, ArtifactModel model) {
        return makeRelative(file.getAbsolutePath(), model);
    }

    /**
     * Returns a known artifact.
     * 
     * @param real the real underlying artifact
     * @return the artifact or <b>null</b> if no artifact is known for <code>real</code>
     */
    IArtifact getArtifact(Object real) {
        IArtifact result;
        if (real instanceof File) {
            result = fileArtifacts.get(makeRelativeFile((File) real));
        } else {
            if (real instanceof Comparable) {
                result = otherArtifacts.get(real);
            } else {
                result = null;
            }
        }
        return result;
    }
    
    /**
     * Returns whether this artifact model handles the given real object.
     * 
     * @param real the real object
     * @return a numeric value allowing to rank multiple artifact models handling <code>real</code>,
     *   i.e., 0 if it does not handle, 1 if it basically handles, a larger number for higher priority (e.g., the 
     *   length of {@link #basePath})
     */
    int handles(Object real) {
        int result = 0;
        if (real instanceof File) {
            File file = ((File) real);
            String absFile = PathUtils.normalize(file.getAbsolutePath());
            if (absFile.startsWith(basePath)) {
                result = basePath.length();
            }
        } else {
            result = basePath.length();
            // currently unclear, grab all
        }
        return result;
    }

    /**
     * Deletes a path and possible related artifacts.
     * 
     * @param path the path being deleted
     */
    synchronized void delete(File path) {
        String key = makeRelativeFile(path);
        fileArtifacts.remove(key);
        pathCache.remove(key);
    }
    
    /**
     * Returns the internal path cache key for <code>path</code>.
     * 
     * @param path the path
     * @return the path cache key
     */
    private String getPathKey(Path path) {
        return makeRelativeFile(path.getAbsolutePath());
    }
    
    /**
     * Discards a path before it becomes invalid, e.g., as its scope is discarded
     * during execution.
     * 
     * @param path the path to discard
     */
    synchronized void discardPath(Path path) {
        pathCache.remove(getPathKey(path));
    }
    
    /**
     * Returns a path from the path cache.
     * 
     * @param pathKey the path key (normalized path)
     * @return the path (may be <b>null</b> if unknown)
     */
    synchronized Path getPathFromCache(String pathKey) {
        return pathCache.get(pathKey);
    }

    /**
     * Called if a path is created.
     * 
     * @param path the path to discard
     */
    synchronized void registerPath(Path path) {
        String key = getPathKey(path);
        Path known = pathCache.get(key);
        if (null == known) {
            pathCache.put(key, path);
        } // shall not occur
    }

    /**
     * Called before renaming an artifact to cleanup.
     * 
     * @param artifact the artifact being renamed
     * @throws VilException in case of problems obtaining the path
     */
    synchronized void beforeRename(IFileSystemArtifact artifact) throws VilException {
        delete(artifact.getPath()); // clears cache
    }

    /**
     * Called after rename in order to create the changed artifacts.
     * 
     * @param artifact the renamed artifact
     * @throws VilException in case of problems obtaining the path
     */
    synchronized void afterRename(IFileSystemArtifact artifact) throws VilException {
        List<VilException> errors = new ArrayList<VilException>();
        scanAll(artifact.getPath().getAbsolutePath(), 0, ProgressObserver.NO_OBSERVER, null, errors);
        // path cache happens automatically
    }

    /**
     * Called before a path is renamed, i.e., it is about to be renamed.
     * 
     * @param path the path
     */
    synchronized void beforeRename(Path path) {
        pathCache.remove(getPathKey(path));
    }

    /**
     * Called after a path was renamed.
     * 
     * @param path the path
     */
    synchronized void afterRename(Path path) {
        registerPath(path);
    }

    /**
     * Deletes a path and possible related artifacts. This method is called from {@link Path}.
     * 
     * @param path the path being deleted
     */
    synchronized void delete(Path path) {
        if (FileUtils.isFile(path.getPath())) {
            fileArtifacts.remove(path.getPath());
        } else {
            if (path.isPattern()) {
                String pattern = path.getPath();
                Iterator<String> iter = fileArtifacts.keySet().iterator();
                while (iter.hasNext()) {
                    String pathKey = iter.next();
                    if (SelectorUtils.matchPath(pattern, pathKey)) {
                        pathCache.remove(pathKey);
                        iter.remove();
                    }
                }                
            } else {
                String sPath = path.getPath();
                if (!sPath.endsWith("/")) {
                    sPath += "/";
                }
                Iterator<String> iter = fileArtifacts.keySet().iterator();
                while (iter.hasNext()) {
                    String pathKey = iter.next();
                    if (pathKey.startsWith(sPath)) {
                        pathCache.remove(pathKey);
                        iter.remove();
                    }
                }
            }
        }
        pathCache.remove(getPathKey(path));
    }

    /**
     * Clears this artifact. For internal use only.
     */
    void clear() {
        List<IFileSystemArtifact> files = new ArrayList<IFileSystemArtifact>(fileArtifacts.size());
        files.addAll(fileArtifacts.values()); // avoid concurrent modification
        for (IFileSystemArtifact fa : files) {
            if (fa.isTemporary()) {
                try {
                    fa.delete();
                } catch (VilException e) {
                }
            }
        }
        fileArtifacts.clear();
        otherArtifacts.clear();
        pathCache.clear();
    }
    
    /**
     * Sets the settings for the artifact model.
     * 
     * @param key ID for the settings object
     * @param object the settings
     */
    public void setSettings(ProjectSettings key, Object object) {
        settings.put(key, object);
    }
    
    /**
     * Returns the settings object for the specified key.
     * 
     * @param key the key assigned to the settings object
     * @return the settings object
     */
    public Object getSettings(ProjectSettings key) {
        return settings.get(key);
    }
    
}
