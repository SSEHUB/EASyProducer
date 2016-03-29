package net.ssehub.easy.integration.common;

import java.net.URI;

/**
 * Returns information about an available persisted model.
 * 
 * @author Holger Eichelberger
 */
public interface IModelInfo {

    /**
     * Returns the name of the model.
     * 
     * @return the name
     */
    public String getName();

    /**
     * Returns the version of the model.
     * 
     * @return the version (may be <b>null</b> if there is none)
     */
    public String getVersion();
    
    /**
     * Returns where the model was stored at.
     * 
     * @return the location
     */
    public URI getLocation();

}
