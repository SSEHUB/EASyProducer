package de.uni_hildesheim.sse.easy_producer.instantiator.model;

/**
 * Interface for a management class providing information, needed by the instantiators.
 * @author El-Sharkawy
 *
 */
public interface IInstantiatorProjectManager {
    
    /**
     * Returns the path of the project.
     * 
     * @param projectID The ID of the project, which should be returned.
     * @return The absolute path in the filesystem for this project.
     */
    public String getProjectPath(String projectID);

    /**
     * Returns the Name of a PLP by given ID.
     * 
     * @param projectID The ID of the project, which name should be returned.
     * @return the name of the PLP
     */
    public String getPLPName(String projectID);
    
    /**
     * Returns PLP by given UUID.
     * 
     * @param projectID The ID of the project, which should be returned.
     * @return The PLP, or null, if there is no valid reference in same workspace
     */
    public IInstantiatorProject getPLP(String projectID);
}
