package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * GUI representation of container values.
 * @author El-Sharkawy
 * @author Dennis Konoppa
 *
 */
class ContainerGUIVariable extends AbstractExpandableGUIVariable {
    
    /**
     * Sole constructor for this class.
     * @param variable The {@link IDecisionVariable} represented by this GUIVariable
     * @param parent The controlling composite, needed for the creation of CellEditors
     * @param config The {@link GUIConfiguration} holding this GUIVariable
     * @param varParent The parent GUIVariable holding this variable. Can be <tt>null</tt> if and only if this variable
     * is a top level variable stored inside the configuration.
     */
    ContainerGUIVariable(IDecisionVariable variable, Composite parent, GUIConfiguration config, GUIVariable varParent) {
        super(variable, parent, config, varParent);
    }
    
    @Override
    public boolean isExtendable() {
        return true;
    }

    @Override
    public String getValueText() {
        String result;
        if (hasValue() && hasNullValue()) {
            result = getNullLabel();
        } else {
            //checkstyle: stop exception type check 
            try {
                result = StringProvider.toIvmlString(getVariable().getValue());
            } catch (Throwable t) {
                result = "";
            }
            //checkstyle: resume exception type check 
        }
        return result;
    }
    
    @Override
    public void remove(GUIVariable nestedVariable) {
        ContainerVariable relatedVariable = (ContainerVariable) getVariable();
        boolean found = relatedVariable.removeNestedElement(nestedVariable.getVariable());
        
        if (found) {
            //Notify Editor to become dirty
            getConfiguration().changed(this);
            // create nested GUIVariables
            createNestedVariables();
        }  
    }
    
    // TODO listener to reflect changes in textual representation of container and to change values in container itself

    @Override
    public Object getValue() {
        String value = "";
        if (null != getVariable().getValue() && null != getVariable().getValue().getValue()) {
            value = getVariable().getValue().getValue().toString();
        }
        
        return value;
    }
    
    @Override
    public GUIEditor getEditor() {
        GUIEditor editor = null;
        String content = getValueText();
        IGUITextHandler handler = null;
        Container type = (Container) getType();
        IDatatype contType = type.getContainedType();
        if (IntegerType.TYPE.isAssignableFrom(contType)) {
            handler = new IntegerTextHandler();
        } else if (StringType.TYPE.isAssignableFrom(contType)) {
            handler = new StringCollectionHandler(", "); // parameter/separator can be changed
        }
        // further specific types may go here, and we will have further more specific editors ;)
        if (null != handler) {
            content = handler.format(content);
            Text result = new Text(getComposite(), SWT.SINGLE | SWT.BORDER);
            result.setText(content);
            editor = new ContainerTextGUIEditor(result, handler);
        } else if (Reference.TYPE.isAssignableFrom(contType)) {
            // Create MutlipleSelectionEditor (table for references)
            editor = new MultipleSelectionEditor(getComposite(), contType, getVariable());
        } else {
            editor = super.getEditor();
        }
        return editor;
    }
    
    @Override
    public void setValue(Object value) {
        // QM-IConf needs this - if this is a problem, we need an additional method through the hierarchy for this
        if (null != value && value instanceof List) {
            IDecisionVariable var = getVariable();
            Object[] values = ((List<?>) value).toArray();
            try {
                var.setValue(ValueFactory.createValue(var.getDeclaration().getType(), values), var.getState());
            } catch (ValueDoesNotMatchTypeException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
            } catch (ConfigurationException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
            }
        }
    }
    
}
