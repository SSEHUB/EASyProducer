package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIValueFactory;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Content provider for the default configuration editor.
 * @author El-Sharkawy
 *
 */
public class AnnotationViewContentProvider implements ITreeContentProvider {

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
        GUIVariable variable = (GUIVariable) inputElement;
        IDecisionVariable iVariable = variable.getVariable();
        int nAnnotations = iVariable.getAttributesCount();
        GUIVariable[] nestedVars = new GUIVariable[nAnnotations];
        for (int i = 0; i < nestedVars.length; i++) {
            GUIVariable gVar = GUIValueFactory.createVariable(iVariable.getAttribute(i),
                    variable.getComposite(), variable.getConfiguration(), variable);
            nestedVars[i] = gVar;
        }
        
        return nestedVars;
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
