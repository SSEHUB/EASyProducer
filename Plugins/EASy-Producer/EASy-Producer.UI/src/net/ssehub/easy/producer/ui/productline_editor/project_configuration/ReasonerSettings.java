package net.ssehub.easy.producer.ui.productline_editor.project_configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;

/**
 * Some UI elements for defining the project specific reasoner settings.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerSettings implements ModifyListener {

    private ReasonerConfiguration cfg;
    private Text timeout;
    
    /**
     * Sole constructor for this class.
     * @param parent The parent composite which will hold this Combobox.
     * @param cfg the reasoner configuration of the current project
     * @param parentPage The parent page which will react on changes of this Combobox.
     */
    public ReasonerSettings(Composite parent, ReasonerConfiguration cfg, AbstractEASyEditorPage parentPage) {
        this.cfg = cfg;
        Label title = new Label(parent, SWT.LEFT);
        title.setText("Define the reasoner timeout (in milliseconds, no timeout if <0):");
        title.setBackground(parent.getBackground());
        timeout = new Text(parent, SWT.RIGHT | SWT.BORDER);
        GridData data = new GridData();
        data.widthHint = 80;
        timeout.setLayoutData(data);
        timeout.setTextLimit(6);
        setTimeout();
        timeout.addModifyListener(this);
    }
    
    /**
     * Sets the actual timeout value.
     */
    private void setTimeout() {
        timeout.setText(Integer.toString(cfg.getTimeout()));
    }

    /**
     * Refreshes the timeout.
     */
    public void refresh() {
        setTimeout();
    }

    @Override
    public void modifyText(ModifyEvent ev) {
        try {
            String txt = timeout.getText().trim();
            cfg.setTimeout(Integer.parseInt(txt));
        } catch (NumberFormatException ex) {
            // TODO inform the user
        }
    }
    
}
