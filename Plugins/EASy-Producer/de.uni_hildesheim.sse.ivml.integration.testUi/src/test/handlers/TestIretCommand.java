package test.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

import de.uni_hildesheim.sse.integration.common.IConstraint;
import de.uni_hildesheim.sse.integration.common.ModelException;
import de.uni_hildesheim.sse.integration.iret.IModel;
import de.uni_hildesheim.sse.integration.iret.IModelAccess;

/**
 * A command for testing the IRET integration in a static way.
 * 
 * @author Holger Eichelberger
 */
public class TestIretCommand extends AbstractCommand {

    public static final String PROJECT_NAME = "test";
    public static final String MODEL_NAME = "model";
    
    /**
     * The constructor.
     */
    public TestIretCommand() {
    }

    /**
     * {@inheritDoc}
     */
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchWindow window = HandlerUtil
                .getActiveWorkbenchWindowChecked(event);
        try {
            IModelAccess access = IModelAccess.getInstance();
            if (null != access) {
                IModel model = access.createModel(MODEL_NAME);
                model.addVariable("intVar", "Integer", "compile", "1");
                IConstraint constraint = model.createConstraint("intVar < 3");
                model.addConstraint(constraint);
                model.close(null);
            } else {
                MessageDialog.openInformation(window.getShell(),
                        "TestIret integration", "not active");
            }
        } catch (ModelException e) {
            MessageDialog.openInformation(window.getShell(),
                    "TestIret problem", e.getMessage());
        }
        return null;
    }
}
