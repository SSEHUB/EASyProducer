package net.ssehub.easy.producer.ui.confModel;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * Implements a GUI editor representation for Text.
 * 
 * @author Holger Eichelberger
 */
class TextGUIEditor implements GUIEditor {

    private Text text;

    /**
     * Creates an editor representation.
     * 
     * @param text the text
     */
    TextGUIEditor(Text text) {
        this.text = text;
    }
    
    @Override
    public Control getControl() {
        return text;
    }

    @Override
    public Object getValue() {
        return text.getText();
    }

    @Override
    public void setValue(Object object) {
        if (null != object) {
            text.setText(object.toString());
        }
    }

    @Override
    public boolean isPseudoEditor() {
        return false;
    }

    @Override
    public void refreshContents() {
        // currently unused
    }

}
