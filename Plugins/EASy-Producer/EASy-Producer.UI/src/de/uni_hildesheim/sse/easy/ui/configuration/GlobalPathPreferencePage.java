package de.uni_hildesheim.sse.easy.ui.configuration;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.uni_hildesheim.sse.easy.ui.internal.EASyPreferenceStore;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;

/**
 * Implements the global EASy path preference page.
 * The user can change the global ivml-, vil and/or vtl-Path.
 * Initially, the input fields hold the current values.
 * The user can restore the default values which are stored in the default Configuration.
 * 
 * Moreover the user can change these paths by typing in new ones. As paths are interpreted
 * as project local paths, selection buttons do not make sense here.
 * After pressing the apply-Button the new values are stored in the default configuration and the 
 * Eclipse Preference-Store.
 * 
 * @author Niko Nowatzki
 * @author Holger Eichelberger
 */
public class GlobalPathPreferencePage extends PreferencePage implements
    IWorkbenchPreferencePage, Listener {
    
    private Text ivmlInput;
    private Text vilInput;
    private Text vtlInput;
    
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
        ivmlLabel.setText("IVML path:");
        
        ivmlInput = new Text(pageComponent, SWT.SINGLE | SWT.BORDER);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        ivmlInput.setLayoutData(gd);
        
        Composite composite = new Composite(getShell(), SWT.NONE);
        GridLayout layout = new GridLayout(2, true);
        
        layout.marginWidth = 0;
        
        composite.setLayout(layout);

        Label vilLabel = new Label(pageComponent, SWT.LEFT);
        vilLabel.setText("VIL path:");
        
        vilInput = new Text(pageComponent, SWT.BORDER);
        vilInput.setLayoutData(gd);
        
        Label vtlLabel = new Label(pageComponent, SWT.LEFT);
        vtlLabel.setText("VTL path:");
        
        vtlInput = new Text(pageComponent, SWT.BORDER);
        vtlInput.setLayoutData(gd);
        vtlInput.setEnabled(false);
        
        setDefaultValues();
    }
    
    /**
     * Sets the path from <code>source</code> to <code>kind</code>.
     * 
     * @param source the source UI element
     * @param kind the target path kind
     */
    private static void setPath(Text source, PathKind kind) {
        String text = source.getText().trim();
        if (!text.isEmpty()) {
            Configuration.DEFAULT.setPathDirect(kind, Configuration.checkPath(text));
        }
    }
    
    @Override
    protected void performApply() {
        setPath(ivmlInput, PathKind.IVML);
        setPath(vilInput, PathKind.VIL);
        if (vtlInput.isEnabled()) {
            setPath(vtlInput, PathKind.VTL);
        } else {
            setPath(vilInput, PathKind.VTL); // implicit default rule
        }
        EASyPreferenceStore.persistDefaultConfiguration();
        
        super.performApply();
    }
    
    @Override
    protected void performDefaults() {
        setDefaultValues();
        super.performDefaults();
    }

    /**
     * Set the default values for the 3 paths.
     */
    private void setDefaultValues() {
        ivmlInput.setText(Configuration.DEFAULT.getPath(PathKind.IVML));
        vilInput.setText(Configuration.DEFAULT.getPath(PathKind.VIL));
        vtlInput.setText(Configuration.DEFAULT.getPath(PathKind.VTL));
    }

    @Override
    public void handleEvent(Event event) {
    }
    
}
