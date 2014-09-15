package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;

/**
 * Listener for the context menu of the {@link ConfigurationTableEditor}.
 * @author El-Sharkawy
 *
 */
public class EditorContextMenuListener implements SelectionListener {
    
    /**
     * Specifies the action which should be handled by the {@link EditorContextMenuListener} instance.
     * @author El-Sharkawy
     *
     */
    static enum Action {
        SET_NULL, REMOVE_VALUE;
    }
    
    private StructuredViewer viewer;
    private Action action;
    
    
    /**
     * Sole constructor for this listener.
     * @param viewer The {@link ConfigurationTableEditor} having a context menu.
     * @param action Specifies the action which shall be performed
     * by the specific menu item (must not be <tt>null</tt>).
     */
    public EditorContextMenuListener(StructuredViewer viewer, Action action) {
        this.viewer = viewer;
        this.action = action;
    }

    @Override
    public void widgetSelected(SelectionEvent evt) {
        GUIVariable var = getSelectedVariable();
        switch(action) {
        case SET_NULL:
            var.setNULLValue();
            break;
        case REMOVE_VALUE:
            var.setEmptyValue();
            break;
        default:
            // DO nothing
        }
        viewer.refresh();
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent evt) {
        // Not needed
        
    }
    
    /**
     * Returns the current selected variable, i.e. which the user has clicked with the right mouse button.
     * @return The selected {@link GUIVariable}.
     */
    private GUIVariable getSelectedVariable() {
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        return (GUIVariable) selection.getFirstElement();
    }

}
