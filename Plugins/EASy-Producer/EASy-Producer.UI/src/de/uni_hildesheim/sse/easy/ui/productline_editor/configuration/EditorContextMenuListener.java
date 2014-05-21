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
    private StructuredViewer viewer;
    
    
    /**
     * Sole constructor for this listener.
     * @param viewer The {@link ConfigurationTableEditor} having a context menu.
     */
    public EditorContextMenuListener(StructuredViewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public void widgetSelected(SelectionEvent evt) {
        GUIVariable var = getSelectedVariable();
        if (!var.hasValue() || !var.hasNullValue()) {
            var.setNULLValue();
        } else {
            var.setEmptyValue();
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
