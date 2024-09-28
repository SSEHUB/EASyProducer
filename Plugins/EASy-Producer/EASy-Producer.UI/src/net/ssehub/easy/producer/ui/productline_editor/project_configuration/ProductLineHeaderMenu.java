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
package net.ssehub.easy.producer.ui.productline_editor.project_configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.contributions.Contributions;
import net.ssehub.easy.producer.ui.contributions.Contributions.UIElement;
import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;
import net.ssehub.easy.producer.ui.productline_editor.AbstractHeaderMenu;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;

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
    
    private Button btnValidateProductline;
    private Button btnPullConfiguration;
    private Button btnManagePredecessors;
    private Button btnCreateMember;
    private AbstractEASyEditorPage relatedEditor;

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
                ProductLineCommands.validateProductLine(ReasoningOperation.CONSITENCY_CHECK, 
                    getShell(), getProductLineProject());
            }
        });
    }

    /**
     * Creates the Listener for the Add Predecessor button.
     */
    private void createPredecessorListener() {
        btnManagePredecessors.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                ProductLineCommands.modifyPredecessors(getShell(), getProductLineProject());
                revalidateButtons();
            }
        });
    }

    /**
     * Creates the Listener for the Pull Config button.
     */
    private void createPullListener() {
        btnPullConfiguration.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                ProductLineCommands.pullConfigurationFromPredecessors(getShell(), getProductLineProject());
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
                ProductLineCommands.createProductLineMember(getShell(), getProductLineProject());
            }
        });
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