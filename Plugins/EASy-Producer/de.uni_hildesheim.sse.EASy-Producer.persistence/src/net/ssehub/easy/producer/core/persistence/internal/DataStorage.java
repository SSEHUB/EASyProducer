package net.ssehub.easy.producer.core.persistence.internal;

import java.io.File;

import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.datatypes.Model;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject;
import net.ssehub.easy.producer.core.persistence.internal.xml.XmlConnector;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;

/**
 * Extensible delegator for persistent access. This delegator supports saving and (partial) loading of {@link Model}s.
 * Supported persistent formats can be found in {@link StorageType}.
 * @author Kapeluch
 * @author El-Sharkawy
 */
public class DataStorage implements StorageConnector {

    private StorageType type;
    private String location;
    private StorageConnector connector;
    private PathEnvironment pathEnv;

    /**
     * Sole constructor.
     * 
     * @param type Storage type
     * @param location Location
     * @param pathEnv an instance to make locations relative
     */
    public DataStorage(StorageType type, String location, PathEnvironment pathEnv) {
        this.type = type;
        this.location = location;
        this.pathEnv = pathEnv;
        createConnector();
    }

    /**
     * Returns the storage-location.
     * 
     * @return the storageLocation
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for the location of the file to be read/written.
     * @param storageLocation the storageLocation to set
     */
    public void setLocation(String storageLocation) {
        this.location = storageLocation;
    }

    /**
     * Returns the location/file name of the EASy config file.
     * 
     * @return the location
     */
    public String getEasyConfigFile() {
        return location + File.separator + PersistenceConstants.CONFIG_FILE;
    }

    /**
     * Creates and returns a specific storage-connector.
     */
    public void createConnector() {
        switch (type) {
        case XML:
            connector = new XmlConnector(getEasyConfigFile(), pathEnv);
            break;
        default:
            connector = null;
            break;
        }
    }

    @Override
    public void loadModels(Model... models) throws PersistenceException {
        connector.loadModels(models);
    }
    
    @Override
    public void loadModels(PersistentProject project) throws PersistenceException {
        connector.loadModels(project);
    }

    @Override
    public void saveModels(PersistentProject project) throws PersistenceException {
        connector.saveModels(project);
    }

    @Override
    public String getProjectID() {
        return connector.getProjectID();
    }
    
    @Override
    public PathEnvironment getPathEnvironment() {
        return pathEnv;
    }

}
