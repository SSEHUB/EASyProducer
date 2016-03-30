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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import net.ssehub.easy.producer.examples.ExampleInstallationException;
import net.ssehub.easy.producer.examples.ExamplesInstaller;
import net.ssehub.easy.producer.examples.AvailableExamples.ExampleDescriptor;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;

/**
 * Wizard for unpacking examples shipped with this bundle into the workspace.
 * @author El-Sharkawy
 *
 */
public class ExamplesWizard extends Wizard implements INewWizard {
    
    private ExamplesWizardPage page;
    /**
     *  Must be an attribute to support nested class in Java prior to version 8.
     */
    private boolean projectsInstalled;
    
    /**
     * Sole constructor for this Wizard.
     * Should be without parameters, as it will be called by Eclipse.
     */
    public ExamplesWizard() {
        super();
        page = new ExamplesWizardPage();
        addPage(page);
    }

    @Override
    public boolean performFinish() {      
        projectsInstalled = true;
        final ExampleDescriptor[] selectedExamples = page.getSelectedExamples();
        BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
            
            @Override
            public void run() {
                try {
                    // Install and check that at least one project was imported.
                    ExamplesInstaller installer = new ExamplesInstaller(selectedExamples);
                    projectsInstalled = !installer.installExamples().isEmpty();
                } catch (ExampleInstallationException eie) {
                    projectsInstalled = false;
                    EasyProducerDialog.showErrorDialog(eie.getMessage());
                }
            }
        });
        
        return projectsInstalled;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // Method from INewWizard, but not needed.
    }

}
