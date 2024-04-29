package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.DefaultValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Implements a simple file artifact, i.e., an artifact which is represented as a file.
 * Non-specialized file-based artifacts, e.g., composite artifacts shall be represented
 * by this class or by specific subclasses which also shall act as default file artifact.
 * In particular, the following methods shall be overridden by subclasses:
 * <ol>
 *   <li>{@link #artifactChanged(Object)}</li>
 *   <li>{@link #selectAll()} without {@link Invisible Invisible annotation}</li>
 * </ol>
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(DefaultFileArtifactCreator.class)
public class FileArtifact extends CompositeArtifact implements IFileSystemArtifact, IActualValueProvider {

    @DefaultValue
    public static final FileArtifact DEFAULT = new FileArtifact();
    private Path path;
    private boolean isTemporary; // path may be in temporary folder but artifact may not be created as such

    /**
     * Default constructor for {@link IActualValueProvider actual value provider template}.
     */
    FileArtifact() {
    }
    
    /**
     * Creates a new file artifact.
     * 
     * @param file the physical file of this artifact
     * @param model the artifact model to create this folder artifact within
     */
    protected FileArtifact(File file, ArtifactModel model) {
        path = Path.createInstance(file, model);
    }

    /**
     * Creates a new file artifact.
     * 
     * @param path the path representing this artifact
     * @param model the artifact model to create this folder artifact within
     */
    protected FileArtifact(Path path, ArtifactModel model) {
        if (path.getArtifactModel() != model) {
            this.path = Path.createInstance(path.getPath(), model);
        } else {
            this.path = path;
        }
    }

    /**
     * Creates a temporary file artifact.
     * 
     * @return the created file artifact
     * @throws VilException in case that the creation fails
     */
    public static FileArtifact create() throws VilException {
        try {
            File file = File.createTempFile("fileArtifact", "vil");
            file.deleteOnExit();
            FileArtifact result = ArtifactFactory.createArtifact(FileArtifact.class, file, null);
            result.isTemporary = true;
            return result;
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_IO);
        }
    }
    
    /**
     * Returns whether this artifact is (considered to be) a temporary artifact.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    @Invisible
    public boolean isTemporary() {
        return isTemporary && getPath().isTemporary();
    }
    
    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void delete() throws VilException {
        path.delete();
    }
    
    /**
     * Returns the artifact model.
     * 
     * @return the artifact model
     */
    @Invisible
    public ArtifactModel getArtifactModel() {
        return path.getArtifactModel();
    }

    /**
     * Returns the simple name of this artifact. 
     * 
     * @return the simple name
     * @throws VilException in case that the operation cannot continue
     */
    @Override
    public String getName() throws VilException {
        return path.getName();
    }
    
    /**
     * Returns the plain name without (possible) extension.
     * 
     * @return the plain name of the artifact
     * @throws VilException in case that errors occur
     */
    public String getPlainName() throws VilException {
        String name = getName();
        int pos = name.lastIndexOf('.');
        if (pos > 0) {
            name = name.substring(0, pos);
        }
        return name;
    }
    
    /**
     * Returns the path segments of this path (excluding the names).
     * 
     * @return the path segments
     */
    public String getPathSegments() {
        return path.getPathSegments();
    }

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void rename(String name) throws VilException {
        path.getArtifactModel().beforeRename(this);
        path = path.rename(name);
        path.getArtifactModel().afterRename(this);
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFileArtifact(this);
    }

    @Override
    @ReturnGenerics(IFileSystemArtifact.class)
    @OperationMeta(storeArtifactsBefore = true)
    public Set<IFileSystemArtifact> move(IFileSystemArtifact target) throws VilException {
        return new ListSet<IFileSystemArtifact>(FileUtils.move(this, target), IFileSystemArtifact.class);
    }

    @Override
    @ReturnGenerics(IFileSystemArtifact.class)
    @OperationMeta(storeArtifactsBefore = true)
    public Set<IFileSystemArtifact> copy(IFileSystemArtifact target) throws VilException {
        return new ListSet<IFileSystemArtifact>(FileUtils.copy(this, target), IFileSystemArtifact.class);
    }

    @Invisible
    @Override
    public Set<? extends FragmentArtifact> selectAll() {
        return ArraySet.empty(FragmentArtifact.class);
    }

    @Override
    protected Text createText() throws VilException {
        return new Text(path.getAbsolutePath(), true);
    }

    @Override
    protected Binary createBinary() throws VilException {
        return new Binary(path.getAbsolutePath(), true);
    }
    
    /**
     * Substitutes the extension.
     * @param extension the new extension
     * @return the path
     * @throws VilException in case of problems
     */
    public Path substituteExtension(String extension) throws VilException {
        return getPath(); // TODO implement
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return convert(path);
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(IFileSystemArtifact val) {
        FileArtifact convertedValue = null;
        if (val instanceof FileArtifact) {
            convertedValue = (FileArtifact) val;
        }
        return convertedValue;
    }

    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case of problems
     */
    @Invisible
    @Conversion
    public static Path convert(FileArtifact val) throws VilException {
        return val.getPath();
    }
    
    /**
     * Conversion operation.
     * 
     * @param path the path to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(Path path) throws VilException {
        return ArtifactFactory.createArtifact(FileArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }

    @Override
    public long lastModification() {
        return path.lastModification();
    }

    @Override
    public boolean exists() {
        return path.exists();
    }
    
    @Override
    public String getStringValue(StringComparator comparator) {
        String result;
        if (null != comparator && comparator.inTracer() && isTemporary()) {
            result = "<temp>";
        } else {
            result = getPath().getPath();
        }
        return result;
    }
    
    @Override
    public void store() throws VilException {
        if (getRepresentationChanged(true)) {
            File file = path.getAbsolutePath();
            Text text = getTextInstance();
            Binary binary = getBinaryInstance();
            if (null != text) {
                file.getParentFile().mkdirs();
                PrintWriter out = null;
                try {
                    out = new PrintWriter(new FileWriter(file));
                    text.write(out);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    throw new VilException(e, VilException.ID_IO);
                }
            } else if (null != binary) {
                file.getParentFile().mkdirs();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    binary.write(out);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    throw new VilException(e, VilException.ID_IO);
                }
            }
        }
    }

    @Override
    public Object determineActualValue(Object object) {
        // by default, for non-existing paths a folder is created
        Object result = object;
        if (object instanceof FolderArtifact) {
            FolderArtifact folder = (FolderArtifact) object;
            if (!folder.exists()) {
                Path path = folder.getPath();
                result = new FileArtifact(path, path.getArtifactModel());
            }
        }
        return result;
    }
    
    @Override
    public void setExecutable(boolean ownerOnly) throws VilException {
        FileSystemArtifactOperations.setExecutable(this, ownerOnly);
    }

    /**
     * Returns the MD5 hash of this file artifact.
     * 
     * @return the MD5 hash
     * @throws VilException if the file artifact cannot be opened/read or the MD5 algorithm is not available
     */
    public String getMd5Hash() throws VilException {
        String result;
        try {
            byte[] data = Files.readAllBytes(path.getAbsolutePath().toPath());
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
     * Returns whether this file artifact has the same content as {@code artifact}.
     * 
     * @param artifact the artifact to compare
     * @return {@code true} if both artifacts have the same content, {@code false} else
     * @throws VilException if one of the file artifacts cannot be accessed/opened
     */
    public boolean hasSameContent(FileArtifact artifact) throws VilException {
        try {
            return org.apache.commons.io.FileUtils.contentEquals(path.getAbsolutePath(), 
                artifact.getPath().getAbsolutePath());
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_IO);
        }
    }
    
}
