package de.uni_hildesheim.sse.easy_producer.persistency.project_creation;

import org.eclipse.core.resources.IProject;


/**
 * Configurator for configuring newly created EASy projects.
 * These Configurators should set {@link IProject} settings of Eclipse, like
 * <ul>
 * <li>Natures</li>
 * <li>Classpath Entries</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public interface IEASyProjectConfigurator {

    /**
     * Configures the given {@link IProject}.
     * @param project The project to configure. Should be a new created project, must not be <tt>null</tt>.
     */
    public void configure(IProject project);
}
