package de.uni_hildesheim.sse.easy.ui.productline_editor.PTNSelectionDialog;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;

/**
 * LabelProvider for the {@link PtnSelectionDialog}.
 * Returns converts the <tt>ProductLineProject</tt>s displayed in this dialog into readable Strings.
 * @author Crowder, Schniedermeyer, Hundt
 *
 */
class PTNSelectionDialogLabelProvider extends LabelProvider implements IColorProvider {

    @Override
    public String getText(Object element) {
        String projectID = (String) element;
        PLPInfo ptn = SPLsManager.INSTANCE.getPLP(projectID);
        return ptn.getProjectName();
    }

    @Override
    public Image getImage(Object element) {
        return null;
    }

    @Override
    public Color getForeground(Object element) {
        return null;
    }

    @Override
    public Color getBackground(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

}
