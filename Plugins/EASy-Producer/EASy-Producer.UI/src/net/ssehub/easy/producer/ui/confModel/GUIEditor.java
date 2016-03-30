package net.ssehub.easy.producer.ui.confModel;

import org.eclipse.swt.widgets.Control;

/**
 * Defines a GUI editor representation.
 * 
 * @author Holger Eichelberger
 */
public interface GUIEditor {

    /**
     * Returns the actual SWT control of the editor.
     * 
     * @return the control
     */
    public Control getControl();
    
    /**
     * Returns the value of the editor.
     * 
     * @return the value
     */
    public Object getValue();
    
    /**
     * Changes the value of the editor.
     * 
     * @param object the new value
     */
    public void setValue(Object object);
    
    /**
     * Returns whether this representation actually holds an editable SWT element
     * or whether it is a pseudo editor such as a Label.
     * 
     * @return <code>true</code> if it is a pseudo editor, <code>false</code> else
     */
    public boolean isPseudoEditor();
    
    /**
     * Refreshes the contents of this editor.
     */
    public void refreshContents();
    
}
