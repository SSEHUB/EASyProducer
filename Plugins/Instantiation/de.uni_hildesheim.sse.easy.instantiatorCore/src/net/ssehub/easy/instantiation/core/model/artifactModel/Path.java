package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.tools.ant.types.selectors.SelectorUtils;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils.ScanResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.DefaultValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents a path within a file system (not a folder!).
 * 
 * @author Holger Eichelberger
 */
public class Path implements IVilType, IStringValueProvider {

    public static final String SEPARATOR = "/";
    @DefaultValue
    public static final Path DUMMY = new Path("", null);
    
    private String path;
    private ArtifactModel model;

    /**
     * Creates a path from the given string representation. A path may be 
     * a (regular) pattern!
     * 
     * @param file the file to construct the path from
     * @param model the artifact model as a basis for relative paths
     */
    //private Path(File file, ArtifactModel model) {
    //    this(file.getAbsolutePath(), model);
    //}
    
    /**
     * Creates a path from the given string representation. A path may be 
     * a (regular) pattern!
     * 
     * @param path the path to construct the path object from
     * @param model the artifact model as a basis for relative paths
     */
    protected Path(String path, ArtifactModel model) {
        this.model = model;
        this.path = ArtifactModel.makeRelative(path, model);
    }

    /**
     * Creates a path from the given (relative) <code>path</code> and directly localizes 
     * it into <code>model</code>. A path may be a (regular) pattern!
     * 
     * @param path the path to construct this path object from
     * @param model the artifact model as a basis for relative paths
     */
    //private Path(Path path, ArtifactModel model) {
    //    this(path.getPath(), model);
    //}

    /**
     * Creates a path from the given (relative) <code>path</code> and directly localizes 
     * it into <code>model</code>. A path may be a (regular) pattern!
     * 
     * @param path the path to construct this path object from
     * @param model the artifact model as a basis for relative paths
     * @return the created path
     */
    @Invisible
    public static Path createInstance(Path path, ArtifactModel model) {
        return lookupOrCreate(path.getPath(), model);
    }

    /**
     * Creates a path from the given string representation. A path may be 
     * a (regular) pattern!
     * 
     * @param path the path to construct the path object from
     * @param model the artifact model as a basis for relative paths
     * @return the created path
     */
    @Invisible
    public static Path createInstance(String path, ArtifactModel model) {
        return lookupOrCreate(path, model);  
    }

    /**
     * Creates a path from the given string representation. A path may be 
     * a (regular) pattern!
     * 
     * @param file the file to construct the path from
     * @param model the artifact model as a basis for relative paths
     * @return the created path
     */
    @Invisible
    public static Path createInstance(File file, ArtifactModel model) {
        return lookupOrCreate(file.getAbsolutePath(), model);
    }

    /**
     * Looks up the given path in the path cache or creates a new path object registering it in the path cache of 
     * <code>model</code>.
     * 
     * @param path the path to create the path object for
     * @param model the artifact model as a basis for relative paths
     * @return the created/found path
     */
    private static Path lookupOrCreate(String path, ArtifactModel model) {
        String relPath = ArtifactModel.makeRelative(path, model);
        ArtifactModel qModel = null == model ? ArtifactFactory.getDefaultArtifactModel() : model;
        Path result = qModel.getPathFromCache(relPath);
        if (null == result) {
            result = new Path(path, model); // may be relPath but then double normalization, keep norm. in constructor
            if (null != model) {
                model.registerPath(result);
            }
        }
        return result;
    }
    
    /**
     * Returns the containing artifact model.
     * 
     * @return the containing artifact model
     */
    @Invisible
    public ArtifactModel getArtifactModel() {
        return model;
    }
    
    /**
     * Creates a path from the given string representation. A path may be 
     * a (regular) pattern!
     * 
     * @param path the path to construct the path object from
     * @return the created path object
     * @throws VilException in case that the path does not comply to Java conventions
     */
    public static Path create(String path) throws VilException {
        return createInstance(path, ArtifactFactory.findModel(path));
    }
    
    /**
     * Returns the path represented by this instance. This path may be a pattern.
     * 
     * @return the represented path
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns the absolute path with respect to {@link #model}.
     * 
     * @return the absolute path
     */
    @Invisible(inherit = true)
    public File getAbsolutePath() {
        File result;
        if (null != model) {
            result = getAbsolutePath(new File(model.getBasePath()));
        } else {
            result = new File(""); // for DUMMY
        }
        return result;
    }
    
    /**
     * Returns the parent of this path.
     * 
     * @return the parent, <b>this</b> if there is no further parent
     */
    public Path getParent() {
        Path result = this;
        File f = new File(path);
        File parent = f.getParentFile();
        if (null != parent) {
            result = createInstance(parent, ArtifactFactory.findModel(parent));
        }
        return result;
    }
    
    /**
     * Returns the absolute path.
     * 
     * @param base the base path for turning relative paths into absolute paths
     * @return the absolute path
     */
    private File getAbsolutePath(File base) {
        File result = new File(path);
        if (!result.isAbsolute() && null != base) {
            result = new File(base, path);
        } 
        return result.getAbsoluteFile();
    }
    
    /**
     * Returns whether this path is a pattern.
     * 
     * @return <code>true</code> if it is a pattern, <code>false</code> else
     */
    public boolean isPattern() {
        return PathUtils.isPattern(path);
    }
   
    /**
     * Turns this path into a java package name.
     * 
     * @return the related java Package name
     * @throws VilException in case that the related Java path cannot be created
     */
    public JavaPath toJavaPath() throws VilException {
        return new JavaPath(this);
    }
    
    /**
     * Turns this path into a java package name.
     * 
     * @param prefixRegEx an optional regular expression (intended for path prefixes) to be 
     *   replaced by the empty string (may be <b>null</b>)
     * @return the related java Package name
     * @throws VilException in case that the related Java path cannot be created
     */
    public JavaPath toJavaPath(String prefixRegEx) throws VilException {
        return new JavaPath(this, prefixRegEx);
    }
    
    /**
     * Turns this path into a relative native OS path.
     * 
     * @return the native OS path as a string
     */
    public String toOSPath() {
        return FilenameUtils.separatorsToSystem(path);
    }

    /**
     * Turns this path into an absolute native OS path.
     * 
     * @return the native OS path as a string
     * @throws VilException in case that accessing the absolute path fails
     */
    public String toAbsoluteOSPath() throws VilException {
        return FilenameUtils.separatorsToSystem(getAbsolutePath().getPath());
    }

    /**
     * Deletes all files in the given path.
     * 
     * @throws VilException in case of I/O problems
     */
    public void deleteAll() throws VilException {
        if (isPattern()) {
            Set<FileArtifact> all = selectAll();
            if (null != all) {
                for (FileArtifact f : all) {
                    f.delete();
                }
            }
        } else {
            try {
                File file = getAbsolutePath();
                if (!file.isFile()) {
                    org.apache.commons.io.FileUtils.cleanDirectory(file);
                }
            } catch (IOException e) {
                throw new VilException(e, VilException.ID_IO);
            }
        }
    }
    
    /**
     * Creates the directories pointing to path.
     * 
     * @throws VilException in case of a pattern path or if access to the absolute path fails
     */
    public void mkdir() throws VilException {
        if (isPattern()) {
            throw new VilException("cannot create a directory from the pattern '" + path + "'", 
                VilException.ID_IO);
        }
        getAbsolutePath().mkdirs();
        ArtifactFactory.createArtifact(getAbsolutePath());
    }
        
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static Path convert(String val) {
        return createInstance(val, ArtifactFactory.findModel(val));
    }
    
    /**
     * Converts a path into a file system artifact.
     * 
     * @param path the path to be converted
     * @return the resulting artifact
     * @throws VilException in case of problems
     */
    @Invisible
    @Conversion
    public static IFileSystemArtifact convert(Path path) throws VilException {
        IFileSystemArtifact result;
        if (path.getAbsolutePath().isFile()) {
            result = FileArtifact.convert(path);
        } else {
            result = FolderArtifact.convert(path);
        }
        return result;
    }

    /**
     * Returns whether this path matches the given path.
     * 
     * @param path the path to check the match for
     * @return <code>true</code> of the match is positive, <code>false</code> else
     */
    @Invisible
    public boolean matches(Path path) {
        boolean result;
        if (path.isPattern()) {
            if (isPattern()) {
                result = false;
            } else {
                result = match(path, this, false);
            }
        } else {
            result = match(this, path, !isPattern());
            /*String thisPath = PathUtils.normalize(getAbsolutePath().getAbsolutePath());
            String pathPath = PathUtils.normalize(path.getAbsolutePath().getAbsolutePath());
            result = SelectorUtils.matchPath(thisPath, pathPath); */
        }
        return result;
    }
    
    /**
     * Convert the paths into absolute normalized paths and match or test for prefix equality.
     * 
     * @param pattern the path representing the pattern
     * @param path the path to be matched
     * @param prefix do a prefix check of <code>pattern</code> in <code>path</code> or match
     *   <code>pattern</code> as ANT pattern in <code>path</code>
     * @return <code>true</code> if <code>path</code> matches <code>pattern</code>, <code>false</code> else
     */
    private static boolean match(Path pattern, Path path, boolean prefix) {
        boolean result;
        // just use the ANT stuff / prefix but use the absolute paths
        String sPattern = PathUtils.normalize(pattern.getAbsolutePath().getAbsolutePath());
        String sPath = PathUtils.normalize(path.getAbsolutePath().getAbsolutePath());
        if (prefix) {
            result = sPath.startsWith(sPattern);
        } else {
            result = SelectorUtils.matchPath(sPattern, sPath); 
        }
        return result;
    }
        
    /**
     * Does type selection of artifacts by type equality.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    @ReturnGenerics(FileArtifact.class)
    @OperationMeta(name = {"selectByKind", "typeSelect"})
    public Set<FileArtifact> selectByType(Class<?> type) { 
        return ArtifactFactory.selectByType(this, type, false, false); // TODO check IFileSystemArtifact
    }

    /**
     * Does type selection of artifacts by sub-typing.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    @ReturnGenerics(FileArtifact.class)
    public Set<FileArtifact> selectByKind(Class<?> type) { 
        return ArtifactFactory.selectByType(this, type, true, false); // TODO check IFileSystemArtifact
    }

    /**
     * Does type selection of artifacts by not matched sub-typing.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    @ReturnGenerics(FileArtifact.class)
    public Set<FileArtifact> typeReject(Class<?> type) { 
        return ArtifactFactory.selectByType(this, type, true, true); // TODO check IFileSystemArtifact
    }

    /**
     * Selects all file artifacts represented by this path.
     * 
     * @return all file artifacts represented by path
     */
    @ReturnGenerics(FileArtifact.class)
    public Set<FileArtifact> selectAll() {
        List<FileArtifact> result = new LinkedList<FileArtifact>();
        model.selectByType(this, null, result, true, false); // TODO check IFileSystemArtifact
        if (result.size() == 0 && FileUtils.hasFiles(getAbsolutePath())) {
            // usually a folder external to source/target
            ScanResult<FileArtifact> res = new ScanResult<FileArtifact>(result);
            FileUtils.scan(getAbsolutePath(), null, 0L, res, FileArtifact.class);
        }
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }
    
    /**
     * Represents the path/string concatenation operation.
     * 
     * @param path the Path to be considered
     * @param string the String to be considered
     * @return path + string
     */
    @OperationMeta(name = Constants.ADDITION, opType = OperationType.INFIX)
    public static String concat(Path path, String string) {
        return PathUtils.normalize(path.getAbsolutePath()) + string;
    }

    /**
     * Represents the path/string concatenation operation.
     * 
     * @param string the String to be considered
     * @param path the Path to be considered
     * @return string + path 
     */
    @OperationMeta(name = Constants.ADDITION, opType = OperationType.INFIX)
    public static String concat(String string, Path path) {
        return string + PathUtils.normalize(path.getAbsolutePath());
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        String result;
        if (DUMMY == this) {
            result = "";
        } else {
            // no problem for test, as made relative for output afterwards
            result = PathUtils.normalize(getAbsolutePath().getAbsolutePath());
        }
        return result;
    }

    @Override
    public String toString() {
        return PathUtils.normalize(getAbsolutePath().getAbsolutePath());
    }
    
    /**
     * Returns the last modification timestamp of this artifact.
     *
     * @return the last modification timestamp, 0 if unknown
     */
    @Invisible(inherit = true)
    public long lastModification() {
        long result;
        try {
            result = getAbsolutePath().lastModified();
        } catch (SecurityException e) {
            result = 0;
        }
        return result;
    }

    /**
     * Returns whether this artifact is exists.
     * 
     * @return <code>true</code> if this artifact exists, <code>false</code> else
     */
    public boolean exists() {
        boolean exists;
        if (isPattern()) {
            exists = false;
        } else {
            exists = getAbsolutePath().exists();
        }
        return exists;
    }

    /**
     * Deletes the underlying artifact. Handles patterns through {@link ArtifactModel#delete(Path)}.
     * 
     * @throws VilException in case that deletion fails
     */
    public void delete() throws VilException {
        model.delete(this);
        if (isPattern()) {
            Set<FileArtifact> all = selectAll();
            if (null != all) {
                for (FileArtifact f : all) {
                    f.delete();
                }
            }
        } else {
            FileUtils.delete(getAbsolutePath());
        }
    }
    
    /**
     * Returns the MD5 hash of this path. May fail if it is a folder.
     * 
     * @return the MD5 hash
     * @throws VilException if the file artifact cannot be opened/read or the MD5 algorithm is not available
     */
    public String getMd5Hash() throws VilException {
        String result;
        try {
            byte[] data = Files.readAllBytes(getAbsolutePath().toPath());
            byte[] hash = MessageDigest.getInstance("MD5").digest(data);
            result = new BigInteger(1, hash).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new VilException(e.getMessage(), VilException.ID_ARTIFACT_INTERNAL);
        } catch (IOException e) {
            throw new VilException(e.getMessage(), VilException.ID_IO);
        }
        return result;
    }
    
    /**
     * Creates the file represented by this path and sets its modification time to now.
     * 
     * @throws VilException if I/O issues occur
     */
    public void touch() throws VilException {
        File f = getAbsolutePath();
        if (!f.exists()) {
            try {
                new FileOutputStream(f).close();
            } catch (IOException e) {
                throw new VilException(e.getMessage(), e, VilException.ID_IO);
            }
        }
        f.setLastModified(System.currentTimeMillis());
    }
    
    /**
     * Returns the simple name of this artifact. 
     * 
     * @return the simple name
     * @throws VilException in case that the operation cannot continue
     */
    public String getName() throws VilException {
        String result;
        if (isPattern()) {
            result = path;
        } else {
            result = getAbsolutePath().getName();
        }
        return result;
    }
    
    /**
     * Returns the path segments of this path (excluding the names).
     * 
     * @return the path segments
     */
    public String getPathSegments() {
        String result;
        int pos = path.lastIndexOf('/');
        if (pos > 0) {
            result = path.substring(0, pos);
        } else {
            result = null;
        }
        return result;
    }
    
    
    /**
     * Renames the underlying artifact and returns a new path if necessary.
     * 
     * @param name the new name (absolute or relative)
     * @return the new path reflecting the replaced artifact
     * @throws VilException in case that renaming fails
     */
    public Path rename(String name) throws VilException {
        if (null != this.model) {
            this.model.beforeRename(this);
        }
        Path result = this;
        File file = new File(name);
        if (!file.isAbsolute()) {
            //file = new File(model.getBase(), name);
            file = getAbsolutePath().getParentFile();
            if (null == file) {
                file = new File(model.getBase(), name);
            } else {
                file = new File(file, name);
            }
        }
        FileUtils.rename(getAbsolutePath(), file);
        ArtifactModel model = ArtifactFactory.findModel(file);
        if (null != model) {
            this.model = model;
            //result = createInstance(getPath(), model);
        }
        path = ArtifactModel.makeRelative(file.getAbsolutePath(), model);
        if (null != this.model) {
            this.model.afterRename(this);
        }
        return result;
    }

    /**
     * Returns whether this path is considered to be temporary.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    @Invisible
    public boolean isTemporary() {
        File tmp = new File(System.getProperty("java.io.tmpdir"));
        String tmpN = PathUtils.normalize(tmp);
        String pathN = PathUtils.normalize(getAbsolutePath());
        return pathN.startsWith(tmpN);
    }
    
    /**
     * Copies the artifacts denoted by this path to <code>target</code>.
     * 
     * @param target the target artifact
     * @return the created or touched artifacts
     * @throws VilException in case that file system operations or artifact model operations fail
     */
    public Set<IFileSystemArtifact> copy(IFileSystemArtifact target) throws VilException {
        return FileUtils.copyOrMove(this, target, false);
    }

    /**
     * Moves the artifacts denoted by this path to <code>target</code>.
     * 
     * @param target the target artifact
     * @return the created or touched artifacts
     * @throws VilException in case that file system operations or artifact model operations fail
     */
    public Set<IFileSystemArtifact> move(IFileSystemArtifact target) throws VilException {
        return FileUtils.copyOrMove(this, target, true);
    }

}
