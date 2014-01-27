package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.io.File;
import java.io.IOException;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Represents a file system folder.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(DefaultFolderArtifactCreator.class)
public class FolderArtifact extends SimpleArtifact implements IFileSystemArtifact, IArtifactChangedListener {

    // TODO use listener to reload after changes
    
    private Path path;

    /**
     * Creates a path artifact from the given <code>path</code>. A path may be 
     * a (regular) pattern!
     * 
     * @param path the path representing the folder
     */
    protected FolderArtifact(Path path) {
        this.path = path;
    }

    /**
     * Creates a path artifact from the given <code>file</code>. A path may be 
     * a (regular) pattern!
     * 
     * @param file the file representing the path
     * @param model the artifact model to create this folder artifact within
     */
    protected FolderArtifact(File file, ArtifactModel model) {
        path = new Path(file, model);
    }
    
    /**
     * Creates a temporary file artifact.
     * 
     * @return the created file artifact
     * @throws ArtifactException in case that the creation fails
     */
    public static FolderArtifact create() throws ArtifactException {
        try { 
            File file = File.createTempFile("folderArtifact", "");
            file.delete();
            file.mkdirs();
            return ArtifactFactory.createArtifact(FolderArtifact.class, file, null);
        } catch (IOException e) {
            throw new ArtifactException(e, ArtifactException.ID_IO);
        }
    }

    @Override
    public void delete() throws ArtifactException {
        path.delete();
    }

    @Override
    public String getName() throws ArtifactException {
        return path.getName();
    }

    @Override
    public void rename(String name) throws ArtifactException {
        path = path.rename(name);
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY;
    }
    
    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFolderArtifact(this);
    }

    @Override
    public Path getPath() {
        return path;
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

    /**
     * Returns the contained file system artifacts, i.e., folder and file artifacts.
     * @return the contained artifacts as collection
     * @throws ArtifactException in case that obtaining the artifacts fails
     */
    public Set<FileArtifact> selectAll() throws ArtifactException { // TODO turn into IFileSystemArtifact
        return getPath().selectAll();
    }

    @Override
    public void artifactChanged(Object cause) throws ArtifactException {
    }
   
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static FolderArtifact convert(String val) {
        File file = new File(val);
        return new FolderArtifact(file, ArtifactFactory.findModel(file));
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
    public static Path convert(FolderArtifact val) throws ArtifactException {
        return val.getPath();
    }

    /**
     * Converts a path into a folder.
     * 
     * @param path the path to be converted
     * @return the resulting folder
     * @throws ArtifactException in case of problems
     */
    @Invisible
    @Conversion
    public static FolderArtifact convert(Path path) throws ArtifactException {
        return new FolderArtifact(path);
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
            result = path.getPath();
        }
        return result;
    }

    @Override
    public void store() throws ArtifactException {
        // do nothing, we cannot store a folder
    }
    
    /**
     * Returns whether this artifact is (considered to be) a temporary artifact.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    public boolean isTemporary() {
        return path.isTemporary();
    }

    @Override
    public void update() throws ArtifactException {
        // TODO check whether functionality is actually needed
    }
    
}
