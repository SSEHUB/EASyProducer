/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.productline_editor.configuration;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.IProductLineProjectListener;
import net.ssehub.easy.producer.core.mgmt.IVilExecutionListener;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.observer.EclipseProgressObserver;
import net.ssehub.easy.producer.ui.confModel.GUIConfiguration;
import net.ssehub.easy.producer.ui.confModel.GUIHistory;
import net.ssehub.easy.producer.ui.confModel.GUIHistoryItem;
import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.producer.ui.core.reasoning.AbstractReasonerListener;
import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.producer.ui.productline_editor.EclipseConsole;
import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Header menu holding buttons for the product configuration editor page.<br>
 * This buttons allow the user to:
 * <ul>
 * <li>Validate made Decisions</li>
 * <li>Transform the product</li>
 * </ul>
 * This class also handles the transformator notification pop up.
 * 
 * @author EL-Sharkawy
 * 
 */
public class ConfigurationHeaderMenu extends AbstractConfigMenu implements IProductLineProjectListener,
    IVilExecutionListener {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ConfigurationHeaderMenu.class, 
            Bundle.ID);
    
    private static final Image IMG_INSTANTIATE = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_ETOOL_DEF_PERSPECTIVE);
    private static final Image IMG_VALIDATE = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_ELCL_SYNCED);
    private static final Image IMG_FREEZE = PlatformUI.getWorkbench().getSharedImages()
        .getImage(IDE.SharedImages.IMG_OPEN_MARKER);
    private static final Image IMG_UNDO = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_TOOL_UNDO);
    private static final Image IMG_ABORT = PlatformUI.getWorkbench().getSharedImages()
        .getImage(ISharedImages.IMG_OBJS_ERROR_TSK);

    private Button validateProductButton;
    private Button undoButton;
    private Button btnInstantiate;
    private Button btnFreezeAll;
    private Button btnAbortInstantiation;

    /**
     * Created for demonstrating only. Please remove this after Dry-Run-Review.
     */
    private Button btnPropagate;
    private AbstractEASyEditorPage parentPage;

    /**
     * {@link IReasonerListener} for validating the configuration. Tests whether the current configuration is valid and
     * opens a dialog presenting the result.
     * 
     * @author El-Sharkawy
     * 
     */
    private class ValidateConfigListener extends AbstractReasonerListener {

        @Override
        public void endReasoning(ReasoningResult result) {
            clearErrorMessages();
            if (result.hasConflict()) {
                Message[] errorMessages = new Message[result.getMessageCount()];
                for (int i = 0; i < errorMessages.length; i++) {
                    errorMessages[i] = result.getMessage(i);
                }
                setErrorMessages(errorMessages);
                EasyProducerDialog.showReasonerErrorDialog(getParent().getShell(), errorMessages);
            } else {
                boolean hasWarnings = false;
                for (int i = 0; i < result.getMessageCount() && !hasWarnings; i++) {
                    hasWarnings |= result.getMessage(i).getStatus() == Status.WARNING;
                }
                if (hasWarnings) {
                    displayWarnings(result);
                } else {
                    EasyProducerDialog.showInfoDialog(getParent().getShell(), "Everything is ok");
                }
            }
        }
    }

    /**
     * {@link IReasonerListener} for propagating values.
     * 
     * @author El-Sharkawy
     * 
     */
    private class PropagateListener extends AbstractReasonerListener {

        @Override
        public void endReasoning(ReasoningResult result) {
            if (result.hasConflict()) {
                Message[] errorMessages = new Message[result.getMessageCount()];
                for (int i = 0; i < errorMessages.length; i++) {
                    errorMessages[i] = result.getMessage(i);
                }
                setErrorMessages(errorMessages);
                EasyProducerDialog.showReasonerErrorDialog(getParent().getShell(), errorMessages);
            } else {
                clearErrorMessages();
                if (result.getMessageCount() > 0) {
                    displayWarnings(result);
                }
            }
        }
    }

    /**
     * {@link IReasonerListener}, for a reasoning which is executed automatically before freezing the configuration.
     * 
     * @author El-Sharkawy
     * 
     */
    private class ReasoningPreFreezeListener extends AbstractReasonerListener {
        @Override
        public void endReasoning(ReasoningResult result) {
            if (result.hasConflict()) {
                Message[] errorMessages = new Message[result.getMessageCount()];
                for (int i = 0; i < errorMessages.length; i++) {
                    errorMessages[i] = result.getMessage(i);
                }
                setErrorMessages(errorMessages);
                EasyProducerDialog.showReasonerErrorDialog(getParent().getShell(), errorMessages);
            } else {
                clearErrorMessages();
                if (result.getMessageCount() > 0) {
                    displayWarnings(result);
                }
                getConfigContainer().getGuiConfig().freeze();
                // TODO SE: check whether something changed.
                parentPage.refresh();
                parentPage.setDirty();
            }
        }
    }

    /**
     * Sole constructor for this class.
     * 
     * @param parent
     *            the parent control (must not be <tt>null</tt>).
     * @param plp
     *            Current configured project holding the configuration (must not be <tt>null</tt>).
     * @param parentPage
     *            The page bearing this menu item (must not be <tt>null</tt>).
     */
    public ConfigurationHeaderMenu(Composite parent, ProductLineProject plp, AbstractEASyEditorPage parentPage) {

        super(parent, plp);
        setBackground(parent.getBackground());
        this.parentPage = parentPage;
        plp.register(this);
        plp.addVilExecutionListener(this);
        createButtons();
    }
    
    /**
     * Creates the two buttons.
     */
    private void createButtons() {
        createValidateButton();
        createInstantiateButton();
        createPropagateButton();
        createFreezeButton();
        createUndoButton();
        createAbortInstantiationButton();
    }

    

    /**
     * Creates Propagation button. TODO: Remove this button after Dry-Run-Review.
     */
    private void createPropagateButton() {
        btnPropagate = new Button(this, SWT.NONE);
        btnPropagate.setText("Propagate Values");
        btnPropagate.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
        btnPropagate.setImage(IMG_VALIDATE);

        // Add Listener
        btnPropagate.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                createReasoningProgressObserver(ReasoningOperation.PROPAGATION, new PropagateListener());
            }
        });
    }

    /**
     * Tests whether the model is valid and freezes all not frozen variables.
     */
    private void createFreezeButton() {
        btnFreezeAll = new Button(this, SWT.NONE);
        btnFreezeAll.setText("Freeze All");
        btnFreezeAll.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
        btnFreezeAll.setImage(IMG_FREEZE);

        // Add Listener
        btnFreezeAll.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                createReasoningProgressObserver(ReasoningOperation.VALIDATION, new ReasoningPreFreezeListener());
            }
        });
    }

    /**
     * Creates a reasoning progress observer based on {@link #getProductLineProject()}.
     * 
     * @param operation
     *            the desired reasoning operation
     * @param listener
     *            A listener which will be called after the reasoning has been finished. Can be <tt>null</tt>, if no
     *            action shall be executed after the reasoning is finished.
     */
    private void createReasoningProgressObserver(ReasoningOperation operation,
        IReasonerListener listener) {

        getProductLineProject().reason(operation, listener);
    }
    
    /**
     * Creates revert button.
     */
    private void createUndoButton() {
        undoButton = new Button(this, SWT.NONE);
        undoButton.setText("Undo Changes");
        undoButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
        undoButton.setImage(IMG_UNDO);
        // Add Listener
        undoButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                GUIConfiguration guiConfig = getConfigContainer().getGuiConfig();
                GUIVariable[] guiVarElements = guiConfig.getElements();
                // Find out which variable was edited last
                Map<Long, GUIVariable> lastEditedGuiVariable = new HashMap<Long, GUIVariable>();
                for (GUIVariable guiVariable : guiVarElements) {
                    if (guiVariable.getHistory().getLastEdited() > 0) {
                        lastEditedGuiVariable.put(guiVariable.getHistory().getLastEdited(), guiVariable);
                    }
                }
                // Sort lastEditedGuiVariable
                TreeMap<Long, GUIVariable> treeMap = new TreeMap<Long, GUIVariable>(lastEditedGuiVariable);
                if (!treeMap.isEmpty()) {
                    GUIVariable guiVariable = treeMap.lastEntry().getValue();
                    // Get last edited variable
                    GUIHistoryItem guiHistoryitem = guiVariable.getHistory().getLastHistoryItem();
                    if (guiHistoryitem != null) {
                        try {
                            restoreHistoryValue(guiVariable, guiHistoryitem);
                        } catch (ConfigurationException configurationException) {
                            LOGGER.exception(configurationException);
                        }
                        LOGGER.debug("Reassigned old values " + guiVariable.getVariable());
                        guiConfig.configurationChanged();
                        
                        int count = guiVariable.getVariable().getNestedElementsCount();
                        for (int i = 0; i < count; i++) {
                            IDecisionVariable tmp = guiVariable.getVariable().getNestedElement(i);
                            LOGGER.debug("Nested: " + tmp + "; " + tmp.getState());
                        }
                    } 
                }
            }

            private void restoreHistoryValue(GUIVariable guiVariable, GUIHistoryItem guiHistoryitem)
                throws ConfigurationException {
                
                if (null != guiHistoryitem) {
                    guiVariable.getVariable().setHistoryValue(guiHistoryitem.getValue(), 
                        guiHistoryitem.getState());
                    IGUIConfigurationContainer editor = getConfigContainer();
                    editor.updateItem(guiVariable);
                    
                    for (int i = 0, end = guiVariable.getNestedElementsCount(); i < end; i++) {
                        GUIVariable nestedGUIVar = guiVariable.getNestedElement(i);
                        GUIHistory nestedGUIHistory = nestedGUIVar.getHistory();
                        GUIHistoryItem nestedGUIHistoryItem = nestedGUIHistory.getLastHistoryItem();
                        restoreHistoryValue(nestedGUIVar, nestedGUIHistoryItem);
                    }
                }
            }
        });
    }

    /**
     * Creates validation button.
     */
    private void createValidateButton() {
        validateProductButton = new Button(this, SWT.NONE);
        validateProductButton.setText("Validate Product");
        validateProductButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
        validateProductButton.setImage(IMG_VALIDATE);

        // Add Listener
        setValidateListener();
    }

    /**
     * Creates a listener for the validation button and add it to the button.
     */
    private void setValidateListener() {
        validateProductButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                createReasoningProgressObserver(ReasoningOperation.VALIDATION, new ValidateConfigListener());
            }
        });
    }

    /**
     * Creates the transform button.
     */
    private void createInstantiateButton() {
        btnInstantiate = new Button(this, SWT.PUSH);
        btnInstantiate.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
        btnInstantiate.setText("Instantiate Product");
        btnInstantiate.setImage(IMG_INSTANTIATE);
    }
    
    /**
     * Creates the transform button.
     */
    private void createAbortInstantiationButton() {
        btnAbortInstantiation = new Button(this, SWT.PUSH);
        btnAbortInstantiation.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
        btnAbortInstantiation.setText("Stop Instantiation");
        btnAbortInstantiation.setImage(IMG_ABORT);
        btnAbortInstantiation.setEnabled(false);
        // Add Listener
        setInstantiationListeners();
    }

    /**
     * Creates a listener for the instantiation and abort button and add them the buttons.
     */
    private void setInstantiationListeners() {
        btnInstantiate.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                btnAbortInstantiation.setEnabled(true);
                btnInstantiate.setEnabled(false);
                /*
                 * The EclipseConsole allows displaying relevant information on instantiation processes to the user.
                 * Thus, for each instantiation process triggered by the user, the console will be cleared first and
                 * then the new output of the new instantiation process will be written to the console
                 */
                EclipseConsole.INSTANCE.clearConsole();
                getProductLineProject().instantiate(new EclipseProgressObserver(), false);
                getProductLineProject().refreshArtifacts(); 
            }
        });
        
        btnAbortInstantiation.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                getProductLineProject().abortInstantiation();
            }
        });
    }
    
    /**
     * Method for preparing a <tt>RasonerResult</tt> for showing a warnings dialog. It filters only warnings out of the
     * <tt>RasonerResult</tt> and creates a dialog which displays the warnings.
     * 
     * @param result
     *            The result of an reasoning step, may containing warnings.
     */
    private void displayWarnings(ReasoningResult result) {
        List<Message> warnings = new LinkedList<Message>();
        for (int i = 0; i < result.getMessageCount(); i++) {
            Message msg = result.getMessage(i);
            if (Status.WARNING == msg.getStatus() || Status.UNSUPPORTED == msg.getStatus()) {
                warnings.add(result.getMessage(i));
            }
        }
        if (warnings.size() > 0) {
            Message[] warningsArray = warnings.toArray(new Message[warnings.size()]);
            EasyProducerDialog.showReasonerWarningDialog(getParent().getShell(), warningsArray);
        }
    }

    @Override
    public void revalidateButtons() {        
        Display.getDefault().asyncExec(new Runnable() {
            
            @Override
            public void run() {
                if (!btnInstantiate.isDisposed()) {
                    if (!getProductLineProject().isTransformable()) {
                        btnInstantiate.setEnabled(false);
                    } else if (!btnInstantiate.isEnabled()) {
                        btnInstantiate.setEnabled(true);
                    }
                }

                if (!validateProductButton.isDisposed()) {
                    if (ReasonerFrontend.getInstance().reasoningSupported()) {
                        validateProductButton.setEnabled(true);
                    } else {
                        validateProductButton.setEnabled(false);
                    }
                }
            }            
        });
        
    }

    @Override
    public void configurationPulled() {
        revalidateButtons();
    }

    @Override
    public void dispose() {
        getProductLineProject().unregister(this);
        getProductLineProject().removeVilExecutionListener(this);
        super.dispose();
    }

    @Override
    public void projectClosed() {
        // Not needed here
    }

    @Override
    public void buildScriptChanged() {
        revalidateButtons();
    }

    @Override
    public void vilExecutionAborted(final PLPInfo plp, final VilException exc) {
        if (plp == getProductLineProject()) {
            Display.getDefault().asyncExec(new Runnable() {
                
                @Override
                public void run() {
                    EasyProducerDialog.showErrorDialog(exc.getMessage());
                }
            });
            vilExecutionFinished(plp);
        }
    }

    @Override
    public void vilExecutionFinished(final PLPInfo plp) {
        if (plp == getProductLineProject()) {
            Display.getDefault().asyncExec(new Runnable() {
    
                @Override
                public void run() {
                    if (null != ConfigurationHeaderMenu.this && !ConfigurationHeaderMenu.this.isDisposed()) {
                        
                        btnAbortInstantiation.setEnabled(false);
                        btnInstantiate.setEnabled(true);
                    }
                }
            });
        }
    }
}