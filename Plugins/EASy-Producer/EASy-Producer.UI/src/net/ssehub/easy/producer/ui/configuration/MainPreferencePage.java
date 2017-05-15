package net.ssehub.easy.producer.ui.configuration;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import net.ssehub.easy.producer.ui.internal.EASyPreferenceStore;

/**
 * Just an empty preference page as the main hook-in point for EASy-Producer preference pages.
 * 
 * @author Holger Eichelberger
 */
public class MainPreferencePage extends PreferencePage implements
    IWorkbenchPreferencePage {

    private Button oclCompliance;
    
    @Override
    public void init(IWorkbench workbench) {
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite pageComponent = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        pageComponent.setLayout(layout);
        GridData data = new GridData();
        data.verticalAlignment = GridData.FILL;
        data.horizontalAlignment = GridData.FILL;
        pageComponent.setLayoutData(data);

        oclCompliance = new Button(pageComponent, SWT.CHECK);
        oclCompliance.setText("OCL compliance mode");
        oclCompliance.setSelection(EASyPreferenceStore.getOclCompliance());
        
        new Label(pageComponent, SWT.LEFT);
        
        return pageComponent;
    }

    @Override
    protected void performDefaults() {
        oclCompliance.setSelection(false);
        super.performDefaults();
    }

    @Override
    protected void performApply() {
        EASyPreferenceStore.setOclCompliance(oclCompliance.getSelection());
        super.performApply();
    }
    
}
