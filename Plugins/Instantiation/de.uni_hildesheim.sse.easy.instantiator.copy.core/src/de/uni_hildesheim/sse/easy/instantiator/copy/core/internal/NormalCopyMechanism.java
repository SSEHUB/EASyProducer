package de.uni_hildesheim.sse.easy.instantiator.copy.core.internal;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.AbstractCopyMechanism;

/**
 * Copies resources from one project to another without
 * modifying the package structure.
 * @author El-Sharkawy
 *
 */
public class NormalCopyMechanism extends AbstractCopyMechanism {
    /**
     * The ID of this Copy mechanism.
     * This ID is also needed as a constant value for the registry.
     */
    public static final String ID = "de.uni_hildesheim.sse.easy.instantiator.copy.core.normal";

    @Override
    public void copy(String sourceProjectName, String targetProjectName) {
        IProject sourceProject = getResourceManager().getProject(sourceProjectName);
        IProject targetProject = getResourceManager().getProject(targetProjectName);
        Set<String> ignoredFolders = new HashSet<String>();
        ignoredFolders.add(getResourceManager().getConfigFolder());
        genericCopy(sourceProject, targetProject, ignoredFolders, false);
    }

    @Override
    public String getID() {
        return ID;
    }
    
    @Override
    public String getName() {
        return "Copy without package adaptation";
    }

    @Override
    public boolean useNameSpace() {
        return false;
    }

}
