package net.ssehub.easy.producer.ui.confModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;
import net.ssehub.easy.varModel.model.values.Value;

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
     * Determines the actually visible variables for the given resolution <code>scope</code>.
     * 
     * @param scope the resolution scope (project or interface)
     * @param visible the visible variables (to be modified as a side effect)
     * @param done already processed scopes
     */
    private static void determineVisible(IResolutionScope scope, Set<AbstractVariable> visible, 
        Set<IResolutionScope> done) {
        if (!done.contains(scope)) {
            done.add(scope);
            for (int e = 0; e < scope.getElementCount(); e++) {
                ContainableModelElement elt = scope.getElement(e);
                if (elt instanceof DecisionVariableDeclaration) {
                    visible.add((DecisionVariableDeclaration) elt);
                } else if (elt instanceof AttributeAssignment) {
                    determineVisible((AttributeAssignment) elt, visible);
                }
            }
            for (int i = 0; i < scope.getImportsCount(); i++) {
                ProjectImport imp = scope.getImport(i);
                if (null != imp.getScope()) {
                    determineVisible(imp.getScope(), visible, done);
                }
            }
        }
    }
    
    /**
     * Part of {@link #determineVisible(IResolutionScope, Set, Set)}, which handles {@link AttributeAssignment} blocks
     * recursively.
     * @param block the current assignment block
     * @param visible the visible variables (to be modified as a side effect)
     */
    private static void determineVisible(AttributeAssignment block, Set<AbstractVariable> visible) {
        for (int e = 0; e < block.getElementCount(); e++) {
            ContainableModelElement elt = block.getElement(e);
            if (elt instanceof DecisionVariableDeclaration) {
                visible.add((DecisionVariableDeclaration) elt);
            } else if (elt instanceof AttributeAssignment) {
                determineVisible((AttributeAssignment) elt, visible);
            }
        }
    }
    
    /**
     * Resets the map and adds only all top level elements to this map.
     */
    public void initMap() {
        //topLevelVariables = new GUIVariable[config.getDecisionCount()];
        ArrayList<GUIVariable> variables = new ArrayList<GUIVariable>();
        if (null != config) {
            Set<AbstractVariable> visible = new HashSet<AbstractVariable>();
            determineVisible(config.getProject(), visible, new HashSet<IResolutionScope>());
            Iterator<IDecisionVariable> iterator = config.iterator();
            try {
                while (iterator.hasNext()) {
                    IDecisionVariable configVariable = iterator.next();
                    if (configVariable.isVisible() && visible.contains(configVariable.getDeclaration())) {
                        GUIVariable guiVariable = GUIValueFactory.createVariable(configVariable, parent, this, null);
                        // Currently, no variables are created for constraint variables.
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
     * Replaces a variable to reflect the new value (of a more or less specific type).
     * 
     * @param var the variable to be replaced (may affect top-level GUI variables)
     * @param val the new value carrying the type
     * @return the new variable or <code>var</code>
     * @throws ConfigurationException in case that configuring the variable is not possibe
     */
    public GUIVariable replace(GUIVariable var, Value val) throws ConfigurationException {
        GUIVariable result = var;
        if (var.isTopLevelDeclaration()) {
            for (int t = 0; t < topLevelVariables.length; t++) {
                if (topLevelVariables[t] == var) {
                    IDecisionVariable decVar = topLevelVariables[t].getVariable();
                    GUIVariable.replaceValue(decVar, val);
                    topLevelVariables[t] = GUIValueFactory.createVariable(decVar, parent, this, null);
                    changed(topLevelVariables[t]);
                    result = topLevelVariables[t];
                    break;
                }
            }
        } else {
            var.getParent().replace(var, val);
        }
        return result;
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
     * <code>warnings[i].getConflicts()</code> must return a list containing only constraints.
     */
    public void setErrorMessages(Message[] warnings) {        
        // Add all new messages
        if (null != warnings) {           
            Map<AbstractVariable, GUIVariable> variableMap = toHashMap();
            ErrorSetter errorSetter = new ErrorSetter(variableMap, config);

            for (int i = 0; i < warnings.length; i++) {
                Message warning = warnings[i];
                StringBuffer userMessage = new StringBuffer();
                List<String> labels = warning.getConflictLabels();
                if (null != labels && !labels.isEmpty()) {
                    userMessage.append(labels.get(0));
                    for (int j = 1; j < labels.size(); j++) {
                        userMessage.append("\n");
                        userMessage.append(labels.get(j));
                    }
                }
                errorSetter.setErrorMsg(userMessage.toString());
                List<ModelElement> conflictingElements = warning.getConflicts();
                if (!conflictingElements.isEmpty()) {
                    for (int j = 0; j < conflictingElements.size(); j++) {
                        ModelElement conflictingElement = conflictingElements.get(j);
                        conflictingElement.accept(errorSetter);
                    }
                }
                errorSetter.setErrorMsg(null);
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
     * complexity (<code>O(2n)</code> instead of <code>O(n^2)</code>).
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
    
    /**
     * Returns the variability configuration.
     * 
     * @return the variability configuration
     */
    public Configuration getConfig() {
        return config;
    }
    
}