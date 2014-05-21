package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;

/**
 * Concrete label provider for the default configuration editor.
 * @author El-Sharkawy
 *
 */
public class ConfigurationLabelProvider extends AbstractConfigurationLabelProvider {
    
    /**
     * Sole constructor for this class.
     * @param config The configuration, which should be edited.
     */
    ConfigurationLabelProvider(GUIConfiguration config) {
        super(config);
    }

    @Override
    protected ColumnType columType(int columnIndex) {
        ColumnType type = null;
        switch (columnIndex) {
        case 0:
            type = ColumnType.NAME;
            break;
        case 1:
            type = ColumnType.VALUE;
            break;
        case 2:
            type = ColumnType.EXTEND;
            break;
        case 3:
            type = ColumnType.REMOVE;
            break;
        case 4:
            type = ColumnType.FREEZE;
            break;
        case 5:
            type = ColumnType.COMMENT;
            break;
        case 6:
            type = ColumnType.ERROR;
            break;
        default:
            type = ColumnType.ELSE;
            break;
        }
        
        return type;
    }

    @Override
    protected String getSpecializedColumnText(GUIVariable var, int columnIndex) {
        return null;
    }

    @Override
    protected Image getSpecializedColumnImage(GUIVariable var, int columnIndex) {
        Image im = null;
        if (ColumnType.EXTEND == columType(columnIndex) && !var.isFrozen() && var.isExtendable()) {
            im = AbstractConfigurationLabelProvider.ADD;
        } else if (ColumnType.REMOVE == columType(columnIndex) && !var.isFrozen() && null != var.getParent()
            && var.getParent().isExtendable()) {
            
            im = AbstractConfigurationLabelProvider.REMOVE;
        }
        
        return im;
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub
        
    }
}
