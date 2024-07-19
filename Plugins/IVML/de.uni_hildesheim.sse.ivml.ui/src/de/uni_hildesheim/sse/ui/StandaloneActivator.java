package de.uni_hildesheim.sse.ui;

import java.io.File;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * The activator class controls the plug-in life cycle. This class is required only if the IVML editor 
 * shall be used as a standalone plugin in Eclipse. EASy-Producer does not need this code, which aims at loading
 * all projects from the workspace root. In order to reduce the number of plugins, we refrained
 * from creating an own plugin project for that activator. If you want to use that activator, please change the
 * manifest as part of the packaging/deployment activities. In case that you want aim at using the
 * resolver from the ReasonerCore, please call
 * <code>
 *   de.uni_hildesheim.sse.reasoning.core.importResolver.ReasoningImportResolver.registerAsTopResolver();
 * </code>
 * before activating the IVML UI via this activator. 
 */
public class StandaloneActivator extends Activator {

    private BundleContext context;
    
    /**
     * Returns the workspace root as file.
     * 
     * @return the workspace root as file
     */
    private File getWorkspaceRoot() {
        ServiceTracker<IWorkspace, IWorkspace> workspaceTracker = new ServiceTracker<>(context, IWorkspace.class, null);
        workspaceTracker.open();
        IWorkspace workspace = workspaceTracker.getService();        
        return workspace.getRoot().getLocation().toFile();
    }
    
    @Override
    public void start(BundleContext context) throws Exception {
        this.context = context;
        super.start(context);
        // now done automatically ModelUtility.setResourceInitializer(new EclipseResourceInitializer());
        ObservableWorkspaceJob job = new ObservableWorkspaceJob("IVML startup task") {
                
            @Override
            protected IStatus doJob() throws CoreException {
                //try {
                    File root = getWorkspaceRoot();
                    File metaRoot = new File(root, ".metadata");
                    VarModel.INSTANCE.locations().addExcludedLocation(metaRoot);
                    //done via DS: VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, getObserver());
                //} catch (ModelManagementException e) {
                    // unclear
                //}
                return Status.OK_STATUS;
            }
        };
        job.schedule();
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        ObservableWorkspaceJob job = new ObservableWorkspaceJob("IVML startup task") {
                
            @Override
            protected IStatus doJob() throws CoreException {
                File root = getWorkspaceRoot();
                File metaRoot = new File(root, ".metadata");
                try {
                    VarModel.INSTANCE.locations().removeLocation(root, getObserver());
                    VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, getObserver());
                    VarModel.INSTANCE.locations().removeExcludedLocation(metaRoot);
                } catch (ModelManagementException e) {
                    throw new CoreException(new Status(IStatus.ERROR, "ivml.ui", 0, e.getMessage(), e));
                }
                return Status.OK_STATUS;
            }
        };
        job.schedule();
        super.stop(context);
    }

}
