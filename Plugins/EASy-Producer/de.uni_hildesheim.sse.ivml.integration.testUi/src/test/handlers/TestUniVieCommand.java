package test.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

import de.uni_hildesheim.sse.integration.common.IConstraint;
import de.uni_hildesheim.sse.integration.common.IModelInfo;
import de.uni_hildesheim.sse.integration.common.ModelException;
import de.uni_hildesheim.sse.integration.univie.IEvaluationResult;
import de.uni_hildesheim.sse.integration.univie.IModel;
import de.uni_hildesheim.sse.integration.univie.IModelAccess;

/**
 * A command for testing the UniVie integration in a static way.
 * 
 * @author Holger Eichelberger
 */
public class TestUniVieCommand extends AbstractCommand {

    public static final String PROJECT_NAME = TestIretCommand.PROJECT_NAME;
    public static final String MODEL_NAME = TestIretCommand.MODEL_NAME;

    /**
     * The constructor.
     */
    public TestUniVieCommand() {
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
                List<IModelInfo> modelInfos = access.getAvailableModels(getProject(PROJECT_NAME));
                if (0 == modelInfos.size()) {
                    throw new ModelException("no model information available for project '"
                        + PROJECT_NAME + "'. Run IRET-Test before?");
                }
                IModelInfo modelInfo = selectModel(modelInfos, MODEL_NAME);
                if (null == modelInfo) {
                    throw new ModelException("no model information available for model '"
                        + MODEL_NAME + "'. Run IRET-Test before?");
                }

                IModel model = access.obtainModel(modelInfo);
                if (null == model) {
                    throw new ModelException("no model instance available for model '"
                        + MODEL_NAME + "'. Run IRET-Test before?");
                }
                List<IConstraint> constraints = new ArrayList<IConstraint>();
                constraints.add(model.createConstraint("intVar < 3"));
                IEvaluationResult result = model.evaluate(constraints);
                if (result.hasConflict()) {
                    throw new ModelException("model is inconsistent");
                } 
                if (result.isReasoningUnsupported()) {
                    MessageDialog.openInformation(window.getShell(),
                            "TestUniVie integration result", 
                            "operation is currently not supported by the actual reasoner");
                } else {
                    if (result.getMessagesCount() > 0) {
                        StringBuilder builder = new StringBuilder();
                        for (int i = 0; i < result.getMessagesCount(); i++) {
                            if (i > 0) {
                                builder.append("\n");
                            }
                            builder.append(result.getMessage(i).getDescription());
                        }
                        throw new ModelException(builder.toString());
                    }
                    if (1 != result.getConstraintCount()) {
                        throw new ModelException("unexpected size of result set (" 
                            + result.getConstraintCount() + " != 1)");
                    }
                    MessageDialog.openInformation(window.getShell(),
                            "TestUniVie integration result", result.getEvaluationResult(0).toString());
                }
                model.close();
            } else {
                MessageDialog.openInformation(window.getShell(),
                    "TestUniVie integration", "not active");
            }
        } catch (ModelException e) {
            MessageDialog.openInformation(window.getShell(),
                "TestUniVie integration problem", e.getMessage());
        }
        return null;
    }
}
