package de.uni_hildesheim.sse.easy.ui.productline_editor.PTNSelectionDialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;

/**
 * Dialog for (de-)selecting predecessor projects.
 * @author Crowder, Schniedermeyer, Hundt
 *
 */
public class PtnSelectionDialog extends Dialog {

    private ArrayList<String> result;
    private CheckboxTableViewer pTNlist;
    private String projectID;

    /**
     * Sole constructor.
     * 
     * @param parent The parent shell
     * @param style The style
     * @param projectID The id of current plp
     */
    public PtnSelectionDialog(Shell parent, int style, String projectID) {
        // Let users override the default styles
        super(parent, style);
        this.projectID = projectID;
    }

    /**
     * Opens the dialog and returns the input.
     * 
     * @return String
     */
    public ArrayList<String> open() {
        // Create the dialog window
        Shell shell = new Shell(getParent(), getStyle());
        shell.setText("Choose Predecessor Product Lines");
        createContents(shell);

        // Move the dialog to the center of the top level shell.
        Rectangle shellBounds = getParent().getBounds();
        Point dialogSize = shell.getSize();
        shell.setLocation(shellBounds.x + (shellBounds.width - dialogSize.x) / 2, shellBounds.y
                + (shellBounds.height - dialogSize.y) / 2);

        shell.open();
        Display display = getParent().getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        return result;
    }

    /**
     * Creates the dialog's contents.
     * 
     * @param shell the dialog window
     */
    private void createContents(final Shell shell) {
        shell.setLayout(new GridLayout(2, true));
        shell.setSize(400, 300);
        // Show the message
        Label label = new Label(shell, SWT.NONE);
        label.setText("Choose PTNs:");
        GridData data = new GridData();
        data.horizontalSpan = 2;
        label.setLayoutData(data);

        // Display the input box
        pTNlist = CheckboxTableViewer.newCheckList(shell, SWT.BORDER);
        data = new GridData(GridData.FILL_HORIZONTAL);
        data.horizontalSpan = 2;
        data.verticalSpan = 4;
        // pTNlist.getControl().setSize(100, 250);
        pTNlist.getControl().setLayoutData(data);
        pTNlist.setLabelProvider(new PTNSelectionDialogLabelProvider());

        pTNlist.setContentProvider(new PTNSelectionDialogContentProvider());

        refreshData();

        // Create the OK button and add a handler
        // so that pressing it will set input
        // to the entered value
        Button ok = new Button(shell, SWT.PUSH);
        ok.setText("OK");
        data = new GridData(GridData.FILL_HORIZONTAL);
        ok.setLayoutData(data);
        ok.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                // Return the entered value, or null
                result = new ArrayList<String>();
                Object[] returnArray = pTNlist.getCheckedElements();

                for (int i = 0; i < returnArray.length; i++) {
                    if (returnArray[i] instanceof String) {
                        result.add((String) returnArray[i]);
                    }
                }

                shell.close();
            }
        });

        // Create the cancel button and add a handler
        // so that pressing it will set input to null
        Button cancel = new Button(shell, SWT.PUSH);
        cancel.setText("Cancel");
        data = new GridData(GridData.FILL_HORIZONTAL);
        cancel.setLayoutData(data);
        cancel.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                result = null;
                shell.close();
            }
        });

        // Set the OK button as the default, so
        // user can type input and press Enter
        // to dismiss
        shell.setDefaultButton(ok);
    }

    /**
     * Sets the input of the CheckboxTableViewer to refresh the contents of the view.
     */
    public void refreshData() {
        PLPInfo plp = SPLsManager.INSTANCE.getPLP(projectID);
        List<String> input = plp.getMemberController().getPossiblePredecessors();

        pTNlist.setInput(input.toArray());

        // Set the selection of the CheckboxViewer
        pTNlist.setCheckedElements(plp.getMemberController().getPredecessorIDs().toArray());

        // pTNlist.setGrayedElements(grayedElements.toArray());
    }

}
