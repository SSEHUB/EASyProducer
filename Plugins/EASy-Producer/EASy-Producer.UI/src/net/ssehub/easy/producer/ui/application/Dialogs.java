package net.ssehub.easy.producer.ui.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import net.ssehub.easy.producer.ui.internal.Activator;

/**
 * Error and Info Box utility class. This class should be used to have a common look and feel for error and info
 * dialogs.
 * 
 * @author Holger Eichelberger
 */
public class Dialogs {

    /**
     * Utility class.
     */
    private Dialogs() {
    }
    
    /**
     * Opens a specific dialog with the given parameters.
     * 
     * @param parent The parent of this dialog (may be <b>null</b>)
     * @param message The message to be shown in the message box.
     * @param title The title in the top of the window
     * @param style The SWT Style, which specifies the behavior of the dialog
     * @return The result of the dialog or <code>0</code>
     */
    private static int showDialog(Shell parent, String message, String title, int style) {
        int result = 0;
        if (null == parent) {
            parent = getDefaultShell();
        }
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
     * Returns the default shell of the workbench.
     * 
     * @return the default shell
     */
    public static Shell getDefaultShell() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
        
        return (null != window) ? window.getShell() : null;
    }

    /**
     * Displays an error dialog on the default shell for the given exception on the default shell.
     * 
     * @param title the title of the error dialog
     * @param caller the calling class (for logging)
     * @param exception the exception the message shall be displayed for
     */
    public static void showErrorDialog(String title, Class<?> caller, Exception exception) {
        showErrorDialog(null, title, caller, exception);
    }
    
    /**
     * Displays an error dialog for the given exception on the default shell.
     * 
     * @param parent The parent of this dialog (may be <b>null</b>, then the {@link #getDefaultShell() default 
     * shell} will be used)
     * @param title the title of the error dialog
     * @param caller the calling class (for logging)
     * @param exception the exception the message shall be displayed for
     */
    public static void showErrorDialog(Shell parent, String title, Class<?> caller, Exception exception) {
        showErrorDialog(parent, title, exception.getMessage());
        Activator.getLogger(caller).exception(exception);
    }
    
    /**
     * Displays an error dialog on the default shell.
     * 
     * @param title the title of the error dialog
     * @param message the error message
     */
    public static void showErrorDialog(String title, String message) {
        showErrorDialog(null, title, message);
    }

    /**
     * Shows an error dialog.
     * 
     * @param parent The parent of this dialog (may be <b>null</b>, then the {@link #getDefaultShell() default 
     * shell} will be used)
     * @param title the title of the error dialog
     * @param message the error massage
     */
    public static void showErrorDialog(Shell parent, String title, String message) {
        showDialog(parent, message, title , SWT.OK | SWT.ICON_ERROR);
    }
    
    /**
     * Displays an error dialog on the default shell.
     * 
     * @param title the title of the error dialog
     * @param message the error message
     */
    public static void showInfoDialog(String title, String message) {
        showInfoDialog(null, title, message);
    }
    
    /**
     * Shows an info dialog.
     * 
     * @param parent The parent of this dialog (may be <b>null</b>, then the {@link #getDefaultShell() default 
     * shell} will be used)
     * @param title the title of the information dialog
     * @param message the information massage
     */
    public static void showInfoDialog(Shell parent, String title, String message) {
        showDialog(parent, message, title , SWT.OK | SWT.ICON_INFORMATION);
    }

    /**
     * Shows a confirmation dialog on the default shell, where the user must decide between yes or no.
     * 
     * @param title the title of the confirmation dialog
     * @param message The confirmation message/question
     * @return <b>SWT.YES</b> or <b>SWT.NO</b>
     */
    public static int showInfoConfirmDialog(String title, String message) {
        return showConfirmDialog(null, title, message);
    }
    
    /**
     * Shows a confirmation dialog, where the user must decide between yes or no.
     * 
     * @param parent The parent of this dialog (may be <b>null</b>, then the {@link #getDefaultShell() default 
     * shell} will be used)
     * @param title the title of the confirmation dialog
     * @param message The confirmation message/question
     * @return <b>SWT.YES</b> or <b>SWT.NO</b>
     */
    public static int showConfirmDialog(Shell parent, String title, String message) {
        return showDialog(parent, message, title, SWT.YES | SWT.NO | SWT.ICON_INFORMATION);
    }

}