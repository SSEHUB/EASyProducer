package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.uni_hildesheim.sse.model.confModel.DisplayNameProvider;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.filter.ReferenceValuesFinder;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;

/**
 * Implements a GUI representation for references.
 * Creates a multiple-selection table.
 * 
 * @author Dennis Konoppa
 */
public class MultipleSelectionEditor implements GUIEditor {

    private Table table;
    
    private List<AbstractVariable> selectedValues;
    
    private Map<String, AbstractVariable> possibleVariables;
    
    private DisplayNameProvider nameProvider = DisplayNameProvider.getInstance();
    
    /**
     * Constructor for a {@link MultipleSelectionEditor}.
     * 
     * @param composite composite for editor
     * @param refType IDatatype for current reference
     * @param refVariable IDecisionVariable from current reference
     */
    public MultipleSelectionEditor(Composite composite, IDatatype refType, IDecisionVariable refVariable) {
        selectedValues = new ArrayList<AbstractVariable>();
        ContainerValue value = (ContainerValue) refVariable.getValue();
        if (null != value) {
            for (int i = 0; i < value.getElementSize(); i++) {
                ReferenceValue subValue = (ReferenceValue) value.getElement(i);
                selectedValues.add(subValue.getValue());
            }
        }
        this.table = new Table(composite, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);
        table.setHeaderVisible(true);

        TableColumn column = new TableColumn(table, SWT.NULL);
        column.setText(refVariable.getDeclaration().getName());
        IDatatype usedType = ((Reference) refType).getType();
        List<AbstractVariable> allVariables = 
                ReferenceValuesFinder.findPossibleValues(refVariable.getConfiguration().getProject(), usedType);
        possibleVariables = new HashMap<String, AbstractVariable>();
        
        for (int i = 0, n = allVariables.size(); i < n; i++) {
            AbstractVariable decl = allVariables.get(i);
            String currentConfiguration = nameProvider.getDisplayName(decl);
            possibleVariables.put(currentConfiguration, decl);
            TableItem item = new TableItem(table, SWT.NULL);
            item.setText(currentConfiguration);
        }
        
        for (int i = 0, n = selectedValues.size(); i < n; i++) {
            AbstractVariable selectedVar = selectedValues.get(i);
            String selectedName = nameProvider.getDisplayName(selectedVar);
            for (int j = 0; j < table.getItemCount(); j++) {
                TableItem item = table.getItem(j);
                if (selectedName.equals(item.getText())) {
                    item.setChecked(true);
                }
            }
        }

        table.setHeaderVisible(false);
        table.getColumn(0).pack();
        
        table.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                // Whenever something is checked in table, update selected values
                if (event.detail == SWT.CHECK) {
                    refreshContents();
                }
            }
        });
    }
    
    /**
     * Method to check selected references in table and update list of selected values.
     */
    public void updateSelectedValues() {
        selectedValues.clear();
        TableItem[] items = table.getItems(); 
        for (int i = 0; i < items.length; i++) {
            TableItem item = items[i];
            if (item.getChecked()) {
                AbstractVariable selectedVar = possibleVariables.get(item.getText());
                selectedValues.add(selectedVar);
            }
        }
    }
    
    @Override
    public Control getControl() {
        return table;
    }

    @Override
    public Object getValue() {
        return selectedValues;
    }

    @Override
    public void setValue(Object object) {
        if (null != object) {
            @SuppressWarnings("unchecked")
            List<AbstractVariable> values = (ArrayList<AbstractVariable>) object;
            selectedValues.clear();
            for (AbstractVariable value : values) {
                selectedValues.add(value);
            }
        } else {
            selectedValues.clear();
        }
        
    }

    @Override
    public boolean isPseudoEditor() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void refreshContents() {
        updateSelectedValues();
    }
}
