/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.easy.ui.productline_editor.predecessorSelection;

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

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;

/**
 * Dialog for (de-)selecting predecessor projects.
 * @author Crowder
 * @author Schniedermeyer
 * @author Hundt
 * @author El-Sharkawy
 *
 */
public class PredecessorSelectionDialog extends Dialog {

    private ArrayList<String> result;
    private CheckboxTableViewer predecessorList;
    private String projectID;

    /**
     * Sole constructor.
     * 
     * @param parent The parent shell
     * @param style The style
     * @param projectID The id of current plp
     */
    public PredecessorSelectionDialog(Shell parent, int style, String projectID) {
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
        label.setText("Choose Predecessor Product Line Projects:");
        GridData data = new GridData();
        data.horizontalSpan = 2;
        label.setLayoutData(data);

        // Display the input box
        predecessorList = CheckboxTableViewer.newCheckList(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
        GridData listData = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
        listData.horizontalSpan = 2;
        listData.verticalSpan = 1;
        listData.heightHint = 180;
        predecessorList.getControl().setLayoutData(listData);
        predecessorList.setLabelProvider(new PTNSelectionDialogLabelProvider());

        predecessorList.setContentProvider(new PTNSelectionDialogContentProvider());

        refreshData();

        // Create the OK button and add a handler
        // so that pressing it will set input
        // to the entered value
        Button ok = new Button(shell, SWT.PUSH);
        ok.setText("OK");
        ok.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        ok.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                // Return the entered value, or null
                result = new ArrayList<String>();
                Object[] returnArray = predecessorList.getCheckedElements();

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
        cancel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
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

        predecessorList.setInput(input.toArray());

        // Set the selection of the CheckboxViewer
        predecessorList.setCheckedElements(plp.getMemberController().getPredecessorIDs().toArray());

        // pTNlist.setGrayedElements(grayedElements.toArray());
    }

}
