package de.uni_hildesheim.sse.easy.ui.configuration;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.PersistenceUtils;

/**
 * Implements the global preference page.
 * The user can change the global ivml-, vil and/or vtl-Path.
 * First of all the input fields hold the current values as messages.
 * The user can restore the default values which are stored in the default Configuration.
 * 
 * These paths would be "EASy".
 * 
 * Moreover the user can change these paths by typing in new ones.
 * After pressing the apply-Button the new values are stored in the Eclipse Preference-Store.
 * When the user runs a new Eclipse-instance these values are loaded as default and put in the textfield.
 * If the user decides to change them to the default-values he can do that ba using "Restore Defaults"...
 * 
 * @author Niko Nowatzki
 * @author Holger Eichelberger
 */
public class PathPropertyPage extends PropertyPage implements IWorkbenchPreferencePage, Listener {
    
    private Configuration projectConfiguration;
    private IProject currentProject;
    private Text ivmlInput;
    private Text vilInput;
    private Text vtlInput;
    private Label materialized;
    
    @Override
    public void init(IWorkbench workbench) {
        init();
    }

    /**
     * Lazy init.
     */
    private void init() {
        if (null == currentProject) {
            IAdaptable a = getElement();
            currentProject = (IProject) a.getAdapter(IProject.class);
            projectConfiguration = PersistenceUtils.getConfiguration(currentProject);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected Control createContents(Composite parent) {
        init();
        
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
     * Updates the materialized label.
     */
    private void updateMaterialized() {
        String text;
        if (projectConfiguration.isMaterialized()) {
            text = "Local:";
        } else {
            text = "Global:";
        }        
        materialized.setText(text);
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
    
        pageComponent.setLayout(new GridLayout(3, false));
    
        materialized = new Label(pageComponent, SWT.LEFT);
        updateMaterialized();
        
        new Label(pageComponent, SWT.LEFT);
        new Label(pageComponent, SWT.LEFT);
        
        Label ivmlLabel = new Label(pageComponent, SWT.LEFT);
        ivmlLabel.setText("IVML path:");
        
        ivmlInput = new Text(pageComponent, SWT.SINGLE | SWT.BORDER);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        ivmlInput.setLayoutData(gd);
        createPathSelectionButton(pageComponent, PathKind.VTL);
        
        Composite composite = new Composite(getShell(), SWT.NONE);
        GridLayout layout = new GridLayout(2, true);
        
        layout.marginWidth = 0;
        
        composite.setLayout(layout);

        Label vilLabel = new Label(pageComponent, SWT.LEFT);
        vilLabel.setText("VIL path:");
        
        vilInput = new Text(pageComponent, SWT.BORDER);
        vilInput.setLayoutData(gd);
        createPathSelectionButton(pageComponent, PathKind.VTL);
        
        Label vtlLabel = new Label(pageComponent, SWT.LEFT);
        vtlLabel.setText("VTL path:");
        
        vtlInput = new Text(pageComponent, SWT.BORDER);
        vtlInput.setLayoutData(gd);
        vtlInput.setEnabled(false);
        createPathSelectionButton(pageComponent, PathKind.VTL).setEnabled(false);
        
        setInputs(projectConfiguration);
    }
    
    /**
     * Implements a listener for the path selection button.
     * 
     * @author Holger Eichelberger
     */
    private class ButtonListener implements Listener {
        
        private PathKind kind;
        
        /**
         * Creates the listener for a specific path kind.
         * 
         * @param kind the kind
         */
        ButtonListener(PathKind kind) {
            this.kind = kind;
        }
        
        @Override
        public void handleEvent(Event evt) {
            if (SWT.Selection == evt.type) {
                ResourceListSelectionDialog dlg = new ResourceListSelectionDialog(
                    PathPropertyPage.this.getShell(), currentProject, IResource.FOLDER);
                if (ResourceListSelectionDialog.OK == dlg.open()) {
                    Object[] selected = dlg.getResult();
                    if (null != selected && selected.length > 0 && selected[0] instanceof IResource) {
                        IResource res = (IResource) selected[0];
                        try {
                            projectConfiguration.setPath(kind, res.getFullPath().toFile());
                        } catch (IOException e) {
                            MessageDialog.openError(getShell(), "Error setting path", e.getMessage());
                        }
                    }
                }
            }
        }
        
    }
    
    /**
     * Creates a path selection button.
     * 
     * @param pageComponent the page component to create the button for
     * @param kind the path kind
     * @return the button created
     */
    private Button createPathSelectionButton(Composite pageComponent, PathKind kind) {
        Button button = new Button(pageComponent, SWT.CENTER);
        button.setText("...");
        button.addListener(SWT.Selection, new ButtonListener(kind)); 
        return button;
    }
    
    /**
     * Sets the texts from the given <code>configuration</code>.
     * 
     * @param configuration the configuration to take the paths from
     */
    private void setInputs(Configuration configuration) {
        ivmlInput.setText(configuration.getPath(PathKind.IVML));
        vilInput.setText(configuration.getPath(PathKind.VIL));
        vtlInput.setText(configuration.getPath(PathKind.VTL));
    }
    
    @Override
    protected void performDefaults() {
        setInputs(Configuration.DEFAULT);
        super.performDefaults();
    }
    
    /**
     * Sets the path from <code>source</code> to <code>kind</code>.
     * 
     * @param source the source UI element
     * @param kind the target path kind
     */
    private void setPath(Text source, PathKind kind) {
        String text = source.getText().trim();
        if (!text.isEmpty()) {
            try {
                projectConfiguration.setPath(kind, new File(source.getText()));
            } catch (IOException e) {
                MessageDialog.openError(getShell(), "Error setting path", e.getMessage());
            }
        }
    }
    
    @Override
    protected void performApply() {
        setPath(ivmlInput, PathKind.IVML);
        setPath(vilInput, PathKind.VIL);
        if (vtlInput.isEnabled()) {
            setPath(vtlInput, PathKind.VTL);    
        } else {
            setPath(vilInput, PathKind.VTL); // default rule
        }
        projectConfiguration.store();
        super.performApply();
        updateMaterialized();
    }

    @Override
    public void handleEvent(Event event) {
    }
    
}
