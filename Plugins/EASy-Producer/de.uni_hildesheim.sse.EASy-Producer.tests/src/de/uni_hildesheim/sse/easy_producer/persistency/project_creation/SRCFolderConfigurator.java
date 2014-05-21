package de.uni_hildesheim.sse.easy_producer.persistency.project_creation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.junit.Assert;

import de.uni_hildesheim.sse.easy_producer.ProjectConstants;

/**
 * Simple {@link IEASyProjectConfigurator} for creating an SRC folder.
 * This is needed by the tests.
 * @author El-Sharkawy
 *
 */
public class SRCFolderConfigurator implements IEASyProjectConfigurator {

    private boolean wasExecuted = false;
    
    @Override
    public void configure(IProject project) {
        wasExecuted = true;
        try {
            project.getFolder(ProjectConstants.FOLDER_SOURCE).create(false, true, null);
            project.getFolder(ProjectConstants.FOLDER_RES).create(false, true, null);
        } catch (CoreException e) {
            Assert.fail(e.getLocalizedMessage());
        }
    }

    /**
     * Checks whether the configurator was executed.
     */
    void checkExecution() {
        Assert.assertTrue(SRCFolderConfigurator.class.getSimpleName() + " was not executed.", wasExecuted);
    }
}
