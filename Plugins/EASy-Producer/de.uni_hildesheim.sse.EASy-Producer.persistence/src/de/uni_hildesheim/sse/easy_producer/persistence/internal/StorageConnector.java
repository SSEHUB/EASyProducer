package de.uni_hildesheim.sse.easy_producer.persistence.internal;

import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PersistentProject;

/**
 * General interface for this creation of arbitrary connectors, able to save <code>Models</code> persistently. 
 * @author Kapeluch
 * @author El-Sharkawy
 */
public interface StorageConnector {

    /**
     * Loads the specified models.
     * 
     * @param models the models to load
     * @throws PersistenceException in case of reading errors
     */
    public void loadModels(Model...models) throws PersistenceException;
    
    /**
     * Method for loading models out of a persistent file/database.
     * @param project A {@link PersistentProject} holding an empty array of <code>Models</code> for storing
     * the information read in a persistent file/database. These models must only contain the correct
     * <code>ModelType</code>s, for managing which parts should be loaded.
     * @throws PersistenceException Will be thrown if an error is occurred during reading the persistent information.
     */
    public void loadModels(PersistentProject project) throws PersistenceException;

    /**
     * Saves data from given model to storage.
     * 
     * @param project The information which should be saved in non ivml files.
     * @throws PersistenceException Will be thrown if an error is occurred during reading the persistent information.
     */
    public void saveModels(PersistentProject project) throws PersistenceException;

    /**
     * Returns the UUID of a given pl project.
     * 
     * @return the id or <b>null</b> if the specified project has no configuration file.
     */
    public String getProjectID();
    
    /**
     * Returns the path environment used for making paths relative.
     * 
     * @return the path environment
     */
    public PathEnvironment getPathEnvironment();
}
