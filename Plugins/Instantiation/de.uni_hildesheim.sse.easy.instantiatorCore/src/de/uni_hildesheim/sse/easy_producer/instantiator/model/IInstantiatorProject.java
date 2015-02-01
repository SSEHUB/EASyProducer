package de.uni_hildesheim.sse.easy_producer.instantiator.model;

import java.io.File;
import java.util.List;

import de.uni_hildesheim.sse.model.confModel.Configuration;

/**
 * Needed project information for the instantiation process.
 * @author El-Sharkawy
 *
 */
public interface IInstantiatorProject {
    
    /**
     * Returns the configuration for the variability model.
     * @return the configuration for the variability model.
     */
    public Configuration getConfiguration();
    
    /**
     * Returns the ID of this project.
     * @return The ID of this project
     */
    public String getProjectID();
    
    /**
     * Returns the name of this project.
     * @return The name of this project.
     */
    public String getProjectName();
    
    /**
     * Returns the current {@link IInstantiatorController}.
     * @return The current {@link IInstantiatorController}
     */
    public IInstantiatorController getInstantiatorController();
    
    /**
     * Getter for the project location.
     * @return the absolute file path of the root folder of this plp, or <code>null</code> if no file can be determined
     */
    public File getProjectLocation();
    
    /**
     * Returns the folder containing the EASy configuration and the variability 
     * models as a subfolder of {@link #getProjectLocation()}.
     * 
     * @return the folder containing the EASy configuration and the variability model
     */
    public File getConfigLocation();
    
    
    // ScaleLog: preliminary interface
    /**
     * Returns the locations of the predecessors.
     * 
     * @param checkExisting return only real locations, i.e., not virtuals that may point into the classpath
     * @return the locations of the predecessors
     */
    public List<File> getPredecessorLocations(boolean checkExisting);

    // ScaleLog: preliminary interface
    /**
     * Returns the locations of the successors.
     * 
     * @return the locations of the successors
     */
    public List<File> getSuccessorLocations();

}
