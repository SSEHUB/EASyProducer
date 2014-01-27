package de.uni_hildesheim.sse.easy.ui.confModel;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * GUI representation of {@link IDecisionVariable}s which can be configured with a simple text editor.
 * 
 * @author El-Sharkawy
 *
 */
class BasisGUIVariable extends GUIVariable {
    private Composite parent;
    
    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param config The {@link GUIConfiguration} holding this BasisGUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     */
    BasisGUIVariable(IDecisionVariable variable, Composite parent, GUIConfiguration config, GUIVariable varParent) {
        super(variable, config, varParent);
        this.parent = parent;
    }

    @Override
    public CellEditor getCellEditor() {
        return new TextCellEditor(parent);
    }

    @Override
    public String getValueText() {
        ConfigEditorValueRetriever retriever = new ConfigEditorValueRetriever(getVariable());
        return retriever.getValue().toString();
    }

    @Override
    protected Value getValueAssignment(Object value) throws ValueDoesNotMatchTypeException {
        Value val = null;
        IDatatype type = getVariable().getDeclaration().getType();
        if (!"".equals(value) || type.isAssignableFrom(StringType.TYPE)) {
            val = ValueFactory.createValue(type, value);
        }
        
        return val;
    }

    @Override
    public Object getValue() {
        String value = "";
        if (null != getVariable().getValue() && null != getVariable().getValue().getValue()) {
            value = getVariable().getValue().getValue().toString();
        }
        
        return value;
    }
}
