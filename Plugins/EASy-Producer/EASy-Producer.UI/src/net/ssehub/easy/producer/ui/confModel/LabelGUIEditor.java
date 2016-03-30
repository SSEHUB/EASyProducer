package net.ssehub.easy.producer.ui.confModel;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * Implements a (non-modifable) label editor implementation.
 * 
 * @author Holger Eichelberger
 */
class LabelGUIEditor implements GUIEditor {

    private Label label;

    /**
     * Creates a label editor representation.
     * 
     * @param label the label
     */
    LabelGUIEditor(Label label) {
        this.label = label;
    }
    
    @Override
    public Control getControl() {
        return label;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object object) {
    }

    @Override
    public boolean isPseudoEditor() {
        return true;
    }

    @Override
    public void refreshContents() {
        // currently unused
    }

}
