package net.ssehub.easy.producer.ui.configuration;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import net.ssehub.easy.producer.ui.internal.EASyPreferenceStore;
import net.ssehub.easy.varModel.persistency.AbstractVarModelWriter;

/**
 * Implements preferencePage for customization of ivml-properties such as
 * indentation.
 * 
 * @author Niko Nowatzki
 * @author Holger Eichelberger
 */
public class IvmlIndentationPreferencePage extends PreferencePage implements
    IWorkbenchPreferencePage, Listener {
  
    private Spinner indentSpinner;
    private Button indentCheckbox;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void init(IWorkbench workbench) {
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Control createContents(Composite parent) {
        Composite pageComponent = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        pageComponent.setLayout(layout);
        GridData data = new GridData();
        data.verticalAlignment = GridData.FILL;
        data.horizontalAlignment = GridData.FILL;
        pageComponent.setLayoutData(data);
 
        createConfigurationDialogs(pageComponent);
      
        return pageComponent;
    }
    

    /**
     * Create the dialogs.
     * 3 labels for users info.
     * 3 TextFields for user input.
     * 1 Button for applying the input. The values will be stored in the preference store.
     * 1 Button for restoring the default values.
     * 
     * @param pageComponent The PageComponent.
     */
    private void createConfigurationDialogs(Composite pageComponent) {
    
        pageComponent.setLayout(new GridLayout(2, false));
    
        Label ivmlLabel = new Label(pageComponent, SWT.LEFT);
        ivmlLabel.setText("Set indent step:");
        
        indentSpinner = new Spinner(pageComponent, SWT.NONE);
        indentSpinner.setIncrement(1);
        indentSpinner.setMinimum(0);
        indentSpinner.setMaximum(100);
        indentSpinner.setToolTipText("How many whitespaces should be used for indentation");
        
        indentSpinner.setSelection(EASyPreferenceStore.getIvmlIndentStep());
        indentCheckbox = new Button(pageComponent, SWT.CHECK);
        indentCheckbox.setText("Use whitespaces");
 
        indentCheckbox.setSelection(EASyPreferenceStore.getUseIvmlWhitespace());
    }
    
    @Override
    protected void performApply() {
    
        AbstractVarModelWriter.setIndentStep(Integer.parseInt(indentSpinner.getText()));
        AbstractVarModelWriter.setUseIvmlWhitespace(indentCheckbox.getSelection());

        EASyPreferenceStore.setIvmlPrefs(Integer.parseInt(indentSpinner.getText()),
            indentCheckbox.getSelection()); 
    }
    
  
    @Override
    protected void performDefaults() {
        AbstractVarModelWriter.setIndentStep(4);
        AbstractVarModelWriter.setUseIvmlWhitespace(false);
        
        refreshPage();
    }

    /**
     * Load the current values from PreferenceStore to page.
     */
    private void refreshPage() {
        indentSpinner.setSelection(4);
        indentCheckbox.setSelection(true);
    }
    
    @Override
    public void handleEvent(Event event) {
    }
    
}