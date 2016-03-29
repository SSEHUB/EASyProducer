package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.easy.ui.internal.Activator;
import de.uni_hildesheim.sse.easy.ui.productline_editor.ImageProvider;
import de.uni_hildesheim.sse.easy.ui.productline_editor.ImageProvider.ImageType;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.DisplayNameProvider;
import net.ssehub.easy.varModel.confModel.IAssignmentState;

/**
 * Super class for configuration label provider. This label provider is capable of determining correct:
 * <ul>
 * <li>Text (<tt>String</tt>)</li>
 * <li>Images</li>
 * </ul>
 * for every cell of a configuration editor.
 * @author El-Sharkawy
 *
 */
abstract class AbstractConfigurationLabelProvider extends CellLabelProvider implements
    ITableLabelProvider, IColorProvider {
    
    protected static final Image ADD = ImageProvider.getInstance().getImage(ImageType.ADD);
    protected static final Image REMOVE = ImageProvider.getInstance().getImage(ImageType.DELETE);
    private static final Image UNCHECKED = Activator.getImageDescriptor("icons/open.png").createImage();
    private static final Image ASSIGNED = Activator.getImageDescriptor("icons/editor/assigned.png").createImage();
    private static final Image NULL = Activator.getImageDescriptor("icons/editor/null.png").createImage();
    private static final Image CHECKED = Activator.getImageDescriptor("icons/checkmark.png").createImage();
    private static final Color ERROR_COLOR = Display.getDefault().getSystemColor(SWT.COLOR_RED);
    private static final Color NESTED_ELEMENT_COLOR = new Color(Display.getDefault(), new RGB(232, 242, 254));
//    private static final Color NESTED_ELEMENT_COLOR = new Color(Display.getDefault(), new RGB(227, 235, 243));
    
    private GUIConfiguration config;
    
    /**
     * Sole constructor for this class.
     * @param config The configuration, which should be edited in the related editor of this label provider.
     */
    protected AbstractConfigurationLabelProvider(GUIConfiguration config) {
        this.config = config;
    }

    /**
     * Getter of the configuration edited by the related editor.
     * @return The configuration edited by this editor.
     */
    protected final GUIConfiguration getConfiguration() {
        return config;
    }

    @Override
    public void update(ViewerCell cell) {
        Object element = cell.getElement();
        int index = cell.getVisualIndex();
        String text = getColumnText(element, index);
        cell.setText(text);
        cell.setImage(getColumnImage(element, index));
        if (ColumnType.ERROR == columType(index) && null != text) {
            cell.setForeground(ERROR_COLOR); 
        } else {
            cell.setForeground(getForeground(element));
        }
        cell.setBackground(getBackground(element));
    }
    
    @Override
    public String getColumnText(Object element, int columnIndex) {
        String result = null;
        GUIVariable var = (GUIVariable) element;
        ColumnType columnType = columType(columnIndex);
        
        switch (columnType) {
        case NAME:
            result = DisplayNameProvider.getInstance().getDisplayName(var.getVariable());
            break;
        case VALUE:
            result = var.getValueText();
            break;
        case FREEZE:
            if (var.isFreezable()) {
                result = "freeze";
            }
            break;
        case COMMENT:
            result = var.getComment();
            break;
        case ERROR:
            result = var.getErrorMessages();
            break;
        default:
            if (ColumnType.ELSE != columnType) {
                result = getSpecializedColumnText(var, columnIndex);
            } else {
                var.getName();
            }
            break;
        }
        return result;
    }
    
    @Override
    public Color getForeground(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getBackground(Object element) {
        GUIVariable variable = (GUIVariable) element;
        Color backgroundColor = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
        IAssignmentState state = variable.getAssignmentState();
        
        if (AssignmentState.FROZEN == state) {
            backgroundColor = Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
        } else if (variable.getNestedDepth() % 2 == 1) {
            /*
             * Color nested elements.
             * Same color for elements having the same getNestedDepth()
             */
            backgroundColor = NESTED_ELEMENT_COLOR;
        }
        
        return backgroundColor;
    }
    
    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        Image im = null;
        
        GUIVariable value = (GUIVariable) element;
        if (ColumnType.NAME == columType(columnIndex)) {
            im = CHECKED;
            IAssignmentState state = value.getAssignmentState();
            if (AssignmentState.UNDEFINED == state) {
                im = UNCHECKED;
            } else if (AssignmentState.ASSIGNED == state || AssignmentState.DERIVED == state
                    || AssignmentState.DEFAULT == state) {
                if (value.hasValue() && value.hasNullValue()) {
                    im = NULL;
                } else {
                    im = ASSIGNED;
                }
            }
        } else {
            im = getSpecializedColumnImage(value, columnIndex);
        }
        return im;
    }
    
    /**
     * Matching the given column index to the correct column type.
     * @param columnIndex The current column index of the current cell.
     * @return The correct column type according to the given index.
     */
    protected abstract ColumnType columType(int columnIndex);
    
    /**
     * This method is for extending the {@link #getColumnText(Object, int)} method.
     * @param var the {@link GUIVariable} represented by the entire row
     * @param columnIndex the zero-based index of the column in which the label appears
     * @return String or or <code>null</code> if there is no text for the 
     *  given object at columnIndex
     */
    protected abstract String getSpecializedColumnText(GUIVariable var, int columnIndex);
    
    /**
     * This method is for extending the {@link #getColumnImage(Object, int)} method.
     * @param var the {@link GUIVariable} represented by the entire row
     * @param columnIndex the zero-based index of the column in which the label appears
     * @return An Image or or <code>null</code> if there is no Image for the 
     *  given object at columnIndex
     */
    protected abstract Image getSpecializedColumnImage(GUIVariable var, int columnIndex);
    
    @Override
    public String getToolTipText(Object element) {
        GUIVariable var = (GUIVariable) element;
        return var.getTooltip();
    }

    @Override
    public Point getToolTipShift(Object object) {
        return new Point(5, 5);
    }

    @Override
    public int getToolTipDisplayDelayTime(Object object) {
        return 100; //msec
    }

    @Override
    public int getToolTipTimeDisplayed(Object object) {
        return 5000; //msec
    }
}
