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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.IProductLineProjectListener;
import net.ssehub.easy.producer.core.mgmt.IVilExecutionListener;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.confModel.GUIConfiguration;
import net.ssehub.easy.producer.ui.confModel.GUIHistory;
import net.ssehub.easy.producer.ui.confModel.GUIHistoryItem;
import net.ssehub.easy.producer.ui.confModel.GUIVariable;
import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.producer.ui.productline_editor.project_configuration.ProductLineCommands;
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

    private class BasicConfigListener extends ProductLineCommands.ValidationListener {

        public BasicConfigListener(Shell shell) {
            super(shell);
        }

        @Override
        protected void onErrors(Message[] errorMessages) {
            setErrorMessages(errorMessages);
            super.onErrors(errorMessages);
        }

        @Override
        protected boolean onWarnings(ReasoningResult result) {
            ProductLineCommands.displayWarnings(getShell(), result);
            return true;
        }

    }

    /**
     * {@link IReasonerListener} for validating the configuration. Tests whether the current configuration is valid and
     * opens a dialog presenting the result.
     * 
     * @author El-Sharkawy
     * 
     */
    private class ValidateConfigListener extends BasicConfigListener {

        public ValidateConfigListener(Shell shell) {
            super(shell);
        }

        @Override
        public void endReasoning(ReasoningResult result) {
            clearErrorMessages();
            super.endReasoning(result);
        }

    }

    /**
     * {@link IReasonerListener} for propagating values.
     * 
     * @author El-Sharkawy
     */
    private class PropagateListener extends BasicConfigListener {

        public PropagateListener(Shell shell) {
            super(shell);
        }

        @Override
        protected boolean onWarnings(ReasoningResult result) {
            clearErrorMessages();
            super.onWarnings(result);
            parentPage.refresh();
            return true;
        }

    }

    /**
     * {@link IReasonerListener}, for a reasoning which is executed automatically before freezing the configuration.
     * 
     * @author El-Sharkawy
     */
    private class ReasoningPreFreezeListener extends BasicConfigListener {

        public ReasoningPreFreezeListener(Shell shell) {
            super(shell);
        }
        
        @Override
        protected boolean onWarnings(ReasoningResult result) {
            clearErrorMessages();
            super.onWarnings(result);
            if (result.getMessageCount() > 0) {
                ProductLineCommands.displayWarnings(getShell(), result);
            }
            getConfigContainer().getGuiConfig().freeze();
            // TODO SE: check whether something changed.
            parentPage.refresh();
            parentPage.setDirty();
            return true;
        }

    }

    /**
     * Sole constructor for this class.
     * 
     * @param parent
     *            the parent control (must not be <code>null</code>).
     * @param plp
     *            Current configured project holding the configuration (must not be <code>null</code>).
     * @param parentPage
     *            The page bearing this menu item (must not be <code>null</code>).
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
        btnPropagate.addSelectionListener(new ReasonerSelectionAdapter(ReasoningOperation.PROPAGATION, 
            new PropagateListener(getShell())));
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
        btnFreezeAll.addSelectionListener(new ReasonerSelectionAdapter(ReasoningOperation.VALIDATION, 
            new ReasoningPreFreezeListener(getShell())));
    }

    private class ReasonerSelectionAdapter extends SelectionAdapter {
        
        private ReasoningOperation operation;
        private IReasonerListener listener;
        
        private ReasonerSelectionAdapter(ReasoningOperation operation, IReasonerListener listener) {
            this.operation = operation;
            this.listener = listener;            
        }
        
        public void widgetSelected(SelectionEvent event) {
            ProductLineCommands.validateProductLine(operation, getShell(), getProductLineProject(), listener);
        }
        
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
        validateProductButton.addSelectionListener(new ReasonerSelectionAdapter(
            ReasoningOperation.VALIDATION, new ValidateConfigListener(getShell())));
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
                ProductLineCommands.instantiateProductLine(getShell(), getProductLineProject());
            }
        });
        
        btnAbortInstantiation.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                getProductLineProject().abortInstantiation();
            }
        });
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
                    EasyProducerDialog.showErrorDialog(getShell(), exc.getMessage());
                }
            });
            vilExecutionFinished(plp, false);
        }
    }

    @Override
    public void vilExecutionFinished(final PLPInfo plp, final boolean instantiationSuccessfull) {
        if (plp == getProductLineProject()) {
            Display.getDefault().asyncExec(new Runnable() {
    
                @Override
                public void run() {
                    if (null != ConfigurationHeaderMenu.this && !ConfigurationHeaderMenu.this.isDisposed()) {
                        
                        btnAbortInstantiation.setEnabled(false);
                        btnInstantiate.setEnabled(true);
                        
                        if (instantiationSuccessfull) {
                            EasyProducerDialog.showInfoDialog(getShell(),
                                getProductLineProject().getProjectName() + " instantiation completed successfully");
                        }
                    }
                }
            });
        }
    }
}