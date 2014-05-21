package de.java.instantiator.prototype;

import org.eclipse.ui.IStartup;

import de.uni_hildesheim.sse.easy.ui.productline_editor.Editor;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * This class registers the EditorPage.
 * 
 * @author Sass
 *
 */
public class Startup implements IStartup {
    
    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(Startup.class, Bundle.ID);

    @Override
    public void earlyStartup() {
        logger.info("Registering new page...");
        Editor.registerNewPage(new PageFactory());
    }
}
