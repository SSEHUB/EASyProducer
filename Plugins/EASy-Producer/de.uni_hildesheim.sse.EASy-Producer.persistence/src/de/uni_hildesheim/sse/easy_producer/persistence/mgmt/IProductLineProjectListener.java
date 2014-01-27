package de.uni_hildesheim.sse.easy_producer.persistence.mgmt;

/**
 * Listener for changes inside the {@link PLPInfo}.
 * @author El-Sharkawy
 *
 */
public interface IProductLineProjectListener {
    
    /**
     * This method is called, if the configuration is pulled.
     */
    public void configurationPulled();
    
    /**
     * This method is called, if the related {@link PLPInfo} is closed.
     */
    public void projectClosed();
    
    /**
     * This method is called, if the {@link PLPInfo#getBuildScript()} was changed.
     */
    public void buildScriptChanged();
}
