package net.ssehub.easy.producer.ui.application;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.ide.IDEInternalWorkbenchImages;

import net.ssehub.easy.producer.ui.internal.Activator;

/**
 * Class for configuring the workbench.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("restriction")
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

    public static final String PERSPECTIVE_ID = "EASy.perspective";

    /**
     * Instantiates and returns an workbenchWindowAdvisor
     * for the given configurer.
     * 
     * @param configurer Given configurer.
     * @return the ApplicationWorkbenchWindowAdvisor to the given configurer.
     */
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
            IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

    /**
     * Returns the PERSPECTIVE_ID.
     * @return The public declared field holding the perspectives-id.
     */
    public String getInitialWindowPerspectiveId() {
        return PERSPECTIVE_ID;
    }
    
    @Override
    public void initialize(IWorkbenchConfigurer configurer) {
        configurer.declareImage(
            IDEInternalWorkbenchImages.IMG_OBJS_ERROR_PATH,
            Activator.getImageDescriptor(Activator.ERROR), true);
        configurer.declareImage(
            IDEInternalWorkbenchImages.IMG_OBJS_WARNING_PATH,
            Activator.getImageDescriptor(Activator.WARNING), true);    
    }

}
