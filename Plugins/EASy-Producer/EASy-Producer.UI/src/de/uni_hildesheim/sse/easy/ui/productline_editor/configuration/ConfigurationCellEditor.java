package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ToolTip;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;

/**
 * The Cell Editor for the Decision Editor Table.
 * 
 * @author El-Sharkawy
 * 
 */
public class ConfigurationCellEditor extends EditingSupport {

    private ColumnType columnType;
    private TreeViewer viewer;

    /**
     * Constructs a CellEditor with a given viewer for the given column.
     * 
     * @param viewer for the table
     * @param columnType Parameter for the Cell editor.
     */
    public ConfigurationCellEditor(TreeViewer viewer, ColumnType columnType) {
        super(viewer);
        this.columnType = columnType;
        this.viewer = viewer;
        
        // Activate the tooltip support for the viewer
        ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE); 
    }

    /**
     * Returns if the column can be edited.
     * 
     * @return <tt>true</tt> if editable
     * @param element The {@link GUIVariable} which is assigned to the current row
     */
    @Override
    protected boolean canEdit(Object element) {
        GUIVariable configItem = (GUIVariable) element;

        return configItem.isEditable();
    }

    /**
     * Returns the CellEditor for the given element.
     * Eclipse creates a new CellEditor on demand, i.e. if the user enters a specific cell.
     * 
     * @return the CellEditor for the element
     * @param element The {@link GUIVariable} which is assigned to the current row
     */
    @Override
    protected CellEditor getCellEditor(Object element) {
        CellEditor result = null;
        //Cast can be done, since only DecisionVariables are edited inside the configuration editor.
        GUIVariable configItem = (GUIVariable) element;
        
        switch (columnType) {
        case VALUE:
            result = configItem.getCellEditor(viewer.getTree());
            break;
        case FREEZE:
            result = new CheckboxCellEditor(viewer.getTree());
            break;
        case EXTEND:
            if (configItem.isExtendable()) {
                result = new CheckboxCellEditor(viewer.getTree());
            }
            break;
        case REMOVE:
            GUIVariable parent = configItem.getParent();
            if (null != parent && parent.isExtendable()) {
                result = new CheckboxCellEditor(viewer.getTree());
            }
            break;
        default:
            break;
        }
        return result;
    }

    /**
     * Returns the value in a column for a given element.
     * 
     * @return the value for the element
     * @param element The object which is assigned to the current row
     */
    @Override
    protected Object getValue(Object element) {
        // Cast can be done, since only DecisionVariables are edited inside the configuration editor.
        GUIVariable configItem = (GUIVariable) element;
        Object returnValue = null;
        
        switch (columnType) {
        case VALUE:
            if (!configItem.isExpandable()) {
                returnValue = configItem.getValue();
            } else {
                // Avoids AssertionFailedException in unused TextCellEditors for expandable variables.
                returnValue = configItem.getValueText();
            }
            break;
        case FREEZE:
            returnValue = configItem.isFrozen();
            break;
        case EXTEND:
            if (configItem.isExtendable()) {
                returnValue = true;
            }
            break;
        case REMOVE:
            GUIVariable parent = configItem.getParent();
            if (null != parent && parent.isExtendable() && !parent.isFrozen()) {
                returnValue = true;
            }
            break;
        default:
            break;
                
        }
        return returnValue;
    }

    /**
     * Sets the value for the given element with a given value.
     * 
     * @param element the element where the value changed
     * @param value the new value for the element
     */
    @Override
    protected void setValue(Object element, Object value) {
        //Cast can be done, since only DecisionVariables are edited inside the configuration editor.
        GUIVariable configItem = (GUIVariable) element;
        
        switch (columnType) {
        case VALUE:
            configItem.setValue(value);
            break;
        case FREEZE:
            boolean frozen = !configItem.isFrozen() && (Boolean) value;
            if (frozen) {
                configItem.freeze();
            }
            break;
        case EXTEND:
            configItem.extend();
            viewer.setExpandedState(configItem, true);
            GUIVariable newItem = configItem.getNestedElement(configItem.getNestedElementsCount() - 1);
            if (newItem.isExpandable()) {
                // Add the new element before expanding it.
                viewer.refresh();
                viewer.setExpandedState(newItem, true);
            }
            break;
        case REMOVE:
            GUIVariable parent = configItem.getParent();
            if (null != parent && parent.isExtendable() && !parent.isFrozen()) {
                parent.remove(configItem);
            }
            break;
        default:
            break;
                
        }
        getViewer().refresh();
//        getViewer().update(element, null);
    }
}
