package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Implements a simple file artifact, i.e., an artifact which is represented as a file.
 * Non-specialized file-based artifacts, e.g., composite artifacts shall be represented
 * by this class or by specific subclasses which also shall act as default file artifact.
 * In particular, the following methods shall be overridden by subclasses:
 * <ol>
 *   <li>{@link #artifactChanged()}</li>
 *   <li>{@link #selectAll()} without {@link Invisible Invisible annotation}</li>
 * </ol>
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(DefaultFileArtifactCreator.class)
public class FileArtifact extends CompositeArtifact implements IFileSystemArtifact {

    private Path path;
    
    /**
     * Creates a new file artifact.
     * 
     * @param file the physical file of this artifact
     * @param model the artifact model to create this folder artifact within
     */
    protected FileArtifact(File file, ArtifactModel model) {
        path = new Path(file, model);
    }

    /**
     * Creates a new file artifact.
     * 
     * @param path the path representing this artifact
     * @param model the artifact model to create this folder artifact within
     */
    protected FileArtifact(Path path, ArtifactModel model) {
        if (path.getArtifactModel() != model) {
            this.path = new Path(path.getPath(), model);
        } else {
            this.path = path;
        }
    }


    /**
     * Creates a temporary file artifact.
     * 
     * @return the created file artifact
     * @throws ArtifactException in case that the creation fails
     */
    public static FileArtifact create() throws ArtifactException {
        try {
            File file = File.createTempFile("fileArtifact", "vil");
            file.deleteOnExit();
            return ArtifactFactory.createArtifact(FileArtifact.class, file, null);
        } catch (IOException e) {
            throw new ArtifactException(e, ArtifactException.ID_IO);
        }
    }
    
    /**
     * Returns whether this artifact is (considered to be) a temporary artifact.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    @Invisible
    public boolean isTemporary() {
        return getPath().isTemporary();
    }
    
    @Override
    public void delete() throws ArtifactException {
        path.delete();
    }

    /**
     * Returns the simple name of this artifact. 
     * 
     * @return the simple name
     * @throws ArtifactException in case that the operation cannot continue
     */
    @Override
    public String getName() throws ArtifactException {
        return path.getName();
    }
    
    /**
     * Returns the plain name without (possible) extension.
     * 
     * @return the plain name of the artifact
     * @throws ArtifactException in case that errors occur
     */
    public String getPlainName() throws ArtifactException {
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
    public void rename(String name) throws ArtifactException {
        path = path.rename(name);
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFileArtifact(this);
    }

    @Override
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)
    public Set<IFileSystemArtifact> move(IFileSystemArtifact target) throws ArtifactException {
        return new ListSet<IFileSystemArtifact>(FileUtils.move(this, target), IFileSystemArtifact.class);
    }

    @Override
    @OperationMeta(returnGenerics = IFileSystemArtifact.class)
    public Set<IFileSystemArtifact> copy(IFileSystemArtifact target) throws ArtifactException {
        return new ListSet<IFileSystemArtifact>(FileUtils.copy(this, target), IFileSystemArtifact.class);
    }

    @Invisible
    @Override
    public Set<? extends FragmentArtifact> selectAll() {
        return ArraySet.empty(FragmentArtifact.class);
    }

    @Override
    protected Text createText() throws ArtifactException {
        return new Text(path.getAbsolutePath(), true);
    }

    @Override
    protected Binary createBinary() throws ArtifactException {
        return new Binary(path.getAbsolutePath(), true);
    }
    
    /**
     * Substitutes the extension.
     * @param extension the new extension
     * @return the path
     * @throws ArtifactException in case of problems
     */
    public Path substituteExtension(String extension) throws ArtifactException {
        return getPath(); // TODO implement
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws ArtifactException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws ArtifactException {
        Path path = Path.convert(val);
        return convert(path);
    }

    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws ArtifactException in case of problems
     */
    @Invisible
    @Conversion
    public static Path convert(FileArtifact val) throws ArtifactException {
        return val.getPath();
    }
    
    /**
     * Conversion operation.
     * 
     * @param path the path to be converted
     * @return the converted value
     * @throws ArtifactException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(Path path) throws ArtifactException {
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
    public void store() throws ArtifactException {
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
                    throw new ArtifactException(e, ArtifactException.ID_IO);
                }
            } else if (null != binary) {
                file.getParentFile().mkdirs();
                try {
                    FileOutputStream out = new FileOutputStream(file);
                    binary.write(out);
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    throw new ArtifactException(e, ArtifactException.ID_IO);
                }
            }
        }
    }

}
