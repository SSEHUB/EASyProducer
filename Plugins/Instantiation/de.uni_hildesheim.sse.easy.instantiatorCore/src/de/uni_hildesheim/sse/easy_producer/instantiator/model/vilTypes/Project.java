package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FolderArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Represents the physical project we are operating on. Call {@link #release()}
 * if the instance is not used anymore.
 * 
 * @author Holger Eichelberger
 */
public class Project implements IVilType, IStringValueProvider {

    // TODO move to artifact model package
    private ArtifactModel artifactModel;
    private File base;

    /**
     * Creates an empty project without scanning. Just for testing.
     */
    public Project() {
        this.base = new File(".");
        artifactModel = ArtifactFactory.createArtifactModel(base);
    }
    
    /**
     * Creates a project for a given <code>base</code> directory.
     * 
     * @param base the base directory (shall be an absolute path)
     * @param observer to notify the caller in case of long-running scans
     * @throws ArtifactException in case that the creation of artifacts fails
     */
    public Project(File base, ProgressObserver observer) throws ArtifactException {
        this.base = base.getAbsoluteFile();
        artifactModel = ArtifactFactory.createArtifactModel(base);
        artifactModel.scanAll(observer);
    }
     
    /**
     * Returns the name of the project.
     * 
     * @return the name of the project
     */
    public String getName() {
        return base.getName();
    }
    
    /**
     * Returns all files.
     * 
     * @return all files
     */
    @OperationMeta(returnGenerics = { FileArtifact.class } )
    public Set<FileArtifact> selectAllFiles() {
        return artifactModel.selectByType(FileArtifact.class);
    }

    /**
     * Returns all folders.
     * 
     * @return all folders
     */
    @OperationMeta(returnGenerics = { FolderArtifact.class } )
    public Set<FolderArtifact> selectAllFolders() {
        return artifactModel.selectAllFolders();
    }
    
    /**
     * Returns the path of this project.
     * 
     * @return the path
     */
    public Path getPath() {
        return new Path(".", artifactModel);
    }
    
    /**
     * Localizes the given <code>path</code> taken from source with respect to this project.
     * 
     * @param source the source project
     * @param path the target path
     * @return the localized path
     */
    public Path localize(Project source, Path path) {
        return new Path(path, artifactModel);
    }

    /**
     * Localizes the given <code>path</code> taken from source with respect to this project.
     * 
     * @param source the source project
     * @param artifact the target artifact
     * @return the localized path
     * @throws ArtifactException in case that localization is not possible due to <code>artifact</code>
     */
    public Path localize(Project source, IFileSystemArtifact artifact) throws ArtifactException {
        return new Path(artifact.getPath(), artifactModel);
    }

    /**
     * Returns the local project artifacts.
     * 
     * @return the local artifacts
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public Set<FileArtifact> getLocalProjectArtifacts() {
        return getPath().selectAll();
    }
    
    /**
     * Does type selection of artifacts.
     * 
     * @param type the target type
     * @return the selected artifacts (the type will be adjusted to the actual
     *   type of <code>type</code>)
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public Set<FileArtifact> selectByType(Class<? extends IVilType> type) {
        return artifactModel.selectByType(type);
    }

    /**
     * Does name selection of artifacts.
     * 
     * @param name the regular name pattern for artifact selection
     * @return the selected artifacts
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public Set<FileArtifact> selectByName(String name) {
        return artifactModel.selectByName(name);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        String result;
        if (null != comparator && comparator.inTracer()) {
            result = "<project>"; // may differ and disturb test results
        } else {
            result = artifactModel.getBasePath(); // this is a full system-dependent path
        }
        return result;
    }
    
    /**
     * Returns the path to the EASy files.
     * 
     * @return the path to the EASy files
     */
    public Path getEasyFolder() {
        return new Path("EASy", artifactModel); // TODO make generic -> ScaleLog
    }
    
    /**
     * Releases this instance and the related artifact model.
     */
    @Invisible
    public void release() {
        if (null != artifactModel) {
            ArtifactFactory.release(artifactModel);
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }
    
    /**
     * Returns the underlying artifact model.
     * 
     * @return the underlying artifact model
     */
    @Invisible
    public ArtifactModel getArtifactModel() {
        return artifactModel;
    }
    
    /**
     * Converts a project to its base path.
     * 
     * @param project the project to be converted
     * @return the base path of <code>project</code>
     */
    @Conversion
    public static Path convert(Project project) {
        return project.getPath();
    }
 
}
