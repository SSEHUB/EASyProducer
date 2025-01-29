package net.ssehub.easy.producer.eclipse.persistency.eclipse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Some utility methods for natures.
 *
 * @author Holger Eichelberger
 */
public final class NatureUtils {

    private static Predicate<String> natureFilter = n -> true;
    
    /**
     * Prevents this class from being instantiated from outside.
     */
    private NatureUtils() {
    }

    /**
     * Returns whether at least one of the given natures is
     * defined on the given project. Filtered out natures are always found.
     *
     * @param project the project to check the nature on
     * @param natures the natures to be checked
     * @return <code>true</code> if at least one nature in <code>natures</code> 
     *   is a nature of <code>project</code>, <code>false</code> else
     * @throws CoreException if <code>project</code> does not exist or is not open
     */
    public static boolean hasNature(IProject project, String... natures) throws CoreException {
        boolean found = false;
        IProjectDescription description = project.getDescription();
        String[] pNatures = description.getNatureIds();
        for (int i = 0; !found && i < pNatures.length; i++) {
            for (int j = 0; !found && j < natures.length; j++) {
                if (natureFilter.test(natures[j])) {
                    found = pNatures[i].equals(natures[j]);
                } else {
                    found = true; // just consider true
                }
            }
        }
        return found;
    }
    
    /**
     * Ensures a builder, while removing another one.
     * 
     * @param project the project to check the builders on
     * @param includeBuilder the builder id to include
     * @param excludeBuilder the builder id to exclude
     * @param monitor an optional progress monitor (may be <b>null</b>)
     * @throws CoreException if <code>project</code> does not exist or is not open
     */
    public static void ensureBuilder(IProject project, String includeBuilder, String excludeBuilder, 
        IProgressMonitor monitor) throws CoreException {
        IProjectDescription projectDescription = project.getDescription();
        ICommand[] buildSpec = projectDescription.getBuildSpec();
        List<ICommand> list = new ArrayList<>(Arrays.asList(buildSpec));
        boolean found = false;
        for (int b = list.size() - 1; b >= 0; b--) {
            ICommand c = list.get(b);
            if (c.getBuilderName().equals(excludeBuilder)) {
                list.remove(b);
            } else if (c.getBuilderName().equals(includeBuilder)) {
                found = true;
            }
        }
        if (!found && includeBuilder != null) {
            ICommand command = projectDescription.newCommand();
            command.setBuilderName(includeBuilder);
            list.add(command);
        }
        projectDescription.setBuildSpec(list.toArray(new ICommand[list.size()]));
        project.setDescription(projectDescription, monitor);
    }

    /**
     * Adds a nature to the given project. Filtered out natures are not added.
     *
     * @param project the project to add the nature to
     * @param nature the nature to be added
     * @param monitor an optional progress monitor (may be <b>null</b>)
     * @throws CoreException if <code>project</code> does not exist or is not open
     */
    public static void addNature(IProject project, String nature, IProgressMonitor monitor) throws CoreException {
        if (natureFilter.test(nature)) {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            String[] newNatures = new String[natures.length + 1];
            System.arraycopy(natures, 0, newNatures, 0, natures.length);
            newNatures[natures.length] = nature;
            description.setNatureIds(newNatures);
            if (project == null || !project.isOpen()) {
                throw new RuntimeException("Project not running");
            }
            project.setDescription(description, monitor);
        }
    }

    /**
     * Removes a nature from the given project. Filtered out natures are not removed.
     * 
     * @param project the project to remove the nature from
     * @param nature the nature to be remove
     * @param monitor an optional progress monitor (may be <b>null</b>)
     * @throws CoreException if <code>project</code> does not exist or is not open
     */
    public static void removeNature(IProject project, String nature, IProgressMonitor monitor) throws CoreException {
        if (natureFilter.test(nature)) {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();
            for (int i = 0; i < natures.length; i++) {
                if (nature.equals(natures[i])) {
                    // Remove the nature
                    String[] newNatures = new String[natures.length - 1];
                    System.arraycopy(natures, 0, newNatures, 0, i);
                    System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
                    description.setNatureIds(newNatures);
                    project.setDescription(description, monitor);
                    return;
                }
            }
        }
    }
    
    /**
     * Allows filtering out natures. [testing].
     * 
     * @param filter the nature filter
     */
    public static void setNatureFilter(Predicate<String> filter) {
        if (null != filter) {
            natureFilter = filter;
        }
    }

}
