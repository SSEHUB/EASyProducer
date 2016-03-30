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

import java.text.Collator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;
import net.ssehub.easy.producer.ui.productline_editor.instantiator.TreeNode.InsertionPoint;

/**
 * Creates a dialog for inserting instantiators.
 * 
 * @author Holger Eichelberger
 */
public class InsertInstantiatorDialog extends Dialog {
    
    private ComboViewer combo;
    private Script script;
    private TreeNode node;
    private InsertionPoint insertionPoint;
    private TableViewer params;
    private Button before;
    
    /**
     * Default constructor.
     * 
     * @param parentShell The parent shell.
     * @param script the script to insert into
     * @param node the selected node
     * @param insertionPoint the supported insertion points
     */
    public InsertInstantiatorDialog(Shell parentShell, Script script, TreeNode node, InsertionPoint insertionPoint) {
        super(parentShell);
        this.script = script;
        this.node = node;
        this.insertionPoint = insertionPoint;
        setBlockOnOpen(true);
    }
    
    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText("Insert instantiator (no named args)");
    }
    
    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(1, true);
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        applyDialogFont(composite);
        
        Label label = new Label(composite, SWT.NONE);
        label.setText("Available instantiators");
        
        combo = new ComboViewer(composite, SWT.SINGLE);
        combo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return ((IMetaOperation) element).getSignature();
            }
        });
        for (IMetaOperation op : sortedInstantiators()) {
            combo.add(op);
        }
        combo.addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                ISelection selection = event.getSelection();
                if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
                    IMetaOperation op = (IMetaOperation) ((IStructuredSelection) selection).getFirstElement();
                    fillParams(op);
                }
            }
        });
        
        label = new Label(composite, SWT.NONE);
        label.setText("Parameters / Arguments:");
        
        params = new TableViewer(composite, SWT.VERTICAL);
        Table table = params.getTable();
        GridData tGridData = new GridData(GridData.FILL_BOTH);
        tGridData.minimumHeight = 100;
        table.setLayoutData(tGridData);
        TableLayout tLayout = new TableLayout();
        table.setLayout(tLayout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tLayout.addColumnData(new ColumnWeightData(3, 50, true));
        TableViewerColumn tableViewerColumn = new TableViewerColumn(params, SWT.NONE);
        tableViewerColumn.getColumn().setText("type"); 
        tableViewerColumn.getColumn().setResizable(true);
        
        tLayout.addColumnData(new ColumnWeightData(3, 50, true));
        tableViewerColumn = new TableViewerColumn(params, SWT.NONE);
        tableViewerColumn.getColumn().setText("argument"); 
        tableViewerColumn.getColumn().setResizable(true);
        tableViewerColumn.setEditingSupport(new ArgumentEditingSupport(params));

        params.setLabelProvider(new ParamTableLabelProvider());
        params.setContentProvider(new ParamTableContentProvider());
        
        // TODO support named arguments
        
        before = new Button(composite, SWT.CHECK);
        before.setText("Insert before selected element (after if unselected)");
        if (InsertionPoint.BEFORE_THIS == insertionPoint) {
            before.setSelection(true);
        } else {
            before.setSelection(false);
        }
        return composite;
    }

    /**
     * Implements argument editing support.
     * 
     * @author Holger Eichelberger
     */
    private static class ArgumentEditingSupport extends EditingSupport {

        private final CellEditor editor;
        private final TableViewer viewer;

        /**
         * Creates new argument editing support.
         * 
         * @param viewer the table view to attache the support to
         */
        ArgumentEditingSupport(TableViewer viewer) {
            super(viewer);
            this.viewer = viewer;
            this.editor = new TextCellEditor(viewer.getTable());
        }
        
        @Override
        protected CellEditor getCellEditor(Object element) {
            return editor;
        }

        @Override
        protected boolean canEdit(Object element) {
            return true;
        }

        @Override
        protected Object getValue(Object element) {
            return ((Argument) element).getArgument();
        }

        @Override
        protected void setValue(Object element, Object value) {
            ((Argument) element).setArgument(value.toString());
            viewer.update(element, null);
        }
        
    }

    /**
     * Implements a parameter table lable provider.
     * 
     * @author Holger Eichelberger
     */
    private static class ParamTableLabelProvider implements ITableLabelProvider {

        @Override
        public void addListener(ILabelProviderListener listener) {
        }

        @Override
        public void dispose() {
        }

        @Override
        public boolean isLabelProperty(Object element, String property) {
            return false;
        }

        @Override
        public void removeListener(ILabelProviderListener listener) {
        }

        @Override
        public Image getColumnImage(Object element, int columnIndex) {
            return null;
        }

        @Override
        public String getColumnText(Object element, int columnIndex) {
            String result;
            Argument arg = (Argument) element;
            switch (columnIndex) {
            case 0:
                result = arg.getParameterType();
                break;
            case 1:
                result = arg.getArgument();
                break;
            default:
                result = null;
                break;
            }
            return result;
        }
        
    }
    
    /**
     * Implements a parameter table content provider.
     * 
     * @author Holger Eichelberger
     */
    private static class ParamTableContentProvider implements IStructuredContentProvider {

        @Override
        public void dispose() {
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        @Override
        public Object[] getElements(Object inputElement) {
            Object[] elements;
            if (inputElement instanceof Object[]) {
                elements = (Object[]) inputElement;
            } else {
                elements = new Object[0];
            }
            return elements;
        }
        
    }

    /**
     * Fills the parameter table.
     * 
     * @param op the operation to fill the parameter table with
     */
    private void fillParams(IMetaOperation op) {
        Argument[] contents;
        if (null == op) {
            contents = new Argument[0];
        } else {
            contents = new Argument[op.getParameterCount()];
            for (int p = 0; p < op.getParameterCount(); p++) {
                contents[p] = new Argument(op.getParameterType(p));
            }
        }
        params.setInput(contents);
        params.refresh();
    }

    /**
     * Returns the sorted (available) instantiators.
     * 
     * @return the instantiators as operations
     */
    private Collection<IMetaOperation> sortedInstantiators() {
        TypeRegistry registry = script.getTypeRegistry();
        TreeMap<String, IMetaOperation> sorter = new TreeMap<String, IMetaOperation>(Collator.getInstance());
        for (TypeDescriptor<? extends IVilType> inst : registry.allInstantiators()) {
            addOperations(inst, sorter);
        }
        Set<Script> done = new HashSet<Script>();
        addScript(script, done, sorter);
        // only imports of script!
        for (int i = 0; i < script.getImportsCount(); i++) {
            Script imp = script.getImport(i).getResolved();
            if (null != imp && !done.contains(script)) {
                addScript(script, done, sorter);
            }
        }
        return sorter.values();
    }

    /**
     * Adds a script if not already done as well as its parent scripts.
     * 
     * @param script the script to be added
     * @param done the already processed scripts (to be modified as a side effect)
     * @param sorter a sorted signature-operation mapping (to be modified as a side effect)
     */
    private void addScript(Script script, Set<Script> done, TreeMap<String, IMetaOperation> sorter) {
        if (!done.contains(script)) {
            done.add(script);
            Script iter = script;
            while (null != iter) {
                addOperations(iter, sorter);
                iter = iter.getParent();
            }
        }
    }
    
    /**
     * Adds the operations of the given <code>type</code>.
     * 
     * @param type the type to be added
     * @param sorter a sorted signature-operation mapping (to be modified as a side effect)
     */
    private void addOperations(IMetaType type, TreeMap<String, IMetaOperation> sorter) {
        for (int o = 0; o < type.getOperationsCount(); o++) {
            IMetaOperation op = type.getOperation(o);
            if (!op.acceptsNamedParameters()) { // currently not supported
                sorter.put(op.getSignature(), op);
            }
        }
    }

    @Override
    protected void okPressed() {
        ISelection selection = combo.getSelection();
        InsertionPoint insertionPoint;
        if (before.getSelection()) {
            insertionPoint = InsertionPoint.BEFORE_THIS;
        } else {
            insertionPoint = InsertionPoint.AFTER_THIS;
        }
        IMetaOperation op = null;
        if (selection instanceof IStructuredSelection) {
            Object selected = ((IStructuredSelection) selection).getFirstElement(); // SINGLE
            if (selected instanceof IMetaOperation) {
                op = (IMetaOperation) selected;
            }
        }
        String error = TreeUtils.insertOperation(script, node, insertionPoint, op, (Argument[]) params.getInput());
        if (null != error) {
            EasyProducerDialog.showErrorDialog(getShell(), error);
        } else {
            super.okPressed();
        }
    }

}
