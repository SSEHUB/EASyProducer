package de.uni_hildesheim.sse.easy.ui.productline_editor;

import java.io.IOException;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
/**
 *  Retrieve the MessageConsole of the currently running Elcipse-instance.
 */
public class EclipseConsole {

    /**
     * Stores the singleton instance of the Eclipse console.
     */
    public static final EclipseConsole INSTANCE = new EclipseConsole();
    
    private static final String CONSOLE_NAME = "EASy-Producer";
    
    
    /**
     * The MessageConsole of the currently running Eclipse-instance.
     */
    private MessageConsole msgConsole = null;
    
    /**
     * The private constructor of this class. This class is a singleton.
     */
    private EclipseConsole() {
        /*
         *  Retrieve the MessageConsole of the currently running Elcipse-instance.
         *  This results in a new console-instance created by the method below.
         */
        this.msgConsole = getMessageConsole(CONSOLE_NAME);
        // Ensure that the MessageConsole will be displayed.
        displayConsole();
    }
    
    /**
     * This method searches for and returns a specific instance of the MessageConsole
     * of the currently running Eclipse-instance by name. If the console with the given
     * name does not exist, a new console-instance will be created and returned.
     * 
     * Please note that this code is taken from: 
     * http://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F
     * 
     * @param consoleName the name of the MessageConsole-instance that should be returned.
     * @return the MessageConsole with the given name or a new instance of the MessageConsole
     * if the instance with the given name does not exist.
     */
    private MessageConsole getMessageConsole(String consoleName) {
        MessageConsole console = null;
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length && null == console; i++) {
            if (consoleName.equals(existing[i].getName())) {
                console = (MessageConsole) existing[i];
            }
        }
        
        //no console found, so create a new one
        if (null == console) {
            console = new MessageConsole(consoleName, null);
            conMan.addConsoles(new IConsole[]{console});
        }
        return console; 
    }
    
    /**
     * Displays the specified text at the console, followed by a line
     * separator string.
     * 
     * @param text message to display
     * @param lineBreak <tt>true</tt> if a linebreak shall be inserted after the message.
     * @return <tt>true</tt> if the message was successfully displayed inside the console.
     */
    public boolean writeToConsole(String text, boolean lineBreak) {
        boolean isWritten = false;
        if (this.msgConsole != null) {
            MessageConsoleStream out = this.msgConsole.newMessageStream();
            if (lineBreak) {
                out.println(text);
            } else {
                out.print(text);
            }
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isWritten;
    }
    
    /**
     * Clears the console.
     * <p>
     * Since a console may or may not support direct manipulation
     * of its document's contents, this method should be called to clear a text console's
     * document. The default implementation sets this console's document content
     * to the empty string directly. Subclasses should override as required.
     * </p>
     */
    public void clearConsole() {
        this.msgConsole.clearConsole();
    }
    
    /**
     * Tries to show the console inside the GUI.
     * @return <tt>true</tt> if the console could be displayed inside the GUI.
     */
    public boolean displayConsole() {
        boolean isDisplayed = false;
        IWorkbenchPage activeWorkbenchPage = getActiveWorkbenchPage();
        try {
            IConsoleView consoleView = (IConsoleView) activeWorkbenchPage.showView(IConsoleConstants.ID_CONSOLE_VIEW);
            consoleView.display(this.msgConsole);
            isDisplayed = true;
        } catch (PartInitException e) {
            System.err.println("The console of the running Eclipse-instance could not be displayed: ");
            e.printStackTrace();
        }
        return isDisplayed;
    }
    
    /**
     * Returns the currently active page for this workbench window.
     * 
     * @return the active page, or <code>null</code> if none
     */
    private IWorkbenchPage getActiveWorkbenchPage() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
        return workbenchWindow.getActivePage();
    }
}
