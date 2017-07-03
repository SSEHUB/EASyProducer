package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.io.IOException;

import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.DefaultValue;
import net.ssehub.easy.instantiation.core.model.vilTypes.IActualValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents a file system folder.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(DefaultFolderArtifactCreator.class)
public class FolderArtifact extends SimpleArtifact implements IFileSystemArtifact, IArtifactChangedListener, 
    IActualValueProvider {

    // TODO use listener to reload after changes
    
    @DefaultValue
    public static final FolderArtifact DEFAULT = new FolderArtifact();
    private Path path;
    private boolean isTemporary; // path may be in temporary folder but artifact may not be created as such

    /**
     * Default constructor for {@link IActualValueProvider actual value provider template}.
     */
    FolderArtifact() {
    }

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
        path = Path.createInstance(file, model);
    }
    
    /**
     * Creates a temporary file artifact.
     * 
     * @return the created file artifact
     * @throws VilException in case that the creation fails
     */
    public static FolderArtifact create() throws VilException {
        try { 
            File file = File.createTempFile("folderArtifact", "");
            file.delete();
            file.mkdirs();
            file.deleteOnExit();
            FolderArtifact result = ArtifactFactory.createArtifact(FolderArtifact.class, file, null);
            result.isTemporary = true;
            return result;
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_IO);
        }
    }

    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void delete() throws VilException {
        path.delete();
    }

    @Override
    public String getName() throws VilException {
        return path.getName();
    }

    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void rename(String name) throws VilException {
        path.getArtifactModel().beforeRename(this);
        path = path.rename(name);
        path.getArtifactModel().afterRename(this);
    }

    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws VilException {
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
    @OperationMeta(returnGenerics = IFileSystemArtifact.class, storeArtifactsBefore = true )
    public Set<IFileSystemArtifact> move(IFileSystemArtifact target) throws VilException {
        return new ListSet<IFileSystemArtifact>(FileUtils.move(this, target), IFileSystemArtifact.class);
    }

    @Override
    @OperationMeta(returnGenerics = IFileSystemArtifact.class, storeArtifactsBefore = true )
    public Set<IFileSystemArtifact> copy(IFileSystemArtifact target) throws VilException {
        return new ListSet<IFileSystemArtifact>(FileUtils.copy(this, target), IFileSystemArtifact.class);
    }

    /**
     * Returns the contained file system artifacts, i.e., folder and file artifacts.
     * @return the contained artifacts as collection
     * @throws VilException in case that obtaining the artifacts fails
     */
    public Set<FileArtifact> selectAll() throws VilException { // TODO turn into IFileSystemArtifact
        return getPath().selectAll();
    }

    @Override
    public void artifactChanged(Object cause) throws VilException {
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
     * @throws VilException in case of problems
     */
    @Invisible
    @Conversion
    public static Path convert(FolderArtifact val) throws VilException {
        return val.getPath();
    }

    /**
     * Converts a path into a folder.
     * 
     * @param path the path to be converted
     * @return the resulting folder
     * @throws VilException in case of problems
     */
    @Invisible
    @Conversion
    public static FolderArtifact convert(Path path) throws VilException {
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
    public void store() throws VilException {
        // do nothing, we cannot store a folder
    }
    
    /**
     * Returns whether this artifact is (considered to be) a temporary artifact.
     * 
     * @return <code>true</code> if it is temporary, <code>false</code> else
     */
    public boolean isTemporary() {
        return isTemporary && path.isTemporary();
    }

    @Override
    public void update() throws VilException {
        // TODO check whether functionality is actually needed
    }

    @Override
    public Object determineActualValue(Object object) {
        // by default, for non-existing paths a folder is created
        Object result = object;
        if (object instanceof FileArtifact) {
            FileArtifact file = (FileArtifact) object;
            if (!file.exists()) {
                Path path = file.getPath();
                result = new FolderArtifact(path);
            }
        }
        return result;
    }
    
}
