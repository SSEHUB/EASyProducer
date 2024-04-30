package net.ssehub.easy.producer.ui.core;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.productline_editor.ProductLineEditorInput;

/**
 * Static functions used inside the GUI, e.g. open an editor.
 * @author El-Sharkawy
 *
 */
public class GUIUtils {

    /**
     * Should prevent instantiation.
     */
    private GUIUtils() {}
    
    /**
     * Opens the {@link net.ssehub.easy.producer.ui.productline_editor.Editor} for the given
     * {@link ProductLineProject}.
     * @param plp An existing and loaded {@link ProductLineProject}, which should be edited inside the
     *     {@link net.ssehub.easy.producer.ui.productline_editor.Editor}.
     * @throws PartInitException if the editor could not be created or initialized
     */
    public static void openProductLineEditor(ProductLineProject plp) throws PartInitException {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry()
            .findEditor("de.uni_hildesheim.sse.easy_producer.ProductLineConfigurationEditor.new");
        page.openEditor(new ProductLineEditorInput(plp), desc.getId());
    }
    
    /**
     * Opens an IVML file with the given file name (project name) inside the IVML-Editor.
     * @param plp The ProductLineProject which contains the desired IVML file.
     * @param projectName The project name of the desired IVML file (file name without the .ivml extension).
     * @throws PartInitException if the editor could not be created or initialized 
     */
    public static void openProject(PLPInfo plp, String projectName) throws PartInitException {

        File projectFile = new File(plp.getConfigLocation(), projectName + ".ivml");
        openFileInWS(projectFile);
    }

    /**
     * Opens the specified <code>file</code> inside an appropriate editor, e.g. a IVML file inside the IVML editor.
     * The file must be located inside the workspace.
     * @param file The file which shall be opened in an IVML-Editor.
     * @throws PartInitException if the editor could not be created or initialized
     */
    public static void openFileInWS(File file) throws PartInitException {

        IPath location = Path.fromOSString(file.getAbsolutePath());
        IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(location);
        openFileInEditor(iFile);
    }

    /**
     * Open the given file in an appropriate editor.
     * 
     * @param file The file to open.
     * @throws PartInitException if the editor could not be created or initialized
     */
    private static void openFileInEditor(IFile file) throws PartInitException {
        
        // Get the active page.
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        // Figure out the default editor for the file type based on extension.
        IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
        if (desc != null) {
            // Try opening the page in the editor.
            page.openEditor(new FileEditorInput(file), desc.getId());
        }

    }
    
    /**
     * Opens an appropriate editor to edit specific parts of the given {@link ProductLineProject}.
     * @param plp The {@link ProductLineProject} which shall be edited.
     * @param desiredEditor Specification which part of the {@link ProductLineProject} should be edited.
     * @throws PartInitException if the editor could not be created or initialized
     */
    public static void openEditor(ProductLineProject plp, EditorType desiredEditor) throws PartInitException {
        String configPath = plp.getConfigLocation().getAbsolutePath();
        switch (desiredEditor) {
        case PRODUCT_LINE_PROJECT:
            openProductLineEditor(plp);
            break;
        case VARMODEL:
            String projectPath = PersistenceUtils.ivmlFileLocation(plp.getProject(), configPath);
            File projectFile = new File(projectPath);
            openFileInWS(projectFile);
            break;
        case BUILD_SCRIPT:
            String scriptPath = PersistenceUtils.vilFileLocation(plp.getBuildScript(), configPath);
            File scriptFile = new File(scriptPath);
            openFileInWS(scriptFile);
            break;
        default:
            break;
        }
    }
}
