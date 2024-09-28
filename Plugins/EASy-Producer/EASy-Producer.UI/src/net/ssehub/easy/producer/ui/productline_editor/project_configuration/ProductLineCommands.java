/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.producer.ui.productline_editor.project_configuration;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.observer.EclipseProgressObserver;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.InvalidProjectnameException;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.ProjectAlreadyExistsException;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.ProjectCreator;
import net.ssehub.easy.producer.ui.core.GUIUtils;
import net.ssehub.easy.producer.ui.core.reasoning.AbstractReasonerListener;
import net.ssehub.easy.producer.ui.internal.Activator;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.producer.ui.productline_editor.EclipseConsole;
import net.ssehub.easy.producer.ui.productline_editor.predecessorSelection.PredecessorSelectionDialog;
import net.ssehub.easy.producer.ui.project_management.EASyJavaConfigurator;
import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.validation.IvmlIdentifierCheck;

/**
 * Top-level shared product line commands.
 * 
 * @author Holger Eichelberger
 */
public class ProductLineCommands {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ProductLineCommands.class,
        Activator.PLUGIN_ID);

    /**
     * Allows for choosing new predecessors.
     * 
     * @param shell the active shell
     * @param plp the current product line project
     */
    public static void modifyPredecessors(Shell shell, ProductLineProject plp) {
        PredecessorSelectionDialog selectiondlg = new PredecessorSelectionDialog(shell, SWT.TITLE | SWT.BORDER
                | SWT.APPLICATION_MODAL, plp.getProjectID());
        ArrayList<String> newPredecessors = selectiondlg.open();
        plp.setPredecessors(newPredecessors);
    }

    /**
     * Allows for pulling a the configuration(s) from the predecessor(s).
     * 
     * @param shell the active shell
     * @param plp the current product line project
     */
    public static void pullConfigurationFromPredecessors(Shell shell, ProductLineProject plp) {
        plp.pullConfigFromPredecessors();
    }
    
    /**
     * Input Validation class for the product creation dialog.
     * 
     * @author El-Sharkawy
     * 
     */
    private static class InputValidator implements IInputValidator {
        
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
     * Displays the dialog for creating a new product.
     * 
     * @param shell the active shell
     * @param plp the current product line project
     */
    public static void createProductLineMember(Shell shell, ProductLineProject plp) {

        InputDialog dia = new InputDialog(shell, "Create a new Product Line Member",
            "Please enter the name of your new Product Line Member:", "New_Product", new InputValidator());
        dia.open();
        if (Window.OK == dia.getReturnCode()) {
            try {
                ProjectCreator pc = new ProjectCreator(dia.getValue());
                ProductLineProject newPLP = pc.deriveNewMember(plp.getProjectID(),
                    new EASyJavaConfigurator());
                try {
                    GUIUtils.openProductLineEditor(newPLP);
                } catch (PartInitException e) {
                    LOGGER.exception(e);
                }
            } catch (ProjectAlreadyExistsException e) {
                // Could not occur, because of the IInputValidator.isValid method.
            } catch (InvalidProjectnameException e) {
                LOGGER.exception(e);
            }
        }
    }
    
    /**
     * <code>IReasonerListener</code> for validating the variability model (perform satisfiability check).
     * 
     * @author El-Sharkawy
     */
    public static class ValidationListener extends AbstractReasonerListener {
        
        private Shell shell;
        
        public ValidationListener(Shell shell) {
            this.shell = shell;
        }
        
        protected Shell getShell() {
            return shell;
        }
        
        @Override
        public void endReasoning(ReasoningResult result) {
            if (result.reasoningUnsupported()) {
                EasyProducerDialog.showErrorDialog(shell,
                    "Currently installed reasoners are not able to handle the "
                            + "desired reasoning operation");
            } else if (result.hasConflict()) {
                Message[] errorMessages = new Message[result.getMessageCount()];
                for (int i = 0; i < errorMessages.length; i++) {
                    errorMessages[i] = result.getMessage(i);
                }
                onErrors(errorMessages);
            } else {
                boolean hasWarnings = false;
                for (int i = 0; i < result.getMessageCount() && !hasWarnings; i++) {
                    hasWarnings |= result.getMessage(i).getStatus() == Status.WARNING;
                }
                boolean done = false;
                if (hasWarnings) {
                    done = onWarnings(result);
                } 
                if (!done) {
                    EasyProducerDialog.showInfoDialog(shell, "No conflicts detected");
                }
            }
        }

        /**
         * Called on errors. May be overridden.
         * 
         * @param errorMessages the error messages
         */
        protected void onErrors(Message[] errorMessages) {
            EasyProducerDialog.showReasonerErrorDialog(shell, errorMessages);
        }

        /**
         * Called on warnings. May be overridden.
         * 
         * @param result the reasoning result
         * @return {@code true} if warnings are handled and no "everything ok message" shall be shown, {@code false} if 
         *     the "everything ok message" shall be shown anyway
         * @see ProductLineCommands#displayWarnings(Shell, ReasoningResult)
         */
        protected boolean onWarnings(ReasoningResult result) {
            // origina, no warning output
            return false;
        }
        
    }

    /**
     * Method for preparing a <code>RasonerResult</code> for showing a warnings dialog. It filters only warnings 
     * out of the <code>RasonerResult</code> and creates a dialog which displays the warnings.
     * 
     * @param shell the parent shell
     * @param result The result of an reasoning step, may containing warnings.
     */
    public static void displayWarnings(Shell shell, ReasoningResult result) {
        List<Message> warnings = new LinkedList<Message>();
        for (int i = 0; i < result.getMessageCount(); i++) {
            Message msg = result.getMessage(i);
            if (Status.WARNING == msg.getStatus() || Status.UNSUPPORTED == msg.getStatus()) {
                warnings.add(result.getMessage(i));
            }
        }
        if (warnings.size() > 0) {
            Message[] warningsArray = warnings.toArray(new Message[warnings.size()]);
            EasyProducerDialog.showReasonerWarningDialog(shell, warningsArray);
        }
    }

    /**
     * Validates the given product line with a default validation listener.
     * 
     * @param op the reasoning operation to execute
     * @param shell the active shell
     * @param plp the current product line project
     */
    public static void validateProductLine(ReasoningOperation op, Shell shell, ProductLineProject plp) {
        validateProductLine(op, shell, plp, new ValidationListener(shell));
    }

    /**
     * Validates the given product line.
     * 
     * @param op the reasoning operation to execute
     * @param shell the active shell
     * @param plp the current product line project
     * @param listener a custom validation listener
     */
    public static void validateProductLine(ReasoningOperation op, Shell shell, ProductLineProject plp, 
        IReasonerListener listener) {
        plp.reason(op, listener);
    }

    /**
     * Instantiates the given product line.
     * 
     * @param shell the active shell
     * @param plp the current product line project
     */
    public static void instantiateProductLine(Shell shell, ProductLineProject plp) {
        instantiateProductLine(shell, plp, false);
    }

    /**
     * Instantiates the given product line.
     * 
     * @param shell the active shell
     * @param plp the current product line project
     * @param forceSelfInstantiate whether a self-insantiation shall be carried out forcibly
     */
    public static void instantiateProductLine(Shell shell, ProductLineProject plp, boolean forceSelfInstantiate) {
        /*
         * The EclipseConsole allows displaying relevant information on instantiation processes to the user.
         * Thus, for each instantiation process triggered by the user, the console will be cleared first and
         * then the new output of the new instantiation process will be written to the console
         */
        EclipseConsole.INSTANCE.clearConsole();
        plp.instantiate(new EclipseProgressObserver(), false, forceSelfInstantiate);
        plp.refreshArtifacts(); 
    }

}
