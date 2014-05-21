package de.uni_hildesheim.sse.utils.modelManagement;


/**
 * Specifies the interface to the most basic data of a model (and model info).
 * 
 * @author Holger Eichelberger
 */
public interface IModelData {

    /**
     * Returns the name of the model.
     * 
     * @return the name
     */
    public String getName();

    /**
     * Returns the version of the model.
     * 
     * @return the version, may be <b>null</b> if no version is specified
     */
    public Version getVersion();

}
