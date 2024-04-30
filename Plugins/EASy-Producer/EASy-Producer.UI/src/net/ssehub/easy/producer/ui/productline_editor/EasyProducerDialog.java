package net.ssehub.easy.producer.ui.productline_editor;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.producer.eclipse.EASyProducerConstants;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Error and Info Box for EASy-Producer. This class should be used to have a global look and feel for error and info
 * dialogs.
 * 
 * @author El-Sharkawy
 * @author Kapeluch
 */
public class EasyProducerDialog {

    /**
     * Opens a specific dialog with the given parameters.
     * 
     * @param message The message to be shown in the message box.
     * @param title The title in the top of the window
     * @param style The SWT Style, which specifies the behavior of the dialog
     * @param parent The caller of this dialog.
     * @return The result of the dialog or <code>0</code>
     */
    private static int showDialog(Shell parent, String message, String title, int style) {
        int result = 0;
        if (message != null) {
            Shell shell = new Shell(parent);
            MessageBox messageBox = new MessageBox(shell, style);
            messageBox.setText(title);
            messageBox.setMessage(message);
            result =  messageBox.open();
        }
        
        return result;
    }

    /**
     * Creates an error dialog.
     * 
     * @param message The error message
     * @param parent The caller of this dialog.
     * @return <b>SWT.OK</b> after the dialog is confirmed.
     */
    public static int showErrorDialog(Shell parent, String message) {
        return showDialog(parent, message, EASyProducerConstants.EASY_PRODUCER_ERROR, SWT.OK | SWT.ICON_ERROR);
    }
    
    /**
     * Creates an error dialog.
     * 
     * @param message The error message
     * @return <b>SWT.OK</b> after the dialog is confirmed.
     */
    public static int showErrorDialog(String message) {
        return showDialog(new Shell(), message, EASyProducerConstants.EASY_PRODUCER_ERROR, SWT.OK | SWT.ICON_ERROR);
    }
    
    /**
     * Creates an error dialog.
     * 
     * @param parent The caller of this dialog.
     * @param messages The error messages
     * @return <b>SWT.OK</b> after the dialog is confirmed or <code>0</code>.
     */
    public static int showReasonerErrorDialog(Shell parent, Message... messages) {
        StringBuffer errorMsg = new StringBuffer("Following errors occured:");
        return showReasonerDialog(parent, SWT.ICON_ERROR, EASyProducerConstants.EASY_PRODUCER_ERROR, errorMsg,
            messages);
    }
    
    /**
     * Creates an warning dialog.
     * 
     * @param parent The caller of this dialog.
     * @param messages The warning messages
     * @return <b>SWT.OK</b> after the dialog is confirmed or <code>0</code>.
     */
    public static int showReasonerWarningDialog(Shell parent, Message... messages) {
        StringBuffer warningMsg = new StringBuffer("Following warnings occured:");
        return showReasonerDialog(parent, SWT.ICON_WARNING, EASyProducerConstants.EASY_PRODUCER_INFO, warningMsg,
            messages);
    }

    /**
     * Creates a dialog displaying the result of an earlier reasoner call.
     * @param parent The caller of this dialog.
     * @param messageBoxStyle
     * <ul>
     * <li><code>SWT.ICON_ERROR</code></li>
     * <li><code>SWT.ICON_INFORMATION</code></li>
     * <li>...</li>
     * </ul>
     * @param title Should match to the given icon.
     * <ul>
     * <li><code>EASyProducerConstants.EASY_PRODUCER_ERROR</code></li>
     * <li><code>EASyProducerConstants.EASY_PRODUCER_INFO</code></li>
     * <li>...</li>
     * </ul>
     * @param msg The beginning of the message, which shall be displayed.
     * @param messages The messages to be displayed
     * @return <b>SWT.OK</b> after the dialog is confirmed or <code>0</code>.
     */
    private static int showReasonerDialog(Shell parent, int messageBoxStyle, String title, StringBuffer msg,
        Message... messages) {

        int returnValue = 0;
        boolean hasConflict = false;
        if (messages != null && messages.length > 0) {
            for (int i = 0; i < messages.length; i++) {
                Message oneMsg = messages[i];
                hasConflict |= oneMsg.getStatus() == Status.ERROR;
                msg.append("\n");
                msg.append(oneMsg.getDescription());
                List<ModelElement> conflicts = oneMsg.getConflicts();
                List<String> labels = oneMsg.getConflictLabels();
                if (null != labels && !labels.isEmpty()) {
                    for (int j = 0; j < labels.size(); j++) {
                        msg.append("\n - ");
                        msg.append(labels.get(j));
                    }
                } else if (conflicts.size() > 0) {
                    msg.append(":");
                    for (int j = 0; j < conflicts.size(); j++) {
                        ModelElement conflictingElement = conflicts.get(j);
                        if (null != conflictingElement) {
                            msg.append("\n - ");
                            String conflict = StringProvider.toIvmlString(conflictingElement);
                            conflict = conflict.replaceAll("\n", "");
                            conflict = conflict.replaceAll(";", "");
                            msg.append(conflict);
                        }
                    }
                }
            }
            
            returnValue = showDialog(parent, title, msg.toString(), hasConflict);
        }
        
        return returnValue;
    }
    
    /**
     * Creates a dialog box, from where the error message can be copy-pasted to somewhere.
     * @param parent The caller of this dialog, maybe <code>null</code>.
     * @param title The title of the dialog, should be either {@link EASyProducerConstants#EASY_PRODUCER_ERROR} or
     *     {@link EASyProducerConstants#EASY_PRODUCER_INFO}
     * @param message The message to display on the dialog.
     * @param isError Specification whether the displayed message is an error or only an information.
     *     <code>true</code> a read error icon will be shown, <code>false</code>an info icon will be shown
     * @return A window's return codes are window-specific, although two standard return codes are predefined:
     * <code>Window.OK</code> and <code>Window.CANCEL</code>.
     */
    public static int showDialog(Shell parent, String title, String message, boolean isError) {
        Shell shell = parent != null ? new Shell(parent) : new Shell();
        int swtImage = isError ? MessageDialog.ERROR : MessageDialog.INFORMATION;
        MessageDialogWithCopy msgDialog = new MessageDialogWithCopy(shell, title, null, message, swtImage,
            new String[] {"OK"}, 0);
        
        return msgDialog.open();
    }
    
    /**
     * Shows an info dialog.
     * 
     * @param parent The caller of this dialog.
     * @param message The information massage
     * @return <b>SWT.OK</b> after the dialog is confirmed
     */
    public static int showInfoDialog(Shell parent, String message) {
        return showDialog(parent, message, EASyProducerConstants.EASY_PRODUCER_INFO, SWT.OK | SWT.ICON_INFORMATION);
    }

    /**
     * Shows an information dialog, where the user must decide between yes or no.
     * 
     * @param parent The caller of this dialog.
     * @param message The information message
     * @return <b>SWT.YES</b> or <b>SWT.NO</b>
     */
    public static int showInfoConfirmDialog(Shell parent, String message) {
        return showDialog(parent, message, EASyProducerConstants.EASY_PRODUCER_INFO,
            SWT.YES | SWT.NO | SWT.ICON_INFORMATION);
    }
}