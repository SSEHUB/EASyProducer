package test.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.uni_hildesheim.sse.integration.common.IModelInfo;
import de.uni_hildesheim.sse.integration.common.ModelException;
import de.uni_hildesheim.sse.integration.univie.IModel;
import de.uni_hildesheim.sse.integration.univie.IModelAccess;

/**
 * A command for testing the UniVie integration in a static way.
 * 
 * @author Holger Eichelberger
 */
public class TestUniVieCommand2 extends AbstractCommand {

    public static final String PROJECT_NAME = TestIretCommand.PROJECT_NAME;
    public static final String MODEL_NAME = TestIretCommand.MODEL_NAME;

    /**
     * The constructor.
     */
    public TestUniVieCommand2() {
    }

    /**
     * Select variants (Ioanna's code).
     * 
     * @param plProjectPath put in the project path
     * @return the selected variants (...configured variants)
     */
    private String getSelectedVariants(String plProjectPath) {
        if (!plProjectPath.equals("")) {
            Map<String, String> variantValues = new HashMap<String, String>();
            IModelAccess access = IModelAccess.getInstance();
            IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plProjectPath);
            List<IModelInfo> available = access.getAvailableModels(project);
            // List<IModelInfo> available = access.getTopLevelModels(project); // next version
            // access.getMostRecentTopLevelModel(project); // next version
            
            IModel ivml;
            if (!available.isEmpty()) {
                try {
                    ivml = access.obtainModel(available.get(0));
                    for (int v = 0; v < ivml.getVariablesCount(); v++) {
                        variantValues.put(ivml.getVariable(v).getName(), ivml.getVariable(v).getValue());
                        //variantValues.put(ivml.getVariable(v).getName(), ivml.getVariable(v).getDefaultValue());
                    }
                    return variantValues.toString();
                } catch (ModelException e) {
                    e.printStackTrace(System.out);
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
        String result = getSelectedVariants("PL_Warehouse");
        System.out.println(result);
        MessageDialog.openInformation(window.getShell(), "TestUniVie integration result", result);
        return null;
    }
}
