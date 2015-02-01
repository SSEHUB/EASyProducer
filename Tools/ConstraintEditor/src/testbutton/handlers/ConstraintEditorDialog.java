package testbutton.handlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.uni_hildesheim.sse.ui.embed.EditorUtils;

/**
 * This class realizes a dialog which includes an embedded IVML-editor.
 * 
 * @author kroeher
 *
 */
public class ConstraintEditorDialog extends Dialog {

    private URI resourceURI;
    
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
                f.deleteOnExit();
                FileOutputStream out = new FileOutputStream(f);
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
                resourceURI = f.toURI();
            } catch (IOException e) {
                // dont care for open streams here...
                e.printStackTrace();
            }
        }
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        if (null != resourceURI) {
            // Embed the actual editor
            EditorUtils.embedIvmlEditor(resourceURI, parent);
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
        /*
         *  TODO If "Ok"- or "Cancel"-button is pressed ...
         *  
         *  1. ask if changes shall be saved
         *  2. if 1. == true, save changes in editor to IVML-file
         *  
         *  Maybe add an additional "Save"-button?
         */
        super.buttonPressed(buttonId);
    }
    
}
