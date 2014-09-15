package de.uni_hildesheim.sse.easy.ui.confModel;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * Class that implements the GUIEditor.
 * Container for handling a text and its GUI.
 * 
 * @author Dennis Konoppa
 *
 */
public class ContainerTextGUIEditor implements GUIEditor {

    private Text text;

    private IGUITextHandler handler;
    
    /**
     * Creates an editor representation.
     * 
     * @param text the text
     */
    ContainerTextGUIEditor(Text text) {
        this(text, null);
    }
    
    /**
     * Constructor for ContainerTextGUIEditor.
     * Sets Text and IGUITextHandler. 
     * 
     * @param text the text
     * @param handler handler for the text
     */
    public ContainerTextGUIEditor(Text text, IGUITextHandler handler) {
        this.text = text;
        this.handler = handler;
    }

    @Override
    public Control getControl() {
        return text;
    }

    @Override
    public Object getValue() {
        Object result = text.getText();
        if (null != handler) {
            result = handler.split(text.getText());
        }
        return result;
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
