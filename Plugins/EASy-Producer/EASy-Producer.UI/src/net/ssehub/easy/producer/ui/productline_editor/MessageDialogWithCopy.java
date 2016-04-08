/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.productline_editor;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * SWT MEssagebox with a text field allowing copy pasting the message.
 * @see <a href="http://stackoverflow.com/questions/30630092/copy-and-paste-messagedialog-message">
 * http://stackoverflow.com/questions/30630092/copy-and-paste-messagedialog-message</a>
 * @author El-Sharkawy
 */
public class MessageDialogWithCopy extends MessageDialog {
    
    /**
     * Single constructor for this class.
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level shell
     * @param dialogTitle
     *            the dialog title, or <code>null</code> if none
     * @param dialogTitleImage
     *            the dialog title image, or <code>null</code> if none
     * @param dialogMessage
     *            the dialog message
     * @param dialogImageType
     *            one of the following values:
     *            <ul>
     *            <li><code>MessageDialog.NONE</code> for a dialog with no
     *            image</li>
     *            <li><code>MessageDialog.ERROR</code> for a dialog with an
     *            error image</li>
     *            <li><code>MessageDialog.INFORMATION</code> for a dialog
     *            with an information image</li>
     *            <li><code>MessageDialog.QUESTION </code> for a dialog with a
     *            question image</li>
     *            <li><code>MessageDialog.WARNING</code> for a dialog with a
     *            warning image</li>
     *            </ul>
     * @param dialogButtonLabels
     *            an array of labels for the buttons in the button bar
     * @param defaultIndex
     *            the index in the button label array of the default button
     */
    //checkstyle: stop parameter number check
    public MessageDialogWithCopy(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage,
        int dialogImageType, String[] dialogButtonLabels, int defaultIndex) {
        
        super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, dialogButtonLabels,
            defaultIndex);
    }
    //checkstyle: resume parameter number check

    @Override
    protected Control createMessageArea(final Composite composite) {
        Image image = getImage();
        if (image != null) {
            imageLabel = new Label(composite, SWT.NULL);
            image.setBackground(imageLabel.getBackground());
            imageLabel.setImage(image);

            imageLabel.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, false, false));
        }

        // Use Text control for message to allow copy

        if (message != null) {
            Text msg = new Text(composite, SWT.READ_ONLY | SWT.MULTI);

            msg.setText(message);

            GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
            data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);

            msg.setLayoutData(data);
        }

        return composite;
    }
}
