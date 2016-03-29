/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Displays the current annotation values for a given
 * {@link net.ssehub.easy.varModel.confModel.IDecisionVariable}.
 * 
 * @author El-Sharkawy
 */
public class AnnotationsViewDialog extends Dialog {

    private GUIVariable variable;
    
    /**
     * Single constructor for this class.
     * @param parentShell the parent shell, or <code>null</code> to create a top-level shell
     * @param variable The variable for which the annotations shall be displayed.
     */
    public AnnotationsViewDialog(Shell parentShell, GUIVariable variable) {
        super(parentShell);
        this.variable = variable;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new GridLayout(1, true));
        IDecisionVariable nestedVar = variable.getVariable();
        if (null != nestedVar) {
//            String[] titles = {"Annotation", "Value"};
            TreeViewer viewer = new TreeViewer(container, SWT.FULL_SELECTION | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);
            viewer.setUseHashlookup(true);
            final Tree table = viewer.getTree();
            table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
            table.setHeaderVisible(true);
            table.setLinesVisible(true); 

//            viewer.setColumnProperties(titles);
            viewer.setContentProvider(new AnnotationViewContentProvider());
            viewer.setInput(variable);
            TreeViewerColumn column1 = new TreeViewerColumn(viewer, SWT.NONE);
            column1.getColumn().setText("Annotation");
            column1.getColumn().setWidth(150);
            column1.setLabelProvider(new ConfigurationLabelProvider(variable.getConfiguration()));
            
            TreeViewerColumn column2 = new TreeViewerColumn(viewer, SWT.NONE);
            column2.getColumn().setText("Value");
            column2.getColumn().setWidth(125);
            column2.setEditingSupport(new ConfigurationCellEditor(viewer, ColumnType.VALUE));
            column2.setLabelProvider(new ConfigurationLabelProvider(variable.getConfiguration()));
            System.out.println(viewer.getTree().getColumnCount());
//            table.update();
//            table.redraw();
            viewer.refresh();
            
//            Table table = new Table(container, SWT.FULL_SELECTION | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
//            table.setHeaderVisible(true);
//            table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//            String[] titles = {"Annotation", "Value"};
//            for (int i = 0; i < titles.length; i++) {
//                TableColumn column = new TableColumn(table, SWT.NULL);
//                column.setText(titles[i]);
//            }
//
//            for (int i = 0; i < nestedVar.getAttributesCount(); i++) {
//                IDecisionVariable annotation = nestedVar.getAttribute(i);
//                Value value = annotation.getValue();
//                TableItem item = new TableItem(table, SWT.NULL);
//                item.setText(annotation.getDeclaration().getName());
//                item.setText(0, annotation.getDeclaration().getName());
//                String valueTxt = (null != value && NullValue.INSTANCE != value) ? value.getValue().toString()
//                    : "<null>";
//                item.setText(1, valueTxt);
//            }
//
//            for (int i = 0; i < titles.length; i++) {
//                table.getColumn(i).pack();
//            }
        }
        return container;
    }

    
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setSize(300, 200);
        newShell.setText("Annotations for " + variable.getName());
    }
    
    /**
     * Creates only a OK button instead of the default behavior.
     * @param parent The button bar composite
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        // create only OK button
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }
}
