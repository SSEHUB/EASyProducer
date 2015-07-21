
/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.ui.productline_editor.components;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.model.varModel.Project;

 /**
  * Super class for combox box working with information of a {@link PLPInfo} object.
  * @author Sascha El-Sharkawy
  * @param <Value> The kind of model elements, which shall be selected by this combo box.
  */
public abstract class AbstractComboBox<Value> {
    
    /**
     * A listener to react on state changes of {@link AbstractComboBox}.
     * @author Sascha El-Sharkawy
     *
     * @param <Value> The kind of model elements, which are selectable by the related {@link AbstractComboBox}.
     */
    public static interface ComboBoxListener<Value> {
        
        /**
         * Will be called if a new value was selected.
         * @param selectedValue The selected value or <tt>null</tt> if
         * {@link AbstractComboBox#NO_SELECTION_VALUE} was selected.
         */
        public void valueSelected(Value selectedValue);
    }

    public static final String NO_SELECTION_VALUE = "[all]";
    
    private PLPInfo plp;
    private List<Value> values;
    private String[] displayNames;
    private List<ComboBoxListener<Value>> listeners;
    private Combo combobox;
    private Value lastSelection;
    private boolean informListeners;
    
    /**
     * Default constructor for this class.
     * @param plp The {@link PLPInfo} which will be configured by this combo box, will also be used for creating the
     * displayed information.
     * @param parent The parent container holding this combo box
     */
    protected AbstractComboBox(PLPInfo plp, Composite parent) {
        this(plp, parent, (ComboBoxListener<Value>[]) null);
    }
    
    /**
     * Constructor for this class if listeners should already be called during start up.
     * @param plp The {@link PLPInfo} which will be configured by this combo box, will also be used for creating the
     * displayed information.
     * @param parent The parent container holding this combo box
     * @param initialListeners Listeners which should already be informed while this combo box is created. Useful if
     * {@link #onInit()} is overwritten
     */
    protected AbstractComboBox(PLPInfo plp, Composite parent, ComboBoxListener<Value>... initialListeners) {
        this.plp = plp;
        this.values = new ArrayList<Value>();
        this.listeners = new ArrayList<ComboBoxListener<Value>>();
        lastSelection = null;
        informListeners = true;
        combobox = new Combo(parent, SWT.DROP_DOWN);
        if (null != initialListeners) {
            for (int i = 0; i < initialListeners.length; i++) {
                ComboBoxListener<Value> listener = initialListeners[i];
                if (null != listener) {
                    this.listeners.add(listener);
                }
            }
        }
        combobox.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent evt) {
                Value selectedValue = getSelectedValue();
                lastSelection = selectedValue;
                if (informListeners) {
                    for (int i = 0; i < listeners.size(); i++) {
                        ComboBoxListener<Value> listener = listeners.get(i);
                        listener.valueSelected(selectedValue);
                    }
                }
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent evt) {
                // Not needed
            }
        });
        update();
        onInit();
    }
    
    /**
     * Method if something additional should be at the end of the constructor call.
     */
    protected void onInit() {
        // Nothing to do per default
    }
    
    /**
     * Updates its information. <br/>
     * Recalculates the data displayed (and selectable) by this combo box.
     */
    public void update() {
        boolean informListeners = false;
        values.clear();
        List<Value> calculatedValues = calculateValues();
        int length = null != calculatedValues ? calculatedValues.size() + 1 : 1;
        displayNames = new String[length];
        displayNames[0] = NO_SELECTION_VALUE;
        int selectedIndex = -1;
        for (int i = 0; i < calculatedValues.size(); i++) {
            Value element = calculatedValues.get(i);
            displayNames[i + 1] = getDisplayName(element);
            values.add(element);
            if (equals(element, lastSelection)) {
                selectedIndex = i + 1;
                if (element != lastSelection) {
                    // Same element, but filter criteria maybe changed.
                    informListeners = true;
                }
            }
        }
        combobox.setItems(displayNames);
        
        // Restore previous selection
        synchronized (this) {
            this.informListeners = informListeners;
            if (-1 != selectedIndex) {
                select(selectedIndex);
            } else {
                // Select NO_SELECTION_VALUE, which is the first item in the list
                select(0);
            }
            this.informListeners = true;
        }
    }
    
    /**
     * Selects the item at the given zero-relative index in the receiver's list. If the item at the index was already
     * selected, it remains selected. Indices that are out of range are ignored.
     * @param index the index of the item to select, based on 0.
     */
    public void select(int index) {
        if (index >= 0 && index < size()) {
            combobox.select(index);
            Value selectedValue = getSelectedValue();
            if (informListeners) {
                for (int i = 0; i < listeners.size(); i++) {
                    ComboBoxListener<Value> listener = listeners.get(i);
                    listener.valueSelected(selectedValue);
                }
            }
        }
    }
    
    /**
     * The number of elements which can be selected / are displayed by this combo box.
     * @return A value greater or equal to 0.
     */
    public int size() {
        return displayNames.length;
    }
    
    /**
     * Returns the selected value or <tt>null</tt> if {@link #NO_SELECTION_VALUE} was selected.
     * @return The selected value or <tt>null</tt> if {@link #NO_SELECTION_VALUE} was selected
     */
    public Value getSelectedValue() {
        int selectedIndex = combobox.getSelectionIndex();
        lastSelection = (selectedIndex <= 0) ? null : values.get(selectedIndex - 1);
        return lastSelection;
    }
    
    /**
     * Adds an action listener to this drop down menu.
     * @param listener The listener which should react on state changes.
     */
    public void addListener(ComboBoxListener<Value> listener) {
        listeners.add(listener);
    }
    
    /**
     * Part of the individual sub class: Calculates elements which may be selected by this combo box.
     * @return A list of items which may be selected by this combo box, must not be <tt>null</tt>.
     */
    protected abstract List<Value> calculateValues();
    
    /**
     * Returns a String representing a selectable element.
     * @param element a selectable element of this combo box.
     * @return A name which is sufficient for the user.
     */
    protected abstract String getDisplayName(Value element);
    
    /**
     * Compare method to check whether the old selection is equal to one of the new elements calculated inside
     * the {@link #update()} method, e.q. <tt>return value1.equals(value2)</tt>.<br/>
     * Sometimes the exiting <tt>equals</tt> method are not sufficient for this combo box.
     * @param value1 On value to compare with the other, maybe <tt>null</tt>.
     * @param value2 On value to compare with the other, maybe <tt>null</tt>.
     * @return <tt>true</tt> if value1 and value2 are equal in the context of this combo box.
     */
    protected abstract boolean equals(Value value1, Value value2);
    
    /**
     * Returns the {@link PLPInfo} which will be configured by this combo box and which is used for data generation.
     * @return The {@link PLPInfo} which will be configured by this combo box and which is used for data generation
     */
    public PLPInfo getProductLineProject() {
        return plp;
    }
    
    /**
     * Returns the main IVML varmodel {@link Project} of the related {@link #getProductLineProject()}.
     * @return {@link #getProductLineProject()}.{@link #getProject()}.
     */
    protected Project getProject() {
        return plp.getProject();
    }
}
