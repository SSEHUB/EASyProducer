package net.ssehub.easy.producer.ui.internal;


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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import net.ssehub.easy.producer.eclipse.EASyProducerConstants;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.IEASyProjectConfigurator;
import net.ssehub.easy.producer.ui.project_management.AbstractProjectCreationDescriptor;
import net.ssehub.easy.producer.ui.project_management.ProjectConfigurationRegistry;
import net.ssehub.easy.varModel.validation.IvmlIdentifierCheck;

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
    private Combo projectTypeSelection;

    /**
     * Sole constructor for creating a new {@link NewEASyProjectWizardPage}.
     */
    NewEASyProjectWizardPage() {
        super("New " + EASyProducerConstants.PROGRAM_NAME + " Project");
        setDescription("This wizard creates a new project for product lines.");
        setImageDescriptor(Activator.getImageDescriptor("icons/logo_big.gif"));
        this.defaultPrefix = "PL_";
        this.lblText = "Name of the project:";
        updateStatus("updateStatus");
    }
    
    /**
     * {@inheritDoc}
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout(2, false);
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
        
        projectTypeSelection = null;
        if (ProjectConfigurationRegistry.getDescriptorSize() > 0) {
            Label lblProjectTypeSelection = new Label(container, SWT.WRAP | SWT.LEFT);
            GridData gdTypeSelection = new GridData(SWT.HORIZONTAL, SWT.TOP, false, false, 1, 1);
            gdTypeSelection.widthHint = 200;
            lblProjectTypeSelection.setLayoutData(gdTypeSelection);
            lblProjectTypeSelection.setText("Underlying Eclipse project basis for the new "
                + EASyProducerConstants.PROGRAM_NAME + " project:");
            projectTypeSelection = new Combo(container, SWT.DROP_DOWN);
            projectTypeSelection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            for (int i = 0, end = ProjectConfigurationRegistry.getDescriptorSize(); i < end; i++) {
                projectTypeSelection.add(ProjectConfigurationRegistry.getDescriptor(i).getProjectType());
            }
            projectTypeSelection.select(0);
        }
        
        dialogChanged();
        setControl(container);
    }

    /**
     * Returns the selected {@link IEASyProjectConfigurator}.
     * @return The selected {@link IEASyProjectConfigurator}, maybe <tt>null</tt> only in case of errors.
     */
    IEASyProjectConfigurator getProjectConfigurator() {
        AbstractProjectCreationDescriptor projectDescriptor = null;
        if (null != projectTypeSelection && projectTypeSelection.getItemCount() > 0) {
            int index = projectTypeSelection.getSelectionIndex();
            if (index >= 0 && ProjectConfigurationRegistry.getDescriptorSize() > index) {
                projectDescriptor = (ProjectConfigurationRegistry.getDescriptor(index));
            }  
        }
        return null != projectDescriptor ? projectDescriptor.getProjectConfigurator() : null;
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