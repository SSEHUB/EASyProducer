package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Interface for listeners, which should be informed in case of changes inside the configuration.
 * @author El-Sharkawy
 *
 */
public interface IConfigurationChangeListener {
    
    /**
     * Notification that a {@link DecisionVariable} changed inside the {@link Configuration}.
     * @param config The {@link Configuration} where the change occurred.
     * @param changedVariable The {@link DecisionVariable} which changed.
     * @param oldValue the old value of <code>changedVariable</code> before the change
     */
    public void itemChanged(Configuration config, IDecisionVariable changedVariable, Value oldValue);
   
    /**
     * Notification that the state of a {@link DecisionVariable} has been changed inside the {@link Configuration}.
     * @param config The {@link Configuration} where the change occurred.
     * @param changedVariable The {@link DecisionVariable} which changed.
     */
    public void stateChanged(Configuration config, IDecisionVariable changedVariable);

    /**
     * Notification that the whole configuration was refreshed, e.g. because the project was reparsed.
     * @param config The configuration which was refreshed.
     */
    public void configurationRefreshed(Configuration config);
}
