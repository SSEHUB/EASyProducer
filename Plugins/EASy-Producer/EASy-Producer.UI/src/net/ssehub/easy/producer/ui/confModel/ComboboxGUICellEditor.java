package net.ssehub.easy.producer.ui.confModel;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.producer.ui.productline_editor.IUpdateListener;
import net.ssehub.easy.producer.ui.productline_editor.IUpdateProvider;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Implements an updatable combobox cell editor.
 * 
 * @author Holger Eichelberger
 */
class ComboboxGUICellEditor extends ComboBoxCellEditor implements IUpdateProvider {

    private ComboboxGUIVariable variable;
    private IUpdateListener listener;

    /**
     * Creates the combobox editor.
     * 
     * @param parent the parent composite
     * @param items the combobox items
     * @param variable the creating variable
     */
    public ComboboxGUICellEditor(Composite parent, String[] items, ComboboxGUIVariable variable) {
        super(parent, items);
        this.variable = variable;
    }
    
    @Override
    public void setUpdateListener(IUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public void refresh() {
        String[] items = variable.refreshContents();
        if (null != items) {
            Object selected = getValue();
            setItems(items);
            if (null != selected) {
                boolean found = false;
                for (int i = 0; !found && i < items.length; i++) {
                    found = selected.equals(items[i]);
                }
                if (found) {
                    setValue(selected);
                }
            }
        }
    }
    
    // do not inform about value changes at the moment

    @Override
    public void dispose() {
        if (null != listener) {
            listener.dispose();
        }
        super.dispose();
    }

    @Override
    public IDecisionVariable getVariable() {
        return variable.getVariable();
    }
   
}
