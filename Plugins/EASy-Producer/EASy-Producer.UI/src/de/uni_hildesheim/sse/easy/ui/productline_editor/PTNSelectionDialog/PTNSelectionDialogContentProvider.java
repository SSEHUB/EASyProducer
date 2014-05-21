package de.uni_hildesheim.sse.easy.ui.productline_editor.PTNSelectionDialog;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Content Provider for the {@link PtnSelectionDialog}.
 * Returns the selected <tt>ProductLineProject</tt>s as Object Array.
 * @author Crowder, Schniedermeyer, Hundt
 *
 */
class PTNSelectionDialogContentProvider implements IStructuredContentProvider {

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object[] getElements(Object inputElement) {
        Object[] ptns = (Object[]) inputElement;
        return ptns;
    }

}
