package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;

/**
 * Content provider for the default configuration editor.
 * @author El-Sharkawy
 *
 */
public class ConfigurationContentProvider implements ITreeContentProvider {

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
        GUIConfiguration config = (GUIConfiguration) inputElement;
        return config.getElements();
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        GUIVariable parentVar = (GUIVariable) parentElement;
        GUIVariable[] children = new GUIVariable[parentVar.getNestedElementsCount()];
        for (int i = 0; i < children.length; i++) {
            children[i] = parentVar.getNestedElement(i);
        }
        
        return children;
    }

    @Override
    public Object getParent(Object element) {
        return ((GUIVariable) element).getParent();
    }

    @Override
    public boolean hasChildren(Object element) {
        GUIVariable var = (GUIVariable) element;
        return var.getNestedElementsCount() > 0;
    }

}
