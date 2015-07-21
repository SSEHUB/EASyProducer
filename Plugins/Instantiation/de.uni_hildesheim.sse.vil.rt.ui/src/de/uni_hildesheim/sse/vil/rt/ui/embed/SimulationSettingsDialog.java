/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.vil.rt.ui.embed;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.uni_hildesheim.sse.dslcore.ui.ConfigurationEditorFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.RtVilExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.ChangeHistory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.vil.rt.RtVilModelUtility;

/**
 * Implements a settings dialog for the simulation.
 * 
 * @author Holger Eichelberger
 */
public class SimulationSettingsDialog extends Dialog {

    private Configuration config;
    private TreeViewer configViewer;
    private Text[] arguments;
    private Argument[] openArguments;
    private NamedViewerFilter[] filters;
    
    protected SimulationSettingsDialog(Shell parentShell, Configuration config, Argument[] openArguments, 
        NamedViewerFilter[] filters) {
        super(parentShell);
        this.config = config;
        this.openArguments = openArguments;
        this.filters = filters;
        setBlockOnOpen(true);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        final Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        composite.setLayout(layout);
        
        Label tmp = new Label(composite, SWT.NONE);
        tmp.setText("Script arguments:");
        
        //TODO >turn this part into table (from here)
        Composite argPanel = new Composite(composite, SWT.NONE);
        GridLayout argLayout = new GridLayout();
        argPanel.setLayout(argLayout);
        GridData layoutData = new GridData();
        layoutData.horizontalAlignment = SWT.FILL;
        argLayout.numColumns = 2;
        argPanel.setLayoutData(layoutData);
        arguments = new Text[openArguments.length];
        for (int a = 0; a < openArguments.length; a++) {
            Argument arg = openArguments[a];
            Label label = new Label(argPanel, SWT.NONE);
            label.setText(arg.getName() + " (type: " + arg.getTypeName() + ")"); // Table: type name in own column
            arguments[a] = new Text(argPanel, SWT.BORDER);
            arguments[a].setText(arg.getValueExpressionText());
            layoutData = new GridData();
            layoutData.horizontalAlignment = SWT.FILL;
            layoutData.grabExcessHorizontalSpace = true;
            arguments[a].setLayoutData(layoutData);
        }
        //TODO <turn this part into table (until here)
        
        tmp = new Label(composite, SWT.NONE);
        String variablesText = "Variables";
        String filterText = NamedViewerFilter.toString(filters);
        if (filterText.length() > 0) {
            variablesText += "(filter for " + filterText + ")";
        }
        variablesText += ":";
        tmp.setText(variablesText);
        
        configViewer = ConfigurationEditorFactory.createEditor(config.getConfiguration(), composite);
        if (null != filters) {
            configViewer.setFilters(NamedViewerFilter.toFilter(filters));
        }
        layoutData = new GridData();
        layoutData.heightHint = 200;
        configViewer.getTree().setLayoutData(layoutData);
        
        return composite;
    }
    
    /**
     * Defines a temporary parameter representing a expression-value combination.
     * 
     * @author Holger Eichelberger
     */
    static class TempArgument {

        private Expression valueExpression;
        private Object value;

        /**
         * Creates a new temp argument.
         * 
         * @param valueExpression the value expression
         * @param value the value
         */
        private TempArgument(Expression valueExpression, Object value) {
            this.valueExpression = valueExpression;
            this.value = value;
        }
        
        /**
         * Returns the value expression.
         * 
         * @return the value expression
         */
        public Expression getValueExpression() {
            return valueExpression;
        }
        
        /**
         * Returns the value of the expression.
         * 
         * @return the value
         */
        public Object getValue() {
            return value;
        }
    }

    /**
     * Validates the provided arguments. Opens a dialog in case of errors.
     * 
     * @return the arguments if valid, <b>null</b> if at least one argument is invalid
     */
    private TempArgument[] validateArguments() {
        TempArgument[] result = new TempArgument[openArguments.length];
        // validate against empty environment - so that nothing is available
        RtVilExecution executor = new RtVilExecution();
        try { // TODO table - may evaluate all in once and show errors in table, or incrementally
            for (int a = 0; a < openArguments.length; a++) {
                result[a] = analyze(arguments[a].getText(), executor);
            }
        } catch (VilException e) {
            MessageDialog.openError(getShell(), "Argument expression error", e.getMessage());
            result = null;
        }
        return result;
    }

    /**
     * Analyzes a textual expression.
     * 
     * @param expressionText the expression text
     * @param executor the executor (<b>null</b> creates an executor)
     * @return an instance containing expression and actual value
     * @throws VilException in case of parsing / evaluation problems
     */
    static TempArgument analyze(String expressionText, RtVilExecution executor) throws VilException {
        if (null == executor) {
            executor = new RtVilExecution();
        }
        Expression valueExpression = RtVilModelUtility.INSTANCE.createPrimaryExpression(
            expressionText, executor.getRuntimeEnvironment());
        Object value = null;
        if (null != valueExpression) {
            value = valueExpression.accept(executor);
        }
        return new TempArgument(valueExpression, value);
    }
    
    @Override
    protected void configureShell(Shell newShell) {
    
        newShell.setMinimumSize(800, 600);
        //newShell.setSize(800, 450);
        super.configureShell(newShell);
        newShell.setText("Simulation settings");
    }

    @Override
    protected void okPressed() {
        TempArgument[] args = validateArguments();
        if (null != args) {
            for (int a = 0; a < args.length; a++) {
                openArguments[a].setValue(args[a].valueExpression, args[a].value);
            }
            ChangeHistory history = config.getChangeHistory();
            history.commitAll();
            history.clear();
            super.okPressed();
        }
    }

    @Override
    protected void cancelPressed() {
        ChangeHistory history = config.getChangeHistory();
        history.rollbackAll();
        history.clear();
        super.cancelPressed();
    }

}