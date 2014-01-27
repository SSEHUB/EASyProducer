package de.uni_hildesheim.sse.easy_producer.persistence.internal;

import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.xml.XmlConnector;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.PersistenceConstants;

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
     * Creates and returns a specific storage-connector.
     */
    public void createConnector() {
        switch (type) {
        case XML:
            final String config = location + '/' + PersistenceConstants.CONFIG_FILE; 
            connector = new XmlConnector(config, pathEnv);
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
