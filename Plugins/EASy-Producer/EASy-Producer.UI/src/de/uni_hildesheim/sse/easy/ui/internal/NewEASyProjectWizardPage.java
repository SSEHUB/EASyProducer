package de.uni_hildesheim.sse.easy.ui.internal;


import java.io.File;
import java.net.URI;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uni_hildesheim.sse.easy_producer.EASyProducerConstants;
import de.uni_hildesheim.sse.model.validation.IvmlIdentifierCheck;

/**
 * WizardPage for the creation of a new product line project.
 * 
 * @author El-Sharkawy
 * @author Nowatzki
 */

public class NewEASyProjectWizardPage extends WizardPage {

    private Text txtProjectName;
    private String defaultPrefix;
    private String lblText;
    

    /**
     * Sole constructor for creating a new {@link NewEASyProjectWizardPage}.
     */
    NewEASyProjectWizardPage() {
        super("New " + EASyProducerConstants.PROGRAM_NAME + " Project");
        setDescription("This wizard creates a new project for product lines.");
        setImageDescriptor(Activator.getImageDescriptor("icons/logo_big.gif"));
        this.defaultPrefix = "PL_";
        this.lblText = "Name of the product line:";
        updateStatus("updateStatus");
    }
    
    /**
     * {@inheritDoc}
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        layout.verticalSpacing = 9;
        Label label = new Label(container, SWT.NULL);
        label.setText(lblText);

        txtProjectName = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        txtProjectName.setLayoutData(gd);
        
        //validates the projectname when ever the name is changed.
        txtProjectName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent modifiedEvent) {
                
                dialogChanged();
                
            }
            
        });
        
        txtProjectName.setText(defaultPrefix);
        txtProjectName.addSelectionListener(new SelectionListener() {

            
            public void widgetDefaultSelected(SelectionEvent exc) {
                dialogChanged();
            }

            public void widgetSelected(SelectionEvent exc) {
                dialogChanged();              
            }
        });

        dialogChanged();
        setControl(container);
    }

    /**
     * Ensures that the text field is set correctly.
     */
    private void dialogChanged() {
        if (getProjectName().length() == 0) {
            updateStatus("Project name must be specified");
        } else {
            boolean projectnameExists = ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName()).exists();
            URI workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocationURI();
            File folder = new File(workspaceLocation);
            folder = new File(folder, getProjectName());
            boolean folderExists = folder.exists();
                      
            if (!IvmlIdentifierCheck.isValidIdentifier(getProjectName())) {
                updateStatus("Invalid project name");
            } else if (projectnameExists) {
                updateStatus("Project already exists");
            } else if (folderExists) {
                updateStatus("A (hidden) folder with the specified name exists in workspace");
            } else {
                updateStatus(null);
            }
        }
    }

    /**
     * Updates the status message in the top of the dialog.
     * 
     * @param message Message which should be displayed.
     */
    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    /**
     * Returns the name of the specified project.
     * 
     * @return The name of the specified project
     */
    public String getProjectName() {
        return txtProjectName.getText();
    }
}