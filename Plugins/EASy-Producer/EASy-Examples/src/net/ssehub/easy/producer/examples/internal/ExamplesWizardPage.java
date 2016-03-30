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
package net.ssehub.easy.producer.examples.internal;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.producer.examples.AvailableExamples;
import net.ssehub.easy.producer.examples.AvailableExamples.ExampleDescriptor;
import net.ssehub.easy.producer.ui.internal.Activator;

/**
 * Content of {@link ExamplesWizard}.
 * @author El-Sharkawy
 *
 */
public class ExamplesWizardPage extends WizardPage {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ExamplesWizardPage.class,
        Bundle.PLUGIN_ID);
    
    private CheckboxTableViewer examplesList;
    private Browser descriptionArea;
    
    /**
     * Sole constructor for this class.
     */
    ExamplesWizardPage() {
        super("Import existing EASy-Producer examples into workspace.");
        setTitle("Import existing EASy-Producer examples into workspace.");
        setImageDescriptor(Activator.getImageDescriptor("icons/logo_big.gif"));
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        container.setLayout(new GridLayout(2, true));
        container.setLayoutData(new GridData(SWT.FILL));
        
        // Example selection
        examplesList = CheckboxTableViewer.newCheckList(container, SWT.BORDER | SWT.MULTI | SWT.FILL | SWT.V_SCROLL
            | SWT.H_SCROLL);
        examplesList.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        examplesList.setContentProvider(new IStructuredContentProvider() {
            
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
                // Not needed
            }
            
            @Override
            public void dispose() {
                // Not needed
            }

            @Override
            public Object[] getElements(Object inputElement) {
                return (Object[]) inputElement;
            }
        });
        examplesList.setLabelProvider(new LabelProvider());
        examplesList.setInput(AvailableExamples.INSTANCE.getExamples());
        
        // Description
        descriptionArea = new Browser(container, SWT.BORDER | SWT.FILL);
        descriptionArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        examplesList.addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                try {
                    if (!event.getSelection().isEmpty()) {
                        StructuredSelection selection = (StructuredSelection) event.getSelection();
                        ExamplesWizardPage.this.selectionChanged(selection.getFirstElement());
                    } else {
                        descriptionArea.setText("");
                    }
                } catch (ClassCastException cce) {
                    LOGGER.exception(cce);
                }
            }
        });
        
        examplesList.addCheckStateListener(new ICheckStateListener() {
            
            @Override
            public void checkStateChanged(CheckStateChangedEvent event) {
                selectionChanged(event.getElement());
            }
        });
        
        setControl(container);      
    }
    
    /**
     * Returns the selected examples.
     * @return An maybe empty array of selected exampled.
     */
    ExampleDescriptor[] getSelectedExamples() {
        Object[] selection = examplesList.getCheckedElements();
        ExampleDescriptor[] selectedExamples = new ExampleDescriptor[(null != selection) ? selection.length : 0];
        for (int i = 0; i < selectedExamples.length; i++) {
            selectedExamples[i] = (ExampleDescriptor) selection[i];
        }
        return selectedExamples;
    }

    /**
     * Sets the description inside the description area.
     * @param selectedElement The selected element for which the selection shall be displayed. Maybe <tt>null</tt>.
     */
    private void selectionChanged(Object selectedElement) {
        descriptionArea.setText("");
        if (null != selectedElement && selectedElement instanceof ExampleDescriptor) {
            try {
                ExampleDescriptor descriptor = (ExampleDescriptor) selectedElement;
                File descriptionFile = descriptor.getDescription();
                if (null != descriptionFile && descriptionFile.exists()) {
                    descriptionArea.setText(FileUtils.readFileToString(descriptionFile));
                }
            } catch (IOException ioe) {
                LOGGER.exception(ioe);
            }
        }
    }

}
