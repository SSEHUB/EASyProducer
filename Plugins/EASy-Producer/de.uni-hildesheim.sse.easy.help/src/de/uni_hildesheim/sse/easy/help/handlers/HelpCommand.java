package de.uni_hildesheim.sse.easy.help.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

/**
 * The help-command implementation of the EASy-Producer documentation.
 * This simple command opens the Eclipse help-system with the EASy-help
 * main-page.
 * 
 * @author kroeher
 *
 */
public class HelpCommand  extends AbstractHandler {

    /**
     * {@inheritDoc}
     */
    public Object execute(ExecutionEvent event) throws ExecutionException {
        if (PlatformUI.getWorkbench().getHelpSystem().hasHelpUI()) {
            PlatformUI.getWorkbench().getHelpSystem()
                .displayHelpResource("/de.uni-hildesheim.sse.easy.help/html/main_page.html");
        }
        return null;
    }
}
