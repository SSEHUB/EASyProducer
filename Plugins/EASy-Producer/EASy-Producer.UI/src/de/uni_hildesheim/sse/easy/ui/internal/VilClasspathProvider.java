package de.uni_hildesheim.sse.easy.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.VilArgumentProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.PersistenceUtils;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;

/**
 * A parameter provider which adds the project's classpath as a given parameter name to the
 * main VIL call. This class shall be somewhere in the Eclipse part of EASy, not in the standalone
 * part.
 * 
 * @author Holger Eichelberger
 */
public class VilClasspathProvider extends VilArgumentProvider {

    private String paramName;
    
    /**
     * Creates a VIL classpath provider.
     * 
     * @param paramName the parameter name to be provided
     */
    public VilClasspathProvider(String paramName) {
        this.paramName = paramName;
    }
     
    @Override
    protected void provideArgumentsImpl(PLPInfo plp, Executor executor) {
        List<String> classpath = null;
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plp.getProjectName());
        if (null != project) {
            IJavaProject jProject = JavaCore.create(project);
            if (null != jProject) {
                try {
                    classpath = new ArrayList<String>();
                    IClasspathEntry[] entries = jProject.getResolvedClasspath(true);
                    for (int e = 0; e < entries.length; e++) {
                        IClasspathEntry entry = entries[e];
                        if (IClasspathEntry.CPE_LIBRARY == entry.getEntryKind() 
                            || IClasspathEntry.CPE_SOURCE == entry.getEntryKind() 
                            || IClasspathEntry.CPE_VARIABLE == entry.getEntryKind()) { // project -> recursive?
                            IPath path = PersistenceUtils.makeWsPathAbsolute(entry.getPath());
                            classpath.add(path.toString());
                        } 
                    }
                } catch (JavaModelException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(VilClasspathProvider.class, Activator.PLUGIN_ID).exception(e);
                }
            }
        }
        if (null != classpath) {
            executor.addCustomArgument(paramName, classpath);
        }
    }

    @Override
    public String getParameterName() {
        return paramName;
    }

    @Override
    public String getParameterType() {
        return "sequenceOf(String)";
    }

    @Override
    public String getName() {
        return "Java classpath";
    }

    @Override
    public boolean acceptsFreeArguments() {
        return false;
    }

    @Override
    public String getFreeArguments() {
        return null;
    }

    @Override
    public void setFreeArguments(String arguments) {
    }

}
