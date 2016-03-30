package net.ssehub.easy.producer.ui.productline_editor.project_configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;

/**
 * Checkbox for (de-)selecting whether debug infomration shall be saved.
 * @author El-Sharkawy
 *
 */
public class EASyDebugInformationButton implements SelectionListener {

    private PLPInfo plp;
    private AbstractEASyEditorPage parentPage;
    private Button btnDebugInfos;
    
    /**
     * Sole constructor for this class, will create a new checkbox.
     * @param parent The parent composite which will hold this checkbox.
     * @param plp The {@link PLPInfo} to be configured.
     * @param parentPage The parent page which will react on changes of this checkbox.
     */
    public EASyDebugInformationButton(Composite parent, PLPInfo plp, AbstractEASyEditorPage parentPage) {
        this.plp = plp;
        this.parentPage = parentPage;
        Label lblDebugInfos = new Label(parent, SWT.LEFT);
        lblDebugInfos.setText("Debug information should be saved:");
        btnDebugInfos = new Button(parent, SWT.CHECK);
        lblDebugInfos.setBackground(parent.getBackground());
        refresh();
        btnDebugInfos.addSelectionListener(this);
    }

    /**
     * Refreshes whether debug infomration should be saved or not.
     */
    public void refresh() {
        btnDebugInfos.setSelection(plp.getSaveDebugInformation());
    }
    
    @Override
    public void widgetSelected(SelectionEvent evt) {
        plp.setSaveDebugInformation(btnDebugInfos.getSelection());
        parentPage.setDirty();
        
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent evt) {
        // TODO Auto-generated method stub
        
    }
}
