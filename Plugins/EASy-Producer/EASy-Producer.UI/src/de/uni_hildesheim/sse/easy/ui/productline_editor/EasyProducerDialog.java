package de.uni_hildesheim.sse.easy.ui.productline_editor;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import de.uni_hildesheim.sse.easy_producer.EASyProducerConstants;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
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
     * @return <b>SWT.OK</b> after the dialog is confirmed or <tt>0</tt>.
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
     * @return <b>SWT.OK</b> after the dialog is confirmed or <tt>0</tt>.
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
     * <li><tt>SWT.ICON_ERROR</tt></li>
     * <li><tt>SWT.ICON_INFORMATION</tt></li>
     * <li>...</li>
     * </ul>
     * @param title Should match to the given icon.
     * <ul>
     * <li><tt>EASyProducerConstants.EASY_PRODUCER_ERROR</tt></li>
     * <li><tt>EASyProducerConstants.EASY_PRODUCER_INFO</tt></li>
     * <li>...</li>
     * </ul>
     * @param msg The beginning of the message, which shall be displayed.
     * @param messages The messages to be displayed
     * @return <b>SWT.OK</b> after the dialog is confirmed or <tt>0</tt>.
     */
    private static int showReasonerDialog(Shell parent, int messageBoxStyle, String title, StringBuffer msg,
        Message... messages) {

        int returnValue = 0;
        if (messages != null && messages.length > 0) {
            for (int i = 0; i < messages.length; i++) {
                Message oneMsg = messages[i];
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
            
            returnValue = showDialog(parent, msg.toString(), title, SWT.OK | messageBoxStyle);
        }
        
        return returnValue;
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