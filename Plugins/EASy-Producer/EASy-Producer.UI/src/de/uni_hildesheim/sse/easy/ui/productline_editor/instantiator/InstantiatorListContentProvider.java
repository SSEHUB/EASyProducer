package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import java.util.HashSet;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;

/**
 * Simple content provider for the list of instantiators in the instantiator view.
 * 
 * @author gawenda
 */
class InstantiatorListContentProvider implements IStructuredContentProvider {

    @SuppressWarnings("unchecked")
    @Override
    public Object[] getElements(Object inputElement) {
        // Should be a List of Instantiators
        return ((HashSet<FileInstantiator>) inputElement).toArray();
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // Nothing to do here as it is READ_ONLY
    }

    @Override
    public void dispose() {
        // Nothing to dispose
    }
}
