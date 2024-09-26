package net.ssehub.easy.producer.core.persistence.datatypes;

import java.io.File;

import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.PersistenceException;

/**
 * General interface for different Persistencer plug-ins.
 * @author El-Sharkawy
 *
 */
public interface IPersistencer {
    
    /**
     * Loads a PersistentProject, which is an EASy project representation, from a storage (file system).
     * @return The PersistentProject of the project which should be loaded.
     * @throws PersistenceException In case of an incorrect data format of the configuration file,
     * this exception will be thrown.
     */
    public PersistentProject load() throws PersistenceException;
    
    /**
     * Saves given PersistentProject to storage.
     * @param plp The project which should be saved
     * @throws PersistenceException If files cannot be written to the file system.
     */
    public void save(PLPInfo plp) throws PersistenceException;
    
    /**
     * Creates an empty EASy project without any eclipse specific stuff.
     * @param projectName The name of the project, which should be created.
     * @param parentFolder The parentFolder, where the project should be created.
     * @param projectID The unique ID of the project which should be created.
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before
     * @throws PersistenceException Will be thrown if the System cannot create folders and files in the parentFolder.
     * @return IProjectCreationResult Information of newly created items.
     */
    public IProjectCreationResult createProject(String projectName, File parentFolder, String projectID, boolean lazy)
        throws PersistenceException;

    /**
     * Returns the ID of a given EASy project.
     * 
     * @return the ID or <b>null</b> if the specified project has no configuration file.
     */
    public String getProjectID();

    /**
     * Returns the project folder.
     * 
     * @return the project folder
     */
    public File getProjectFolder();
    
    /**
     * Returns the EASy config file.
     * 
     * @return the EASy config file
     */
    public File getEasyConfigFile();
    
    /**
     * Updates the models in the given project.
     * 
     * @throws PersistenceException if errors during the update occur
     */
    public void update() throws PersistenceException;
    
    /**
     * Returns the path environment for making absolute paths relative and vice versa.
     * 
     * @return the path environment
     */
    public PathEnvironment getPathEnvironment();
    
    /**
     * Sets the storage folder.
     * 
     * @param folder the new storage folder
     */
    public void setStorageFolder(File folder);
    
}
