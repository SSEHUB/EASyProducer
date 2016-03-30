package net.ssehub.easy.producer.ui.confModel;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;

/**
 * Implements a combo GUI editor representation.
 * 
 * @author Holger Eichelberger
 */
class ComboGUIEditor implements GUIEditor {

    private Combo editor;
    private ComboboxGUIVariable parent;

    /**
     * Creates a combo GUI editor representation.
     * 
     * @param editor the editor
     * @param parent the creating GUI variable
     */
    public ComboGUIEditor(Combo editor, ComboboxGUIVariable parent) {
        this.editor = editor;
        this.parent = parent;
    }
    
    @Override
    public Control getControl() {
        return editor;
    }

    @Override
    public Object getValue() {
        return editor.getSelectionIndex();
    }

    @Override
    public void setValue(Object object) {
        if (null != object) {
            editor.setText(object.toString());
        } else {
            editor.clearSelection();
        }
    }

    @Override
    public boolean isPseudoEditor() {
        return false;
    }

    @Override
    public void refreshContents() {
        String[] items = parent.refreshContents();
        if (null != items) {
            String selected = editor.getText();
            editor.setItems(items);
            if (null != selected) {
                boolean found = false;
                for (int i = 0; !found && i < items.length; i++) {
                    found = selected.equals(items[i]);
                }
                if (found) {
                    editor.setText(selected);
                }
            }
        }
    }

}
