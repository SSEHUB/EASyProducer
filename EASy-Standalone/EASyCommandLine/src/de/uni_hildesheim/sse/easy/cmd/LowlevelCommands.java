package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import de.uni_hildesheim.sse.easy.loader.ListLoader;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistency.EASyPersistencer;

/**
 * Static commands for running and controlling EASy via command line or by a build tool.
 * These class contains only very simple lowlevel commands for atomic functions.
 * @author El-Sharkawy
 *
 */
public class LowlevelCommands {
       
    /**
     * Should prevent instantiation of this utility class.
     */
    private LowlevelCommands() {}
    
    /**
     * Adds one project (folder) to the SPLsManager.
     * The folder must be a valid EASy project with a correct project structure, e.g.
     * EASy sub folder or .EASy-Producer project, correct named IVML/VIL files and so on.
     * @param projectFolder The toplevel folder of the project
     * @throws PersistenceException Will be thrown if the project has no valid EASy structure.
     */
    public static void loadProject(File projectFolder) throws PersistenceException {
        EASyPersistencer persistencer = new EASyPersistencer(projectFolder);
        persistencer.load();
    }

    /**
     * Loads all projects of a given workspace (folder).
     * The projects must be valid EASy projects.
     * @param wsFolder A folder which contains EASy project folders, which should be loaded.
     * @see #loadProject(File)
     */
    public static void loadWorkspace(File wsFolder) {
        File[] folders = wsFolder.listFiles();
        if (null != folders) {
            for (File folder : folders) {
                if (!folder.getName().equalsIgnoreCase(".metadata")) {
                    try {
                        loadProject(folder);
                    } catch (PersistenceException e) {
                        // project which are no EASy projects should be ignored.
                    }
                }
            }
        }
    }
    
    /**
     * Returns the EASy project with the given name.
     * The projects must already be loaded and stored inside the {@link SPLsManager}.
     * For this reason, the {@link #loadProject(File)} or {@link #loadWorkspace(File)} method should
     * be called before this method is called.
     * @param projectName The name of the project to be loaded.
     * @return Returns a loaded {@link PLPInfo} or <tt>null</tt> if no project was loaded with the specified
     *     projectName.
     */
    public static PLPInfo getProject(String projectName) {
        Collection<PLPInfo> infos = SPLsManager.INSTANCE.getProductLineProjects().values();
        PLPInfo plp = null;
        for (PLPInfo plpInfo : infos) {
            if (plpInfo.getProjectName().equalsIgnoreCase(projectName)) {
                plp = plpInfo;
                break;
            }
        }
               
        return plp;
    }
    
    /**
     * Loads and starts the classes of EASy.
     * This method must be called once, before all other operations can be performed.
     * @throws IOException in case of loading the startup sequence fails.
     */
    public static void startEASy() throws IOException {
        ListLoader loader = new ListLoader();
        loader.startup();
    }
}
