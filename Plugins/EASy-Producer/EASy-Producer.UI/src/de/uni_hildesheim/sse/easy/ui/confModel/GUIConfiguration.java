package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;

/**
 * Wrapper class for this configuration as needed by the Eclipse GUI.
 * @author El-Sharkawy
 *
 */
public class GUIConfiguration implements IGUIConfigurableElement {
    private Configuration config;
    private Composite parent;
    private List<IGUIConfigChangeListener> listeners;
    private GUIVariable[] topLevelVariables;
    
    /**
     * Sole constructor for this class.
     * @param config The origin configuration.
     * @param parent Should be a table for creating CellEditors
     */
    public GUIConfiguration(Configuration config, Composite parent) {
        this.parent = parent;
        this.config = config;
        listeners = new ArrayList<IGUIConfigChangeListener>();
        initMap();
    }
    
    /**
     * Resets the map and adds only all top level elements to this map.
     */
    public void initMap() {
        topLevelVariables = new GUIVariable[config.getDecisionCount()];
        ArrayList<GUIVariable> variables = new ArrayList<GUIVariable>();
        if (null != config) {
            Iterator<IDecisionVariable> iterator = config.iterator();
            try {
                while (iterator.hasNext()) {
                    IDecisionVariable configVariable = iterator.next();
                    if (configVariable.isVisible()) {
                        GUIVariable guiVariable = GUIValueFactory.createVariable(configVariable, parent, this, null);
                        // Currently, no variables are created for constraitn variables.
                        if (null != guiVariable) {
                            variables.add(guiVariable);
                        }
                    }
                }            
            } catch (ConcurrentModificationException cme) {
                // This exception occurs while the configuration is changed multiple times through the parser
                // No handling needed, discard all changes and wait until the configuration is changed a second time
            }
        }
        topLevelVariables = new GUIVariable[variables.size()];
        topLevelVariables = variables.toArray(topLevelVariables);
        // Sorting the array (instead of a list) saves one complete iteration step through the whole structure
        Arrays.sort(topLevelVariables);
    }

    /**
     * Returns the GUI Elements which should be shown inside the GUI as an array.
     * @return Not hidden configuration items.
     */
    public GUIVariable[] getElements() {
        return topLevelVariables;
    }
    
    /**
     * Informs all listeners that this model contains unsaved data.
     * @param var The variable which has been changed inside the GUI.
     */
    void changed(GUIVariable var) {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).changed(this);
        }
    }
    
    /**
     * Informs all listeners that this model contains unsaved data.
     */
    public void configurationChanged() {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).imtemsChanged(this);
        }
    }
    
    /**
     * Adds a new {@link IGUIConfigChangeListener} to this configuration.
     * @param listener The listener, which shall be informed if any changes occur.
     */
    public void register(IGUIConfigChangeListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Returns the number of items.
     * 
     * @return the number of items
     */
    public int getItemCount() {
        return topLevelVariables.length;
    }

    @Override
    public GUIConfiguration getConfiguration() {
        return this;
    }
    
    /**
     * Deletes all error messages for the {@link GUIVariable}'s of this configuration and adds the
     * given messages to variables affected variables.
     * @param warnings A list of error/warning messages, produced by a reasoning step.
     * <tt>warnings[i].getConflicts()</tt> must return a list containing only constraints.
     */
    public void setErrorMessages(Message[] warnings) {        
        // Add all new messages
        if (null != warnings) {           
            Map<AbstractVariable, GUIVariable> variableMap = toHashMap();
            ErrorSetter errorSetter = new ErrorSetter(variableMap);

            for (int i = 0; i < warnings.length; i++) {
                Message warning = warnings[i];
                List<ModelElement> conflictingElements = warning.getConflicts();
                if (!conflictingElements.isEmpty()) {
                    for (int j = 0; j < conflictingElements.size(); j++) {
                        ModelElement conflictingElement = conflictingElements.get(j);
                        conflictingElement.accept(errorSetter);
                    }
                }
            }
        }
        
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).imtemsChanged(this);
        }
    }
    
    /**
     * Removes the error messages of all stored {@link GUIVariable}.
     * This method should be called after a reasoning was performed and no error was detected.
     */
    public void clearErrorMessages() {
        for (int i = 0; i < topLevelVariables.length; i++) {
            topLevelVariables[i].removeErrorMessages();
        }
        
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).imtemsChanged(this);
        }
    }
    
    /**
     * Converts the nested {@link GUIVariable}'s into a temporary {@link Map}.
     * This is used inside the {@link #setErrorMessages(Message[])} method to reduce the
     * complexity (<tt>O(2n)</tt> instead of <tt>O(n^2)</tt>).
     * This also removes all stored error messages.
     * @return A map in the form of ({@link AbstractVariable}, {@link GUIVariable}).
     */
    private Map<AbstractVariable, GUIVariable> toHashMap() {
        Map<AbstractVariable, GUIVariable> variableMap =
            new HashMap<AbstractVariable, GUIVariable>(topLevelVariables.length);
        
        for (int i = 0; i < topLevelVariables.length; i++) {
            GUIVariable guiVariable = topLevelVariables[i];
            guiVariable.removeErrorMessages();
            variableMap.put(guiVariable.getVariable().getDeclaration(), guiVariable);
        }
        
        return variableMap;
    }
    
    /**
     * Causes to freeze all values.
     */
    public void freeze() {
        GUIVariable[] elements = getElements();
        for (GUIVariable guiVariable : elements) {
            guiVariable.freeze();
        }
    }
}