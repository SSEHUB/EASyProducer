package testbutton.handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.uni_hildesheim.sse.ConstraintSyntaxException;
import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor;
import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor.IValidationStateListener;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.persistency.StringProvider;
import net.ssehub.easy.varModel.persistency.ConstraintSplitWriter.IConstraintFilter;
import de.uni_hildesheim.sse.ui.embed.EditorUtils;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;

/**
 * This class realizes a dialog which includes an embedded IVML-editor.
 * 
 * @author kroeher
 *
 */
public class ConstraintEditorDialog extends Dialog implements IValidationStateListener {

    private URI resourceURI;
    private ModelInfo<Project> modelInfo;
    private IEmbeddedEditor editor;
    
    /**
     * The constructor of this dialog.
     * 
     * @param parent the <code>Shell</code> of the active workbench-window.
     */
    public ConstraintEditorDialog(Shell parent) {
        super(parent);
        InputStream in = ConstraintEditorDialog.class.getClassLoader().getResourceAsStream("test.ivml");
        if (null != in) {
            try {
                File f = File.createTempFile("xtextEditorTest", "ivml");
                f.delete();
                f.mkdirs();
                f.deleteOnExit();
                File file = new File(f, "test.ivml");
                FileOutputStream out = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int count;
                do {
                    count = in.read(buffer);
                    if (count > 0) {
                        out.write(buffer, 0, count);
                    }
                } while (count > 0);
                in.close();
                out.close();
                resourceURI = file.toURI();
                // assuming that the loader has been set before!
                VarModel.INSTANCE.locations().addLocation(f, ProgressObserver.NO_OBSERVER);
                List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo("test");
                if (null != infos) {
                    for (int i = 0; i < infos.size(); i++) {
                        ModelInfo<Project> info = infos.get(i);
                        if (info.getLocation().equals(resourceURI)) {
                            modelInfo = info;
                            VarModel.INSTANCE.load(modelInfo);
                        }
                    }
                }
            } catch (IOException e) {
                // don't care for open streams here...
                e.printStackTrace();
            } catch (ModelManagementException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        if (null != resourceURI) {
            // Embed the actual editor
            IConstraintFilter filter = new IConstraintFilter() {
                
                @Override
                public boolean splitAt(IModelElement context, ConstraintSyntaxTree constraint) {
                    return true; // just split at the first one, the remainder constraints are ignored
                }
                
            };
            if (null == modelInfo) {
                EditorUtils.embedIvmlEditor(resourceURI, parent);
            } else {
                editor = EditorUtils.embedIvmlConstraintEditor(modelInfo, parent, filter, false);
                editor.addValidationStateListener(this);
            }
        }
        return container;
    }
    
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Constraint definition dialog");
    }
    
    @Override
    protected Point getInitialSize() {
        return new Point(450, 300);
    }

    @Override
    protected void buttonPressed(int buttonId) {
        try {
            ConstraintSyntaxTree result = EditorUtils.obtainExpression(editor, modelInfo, null);
            System.out.println(StringProvider.toIvmlString(result));
        } catch (CSTSemanticException e) {
            System.out.println(e.getMessage());
        } catch (ConstraintSyntaxException e) {
            System.out.println(e.getMessage());
        } // -> filter
        super.buttonPressed(buttonId);
    }

    @Override
    public void notifyValidationState(final boolean hasErrors) {
        final Button button = getButton(IDialogConstants.OK_ID);
        if (null != button) {
            Display display = Display.getDefault();
            if (!display.isDisposed()) {
                display.asyncExec(new Runnable() {

                    @Override
                    public void run() {
                        button.setEnabled(!hasErrors);
                    }
                });
            }
        }
        
    }
    
}
