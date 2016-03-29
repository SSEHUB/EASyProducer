/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.values.Value;

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
