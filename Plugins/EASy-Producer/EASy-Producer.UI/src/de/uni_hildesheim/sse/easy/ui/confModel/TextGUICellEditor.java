package de.uni_hildesheim.sse.easy.ui.confModel;

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy.ui.productline_editor.IUpdateListener;
import de.uni_hildesheim.sse.easy.ui.productline_editor.IUpdateProvider;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Implements an updating text cell editor.
 * 
 * @author Holger Eichelberger
 */
public class TextGUICellEditor extends TextCellEditor implements IUpdateProvider {

    private BasisGUIVariable variable;
    private IUpdateListener listener;
    
    /**
     * Creates a new text string cell editor parented under the given control.
     *
     * @param parent the parent control
     * @param variable the variable this editor was created for
     */
    public TextGUICellEditor(Composite parent, BasisGUIVariable variable) {
        super(parent);
        this.variable = variable;
    }

    @Override
    public void refreshContents() {
        // not relevant here, the value change is the interesting part
    }

    @Override
    public void setUpdateListener(IUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public IDecisionVariable getVariable() {
        return variable.getVariable();
    }
    

    @Override
    protected void doSetValue(Object value) {
        super.doSetValue(value);
        if (null != listener) {
            listener.valueChanged(this);
        }
    }
    
    @Override
    public void dispose() {
        if (null != listener) {
            listener.dispose();
        }
        super.dispose();
    }
    
}
