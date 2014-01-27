package de.uni_hildesheim.sse.easy.ui.productline_editor.project_configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.CopyMechansimRegistry;
import de.uni_hildesheim.sse.easy.instantiator.copy.core.CopyModel;
import de.uni_hildesheim.sse.easy.ui.contributions.Contributions;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;

/**
 * ComboBox for selecting a CopyMechanism of the current <tt>ProductLineProject</tt>.
 * @author El-Sharkawy
 *
 */
public class CopyCombobox implements SelectionListener {
    private Combo copyMechanismsMenu;
    private Map<String, String> items;
    private CopyModel copyModel;
    private AbstractEASyEditorPage parentPage;

    /**
     * Sole constructor for this class.
     * @param parent The parent composite which will hold this Combobox.
     * @param copyModel The CopyModel of the current project which shall be edited by this ComboBox.
     * @param parentPage The parent page which will react on changes of this Combobox.
     */
    public CopyCombobox(Composite parent, CopyModel copyModel, AbstractEASyEditorPage parentPage) {
        Label title = new Label(parent, SWT.LEFT);
        title.setText("Select how PL assets should be copied into this project before instantiation:");
        title.setBackground(parent.getBackground());
        copyMechanismsMenu = new Combo(parent, SWT.NONE | SWT.DROP_DOWN);
        copyMechanismsMenu.addSelectionListener(this);
        copyMechanismsMenu.setEnabled(Contributions.isEnabled(Contributions.UIElement.COPY_MECHANISMS));
        this.copyModel = copyModel;
        this.parentPage = parentPage;
        items = new HashMap<String, String>();
        refresh();
    }

    /**
     * Refreshes the list of possible Copy Mechanisms.
     */
    public void refresh() {
        //Remove old items
        copyMechanismsMenu.removeAll();
        items.clear();
        
        // Add current available mechanisms
        List<String[]> allMechansims = CopyMechansimRegistry.INSTANCE.getMechnisms();
        for (int i = 0; i < allMechansims.size(); i++) {
            copyMechanismsMenu.add(allMechansims.get(i)[0]);
            items.put(allMechansims.get(i)[0], allMechansims.get(i)[1]);
            if (allMechansims.get(i)[1].equals(copyModel.getID())) {
                copyMechanismsMenu.select(i);
            }
        }
    }
    
    /**
     * Returns the selected Copy mechanism.
     * @return The ID of the selected Copy Mechanism or <tt>null</tt> if none is selected.
     */
    public String getSelectedMechanism() {
        String selectedItem = null;
        if (-1 != copyMechanismsMenu.getSelectionIndex()) {
            String name = copyMechanismsMenu.getItem(copyMechanismsMenu.getSelectionIndex());
            selectedItem = items.get(name);
        }
        
        return selectedItem;
    }

    @Override
    public void widgetSelected(SelectionEvent evt) {
        copyModel.setCopyMechanism(getSelectedMechanism());
        parentPage.setDirty();
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent evt) {
        //Not needed here
    }
}
