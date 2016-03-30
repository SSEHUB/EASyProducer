package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.io.File;
import java.util.HashMap;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FolderArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.ProjectSettings;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IProjectDescriptor.ModelKind;

/**
 * Represents the physical project we are operating on. Call {@link #release()}
 * if the instance is not used anymore.
 * 
 * @author Holger Eichelberger
 */
public class Project implements IVilType, IStringValueProvider {

    private static final java.util.Map<String, Project> CACHE = new HashMap<String, Project>();
    private ArtifactModel artifactModel;
    private File base;
    private IProjectDescriptor descriptor;
    private boolean empty;
    private String name;

    /**
     * Creates an empty project without scanning. Just for testing.
     */
    public Project() {
        this.base = new File(".");
        this.empty = true;
        artifactModel = ArtifactFactory.createArtifactModel(base);
    }
    
    /**
     * Creates a project for a given <code>base</code> directory.
     * 
     * @param base the base directory (shall be an absolute path)
     * @param observer to notify the caller in case of long-running scans
     * @throws VilException in case that the creation of artifacts fails
     */
    public Project(File base, ProgressObserver observer) throws VilException {
        this.base = base.getAbsoluteFile();
        name = base.getName();
        this.empty = false;
        artifactModel = ArtifactFactory.createArtifactModel(base);
        artifactModel.scanAll(observer);
    }
    
    /**
     * Creates a new project by for the base directory given in <code>project</code>. Please note that this
     * constructor is intended to be called to re-instantiate <code>project</code> after {@link #release()} has been 
     * called on <code>project</code>. Thereby, the instance created by this constructor is fully initialized with a 
     * artifact model and, dependent on <code>project</code>, also an artifact scan is executed. This constructor is
     * mainly intended to allow testing based on the VIL execution visitor and the VIL executor afterwards in sequence.
     * 
     * @param project the project the data shall be taken from
     * @param observer to notify the caller in case of long-running scans
     * @throws VilException in case that the creation of artifacts fails
     */
    public Project(Project project, ProgressObserver observer) throws VilException {
        this.base = project.base;
        this.empty = project.empty;
        this.name = project.name;
        this.artifactModel = ArtifactFactory.createArtifactModel(this.base);
        if (!this.empty) {
            artifactModel.scanAll(observer);    
        }
    }
    
    /**
     * Creates a project based on a given <code>descriptor</code>.
     * 
     * @param descriptor the descriptor to create the project for
     * @param observer to notify the caller in case of long-running scans
     * @throws VilException in case that the creation of artifacts fails
     */
    private Project(IProjectDescriptor descriptor, ProgressObserver observer) 
        throws VilException {
        this(descriptor.getBase().getAbsoluteFile(), observer);
        this.descriptor = descriptor;
        if (null != descriptor.getMainVilScript()) {
            this.name = descriptor.getMainVilScript().getName();
        }
    }
    
    /**
     * Returns the name of the project.
     * 
     * @return the name of the project
     */
    public String getName() {
        return name;
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
     * @throws VilException in case that localization is not possible due to <code>artifact</code>
     */
    public Path localize(Project source, IFileSystemArtifact artifact) throws VilException {
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
    public Set<FileArtifact> selectByType(Class<?> type) {
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

    /**
     * Returns a cached project or caches a new one for <code>descriptor</code>.
     * This method shall only be called on the root successor as caching will only work there!
     * 
     * @param descriptor the descriptor to return the project for
     * @return the related project
     * @throws VilException in case that creating / scanning the project base fails
     */
    public static Project getProjectFor(IProjectDescriptor descriptor) throws VilException {
        String key = descriptor.getBase().getAbsoluteFile().toString();
        Project result = CACHE.get(key);
        if (null == result) {
            result = new Project(descriptor, descriptor.createObserver());            
            CACHE.put(key, result);
        }
        return result;
    }
    
    /**
     * Clears the project descriptor cache. Handle with care and do not call this during a VIL execution!
     */
    public static void clearProjectDescriptorCache() {
        CACHE.clear();
    }

    /**
     * Returns the predecessors of this project.
     * 
     * @return the predecessors
     * @throws VilException in case that creating / scanning the project base fails
     */
    @OperationMeta(returnGenerics = Project.class)
    public Set<Project> predecessors() throws VilException {
        Project[] tmp;
        if (null != descriptor) {
            int count = descriptor.getPredecessorCount();
            tmp = new Project[count];
            for (int p = 0; p < count; p++) {
                tmp[p] = getProjectFor(descriptor.getPredecessor(p));
            }
        } else {
            tmp = new Project[0];
        }
        return new ArraySet<Project>(tmp, Project.class);
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
        return createPathWithFallback(ModelKind.IVML);
    }

    /**
     * Returns the path to the IVML model files.
     * 
     * @return the path to the IVML model files
     */
    public Path getIvmlFolder() {
        return createPathWithFallback(ModelKind.IVML);
    }

    /**
     * Returns the path to the VIL model files.
     * 
     * @return the path to the VIL model files
     */
    public Path getVilFolder() {
        return createPathWithFallback(ModelKind.VIL);
    }

    /**
     * Returns the path to the VTL model files.
     * 
     * @return the path to the VTL model files
     */
    public Path getVtlFolder() {
        return createPathWithFallback(ModelKind.VTL);
    }
    
    /**
     * Creates a model path with default fallback.
     * 
     * @param kind the kind of the models
     * @return the path
     */
    private Path createPathWithFallback(ModelKind kind) {
        String path = null;
        if (null != descriptor) {
            path = descriptor.getModelFolder(kind);
        }
        if (null == path) {
            path = "EASy"; // fallback, shall be a constant
        }
        return new Path(path, artifactModel);
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
    
    /**
     * Returns the main VIL script of the project.
     * 
     * @return the main VIL script
     */
    public Script getMainVilScript() {
        Script result;
        if (null != descriptor) {
            result = descriptor.getMainVilScript();
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Sets the settings for the artifact model.
     * 
     * @param key ID for the settings object
     * @param object the settings
     */
    public void setSettings(ProjectSettings key, Object object) {
        artifactModel.setSettings(key, object);
    }
    
    /**
     * Returns the settings object for the specified key.
     * 
     * @param key the key assigned to the settings object
     * @return the settings object
     */
    public Object getSettings(ProjectSettings key) {
        return artifactModel.getSettings(key);
    }
    
    

 
}
