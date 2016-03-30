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
package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.producer.ui.productline_editor.EditorConstants;
import net.ssehub.easy.producer.ui.productline_editor.ImageProvider;
import net.ssehub.easy.producer.ui.productline_editor.ImageProvider.ImageType;
import net.ssehub.easy.producer.ui.productline_editor.instantiator.TreeNode.Insertable;
import net.ssehub.easy.producer.ui.productline_editor.instantiator.TreeNode.InsertionPoint;

/**
 * Creates the editor page for linking files with a file instantiator.<br>
 * This page allows the user to:
 * <ul>
 * <li>Add and delete instantiator engines</li>
 * <li>See configured instantiator engines</li>
 * <li>Change the files bound to an instantiator if that instantiator had been created in this ProductLineProject</li>
 * <li>See informations about the instantiator that is currently shown</li>
 * <li>See the filetype an instantiator will handle, after clicking save, if there are multiple filetypes to be handled,
 * the type will be shown as "various"</li>
 * </ul>
 * <li>To check for files that might be instantiated by multiple instantiator engines</li>
 * 
 * @author gawenda
 * @author El-Sharkawy
 */
public class InstantiatorConfigPage extends AbstractEASyEditorPage {
    private Button addRuleButton;
    private Button addCopyRuleButton;
    private Button addSystemCallButton;
    private Button insertInstantiatorButton;
    private Button deleteElementButton;
    
    private TreeViewer ruleTree;

    /**
     * Sole constructor for this class.
     * 
     * @param parent the parent control
     * @param plp The ProductLineProject which will be edited
     */
    public InstantiatorConfigPage(Composite parent, ProductLineProject plp) {
        super(plp, EditorConstants.INSTANTIATOR_PAGE, parent);
        GridData data = new GridData();
        data.heightHint = 600;
        setData(data);
        
        // Buttons
        Composite buttonComposite = getToolkit().createComposite(getContentPane(), SWT.NONE);
        GridLayout headerButtonCompositeLayout = new GridLayout();
        buttonComposite.setLayout(headerButtonCompositeLayout);
        headerButtonCompositeLayout.numColumns = 4;
        createButtons(buttonComposite);
        
        // Editor
        Label header = new Label(getContentPane(), SWT.NONE);
        header.setText("Active VIL rules in " + getScriptSignature() + ":");
        header.setBackground(getContentPane().getBackground());
        createContent(getContentPane());
    }

    /**
     * Creates the buttons.
     * 
     * @param parent the parent composite
     */
    private void createButtons(Composite parent) {
        createAddRuleButton(parent);
        createCopyRuleButton(parent);
        createAddSystemCallButton(parent);
        createAddInstantiatorButton(parent);
        createDeleteElementButton(parent);
    }
    
    /**
     * Creates an "add rule" button.
     * 
     * @param parent the parent composite
     */
    private void createAddRuleButton(Composite parent) {   
        addRuleButton = new Button(parent, SWT.NONE);
        addRuleButton.setImage(ImageProvider.getInstance().getImage(ImageType.ADD));
        addRuleButton.setText("Add Rule...");
        addRuleButton.setEnabled(false);
        addRuleButton.setToolTipText("In development...");
        addRuleButton.addSelectionListener(new TreeNodeInsertionSelectionAdapter(Insertable.RULE) {
            @Override
            protected void insert(TreeNode selected) {
                
            }
        });
    }

    /**
     * Creates a "copy rule" button.
     * 
     * @param parent the parent composite
     */
    private void createCopyRuleButton(Composite parent) {
        addCopyRuleButton = new Button(parent, SWT.NONE);
        addCopyRuleButton.setImage(PlatformUI.getWorkbench().getSharedImages()
            .getImage(ISharedImages.IMG_TOOL_COPY));
        addCopyRuleButton.setText("Add Copy Rule...");
        addCopyRuleButton.setEnabled(false);
        addCopyRuleButton.setToolTipText("In development...");
        addCopyRuleButton.addSelectionListener(new TreeNodeInsertionSelectionAdapter(Insertable.RULE) {
            @Override
            protected void insert(TreeNode selected) {
                
            }
        });
    }

    /**
     * Creates a "system call" button.
     * 
     * @param parent the parent composite
     */
    private void createAddSystemCallButton(Composite parent) {
        addSystemCallButton = new Button(parent, SWT.NONE);
        addSystemCallButton.setImage(PlatformUI.getWorkbench().getSharedImages()
            .getImage(IDE.SharedImages.IMG_OPEN_MARKER));
        addSystemCallButton.setText("Add System Call...");
        addSystemCallButton.setEnabled(false);
        addSystemCallButton.setToolTipText("In development...");
        addSystemCallButton.addSelectionListener(new TreeNodeInsertionSelectionAdapter(Insertable.RULE) {
            @Override
            protected void insert(TreeNode selected) {
                
            }
        });
    }

    /**
     * Creates an "add instantiator" button.
     * 
     * @param parent the parent composite
     */
    private void createAddInstantiatorButton(Composite parent) {
        insertInstantiatorButton = new Button(parent, SWT.NONE);
        insertInstantiatorButton.setImage(PlatformUI.getWorkbench().getSharedImages()
            .getImage(IDE.SharedImages.IMG_OPEN_MARKER));
        insertInstantiatorButton.setText("Insert Instantiator...");
        insertInstantiatorButton.setEnabled(false);
        insertInstantiatorButton.addSelectionListener(new TreeNodeInsertionSelectionAdapter(Insertable.INSTANTIATOR) {
            @Override
            protected void insert(TreeNode selected) {
                Script script = getProductLineProject().getBuildScript();
                InsertInstantiatorDialog dlg = new InsertInstantiatorDialog(getShell(), 
                    script, selected, getSupportedInsertionPoint(selected));
                if (Window.OK == dlg.open()) {
                    refresh();
                    try {
                        TreeUtils.store(script);
                    } catch (VilException e) {
                        EasyProducerDialog.showErrorDialog(getShell(), e.getMessage());
                    }
                }
            }
        });
    }

    /**
     * Creates a "delete element" button.
     * 
     * @param parent the parent composite
     */
    private void createDeleteElementButton(Composite parent) {
        deleteElementButton = new Button(parent, SWT.NONE);
        deleteElementButton.setImage(PlatformUI.getWorkbench().getSharedImages()
            .getImage(ISharedImages.IMG_TOOL_DELETE));
        deleteElementButton.setText("Delete...");
        deleteElementButton.setEnabled(false);
        deleteElementButton.setToolTipText("In development...");
        deleteElementButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent evt) {
            }
        });
    }

    /**
     * A selection adapter checking for supported insertion first.
     *  
     * @author Holger Eichelberger
     */
    private abstract class TreeNodeInsertionSelectionAdapter extends SelectionAdapter {

        private Insertable insertable;
        
        /**
         * Creates the selection adapter.
         * 
         * @param insertable the intended insertable
         */
        private TreeNodeInsertionSelectionAdapter(Insertable insertable) {
            this.insertable = insertable;
        }
        
        @Override
        public void widgetSelected(SelectionEvent evt) {
            TreeNode selected = getSelected(ruleTree.getSelection());
            if (null != selected && InsertionPoint.NONE != getSupportedInsertionPoint(selected)) {
                insert(selected);
            }
        }
        
        /**
         * Is called if the insertion shall happen.
         * 
         * @param selected the selected node
         */
        protected abstract void insert(TreeNode selected);
        
        /**
         * Returns the supported insertion point for the given <code>selected</code> node.
         * 
         * @param selected the selected node
         * @return the insertion point
         */
        protected InsertionPoint getSupportedInsertionPoint(TreeNode selected) {
            return selected.supportedInsertionPoint(insertable);
        }
        
    }

    /**
     * Creates the main content with the list of instantiators, a tree for a chosen instantiator, and a list of multiple
     * instantiated files, which is only shown, if the user decides to have them calculated.
     * 
     * @param parent the parent composite
     */
    private void createContent(Composite parent) {
        ruleTree = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
        ruleTree.setLabelProvider(new InstantiatorTreeLabelProvider());
        ruleTree.setContentProvider(new InstantiatorTreeContentProvider());
        ruleTree.addSelectionChangedListener(new TreeSelectionListener());
        
        
        Tree table = ruleTree.getTree();
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        /*
         * Show scroll bars of parent composite only if less then approx. 3 rows are shown in the table
         * Otherwise the scroll bars of the table are used.
         */
        data.heightHint = 60;
        table.setLayoutData(data);
        
        refresh();
    }
    
    /**
     * Returns the actual script signature.
     * 
     * @return the actual script signature
     */
    private String getScriptSignature() {
        String result;
        Script vilScript = getProductLineProject().getBuildScript();
        if (null != vilScript) {
            result = vilScript.getName();
            result += "(";
            for (int p = 0; p < vilScript.getParameterCount(); p++) {
                if (p > 0) {
                    result += ", ";
                }
                VariableDeclaration decl = vilScript.getParameter(p);
                result += decl.getType().getVilName();
                result += " ";
                result += decl.getName();
            }
            result += ")";
        } else {
            result = "?";
        }
        return result;
    }
    
    /**
     * Reacts on general tree selections and enables / disables buttons.
     * 
     * @author Holger Eichelberger
     */
    private class TreeSelectionListener implements ISelectionChangedListener {

        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            TreeNode selected = getSelected(event.getSelection());
            setEnabled(insertInstantiatorButton, selected, Insertable.INSTANTIATOR);
            //setEnabled(addCopyRuleButton, selected, Insertable.RULE);
            //setEnabled(addRuleButton, selected, Insertable.RULE);
            //setEnabled(addSystemCallButton, selected, Insertable.RULE);
            //deleteElementButton.setEnabled(null != selected);
        }
        
    }

    /**
     * Changes the enabled state of <code>button</code> dependent on the selected <code>node</code> and the
     * intended <code>insertable</code>.
     * 
     * @param button the button
     * @param node the selected node (may be <b>null</b>)
     * @param insertable the insertable
     */
    private static void setEnabled(Button button, TreeNode node, Insertable insertable) {
        boolean enabled;
        if (null == node) {
            enabled = false;
        } else {
            enabled = InsertionPoint.NONE != node.supportedInsertionPoint(insertable);
        }
        button.setEnabled(enabled);
    }
    
    /**
     * Returns the selected tree node.
     * 
     * @param selection the current selection
     * @return the selected tree node (may be <b>null</b> if none is selected)
     */
    private TreeNode getSelected(ISelection selection) {
        TreeNode result = null;
        if (!selection.isEmpty() && selection instanceof TreeSelection) {
            TreeSelection tSelection = (TreeSelection) selection;
            Object selected = tSelection.getFirstElement(); // single selection only, see above
            if (selected instanceof TreeNode) {
                result = (TreeNode) selected;
            }
        }
        return result;
    }

    @Override
    public void refresh() {
        // TODO refresh upon VIL change
        ruleTree.setInput(createRuleTree());
    }
 
    /**
     * Creates the rule tree for the tree viewer.
     * 
     * @return the rule tree
     */
    private TreeNode[] createRuleTree() {
        TreeNode[] result = null;
        Script vilScript = getProductLineProject().getBuildScript();
        if (null != vilScript) {
            RuleTreeVilVisitor visitor = new RuleTreeVilVisitor();
            try {
                vilScript.accept(visitor);
            } catch (VilException e) {
                // ignore
            }
            result = visitor.getRootNodes();
        }
        return result;
    }
    
    @Override
    public final String getPageText() {
        return EditorConstants.INSTANTIATOR_PAGE;
    }

    @Override
    protected void pageActivated() {
        refresh();
    }

    @Override
    public void propertyChanged(Object source, int propId) {
        // Not needed    
    }

    @Override
    public void close() {
        // No action needed
    }
    
}