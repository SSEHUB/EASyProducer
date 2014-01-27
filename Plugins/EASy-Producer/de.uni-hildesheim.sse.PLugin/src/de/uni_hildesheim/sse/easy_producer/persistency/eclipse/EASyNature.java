
package de.uni_hildesheim.sse.easy_producer.persistency.eclipse;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * The nature for all EASy-Producer projects.
 * @author El-Sharkawy
 *
 */
public class EASyNature implements IProjectNature {

    /**
     * ID of this project nature.
     */
    public static final String NATURE_ID = "de.uni_hildesheim.sse.EASy-Producer";
    
    /**
     * ID copied from Xtext.UI plug-in.
     */
    public static final String XTEXT_NATURE_ID = "org.eclipse.xtext.ui.shared.xtextNature";

    private IProject project;

    @Override
    public void configure() throws CoreException {
    }

    @Override
    public void deconfigure() throws CoreException {
    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(IProject project) {
        this.project = project;
    }

}
