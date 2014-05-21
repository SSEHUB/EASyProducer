package de.uni_hildesheim.sse.easy.ui.productline_editor.project_configuration;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.uni_hildesheim.sse.easy.ui.contributions.Contributions;
import de.uni_hildesheim.sse.easy.ui.contributions.Contributions.UIElement;
import de.uni_hildesheim.sse.easy.ui.core.GUIUtils;
import de.uni_hildesheim.sse.easy.ui.core.reasoning.AbstractReasonerListener;
import de.uni_hildesheim.sse.easy.ui.internal.Activator;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractHeaderMenu;
import de.uni_hildesheim.sse.easy.ui.productline_editor.EasyProducerDialog;
import de.uni_hildesheim.sse.easy.ui.productline_editor.PTNSelectionDialog.PtnSelectionDialog;
import de.uni_hildesheim.sse.easy.ui.project_management.ProjectCreator;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.InvalidProjectnameException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ProjectAlreadyExistsException;
import de.uni_hildesheim.sse.model.validation.IvmlIdentifierCheck;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Header menu holding buttons for product line editor page.<br>
 * This buttons allow the user to:
 * <ul>
 * <li>Validate constraints</li>
 * <li>Pull the configuration from predecessors</li>
 * <li>Add/remove predecessors</li>
 * <li>Derive new member</li>
 * </ul>
 * 
 * @author EL-Sharkawy
 * @author Nowatzki
 * 
 */
public class ProductLineHeaderMenu extends AbstractHeaderMenu {
    private static final Image IMG_VALIDATE = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_ELCL_SYNCED);
    private static final Image IMG_PULL_CONFIG = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_ETOOL_DEF_PERSPECTIVE);
    private static final Image IMG_DERIVE = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_TOOL_COPY);
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ProductLineHeaderMenu.class,
        Activator.PLUGIN_ID);
    
    private Button btnValidateProductline;
    private Button btnPullConfiguration;
    private Button btnManagePredecessors;
    private Button btnCreateMember;
    private AbstractEASyEditorPage relatedEditor;
    
 
    /**
     * Input Validation class for the product creation dialog.
     * 
     * @author El-Sharkawy
     * 
     */
    private class InputValidator implements IInputValidator {
        
        @Override
        public String isValid(String projectname) {
            String result = null;
            
            if (projectname == null || projectname.isEmpty()) {
                result = "Project name cannot be null!";
            } else {
                try {
                    boolean projectnameExists =
                        ResourcesPlugin.getWorkspace().getRoot().getProject(projectname).exists();
                    URI workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocationURI();
                    File folder = new File(workspaceLocation);
                    folder = new File(folder, projectname);
                    boolean folderExists = folder.exists();
                    
                    if (!IvmlIdentifierCheck.isValidIdentifier(projectname)) {
                        result = "Invalid project name";
                    } else if (projectnameExists) {
                        result = "Project already exists";
                    } else if (folderExists) {
                        result = "A (hidden) folder with the specified name exists in workspace";
                    }
                } catch (IllegalArgumentException exc) {
                    result = "Invalid project name";
                }
            }
            return result;
        }
    }
    
    /**
     * <tt>IReasonerListener</tt> for validating the variability model (perform satisfiability check).
     * @author El-Sharkawy
     *
     */
    private class ValidationListener extends AbstractReasonerListener {
        @Override
        public void endReasoning(ReasoningResult result) {
            if (result.reasoningUnsupported()) {
                EasyProducerDialog.showErrorDialog(getParent().getShell(),
                        "Currently installed reasoners are not able to handle the "
                                + "desired reasoning operation");
            } else if (result.hasConflict()) {
                Message[] errorMessages = new Message[result.getMessageCount()];
                for (int i = 0; i < errorMessages.length; i++) {
                    errorMessages[i] = result.getMessage(i);
                }
                EasyProducerDialog.showReasonerErrorDialog(getParent().getShell(), errorMessages);
            } else {
                EasyProducerDialog.showInfoDialog(getParent().getShell(), "No conflicts detected");
            }
        }
    }

    /**
     * Sole constructor for this class.
     * 
     * @param parent the parent control
     * @param plp Current configured project holding the configuration.
     * @param relatedEditor The editor holding this menu, will be refreshed after some operations.
     * @see AbstractEASyEditorPage#refresh()
     */
    public ProductLineHeaderMenu(Composite parent, ProductLineProject plp, AbstractEASyEditorPage relatedEditor) {
        super(parent, plp);
        this.relatedEditor = relatedEditor;
        createButtons();
    }

    /**
     * Creates the buttons.
     */
    private void createButtons() {
        // Validate Constraints
        btnValidateProductline = new Button(this, SWT.PUSH);
        btnValidateProductline.setText("Validate Constraints");
        btnValidateProductline.setImage(IMG_VALIDATE);
        createValidateListener();

        // Pull Configuration
        btnPullConfiguration = new Button(this, SWT.PUSH);
        btnPullConfiguration.setText("Pull Configuration");
        btnPullConfiguration.setImage(IMG_PULL_CONFIG);
        Contributions.configure(btnPullConfiguration, UIElement.PULL_CONFIGURATION);
        createPullListener();

        // Add/remove predecessors
        btnManagePredecessors = new Button(this, SWT.PUSH);
        btnManagePredecessors.setText("Add/remove predecessors");
        createPredecessorListener();

        // Derive new Product Line Member
        btnCreateMember = new Button(this, SWT.PUSH);
        btnCreateMember.setText("Derive new Product Line Member");
        btnCreateMember.setImage(IMG_DERIVE);
        Contributions.configure(btnCreateMember, UIElement.DERIVE_NEW_MEMBER);
        createDeriveListener();
    }

    /**
     * Creates the Listener for the Validate button.
     */
    private void createValidateListener() {
        btnValidateProductline.addSelectionListener(new SelectionAdapter() {           

            @Override
            public void widgetSelected(SelectionEvent event) {
                getProductLineProject().reason(ReasoningOperation.CONSITENCY_CHECK, new ValidationListener());
            }
        });
    }

    /**
     * Creates the Listener for the Add Predecessor button.
     */
    private void createPredecessorListener() {
        btnManagePredecessors.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                displayCreateAddPredecessorDialog();
            }
        });
    }

    /**
     * Creates a Dialog for choosing new predecessors.
     */
    private void displayCreateAddPredecessorDialog() {
        PtnSelectionDialog selectiondlg = new PtnSelectionDialog(getShell(), SWT.TITLE | SWT.BORDER
                | SWT.APPLICATION_MODAL, getProductLineProject().getProjectID());
        ArrayList<String> newPredecessors = selectiondlg.open();
        getProductLineProject().setPredecessors(newPredecessors);
    }

    /**
     * Creates the Listener for the Pull Config button.
     */
    private void createPullListener() {
        btnPullConfiguration.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                getProductLineProject().pullConfigFromPredecessors();
                relatedEditor.refresh();
            }
        });
    }

    /**
     * Creates the Listener for the Derive New Product Node button.
     */
    private void createDeriveListener() {
        btnCreateMember.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                try {
                    displayCreateProductDialog();
                } catch (InvalidProjectnameException e) {
                    LOGGER.exception(e);
                }
            }
        });
    }

    /**
     * Displays the dialog for creating a new product.
     * @throws InvalidProjectnameException 
     */
    private void displayCreateProductDialog() throws InvalidProjectnameException {

        InputDialog dia = new InputDialog(getShell(), "Create a new Product Line Member",
            "Please enter the name of your new Product Line Member:", "New_Product", new InputValidator());
        dia.open();
        if (Window.OK == dia.getReturnCode()) {
            try {
                ProjectCreator pc = new ProjectCreator(dia.getValue());
                ProductLineProject newPLP = pc.deriveNewMember(getProductLineProject().getProjectID());
                try {
                    GUIUtils.openProductLineEditor(newPLP);
                } catch (PartInitException e) {
                    LOGGER.exception(e);
                }
            } catch (ProjectAlreadyExistsException e) {
                // Could not occur, because of the IInputValidator.isValid method.
            }
        }
    }
    
    @Override
    public void revalidateButtons() {
        ReasonerFrontend reasoner = ReasonerFrontend.getInstance();
        if (reasoner.reasoningSupported()) {
            btnValidateProductline.setEnabled(true);
        } else {
            btnValidateProductline.setEnabled(false);
        }
        if (Contributions.isEnabled(UIElement.PULL_CONFIGURATION)) {
            if (getProductLineProject().getMemberController().hasPredecessors()) {
                btnPullConfiguration.setEnabled(true);
            } else {
                btnPullConfiguration.setEnabled(false);
            }
        }
    }
}