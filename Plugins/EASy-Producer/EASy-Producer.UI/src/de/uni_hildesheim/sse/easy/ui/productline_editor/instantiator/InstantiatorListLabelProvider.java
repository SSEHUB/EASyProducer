package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * Simple label provider for the list of instantiators in the instantiator view.
 * 
 * @author gawenda
 */
class InstantiatorListLabelProvider extends LabelProvider {

    @Override
    public String getText(Object element) {
        return element.toString();
    }

}
