package de.uni_hildesheim.sse.easy_producer;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.PathEnvironmentFactory.IProjectHandler;

/**
 * Implements a Java project handler for the initialization of path environments.
 * 
 * @author Holger Eichelberger
 */
public class JavaProjectHandler implements IProjectHandler {

    /**
     * Defines the ID used in relative references to (external) classpath entries.
     */
    public static final String CLASSPATH_ID = "classpath";
    
    /**
     * Defines the singleton instance of this class.
     */
    public static final IProjectHandler INSTANCE = new JavaProjectHandler();
    
    /**
     * Prevents this class from being instantiated from outside.
     */
    private JavaProjectHandler() {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void addPaths(IProject project, PathEnvironment pathEnv) {
        try {
            IJavaProject jProject = JavaCore.create(project);
            if (null != project) {
                ArrayList<String> paths = new ArrayList<String>();
                IClasspathEntry[] entries = jProject.getResolvedClasspath(true);
                for (int e = 0; e < entries.length; e++) {
                    IClasspathEntry entry = entries[e];
                    if (IClasspathEntry.CPE_LIBRARY == entry.getEntryKind()) {
                        IPath path = entry.getPath();
                        if (path.isAbsolute()) {
                            paths.add(path.toString());
                        }
                    }
                }
                if (!paths.isEmpty()) {
                    String[] tmp = new String[paths.size()];
                    paths.toArray(tmp);
                    pathEnv.addMapping(CLASSPATH_ID, tmp);
                }
            }
        } catch (JavaModelException e) {
        }
    }

}
