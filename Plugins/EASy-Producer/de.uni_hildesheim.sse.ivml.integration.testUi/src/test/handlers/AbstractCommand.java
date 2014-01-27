package test.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

import de.uni_hildesheim.sse.integration.common.IModelInfo;

/**
 * Provides some basic functionality.
 * 
 * @author Holger Eichelberger
 */
abstract class AbstractCommand extends AbstractHandler {

    /**
     * Returns the project used for testing.
     * 
     * @param name the name of the project to be returned
     * @return the project
     */
    public static final IProject getProject(String name) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(name);
    }
    
    /**
     * Selects the model information object for the given model name.
     * 
     * @param modelName the name of the model to select
     * @param available the available model information objects
     * @return the selected object (may be <b>null</b>)
     */
    public static IModelInfo selectModel(List<IModelInfo> available, String modelName) {
        IModelInfo result = null;
        for (int i = 0; null == result && i < available.size(); i++) {
            if (available.get(i).getName().equals(modelName)) {
                result = available.get(i);
            }
        }
        return result;
    }

}
