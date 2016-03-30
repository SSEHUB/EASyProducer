package net.ssehub.easy.instantiation.java.mocks;
//
//import java.io.File;
//import java.io.InputStream;
//import java.net.URI;
//import java.util.Map;
//
//import org.eclipse.core.resources.IBuildConfiguration;
//import org.eclipse.core.resources.IFile;
//import org.eclipse.core.resources.IFilterMatcherDescriptor;
//import org.eclipse.core.resources.IMarker;
//import org.eclipse.core.resources.IPathVariableManager;
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IProjectDescription;
//import org.eclipse.core.resources.IProjectNatureDescriptor;
//import org.eclipse.core.resources.IResource;
//import org.eclipse.core.resources.IResourceChangeListener;
//import org.eclipse.core.resources.IResourceRuleFactory;
//import org.eclipse.core.resources.ISaveParticipant;
//import org.eclipse.core.resources.ISavedState;
//import org.eclipse.core.resources.ISynchronizer;
//import org.eclipse.core.resources.IWorkspace;
//import org.eclipse.core.resources.IWorkspaceDescription;
//import org.eclipse.core.resources.IWorkspaceRoot;
//import org.eclipse.core.resources.IWorkspaceRunnable;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.IPath;
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.core.runtime.Plugin;
//import org.eclipse.core.runtime.jobs.ISchedulingRule;
//
///**
// * Experimental mocks.
// * @author Aike Sass
// *
// */
//public class WorkspaceMock extends AbstractResourceMock implements IWorkspace {
//    
//    /**
//     * Default Constructor.
//     * 
//     * @param file file
//     */
//    public WorkspaceMock(File file) {
//        super(file);
//    }
//
//    @Override
//    public <T> T getAdapter(Class<T> adapter) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void addResourceChangeListener(IResourceChangeListener listener) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void addResourceChangeListener(IResourceChangeListener listener, int eventMask) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public ISavedState addSaveParticipant(Plugin plugin, ISaveParticipant participant) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public ISavedState addSaveParticipant(String pluginId, ISaveParticipant participant) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void build(int kind, IProgressMonitor monitor) throws CoreException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void build(IBuildConfiguration[] buildConfigs, int kind, boolean buildReferences, IProgressMonitor monitor)
//            throws CoreException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void checkpoint(boolean build) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public IProject[][] computePrerequisiteOrder(IProject[] projects) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public ProjectOrder computeProjectOrder(IProject[] projects) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus copy(IResource[] resources, IPath destination, boolean force, IProgressMonitor monitor)
//            throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus copy(IResource[] resources, IPath destination, int updateFlags, IProgressMonitor monitor)
//            throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus delete(IResource[] resources, boolean force, IProgressMonitor monitor) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus delete(IResource[] resources, int updateFlags, IProgressMonitor monitor) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void deleteMarkers(IMarker[] markers) throws CoreException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void forgetSavedTree(String pluginId) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public IFilterMatcherDescriptor[] getFilterMatcherDescriptors() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IFilterMatcherDescriptor getFilterMatcherDescriptor(String filterMatcherId) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IProjectNatureDescriptor[] getNatureDescriptors() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IProjectNatureDescriptor getNatureDescriptor(String natureId) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public Map<IProject, IProject[]> getDanglingReferences() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IWorkspaceDescription getDescription() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IWorkspaceRoot getRoot() {
//        return new WorkspaceRootMock(getJavaFile());
//    }
//
//    @Override
//    public IResourceRuleFactory getRuleFactory() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public ISynchronizer getSynchronizer() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public boolean isAutoBuilding() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public boolean isTreeLocked() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public IProjectDescription loadProjectDescription(IPath projectDescriptionFile) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IProjectDescription loadProjectDescription(InputStream projectDescriptionFile) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus move(IResource[] resources, IPath destination, boolean force, IProgressMonitor monitor)
//            throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus move(IResource[] resources, IPath destination, int updateFlags, IProgressMonitor monitor)
//            throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IBuildConfiguration newBuildConfig(String projectName, String configName) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IProjectDescription newProjectDescription(String projectName) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void removeResourceChangeListener(IResourceChangeListener listener) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void removeSaveParticipant(Plugin plugin) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void removeSaveParticipant(String pluginId) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void run(IWorkspaceRunnable action, ISchedulingRule rule, int flags, IProgressMonitor monitor)
//            throws CoreException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void run(IWorkspaceRunnable action, IProgressMonitor monitor) throws CoreException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public IStatus save(boolean full, IProgressMonitor monitor) throws CoreException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void setDescription(IWorkspaceDescription description) throws CoreException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public String[] sortNatureSet(String[] natureIds) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateEdit(IFile[] files, Object context) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateFiltered(IResource resource) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateLinkLocation(IResource resource, IPath location) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateLinkLocationURI(IResource resource, URI location) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateName(String segment, int typeMask) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateNatureSet(String[] natureIds) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validatePath(String path, int typeMask) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateProjectLocation(IProject project, IPath location) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IStatus validateProjectLocationURI(IProject project, URI location) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public IPathVariableManager getPathVariableManager() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//}
