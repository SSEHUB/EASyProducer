package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.util.HashMap;

import de.uni_hildesheim.sse.easy_producer.core.persistence.internal.Activator;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.model.IInstantiatorProjectManager;

/**
 * This class manages all available ProductLineProjects.
 * 
 * @author El-Sharkawy
 * 
 */
public class SPLsManager implements IInstantiatorProjectManager {
    // Singleton
    public static final SPLsManager INSTANCE = new SPLsManager();

    private static final EASyLogger LOGGER =
        EASyLoggerFactory.INSTANCE.getLogger(SPLsManager.class, Activator.PLUGIN_ID);
    
    // Attributes
    /**
     * ID and reference for found {@link PLPInfo}s.
     * A 2-tuple in the form of (projectID, PLP).
     */
    private HashMap<String, PLPInfo> plProjects;

    /**
     * Constructor for the singelton.
     */
    private SPLsManager() {
        resetHashMaps();
    }

    /**
     * Clears all stored configuration paths and plp information.
     * 
     * @since 21.04.2012
     */
    private void resetHashMaps() {
        plProjects = new HashMap<String, PLPInfo>();
    }

    /**
     * Adds a new product line project to the list of available product lines. This method should be used when the
     * persistence layer reads the configuration file.
     * 
     * @param plp The Product Line Project which should be added to the list.
     */
    public void addPLP(PLPInfo plp) {
        PLPInfo info = plProjects.get(plp.getProjectID());
        boolean put = false;
        if (null != info && info.isPreliminary() && !plp.isPreliminary()) {
            // more specialized
            for (PLPInfo p : plProjects.values()) {
                if (p != info) {
                    p.getMemberController().replacePLPInfo(plp);
                }
            }
            // replace
            put = true;
        } else {
            put = plProjects.get(plp.getProjectID()) == null;
        }
        if (put) {
            plProjects.put(plp.getProjectID(), plp);
            plp.refresh();
            LOGGER.info("PLP added. Current projects: " + plProjects.toString());
        }

    }

    /**
     * Removes a project from the list of currently available product lines. Additionally removes references of
     * predecessors and successors
     * 
     * @param projectID The ID of the project, which should be removed.
     */
    public void removePLP(String projectID) {
        PLPInfo plp = getPLP(projectID);
        if (plp != null) {
            plProjects.remove(projectID);
            LOGGER.info("PLP removed. Current projects: " + plProjects.toString());
        }
    }

    /**
     * Returns a copy of the current productline-projects-map.
     * A 2-tuple in the form of (projectID, PLP).
     * @return Copy of pl_projects
     */
    @SuppressWarnings("unchecked")
    public HashMap<String, PLPInfo> getProductLineProjects() {
        return (HashMap<String, PLPInfo>) plProjects.clone();
    }

    @Override
    public String getProjectPath(String projectID) {
        return plProjects.get(projectID).getProjectLocation().toString();
    }

    @Override
    public String getPLPName(String projectID) {
        return getPLP(projectID).getProjectName();
    }

    @Override
    public PLPInfo getPLP(String projectID) {
        return plProjects.get(projectID);
    }
}
